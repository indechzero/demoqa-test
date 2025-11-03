package FinalActivity.tests.PageActions;

import FinalActivity.tests.PageObjects.CheckBoxPageObjects;
import TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CheckBoxComponent extends BaseTest {

    CheckBoxPageObjects chkBoxPageObjects = new CheckBoxPageObjects(driver);

    @Given("that I navigated to the checkbox activity from the homepage")
    public void goToHomePage()
    {
    driver.get("https://demoqa.com/");
        javaScrollDown(chkBoxPageObjects.elementsNavButton);
        waitForWebElementToAppear(chkBoxPageObjects.elementsNavButton);
    chkBoxPageObjects.elementsNavButton.click();
    chkBoxPageObjects.checkBoxMenuBtn.click();
    }


    public void goToForm(){

        String ActualTitle = driver.getTitle();
        String PageTitle = "DEMOQA";

        assert ActualTitle.equalsIgnoreCase(PageTitle);
        System.out.println(chkBoxPageObjects.sectionTitle.getText());
        assert chkBoxPageObjects.sectionTitle.getText().equalsIgnoreCase("Check Box");
        javaScrollDown(chkBoxPageObjects.homeCheckBox);
    }

    public void selectAll() throws InterruptedException {

        assert chkBoxPageObjects.homeCheckBox.isEnabled();
        chkBoxPageObjects.homeCheckBox.click();

        List<WebElement> selectedElements = driver.findElements(By.xpath("//*[@id=\"result\"]/span"));

        // Retrieve file name span
        for(WebElement e : selectedElements){
            String[] name = e.getText().split("-");
            String formattedName = name[0].trim();
            System.out.println(formattedName);
        }

        Thread.sleep(5000L);

        //Unselect Home Checkbox
        chkBoxPageObjects.homeCheckBox.click();
        assert !chkBoxPageObjects.homeCheckBox.isSelected();
    }

    public void CheckBoxTest() throws InterruptedException {

        //click plus button to reveal all
        chkBoxPageObjects.plusButton.click();

        List<WebElement> boxLabels = driver.findElements(By.xpath("*//span[@class=\"rct-title\"]"));

        Thread.sleep(2000L);

        // select checkboxes one by one
        for (int i = 0; i < boxLabels.size(); i++) {

            boxLabels.get(i).click();
                assert !boxLabels.get(i).isSelected();
            String[] name = boxLabels.get(i).getText().split("-");
            String expectedText = Arrays.toString(name);
            String formattedName = name[0].trim();
            System.out.println(formattedName);
            assert formattedName.equalsIgnoreCase(expectedText);

        }
    }
        public void getResults() throws InterruptedException {

            List<WebElement> selectedElements = driver.findElements(By.xpath("//*[@id=\"result\"]/span"));

            List<String> lst1 = new ArrayList<>();
            for(WebElement e : selectedElements){
                String[] name = e.getText().split("-");
                String formattedName = name[0].trim();
                System.out.println(formattedName);
            }

            assert chkBoxPageObjects.collapseAll.isEnabled();
            chkBoxPageObjects.collapseAll.click();
            System.out.println("Checkbox items are collapsed");


        }


    }


