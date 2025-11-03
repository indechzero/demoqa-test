package FinalActivity.tests.stepDefinitions.alertsAndWindows;

import FinalActivity.tests.PageActions.windowsActivityComponents;
import TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class windowsActivityStepDef extends BaseTest {

    @Test
        @Given("that I am in the DEMO homepage for the Windows Activity")
            public void goToHomePage() throws InterruptedException, IOException {
            windowsActivityComponents.goToHomePage();
        }
        @When("I navigated to the Windows activity page")
        public static void verifySectionTitle()
        {
            windowsActivityComponents.verifySectionTitle();
        }

        @Then("I must be able to verify that the windows are functional")
        public static void windowHandle() throws InterruptedException
        {

            windowsActivityComponents.windowHandle();
        }

    @AfterClass
    public void tearDown()  {
        driver.quit();
    }

}


