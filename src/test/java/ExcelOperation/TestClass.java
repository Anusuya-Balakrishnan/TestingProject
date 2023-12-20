package ExcelOperation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass {

@Test(dataProvider = "userInformation", dataProviderClass = DataProviderExample.class)
public void testMethod(Object username,Object password) {
	WebDriverManager.chromedriver().setup();
   RemoteWebDriver driver= new ChromeDriver();
   driver.manage().window().maximize();
   driver.get("https://www.saucedemo.com/");
   WebElement usernameElement= driver.findElement(By.id("user-name"));
//   usernameElement.sendKeys( Object.toString(username));
   WebElement passwordElement= driver.findElement(By.id("password"));
   passwordElement.sendKeys((CharSequence[]) password);
   WebElement login= driver.findElement(By.id("login-button"));
   login.click();
   WebElement menu =driver.findElement(By.name("Open Menu"));
   menu.click();
   WebElement logout =driver.findElement(By.name("Logout"));
   logout.click();
}

}
