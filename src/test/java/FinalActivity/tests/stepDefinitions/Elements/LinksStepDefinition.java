package FinalActivity.tests.stepDefinitions.Elements;

import FinalActivity.tests.PageActions.LinksComponent;
import TestComponents.BaseTest;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class LinksStepDefinition extends BaseTest {


    LinksComponent linksComponents = new LinksComponent();
    @Test
    @Given("that I am in the DEMO homepage for Links activity")
    public void gotHomePage() throws InterruptedException, IOException {

        linksComponents.goToHomePageLinks();
    }
    @When("I navigated to the Links activity page")
    public void goToLinksPage () throws IOException, InterruptedException {

        linksComponents.goLinksPage();
    }
    @And("I must be able to verify the window links")
    public void clickNewWindowLinks () throws IOException, InterruptedException {

        linksComponents.clickNewWindowLinks();
    }
    @Then("I must be able to verify the API links")
    public void clickLinksAPI () throws IOException, InterruptedException {

        linksComponents.clickLinksAPI();
    }

    @AfterClass
    public void tearDown()  {
        driver.quit();
    }
}

