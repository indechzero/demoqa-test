package FinalActivity.tests.PageActions;

import FinalActivity.tests.PageObjects.radioBtnPageObjects;
import TestComponents.BaseTest;
import org.openqa.selenium.JavascriptExecutor;

public class RadioButtonComponents extends BaseTest {

  radioBtnPageObjects radioPageObj = new radioBtnPageObjects(driver);

    JavascriptExecutor js = (JavascriptExecutor) driver;

    public void goToHomePage()
    {
        driver.get("https://demoqa.com/");
        assert driver.getCurrentUrl().equalsIgnoreCase("https://demoqa.com/");
        assert radioPageObj.elementsNavButton.isEnabled();
        radioPageObj.elementsNavButton.click();

       assert radioPageObj.mainBody.getText().equalsIgnoreCase("Please select an item from left to start practice.");
       radioPageObj.radioButton.click();
    }

public  void goToRadioButtonPage() {

    String PageTitle = "DEMOQA";
    assertTitle(PageTitle);
    System.out.println(radioPageObj.sectionTitle.getText());
    assert radioPageObj.sectionTitle.getText().equalsIgnoreCase("Radio Button");

}

public void radioButtonUnselected () {
    System.out.println(radioPageObj.mainText.getText());

   assert radioPageObj.mainText.getText().equalsIgnoreCase("Do you like the site?");

    assert radioPageObj.yesBtn.isEnabled();
        System.out.println("Radio Button Yes Enabled");
    assert radioPageObj.impressiveBtn.isEnabled();
        System.out.println("Radio Button Impressive Enabled");
    assert !radioPageObj.noBtn.isEnabled();
    System.out.println("Radio Button No Disabled");

    //radio buttons must be unselected by default

    elementMustNotBeSelected(radioPageObj.yesBtn);
    elementMustNotBeSelected(radioPageObj.impressiveBtn);
    elementMustBeDisabled(radioPageObj.noBtn);

}

public void selectYesRadioBtn () {
    //Select Yes radio button

    js.executeScript("arguments[0].click();", radioPageObj.yesBtn);

    elementMustBeSelected(radioPageObj.yesBtn);
    assert radioPageObj.yesBtnMsg.getText().equalsIgnoreCase("You have selected Yes");
    System.out.println(radioPageObj.yesBtnMsg.getText());
}

public void selectImpressive () {
    //Select Impressive Radio button

    js.executeScript("arguments[0].click();", radioPageObj.impressiveBtn);
    elementMustBeSelected(radioPageObj.impressiveBtn);
    assert radioPageObj.impressiveBtnMsg.getText().equalsIgnoreCase("You have selected Impressive");
    System.out.println(radioPageObj.impressiveBtnMsg.getText());

}

public void verifyNoBtn (){

    //Assert No Button

    js.executeScript("arguments[0].click();", radioPageObj.noBtn);
    elementMustBeDisabled(radioPageObj.noBtn);

}

}

