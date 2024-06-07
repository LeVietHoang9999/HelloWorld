package testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Step4 {
	
	@Test(enabled=false)
	public void SuperCarSport() {
		System.out.println("Letter S");
	}
	@Test
	public void WWEwrestlingChampion() {
		System.out.println("Letter W");
	}
	@Test
	public void GQchannelChina() {
		System.out.println("Letter G");
	}
	@Test(timeOut=4000)
	public void BMWcarSport() {
		System.out.println("Letter B");
	}
	@Test(dependsOnMethods= {"WWEwrestlingChampion"})
	public void AppSignoutCarLoan() {
		System.out.println("Letter A");
	}
	
}
