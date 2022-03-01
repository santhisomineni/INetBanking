package com.inetBanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop;
	public ReadConfig()
	{
		File src=new File("./Configuration/config.properties");
	    try
	    {
	    	FileInputStream fis=new FileInputStream(src);
	    	prop=new Properties();
	    	prop.load(fis);
	    }
	    catch(Exception e)
	    {
	    	System.out.println("Exception is "+e.getMessage());
	    }
	}
	public String getApplicationURL()
	{
		String url=prop.getProperty("baseURL");
		return url;
	}
	public String getUserName()
	{
		String userName=prop.getProperty("username");
		return userName;
	}
	public String getPassword()
	{
		String passWord=prop.getProperty("password");
		return passWord;
	}
	public String getChromePath()
	{
		String chromePath=prop.getProperty("chromepath");
		return chromePath;
	}
	public String getFirefoxPath()
	{
		String firefoxPath=prop.getProperty("firefoxpath");
		return firefoxPath;
	}
}
