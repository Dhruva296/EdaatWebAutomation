/**
* Test Script Name                   : N/A
* Objective                          : Admin Approved Billers Management related functions
* Version                            : 1.0
* Author                             : Kathirvelu M
* Created Date                       : 05/06/2023
* Last Updated on                    : N/A
* Updated By                         : Dhruva Kumar S
* Pre-Conditions                     : N/A
* Manual Testcase Name               : N/A
* Epic Details                       : N/A
* User Story Details                 : N/A
* Defects affecting this test script : None
* Work Arounds/Known Issues          : None
**/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.internal.TestMethodWithDataProviderMethodWorker;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.azmqalabs.edaattestautomation.testscripts.admin.AdminNotApprovedMgmCloseBiller;

public class AdminReceivablesPaidOutsideEdaatPage extends BasePage {

	public AdminReceivablesPaidOutsideEdaatPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.Admin_SystemMgm_SearchItem)
	public WebElement Client;

	public boolean Exists() {
		return super.Exists(Client);
	}
	public void NavigatetoPaidOutsideEdaat(Log log) throws InterruptedException
	{
		try {
		WebClickUsingJS(EdaatOR.Admin_Receivable_Link);
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Admin_ReceviablesPaidOutsideEddatLink);
		if(CheckElementExists(EdaatOR.Admin_Paid_Outside_Edaat_Header)) {
			log.ReportEvent("pass", "Navigate to Paid OutSideEdaat is Successful");
		}
		else {
			log.ReportEvent("fail", "Navigate to Paid OutSideEdaat is Unsuccessful");
			takeScreenShot();
			driver.quit();
			Assert.fail();
			}
		}
		catch(Exception e){
			e.printStackTrace();
			log.ReportEvent("fail", "Navigate to Paid OutSideEdaat is Unsuccessful");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}
	
		//Function Summary  : Method to Verify Grid View Details
	//Parameter Summary : ActivationMsg
	public void GridView(Map<Object,Object> testdatamap,Log Log) {
	
		try {
			  NavigatetoPaidOutsideEdaat(Log);
			  Thread.sleep(2000);
			  if(CheckElementExists(EdaatOR.Admin_ReceviablesPaidOutsideEddatGridView)) {
		          Log.ReportEvent("PASS", "Verify Paid OutSideEdaat GridView is Successful");
			  }
			  else {
				  Log.ReportEvent("Fail", "Verify Paid OutSideEdaat GridView is Unsuccessful");
				  takeScreenShot();
				  driver.quit();
				  Assert.fail();
			}
		}
		catch(Exception e){
			e.printStackTrace();
			Log.ReportEvent("Fail", "Verify Paid OutSideEdaat GridView is Unsuccessful");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
		
	}
	
	//Function Summary   : Method to  Navigate to "Paid outside Edaat" Page
		//Parameter Summary  : N/A
		public void navigatetoReceivablesPaidOutsideEdaat() throws Exception {
		WebClick(EdaatOR.Admin_Receivables_Menu);
		clickOnPaidOutsideEdaatManu();
		Thread.sleep(2000);
		}
		
		//Function Summary   : Method to  click on "Paid outside Edaat" Menu
		//Parameter Summary  : N/A
		private void clickOnPaidOutsideEdaatManu() {
			WebClickUsingJS(EdaatOR.Admin_Receivables_PaidoutsideMenu);
			waitForPageToLoad();
		}
	   	    //Function Summary   : Method to "Paid outside Edaat" Search
		//Parameter Summary  : BillNumber,DocumentNo
		public void VerifyPaidOutsideEdaatSearch(Map<Object, Object> testdatamap,Log Log) {
			try {
					paidOutsideEdaatSearch(testdatamap, Log);
					Thread.sleep(1000);
					String actualValue=WebGetText("//tr/td[text()='"+testdatamap.get("BillNumber").toString()+"']");
					
					String expectedValue=testdatamap.get("BillNumber").toString();
		        	if (actualValue.equals(expectedValue)) {
						Log.ReportEvent("PASS", "Verify PaidOutSide Edaat Search functionality is Successfull");	        	
					}
		        	else {
		        		 Log.ReportEvent("FAIL", " PaidOutSide Edaat Search functionality is Failed");	        	
						 takeScreenShot();
						 driver.quit();
						 Assert.fail();
		        	}
			}
			
			catch(Exception e){
				 Log.ReportEvent("FAIL", " PaidOutSide Edaat Search functionality is Failed");	        	
				 takeScreenShot();
				 driver.quit();
				 Assert.fail();
			}
	
		}
		public void paidOutsideEdaatSearch(Map<Object, Object> testdatamap,Log Log) {
			try {
					WebEdit(EdaatOR.Admin_PaidoutsideEdaat_BillNo,testdatamap.get("BillNumber").toString());
					Thread.sleep(2000);
					WebEdit(EdaatOR.Admin_PaidOutsideEdaat_DocumentNo, testdatamap.get("DocumentNo").toString());
					Thread.sleep(2000);
					WebClick(EdaatOR.Admin_PaidoutsideEdaat_SubBillerName);
					WebClick("//li[text()='"+testdatamap.get("SubBillerName").toString()+"']");
					Thread.sleep(1500);
					WebClick(EdaatOR.Admin_PaidoutsideEdaat_Searchbtn);
					Thread.sleep(2000);
					List<WebElement> elements = getElements(EdaatOR.Admin_PaidoutsideEdaat_billNoTbl);
					for(WebElement element:elements) {
						boolean Value = element.getText().equals(testdatamap.get("BillNumber").toString());
						if(!Value) {
							Log.ReportEvent("Fail", "Paid outside Edaat Search Verification is Unsuccessful");
							takeScreenShot();
							driver.quit();
							Assert.fail();
						}
					}
					Log.ReportEvent("Pass", "paid outside edaat search verification is successful");
                   
					}
			catch (Exception e) {
				Log.ReportEvent("Fail", "Paid outside Edaat Search Verification is Unsuccessful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			  }
		  }
		  	}
