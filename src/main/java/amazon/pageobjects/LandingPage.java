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
	@FindBy(css="div[class*='ng-trigger-flyInOut']")
	WebElement errorMessage;
//<div class="ng-tns-c4-7 ng-star-inserted ng-trigger ng-trigger-flyInOut ngx-toastr toast-error ng-animating" toast-component="" style="" xpath="1"><!----><!----><!----><div role="alert" class="ng-tns-c4-7 toast-message ng-star-inserted" aria-label="Incorrect email or password." style=""> Incorrect email or password. </div><!----><!----></div>
	public ProductCatalogue loginApplication(String email,String password) {//Action method. 
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);//Good
		return productCatalogue;

	}
	public String getErrorMessage() throws InterruptedException {
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

}
