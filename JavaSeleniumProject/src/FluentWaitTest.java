import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FluentWaitTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/hoang.leviet/Documents/chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
	  	driver.manage().window().maximize();
	  	//driver.findElement(By.xpath("//button[text(),'Start']"));
	  	driver.findElement(By.cssSelector("[id='start'] button")).click();//button la child tagname cua the id='start'
	  	//driver.findElement(By.id("")).getAttribute("style").contains("");
	  	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	  	       .withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3))
	  	       .ignoring(NoSuchElementException.class);
	  	WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
	  	     public WebElement apply(WebDriver driver) {
	  	       return driver.findElement(By.cssSelector("[id='finish'] h4"));
	  	     }
	  	   });
	  	System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed());
	}

}
