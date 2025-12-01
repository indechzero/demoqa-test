package FinalActivity.tests.PageActions;

import FinalActivity.tests.PageObjects.LinksPageObjects;
import TestComponents.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

public class LinksComponent extends BaseTest {

        LinksPageObjects linksObject = new LinksPageObjects(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

    public void goToHomePageLinks()
    {
        driver.get("https://demoqa.com/");
        assert driver.getCurrentUrl().equalsIgnoreCase("https://demoqa.com/");
        linksObject.elementsNavButton.click();
        linksObject.linksSection.click();
    }

    public void goLinksPage() {

    String PageTitle = "DEMOQA";

    assertTitle(PageTitle);
    System.out.println(linksObject.sectionTitle.getText());
        assert linksObject.sectionTitle.getText().equalsIgnoreCase("Links");


}
    public void clickNewWindowLinks () throws InterruptedException {

        js.executeScript("arguments[0].click();", linksObject.simpleLink);
        Thread.sleep(3000);
        js.executeScript("arguments[0].click();", linksObject.dynamicLink);
        Thread.sleep(8000);
        Object[] windowHandles = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);
        driver.close();

        driver.switchTo().window((String) windowHandles[2]);
        driver.close();
        //Switch back to the old tab or window
        driver.switchTo().window((String) windowHandles[0]);

        waitForWebElementToAppear(linksObject.sectionTitle);

        js.executeScript("window.scrollBy(0,500)", " ");
        Thread.sleep(8000);
    }

    public void clickLinksAPI() throws InterruptedException {

        for (int i = 0; i < linksObject.links.size() - 1; i++) {

            js.executeScript("arguments[0].click();", linksObject.links.get(i));
            System.out.println(linksObject.links.get(i).getText());
            Thread.sleep(4000);
            System.out.println(linksObject.linkResponseMsg.getText());
            assertLinkMessage(linksObject.linkResponseMsg, linksObject.linkResponseMsg.getText());


            String errorCode = linksObject.links.get(i).getText();
            String errorMessage = linksObject.linkResponseMsg.getText();

            // Perform assertions
            Assert.assertTrue(errorMessage.contains(errorCode));

        }

    }
    }