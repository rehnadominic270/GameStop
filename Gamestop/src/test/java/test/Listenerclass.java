package test;

import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import code.BaseClass;

public class Listenerclass  extends TestListenerAdapter{

	
	public BaseClass base;
	@Override
	public void onTestFailure(ITestResult tr) {
		
		System.out.println(tr.getName());
		
	String methodName= tr.getName();
	try {
		base.takeScreenShot(methodName);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		
	}

	@Override
	public void onStart(ITestContext testContext) {
		
		System.out.println("Test getting started");
	}

	@Override
	public void onFinish(ITestContext testContext) {
		System.out.println("Test getting finished");
	}

	@Override
	public void onTestStart(ITestResult result) {
		
	}
	
	

}
