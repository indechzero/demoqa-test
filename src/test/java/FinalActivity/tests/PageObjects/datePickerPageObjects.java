package FinalActivity.tests.PageObjects;

import TestComponents.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class datePickerPageObjects extends BaseTest {

    public datePickerPageObjects(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".text-center")
    public WebElement sectionTitle;


    public By dateInput = By.id("datePickerMonthYearInput");

    public By dateTimeInput = By.id("dateAndTimePickerInput");

    @FindBy(xpath="//div[contains(text(),'Select Date')]") @CacheLookup
    public WebElement selectDateLabel;


    @FindBy(xpath="//input[@id='datePickerMonthYearInput']")
    public WebElement selectDateField;

    @FindBy(id="datePickerMonthYearInput")
    public WebElement dateFieldInput;

    @FindBy(css="div[class='mt-4 row'] div[class='col-md-3 col-sm-12']")
    public WebElement dateAndTimeLabel;

    @FindBy(xpath="//input[@id='dateAndTimePickerInput']")
    public WebElement dateAndTimeInput;

    @FindBy(xpath="(//li[@id='item-2'])[3]") @CacheLookup
    public WebElement datePicker;

    @FindBy(xpath="//div[4]") @CacheLookup
    public WebElement widgets;

//   @FindBy (xpath = "//*[@id='datePickerMonthYear']/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]")
//    public WebElement monthDropdownButton;
//
//    @FindBy(xpath="//*[@id=\"datePickerMonthYear\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select/")
//    public List<WebElement>  monthPicker;
}

