package com.inetBanking.TestCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.Utilities.ReadConfig;

public class BaseClass {
	ReadConfig rc = new ReadConfig();
	public String baseURL = rc.getApplicationURL();
	public String username = rc.getUserName();
	public String password = rc.getPassword();
	public static WebDriver driver;
	public Logger log;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {

		log = LogManager.getLogger(BaseClass.class.getName());
		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", rc.getChromePath());
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", rc.getFirefoxPath());
			driver = new FirefoxDriver();

		}
		driver.get(baseURL);
	}

	@AfterClass
	public void closeBrowser() {
		driver.close();
	}

}
