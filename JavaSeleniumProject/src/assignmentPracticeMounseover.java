import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class assignmentPracticeMounseover {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/hoang.leviet/Documents/chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	  	driver.manage().window().maximize();
	  	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	  	Actions a = new Actions(driver);

//	  	WebElement input_nation = driver.findElement(By.id("autocomplete"));
//	  	a.moveToElement(input_nation).click().keyDown(Keys.SHIFT).sendKeys("india").build().perform();
//	  	
//	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='ui-id-1']/li//div[text()='India']")));	
//	  	WebElement opt = driver.findElement(By.xpath("//ul[@id='ui-id-1']/li//div[text()='India']"));
//	  	Assert.assertTrue(opt.isDisplayed());
//	  	System.out.println("The needed option appears successfully");
//	  	opt.click();
//	  	//Locator: (//div[text()='India'])[1]
//	  	//USA: 
//	  	//del the keys in the bar text: 
//	  	Thread.sleep(1000L);
//	  	a.moveToElement(input_nation).doubleClick().build().perform();//right click mouse. 
//
//	  	a.moveToElement(input_nation).click().keyDown(Keys.BACK_SPACE).build().perform();
//	  	a.moveToElement(input_nation).click().keyDown(Keys.SHIFT).sendKeys("usa").build().perform();
//
//	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='ui-id-1']/li//div[contains(text(),'USA')]")));	
//	  	
//	  	WebElement opt2 = driver.findElement(By.xpath("//ul[@id='ui-id-1']/li//div[contains(text(),'USA')]"));
//	  	Assert.assertTrue(opt2.isDisplayed());
//	  	System.out.println("The needed option 2 appears successfully");
//	  	opt2.click();
//	  	
	  	JavascriptExecutor js = (JavascriptExecutor) driver;
	  	//cach 2: 
	  	driver.findElement(By.id("autocomplete")).sendKeys("ind");
	  	Thread.sleep(2000L);
	  	driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
	  	driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);//to take the present option. 
	  	System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));//value o day la cua id autocomplete
	  	String val = "return document.getElementById(\"autocomplete\").value;";
	  	String text = (String)js.executeScript(val);
	  	System.out.println(val);
	  	System.out.println(text);
	}

}
