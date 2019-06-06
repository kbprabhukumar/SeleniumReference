package com.test.PefinWebApp;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class YourNewHomePlan {
	
	
				By pageName=By.xpath("//*[@id='free-plan-container']/div[1]/div[1]/div[1]/div");
				By ActualNewHomePlanPageTitle=By.xpath("//*[@id='free-plan-container']/div[1]/div[1]/div[1]/div");
				By ActualTotalSpendingUpfront=By.xpath("//*[@id='free-plan-container']/div[1]/div[7]/div[1]/div/div[2]");
				By ActualExpectedYourMortgage=By.xpath("//*[@id='free-plan-container']/div[1]/div[11]/div[1]/div/div[2]");
				By ActualHomeValue=By.xpath("//*[@id='free-plan-container']/div[1]/div[3]/div[1]/div[2]/span");
				By ActualArea=By.xpath("//*[@id='free-plan-container']/div[1]/div[3]/div[2]/div[2]/span");
				
				WebDriver driver;
				HashMap<String,String> inputData;
				
				String pageNameExpected="Your new home plan";
				
				public YourNewHomePlan(WebDriver driver,HashMap<String,String> inputData) //throws InterruptedException
				{
					try
					{
					this.driver=driver;
					this.inputData=inputData;
					
					Thread.sleep(3000);
				    //Assert.assertEqual(String actual,String expected) 
					Assert.assertEquals(driver.findElement(ActualNewHomePlanPageTitle).getText(),pageNameExpected,"ERROR");
					Assert.assertEquals(driver.findElement(ActualHomeValue).getText(),inputData.get("ExpectedHomeValue"),"ERROR");
					Assert.assertEquals(driver.findElement(ActualArea).getText(),inputData.get("ExpectedArea"),"ERROR");
					Assert.assertEquals(driver.findElement(ActualTotalSpendingUpfront).getText(),inputData.get("ExpectedTotalSpendingUpfront"),"ERROR");
					Assert.assertEquals(driver.findElement(ActualExpectedYourMortgage).getText(),inputData.get("ExpectedYourMortgage"),"ERROR");
					
				    			    }
					catch(Exception e)
					 {
						 System.out.println(e.getMessage());
					 }
	  }
	
	
	
}

