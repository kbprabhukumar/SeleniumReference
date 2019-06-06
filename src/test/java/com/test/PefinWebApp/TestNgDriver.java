package com.test.PefinWebApp;
/**
 * @author Prabhu Kumar
 * @KeyInputParameter: Webdriver Object and Hashmap Object 
 * @Functionality This is TestNG driver which controls the flow of test cases
 */

import java.io.IOException;
import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgDriver {

		WebDriver driver;
	    HashMap<String,String> inputData;
	
	//BeforeMethod is called once before starting test case execution 
	// This method launches the respective browser with application url provided in the config file
	    
	@BeforeMethod
	public void lanuchApp() //throws Exception
	{   
		LaunchBrowser obj2=new LaunchBrowser();
		driver=obj2.loadBrowser(driver);
				
	}
	
	// Test Case 1: Reads the data from test data sheet for the matching test case TC001,
	//passed to AUI during execution
	@Test
	public void Test1() //throws InterruptedException, IOException
	{	
		System.out.println("************ Test Case - TC001 ***********");
		TestData obj1=new TestData();
	    inputData=obj1.ReadExcelData("TC001", inputData);
	    SignupHome obj2=new SignupHome(driver,inputData);
		PlanHome obj3=new PlanHome(driver,inputData);
		YourNewHomePlan obj4=new YourNewHomePlan(driver,inputData);
				
	}
	
	// Test Case 2: Reads the data from test data sheet for the matching test case TC002,
	//passed to AUI during execution
	
	@Test
	public void Test2() //throws InterruptedException, IOException
	{	
		System.out.println("************ Test Case - TC002 ***********");
		TestData obj1=new TestData();
	    inputData=obj1.ReadExcelData("TC002", inputData);
	    SignupHome obj2=new SignupHome(driver,inputData);
		PlanHome obj3=new PlanHome(driver,inputData);
		YourNewHomePlan obj4=new YourNewHomePlan(driver,inputData);
	}
	
	// Test Case 3: Reads the data from test data sheet for the matching test case TC002, 
	// passed to AUI during execution
	
	@Test
	public void Test3() //throws InterruptedException, IOException
	
	{	System.out.println("************ Test Case - TC003 ***********");
		TestData obj1=new TestData();
	    inputData=obj1.ReadExcelData("TC003", inputData);
	    SignupHome obj2=new SignupHome(driver,inputData);
		PlanHome obj3=new PlanHome(driver,inputData);
		YourNewHomePlan obj4=new YourNewHomePlan(driver,inputData);
	}
	
	// Test Case 4: Reads the data from test data sheet for the matching test case TC002,
	//passed to AUI during execution
		@Test
	public void Test4() //throws InterruptedException, IOException
	{	System.out.println("************ Test Case - TC004 ***********");
		TestData obj1=new TestData();
	    inputData=obj1.ReadExcelData("TC004", inputData);
	    SignupHome obj2=new SignupHome(driver,inputData);
		PlanHome obj3=new PlanHome(driver,inputData);
		YourNewHomePlan obj4=new YourNewHomePlan(driver,inputData);
				
	}
		
	// Test Case 5: Reads the data from test data sheet for the matching test case TC002,
	//passed to AUI during execution
		
	@Test
	public void Test5() //throws InterruptedException, IOException
	{	System.out.println("************ Test Case - TC005 ***********");
		TestData obj1=new TestData();
	    inputData=obj1.ReadExcelData("TC005", inputData);
	    SignupHome obj2=new SignupHome(driver,inputData);
		PlanHome obj3=new PlanHome(driver,inputData);
		YourNewHomePlan obj4=new YourNewHomePlan(driver,inputData);
				
	}
	
	
	@AfterMethod
	public void closeOperation()
	{
		driver.close();
		    int result = Reporter.getCurrentTestResult().getStatus();
		    if(ITestResult.FAILURE == result){
		        System.out.println("AFTER METHOD IN FAILURE:: "+result);
		    }else if(ITestResult.SUCCESS == result){
		        System.out.println("AFTER METHOD IN SUCCESS:: "+result);
		    }
		    else if(ITestResult.SKIP == result){
		        System.out.println("AFTER METHOD IN SKIP :: "+result);
		    }
		
		
	}
	
	
	


}        