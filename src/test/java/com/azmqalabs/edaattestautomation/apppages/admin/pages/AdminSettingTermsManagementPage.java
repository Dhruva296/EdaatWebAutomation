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
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

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



public class AdminSettingTermsManagementPage extends BasePage
{

	public AdminSettingTermsManagementPage(WebDriver driver,ExtentTest test)
	{
		 this.driver=driver;
		 this.test=test;
		 
		 PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  
	

	@FindBy(xpath = EdaatOR.Admin_Termsmanagementsym)
	public WebElement TermsManagement;
		
	    
	    public boolean Exists(){
	    	return super.Exists(TermsManagement); 
		}
	 
	  
		
		//Function Summary   : Method to Navigate Term management section in Settings Module.
		//Parameter Summary : N/A
			public void navigateTerm(Log Log) throws Exception {
				WebClickUsingJS(EdaatOR.Admin_SettingsMenu);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Admin_Terms_menu);
				Thread.sleep(2000);
				if(CheckElementExists(EdaatOR.Admin_Termsmanagementsym)) {
		        	Log.ReportEvent("PASS", "Term management Page is Loaded successfully");
				}
				else {
		        	Log.ReportEvent("FAIL", "Term management Page is not Loaded successfully");
		        	this.takeScreenShot();
		        	driver.quit();Assert.fail();
				}
			}
				//Function Summary   : Method to Delete Terms
			//Parameter Summary : N/A
			public void  VerifyDeleteTerms(Map<Object,Object>testdatamap,Log Log)
			{
				try{
					navigateTerm(Log);
					
					AddTermAndDeActivate(testdatamap,Log);
					Thread.sleep(1000);
				    WebClick(EdaatOR.Admin_Terms_Delete_Button);
					Thread.sleep(2000);
					
					WebClick(EdaatOR.Biller_Setting_termMgm_deleteyes);
					Thread.sleep(3000);
					WebEdit(EdaatOR.Admin_TermTXT_Field,testdatamap.get("EnglishName").toString());
					Thread.sleep(1000);
					WebClickUsingJS(EdaatOR.Admin_Term_SearchBTN);
					Thread.sleep(1000);
					if(CheckElementExists(EdaatOR.Admin_Terms_NoDataText)) {
						Log.ReportEvent("PASS", "Term is deleted Successfully");
					}
					else {
					Log.ReportEvent("FAIL", "Term is not deleted Successfully");
					this.takeScreenShot();
					driver.quit();Assert.fail();
					}
				}
					catch(Exception e){
					Log.ReportEvent("FAIL", "Term is not deleted Successfully");
					this.takeScreenShot();
					driver.quit();Assert.fail();

					}				
}
	//Function Summary   : Method to Search Terms
	//Parameter Summary : EnglishName
			public void SearchTerm(Map<Object,Object>testdatamap,Log Log) throws Exception {
				try {
					WebEdit(EdaatOR.Admin_TermTXT_Field,testdatamap.get("EnglishName").toString());
					Thread.sleep(2000);
					WebClickUsingJS(EdaatOR.Admin_Term_SearchBTN);
					Thread.sleep(2000);
					if(getText("//td[text()='"+testdatamap.get("EnglishName").toString()+"']").equals(testdatamap.get("EnglishName").toString())){
						Log.ReportEvent("PASS", "Searched Term is displayed Successfully");

					}
					else {
						Log.ReportEvent("FAIL", "Searched Term is not displayed Successfully");
						this.takeScreenShot();	
					}
				}
				catch(Exception e){
					Log.ReportEvent("FAIL", "'Search Term' is not Successful");

					this.takeScreenShot();

				}					
			}
			//Function Summary   : Method to Add and DeActivate Terms
			//Parameter Summary : EnglishName,ArabicName,ArabicText,EnglishText
		public void AddTermAndDeActivate(Map<Object,Object>testdatamap,Log Log) {
				
				try {
					WebClick(EdaatOR.Admin_AddTerm_Btn);
					Thread.sleep(1000);
					WebEdit(EdaatOR.Admin_TermName_Arabic,testdatamap.get("ArabicName").toString());
					Thread.sleep(1000);
					WebEdit(EdaatOR.Admin_TermName_ENG,testdatamap.get("EnglishName").toString());
					Thread.sleep(1000);
					WebEdit(EdaatOR.Admin_TermText_Arabic,testdatamap.get("ArabicText").toString());
					Thread.sleep(1000);
					WebEdit(EdaatOR.Admin_TermText_Eng,testdatamap.get("EnglishText").toString());
					
					Thread.sleep(1000);
					WebClickUsingJS(EdaatOR.Admin_TermToggle);
					Thread.sleep(1000);
					
					Thread.sleep(1000);
					WebClick(EdaatOR.Admin_TermSave_BTN);
					Thread.sleep(1000);
					SearchTerm(testdatamap,Log);
					Thread.sleep(1000);
					WebClickUsingJS(EdaatOR.Admin_TermStatusToggle);
					Thread.sleep(1000);
					
					if(CheckElementExists(EdaatOR.Admin_Termsmanagementsym)) {
			        	Log.ReportEvent("PASS", "'Add Term and Deactivate' is Successful");
						Thread.sleep(1000);
						WebClick(EdaatOR.Admin_TermConfirmBTN);
					}
					else {
			        	Log.ReportEvent("FAIL", "'Add Term and Deactivate' is not Successful");
						this.takeScreenShot();
						driver.quit();Assert.fail();
					}
				}
				catch(Exception e){
		        	Log.ReportEvent("FAIL", "'Add Term and Deactivate' is not Successful");
					this.takeScreenShot();
					driver.quit();Assert.fail();
				}		
		}
		//Function Summary : Method to view term details button
		//Parameter Summary: ArabicName,EnglishName,ArabicText,EnglishText
		public void VerifyToviewActiveTerm(Map<Object, Object> testdatamap,Log Log) {
			 try {
					WebClick(EdaatOR.Admin_AddTerm_Btn);
					Thread.sleep(1000);
					WebEdit(EdaatOR.Admin_TermName_Arabic,testdatamap.get("ArabicName").toString());
					Thread.sleep(1000);
					WebEdit(EdaatOR.Admin_TermName_ENG,testdatamap.get("EnglishName").toString());
					Thread.sleep(1000);
					WebEdit(EdaatOR.Admin_TermText_Arabic,testdatamap.get("ArabicText").toString());
					Thread.sleep(1000);
					WebEdit(EdaatOR.Admin_TermText_Eng,testdatamap.get("EnglishText").toString());
					Thread.sleep(1000);
					WebClick(EdaatOR.Admin_TermToggle);
					Thread.sleep(1000);
					WebClick(EdaatOR.Admin_TermSave_BTN);
					Thread.sleep(1000);
					SearchTerm(testdatamap,Log);
					Thread.sleep(1000);
					WebClickUsingJS(EdaatOR.Admin_TermsManagement_Editbtn);
			        if(WebGetText(EdaatOR.Admin_TermsManagement_updatetxt).equals(testdatamap.get("ViewText").toString())) {
			        	Log.ReportEvent("PASS", "View term details is Successful");
			        }
			        else {
			        	Log.ReportEvent("FAIL", "View term details is not Successful");
			        	this.takeScreenShot();
			        	driver.quit();
			        	Assert.fail();

			        }
			 }
				catch(Exception e){
		        	Log.ReportEvent("FAIL", "View term details is not Successful");
					this.takeScreenShot();
					driver.quit();
		        	Assert.fail();
			
		}
		}

