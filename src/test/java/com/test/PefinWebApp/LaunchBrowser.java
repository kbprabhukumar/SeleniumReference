package com.test.PefinWebApp;
/**
 * @author Prabhu Kumar
 * @KeyInputParameter: Webdriver Object  
 * @Functionality : Launches the respective webbrowser for given url based on the browser type updated in config file
 *  */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LaunchBrowser {
	WebDriver driver;
	public WebDriver loadBrowser(WebDriver driver1) //throws Exception
	{
		try
		{
				File src=new File("./configs/Config.property");
				FileInputStream fis= new FileInputStream(src);
				Properties pro=new Properties();
				pro.load(fis);
		        String browsername=pro.getProperty("browserName");
		        String url=pro.getProperty("applicaitonUrl");
		        String chromeDriverPath=pro.getProperty("chromeDriverPath");
		        String ieDriverPath=pro.getProperty("applicaitonUrl");
		        
		        this.driver=driver1;
		        
		         if (browsername.compareToIgnoreCase("Chrome")==0)	
		         {
		        	 System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		     		driver = new ChromeDriver();
		     		driver.manage().window().maximize();
		     		driver.get(url);
		     		
		     		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		     		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		     		
		     		
		         }
		         else if(browsername.compareToIgnoreCase("IE")==0)
		         {
		        	System.setProperty("webdriver.ie.driver", ieDriverPath);
		      		driver = new InternetExplorerDriver();
		        	
		        	//driver = new MicrosoftWebDriver();
		      		driver.manage().window().maximize();
		      		driver.get(url);
		      		
		      		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		      		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		         }
		         else
		         {
		        	//implement the code of other browser here
		         }
		         
				System.out.println(pro.getProperty("browserName"));
		}
		
		catch (Exception e)
		{
		System.out.println(e.getMessage());
		}

		finally 
		{
		return driver;
		}
	}

}
