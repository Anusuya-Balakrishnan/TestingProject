package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DemoSteps1 {
	@Given("First user navigate to the page")
	public void firstUserNavigateToThePage() {
	   System.out.println("First user navigate to the page");
	}
	@When("user enters username1")
	public void userEntersUsername1() {
	    System.out.println("user enters username1");
	}
	@When("user enters password1")
	public void userEntersPassword1() {
	    System.out.println("user enters password1");
	}
	@When("user clicks submit button1")
	public void userClicksSubmitButton1() {
	    System.out.println("user clicks submit button1");
//	    Assert.assertTrue(false);
	}
	@Then("user gets success message1")
	public void userGetsSuccessMessage1() {
	    System.out.println("user gets success message1");
	}

}
