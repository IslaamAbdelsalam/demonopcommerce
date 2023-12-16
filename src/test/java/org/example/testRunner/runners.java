package org.example.testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/resources/features",
        glue={"org.example.stepDefs"},
        tags = "@Smoke",//annotation before each class or test case that will be run
        plugin = {"pretty",
                "html:target/cucumber.html",
                "json:target/cucumber.json",
                "junit:target/cukes.xml",
                "rerun:target/rerun.txt"}

)
public class runners extends AbstractTestNGCucumberTests {
}
