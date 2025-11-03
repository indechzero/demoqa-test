package FinalActivity.tests.PageObjects;

import TestComponents.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckBoxPageObjects extends BaseTest {

    public CheckBoxPageObjects(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".text-center")
    public WebElement sectionTitle;

    @FindBy(xpath="*//span[@class=\"rct-title\"]")
    public WebElement homeCheckBox;

    @FindBy(xpath="//*[@id=\"result\"]/span") @CacheLookup
    public  List<WebElement> selectedElements;

    @FindBy(xpath="//body/div[@id='app']/div[@class='body-height']/div[@class='home-content']/div[@class='home-body']/div[@class='category-cards']/div[1]")
    @CacheLookup public WebElement elementsNavButton;

    @FindBy(xpath="(//li[@id='item-1'])[1]")
    @CacheLookup public WebElement checkBoxMenuBtn;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/div/button[1]")
    @CacheLookup public WebElement plusButton;

    @FindBy(xpath="//*[@id=\"tree-node\"]/div/button[2]")
    @CacheLookup public WebElement collapseAll;
    }

