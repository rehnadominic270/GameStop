package test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtendReportDemo {
	
	@Test
	public void test()
	{
		
		ExtentHtmlReporter html = new ExtentHtmlReporter("D:\\GameStop\\GameStop\\Gamestop\\Reports\\reports.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(html);
		
		ExtentTest logger=extent.createTest("test");
		logger.log(Status.INFO, "Login to amazon");
		extent.flush();
		
		
	}

}
