import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FramesAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/hoang.leviet/Documents/chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.get("https://the-internet.herokuapp.com/nested_frames");
	  	driver.manage().window().maximize();
	  	System.out.println(driver.findElements(By.tagName("frame")).size());
	  	System.out.println(driver.findElements(By.tagName("frameset")).size());
	  	//buoc 1: la vao frame
	  	//Cach 1: dung frame(0) va frame(1):
	  	//driver.switchTo().frame(0);//The half-top of the frame

	  	//driver.switchTo().frame(1);//the second small frame
	  	//cach 2:
	  	driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));
	  	driver.switchTo().frame("frame-middle");//ben trong la classname
	  	//frameset thi khong tinh, vi no bao chua cac frame o trong
	  	Assert.assertEquals(driver.findElement(By.xpath("//*[@id='content']")).getText(), "MIDDLE");
	  	System.out.println(driver.findElement(By.xpath("//*[@id='content']")).getText());
	  	driver.switchTo().defaultContent();
	  	driver.switchTo().defaultContent();
	  	driver.switchTo().frame("frame-top");
	  	driver.switchTo().frame("frame-left");
	  	//Assert.assertEquals(driver.findElement(By.xpath("//*[@id='content']")).getText(), "LEFT");
	  	System.out.println(driver.findElement(By.xpath("//body[contains(text(),'LEFT')]")).getText());
	  	Assert.assertEquals(driver.findElement(By.xpath("//body[contains(text(),'LEFT')]")).getText(), "LEFT");
	  	//driver.findElement(By.linkText("https://google.com")).click();
	  	try {
	  	    WebElement link = driver.findElement(By.linkText("https://asas.com"));
	  	    link.click();
	  	} catch (NoSuchElementException e) {
	  	    System.out.println("Link with text 'asas' not found.");//tranh gay loi cho code dang chay
	  	}
	}

	
}
