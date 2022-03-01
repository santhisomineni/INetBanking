package com.inetBanking.PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver rdriver) {
		this.driver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	//By userId=By.name("uid");
	@FindBy(name="uid")
	WebElement txtUserId;
	//By password=By.name("password");
	@FindBy(name="password")
	WebElement txtPassWord;
	//By logIn=By.name("btnLogin");
	@FindBy(name="btnLogin")
	WebElement btnLogIn;
	public void setUserName(String uname)
	{
		txtUserId.sendKeys(uname);
	}
	public void setPassWord(String pwd)
	{
		txtPassWord.sendKeys(pwd);
	}
	public void clickLogIn()
	{
		btnLogIn.click();
	}
}
