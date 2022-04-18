package com.zeroBank.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/zeroBank/stepDefinitions",
        plugin = {"pretty", "html:target/cucumber.html",
                "rerun:target/rerun.txt",  // store the failed scenario into rerun.txt
                "me.jvt.cucumber.report.PrettyReports:target", // fancy report
                "json:target/cucumber-reports/CucumberTestReport.json"
        },
        dryRun = false,
        publish = true,
        tags = ""
)
public class CukesRunner {


}
