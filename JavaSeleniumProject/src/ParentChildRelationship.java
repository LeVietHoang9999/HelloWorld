import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ParentChildRelationship {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/hoang.leviet/Documents/chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    //source code de tat Show Notifications
		//----------------------------------------
//		Map<String, Object> prefs = new HashMap<String, Object>();
//	    prefs.put("profile.default_content_setting_values.notifications", 2);
//	    ChromeOptions options = new ChromeOptions();
//	    options.setExperimentalOption("prefs", prefs);
	    //----------------------------------------  
	  	//WebDriver driver = new ChromeDriver(options);
	  	driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	  	
        driver.manage().window().maximize();
	    Thread.sleep(4000L);
	    driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
	    driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR']//a[@value='BLR']")).click();
	    
	    Thread.sleep(2000L);
	    
	    driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();
	    
	    Thread.sleep(1000L);
	    driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")).click();
//	    driver.findElement(By.cssSelector("#autosuggest")).sendKeys("ind");
//	    Thread.sleep(3000L);
//	    List<WebElement> dropdowns =driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
//	    //phan tu cua List la webelement
//	    for (WebElement dropdown: dropdowns) {
//	    	if (dropdown.getText().equalsIgnoreCase("India")) {
//	    		dropdown.click();
//	    		break;
//	    	}
//	    }
	    
	   //findElement(By.cssSelector("li[class='ui-menu-item'] a"));
	    // Cai nay la dien ten nuoc roi chon 1 option
	    driver.findElement(By.cssSelector("#autosuggest")).sendKeys("ind");
	    Thread.sleep(3000L);
	    List<WebElement> options1 = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
	    for (WebElement option: options1) {
	    	if(option.getText().equalsIgnoreCase("India")) {
	    		option.click();
	    	}
	    }
	    //Handling Checkbox:
	    
	}

}
