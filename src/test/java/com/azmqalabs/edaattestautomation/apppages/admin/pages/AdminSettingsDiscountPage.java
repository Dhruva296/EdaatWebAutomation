/**
*
* Test Script Name                   : N/A
* Objective                          : Admin Settings Discounts Management functionality
* Version                            : 1.0
* Author                             : Kathirvelu Mohan
* Created Date                       : 23/05/2023
* Last Updated on                    : N/A
* Updated By                         : Dhruva Kumar S
* Pre-Conditions                     : N/A
* Epic Details                       : N/A
* User Story Details                 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.azmqalabs.edaattestautomation.common.Log;
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
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;



public class AdminSettingsDiscountPage extends BasePage
{

	public AdminSettingsDiscountPage(WebDriver driver,ExtentTest test)
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

//Function summary:Navigate to Discount Management
//Function Parameters:NA
	public void navigateDisCountPage(Log Log) throws Exception {
		Thread.sleep(3000);
		WebClickUsingJS(EdaatOR.Admin_Settings);
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Admin_Menu_Discount);
		Thread.sleep(2000);
		if(CheckElementExists(EdaatOR.Admin_Discount_mgm_page)) {
			Log.ReportEvent("PASS", "Discount Management page is Loaded Successfully");
			}
			else{
				Log.ReportEvent("FAIL", "Discount Management page is not Loaded Successfully");
				this.takeScreenShot();
				driver.quit();Assert.fail();
			}
	}
	//Function Summary : Method to ClickOnDiscountBtn
	//Parameter Summary: N/A

	public void ClickOnDiscountBtn() throws Exception {
		WebClick(EdaatOR.Admin_AddDiscount);
	}
	//Function Summary : Method to EnterDiscEnglishBox
	//Parameter Summary: pname
	public void EnterDiscEnglishBox(String pname)throws Exception {
	WebEdit(EdaatOR.Admin_DiscountNameEn, pname);
	}
	//Function Summary : Method to EnterDiscArabicBox
	//Parameter Summary: lstname
	public void EnterDiscArabicBox(String lstname)throws Exception {
		WebEdit(EdaatOR.Admin_DiscountNameAr, lstname);
	}
	//Function Summary : Method to EnterDiscPercentBox
	//Parameter Summary: lstname
	public void EnterDiscPercentBox(String lstname) throws Exception{
		WebEdit(EdaatOR.Admin_DiscPercentage, lstname);
	}
    //Function Summary : Method to ClickOnDiscountAddBtn
	//Parameter Summary: N/A
	public void ClickOnDiscountAddBtn() throws Exception{
		WebClick(EdaatOR.Admin_AddDiscountBtn);
	}
 //Function Summary : Method to EnterDiscNameBox
	//Parameter Summary: lstname
	public void EnterDiscNameBox(String lstname)throws Exception {
		WebEdit(EdaatOR.Admin_SearchDiscountName, lstname);
	}
	//Function Summary : Method to ClickOnDiscountSearchBtn
	//Parameter Summary: N/A
	public void ClickOnDiscountSearchBtn()throws Exception {
		WebClick(EdaatOR.Admin_SearchDiscountBtn);
	}
    //Function Summary : Method to ClickOnDiscountDeleteBtn
	//Parameter Summary: N/A
	public void ClickOnDiscountDeleteBtn() throws Exception{
		WebClick(EdaatOR.Admin_Discount_DeleteBtn);
	//	WebClick(EdaatOR.Biller_Discount_DeleteBtn);
	}
	//Function Summary : Method to ClickOnDiscountConfYesBtn
	//Parameter Summary: N/A
	public void ClickOnDiscountConfYesBtn() throws Exception{
		//WebClick(EdaatOR.Biller_Discount_YesConfBtn);
    	WebClick(EdaatOR.Admin_Discount_YesConfBtn);

	}

//Function Summary  : Method to Add  Discount
//Parameter Summary : DiscountEngName,DiscountArabicName,DiscountPercentage
	public void AddDiscount(Map<Object,Object>testdatamap,Log Log) throws Exception {
		ClickOnDiscountBtn();
		Thread.sleep(1500);
		EnterDiscEnglishBox(testdatamap.get("DiscountEngName").toString());
		Thread.sleep(500);
		EnterDiscArabicBox(testdatamap.get("DiscountArabicName").toString());
		Thread.sleep(200);
		EnterDiscPercentBox(testdatamap.get("DiscountPercentage").toString());
		Thread.sleep(200);
		ClickOnDiscountAddBtn();
		Thread.sleep(1500);
		if(CheckElementExists(EdaatOR.Admin_Discount_mgm_page)) {
			Log.ReportEvent("PASS", "Add Discount is Successful");
			}
			else{
				Log.ReportEvent("FAIL", "Add Discount is not Successful");
				this.takeScreenShot();
				driver.quit();Assert.fail();
			}
	}
	//Function Summary : Method to Search "Discount" in "Discount Management"Page
	//Parameter Summary: DiscountEngName
	public void searchDiscount(Map<Object,Object>testdatamap,Log Log) throws Exception {
		EnterDiscNameBox(testdatamap.get("DiscountEngName").toString());
		ClickOnDiscountSearchBtn();
		Thread.sleep(1500);
		if(CheckElementExists("//td[text()='"+testdatamap.get("DiscountEngName").toString()+"']")) {
			Log.ReportEvent("PASS", "Search Discount is Successful");
			}
			else{
				Log.ReportEvent("FAIL", "Search Discount is not Successful");
				this.takeScreenShot();
				driver.quit();Assert.fail();
			}
	}

    //Function Summary : Method to verifyDeleteDiscount
	//Parameter Summary: N/A
	public void verifyDeleteDiscount(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			AddDiscount(testdatamap,Log);
			Thread.sleep(1000);
			searchDiscount(testdatamap,Log);
			Thread.sleep(1000);
			ClickOnDiscountDeleteBtn();
			Thread.sleep(1500);
			if((getText(EdaatOR.Admin_Tamplate_ConfirmDeletePop).equals (testdatamap.get("DeleteDiscount").toString()))) {
				ClickOnDiscountConfYesBtn();
				Log.ReportEvent("PASS", "Delete Discount is Successful");
			}
			else{
				Log.ReportEvent("FAIL", "Delete Discount is not Successful");
				this.takeScreenShot();
				driver.quit();Assert.fail();
			}

		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Delete Discount is not Successful");
			this.takeScreenShot();
			driver.quit();Assert.fail();
		}
	}
//Function summary:verify Add Deactivate Discount
//Function Parameters:ActivationMsg and DeactivationMsg.
	public void verifyAddDeactivateDiscount(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			AddDiscount(testdatamap,Log);
			searchDiscount(testdatamap,Log);
			Thread.sleep(1500);
			WebClickUsingJS(EdaatOR.Admin_DiscountStatusToggle);
//			ValidateTwoValue(getText(EdaatOR.Admin_confirmationMsg), testdatamap.get("ActivationMsg").toString());
			WebClickUsingJS(EdaatOR.Admin_Activate);
			Thread.sleep(1500);
			WebClickUsingJS(EdaatOR.Admin_DiscountStatusToggle);
//				ValidateTwoValue(getText(EdaatOR.Admin_confirmationMsg), testdatamap.get("DeactivationMsg").toString());
				if(getText(EdaatOR.Admin_confirmationMsg).equals(testdatamap.get("DeactivationMsg").toString())) {
					WebClickUsingJS(EdaatOR.Admin_Activate);
					Log.ReportEvent("PASS", "Deactivate Discount is Successful");
					}
					else{
						Log.ReportEvent("FAIL", "Deactivate Discount is not Successful");
						this.takeScreenShot();
						driver.quit();Assert.fail();
					}
		}
	    	catch(Exception e){
				Log.ReportEvent("FAIL", "Deactivate Discount is not Successful");
				this.takeScreenShot();
				driver.quit();Assert.fail();
		}
	}
	//Function summary:verify Status Toggle
	//Function Parameters:NA
	public void StatusToggle(Map<Object,Object> testdatamap,Log Log) throws Exception
	{
		verifyAddDeactivateDiscount(testdatamap,Log);
	}
	
	//Function Summary  : Method to search discount in discount Management.
    //Parameter Summary : N/A.

	public void SearchDiscount(Map<Object, Object> testdatamap,Log Log) throws Exception {
		// TODO Auto-generated method stub
		try {
			AddDiscount(testdatamap,Log);
			searchDiscount(testdatamap,Log);
			
		}
	    	catch(Exception e){
				Log.ReportEvent("FAIL", "Search Discount is not Successful");
				this.takeScreenShot();
				driver.quit();Assert.fail();
		}
	}
	
	//Function Summary  : Method to Add and DeActivate Discount
	//Parameter Summary : ActivationMsg
	public void VerifyAddDiscountActivate(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			AddDiscount(testdatamap,Log);
			Thread.sleep(1500);
			searchDiscount(testdatamap,Log);
			Thread.sleep(1500);
			WebClickUsingJS(EdaatOR.Admin_DiscountStatusToggle);
			Thread.sleep(1500);
			if(getText(EdaatOR.Admin_confirmationMsg).equals(testdatamap.get("ActivationMsg").toString())) {
				WebClickUsingJS(EdaatOR.Admin_Activate);
				Log.ReportEvent("PASS", "Activate Discount is Successful");
				}
				else{
					Log.ReportEvent("FAIL", "Activate Discount is not Successful");
					this.takeScreenShot();
					driver.quit();Assert.fail();
				}
		}
	    	catch(Exception e){
				Log.ReportEvent("FAIL", "Activate Discount is not Successful");
				this.takeScreenShot();
				driver.quit();Assert.fail();
		}
	}
	
	//Function Summary  : method to verify Error messages in Add discount page
	//Parameter Summary : ExpectedResult, ArabicName, Percentage
	public void VerifyAddDiscountErrorMsg(String ArabicName,String Percentage,String EnglishName, String ExpectedResult,Log Log) throws InterruptedException{
		{
			try {
				
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_AddDiscount);
				Thread.sleep(500);
				WebEdit(EdaatOR.Admin_DiscountNameEn, EnglishName);
				WebEdit(EdaatOR.Admin_DiscountNameAr, ArabicName);
				WebEdit(EdaatOR.Admin_DiscPercentage, Percentage);
				WebClick(EdaatOR.Admin_AddDiscountBtn);
				Thread.sleep(500);
				
				if (ExistsCheck(EdaatOR.Admin_MandatoryErrorMsg)){	
				
						VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_InvoiceTemplateArNameErrMsg));
						Thread.sleep(500);
						VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_InvoiceTemplateEnNameErrMsg));
						Thread.sleep(500);
						VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_PercentageReqErrorMsg));
						Log.ReportEvent("PASS", "Verify 'This field is required' error Message is successful");

				}
				else if (ExpectedResult.equals(getText(EdaatOR.Admin_InvoiceTemplateArNameErrMsg))) {
					Log.ReportEvent("PASS", "Verify Error message for Arabic name is successful");

				}
				else if (ExpectedResult.equals(getText(EdaatOR.Admin_PercentageReqErrorMsg))) {
					Log.ReportEvent("PASS", "Verify Error message for Percentage is successful");

				}
				else {
					Log.ReportEvent("FAIL", "Verify Add Discount error Message is not successful");
					this.takeScreenShot();
					driver.quit();Assert.fail();
				}

			} catch (Exception e) {
				Log.ReportEvent("FAIL", "Verify Add Discount error Message is not successful");
				this.takeScreenShot();
				driver.quit();Assert.fail();			}

		}
	}
}
