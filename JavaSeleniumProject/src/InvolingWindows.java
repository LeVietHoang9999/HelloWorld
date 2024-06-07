
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvolingWindows {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/hoang.leviet/Documents/chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	  	driver.manage().window().maximize();
	  	driver.get("https://rahulshettyacademy.com/angularpractice/");
	  	
	  	driver.switchTo().newWindow(WindowType.TAB);
	  	//tuc la chuyen web sang 1 tab ben canh. 
	  	Set<String> windows = driver.getWindowHandles();
	  	Iterator<String> it = windows.iterator();
	  	String parentWindowId = it.next();
	  	String childWindowId = it.next();
	  	driver.switchTo().window(childWindowId);
	  	driver.get("https://rahulshettyacademy.com/#/index");
	  	String keyToSend = driver.findElements(By.xpath("//a[contains(@href,'https://courses.rahulshettyacademy.com/p')]")).get(1).getText();
	  	driver.switchTo().window(parentWindowId);
	  	WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
	  	name.sendKeys(keyToSend);
	  	File file = name.getScreenshotAs(OutputType.FILE);
	  	FileUtils.copyFile(file, new File("logo1.png"));
	  	//GET the height and width of the input rectangular: 
	  	System.out.println(name.getRect().getDimension().getHeight());
	  	System.out.println(name.getRect().getDimension().getWidth());
	}

}
