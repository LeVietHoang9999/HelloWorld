package amazon.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import amazon.TestComponents.BaseTest;
import amazon.pageobjects.CartPage;
import amazon.pageobjects.CheckoutPage;
import amazon.pageobjects.ConfirmationPage;
import amazon.pageobjects.OrderPage;
import amazon.pageobjects.ProductCatalogue;

public class StandAloneTest extends BaseTest {

	//String productName = "ZARA COAT 3";
	@FindBy(css = "[routerlink*='cart']")
	WebElement cartHeader;

	@Test(dataProvider="getData", groups= {"Purchase"},priority=1)
	public void submitOrder(HashMap<String, String> input) throws IOException {

		// TODO Auto-generated method stub
		// LandingPage landingPage = launchApplication();
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));// Good
		List<WebElement> products = productCatalogue.getProductList();// Good
		productCatalogue.addProductToCart(input.get("product"));// Good
		CartPage cartPage = productCatalogue.goToCartPage();
		
		Boolean match = cartPage.VerifyProductDisplay(input.get("product"));// zara coat 3
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.gotoCheckout();
		checkoutPage.selectCountry();
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.VerifyConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		System.out.println("Run the test successfully");

	}

	
	@Test(dataProvider="getData",groups= {"submitOrder"},priority=2)// Good (V)
	public void OrderHistoryTest(HashMap<String, String> input) {
		// ZARA COAT 3
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));// Good
		OrderPage orderPage = productCatalogue.goToOrderPage();
		Assert.assertTrue(orderPage.VerifyOrderDisplay(input.get("product")));
	} 
	
//	public String getScreenshot(String testCaseName) throws IOException {
//		TakesScreenshot ts = (TakesScreenshot)driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//		File file = new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
//		FileUtils.copyFile(source,file);
//		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
//	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "ashika@gmail.com");
//		map.put("password", "Iamking@000");
//		map.put("product", "ZARA COAT 3");
//		
//		
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("email", "shetty@gmail.com");
//		map1.put("password", "Iamking@000");
//		map1.put("product", "ADIDAS ORIGINAL");
		
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//amazon//data//PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};// 2 dimension syntax. Object is the parent (Integer, double, string, float)
		//2 sets
	}
}
