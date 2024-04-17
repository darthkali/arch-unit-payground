package de.darthkali.hexagonal

import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes
import org.springframework.stereotype.Controller
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service


@AnalyzeClasses(packagesOf = [HexagonalApplication::class])
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


}