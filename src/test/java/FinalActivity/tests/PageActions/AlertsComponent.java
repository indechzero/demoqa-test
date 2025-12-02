package FinalActivity.tests.PageActions;

import FinalActivity.tests.PageObjects.AlertsPageObjects;
import TestComponents.BaseTest;
import io.qameta.allure.Allure;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class AlertsComponent extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(AlertsComponent.class);
    JavascriptExecutor js = (JavascriptExecutor) driver;

    private final AlertsPageObjects alertsObjects = new AlertsPageObjects(driver);

    public void goToHomePage()
    {
        log.info("Navigate to DemoQA site");
        driver.get("https://demoqa.com/");
        log.info("Assert URL");
        assert driver.getCurrentUrl().equalsIgnoreCase("https://demoqa.com/");
        log.error("Unable to assert URL");
        javaScrollDown(alertsObjects.alertFrameWindowsbtn);
        alertsObjects.alertFrameWindowsbtn.click();
        alertsObjects.alertMenuBtn.click();

    }


    public  void goToAlertsPage(){
        log.info("Navigate to Alerts page");
        Allure.step("Navigate to Alerts page");

        String ActualTitle = driver.getTitle();
        String PageTitle = "DEMOQA";
        assert ActualTitle.equalsIgnoreCase(PageTitle);

        System.out.println(alertsObjects.sectionTitle.getText());
        assert alertsObjects.sectionTitle.getText().equalsIgnoreCase("Alerts");
   }

    public void firstAlert(){
        log.info("Verify first Alert");
        Allure.step("Verify first Alert");

        alertsObjects.alertButton.click();
        alertVerification();
        Alert alert = driver.switchTo().alert();
        //Store the alert text in a variable and verify it
        String text = alert.getText();
        log.info("Assert first Alert");
       assert text.equalsIgnoreCase("You clicked a button");
        alert.dismiss();
        System.out.println(text);

    }

    public void secondAlertButton (){

        js.executeScript("window.scrollBy(0,450)", "");
        log.info("Verify Second Alert");
        Allure.step("Verify Second Alert");

        alertsObjects.TimerAlertButton.click();
        alertVerification();
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        System.out.println(text);

        alert.accept();
    }

    public void thirdAlertButton(){

        log.info("Verify Third Alert");
        Allure.step("Verify Third Alert");

        alertsObjects.confBtn.click();
        alertVerification();
        Alert alert = driver.switchTo().alert();

        alert.accept();

        System.out.println(alertsObjects.okayResult.getText());
     assert alertsObjects.okayResult.getText().equalsIgnoreCase("You selected Ok");

    }
    public void fourthAlertButton(){
        log.info("Verify Fourth Alert");
        Allure.step("Verify Fourth Alert");
        alertsObjects.promptButton.click();
        alertVerification();
        Alert alert = driver.switchTo().alert();

        log.info("Assert message input");
        Allure.step("Assert message input");

        String message = "Jane Doe";
        alert.sendKeys(message);
        String text = alert.getText();
        System.out.println(text);

        alert.accept();

        System.out.println(alertsObjects.promptResult.getText());
       assert alertsObjects.promptResult.getText().equalsIgnoreCase("You entered Jane Doe");

    }


    }

