/**
*
* Test Script Name                      : N/A.
* Objective                             : Balance details functionality.
* Version                               : 1.0
* Author                                : Kathirvelu M
* Created Date                          : 08/05/2023
* Last Updated on                       : N/A
* Updated By                            : Arun Kumar MS.
* Pre-Conditions                        : N/A
* Manual Testcase Name                  : N/A
* Epic Details                          : N/A
* User Story Details                    : N/A
* Defects affecting this test script    : None
* Work Arounds/Known issues             : None
**/
package com.azmqalabs.edaattestautomation.apppages.biller.pages;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
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
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.azmqalabs.edaattestautomation.common.Log;



public class BillerReceivablesBalancePage extends BasePage
{

	public BillerReceivablesBalancePage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  


	@FindBy(xpath = EdaatOR.Biller_Receivables_balance)
	public WebElement Balance;


	public boolean Exists(){
		return super.Exists(Balance); 
	}
	

//Function Summary:to perform search functionality.
//Function Summary:contract number.
	public void BalanceSearch(Map<Object, Object> testdatamap,Log Log) throws InterruptedException, IOException
	{
		SelectDate(testdatamap,Log);
		Search(testdatamap, Log);
	}
	//Function Summary:Method to do Search.
//Function Summary:contract number.
	public void Search(Map<Object, Object> testdatamap,Log Log) throws InterruptedException, IOException
	{
		try {
			WebClear(EdaatOR.Biller_Rcv_balContract);
			WebEdit(EdaatOR.Biller_Rcv_balContract,testdatamap.get("contract number").toString());
			Thread.sleep(2000);		
			 WebClickUsingJS(EdaatOR.Biller_Rcv_balSearch);
			 Thread.sleep(2000);		
			 driver.findElement(By.xpath(EdaatOR.Biller_Rcv_balContract)).sendKeys(Keys.PAGE_DOWN);
			 Thread.sleep(2000);
			 if(getText(EdaatOR.Biller_Rcv_balverifyContract).equals(testdatamap.get("contract number").toString()))
			 {
			 Thread.sleep(2000);
 			Log.ReportEvent("PASS", " Search Functionality In Balance Details Page is Successful");
			 }
			 else {
		 			Log.ReportEvent("FAIL", " Search Functionality In Balance Details Page is Unsuccessful");
		 			 this.takeScreenShot();	
					 driver.quit();
		 			 Assert.fail();

			 }
		    }
	   catch(Exception e){
			Log.ReportEvent("FAIL", " Search Functionality In Balance Details Page is Unsuccessful");
			this.takeScreenShot();
			 driver.quit();
			 Assert.fail();

		} 
	   
	}
	//Function Summary   : Method to navigate on Balance details Page.
	//Parameter Summary :  N/A.
	public void naviagteBalanceDetails(Log Log) throws InterruptedException {
		WebClickUsingJS(EdaatOR.Biller_Receivable_Link);
		WebClickUsingJS(EdaatOR.Biller_BalanceDetailsPage);
		waitForPageToLoad();
		if (CheckElementExists(EdaatOR.Biller_BalanceDetails)) {				
			Thread.sleep(2000);
        	Log.ReportEvent("PASS", "Balance Details Page is Loaded Successfully");

	} else {
    	Log.ReportEvent("FAIL", "Balance Details Page is Not Loaded Successfully");
		this.takeScreenShot();
		driver.quit();
		Assert.fail();


	}		
	}
	
	//Function Summary   : Method to verify Veiw invoice details button is clickable.
	//Parameter Summary :  N/A
	public void verifyViewInvoiceBtn(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			
			WebClick(EdaatOR.Biller_BalanceDetailsViewBtn);
			waitForPageToLoad();
			switchToWindow();
			if(CheckElementExists(EdaatOR.Biller_InvoiceDetails)==true) {
				Log.ReportEvent("PASS", " Veiw Invoice Details Button Clickable is Successful");

			}else {
			
				Log.ReportEvent("FAIL", " Veiw Invoice Details Button Clickable is Unsuccessful");
				this.takeScreenShot();
				driver.quit();
                Assert.fail();

			}
		}				
		catch(Exception e){
			Log.ReportEvent("FAIL", " Veiw Invoice Details Button Clickable is Unsuccessful");
			this.takeScreenShot();
			driver.quit();
            Assert.fail();		}
	}
	//Function Summary:To select date from drop down.
