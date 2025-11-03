package FinalActivity.tests.PageActions;

import FinalActivity.tests.PageObjects.WebTablePageObjects;
import TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

import static org.testng.Assert.assertEquals;

public class WebTableComponents extends BaseTest {

private final WebTablePageObjects webTableObjects = new WebTablePageObjects(driver);

    JavascriptExecutor js = (JavascriptExecutor) driver;

    @Given("that I navigated to the web table activity from the homepage")
    public void goToHomePage()
    {
        driver.get("https://demoqa.com/");
        webTableObjects.elementsNavButton.click();
        webTableObjects.webTables.click();
    }

public void goToWebTablePage() {

    String PageTitle = "DEMOQA";
    String expectedSectionTitle = "Web Tables";
    String actualSectionTitle = webTableObjects.sectionTitle.getText();
    assertTitle(PageTitle);
    System.out.println(webTableObjects.sectionTitle.getText());

    assertEquals(actualSectionTitle,expectedSectionTitle, "Section title does not match the expected value");
    System.out.println(webTableObjects.sectionTitle.getText());


}
    public void addNewRowEntry (String firstName, String lastName, String email, String age, String salary, String department) {

        //Scroll to table (for smaller resolution)
        js.executeScript("window.scrollBy(0,500)", " ");
        js.executeScript("document.querySelector('.rt-table').scrollTop=5000", " ");

        webTableObjects.addNewRecordBtn.click();

        System.out.println(webTableObjects.modalHeader.getText());

        webTableObjects.firstNameField.isDisplayed();
        webTableObjects.firstNameField.sendKeys(firstName);

        webTableObjects.lastNameField.sendKeys(lastName);
        webTableObjects.lastNameField.isDisplayed();

        webTableObjects.userEmailField.isDisplayed();
        webTableObjects.userEmailField.sendKeys(email);

        webTableObjects.ageField.isDisplayed();
        webTableObjects.ageField.sendKeys(age);

        webTableObjects. salaryField.isDisplayed();
        webTableObjects.salaryField.sendKeys(salary);

        webTableObjects.departmentField.isDisplayed();
        webTableObjects.departmentField.sendKeys(department);

        webTableObjects.submitBtn.click();


        //Retrieve each row entry data
        List<WebElement> rowEntry = webTableObjects.rowEntries;

        for (int i = 0; i < rowEntry.size(); i++) {
            System.out.println("Row Number" + "  " + (i));
            System.out.println(rowEntry.get(i).getText());
        }

    }

    public void editNewRowEntry () {

        String ghostText = driver.findElement(webTableObjects.tblSearchBox).getAttribute("placeholder");
        System.out.println(ghostText);
        assert Objects.requireNonNull(ghostText).equalsIgnoreCase("Type to search");
        driver.findElement(webTableObjects.tblSearchBox).sendKeys("Doe");


        for (int i = 0; i < webTableObjects.rowEntryEditBtn.size(); i++) {
            js.executeScript("arguments[0].click();", webTableObjects.rowEntryEditBtn.get(i));
        }

        waitForWebElementToAppear(webTableObjects.editModalBody);

        webTableObjects.editFirstNameField.isDisplayed();
            webTableObjects.editFirstNameField.clear();
                webTableObjects.editFirstNameField.sendKeys("JohnEdit");

        webTableObjects.editLastNameField.isDisplayed();
            webTableObjects.editLastNameField.clear();
                webTableObjects.editLastNameField.sendKeys("DoeEdit");

        webTableObjects.editUserEmailField.isDisplayed();
            webTableObjects.editUserEmailField.clear();
                webTableObjects.editUserEmailField.sendKeys("testemailEDIT@rocketmail.com");

        webTableObjects.editAgeField.isDisplayed();
            webTableObjects.editAgeField.clear();
                webTableObjects.editAgeField.sendKeys("30");

        webTableObjects.editSalaryField.isDisplayed();
            webTableObjects.editSalaryField.clear();
                webTableObjects.editSalaryField.sendKeys("50000");

        webTableObjects.editDepartmentField.isDisplayed();
            webTableObjects.editDepartmentField.clear();
                webTableObjects.editDepartmentField.sendKeys("Edit Job");

        webTableObjects.editModalSubmitBtn.click();

      assert webTableObjects.editFirstNameField.getText().equals("JohnEdit");

      assert webTableObjects.editLastNameField.getText().equals("DoeEdit");

      assert webTableObjects.editUserEmailField.getText().equals("testemailEDIT@rocketmail.com");

      assert webTableObjects.editAgeField.getText().equals("30");

      assert webTableObjects.editSalaryField.getText().equals("50000");

      assert webTableObjects.editDepartmentField.getText().equals("Edit Job");

        for (int i = 0; i < webTableObjects.firstNameEntries.size(); i++) {
            System.out.println(webTableObjects.firstNameEntries.get(i).getText());
        }

        webTableObjects.searchBox.clear();

    }

    public void deleteNewRowEntry () {


        webTableObjects.searchBox.sendKeys("Doe");


        for (int i = 0; i < webTableObjects.rowEntryDeleteBtn.size(); i++) {
            js.executeScript("arguments[0].click();", webTableObjects.rowEntryDeleteBtn.get(i));
        }
        webTableObjects.searchBox.clear();
        webTableObjects.searchBox.sendKeys(".");
        webTableObjects.searchBox.sendKeys(Keys.BACK_SPACE);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"rt-tr-group\"]/child::div[1]/child::div[7]/child::div[1]/span[2]")));

    }

    }

