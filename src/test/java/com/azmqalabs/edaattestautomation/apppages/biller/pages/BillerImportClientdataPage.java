/**
* Test Script Name  				 : N/A
* Objective                          :Verify to download the bulk sheet.
* Version      						 : 1.0
* Author       						 : Arun Kumar MS
* Created Date 			      		 : 11/08/2023
* Last Updated on					 : N/A
* Updated By   			 			 : Basavaraj Mudnur
* Pre-Conditions					 : N/A
* Manual Test case Name				 : N/A
* Epic Details						 : N/A
* User Story Details				 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.biller.pages;


import java.io.File;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.azmqalabs.edaattestautomation.common.Log;



public class BillerImportClientdataPage extends BasePage
{

	public BillerImportClientdataPage(WebDriver driver,ExtentTest test)
	{
		 this.driver=driver;
		 this.test=test;
		 
		 PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  
	

	@FindBy(xpath = EdaatOR.Biller_importclientsym)
	public WebElement ImportClientsData;
		
	    
	    public boolean Exists(){
	    	return super.Exists(ImportClientsData); 
		}
	  //Function Summary : Method to Select Individual Client radio Button. 
	  	//Parameter Summary: N/A.
	    public void ClickOnIndividualRadBtn() throws Exception
	    {
	    	WebClick(EdaatOR.Biller_IndivRdnBtn);
	    }
	  //Function Summary : Method to Select corporate Client radio Button. 
	  	//Parameter Summary: N/A.
	    public void ClickOnCoporateRadBtn() throws Exception
	    {
	    	WebClick(EdaatOR.Biller_CarpoRdnBtn);
	    }
	    //Function Summary : Method to Select Individual Client radio Button. 
	  	//Parameter Summary: N/A.
	    public void ClickOnDownloadIndividual() throws Exception
	    {
	    	WebClick(EdaatOR.Biller_IndDownimg);
	    }
	  //Function Summary : Method to Select corporate Client radio Button. 
	  	//Parameter Summary: N/A.
	    public void ClickOnDownloadCorporate() throws Exception
	    {
	    	WebClick(EdaatOR.Biller_CorpDownimg);
	    }

		// Function Summary : Method to Select corporate/Individual Client radio Button.
		// Parameter Summary: Customertype.
		public void Selectradiobtn1(Map<Object, Object> testdatamap, Log log) throws Exception {
			try {
				String client = testdatamap.get("Customertype").toString();
				if (client.equalsIgnoreCase("Corporates")) {
					ClickOnCoporateRadBtn();
					Thread.sleep(3000);
					if (getText(EdaatOR.Biller_Corporate_type_verify).equals("Corporate Data Form")) {
						log.ReportEvent("PASS", " Select 'Corporates' Type of The Customer is Successful");
						ClickOnDownloadCorporate();
						log.ReportEvent("PASS", "Download Import Client Data is Suceessful");
					} else {
						log.ReportEvent("FAIL", " Select 'Corporates' Type of The Customer is not Successful");
						takeScreenShot();
						driver.quit();
						Assert.fail();
					}
				} else {
					if (getText(EdaatOR.Biller_Individual_type_verify).equals("Individual Data Form")) {
						log.ReportEvent("PASS", " Select 'Individual' Type of The Customer is Successful");
						ClickOnIndividualRadBtn();
						Thread.sleep(3000);
						ClickOnDownloadIndividual();
						log.ReportEvent("PASS", "Download Import Client Data is Successful");
					} else {
						log.ReportEvent("FAIL", " Select 'Indiviuals' Type of The Customer is not Successful");
						takeScreenShot();
						driver.quit();
						Assert.fail();
					}
				}
			} catch (Exception e) {
				log.ReportEvent("FAIL", "Download Import Client Data is not Successful");
				takeScreenShot();
				driver.quit();
				Assert.fail();

			}
		}
	    
	    public void Selectradiobtn(Map<Object, Object> testdatamap) throws Exception
	    {
	    	String client=testdatamap.get("Customertype").toString();
			if(client.equalsIgnoreCase("Corporates")) {
				ClickOnCoporateRadBtn();
				Thread.sleep(3000);			
				
			}
			else{
				ClickOnIndividualRadBtn();
				Thread.sleep(3000);
			}
	    }
	  //Function Summary : Method to download Import client data. 
	//Parameter Summary: N/A.
	    public void downloadImportClientdata(Map<Object, Object> testdatamap,Log Log)
        {
            try {
                WebClickUsingJS(EdaatOR.Biller_Clientbtn);
                Thread.sleep(1000);
                WebClickUsingJS(EdaatOR.Biller_ImportClientbtn);
                Thread.sleep(2000);
                if(getText(EdaatOR.Biller_importclientsym).equals("Import Clients Data")) {
    			Log.ReportEvent("PASS", "'Import Clients Data' Page is Loaded Successfully");
                Selectradiobtn1(testdatamap, Log);
                Thread.sleep(3000);
                }
                else {
        			Log.ReportEvent("FAIL", "'Import Clients Data' Page is not Loaded Successfully");
        			takeScreenShot();
        			driver.quit();
        			Assert.fail();
				}
            }
            catch(Exception e){
               	Log.ReportEvent("FAIL", "Download import client data is not Successful");
                this.takeScreenShot();
                driver.quit();
    			Assert.fail();
            }        
                 }
	  //Function Summary : Method to ClickOnClientsLink
		//Parameter Summary: N/A
		 public void ClickOnClientsLink() {
		   WebClickUsingJS(EdaatOR.Biller_Clients_link);
		    waitForPageToLoad();
		 }
		//Function Summary : Method to ClickOnImportClientsLink
		//Parameter Summary: N/A
		 public void ClickOnImportClientsLink() {
			WebClickUsingJS(EdaatOR.Biller_ImportClientsData_Link);
			waitForPageToLoad();
				
			}
		//Function Summary : Method to NavigateClientsImportClientsData
		//Parameter Summary: N/A
		public void NavigateClientsImportClientsData(Log Log) 
		{
			try {
				ClickOnClientsLink();
				ClickOnImportClientsLink();
				Thread.sleep(2000);
				if(getText(EdaatOR.Biller_importclientsym).equals("Import Clients Data")) {
				Log.ReportEvent("PASS", "'Import Clients Data' Page is Loaded Successfully");
				}
				else {
					Log.ReportEvent("FAIL", "'Import Clients Data' Page is not Loaded Successfully");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			}
			catch (Exception e) {
				Log.ReportEvent("FAIL", "'Import Clients Data' Page is not Loaded Successfully");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}
		//Function Summary : Method to SelectTypeofCustomer
		//Parameter Summary: TypeCorporate,TypeIndividual
		public void SelectTypeofCustomer(Map<Object, Object> testdatamap,Log Log) {
			try
			{
			NavigateClientsImportClientsData(Log);
			WebClick(EdaatOR.Biller_Corporate_type_select);
			Thread.sleep(2000);
			if(getText(EdaatOR.Biller_Corporate_type_verify).equals("Corporate Data Form")) {
			     Log.ReportEvent("PASS", " Select 'Corporate Data Form' Type of The Customer is Successful");
				
			Thread.sleep(2000);
			WebClick(EdaatOR.Biller_Individual_type_select);
			Thread.sleep(2000);
			if (getText(EdaatOR.Biller_Individual_type_verify).equals("Individual Data Form")) {
			     Log.ReportEvent("PASS", " Select 'Individual Data Form' Type of The Customer is Successful");
				}
			else {
		        Log.ReportEvent("FAIL", " Select Type of The Customer is not Successful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
				}
			}
			else {
		        Log.ReportEvent("FAIL", " Select Type of The Customer is not Successful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
				}
			}
		catch(Exception e){
	        Log.ReportEvent("FAIL", " Select the type of the customer is not Successful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
			}
		}
		
		//Function Summary : Method to Import Clients Bulk Data
		//Parameter Summary:	
		public void ImportBulkData(Map<Object, Object> testdatamap,Log Log)
	    {
	    	try {
	    		NavigateClientsImportClientsData(Log);
	    		UploadClientBulkData(testdatamap,Log);
		        Thread.sleep(5000);
		        waitForPageToLoad();
		        Thread.sleep(3000);		 
			}
			catch(Exception e){
				Log.ReportEvent("FAIL", " Import Clients Bulk Data is not Successful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}    	
	    }	
		
	//Function Summary : Method to Import Clients Bulk Data
	   //Parameter Summary:Customertype,Individual
		public void UploadClientBulkData(Map<Object, Object> testdatamap, Log log) throws Exception
		{
			String client=testdatamap.get("Customertype").toString();
			if(client.equalsIgnoreCase("Individual")) {	
				
			WebClick(EdaatOR.Biller_IndivRdnBtn);
			Thread.sleep(1000);
			WebClickUsingActions(EdaatOR.Biller_import_AttachFile);
			Thread.sleep(3000);
			File classpathRoot = new File(System.getProperty("user.dir"));
	        File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//UploadBulkData.exe");
	        String sFilename = app.toString();
	        Runtime.getRuntime().exec(sFilename);
	        System.out.println(sFilename);
	        Thread.sleep(3000);
	        WebClickUsingJS(EdaatOR.Biller_ClientProcessButton);
	        Thread.sleep(2000);
	        if(ExistsCheck(EdaatOR.Biller_ClientConfirmUploadButton)) {
	        	 WebClickUsingJS(EdaatOR.Biller_ClientConfirmUploadButton);
	 	        Thread.sleep(10000);
        	log.ReportEvent("PASS", " Import Clients Bulk Data is Successful");
	        SerachIndividualClient(testdatamap,log);
	        }
			else {
				log.ReportEvent("FAIL", " Import Clients Bulk Data is not Successful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
	        }			
	        else if(client.equalsIgnoreCase("Corporate")){
				CorporateClientBulkData(testdatamap);
				Thread.sleep(3000);
				if(ExistsCheck(EdaatOR.Biller_ClientConfirmUploadButton)) {
			        WebClickUsingJS(EdaatOR.Biller_ClientConfirmUploadButton);
		        	log.ReportEvent("PASS", " Import Clients Bulk Data is Successful");
				CorporateClientsearch(testdatamap,log);
				}
				else {
					log.ReportEvent("FAIL", " Import Clients Bulk Data is not Successful");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			}
		}
		
		//Function Summary : Method to Import Corporate Clients Bulk Data
	   //Parameter Summary:N/A
		public void CorporateClientBulkData(Map<Object, Object> testdatamap) throws Exception
		{
			WebClick(EdaatOR.Biller_CarpoRdnBtn);
			WebClickUsingJS(EdaatOR.Biller_import_AttachFile);
			Thread.sleep(2000);
			File classpathRoot = new File(System.getProperty("user.dir"));
	        File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//UploadCorporateClientBulkData.exe");
	        String sFilename = app.toString();
	        Runtime.getRuntime().exec(sFilename);
	        System.out.println(sFilename);
	        Thread.sleep(2000);
	        WebClickUsingJS(EdaatOR.Biller_ClientProcessButton);
	        Thread.sleep(2000);
		}

		//Function Summary : Method to Search Individual Clients
	   //Parameter Summary:ClientName,NationalD,CRNumber
		public void SerachIndividualClient(Map<Object, Object> testdatamap, Log log) throws Exception
		{
			WebClickUsingJS(EdaatOR.Admin_Add_Individualclient);
			Thread.sleep(2000);
			WebEdit(EdaatOR.Biller_Individualclient_Cname,testdatamap.get("ClientName").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_Individualclient_IdNumber,testdatamap.get("NationalD").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_Individualclient_CustomerRefNumber,testdatamap.get("CRNumber").toString());
			Thread.sleep(1000);
			scrollDowntillend(driver);
			WebClickUsingJS(EdaatOR.Biller_Individualclient_Search);
			Thread.sleep(2000);
			VerifyValue1(getText("//td[text()='"+testdatamap.get("NationalD").toString()+"']"),testdatamap.get("NationalD").toString());
			if(getText("//td[text()='"+testdatamap.get("NationalD").toString()+"']").equals(testdatamap.get("NationalD").toString())) {
	        	log.ReportEvent("PASS", "Individual Client Search is Successful");
			}
			else {
				log.ReportEvent("FAIL", "Individual Client Search is Successful");
				takeScreenShot();
			}
				
		}
	public void CorporateClientsearch(Map<Object, Object> testdatamap,Log log) throws Exception
		{
			WebClickUsingJS(EdaatOR.Biller_Add_Companyclient);
        	Thread.sleep(2000);
        	WebEdit(EdaatOR.Biller_Corporateclient_Name,testdatamap.get("ClientName").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_Corporateclient_Rno,testdatamap.get("CRNumber").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_Corpoclient_CustomerRefNumber,testdatamap.get("ReferenceNumber").toString());
			Thread.sleep(1000);
        	WebClick(EdaatOR.Biller_Individualclient_Search);
        
			VerifyValue1(getText("//td[text()='"+testdatamap.get("CRNumber").toString()+"']"),testdatamap.get("CRNumber").toString());
			if(getText("//td[text()='"+testdatamap.get("CRNumber").toString()+"']").equals(testdatamap.get("CRNumber").toString())) {
	        	log.ReportEvent("PASS", "Corporate Client Search is Successful");
			}
			else {
	        	log.ReportEvent("FAIL", "Corporate Client Search is not Successful");
	        	takeScreenShot();
			}
		}

		//Function Summary : ImportClientData Page fields error validation
	    //Parameter Summary:ClientName,NationalD,CRNumber
	public void importClientdataErrormeaasgaeValidation(Map<Object,Object> testdatamap,Log log) {
		String Expected=testdatamap.get("ExpectedResult").toString();
		String ClientType = testdatamap.get("ClientType").toString();
		try {
			if(ClientType.equalsIgnoreCase("Individual")) {
				WebClick(EdaatOR.Biller_Individual_type_select);
				Thread.sleep(2000);
		        WebClickUsingJS(EdaatOR.Biller_ClientProcessButton);
		        if (Expected.equals(getText(EdaatOR.BillerImportClientdataError))) {
		        log.ReportEvent("PASS", "Validate Individual Attach Excel File Error Message is Successful");
		        }
		        else {
			        log.ReportEvent("FAIL", "Validate Individual Attach Excel File Error Message is not Successful");
			        takeScreenShot();
			        driver.quit();
			        Assert.fail();
		        }
		       }
			else if (ClientType.equalsIgnoreCase("Corporate") ) {
				WebClick(EdaatOR.Biller_Corporate_type_select);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Biller_ClientProcessButton);
				if(Expected.equals(getText(EdaatOR.BillerImportClientdataError))) {
				log.ReportEvent("PASS", "Validate Corporate Attach Excel File Error Message is Successful");				
				}
				else {
					log.ReportEvent("FAIL", "Validate Corporate Attach Excel File Error Message is not Successful");
					takeScreenShot();
					driver.quit();
					Assert.fail();
					}
		        }
			else if (ClientType.equalsIgnoreCase("Individual1")){
					WebClick(EdaatOR.Biller_IndivRdnBtn);
					Thread.sleep(1000);
					WebClickUsingActions(EdaatOR.Biller_import_AttachFile);
					Thread.sleep(3000);
					File classpathRoot = new File(System.getProperty("user.dir"));
					File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//EdaatLogo.exe");
					String sFilename = app.toString();
					Runtime.getRuntime().exec(sFilename);
					System.out.println(sFilename);
					Thread.sleep(3000);
					WebClickUsingJS(EdaatOR.Biller_ClientProcessButton);
					Thread.sleep(2000);
					WebClickUsingJS(EdaatOR.Biller_ClientConfirmUploadButton);
					Thread.sleep(10000);
				if(Expected.equals(getText(EdaatOR.BillerImportClientdataError)))
				{
					log.ReportEvent("PASS", "Validate Individual Attach File Error Message By Uploading Image is Successful");
				}
				else
				{
					log.ReportEvent("FAIL", "Validate Individual Attach File Error Message By Uploading Image is not Successful");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			}
			else if(ClientType.equalsIgnoreCase("Corporate1")){
				WebClick(EdaatOR.Biller_CarpoRdnBtn);
				WebClickUsingJS(EdaatOR.Biller_import_AttachFile);
				Thread.sleep(2000);
				File classpathRoot = new File(System.getProperty("user.dir"));
		        File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//EdaatLogo.exe");
		        String sFilename = app.toString();
		        Runtime.getRuntime().exec(sFilename);
		        System.out.println(sFilename);
		        Thread.sleep(2000);
		        WebClickUsingJS(EdaatOR.Biller_ClientProcessButton);
		        Thread.sleep(2000);
		        WebClickUsingJS(EdaatOR.Biller_ClientConfirmUploadButton);
		        
		        if(Expected.equals(getText(EdaatOR.BillerImportClientdataError)))
				{
					log.ReportEvent("PASS", "Validate Corporate Attach File Error Message By Uploading Image is Successful");
				}
				else
				{
					log.ReportEvent("FAIL", "Validate Corporate Attach File Error Message By Uploading Image is not Successful");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
				}
				
			}
				
		catch (Exception e) {
			log.ReportEvent("FAIL", "Validate Individual/Corporate Attach File Error Message is not Successful");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

}



