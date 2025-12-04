package FinalActivity.tests.PageActions;

import FinalActivity.tests.PageObjects.DynamicPropPageObjects;
import TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import org.openqa.selenium.support.Color;

import java.util.concurrent.TimeUnit;

public class DynamicPropComponents extends BaseTest {

    DynamicPropPageObjects dynamicPgObjects = new DynamicPropPageObjects(driver);


    @Given("that I am in the DEMOQA homepage")
    public void goToDemoHomePage() throws InterruptedException {
        driver.get("https://demoqa.com/");
        assert driver.getCurrentUrl().equalsIgnoreCase("https://demoqa.com/");

        dynamicPgObjects.elementsNavButton.click();
        Thread.sleep(5000);
        javaScriptClick(dynamicPgObjects.dynamicProperties);
//        dynamicPgObjects.dynamicProperties.click();
    }


    public  void goToDynamicPropsPage(){
        String ActualTitle = driver.getTitle();
        String PageTitle = "DEMOQA";

        assert ActualTitle.equalsIgnoreCase(PageTitle);

        System.out.println(dynamicPgObjects.sectionTitle.getText());
        assert dynamicPgObjects.sectionTitle.getText().equalsIgnoreCase("Dynamic Properties");
}


    public void dynamicButtonColor (){

        dynamicPgObjects.colorChange.getText();
        System.out.println(dynamicPgObjects.colorChange.getText());

        String btnColorDynamic = dynamicPgObjects.colorChange.getCssValue("color");

        String color = Color.fromString(btnColorDynamic).asHex();

        System.out.println("First button color is" + " " + color);
        String firstColor = "#ffffff";

        assert color.equalsIgnoreCase(firstColor);

//        //Verify button text color change
//        String btnColorFinal= dynamicPgObjects.colorChange.getCssValue("color");
//        String colorAfter = Color.fromString(btnColorFinal).asHex();
//
//        String waitColorElement = dynamicPgObjects.colorChangeBtn.getCssValue("color");
//        System.out.println(waitColorElement);
//
        driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
//
//        System.out.println("Final button color is" + " " + colorAfter);
//
//        String newColor = "#dc3545";
//
//        assert colorAfter.equalsIgnoreCase(newColor);

    }

   public void disabledButton(){

        waitForElementToBeEnabled(dynamicPgObjects.enableAfterBtn);
       boolean btnDisable = driver.findElement(dynamicPgObjects.enableAfterBtn).isEnabled();
       String disabledBtn = driver.findElement(dynamicPgObjects.enableAfterBtn).getText();

       System.out.println(disabledBtn);

       assert disabledBtn.equalsIgnoreCase("Will enable 5 seconds");
       assert btnDisable;

   }

   public void dynamicBtnDisplay(){


       waitForElementToAppear(dynamicPgObjects.visibleBtn);

       String hiddenBtn = driver.findElement(dynamicPgObjects.visibleBtn).getText();
       System.out.println(hiddenBtn);

      assert hiddenBtn.equalsIgnoreCase( "Visible After 5 Seconds");


   }

    public void dynamicButtonColorChange ()
    {
        //Verify button text color change
        String btnColorFinal= dynamicPgObjects.colorChange.getCssValue("color");
        String colorAfter = Color.fromString(btnColorFinal).asHex();

        String waitColorElement = dynamicPgObjects.colorChangeBtn.getCssValue("color");
        System.out.println(waitColorElement);

        driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);

        System.out.println("Final button color is" + " " + colorAfter);

        String newColor = "#dc3545";

        assert colorAfter.equalsIgnoreCase(newColor);
    }



   public void dynamicBtnText (){

       String dynamicIdText = dynamicPgObjects.dynamicBtn.getText();
       System.out.println(dynamicIdText);
    assert dynamicIdText.equalsIgnoreCase("This text has random Id");
   }

    }

