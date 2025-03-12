/**
* Test Script Name  				 : N/A
* Objective                          : Verify the TermsManagement Functionality.
* Version      						 : 1.0
* Author       						 : Arun Kumar MS
* Created Date 			      		 : 11/08/2023
* Last Updated on					 : N/A
* Updated By   			 			 : 
* Pre-Conditions					 : N/A
* Epic Details						 : N/A
* User Story Details				 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.biller.pages;

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

import com.azmqalabs.edaattestautomation.common.Log;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;



public class BillerSettingTermsManagementPage extends BasePage
{

	public BillerSettingTermsManagementPage(WebDriver driver,ExtentTest test)
	{
		 this.driver=driver;
		 this.test=test;
		 
		 PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  
	

	@FindBy(xpath = EdaatOR.Biller_Termsmanagementsym)
	public WebElement TermsManagement;
		
	    
	    public boolean Exists(){
	    	return super.Exists(TermsManagement); 
		}
	  //Function Summary :Method to Verify grid View of termsmanagement module. 
	//Parameter Summary: N/A.
	  
		public void VerifyGridView(Log Log) {
			try {
		      
		        if (ExistsCheck(EdaatOR.Biller_Termsnameinarabic)) {
					Log.ReportEvent("PASS", "Terms Management Grid View verified Successfully.");
				}
				else {
					Log.ReportEvent("FAIL", "Terms Management Grid View Verification failed.");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			}

			catch (Exception e) {
				Log.ReportEvent("FAIL", "Terms Management Grid View Verification failed.");
				takeScreenShot();
				driver.quit();
				Assert.fail();
				
			}
		}
	
			//Function Summary   : Method to verify terms Search Functionality
			//Parameter Summary : EnglishName
			public void VerifySearchTerm(Map<Object,Object>testdatamap,Log Log) throws Exception {
				try {
					WebEdit(EdaatOR.Biller_TermTXT_Field,testdatamap.get("EnglishName").toString());
					Thread.sleep(2000);
					WebClickUsingJS(EdaatOR.Biller_Term_SearchBTN);
					Thread.sleep(4000);
					if((getText("(//tr/td[contains(text(),'"+testdatamap.get("EnglishName").toString()+"')])[1]").equals(testdatamap.get("EnglishName").toString()))) {
						
					  	Log.ReportEvent("PASS", " Search Term is Successful");
						
					}
					else {
					  	Log.ReportEvent("FAIL", " Search Term is Unsuccessful");
					  	takeScreenShot();
					  	driver.quit();
					  	Assert.fail();

					}
				}
				catch(Exception e){
					Log.ReportEvent("FAIL", " Search Term is Unsuccessful");
				  	takeScreenShot();
				  	driver.quit();
				  	Assert.fail();					
				}
					
			}
			
			//Function Summary   : Method to DeActivate Terms
			//Parameter Summary : EnglishName,ArabicName,ArabicText,EnglishText
		public void DeActivateTerm(Map<Object,Object>testdatamap,Log Log) {
				
			 try {
				 WebClickUsingJS(EdaatOR.Biller_IndividualToggle);
					Thread.sleep(1000);
					if(getText(EdaatOR.Biller_ConfirmationPopupMessage).equals(testdatamap.get("DeActive").toString())) {
						WebClick(EdaatOR.Biller_YesBtn);
						Log.ReportEvent("PASS", " Term is Deactivated Successfully");
					}
					else {
						Log.ReportEvent("FAIL", " Term is not Deactivated Successfully");
		                takeScreenShot();
		                driver.quit();
		                Assert.fail();
					}
		        	
				}
				catch(Exception e){
					Log.ReportEvent("FAIL", " Term is not Deactivated Successfully");
		            takeScreenShot();
		            driver.quit();
		            Assert.fail();
				}
}
//Function Summary :Method to Navigate "TermsManagement" Page
		//Parameter Summary: N/A
		public void navigatetoTermsManagement(Log Log) throws InterruptedException {	
	        try {
	        	WebClick(EdaatOR.Biller_Settingbtn);
		        Thread.sleep(1000);
		        WebClick(EdaatOR.Biller_Termsmanagementbtn);
		        Thread.sleep(2000);
		        if(ExistsCheck(EdaatOR.Biller_Termsmanagementsym)) {
		        	Log.ReportEvent("PASS", "Terms Mangement Page is Loaded Successfully");
		        }
		        else {
		        	Log.ReportEvent("FAIL", "Terms Mangement Page is not Loaded Successfully");
		        	takeScreenShot();
		        	driver.quit();
		        	Assert.fail();

		        }
				
	        }
			catch(Exception e){
				Log.ReportEvent("FAIL", "Terms Mangement Page is not Loaded Successfully");
	        	takeScreenShot();
	        	driver.quit();
	        	Assert.fail();

				
			}
			
		}
		
		//Function Summary :Method to Search Term in TermsManagement" Page
		//Parameter Summary:EnglishName
	/*	private void SearchTerm(Map<Object, Object> testdatamap) {
			try {
				  WebEdit(EdaatOR.Biller_searchtxtfield, testdatamap.get("EnglishName").toString());
			      WebClick(EdaatOR.Biller_Searchbtn);
				
				test.log(Status.PASS," Search Term  is Successful" + driver.getTitle() +" * Search Term PASS * " );	
			}
			catch(Exception e){
				test.log(Status.FAIL,"Search Term is Failed" + driver.getTitle() +" * Search Term is FAIL * " );
				
			}
		}*/

		//Function Summary : Method to add and active Term 
		//Parameter Summary: ArebicName,EnglishName,ArebicTermName,EnglishTermName
		public void VerifyToActivateTerm(Map<Object, Object> testdatamap,Log Log) {
			 try {
				 WebClickUsingJS(EdaatOR.Biller_IndividualToggle);
					Thread.sleep(1000);
					if(getText(EdaatOR.Biller_ConfirmationPopupMessage).equals(testdatamap.get("Active").toString())) {
						WebClick(EdaatOR.Biller_YesBtn);
						Log.ReportEvent("PASS", " Term is Activated Successfully");
					}
					else {
						Log.ReportEvent("FAIL", " Term is not Activated Successfully");
		                takeScreenShot();
		                driver.quit();
		                Assert.fail();
					}
		        	
				}
				catch(Exception e){
					Log.ReportEvent("FAIL", " Term is not Activated Successfully");
		            takeScreenShot();
		            driver.quit();
		            Assert.fail();
				}
	
	}
	
   //Function Summary : Method to add and active Term 
   //Parameter Summary: ArebicName,EnglishName,ArebicTermName,EnglishTermName
   public void VerifyToviewActiveTerm(Map<Object, Object> testdatamap,Log Log) {
        try {
			 WebClickUsingJS(EdaatOR.Biller_TermsManagement_Editbtn);
			Thread.sleep(2000);			
			String pricelistName = driver.findElement(By.xpath(EdaatOR.Biller_TermName_ENG)).getAttribute("value");
	if(pricelistName.equals(testdatamap.get("EnglishName").toString())) {
	Log.ReportEvent("PASS", " View Terms Details Button Verification is Successful");

	}
	else {
	      Log.ReportEvent("FAIL", " View Terms Details Button Verification is Unsuccessful");
			  this.takeScreenShot(); 
			  driver.quit();
			  Assert.fail();
			        	
			}
		}
  catch (Exception e) {
	Log.ReportEvent("FAIL", " View Terms Details Button Verification is Unsuccessful");
     this.takeScreenShot(); 
    driver.quit();
    Assert.fail();
			}
	}	
