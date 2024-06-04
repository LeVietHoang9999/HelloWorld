import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HandlingCalendarUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String date = "12";
		String month ="12";
		String year ="2027";
		String[] calendar = {month,date,year};
		System.setProperty("webdriver.chrome.driver", "/Users/hoang.leviet/Documents/chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	  	driver.manage().window().maximize();
	  	driver.findElement(By.className("react-date-picker__inputGroup")).click();
	  	//react-calendar__tile react-calendar__year-view__months__month class button month
	  	driver.findElement(By.className("react-calendar__navigation__label")).click();
	  	driver.findElement(By.className("react-calendar__navigation__label")).click();
	  	driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
	  	
	  	//driver.findElements(By.xpath("//button[contains(@class,'react-calendar__year-view__months__month')]")).get(Integer.parseInt(month)-1).click();
	  	driver.findElements(By.xpath("//button[contains(@class,'react-calendar__year-view__months__month')]")).get(Integer.parseInt(month)-1).click();
	  	//month luon co dinh la 12 nen dung cach nay duoc. 
	  	driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
	  	//String.valueOf(month);
	  	//Lam the nao de lay ra ngay thang nam trong tagname cua calendar do, khi no khong co static value...
	  	List<WebElement> dynamic_calendar = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));//tat ca gia tri deu tra ve String
	  	for(int i =0;i<dynamic_calendar.size();i++) {
	  		//List<String> a = Arrays.asList(calendar);
	  		//dung ham Assert.assertEquals. 
	  		System.out.println(dynamic_calendar.get(i).getAttribute("value"));
	  		Assert.assertEquals(dynamic_calendar.get(i).getAttribute("value"), calendar[i]);
	  		System.out.println("Correct");
	  		
	  	}
	}

}
