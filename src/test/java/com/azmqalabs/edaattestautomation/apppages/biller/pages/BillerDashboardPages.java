/**
* Test Script Name  				 : N/A
* Objective                          : Verify the Dashboard Functionality.
* Version      						 : 1.0
* Author       						 : Arun Kumar MS
* Created Date 			      		 : 11/08/2023
* Last Updated on					 : N/A
* Updated By   			 			 : 
* Pre-Conditions					 : N/A
* Manual Test case Name				 : N/A
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

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.azmqalabs.edaattestautomation.common.Log;



public class BillerDashboardPages extends BasePage
{

	public BillerDashboardPages(WebDriver driver,ExtentTest test)
	{
		 this.driver=driver;
		 this.test=test;
		 
		 PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  
	

	@FindBy(xpath = EdaatOR.Biller_Dashboard)
	public WebElement Dashboard;
		
	    
	    public boolean Exists(){
	    	return super.Exists(Dashboard); 
		}
	    
		public void NavigateDashboardPage(Log Log) throws Exception{
	        WebClick(EdaatOR.Biller_Dashboardmenu);

			if (CheckElementExists(EdaatOR.Biller_Dashboard)) {				
				Thread.sleep(2000);
			 	Log.ReportEvent("PASS", " Dashboard Page is Loaded Successfully");

		} else {
	    	Log.ReportEvent("FAIL", "Dashboard Page is Not Loaded Successfully");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();


		}
		 	

		}
	  //Function Summary : Method to Search TrackedBillerName. 
	//Parameter Summary: TrackedBillerName,FromYear,FromMonth,ToYear,ToMonth.
	    public void TrackerBillerSearch(Map<Object, Object> testdatamap,Log Log)
	    {
	    	try {
		        Thread.sleep(1000);
		        WebClick(EdaatOR.Biller_TrackerName);
		        Thread.sleep(2000);
		        WebClickUsingActions("//li[text()='"+testdatamap.get("TrackedBillerName").toString()+"']");
		        Thread.sleep(1000);
		        if(CheckElementExists("//li[text()='"+testdatamap.get("TrackedBillerName").toString()+"']"))
		        {
					Log.ReportEvent("PASS", "Enter Tracker Biller Name is Successful");

		        }
		        else {
					Log.ReportEvent("FAIL", "Enter Tracker Biller Name is Unsuccessful");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
		        }
		        
		        WebClick(EdaatOR.Biller_Dashboard_FromDate);
		        Thread.sleep(1000);
		    	selectDropdownValue_PartialText(EdaatOR.Biller_Dashboard_Fromyear,testdatamap.get("FromYear").toString());
		    	Thread.sleep(1000);
		    	selectDropdownValue_PartialText(EdaatOR.Biller_Dashboard_FromMonth,testdatamap.get("FromMonth").toString());
		    	Thread.sleep(1000);
	        	WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
	        	Thread.sleep(1000);
	        	WebClick(EdaatOR.Biller_Dashboard_TODate);
	        	Thread.sleep(1000);
	        	selectDropdownValue_PartialText(EdaatOR.Biller_Dashboard_Toyear,testdatamap.get("ToYear").toString());
	        	Thread.sleep(1000);
	        	selectDropdownValue_PartialText(EdaatOR.Biller_Dashboard_ToMonth,testdatamap.get("ToMonth").toString());
	        	Thread.sleep(1000);
	        	WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");
	        	Thread.sleep(5000);
	        	WebClick(EdaatOR.Biller_DashboardSearchBtn);
	        	Thread.sleep(10000);
	        	if(getText(EdaatOR.Biller_AttachetedImage_Link1).equals(testdatamap.get("Value").toString()))
	        	{
	        	ValidateTwoValue(getText(EdaatOR.Biller_AttachetedImage_Link1), testdatamap.get("Value").toString());
	        	verifyElementIsPresent(EdaatOR.Biller_Dashboard_InvoiceCount);
				Log.ReportEvent("PASS", "Tracker Biller Search is Successful");
	        	}
	        	else {
					Log.ReportEvent("FAIL", "Tracker Biller Search is Unsuccessful");
		        	this.takeScreenShot();
					driver.quit();
		        	Assert.fail();

	        	}

			}
			catch(Exception e){
				Log.ReportEvent("FAIL", "Tracker Biller Search is Successful");
	        	this.takeScreenShot();
				driver.quit();
	        	Assert.fail();			}

	    	
	    	
	    }
 //Function Summary : Method to Click on Dashboards. 
		//Parameter Summary: N/A
		public void BillerDashboardclick(Map<Object, Object> testdatamap,Log Log) {

	    	try {
		        Thread.sleep(1000);
		        WebClick(EdaatOR.Biller_Total_no_bills);
		        if(CheckElementExists(EdaatOR.Biller_BillsList_page))
		        {
		        	Log.ReportEvent("PASS", "Click On Total Number Of Bills Menu is Successful");

		        }
		        else {
		        	Log.ReportEvent("FAIL", "Click On Total Number Of Bills Menu is Unsuccessful");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();

		        }
		        Thread.sleep(2000);
	        	driver.navigate().back();
		        WebClick(EdaatOR.Biller_MyBalance);
	        	 if(CheckElementExists(EdaatOR.Biller_Warningmsg_BalanceDetails))
			        {
			        	Log.ReportEvent("PASS", "Click On My Balance Menu is Successful");

			        }
			        else {
			        	Log.ReportEvent("FAIL", "Click On My Balance Menu is Unsuccessful");
						this.takeScreenShot();
						driver.quit();
						Assert.fail();

			        }
	        	Thread.sleep(2000);
	        	driver.navigate().back();
		        WebClick(EdaatOR.Biller_Totalamt_Transfer);
		        if(CheckElementExists(EdaatOR.Biller_TotalamtPaid_text))
		        {
		        	Log.ReportEvent("PASS", "Click On Total Amount Transferred Menu is Successful");

		        }
		        else {
		        	Log.ReportEvent("FAIL", "Click On Total Amount Transferred Menu is Unsuccessful");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();

		        }
	        	Thread.sleep(2000);
	        	driver.navigate().back();
		        WebClick(EdaatOR.Biller_InvoicesVolumeStatus);
		        if(CheckElementExists(EdaatOR.Biller_BillsList_page))
		        {
		        	Log.ReportEvent("PASS", "Click On Invoice Volume Status Menu is Successful");

		        }
		        else {
		        	Log.ReportEvent("FAIL", "Click On Invoice Volume Status Menu is Unsuccessful");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();

		        }
	        	Thread.sleep(2000);
	        	driver.navigate().back();
		        WebClick(EdaatOR.Biller_InvoicesValueStatus);
		        if(CheckElementExists(EdaatOR.Biller_BillsList_page))
		        {
		        	Log.ReportEvent("PASS", "Click On Invoice Value Status Menu is Successful");

		        }
		        else {
		        	Log.ReportEvent("FAIL", "Click On Invoice Value Status Menu is Unsuccessful");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();

		        }
	        	Thread.sleep(2000);
	        	driver.navigate().back();
	        	if(CheckElementExists(EdaatOR.Biller_Total_no_bills))
	        	{
		        	Log.ReportEvent("PASS", "User Able Click On Dashboard Submenus is Successful");

	        	}
	        	else {
		        	Log.ReportEvent("FAIL", "User Able Click On Dashboard Submenus is Unsuccessful");
		        	this.takeScreenShot();
					driver.quit();
					Assert.fail();

	        	}

			}
			catch(Exception e){
				Log.ReportEvent("FAIL", "User Able Click On Dashboard Submenus is Unsuccessful");
	        	this.takeScreenShot();
				driver.quit();
				Assert.fail();
				
			}

	    	
	    	
	    	
		}

}