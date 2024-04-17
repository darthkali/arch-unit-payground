package de.darthkali.schichten

import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses
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
        .or().resideInAPackage("..service..")
        .should().haveSimpleNameEndingWith("Service")
        .andShould().beAnnotatedWith(Service::class.java)

    @ArchTest
    val REPO_TEST: ArchRule = classes()
        .that().areAnnotatedWith(Repository::class.java)
        .or().haveSimpleNameEndingWith("Repository")
        .or().resideInAPackage("..persistance..")
        .should().haveSimpleNameEndingWith("Repository")
        .andShould().beAnnotatedWith(Repository::class.java)

    @ArchTest
    val CONTROLLER_TEST: ArchRule = classes()
        .that().areAnnotatedWith(Controller::class.java)
        .or().haveSimpleNameEndingWith("Controller")
        .or().resideInAPackage("..controller..")
        .should().haveSimpleNameEndingWith("Controller")
        .andShould().beAnnotatedWith(Controller::class.java)

    @ArchTest
    val CONTROLLER_DEPENDS: ArchRule = noClasses()
        .that().resideInAPackage("..controller..")
        .or().haveSimpleNameEndingWith("Controller")
        .or().areAnnotatedWith(Controller::class.java)
        .should().accessClassesThat().resideInAnyPackage("..service..", "..persistence..")

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

//    @ArchTest
//    val FACHLICH: ArchRule = methods()
//        .that().arePublic()
//        .and().areDeclaredInClassesThat().areAnnotatedWith(Repository::class.java)
//        .and().haveNameStartingWith("save")
//        .should(ArchCondition("FachlicheArchiv"){
//
//            @Override
//            fun check (item: JavaMethod, events: ConditionEvents){
//                item.methodCallsFromSelf()
//                    .stream()
//                    .filter(methodCall -> methodCall.getTargetowner@.isEquivalentTo(Logger.class))
//                    .toList();
//            }
//        })

}