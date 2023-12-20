package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
	
	RemoteWebDriver driver;
	@Given("I first navigate to website")
	public void iFirstNavigateToWebsite() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/login");
		Thread.sleep(2000);
	    
	}
	@When("I enter user name as {string}")
	public void iEnterUserNameAs(String username) throws InterruptedException {
		WebElement userNameElement=driver.findElement(By.id("username"));
		userNameElement.sendKeys(username);
		Thread.sleep(2000);
	}
	@When("enter password as {string}")
	public void enterPasswordAs(String password) throws InterruptedException {
	    WebElement passwordElement=driver.findElement(By.id("password"));
	    passwordElement.sendKeys(password);
	    Thread.sleep(2000);
	}

	@When("I click login button")
	public void iClickLoginButton() throws InterruptedException {
		WebElement loginButton=driver.findElement(By.xpath("//button[text()='Login']"));
		loginButton.click();
		Thread.sleep(2000);
	    
	}
	@Then("I will get message success message")
	public void iWillGetMessageSuccessMessage() {
	    String successMessage="You logged into a secure area!";
	    String passwordInvalidMessage="Your password is invalid!";
	    String userInvalidMessage="Your username is invalid!";
	    WebElement flash=driver.findElement(By.id("flash"));
	    String actualResult=flash.getText();
	    if(actualResult.equals(successMessage)) {
	    	System.out.println("Test pass");
	    }
	    else if(actualResult.equals(passwordInvalidMessage)) {
	    	System.out.println("Test fail(Invalid password)");
	    }
	    else if(actualResult.equals(userInvalidMessage)) {
	    	System.out.println("Test fail(Invalid username)");
	    }
	    driver.close();
	}


}
