package FinalActivity.tests.PageObjects;

import TestComponents.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebTablePageObjects extends BaseTest {

    public WebTablePageObjects(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".text-center")
        public WebElement sectionTitle;

    @FindBy(xpath="//button[@id=\"addNewRecordButton\"]") @CacheLookup
        public WebElement addNewRecordBtn;

    @FindBy(xpath="//div[@class=\"modal-header\"]") @CacheLookup
        public WebElement modalHeader;

    @FindBy(id= "firstName") @CacheLookup
        public WebElement firstNameField;

    @FindBy(id= "firstName") @CacheLookup
        public WebElement editFirstNameField;

    @FindBy(id="lastName") @CacheLookup
        public WebElement lastNameField;

    @FindBy(id="lastName") @CacheLookup
        public WebElement editLastNameField;

    @FindBy(id="userEmail") @CacheLookup
        public WebElement userEmailField;

    @FindBy(id="userEmail") @CacheLookup
        public WebElement editUserEmailField;

    @FindBy(id="age") @CacheLookup
        public WebElement ageField;

    @FindBy(id="age") @CacheLookup
        public WebElement editAgeField;

    @FindBy(id="salary") @CacheLookup
        public WebElement salaryField;

    @FindBy(id="salary") @CacheLookup
        public WebElement editSalaryField;

    @FindBy(id="department") @CacheLookup
        public WebElement departmentField;

    @FindBy(id="department") @CacheLookup
        public WebElement editDepartmentField;

    @FindBy(id="submit") @CacheLookup
        public WebElement submitBtn;

    @FindBy(id="submit") @CacheLookup
        public WebElement editModalSubmitBtn;

    @FindBy(xpath = "//*[@id=\"searchBox\"]")
        public WebElement searchBox;

    public By tblSearchBox = By.xpath("//*[@id=\"searchBox\"]");

    @FindBy(xpath="//div[@class=\"rt-tr-group\"]/child::div[1]/child::div[1]") @CacheLookup
        public List<WebElement> firstNameEntries;

    @FindBy(xpath="//div[@class=\"rt-tr-group\"]") @CacheLookup
        public List<WebElement> rowEntries;

    @FindBy(xpath="//div[@class=\"rt-tr-group\"]/child::div[1]/child::div[7]/child::div[1]/span[1]")
        public List<WebElement> rowEntryEditBtn;

    @FindBy(xpath="//div[@class=\"rt-tr-group\"]/child::div[1]/child::div[7]/child::div[1]/span[2]")
        public List<WebElement> rowEntryDeleteBtn;

    @FindBy(xpath="/html/body/div[5]/div/div/div[2]")
        public WebElement editModalBody;

    @FindBy(xpath="//body/div[@id='app']/div[@class='body-height']/div[@class='home-content']/div[@class='home-body']/div[@class='category-cards']/div[1]") @CacheLookup
        public WebElement elementsNavButton;

    @FindBy(xpath="(//li[@id='item-3'])[1]") @CacheLookup
        public WebElement webTables;

}

