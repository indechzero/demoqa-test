package TestComponents;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class BaseTest {

	public static WebDriver driver;
	public WebDriver wait;

	public WebDriver initializeDriver() throws IOException

	{
		// Original explicit chromedriver path (kept commented for reference):
		// System.setProperty("webdriver.chrome.driver", "/Users/Josephcanlas/Documents/FinalActivity/chromedriver-mac-arm64/chromedriver");
		// Use WebDriverManager to download/setup the correct chromedriver binary automatically.
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		// Run headless by default when executing in CI or this environment.
		options.addArguments("--headless=new");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		driver = new ChromeDriver(options);
		return driver;

	}

	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
		//read json to string
	String jsonContent = 	FileUtils.readFileToString(new File(filePath),
			StandardCharsets.UTF_8);

	//String to HashMap- Jackson Databind

	ObjectMapper mapper = new ObjectMapper();
	  List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
      });
	  return data;

	//{map, map}

	}

	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";

	}

	@io.qameta.allure.Attachment(value = "Screenshot", type = "image/png")
	public byte[] saveScreenshot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	public void waitForElementToAppear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}

	public void waitForElementToBeEnabled(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(findBy));

	}

	public void waitForWebElementToBeEnabled(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(findBy));

	}

	public void waitForWebElementToAppear(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.visibilityOf(findBy));

	}

	public static void waitForBodyTextToAppear(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		wait.until(ExpectedConditions.visibilityOf(findBy));

	}

	public void waitForWebElementListToAppear(List <WebElement> findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElements(findBy));

	}

	public void waitForListToAppear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));

	}

	public void waitForWebElementToDisappear(WebElement ele) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}


	public void elementMustNotBeSelected(WebElement elementSelect) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.elementSelectionStateToBe(elementSelect, false));
	}

	public void elementMustBeDisabled(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(ele)));
	}

	public void elementMustBeSelected(WebElement elementSelect) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.elementSelectionStateToBe(elementSelect, true));
	}

	public void alertVerification() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.alertIsPresent());
	}


	public void waitForProgressBarFinished(By progressBar) {


		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(progressBar,
				"100%"));

	}

	public void textElementIsEqual(WebElement label, String message) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.textToBePresentInElementValue(label, message));

	}

	public void textElementAssertion(By label, String message) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(9));
		wait.until(ExpectedConditions.textToBe(label, message));

	}

	public void assertTitle(String pageTitle) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
		wait.until(ExpectedConditions.titleIs(pageTitle));

	}

	public void assertLinkMessage(WebElement linkTitle, String message) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));

		wait.until(ExpectedConditions.textToBePresentInElement(linkTitle, message ));

	}

	public void verifyEmpty (WebElement textField, String element){

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));

		wait.until(ExpectedConditions.not(ExpectedConditions.attributeToBeNotEmpty(textField,element)));
	}

	public static void javaScriptClick(WebElement element){

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

	}

	public static void javaScrollDown (WebElement element){

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
	}





}
