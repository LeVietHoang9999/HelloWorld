package amazon.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import amazon.pageobjects.CartPage;

public class AbstractComponent {//Which can be used by all page objects files with the command header
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	//driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;
	By wait_cartHeader = By.cssSelector("[routerlink*='cart']");
	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		 
	}
	public CartPage goToCartPage() {
		//By wait_cartHeader = By.cssSelector("section[class*='ta-result']");
		waitForElementToAppear(wait_cartHeader);
		cartHeader.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public void waitForElementToDisappear(WebElement ele) {
		//Thread.sleep(1000) to increase the test speed
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));//doi cho den khi nao cai animating bien mat thi moi bam vao routerlink

	}
}