package FinalActivity.tests.PageObjects;

import TestComponents.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPageObjects extends BaseTest {

    public AlertsPageObjects(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

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

    @FindBy(xpath="//div[@class='element-list collapse show']//li[@id='item-1']") @CacheLookup
        public WebElement alertMenuBtn;

    @FindBy(xpath="//body/div[@id='app']/div[@class='body-height']/div[@class='home-content']/div[@class='home-body']/div[@class='category-cards']/div[3]") @CacheLookup
        public WebElement alertFrameWindowsbtn;
    }





