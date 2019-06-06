package com.test.PefinWebApp;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PlanHome {

	
	WebDriver driver;
	HashMap<String,String> inputData;
	
	By state=By.xpath("//Select[@class='dropdown-select']");
	By city=By.id("home-input-city-select");
	By zipCode=By.id("home-input-zipcode-select");
	By date=By.xpath("//*[@id='date-input-component']//input");
	
	By creditScoreExcellent=By.xpath("//*[contains(text(),'Excellent')]");
	By creditScoreGood=By.xpath("//*[contains(text(),'Good')]");
	By creditScoreFair=By.xpath("//*[contains(text(),'Fair')]");
	By creditScorePoor=By.xpath("//*[contains(text(),'Poor')]");
	By creditScoreBad=By.xpath("//*[contains(text(),'Bad')]");
	
	By upfrontInstallment=By.xpath("//*[@id='home-input-form']/div/div[4]/div[2]/div[1]/currency-input/div/div[2]/div/input");
	By monthlyInstallment=By.xpath("//*[@id='home-input-form']/div/div[4]/div[2]/div[2]/currency-input/div/div[2]/div/input");
	By submitForm=By.xpath("//*[@id='home-input-form']/input");
	
	public PlanHome(WebDriver driver,HashMap<String,String> inputData) //throws InterruptedException
	{
		 try
		 {
				this.driver=driver;
				this.inputData=inputData;
				
				//Select State
				WebElement dropdown=driver.findElement(state);
				Select statedropdown= new Select(dropdown);
				statedropdown.selectByVisibleText(inputData.get("State"));
				
				//Select City
				driver.findElement(state).sendKeys(Keys.TAB);
				Thread.sleep(5000);
				WebElement element= driver.findElement(city);
				element.sendKeys(inputData.get("City"));	
				Thread.sleep(5000);
				element.sendKeys(Keys.TAB);
				
				        
				//zipcode 
				driver.findElement(zipCode).sendKeys(inputData.get("ZIPCODE"));
				
				//Date
				driver.findElement(date).sendKeys(inputData.get("DATE"));
				Thread.sleep(3000);
				
				//CreditScore
				if(inputData.get("CreditScore").equals("Excellent"))
						{ driver.findElement(creditScoreExcellent).click();	}
				else if(inputData.get("CreditScore").equals("Good"))
						{ driver.findElement(creditScoreGood).click();	}
				else if(inputData.get("CreditScore").equals("Fair"))
						{ driver.findElement(creditScoreFair).click();	}
				else if (inputData.get("CreditScore").equals("Poor"))
				{ driver.findElement(creditScorePoor).click();	}
				else  
				{ driver.findElement(creditScoreBad).click();	}
				
				//UpfrontInstallment Amount
				driver.findElement(upfrontInstallment).sendKeys(inputData.get("UpfrontInstallmentAmount")); 
				
				//MonthlyInstallment Amount
				driver.findElement(monthlyInstallment).sendKeys(inputData.get("MonthlyInstallmentAmount")); 
				
				driver.findElement(submitForm).click();
		 }
		 catch(Exception e)
		 {
			 System.out.println(e.getMessage());
		 }
	}
	
	
}