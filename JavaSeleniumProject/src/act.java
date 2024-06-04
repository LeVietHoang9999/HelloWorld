import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class act {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/hoang.leviet/Documents/chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.get("https://jqueryui.com/droppable/");
	  	driver.manage().window().maximize();
	  	//System.out.println(driver.findElements(By.tagName("iframe")).size());//chi co findElements moi co function size() de tim ra so luong Elements. 
	  	System.out.println(driver.findElements(By.tagName("iframe")).size());
	  	driver.switchTo().frame(0);
	  	Actions a = new Actions(driver);
	  	//WebDriver la 1 auto framework
	  	WebElement source = driver.findElement(By.id("draggable"));
	  	WebElement target = driver.findElement(By.id("droppable"));
	  	a.dragAndDrop(source, target).build().perform();//action nao cung can co build().perform();
	  	driver.switchTo().defaultContent();
	  	driver.findElement(By.xpath("//*[text()='Accept']")).click();
	}

}
