package FinalActivity.tests.PageObjects;

import TestComponents.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class practiceFormPageObjects extends BaseTest {

    public practiceFormPageObjects(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".text-center")
        public WebElement sectionTitle;

    @FindBy(id="firstName")
        public WebElement firstName;

    @FindBy(id="lastName")
        public WebElement lastName;

    @FindBy(id="userName-label")
        public WebElement lblFirstName;

    @FindBy(id="userEmail-label")
        public WebElement Lblemail;

    @FindBy(id="userEmail")
        public WebElement emailField;

    @FindBy(xpath="//div[normalize-space()=\"Gender\"]")
        public WebElement genderLabel;

    @FindBy(css="label[for=\"gender-radio-1\"]") @CacheLookup
        public WebElement maleRadio;

    @FindBy(id="userNumber-label")
        public WebElement userNumberLabel;

    @FindBy(id="userNumber")
        public WebElement userNumberField;

    @FindBy(className="form-file-label") @CacheLookup
        public WebElement selectPictureLabel;

    @FindBy(css="#uploadPicture")
        @CacheLookup public WebElement selectPicture;

    @FindBy(id="dateOfBirth-label")
        public WebElement lblDate;

    @FindBy(xpath="//input[@id=\"dateOfBirthInput\"]")
        public WebElement birthDateField;

    @FindBy(css=".react-datepicker__month-select")
        public WebElement monthSelect;

    @FindBy(xpath = "//*[@id=\"dateOfBirth\"]//div[1]/select")
        public WebElement birthMonth;

    @FindBy(xpath="//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select")
        public WebElement birthYear;

    @FindBy(xpath="//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[4]")
        public WebElement birthDay;

    @FindBy(id="subjects-label")
        public WebElement subjLabel;

    @FindBy(xpath="//*[@id=\"subjectsInput\"]")
        public WebElement subjField;

    @FindAll({@FindBy (xpath="//*[@id=\"react-select-2-option-0\"]")})
        public List<WebElement> subjAutoComplete;

    @FindBy(xpath="//div[@id=\"hobbiesWrapper\"]//label[@id=\"subjects-label\"]") @CacheLookup
        public WebElement hobbies;

    @FindAll({@FindBy (xpath="//input[@type='checkbox'] ")})
        public List<WebElement> HobbyCheckBoxes;

    @FindBy(id="currentAddress")
        public WebElement userAddress;

    @FindBy(xpath="//*[@id=\"react-select-3-option-0\"]")
        public WebElement stateUserOptionNCR;

    @FindBy(xpath="//*[@id=\"state\"]")
        public WebElement stateField;

    @FindBy(xpath = "//*[@id=\"stateCity-wrapper\"]//div//div[@id=\"city\"]")
        public WebElement cityField;

    @FindBy(xpath = "//*[@id=\"react-select-4-option-0\"]")
        public WebElement cityListOption;

    @FindBy(id="submit")
        public WebElement submitBtn;

    @FindBy(css="#example-modal-sizes-title-lg")
        public WebElement successModalTitle;

    @FindAll({@FindBy (xpath="*//div/table/tbody/tr/td[2]")})
        public List<WebElement> SuccessModalResults;

    @FindBy(id="closeLargeModal")
        public WebElement closeBtn;

    @FindBy(xpath="(//div[@class='card mt-4 top-card'])[2]") @CacheLookup
        public WebElement practiceFormNavigation;

    @FindBy(xpath="(//li[@id='item-0'])[2]") @CacheLookup
        public WebElement practiceForm;
    }

