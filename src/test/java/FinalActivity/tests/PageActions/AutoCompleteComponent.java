package FinalActivity.tests.PageActions;

import FinalActivity.tests.PageObjects.AutoCompletePageObjects;
import TestComponents.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Arrays;
@Epic("Auto Complete")
@Feature("Widgets")
public class AutoCompleteComponent extends BaseTest {

    JavascriptExecutor js = (JavascriptExecutor) driver;
    private static final Logger log = LoggerFactory.getLogger(AlertsComponent.class);
    AutoCompletePageObjects autoCompleteObjects = new AutoCompletePageObjects(driver);

@Test
@Description("Verify if home page is accessible")
    public void goToHomePage()
    {
        log.info("Navigate to DemoQA site");
        Allure.step("Navigate to home page");
        driver.get("https://demoqa.com/");
        log.info("Assert URL");
        assert driver.getCurrentUrl().equalsIgnoreCase("https://demoqa.com/");
        log.error("Unable to assert URL");
        javaScrollDown(autoCompleteObjects.widgets);
        autoCompleteObjects.widgets.click();
        javaScrollDown(autoCompleteObjects.autoComplete);
        autoCompleteObjects.autoComplete.click();
        log.info("Navigate to Autocomplete activity page");
        Allure.step("Navigate to autocomplete activity page");

    }
    @Test
    @Description("Verify if auto complete activity page is correct")
    public void goToForm(){

        String PageTitle = "DEMOQA";
        assertTitle(PageTitle);
        waitForWebElementToAppear(autoCompleteObjects.sectionTitle);
        System.out.println(autoCompleteObjects.sectionTitle.getText());
        Allure.step("Verify that activity page is correct");
        assert autoCompleteObjects.sectionTitle.getText().equalsIgnoreCase("Auto Complete");

    }
@Test
@Description("Verify that I can enter multiple color")
    public void multipleColorNames () throws InterruptedException {
        js.executeScript("window.scrollBy(0,350)", "");
            Allure.step("Verify that I can type on the text field and suggestions will display.");
            log.info("Verify that I can type on the text field and suggestions will display.");
        assert autoCompleteObjects.typeMultipleColorNames.getText().equals("Type multiple color names");
        autoCompleteObjects.typeMultipleColorNamesInput.sendKeys("R");
            saveScreenshot();
        Thread.sleep(5000);
        autoCompleteObjects.typeMultipleColorNamesInput.sendKeys(Keys.ENTER);

        System.out.println(autoCompleteObjects.typeMultipleColorNames.getText());
            saveScreenshot();
        for (int i = 0; i < 3 ; i++) {

            autoCompleteObjects.typeMultipleColorNamesInput.sendKeys("R");
                Thread.sleep(5000);
            autoCompleteObjects.typeMultipleColorNamesInput.sendKeys(Keys.ENTER);
        }
        for (int i = 0; i < autoCompleteObjects.enteredValuesList.size() ; i++) {

            String[] name = autoCompleteObjects.enteredValuesList.get(i).getText().split("-");
            String expectedText = Arrays.toString(name);
            String formattedName = name[0].trim();
            System.out.println(formattedName);
            assert formattedName.equalsIgnoreCase(expectedText);

            saveScreenshot();
        }

    }

    public void singleColorName () throws InterruptedException {

        Allure.step("Verify that I can type on the text field and one suggestion will display.");
        assert autoCompleteObjects.autoCompleteLabelSingle.getText().equals("Type single color name");
        System.out.println(autoCompleteObjects.autoCompleteLabelSingle.getText());
        Thread.sleep(5000);
        autoCompleteObjects.autoCompleteInputSingle.click();
        autoCompleteObjects.autoCompleteInputSingle.sendKeys("B");
        Thread.sleep(5000);
        autoCompleteObjects.autoCompleteInputSingle.sendKeys(Keys.ENTER);
        saveScreenshot();
        System.out.println(autoCompleteObjects.autoCompleteInputSingle.getText());

        System.out.println(autoCompleteObjects.singleEnterValue.getText());
    }

}
