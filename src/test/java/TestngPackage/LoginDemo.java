package TestngPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginDemo {
	
	RemoteWebDriver driver;
	WebDriverWait wait;
	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		
	}
	
	
	@DataProvider
	public Object[][] data() {
		
		Object array[][]= {{"standard_user","secret_sauce"},{"locked_out_user","secret_sauce"},{"problem_user","secret_sauce"},{"performance_glitch_user","secret_sauce"},{"error_user","secret_sauce"},{"visual_user","secret_sauce"}};
		return array;
	}

//	@Test(dataProvider = "data")
	public void test(String name,String password) {
		System.out.println("name="+name+" "+"password="+password);
		
	}
	@Test(dataProvider = "data")
	public void login(String name,String pass) throws InterruptedException {
		driver.get("https://www.saucedemo.com/");
		WebElement username=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
		username.sendKeys(name);
		WebElement password=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
		password.sendKeys(pass);
		WebElement loginButton=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-button")));
		loginButton.click();
		
		
	}
	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
		
	}
}
