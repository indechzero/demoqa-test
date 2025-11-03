package FinalActivity.tests.PageActions;

import FinalActivity.tests.PageObjects.WindowsActPageObjects;
import TestComponents.BaseTest;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;

import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class windowsActivityComponents extends BaseTest {

    private static final WindowsActPageObjects windowPageObjects = new WindowsActPageObjects(driver);

    public static void goToHomePage()
    {
        driver.get("https://demoqa.com/");
        assert driver.getCurrentUrl().equalsIgnoreCase("https://demoqa.com/");
        javaScrollDown(windowPageObjects.alertFrameWindowsbtn);
        windowPageObjects.alertFrameWindowsbtn.click();
        windowPageObjects.browserWindows.click();

    }
    public static void verifySectionTitle()
    {
        driver.manage().window().maximize();

        String PageTitle = driver.getTitle();
        String ActualPageTitle = "DEMOQA";
        System.out.println(windowPageObjects.sectionTitle.getText());
        assertEquals(PageTitle,ActualPageTitle, "Page title does not match the expected value");

        String expectedSectionTitle = "Browser Windows";
        String actualSectionTitle = windowPageObjects.sectionTitle.getText();

        System.out.println(windowPageObjects.sectionTitle.getText());
        assertEquals(actualSectionTitle,expectedSectionTitle, "Section title does not match the expected value");


    }

    public static void windowHandle() throws InterruptedException {

        String parentWindow = driver.getWindowHandle();

//        List<WebElement> browserWindowButtons = driver.findElements(By.xpath("//div[@id='browserWindows']//div//button"));
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
//                    System.out.println("New Window Title: " + title);
                        System.out.println(title);
//                        waitForBodyTextToAppear(windowPageObjects.bodyText);
//                        System.out.println(windowPageObjects.bodyText.getText());
                        System.out.println("Window/Tab closed");


                    } catch (Exception e) {
                        System.out.println("Error Occurred: " + e.getMessage());
//                        driver.switchTo().window(handle);
                        System.out.println("Switched to window: " + handle);
                        Thread.sleep(2000);

//                        System.out.println(driver.findElement(By.xpath("/html/body")).getText());

                    }
                }
            }
        }

//        driver.switchTo().window(parentWindow);
        Thread.sleep(2000);
        driver.quit();
    }

    public static void windowScrollToElement(WebDriver driver, WebElement element) {
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

