package Hello;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class SeleniumProgram {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	RemoteWebDriver driver =new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.google.com/");
}
}
