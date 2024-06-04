import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleHTTPS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipaddress:4444");
		options.setCapability("proxy", proxy);
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		options.setExperimentalOption("prefs", prefs);
		//download.default_directory: day la duong link can download, 
		///directory/path : la duong dan can cai trong may tinh. 
		
		
	  	options.setAcceptInsecureCerts(true);
		System.setProperty("webdriver.chrome.driver", "/Users/hoang.leviet/Documents/chromedriver.exe");
	    WebDriver driver = new ChromeDriver(options);
	    driver.get("https://expired.badssl.com/");
	  	driver.manage().window().maximize();
	  	System.out.println(driver.getTitle());
	  	//Block pop-up windows: 
//	  	ChromeOptions options = new ChromeOptions();
//	  	options.setExperimentalOption("excludeSwitches",
//	  	Arrays.asList("disable-popup-blocking"));
	  	
	  	
	}

} 
