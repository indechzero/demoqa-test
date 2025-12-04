package TestComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.resources.ExtentReporterNG;

import java.io.IOException;
import java.lang.reflect.Field;

public class Listeners extends BaseTest implements ITestListener{
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>(); // Thread safe

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test); // Set the test object to ThreadLocal
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed");

		// Optional: Attach screenshot on success (Verified feature)
		attachScreenshotToReport(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// 1. Log the error
		extentTest.get().fail(result.getThrowable());

		// 2. Attach screenshot
		attachScreenshotToReport(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.get().log(Status.SKIP, "Test Skipped");
		extentTest.get().skip(result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

	// --- HELPER METHOD TO REDUCE DUPLICATION ---
	private void attachScreenshotToReport(ITestResult result) {
		WebDriver driver = null;
		String methodName = result.getMethod().getMethodName();

		try {
			// Robust reflection to find 'driver' field in class hierarchy
			Class<?> currentClass = result.getTestClass().getRealClass();
			driver = getDriverFromField(currentClass, result.getInstance());

		} catch (Exception e) {
			extentTest.get().log(Status.WARNING, "Failed to retrieve driver via reflection: " + e.getMessage());
		}

		if (driver != null) {
			try {
				// Using the inherited getScreenshot method from BaseTest
				String filePath = getScreenshot(methodName, driver);
				extentTest.get().addScreenCaptureFromPath(filePath, methodName);
			} catch (IOException e) {
				extentTest.get().log(Status.WARNING, "Failed to capture screenshot: " + e.getMessage());
			}
		}
	}

	// Recursive method to find the 'driver' field even if it is in a grandparent class
	private WebDriver getDriverFromField(Class<?> clazz, Object instance) throws IllegalAccessException {
		if (clazz == null) return null;

		try {
			Field field = clazz.getDeclaredField("driver");
			field.setAccessible(true); // Access private/protected fields
			return (WebDriver) field.get(instance);
		} catch (NoSuchFieldException e) {
			// If not found in this class, check the parent class
			return getDriverFromField(clazz.getSuperclass(), instance);
		}
	}
}


