package ExcelOperation;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderExample {

	ReadDataFromExcel readObject=new ReadDataFromExcel();
	
	@DataProvider(name="userInformation")
	public Object[][] userData() throws IOException {
		return readObject.read();
	}
}
