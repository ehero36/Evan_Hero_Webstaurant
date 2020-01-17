package eh_webstaurant_test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;





public class launchbrowser {
	
	public static WebDriver driver = null;
	

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ehero\\eclipse-workspace\\eh_webstaurant_test\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		//opening chrome to webstaurant home page
		driver.navigate().to("https://www.webstaurantstore.com/");
		driver.manage().window().maximize();
		
		//selecting search bar 
		Actions action = new Actions(driver);
		WebElement Searchbar = driver.findElement(By.id("searchval"));
		action.moveToElement(Searchbar).perform();
		action.click();
		action.perform();
		
		//entering search value
		Searchbar.sendKeys("stainless work table");
		
		//selecting submit search button
		
		driver.findElement(By.cssSelector("#searchForm > button")).click();
		
		
		//verify "table" string value
		
		 String results = driver.findElement(By.tagName("body")).getText();
		 Assert.assertTrue("Text not found!", results.contains("table"));
		
		  
		//scroll to last item
		JavascriptExecutor js  = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,9999)");
		
		//add to cart 
		
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[4]/div[3]/div[2]/div[60]/div[4]/form/div[1]/div/input[2]")).click();
		
		
		//remove from cart 
		driver.navigate().to("https://www.webstaurantstore.com/viewcart.cfm");
		driver.findElement(By.name("quantityButtonDown")).click();
	}

	

	}
