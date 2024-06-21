package amazon.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import amazon.TestComponents.BaseTest;
import amazon.pageobjects.CartPage;
import amazon.pageobjects.CheckoutPage;
import amazon.pageobjects.ConfirmationPage;
import amazon.pageobjects.LandingPage;
import amazon.pageobjects.ProductCatalogue;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidationsTest extends BaseTest {
	
	
	@Test(groups= {"EfforHandling"},priority=2)
	public void loginErrorValidation() throws IOException, InterruptedException
		{
		//String productName = "ZARA COAT 3";
		landingPage.loginApplication("anshika@gmail.com", "Iamki000");
		Assert.assertEquals("Incorrect email password.", landingPage.getErrorMessage());
		
		
	}
	@Test(priority=1)
	public void ProductErrorValidation() throws IOException
		{
		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue= landingPage.loginApplication("anshika@gmail.com", "Iamking@000");//Good
		List<WebElement> products = productCatalogue.getProductList();//Good
		productCatalogue.addProductToCart(productName);//Good
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");//zara coat 3
		Assert.assertFalse(match);
		
		
		
	}

}
