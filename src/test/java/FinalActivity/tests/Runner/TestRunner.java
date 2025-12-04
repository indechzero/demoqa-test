package FinalActivity.tests.Runner;
import io.cucumber.testng.*;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/Features/",
        glue = "FinalActivity.tests.StepDefinitions",
        monochrome = true,
        plugin = {"html:target/cucumber.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

}