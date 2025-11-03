package org.FinalActivity;

import org.AbstractComponent.abstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckBoxComponent extends abstractComponent {


    public CheckBoxComponent(WebDriver driver)

    {
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    public void goToForm(){
        driver.get("https://demoqa.com/checkbox");

        String ActualTitle = driver.getTitle();
        String PageTitle = "DEMOQA";

        assert ActualTitle.equalsIgnoreCase(PageTitle);

    }

    public void selectAll() throws InterruptedException {

        driver.findElement(By.xpath("*//span[@class=\"rct-title\"]")).click();

//        List <WebElement> selectedElements;
//        selectedElements= driver.findElements(By.xpath("//*[@id=\"result\"]/span"));

        List<WebElement> selectedElements = driver.findElements(By.xpath("//*[@id=\"result\"]/span"));

        List<String> lst1 = new ArrayList<>();
        for(WebElement e : selectedElements){
            String[] name = e.getText().split("-");
            String formattedName = name[0].trim();
            System.out.println(formattedName);
        }

        Thread.sleep(5000L);

        driver.findElement(By.xpath("*//span[@class=\"rct-title\"]")).click();
    }

    public void CheckBoxTest() throws InterruptedException {

        String sectionTitle = (driver.findElement(By.cssSelector(".text-center")).getText());

       assert sectionTitle.equalsIgnoreCase("Check Box");
        System.out.println(sectionTitle);

//        driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button")).click();

        driver.findElement(By.xpath("//*[@id=\"tree-node\"]/div/button[1]")).click();

        List<WebElement> boxLabels = driver.findElements(By.xpath("*//span[@class=\"rct-title\"]"));
//        List<WebElement> boxCheck = driver.findElements(By.xpath("//*[@type=\"checkbox\"]"));

        Thread.sleep(2000L);

        for (int i = 0; i < boxLabels.size(); i++) {

            boxLabels.get(i).click();
            String[] name = boxLabels.get(i).getText().split("-");
            String formattedName = name[0].trim();
            System.out.println(formattedName);
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


        }

//        driver.findElement(By.xpath("*//label[@for=\"tree-node-home\"]")).getText();
//        driver.findElement(By.xpath("*//span[@class=\"rct-checkbox\"]")).click();
//        driver.findElement(By.xpath("*//span[@class=\"rct-title\"]")).getText();
//        driver.findElement(By.xpath("//*[@id=\"result\"]"));


    }


