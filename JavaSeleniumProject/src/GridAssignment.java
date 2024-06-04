import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GridAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/hoang.leviet/Documents/chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	  	driver.manage().window().maximize();
//	  	List<WebElement> list1 = driver.findElements(By.xpath("//table[@id='product']/tbody/tr[1]/th[2]"));
//	  	List<WebElement> list2 = driver.findElements(By.xpath("//fieldset/table[@id='product']/tbody/tr/td[2]"));
//	  	int num1 = list1.size();
//	  	int num2 = list2.size();
//	  	System.out.println(num1+num2);
//	  	List<WebElement> list3 = driver.findElements(By.xpath("//fieldset/table/tbody/tr[1]/th"));
//	  	System.out.println(list3.size());
//	  //fieldset/table/tbody/tr[3]/td
//	  	List<WebElement> list4 = driver.findElements(By.xpath("//fieldset/table/tbody/tr[3]/td"));
//	  	for (int i =0;i<list4.size();i++) {
//	  		System.out.println(list4.get(i).getText());
	  	//Cach 2:
	  	WebElement table = driver.findElement(By.xpath("//table[@name='courses']"));
	  	//goi tat ca TR
	  	List<WebElement> table_tr = table.findElements(By.tagName("tr"));
	  	System.out.println(table_tr.size());
	  	System.out.println(table_tr.get(0).findElements(By.tagName("th")).size());
	  	System.out.println(table_tr.get(2).findElements(By.tagName("td")).size());
	  	for (int i = 0;i<table_tr.get(2).findElements(By.tagName("td")).size();i++) {
		  	System.out.println(table_tr.get(2).findElements(By.tagName("td")).get(i).getText());

	  	}
	}

}
