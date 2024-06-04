import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

public class TakeScreenShot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/hoang.leviet/Documents/chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	  	driver.get("https://jqueryui.com/droppable/");
//	  	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//	  	FileUtils.copyFile(src,new File("C:\\Users\\hoang.leviet\\screenshot.png"));
//	
	  	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  	FileUtils.copyFile(src,new File("C:\\Users\\hoang.leviet\\Downloads\\BaiTap\\testScreenshot.png"));
	}

} 
