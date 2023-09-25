package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generics.BaseClass;

public class LoginPage extends BaseClass{
	
	public LoginPage(WebDriver driver) {

	PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText = "Log in") 
	private WebElement Loginlink;

	public WebElement getLoginlink() {
		return Loginlink;
	}
	
	@FindBy(id = "Email")
	private WebElement EmailTF;
	
	public WebElement getEmailTF() {
		return EmailTF;
	}
	
	@FindBy(id="Password")
	private WebElement PasswordTF;
	
	public WebElement getPasswordTF() {
		return PasswordTF;
	}
	
	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement LoginButton;
	
	public WebElement getLoginButton() {
		return LoginButton;
	}
}
