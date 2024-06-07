package testNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Step2 {
	@BeforeMethod
	public void BeforeEveryMethod() {
		System.out.println("***");
	}
	@AfterMethod
	public void AfterEveryMethod() {
		System.out.println("*********");
	}
	@Test
	public void WebLoginCarLoan() {
		System.out.println("Web Login Car Loan");
		Assert.assertTrue(false);//Test listeners
	}
	@Test
	public void AppLoginCarLoan() {
		System.out.println("App Login car Loan");
	}
	@Test
	public void AppLogoutCarLoan() {
		System.out.println("App Logout car Loan");
	}
	@Test
	public void AppSigninCarLoan() {
		System.out.println("App Signin car Loan");
	}
	@Test(dataProvider="getData")//no se chay di chay lai cho den khi toan bo dataProvider xuat hien
	public void WhatAppSignoutCarLoan(String username, String password) {
		System.out.println("WhatApp Signout car Loan");
		System.out.println(username);
		System.out.println(password);
	}
	@Test
	public void LoginAPICarLoan() {
		System.out.println("Login API car loan");
	}
	@org.testng.annotations.BeforeSuite(groups= {"Smoke"})
	public void BeforeSuite() {
		System.out.println("Appear here");
	}
	@DataProvider
	public Object[][] getData() {//how do you achieve parameterization? famous interview question. 
		Object[][] data = new Object[3][2]; //means 3 rows+2 columns
		//first set
		data[0][0] = "firstusername";
		data[0][1] = "1stUserpassword";
		//2nd set
		data[1][0]= "secondusername";
		data[1][1]= "2ndUserpassword";
		//3rd set
		data[2][0] = "thirdusername";
		data[2][1] ="3rdUserpassword";
		return data;
	}
	
}
