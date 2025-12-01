package FinalActivity.tests.Runner;
import io.cucumber.testng.*;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
// ORIGINAL: runs all features under the `Features` folder
// @CucumberOptions(
//         features = "Features",
//         glue = "FinalActivity.tests.StepDefinitions", monochrome = true,
//         plugin = {"html:target/cucumber.html"
//         }
// )
// The original Runner is preserved above (commented).
// Below is a Runner configured to execute a single feature file
// `AlertsAndWindows.feature`. To change which feature runs, edit
// the `singleFeaturePath` value or restore the original annotation.
@CucumberOptions(
        features = "src/test/java/Features/AlertsAndWindows.feature",
        glue = "FinalActivity.tests.StepDefinitions",
        monochrome = true,
        plugin = {"html:target/cucumber.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

}

//use cucumber TESTNG package