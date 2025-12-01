package FinalActivity.tests.PageObjects;

import TestComponents.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AutoCompletePageObjects extends BaseTest {

    public AutoCompletePageObjects(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath=" //*[@id=\"autoCompleteMultiple\"]/span[1]") @CacheLookup
    public  WebElement typeMultipleColorNames;

    @FindBy(xpath="//*[@id=\"autoCompleteMultipleInput\"]") @CacheLookup
    public   WebElement typeMultipleColorNamesInput;

    @FindBy(xpath="//*[@id=\"autoCompleteSingle\"]/span[1]") @CacheLookup
    public  WebElement autoCompleteLabelSingle;

    @FindBy(xpath="//*[@id=\"autoCompleteSingleInput\"]") @CacheLookup
    public   WebElement autoCompleteInputSingle;

    @FindBy(css=".text-center")
    public WebElement sectionTitle;

    @FindBy(xpath="*//body//div/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div") @CacheLookup
    public  List<WebElement> enteredValuesList;

    @FindBy(xpath="*//body//div/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div") @CacheLookup
    public WebElement enteredValue;

    @FindBy(className="css-12jo7m5")
    @CacheLookup public WebElement enteredValues;

    @FindBy(xpath="(//li[@id='item-1'])[3]") @CacheLookup
    public WebElement autoComplete;

    @FindBy(xpath="(//div[@class='auto-complete__single-value css-1uccc91-singleValue'])[1]")
    @CacheLookup public WebElement singleEnterValue;

    @FindBy(xpath="//div[4]") @CacheLookup
    public WebElement widgets;

}
