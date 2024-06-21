package amazon.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazon.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {
	WebDriver driver;
	
	@FindBy(css=".cartSection h3")
	private List<WebElement> productTitles;
	
	@FindBy(css="tr td:nth-child(3)")
	private List<WebElement> productNames;
	public OrderPage(WebDriver driver) {
		super(driver);
		//initialization: 
		this.driver = driver;
		PageFactory.initElements(driver, this);//this is the first global variable
	}
	public Boolean VerifyOrderDisplay(String productName) {//cai nay de assert lun
		Boolean match = productNames.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		return match;
	}

}
