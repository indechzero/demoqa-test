package FinalActivity.tests.PageActions;

import FinalActivity.tests.PageObjects.progressBarPageObjects;
import TestComponents.BaseTest;

public class ProgressBarComponent extends BaseTest {

   private final progressBarPageObjects progressPageObjects = new progressBarPageObjects(driver);

    public void goToHomePage()
    {
        driver.get("https://demoqa.com/");
        javaScrollDown(progressPageObjects.widgets);
        progressPageObjects.widgets.click();
        progressPageObjects.progressBarNav.click();
    }


    public  void goToProgressBarPage() {

        String PageTitle = "DEMOQA";
        assertTitle(PageTitle);
        System.out.println(progressPageObjects.sectionTitle.getText());
        assert progressPageObjects.sectionTitle.getText().equalsIgnoreCase("Progress Bar");

    }

    public void startProgressBar () throws InterruptedException {

        System.out.println("Activity Title:" + progressPageObjects.progressBarLabel.getText());

        assert progressPageObjects.progressBarLabel.getText().equalsIgnoreCase("Progress Bar");
        System.out.println(progressPageObjects.progressBarButton.getText());

        assert progressPageObjects.startStopBtn.getText().equalsIgnoreCase("Start");
        progressPageObjects.progressBarButton.click();


        System.out.println("Pause Progress Bar");
        System.out.println(progressPageObjects.progressBarButton.getText());
        assert progressPageObjects.progressBarButton.getText().equalsIgnoreCase("Stop");
        Thread.sleep(5000);
        progressPageObjects.progressBarButton.click();

        System.out.println(progressPageObjects.progressBar.getText());


    }
    public void continueProgressBar () throws InterruptedException {

        Thread.sleep(8000);
        System.out.println("Continue Progress Bar");
        progressPageObjects.progressBarButton.click();
        Thread.sleep(5000);


    }

    public void verifyFinishedProgress () {

//        textElementIsEqual(progressPageObjects.progressBar, "100%");
        assert progressPageObjects.progressBar.getText().equalsIgnoreCase("100%");

        System.out.println(progressPageObjects.resetButton.getText());

        assert progressPageObjects.resetButton.getText().equalsIgnoreCase("Reset");
        System.out.println(progressPageObjects.progressBar.getText());


    }

    public void resetProgressBar () {

        progressPageObjects.resetButton.click();
        assert progressPageObjects.progressBar.getText().equalsIgnoreCase("100%");
        System.out.println(progressPageObjects.progressBar.getText());


    }

    }

