package TestngPackage;

import org.testng.annotations.DataProvider;

public class DataProviderExample {
	
	@DataProvider
  public Object[][] dataExample() {
	  Object data [][] = {{"student","Password123"},{"incorrectUser","Password123"},{"student","incorrectPassword"}};
	return data;
  }
}
