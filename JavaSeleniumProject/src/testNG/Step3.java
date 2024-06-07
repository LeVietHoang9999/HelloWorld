package testNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Step3 {
	@Test
	public void WebLoginHomeLoan() {
		System.out.println("Web Login Home Loan");
	}
	@Test(groups= {"Smoke"})
	public void AppLoginHomeLoan() {
		System.out.println("App Login Home Loan");
	}
	@Parameters({"URL","key"})
	@Test
	public void LoginAPIHomeLoan(String urlName, String key) {
		System.out.println("Login API Home loan");
		System.out.println(urlName);
		System.out.println(key);
	}
}
