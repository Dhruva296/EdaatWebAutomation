/**
* Test Script Name  				 : N/A
* Objective     					 : Verify PaidOutsideEDAAT Functionality
* Version      						 : 1.0
* Author       						 : Basavaraj Mudnur
* Created Date 			      		 : 
* Last Updated on					 : N/A
* Updated By   			 			 : Basavaraj Mudnur
* Pre-Conditions					 : N/A
* Manual Test case Name				 : N/A
* Epic Details						 : N/A
* User Story Details				 : N/A
* Defects affecting this test script : N/A
* WorkArounds/Known Issues			 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.biller.pages;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.azmqalabs.edaattestautomation.common.Log;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;

public class BillerSettingsPaidOutsideEDAATBillsPage extends BasePage{
	public BillerSettingsPaidOutsideEDAATBillsPage(WebDriver driver,ExtentTest test) {

		this.driver=driver;
		this.test=test;

		PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  


	@FindBy(xpath = EdaatOR.Biller_Settings)
	public WebElement Setting;


	public boolean Exists(){
		return super.Exists(Setting); 
	}
	//Function Summary : Navigate to Paid OutsideBillsEdaatBills Page 
		//Parameter Summary: N/A
		public void navigatetoPaidOutsideBills(Log Log) {
		try {
			WebClickUsingJS(EdaatOR.Biller_Settings);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_PaidOutsidemenu);
			Thread.sleep(2000);
			if(ExistsCheck(EdaatOR.Biller_PaidOutsideEdaat_Page)) {
				Log.ReportEvent("PASS", "Paid Outside EDAAT Bills Page is Loaded Successfully");

			}
			else {
				Log.ReportEvent("FAIL", "Paid Outside EDAAT Bills Page is not Loaded Successfully");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();

			}
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "Paid Outside EDAAT Bills Page is not Loaded Successfully");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
		
		}
		
		//Function Summary : Method to upload Bulk data
		//Parameter Summary: ConfirmMsg
		public void uploadBulkData(Map<Object, Object> testdatamap,Log Log) throws InterruptedException, IOException  {
		try {
			WebClickUsingActions(EdaatOR.Biller_Attachfile);
			Thread.sleep(3000);
			File classpathRoot = new File(System.getProperty("user.dir"));
			File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//BillerSettingsPaidOutsideBills.exe");
			String sFilename = app.toString();
			Runtime.getRuntime().exec(sFilename);
			System.out.println(sFilename);
			Thread.sleep(2000);
			WebClick(EdaatOR.Biller_Proccesbtn);
			
			if(WebGetText(EdaatOR.Biller_successmsg).equals(testdatamap.get("ConfirmMsg").toString() )) {
			 	Log.ReportEvent("PASS", " Upload Bulk data Is Suceessful");

			}
			else {
			 	Log.ReportEvent("FAIL", " Upload Bulk data Is Unsuccessful");
			 	takeScreenShot();
			 	driver.quit();
			 	Assert.fail();
			}
		 	
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", " Upload Bulk data Is Unsuccessful");
		 	takeScreenShot();
		 	driver.quit();
		 	Assert.fail();
		}
			
			
		}
		
		public void  getAutoItImagePathFile1() throws Exception {
			File classpathRoot = new File(System.getProperty("user.dir"));
			Thread.sleep(800);
			File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//EdaatLogo.exe");
			String sFilename = app.toString();
			Thread.sleep(1000);
			Runtime.getRuntime().exec(sFilename);
			Thread.sleep(800);
		}
		
	
		public void PaidOutsideEdaatErrorMessageValidation(Map<Object, Object> testdatamap,Log Log) throws InterruptedException, IOException
		{
			try
			{
				String File = testdatamap.get("FileType").toString();
				
				if(File.equalsIgnoreCase("Invalid")) {
				WebClickUsingActions(EdaatOR.Biller_Attachfile);
				getAutoItImagePathFile1();
				}
				WebClick(EdaatOR.Biller_Proccesbtn);
				Thread.sleep(3000);
				String Expected=testdatamap.get("ExpectedResult").toString();

				if(getText(EdaatOR.Biller_Settings_PaidOutsideEdaatSelectFileError).equals(Expected)) {
					
			         Log.ReportEvent("PASS", "Error Message Validation for Upload Bulk Data is Successful");			
					
			     }
				else if(getText(EdaatOR.Biller_Settings_PaidOutsideEdaatInvalidFileError).equals(Expected)){
					
			         Log.ReportEvent("PASS", "Error Message Validation for Upload Bulk Data is Successful");			
				}	
				else {

			         Log.ReportEvent("FAIL", "Error Message Validation for Upload Bulk Data is Unsuccessful");	
			         takeScreenShot();
			         driver.quit();
			         Assert.fail();

					  }
			}
			catch (Exception e) {
				 Log.ReportEvent("FAIL", "Error Message Validation for Upload Bulk Data is Unsuccessful");	
		         takeScreenShot();
		         driver.quit();
		         Assert.fail();
			
			}
		

	
}
}
