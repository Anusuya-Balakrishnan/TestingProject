package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;



@CucumberOptions(features = "src/test/java/features/Bookcard.feature",
glue = "steps",dryRun = false,snippets = SnippetType.CAMELCASE,
plugin = {"pretty","html:target/cucumber-reports/index.html"}

)
public class TestRunner extends AbstractTestNGCucumberTests {

}
