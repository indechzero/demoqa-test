package FinalActivity.tests.PageActions;

import FinalActivity.tests.PageObjects.selectablePageObjects;
import TestComponents.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.Color;

public class SelectableTestComponents extends BaseTest {

  selectablePageObjects selectPgObjects = new selectablePageObjects(driver);


    JavascriptExecutor js = (JavascriptExecutor) driver;

    public void goToHomePage()
    {
        driver.get("https://demoqa.com/");
        javaScrollDown(selectPgObjects.interactionsCard);
        selectPgObjects.interactionsCard.click();
        javaScrollDown(selectPgObjects.selectable);
        selectPgObjects.selectable.click();
    }


public void goToSelectablePage() {
    driver.manage().window().maximize();

    String PageTitle = "DEMOQA";

    assertTitle(PageTitle);

    System.out.println(selectPgObjects.sectionTitle.getText());
    assert selectPgObjects.sectionTitle.getText().equalsIgnoreCase("Selectable");
}
    public void selectListPage () {


        for (int i = 1; i <= selectPgObjects.selectableCount.size(); i++) {

            js.executeScript("arguments[0].click();", selectPgObjects.selectableCount.get(i - 1));
            System.out.println(selectPgObjects.selectableCount.get(i - 1).getText());
            System.out.print(i + " element is selected\t--");

            String highlightColor = selectPgObjects.selectableCount.get(i - 1).getCssValue("background-color");
            String hex = Color.fromString(highlightColor).asHex();


//            System.out.println("The color of the selectables when clicked is" + hex);
            assert hex.equalsIgnoreCase("#007bff");

        }

        for (int i = 1; i <= selectPgObjects.selectableCount.size(); i++) {


            js.executeScript("arguments[0].click();", selectPgObjects.selectableCount.get(i - 1));
            System.out.println(selectPgObjects.selectableCount.get(i - 1).getText());

            System.out.print(i + " element is deselected\t--");
            System.out.println("pass");

            String unselectedColor = selectPgObjects.selectableCount.get(i - 1).getCssValue("background-color");
            String hex = Color.fromString(unselectedColor).asHex();

            System.out.println("Color has changed:");
         assert hex.equalsIgnoreCase("#ffffff");
        }

    }

        public void selectGridPage () {
            selectPgObjects.gridTab.click();

        for (int i = 1; i <= selectPgObjects.selectableGrid.size(); i++)
        {

            js.executeScript("arguments[0].click();", selectPgObjects.selectableGrid.get(i-1));
            System.out.println(selectPgObjects.selectableGrid.get(i-1).getText());

        }

}

    }


