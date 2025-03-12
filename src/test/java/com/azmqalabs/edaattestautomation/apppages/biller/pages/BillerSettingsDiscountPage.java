/**
* Test Script Name  				 : N/A
* Objective     					 : Verify Discount Management Functionality.
* Version      						 : 1.0
* Author       						 : Arun kumar MS
* Created Date 			      		 : 24/05/2023
* Last Updated on					 : N/A
* Updated By   			 			 : 
* Pre-Conditions					 : N/A
* Manual Test case Name				 : N/A
* Epic Details						 : N/A
* User Story Details				 : N/A
* Defects affecting this test script : N/A
* WorkArounds/Known Issues			 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.biller.pages;

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



public class BillerSettingsDiscountPage extends BasePage
{

	public BillerSettingsDiscountPage(WebDriver driver,ExtentTest test)
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

	//Function Summary : Navigate to "Discount Management" Page
	//Parameter Summary: N/A
	public void navigateToDisCountPage(Log Log) throws Exception {
		
		try {
		WebClickUsingJS(EdaatOR.Biller_Settings);
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Biller_Menu_Discount);
		Thread.sleep(2000);
		if(ExistsCheck(EdaatOR.Biller_Discount_Mgm_Page)) {
	    	Log.ReportEvent("PASS", "Discount management page is loaded Successfully");

		}
		else {
	    	Log.ReportEvent("FAIL", "Discount management page is not loaded Successfully");
	    	this.takeScreenShot();
	    	driver.quit();
	    	Assert.fail();

		}
		}
		
		catch(Exception e){
			Log.ReportEvent("FAIL", "Discount management page is not loaded Successfully");
	    	this.takeScreenShot();
	    	driver.quit();
	    	Assert.fail();
		}
	}

	//Function Summary : Method to click on"Add Discount"button in "Discount Management"Page
	//Parameter Summary: N/A
	public void ClickOnDiscountBtn() throws Exception {
		WebClick(EdaatOR.Biller_Discount_AddBtn);
	}

	//Function Summary : Method to enter Discount name in "Discount Name in English"textfield in "Add Discount"popup
	//Parameter Summary: pname
	public void EnterDiscEnglishBox(String pname) throws Exception {
		WebEdit(EdaatOR.Biller_Discount_EngInp, pname);
	}

	//Function Summary : Method to enter Discount name in"Discount Name in Arabic"textfield in "Add Discount"popup
	//Parameter Summary: lstname
	public void EnterDiscArabicBox(String lstname) throws Exception {
		WebEdit(EdaatOR.Biller_Discount_AtrabInp, lstname);
	}

	//Function Summary : Method to enter percentage in"percentage"textfield in "Add Discount"popup
	//Parameter Summary: lstname
	public void EnterDiscPercentBox(String lstname) throws Exception {
		WebEdit(EdaatOR.Biller_Discount_Percent, lstname);
	}

	//Function Summary : Method to click on "Add Discount"button "Add Discount"popup 
	//Parameter Summary: N/A
	public void ClickOnDiscountAddBtn() throws Exception {
		WebClick(EdaatOR.Biller_Discount_AddDiscBtn);
	}

	//Function Summary : Method to enter Discount Name in "Discount Name"textfield 
	//Parameter Summary: lstname
	public void EnterDiscNameBox(String lstname) throws Exception {
		WebEdit(EdaatOR.Biller_Discount_DiscName, lstname);
	}

	//Function Summary : Method to click on "Search"button in "Discount Management" Page 
	//Parameter Summary: N/A
	public void ClickOnDiscountSearchBtn() throws Exception {
		WebClick(EdaatOR.Biller_Discount_SearchBtn);
	}

	//Function Summary : Method to click on "delete"icon in Discount Management gridview 
	//Parameter Summary: N/A
	public void ClickOnDiscountDeleteBtn() throws Exception {
		WebClick(EdaatOR.Biller_Discount_DeleteBtn);
	}
	//Function Summary : Method to click on "Yes,Delete"button in "Are you sure to delete this Discount?"popup 
	//Parameter Summary: N/A
	public void ClickOnDiscountConfYesBtn() throws Exception {
		WebClick(EdaatOR.Biller_Discount_YesConfBtn);
	}

	//Function Summary : Method to Create Discount
	//Parameter Summary: DiscountEngName,DiscountArabicName,DiscountPercentage
	public void AddDiscount(Map<Object,Object>testdatamap,Log Log) throws Exception {
		try {
		ClickOnDiscountBtn();
		Thread.sleep(1500);
		EnterDiscEnglishBox(testdatamap.get("DiscountEngName").toString());
		Thread.sleep(500);
		EnterDiscArabicBox(testdatamap.get("DiscountArabicName").toString());
		Thread.sleep(200);
		EnterDiscPercentBox(testdatamap.get("DiscountPercentage").toString());
		ClickOnDiscountAddBtn();
		Thread.sleep(1500);
		
		if(ExistsCheck(EdaatOR.Biller_Settings_DiscEngNameError)) {
			Log.ReportEvent("Fail", "Discount is not Added Successfully");
			takeScreenShot();
			driver.quit();
			Assert.fail();
	     }
		else if(ExistsCheck(EdaatOR.Biller_Settings_DiscArabicNameError)){
			Log.ReportEvent("Fail", "Discount is not Added Successfully");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
		else if(ExistsCheck(EdaatOR.Biller_Settings_DiscountPercentageError)){
			Log.ReportEvent("Fail", "Discount is not Added Successfully");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
		else if(ExistsCheck(EdaatOR.Biller_Settings_DiscArabicNameError)){
			Log.ReportEvent("Fail", "Discount is not Added Successfully");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
		else {
			Log.ReportEvent("PASS", "Discount is Added Successfully");
		}
		
	}catch(Exception e){
		Log.ReportEvent("Fail", "Discount is not Added Successfully");
		takeScreenShot();
		driver.quit();
		Assert.fail();
		}	
	}

	//Function Summary : Method to Search "Discount" in "Discount Management"Page
	//Parameter Summary: DiscountEngName
	public void searchDiscount(Map<Object,Object>testdatamap,Log Log) throws Exception {
		try {
		EnterDiscNameBox(testdatamap.get("DiscountEngName").toString());
		ClickOnDiscountSearchBtn();
		if(getText("//td[text()='"+testdatamap.get("DiscountEngName").toString()+"']").equals(testdatamap.get("DiscountEngName").toString())) {
			Log.ReportEvent("PASS", "Discount Search is Successful");

		}
		else {
			Log.ReportEvent("FAIL", "Discount Search is unsuccessful");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
		Thread.sleep(1500);
	}catch(Exception e){
			Log.ReportEvent("FAIL", "Discount Search is unsuccessful");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	//Function Summary : Method to delete the "Discount" in "Discount Management" Page
	//Parameter Summary: DeleteDiscount
	public void DeleteDiscount(Map<Object,Object>testdatamap, Log Log) throws Exception {
		try {
		ClickOnDiscountDeleteBtn();
		Thread.sleep(1500);
		ClickOnDiscountConfYesBtn();
		Thread.sleep(1500);
		EnterDiscNameBox(testdatamap.get("DiscountEngName").toString());
		ClickOnDiscountSearchBtn();
		if(ExistsCheck(EdaatOR.Biller_Product_NoData)) {
			Log.ReportEvent("PASS", "Discount is Deleted Successfully");

		}
		
    else {
		Log.ReportEvent("FAIL", "Discount is not Deleted Successfully");
		takeScreenShot();
		driver.quit();
		Assert.fail();

		}
		
	}catch(Exception e){
		Log.ReportEvent("FAIL", "Discount is not Deleted Successfully");
		takeScreenShot();
		driver.quit();
		Assert.fail();
	}	

	}

	//Function Summary : Navigate to Search Discount.
	//Parameter Summary: N/A.
	public void SearchDiscount(Map<Object, Object> testdatamap,Log Log) throws Exception {
		// TODO Auto-generated method stub
		navigateToDisCountPage(Log);
		AddDiscount(testdatamap,Log);
		searchDiscount(testdatamap,Log);
		Thread.sleep(1500);
		verifyElementIsPresent(EdaatOR.Biller_Discount_Name);
    	Log.ReportEvent("PASS", " Verify Delete Discount Suceessfull");
    	this.takeScreenShot();
		
	}
	//Function Summary   : Method to ClickonBillersettings
	//Parameter Summary  : N/A
		public void ClickonBillersettings() {
		WebClickUsingJS(EdaatOR.Biller_Settings);
		waitForPageToLoad();
		}
	 public void ClickonDiscountsManagement() {
		 
			WebClickUsingJS(EdaatOR.Biller_settings_Discount);
			waitForPageToLoad();
		}
	
	//Function Summary : Method to Add and Activate Discount
	//Parameter Summary: Active
	public void ActivateDiscount(Map<Object,Object> testdatamap,Log Log) {
		try {
			AddDiscount(testdatamap,Log);
			searchDiscount(testdatamap,Log);
			WebClickUsingJS(EdaatOR.Biller_IndividualToggle);
			Thread.sleep(1000);
			if(getText(EdaatOR.Biller_ConfirmationPopupMessage).equals(testdatamap.get("Active").toString())) {
				Thread.sleep(1000);
				WebClick(EdaatOR.Biller_YesBtn);
				Log.ReportEvent("PASS", " Discount is Activated Successfully");
			}
			else {
				Log.ReportEvent("FAIL", " Discount is not Activated Successfully");
                takeScreenShot();
                driver.quit();
                Assert.fail();
			}
        	
		}
		catch(Exception e){
			Log.ReportEvent("FAIL", " Discount is not Activated Successfully");
            takeScreenShot();
            driver.quit();
            Assert.fail();
		}
		
	}
		
		//Function Summary   : Method to  EnterDiscountSearchitem
		//Parameter Summary  : DiscountEnglish
		public void EnterDiscountSearchitem(String DiscountEnglish) throws Exception {
			WebEdit(EdaatOR.Biller_settings_Discount_srch,DiscountEnglish);
			Thread.sleep(1000);
			WebClick(EdaatOR.Biller_settings_Discount_srchbtn);
		}
		//Function Summary   : Method to   VerifyDiscoutStatusToggel
		//Parameter Summary  : DiscountEnglish
		public void VerifyDiscoutStatusToggel(Map<Object, Object> testdatamap,Log Log)
		{
			try {
				AddDiscount(testdatamap,Log);
				Thread.sleep(2000);
				searchDiscount(testdatamap,Log);
				WebClickUsingJS(EdaatOR.Biller_IndividualToggle);
					 if (getText(EdaatOR.Biller_Systm_Active_toggle_Msg).toString().equals(testdatamap.get("Active").toString())) {
							WebClick(EdaatOR.Biller_YesBtn);
				            Thread.sleep(1000);
				            Log.ReportEvent("PASS", "Activate Toggle is Successful");
				        } else if (getText(EdaatOR.Biller_Systm_DeActive_toggle_Msg).toString().equals(testdatamap.get("Inactive").toString())) {
							WebClick(EdaatOR.Biller_YesBtn);
				            Thread.sleep(1000);
				            Log.ReportEvent("PASS", "Deactivate Toggle is Successful");
				        } else {
				            Log.ReportEvent("FAIL", "Activate/Deactivate Toggle Action was not Successful");
				            this.takeScreenShot();
				            driver.quit();
				            Assert.fail();
				        }
				      
				    } catch (Exception e) {
				            Log.ReportEvent("FAIL", "Toggle Action was not Successful");
				            this.takeScreenShot();
				            driver.quit();
				            Assert.fail();
				        }   
		}
			//Function Summary : To add Discount.
	//Parameter Summary: DiscountEngName,DiscountArabicName and DiscountPercentage.
	public void AddDiscountDeactivate(Map<Object,Object> testdatamap,Log Log) throws InterruptedException
	{
		try {
		       ClickOnDiscountBtn();
		       Thread.sleep(1500);
		       EnterDiscEnglishBox(testdatamap.get("DiscountEngName").toString());
		       Thread.sleep(500);
	           EnterDiscArabicBox(testdatamap.get("DiscountArabicName").toString());
		       Thread.sleep(200);
		       EnterDiscPercentBox(testdatamap.get("DiscountPercentage").toString());
		       Thread.sleep(1500);
		       WebClickUsingJS(EdaatOR.Biller_Discount_toggle);
		       Thread.sleep(1500);
		       ClickOnDiscountAddBtn();
		       
		       if(ExistsCheck(EdaatOR.Biller_Settings_DiscEngNameError)) {
					Log.ReportEvent("Fail", "Discount is not Added Successfully");
					takeScreenShot();
					driver.quit();
					Assert.fail();
			     }
				else if(ExistsCheck(EdaatOR.Biller_Settings_DiscArabicNameError)){
					Log.ReportEvent("Fail", "Discount is not Added Successfully");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
				else if(ExistsCheck(EdaatOR.Biller_Settings_DiscountPercentageError)){
					Log.ReportEvent("Fail", "Discount is not Added Successfully");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
				else if(ExistsCheck(EdaatOR.Biller_Settings_DiscArabicNameError)){
					Log.ReportEvent("Fail", "Discount is not Added Successfully");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
				else {
					Log.ReportEvent("PASS", "Discount is Added Successfully");
				}
		       DeactivateDiscount(testdatamap,Log);
		       
				
			}catch(Exception e){
				Log.ReportEvent("Fail", "Discount is not Added Successfully");
				takeScreenShot();
				driver.quit();
				Assert.fail();
				}
	
	}
	
	//Function Summary : To deactivate Discount.
	//Parameter Summary: N/A.
	public void DeactivateDiscount(Map<Object,Object>testdatamap,Log Log) 
	{
	  try {
			searchDiscount(testdatamap,Log);
		     WebClick(EdaatOR.Biller_Discount_Deactivatetgl);
	         Thread.sleep(1500);
		     if(CheckElementExists(EdaatOR.Biller_Discount_Deact_confirm)==true)
		     {
			    WebClickUsingJS(EdaatOR.Biller_Discount_Canyes);
		        Thread.sleep(1500);
			    Log.ReportEvent("PASS", "Discount is Deactivated Successfully");
		      }
		     else {
		    	 Log.ReportEvent("FAIL", "Discount is not Deactivated Successfully");
		    	 this.takeScreenShot();
		    	 driver.quit();
		    	 Assert.fail();
		     }
	      }
		catch(Exception e){
			Log.ReportEvent("FAIL", "Discount is not Deactivated Successfully");
	    	 this.takeScreenShot();
	    	 driver.quit();
	    	 Assert.fail();
		}
	}
	//Function Summary : Method to Validate Add Discount Functionality Error Messages
	//Parameter Summary: ExpectedResult
	public void AddDiscountErrorMessageValidation(Map<Object,Object>testdatamap,Log Log) throws IOException, Exception {
		ClickOnDiscountBtn();
		Thread.sleep(1500);
		EnterDiscEnglishBox(testdatamap.get("DiscountEngName").toString());
		Thread.sleep(500);
		EnterDiscArabicBox(testdatamap.get("DiscountArabicName").toString());
		Thread.sleep(200);
		EnterDiscPercentBox(testdatamap.get("DiscountPercentage").toString());
		ClickOnDiscountAddBtn();
		Thread.sleep(1500);
		try {
			if(getText(EdaatOR.Biller_Settings_DiscEngNameError).equals(testdatamap.get("ErrorMessage1").toString())
					||getText(EdaatOR.Biller_Settings_DiscEngNameError).equals(testdatamap.get("ErrorMessage2").toString())) {
				Log.ReportEvent("PASS", "Error Message Validation for Discount Name in English Text Field is Successful");
				
		     }
			else if(getText(EdaatOR.Biller_Settings_DiscArabicNameError).equals(testdatamap.get("ErrorMessage1").toString())
					||getText(EdaatOR.Biller_Settings_DiscArabicNameError).equals(testdatamap.get("ErrorMessage2").toString())){
				Log.ReportEvent("PASS", "Error Message Validation for Discount Name in Arabic Text Field is Successful");

			}
			else if(getText(EdaatOR.Biller_Settings_DiscountPercentageError).equals(testdatamap.get("ErrorMessage1").toString())
					||getText(EdaatOR.Biller_Settings_DiscountPercentageError).equals(testdatamap.get("ErrorMessage2").toString())){
				Log.ReportEvent("PASS", "Error Message Validation for Percentage Text Field is Successful");

				
			}
	
        	else {
        		  Log.ReportEvent("FAIL", "Add Discount UI Error Message Validation is Unsuccessful");	
     	         takeScreenShot();
     	         driver.quit();
     	         Assert.fail();

			  }
		}

		catch(Exception e){
			 Log.ReportEvent("FAIL", "Add Discount UI Error Message Validation is Unsuccessful");	
 	         takeScreenShot();
 	         driver.quit();
 	         Assert.fail();
		}
	}
	


}
