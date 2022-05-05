package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/featurefile/web",
        glue = {"com.web.base","com/web/stepDefination"},
        plugin = { "pretty", "json:target/WebTestRunner.json" })

public class WebTestRunner extends AbstractTestNGCucumberTests{

		
}
