package code;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	private static BaseClass instance = null;
	private  WebDriver driver;

	private BaseClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public static BaseClass getInstance() {
		if (instance == null) {

			instance = new BaseClass();
		}

		return instance;
	}
	
	public  WebDriver getDriver()
	{
		return driver;
	}
	
	public void loadURL()
	{
		driver.get("https://www.gamestop.com/");
	}
	
	
	public  void takeScreenShot(String methodName) throws IOException
	{
		TakesScreenshot ts=((TakesScreenshot)driver);
		
		File src=ts.getScreenshotAs(OutputType.FILE);
	
		FileUtils.copyFile(src,new File("./ScreenShot/"+methodName+".png"));
		
	}
}
