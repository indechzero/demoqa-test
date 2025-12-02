package FinalActivity.tests.StepDefinitions.AlertsAndWindows;

import FinalActivity.tests.PageActions.WindowsActivityComponents;
import TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class WindowsActivityStepDef extends BaseTest {

    @Test
        @Given("that I am in the DEMO homepage for the Windows Activity")
            public void goToHomePage() throws InterruptedException, IOException {
            WindowsActivityComponents.goToHomePage();
        }
        @When("I navigated to the Windows activity page")
        public static void verifySectionTitle()
        {
            WindowsActivityComponents.verifySectionTitle();
        }

        @Then("I must be able to verify that the windows are functional")
        public static void windowHandle() throws InterruptedException
        {

            WindowsActivityComponents.windowHandle();
        }

    @AfterClass
    public void tearDown()  {
        driver.quit();
    }

}


