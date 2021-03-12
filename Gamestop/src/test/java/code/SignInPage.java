package code;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SignInPage {
	
	
	WebDriver driver;
	
	@FindBy(xpath="//a[@href='#accountModal']")
	WebElement myAccount;
	
	@FindBy(xpath="//a[@id='signIn']")
	WebElement signin;
	
	@FindBy(name="loginEmail")
	WebElement email;
	
	@FindBy(id="login-form-password")
	WebElement password;
	
	@FindBy(xpath="//button[@class='btn btn-block btn-primary']")
	WebElement signInButton;
	
	
	public SignInPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void login() throws InterruptedException
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(myAccount).click().build().perform();
		
		Thread.sleep(2000);
		
		actions.moveToElement(signin).click().build().perform();
		
		Thread.sleep(1000);
		
		email.sendKeys("ABCD");
		password.sendKeys("pass");
		signInButton.click();
	}

}
