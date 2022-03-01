package com.inetBanking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	@Test
	public void loginpagetest() throws IOException {
		
		log.debug("navigated to url");
		log.info("we r in the guru99 page");
		System.out.println(driver.getTitle());
		log.info("title printing");
		LoginPage lp = new LoginPage(driver);
		log.error("testing purpose");
		lp.setUserName(username);
		lp.setPassWord(password);
		lp.clickLogIn();
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			captureScreen(driver,"loginpagetest");
			log.error("title not matched");
		}
	}
}