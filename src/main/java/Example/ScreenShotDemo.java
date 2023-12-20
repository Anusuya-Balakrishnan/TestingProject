package Example;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShotDemo {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://oceanacademy.co.in/");
		Thread.sleep(2000);
		TakesScreenshot screenShot=(TakesScreenshot) driver;
		File file=screenShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("screenShot.png"));
	}

}
