package com.seleniumproject.utilityclass;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
	FileInputStream fileinput;
	
	Properties pro;
	 
	public ReadConfig() {
    	
    	File file = new File("C:\\Users\\Anurag\\eclipse-workspace\\seleniumdemo\\configuration\\configfile.properties");
    	 
    	try
    	{
    		
    	fileinput = new FileInputStream(file);
    	
    	 pro = new Properties();
    	
    	pro.load(fileinput);
    	}
             catch(Exception e)
    	{
            	 
            	 System.out.println("This line is throwing an exception");
            	 System.out.println(e.getStackTrace());
             }
    	
    	
    }
	
	public String getApplicationURL() 
	{
		String url = pro.getProperty("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		return url;
	}
	
	public String getUserName()
	{
		
		String username = pro.getProperty("username");
		return username;
	}
	
	public String getPassword()
	{
		
		String password = pro.getProperty("password");
		return password;
	}
	
	
}
