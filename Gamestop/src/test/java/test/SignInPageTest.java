package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import code.BaseClass;
import code.SignInPage;

public class SignInPageTest {
	
	BaseClass base;
	SignInPage signIn;
	WebDriver driver;
	
	@BeforeTest
	public void testStart()
	{
		System.out.println("test is getting started");
	}
	
	@BeforeClass
	public void initialize()
	{
		base=BaseClass.getInstance();
		driver=base.getDriver();
		base.loadURL();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		signIn=new SignInPage(driver);
		PageFactory.initElements(driver, signIn);
		
		
	}
	
	@Test
	public void loginCheck() throws InterruptedException
	{
         signIn.login();
	}



	@AfterClass
	public void close()
	{
		driver.close();
	}
	
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("Test is getting finished");
	}
	
}