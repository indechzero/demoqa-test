package FinalActivity.tests.stepDefinitions;

import TestComponents.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterSuite;

import java.io.IOException;


public class Hooks extends BaseTest {
//WebDriver driver;

    @Before
    public void BeforeSteps() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        }
    @After
    public void tearDown(Scenario scenario) {
        try {
            String screenshotName = scenario.getName();
            if (scenario.isFailed()) {
                TakesScreenshot ts = (TakesScreenshot) driver;
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "img/png", screenshotName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();

}

}



