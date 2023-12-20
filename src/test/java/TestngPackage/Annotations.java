package TestngPackage;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Annotations {


	

//@BeforeMethod
public void bmethod() {
		
		System.out.println("Before method");
	
}
	@Test(priority = 1,enabled = true, invocationCount = 3)
	public void test0() {
		System.out.println("test0");
	}
	@Test(priority = 0 ,invocationCount = 2)
	public void test1() {
		System.out.println("test 1");
	}
	@Test(priority = 2)
	public void test2() {
		System.out.println("test2");
	}
//	@AfterMethod
	public void amethod() {
		System.out.println("After method");
	}
}