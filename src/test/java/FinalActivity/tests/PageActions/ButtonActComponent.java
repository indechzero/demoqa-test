package FinalActivity.tests.PageActions;

import TestComponents.BaseTest;
import FinalActivity.tests.PageObjects.ButtonPageObjects;

import io.qameta.allure.Allure;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ButtonActComponent extends BaseTest {

    JavascriptExecutor js = (JavascriptExecutor) driver;

    ButtonPageObjects btnPageObjects = new ButtonPageObjects(driver);
    private static final Logger log = LoggerFactory.getLogger(AlertsComponent.class);

    public void goToHomePage() {
        driver.get("https://demoqa.com/");
        log.info("Navigate to DemoQA site");
        Allure.step("Navigate to home page");
        assert driver.getCurrentUrl().equalsIgnoreCase("https://demoqa.com/");
        btnPageObjects.elementsNavButton.click();
        btnPageObjects.buttonMenuItem.click();
    }

    public void gotoButtonsPage() {

        String PageTitle = "DEMOQA";
        assertTitle(PageTitle);

        System.out.println(btnPageObjects.sectionTitle.getText());
        assert btnPageObjects.sectionTitle.getText().equalsIgnoreCase("Buttons");

    }


    public void doubleClick() {

        btnPageObjects.act.doubleClick(btnPageObjects.dblClick).perform();

        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(8));
        waitForElementToAppear(btnPageObjects.dblClickMsg);
        textElementAssertion(btnPageObjects.dblClickMsg, "You have done a double click");
        System.out.println(driver.findElement(btnPageObjects.dblClickMsg).getText());
    }

    public void rightClick() {
        btnPageObjects.act.contextClick(btnPageObjects.rightClkBtn).perform();
        waitForElementToAppear(btnPageObjects.rightClkMsg);
        textElementAssertion(btnPageObjects.rightClkMsg, "You have done a right click");
        System.out.println(driver.findElement(btnPageObjects.rightClkMsg).getText());
    }

    public void dynamicButton() {

        btnPageObjects.dynamicBtn.click();
        waitForElementToAppear(btnPageObjects.dynamicClkMsg);
        textElementAssertion(btnPageObjects.dynamicClkMsg, "You have done a dynamic click");
        System.out.println(driver.findElement(btnPageObjects.dynamicClkMsg).getText());

    }

}

