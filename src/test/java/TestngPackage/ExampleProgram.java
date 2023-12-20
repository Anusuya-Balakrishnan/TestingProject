package TestngPackage;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExampleProgram {
	public static RemoteWebDriver driver;
	WebDriverWait wait;
	int count=1;
	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice-test-login/");
	}
	@Test
	public void login() throws InterruptedException {
		
		
		WebElement username=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
		WebElement password=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
		username.sendKeys("student");
		password.sendKeys("Password123");
		WebElement submitBtn=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submit")));
		submitBtn.click();
		
		WebElement postTitleElement=wait.until(ExpectedConditions.presenceOfElementLocated(By.className("post-title")));
		String postTitle=postTitleElement.getText();
//        SoftAssert softAssert = new SoftAssert(); 
        Assert.assertEquals(postTitle, "Logged In");
		Thread.sleep(5000);
		
	}
	
	public static void takeScreenShot(String name) {
		try {
			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String filename ="./screenShot"+name+".png";
			FileUtils.copyFile(file, new File(filename ));
			System.out.println("*******Screenshot captured********");
			} 
			catch(Exception e) {
			e.printStackTrace();
			}
	}
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
}
