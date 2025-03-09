package com.azmqalabs.edaattestautomation.apppages.biller.pages;

import java.util.Map;

import org.openqa.selenium.By;
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


public class BillerReportsDailyReconciliationReportSadadPage extends BasePage
{

	public BillerReportsDailyReconciliationReportSadadPage(WebDriver driver,ExtentTest test)
	{
		 this.driver=driver;
		 this.test=test;
		 
		 
		 PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  
	 public static String totalInvoiceAmount;
	 public static String operationalFees;

	@FindBy(xpath = EdaatOR.Biller_DailyReconciliationReportSadad)
	public WebElement DailyReconciliationReportPage;
		
	    
	    public boolean Exists(){
	    	return super.Exists(DailyReconciliationReportPage); 
		}
	    
	  //Function Summary  : Method to Navigate Daily reconciliation Report sadad.  
	  		//Parameter Summary : NA
	  		public void navigateToDailyReconciliationReportSadadPage(Log Log)throws InterruptedException
	  		{
	  			try{
	  			WebClickUsingJS(EdaatOR.Biller_ReportMenu);
	  			Thread.sleep(1000);
	  			WebClickUsingJS(EdaatOR.Biller_ReceivablesReportsbtn);
	  			Thread.sleep(1000);
	  			WebClickUsingJS(EdaatOR.Biller_DailyReconciliationReportSadad);
	  			Thread.sleep(1000);
	  			if(ExistsCheck(EdaatOR.Biller_DailyReconciliationReportSadad_Page)) {
	  			Log.ReportEvent("PASS", "Daily Reconciliation SADAD Report Page is Loaded Successfully");
	  			}
	  			else {
		  			Log.ReportEvent("FAIL", "Daily Reconciliation SADAD Report Page is not Loaded Successfully");
		  			takeScreenShot();
		  			driver.quit();
		  			Assert.fail();

	  			}
	  			}
	  			catch (Exception e) {
	  				Log.ReportEvent("FAIL", "Daily Reconciliation SADAD Report Page is not Loaded Successfully");
		  			takeScreenShot();
		  			driver.quit();
		  			Assert.fail();
	  			}
	  		} 
		//Function Summary   : Method to select Reconcilied date
		//Parameter Summary  : Date,Month,Year.
		public void SelectReconciliedDate(Map<Object,Object> testdatamap) throws InterruptedException
		{
			try {
                Thread.sleep(2000);
				WebClick(EdaatOR.Biller_DailyReconciliationReport_ReconciledDate);			
				selectDropdownValue_PartialText(EdaatOR.Admin_ReportsFromYear, testdatamap.get("Year").toString());
				selectDropdownValue_PartialText(EdaatOR.Admin_ReportsFromMonth, testdatamap.get("Month").toString());
				WebClick("//a[text()='"+testdatamap.get("Date").toString()+"']");
				Thread.sleep(800);
 
			}		catch(Exception e){
				test.log(Status.FAIL,"Select Date FAIL" + driver.getTitle() +" *Select Date FAIL * " );
				
			}
		}
		
		
		//Function Summary   : Method to select Transfer Status
		//Parameter Summary  : Status.
		public void SelectTransferStatus(Map<Object,Object> testdatamap) throws InterruptedException
		{
			try {
				selectDropdownValue_PartialText(EdaatOR.Biller_DailyReconciliationReport_TransferStatus, testdatamap.get("Status").toString());
 
			  }		catch(Exception e){
				test.log(Status.FAIL,"Select payment method FAIL" + driver.getTitle() +" *Select Payment Method FAIL * " );
				
			}
		}
		
		//Function Summary  : Method to click on Generate report button
		//Parameter Summary : N/A	
		public void clickOnGenerateReport() throws Exception
		{
			WebClick(EdaatOR.Admin_Button);
	    	Thread.sleep(2000);
			
		}
		
		
		//Function Summary  : Method to Verify Daily Reconciliation Report (SADAD)
		//Parameter Summary : N/A	
		public void verifyDailyReconciliationReportSADAD(Map<Object,Object> testdatamap,Log Log) {
			try {
				Thread.sleep(2000);
				SelectReconciliedDate(testdatamap);
				Thread.sleep(1000);
				SelectTransferStatus(testdatamap);
				Thread.sleep(1000);
				clickOnGenerateReport();
				Thread.sleep(10000);

				switchToWindow();
				swithchToFrame(EdaatOR.Admin_Corporate_Report);
				Thread.sleep(2000);
				if(ExistsCheck("//div[text()='"+testdatamap.get("BillNumber").toString()+"']")) {
					Log.ReportEvent("PASS", "Daily Reconciliation SADAD Report Generation is Successful");
				}
				else {
					Log.ReportEvent("FAIL", "Daily Reconciliation SADAD Report Generation is Unsuccessful");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
				if(testdatamap.get("RetriveData").toString().equals("Retrive Data")) {
                	totalInvoiceAmount = getTotalInvoiceAmount();
                	operationalFees = getAmountOperationFees();
		        	
		        
				}
				if(testdatamap.get("Export").toString().equals("Export"))
				{
					verifyDailyReconciliationSADADExportReport(testdatamap,Log);
				}
                
				switchBacktoParentwindow();		

			}
			catch (Exception e) {
				Log.ReportEvent("FAIL", "Daily Reconciliation SADAD Report Generation is Unsuccessful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}

		}
		
//Function Summary  : Method to Export Daily Reconciliation Report (SADAD)
//Parameter Summary : N/A	
		public void verifyDailyReconciliationSADADExportReport(Map<Object,Object> testdatamap,Log Log) {
			try {
				WebClick(EdaatOR.Biller_DailyReconciliationReportSadad_ExportDropdown);
				
				if(ExistsCheck(EdaatOR.Biller_DailyReconciliationReportSadad_ExportFileFormat)) {
				WebClick(EdaatOR.Biller_DailyReconciliationReportSadad_ExportFileFormat);
				
				Log.ReportEvent("PASS", "Daily Reconciliation SADAD Report Export To Excel is Successful ");
				}
				else {
					Log.ReportEvent("FAIL", "Daily Reconciliation SADAD Report Export To Excel is Unsuccessful");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
				switchBacktoParentwindow();		
			}
			catch (Exception e) {
				Log.ReportEvent("FAIL", "Daily Reconciliation SADAD Report Export To Excel is Unsuccessful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}

		}
		
		
	  
	            //Function Summary  : Method to verify Daily Reconciliation Report(SADAD) And Get Invoice Paid Amount and Operational fees amount
				//Parameter Summary : N/A	
				public void verifyDailyReconciliationReportSADADAndGetInvoicePaidAmount(Map<Object,Object> testdatamap,Log Log) {
					try {
						SelectReconciliedDate(testdatamap);
						Thread.sleep(400);
						SelectTransferStatus(testdatamap);
						Thread.sleep(100);
						clickOnGenerateReport();
						switchToWindow();
						swithchToFrame(EdaatOR.Admin_Corporate_Report);
						Thread.sleep(2000);			   			  					  			
						
						test.log(Status.PASS,"verify Daily Reconciliation Report(SADAD) And Get Invoice Paid Amount and Operational fees amount" + driver.getTitle() +" * PASS * " );
						Log.ReportEvent("PASS", " Verifed Invoice paid amount and operational fees is Successful");
						this.takeScreenShot();

					}
					catch (Exception e) {
						test.log(Status.FAIL,"verify Daily Reconciliation Report(SADAD) And Get Invoice Paid Amount and Operational fees amount" + driver.getTitle() +" * FAIL * " );
						 this.takeScreenShot();
					}
					 

				}
				
				
	  public String getTotalInvoiceAmount()
	  {
			String invoiceAmount = driver.findElement(By.xpath(EdaatOR.Admin_Reports_TotalInvoicePaid)).getText().toString();
			return invoiceAmount;
				
	  }
	  public String getAmountOperationFees()
	  {
			 String operationalFees = driver.findElement(By.xpath(EdaatOR.Admin_Reports_OperationFees)).getText().toString();
			return operationalFees;
	  }
	  

	  public void switchToParentwindow()
	  {
		  switchBacktoParentwindow();
	  }

//	public void setTotalInvoiceAmount(String totalInvoiceAmount) {
//		this.totalInvoiceAmount = totalInvoiceAmount;
//	}
//
//	public void setOperationalFees(String operationalFees) {
//		this.operationalFees = operationalFees;
//	}

}
	 