//Function Summary : Method to verify Delete Term Button
		//Parameter Summary:NA.
		public void DeleteTermButton(Map<Object, Object> testdatamap,Log Log) throws Exception
		{
		   try {
			WebClickUsingJS(EdaatOR.Biller_Setting_termMgm_deleteBtn);
		    Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Setting_termMgm_deleteyes);

	        Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Terms_menu);
	        Thread.sleep(2000);
	        WebEdit(EdaatOR.Biller_TermTXT_Field,testdatamap.get("EnglishName").toString());
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Term_SearchBTN);
			Thread.sleep(2000);
			if(ExistsCheck(EdaatOR.Biller_Setting_termMgm_after_delete)) {
				Log.ReportEvent("PASS", "Delete Term is Successful");

			}
			else { 
				Log.ReportEvent("FAIL", "Delete Term is Unsuccessful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
				
			}
	        
		}catch(Exception e){
		Log.ReportEvent("FAIL", "Delete Term is Unsuccessful");
		takeScreenShot();
		driver.quit();
		Assert.fail();
	}
			
		}
  //Function Summary : Method to Add Term
  //Parameter Summary:ArabicName,EnglishName,ArabicText,EnglishText
  public void AddTerm(Map<Object,Object>testdatamap,Log Log) {
	
	try {
		WebClick(EdaatOR.Biller_AddTerm_Btn);
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_TermName_Arabic,testdatamap.get("ArabicName").toString());
	    Thread.sleep(1000);
	    WebEdit(EdaatOR.Biller_TermName_ENG,testdatamap.get("EnglishName").toString());
	    Thread.sleep(1000);
	    WebEdit(EdaatOR.Biller_TermText_Arabic,testdatamap.get("ArabicText").toString());
	    Thread.sleep(1000);
	    WebEdit(EdaatOR.Biller_TermText_Eng,testdatamap.get("EnglishText").toString());
	    Thread.sleep(1000);
	  if(testdatamap.get("ActiveToggle").toString().equals("ActiveToggle")) {
		WebClick(EdaatOR.Biller_TermToggle);

	    }
	     WebClick(EdaatOR.Biller_TermSave_BTN);
	     Thread.sleep(1000);

	
	if(ExistsCheck(EdaatOR.Biller_Settings_TermArabicNameError)) {
		Log.ReportEvent("FAIL", "Add Term is Unsuccessful");
		takeScreenShot();
		driver.quit();
		Assert.fail();
     }
	else if(ExistsCheck(EdaatOR.Biller_Settings_TermEngNameError)){
		Log.ReportEvent("FAIL", "Add Term is Unsuccessful");
		takeScreenShot();
		driver.quit();
		Assert.fail();
	}
	else if(ExistsCheck(EdaatOR.Biller_Settings_TermTextArabicError)){
		Log.ReportEvent("FAIL", "Add Term is Unsuccessful");
		takeScreenShot();
		driver.quit();
		Assert.fail();
	}
	
	else {
		Log.ReportEvent("PASS", "Add Term is Successful");
		
		  }

         }
    catch(Exception e){
	Log.ReportEvent("FAIL", "Add Term is Unsuccessful");
					takeScreenShot();
					driver.quit();
					Assert.fail();
					
	}
}
//Function Summary : Method to Verify AddTerm UI Error Msg
//Parameter Summary:ErrorMessage1,ErrorMessage2
  public void AddTermErrorMessageValidation(Map<Object,Object>testdatamap,Log Log) throws Exception {
	 
	try {
		 String ErrorMessage1=testdatamap.get("ErrorMessage1").toString();
		  String ErrorMessage2=testdatamap.get("ErrorMessage2").toString();
		  WebClick(EdaatOR.Biller_AddTerm_Btn);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_TermName_Arabic,testdatamap.get("ArabicName").toString());
		    Thread.sleep(1000);
		    WebEdit(EdaatOR.Biller_TermName_ENG,testdatamap.get("EnglishName").toString());
		    Thread.sleep(1000);
		    WebEdit(EdaatOR.Biller_TermText_Arabic,testdatamap.get("ArabicText").toString());
		    Thread.sleep(1000);
		    WebEdit(EdaatOR.Biller_TermText_Eng,testdatamap.get("EnglishText").toString());
		     Thread.sleep(1000);
		    WebClick(EdaatOR.Biller_TermSave_BTN);
		     Thread.sleep(1000);
		if(getText(EdaatOR.Biller_Settings_TermArabicNameError).equals(ErrorMessage1)
			||getText(EdaatOR.Biller_Settings_TermArabicNameError).equals(ErrorMessage2)) {
			
         Log.ReportEvent("PASS", " Error Message Validation for Term Name in Arabic Text Field is Successful");			
	     }
		else if(getText(EdaatOR.Biller_Settings_TermEngNameError).equals(ErrorMessage1)
				||getText(EdaatOR.Biller_Settings_TermEngNameError).equals(ErrorMessage2)){
	         Log.ReportEvent("PASS", "Error Message Validation for Term Name in English Text Field is Successful");			

		}
		else if(getText(EdaatOR.Biller_Settings_TermTextArabicError).toString().equals(ErrorMessage1)
				||getText(EdaatOR.Biller_Settings_TermTextArabicError).toString().equals(ErrorMessage2)){
	         Log.ReportEvent("PASS", "Error Message Validation for Term Text in Arabic Text Field is Successful");			

			
		}
		else if(getText(EdaatOR.Biller_Settings_TermTextArabicError).toString().equals(ErrorMessage1)
				||getText(EdaatOR.Biller_Settings_TermTextArabicError).toString().equals(ErrorMessage2)){
	         Log.ReportEvent("PASS", "Error Message Validation for Term Text in Arabic Text Field is Successful");			

			
		}
		
		else {

	         Log.ReportEvent("FAIL", "Add Term UI Error Message Validation is Unsuccessful");	
	         takeScreenShot();
	         driver.quit();
	         Assert.fail();
			  }
	}
	catch(Exception e){
		 Log.ReportEvent("FAIL", "Add Term UI Error Message Validation is Unsuccessful");	
         takeScreenShot();
         driver.quit();
         Assert.fail();
								
	}
}
}