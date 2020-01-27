package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BrowserInit {
	
	protected WebDriver driver;
	public void init(final String url) { 
	    System.setProperty("webdriver.chrome.driver","A:\\selenium\\chromedriver.exe"); 
	    driver = new ChromeDriver();
	    driver.get(url);
	 }
	
	@AfterMethod
	public void tearDown() {
	    driver.close();
	 }
}
