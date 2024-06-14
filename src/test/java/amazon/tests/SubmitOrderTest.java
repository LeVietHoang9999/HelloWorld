package amazon.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import amazon.pageobjects.LandingPage;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest {

	public static void main(String[] args) {
		String productName = "ZARA COAT 3";
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//can co cai implicitlyWait thi moi xu ly duoc cac man hinh loaing nhu the
		
		landingPage.loginApplication("anshik@gmail.com", "Iamking@000");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#products")));

		List<WebElement> products = driver.findElements(By.xpath("//div[contains(@class,'mb-3')]"));
//		WebElement prod = products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);//find first la tim ra ket qua dau tien. khong thi tra ve null
//		//sau khi filter xong thi van la webelement, tru khi ban dung foreach thi no se in ra system.out.println. 
//		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		WebElement prod = products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);//cai filter nay chi la tim thang webelement thoi, chu khong goi ra nhu forEach hay system.out.println
		prod.findElement(By.cssSelector("div[class='card-body'] button:last-of-type")).click();
		
		
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[contains(@class,'ng-animating')]"))));//doi cho den khi nao cai animating bien mat thi moi bam vao routerlink
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		//div[contains(@class,'mb-3')]
		List<WebElement> lsProduct = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean findProduct = lsProduct.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(findProduct);
		System.out.println(findProduct);
		driver.findElement(By.cssSelector("div[class*='subtotal'] ul li button")).click();
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")),"india").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section[class*='ta-result']")));
		driver.findElement(By.cssSelector(".ta-results .ta-item:last-child")).click();
		driver.findElement(By.cssSelector("a[class*='btnn']")).click();
		
		String header = driver.findElement(By.cssSelector(".hero-primary")).getText();
		
		//Assert.assertEquals(header, "THANKYOU FOR THE ORDER.");
		//System.out.println(Assert.assertEquals(header, "THANKYOU FOR THE ORDER."));
		Assert.assertTrue(header.equalsIgnoreCase("THANKYOU FOR THE ORDER."));//equalsIgnoreCase la loai bo ca upperCase va lowerCase
		System.out.println(header.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		//driver.close();
		System.out.println("Run the test successfully");
	}

}
