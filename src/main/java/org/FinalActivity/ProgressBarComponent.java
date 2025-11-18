package org.FinalActivity;

import org.AbstractComponent.abstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ProgressBarComponent extends abstractComponent {

    @FindBy(css=".text-center")
    static WebElement sectionTitle;

    @FindBy (xpath = "//div[@class='mb-3']") @CacheLookup
    WebElement progressBarLabel;

    @FindBy(xpath="//button[@id='startStopButton']") @CacheLookup
    WebElement progressBarButton;

    @FindBy(xpath="//*[@id=\"resetButton\"]") @CacheLookup
    WebElement resetButton;

    By startStopBtn = By.xpath("//button[@id='startStopButton']");

    By progressBarPercentage = By.xpath("//*[@id=\"progressBar\"]/div");

    @FindBy(xpath="//*[@id=\"progressBar\"]/div") @CacheLookup
    WebElement progressBar;




    public ProgressBarComponent(WebDriver driver)

{
    this.driver = driver;
    PageFactory.initElements(driver,this);

        }

public  void goToProgressBarPage() {
    driver.get("https://demoqa.com/progress-bar");

    String PageTitle = "DEMOQA";

    assertTitle(PageTitle);
    System.out.println(sectionTitle.getText());
    textElementIsEqual(sectionTitle, "Progress Bar");


}
    public void startProgressBar () throws InterruptedException {

        System.out.println("Activity Title:" + progressBarLabel.getText());

        textElementIsEqual( progressBarLabel,"Progress Bar");
        System.out.println(progressBarButton.getText());

        textElementAssertion(startStopBtn,"Start");
        progressBarButton.click();

        System.out.println(progressBarButton.getText());
        textElementIsEqual(progressBarButton,"Stop");

//        Thread.sleep(Duration.ofSeconds(5));
        progressBarButton.click();

        System.out.println(progressBar.getText());


    }
    public void continueProgressBar () throws InterruptedException {

        progressBarButton.click();
//        Thread.sleep(Duration.ofSeconds(5));


    }

    public void verifyFinishedProgress () {

        textElementIsEqual(progressBar, "100%");
        System.out.println(resetButton.getText());

        textElementIsEqual(resetButton,"Reset");
        System.out.println(progressBar.getText());


    }

    public void resetProgressBar () {

      resetButton.click();
      waitForProgressBarFinished(progressBarPercentage);
      System.out.println(progressBar.getText());


    }

    }

