package FinalActivity.tests.PageObjects;

import TestComponents.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicPropPageObjects extends BaseTest {

    public DynamicPropPageObjects(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".text-center")
    public  WebElement sectionTitle;

    public By enableAfterBtn = By.cssSelector("#enableAfter");

    @FindBy(css="#colorChange")
    public WebElement colorChange;

    public By visibleBtn = By.xpath("//button[@id='visibleAfter']");

    @FindBy(css = "#colorChange")
    public WebElement colorChangeBtn;

    @FindBy(xpath = "//div[2]/..//p[1]")
    public  WebElement dynamicBtn;

    @FindBy(xpath="//body/div[@id='app']/div[@class='body-height']/div[@class='home-content']/div[@class='home-body']/div[@class='category-cards']/div[1]")
    @CacheLookup
    public WebElement elementsNavButton;

    @FindBy(xpath="(//li[@id='item-8'])[1]") @CacheLookup public
    WebElement dynamicProperties;

    }

