package code;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	String text,message;
	
	public WebDriver driver;
	@FindBy(name="q")
	public WebElement search;
	
	@FindBy(xpath="//span[@class='search-keywords']")
	WebElement searchResults;
	
	@FindBy(xpath="//div[@class='product-tile product-detail']")
	List<WebElement> list;
	
	@FindBy(xpath="//button[text()='Add to Cart']")
	WebElement AddToCart;
	
	@FindBy(xpath="//div[@class='addedtocart product-tile']/h5")
	WebElement addToCartMessage;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String searchElement(String value)
	{
		
		search.click();
		search.sendKeys(value,Keys.ENTER);
		 text=searchResults.getText();
		 System.out.println(text);
		driver.navigate().back();
		 return text;
		
	}
	
	
	public String addToCart() throws InterruptedException
	{
		search.sendKeys("games",Keys.ENTER);
		list.get(0).click();
		
		Actions actions=new Actions(driver);
		actions.moveToElement(AddToCart).click().build().perform();
		
		//WebElement frame1=driver.findElement(By.id("ae-userStateStore"));
		//driver.switchTo().frame(frame1);
		
     Thread.sleep(3000);
	
	message=addToCartMessage.getText();
	
	
	System.out.println(message);
	return message;
		
	}
	

}
