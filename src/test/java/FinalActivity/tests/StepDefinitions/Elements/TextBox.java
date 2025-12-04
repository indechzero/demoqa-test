package FinalActivity.tests.StepDefinitions.Elements;

import FinalActivity.tests.PageActions.TextBoxComponents;
import TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class TextBox extends BaseTest {


        TextBoxComponents textBox = new TextBoxComponents();
    @Test
    @Given("that I am in the DEMO homepage for Text Box activity")
    public void goToHomePage () throws InterruptedException, IOException {
        textBox.goToHomePage();
    }
    @When("I navigated to the Text Box activity page")
    public void goToTextBoxPage () throws InterruptedException, IOException {
        textBox.goToTextBoxPage();
    }
    @Then("I must be able to verify the text boxes successfully by submitting username {string}, email {string}, address {string} and permanent address {string}")
    public void enterTextField (String usernameInput, String emailInput, String addressInput, String permanentAddress ) throws InterruptedException, IOException {
        textBox.enterTextField(usernameInput, emailInput, addressInput, permanentAddress);

    }

    @AfterClass
    public void tearDown()  {
        driver.quit();
    }
}
