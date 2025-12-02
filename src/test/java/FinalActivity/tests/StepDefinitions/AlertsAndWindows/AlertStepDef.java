package FinalActivity.tests.StepDefinitions.AlertsAndWindows;

import FinalActivity.tests.PageActions.AlertsComponent;
import TestComponents.BaseTest;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class AlertStepDef extends BaseTest {
    WebDriver driver;

AlertsComponent alertComponent = new AlertsComponent();

    @Test
       @Given("that I am in the DEMO homepage")
    public void goToHomePage() throws InterruptedException, IOException {
        alertComponent.goToHomePage();
    }

    @When("I navigated to the Alerts activity page")
    public void goToAlerts() throws InterruptedException, IOException {
        alertComponent.goToAlertsPage();
    }

    @And("I click the first alert button to verify that it is functional")
    public void goToFirstAlerts() throws InterruptedException, IOException {
        alertComponent.firstAlert();
    }

    @And("I click the second alert button to verify that it is functional")
    public void goToSecondAlerts() throws InterruptedException, IOException {
        alertComponent.secondAlertButton();
    }

    @And("I click the third alert button to verify that it is functional")
    public void goToThirdAlerts() throws InterruptedException, IOException {
        alertComponent.thirdAlertButton();
    }

    @Then("the last alert button must be functional")
    public void goToFourthAlerts() throws InterruptedException, IOException {
        alertComponent.fourthAlertButton();
    }

        }

//    @AfterClass
//    public void tearDown()  {
//        driver.quit();
//    }
//    }

