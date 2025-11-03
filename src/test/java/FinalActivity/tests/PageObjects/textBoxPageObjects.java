package FinalActivity.tests.PageObjects;

import TestComponents.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class textBoxPageObjects extends BaseTest {

    public textBoxPageObjects(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".text-center")
        public WebElement sectionTitle;

    @FindBy(id="userName")
        public WebElement userName;

    @FindBy(id="userEmail")
        public WebElement userEmail;

    @FindBy(id="currentAddress")
        public WebElement currentAddress;

    @FindBy(id="permanentAddress")
        public WebElement permanentAddress;

    @FindBy(id="submit")
        public WebElement submitBtn;

    @FindBy(id="name")
        public WebElement nameMsg;

    @FindBy(xpath="//p[@id=\"email\"]")
        public WebElement emailMsg;

    @FindBy(xpath="//p[@id=\"currentAddress\"]")
        public WebElement currentAddressMsg;

    @FindBy(xpath="//p[@id=\"permanentAddress\"]")
        public WebElement permanentAddressMsg;

    @FindBy(xpath="//body/div[@id='app']/div[@class='body-height']/div[@class='home-content']/div[@class='home-body']/div[@class='category-cards']/div[1]") @CacheLookup
        public WebElement elementsNavButton;

    @FindBy(xpath="(//li[@id='item-0'])[1]") @CacheLookup
        public WebElement textBox;
    }

