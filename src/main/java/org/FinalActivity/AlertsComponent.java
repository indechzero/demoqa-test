package org.FinalActivity;

import dev.failsafe.internal.util.Assert;
import org.AbstractComponent.abstractComponent;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsComponent extends abstractComponent{

JavascriptExecutor js = (JavascriptExecutor) driver;

    @FindBy(css=".text-center")
    public  WebElement sectionTitle;

    @FindBy(id="alertButton")
    public WebElement alertButton;

    @FindBy(id="timerAlertButton")
    public WebElement TimerAlertButton;

    @FindBy(id="promtButton")
    public WebElement promptButton;

    @FindBy(css="#confirmButton")
    public WebElement confBtn;

    @FindBy(id="confirmResult")
    public WebElement okayResult;

    @FindBy(css="#promptResult")
    public WebElement promptResult;

public AlertsComponent(WebDriver driver)

{
    this.driver = driver;
    PageFactory.initElements(driver,this);

}


public  void goToPracticeForm(){
    driver.get("https://demoqa.com/alerts");


}
    public String getSectionTitle(){

        waitForWebElementToAppear(sectionTitle);
        System.out.println(sectionTitle.getText());
        return sectionTitle.getText();

   }

    public void firstAlert(){
       alertButton.click();
      alertVerification();
        Alert alert = driver.switchTo().alert();
        //Store the alert text in a variable and verify it
        String text = alert.getText();

       assert text.equalsIgnoreCase("You clicked a button");
        alert.dismiss();
        System.out.println(text);

    }

    public void secondAlertButton (){

        js.executeScript("window.scrollBy(0,450)", "");

        TimerAlertButton.click();
        alertVerification();
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        System.out.println(text);

        alert.accept();
    }


    public void ThirdAlertButton (){

        confBtn.click();
        alertVerification();
        Alert alert = driver.switchTo().alert();

        alert.accept();

        System.out.println(okayResult.getText());
     assert okayResult.getText().equalsIgnoreCase("You selected Ok");

    }

    public void FourthAlertButton (){

        promptButton.click();
        alertVerification();
        Alert alert = driver.switchTo().alert();

        String message = "Jane Doe";
        alert.sendKeys(message);
        String text = alert.getText();
        System.out.println(text);

        alert.accept();

        System.out.println(promptResult.getText());
       assert promptResult.getText().equalsIgnoreCase("You entered Jane Doe");

    }



    }

