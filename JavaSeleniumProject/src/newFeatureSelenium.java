import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class newFeatureSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/hoang.leviet/Documents/chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	  	driver.manage().window().maximize();
	  	driver.get("https://rahulshettyacademy.com/angularpractice/");
//	  	WebElement inputName = driver.findElement(By.xpath("(//*[@name='name'])[1]"));
//	  	System.out.println(driver.findElement(with(By.tagName("label")).above(inputName)).getText());
	  	WebElement inputName = driver.findElement(By.xpath("//input[@name='name']"));
	  	System.out.println(driver.findElement(with(By.tagName("label")).above(inputName)).getText());
	  	WebElement dateOfBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
	  	driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click();
	  	WebElement loveIceScream = driver.findElement(By.cssSelector("[for='exampleCheck1']"));
	  	driver.findElement(with(By.tagName("input")).toLeftOf(loveIceScream)).click();
	  	WebElement radio = driver.findElement(By.cssSelector("[id='inlineRadio1']"));
	  	System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radio)).getText());
	}

}
