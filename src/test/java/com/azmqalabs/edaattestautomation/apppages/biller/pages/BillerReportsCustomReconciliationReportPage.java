package com.azmqalabs.edaattestautomation.apppages.biller.pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;


import com.azmqalabs.edaattestautomation.common.Log;


public class BillerReportsCustomReconciliationReportPage extends BasePage
{

	public BillerReportsCustomReconciliationReportPage(WebDriver driver,ExtentTest test)
	{
		 this.driver=driver;
		 this.test=test;
		 
		 PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  
	

	@FindBy(xpath = EdaatOR.Biller_CustomReconciliationReport)
	public WebElement CustomReconciliationReportPage;
		
	    
	    public boolean Exists(){
	    	return super.Exists(CustomReconciliationReportPage); 
		}
	    
	  		public void verifySearchButton(Map<Object, Object> testdatamap, Log log) {
				try {
					
					WebClick(EdaatOR.Biller_CustomReconciliationReport_FromDateField);
					selectDropdownValue_PartialText(EdaatOR.Biller_CustomReconciliationReport_FromYearField,
							testdatamap.get("FromYear").toString());
					selectDropdownValue_PartialText(EdaatOR.Biller_CustomReconciliationReport_FromMonthField,
							testdatamap.get("FromMonth").toString());
					WebClickUsingJS("//a[text()='" + testdatamap.get("FromDate") + "']");
					
					WebClick(EdaatOR.Biller_CustomReconciliationReport_ToDateField);
					selectDropdownValue_PartialText(EdaatOR.Biller_CustomReconciliationReport_ToYearField,
							testdatamap.get("ToYear").toString());
					selectDropdownValue_PartialText(EdaatOR.Biller_CustomReconciliationReport_ToMonthField,
							testdatamap.get("ToMonth").toString());
					WebClickUsingJS("//a[text()='" + testdatamap.get("ToDate") + "']");
					WebClick(EdaatOR.Biller_CustomReconciliationReport_SearchButon);
					
					test.log(Status.PASS, "Verify that the search button is clickable");
					log.ReportEvent("PASS", "Verify that the search button is clickable pass");
					 this.takeScreenShot();
				} catch (Exception e) {
					test.log(Status.FAIL, "Verify that the search button is clickable fail");
				}
	  		}
	    
		public void verifyDefaultFieldsAreChecked(Log Log) throws Exception {
			try {
				WebElement invoiceAmount = driver
						.findElement(By.xpath(EdaatOR.Biller_CustomReconciliationReport_InvoiceAmountField));
				WebElement billNumber = driver
						.findElement(By.xpath(EdaatOR.Biller_CustomReconciliationReport_BillNumberField));
				WebElement paidAmount = driver
						.findElement(By.xpath(EdaatOR.Biller_CustomReconciliationReport_PaidAmountField));
				WebElement contractNumber = driver
						.findElement(By.xpath(EdaatOR.Biller_CustomReconciliationReport_ContractNumberField));
				if (invoiceAmount.isSelected() && billNumber.isSelected() && paidAmount.isSelected()
						&& contractNumber.isSelected() ) {
					
					Log.ReportEvent("PASS", "Default Fields are Successfully Checked.");
					
				}
				 else {
					    
						Log.ReportEvent("FAIL", "Default Fields are not Checked Successfully.");
						 this.takeScreenShot();
						 driver.quit();
						 Assert.fail();
			            
			        }
			} 
			catch (Exception e) {
				Log.ReportEvent("FAIL", "Default Fields are not Checked Successfully.");
				 this.takeScreenShot();
				 driver.quit();
				 Assert.fail();
			}
		}
//Function Summary   : Method to Verify SubBiller Check Boxes in Custom Reconciliation Report
	    //Parameter Summary  : N/A
		
		public void VerifySubBillerCheckBoxesInCustomReconciliationReport(Log Log)
		{
			try {
				scrollDowntillend(driver);
				Thread.sleep(2000);

				if(ExistsCheck(EdaatOR.Biller_CustomReconciliationReport_SubBillerName_CheckBx)==false 
					&& ExistsCheck(EdaatOR.Biller_CustomReconciliationReport_TransferFees_SubBiller_CheckBx)==false
					&&ExistsCheck(EdaatOR.Biller_CustomReconciliationReport_SubBillerShare_CheckBx)==false) {
			    	Log.ReportEvent("PASS", "Sub Biller Checkboxes Verification in Custom Reconciliation Report is Successful.");

				}
				else {
			    	Log.ReportEvent("FAIL", "Sub Biller Checkboxes Verification in Custom Reconciliation Report is Unsuccessful.");
                    takeScreenShot();
                    driver.quit();
                    Assert.fail();
				}
			  }
	       catch (Exception e) {
	    	   Log.ReportEvent("FAIL", "Sub Biller Checkboxes Verification in Custom Reconciliation Report is Unsuccessful.");
               takeScreenShot();
               driver.quit();
               Assert.fail();
		}
	}
	//Function Summary  : Method to click on 'Select All' checkbox
		//Parameter Summary : N/A	
		public void clickOnSelectAllCheckbox() throws Exception
		{
			WebClick(EdaatOR.Admin_RecievableReports_selectAll_checkbox);
	    	Thread.sleep(2000);
			
		}

		//Function Summary   : Method to select from date and To date
		//Parameter Summary  : FromYear, FromMonth,ToYear,ToMonth.
		public void SelectDate(Map<Object,Object> testdatamap) throws InterruptedException
		{
			try {
                Thread.sleep(2000);
				WebClick(EdaatOR.Admin_ReportsFromCalender);			
				selectDropdownValue_PartialText(EdaatOR.Admin_ReportsFromYear, testdatamap.get("FromYear").toString());
				selectDropdownValue_PartialText(EdaatOR.Admin_ReportsFromMonth, testdatamap.get("FromMonth").toString());
				WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
				Thread.sleep(800);
				WebClick(EdaatOR.Admin_ReportsToCalender);
				selectDropdownValue_PartialText(EdaatOR.Admin_ReportsFromYear, testdatamap.get("ToYear").toString());
				selectDropdownValue_PartialText(EdaatOR.Admin_ReportsFromMonth, testdatamap.get("ToMonth").toString());
				WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");
 
			}		catch(Exception e){
				test.log(Status.FAIL,"Select Date FAIL" + driver.getTitle() +" *Select Date FAIL * " );
				
			}
		}
				
				
		//Function Summary   : Method to select payment method
		//Parameter Summary  : paymentMethod.
		public void SelectPaymentMethod(Map<Object,Object> testdatamap) throws InterruptedException
		{
			try {
                    Thread.sleep(1000);
                    WebClick(EdaatOR.Admin_customReconcillation_PaymentMethod);
                    Thread.sleep(1000);
                    WebClick("//li[text()='"+testdatamap.get("PaymentMethod").toString()+"']");
			    	Thread.sleep(1000);
 
 
			  }		catch(Exception e){
				test.log(Status.FAIL,"Select payment method FAIL" + driver.getTitle() +" *Select Payment Method FAIL * " );
				
			}
		}
	//Function Summary  : Method to click on Export to Excel link
				//Parameter Summary : N/A	
				public void clickOnExportToExcelLink() throws Exception
				{
					WebClick(EdaatOR.Admin_customReconcillation_ExportToExcelLink);
			    	Thread.sleep(1000);
					
				}
				
		//Function Summary  : Method to click on search button
		//Parameter Summary : N/A	
		public void clickOnSearchButton() throws Exception
		{
			WebClick(EdaatOR.Admin_Button);
	    	Thread.sleep(2000);
			
		}
			//Function Summary   : Method to validate Export To Excel Functionality			
				public void validateExportToExcelFunctionality(Map<Object,Object> testdatamap,Log Log) throws InterruptedException
				{
					try {
						
						SelectDate(testdatamap);
						SelectPaymentMethod(testdatamap);
						Thread.sleep(1000);
						clickOnSearchButton();
						Thread.sleep(2000);
						WebElement element=driver.findElement(By.xpath(EdaatOR.Admin_customReconcillation_ExportToExcelLink));
						scrollToElement(driver, element);
						Thread.sleep(1000);
						clickOnExportToExcelLink();
						Thread.sleep(2000);
						if(ExistsCheck(EdaatOR.Admin_customReconcillation_ExportedToExcelConMessage))
						{
							Log.ReportEvent("PASS", "Export to Excel Verification is Successful");
						}
						else {
							Log.ReportEvent("FAIL", "Export to Excel Verification is Unsuccessful");
							takeScreenShot();
							driver.quit();
							Assert.fail();
							
						}

					  }catch(Exception e){
						  
							Log.ReportEvent("FAIL", "Export to Excel Verification is Unsuccessful");
							takeScreenShot();
							driver.quit();
							Assert.fail();
					}
				}

		//Function Summary   : Method to Verify The Report To Retrieved Data Without Select PaymentMethod
		//Parameter Summary  : N/A
		public void VerifyTheReportToRetrievedDataWithoutSelectPaymentMethod(Map<Object,Object> testdatamap,Log Log)
		{
			try {
				 searchCustomReconciliationReport(testdatamap,Log);
				 Thread.sleep(3000);
	             if(IsDispalyed(EdaatOR.Biller_customReconciliation_No_data_text)==true) {
	             VerifyValue1(getText(EdaatOR.Biller_CustomReconciliationReport_BillNo),testdatamap.get("BillNumber").toString());
	             Thread.sleep(2000);
	             VerifyValue1(getText(EdaatOR.Biller_CustomReconciliationReport_CRNo),testdatamap.get("CRNumber").toString());
	             Thread.sleep(2000);
				 VerifyValue1(getText(EdaatOR.Biller_CustomReconciliationReport_InvoicrAmt),testdatamap.get("InvoiceAmount").toString());
	             Thread.sleep(2000);
				 VerifyValue1(getText(EdaatOR.Biller_CustomReconciliationReport_PaidAmt),testdatamap.get("PaidAmount").toString());
			     Log.ReportEvent("PASS", " Retrieve data Without Selecting Payment Method is Successfull");
	             }
	             else {
				     Log.ReportEvent("FAIL", "Retrieve data Without Selecting Payment Method is Unsuccessfull");
				     this.takeScreenShot();
				     driver.quit();
				     Assert.fail();
	             }
			}
			catch(Exception e){
				Log.ReportEvent("FAIL", "Retrieve data Without Selecting Payment Method is Unsuccessfull");
			     this.takeScreenShot();
			     driver.quit();
			     Assert.fail();
		     }
	}

		
		 //Function Summary   : Method to verifyAvailablePaymentMethodAssignedToBillerAccount
	   	 //Parameter Summary  : PaymentMethod1,PaymentMethod2,PaymentMethod3,PaymentMethod4
		public void verifyAvailablePaymentMethodAssignedToBillerAccount(Map<Object, Object> testdatamap,Log Log) {
			try {
				boolean isPaymentMethodFound = false;
				 WebClick(EdaatOR.Admin_customReconcillation_PaymentMethod);
				 
				 List<WebElement> paymentMethodValues = getElements(EdaatOR.Admin_customReconcillation_PaymentMethodValues);
				 String [] expectedPaymentText= {testdatamap.get("PaymentMethod1").toString(),
				 testdatamap.get("PaymentMethod2").toString(),testdatamap.get("PaymentMethod3").toString()
				 ,testdatamap.get("PaymentMethod4").toString()};
				for(int i=0;i<paymentMethodValues.size();i++) {
					String actualPaymentText = paymentMethodValues.get(i).getText();
					if (actualPaymentText.equals(expectedPaymentText[i])) {
						if (!isPaymentMethodFound) {
				            Log.ReportEvent("PASS", "Payment Method Appeared as Assigned in the Biller Account");
				            isPaymentMethodFound = true; 
				        }						
					}
					else
					{
						Log.ReportEvent("FAIL", "Payment Method not Appeared as Assigned in the Biller Account");
						takeScreenShot();
						driver.quit();
						Assert.fail();
					}
				}
				
			} catch (Exception e) {
				Log.ReportEvent("FAIL", "Payment Method not Appeared as Assigned in the Biller Account");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
			
		}

		//Function Summary  : Method to verifyToObserveTheRetrievedData
				//Parameter Summary : BillerName
				public void verifyToObserveTheRetrievedData(Map<Object, Object> testdatamap, Log Log) throws InterruptedException, IOException {
					try {
					searchCustomReconciliationReport(testdatamap,Log);
					if(CheckElementExists(EdaatOR.Biller_customReconciliation_BillerName_Column_Header)) {
					VerifyValue1(getText(EdaatOR.Admin_customReconcillation_BillerName),testdatamap.get("BillerName").toString());			
					Log.ReportEvent("PASS", "Custom Reconciliation Report Data Retrieval is Successfull");
					Thread.sleep(500);
					}
					else {
						Log.ReportEvent("FAIL", "Custom Reconciliation Report Data Retrieval is Unsuccessfull");
						this.takeScreenShot();
						driver.quit();
						Assert.fail();
					}
					}
					catch (Exception e) {
						Log.ReportEvent("FAIL", "Custom Reconciliation Report Data Retrieval is Unsuccessfull");
						this.takeScreenShot();
						driver.quit();
						Assert.fail();
					}
				}

				//Function Summary  : Method to Verify the pagination in the report
				//Parameter Summary : N/A	
				public void verifyPaginationInTheReport(Map<Object,Object> testdatamap,Log Log) {
					try {
						searchCustomReconciliationReport(testdatamap,Log);
		                verifyElementIsPresent(EdaatOR.Admin_RecievableReports_pagination_dropdown);
						WebClick(EdaatOR.Admin_RecievableReports_pagination_dropdown);
		                Thread.sleep(1000);
				    	List<WebElement> options=getElements(EdaatOR.Admin_RecievableReports_pagination_options);
				    	if(options.size()==4) {	
				    		for (Object option:options){
				    			CheckElementExists(option.toString());
				    	}
				    		Log.ReportEvent("PASS", "Pagination in the report Verification is Successful");
				    		}
			    		else {
				    		Log.ReportEvent("FAIL", "Pagination in the report Verification is Unsuccessfull");
				    		this.takeScreenShot();
				    		driver.quit();
				    		Assert.fail();
			    		}
					}
					catch (Exception e) {
						Log.ReportEvent("FAIL", "Pagination in the report Verification is Unsuccessfull");
			    		this.takeScreenShot();
			    		driver.quit();
			    		Assert.fail();
					}
							
				}

				//Function Summary   : Method to validate Search Button is clickable Functionality	
				//Parameter Summary : N/A	
				public void validateSearchButtonIsClickableFunctionality(Map<Object,Object> testdatamap,Log Log) throws InterruptedException
				{
					try {
						SelectDate(testdatamap);
						SelectPaymentMethod(testdatamap);
						clickOnSelectAllCheckbox();
						Thread.sleep(600);
						clickOnSearchButton();
						Thread.sleep(1000);			
						if(ExistsCheck(EdaatOR.Biller_Rece_Reports_Custom_Rec_Report)) {
						Thread.sleep(500);
						Log.ReportEvent("PASS", "Search button clickable is Successful");

					  }	
						else {
							Log.ReportEvent("FAIL", "Search button clickable is Unsuccessfull");
							this.takeScreenShot();
							driver.quit();
							Assert.fail();
						}
					}
					catch(Exception e){
						Log.ReportEvent("FAIL", "Search button clickable is Unsuccessfull");
						this.takeScreenShot();
						driver.quit();
						Assert.fail();
					}
				}

				//Function Summary   : Method to validate CheckingAndUnchecking Reports checkbox Changes In GridData		
				public void validateCheckingAndUncheckingReportsCheckboxChangesInGridData(Map<Object,Object> testdatamap,Log Log) throws InterruptedException
				{
					try {
						
						SelectDate(testdatamap);
						Thread.sleep(900);
						SelectPaymentMethod(testdatamap);
						Thread.sleep(900);
						clickOnReportsFieldsCheckbox(testdatamap);
						Thread.sleep(900);
						clickOnSearchButton();					
						Thread.sleep(2000);	
						WebElement element=driver.findElement(By.xpath(EdaatOR.Admin_customReconcillation_ExportToExcelLink));
						scrollToElement(driver, element);
						
						Thread.sleep(900);	
						if(ExistsCheck(EdaatOR.Biller_Rece_Cus_Rec_Reports_BillerName_GridColumn)) {
						Thread.sleep(1000);
						clickOnReportsFieldsCheckbox(testdatamap);						
						Thread.sleep(900);
						clickOnSearchButton();			
						Thread.sleep(2000);
						WebElement element1=driver.findElement(By.xpath(EdaatOR.Admin_customReconcillation_ExportToExcelLink));
						scrollToElement(driver, element1);
						Thread.sleep(900);
						verifyElementIsNotPresent(EdaatOR.Biller_Rece_Cus_Rec_Reports_BillerName_GridColumn);
						Log.ReportEvent("PASS", "Checking and Unchecking the Report's Checkbox Successfully Changes Grid Data");
						}
						 
						else {
							
							Log.ReportEvent("FAIL", "Checking and Unchecking the Report's Checkbox Fails to Change Grid Data.");
							takeScreenShot();
							driver.quit();
							Assert.fail();
							
						}

					  }		catch(Exception e){
						  
						  Log.ReportEvent("FAIL", "Checking and Unchecking the Report's Checkbox Fails to Change Grid Data.");
							takeScreenShot();
							driver.quit();
							Assert.fail();
					}
				}
				//Function Summary  : Method to click On Reports Fields Checkbox
				//Parameter Summary : N/A	
				public void clickOnReportsFieldsCheckbox(Map<Object,Object> testdatamap) throws InterruptedException
				{
                    WebClickUsingJS("//label[text()='"+testdatamap.get("ReportFieldsCheckboxes").toString()+"']");
			    	Thread.sleep(1000);
			    	
			    	
				}

				//Function Summary  : Method to verifyToObserveTheRetrievedData
				//Parameter Summary : BillerName
				public void searchCustomReconciliationReport(Map<Object, Object> testdatamap, Log Log) {
					try {
						SelectDate(testdatamap);
						if(testdatamap.get("PaymentMethodSelection").toString().equalsIgnoreCase("true")) {
						SelectPaymentMethod(testdatamap);
						clickOnSelectAllCheckbox();
						Thread.sleep(600);
						}
						clickOnSearchButton();
						Thread.sleep(1000);
						if(!testdatamap.get("PaymentMethod").toString().equalsIgnoreCase("master card")&& IsDispalyed(EdaatOR.Biller_customReconciliation_No_data_text)==false) {
							Log.ReportEvent("PASS", "Custom Reconciliation Report Search is Successfull");
							Thread.sleep(900);
							}
						else if(testdatamap.get("PaymentMethod").toString().equalsIgnoreCase("master card")&& CheckElementExists(EdaatOR.Biller_customReconciliation_No_data_text)){
							Log.ReportEvent("PASS", "Master Card Custom Reconciliation Report Search is Successfull");
							Thread.sleep(900);
						}
						else if(testdatamap.get("PaymentMethod").toString().equalsIgnoreCase("mada")&& CheckElementExists(EdaatOR.Biller_customReconciliation_No_data_text)){
							Log.ReportEvent("PASS", "Mada Custom Reconciliation Report Search is Successfull");
							Thread.sleep(900);
						}
						else {
							Log.ReportEvent("FAIL", "Custom Reconciliation Report Search is Unsuccessfull");
							this.takeScreenShot();
							driver.quit();
							Assert.fail();
						}
					}
					catch (Exception e) {
						Log.ReportEvent("FAIL", "Custom Reconciliation Report Search is Unsuccessfull");
						this.takeScreenShot();
						driver.quit();
						Assert.fail();
					}
				}


				 //Function Summary  : Method to Navigate Custom reconciliation Report page.  
		  		//Parameter Summary : NA
		  		public void navigateToCustomReconciliationReportPage(Log Log)throws InterruptedException
		  		{
		  			try{
		  			WebClickUsingJS(EdaatOR.Biller_ReportMenu);
		  			Thread.sleep(1000);
		  			WebClickUsingJS(EdaatOR.Biller_ReceivablesReportsbtn);
		  			Thread.sleep(1000);
		  			WebClickUsingJS(EdaatOR.Biller_CustomReconciliationReport);
		  			Thread.sleep(1000);
		  			if(CheckElementExists(EdaatOR.Biller_customReconciliation_Report_Header)) {
			  			Log.ReportEvent("PASS", "Custom Reconciliation Report page is displayed Successfully");
			  			Thread.sleep(1000);
		  			}
		  			else {
		  				Log.ReportEvent("FAIL", "Custom Reconciliation Report page is not displayed Successfully");
		  				this.takeScreenShot();
		  				driver.quit();
		  				Assert.fail();
		  			}
		  			}
		  			catch (Exception e) {
		  				Log.ReportEvent("FAIL", "Custom Reconciliation Report page is not displayed Successfully");
		  				this.takeScreenShot();
		  				driver.quit();
		  				Assert.fail();
		  			}
		  		} 

}

	 

