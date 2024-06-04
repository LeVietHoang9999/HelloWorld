import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class testNG_connectWeb2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/hoang.leviet/Documents/chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	  	driver.manage().window().maximize();
	  	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	  	driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys("Rice");
	  	List<WebElement> lsProduct = driver.findElements(By.xpath("//tbody/tr/td[1]"));
	  	
	  	List<WebElement> lsProduct1 = lsProduct.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
	  	Assert.assertEquals(lsProduct.size(), lsProduct1.size());
	
	}

}
