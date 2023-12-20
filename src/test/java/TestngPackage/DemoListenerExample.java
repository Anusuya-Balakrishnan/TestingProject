package TestngPackage;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.devtools.DevToolsException;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoListenerExample {

	public  RemoteWebDriver driver;
	WebDriverWait wait;
	public static int count=1;
//	@BeforeMethod
//	public void beforeMethod() {
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver();
//		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
//		driver.manage().window().maximize();
//		driver.get("https://practicetestautomation.com/practice-test-login/");
//	}
	
	@Test(dataProvider = "dataExample", dataProviderClass = DataProviderExample.class)
	public void login(Object user,Object pass) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		
		WebElement username=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
		WebElement password=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
		username.sendKeys(String.valueOf(user));
		password.sendKeys(String.valueOf(pass));
		WebElement submitBtn=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submit")));
		submitBtn.click();
		
		WebElement postTitleElement=wait.until(ExpectedConditions.presenceOfElementLocated(By.className("post-title")));
		String postTitle=postTitleElement.getText();
//        SoftAssert softAssert = new SoftAssert(); 
//        Assert.assertEquals(postTitle, "Logged In Successfully");
//        System.out.println("element present"+driver.findElement(By.id("error")).isDisplayed());
//		Assert.assertTrue(!(driver.findElement(By.id("error")).isDisplayed()));
		Assert.assertEquals(driver.getTitle(), "Logged In Successfully | Practice Test Automation");
		Thread.sleep(2000);
		count++;
		driver.close();
	}
	public WebDriver getDriver() {
		return driver;
	}
	
	public void takeScreenShot(String name) throws InterruptedException {
		try {
			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String filename ="./screenShot"+name+String.valueOf(count)+".png";
			FileUtils.copyFile(file, new File(filename ));
			System.out.println("*******Screenshot captured********");
			} 
			catch(Exception e) {
			e.printStackTrace();
			}
		Thread.sleep(3000);
		count++;
//		driver.close();
	}
//	@AfterMethod
//	public void afterMethod() {
//		driver.close();
//	}
}
