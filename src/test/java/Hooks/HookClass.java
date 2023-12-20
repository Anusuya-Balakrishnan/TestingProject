package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class HookClass {

	@BeforeStep
	public void beforeStep() {
		System.out.println("before step");
	}
	@AfterStep
	public void afterStep() {
		System.out.println("after step");
	}
	@Before
	public void beforeScenario() {
//		System.out.println(s.getStatus());
		System.out.println("before scenario");
	}
	@After
	public void afterScenario() {
//		System.out.println(s.getStatus());
		System.out.println("after scenario");
	}
}
