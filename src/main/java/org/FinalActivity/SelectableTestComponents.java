package org.FinalActivity;

import dev.failsafe.internal.util.Assert;
import org.AbstractComponent.abstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class SelectableTestComponents extends abstractComponent {

    @FindBy(css=".text-center")
    static WebElement sectionTitle;

    @FindBy(id="userName")
    WebElement userName;

//    By progressBarPercentage = By.xpath("//*[@id=\"progressBar\"]/div");

    @FindBy(xpath="//*[@id=\"verticalListContainer\"]/li")
    List<WebElement> selectableCount;

    @FindBy(id="demo-tab-grid")
            WebElement gridTab;

    @FindBy(xpath="//*[@id=\"gridContainer\"]/div/li")
    List<WebElement>  selectableGrid;


    JavascriptExecutor js = (JavascriptExecutor) driver;


    public SelectableTestComponents(WebDriver driver)

{
    this.driver = driver;
    PageFactory.initElements(driver,this);

        }

public void goToSelectablePage() {
    driver.manage().window().maximize();
    driver.get("https://demoqa.com/selectable");

    String PageTitle = "DEMOQA";

    assertTitle(PageTitle);

    System.out.println(sectionTitle.getText());

    textElementIsEqual(sectionTitle,"Selectable");

}
    public void selectListPage () {


        for (int i = 1; i <= selectableCount.size(); i++) {

            js.executeScript("arguments[0].click();", selectableCount.get(i - 1));
            System.out.println(selectableCount.get(i - 1).getText());

            String highlightColor = selectableCount.get(i - 1).getCssValue("background-color");
            String hex = Color.fromString(highlightColor).asHex();

            assert hex.equalsIgnoreCase("#007bff");

        }

        for (int i = 1; i <= selectableCount.size(); i++) {


            js.executeScript("arguments[0].click();", selectableCount.get(i - 1));
            System.out.println(selectableCount.get(i - 1).getText());

            System.out.print(i + " element is deselected\t--");
            System.out.println("pass");

            String unselectedColor = selectableCount.get(i - 1).getCssValue("background-color");
            String hex = Color.fromString(unselectedColor).asHex();

         assert hex.equalsIgnoreCase("#ffffff");
        }

    }

        public void selectGridPage () {
            gridTab.click();

        for (int i=1; i<=selectableGrid.size(); i++)
        {

            js.executeScript("arguments[0].click();", selectableGrid.get(i-1));
            System.out.println(selectableGrid.get(i-1).getText());

        }

}

    }


