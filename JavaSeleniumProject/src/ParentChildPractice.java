import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ParentChildPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/hoang.leviet/Documents/chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	  	driver.manage().window().maximize();
	  	String opt = driver.findElement(By.xpath("//div[1]/div[4]/fieldset/label[1]")).getText();
	  	
	  	WebElement dropdownList = driver.findElement(By.xpath("//div[1]/div[3]/fieldset/select"));
	  	Select s = new Select(dropdownList);
	  	s.selectByVisibleText(opt);
	  	System.out.println(s.getFirstSelectedOption());
	  	driver.findElement(By.xpath("//div[2]/div[3]/fieldset/input[1]")).sendKeys(opt);
	  	driver.findElement(By.xpath("//div[2]/div[3]/fieldset/input[2]")).click();
	  	String alertText = driver.switchTo().alert().getText();
	  	if(alertText.contains(opt)) {
	  		Assert.assertTrue(true);
	  		System.out.println("Assignment done");
	  		
	  	}
	  	else {
	  		Assert.assertTrue(false);
	  	}
	  	driver.switchTo().alert().accept();
	}

}
