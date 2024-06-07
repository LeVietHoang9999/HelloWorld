package testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
//we can define multiple tests from a single class
public class testNG1 {
	@BeforeClass
	public void befoClass() {
		System.out.println("The class starts from this point");
	}
	@Parameters({"URL"})
	@BeforeTest
	//test annotation -> this is the first testcase in the Test Folder (Priority: Suite->Test Folder -> Class)
	public void Demo(String urlName) {
		System.out.println("The mansion 4000 square feet");
		System.out.println(urlName);
	}
	@Test
	public void Demo2() {
		System.out.println("The super Sport car");
	}
	@AfterTest(groups= {"Smoke"})
	public void PersonalLoan1() {
		System.out.println("100 inches Sony TV in the suite room");
	}
	@org.testng.annotations.AfterSuite
	public void AfterSuite() {
		System.out.println("Disappear and wait here");
	}
	@AfterClass
	public void AftClass() {
		System.out.println("The class complete in this point");
	}
}
