package org.FinalActivity;

import org.AbstractComponent.abstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;

public class RadioButtonComponents extends abstractComponent {

    @FindBy(css=".text-center")
    static WebElement sectionTitle;

    @FindBy(css=".mb-3")
    WebElement mainText;

    @FindBy(id="yesRadio")
    WebElement yesBtn;

    @FindBy(xpath="//*[@id=\"impressiveRadio\"]")
    WebElement impressiveBtn;

    @FindBy(id="noRadio")
    WebElement noBtn;

    @FindBy(xpath="//*/p[@class='mt-3']")
    WebElement yesBtnMsg;

    @FindBy(xpath="//*/p[@class='mt-3']")
    WebElement impressiveBtnMsg;

    JavascriptExecutor js = (JavascriptExecutor) driver;

    public RadioButtonComponents(WebDriver driver)

{
    this.driver = driver;
    PageFactory.initElements(driver,this);

        }

public  void goToRadioButtonpage() {

    driver.get("https://demoqa.com/radio-button");

    String PageTitle = "DEMOQA";
    assertTitle(PageTitle);
    System.out.println(sectionTitle.getText());
    textElementIsEqual(sectionTitle,"Radio Button");
}

public void radioButtonUnselected () {
    System.out.println(mainText.getText());

   assert mainText.getText().equalsIgnoreCase("Do you like the site?");

    //radio buttons must be unselected by default

    elementMustNotBeSelected(yesBtn);
    elementMustNotBeSelected(impressiveBtn);
    elementMustBeDisabled(noBtn);

}

public void selectYesRadioBtn () {
    //Select Yes radio button

    js.executeScript("arguments[0].click();", yesBtn);

    elementMustBeSelected(yesBtn);
    assert yesBtnMsg.getText().equalsIgnoreCase("You have selected Yes");
    System.out.println(yesBtnMsg.getText());
}

public void selectImpressive () {
    //Select Impressive Radio button

    js.executeScript("arguments[0].click();", impressiveBtn);
    elementMustBeSelected(impressiveBtn);
    assert impressiveBtnMsg.getText().equalsIgnoreCase("You have selected Impressive");
    System.out.println(impressiveBtnMsg.getText());

}

public void verifyNoBtn (){

    //Assert No Button

    js.executeScript("arguments[0].click();", noBtn);
    elementMustBeDisabled(noBtn);

}

}

