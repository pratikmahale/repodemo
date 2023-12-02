package com.seleniumproject.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Baseclass
{
	
	WebDriver ldriver;
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement Username;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;
	
	@FindBy (xpath = "//button[text()=' Login ']")
	private WebElement loginbutton;
	
	
	public  LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public void setUsename()
	{
		Username.sendKeys("username");
	
	}
	
	public void setPassword()
	{
		password.sendKeys("password");
	}
	
	public void clickOnLoginButton()
	{
		loginbutton.click();
	}
	
	
}
