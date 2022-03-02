package com.inetBanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.LoginPage;
import com.inetBanking.Utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{

	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		log.info("user name provided");
		lp.setPassWord(pwd);
		log.info("password provided");
		lp.clickLogIn();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			Assert.assertTrue(false);
			log.info("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			log.info("Login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			
		}
		
		
	}
	
	
	public boolean isAlertPresent() //user defined method created to check alert is presetn or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	
   @DataProvider(name="LoginData")
	
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
				//System.out.println(logindata[i-1][j]);
			}
				
		}
	return logindata;
	}
	
}