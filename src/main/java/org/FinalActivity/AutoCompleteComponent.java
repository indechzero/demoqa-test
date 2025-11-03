package org.FinalActivity;

import org.AbstractComponent.abstractComponent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AutoCompleteComponent extends abstractComponent {

    @FindBy(xpath=" //*[@id=\"autoCompleteMultiple\"]/span[1]") @CacheLookup
    public WebElement typeMultipleColorNames;

    @FindBy(xpath="//*[@id=\"autoCompleteMultipleInput\"]") @CacheLookup
    public   WebElement typeMultipleColorNamesInput;

    @FindBy(xpath="//*[@id=\"autoCompleteSingle\"]/span[1]") @CacheLookup
    public  WebElement autoCompleteLabelSingle;

    @FindBy(xpath="//*[@id=\"autoCompleteSingleInput\"]") @CacheLookup
    public   WebElement autoCompleteInputSingle;

    @FindBy(css=".text-center")
    public WebElement sectionTitle;

    @FindBy(xpath="css-12jo7m5 auto-complete__multi-value__label") @CacheLookup
    public List<WebElement> enteredValues;

    JavascriptExecutor js = (JavascriptExecutor) driver;



    public void goToForm(){
        driver.get("https://demoqa.com/auto-complete");

        js.executeScript("window.scrollBy(0,150)", "");

        String PageTitle = "DEMOQA";
        assertTitle(PageTitle);
        waitForWebElementToAppear(sectionTitle);
        System.out.println(sectionTitle.getText());
        textElementIsEqual(sectionTitle,"Auto Complete");

    }

    public void multipleColorNames () throws InterruptedException {
        js.executeScript("window.scrollBy(0,350)", "");

       assert typeMultipleColorNames.getText().equals("Type multiple color names");
        typeMultipleColorNamesInput.sendKeys("R");
        Thread.sleep(5000);
        typeMultipleColorNamesInput.sendKeys(Keys.ENTER);

        System.out.println(typeMultipleColorNames.getText());

        for (int i = 0; i < 2 ; i++) {

            typeMultipleColorNamesInput.sendKeys("R");
                Thread.sleep(5000);
            typeMultipleColorNamesInput.sendKeys(Keys.ENTER);

        }

        System.out.println(enteredValues.toString());

    }

    public void singleColorName () throws InterruptedException {

       assert autoCompleteLabelSingle.getText().equals("Type single color name");
        System.out.println(autoCompleteLabelSingle.getText());
        Thread.sleep(500);
        autoCompleteInputSingle.click();
        autoCompleteInputSingle.sendKeys("B");
        Thread.sleep(5000);
        autoCompleteInputSingle.sendKeys(Keys.ENTER);

        System.out.println(autoCompleteInputSingle.getText());
    }

}
