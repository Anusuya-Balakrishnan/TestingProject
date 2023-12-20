package listener;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v114.page.Page.CaptureScreenshotFormat;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestngPackage.DemoListenerExample;
import TestngPackage.ExampleProgram;


public class MyListener implements ITestListener  {
	ExtentTest test;
	ExtentReports extent;
	public void onStart(ITestContext context) {
		
		//create the htmlReporter object 
				ExtentSparkReporter htmlReporter  = new ExtentSparkReporter("extentReport.html");
				//create ExtentReports and attach reporter(s)
				  extent = new ExtentReports();
				  extent.attachReporter(htmlReporter);
				  htmlReporter.config().setTheme(Theme.DARK);
				  
		System.out.println("In Listener, on start"+context.getName());
		
	}
	public void onTestStart(ITestResult result) {
		System.out.println("In Listener, test start"+result.getName());
		test = extent.createTest(result.getName());
		
	}
	public void onTestSuccess(ITestResult result) {
		System.out.println("In Listener, on Test success"+result.getName());
		
		test.log(Status.PASS,"test passed"+result.getName());
		
		
	}
	public void onTestFailure(ITestResult result) {
		System.out.println("In Listener, on Test failure"+result.getName());
		
		
		Object instance = result.getInstance();
		
		WebDriver driver = ((DemoListenerExample) instance).getDriver();
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
		String screenshotPath = "screenshot_" + System.currentTimeMillis() + ".png"; // Set your desired screenshot path
		// Save the screenshot to the specified path
		// You might need to adjust this based on your project structure and requirements
		try {
			Files.write(Paths.get(screenshotPath), screenshot);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.fail("Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		test.log(Status.FAIL, "test failed"+result.getName());
		test.fail("Test step failed");
	}

	public void onFinish(ITestContext context) {
		System.out.println("In Listener, on Finish"+context.getName());
		extent.flush();
	}
}
