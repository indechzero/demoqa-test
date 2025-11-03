package FinalActivity.tests.PageObjects;

import TestComponents.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class radioBtnPageObjects extends BaseTest {

    public radioBtnPageObjects(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".text-center")
        public WebElement sectionTitle;

    @FindBy(css=".mb-3")
        public WebElement mainText;

    @FindBy(id="yesRadio")
        public WebElement yesBtn;

    @FindBy(xpath="//*[@id=\"impressiveRadio\"]")
        public WebElement impressiveBtn;

    @FindBy(id="noRadio")
        public WebElement noBtn;

    @FindBy(xpath="//*/p[@class='mt-3']")
        public WebElement yesBtnMsg;

    @FindBy(xpath="//*/p[@class='mt-3']")
        public WebElement impressiveBtnMsg;

    @FindBy(xpath="//body/div[@id='app']/div[@class='body-height']/div[@class='home-content']/div[@class='home-body']/div[@class='category-cards']/div[1]")
    @CacheLookup
    public WebElement elementsNavButton;


    @FindBy(xpath="(//li[@id='item-2'])[1]")
    @CacheLookup public WebElement radioButton;

    @FindBy(xpath = "//div[@class='col-12 mt-4 col-md-6']")
    @CacheLookup
    public WebElement mainBody;

}


