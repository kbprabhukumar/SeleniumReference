package com.test.PefinWebApp;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupHome {

	WebDriver driver;
	HashMap<String,String> inputData;
	
	By SignupOptionEmail=By.xpath("//input[@class='cta vert icon-btn']");
	By emailId=By.xpath("//*[@id='email-signup-email-input']/div[1]/div/input");
	By continueButton=By.id("email-signup-button");
	
	public SignupHome(WebDriver driver,HashMap<String,String> inputData)
	{
		try {
				
				this.driver=driver;
				this.inputData=inputData;
				driver.findElement(SignupOptionEmail).click();
				driver.findElement(emailId).sendKeys(inputData.get("EmailID"));
				driver.findElement(continueButton).click();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
			
		
	
}
