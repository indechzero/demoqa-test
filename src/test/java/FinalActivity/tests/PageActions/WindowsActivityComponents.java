package FinalActivity.tests.PageActions;

import FinalActivity.tests.PageObjects.WindowsActPageObjects;
import TestComponents.BaseTest;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class WindowsActivityComponents extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(WindowsActivityComponents.class);
    private static final WindowsActPageObjects windowPageObjects = new WindowsActPageObjects(driver);

    public static void goToHomePage()
    {
        log.info("Navigate to DemoQA site");
        driver.get("https://demoqa.com/");
        log.error("Unable to assert URL");
        assert driver.getCurrentUrl().equalsIgnoreCase("https://demoqa.com/");
        log.info("Assert URL");
        javaScrollDown(windowPageObjects.alertFrameWindowsbtn);
        windowPageObjects.alertFrameWindowsbtn.click();
        windowPageObjects.browserWindows.click();

    }
    public static void verifySectionTitle()
    {
        driver.manage().window().maximize();

        log.info("Verify Page Title");
        String PageTitle = driver.getTitle();
        String ActualPageTitle = "DEMOQA";
        System.out.println(windowPageObjects.sectionTitle.getText());
        assertEquals(PageTitle,ActualPageTitle, "Page title does not match the expected value");
        log.error("Unable to assert page title");
        String expectedSectionTitle = "Browser Windows";
        String actualSectionTitle = windowPageObjects.sectionTitle.getText();

        System.out.println(windowPageObjects.sectionTitle.getText());
        assertEquals(actualSectionTitle,expectedSectionTitle, "Section title does not match the expected value");


    }

    public static void windowHandle() throws InterruptedException {

        log.info("Verify switching between windows and tabs");

        String parentWindow = driver.getWindowHandle();
        List<WebElement> browserWindowButtons = windowPageObjects.browserWindowsBtnList;

        for (WebElement element : browserWindowButtons) {
            windowScrollToElement(driver, element);
            element.click();
            Thread.sleep(5000);
            driver.switchTo().window(parentWindow);
//            driver.navigate().refresh();
            Thread.sleep(5000);

            driver.switchTo().defaultContent();
            System.out.println("Switched to default content");
        }

        if(driver.getCurrentUrl().contains("https://demoqa.com/browser-windows")) {

            Set<String> windowIterator = driver.getWindowHandles();

            for (String handle : windowIterator) {

                if (!handle.equals(parentWindow)) {
                    try {
                        String title = driver.getTitle();
                        driver.switchTo().window(handle);
                        System.out.println("Switched to window: " + handle);
                        Thread.sleep(2000);
                        System.out.println(title);
                        System.out.println("Window/Tab closed");

                    } catch (Exception e) {
                        System.out.println("Error Occurred: " + e.getMessage());
                        System.out.println("Switched to window: " + handle);
                        Thread.sleep(2000);

                    }
                }
            }
        }
        Thread.sleep(2000);
        driver.quit();
    }

    public static void windowScrollToElement(WebDriver driver, WebElement element) {

        log.info("Scroll to element");

        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
            Thread.sleep(500);
            js.executeScript("window.focus();");
            js.executeScript("arguments[0].focus();", element);
        } catch (Exception e) {
            System.out.println("Error Occurred: " + e.getMessage());
        }
    }

}

