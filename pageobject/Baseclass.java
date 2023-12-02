package com.seleniumproject.pageobject;

import java.time.LocalDateTime;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.seleniumproject.utilityclass.ReadConfig;



public class Baseclass
{
	
	ReadConfig readconfig = new ReadConfig();
	
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUserName();
	public String password = readconfig.getPassword();
	
	public static ExtentSparkReporter sparkreport;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	
	public static WebDriver driver;
	
	
	
	@BeforeSuite
	public void setReport() {
		sparkreport = new ExtentSparkReporter("C:\\Users\\Anurag\\eclipse-workspace\\seleniumdemo\\reports\\htmlreports" + LocalDateTime.now()+ ".html");
		extent = new ExtentReports();
		extent.attachReporter(sparkreport);
		extent.setSystemInfo("operating System", "window");
		extent.setSystemInfo("Environment", "QA");
		sparkreport.config().setReportName("Integration Test Execution");
		sparkreport.config().setDocumentTitle("QA Automation Testing Report");
		sparkreport.config().setTheme(Theme.STANDARD);
}
	
	
	@Parameters("browser")
	@BeforeMethod
	 
	
	public void setup(String str)
	{
		if (str.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "F:\\New folder\\New folder\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		} 
	else if (str.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Anurag\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		} 
	}
	
	   
       @AfterMethod
       public void browserclose()
       {
    	   driver.close();
       }
       @AfterSuite
   	public void endReport()
   	{
   		extent.flush();
   	}
      
        
}