				//Function Summary   : Method to Verify Search Term
		//Parameter Summary : EnglishName,ArabicName,ArabicText,EnglishText
		public void SettingsTermsManagementSearchTerm(Map<Object,Object>testdatamap,Log Log)
		{
			try
			{
			navigateTerm(Log);
			WebClick(EdaatOR.Admin_AddTerm_Btn);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_TermName_Arabic,testdatamap.get("ArabicName").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_TermName_ENG,testdatamap.get("EnglishName").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_TermText_Arabic,testdatamap.get("ArabicText").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_TermText_Eng,testdatamap.get("EnglishText").toString());
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_TermToggle);
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_TermSave_BTN);
			Thread.sleep(1000);
			SearchTerm(testdatamap,Log);
			}
			catch(Exception e){
		        Log.ReportEvent("FAIL", "Search term is not Successful");
	        	this.takeScreenShot();
	        	driver.quit();Assert.fail();
			}		
		}
		//Function Summary   : Method to Add and Activate Terms
		//Parameter Summary : EnglishName,ArabicName,ArabicText,EnglishText
		public void VerifyTermsMgnActive(Map<Object, Object> testdatamap,Log Log) {
			// TODO Auto-generated method stub
			
			try {
				WebClick(EdaatOR.Admin_AddTerm_Btn);
				Thread.sleep(1000);
				WebEdit(EdaatOR.Admin_TermName_Arabic,testdatamap.get("ArabicName").toString());
				Thread.sleep(1000);
				WebEdit(EdaatOR.Admin_TermName_ENG,testdatamap.get("EnglishName").toString());
				Thread.sleep(1000);
				WebEdit(EdaatOR.Admin_TermText_Arabic,testdatamap.get("ArabicText").toString());
				Thread.sleep(1000);
				WebEdit(EdaatOR.Admin_TermText_Eng,testdatamap.get("EnglishText").toString());
				Thread.sleep(1000);				
				WebClick(EdaatOR.Admin_TermSave_BTN);
				Thread.sleep(1000);
				SearchTerm(testdatamap,Log);				
				Thread.sleep(1000);			
				WebClickUsingJS(EdaatOR.Admin_TermStatusToggle);
				Thread.sleep(2000);
					if(CheckElementExists(EdaatOR.Admin_TermMngConformActive)) {
					Thread.sleep(1000);			
					WebClick(EdaatOR.Admin_TermConfirmBTN);
					Thread.sleep(1000);
	        	    Log.ReportEvent("PASS", "Add and Activate Term is successful");
	        	    }
					else{
		        	Log.ReportEvent("FAIL", "Add and Activate Term is not successful");
		        	this.takeScreenShot();
		        	driver.quit();
		        	Assert.fail();
					}	
			} catch (Exception e) {
				Log.ReportEvent("FAIL", "Add and Activate Term is not succesful");
	        	this.takeScreenShot();
				e.printStackTrace();
	        	driver.quit();
	        	Assert.fail();
			}
		}		
