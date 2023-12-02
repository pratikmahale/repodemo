package com.seleniumproject.testclass;



import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.seleniumproject.pageobject.Baseclass;
import com.seleniumproject.pageobject.LoginPage;

public class TC_001_loginTest extends Baseclass
{
	@Test
	public void loginTest()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		test = extent.createTest("Verify application login");
		
		
		LoginPage login = new LoginPage(driver);
		
		login.setUsename();
		test.log(Status.PASS, "username successfully entered");
		
		login.setPassword();
		test.log(Status.PASS, "password successfully entered");
		
		login.clickOnLoginButton();
		test.log(Status.PASS, "clicked on login button");
		
		if (driver.getTitle().equals("OrangeHRM"))
		{
			test.log(Status.PASS, "user successfully logged in to the applicatin");
		} else {
			test.log(Status.FAIL, "log in failed");
		}
	    
		
		
		
		
		
	
         
		
	}
}	


