import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavascriptTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/hoang.leviet/Documents/chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	  	driver.manage().window().maximize();
	  	JavascriptExecutor js = (JavascriptExecutor)driver;
//	  	js.executeScript("window.scrollBy(0,500)");
	  	js.executeScript("window.scrollBy(0,500)");
	  	Thread.sleep(2000L);
	  	//js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
	  	
	  	
	  	js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
//	  	js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
//	  	grid: Lưới 
	  	List<WebElement> gridList = driver.findElements(By.xpath("//table[@id='product']/tbody/tr/td[4]"));
	  	int sum = 0;
	  	for(int i =0;i<gridList.size();i++) {
	  		System.out.println(gridList.get(i).getText());
	  		sum = sum + Integer.parseInt(gridList.get(i).getText());
	  	}
	  	System.out.println(sum);
	  	//compare to string in the Total Amount Collected
	  	String amount = driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim();//	  	int amount_parse = Integer.parseInt(amount);
	  	int amount_parse = Integer.parseInt(amount);
	  	
	  	Assert.assertEquals(sum, amount_parse);
	  	System.out.println("Complete");
	}

}
