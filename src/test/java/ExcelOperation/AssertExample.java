package ExcelOperation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertExample {
	RemoteWebDriver driver;
	WebDriverWait wait;
	@BeforeClass
	public void beforeClass() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	wait=new WebDriverWait(driver, Duration.ofSeconds(20));
}
	
	@Test
	public void testcase1() {
		driver.get("https://oceanacademy.co.in/");
		String actualTitle=driver.getTitle();
		SoftAssert softassert=new SoftAssert();
		softassert.assertEquals(actualTitle,"Ocean Academy");
		System.out.println("completed");
//		driver.close();
	}
	@Test
	public void testcase2() {
		driver.get("https://practicetestautomation.com/practice-test-login/");
		WebElement username=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
		username.sendKeys("student");
		WebElement password=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
		password.sendKeys("Password123");
		driver.findElement(By.id("submit")).click();
		
		
		
	}

}
























