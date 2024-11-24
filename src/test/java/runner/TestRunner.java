package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // it has the path of feature directory/file
        features = "src/test/resources/features",
        // the name of the package where step definitions are available
        glue = "steps",
        // it stops actual execution when set to true and scans all the steps
        // also , its provider missing step definition
        // to start the execution, set the value of dry run to false
        //dryRun = true,      // when you don't want executes code
        dryRun = false,     // if you want your code executes
        tags = "@excel",
        plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json","rerun:target/failed.txt"}

)


public class TestRunner {

}