//Function Summary:Fromyear,From month,Toyear,Tomonth,Fromdate and ToDate.
public void SelectDate(Map<Object, Object> testdatamap,Log Log)
{
     try {
		Thread.sleep(5000);
    	WebClick(EdaatOR.Biller_Rcv_balFromd);
        Thread.sleep(2000);
		selectDropdownValue_PartialText(EdaatOR.Biller_Rcv_balFromyear,testdatamap.get("Fromyear").toString());
        Thread.sleep(2000);
        selectDropdownValue_PartialText(EdaatOR.Biller_Rcv_balFromon,testdatamap.get("From month").toString());
        Thread.sleep(2000);
        WebClick("//a[text()='"+testdatamap.get("Fromdate").toString()+"']");
        Thread.sleep(5000);
        WebClick(EdaatOR.Biller_Rcv_balTod);
        Thread.sleep(2000);
        selectDropdownValue_PartialText(EdaatOR.Biller_Rcv_balToyear,testdatamap.get("Toyear").toString());
        Thread.sleep(2000);
        selectDropdownValue_PartialText(EdaatOR.Biller_Rcv_balTomon,testdatamap.get("Tomonth").toString());
        Thread.sleep(2000);
        WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");        
		Log.ReportEvent("PASS", "Enter From and To Date In Balance Details Page is Successful");

		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Enter From and To Date In Balance Details Page is Unsuccessful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}
		
	 //Function Summary : Method to ClickOnReceievablelink
	 //Parameter Summary: N/A
	public void ClickOnReceievablelink() {
		WebClickUsingJS(EdaatOR.Biller_Receivable_Link);
		waitForPageToLoad();	
		}
	//Function Summary : Method to ClickOnBillerBalancelink
	//Parameter Summary: N/A
	public void ClickOnBillerBalancelink() {
		WebClickUsingJS(EdaatOR.Biller_Balance_Link);
		waitForPageToLoad();
		}
	//Function Summary : Method to NavigateReceievableMyBalance
	//Parameter Summary: N/A
	public void NavigateReceievableMyBalance(Log Log) throws InterruptedException {
		
		ClickOnReceievablelink();
		ClickOnBillerBalancelink();
		if (CheckElementExists(EdaatOR.Biller_BalanceDetails)) {				
			Thread.sleep(2000);
	    	Log.ReportEvent("PASS", "Balance Details Page is Loaded Successfully");

	} else {
    	Log.ReportEvent("FAIL", "Balance Details Page is Not Loaded Successfully");
		this.takeScreenShot();
		driver.quit();
		Assert.fail();


	}	

	}
	//Function Summary : Method to UpdateClientInfo
	//Parameter Summary: WalletName
	public void UpdateClientInfo(Map<Object, Object> testdatamap,Log Log){
		try
		{
			Thread.sleep(4000);			
			WebClickUsingActions(EdaatOR.Biller_Update_btn);
			Thread.sleep(2000);
			WebClearandEdit(EdaatOR.Biller_Wallet_efield,testdatamap.get("WalletName").toString());
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Wallet_yesbtn);
			Thread.sleep(2000);
			if(getText(EdaatOR.Biller_updated_Wallet).equals(testdatamap.get("WalletName").toString()))

				{
			Log.ReportEvent("PASS", " Update Client Information is Successful");
				}
			else {
				Log.ReportEvent("FAIL", " Update Client Information is Unsuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();

			}

		}
	catch(Exception e){
		Log.ReportEvent("FAIL", " Update Client Information is Unsuccessful");
		this.takeScreenShot();
		driver.quit();
		Assert.fail();
		}
	}	
	//Function Summary:to perform search functionality.
		//Function Summary:contract number.
			public void BalanceSearchUi(Map<Object, Object> testdatamap,Log Log) throws InterruptedException, IOException
			{
		     	String ValType=testdatamap.get("Type").toString();
		     	try
		     	{
		     	if (ValType.equalsIgnoreCase("Todate"))
		     	{
				Fromdate(testdatamap);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Biller_Rcv_balSearch);
				if(IsDispalyed(EdaatOR.Biller_balanceTodate))
				{
					Log.ReportEvent("PASS", "Select From Date Error Message on Balance Details Page is Successful");
				}
				else {
					Log.ReportEvent("FAIL", "Select From Date Error Message on Balance Details Page is Unsuccessful");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
				}    		
		     	}
		     	else if(ValType.equalsIgnoreCase("Fromdate"))
		     	{
		     	Todate(testdatamap);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Biller_Rcv_balSearch);
				Thread.sleep(2000);
				if(IsDispalyed(EdaatOR.Biller_balanceFromdate))
				{
					Log.ReportEvent("PASS", "Select To Date Error Message on Balance Details Page is Successful");
				}
				else {
					Log.ReportEvent("FAIL", "Select To Date Error Message on Balance Details Page is Unsuccessful");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
				}
	    		
		     	}
		     	else if(ValType.equalsIgnoreCase("Invalid"))
		     	{
		     	Todate(testdatamap);
				Thread.sleep(2000);
				Fromdate(testdatamap);
				Thread.sleep(2000);
				WebEdit(EdaatOR.Biller_Rcv_balContract,testdatamap.get("contract number").toString());
				Thread.sleep(2000);	
				WebClickUsingJS(EdaatOR.Biller_Rcv_balSearch);
				Thread.sleep(2000);
				if(IsDispalyed(EdaatOR.Biller_conctact))
				{
					Log.ReportEvent("PASS", "No Data Available Error Message on Balance Details Page is Successful");
				}
				else {
					Log.ReportEvent("FAIL", "No Data Available Error Message on Balance Details Page is Unsuccessful");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
				}
	    		
		     	}
	     		Log.ReportEvent("PASS", "Validate Error Message on Balance Details Page is Successful");
		     	}
		     	catch(Exception e)
		     	{
		     		Log.ReportEvent("FAIL", "Validate Error Message on Balance Details Page is Unsuccessful");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
		     		
		     	}
			
			}
		public void Fromdate(Map<Object, Object> testdatamap) throws Exception
		{
			WebClick(EdaatOR.Biller_Rcv_balFromd);
	        Thread.sleep(2000);
			selectDropdownValue_PartialText(EdaatOR.Biller_Rcv_balFromyear,testdatamap.get("Fromyear").toString());
	        Thread.sleep(2000);
	        selectDropdownValue_PartialText(EdaatOR.Biller_Rcv_balFromon,testdatamap.get("From month").toString());
	        Thread.sleep(2000);
	        WebClick("//a[text()='"+testdatamap.get("Fromdate").toString()+"']");
	        Thread.sleep(2000);
			
		}
		public void Todate(Map<Object, Object> testdatamap) throws Exception
		{
			  WebClick(EdaatOR.Biller_Rcv_balTod);
		      Thread.sleep(2000);
		      selectDropdownValue_PartialText(EdaatOR.Biller_Rcv_balToyear,testdatamap.get("Toyear").toString());
		      Thread.sleep(2000);
		      selectDropdownValue_PartialText(EdaatOR.Biller_Rcv_balTomon,testdatamap.get("Tomonth").toString());
		      Thread.sleep(2000);
		      WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");
			
		}
		
		//Function Summary:Method to searchBasedOnContractNumber
		//Parameter Summary:contract number
	      public void searchBasedOnContractNumber(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {
	    	  try {
	    		    WebClear(EdaatOR.Biller_Rcv_balContract);
	    		    if(CheckElementExists(EdaatOR.Biller_Rcv_balContract))
	    		    {
	    		    	WebEdit(EdaatOR.Biller_Rcv_balContract,testdatamap.get("contract number").toString());
						Thread.sleep(2000);		
						WebClickUsingJS(EdaatOR.Biller_Rcv_balSearch);
						Thread.sleep(2000);
						WebElement element=driver.findElement(By.xpath(EdaatOR.Biller_Rcv_balContract));
					    scrollToElement(driver, element);
					    if(CheckElementExists(EdaatOR.Biller_conctact))
					    {
					    	Log.ReportEvent("FAIL", "Search Balance Details Based On Contract Number is Unsuccessful");
							takeScreenShot();
							driver.quit();
							Assert.fail();
					    }
					    else {
						Log.ReportEvent("PASS", "Search Balance Details Based On Contract Number is Successful");
					    }
	    		    }else {
						Log.ReportEvent("FAIL", "Search Balance Details Based On Contract Number is Unsuccessful");
						takeScreenShot();
						driver.quit();
						Assert.fail();
	    		    }
				
			} catch (Exception e) {
			Log.ReportEvent("FAIL", "Search Balance Details Based On Contract Number is Unsuccessful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
			}
	      }
	      //Function Summary: validate Paid InvoiceAmount And OperationalFees Of Daily Reconciliation Report sadad.
		//Function Summary:
			public void validatePaidInvoiceAmountAndOperationalFeesOfDailyReconciliationReportsadad(Map<Object, Object> testdatamap,Log Log,String TotalInvoiceAmount,String OperationalFees) throws InterruptedException, IOException
			{
				try {
					SelectDate(testdatamap,Log);				
					Thread.sleep(900);		
					WebClickUsingJS(EdaatOR.Biller_Rcv_balSearch);
					Thread.sleep(900);
					WebElement element=driver.findElement(By.xpath(EdaatOR.Biller_Rcv_balContract));
					scrollToElement(driver, element);
					Thread.sleep(900);					
					VerifyValue1(getText(EdaatOR.Biller_Rcv_BalanceTotalAmountPaid),TotalInvoiceAmount);
					Thread.sleep(1000);
					VerifyValue1(getText(EdaatOR.Biller_Rcv_BalanceTotalOperationFees),OperationalFees);
					Thread.sleep(2000);
					test.log(Status.PASS,"verify paid invoice amount and operational fees in balance details" + driver.getTitle() +" * Receviables balance details Pass * ");
					Log.ReportEvent("PASS", " verify paid invoice amount and operational fees in balance details is Successfull");
					this.takeScreenShot();	
				    }
			   catch(Exception e){
					test.log(Status.FAIL,"verify paid invoice amount and operational fees in balance details" + driver.getTitle() +" * Receviables balance details FAIL * " );
					this.takeScreenShot();
				} 
			   
			}
		//Function Summary:Method to calculateTheOperationalFees
		//Parameter Summary:InvoiceAmount,AZMFeesFixed,AZMFeesPercentage,MadaFeesFixed,MadaFeesPercentage
		public String calculateTheOperationalFees(Map<Object, Object> testdatamap) throws InterruptedException {
				double percent=100.00;
				String invoiceAmount = testdatamap.get("InvoiceAmount").toString();
				String azmFeesFixed = testdatamap.get("AZMFeesFixed").toString();
				String azmFeesPercentage = testdatamap.get("AZMFeesPercentage").toString();
				String paymentMethodFeesFixed = testdatamap.get("PaymentMethodFeesFixed").toString();
				String paymentMethodFeesPercentage = testdatamap.get("PaymentMethodFeesPercentage").toString();			
				double azmFeesPercentageAmount=Double.parseDouble(invoiceAmount)*Double.parseDouble(azmFeesPercentage)/percent;
				double paymentMethodFeesPercentageAmount=Double.parseDouble(invoiceAmount)*Double.parseDouble(paymentMethodFeesPercentage)/percent;
				double operationFees = Double.parseDouble(azmFeesFixed)+Double.parseDouble(paymentMethodFeesFixed)+azmFeesPercentageAmount+paymentMethodFeesPercentageAmount;
			    String expectedOperationalFees = String.format("%.2f", operationFees);	
			    return expectedOperationalFees;			
		}
	
		//Function Summary:Method to calculateTheOperationalFees
		//Parameter Summary:InvoiceAmount
		public void verifyTheAmountPaidAndOperationalFees(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {	
			try {
				Thread.sleep(500);
				if(getText(EdaatOR.Biller_Rcv_balverifyAmountPaid).equals(testdatamap.get("InvoiceAmount").toString())) {
					VerifyValue1(getText(EdaatOR.Biller_Rcv_balverifyOperationalFees),calculateTheOperationalFees(testdatamap));
					Log.ReportEvent("PASS", "Validate Fees Deduction Correctly in Balance Details Page is Successful");

				}
				else {
					Log.ReportEvent("FAIL", "Validate Fees Deduction Correctly in Balance Details Page is Unsuccessful");
					this.takeScreenShot();
					driver.quit();
                    Assert.fail();
					
				}

			} catch (Exception e) {
				Log.ReportEvent("FAIL", "Validate Fees Deduction Correctly in Balance Details Page is Unsuccessful");
				this.takeScreenShot();
				driver.quit();
                Assert.fail();
			}			
		}
		
		//Function Summary :Method to verifyThePaymentMethodInThePaymentMethodColumn
		//Parameter Summary:ExpectedPaymentMethod
		public void verifyThePaymentMethodInThePaymentMethodColumn(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {	
			try {
				if(getText(EdaatOR.Biller_Rcv_balverifyPaymentMethod).equals(testdatamap.get("ExpectedPaymentMethod").toString()))
				{
					Log.ReportEvent("PASS", "Validate Payment Method in Balance Details Page is Successful");

				}
				else {
					Log.ReportEvent("FAIL", "Validate Payment Method in Balance Details Page is Unsuccessful");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();

				}			

			} catch (Exception e) {
				Log.ReportEvent("FAIL", "Validate Payment Method in Balance Details Page is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();			
				}			
		}

}
