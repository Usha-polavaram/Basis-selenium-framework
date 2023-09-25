package login;

import org.testng.annotations.Test;

import generics.BaseClass;
import objectRepository.LoginPage;

public class LoginToApp extends BaseClass{
	@Test
	public void login()
	{
		LoginPage login=new LoginPage(driver);
		login.getLoginlink().click();
		
		login.getEmailTF().sendKeys(utility.readingDataFromPropertyFile("un"));
		login.getPasswordTF().sendKeys(utility.readingDataFromPropertyFile("pwd"));
		login.getLoginButton().click();
	}
}

