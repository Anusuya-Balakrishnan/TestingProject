package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BookCartSteps {
	int currentCount=0;
	RemoteWebDriver driver;
	WebDriverWait wait;
	@Given("user navigate to bookcart website")
	public void userNavigateToBookcartWebsite() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://bookcart.azurewebsites.net/login");
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		
	    
	}
	@Given("user enters user name as {string} and password as {string}")
	public void userEntersUserNameAsAndPasswordAs(String user, String pass) {
		WebElement username=wait.until(ExpectedConditions.presenceOfElementLocated
				(By.cssSelector("#mat-input-0")));
		username.sendKeys(user);
		WebElement password=wait.until(ExpectedConditions.presenceOfElementLocated
				(By.cssSelector("#mat-input-1")));
	    password.sendKeys(pass);
	}
	@When("user click login button")
	public void userClickLoginButton() {
		WebElement loginBtn=wait.until(ExpectedConditions.presenceOfElementLocated
				(By.xpath("//button[contains(@class,'mat-focus-indicator mat-raised-button mat-button-base mat-primary')]")));
		
	   loginBtn.click(); 
	}
	@When("user search {string} book in the list")
	public void userSearchBookInTheList(String bookname) {
	    WebElement searchBox=wait.until(ExpectedConditions.presenceOfElementLocated(
	    		By.xpath("//input[contains(@placeholder,'Search books or authors')]")));
	    searchBox.sendKeys(bookname);
	    WebElement option=wait.until(ExpectedConditions.presenceOfElementLocated(
	    		By.xpath("//span[contains(@class,'mat-option-text')]")));
	    option.click();
	}
	@Then("user add the book into the cart")
	public void userAddTheBookIntoTheCart() {
		
	    WebElement cartCountElement=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mat-badge-content-0")));
	    currentCount=Integer.valueOf(cartCountElement.getText());
	    WebElement addToCartBtn=wait.until(ExpectedConditions.presenceOfElementLocated(
	    		By.id("//span[contains(text(),'Add to Cart')]")));
	    addToCartBtn.click();
	    int afterCartClick=Integer.valueOf(cartCountElement.getText());
	    if(afterCartClick==currentCount+1) {
	    	System.out.println("successfully added");
	    }
	    else {
	    	System.out.println("not added");
	    }
	}
}
