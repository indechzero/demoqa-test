package FinalActivity.tests.StepDefinitions.Elements;

import TestComponents.BaseTest;
import FinalActivity.tests.PageActions.DynamicPropComponents;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class DynamicProperties extends BaseTest {

    DynamicPropComponents dynamicComponent = new DynamicPropComponents();

    @Test
    @Given("that I am in the DEMO homepage for Dynamic Properties activity")
    public void goToDemoHomePage () throws InterruptedException, IOException {

        dynamicComponent.goToDemoHomePage();
    }
    @When("I navigated to the Dynamic Properties activity page")
    public void goToDynamicPropsPage () throws InterruptedException, IOException {

        dynamicComponent.goToDynamicPropsPage();
    }
    @Then("I must be able to verify dynamicButtonColor")
    public void dynamicButtonColor () throws InterruptedException, IOException {

        dynamicComponent.dynamicButtonColor();
    }
    @And("I must be able to verify disabledButton")
    public void disabledButton () throws InterruptedException, IOException {

        dynamicComponent.disabledButton();
    }
    @And("I must be able to verify dynamicBtnDisplay")
    public void dynamicBtnDisplay () throws InterruptedException, IOException {

        dynamicComponent.dynamicBtnDisplay();
    }
    @And("I must be able to verify dynamicButtonColorChange")
    public void dynamicButtonColorChange () throws InterruptedException, IOException {

        dynamicComponent.dynamicButtonColorChange();
    }
    @And("I must be able to verify dynamicBtnText")
    public void dynamicBtnText () throws InterruptedException, IOException {

        dynamicComponent.dynamicBtnText();


    }

    @AfterClass
    public void tearDown()  {
        driver.quit();
    }
}
