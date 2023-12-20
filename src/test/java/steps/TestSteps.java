package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestSteps {
	int a,b,result;
	@Given("get values from users")
	public void getValuesFromUsers() {
		a=10;
	   b=20;
	}
	@When("we add two numbers")
	public void weAddTwoNumbers() {
	   result=a+b;
	}
	@Then("it will show the result")
	public void itWillShowTheResult() {
		System.out.println("result"+result);
	    
	}
}
