import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Base {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/hoang.leviet/Documents/chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   // WebDriverWait w = new WebDriverWait(driver, 5);
	    //WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
	    WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
	    //WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
	    //thời gian chờ ngầm định cho tất cả các phần tử trong class trước khi quăng kết quả ra exception.
	    driver.get("https://rahulshettyacademy.com/seleniumPractise/");
	  	driver.manage().window().maximize();
	    Thread.sleep(3000L);
		String[] names = {"Brocolli", "Cucumber", "Beetroot"};
		 
		addCart(driver,names);
		driver.findElement(By.xpath("//img[contains(@alt,'Cart')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		//Thread.sleep(1000L);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoCode")));
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
	    driver.findElement(By.className("promoBtn")).click();
	    //Thread.sleep(6000L);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));

	    Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Code applied ..!')]")).isDisplayed());
	   // Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")));
	    //Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")));
		//Thread.sleep(5000L);
	    //driver.close();
	    //explicit wait: No performance issue. 
	    //implicit wait: Performance causes issues are not caught. 
	    
	}
	public static void addCart(WebDriver driver, String[] names) {
		int j=0;
		
	    
	    List<WebElement> productList = driver.findElements(By.cssSelector("h4.product-name"));//vi text cua tung phan tu trong productList.get(i) se kha dai. nen can cho vao vong lap va cat bot ki tu cua product name. 
	    List<WebElement> addToCartButtons = driver.findElements(By.xpath("//div[@class='product-action']/button"));
	    
	    //List<WebElement> productList nay de goi tat ca cac phan tu bang driver.findElements. cai nay dung get dc
	    //WebElement dropdownList = driver.findElement(By.cssSelector("id cua dropdown do"));
	    //Select dropdown = new Select(dropdownList); dropdown static. 
	    for (int i =0;i<productList.size();i++) {//nho la product size nha, tu dung get(i) lam gi? :))))
	    	String[] productName = productList.get(i).getText().split("-");
	    	String nameFormatted = productName[0].trim();
	    	List<String> namesList = Arrays.asList(names);
	    	if(namesList.contains(nameFormatted)) {//cho vong lap for, cat string, sau do dat dieu kien , neu string trong productList trung khop voi names ta can, thi ta bam add to card. la tim den dung productList.cssSelector va get(i)
	    		j++;
	    		addToCartButtons.get(i).click();//co rat nhieu nut add to cart nen can List<WebElement> va findElements. 
				//text cua no la dynamic tu Addto Cart -> Added. nen goi ca button thay vi goi text. vi button la static. 
	    		if  (j==names.length) {//o day chi muon mua 3 san pham thoi. 
	    			break;
	    		}
	    	}
	    }
	}

}
