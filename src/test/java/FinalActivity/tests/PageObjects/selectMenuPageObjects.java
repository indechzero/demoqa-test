package FinalActivity.tests.PageObjects;

import TestComponents.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class selectMenuPageObjects extends BaseTest {

    public selectMenuPageObjects(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".text-center")
    public WebElement sectionTitle;

    @FindBy(xpath="//*[@id=\"selectMenuContainer\"]/div[1]/div")
    @CacheLookup
    public WebElement selectValueLabel;

    @FindBy(xpath="//*[@id=\"withOptGroup\"]/div/div[1]")
    @CacheLookup public WebElement selectValueField;

    @FindBy(xpath="//*[@id=\"withOptGroup\"]/div[2]/div/div[1]/div[2]/div")
    @CacheLookup public List<WebElement> selectValueFirstGroupOptions;

    @FindBy(xpath="//*[@id=\"selectMenuContainer\"]/div[3]/div")
    @CacheLookup public WebElement selectOneLabel;

    @FindBy(xpath="//*[@id=\"selectOne\"]/div/div[1]")
    @CacheLookup public WebElement selectOneField;

    @FindBy(id = "selectOne")
    public WebElement selectOneDropdown;

//    // 2. Select One (Custom React Dropdown)
//    public By selectOneDropdown = By.id("selectOne");
//    public By selectOneOption(String text) {
//        return By.xpath("//div[contains(@id, 'react-select-3-option') and text()='" + text + "']");
//    }

    @FindBy(xpath = "//*[@id=\"selectOne\"]/div[2]/div/div/div//*")
    @CacheLookup public  List <WebElement> selectOneOptions;

//    @FindBy(xpath = "//*[@id=\"withOptGroup\"]/div[2]/div//*")
//    @CacheLookup public  List <WebElement> selectOneDropdownList;

    @FindBy(xpath = "//*[@id=\"withOptGroup\"]/div[2]//div/div/child::*")
    @CacheLookup public  List <WebElement> selectOneDropdownList;

    @FindBy(xpath="//div[contains(text(),'Old Style Select Menu')]")
    @CacheLookup public WebElement oldStyleSelectMenuLabel;

    @FindBy(xpath="//*[@id=\"oldSelectMenu\"]")
    @CacheLookup public WebElement oldStyleSelectMenuField;

    @FindBy(xpath="//*[@id=\"selectMenuContainer\"]/div[7]/div/p/b")
    @CacheLookup public WebElement multiSelectLabel;

    @FindBy(xpath="//*[@id=\"selectMenuContainer\"]/div[7]/div/div/div/div[1]") @CacheLookup
        public WebElement multiSelectField;

    @FindBy(xpath="//*[@id=\"selectMenuContainer\"]/div[7]/div/div/div[2]/div//*") @CacheLookup
        public List<WebElement> multiSelectOptions;

    @FindBy(xpath="//*[@id=\"selectMenuContainer\"]/div[8]/div/p/b") @CacheLookup
        public WebElement standardMultiSelectLabel;

    @FindBy(xpath="//*[@id=\"cars\"]") @CacheLookup
        public WebElement  standardMultiSelectOptions;

    @FindBy(xpath="(//li[@id='item-8'])[2]") @CacheLookup
        public WebElement selectMenu;

    @FindBy(xpath="//div[4]") @CacheLookup
    public WebElement widgets;
    }

