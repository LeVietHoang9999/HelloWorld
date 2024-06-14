package amazon.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazon.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent{
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".action__submit")
	WebElement submit;
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement country;
	//driver.findElement(By.cssSelector(".ta-results .ta-item:last-child")).click();
	@FindBy(css=".ta-results .ta-item:last-child")
	WebElement selectCountry;
	By results = By.cssSelector("section[class*='ta-result']");
	public void selectCountry() {//Step 1: vua truyen string + vua select country trong pop-up country
		Actions a = new Actions(driver);
		a.sendKeys(country,"india").build().perform();//Good
		
		waitForElementToAppear(results);
		selectCountry.click();
	} //step 2: viet ham chon nut submit
	public ConfirmationPage submitOrder() {
		submit.click();
		return new ConfirmationPage(driver);
	}
}
