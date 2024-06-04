import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class findLinks {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/hoang.leviet/Documents/chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	  	driver.manage().window().maximize();
	  	WebElement footerDriver =  driver.findElement(By.id("gf-BIG"));//khi nay footerDriver tro thanh 1 driver (auto framework)
	  	System.out.println(footerDriver.findElements(By.tagName("a")).size());//lay ra tong so luong link trong 1 section cu the. 
	  	WebElement groupLink = driver.findElement(By.xpath("//tr/td[1]/ul"));
	  	//lap cac link de click, sau do lay ten cua tung tab 1. 
	  	
	  	for (int i =0;i<groupLink.findElements(By.xpath("//tr/td[1]/ul/li/a")).size();i++) {
	  		String clickLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
	  		groupLink.findElements(By.xpath("//tr/td[1]/ul/li/a")).get(i).sendKeys(clickLinkTab);
	  		Thread.sleep(3000L);
	  	}
	  	//switch window: (with optimized while loop)
	  	Set<String> windows = driver.getWindowHandles();
	  	Iterator<String> it = windows.iterator();//Iterator la 1 dang vong lap. 
	  	while(it.hasNext()) {
	  		driver.switchTo().window(it.next());
	  		System.out.println(driver.getTitle());
	  	}
//	  	//Cach 2 : dung vong lap for dat bien la winHandle from driver.getWindowHandles()
//	  	for (String winHandle : driver.getWindowHandles ()){
//	  		driver.switchTo ().window (winHandle); 
//	  		System.out.println(driver.getTitle());
//	  		}
	  	
	}

}
