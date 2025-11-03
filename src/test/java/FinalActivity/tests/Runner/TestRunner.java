package FinalActivity.tests.Runner;
import TestComponents.BaseTest;
import io.cucumber.testng.*;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "Resources",
        glue = "FinalActivity.tests.stepDefinitions", monochrome = true,
        plugin = {"html:target/cucumber.html"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {



}

//use cucumber TESTNG package