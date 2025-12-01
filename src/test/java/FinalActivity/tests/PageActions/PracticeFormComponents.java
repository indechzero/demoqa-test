package FinalActivity.tests.PageActions;

import FinalActivity.tests.PageObjects.practiceFormPageObjects;
import TestComponents.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PracticeFormComponents extends BaseTest {

    practiceFormPageObjects practicePgObjects = new practiceFormPageObjects(driver);


    JavascriptExecutor js = (JavascriptExecutor) driver;


    public void goToHomePage()
    {
        driver.get("https://demoqa.com/");
        practicePgObjects.practiceFormNavigation.click();
        practicePgObjects.practiceForm.click();
    }

public void goToPracticeForm(){
    String PageTitle = "DEMOQA";
    assertTitle(PageTitle);

    System.out.println(practicePgObjects.sectionTitle.getText());
    assert practicePgObjects.sectionTitle.getText().equalsIgnoreCase("Practice Form");

   }
    public void userDetails (String firstName, String lastName, String email, String userNumber){

        System.out.println(practicePgObjects.lblFirstName.getText());
        assert practicePgObjects.lblFirstName.getText().equalsIgnoreCase("Name");
        practicePgObjects.firstName.sendKeys(firstName);
        practicePgObjects.lastName.sendKeys(lastName);

        System.out.println(practicePgObjects.firstName.getAttribute("value"));
        System.out.println(practicePgObjects.lastName.getAttribute("value"));
            assert practicePgObjects.firstName.getAttribute("value").equalsIgnoreCase(firstName);
            assert practicePgObjects.firstName.getAttribute("value").equalsIgnoreCase(lastName);

        practicePgObjects.emailField.sendKeys(email);
            assert practicePgObjects.emailField.getText().equalsIgnoreCase(email);
            System.out.println(practicePgObjects.emailField.getAttribute("value"));

        System.out.println(practicePgObjects.genderLabel.getText());

        js.executeScript("arguments[0].click();", practicePgObjects.maleRadio);
        System.out.println(practicePgObjects.maleRadio.getText());
            assert practicePgObjects.maleRadio.isSelected();

        System.out.println(practicePgObjects.userNumberLabel.getText());
        practicePgObjects.userNumberField.sendKeys(userNumber);
            assert practicePgObjects.userNumberField.getText().equalsIgnoreCase(userNumber);

        System.out.println(practicePgObjects.userNumberField.getAttribute("value"));
    }

    public void birthDate() {

        System.out.println(practicePgObjects.lblDate.getText());
        js.executeScript("arguments[0].click();", practicePgObjects.birthDateField);

        js.executeScript("arguments[0].click();", practicePgObjects.monthSelect);
        Select selectMonth = new Select(practicePgObjects.monthSelect);
        selectMonth.selectByVisibleText("January");
        js.executeScript("arguments[0].click();", practicePgObjects.birthMonth);

        Select selectYear = new Select(practicePgObjects.birthYear);
        selectYear.selectByIndex(101);

        js.executeScript("arguments[0].click();", practicePgObjects.birthDay);

//        js.executeScript("arguments[0].click();", practicePgObjects.birthDateField);
//        js.executeScript("arguments[0].click();", practicePgObjects.monthSelect);
//        js.executeScript("arguments[0].click();", practicePgObjects.birthMonth);
//        js.executeScript("arguments[0].click();", practicePgObjects.birthYear);
//        js.executeScript("arguments[0].click();", practicePgObjects.birthDay);

        System.out.println(practicePgObjects.birthDateField.getAttribute("value"));

    }

   public void practiceHobbiesSubj() throws InterruptedException {

       js.executeScript("window.scrollBy(0,550)", "");
       System.out.println(practicePgObjects.subjLabel.getText());
       waitForWebElementToAppear(practicePgObjects.subjField);
       practicePgObjects.subjField.sendKeys("com");

       Thread.sleep(4000);
       for (WebElement option : practicePgObjects.subjAutoComplete) {
           if (option.getText().equalsIgnoreCase("Computer Science")) {
               option.click();
               break;
           }
       }

       System.out.println(practicePgObjects.hobbies.getText());


       for (int i = 0; i < practicePgObjects.HobbyCheckBoxes.size(); i++) {
           js.executeScript("arguments[0].click();", practicePgObjects.HobbyCheckBoxes.get(i));
       }
       System.out.println("Select All Hobbies:");
       for (int i = 0; i < practicePgObjects.HobbyCheckBoxes.size(); i++) {
           assert practicePgObjects.HobbyCheckBoxes.get(i).isSelected();
       }
   }
       public void pictureUpload () {

           System.out.println(practicePgObjects.selectPictureLabel.getText());
//           js.executeScript("arguments[0].click();",selectPicture);
           practicePgObjects.selectPicture.sendKeys("/Users/Josephcanlas/Documents/FinalActivity/src/main/resources/samplePhoto.jpg");
       }

       public void userLocation () throws InterruptedException {


           practicePgObjects.userAddress.sendKeys("123 Playground Street");
//           js.executeScript("arguments[0].click();",stateField);
           js.executeScript("window.scrollBy(0,550)", "");

           practicePgObjects.stateField.click();

           waitForWebElementToAppear(practicePgObjects.stateUserOptionNCR);
           js.executeScript("arguments[0].click();",practicePgObjects.stateUserOptionNCR);
           System.out.println(practicePgObjects.stateField.getText());
           Thread.sleep(4000);
           practicePgObjects.cityField.click();
           js.executeScript("arguments[0].click();", practicePgObjects.cityListOption);
           System.out.println(practicePgObjects.cityField.getText());

       }

    public void submitModal()  {

        practicePgObjects.submitBtn.click();
        Actions builder = new Actions(driver);
        builder.moveToElement(practicePgObjects.submitBtn).perform();

        System.out.println(practicePgObjects.successModalTitle.getText());
        for (int i = 0; i < practicePgObjects.SuccessModalResults.size(); i++) {
            System.out.println(practicePgObjects.SuccessModalResults.get(i).getText());
        }

        js.executeScript("arguments[0].click();", practicePgObjects.closeBtn);

    }
   }

