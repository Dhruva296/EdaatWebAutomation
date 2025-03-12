/**
*
* Test Script Name                   : N/A
* Objective                          : Incoming bills functionality.
* Version                            : 1.0
* Author                             : Kathirvelu M
* Created Date                       : 14/09/2023
* Last Updated on                    : N/A
* Updated By                         : Radhika K R
* Pre-Conditions                     : N/A
* Epic Details                       : N/A
* User Story Details                 : N/A
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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;



public class AdminPayablesIncomingBillsPage extends BasePage
{

	public AdminPayablesIncomingBillsPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  


	@FindBy(xpath = EdaatOR.Admin_IncomingBillsPage)
	public WebElement Client;


	public boolean Exists(){
		return super.Exists(Client); 
	}
	//Function Summary   : Method to  Navigate to Incoming bills page
	//Parameter Summary  : N/A
	public void NavigatetoIncomingBillsPage(Log log) throws InterruptedException {
	   try {
		WebClickUsingJS(EdaatOR.Admin_PayablesMenu);
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Admin_IncomingBillsLink);
		Thread.sleep(1000);
		if(CheckElementExists(EdaatOR.Admin_IncomingBillsPage)) {
		log.ReportEvent("Pass", "Navigate to Incoming Bills Page is Successful");
		 }
		else {
			log.ReportEvent("Fail", "Navigate to Incoming Bills Page is Unsuccessful");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		 }
	   }
	   catch (Exception e) {
		   log.ReportEvent("Fail", "Navigate to Incoming Bills Page is Unsuccessful");
			takeScreenShot();
			driver.quit();
			Assert.fail();
	  }
	}
//Function Summary   : Method to Verify grid view 
//Parameter Summary  : N/A
	public void  VerifyIncomingbillsGridView(Log Log)
	{
		try{
			NavigatetoIncomingBillsPage(Log);
			Thread.sleep(1000);
           if(CheckElementExists(EdaatOR.Admin_DistRecordofpostinggridview)) {
        	   Log.ReportEvent("Pass", "Verify Grid View is Successful");
           }
           else {
        	   Log.ReportEvent("Fail", "Verify Grid View is Unsuccessful");
        	   takeScreenShot();
        	   driver.quit();
        	   Assert.fail();

		      }
	
		  }
			catch(Exception e){
				Log.ReportEvent("Fail", "Verify Grid View is Unsuccessful");
	        	   takeScreenShot();
	        	   driver.quit();
	        	   Assert.fail();
			}
	}
//Function Summary   : Method to Verify Incoming Bills Search
//Parameter Summary  : BillNumber,ContractNumber
	public void IncomingBillsSearch(Map<Object, Object> testdatamap,Log Log)

	{

		try {	

	        WebEdit(EdaatOR.Admin_Payables_IncomingBillNumber,testdatamap.get("BillNumber").toString());

	        WebEdit(EdaatOR.Admin_Payables_IncomingBillerName,testdatamap.get("BillerName").toString());

	        WebEdit(EdaatOR.Admin_Payables_IncomingContractNumber,testdatamap.get("ContractNumber").toString());

	        WebClick(EdaatOR.Admin_Payables_IncomingBillsearch);
            Thread.sleep(1500);
	        List<WebElement> elements = getElements(EdaatOR.Admin_Payables_IncomingBillsVerify);
			for(WebElement element:elements) {
				boolean Value = element.getText().equals(testdatamap.get("BillNumber").toString());
				if(!Value) {
					Log.ReportEvent("Fail", "Search Functionality Validation is Unsuccessful");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
	        	Log.ReportEvent("PASS", "Search Functionality Validation is Successful");
	        }
		}

		catch(Exception e){
            e.printStackTrace();
			Log.ReportEvent("Fail", "Search Functionality Validation is Unsuccessful");
			takeScreenShot();
            driver.quit();
            Assert.fail();
		}

	}
}
