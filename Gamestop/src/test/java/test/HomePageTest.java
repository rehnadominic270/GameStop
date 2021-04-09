package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import code.BaseClass;
import code.HomePage;
import junit.framework.Assert;

public class HomePageTest {
	public BaseClass base;
	public WebDriver driver;
	public HomePage homePage;
	
	
	@BeforeClass
	public void intialize()
	{
		base=BaseClass.getInstance();
		driver=base.getDriver();
		base.loadURL();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		homePage=new HomePage(
				driver);
		PageFactory.initElements(driver, homePage);
		
	}
	
	@Test(dataProvider="input",priority=1)
	public void validateSearch(String val)
	{
		String result=homePage.searchElement(val);
		Assert.assertTrue(result.contains(val));
		
		//Assert.assertTrue(false);
	
		
		
	
		
	}
	
	@DataProvider(name="input")
	public Object[] getData()
	{
		
		String[] s=new String[3];
		s[0]="games";
		s[1]="videos";
		s[2]="toys";
		
		return s;
		
	}
	
	@Test(priority=2)
	public void validateAddToCart() throws InterruptedException, IOException
	{
	
	 //h.addToCart();
		//System.out.println(result1);
		
	
	Assert.assertEquals(homePage.addToCart(),"Added to Cart");

}

	
	@AfterClass
	public void quit()
	{
		driver.quit();
	}
}