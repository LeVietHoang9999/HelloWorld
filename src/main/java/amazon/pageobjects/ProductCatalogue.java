package amazon.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazon.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);//this is the first global variable
	}
	//		List<WebElement> products = driver.findElements(By.xpath("//div[contains(@class,'mb-3')]"));
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(xpath="//div[contains(@class,'ng-animating')]")
	WebElement spinner;
	
	By productBy = By.xpath("//div[contains(@class,'mb-3')]");
	By addToCart = By.cssSelector("div[class='card-body'] button:last-of-type");
	//By toastMessage = By.cssSelector("#toast-container");
	
	
	
	public List<WebElement> getProductList(){
		waitForElementToAppear(productBy);
		return products;
	}
	public WebElement getProductByname(String productName) {
		WebElement prod = getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);//cai filter nay chi la tim thang webelement thoi, chu khong goi ra nhu forEach hay system.out.println
		return prod;
	}
	
	public void addProductToCart(String productName) {
		WebElement prod = getProductByname(productName);
		prod.findElement(addToCart).click();
		waitForElementToDisappear(spinner);
	}
	
}
