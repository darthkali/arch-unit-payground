package de.darthkali.schichten

import com.tngtech.archunit.core.domain.JavaClass.Predicates.assignableTo
import com.tngtech.archunit.core.domain.properties.CanBeAnnotated.Predicates.annotatedWith
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses
import com.tngtech.archunit.library.Architectures
import com.tngtech.archunit.library.Architectures.layeredArchitecture
import com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices
import org.springframework.stereotype.Controller
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@AnalyzeClasses(packagesOf = [SchichtenApplication::class])
class ArchitekturTest {

    @ArchTest
    val SERVICE_NAMING: ArchRule = classes()
        .that().areAnnotatedWith(Service::class.java)
        .or().haveSimpleNameEndingWith("Service")
        .should().haveSimpleNameEndingWith("Service")
        .andShould().beAnnotatedWith(Service::class.java)
        .andShould().resideInAPackage("..service..")

    @ArchTest
    val CONTROLLER_DEPENDS: ArchRule = noClasses()
        .that().resideInAPackage("..controller..")
        .or().haveSimpleNameEndingWith("Controller")
        .or().areAnnotatedWith(Controller::class.java)
        .should().accessClassesThat().resideInAPackage("..persistence..")

    @ArchTest
    val FUNNY_TEST: ArchRule = classes()
        .that().haveSimpleName("Loriot")
        .should().resideInAPackage("..fun..")
        .because("Loriot war ein Lustiger Typ")


    @ArchTest
    val SERVICE_TRANSACTION: ArchRule = methods()
        .that().arePublic()
        .and().areDeclaredInClassesThat().areAnnotatedWith(Service::class.java)
        .should().beAnnotatedWith(Transactional::class.java)


    @ArchTest
    val CYCLES: ArchRule = slices()
        .matching("de.darthkali.schichten.(*)..")
        .should().beFreeOfCycles()


    @ArchTest
    val LAYERS: ArchRule = layeredArchitecture()
        .consideringOnlyDependenciesInLayers()
        .layer("Controller").definedBy(annotatedWith(Controller::class.java)) //definition der Schicht Controller
        .layer("Service").definedBy(annotatedWith(Service::class.java)) //definition der Schicht Service
        .layer("Persistence").definedBy(annotatedWith(Repository::class.java)) //definition der Schicht Persistence
        .whereLayer("Controller").mayNotBeAccessedByAnyLayer() //keine Schicht darf auf Controller zugreifen
        .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller") //nur Controller darf auf Service zugreifen
        .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Service") //nur Service darf auf Persistence zugreifen

}










