package amazon.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazon.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;
	@FindBy(css=".totalRow button")//day chinh la nut de chuyen sang trang CheckoutPage
	WebElement checkoutEle;
	
	@FindBy(css=".cartSection h3")
	private List<WebElement> productTitles;
	
	public CartPage(WebDriver driver) {
		super(driver);
		//initialization: 
		this.driver = driver;
		PageFactory.initElements(driver, this);//this is the first global variable
	}
//	@FindBy(xpath="//input[@placeholder='email@example.com']")
//	WebElement userEmail;
//	
	public Boolean VerifyProductDisplay(String productName) {//cai nay de assert lun
		Boolean match = productTitles.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		return match;
	}
	public CheckoutPage gotoCheckout() {
		checkoutEle.click();
		return new CheckoutPage(driver);
	}
	

}
