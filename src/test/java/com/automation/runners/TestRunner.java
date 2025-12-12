package com.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"StepDefinitions", "automation.hooks"},
        tags = "@regression",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"  // Extent
        },
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
    

    @Override
    @DataProvider(parallel = true)   // enable parallel if needed
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
