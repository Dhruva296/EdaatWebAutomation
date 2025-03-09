/**
*
* Test Script Name                      : N/A.
* Objective                             : Balance details functionality.
* Version                               : 1.0
* Author                                : Kathirvelu Mohan
* Created Date                          : 08/05/2023
* Last Updated on                       : N/A
* Updated By                            : Dhruva Kumar S
* Pre-Conditions                        : N/A
* Epic Details                          : N/A
* User Story Details                    : N/A
**/

package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.interactions.touch.Scroll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.Config;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;



public class AdminReceivablesBalancePage extends BasePage
{

	public AdminReceivablesBalancePage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  


	@FindBy(xpath = EdaatOR.Admin_Receievable_Balance)
	public WebElement Balance;


	public boolean Exists(){
		return super.Exists(Balance); 
	}
	//Function Summary   : Method to navigate on Balance details Page.
	//Parameter Summary :  N/A.
		public void naviagteBalanceDetails(Log Log) {
			try {
			WebClickUsingJS(EdaatOR.Admin_Receievable_link);
			WebClickUsingJS(EdaatOR.Admin_BalanceDetailsPage);
			if(CheckElementExists(EdaatOR.Admin_BalanceDetailsHeaderEdit)) {
        	Log.ReportEvent("PASS", "Navigate to Balance Details Page is Successful");
			Thread.sleep(3000);
			}
			else {
	        	Log.ReportEvent("Fail", "Navigate to Balance Details Page is Unsuccessful");
                takeScreenShot();
                driver.quit();
                Assert.fail();
			   }
			}
			catch(Exception e){
				Log.ReportEvent("Fail", "Navigate to Balance Details Page is Unsuccessful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
			
		}
    //Function Summary:Method to do EnterSearch
	//Function Summary:contract number,SubBillerName
	public void EnterSearch(Map<Object, Object> testdatamap,Log log) throws InterruptedException, IOException
	{
		try {
			WebEdit(EdaatOR.Admin_Rcv_balContract,testdatamap.get("contract number").toString());
			Thread.sleep(2000);
			WebClick(EdaatOR.Admin_Rcv_subbiler);
			Thread.sleep(2000);
			WebClickUsingActions("//li[text()='"+testdatamap.get("SubBillerName").toString()+"']");
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Rcv_balSearch);
			waitForElement(EdaatOR.PageLoader);
			Thread.sleep(2000);
			List<WebElement> elements = getElements(EdaatOR.Admin_Paid_Outside_contractNo);
			for(WebElement element:elements) {
				boolean Value = element.getText().equals(testdatamap.get("contract number").toString());
				if(!Value) {
					log.ReportEvent("Fail", "Balance Details Search is Unsuccessful");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
		    }
			log.ReportEvent("PASS", "Balance Details Search is Successful");
		}
	   catch(Exception e){
			e.printStackTrace();
			log.ReportEvent("Fail", "Balance Details Search is Unsuccessful");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		} 
	   
	}
	
    //Function Summary:To select date from drop down.
	//Function Summary:Fromyear,From month,Toyear,Tomonth,Fromdate and ToDate.
		public void SelectDate(Map<Object, Object> testdatamap,Log log) throws Exception{	 
	    	WebClick(EdaatOR.Admin_Rcv_balFromd);
			selectDropdownValue_PartialText(EdaatOR.Admin_Rcv_balFromyear,testdatamap.get("Fromyear").toString());
	        selectDropdownValue_PartialText(EdaatOR.Admin_Rcv_balFromon,testdatamap.get("From month").toString());
	        WebClick("//a[contains(@title, '" + testdatamap.get("Fromdate").toString() + "')]"); 
	        Thread.sleep(1000);
	        WebClick(EdaatOR.Admin_Rcv_balTod);
	        selectDropdownValue_PartialText(EdaatOR.Admin_Rcv_balToyear,testdatamap.get("Toyear").toString());
	        selectDropdownValue_PartialText(EdaatOR.Admin_Rcv_balTomon,testdatamap.get("Tomonth").toString());
	        WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");
	       }

	//Function Summary   : Method to verifyViewInvoiceBtn
	//Parameter Summary :  N/A
	public void verifyViewInvoiceBtn(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			EnterSearch(testdatamap,Log);
			WebClick(EdaatOR.Admin_BalanceDetailsViewBtn);
			waitForPageToLoad();
			switchToWindow();
			if(CheckElementExists(EdaatOR.Admin_InvoiceDetails)) {
	        	Log.ReportEvent("PASS", "View Invoice Details button is clickable Verification is Successful");
			}
			else {
			    Log.ReportEvent("Fail", "View Invoice Details button is clickable Verification is Unsuccessful");
			    takeScreenShot();
			    driver.quit();
			    Assert.fail();
		      }
		   }   
		catch(Exception e){
			Log.ReportEvent("Fail", "View Invoice Details button is clickable Verification is Unsuccessful");
		    takeScreenShot();
		    driver.quit();
		    Assert.fail();		
		    }
	    }
	    
		//Function Summary : Method to UpdateClientInfo		
		//Parameter Summary: WalletName
		public void UpdateClientInfo(Map<Object, Object> testdatamap,Log Log){
			try
			{
				WebClick(EdaatOR.Admin_Update_btn);
				Thread.sleep(2000);
				WebClearandEdit(EdaatOR.Admin_Wallet_efield,testdatamap.get("WalletName").toString());
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Admin_Wallet_yesbtn);
				Thread.sleep(3000);
				String actualValue=getText(EdaatOR.Admin_updated_Wallet);
				String expectedValue=testdatamap.get("WalletName").toString();
				if(actualValue.equals(expectedValue)) {
	        	  Log.ReportEvent("PASS", "Update Client Information is successful");
	        	}
				else{
		        	  Log.ReportEvent("Fail", "Update Client Information is Usuccessful");
                      takeScreenShot();
                      driver.quit();
                      Assert.fail();
				}
			}
		catch(Exception e){
				 e.printStackTrace();
				 Log.ReportEvent("Fail", "Update Client Information is Usuccessful");
	             takeScreenShot();
	             driver.quit();
	             Assert.fail();			
             }
		}
  public void BalanceSearch(Map<Object, Object> testdatamap,Log Log) throws InterruptedException, IOException
  {
	  try {
	  naviagteBalanceDetails(Log);
	  Thread.sleep(2000);
	  SelectDate(testdatamap,Log);
	  EnterSearch(testdatamap,Log);
	  }
	  catch(Exception e){
		  e.printStackTrace();
		  Log.ReportEvent("Fail", "Search functionality validation is Unsuccessful");
		  takeScreenShot();
		  driver.quit();
		  Assert.fail();
		  }	
  }
   
}