//Function Summary :Method to Verify grid view of terms management module. 
//Parameter Summary: N/A.
			  
				public void VerifyGridView(Log Log) {
					try {
						navigateTerm(Log);
				        Thread.sleep(1000);
				        if(CheckElementExists(EdaatOR.Admin_TermsNameEng)&& CheckElementExists(EdaatOR.Admin_TermsNameAr)) {
		        	
			        	Log.ReportEvent("PASS", "Grid view of Terms management is Successful");
				        }
				        else{
				        	Log.ReportEvent("FAIL", "Grid view of Terms management is not Successful");
				        this.takeScreenShot();
				        driver.quit();Assert.fail();
					}
					}
					catch(Exception e){
			        	Log.ReportEvent("FAIL", "Grid view of Terms management is not Successful");
						this.takeScreenShot();
				        driver.quit();Assert.fail();

					}				
		
			}	
			public void AddTerm(Map<Object,Object>testdatamap) throws Exception {
				WebClick(EdaatOR.Admin_AddTerm_Btn);
				Thread.sleep(500);
				WebEdit(EdaatOR.Admin_TermName_Arabic,testdatamap.get("ArabicName").toString());
				Thread.sleep(500);
				WebEdit(EdaatOR.Admin_TermName_ENG,testdatamap.get("EnglishName").toString());
				Thread.sleep(500);
				WebEdit(EdaatOR.Admin_TermText_Arabic,testdatamap.get("ArabicText").toString());
				Thread.sleep(500);
				WebEdit(EdaatOR.Admin_TermText_Eng,testdatamap.get("EnglishText").toString());
				
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_TermSave_BTN);
			}	
				
				
				//Function Summary  : method to verify Error messages in term management page
				//Parameter Summary : ExpectedResult
				public void VerifyAddTermErrorMsg(Map<Object,Object>testdatamap,Log Log) throws InterruptedException{
					{
						try {
							Thread.sleep(1000);
							AddTerm(testdatamap);
							
							if (ExistsCheck(EdaatOR.Admin_MandatoryErrorMsg)){	

								VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_ArNameErrorMsg));
								Thread.sleep(500);
								VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_EnNameErrorMsg));
								Thread.sleep(500);
								VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_ArDescErrorMsg));
								Log.ReportEvent("PASS", "Verify 'This field is required' error Message is successful");

							}
							else if (testdatamap.get("ExpectedResult").toString().equals(getText(EdaatOR.Admin_ArNameErrorMsg))) {
								Log.ReportEvent("PASS", "Verify error Message for 'Term name in Arabic' is successful");

							}

							else {
								Log.ReportEvent("FAIL", "Verify Add term error Message is not successful");
								this.takeScreenShot();
								driver.quit();Assert.fail();							}

						} catch (Exception e) {
							Log.ReportEvent("FAIL", "Verify Add term error Message is not successful");
							this.takeScreenShot();
							driver.quit();Assert.fail();						}

					}
				}							

				
}