package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/functionalTests/ChromeBrowser", plugin = { "pretty",
		"html:target/Wiki-reports/HTML",
		"json:target/Wiki-reports/JSON/wiki.json" }, glue = { "stepDefinitions" }, monochrome = true)
public class TestRunner {

}
