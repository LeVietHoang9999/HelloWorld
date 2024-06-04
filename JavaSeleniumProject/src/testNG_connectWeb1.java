import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class testNG_connectWeb1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/hoang.leviet/Documents/chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	  	driver.manage().window().maximize();
	  	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	  	//click on the header to sort the products' names. //tr/th[1]
	  	driver.findElement(By.xpath("//tr/th[1]")).click();
	  	//get all the products' names to WebElement and 
	  	List<WebElement> listProduct = driver.findElements(By.xpath("//tbody/tr/td[1]"));//total 5 elements
	  	//use Stream to switch all of t hem to the List. 
	  	List<String> originalList = listProduct.stream().map(s->s.getText()).collect(Collectors.toList());
	  	//sort List original 
	  	List<String> orderedList = originalList.stream().sorted().collect(Collectors.toList());
	  	//Use Assert function to compare the primary list to the transformed list (ordered List).
	  	Assert.assertTrue(originalList.equals(orderedList));
	  	List<String> price; 
	  	//tim item Rice o trong tab khac của trang ban hang
	  	do {
	  		//ta can 1 list webelement moi de lay ra cac san pham khi sang tab moi. 
		  	List<WebElement> listProduct1 = driver.findElements(By.xpath("//tbody/tr/td[1]"));//total 5 elements
		  	//chi can tim ra 1 cot tr/td[1]. sau do filter getText (cai nay k lay ra text ma chi filter) -> Rice -> no se xac dinh dcphan tu Rice. Map se dung dc method()
	  		price = listProduct1.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeggie(s)).collect(Collectors.toList());
		  	price.forEach(s->System.out.println(s)) ;
		  	if(price.size()<1) {
		  		driver.findElement(By.xpath("//a[@aria-label='Next']")).click();//chua tim thay item rice thi bam tiep sang ta
		  	}
	  	}while(price.size()<1);
	  	//tuc la sai dieu kien price.size = 0 thi out loop. con dung dieu kienj thi con lap. 
	  	
	}

	private static String getPriceVeggie(WebElement s) {
		String veggiePrice = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return veggiePrice;
	}

//	private static String getPriceVeggie(WebElement s) {
//		// TODO Auto-generated method stub
//		String priceOfVeggie = s.findElement(By.xpath("following-sibling::td[1]")).getText();
//		return priceOfVeggie;
//	}

}
