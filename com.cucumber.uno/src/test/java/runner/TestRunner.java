package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;


//@RunWith(Cucumber.class)
@CucumberOptions
			(features="src/test/resources/features",
			glue={"stepDefination"},
					plugin = { "html:target/cucumber-html-report",
					        "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",
					        "usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml"})

//@Cucumber.Options(features={"src/test/resources/features"})
public class TestRunner extends AbstractTestNGCucumberTests{

}


