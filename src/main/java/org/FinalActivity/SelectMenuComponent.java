package org.FinalActivity;

import org.AbstractComponent.abstractComponent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectMenuComponent extends abstractComponent {

    @FindBy(css=".text-center")
    static WebElement sectionTitle;

    @FindBy(xpath="//*[@id=\"selectMenuContainer\"]/div[1]/div")
    @CacheLookup public static WebElement selectValueLabel;

    @FindBy(xpath="//*[@id=\"withOptGroup\"]/div/div[1]")
    @CacheLookup public static WebElement selectValueField;

    @FindBy(xpath="//*[@id=\"withOptGroup\"]/div[2]/div/div[1]/div[2]/div")
    @CacheLookup public static List <WebElement> selectValueFirstGroupOptions;


    @FindBy(xpath="//*[@id=\"selectMenuContainer\"]/div[3]/div")
    @CacheLookup public WebElement selectOneLabel;

    @FindBy(xpath="//*[@id=\"selectOne\"]/div/div[1]")
    @CacheLookup public WebElement selectOneField;

    @FindBy(xpath = "//*[@id=\"selectOne\"]/div[2]/div/div/div//*")
    @CacheLookup public  List <WebElement> selectOneOptions;

//    @FindBy(xpath = "//*[@id=\"withOptGroup\"]/div[2]/div//*")
//    @CacheLookup public  List <WebElement> selectOneDropdownList;

    @FindBy(xpath = "//*[@id=\"withOptGroup\"]/div[2]//div/div/child::*")
    @CacheLookup public  List <WebElement> selectOneDropdownList;

    @FindBy(xpath="//div[contains(text(),'Old Style Select Menu')]")
    @CacheLookup public WebElement oldStyleSelectMenuLabel;

    @FindBy(xpath="//*[@id=\"oldSelectMenu\"]")
    @CacheLookup public WebElement oldStyleSelectMenuField;

    @FindBy(xpath="//*[@id=\"selectMenuContainer\"]/div[7]/div/p/b")
    @CacheLookup public WebElement multiSelectLabel;

    @FindBy(xpath="//*[@id=\"selectMenuContainer\"]/div[7]/div/div/div/div[1]")
    @CacheLookup public WebElement multiSelectField;

    @FindBy(xpath="//*[@id=\"selectMenuContainer\"]/div[7]/div/div/div[2]/div//*")
    @CacheLookup public List<WebElement> multiSelectOptions;

    @FindBy(xpath="//*[@id=\"selectMenuContainer\"]/div[8]/div/p/b")
    @CacheLookup public WebElement standardMultiSelectLabel;

    @FindBy(xpath="//*[@id=\"cars\"]")
    @CacheLookup public WebElement  standardMultiSelectOptions;



public void goToSelectMenuPage() {
    driver.get("https://demoqa.com/select-menu");

    String ActualTitle = driver.getTitle();
    String PageTitle = "DEMOQA";

    assert ActualTitle.equalsIgnoreCase(PageTitle);
    System.out.println(sectionTitle.getText());

   assert sectionTitle.getText().equalsIgnoreCase("Select Menu");

}

public void clickValueField () throws InterruptedException {

    System.out.println(selectValueLabel.getText());
    assert selectValueLabel.getText().equalsIgnoreCase("Select Value");
    selectValueField.click();

    for (int i = 1; i <= selectOneDropdownList.size(); i++) {

        // Select First Group
        System.out.println(selectOneDropdownList.get(i-1).getText());
//        waitForWebElementListToAppear(selectValueFirstGroupOptions);
    }

//    for (int i = 1; i <= selectValueSecondGroupOptions.size(); i++) {
//
//        // Select First Group
//        System.out.println(selectValueSecondGroupOptions.get(i-1).getText());
//        waitForWebElementListToAppear(selectValueSecondGroupOptions);
//    }

//    System.out.println(ThirdValueGroupOption1.getText());
//    System.out.println(ThirdValueGroupOption2.getText());
}

public void clickOneValue(){

    selectValueFirstGroupOptions.getFirst().click();
    System.out.println("Selected Option:" + " " + selectValueField.getText());
    assert selectValueField.getText().equalsIgnoreCase("Group 1, option 1");

}

    public void clickSelectOneField (){

        System.out.println(selectOneLabel.getText());
        assert selectOneLabel.getText().equalsIgnoreCase("Select One");
        selectOneField.click();

        for (int i = 1; i < selectOneOptions.size(); i++) {
            System.out.println(selectOneOptions.get(i-1).getText());
            waitForWebElementListToAppear(selectOneOptions);
        }
        selectOneOptions.get(1).click();
        System.out.println(selectOneField.getText());
        assert selectOneField.getText().equalsIgnoreCase("Mr.");

    }

public void clickOldStyleField (){

    System.out.println(oldStyleSelectMenuLabel.getText());
    assert oldStyleSelectMenuLabel.getText().equalsIgnoreCase("Old Style Select Menu");
    oldStyleSelectMenuField.click();

    Select oldStyleSelect = new Select(oldStyleSelectMenuField);
    List <WebElement> options = oldStyleSelect.getOptions();
    System.out.println("Number of Options:" + options.size());
    oldStyleSelect.getFirstSelectedOption().click();
   assert oldStyleSelect.getFirstSelectedOption().getText().equalsIgnoreCase("Red");

}
    public void clickMultiSelectField (){

        System.out.println(multiSelectLabel.getText());
        assert multiSelectLabel.getText().equalsIgnoreCase("Multiselect drop down");
        multiSelectField.click();

        for (int i = 1; i <= multiSelectOptions.size(); i++) {

//            waitForWebElementListToAppear(multiSelectOptions);
            System.out.println(multiSelectOptions.get(i-1).getText());
            multiSelectOptions.get(i-1).click();
        }
    }

    public void clickStandardMultiSelect (){

        System.out.println(standardMultiSelectLabel.getText());
        assert standardMultiSelectLabel.getText().equalsIgnoreCase("Standard multi select");

        Select standardMultiSelect = new Select(standardMultiSelectOptions);
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



