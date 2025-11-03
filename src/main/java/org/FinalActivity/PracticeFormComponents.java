package org.FinalActivity;

import org.AbstractComponent.abstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PracticeFormComponents extends abstractComponent {

    @FindBy(css=".text-center")
    static  WebElement sectionTitle;

    @FindBy(id="firstName")
    WebElement firstName;

    @FindBy(id="lastName")
    WebElement lastName;

    @FindBy(id="userName-label")
    WebElement lblFirstName;

    @FindBy(id="userEmail-label")
    WebElement Lblemail;

    @FindBy(id="userEmail")
    WebElement emailField;

    @FindBy(xpath="//div[normalize-space()=\"Gender\"]")
    WebElement genderLabel;

    @FindBy(css="label[for=\"gender-radio-1\"]") @CacheLookup
     WebElement maleRadio;

    @FindBy(id="userNumber-label")
    WebElement userNumberLabel;

    @FindBy(id="userNumber")
    WebElement userNumberField;

    @FindBy(className="form-file-label") @CacheLookup
     WebElement selectPictureLabel;

    @FindBy(css="#uploadPicture")
    @CacheLookup  WebElement selectPicture;

    @FindBy(id="dateOfBirth-label")
    WebElement lblDate;

    @FindBy(xpath="//input[@id=\"dateOfBirthInput\"]")
    WebElement birthDateField;

    @FindBy(css=".react-datepicker__month-select")
    WebElement monthSelect;

    @FindBy(xpath = "//*[@id=\"dateOfBirth\"]//div[1]/select/option[1]")
    WebElement birthMonth;

    @FindBy(xpath="//*[@id=\"dateOfBirth\"]//div/select/option[101]")
    WebElement birthYear;

    @FindBy(xpath="(//div[@aria-label='Choose Friday, November 29th, 2024'])[1]")
    WebElement birthDay;

    @FindBy(id="subjects-label")
    WebElement subjLabel;

    @FindBy(xpath="//*[@id=\"subjectsInput\"]")
    WebElement subjField;

    @FindAll({@FindBy (xpath="//*[@id=\"react-select-2-option-0\"]")})
    List<WebElement> subjAutoComplete;

    @FindBy(xpath="//div[@id=\"hobbiesWrapper\"]//label[@id=\"subjects-label\"]") @CacheLookup
     WebElement hobbies;

    @FindAll({@FindBy (xpath="//input[@type='checkbox'] ")})
    List<WebElement> HobbyCheckBoxes;

    @FindBy(id="currentAddress")
    WebElement userAddress;

    @FindBy(xpath="//*[@id=\"react-select-3-option-0\"]")
    WebElement stateUserOptionNCR;

    @FindBy(xpath="//*[@id=\"state\"]")
    WebElement stateField;

    @FindBy(xpath = "//*[@id=\"stateCity-wrapper\"]//div//div[@id=\"city\"]")
    WebElement cityField;

    @FindBy(xpath = "//*[@id=\"react-select-4-option-0\"]")
            WebElement cityListOption;

    @FindBy(id="submit")
    WebElement submitBtn;

    @FindBy(css="#example-modal-sizes-title-lg")
    WebElement successModalTitle;

    @FindAll({@FindBy (xpath="*//div/table/tbody/tr/td[2]")})
    List<WebElement> SuccessModalResults;

    @FindBy(id="closeLargeModal")
            WebElement closeBtn;


    JavascriptExecutor js = (JavascriptExecutor) driver;


public PracticeFormComponents(WebDriver driver)

{
    this.driver = driver;
    PageFactory.initElements(driver,this);

        }

public void goToPracticeForm(){
    driver.get("https://demoqa.com/automation-practice-form");


}
    public String getSectionTitle(){

        waitForWebElementToAppear(sectionTitle);
        System.out.println(sectionTitle.getText());
        return sectionTitle.getText();

   }
    public void userDetails (){

        System.out.println(lblFirstName.getText());
        firstName.sendKeys("John");
        lastName.sendKeys("Doe");

        System.out.println(firstName.getAttribute("value"));
        System.out.println(lastName.getAttribute("value"));

        emailField.sendKeys("testdoe@gmail.com");

        System.out.println(emailField.getAttribute("value"));

        System.out.println(genderLabel.getText());

        js.executeScript("arguments[0].click();", maleRadio);
        System.out.println(maleRadio.getText());
        System.out.println(userNumberLabel.getText());

        userNumberField.sendKeys("6312345678");
        System.out.println(userNumberField.getAttribute("value"));
    }

    public void birthDate() {

        System.out.println(lblDate.getText());
        js.executeScript("arguments[0].click();", birthDateField);
        js.executeScript("arguments[0].click();", monthSelect);
        js.executeScript("arguments[0].click();", birthMonth);
        js.executeScript("arguments[0].click();", birthYear);
        js.executeScript("arguments[0].click();", birthDay);

        System.out.println(birthDateField.getAttribute("value"));

    }

   public void practiceHobbiesSubj() throws InterruptedException {

       js.executeScript("window.scrollBy(0,550)", "");
       System.out.println(subjLabel.getText());
       waitForWebElementToAppear(subjField);
       subjField.sendKeys("com");

       Thread.sleep(4000);
       for (WebElement option : subjAutoComplete) {
           if (option.getText().equalsIgnoreCase("Computer Science")) {
               option.click();
               break;
           }
       }

       System.out.println(hobbies.getText());

       for (int i = 0; i < HobbyCheckBoxes.size(); i++) {
           js.executeScript("arguments[0].click();", HobbyCheckBoxes.get(i));
       }
   }
       public void pictureUpload () {

           System.out.println(selectPictureLabel.getText());
//           js.executeScript("arguments[0].click();",selectPicture);
           selectPicture.sendKeys("/Users/Josephcanlas/Documents/FinalActivity/src/main/resources/samplePhoto.jpg");
       }

       public void userLocation () throws InterruptedException {


           userAddress.sendKeys("123 Playground Street");
//           js.executeScript("arguments[0].click();",stateField);
           js.executeScript("window.scrollBy(0,550)", "");

           stateField.click();

           waitForWebElementToAppear(stateUserOptionNCR);
           js.executeScript("arguments[0].click();",stateUserOptionNCR);
           System.out.println(stateField.getText());
           Thread.sleep(4000);
           cityField.click();
           js.executeScript("arguments[0].click();",cityListOption);
           System.out.println(cityField.getText());

       }

    public void submitModal()  {

        submitBtn.click();
        Actions builder = new Actions(driver);
        builder.moveToElement(submitBtn).perform();

        System.out.println(successModalTitle.getText());
        for (int i = 0; i < SuccessModalResults.size(); i++) {
            System.out.println(SuccessModalResults.get(i).getText());
        }

        js.executeScript("arguments[0].click();", closeBtn);

    }
   }

