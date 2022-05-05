package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/featurefile/api",
        glue = {"com/api/stepDefination"},
        plugin = { "pretty", "json:target/APITestRunner.json" })


public class APITestRunner extends AbstractTestNGCucumberTests{

}
