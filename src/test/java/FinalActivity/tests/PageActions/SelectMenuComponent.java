package FinalActivity.tests.PageActions;

import FinalActivity.tests.PageObjects.selectMenuPageObjects;
import TestComponents.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectMenuComponent extends BaseTest {

    private final selectMenuPageObjects selectPageObj = new selectMenuPageObjects(driver);

    public void goToHomePage()
    {
        driver.get("https://demoqa.com/");
        javaScrollDown(selectPageObj.widgets);
        selectPageObj.widgets.click();
        selectPageObj.selectMenu.click();
    }


    public void goToSelectMenuPage() {

        String ActualTitle = driver.getTitle();
        String PageTitle = "DEMOQA";

        assert ActualTitle.equalsIgnoreCase(PageTitle);
        System.out.println(selectPageObj.sectionTitle.getText());

        assert selectPageObj.sectionTitle.getText().equalsIgnoreCase("Select Menu");

    }

    public void clickValueField () throws InterruptedException {

        System.out.println(selectPageObj.selectValueLabel.getText());
        assert selectPageObj.selectValueLabel.getText().equalsIgnoreCase("Select Value");
        selectPageObj.selectValueField.click();

        for (int i = 1; i <= selectPageObj.selectOneDropdownList.size(); i++) {

            // Select First Group
            System.out.println(selectPageObj.selectOneDropdownList.get(i-1).getText());
        }
    }

    public void clickOneValue(){

        selectPageObj.selectValueFirstGroupOptions.getFirst().click();
        System.out.println("Selected Option:" + " " + selectPageObj.selectValueField.getText());
        assert selectPageObj.selectValueField.getText().equalsIgnoreCase("Group 1, option 1");

}

    public void clickSelectOneField (){

        System.out.println(selectPageObj.selectOneLabel.getText());
        assert selectPageObj.selectOneLabel.getText().equalsIgnoreCase("Select One");
        selectPageObj.selectOneField.click();

        for (int i = 1; i < selectPageObj.selectOneOptions.size(); i++) {
            System.out.println(selectPageObj.selectOneOptions.get(i-1).getText());
            waitForWebElementListToAppear(selectPageObj.selectOneOptions);
        }
        selectPageObj.selectOneOptions.get(1).click();
        System.out.println(selectPageObj.selectOneField.getText());
        assert selectPageObj.selectOneField.getText().equalsIgnoreCase("Mr.");

    }

    public void clickOldStyleField (){

        System.out.println(selectPageObj.oldStyleSelectMenuLabel.getText());
        assert selectPageObj.oldStyleSelectMenuLabel.getText().equalsIgnoreCase("Old Style Select Menu");
        selectPageObj.oldStyleSelectMenuField.click();

        Select oldStyleSelect = new Select(selectPageObj.oldStyleSelectMenuField);
        List <WebElement> options = oldStyleSelect.getOptions();
        System.out.println("Number of Options:" + options.size());
        oldStyleSelect.getFirstSelectedOption().click();
            assert oldStyleSelect.getFirstSelectedOption().getText().equalsIgnoreCase("Red");

    }
    public void clickMultiSelectField (){

        System.out.println(selectPageObj.multiSelectLabel.getText());
        assert selectPageObj.multiSelectLabel.getText().equalsIgnoreCase("Multiselect drop down");
        selectPageObj.multiSelectField.click();

        for (int i = 1; i <= selectPageObj.multiSelectOptions.size(); i++) {

//            waitForWebElementListToAppear(multiSelectOptions);
            System.out.println(selectPageObj.multiSelectOptions.get(i-1).getText());
            selectPageObj.multiSelectOptions.get(i-1).click();
        }
    }

    public void clickStandardMultiSelect (){

        System.out.println(selectPageObj.standardMultiSelectLabel.getText());
            assert selectPageObj.standardMultiSelectLabel.getText().equalsIgnoreCase("Standard multi select");

        Select standardMultiSelect = new Select(selectPageObj.standardMultiSelectOptions);
         List <WebElement> options = standardMultiSelect.getOptions();

            for (WebElement e : options) {
                System.out.println(e.getText());
            }

        standardMultiSelect.selectByVisibleText("Volvo");
        System.out.println("Number of Options:" + options.size());
        System.out.println(standardMultiSelect.getFirstSelectedOption().getText());
            assert standardMultiSelect.getFirstSelectedOption().getText().equals("Volvo");

    }

}



