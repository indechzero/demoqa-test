package FinalActivity.tests.PageObjects;

import TestComponents.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class selectablePageObjects extends BaseTest {

    public selectablePageObjects(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".text-center")
        public WebElement sectionTitle;

    @FindBy(id="userName")
        public WebElement userName;

//    By progressBarPercentage = By.xpath("//*[@id=\"progressBar\"]/div");

    @FindBy(xpath="//*[@id=\"verticalListContainer\"]/li")
        public List<WebElement> selectableCount;

    @FindBy(id="demo-tab-grid")
        public WebElement gridTab;

    @FindBy(xpath="//*[@id=\"gridContainer\"]/div/li")
        public List<WebElement>  selectableGrid;

    @FindBy(xpath="//div[5]") @CacheLookup
        public WebElement interactionsCard;

    @FindBy(xpath="(//li[@id='item-1'])[4]") @CacheLookup
        public WebElement selectable;
    }

