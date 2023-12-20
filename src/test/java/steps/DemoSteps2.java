package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DemoSteps2 {
	
	@When("user enters username2")
	public void userEntersUsername2() {
	   System.out.println("user enters username2");
	}
	@When("user enters password2")
	public void userEntersPassword2() {
	    System.out.println("user enters password2");
	}
	@When("user clicks submit button2")
	public void userClicksSubmitButton2() {
	 System.out.println("user clicks submit button2");   
	}
	@Then("user gets success message2")
	public void userGetsSuccessMessage2() {
	    System.out.println("user gets success message2");
	}

}
