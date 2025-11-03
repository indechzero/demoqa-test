package org.FinalActivity;

import dev.failsafe.internal.util.Assert;
import org.AbstractComponent.abstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ButtonActComponent extends abstractComponent {

    @FindBy(css=".text-center")
    static WebElement sectionTitle;

    @FindBy(id="doubleClickBtn")
    WebElement dblclick;

    By dblclickmsg = By.id("doubleClickMessage");

    @FindBy(id="rightClickBtn")
    WebElement rightClkBtn;

    By rightClkMsg = By.id("rightClickMessage");

    @FindBy(xpath = "*//div[3]/button")
    WebElement dynamicBtn;

    By dynamicClkMsg = By.id("dynamicClickMessage");

    Actions act = new Actions(driver);

public ButtonActComponent(WebDriver driver)

{
    this.driver = driver;
    PageFactory.initElements(driver,this);

        }

public  void gotoButtonsPage(){
    driver.get("https://demoqa.com/buttons");

    String PageTitle = "DEMOQA";

    assertTitle(PageTitle);

}
    public String getSectionTitle(){

        waitForWebElementToAppear(sectionTitle);

        return sectionTitle.getText();

   }

   public void doubleClick(){

       act.doubleClick(dblclick).perform();

//       WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(8));
        waitForElementToAppear(dblclickmsg);
        textElementAssertion(dblclickmsg, "You have done a double click");
       System.out.println(driver.findElement(dblclickmsg).getText());
   }

   public void rightClick()
   {
       act.contextClick(rightClkBtn).perform();
       waitForElementToAppear(rightClkMsg);
       textElementAssertion(rightClkMsg, "You have done a right click");
       System.out.println(driver.findElement(rightClkMsg).getText());
   }

   public void dynamicButton(){

        dynamicBtn.click();
        waitForElementToAppear(dynamicClkMsg);
       textElementAssertion(dynamicClkMsg, "You have done a dynamic click");
       System.out.println(driver.findElement(dynamicClkMsg).getText());

    }

    }

