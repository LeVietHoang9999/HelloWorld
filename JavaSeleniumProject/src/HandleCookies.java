import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCookies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/hoang.leviet/Documents/chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    
	  	driver.manage().window().maximize();
	  	//driver.manage().deleteAllCookies();
	  	//driver.manage().deleteCookieNamed("sessionKey");
	  	driver.get("https://jqueryui.com/droppable/");
	  	Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie);
        }
	}

}
