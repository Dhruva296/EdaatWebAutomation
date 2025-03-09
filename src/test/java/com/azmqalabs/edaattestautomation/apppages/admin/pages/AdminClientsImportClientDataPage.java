/**
*
* Test Script Name                   : N/A
* Test Data Sheet                    : N/A
* Objective                          : Verify the Import Client Data Functionality.                                    
* Version                            : 1.0
* Author                             : Kathirvelu Mohan
* Created Date                       : 23/05/2023
* Last Updated on                    : N/A
* Updated By                         : Basavaraj Mudnur
* Pre-Conditions                     : N/A
* Epic Details                       : N/A
* User Story Details                 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;


import java.io.File;
import java.util.Map;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;



public class AdminClientsImportClientDataPage extends BasePage
{

	public AdminClientsImportClientDataPage(WebDriver driver,ExtentTest test)
	{
		 this.driver=driver;
		 this.test=test;
		 
		 PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  
	

	@FindBy(xpath = EdaatOR.Admin_ImportClientdatasym)
	public WebElement ImportClientsData;
		
	    
	    public boolean Exists(){
	    	return super.Exists(ImportClientsData); 
		}
	    //Function summary:Method to navigate import client data.
		//Function Parameters:N/A.
	    public void navigateImportClientdata(Log Log) throws Exception
	    {	    	
	    	WebClick(EdaatOR.Admin_ImportClientdatabtm);
			Thread.sleep(500);
	    	WebClick(EdaatOR.Admin_ImportClientdata);
			Thread.sleep(1000);
			if(CheckElementExists(EdaatOR.Admin_ImportClientdatasym)) {
				Log.ReportEvent("PASS", "Import Clients Data page is Loaded Successfully");
				}
				else{
					Log.ReportEvent("FAIL", "Import Clients Data page is not Loaded Successfully");
					this.takeScreenShot();
					driver.quit();Assert.fail();
				}
	    	
	    }
	    
	    
	  //Function summary:Method to verify the client type in import client data.
	  //Function Parameters:Corporate,Individual.

		public void VerifyClienttype(Map<Object, Object> testdatamap,Log Log) {
			// TODO Auto-generated method stub
			try{
				navigateImportClientdata(Log);
				WebClick(EdaatOR.Admin_ImportCorporateradiobtn);
				VerifyValue1(getText(EdaatOR.Admin_ImportCorporateradioImg),testdatamap.get("Corporate").toString());
				
				Thread.sleep(2000);
				WebClick(EdaatOR.Admin_ImportIndividualradiobtn);
				if(getText(EdaatOR.Admin_ImportIndividualradioImg).equals(testdatamap.get("Individual").toString())) {
				
	        	Log.ReportEvent("PASS", "Select the type of the customer is Successful");
				}
				else{
		        	Log.ReportEvent("FAIL", "Select the type of the customer is not Successful");
					this.takeScreenShot();
					driver.quit();Assert.fail();
				}
			}catch(Exception e){
	        	Log.ReportEvent("FAIL", "Select the type of the customer is not Successful");
				this.takeScreenShot();
				driver.quit();Assert.fail(); 
        }
   }
    	public void UploadClientBulkData(Map<Object, Object> testdatamap) throws Exception		
   	    {			
   	        String client=testdatamap.get("Customertype").toString();		
   	      	if(client.equalsIgnoreCase("Individual")) {			
   	      	WebClick(EdaatOR.Admin_ImportIndividualradiobtn);
			WebClickUsingJS(EdaatOR.Admin_ImportAttachExelFileBTN);
			Thread.sleep(2000);
			File classpathRoot = new File(System.getProperty("user.dir"));
	        File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//UploadBulkData.exe");
	        String sFilename = app.toString();
	        Runtime.getRuntime().exec(sFilename);
	        System.out.println(sFilename);
	        Thread.sleep(2000);
	        WebClickUsingJS(EdaatOR.Admin_ClientProcessButton);
	        Thread.sleep(2000);
	        WebClickUsingJS(EdaatOR.Admin_ClientConfirmUploadButton);
	        Thread.sleep(5000);
	        SerachIndividualClient(testdatamap);
			}
			else{
				CorporateClientBulkData(testdatamap);
				Thread.sleep(3000);
				SerachCorporateClient(testdatamap);
			}
		}
		
			
		public void CorporateClientBulkData(Map<Object, Object> testdatamap) throws Exception
		{
			WebClick(EdaatOR.Admin_ImportCorporateradiobtn);
			WebClickUsingJS(EdaatOR.Admin_ImportAttachExelFileBTN);
			Thread.sleep(2000);
			File classpathRoot = new File(System.getProperty("user.dir"));
	        File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//UploadCorporateClientBulkData.exe");
	        String sFilename = app.toString();
	        Runtime.getRuntime().exec(sFilename);
	        System.out.println(sFilename);
	        Thread.sleep(2000);
	        WebClickUsingJS(EdaatOR.Admin_ClientProcessButton);
	        Thread.sleep(2000);
	        WebClickUsingJS(EdaatOR.Admin_ClientConfirmUploadButton);
		}
		
		public void VerifyImportClientData(Map<Object, Object> testdatamap,Log Log) {
				// TODO Auto-generated method stub
			try{
				navigateImportClientdata(Log);
				
				UploadClientBulkData(testdatamap);
			    Thread.sleep(500);
			    if(CheckElementExists(EdaatOR.Admin_settings_ContentAttachErrorMsg)) {
					Log.ReportEvent("FAIL", "Import the bulk data is not Successful");
					this.takeScreenShot();
					driver.quit();Assert.fail();	
			    }
					else{
						Log.ReportEvent("PASS", "Import the bulk data is Successful");

					}
			}catch(Exception e){
				Log.ReportEvent("FAIL", "Import the bulk data is not Successful");
				this.takeScreenShot();
				driver.quit();Assert.fail();  
	        }
			
		}
		
		  //Function summary:Method to verify to Download the Bulk sheet.
		  //Function Parameters:Individual,Individual,Corporate.
		public void VerifyDownloadBulkSheet(Map<Object, Object> testdatamap,Log Log) {
			try{				
				navigateImportClientdata(Log);
				Thread.sleep(1000);	
				
				WebClick(EdaatOR.Admin_ImportIndividualradiobtn);
				VerifyValue1(getText(EdaatOR.Admin_ImportIndividualradioImg),testdatamap.get("Individual").toString());
				WebClick(EdaatOR.Admin_ImportIndividualradioImg);
				Thread.sleep(1000);		
		
				WebClick(EdaatOR.Admin_ImportCorporateradiobtn);
				if(getText(EdaatOR.Admin_ImportCorporateradioImg).equals(testdatamap.get("Corporate").toString())) {
				WebClick(EdaatOR.Admin_ImportCorporateradioImg);
				Thread.sleep(1000);		
	        	Log.ReportEvent("PASS", "Download the bulk sheet is Successful");
				}
				else{
		        	Log.ReportEvent("FAIL", "Download the bulk sheet is not Successful");
					this.takeScreenShot();
					driver.quit();Assert.fail();
					}
			}
			catch(Exception e){
	        	Log.ReportEvent("FAIL", "Download the bulk sheet is not Successful");
				this.takeScreenShot();
				driver.quit();Assert.fail();
        }
		}
		
		
		public void SerachIndividualClient(Map<Object, Object> testdatamap) throws Exception
		{
			WebClickUsingJS(EdaatOR.Admin_Add_Individualclient);
			WebEdit(EdaatOR.Admin_Individualclient_Name,testdatamap.get("ClientName").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Individualclient_IdNumber,testdatamap.get("NationalD").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Individualclient_CustomerRefNumber,testdatamap.get("CRNumber").toString());
			Thread.sleep(1000);
			scrollDowntillend(driver);
			WebClickUsingJS(EdaatOR.Admin_Individualclient_Search);
			Thread.sleep(2000);
			
			VerifyValue1(getText("//td[text()='"+testdatamap.get("NationalD").toString()+"']"),testdatamap.get("NationalD").toString());
		}
		public void SerachCorporateClient(Map<Object, Object> testdatamap) throws Exception
		{
			WebClickUsingJS(EdaatOR.Admin_Add_Companyclient);
			WebEdit(EdaatOR.Admin_CorporateclientName,testdatamap.get("ClientName").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Corporateclient_Rno,testdatamap.get("CRNumber").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Individualclient_CustomerRefNumber,testdatamap.get("ReferenceNumber").toString());
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Individualclient_Search);
			
			VerifyValue1(getText("//td[text()='"+testdatamap.get("CRNumber").toString()+"']"),testdatamap.get("CRNumber").toString());
		}
		
		//Function Summary  : method to verify Error messages in Import client data page
		//Parameter Summary : ExpectedResult		
	
		public void VerifyImportClientDataErrMsg(String ExpectedResult,Log Log) {
			try {
				Thread.sleep(1000);
				WebClick(EdaatOR.Admin_ClientProcessButton);
				
				if(ExpectedResult.equals (getText(EdaatOR.Admin_ClientUploadButtonErrMsg))){	
					Log.ReportEvent("PASS", "Verify Import Client Data error Message is successful");

				}
				else {
					Log.ReportEvent("FAIL", "Verify Import Client Data error Message is not successful");
					this.takeScreenShot();
					driver.quit();Assert.fail();
				}
			}
			catch(Exception e) {
				Log.ReportEvent("FAIL", "Verify Import Client Data error Message is not successful");
				this.takeScreenShot();
				driver.quit();Assert.fail();			}
			
		}
  }
	
	
    

