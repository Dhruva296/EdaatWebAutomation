/**
*
* Test Script Name  				 : N/A
* Objective     					 : Biller settings Page Functionalities.
* Version      						 : 1.0
* Author       						 : Kathirvelu M
* Created Date 			      		 : 23/05/2023
* Last Updated on					 : N/A
* Updated By   			 			 : Obalanayak M S
* Pre-Conditions					 : N/A 
* Epic Details						 : N/A
* User Story Details				 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.biller.pages;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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



public class BillerSettingsPage extends BasePage
{

	public BillerSettingsPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  


	@FindBy(xpath = EdaatOR.Biller_Client)
	public WebElement Client;


	public boolean Exists(){
		return super.Exists(Client); 
	}

	//Function Summary : Method to create Invoice Template
	//Parameter Summary:TemplateArabic,TemplateEnglish,TemplateDescription,TemplateReferancecode,Recurring,InvoiceType
	public void AddInvoicetemplate(Map<Object,Object>testdatamap,Log Log){
		try{
			navigateToInvoicesTemplate(Log);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Add_Invoice_Button);
			Thread.sleep(2000);
			WebEdit(EdaatOR.Biller_Invoice_TemplateArabic,testdatamap.get("TemplateArabic").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_Invoice_TemplateEng,testdatamap.get("TemplateEnglish").toString());  
			Thread.sleep(1000);
			
			WebEdit(EdaatOR.Biller_Invoice_TemplateDisc,testdatamap.get("TemplateDescription").toString());  
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_Invoice_TemplateRefcode,testdatamap.get("TemplateReferancecode").toString());  
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_Invoice_Templateactideacti);  
			Thread.sleep(1000);
	
			WebClickUsingJS(EdaatOR.Biller_Invoice_TemplateBillpay);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Invoice_TemplateVeriable);
			Thread.sleep(2000);
			if(testdatamap.get("InvoiceType").toString().equalsIgnoreCase("Recurring")) {
				WebClickUsingJS(EdaatOR.Biller_Invoice_Templatetype);
			}
			else if(testdatamap.get("InvoiceType").toString().equalsIgnoreCase("OneTime")) {
				WebClickUsingJS(EdaatOR.Biller_Invoice_Templatetype_One); 
			}
		
			     WebClickUsingJS(EdaatOR.Biller_Individualclient_togle );
					Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_Invoice_Add);
			
			if(ExistsCheck(EdaatOR.Biller_Settings_TemplateArabicNameError)) {
				Log.ReportEvent("FAIL", "Invoice Template not Added Successfully.");
				takeScreenShot();
				driver.quit();
				Assert.fail();
		     }
			else if(ExistsCheck(EdaatOR.Biller_Settings_TemplateEngNameError)){
				Log.ReportEvent("FAIL", "Invoice Template not Added Successfully.");
				takeScreenShot();
				driver.quit();
				Assert.fail();

			}	
			else if(ExistsCheck(EdaatOR.Biller_Settings_TemplateInvoiceTypeError)){
				Log.ReportEvent("FAIL", "Invoice Template not Added Successfully.");
				takeScreenShot();
				driver.quit();
				Assert.fail();

			}	
			else {
				Log.ReportEvent("PASS", "Invoice Template Added Successfully.");

			}
		

		}catch(Exception e){
			Log.ReportEvent("FAIL", "Invoice Template not Added Successfully.");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	//Function Summary : Method to Search Invoice Template
	//Parameter Summary: InvoiceType
	public boolean SearchInvoiceTemplate(Map<Object,Object>testdatamap,Log Log){
		boolean existsElement = false;
		try{

			WebEdit(EdaatOR.Biller_Individualclient_Name,testdatamap.get("TemplateEnglish").toString());
			Thread.sleep(2000);

			WebClickUsingJS(EdaatOR.Biller_Subbiller_Search);
			Thread.sleep(1000);
			if(CheckElementExists("//td[text()='"+testdatamap.get("TemplateEnglish").toString()+"']")==true) {
				existsElement=true;
				Log.ReportEvent("PASS","Invoice Template Search is Sucessfull");
				
			}
			else {
				Log.ReportEvent("FAIL","Invoice Template Search is Unsucessfull");
				takeScreenShot();
				driver.quit();
				Assert.fail();

				
			}
				    	

		}catch(Exception e){
			Log.ReportEvent("FAIL","Invoice Template Search is Unsucessfull");
			takeScreenShot();
			driver.quit();
			Assert.fail();

			
		}
		return existsElement;
	}
		//Function Summary   : Method to add product in Product management Section.
		//Parameter Summary : ProdArabic,ProdEnglish,Category,BasicPrice.

	public void AddProduct(Map<Object,Object>testdatamap,Log Log){
		try{
			WebClickUsingJS(EdaatOR.Biller_Settings);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Product_Management);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Prod_Addbutton);
			Thread.sleep(2000);
			WebEdit(EdaatOR.Biller_Prod_NameArabic,testdatamap.get("ProdArabic").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_Invoice_TemplateEng,testdatamap.get("ProdEnglish").toString());  
			Thread.sleep(1000);
			WebSelect1(EdaatOR.Biller_Invoice_Select,testdatamap.get("Category").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_ProdReferenceCode, testdatamap.get("ReferenceCode").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_Prod_Price,testdatamap.get("BasicPrice").toString());  
			Thread.sleep(1000);
			if(testdatamap.get("Activation").toString().equals("Activation"))
			{
				WebClickUsingJS(EdaatOR.Biller_Prod_Toggle);
				WebClickUsingJS(EdaatOR.Biller_Invoice_Add);
			}
			
			else{
				WebClickUsingJS(EdaatOR.Biller_Invoice_Add);
				
			}

			  if(ExistsCheck(EdaatOR.Biller_Settings_ProArabicNameError)) {
				  Log.ReportEvent("FAIL", "Product is not Added Successfully");
				  takeScreenShot();
				  driver.quit();
				  Assert.fail();
			     }
				else if(ExistsCheck(EdaatOR.Biller_Settings_ProEngNameError)){
					 Log.ReportEvent("FAIL", "Product is not Added Successfully");
					  takeScreenShot();
					  driver.quit();
					  Assert.fail();
				}
				else if(ExistsCheck(EdaatOR.Biller_Settings_ProductCategoryError)){
					 Log.ReportEvent("FAIL", "Product is not Added Successfully");
					  takeScreenShot();
					  driver.quit();
					  Assert.fail();

				}
				else if(ExistsCheck(EdaatOR.Biller_Settings_ProductBasePriceError)){
					 Log.ReportEvent("FAIL", "Product is not Added Successfully");
					  takeScreenShot();
					  driver.quit();
					  Assert.fail();

				}
				else if(ExistsCheck(EdaatOR.Biller_Settings_ProArabicNameError)){
					 Log.ReportEvent("FAIL", "Product is not Added Successfully");
					  takeScreenShot();
					  driver.quit();
					  Assert.fail();
				}
				else if(ExistsCheck(EdaatOR.Biller_Settings_ProductReferenceCodeError)){
					 Log.ReportEvent("FAIL", "Product is not Added Successfully");
					  takeScreenShot();
					  driver.quit();
					  Assert.fail();
				}
				else {
					 Log.ReportEvent("PASS", "Product is Added Successfully");
                     }
			

		}catch(Exception e){
			
				 Log.ReportEvent("FAIL", "Product is not Added Successfully");
				  takeScreenShot();
				  driver.quit();
				  Assert.fail();
		}
	}

	//Function Summary   : Method to Navigate invoice Template in settings module.
	//Parameter Summary : N/A.
	public void navigateToInvoicesTemplate(Log Log) throws Exception {
		try {
		WebClickUsingJS(EdaatOR.Biller_Settings);
		Thread.sleep(200);
		WebClickUsingJS(EdaatOR.Biller_Invoice_template);
		Thread.sleep(2000);
		if(ExistsCheck(EdaatOR.Biller_Invoice_template_Page)) {
	    	Log.ReportEvent("PASS", "Invoices Templates Page is Loaded Successfully");
		}
		else {
	    	Log.ReportEvent("FAIL", "Invoices Templates Page is Loaded Successfully");
            takeScreenShot();
            driver.quit();
            Assert.fail();
		}
		
	}catch(Exception e){
		Log.ReportEvent("FAIL", "Invoices Templates Page is Loaded Successfully");
        takeScreenShot();
        driver.quit();
        Assert.fail();

	}

	}

	//Function Summary   : Method to Verify Invoice Template fields in Invoice Template Popup.
	//Parameter Summary : AddTemplateHeadr.
	public void verfiyInvoiceTemplateVariables(Map<Object,Object>testdatamap,Log Log) throws Exception {
		try {
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Biller_Add_Invoice_Button);
		Thread.sleep(2000);
		if(getText(EdaatOR.Biller_Tamplate_AddTitleHdr).equals(testdatamap.get("AddTemplateHeadr").toString())) {
			Thread.sleep(1000);
			verifyElementIsPresent(EdaatOR.Biller_Tamplate_AddTemplNameArbicHdr);
			verifyElementIsPresent(EdaatOR.Biller_Tamplate_AddTemplNameEngHdr);
			verifyElementIsPresent(EdaatOR.Biller_Tamplate_AddRefercodeHdr);
			verifyElementIsPresent(EdaatOR.Biller_Tamplate_AddActDdeacHdr);
			verifyElementIsPresent(EdaatOR.Biller_Tamplate_AddBillPaymentyHdr);
			Thread.sleep(2000);
	    	Log.ReportEvent("PASS", " Invoice Template Variables Verified Successfully.");
		}
		else {
	    	Log.ReportEvent("FAIL", " Invoice Template Variables not Verified Successfully.");
            takeScreenShot();
            driver.quit();
            Assert.fail();
			
		}
		
	}catch(Exception e){
		Log.ReportEvent("FAIL", " Invoice Template Variables not Verified Successfully.");
        takeScreenShot();
        driver.quit();
        Assert.fail();
	}
	}

	//Function Summary   : Method to verify view Invoice Template Button
	//Parameter Summary : AddTemplateHeadr.
	public void verfiyViewInvoiceTemplate(Map<Object,Object>testdatamap,Log Log) throws Exception {
		try {
			Thread.sleep(1000);
			SearchInvoiceTemplate(testdatamap, Log);
			Thread.sleep(3000);
			WebClickUsingJS(EdaatOR.Biller_Tamplate_Table+"[1]"+EdaatOR.Biller_Tamplate_UpdateBtn);
			Thread.sleep(2000);
			if(getText(EdaatOR.Biller_Tamplate_UpdateTitleHdr).equals(testdatamap.get("VeiwTempleteHeader").toString())){
				Log.ReportEvent("PASS", "View Invoice Details Button Verification is Successful.");
				
			}
			else {
				Log.ReportEvent("FAIL", "View Invoice Details Button verification is Unsuccessful.");
				takeScreenShot();
				driver.quit();
				Assert.fail();

			}
			
		}catch(Exception e){
			Log.ReportEvent("FAIL", "View Invoice Details Button verification is Unsuccessful.");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}
	

	//Function Summary   : Method to Verify Delete Invoice Template in Grid View.
	//Parameter Summary : DeleteConfirmMes.
	public void verfiyDeleteInvoiceTemplate(Map<Object,Object>testdatamap,Log Log) throws Exception {
		try {
			    SearchInvoiceTemplate(testdatamap, Log);
				WebClickUsingJS(EdaatOR.Biller_Tamplate_Table+"[1]"+EdaatOR.Biller_Tamplate_DeleteBtn);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Biller_Tamplate_DeleteConfBtn);
				WebEdit(EdaatOR.Biller_Individualclient_Name,testdatamap.get("TemplateEnglish").toString());
				WebClickUsingJS(EdaatOR.Biller_Subbiller_Search);
				if(ExistsCheck(EdaatOR.Biller_Product_NoData)) {
					Log.ReportEvent("PASS", " Invoice Template is deleted Successfully.");

				}
			else {
				
				Log.ReportEvent("FAIL", "Invoice Template Deletion is Unsuccessful.");
				takeScreenShot();
				driver.quit();
				Assert.fail();

			}

		}catch(Exception e){
			Log.ReportEvent("FAIL", "Invoice Template Deletion is Unsuccessful.");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	public void verifyInvoiceTemplateDetails(Map<Object,Object>testdatamap,Log Log) throws Exception {
		String TemName=testdatamap.get("ActionTemplate").toString();
		switch(TemName) {

		case "Template":
			verfiyInvoiceTemplateVariables(testdatamap,Log);
			break;

		case "View":
			verfiyViewInvoiceTemplate(testdatamap,Log);
			break;

		case "Delete":
			verfiyDeleteInvoiceTemplate(testdatamap,Log);
			break;
		}

	}
	//Function Summary   : Method to Navigate Product management section in Settings Module.
	//Parameter Summary : Create Invoice,TemplateName.
	public void navigateToProductManagement(Log Log) throws Exception {
		try {
			
		WebClickUsingJS(EdaatOR.Biller_Settings);
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Biller_Product_Management);
		Thread.sleep(2000);
		if(ExistsCheck(EdaatOR.Biller_Product_Management_Page)) {
	    	Log.ReportEvent("PASS", "Product management Page is Loaded successfuly");

		}
		else {
	    	Log.ReportEvent("FAIL", "Product management Page is not Loaded successfuly");
	    	takeScreenShot();
	    	driver.quit();
	    	Assert.fail();

		}
	}catch(Exception e){
		Log.ReportEvent("FAIL", "Product management Page is not Loaded successfuly");
    	takeScreenShot();
    	driver.quit();
    	Assert.fail();
	}

	}

	public void EnterProductInputBox(String pname) throws Exception {
		if(!pname.equalsIgnoreCase(""))
			WebEdit(EdaatOR.Biller_Product_NameInput, pname);
	}

	public void SelectIdProductListBox(String lstname) {
		if(!lstname.equalsIgnoreCase(""))
			WebSelect1(EdaatOR.Biller_Product_SearchIDlist, lstname);
	}

	public void ClickOnSearchBtn() throws Exception {
		WebClickUsingJS(EdaatOR.Biller_Product_SeachBtn);
	}
	//Function Summary   : Method to Add product,Search product by Name and Category and active product.
	//Parameter Summary : ProdArabic,ProdEnglish,Category,Active.

	public void verifyProdutToggleStatus(Map<Object,Object>testdatamap,Log Log) throws IOException, Exception {
		try {
			
			WebClickUsingJS(EdaatOR.Biller_Product_ToggleBtn);
			Thread.sleep(5000);
			if (getText(EdaatOR.Biller_Product_ActivePop).toString().equals(testdatamap.get("Active").toString())) {
	            Thread.sleep(2000);
				WebClick(EdaatOR.Biller_Product_ActiveConfbtn);
	            Thread.sleep(2000);
	            Log.ReportEvent("PASS", " Product is Activated Successfully");
	        } else if (getText(EdaatOR.Biller_Systm_DeActive_toggle_Msg).toString().equals(testdatamap.get("Deactive").toString())) {
				WebClick(EdaatOR.Biller_Product_ActiveConfbtn);
	            Thread.sleep(3000);
	            Log.ReportEvent("PASS", "Product is Deactivated Successfully");
	        } else {
	            Log.ReportEvent("FAIL", "Activate/Deactivate Product is not Successful");
	            this.takeScreenShot();
	            driver.quit();
	            Assert.fail();
	        }
	      
	    } catch (Exception e) {
	            Log.ReportEvent("FAIL", "Activate/Deactivate Product is not Successful");
	            this.takeScreenShot();
	            driver.quit();
	            Assert.fail();
	        }   
	}
	//Function Summary   : Method to Add product,Search product by Name and Category and deactive product.
	//Parameter Summary : ProdArabic,ProdEnglish,Category,Active,Deactive.
	
	public void verifyDeActiveProductFunctionality(Map<Object,Object>testdatamap,Log Log) throws IOException, Exception {
		try {
			AddProduct(testdatamap,Log);
			Thread.sleep(5000);
			WebClickUsingJS(EdaatOR.Biller_Product_ToggleBtn);
			Thread.sleep(2000);
			VerifyValue1(getText(EdaatOR.Biller_Product_ActivePop), testdatamap.get("Active").toString());
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Product_ActiveConfbtn);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Product_ToggleBtn);
			Thread.sleep(2000);
			VerifyValue1(getText(EdaatOR.Biller_Product_ActivePop), testdatamap.get("Deactive").toString());
			WebClickUsingJS(EdaatOR.Biller_Product_ActiveConfbtn);
			test.log(Status.PASS,"Add product and De-active Template" + driver.getTitle() +" * Product Management PASS * " );	
        	Log.ReportEvent("PASS", " Verify Product Management Active/Deactivate functionality Is Suceessfull");
        	this.takeScreenShot();

		}
		
		catch(Exception e){
			test.log(Status.FAIL,"Add product and De-active Template" + driver.getTitle() +" * Product Management FAIL * " );
			this.takeScreenShot();

		}
	}
	//Function Summary   : Method to Search product by Name and Category if it's not present add product.
	//Parameter Summary : SearchProdName,SearchProdCateg,ProdArabic,pName,pCate,BasicPrice.

	public void SearchProduct(Map<Object,Object>testdatamap,Log Log) throws IOException, Exception {
		try {
			String pName=testdatamap.get("SearchProdName").toString();
			String pCate=testdatamap.get("SearchProdCateg").toString();
			EnterProductInputBox(pName);
			Thread.sleep(2000);
			SelectIdProductListBox(pCate);
			Thread.sleep(2000);
			ClickOnSearchBtn();
			Thread.sleep(5000);

			if(getText(EdaatOR.Biller_Product_Table+"[1]/td[3]").equals(pName) ) {
				
				Log.ReportEvent("PASS", "Product Search is Successful");
			
			}
			else {
				Log.ReportEvent("FAIL", "Product Search is not Successful");
                takeScreenShot();
                driver.quit();
                Assert.fail();
				
			}

		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Product Search is not Successful");
            takeScreenShot();
            driver.quit();
            Assert.fail();
		}
	}
	
	//Function Summary   : Method to Attach Excel.
	//Parameter Summary  : N/A.	
	public void  getAutoItImagePathFile() throws Exception {
		File classpathRoot = new File(System.getProperty("user.dir"));
		Thread.sleep(800);
		File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//Upload Bills cancellation.exe");
		String sFilename = app.toString();
		Thread.sleep(1000);
		Runtime.getRuntime().exec(sFilename);
		Thread.sleep(800);
	}
	
//Function Summary  : Method to upload Bulk data for bills cancellation.
//Parameter Summary : N/A

		public void VerifyUploadBulkData(Log Log) throws IOException, Exception {
			try {
				WebClickUsingJS(EdaatOR.Biller_Settings);
				Thread.sleep(800);
				WebClickUsingJS(EdaatOR.Biller_BillsCancellation);
				Thread.sleep(800);
				WebClickUsingActions(EdaatOR.Biller_AttachExcel);
				Thread.sleep(800);
				getAutoItImagePathFile();
				Thread.sleep(800);
				WebClickUsingJS(EdaatOR.Biller_ProcessBtn);
				Thread.sleep(800);
				if(ExistsCheck(EdaatOR.Biller_SuccessfulMsg)) {
					Log.ReportEvent("PASS", " Upload bulk data for bills cancellation is Successful");

				}
				else {
					Log.ReportEvent("FAIL", " Upload bulk data for bills cancellation is Unsuccessful");
					this.takeScreenShot();
                    driver.quit();
                    Assert.fail();
				}
			}
			catch(Exception e){
				Log.ReportEvent("FAIL", " Upload bulk data for bills cancellation is Unsuccessful");
				this.takeScreenShot();
                driver.quit();
                Assert.fail();
				
			}
			
		}
	//Function Summary  : Method to Navigate to Settings Content Management
	//Parameter Summary : N/A
		public void NavigatetoSettingsContentManagement(Log Log) throws InterruptedException
		{
			try {
			WebClickUsingJS(EdaatOR.Biller_Settings);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Settings_contentMng);
			
			Thread.sleep(1000);
			if(ExistsCheck(EdaatOR.Biller_Settings_contentMng_Page)){
	  			Log.ReportEvent("PASS", " Content Management Page is Loaded Successfully");

			}
			else {
	  			Log.ReportEvent("FAIL", " Content Management Page is not Loaded Successfully");
  			    this.takeScreenShot();
  			    driver.quit();
  			    Assert.fail();
			}
		}
			catch (Exception e) {
				
				Log.ReportEvent("FAIL", " Content Management Page is not Loaded Successfully");
  			    this.takeScreenShot();
  			    driver.quit();
  			    Assert.fail();
			}
		}
//Function Summary  : Method to Navigate to Settings Content Management
//Parameter Summary : N/A
	public void NavigatetoSettingsBillsCancellation(Log Log) throws InterruptedException
	{
		try {
			WebClickUsingJS(EdaatOR.Biller_Settings);
			Thread.sleep(800);
			WebClickUsingJS(EdaatOR.Biller_BillsCancellation);
		
		Thread.sleep(1000);
		if(ExistsCheck(EdaatOR.Biller_BillsCancellation_Page)){
  			Log.ReportEvent("PASS", " Bills Cancellation Page is Loaded Successfully");

		}
		else {
  			Log.ReportEvent("FAIL", " Bills Cancellation Page is not Loaded Successfully");
		    this.takeScreenShot();
		    driver.quit();
		    Assert.fail();
		}
	}
		catch (Exception e) {
			
			Log.ReportEvent("FAIL", " Bills Cancellation Page is not Loaded Successfully");
		    this.takeScreenShot();
		    driver.quit();
		    Assert.fail();
		}
	}
	//Function Summary  : Method to gettheAutoItFilepath
	//Parameter Summary : N/A
		public void gettheAutoItFilepath() throws IOException, InterruptedException {
			File classpathRoot = new File(System.getProperty("user.dir"));
			Thread.sleep(800);
			File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//BillerSettingsContentManagement.exe");
			String sFilename = app.toString();
			Thread.sleep(1000);
			Runtime.getRuntime().exec(sFilename);
			Thread.sleep(800);		
		}
		//Function Summary  : Method to VerifyToUploadBulkData
		//Parameter Summary : N/A
		public void VerifyToUploadBulkData(Map<Object, Object> testdatamap,Log Log) throws InterruptedException
			{ boolean upload=false;
			  boolean client=false;
			  boolean product = false;

				try
				{  
					WebClickUsingActions(EdaatOR.Biller_AttachExcel);
					Thread.sleep(800);
					gettheAutoItFilepath();
					Thread.sleep(2000);
					WebClick(EdaatOR.Biller_Settings_Content_src);
					Thread.sleep(2000);
					Thread.sleep(2000);
					upload=true;
					if(getText("//span[text()='"+testdatamap.get("Upload").toString()+"']").equals(testdatamap.get("Upload").toString())) {
						Log.ReportEvent("PASS", "Upload Bulk data is Successful");
					}
					else {
						Log.ReportEvent("FAIL", "Upload Bulk data is Unsuccessful");
						takeScreenShot();
						driver.quit();
						Assert.fail();
					}
					
					Thread.sleep(2000);
					WebClickUsingJS(EdaatOR.Biller_Add_Individualclient);
					Thread.sleep(2000);
					WebEdit(EdaatOR.Biller_Individualclient_IdNumber,testdatamap.get("NationalID").toString());
					Thread.sleep(3000);
					WebEdit(EdaatOR.Biller_Individualclient_CustomerRefNumber,testdatamap.get("ClientReferenceNumber").toString());
		        	Thread.sleep(3000);
		        	WebClickUsingJS(EdaatOR.Biller_Individualclient_Search);
		        	Thread.sleep(10000);
		        	
		        	WebClickUsingJS(EdaatOR.Biller_Individualclient_Search);
		        	Thread.sleep(5000);
		        	if(getText(EdaatOR.Biller_SettingContentMngVerifyNationalid).equals(testdatamap.get("NationalID").toString())) {
		        		Log.ReportEvent("PASS", "Individual Client Search is Successful");
		        	}
		        	else {
		        		Log.ReportEvent("FAIL", "Individual Client Search is Unsuccessful");
		        		takeScreenShot();
		        		driver.quit();
		        		Assert.fail();

		        	}
		        	  
		        	
		        	WebClickUsingJS(EdaatOR.Biller_Product_Management);
		        	Thread.sleep(3000);
		        	WebEdit(EdaatOR.Biller_Product_NameInput, testdatamap.get("ProductName").toString());
		        	Thread.sleep(3000);		        
		        	WebClick(EdaatOR.Biller_Product_SeachBtn);
		        	Thread.sleep(5000);
		        	WebClick(EdaatOR.Biller_Product_SeachBtn);
		        	Thread.sleep(3000);
		        	product=true;
		        	if(getText(EdaatOR.Biller_Product_Table+"[1]/td[3]").equals(testdatamap.get("ProductName").toString())) {
			  			Log.ReportEvent("PASS", " Product Search is Successful");
			  			
		        	}
		        	else {
			  			Log.ReportEvent("FAIL", " Product Search is Unsuccessful");
		        		takeScreenShot();
		        		driver.quit();
		        		Assert.fail();
		        		
		        	}
		        	

				}
				catch (Exception e) {
				
					if(upload==false) {
						Log.ReportEvent("FAIL", "Upload Bulk data is Unsuccessful");
						}
					else if(product==false){
			  			Log.ReportEvent("FAIL", " Product Search is Unsuccessful");
					}
					else if(client==false){
			  			Log.ReportEvent("FAIL", " Individual Client Search is Unsuccessful");
					}
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			}

		//Function Summary  : Method to Verify Add Product Error Msg
		//Parameter Summary : ExpectedResult
		public void AddProductErrorMessageValidation(Map<Object,Object>testdatamap,Log Log) throws IOException, Exception {
			try {
				String Expected=testdatamap.get("ExpectedResult").toString();

				WebClickUsingJS(EdaatOR.Biller_Prod_Addbutton);
				Thread.sleep(2000);
				WebEdit(EdaatOR.Biller_Prod_NameArabic,testdatamap.get("ProdArabic").toString());
				Thread.sleep(1000);
				WebEdit(EdaatOR.Biller_Invoice_TemplateEng,testdatamap.get("ProdEnglish").toString());  
				Thread.sleep(1000);
				WebSelect1(EdaatOR.Biller_Invoice_Select,testdatamap.get("Category").toString());
				Thread.sleep(1000);
				WebEdit(EdaatOR.Biller_ProdReferenceCode, testdatamap.get("ReferenceCode").toString());
				Thread.sleep(1000);
				WebEdit(EdaatOR.Biller_Prod_Price,testdatamap.get("BasicPrice").toString());  
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Biller_Invoice_Add);
				
				    if(ExistsCheck(EdaatOR.Biller_Settings_ProArabicNameError)) {

				         Log.ReportEvent("PASS", "Error Message Validation for Product Name in Arabic Text Field is Successful");			

				    }
				else if(getText(EdaatOR.Biller_Settings_ProEngNameError).equals(Expected)){
			         Log.ReportEvent("PASS", "Error Message Validation for Product Name in English Text Field is Successful");			

					
				}
				else if(getText(EdaatOR.Biller_Settings_ProductCategoryError).equals(Expected)){

			         Log.ReportEvent("PASS", "Error Message Validation for Category Dropdown is Successful");			

				}
				else if(getText(EdaatOR.Biller_Settings_ProductBasePriceError).equals(Expected)){

			         Log.ReportEvent("PASS", "Error Message Validation for Base Price Text Field is Successful");			

				}
			
				else if(getText(EdaatOR.Biller_Settings_ProductReferenceCodeError).equals(Expected)){
					
			         Log.ReportEvent("PASS", "Error Message Validation for Reference Code Text Field is Successful");			


				}
				else {
			         Log.ReportEvent("FAIL", "Error Message Validation for Add Product is Unsuccessful");		
			         takeScreenShot();
			         driver.quit();
			         Assert.fail();

					  }

			}


			catch(Exception e){
				
				 Log.ReportEvent("FAIL", "Error Message Validation for Add Product is Unsuccessful");		
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
		//Function Summary  : Method to Verify ContentMgmErrorMessage
		//Parameter Summary : ExpectedResult
		public void ContentMgmErrorMessageValidation(Map<Object, Object> testdatamap,Log Log) throws InterruptedException
		{
			try
			{
				String Expected=testdatamap.get("ExpectedResult").toString();
				String File = testdatamap.get("FileType").toString();
				if(File.equalsIgnoreCase("Invalid")) {
					WebClickUsingActions(EdaatOR.Biller_AttachExcel);
					Thread.sleep(800);
					getAutoItImagePathFile1();
				}
				Thread.sleep(2000);
				WebClick(EdaatOR.Biller_Settings_Content_src);
				Thread.sleep(2000);
				if(getText(EdaatOR.Biller_Settings_ContentMgmSelectFileError).equals(Expected)) {
					
			         Log.ReportEvent("PASS", "Error Message Validation for Upload Bulk Data is Successful");			

			     }
				else if(getText(EdaatOR.Biller_Settings_ContentMgmInvalidFileError).equals(Expected)){
					
			         Log.ReportEvent("PASS", "Error Message Validation for Upload Bulk Data is Successful");			
	
				}	
				else {

					 Log.ReportEvent("Fail", "Error Message Validation for Upload Bulk Data is Unsuccessful");	
			         takeScreenShot();
			         driver.quit();
			         Assert.fail();
			         
					  }


			}
			catch (Exception e) {
			

				Log.ReportEvent("Fail", "Error Message Validation for Content Management is Unsuccessful");	
		         takeScreenShot();
		         driver.quit();
		         Assert.fail();

			}
		

	
}
		
		//Function Summary  : Method to Verify BillsCancelationErrorMessage
		//Parameter Summary : Expected
		public void BillsCancelationErrorMessageValidation(Map<Object, Object> testdatamap,Log Log) throws Exception
		{			
			try
			{
				String File = testdatamap.get("FileType").toString();
				if(File.equalsIgnoreCase("Invalid")) {
					WebClickUsingActions(EdaatOR.Biller_AttachExcel);
					Thread.sleep(800);
					getAutoItImagePathFile1();
				}
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Biller_ProcessBtn);
				Thread.sleep(3000);
				if(getText(EdaatOR.Biller_Settings_BillsCancelationSelectFileError).equals(testdatamap.get("ExpectedResult").toString())) {
					
			         Log.ReportEvent("PASS", "Error Message Validation for Upload Bulk Data is Successful");			

			     }
				else if(getText(EdaatOR.Biller_Settings_BillsCancelationInvalidFileError).equals(testdatamap.get("ExpectedResult").toString())){
			         Log.ReportEvent("PASS", "Error Message Validation for Upload Bulk Data is Successful");			

					
				}	
				else {
			         Log.ReportEvent("Fail", "Error Message Validation for Upload Bulk Data is Unsuccessful");	
			         takeScreenShot();
			         driver.quit();
			         Assert.fail();


					  }


			}
			catch (Exception e) {
			
				   Log.ReportEvent("Fail", "Error Message Validation for Bills Cancelation is Unsuccessful");	
			         takeScreenShot();
			         driver.quit();
			         Assert.fail();

			}
}
		
		//Function Summary  : Method to Verify AddInvoiceTemplateErrorMessage
		//Parameter Summary : Expected
		public void AddInvoiceTemplateErrorMessageValidation(Map<Object, Object> testdatamap,Log Log) throws InterruptedException
		{
			
			try
			{
			
				WebClickUsingJS(EdaatOR.Biller_Settings);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Biller_Invoice_template);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Biller_Add_Invoice_Button);
				Thread.sleep(2000);
				WebEdit(EdaatOR.Biller_Invoice_TemplateArabic,testdatamap.get("TemplateArabic").toString());
				Thread.sleep(1000);
				WebEdit(EdaatOR.Biller_Invoice_TemplateEng,testdatamap.get("TemplateEnglish").toString());  
				Thread.sleep(1000);
				
				//i Added these three
				WebEdit(EdaatOR.Biller_Invoice_TemplateDisc,testdatamap.get("TemplateDescription").toString());  
				Thread.sleep(1000);
				WebEdit(EdaatOR.Biller_Invoice_TemplateRefcode,testdatamap.get("TemplateReferancecode").toString());  
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Biller_Invoice_Templateactideacti);  
				Thread.sleep(1000);
		
			//	i Added these two
				WebClickUsingJS(EdaatOR.Biller_Invoice_TemplateBillpay);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Biller_Invoice_TemplateVeriable);
				Thread.sleep(2000);
				String Invoice = testdatamap.get("InvoiceType").toString();
				if(Invoice.equalsIgnoreCase("Recurring")) 
					WebClickUsingJS(EdaatOR.Biller_Invoice_Templatetype);
				WebClick(EdaatOR.Biller_Invoice_Add);
				
				String Expected=testdatamap.get("ErrorMessage").toString();
				if(ExistsCheck(EdaatOR.Biller_Settings_TemplateArabicNameError)) {
					getText(EdaatOR.Biller_Settings_TemplateArabicNameError).equals(Expected);
					Log.ReportEvent("Pass", "Error Message validation for Template Name in Arabic is Successful");
			     }
				else if(ExistsCheck(EdaatOR.Biller_Settings_TemplateEngNameError)){
					getText(EdaatOR.Biller_Settings_TemplateEngNameError).equals(Expected);
					Log.ReportEvent("Pass", "Error Message validation for Template Name in English is Successful");
				}	
				else if(ExistsCheck(EdaatOR.Biller_Settings_TemplateInvoiceTypeError)){
					getText(EdaatOR.Biller_Settings_TemplateInvoiceTypeError).equals(Expected);
					Log.ReportEvent("Pass", "Error Message validation for Invoice Type is Successful");
				}	
				else {

					Log.ReportEvent("FAIL", "Error Message validation for Add Invoice Template is Successful");
					takeScreenShot();
					driver.quit();
					Assert.fail();
					
					  }
			}
			catch (Exception e) {
			
				Log.ReportEvent("FAIL", "Error Message validation for Add Invoice Template is Successful");
				takeScreenShot();
				driver.quit();
				Assert.fail();			}
}
}