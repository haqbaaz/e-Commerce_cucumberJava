package org.example.testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"Features/LoginFeature.feature","Features/cartFeature.feature"},
        glue = "org/example/stepDefinition",
        plugin = {
                "pretty",
                "html:Output/cucumber-reports.html",
                "json:Output/cucumber.json"},
        monochrome = true)
public class run extends AbstractTestNGCucumberTests {

}
