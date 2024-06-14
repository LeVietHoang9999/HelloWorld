package amazon.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import amazon.pageobjects.CartPage;
import amazon.pageobjects.CheckoutPage;
import amazon.pageobjects.ConfirmationPage;
import amazon.pageobjects.LandingPage;
import amazon.pageobjects.ProductCatalogue;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {
	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;
	public static void main(String[] args) {
		String productName = "ZARA COAT 3";
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
        LandingPage landingPage = new LandingPage(driver);//Good
		landingPage.goTo();//Good
		ProductCatalogue productCatalogue= landingPage.loginApplication("anshika@gmail.com", "Iamking@000");//Good
		//ProductCatalogue productCatalogue = new ProductCatalogue(driver);//Good
		List<WebElement> products = productCatalogue.getProductList();//Good
		productCatalogue.addProductToCart(productName);//Good
		
		//ProductCatalogue.waitForElementToAppear(cartHeader);
		CartPage cartPage = productCatalogue.goToCartPage();
		
		
		//cach de han che khai bao nhieu object ...
		Boolean match = cartPage.VerifyProductDisplay(productName);//zara coat 3
		
		//Su dung CartPage de xu li doan code nay
		
 		Assert.assertTrue(match);
		System.out.println(match);
		CheckoutPage checkoutPage = cartPage.gotoCheckout();
		checkoutPage.selectCountry();
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		//CheckoutPage + ConfirmationMessage: 
		String confirmMessage = confirmationPage.VerifyConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));		
		System.out.println("Run the test successfully");
		//Nhờ có Inheritance nên code rất rõ ràng, mọi người có thể đọc và hiểu 1 cách dễ dàng...
		
		
		//		driver.findElement(By.cssSelector("div[class*='subtotal'] ul li button")).click();//bam vao nut submit de sang trang info (Country...)
//		
//		
//		
//		
//		Actions a = new Actions(driver);
//		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")),"india").build().perform();//Good
//		
//		productCatalogue.waitForElementToAppear(By.cssSelector("section[class*='ta-result']"));//india finding pop-up
//		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section[class*='ta-result']")));
//		driver.findElement(By.cssSelector(".ta-results .ta-item:last-child")).click();
//		driver.findElement(By.cssSelector("a[class*='btnn']")).click(); //chuan bi sang trang bill
//		
//		String header = driver.findElement(By.cssSelector(".hero-primary")).getText();
		
		
		//assertTrue(header.equalsIgnoreCase("THANKYOU FOR THE ORDER."));//equalsIgnoreCase la loai bo ca upperCase va lowerCase
		//System.out.println(header.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		//driver.close();
		
	}

}
