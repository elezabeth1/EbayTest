package testcart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.BrowserInit;

public class Ebay extends BrowserInit {
	@BeforeMethod
	public void setUp() {
	 init("http://ebay.com");
	}
	
	@Test
		public void AddingToCart() throws InterruptedException {
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Electronics")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Smart Watches")).click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.xpath("//h2[contains(text(),'Buy It Now')]")).click();
		js.executeScript("window.scrollBy(0,500)");
		Actions actions=new Actions(driver); 
		actions.moveToElement(driver.findElement(By.xpath("//div[contains(@class,'srp-controls--selected-value')]"))).build().perform();
		driver.findElement(By. xpath("//span[contains(text(),'Price + Shipping: highest first')]")).click();
		driver.findElement(By.xpath("//li[@id='w7-items[0]']//h3[@class='s-item__title'][contains(text(),"
				+ "'Garmin Descent MK1 Sapphire Silver with Black (ENG')]")).click();
	    driver.findElement(By.linkText("Add to cart")).click();
	    driver.navigate().back();
	    driver.navigate().back();
	    driver.findElement(By.xpath("//li[@id='w7-items[1]']//h3[@class='s-item__title'][contains(text(),'Garmin Descent MK1 Sapphire Silver with Black (ENG')]")).click();
	    driver.findElement(By.linkText("Add to cart")).click();
	    Thread.sleep(3000);
	    System.out.println("The 2 most expensive items of smart watches are added to the cart successfully");
		  }
	}