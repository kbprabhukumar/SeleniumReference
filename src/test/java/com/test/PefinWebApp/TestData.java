package com.test.PefinWebApp;

import java.util.HashMap;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;



import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestData {

	HashMap<String,String> inputData;
	
	public HashMap ReadExcelData(String testCaseRef, HashMap inputData) //throws IOException
	{   
		try
		{
		File prosrc=new File("./configs/Config.property");
		FileInputStream profis= new FileInputStream(prosrc);
		Properties pro=new Properties();
		pro.load(profis);
        String testDataFilePath=pro.getProperty("testDataFilePath");
        
		inputData=new HashMap<String,String>();
		File src=new File(testDataFilePath);
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		
		this.inputData=inputData;
		String testCase=testCaseRef;
	    String testCasedata;
		int rowcount=sheet.getLastRowNum();
		
		System.out.println(rowcount);
		for (int i=1 ; i<=rowcount ;i++){
			testCasedata=sheet.getRow(i).getCell(0).getStringCellValue();
			
			
			if (testCasedata.equals(testCase))
			{
				inputData.put("TestCase",sheet.getRow(i).getCell(0).getStringCellValue());
				inputData.put("EmailID",sheet.getRow(i).getCell(1).getStringCellValue());
				inputData.put("State",sheet.getRow(i).getCell(2).getStringCellValue());
				inputData.put("City",sheet.getRow(i).getCell(3).getStringCellValue());
				inputData.put("ZIPCODE",String.valueOf((int)(sheet.getRow(i).getCell(4).getNumericCellValue())));
				inputData.put("DATE",sheet.getRow(i).getCell(5).getStringCellValue());
				
				inputData.put("CreditScore",sheet.getRow(i).getCell(6).getStringCellValue());
				inputData.put("UpfrontInstallmentAmount",String.valueOf((int)(sheet.getRow(i).getCell(7).getNumericCellValue())));
				inputData.put("MonthlyInstallmentAmount",String.valueOf((int)(sheet.getRow(i).getCell(8).getNumericCellValue())));
				
				inputData.put("ExpectedNewHomePlanPageTitle",sheet.getRow(i).getCell(9).getStringCellValue());
				inputData.put("ExpectedHomeValue",sheet.getRow(i).getCell(10).getStringCellValue());
				inputData.put("ExpectedArea",sheet.getRow(i).getCell(11).getStringCellValue());
				inputData.put("ExpectedTotalSpendingUpfront",sheet.getRow(i).getCell(12).getStringCellValue());
				inputData.put("ExpectedYourMortgage",sheet.getRow(i).getCell(13).getStringCellValue());
				
				
				
			}
			
			
		}
		System.out.println(inputData);
		//wb.
		
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally {
			return this.inputData;
		}
		
	}  
}
