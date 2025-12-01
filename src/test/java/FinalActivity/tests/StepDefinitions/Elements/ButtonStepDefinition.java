package FinalActivity.tests.StepDefinitions.Elements;

import TestComponents.BaseTest;
import FinalActivity.tests.PageActions.ButtonActComponent;
import io.cucumber.java.en.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class ButtonStepDefinition extends BaseTest {


       ButtonActComponent btnComponent = new ButtonActComponent();
    @Test
    @Given("that I am in the DEMO homepage for Buttons activity")
       public void gotHomePage() throws InterruptedException, IOException {

           btnComponent.goToHomePage();
       }
    @When("I navigated to the Buttons activity page")
    public void goToButtonsPage() throws InterruptedException, IOException {

        btnComponent.gotoButtonsPage();
    }

    @Then("I must be able to perform double click action on button")
    public void testDoubleClick() throws InterruptedException, IOException {

        btnComponent.doubleClick();
    }

    @And("I must be able to perform right click action on right click button")
    public void testRightClick() throws InterruptedException, IOException {

        btnComponent.rightClick();
    }
    @And("I must be able to verify that dynamic button is functional")
    public void testDynamicButton() throws InterruptedException, IOException {

        btnComponent.dynamicButton();
    }

        }



