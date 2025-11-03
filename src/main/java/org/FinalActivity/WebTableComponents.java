package org.FinalActivity;

import org.AbstractComponent.abstractComponent;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class WebTableComponents extends abstractComponent {

    @FindBy(css=".text-center")
     WebElement sectionTitle;

    @FindBy(xpath="//button[@id=\"addNewRecordButton\"]") @CacheLookup
     WebElement addNewRecordBtn;

    @FindBy(xpath="//div[@class=\"modal-header\"]") @CacheLookup
     WebElement modalHeader;

    @FindBy(id= "firstName") @CacheLookup
     WebElement firstNameField;

    @FindBy(id= "firstName") @CacheLookup
    WebElement editFirstNameField;

    @FindBy(id="lastName") @CacheLookup
     WebElement lastNameField;

    @FindBy(id="lastName") @CacheLookup
    WebElement editLastNameField;

    @FindBy(id="userEmail") @CacheLookup
    WebElement userEmailField;

    @FindBy(id="userEmail") @CacheLookup
    WebElement editUserEmailField;

    @FindBy(id="age") @CacheLookup
    WebElement ageField;

    @FindBy(id="age") @CacheLookup
    WebElement editAgeField;

    @FindBy(id="salary") @CacheLookup
    WebElement salaryField;


    @FindBy(id="salary") @CacheLookup
    WebElement editSalaryField;

    @FindBy(id="department") @CacheLookup
    WebElement departmentField;

    @FindBy(id="department") @CacheLookup
    WebElement editDepartmentField;

    @FindBy(id="submit") @CacheLookup
    WebElement submitBtn;

    @FindBy(id="submit") @CacheLookup
    WebElement editModalSubmitBtn;

    @FindBy(xpath = "//*[@id=\"searchBox\"]")
    WebElement searchBox;

    By tblSearchBox = By.xpath("//*[@id=\"searchBox\"]");

    @FindBy(xpath="//div[@class=\"rt-tr-group\"]/child::div[1]/child::div[1]") @CacheLookup
    List<WebElement> firstNameEntries;

    @FindBy(xpath="//div[@class=\"rt-tr-group\"]") @CacheLookup
    List<WebElement> rowEntries;

    @FindBy(xpath="//div[@class=\"rt-tr-group\"]/child::div[1]/child::div[7]/child::div[1]/span[1]")
    List<WebElement> rowEntryEditBtn;

    @FindBy(xpath="//div[@class=\"rt-tr-group\"]/child::div[1]/child::div[7]/child::div[1]/span[2]")
    List<WebElement> rowEntryDeleteBtn;

    @FindBy(xpath="/html/body/div[5]/div/div/div[2]")
            WebElement editModalBody;

    JavascriptExecutor js = (JavascriptExecutor) driver;

    public WebTableComponents(WebDriver driver)

    {
    this.driver = driver;
    PageFactory.initElements(driver,this);

        }

public void goToWebTablePage() {

    driver.get("https://demoqa.com/webtables");

    String PageTitle = "DEMOQA";
    assertTitle(PageTitle);
    System.out.println(sectionTitle.getText());
    textElementIsEqual(sectionTitle,"Web Tables");
    System.out.println(sectionTitle.getText());

}
    public void addNewRowEntry () {

        //Scroll to table (for smaller resolution)
        js.executeScript("window.scrollBy(0,500)", " ");
        js.executeScript("document.querySelector('.rt-table').scrollTop=5000", " ");

        addNewRecordBtn.click();

        System.out.println(modalHeader.getText());

        firstNameField.isDisplayed();
        firstNameField.sendKeys("John");

        lastNameField.sendKeys("Doe");
        lastNameField.isDisplayed();

        userEmailField.isDisplayed();
        userEmailField.sendKeys("testemail@rocketmail.com");

        ageField.isDisplayed();
        ageField.sendKeys("24");

        salaryField.isDisplayed();
        salaryField.sendKeys("45000");

        departmentField.isDisplayed();
        departmentField.sendKeys("Data Interrogation");

        submitBtn.click();

        //Retrieve each row entry data
        List<WebElement> rowEntry = rowEntries;

        for (int i = 0; i < rowEntry.size(); i++) {
            System.out.println(rowEntry.get(i).getText());
        }

    }

    public void editNewRowEntry () {

        String ghostText = driver.findElement(tblSearchBox).getAttribute("placeholder");
        System.out.println(ghostText);
        assert Objects.requireNonNull(ghostText).equalsIgnoreCase("Type to search");
        driver.findElement(tblSearchBox).sendKeys("Doe");


        for (int i = 0; i < rowEntryEditBtn.size(); i++) {
            js.executeScript("arguments[0].click();", rowEntryEditBtn.get(i));
        }

        waitForWebElementToAppear(editModalBody);

        editFirstNameField.isDisplayed();
        editFirstNameField.clear();
        editFirstNameField.sendKeys("JohnEdit");

        editLastNameField.isDisplayed();
        editLastNameField.clear();
        editLastNameField.sendKeys("DoeEdit");

        editUserEmailField.isDisplayed();
        editUserEmailField.clear();
        editUserEmailField.sendKeys("testemailEDIT@rocketmail.com");

        editAgeField.isDisplayed();
        editAgeField.clear();
        editAgeField.sendKeys("30");

        editSalaryField.isDisplayed();
        editSalaryField.clear();
        editSalaryField.sendKeys("50000");

        editDepartmentField.isDisplayed();
        editDepartmentField.clear();
        editDepartmentField.sendKeys("Edit Job");

        editModalSubmitBtn.click();

        for (int i = 0; i < firstNameEntries.size(); i++) {
            System.out.println(firstNameEntries.get(i).getText());
        }

        searchBox.clear();

    }

    public void deleteNewRowEntry () {


        searchBox.sendKeys("Doe");


        for (int i = 0; i < rowEntryDeleteBtn.size(); i++) {
            js.executeScript("arguments[0].click();", rowEntryDeleteBtn.get(i));
        }
        searchBox.clear();
        searchBox.sendKeys(".");
        searchBox.sendKeys(Keys.BACK_SPACE);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"rt-tr-group\"]/child::div[1]/child::div[7]/child::div[1]/span[2]")));

    }

    }

