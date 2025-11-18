package FinalActivity.tests.Runner;
import TestComponents.BaseTest;
import io.cucumber.testng.*;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.Test;

@Test
// ORIGINAL: runs all features under the `Resources` folder
// @CucumberOptions(
//         features = "Resources",
//         glue = "FinalActivity.tests.stepDefinitions", monochrome = true,
//         plugin = {"html:target/cucumber.html"
//         }
// )
// The original runner is preserved above (commented).
// Below is a runner configured to execute a single feature file
// `alertsAndWindows.feature`. To change which feature runs, edit
// the `singleFeaturePath` value or restore the original annotation.
@CucumberOptions(
        features = "src/test/java/Resources/alertsAndWindows.feature",
        glue = "FinalActivity.tests.stepDefinitions",
        monochrome = true,
        plugin = {"html:target/cucumber.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

}

//use cucumber TESTNG package