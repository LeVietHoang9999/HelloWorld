import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class loginpagePractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/hoang.leviet/Documents/chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    String[] names = {"iphone X", "Samsung Note 8", "Nokia Edge","Blackberry"};
	    WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
	    driver.get("https://rahulshettyacademy.com/loginpagePractise/");
	  	driver.manage().window().maximize();
	    //Thread.sleep(3000L);
	    
	    driver.findElement(By.cssSelector("#username")).sendKeys("rahulshettyacademy");
	    driver.findElement(By.cssSelector("#password")).sendKeys("learning");
	    ////div[@class='form-check-inline']/label[2]//span[@class='checkmark']
	    
	    //locator: //div[@class='form-check-inline']/span[2]
	    // //div[@class='form-check-inline']//label[@class='customradio']/span[2]
	    //driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
	    driver.findElement(By.xpath("//div[@class='form-check-inline'] //span[text()=' User']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Okay']")));
		//w.until(ExpectedConditions.visibilityOfElementLocated(null));
	    driver.findElement(By.xpath("//button[text()='Okay']")).click();
	    driver.findElement(By.xpath("//button[text()='Okay']")).click();
	   // System.out.println(driver.switchTo().alert().getText());
		
	    //driver.switchTo().alert().accept();
	    
	    //w.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("select.form-control")));
	    Thread.sleep(2000L);
	    WebElement dropdownList =  driver.findElement(By.cssSelector("select.form-control"));
	    Select dropdown = new Select(dropdownList);
	    dropdown.selectByIndex(2);
	    System.out.println(dropdown.getFirstSelectedOption());
	    driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	    Assert.assertTrue(driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected());
	    driver.findElement(By.id("signInBtn")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Shop Name']")));
		addCart(driver, names);
	    //w.until se danh cho tab tiep theo...
	    //w.until(ExpectedConditions.invisibilityOfElementLocated(By.id("")));
	    
		Thread.sleep(1000L);
		driver.findElement(By.xpath("//a[contains(text(), 'Checkout')]")).click();
	    
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr/td//button[contains(text(),'Checkout')]")));
		driver.findElement(By.xpath("//tr/td//button[contains(text(),'Checkout')]")).click();
	
	}
	public static void addCart(WebDriver driver, String[] names) {
		int j=0;//cai nay de gioi so lan lap. khi nao j du 4 lan thi close. j==4
		List<WebElement> productList = driver.findElements(By.cssSelector(".card-title"));
		List<WebElement> buttons = driver.findElements(By.xpath("//button[text()='Add ']"));
		//vi co cai List buttons thi khi bam nut so may, thi get(i) cua cai nut do la okay.
		//split & trim
		//chuyen names ve 1 array List. 
		
		for (int i =0; i<productList.size();i++) {
			String productListName = productList.get(i).getText();
			
			
			List<String> nameProduct = Arrays.asList(names);
			if (nameProduct.contains(productListName)) {
				j++;
				buttons.get(i).click();
				if (j==names.length) {
					break;
				}
			}
		}
	
	}
 
}
