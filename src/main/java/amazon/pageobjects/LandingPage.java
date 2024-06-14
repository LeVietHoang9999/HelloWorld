package amazon.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazon.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		//initialization: 
		this.driver = driver;
		PageFactory.initElements(driver, this);//this is the first global variable
	}
	@FindBy(xpath="//input[@placeholder='email@example.com']")
	WebElement userEmail;
	@FindBy(id="userPassword")
	WebElement passwordEle;
	@FindBy(css="input[type='submit']")
	WebElement submit;

	public ProductCatalogue loginApplication(String email,String password) {//Action method. 
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);//Good
		return productCatalogue;

	}
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

}
