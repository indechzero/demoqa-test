package FinalActivity.tests.PageActions;

import FinalActivity.tests.PageObjects.textBoxPageObjects;
import TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import org.openqa.selenium.JavascriptExecutor;

import java.util.Arrays;
import static org.testng.Assert.*;

public class TextBoxComponents extends BaseTest {


    private final textBoxPageObjects txtBoxObj = new textBoxPageObjects(driver);

    @Given("that I navigated to the textbox activity from the homepage")
    public void goToHomePage()
    {
        driver.get("https://demoqa.com/");
        txtBoxObj.elementsNavButton.click();
        txtBoxObj.textBox.click();
    }

public  void goToTextBoxPage() {

    String PageTitle = "DEMOQA";
    String expectedSectionTitle = "Text Box";
    String actualSectionTitle = txtBoxObj.sectionTitle.getText();
    assertTitle(PageTitle);

    System.out.println(txtBoxObj.sectionTitle.getText());
    assertEquals(actualSectionTitle,expectedSectionTitle, "Section title does not match the expected value");

}
    public void enterTextField (String userName, String email, String address, String permanentAddress) {


        txtBoxObj.userName.sendKeys(userName);
            String usernameInput = txtBoxObj.userName.getAttribute("value");

        txtBoxObj.userEmail.sendKeys(email);
            String emailInput = txtBoxObj.userEmail.getAttribute("value");

        txtBoxObj.currentAddress.sendKeys(address);
            String addressInput = txtBoxObj.currentAddress.getAttribute("value");

        txtBoxObj.permanentAddress.sendKeys(permanentAddress);
            String addressPermanentInput = txtBoxObj.permanentAddress.getAttribute("value");

        JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", txtBoxObj.submitBtn);

        String[] enteredValues = new String[] {usernameInput, emailInput, addressInput, addressPermanentInput};

        System.out.println(Arrays.toString(enteredValues));

        System.out.println(txtBoxObj.nameMsg.getText());
        System.out.println(txtBoxObj.emailMsg.getText());
        System.out.println(txtBoxObj.currentAddressMsg.getText());
        System.out.println(txtBoxObj.permanentAddressMsg.getText());

        assert true; txtBoxObj.nameMsg.getText().equalsIgnoreCase("Name:" + usernameInput);
        assert txtBoxObj.emailMsg.getText().equals("Email:" + emailInput);
        assert txtBoxObj.currentAddressMsg.getText().equals("Current Address :" + addressInput);
        assert txtBoxObj.permanentAddressMsg.getText().equals("Permananet Address :" + addressPermanentInput);

}

    }

