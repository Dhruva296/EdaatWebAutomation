/**
* Test Script Name  				 : N/A
* Objective                          : Verify IndividualClient Functionality.
* Version      						 : 1.0
* Author       						 : Kathirvelu Mohan
* Created Date 			      		 : 15/08/2023
* Last Updated on					 : N/A
* Updated By   			 			 : Arun kumar M S
* Pre-Conditions					 : N/A
* Epic Details						 : N/A
* User Story Details				 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.biller.pages;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.azmqalabs.edaattestautomation.common.Log;


public class BillerSubbillerPage extends BasePage
{

	public BillerSubbillerPage(WebDriver driver,ExtentTest test)
	{
		 this.driver=driver;
		 this.test=test;
		 
		 PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  
	

	@FindBy(xpath = EdaatOR.Biller_Client)
	public WebElement Client;
	private boolean existsElement;
		
	    
	    public boolean Exists(){
	    	return super.Exists(Client); 
		}
		
 	//Function Summary   : Method to activate and deactivate individual sub biller.	
	//Parameter Summary   : NationalID.	
	public void ActivateDeactivate(Map<Object,Object> testdatamap,Log Log){
	    try{
//	    	WebClickUsingJS(EdaatOR.Biller_IndividualSubBillerPage);
	    	Thread.sleep(1000);	
	    	if(CheckElementExists(EdaatOR.Biller_IndividualToggle)==true) {
	    		WebEdit(EdaatOR.Biller_Individual_NationalID,testdatamap.get("NationalID").toString());        			
				Thread.sleep(2000);
	    		WebClickUsingJS(EdaatOR.Biller_Individual_searchBtn);
				Thread.sleep(2000);
				if(getText(EdaatOR.Biller_Subbiller_NationalId_Data).equals(testdatamap.get("NationalID").toString()))
				{
				WebClickUsingJS(EdaatOR.Biller_IndividualToggle);
				Thread.sleep(2000);
				VerifyValue1(getText(EdaatOR.Biller_ConfirmationPopupMessage), testdatamap.get("InActive").toString());
				Thread.sleep(2000);
				WebClick(EdaatOR.Biller_YesBtn);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Biller_IndividualToggle);
				Thread.sleep(2000);
				VerifyValue1(getText(EdaatOR.Biller_ConfirmationPopupMessage), testdatamap.get("Active").toString());				
				Thread.sleep(1000);
				WebClick(EdaatOR.Biller_YesBtn);
				Log.ReportEvent("PASS", " Activate Deactivate Individual Sub Biller Status Toggle is Successful");
				}else {
					this.takeScreenShot();
					Log.ReportEvent("FAIL", " Activate Deactivate Individual Sub Biller Status Toggle is Unsuccessful");
		            driver.quit();
	                Assert.fail();

					
				}

	    	}
	    	else {
				this.takeScreenShot();
				Log.ReportEvent("FAIL", " Activate Deactivate Individual Sub Biller Status Toggle is Unsuccessful");
	            driver.quit();
                Assert.fail();
	    }
	    }
	    	catch(Exception e){
			Log.ReportEvent("FAIL", " Activate Deactivate Individual Sub Biller Status Toggle is Unsuccessful");
	        this.takeScreenShot();
            driver.quit();
	        Assert.fail();
	    }
	}
	    //Function Summary : Method to add Individual Subbiller. 
		//Parameter Summary: BillerName,National ID,IBanNumber,BeneficaryName,FixedValueAmount,Percentage Value,MobileNumber,Email.
	    public boolean AddSubBiller(Map<Object, Object> testdatamap,Log Log){
		//	boolean existsElement = false;
			try{				
	        	Thread.sleep(2000);
				WebClick(EdaatOR.Biller_AddSubBilleer);
				Thread.sleep(3000);
				WebEdit(EdaatOR.Biller_SubBillerName,testdatamap.get("SubBillerName").toString());
				Thread.sleep(3000);
				WebEdit(EdaatOR.Biller_Subbiller_NId,testdatamap.get("NationalID").toString());
				Thread.sleep(3000);
				WebEdit(EdaatOR.Biller_SubBiller_IBAN,testdatamap.get("IBanNumber").toString());
				Thread.sleep(3000);
				WebEdit(EdaatOR.Biller_SubBiller_Benificary,testdatamap.get("BeneficaryName").toString());
				Thread.sleep(3000);
				EnterBillerIBANAttmnt();
				Thread.sleep(3000);
				WebClickUsingJS(EdaatOR.Biller_SubBiller_Invoice_Total_AMT_ChkBox);
				Thread.sleep(3000);
				WebClickUsingJS(EdaatOR.Biller_SubBiller_FixedValue_ChkBox);
				Thread.sleep(3000);
				WebEdit(EdaatOR.Biller_SubBiller_FixedValue_Amt,testdatamap.get("FixedValueAmount").toString());
				WebClickUsingJS(EdaatOR.Biller_SubBiller_Percentage_ChkBox);
				Thread.sleep(3000);
				WebEdit(EdaatOR.Biller_SubBiller_Percentage_Val,testdatamap.get("Percentage Value").toString());
				Thread.sleep(3000);
				WebClickUsingJS(EdaatOR.Biller_SubBiller_Trans_Fee_Deduct_ChxBox);
				Thread.sleep(3000);
				WebEdit(EdaatOR.Biller_SubBiller_MOB,testdatamap.get("MobileNumber").toString());
				Thread.sleep(3000);
				WebEdit(EdaatOR.Biller_SubBiller_Email,testdatamap.get("Email").toString());
				Thread.sleep(3000);
				WebClick(EdaatOR.Biller_SubBillerAddButton);
				Thread.sleep(1000);
			     if(CheckElementExists(EdaatOR.Biller_NationalId_Exit)||CheckElementExists(EdaatOR.Biller_IBAN_Exit)||CheckElementExists(EdaatOR.Biller_IBANAttachment_Invalid)||CheckElementExists(EdaatOR.Biller_Fees_Error))
		            {
			    	    WebElement element=driver.findElement(By.xpath(EdaatOR.Biller_SubBiller_ErrorMsg));
						scrollToElement(driver, element);
			        	Log.ReportEvent("FAIL", " Add Individual Sub Biller is Unsuccessful");
			            this.takeScreenShot();
			            driver.quit();
			            Assert.fail();

		            }
		            else {
			        	Log.ReportEvent("PASS", " Add Individual Sub Biller is Successful");
		            }
	           	
	        }catch(Exception e){
	        	Log.ReportEvent("FAIL", " Add Individual Sub Biller is Unsuccessful");
	            this.takeScreenShot();
	            driver.quit();
	            Assert.fail();	        }
	        return existsElement;
	    }			

	    //Function Summary : Method to Edit the Subbiller. 
		//Parameter Summary: BillerName,National ID.
	
	public boolean SubbillerSearch(Map<Object, Object> testdatamap,Log Log){
	//	boolean existsElement = false;
		try{
			    AddSubBiller(testdatamap,Log);			    
	        	WebEdit(EdaatOR.Biller_Individualclient_Name,testdatamap.get("BillerName").toString());
				Thread.sleep(2000);
				WebEdit(EdaatOR.Biller_Subbiller_NId,testdatamap.get("National ID").toString());
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Biller_Subbiller_Search);
            	existsElement=ExistsCheck("//td[text()='+National ID+']");
				Thread.sleep(2000);
				Log.ReportEvent("PASS", "SubBiller Search is successful");
				this.takeScreenShot();

           	
				
        }catch(Exception e){
//       test.log(Status.FAIL,"Add Individual client" + driver.getTitle() +" * Add Individual client PASS * " );
            this.takeScreenShot();
        }
        return existsElement;
    }
	
	  //Function Summary : Method to Edit the Subbiller. 
	//Parameter Summary: FixedValueAmount,Percentage Value.

	public boolean EditSubBiller(Map<Object, Object> testdatamap,Log Log){
		boolean existsElement = false;
		try{
			    Thread.sleep(2000);		
			    if(CheckElementExists(EdaatOR.Biller_SubBiller_Edit))
			    {
				WebClick(EdaatOR.Biller_SubBiller_Edit);
				Thread.sleep(2000);			
				//WebClickUsingJS(EdaatOR.Biller_SubBiller_Invoice_Total_AMT_ChkBox);
				//Thread.sleep(2000);
				//WebClickUsingJS(EdaatOR.Biller_SubBiller_FixedValue_ChkBox);
				//Thread.sleep(2000);
				WebEdit(EdaatOR.Biller_SubBiller_FixedValue_Amt,testdatamap.get("FixedValueAmount").toString());
				//WebClickUsingJS(EdaatOR.Biller_SubBiller_Percentage_ChkBox);
				//Thread.sleep(3000);
				WebEdit(EdaatOR.Biller_SubBiller_Percentage_Val,testdatamap.get("Percentage Value").toString());
				WebClickUsingJS(EdaatOR.Biller_SubBiller_Trans_Fee_Deduct_ChxBox);
				Thread.sleep(2000);
				WebClick(EdaatOR.Biller_SubBiller_Save);
				Thread.sleep(2000);
			 	Log.ReportEvent("PASS", " Edit SubBiller is successful");
			    }else {
			    	Log.ReportEvent("FAIL", " Edit SubBiller is Unsuccessful");
		            this.takeScreenShot();
		            driver.quit();
		            Assert.fail();	

			    }

        }catch(Exception e){
		 	Log.ReportEvent("FAIL", " Edit SubBiller is Unsuccessful");
            this.takeScreenShot();
            driver.quit();
            Assert.fail();
        }
        return existsElement;
	}
	public void EnterBillerIBANAttmnt() throws Exception {
		WebClickUsingActions(EdaatOR.Biller_IBANAttmnt_eField);
		getAutoItImagePathFile();

	}
			
	  //Function Summary : Method to Verify Individual Subbiller. 
		//Parameter Summary: BillerName.

	public void VerifyIndividualClient(Map<Object, Object> testdatamap,Log Log) throws Exception {
		// TODO Auto-generated method stub
		SubbillerSearch(testdatamap,Log);
		VerifyValue1(getText("//td/a[contains(text(),'"+testdatamap.get("BillerName").toString()+"')]"),testdatamap.get("BillerName").toString());
		
	}
	public void ClickOnCorporateSubBiller() {
		WebClickUsingJS(EdaatOR.Biller_subbiller);
		waitForPageToLoad();
	}
	public void ClickOnIndividualSubBiller() {
		WebClickUsingJS(EdaatOR.Biller_Sub_IndividualsubBiller);
		waitForPageToLoad();
	}


	public void ClickOnSubbiller() {
		WebClickUsingJS(EdaatOR.Biller_subbiller_Corp);
		waitForPageToLoad();
	}
	public void NavigateCorporateSubBiller(Log Log) throws InterruptedException{
		ClickOnSubbiller();
		ClickOnCorporateSubBiller();
		if (CheckElementExists(EdaatOR.Biller_Corporate_Subbiller)) {				
			Thread.sleep(2000);
		 	Log.ReportEvent("PASS", " Corporate Subbiller Page is Loaded Successfully");

	} else {
    	Log.ReportEvent("FAIL", " Corporate Subbiller Page is Not Loaded Successfully");
		this.takeScreenShot();
		driver.quit();
		Assert.fail();

	}
	 	

	}
	public void NavigateIndividualSubBiller(Log Log) throws InterruptedException{
		ClickOnSubbiller();
		ClickOnIndividualSubBiller();
		if (CheckElementExists(EdaatOR.Biller_Individual_Subbiller)) {				
			Thread.sleep(2000);
		 	Log.ReportEvent("PASS", " Individual Subbiller Page is Loaded Successfully");

	} else {
    	Log.ReportEvent("FAIL", " Individual Subbiller Page is Not Loaded Successfully");
		this.takeScreenShot();
        driver.quit();
		Assert.fail();

	}	 	

	}
	public void ClickOnAddSubbiller() throws Exception
	{
		WebClick(EdaatOR.Biller_subbiller_Corpaddbtn);
		Thread.sleep(1000);
	}
	public void EnterGeneralinfo(Map<Object, Object> testdatamap) throws Exception
	{
		WebEdit(EdaatOR.Biller_subbiller_Corpname, testdatamap.get("BillerName").toString());
		Thread.sleep(2000);
		WebEdit(EdaatOR.Biller_subbiller_Corpcrnum, testdatamap.get("CRNumber").toString());
		Thread.sleep(2000);
        EnterCRattach();
        Thread.sleep(2000);
        EnterIBANImg();
		WebEdit(EdaatOR.Biller_subbiller_Corpiban, testdatamap.get("IBANNumber").toString());
		Thread.sleep(2000);
		WebEdit(EdaatOR.Biller_subbiller_Corpbenfname, testdatamap.get("BeneficiaryName").toString());
		Thread.sleep(2000);
		WebEdit(EdaatOR.Biller_subbiller_Corptaxnum, testdatamap.get("Taxnumber").toString());
	}
	public void EnterIBANImg() throws InterruptedException, IOException
	{
		WebClickUsingActions(EdaatOR.Biller_subbiller_Ibanclick);
		getAutoITFile();
	}
	public void getAutoITFile() throws InterruptedException, IOException
	{
		File classpathRoot = new File(System.getProperty("user.dir"));
		Thread.sleep(2000);
		File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//ImageUpload.exe");
		String sFilename = app.toString();
		Thread.sleep(2000);
		Runtime.getRuntime().exec(sFilename);
		Thread.sleep(2000);
	}
	public void EnterCRattach() throws InterruptedException, IOException {
		WebClickUsingActions(EdaatOR.Biller_subbiller_crattach);
		getAutoITFile();
	}
	public void EnterOperationalFeesInfo(Map<Object, Object> testdatamap) throws Exception
	{
		WebClick(EdaatOR.Biller_subbiller_Corpfees);
		Thread.sleep(1000);
		WebClick(EdaatOR.Biller_subbiller_Corpfixedvalue);
		Thread.sleep(1000);
		WebClearandEdit(EdaatOR.Biller_subbiller_Corpfixedefield,testdatamap.get("FixedValue").toString());
		WebClick(EdaatOR.Biller_subbiller_Corpperc);
		Thread.sleep(1000);
		WebClearandEdit(EdaatOR.Biller_subbiller_Corpperefield,testdatamap.get("Percentage").toString());
		scrollDowntillend(driver);
	}
	public void EnterNationalAddressinfo(Map<Object, Object> testdatamap) throws Exception {
		
		WebClick(EdaatOR.Biller_subbiller_corpcity);
		Thread.sleep(1000);
		WebClickUsingActions("//li[text()='"+testdatamap.get("City").toString()+"']");
		Thread.sleep(2000);
		WebEdit(EdaatOR.Biller_subbiller_Corpdistname,testdatamap.get("DistrictName").toString());
		Thread.sleep(2000);
		WebEdit(EdaatOR.Biller_subbiller_Corpstreetefield,testdatamap.get("StreetName").toString());
		Thread.sleep(2000);
		WebEdit(EdaatOR.Biller_subbiller_Corpzipcode,testdatamap.get("ZipCode").toString());
		Thread.sleep(2000);
		WebEdit(EdaatOR.Biller_subbiller_Corpbuildno,testdatamap.get("BuildingNo").toString());
		driver.findElement(By.xpath(EdaatOR.Biller_SubBillerAddButton)).sendKeys(Keys.PAGE_DOWN);
	}
	public void EnterContactInfo(Map<Object, Object> testdatamap) throws Exception {
		WebEdit(EdaatOR.Biller_subbiller_Corpempname,testdatamap.get("EmployeeName").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_subbiller_Corpempemail,testdatamap.get("EmployeeEmail").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_subbiller_Corpempmobile,testdatamap.get("EmployeeMobileNumber").toString());
		Thread.sleep(1000);
		
	}
	public void ClickOnAddBtn() throws Exception {
		
		WebClick(EdaatOR.Biller_subbiller_Corpadd);
		
		
	}
	  //Function Summary:Method to search subbiller.
	  //Function Parameters:BillerName.
	public void EnterSearchitem(Map<Object, Object> testdatamap) throws Exception {
		
		WebEdit(EdaatOR.Biller_subbiller_srch,testdatamap.get("BillerName").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_subbiller_crsrch,testdatamap.get("CRNumber").toString());
		Thread.sleep(1000);
		WebClick(EdaatOR.Biller_subbiller_srcclick);
		Thread.sleep(2000);
		
	}
	  //Function Summary:Method to add Corporate subbiller.
	  //Function Parameters:BillerName.
	public void AddCorporateSubBiller(Map<Object, Object> testdatamap,Log Log) throws Exception
	{
		ClickOnAddSubbiller();
		try
		{
		if(CheckElementExists(EdaatOR.Biller_subbiller_Corpverify)==true)
		{
		   EnterGeneralinfo(testdatamap);
//		   EnterIBANImg();
//		   EnterCRattach();
		   EnterOperationalFeesInfo(testdatamap);
		   EnterNationalAddressinfo(testdatamap);
		   EnterContactInfo(testdatamap);
		   ClickOnAddBtn();
		   if(CheckElementExists(EdaatOR.Biller_Corporate_IBANAttachment_Invalid)||CheckElementExists(EdaatOR.Biller_Corporate_AttachCRImage)||CheckElementExists(EdaatOR.Biller_Corporate_Invalid_Iban)||CheckElementExists(EdaatOR.Biller_Corporate_CRNumber_Exist))
		   {
			   WebElement element=driver.findElement(By.xpath(EdaatOR.Biller_SubBiller_ErrorMsg));
				scrollToElement(driver, element);
			   Log.ReportEvent("FAIL", " Add Corporate Subbiller Based on Invoice is Unsuccessful");
			   this.takeScreenShot();
	           driver.quit();
               Assert.fail();

		   }else {
			   
			   Log.ReportEvent("PASS", " Add Corporate Subbiller Based on Invoice is Successful");

		   }
		   EnterSearchitem(testdatamap);	
		   if(getText("//a[contains(text(),'"+testdatamap.get("BillerName").toString()+"')]/parent::td/following-sibling::td[1]").equals(testdatamap.get("CRNumber").toString()))
		   {
		   VerifyValue1(getText("//table[@id='tblSubBillers']//a[contains(text(),'"+testdatamap.get("BillerName").toString()+"')]"), testdatamap.get("BillerName").toString());
		   VerifyValue1(getText("//a[contains(text(),'"+testdatamap.get("BillerName").toString()+"')]/parent::td/following-sibling::td[5]"),testdatamap.get("Status").toString());
		   Log.ReportEvent("PASS", " Add Corporate Subbiller Based on Invoice Functionality and Search is Successful");

		   }
		   else {
			   Log.ReportEvent("FAIL", " Add Corporate Subbiller Based on Invoice Functionality and Search is Unsuccessful");
			   this.takeScreenShot();
	            driver.quit();
               Assert.fail();

		   }
		}
		else
		{
			   Log.ReportEvent("FAIL", " Add Corporate Subbiller based on Invoice Functionality is Unsuccessful");
			   this.takeScreenShot();
	            driver.quit();
               Assert.fail();
		}
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", " Add Corporate Subbiller based on Invoice Functionality is Unsuccessful");
			   this.takeScreenShot();
	            driver.quit();
            Assert.fail();
		}
	}

	
 	//Function Summary   : Method to view table	
	//Parameter Summary   : BillerName.	
	public void TableGridview(Map<Object,Object> testdatamap,Log Log){
	    try{
	    	String BillerName=testdatamap.get("BillerName").toString();
	    	Thread.sleep(2000);	    
	    	if(CheckElementExists(EdaatOR.Biller_CorporateSubBillerGrid)==true) {
    			Thread.sleep(2000);
    			WebClear(EdaatOR.Biller_CorporateSubBiller_BillerName);
    			Thread.sleep(2000);
    			WebEdit(EdaatOR.Biller_CorporateSubBiller_BillerName, BillerName); 
    			Thread.sleep(2000);
    			WebClick(EdaatOR.Biller_CorporateSubBiller_searchBtn);
    			Thread.sleep(2000);
    			if(CheckElementExists("//a[contains(text(),'"+BillerName+"')]"))
    			{
        			Log.ReportEvent("PASS", " View Corporate SubBiller Table Grid View is Successful");

    			}
    			else {
    				Log.ReportEvent("FAIL", " View Corporate SubBiller Table Grid View is Unsuccessful");
    	    		this.takeScreenShot();
		            driver.quit();
    	    		Assert.fail();

    			}
//    			WebClick("//a[contains(text(),'"+BillerName+"')]");
//    			Thread.sleep(2000);
//    			switchTonextwindow();
//    			scrollDowntillend(driver);
//    			WebClick(EdaatOR.Biller_CorporateSubBiller_Back);
    			

	    		}
	    	else {
    			Log.ReportEvent("FAIL", " View Corporate SubBiller Table Grid View is Unsuccessful");
	    		this.takeScreenShot();
	            driver.quit();
	    		Assert.fail();
	    	}
	    }catch(Exception e){
			Log.ReportEvent("FAIL", " View Corporate SubBiller Table Grid View is Unsuccessful");
	        this.takeScreenShot();
            driver.quit();
	        Assert.fail();
	    }
}
      //Function Summary:Verify sub biller Individual Grid View details
	  //Function Parameters:N/A.
	  	    public void SubBillerIndividualGridView(String table,Log Log)
	  		{
	  			try {
	  				if (CheckElementExists(table))
	  				{
	  				    Log.ReportEvent("PASS", " Grid View Details is Loaded Successfully");

	  				}
	  				else {
	  				    Log.ReportEvent("FAIL", " Grid View Details is Not Loaded Successfully");
		  				this.takeScreenShot();
			            driver.quit();
		  				Assert.fail();

	  				}
	  			} catch (Exception e) {
  				    Log.ReportEvent("FAIL", " Grid View Details is Not Loaded Successfully");
	  				this.takeScreenShot();
		            driver.quit();
	  				Assert.fail();
	  			}
	  		}	
	  		
	  //Function Summary:Verify sub biller Individual Grid View details
	  //Function Parameters:N/A.
	  		public void SubBillerIndividual(Map<Object, Object> testdatamap,Log Log) throws Exception
	  		{
	  			addSubBiller(testdatamap,Log);
	  			SearchBiller(testdatamap, Log);
	  		}
	  		
	  //Function Summary:Search sub biller 
	  //Function Parameters:SubBillerName and NationalID.
	  		public void SearchBiller(Map<Object, Object> testdatamap,Log Log)
	  		{
	  		    try {
	  			        WebClear(EdaatOR.Biller_AddsubBiller_SeaName);
	  			        WebEdit(EdaatOR.Biller_AddsubBiller_SeaName,testdatamap.get("SubBillerName").toString());
	  			        Thread.sleep(2000);
	  			        WebClear(EdaatOR.Biller_AddsubBiller_SeaNation);
	  			        WebEdit(EdaatOR.Biller_AddsubBiller_SeaNation,testdatamap.get("NationalID").toString());
	  		         	Thread.sleep(2000);
	  			        WebClickUsingJS(EdaatOR.Biller_AddsubBiller_Search);
	  			        Thread.sleep(2000);
	  			        if(getText(EdaatOR.Biller_AddsubBiller_verify).equals(testdatamap.get("NationalID").toString())) {
		  		        	Log.ReportEvent("PASS", " Search Individual SubBiller is Successful");
	  			        }
	  			        else {
		  		        	Log.ReportEvent("FAIL", " Search Individual SubBiller is Unsuccessful");
		  			        this.takeScreenShot();
				            driver.quit();
		  			        Assert.fail();

	  			        }	  		        
	  		       }
	  		   catch(Exception e){
	  			 Log.ReportEvent("FAIL", " SSearch Individual SubBiller is Unsuccessful");
			        this.takeScreenShot();
		            driver.quit();
			        Assert.fail();	  		        	}

	  		}
	  		
	  //Function Summary:To add product.
	  //Function Parameters:Product,Fixed Value,Percentage,IBAN and Beneficiary Name.
	  		public void addproduct(Map<Object, Object> testdatamap,Log Log) throws Exception
	  		{
	  		 try {	   
	  			WebClickUsingJS(EdaatOR.Biller_AddsubBiller_addprod);
	  			if(CheckElementExists(EdaatOR.Biller_Addproduct_Popup))
	  			{
	  			WebSelect(EdaatOR.Biller_AddsubBiller_prodname,testdatamap.get("Product").toString());
	  			Thread.sleep(2000);
	  			WebClear(EdaatOR.Biller_AddsubBiller_fixed);
	  			WebEdit(EdaatOR.Biller_AddsubBiller_fixed,testdatamap.get("Fixed Value").toString());
	  			Thread.sleep(2000);
	  			WebClear(EdaatOR.Biller_AddsubBiller_per);
	  			WebEdit(EdaatOR.Biller_AddsubBiller_per,testdatamap.get("Percentage").toString());
	  			Thread.sleep(2000);
	  			WebClear(EdaatOR.Biller_AddsubBiller_prodiban);
	  			WebEdit(EdaatOR.Biller_AddsubBiller_prodiban,testdatamap.get("IBAN").toString());
	  			Thread.sleep(2000);
	  			WebClear(EdaatOR.Biller_AddsubBiller_prodbene);
	  			WebEdit(EdaatOR.Biller_AddsubBiller_prodbene,testdatamap.get("Beneficiary Name").toString());
	  			Thread.sleep(2000);
	  			EnterIbanAttachment();
	  			Thread.sleep(2000);
	  			WebClickUsingJS(EdaatOR.Biller_AddsubBiller_prodaddbt);
	  			Thread.sleep(2000);
		        Log.ReportEvent("PASS", " Add Product is Successful");
	  			}
	  			else {
			        Log.ReportEvent("FAIL", " Add Product is Unsuccessful");
  		            this.takeScreenShot();
		            driver.quit();
  		            Assert.fail();


	  			}
	  		   }
	  		   catch(Exception e){
	  			  Log.ReportEvent("FAIL", " Add Product is Unsuccessful");
		          this.takeScreenShot();
		          driver.quit();
		          Assert.fail();
	  		        	}

	  		}
	  		public void EnterIbanAttach() throws Exception {
	  			WebClickUsingActions(EdaatOR.Biller_AddsubBiller_Iban);
	  			getAutoItImagePathFile();
	  		}
	  		public void EnterIbanAttachment() throws Exception {
	  				WebClickUsingActions(EdaatOR.Biller_AddsubBiller_prodatch);
	  				getAutoItImagePathFile();
	  			}
	  		public void  getAutoItImagePathFile() throws Exception {
	  				File classpathRoot = new File(System.getProperty("user.dir"));
	  				Thread.sleep(2000);
	  				File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//ImageUpload.exe");
	  				String sFilename = app.toString();
	  				Thread.sleep(2000);
	  				Runtime.getRuntime().exec(sFilename);
	  				Thread.sleep(800);
	  			}

	  //Function Summary:To Add sub biller 
	  //Function Parameters:SubBillerName,IBAN Number,Beneficiary,Mobile,Emails and NationalID.
	  	public void addSubBiller(Map<Object, Object> testdatamap,Log Log) throws Exception 
	  	{
	  	 try {
	  			WebClickUsingJS(EdaatOR.Biller_AddsubBiller_btn);
	  			WebClear(EdaatOR.Biller_AddsubBiller_name);
	  			WebEdit(EdaatOR.Biller_AddsubBiller_name,testdatamap.get("SubBillerName").toString());
	  			Thread.sleep(2000);
	  			WebClear(EdaatOR.Biller_AddsubBiller_National);
	  			WebEdit(EdaatOR.Biller_AddsubBiller_National,testdatamap.get("NationalID").toString());
	  			Thread.sleep(2000);
	  			WebClear(EdaatOR.Biller_AddsubBiller_IBAN);
	  			WebEdit(EdaatOR.Biller_AddsubBiller_IBAN,testdatamap.get("IBAN Number").toString());
	  			Thread.sleep(2000);
	  			WebClear(EdaatOR.Biller_AddsubBiller_Beneficiary);
	  			WebEdit(EdaatOR.Biller_AddsubBiller_Beneficiary,testdatamap.get("Beneficiary").toString());
	  			Thread.sleep(2000);
	  			EnterIbanAttach();
	            WebClickUsingJS(EdaatOR.Biller_AddsubBiller_Fees);
	  			Thread.sleep(2000);
	  			addproduct(testdatamap,Log);
	  			WebClear(EdaatOR.Biller_AddsubBiller_mbl);
	  			WebEdit(EdaatOR.Biller_AddsubBiller_mbl,testdatamap.get("Mobile").toString());
	  			Thread.sleep(2000);
	  			WebClear(EdaatOR.Biller_AddsubBiller_Email);
	  			WebEdit(EdaatOR.Biller_AddsubBiller_Email,testdatamap.get("Email").toString());
	  			Thread.sleep(2000);
	  			WebClickUsingJS(EdaatOR.Biller_AddsubBiller_check);
	  			Thread.sleep(2000);
	            WebClickUsingJS(EdaatOR.Biller_AddsubBiller_addbtn);  
	            if(CheckElementExists(EdaatOR.Biller_NationalId_Exit)||CheckElementExists(EdaatOR.Biller_IBAN_Exit)||CheckElementExists(EdaatOR.Biller_IBANAttachment_Invalid)||CheckElementExists(EdaatOR.Biller_Fees_Error))
	            {
	            	WebElement element=driver.findElement(By.xpath(EdaatOR.Biller_SubBiller_ErrorMsg));
					scrollToElement(driver, element);
		        	Log.ReportEvent("FAIL", " Add Individual SubBiller is Unsuccessful");
		            this.takeScreenShot();
		            driver.quit();
		            Assert.fail();

	            }
	            else {
		        	Log.ReportEvent("PASS", " Add Individual SubBiller is successful");

	            }

	  		}
	  		catch(Exception e){
	  			Log.ReportEvent("FAIL", " Add Individual SubBiller is Unsuccessful");
	            this.takeScreenShot();
	            driver.quit();
	            Assert.fail();	  		}
	  }
	    //Function Summary: Method to verify Individual subbiller search
		  //Function Parameters:BillerName,National ID.
		public void IndividualSearch(Map<Object, Object> testdatamap,Log Log) {
			// TODO Auto-generated method stub
			try{
				  
		    	WebEdit(EdaatOR.Biller_Individualclient_Name,testdatamap.get("BillerName").toString());
				Thread.sleep(2000);
				WebEdit(EdaatOR.Biller_Subbiller_NId,testdatamap.get("National ID").toString());
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Biller_Subbiller_Search);
		    	existsElement=ExistsCheck("//td[text()='+National ID+']");
				Thread.sleep(2000); 
				Log.ReportEvent("PASS", " Search Individual SubBiller is Sucessful");
				this.takeScreenShot();

				
		}catch(Exception e){
		//test.log(Status.FAIL,"Add Individual client" + driver.getTitle() +" * Add Individual client PASS * " );
		    this.takeScreenShot();
	}	}
	    public void corporatesubbillersearch(Map<Object, Object> testdatamap) throws Exception {
          WebEdit(EdaatOR.Biller_subbiller_srch,testdatamap.get("BillerName").toString());
          Thread.sleep(2000);
          WebEdit(EdaatOR.Biller_subbiller_crsrch,testdatamap.get("CRNumber").toString());
          Thread.sleep(2000);
          WebClick(EdaatOR.Biller_subbiller_srcclick);
          Thread.sleep(2000);
        }
		//Function Summary: Method to Add sub biller and search added sub biller.

        //Function Parameters: BillerName

        public void CorporateSubBillerSearch(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {           

            try
            {
                if (CheckElementExists(EdaatOR.Biller_subbiller_Nodata)==false) {
                    ClickOnAddSubbiller();
                    Thread.sleep(1000);
                    EnterGeneralinfo(testdatamap);                    
                    EnterOperationalFeesInfo(testdatamap);
                    EnterNationalAddressinfo(testdatamap);
                    EnterContactInfo(testdatamap);
                    ClickOnAddBtn();
                    if(CheckElementExists(EdaatOR.Biller_Corporate_IBANAttachment_Invalid)||CheckElementExists(EdaatOR.Biller_Corporate_AttachCRImage)||CheckElementExists(EdaatOR.Biller_Corporate_Invalid_Iban)||CheckElementExists(EdaatOR.Biller_Corporate_CRNumber_Exist))
         		   {
                    	WebElement element=driver.findElement(By.xpath(EdaatOR.Biller_SubBiller_ErrorMsg));
						scrollToElement(driver, element);
         			   Log.ReportEvent("FAIL", " Add Corporate Subbiller is Unsuccessful");
         			   this.takeScreenShot();
			            driver.quit();
                        Assert.fail();

         		   }else {
         			   
         			   Log.ReportEvent("PASS", " Add Corporate Subbiller is Successful");

         		   }
                    
                    Thread.sleep(2000);
                    corporatesubbillersearch(testdatamap); 
                    if(getText("//a[contains(text(),'"+testdatamap.get("BillerName").toString()+"')]/parent::td/following-sibling::td[1]").equals(testdatamap.get("CRNumber").toString()))
         		   {
         		   VerifyValue1(getText("//table[@id='tblSubBillers']//a[contains(text(),'"+testdatamap.get("BillerName").toString()+"')]"), testdatamap.get("BillerName").toString());
         		   VerifyValue1(getText("//a[contains(text(),'"+testdatamap.get("BillerName").toString()+"')]/parent::td/following-sibling::td[5]"),testdatamap.get("Status").toString());
         		   Log.ReportEvent("PASS", " Search Corporate Subbiller is Successful");

         		   }
         		   else {
         			   Log.ReportEvent("FAIL", " Search Corporate Subbiller is Unsuccessful");
         			   this.takeScreenShot();
			            driver.quit();
                        Assert.fail();

         		   }
                }                 
                
            }
            catch (Exception e) {

         	   Log.ReportEvent("FAIL", " Search Corporate Subbiller is Unsuccessful");
 			   this.takeScreenShot();
	            driver.quit();
                Assert.fail();


            }

        }
        
	    //Function Summary: Method to Add sub biller Product details. 
		//Function Parameters: ProductPercentage,ProductIBANNumber,ProductIBANNumber
		public void addProductDetails(Map<Object,Object> testdatamap,Log Log) throws Exception {
			if(CheckElementExists(EdaatOR.Biller_Addproduct_Popup))
			{
			SelectProduct(testdatamap);
			WebClear(EdaatOR.Biller_AddsubBiller_ProductPer);
  			WebEdit(EdaatOR.Biller_AddsubBiller_ProductPer,testdatamap.get("ProductPercentage").toString());
  			Thread.sleep(1000);
			WebEdit(EdaatOR.Billersubbiller_productIBAN, testdatamap.get("ProductIBANNumber").toString());
			WebEdit(EdaatOR.Billersubbiller_product_BenName, testdatamap.get("ProductIBANNumber").toString());
			EnterProductCRattach();
			Thread.sleep(2000);
			ClickOnProductAddBtn();			
            Log.ReportEvent("PASS", " Add Product is Successful");

			}
			else {
	            Log.ReportEvent("PASS", " Add Product is Unsuccessful");
                this.takeScreenShot();
	            driver.quit();
                Assert.fail();


			}
		}
		
		//Function Summary : Method to click on "Transfer Fees Deduction from Sub Biller Share"checkbox .  
		//Parameter Summary: N/A
		private void transferCheckbox() throws Exception {
			WebClick(EdaatOR.Biller_Subbiller_transferfrmsubiller);
			Thread.sleep(2000);
		}
		//Function Summary : Method to select "product" from dropdown.  
		//Parameter Summary: N/A
		public void SelectProduct(Map<Object,Object> testdatamap) { 
			WebSelect(EdaatOR.Biller_subbiller_corpaddProduct_ProductID,testdatamap.get("ProductName").toString());
			waitForPageToLoad();
		}
		//Function Summary : Method to click on "add" button in "add product"popup.  
		//Parameter Summary: N/A
		public void ClickOnProductAddBtn() throws Exception {
			WebClick(EdaatOR.Biller_Subbiller_ProductAddBtn);
			waitForPageToLoad();
		}
		
		public void EnterProductCRattach() throws InterruptedException, IOException {
			WebClickUsingActions(EdaatOR.Biller_subbiller_Productcrattach);
			getAutoITFile();
		}
		//Function Summary: Method to enter "Fees deduction based on Product" details. 
	    //Function Parameters: BillerName,CRNumber,Status
		private void EnterFeesDeductionBasedonProduct(Map<Object, Object> testdatamap) throws Exception {
			WebClick(EdaatOR.Biller_subbiller_Product);
			Thread.sleep(800);
			WebClick(EdaatOR.Biller_subbiller_corpaddProduct);
			Thread.sleep(800);
			scrollDowntillend(driver);
		}
		  //Function Summary: Method to Add sub biller Based on Product. 
		  //Function Parameters: BillerName,CRNumber,Status
		public void AddCorporateSubBillerwithProduct(Map<Object, Object> testdatamap,Log Log) throws Exception {
			ClickOnAddSubbiller();
			try {
			if(CheckElementExists(EdaatOR.Biller_subbiller_Corpverify)==true)
			{
			   EnterGeneralinfo(testdatamap);
			   EnterFeesDeductionBasedonProduct(testdatamap);
			   addProductDetails(testdatamap,Log);
			   transferCheckbox();
			   EnterNationalAddressinfo(testdatamap);
			   EnterContactInfo(testdatamap);
			   ClickOnAddBtn();
			   if(CheckElementExists(EdaatOR.Biller_Corporate_IBANAttachment_Invalid)||CheckElementExists(EdaatOR.Biller_Corporate_AttachCRImage)||CheckElementExists(EdaatOR.Biller_Corporate_Invalid_Iban)||CheckElementExists(EdaatOR.Biller_Corporate_CRNumber_Exist))
			   {
				   WebElement element=driver.findElement(By.xpath(EdaatOR.Biller_SubBiller_ErrorMsg));
					scrollToElement(driver, element);
				   Log.ReportEvent("FAIL", " Add Corporate Subbiller Based on Product is Unsuccessful");
				   this.takeScreenShot();
		            driver.quit();
	                Assert.fail();

			   }else {
				   
				   Log.ReportEvent("PASS", " Add Corporate Subbiller Based on Product is Successful");

			   }			   
			   EnterSearchitem(testdatamap);
			   if(getText("//a[contains(text(),'"+testdatamap.get("BillerName").toString()+"')]/parent::td/following-sibling::td[1]").equals(testdatamap.get("CRNumber").toString()))
			   {
				   VerifyValue1(getText("//table[@id='tblSubBillers']//a[contains(text(),'"+testdatamap.get("BillerName").toString()+"')]"), testdatamap.get("BillerName").toString());
				   VerifyValue1(getText("//a[contains(text(),'"+testdatamap.get("BillerName").toString()+"')]/parent::td/following-sibling::td[5]"),testdatamap.get("Status").toString());
				   Log.ReportEvent("PASS", " Add Corporate Subbiller functionality is Successful");  
			   }
			   else
			   { Log.ReportEvent("FAIL", "  Add Corporate Subbiller Functionality is Unsuccessful");
			   this.takeScreenShot();
	            driver.quit();
               Assert.fail();	

			   }		

			}
			else
			{
				 Log.ReportEvent("FAIL", " Add Corporate Subbiller Functionality is Unsuccessful");
				   this.takeScreenShot();
		            driver.quit();
	               Assert.fail();
			}
			}
			catch (Exception e) {
				 Log.ReportEvent("FAIL", " Add Corporate Subbiller Functionality is Unsuccessful");
				   this.takeScreenShot();
		            driver.quit();
	               Assert.fail();
			}
		}
		
		
		
		 //Function Summary:Verify sub biller Individual Grid View details
		  //Function Parameters:N/A.
		  		public void SubBillerIndividualUi(Map<Object, Object> testdatamap) throws Exception
		  		{
		  			WebClickUsingJS(EdaatOR.Biller_subBiller_individual_link);
		  			addSubBillerUi(testdatamap);
		  		
		  		}
		  		 //Function Summary:To Add sub biller 
		  	  //Function Parameters:SubBillerName,IBAN Number,Beneficiary,Mobile,Emails and NationalID.
		  	  	public void addSubBillerUi(Map<Object, Object> testdatamap) throws Exception 
		  	  	{
		  	  	 try {
		  	  			WebClickUsingJS(EdaatOR.Biller_AddsubBiller_btn);
		  	  			WebClear(EdaatOR.Biller_AddsubBiller_name);
		  	  			WebEdit(EdaatOR.Biller_AddsubBiller_name,testdatamap.get("SubBillerName").toString());
		  	  			Thread.sleep(2000);
		  	  			WebClear(EdaatOR.Biller_AddsubBiller_National);
		  	  			WebEdit(EdaatOR.Biller_AddsubBiller_National,testdatamap.get("NationalID").toString());
		  	  			Thread.sleep(2000);
		  	  			WebClear(EdaatOR.Biller_AddsubBiller_IBAN);
		  	  			WebEdit(EdaatOR.Biller_AddsubBiller_IBAN,testdatamap.get("IBAN Number").toString());
		  	  			Thread.sleep(2000);
		  	  			WebClear(EdaatOR.Biller_AddsubBiller_Beneficiary);
		  	  			WebEdit(EdaatOR.Biller_AddsubBiller_Beneficiary,testdatamap.get("Beneficiary").toString());
		  	  			Thread.sleep(2000);
		  	  			EnterIbanAttach();
		  	  		    WebClear(EdaatOR.Biller_AddsubBiller_mbl);
	  	  			    WebEdit(EdaatOR.Biller_AddsubBiller_mbl,testdatamap.get("Mobile").toString());
	  	  			    Thread.sleep(2000);
		  	            WebClickUsingJS(EdaatOR.Biller_AddsubBiller_Fees);
		  	  			Thread.sleep(2000);
		  	  		    addproductUi(testdatamap);		  	  			
		  	  			//WebClear(EdaatOR.Biller_AddsubBiller_Email);
		  	  			//WebEdit(EdaatOR.Biller_AddsubBiller_Email,testdatamap.get("Email").toString());
		  	  			//Thread.sleep(2000);
		  	  			WebClickUsingJS(EdaatOR.Biller_AddsubBiller_check);
		  	  			Thread.sleep(2000);
		  	            WebClickUsingJS(EdaatOR.Biller_AddsubBiller_addbtn); 
		  	          Thread.sleep(2000);
		  	          // driver.findElement(By.xpath(EdaatOR.Biller_AddsubBiller_National)).sendKeys(Keys.PAGE_DOWN);
		  	            IndividualSubbillerErrormeaasgaeValidation(testdatamap);   
		  	      		test.log(Status.PASS,"addbiller" + driver.getTitle() +" * Create Individual Client Invoice Pass * " );
		  	              this.takeScreenShot();
		  	  		}
		  	  		catch(Exception e){
		  	  		test.log(Status.FAIL,"addbiller" + driver.getTitle() +" * Create Individual Client Invoice FAIL * " );
		  	  		this.takeScreenShot();
		  	  		}
		  	  }
		  	  public void IndividualSubbillerErrormeaasgaeValidation(Map<Object,Object> testdatamap) throws InterruptedException {
		  		this.takeScreenShot();
		  		String Expected=testdatamap.get("ExpectedMessage").toString();
		  		try {
		  			if (ExistsCheck(EdaatOR.Biller_MobileNovalidation)&&(ExistsCheck(EdaatOR.Biller_Nameerror)&&(ExistsCheck(EdaatOR.Biller_Ibanreqerror)&&(ExistsCheck(EdaatOR.Biller_Benfreqerror)&&(ExistsCheck(EdaatOR.Biller_Nationalreqerror)))) )){
		  				VerifyValue(Expected,EdaatOR.Biller_MobileNovalidation);
		  				test.log(Status.PASS, "SubbillerMobileNo and Name ErrorMessage Exists" + driver.getTitle() + " * SubbillerMobileNo and Name ErrorMessage Exists * ");
		  			}
		  			else if	(ExistsCheck(EdaatOR.Biller_Nationalid)) {
		  				VerifyValue(Expected,EdaatOR.Biller_Nationalid);
		  				test.log(Status.PASS, "Subbiller Nationalid ErrorMessage Exists" + driver.getTitle() + " * Subbiller Nationalid ErrorMessage Exists * ");	
		     }
		  			else if	(ExistsCheck(EdaatOR.Biller_Invalidmobileno)) {
		  				VerifyValue(Expected,EdaatOR.Biller_Invalidmobileno);
		  				test.log(Status.PASS, "Subbiller invalidMobileno ErrorMessage Exists" + driver.getTitle() + " * Subbiller invalidMobileno ErrorMessage Exists * ");	
		     }
		  			else if	(ExistsCheck(EdaatOR.Biller_Ibanerror)) {
		  				VerifyValue(Expected,EdaatOR.Biller_Ibanerror);
		  				test.log(Status.PASS, "Subbiller Iban ErrorMessage Exists" + driver.getTitle() + " * Subbiller Iban ErrorMessage Exists * ");	
		  			}
		  			else if	(ExistsCheck(EdaatOR.Biller_InvalidNationalid)) {
		  				VerifyValue(Expected,EdaatOR.Biller_InvalidNationalid);
		  				test.log(Status.PASS, "Subbiller InvalidNationalid ErrorMessage Exists" + driver.getTitle() + " * Subbiller InvalidNationalid ErrorMessage Exists * ");	
		  			}
		  			else if	(ExistsCheck(EdaatOR.Biller_Invalidiban)) {
		  				VerifyValue(Expected,EdaatOR.Biller_Invalidiban);
		  				test.log(Status.PASS, "Subbiller invalidIban ErrorMessage Exists" + driver.getTitle() + " * Subbiller invalidIban ErrorMessage Exists * ");	
		  			}
		  			else if	(ExistsCheck(EdaatOR.Biller_Invalidname)) {
		  				VerifyValue(Expected,EdaatOR.Biller_Invalidname);
		  				test.log(Status.PASS, "Subbiller invalidName ErrorMessage Exists" + driver.getTitle() + " * Subbiller invalidName ErrorMessage Exists * ");	
		  			}
		  		
		  		}
		  		   catch(Exception e)
		  		   {
		  			   this.takeScreenShot();
		  			test.log(Status.FAIL, "Invalid Error message" + driver.getTitle() + " * Invalid login error message is Fail* "); 	   
		  	 }

		  }
		  		
			  //Function Summary:To add product.
			  //Function Parameters:Product,Fixed Value,Percentage,IBAN and Beneficiary Name.
			  		public void addproductUi(Map<Object, Object> testdatamap) throws Exception
			  		{
			  		 try {	   
			  			WebClickUsingJS(EdaatOR.Biller_AddsubBiller_addprod);
			  			WebSelect(EdaatOR.Biller_AddsubBiller_prodname,testdatamap.get("Product").toString());
			  			Thread.sleep(2000);
			  			WebClear(EdaatOR.Biller_AddsubBiller_fixed);
			  			WebEdit(EdaatOR.Biller_AddsubBiller_fixed,testdatamap.get("Fixed Value").toString());
			  			Thread.sleep(2000);
			  			WebClear(EdaatOR.Biller_AddsubBiller_per);
			  			WebEdit(EdaatOR.Biller_AddsubBiller_per,testdatamap.get("Percentage").toString());
			  			Thread.sleep(2000);
			  			WebClear(EdaatOR.Biller_AddsubBiller_prodiban);
			  			WebEdit(EdaatOR.Biller_AddsubBiller_prodiban,testdatamap.get("IBAN").toString());
			  			Thread.sleep(2000);
			  			WebClear(EdaatOR.Biller_AddsubBiller_prodbene);
			  			WebEdit(EdaatOR.Biller_AddsubBiller_prodbene,testdatamap.get("Beneficiary Name").toString());
			  			Thread.sleep(2000);
			  			EnterIbanAttachment();
			  			Thread.sleep(2000);
			  			WebClickUsingJS(EdaatOR.Biller_AddsubBiller_prodaddbt);
			  			Thread.sleep(2000);
			  			IndividualaddSubbillerErrormeaasgaeValidation(testdatamap);
			  			this.takeScreenShot();
			  			test.log(Status.PASS,"addproduct" + driver.getTitle() +" * addproduct PASS* " );
			  		   }
			  		   catch(Exception e){
			  		    	test.log(Status.FAIL,"addproduct" + driver.getTitle() +" * addproduct FAIL * " );
			  		            this.takeScreenShot();
			  		        	}

			  		}
			  	  public void IndividualaddSubbillerErrormeaasgaeValidation(Map<Object,Object> testdatamap) throws IOException, Exception {
				  		
				  		String Expected=testdatamap.get("ExpectedMessage").toString();
				  	
				  		if(ExistsCheck(EdaatOR.Biller_entervalueerrormsg)) {
			  				VerifyValue(Expected,EdaatOR.Biller_entervalueerrormsg);
			  				test.log(Status.PASS, "Subbiller entervalue ErrorMessage Exists" + driver.getTitle() + " * Subbiller entervalue ErrorMessage Exists * ");
				  			}
				  		else if	(ExistsCheck(EdaatOR.Biller_SelectProductvalidation)) {
			  				VerifyValue(Expected,EdaatOR.Biller_SelectProductvalidation);
			  				test.log(Status.PASS, "Subbiller selectproduct ErrorMessage Exists" + driver.getTitle() + " * Subbiller selectproduct ErrorMessage Exists * ");	
			     }
				  		else if	(ExistsCheck(EdaatOR.Biller_Onlyentervalueerrormsg)) {
			  				VerifyValue(Expected,EdaatOR.Biller_Onlyentervalueerrormsg);
			  				test.log(Status.PASS, "Subbiller entervalue ErrorMessage Exists" + driver.getTitle() + " * Subbiller entervalue ErrorMessage Exists * ");
				  		}
				  		else if	(ExistsCheck(EdaatOR.Biller_Onlyenterpercentageerrormsg)) {
			  				VerifyValue(Expected,EdaatOR.Biller_Onlyenterpercentageerrormsg);
			  				test.log(Status.PASS, "Subbiller entervalue percentage ErrorMessage Exists" + driver.getTitle() + " * Subbiller entervalue percentage ErrorMessage Exists * ");
				  		}
			  	  }
			  	//Function Summary : Method to add Individual Subbiller. 
					//Parameter Summary: BillerName,National ID,IBanNumber,BeneficaryName,FixedValueAmount,Percentage Value,MobileNumber,Email.
				    public boolean AddIndSubBillerUi(Map<Object, Object> testdatamap){
					//	boolean existsElement = false;
						try{
							WebClickUsingJS(EdaatOR.Biller_Sub_Individualclient);
				        	Thread.sleep(2000);
				        	WebClickUsingJS(EdaatOR.Biller_Sub_IndividualsubBiller);
				        	Thread.sleep(2000);
							WebClick(EdaatOR.Biller_AddSubBilleer);
							WebClear(EdaatOR.Biller_AddsubBiller_name);
			  	  			WebEdit(EdaatOR.Biller_AddsubBiller_name,testdatamap.get("SubBillerName").toString());
			  	  			Thread.sleep(2000);
			  	  			WebClear(EdaatOR.Biller_AddsubBiller_National);
			  	  			WebEdit(EdaatOR.Biller_AddsubBiller_National,testdatamap.get("NationalID").toString());
			  	  			Thread.sleep(2000);
			  	  			WebClear(EdaatOR.Biller_AddsubBiller_IBAN);
			  	  			WebEdit(EdaatOR.Biller_AddsubBiller_IBAN,testdatamap.get("IBAN Number").toString());
			  	  			Thread.sleep(2000);
			  	  			WebClear(EdaatOR.Biller_AddsubBiller_Beneficiary);
			  	  			WebEdit(EdaatOR.Biller_AddsubBiller_Beneficiary,testdatamap.get("Beneficiary").toString());
			  	  			Thread.sleep(2000);
			  	  			EnterIbanAttach();
			  	  		    WebClear(EdaatOR.Biller_AddsubBiller_mbl);
		  	  			    WebEdit(EdaatOR.Biller_AddsubBiller_mbl,testdatamap.get("Mobile").toString());
		  	  			    Thread.sleep(2000);
			  	          //  WebClickUsingJS(EdaatOR.Biller_AddsubBiller_Fees);
			  	  			//Thread.sleep(2000);
							WebClickUsingJS(EdaatOR.Biller_SubBiller_Invoice_Total_AMT_ChkBox);
							Thread.sleep(3000);
							WebClickUsingJS(EdaatOR.Biller_SubBiller_FixedValue_ChkBox);
							Thread.sleep(3000);
							WebEdit(EdaatOR.Biller_SubBiller_FixedValue_Amt,testdatamap.get("FixedValueAmount").toString());
							WebClickUsingJS(EdaatOR.Biller_SubBiller_Percentage_ChkBox);
							Thread.sleep(3000);
							WebEdit(EdaatOR.Biller_SubBiller_Percentage_Val,testdatamap.get("Percentage Value").toString());
							Thread.sleep(3000);
							WebClickUsingJS(EdaatOR.Biller_SubBiller_Trans_Fee_Deduct_ChxBox);
							Thread.sleep(3000);							
							WebEdit(EdaatOR.Biller_SubBiller_Email,testdatamap.get("Email").toString());
							Thread.sleep(3000);
							WebClick(EdaatOR.Biller_SubBillerAddButton);
							//Thread.sleep(3000);
							 driver.findElement(By.xpath(EdaatOR.Biller_SubBillerName)).sendKeys(Keys.PAGE_UP);
							IndividualSubbillerErrormeaasgaeValidationbasedonInvoice(testdatamap);
							Thread.sleep(3000);
				           	
				        }catch(Exception e){
			      test.log(Status.FAIL,"Add Individual client" + driver.getTitle() +" * Add Individual client PASS * " );
				            this.takeScreenShot();
				        }
				        return existsElement;
				    }
			
				    public void IndividualSubbillerErrormeaasgaeValidationbasedonInvoice(Map<Object,Object> testdatamap) throws InterruptedException {
				  		this.takeScreenShot();
				  		String Expected=testdatamap.get("ExpectedMessage").toString();
				  		try {
				  			 if	(ExistsCheck(EdaatOR.Biller_Fixedvaluereqerror)) {				  				
				  				 
				  			    verifyElementIsPresent(EdaatOR.Biller_Fixedvaluereqerror);
				  				test.log(Status.PASS, "Subbiller FixedValue ErrorMessage Exists" + driver.getTitle() + " * Subbiller FixedValue ErrorMessage Exists * ");
				  			 }		  				
				  					
				     
				  			 else if (ExistsCheck(EdaatOR.Biller_MobileNovalidation)&&(ExistsCheck(EdaatOR.Biller_Nameerror)&&(ExistsCheck(EdaatOR.Biller_Ibanreqerror)&&(ExistsCheck(EdaatOR.Biller_Benfreqerror)&&(ExistsCheck(EdaatOR.Biller_Nationalreqerror)))) )){
				  				VerifyValue(Expected,EdaatOR.Biller_MobileNovalidation);
				  				test.log(Status.PASS, "SubbillerMobileNo and Name ErrorMessage Exists" + driver.getTitle() + " * SubbillerMobileNo and Name ErrorMessage Exists * ");
				  			}
				  			else if	(ExistsCheck(EdaatOR.Biller_Nationalid)) {
				  				VerifyValue(Expected,EdaatOR.Biller_Nationalid);
				  				test.log(Status.PASS, "Subbiller Nationalid ErrorMessage Exists" + driver.getTitle() + " * Subbiller Nationalid ErrorMessage Exists * ");	
				     }
				  			else if	(ExistsCheck(EdaatOR.Biller_Invalidmobileno)) {
				  				VerifyValue(Expected,EdaatOR.Biller_Invalidmobileno);
				  				test.log(Status.PASS, "Subbiller invalidMobileno ErrorMessage Exists" + driver.getTitle() + " * Subbiller invalidMobileno ErrorMessage Exists * ");	
				     }
				  			else if	(ExistsCheck(EdaatOR.Biller_Ibanerror)) {
				  				VerifyValue(Expected,EdaatOR.Biller_Ibanerror);
				  				test.log(Status.PASS, "Subbiller Iban ErrorMessage Exists" + driver.getTitle() + " * Subbiller Iban ErrorMessage Exists * ");	
				  			}
				  			else if	(ExistsCheck(EdaatOR.Biller_InvalidNationalid)) {
				  				VerifyValue(Expected,EdaatOR.Biller_InvalidNationalid);
				  				test.log(Status.PASS, "Subbiller InvalidNationalid ErrorMessage Exists" + driver.getTitle() + " * Subbiller InvalidNationalid ErrorMessage Exists * ");	
				  			}
				  			else if	(ExistsCheck(EdaatOR.Biller_Invalidiban)) {
				  				VerifyValue(Expected,EdaatOR.Biller_Invalidiban);
				  				test.log(Status.PASS, "Subbiller invalidIban ErrorMessage Exists" + driver.getTitle() + " * Subbiller invalidIban ErrorMessage Exists * ");	
				  			}
				  			else if	(ExistsCheck(EdaatOR.Biller_Invalidname)) {
				  				VerifyValue(Expected,EdaatOR.Biller_Invalidname);
				  				test.log(Status.PASS, "Subbiller invalidName ErrorMessage Exists" + driver.getTitle() + " * Subbiller invalidName ErrorMessage Exists * ");	
				  			}
				  			else if	(ExistsCheck(EdaatOR.Biller_percentagereqerror)) {
				  				VerifyValue(Expected,EdaatOR.Biller_percentagereqerror);
				  				test.log(Status.PASS, "Subbiller Percentage ErrorMessage Exists" + driver.getTitle() + " * Subbiller Percentage ErrorMessage Exists * ");	
				  			}
				  		
				  		}
				  		   catch(Exception e)
				  		   {
				  			   this.takeScreenShot();
				  			test.log(Status.FAIL, "Invalid Error message" + driver.getTitle() + " * Invalid login error message is Fail* "); 	   
				  	 }

				  }
				    public void AddIndivSubbillerInvoicetotal() throws InterruptedException
				    {try
				    {
				    	WebClickUsingJS(EdaatOR.Biller_Sub_Individualclient);
			        	Thread.sleep(2000);
			        	WebClickUsingJS(EdaatOR.Biller_Sub_IndividualsubBiller);
			        	Thread.sleep(2000);
						WebClick(EdaatOR.Biller_AddSubBilleer);
						Thread.sleep(2000);
						WebClick(EdaatOR.Biller_SubBillerAddButton);
						driver.findElement(By.xpath(EdaatOR.Biller_SubBillerName)).sendKeys(Keys.PAGE_UP);
						this.takeScreenShot();
						verifyElementIsPresent(EdaatOR.Biller_Totalamount);						
						test.log(Status.PASS, "Subbiller Total Invoice Amount Error message" + driver.getTitle() + " * Subbiller Total Invoice Amount error message is Pass* ");
						Thread.sleep(15000);
						WebClickUsingJS(EdaatOR.Biller_SubBiller_Invoice_Total_AMT_ChkBox);
						WebClick(EdaatOR.Biller_SubBillerAddButton);
						driver.findElement(By.xpath(EdaatOR.Biller_SubBillerName)).sendKeys(Keys.PAGE_UP);
						this.takeScreenShot();
						verifyElementIsPresent(EdaatOR.Biller_Invoicefees);						
						test.log(Status.PASS, "Subbiller Invoice Fees Error message" + driver.getTitle() + " * Subbiller  Invoice Fees error message is Pass* ");
						Thread.sleep(15000);
						WebClickUsingJS(EdaatOR.Biller_SubBiller_FixedValue_ChkBox);
						WebClick(EdaatOR.Biller_SubBillerAddButton);
						driver.findElement(By.xpath(EdaatOR.Biller_SubBillerName)).sendKeys(Keys.PAGE_UP);
						this.takeScreenShot();
						verifyElementIsPresent(EdaatOR.Biller_Fixedvaluereqerror);						
						test.log(Status.PASS, "Subbiller Invoice fixed Fees Error message" + driver.getTitle() + " * Subbiller  Invoice Fixed Fees error message is Pass* ");
						Thread.sleep(15000);
						WebClickUsingJS(EdaatOR.Biller_SubBiller_FixedValue_ChkBox);
						WebClickUsingJS(EdaatOR.Biller_SubBiller_Percentage_ChkBox);
						WebClick(EdaatOR.Biller_SubBillerAddButton);
						driver.findElement(By.xpath(EdaatOR.Biller_SubBillerName)).sendKeys(Keys.PAGE_UP);
						this.takeScreenShot();
						verifyElementIsPresent(EdaatOR.Biller_Percentagereqerror);					
						test.log(Status.PASS, "Subbiller Invoice Percentage Fees Error message" + driver.getTitle() + " * Subbiller  Invoice Percentage Fees error message is Pass* ");
						Thread.sleep(15000);
						WebClickUsingJS(EdaatOR.Biller_SubBiller_Percentage_ChkBox);
						WebClickUsingJS(EdaatOR.Biller_SubBiller_Invoice_Total_AMT_ChkBox);
						WebClickUsingJS(EdaatOR.Biller_AddsubBiller_Fees);
						WebClick(EdaatOR.Biller_SubBillerAddButton);
						driver.findElement(By.xpath(EdaatOR.Biller_SubBillerName)).sendKeys(Keys.PAGE_UP);
						this.takeScreenShot();						
						verifyElementIsPresent(EdaatOR.Biller_SelectProducterrormsg);					
						test.log(Status.PASS, "Subbiller Product with Fees Error message" + driver.getTitle() + " * Subbiller  Product with Fees error message is Pass* ");
		}
				    catch(Exception e)
			  		   {
			  			   this.takeScreenShot();
			  			test.log(Status.FAIL, "Invalid Error message" + driver.getTitle() + " * Invalid login error message is Fail* "); 	   
			  	 }
				    }

				    public void AddCarpoSubbillerInvoicetotal() throws InterruptedException
				    {try
				    {
				    	//NavigateCorporateSubBiller();
						WebClick(EdaatOR.Biller_AddSubBilleer);
						Thread.sleep(2000);
						WebClick(EdaatOR.Biller_SubBillerAddButton);
						driver.findElement(By.xpath(EdaatOR.Biller_Carporatesym)).sendKeys(Keys.PAGE_UP);
						this.takeScreenShot();
						verifyElementIsPresent(EdaatOR.Biller_Totalamount);						
						test.log(Status.PASS, "Subbiller Total Invoice Amount Error message" + driver.getTitle() + " * Subbiller Total Invoice Amount error message is Pass* ");
						Thread.sleep(15000);
						WebClickUsingJS(EdaatOR.Biller_SubBiller_Invoice_Total_AMT_ChkBox);
						WebClick(EdaatOR.Biller_SubBillerAddButton);
						driver.findElement(By.xpath(EdaatOR.Biller_Carporatesym)).sendKeys(Keys.PAGE_UP);
						this.takeScreenShot();
						verifyElementIsPresent(EdaatOR.Biller_Invoicefees);						
						test.log(Status.PASS, "Subbiller Invoice Fees Error message" + driver.getTitle() + " * Subbiller  Invoice Fees error message is Pass* ");
						Thread.sleep(15000);
						WebClickUsingJS(EdaatOR.Biller_SubBiller_FixedValue_ChkBox);
						WebClick(EdaatOR.Biller_SubBillerAddButton);
						driver.findElement(By.xpath(EdaatOR.Biller_Carporatesym)).sendKeys(Keys.PAGE_UP);
						this.takeScreenShot();
						verifyElementIsPresent(EdaatOR.Biller_Fixedvaluereqerror);						
						test.log(Status.PASS, "Subbiller Invoice fixed Fees Error message" + driver.getTitle() + " * Subbiller  Invoice Fixed Fees error message is Pass* ");
						Thread.sleep(15000);
						WebClickUsingJS(EdaatOR.Biller_SubBiller_FixedValue_ChkBox);
						WebClickUsingJS(EdaatOR.Biller_SubBiller_Percentage_ChkBox);
						WebClick(EdaatOR.Biller_SubBillerAddButton);
						driver.findElement(By.xpath(EdaatOR.Biller_Carporatesym)).sendKeys(Keys.PAGE_UP);
						this.takeScreenShot();
						verifyElementIsPresent(EdaatOR.Biller_Percentagereqerror);					
						test.log(Status.PASS, "Subbiller Invoice Percentage Fees Error message" + driver.getTitle() + " * Subbiller  Invoice Percentage Fees error message is Pass* ");
						Thread.sleep(15000);
						WebClickUsingJS(EdaatOR.Biller_SubBiller_Percentage_ChkBox);
						WebClickUsingJS(EdaatOR.Biller_SubBiller_Invoice_Total_AMT_ChkBox);
						WebClickUsingJS(EdaatOR.Biller_AddsubBiller_Fees);
						WebClick(EdaatOR.Biller_SubBillerAddButton);
						driver.findElement(By.xpath(EdaatOR.Biller_Carporatesym)).sendKeys(Keys.PAGE_UP);
						this.takeScreenShot();						
						verifyElementIsPresent(EdaatOR.Biller_SelectProducterrormsg);					
						test.log(Status.PASS, "Subbiller Product with Fees Error message" + driver.getTitle() + " * Subbiller  Product with Fees error message is Pass* ");
		}
				    catch(Exception e)
			  		   {
			  			   this.takeScreenShot();
			  			test.log(Status.FAIL, "Invalid Error message" + driver.getTitle() + " * Invalid login error message is Fail* "); 	   
			  	 }
				    }
				  //Function Summary: Method to Add sub biller Based on Product.
					  //Function Parameters: BillerName,CRNumber,Status
					public void corporateSubBillerProductErrorMessageValidation(Map<Object, Object> testdatamap,Log Log) throws Exception {					
					
						try {						
							WebClickUsingJS(EdaatOR.Biller_AddSubBiller);												
							WebClickUsingJS(EdaatOR.Biller_AddsubBiller_addprod);
				  			WebSelect(EdaatOR.Biller_AddsubBiller_prodname,testdatamap.get("Product").toString());
				  			Thread.sleep(2000);
				  			WebClear(EdaatOR.Biller_AddsubBiller_fixed);
				  			WebEdit(EdaatOR.Biller_AddsubBiller_fixed,testdatamap.get("Fixed Value").toString());
				  			Thread.sleep(2000);
				  			WebClear(EdaatOR.Biller_AddsubBiller_per);
				  			WebEdit(EdaatOR.Biller_AddsubBiller_per,testdatamap.get("Percentage").toString());
				  			Thread.sleep(2000);
				  			WebClear(EdaatOR.Biller_AddsubBiller_prodiban);
				  			WebEdit(EdaatOR.Biller_AddsubBiller_prodiban,testdatamap.get("IBAN").toString());
				  			Thread.sleep(2000);
				  			WebClear(EdaatOR.Biller_AddsubBiller_prodbene);
				  			WebEdit(EdaatOR.Biller_AddsubBiller_prodbene,testdatamap.get("Beneficiary Name").toString());
				  			Thread.sleep(2000);
				  			EnterIbanAttachment();
				  			Thread.sleep(2000);
				  			WebClickUsingJS(EdaatOR.Biller_AddsubBiller_prodaddbt);
				  			Thread.sleep(2000);
				  			AddProductOnCorporateSubBillerErrorMessageValidation(testdatamap,Log);					
				  	  		Log.ReportEvent("PASS", "Validate Product Error Message on Corporate SubBiller Page is Successful");
						}
					  catch (Exception e) {
				  	  		Log.ReportEvent("FAIL", "Validate Product Error Message on Corporate SubBiller Page is Unsuccessful");
						}
					}
					public void AddProductOnCorporateSubBillerErrorMessageValidation(Map<Object,Object> testdatamap,Log Log) throws Exception {
				  		
				  		String Expected=testdatamap.get("ExpectedMessage").toString();					  	
				  	
				  		if	(CheckElementExists(EdaatOR.Biller_CorporateSubBiller_SelectProductErrorMsg)) {
				  			if(IsDispalyed(EdaatOR.Biller_CorporateSubBiller_SelectProductErrorMsg))
				  			{
				  				VerifyValue1(getText(EdaatOR.Biller_CorporateSubBiller_SelectProductErrorMsg),Expected);
					  	  		Log.ReportEvent("PASS", "Validate Please Select Product Error Message for Product Dropdown is Successful");
				  			}else {
					  	  		Log.ReportEvent("FAIL", "Validate Please Select Product Error Message for Product Dropdown is Unsuccessful");
			  		            this.takeScreenShot();
			  		            driver.quit();
                                Assert.fail();
				  			}
			     }
				  		else if	(CheckElementExists(EdaatOR.Biller_entervalueerrormsg)) {
			  				if(IsDispalyed(EdaatOR.Biller_entervalueerrormsg))
				  			{
			  					VerifyValue1(Expected,EdaatOR.Biller_entervalueerrormsg);
					  	  		Log.ReportEvent("PASS", "Validate Enter Fixed Or Percent Fees or both Error Message for Fixed and Percentage Value Text Field is Successful");
				  			}else {
					  	  		Log.ReportEvent("FAIL", "Validate Enter Fixed Or Percent Fees or both Error Message for Fixed and Percentage Value Text Field is Unsuccessful");
			  		            this.takeScreenShot();
			  		            driver.quit();
                                Assert.fail();
				  			}				  		}
				  		else if	(CheckElementExists(EdaatOR.Biller_Onlyenterpercentageerrormsg)) {
			  				if(IsDispalyed(EdaatOR.Biller_Onlyenterpercentageerrormsg))
				  			{
			  					VerifyValue1(Expected,EdaatOR.Biller_Onlyenterpercentageerrormsg);
					  	  		Log.ReportEvent("PASS", "Validate Please Enter Some Percentage from 1-100 Error Message for Percentage Text Field is Successful");
				  			}else {
					  	  		Log.ReportEvent("FAIL", "Validate Please Enter Some Percentage from 1-100 Error Message for Percentage Text Field is Unsuccessful");
			  		            this.takeScreenShot();
			  		            driver.quit();
                                Assert.fail();
				  			}				  		}
			  	  }
					
					//Function Summary:Verify sub biller Individual Grid View details
					  //Function Parameters:N/A.
					  		public void SubBillerIndividualUi(Map<Object, Object> testdatamap,Log Log) throws Exception
					  		{
								NavigateIndividualSubBiller(Log);
					  			addSubBillerUi(testdatamap,Log);
					  		
					  		}
					  		 //Function Summary:To Add sub biller
					  	  //Function Parameters:SubBillerName,IBAN Number,Beneficiary,Mobile,Emails and NationalID.
					  	  	public void addSubBillerUi(Map<Object, Object> testdatamap,Log Log) throws Exception
					  	  	{
					  	  	 try {
					  	  			WebClickUsingJS(EdaatOR.Biller_AddsubBiller_btn);
					  	  			WebClear(EdaatOR.Biller_AddsubBiller_name);
					  	  			WebEdit(EdaatOR.Biller_AddsubBiller_name,testdatamap.get("SubBillerName").toString());
					  	  			Thread.sleep(2000);
					  	  			WebClear(EdaatOR.Biller_AddsubBiller_National);
					  	  			WebEdit(EdaatOR.Biller_AddsubBiller_National,testdatamap.get("NationalID").toString());
					  	  			Thread.sleep(2000);
					  	  			WebClear(EdaatOR.Biller_AddsubBiller_IBAN);
					  	  			WebEdit(EdaatOR.Biller_AddsubBiller_IBAN,testdatamap.get("IBAN Number").toString());
					  	  			Thread.sleep(2000);
					  	  			WebClear(EdaatOR.Biller_AddsubBiller_Beneficiary);
					  	  			WebEdit(EdaatOR.Biller_AddsubBiller_Beneficiary,testdatamap.get("Beneficiary").toString());
					  	  			Thread.sleep(2000);
					  	  			EnterIbanAttach();
					  	  		    WebClear(EdaatOR.Biller_AddsubBiller_mbl);
				  	  			    WebEdit(EdaatOR.Biller_AddsubBiller_mbl,testdatamap.get("Mobile").toString());
				  	  			    Thread.sleep(2000);
					  	            WebClickUsingJS(EdaatOR.Biller_AddsubBiller_Fees);
					  	  			Thread.sleep(2000);
					  	  		    addproductUi(testdatamap,Log);  	  			
					  	  			WebClickUsingJS(EdaatOR.Biller_AddsubBiller_check);
					  	  			Thread.sleep(2000);
					  	            WebClickUsingJS(EdaatOR.Biller_AddsubBiller_addbtn);
					  	            Thread.sleep(2000);
					  	            IndividualSubbillerErrorMessageValidation(testdatamap,Log);
						  	  		Log.ReportEvent("PASS", "Validate Error Messages on Add Individual SubBiller Page is Successful");
					  	  		}
					  	  		catch(Exception e){
					  	  		Log.ReportEvent("FAIL", "Validate Error Messages on Add Individual SubBiller Page is Unsuccessful");
								this.takeScreenShot();
						        driver.quit();
					            Assert.fail();		  	  		}
					  	  }
					  	  public void IndividualSubbillerErrorMessageValidation(Map<Object,Object> testdatamap,Log Log) throws InterruptedException {
					  		String Expected=testdatamap.get("ExpectedMessage").toString();
					  		try {
					  			if (CheckElementExists(EdaatOR.Biller_MobileNovalidation)&&(CheckElementExists(EdaatOR.Biller_Nameerror)&&(CheckElementExists(EdaatOR.Biller_Ibanreqerror)&&(CheckElementExists(EdaatOR.Biller_Benfreqerror)&&(CheckElementExists(EdaatOR.Biller_Nationalreqerror)))) )){
					  				if(IsDispalyed(EdaatOR.Biller_MobileNovalidation)) {
						  			VerifyValue1(Expected,EdaatOR.Biller_MobileNovalidation);
						  	  		Log.ReportEvent("PASS", "Validate Error Message for Name,IBAN Number,National Id,Mobile Number Text Field on Add Individual SubBiller Page is Successful");
					  				}
					  				else {
							  	  	Log.ReportEvent("FAIL", "Validate Error Message for Name,IBAN Number,National Id,Mobile Number Text Field on Add Individual SubBiller Page is Unsuccessful");
							  	  	this.takeScreenShot();
							        driver.quit();
						            Assert.fail();	
					  				}
					  			}
					  			else if	(CheckElementExists(EdaatOR.Biller_Nationalid)) {
					  				if(IsDispalyed(EdaatOR.Biller_Nationalid)) {
							  			VerifyValue1(Expected,EdaatOR.Biller_Nationalid);
							  	  		Log.ReportEvent("PASS", "Validate National Number Exist Error Message for National Id Text Field is Successful");
						  				}
						  				else {
								  	  	Log.ReportEvent("FAIL", "Validate National Number Exist Error Message for National Id Text Field is Unsuccessful");
								  	  	this.takeScreenShot();
								        driver.quit();
							            Assert.fail();	
						  				}		     }
					  			else if	(CheckElementExists(EdaatOR.Biller_Invalidmobileno)) {
					  				if(IsDispalyed(EdaatOR.Biller_Invalidmobileno)) {
							  			VerifyValue1(Expected,EdaatOR.Biller_Invalidmobileno);
							  	  		Log.ReportEvent("PASS", "Validate The Mobile Number Entered is Incorrect Error Message for Mobile Number Text Field is Successful");
						  				}
						  				else {
								  	  	Log.ReportEvent("FAIL", "Validate The Mobile Number Entered is Incorrect Error Message for Mobile Number Text Field is Unsuccessful");
								  	  	this.takeScreenShot();
								        driver.quit();
							            Assert.fail();	
						  				}		     }
					  			else if	(CheckElementExists(EdaatOR.Biller_Ibanerror)) {
					  				if(IsDispalyed(EdaatOR.Biller_Ibanerror)) {
							  			VerifyValue1(Expected,EdaatOR.Biller_Ibanerror);
							  	  		Log.ReportEvent("PASS", "Validate IBAN Number Already Exists Error Message for IBAN Number Text Field is Successful");
						  				}
						  				else {
								  	  	Log.ReportEvent("FAIL", "Validate IBAN Number Already Exists Error Message for IBAN Number Text Field is Unsuccessful");
								  	  	this.takeScreenShot();
								        driver.quit();
							            Assert.fail();	
						  				}	
					  			}
					  			else if	(CheckElementExists(EdaatOR.Biller_InvalidNationalid)) {
					  				if(IsDispalyed(EdaatOR.Biller_InvalidNationalid)) {
							  			VerifyValue1(Expected,EdaatOR.Biller_InvalidNationalid);
							  	  		Log.ReportEvent("PASS", "Validate Invalid National Id Error Message for National Id Text Field is Successful");
						  				}
						  				else {
								  	  	Log.ReportEvent("FAIL", "Validate Invalid National Id Error Message for National Id Text Field is Unsuccessful");
								  	  	this.takeScreenShot();
								        driver.quit();
							            Assert.fail();	
						  				}		  			}
					  			else if	(CheckElementExists(EdaatOR.Biller_Invalidiban)) {
					  				if(IsDispalyed(EdaatOR.Biller_Invalidiban)) {
							  			VerifyValue1(Expected,EdaatOR.Biller_Invalidiban);
							  	  		Log.ReportEvent("PASS", "Validate Invalid IBAN Error Message for IBAN Number Text Field is Successful");
						  				}
						  				else {
								  	  	Log.ReportEvent("FAIL", "Validate Invalid IBAN Error Message for IBAN Number Text Field is Unsuccessful");
								  	  	this.takeScreenShot();
								        driver.quit();
							            Assert.fail();	
						  				}		  			}
					  			else if	(CheckElementExists(EdaatOR.Biller_Invalidname)) {
					  				if(IsDispalyed(EdaatOR.Biller_Invalidname)) {
							  			VerifyValue1(Expected,EdaatOR.Biller_Invalidname);
							  	  		Log.ReportEvent("PASS", "Validate Invalid Name Error Message for Name Text Field is Successful");
						  				}
						  				else {
								  	  	Log.ReportEvent("FAIL", "Validate Invalid Name Error Message for Name Text Field is Unsuccessful");
								  	  	this.takeScreenShot();
								        driver.quit();
							            Assert.fail();	
						  				}		  			}
					  		
					  		}
					  		   catch(Exception e)
					  		   {
						  	  		Log.ReportEvent("FAIL", "Validate Error Messages on Add Individual SubBiller Page is Unsuccessful");
					  			   this.takeScreenShot();
					  			   driver.quit();
					  			   Assert.fail();
					  	 }
					  }
					  	  
					  	//Function Summary:To add product.
						  //Function Parameters:Product,Fixed Value,Percentage,IBAN and Beneficiary Name.
						  		public void addproductUi(Map<Object, Object> testdatamap,Log Log) throws Exception
						  		{			  		  
						  			WebClickUsingJS(EdaatOR.Biller_AddsubBiller_addprod);
						  			WebSelect(EdaatOR.Biller_AddsubBiller_prodname,testdatamap.get("Product").toString());
						  			Thread.sleep(2000);
						  			WebClear(EdaatOR.Biller_AddsubBiller_fixed);
						  			WebEdit(EdaatOR.Biller_AddsubBiller_fixed,testdatamap.get("Fixed Value").toString());
						  			Thread.sleep(2000);
						  			WebClear(EdaatOR.Biller_AddsubBiller_per);
						  			WebEdit(EdaatOR.Biller_AddsubBiller_per,testdatamap.get("Percentage").toString());
						  			Thread.sleep(2000);
						  			WebClear(EdaatOR.Biller_AddsubBiller_prodiban);
						  			WebEdit(EdaatOR.Biller_AddsubBiller_prodiban,testdatamap.get("IBAN").toString());
						  			Thread.sleep(2000);
						  			WebClear(EdaatOR.Biller_AddsubBiller_prodbene);
						  			WebEdit(EdaatOR.Biller_AddsubBiller_prodbene,testdatamap.get("Beneficiary Name").toString());
						  			Thread.sleep(2000);
						  			EnterIbanAttachment();
						  			Thread.sleep(2000);
						  			WebClickUsingJS(EdaatOR.Biller_AddsubBiller_prodaddbt);
						  			Thread.sleep(2000);
						  			AddProductOnIndividualSubBillerErrorMessageValidation(testdatamap,Log);
						  		   }
						  		  
						  		
						  	  public void AddProductOnIndividualSubBillerErrorMessageValidation(Map<Object,Object> testdatamap,Log Log) throws InterruptedException, IOException {
							  		
							  		String Expected=testdatamap.get("ExpectedMessage").toString();
							  	
							  		if(CheckElementExists(EdaatOR.Biller_entervalueerrormsg)) {
						  				if(IsDispalyed(EdaatOR.Biller_entervalueerrormsg))
							  			{
						  					VerifyValue1(Expected,EdaatOR.Biller_entervalueerrormsg);
								  	  		Log.ReportEvent("PASS", "Validate Enter Fixed Or Percent Fees or both Error Message for Fixed Value and Percentage Text Field is Successful");
							  			}else {
								  	  		Log.ReportEvent("FAIL", "Validate Enter Fixed Or Percent Fees or both Error Message for Fixed Value and Percentage Text Field is Unsuccessful");
						  		            this.takeScreenShot();
						  		            driver.quit();
			                                Assert.fail();
							  			}
							  			}
							  		else if	(CheckElementExists(EdaatOR.Biller_SelectProductvalidation)) {
							  			if(IsDispalyed(EdaatOR.Biller_SelectProductvalidation))
							  			{
							  				VerifyValue1(Expected,EdaatOR.Biller_SelectProductvalidation);
								  	  		Log.ReportEvent("PASS", "Validate Please Select at Least One Product Error Message for Product Dropdown is Successful");
							  			}else {
								  	  		Log.ReportEvent("FAIL", "Validate Please Select at Least One Product Error Message for Product Dropdown is Unsuccessful");
						  		            this.takeScreenShot();
						  		            driver.quit();
			                                Assert.fail();
							  			}
						     }
							  		else if	(CheckElementExists(EdaatOR.Biller_Onlyentervalueerrormsg)) {
						  				if(IsDispalyed(EdaatOR.Biller_Onlyentervalueerrormsg))
							  			{
						  					VerifyValue1(Expected,EdaatOR.Biller_Onlyentervalueerrormsg);
								  	  		Log.ReportEvent("PASS", "Validate Choose a Value and/or Percentage for the Product Error Message for Fixed Value Text Field is Successful");
							  			}else {
								  	  		Log.ReportEvent("FAIL", "Validate Choose a Value and/or Percentage for the Product Error Message for Fixed Value Text Field is Unsuccessful");
						  		            this.takeScreenShot();
						  		            driver.quit();
			                                Assert.fail();
							  			}				  		}
							  		else if	(CheckElementExists(EdaatOR.Biller_Onlyenterpercentageerrormsg)) {
						  				if(IsDispalyed(EdaatOR.Biller_Onlyenterpercentageerrormsg))
							  			{
						  					VerifyValue1(Expected,EdaatOR.Biller_Onlyenterpercentageerrormsg);
								  	  		Log.ReportEvent("PASS", "Validate Please Enter Some Percentage from 1-100 Error Message for Percentage Text Field is Successful");
							  			}else {
								  	  		Log.ReportEvent("FAIL", "Validate Please Enter Some Percentage from 1-100 Error Message for Percentage Text Field is Unsuccessful");
						  		            this.takeScreenShot();
						  		            driver.quit();
			                                Assert.fail();
							  			}				  		}
						  	  }
						  	//Function Summary : Method to add Individual Subbiller.
								//Parameter Summary: BillerName,National ID,IBanNumber,BeneficaryName,FixedValueAmount,Percentage Value,MobileNumber,Email.
							    public boolean AddIndSubBillerUi(Map<Object, Object> testdatamap,Log Log){
								//	boolean existsElement = false;
									try{
										NavigateIndividualSubBiller(Log);
							        	Thread.sleep(2000);
										WebClick(EdaatOR.Biller_AddSubBiller);
										WebClear(EdaatOR.Biller_AddsubBiller_name);
						  	  			WebEdit(EdaatOR.Biller_AddsubBiller_name,testdatamap.get("SubBillerName").toString());
						  	  			Thread.sleep(2000);
						  	  			WebClear(EdaatOR.Biller_AddsubBiller_National);
						  	  			WebEdit(EdaatOR.Biller_AddsubBiller_National,testdatamap.get("NationalID").toString());
						  	  			Thread.sleep(2000);
						  	  			WebClear(EdaatOR.Biller_AddsubBiller_IBAN);
						  	  			WebEdit(EdaatOR.Biller_AddsubBiller_IBAN,testdatamap.get("IBAN Number").toString());
						  	  			Thread.sleep(2000);
						  	  			WebClear(EdaatOR.Biller_AddsubBiller_Beneficiary);
						  	  			WebEdit(EdaatOR.Biller_AddsubBiller_Beneficiary,testdatamap.get("Beneficiary").toString());
						  	  			Thread.sleep(2000);
						  	  			EnterIbanAttach();
						  	  		    WebClear(EdaatOR.Biller_AddsubBiller_mbl);
					  	  			    WebEdit(EdaatOR.Biller_AddsubBiller_mbl,testdatamap.get("Mobile").toString());
					  	  			    Thread.sleep(2000);			  	         
										WebClickUsingJS(EdaatOR.Biller_SubBiller_Invoice_Total_AMT_ChkBox);
										Thread.sleep(3000);
										WebClickUsingJS(EdaatOR.Biller_SubBiller_FixedValue_ChkBox);
										Thread.sleep(3000);
										WebEdit(EdaatOR.Biller_SubBiller_FixedValue_Amt,testdatamap.get("FixedValueAmount").toString());
										WebClickUsingJS(EdaatOR.Biller_SubBiller_Percentage_ChkBox);
										Thread.sleep(3000);
										WebEdit(EdaatOR.Biller_SubBiller_Percentage_Val,testdatamap.get("Percentage Value").toString());
										Thread.sleep(3000);
										WebClickUsingJS(EdaatOR.Biller_SubBiller_Trans_Fee_Deduct_ChxBox);
										Thread.sleep(3000);							
										WebEdit(EdaatOR.Biller_SubBiller_Email,testdatamap.get("Email").toString());
										Thread.sleep(3000);
										WebClick(EdaatOR.Biller_SubBillerAddButton);
										IndividualSubbillerErrorMessageValidationbasedonInvoiceAmount(testdatamap,Log);
										Thread.sleep(3000);
							        	Log.ReportEvent("PASS", "Validate Error Messages on Add Individual SubBiller Page is Successful");
							           	
							        }catch(Exception e){
							        	 Log.ReportEvent("FAIL", "Validate Error Messages on Add Individual SubBiller Page is Unsuccessful");
							  			   this.takeScreenShot();
							  			   driver.quit();
							  			   Assert.fail();				        }
							        return existsElement;
							    }
						
							    public void IndividualSubbillerErrorMessageValidationbasedonInvoiceAmount(Map<Object,Object> testdatamap,Log Log) throws InterruptedException {
							  		String Expected=testdatamap.get("ExpectedMessage").toString();
							  		try {
							  			 if	(ExistsCheck(EdaatOR.Biller_Fixedvaluereqerror)) {			  				
							  				
							  			  if(IsDispalyed(EdaatOR.Biller_Fixedvaluereqerror))
								  			{
							  					VerifyValue1(getText(EdaatOR.Biller_Fees_Error),Expected);
									  	  		Log.ReportEvent("PASS", "Validate Identify Fixed Fees Error Message for Fixed Value Text Field is Successful");
								  			}else {
									  	  		Log.ReportEvent("FAIL", "Validate Identify Fixed Fees Error Message for Fixed Value Text Field is Unsuccessful");
							  		            this.takeScreenShot();
							  		            driver.quit();
				                                Assert.fail();
								  			}
							  			  } 		
							
							  			else if	(ExistsCheck(EdaatOR.Biller_percentagereqerror)) {
							  				if(IsDispalyed(EdaatOR.Biller_percentagereqerror))
								  			{
							  					VerifyValue1(getText(EdaatOR.Biller_percentagereqerror),Expected);
									  	  		Log.ReportEvent("PASS", "Validate Please Enter Some Percentage from 1-100 Error Message for Percentage Value Text Field is Successful");
								  			}else {
									  	  		Log.ReportEvent("FAIL", "Validate Please Enter Some Percentage from 1-100 Error Message for Percentage Value Text Field is Unsuccessful");
							  		            this.takeScreenShot();
							  		            driver.quit();
				                                Assert.fail();
								  			}
							  			}
							  		
							  		}
							  		   catch(Exception e)
							  		   {
							  			 Log.ReportEvent("FAIL", "Validate Error Messages on Add Individual SubBiller Page is Unsuccessful");
							  			   this.takeScreenShot();
							  			   driver.quit();
							  			   Assert.fail();				  	 }
							  }
							  //Function Summary: Method to Add sub biller Based on Product.
								  //Function Parameters: BillerName,CRNumber,Status
								public void AddCorporateSubBillerwithProductUi(Map<Object, Object> testdatamap,Log Log) throws Exception {
									String Expected=testdatamap.get("Methods").toString();						
								
									try {							
										
																
										if(Expected.equalsIgnoreCase("General Info"))
									{
										 WebClickUsingJS(EdaatOR.Biller_AddSubBiller);
										 EnterFeesDeductionBasedonProduct(testdatamap);
										 addProductDetails(testdatamap,Log);							
										 Thread.sleep(2000);	
										 EnterGeneralinfo(testdatamap);							
										 WebClick(EdaatOR.Biller_SubBillerAddButton);
										 driver.findElement(By.xpath(EdaatOR.Biller_Carporatesym)).sendKeys(Keys.PAGE_UP);
										 Thread.sleep(2000);
										 if(IsDispalyed(EdaatOR.Biller_CarpNameerror))
										 {
											 verifyElementIsPresent(EdaatOR.Biller_CarpCrNameerror);						
											 verifyElementIsPresent(EdaatOR.Biller_CarpIbanerror);						
											 verifyElementIsPresent(EdaatOR.Biller_CarpBenNameerror);						
											 verifyElementIsPresent(EdaatOR.Biller_CarpTaxNoerror);	
											 Log.ReportEvent("PASS", "Validate Enter General Info Error Messages on Add Corporate SubBiller Page is Successful");
										 }else {
											 Log.ReportEvent("FAIL", "Validate Enter General Info Error Messages on Add Corporate SubBiller Page is Unsuccessful");
								  			 this.takeScreenShot();
								  			 driver.quit();
								  			 Assert.fail();	
										 }												
									}
									else if(Expected.equalsIgnoreCase("National address"))
									{
										 WebClickUsingJS(EdaatOR.Biller_AddSubBiller);
										 EnterFeesDeductionBasedonProduct(testdatamap);
										 addProductDetails(testdatamap,Log);							
										 Thread.sleep(2000);
										 driver.findElement(By.xpath(EdaatOR.Biller_subbiller_Corpbuildno)).sendKeys(Keys.PAGE_DOWN);
										 EnterNationalAddressinfo(testdatamap);
										 WebClick(EdaatOR.Biller_SubBillerAddButton);							
										 Thread.sleep(1000);
										 if(IsDispalyed(EdaatOR.Biller_CarpCityerror)) {
											 verifyElementIsPresent(EdaatOR.Biller_CarpDisterror);						
											 verifyElementIsPresent(EdaatOR.Biller_CarpStreeterror);						
											 verifyElementIsPresent(EdaatOR.Biller_CarpPoatalerror);						
											 verifyElementIsPresent(EdaatOR.Biller_CarpBuildNoerror);
											 Log.ReportEvent("PASS", "Validate Enter National Address Error Messages on Add Corporate SubBiller Page is Successful");
										 }else {
											 Log.ReportEvent("FAIL", "Validate Enter National Address Error Messages on Add Corporate SubBiller Page is Unsuccessful");
								  			 this.takeScreenShot();
								  			 driver.quit();
								  			 Assert.fail();	
										 }
										 }
																
									 
									
									else if(Expected.equalsIgnoreCase("Contact Info"))
									{
										 WebClickUsingJS(EdaatOR.Biller_AddSubBiller);
										 EnterFeesDeductionBasedonProduct(testdatamap);
										 addProductDetails(testdatamap,Log);							
										 Thread.sleep(2000);
										 EnterContactInfo(testdatamap);
										 WebClick(EdaatOR.Biller_SubBillerAddButton);							
										 Thread.sleep(1000);
										 driver.findElement(By.xpath(EdaatOR.Biller_subbiller_Corpbuildno)).sendKeys(Keys.PAGE_DOWN);
										 if(IsDispalyed(EdaatOR.Biller_CarpEmpNameerror))
										 {
											 verifyElementIsPresent(EdaatOR.Biller_CarpEmpEmailerror);						
											 verifyElementIsPresent(EdaatOR.Biller_CarpEmpMobNoerror);
											 Log.ReportEvent("PASS", "Validate Enter Contact Info Error Messages on Add Corporate SubBiller Page is Successful");
										 }else {
											 Log.ReportEvent("FAIL", "Validate Enter Contact Info Error Messages on Add Corporate SubBiller Page is Unsuccessful");
								  			 this.takeScreenShot();
								  			 driver.quit();
								  			 Assert.fail();	
										 }
										
															
									}
									else if(Expected.equalsIgnoreCase("Invalid Contact Info"))
									{
										 WebClickUsingJS(EdaatOR.Biller_AddSubBiller);
										 EnterFeesDeductionBasedonProduct(testdatamap);
										 addProductDetails(testdatamap,Log);							
										 Thread.sleep(2000);
										 EnterContactInfo(testdatamap);
										 WebClick(EdaatOR.Biller_SubBillerAddButton);							
										 Thread.sleep(1000);
										 driver.findElement(By.xpath(EdaatOR.Biller_subbiller_Corpbuildno)).sendKeys(Keys.PAGE_DOWN);
										 if(IsDispalyed(EdaatOR.Biller_CarpEmpinvNameerror))
										 {
											 verifyElementIsPresent(EdaatOR.Biller_CarpEmpinvEmailerror);						
											 verifyElementIsPresent(EdaatOR.Biller_CarpEmpinvMobNoerror);
											 Log.ReportEvent("PASS", "Validate Enter Valid Contact Info Error Messages on Add Corporate SubBiller Page is Successful");
										 }else {
											 Log.ReportEvent("FAIL", "Validate Enter Valid Contact Info Error Messages on Add Corporate SubBiller Page is Unsuccessful");
											 this.takeScreenShot();
								  			 driver.quit();
								  			 Assert.fail();	
										 }
										
															
									}
									else if(Expected.equalsIgnoreCase("Invalid National address"))
									{
										 WebClickUsingJS(EdaatOR.Biller_AddSubBiller);
										 EnterFeesDeductionBasedonProduct(testdatamap);
										 addProductDetails(testdatamap,Log);							
										 Thread.sleep(2000);
										 EnterNationalAddressinfo(testdatamap);
										 WebClick(EdaatOR.Biller_SubBillerAddButton);							
										 Thread.sleep(1000);
										 driver.findElement(By.xpath(EdaatOR.Biller_subbiller_Corpbuildno)).sendKeys(Keys.PAGE_DOWN);
										 if(IsDispalyed(EdaatOR.Biller_CarpInvDisterror))
										 {
											 verifyElementIsPresent(EdaatOR.Biller_CarpInvStreeterror);				
											 Log.ReportEvent("PASS", "Validate Enter Valid National Address Error Messages on Add Corporate SubBiller Page is Successful");
										 }else {
											 Log.ReportEvent("FAIL", "Validate Enter Valid National Address Error Messages on Add Corporate SubBiller Page is Unsuccessful");
											 this.takeScreenShot();
								  			 driver.quit();
								  			 Assert.fail();	
										 }													
									 
									}
									else if(Expected.equalsIgnoreCase("Invalid General Info"))
									{
										
										 WebClickUsingJS(EdaatOR.Biller_AddSubBiller);
										 EnterFeesDeductionBasedonProduct(testdatamap);
										 addProductDetails(testdatamap,Log);							
										 Thread.sleep(2000);
										 EnterGeneralinfo(testdatamap);							
										 WebClick(EdaatOR.Biller_SubBillerAddButton);
										 driver.findElement(By.xpath(EdaatOR.Biller_Carporatesym)).sendKeys(Keys.PAGE_UP);
										 Thread.sleep(2000);
										 if(IsDispalyed(EdaatOR.Biller_CarpInvNameerror))
										 {
											 verifyElementIsPresent(EdaatOR.Biller_CarpInvCrNameerror);						
											 verifyElementIsPresent(EdaatOR.Biller_CarpInvIbanerror);						
											 verifyElementIsPresent(EdaatOR.Biller_CarpInvTaxNoerror);
											 Log.ReportEvent("PASS", "Validate Enter Valid General Info Error Messages on Add Corporate SubBiller Page is Successful");
										 }
										 else {
											 Log.ReportEvent("FAIL", "Validate Enter Valid General Info Error Messages on Add Corporate SubBiller Page is Unsuccessful");
											 this.takeScreenShot();
								  			 driver.quit();
								  			 Assert.fail();	
										 }
															
									}
									else if(Expected.equalsIgnoreCase("Attachments"))
									{
										
										 WebClickUsingJS(EdaatOR.Biller_AddSubBiller);
										 EnterFeesDeductionBasedonProduct(testdatamap);
										 addProductDetails(testdatamap,Log);							
										 Thread.sleep(2000);
										 WebEdit(EdaatOR.Biller_subbiller_Corpname, testdatamap.get("BillerName").toString());
										 Thread.sleep(2000);
										 WebEdit(EdaatOR.Biller_subbiller_Corpcrnum, testdatamap.get("CRNumber").toString());
										 Thread.sleep(2000);					     
										 WebEdit(EdaatOR.Biller_subbiller_Corpiban, testdatamap.get("IBANNumber").toString());
										 Thread.sleep(2000);
										 WebEdit(EdaatOR.Biller_subbiller_Corpbenfname, testdatamap.get("BeneficiaryName").toString());
										 Thread.sleep(2000);
										 WebEdit(EdaatOR.Biller_subbiller_Corptaxnum, testdatamap.get("Taxnumber").toString());
										 EnterNationalAddressinfo(testdatamap);
										 EnterContactInfo(testdatamap);
										 WebClick(EdaatOR.Biller_SubBillerAddButton);							
										 Thread.sleep(1000);
										 if(IsDispalyed(EdaatOR.Biller_CarpEmpinvIbanatcerror))
										 {
											 verifyElementIsPresent(EdaatOR.Biller_CarpEmpinvIbanatcerror);	
											 Log.ReportEvent("PASS", "Validate Attach Attachments Error Message on Add Corporate SubBiller Page is Successful");
										 }else {
											 Log.ReportEvent("FAIL", "Validate Attach Attachments Error Message on Add Corporate SubBiller Page is Unsuccessful");
											 this.takeScreenShot();
								  			 driver.quit();
								  			 Assert.fail();
										 }						
															
									}			
										 Log.ReportEvent("PASS", "Validate Error Messages on Add Corporate SubBiller Page is Successful");
																}
								  catch (Exception e) {
										 Log.ReportEvent("FAIL", "Validate Error Messages on Add Corporate SubBiller Page is Unsuccessful");
										 this.takeScreenShot();
							  			 driver.quit();
							  			 Assert.fail();
									}
								}
		}



	
	
	
  
	
	
    

