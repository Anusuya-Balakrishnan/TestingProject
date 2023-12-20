package TestngPackage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoClass {

	@Test
	@Parameters({"username","age"})
	public void test1(String username,String age) {
		System.out.println("test 1 is running"+username+age);
	}
	@Test
	public void test2() {
		System.out.println("test 2 is running");
	}
	
//	@BeforeMethod
	public void beforeMethod() {
System.out.println("Before Method\n");
	}
//	@BeforeTest
	public void beforeTest() {
		System.out.println("Before test");
	}

}
