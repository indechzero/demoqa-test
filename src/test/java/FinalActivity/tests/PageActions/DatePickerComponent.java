package FinalActivity.tests.PageActions;

import FinalActivity.tests.PageObjects.datePickerPageObjects;
import TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DatePickerComponent extends BaseTest {

    datePickerPageObjects dateObjects = new datePickerPageObjects(driver);


    @Given("that I navigated to the date activity from the homepage")
    public void goToHomePage()
    {
        driver.get("https://demoqa.com/");
        javaScrollDown(dateObjects.widgets);
        dateObjects.widgets.click();
        javaScrollDown(dateObjects.datePicker);
        dateObjects.datePicker.click();
    }

    public void goToDatePickerPage() {


        String ActualTitle = driver.getTitle();
        String PageTitle = "DEMOQA";

       assert ActualTitle.equalsIgnoreCase(PageTitle);

        assert dateObjects.sectionTitle.getText().equalsIgnoreCase("Date Picker");
        System.out.println(dateObjects.sectionTitle.getText());
    }


    public void typeDate() {

        System.out.println(dateObjects.selectDateLabel.getText());
        waitForWebElementToAppear(dateObjects.dateFieldInput);
        waitForWebElementToBeEnabled(dateObjects.dateFieldInput);
        assert dateObjects.selectDateLabel.getText().equals("Select Date");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement inputDate = dateObjects.dateFieldInput;

        wait.until(ExpectedConditions.visibilityOf(inputDate));
        inputDate.click();

            for (int i = 0; i < 10; i++)
                {
                    inputDate.sendKeys(Keys.BACK_SPACE);
                }

        inputDate.sendKeys("01/29/2000");
        inputDate.sendKeys(Keys.RETURN);
        System.out.println("Select Date Field Text:" + ' ' + inputDate.getAttribute("value"));
    }

    public void selectDate() {

        waitForWebElementToAppear(dateObjects.dateAndTimeLabel);
        System.out.println(dateObjects.dateAndTimeLabel.getText());
        waitForWebElementToAppear(dateObjects.dateAndTimeInput);
        waitForWebElementToBeEnabled(dateObjects.dateAndTimeInput);

        assert dateObjects.dateAndTimeLabel.getText().equals("Date And Time");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement inputDateTime = dateObjects.dateAndTimeInput;

        wait.until(ExpectedConditions.visibilityOf(inputDateTime));
        javaScriptClick(inputDateTime);

        for (int i = 0; i < 50; i++)
        {
            inputDateTime.sendKeys(Keys.BACK_SPACE);
        }

        inputDateTime.sendKeys("01/29/2000 7:00 PM");
        inputDateTime.sendKeys(Keys.RETURN);
        System.out.println("Select Date Time Field Text:" + ' ' + inputDateTime.getAttribute("value"));
    }

}
