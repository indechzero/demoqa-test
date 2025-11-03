package org.FinalActivity;

import org.AbstractComponent.abstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DynamicPropComponents extends abstractComponent {

    @FindBy(css=".text-center")
    static  WebElement sectionTitle;

    By enableAfterBtn = By.cssSelector("#enableAfter");

    @FindBy(css="#colorChange")
    WebElement colorChange;

    By visibleBtn = By.xpath("//button[@id='visibleAfter']");

    @FindBy(css = "#colorChange")
    WebElement colorChangeBtn;

    @FindBy(xpath = "//div[2]/..//p[1]")
    WebElement dynamicBtn;

public DynamicPropComponents(WebDriver driver)

{
    this.driver = driver;
    PageFactory.initElements(driver,this);

        }

public  void goToDynamicPropsPage(){
    driver.get("https://demoqa.com/dynamic-properties");


}
    public String getSectionTitle(){

        waitForWebElementToAppear(sectionTitle);
        System.out.println(sectionTitle.getText());
        return sectionTitle.getText();

   }

   public void disabledButton(){

        waitForElementToBeEnabled(enableAfterBtn);
       boolean btnDisable = driver.findElement(enableAfterBtn).isEnabled();
       String disabledBtn = driver.findElement(enableAfterBtn).getText();

       System.out.println(disabledBtn);

       assert disabledBtn.equalsIgnoreCase("Will enable 5 seconds");
       assert btnDisable;

   }

   public void dynamicButtonColor (){

       colorChange.getText();
       System.out.println(colorChange.getText());

      String btnColorDynamic = colorChange.getCssValue("color");

       String color = Color.fromString(btnColorDynamic).asHex();

       System.out.println("First button color is" + " " + color);
       String firstColor = "#ffffff";

       assert color.equalsIgnoreCase(firstColor);

       //Verify button text color change
       String btnColorFinal= colorChange.getCssValue("color");
       String colorAfter = Color.fromString(btnColorFinal).asHex();

       String waitElement = colorChangeBtn.getCssValue("color");
       System.out.println(waitElement);

       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       System.out.println("Final button color is" + " " + colorAfter);

       String newColor = "#dc3545";

      assert colorAfter.equalsIgnoreCase(newColor);

   }

   public void dynamicBtnDisplay(){


       waitForElementToAppear(visibleBtn);

       String hiddenBtn = driver.findElement(visibleBtn).getText();
       System.out.println(hiddenBtn);

      assert hiddenBtn.equalsIgnoreCase( "Visible After 5 Seconds");


   }

   public void dynamicBtnText (){

       String dynamicIdText = dynamicBtn.getText();
       System.out.println(dynamicIdText);
    assert dynamicIdText.equalsIgnoreCase("This text has random Id");
   }

    }

