package org.FinalActivity;

import org.AbstractComponent.abstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TextBoxComponents extends abstractComponent {

    @FindBy(css=".text-center")
    static WebElement sectionTitle;

    @FindBy(id="userName")
    WebElement userName;

    @FindBy(id="userEmail")
    WebElement userEmail;

    @FindBy(id="currentAddress")
    WebElement currentAddress;

    @FindBy(id="permanentAddress")
    WebElement permanentAddress;

    @FindBy(id="submit")
    WebElement submitBtn;

    @FindBy(id="name")
    WebElement nameMsg;

    @FindBy(xpath="//p[@id=\"email\"]")
    WebElement emailMsg;

    @FindBy(xpath="//p[@id=\"currentAddress\"]")
    WebElement currentAddressMsg;

    @FindBy(xpath="//p[@id=\"permanentAddress\"]")
    WebElement permanentAddressMsg;




public  void goToTextBoxPage() {
    driver.get("https://demoqa.com/text-box");

    String PageTitle = "DEMOQA";

    assertTitle(PageTitle);

    System.out.println(sectionTitle.getText());

    textElementIsEqual(sectionTitle,"Text Box");

}
    public void enterTextField () {

//Transfer user actions to Abstract Component file

        userName.sendKeys("John Doe");
        String usernameInput = userName.getAttribute("value");

        userEmail.sendKeys("testdoe@gmail.com");
        String emailInput = userEmail.getAttribute("value");

        currentAddress.sendKeys("123 Playground Street");
        String addressInput = currentAddress.getAttribute("value");

        permanentAddress.sendKeys("456 Sesame Street");
        String addressPermanentInput = permanentAddress.getAttribute("value");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", submitBtn);

        String[] enteredValues = new String[] {usernameInput, emailInput, addressInput, addressPermanentInput};

        System.out.println(Arrays.toString(enteredValues));

        assert nameMsg.getText().equals(usernameInput);
        assert  emailMsg.getText().equals(emailInput);
        assert currentAddressMsg.getText().equals(addressInput);
        assert permanentAddressMsg.getText().equals(addressPermanentInput);

}

    }

