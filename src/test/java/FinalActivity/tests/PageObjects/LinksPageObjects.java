package FinalActivity.tests.PageObjects;

import TestComponents.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LinksPageObjects extends BaseTest {

    public LinksPageObjects(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".text-center")
        public WebElement sectionTitle;

    @FindBy(css = "a[href*='javascript']")
        public List<WebElement> links;

    @FindBy(xpath="//*[@id=\"simpleLink\"]")
        public WebElement simpleLink;

    @FindBy(xpath= "//*[@id=\"dynamicLink\"]")
        public WebElement dynamicLink;

    @FindBy(id="linkResponse")
        public WebElement linkResponseMsg;

    @FindBy(xpath="//body/div[@id='app']/div[@class='body-height']/div[@class='home-content']/div[@class='home-body']/div[@class='category-cards']/div[1]")
    @CacheLookup public WebElement elementsNavButton;

    @FindBy(xpath="(//li[@id='item-5'])[1]") @CacheLookup
    public WebElement linksSection;

    }

