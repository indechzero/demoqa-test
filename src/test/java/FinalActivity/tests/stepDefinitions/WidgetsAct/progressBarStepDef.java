package FinalActivity.tests.stepDefinitions.WidgetsAct;

import FinalActivity.tests.PageActions.ProgressBarComponent;
import TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class progressBarStepDef extends BaseTest {

        ProgressBarComponent progressbar = new ProgressBarComponent();

    @Test
        @Given("that I am in the DEMO homepage for Progress Bar activity")
        public void goToHomePageProgressBar() {

            progressbar.goToHomePage();
        }
    @When("I navigated to the Progress bar activity page")
    public void goToProgressBarPage() {
        progressbar.goToProgressBarPage();
    }

    @And("I click the button to start the progress bar and pause at 50%")
    public void startProgressBar() throws InterruptedException {

        progressbar.startProgressBar();
    }
    @And("I resume the progress bar by clicking Start again")
    public void continueProgressBar() throws InterruptedException {

        progressbar.continueProgressBar();
    }
    @And("I verify that the progress bar is finished")
    public void verifyFinishedProgress() throws InterruptedException {

        progressbar.verifyFinishedProgress();
    }
    @Then("I must be able to reset the progress bar")
    public void resetProgressBar() throws InterruptedException {

        progressbar.resetProgressBar();

        }


    @AfterClass
    public void tearDown()  {
        driver.quit();
        }


    }

