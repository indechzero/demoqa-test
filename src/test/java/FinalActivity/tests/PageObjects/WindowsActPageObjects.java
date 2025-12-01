package FinalActivity.tests.PageObjects;

import TestComponents.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WindowsActPageObjects extends BaseTest {

    public WindowsActPageObjects(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".text-center")
        public WebElement sectionTitle;

    @FindBy(xpath = "//div[@id='browserWindows']//div//button")
        public  List<WebElement> browserWindowsBtnList;

    @FindBy(xpath = "//div[@id='browserWindows']//div//button")
    public  WebElement browserWindowsBtn;

    @FindBy(xpath = "//body")
        public  WebElement bodyText;

    @FindBy(xpath="//body/div[@id='app']/div[@class='body-height']/div[@class='home-content']/div[@class='home-body']/div[@class='category-cards']/div[3]")
    @CacheLookup public WebElement alertFrameWindowsbtn;

    @FindBy(xpath="(//li[@id='item-0'])[3]") @CacheLookup
    public WebElement browserWindows;
}




