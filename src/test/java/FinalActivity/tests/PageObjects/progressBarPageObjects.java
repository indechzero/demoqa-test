package FinalActivity.tests.PageObjects;

import TestComponents.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class progressBarPageObjects extends BaseTest {

    public progressBarPageObjects(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".text-center")
        public WebElement sectionTitle;

    @FindBy (xpath = "//div[@class='mb-3']") @CacheLookup
        public WebElement progressBarLabel;

    @FindBy(xpath="//button[@id='startStopButton']") @CacheLookup
        public WebElement progressBarButton;

    @FindBy(xpath="//*[@id=\"resetButton\"]") @CacheLookup
        public WebElement resetButton;

    @FindBy(xpath="//button[@id='startStopButton']") @CacheLookup
    public WebElement startStopBtn;

        public By startStopBtnBy = By.xpath("//button[@id='startStopButton']");

        public By progressBarPercentageBy = By.xpath("//*[@id=\"progressBar\"]/div");

    @FindBy(xpath="//*[@id=\"progressBar\"]/div") @CacheLookup
        public WebElement progressBar;

    @FindBy(xpath="(//li[@id='item-4'])[3]") @CacheLookup
        public WebElement progressBarNav;

    @FindBy(xpath="//div[4]") @CacheLookup
        public WebElement widgets;

    }

