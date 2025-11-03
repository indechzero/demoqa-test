package org.FinalActivity;

import org.AbstractComponent.abstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DatePickerComponent extends abstractComponent {


    @FindBy(xpath="//div[contains(text(),'Select Date')]") @CacheLookup
    public WebElement selectDateLabel;

    @FindBy(xpath="//input[@id='datePickerMonthYearInput']") @CacheLookup
    private WebElement selectDateField;

    @FindBy(css="div[class='mt-4 row'] div[class='col-md-3 col-sm-12']") @CacheLookup
    private WebElement dateAndTimeLabel;

    @FindBy(xpath="//input[@id='dateAndTimePickerInput']") @CacheLookup
    private WebElement dateAndTimeInput;

    @FindBy(css=".text-center")
    static WebElement sectionTitle;


    public DatePickerComponent(WebDriver driver)

    {
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }
    public void goToDatePickerPage() {

        driver.get("https://demoqa.com/date-picker");

        String ActualTitle = driver.getTitle();
        String PageTitle = "DEMOQA";

       assert ActualTitle.equalsIgnoreCase(PageTitle);

        String sectionTitle = (driver.findElement(By.cssSelector(".text-center")).getText());


        assert sectionTitle.equalsIgnoreCase("Date Picker");
        System.out.println(sectionTitle);
    }

    public void typeDate() {

        System.out.println(selectDateLabel.getText());
        assert selectDateLabel.getText().equals("Select Date");
        selectDateField.clear();
        selectDateField.click();
//        selectDateField.sendKeys("01/29/2025");
        selectDateField.sendKeys(Keys.ENTER);
    }


    public void selectDate() {
        selectDateField.clear();
        selectDateField.click();
    }

    public void selectDateTime() {


    }

}
