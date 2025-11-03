package FinalActivity.tests.PageObjects;

import TestComponents.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ButtonPageObjects extends BaseTest {

    public ButtonPageObjects(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(css=".text-center")
        public WebElement sectionTitle;

    @FindBy(id="doubleClickBtn")
        public WebElement dblClick;

    public By dblClickMsg = By.id("doubleClickMessage");

    @FindBy(id="rightClickBtn")
        public  WebElement rightClkBtn;

    public By rightClkMsg = By.id("rightClickMessage");

    @FindBy(xpath = "*//div[3]/button")
        public WebElement dynamicBtn;

    public  By dynamicClkMsg = By.id("dynamicClickMessage");

    public  Actions act = new Actions(driver);

    @FindBy(xpath="//body/div[@id='app']/div[@class='body-height']/div[@class='home-content']/div[@class='home-body']/div[@class='category-cards']/div[1]")
    @CacheLookup
    public WebElement elementsNavButton;

    @FindBy(xpath="(//li[@id='item-4'])[1]") @CacheLookup
    public WebElement buttonMenuItem;
    }

