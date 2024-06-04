import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class HandleBrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/hoang.leviet/Documents/chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	  	driver.manage().window().maximize();
	  	
//	  	String url = driver.findElement(By.cssSelector("a[href='brokenlink']")).getAttribute("href");
//	  	HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
//	  	conn.setRequestMethod("HEAD");
//	  	conn.connect();
//	  	int resCode = conn.getResponseCode();
//	  	System.out.println(resCode);
	  	//Identify all the links in the footer (If it's a broken link):
	  	List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li']/a"));
	  	
	  	SoftAssert a = new SoftAssert();
	  	
//	  	for (WebElement link: links) {
//	  		String linkName = link.getAttribute("href");
//	  		System.out.println("link name: "+linkName);
//	  		HttpURLConnection conn = (HttpURLConnection)new URL(linkName).openConnection();
//	  		conn.setRequestMethod("HEAD");
//	  		conn.connect();
//	  		int resCode = conn.getResponseCode();
//	  		System.out.println(resCode);
//	  		if (resCode>=400) {
//	  			System.out.println("This link "+linkName+" is broken because of the status code: "+resCode);
//	  			Assert.assertTrue(false); //this is the hard assertion.
//	  		
//	  		}
//	  	}
		//Learn about SoftAssertions
	  	for (WebElement link: links) {
	  		String linkName = link.getAttribute("href");
	  		System.out.println("link name: "+linkName);
	  		HttpURLConnection conn = (HttpURLConnection)new URL(linkName).openConnection();
	  		conn.setRequestMethod("HEAD");
	  		conn.connect();
	  		int resCode = conn.getResponseCode();
	  		System.out.println(resCode);
	  		a.assertTrue(resCode<400, "This link "+linkName+" is broken because of the status code: "+resCode);
	  		//True condition resCode<400, if the assert False, it will automatically print the sentence in the right of the assertTrue code. 
	  		
	  		}
	  	a.assertAll();
	  
	}

}
