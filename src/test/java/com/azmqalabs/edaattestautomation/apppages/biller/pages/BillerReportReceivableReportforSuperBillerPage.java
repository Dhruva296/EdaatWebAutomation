package com.azmqalabs.edaattestautomation.apppages.biller.pages;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.remote.server.handler.SwitchToFrame;
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



public class BillerReportReceivableReportforSuperBillerPage extends BasePage
{

	public BillerReportReceivableReportforSuperBillerPage(WebDriver driver,ExtentTest test)
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
	    //Function Summary   : Method to Navigate Receivable Reports SuperBiller
	    //Parameter Summary :  N/A.
	    public void NavigatetoReceivableReportSuperBiller(Log Log) throws Exception
	    {
	    	WebClick(EdaatOR.Biller_ReportsMenu);
			 Thread.sleep(1000);
			 WebClick(EdaatOR.Biller_Recevible_ReportSuperBiller);
			 Thread.sleep(1000);
			 WebClick(EdaatOR.Biller_Recevible_ReportSuperBillerCorporateClient);
			 Thread.sleep(1000);
			 Log.ReportEvent("PASS", " Navigate to Receivable Report Super Biller");
			 this.takeScreenShot();
			 
	    }
	    
  //Function Summary  : Method to Corporate Client eport
	//Parameter Summary : N/A
	public void NavigatetoCorporateClientReport(Log Log) throws InterruptedException {
	 try {		
		WebClickUsingJS(EdaatOR.Biller_ReportMenu); 
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Biller_Recevible_ReportSuperBiller); 
		Thread.sleep(1000);
		scrollToElementCenter(driver,getElement(EdaatOR.Biller_Recevible_ReportSuperBillerCorporateClient));
		Thread.sleep(1000);
		WebClick(EdaatOR.Biller_Recevible_ReportSuperBillerCorporateClient);
		Thread.sleep(1000);
		if(ExistsCheck(EdaatOR.Biller_CorporateClientReportPage)) {
			Log.ReportEvent("PASS", "Corporate Client Report Page is Loaded Successfully");
    		
		}
	else {
		Log.ReportEvent("FAIL", "Corporate Client Report Page is not Loaded Successfully");
		this.takeScreenShot();
		driver.quit();
		Assert.fail();

	}
	}catch(Exception e){
		Log.ReportEvent("FAIL", "Corporate Client Report Page is not Loaded Successfully");
		this.takeScreenShot();
		driver.quit();
		Assert.fail();
     }
		}
	//Function Summary  : Method to Corporate Client eport
		//Parameter Summary : N/A
		public void NavigatetoSubBillersReport(Log Log) throws InterruptedException {
		 try {		
			WebClickUsingJS(EdaatOR.Biller_ReportMenu); 
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_Recevible_ReportSuperBiller); 
			Thread.sleep(1000);
			scrollToElementCenter(driver, getElement(EdaatOR.Biller_SuperBiller_subBillerbtn));
			Thread.sleep(1000);
			WebClick(EdaatOR.Biller_SuperBiller_subBillerbtn);
			Thread.sleep(1000);
			if(ExistsCheck(EdaatOR.Biller_SuperBiller_SubBiller_ReportPage)) {
				Log.ReportEvent("PASS", "Sub Billers Report Page is Loaded Successfully");
	    		
			}
		else {
			Log.ReportEvent("FAIL", "Sub Billers Report Page is not Loaded Successfully");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();

		}
		}catch(Exception e){
			Log.ReportEvent("FAIL", "Sub Billers Report Page is not Loaded Successfully");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
	     }
			}
		
        //Function Summary  : Method to Corporate Client eport
		//Parameter Summary : N/A
		public void NavigatetoSadadPaymentsTransactionsReport(Log Log) throws InterruptedException {
		 try {		
			WebClickUsingJS(EdaatOR.Biller_ReportMenu); 
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_Recevible_ReportSuperBiller); 
			Thread.sleep(1000);
			 WebClickUsingJS(EdaatOR.Biller_SadadPaymentsReportLink);
			Thread.sleep(1000);
			if(ExistsCheck(EdaatOR.Biller_Receivables_Sadadpayment_Page)) {
				Log.ReportEvent("PASS", "Sadad Payments Transactions Report Page is Loaded Successfully");
	    		
			}
		else {
			Log.ReportEvent("FAIL", "Sadad Payments Transactions Report Page is not Loaded Successfully");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();

		}
		}catch(Exception e){
			Log.ReportEvent("FAIL", "Sadad Payments Transactions Report Page is not Loaded Successfully");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
	     }
			}	
	  //Function Summary  : Method to Verify Corporate Client Report
	  //Parameter Summary : TrackedBillerName .
	 public void VerifyCorportaeClientsReport(Map<Object, Object> testdatamap,Log Log) throws Exception {
		 try{
			 NavigatetoCorporateClientReport(Log);
			 Thread.sleep(1000);
			 WebClickUsingJS(EdaatOR.Biller_Rece_ReportSupBillerCorpoTrackBillName);
			 Thread.sleep(2000);
			 WebEdit(EdaatOR.Biller_Rece_ReportSupBillerCorpoTrackBillName, testdatamap.get("TrackedBillerName").toString());
			 Thread.sleep(2000);
			 WebClick(EdaatOR.Biller_Rece_ReportSupBillerGenerateReportBTN);
			 Thread.sleep(1000);
			 switchToWindow();
			 waitForPageToLoad();
			
			 swithchToFrame(EdaatOR.Biller_SuperBillerCorporateClientframe);
			 Thread.sleep(2000);
			 if(ExistsCheck(EdaatOR.Biller_SuperBillerCorporateReportClientText)) {
				 Log.ReportEvent("PASS", "Corporate Client Report Generation is Successful.");

			 }
			 else {
				 Log.ReportEvent("FAIL", "Corporate Client Report Generation is Unsuccessful.");
	                takeScreenShot();
	                driver.quit();
	                Assert.fail();
			 }
			 switchBacktoParentwindow();
				
     }catch(Exception e){
    	 Log.ReportEvent("FAIL", "Corporate Client Report Generation is Unsuccessful.");
         takeScreenShot();
         driver.quit();
         Assert.fail();
     }
				 
	 
	 }
	 
	 
	 	//Function Summary  : Method to Enter FromDate 
			//Parameter Summary : FromYear,FromMonth,FromDate
			private void EnterFromdate(Map<Object, Object> testdatamap) throws Exception {
				WebClick(EdaatOR.Biller_Clientreport_FromDate);
				selectDropdownValue_PartialText(EdaatOR.Biller_Clientreport_Fromyear,testdatamap.get("FromYear").toString());
				selectDropdownValue_PartialText(EdaatOR.Biller_Clientreport_FromMonth,testdatamap.get("FromMonth").toString());
	            WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
				Thread.sleep(1000);
			}
			
			//Function Summary  : Method to Enter FromDate 
			//Parameter Summary : ToYear,ToMonth,ToDate
			private void EnterTodate(Map<Object, Object> testdatamap) throws Exception {
				WebClick(EdaatOR.Biller_Clientreport_TODate);
				selectDropdownValue_PartialText(EdaatOR.Biller_Clientreport_Toyear,testdatamap.get("ToYear").toString());
				selectDropdownValue_PartialText(EdaatOR.Biller_Clientreport_ToMonth,testdatamap.get("ToMonth").toString());
	            WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");
				Thread.sleep(1000);

			}
			
	//Function Summary  : Method to NavigatetoSadadPaymentsTransactionsReport
	//Parameter Summary : N/A
	public void NavigatetoClientInvoiceReport(Log Log) throws InterruptedException {
	 try {		
		WebClickUsingJS(EdaatOR.Biller_ReportMenu); 
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Biller_Recevible_ReportSuperBiller); 
		Thread.sleep(1000);
		WebClick(EdaatOR.Biller_clientinvoicebtn_SprBiller); 
		Thread.sleep(1000);
		if(ExistsCheck(EdaatOR.Biller_ClientsInvoicesReport_Page)) {
			Log.ReportEvent("PASS", "Client Invoices Report Page is Loaded Successfully");
    		
		}
	else {
		Log.ReportEvent("FAIL", "Client Invoices Report Page is not Loaded Successfully");
		this.takeScreenShot();
		driver.quit();
		Assert.fail();

	}
	}catch(Exception e){
		Log.ReportEvent("FAIL", "Client Invoices Report Page is not Loaded Successfully");
		this.takeScreenShot();
		driver.quit();
		Assert.fail();
     }
		}
	
	
	 //Function Summary  : Method to Verify ClientInvoiceReport Generate Functionality  
	//Parameter Summary : ClientType,ClientName,BillStatus,IdorCR,SubBillerType,SubBillerName,TrackedBiller
	public void GenerateReport(Map<Object, Object> testdatamap,Log Log) {
		// TODO Auto-generated method stub
		try{
			NavigatetoClientInvoiceReport(Log);
			
			WebClick(EdaatOR.Biller_Trackedbiller);
			WebClick("//li[text()='"+testdatamap.get("TrackedBiller").toString()+"']");
			EnterFromdate(testdatamap);
			EnterTodate(testdatamap);
			Thread.sleep(2000);
			selectDropdownValue_PartialText(EdaatOR.Biller_ClientType,testdatamap.get("ClientType").toString());
			Thread.sleep(500);
			WebClick(EdaatOR.Biller_ClientNamearro);
			Thread.sleep(500);
			WebClick("//li[text()='"+testdatamap.get("ClientName").toString()+"']");
			Thread.sleep(1000);
			WebClick(EdaatOR.Biller_Clientstatus);
			Thread.sleep(1000);
			WebClick("//li[text()='"+testdatamap.get("BillStatus").toString()+"']");			
			Thread.sleep(500);
			WebEdit(EdaatOR.Biller_IdorCR,testdatamap.get("IdorCR").toString());
			Thread.sleep(2000);
			WebSelect(EdaatOR.Biller_SubBillerType,testdatamap.get("SubBillerType").toString());
			Thread.sleep(2000);	     
        	WebClick(EdaatOR.Biller_clientSubBillerName);
     		Thread.sleep(2000);
     		WebClick("//li[text()='"+testdatamap.get("SubBillerName").toString()+"']");
     		Thread.sleep(2000);
			WebClickUsingActions(EdaatOR.Biller_Generatebtn);
			Thread.sleep(5000);
			switchToWindow();
			Thread.sleep(3000);
			swithchToFrame(EdaatOR.Biller_reportframe);
			
			if(ExistsCheck(EdaatOR.Biller_clientinvoice)) {
	    		Log.ReportEvent("PASS", "Client Invoices Report Generation is Successful.");

    		}
    		else {
	    		Log.ReportEvent("FAIL", "Client Invoices Report Generation is Unsuccessful.");
                takeScreenShot();
                driver.quit();
                Assert.fail();
    		}
			switchBacktoParentwindow();
			Thread.sleep(2000);
			waitForPageToLoad();			
    		
			}
		catch(Exception e){
    		Log.ReportEvent("FAIL", "Client Invoices Report Generation is Unsuccessful.");
            takeScreenShot();
            driver.quit();
            Assert.fail();
	}
		
	}
		
		
	//Function Summary  : Method to SelectRadioBtn
	//Parameter Summary : 
	 public void SelectRadioBtn(Map<Object, Object> testdatamap) throws Exception {
		 String type = testdatamap.get("Radiobtn").toString();
		 if(type.equalsIgnoreCase("individual"))
		 {
			 WebClickRadiobutton(EdaatOR.Biller_SuperBiller_SubBiller_selectInd);
			 Thread.sleep(1000);
			 WebEdit(EdaatOR.Biller_SuperBiller_SubBiller_Nationalefield, testdatamap.get("NationalId").toString());
			 Thread.sleep(1000);
		 }
		 else
		 {
			 WebClick(EdaatOR.Biller_SuperBiller_SubBiller_selectCorp);
			 Thread.sleep(1000);
			 WebEdit(EdaatOR.Biller_SuperBiller_SubBiller_Crnumberefield, testdatamap.get("CRNumber").toString());
			 Thread.sleep(1000);
		 }
			
		}
	//Function Summary  : Method to Verify Corporate Client Report
	//Parameter Summary : TrackedBillerName .
	public void VerifySubBillersReport(Map<Object, Object> testdatamap,Log Log) {
		try
		{
			String type = testdatamap.get("Radiobtn").toString();
			WebClickUsingJS(EdaatOR.Biller_SuperBiller_subBillerbtn);
			SelectRadioBtn(testdatamap);
			Thread.sleep(1000);
			WebClick(EdaatOR.Biller_SuperBiller_SubBiller_trackbill);
			Thread.sleep(1000);
			WebClickUsingActions("//li[text()='"+testdatamap.get("TrackedBillerName").toString()+"']");
			Thread.sleep(5000);
			
			WebClick(EdaatOR.Biller_SuperBiller_SubBiller_generatebtn);
			switchToWindow();
			Thread.sleep(1000);
			swithchToFrame(EdaatOR.Biller_SuperBiller_SubBiller_frame);
			Thread.sleep(1000);
			
			 if(ExistsCheck(EdaatOR.Biller_SuperBiller_SubBiller_indVerify))
			 {
				 Log.ReportEvent("PASS", "Sub Billers Report Generation is Successful.");
			 }
			 else if(ExistsCheck(EdaatOR.Biller_SuperBiller_SubBiller_CorpVerify)) {
				 Log.ReportEvent("PASS", "Sub Billers Report Generation is Successful.");
			 }
			 else
			 {
				 Log.ReportEvent("FAIL", "Sub Billers Report Generation is Unsuccessful.");
	                takeScreenShot();
	                driver.quit();
	                Assert.fail();
			 }
			 switchBacktoParentwindow();
			 Thread.sleep(1000);
				
		
		}
		catch (Exception e) {
			 Log.ReportEvent("FAIL", "Sub Billers Report Generation is Unsuccessful.");
             takeScreenShot();
             driver.quit();
             Assert.fail();
		}
	}
		 
	    //Function Summary    : Method to Navigate "Over Due Bills Report" Page
	    //Parameter Summary   :  N/A.
	    public void NavigatetoSuperBillerOverDueBillsReport(Log Log) throws Exception
	    { 
	    	try {
	    	 WebClick(EdaatOR.Biller_ReportsMenu);
			 Thread.sleep(1000);
			 WebClick(EdaatOR.Biller_Recevible_ReportSuperBiller);
			 Thread.sleep(1000);
			 WebClick(EdaatOR.Biller_SuperBillerOverDueBillsReport);
			 Thread.sleep(1000);
			 if(ExistsCheck(EdaatOR.Biller_OverDueBillsReport_Page)) {
					Log.ReportEvent("PASS", "Over Due Bills Report Page is Loaded Successfully");
		    		
				}
			else {
				Log.ReportEvent("FAIL", "Over Due Bills Report Page is not Loaded Successfully");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();

			}
			}catch(Exception e){
				Log.ReportEvent("FAIL", "Over Due Bills Report Page is not Loaded Successfully");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
		     }
	    }
	    
	  //Function Summary : Method to Navigate "Client Account Statement Report" Page
	    //Parameter Summary   :  N/A.
	    public void NavigatetoSuperBillerClientAccountStatementReport(Log Log) throws Exception
	    { 
	    	try {
	    		WebClickUsingJS(EdaatOR.Biller_ReportMenu); 
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Biller_Recevible_ReportSuperBiller); 
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Biller_Recevible_ReportSprBiler_ClientAccount); 
				Thread.sleep(1000);
			 if(ExistsCheck(EdaatOR.Biller_ReportClientaccountStatement_Page)) {
					Log.ReportEvent("PASS", "Client Account Statement Report Page is Loaded Successfully");
		    		
				}
			else {
				Log.ReportEvent("FAIL", "Client Account Statement Report Page is not Loaded Successfully");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();

			}
			}catch(Exception e){
				Log.ReportEvent("FAIL", "Client Account Statement Report Page is not Loaded Successfully");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
		     }
	    }
	    
	  //Function Summary  : Method to Verify Overdue Bills Report Client Report
	  //Parameter Summary : ClientType,TrackedBillerName,ClientName,SubBillerType,SubBillerName,Report
	 public void VerifyOverdueBillsReport(Map<Object, Object> testdatamap,Log Log)
     {
		 try{
			 WebClick(EdaatOR.Biller_SuperBillerOverDueBillsReportClientType);
             Thread.sleep(2000);

             WebSelect(EdaatOR.Biller_SuperBillerOverDueBillsReportClientType, testdatamap.get("ClientType").toString());
             Thread.sleep(2000);
             selectDropdownValue_PartialText(EdaatOR.Biller_SuperBillerOverDueBillesTrackedBiller, testdatamap.get("TrackedBillerName").toString() );
             Thread.sleep(2000);
             WebClick(EdaatOR.Biller_SuperBillerOverDueBillsReportclientNameTxtField);
             WebClick("//li[contains(text(),'"+testdatamap.get("ClientName").toString()+"')]");
             Thread.sleep(2000);
             WebSelect(EdaatOR.Biller_SuperBillerOverDueBillsReportSubBillerType, testdatamap.get("SubBillerType").toString());
             Thread.sleep(2000);
//             WebClick(EdaatOR.Biller_SuperBillerOverDueBillsReportSubBillerName);
//             Thread.sleep(1000);
//             WebClick("//li[text()='"+testdatamap.get("SubBillerName").toString()+"']");
//             Thread.sleep(3000);
             WebClick(EdaatOR.Biller_SuperBillerOverDueBillsGenerateReportBTN);
             Thread.sleep(10000);
             waitForPageToLoad();
             switchToWindow();
             swithchToFrame(EdaatOR.Biller_SuperBillerOverDueBillsReportFrame);
             Thread.sleep(2000);
             
             if(WebGetText("//div[text()='"+testdatamap.get("Report").toString()+"']").equals(testdatamap.get("Report").toString())) {
 	    		Log.ReportEvent("PASS", "Over Due Bills Report Generation is Successful.");

     		}
     		else {
 	    		Log.ReportEvent("FAIL", "Over Due Bills Report Generation is Unsuccessful.");
                 takeScreenShot();
                 driver.quit();
                 Assert.fail();
     		}
             Thread.sleep(2000);
            
             switchBacktoParentwindow();
             
             }

         catch(Exception e){
        	 Log.ReportEvent("FAIL", "Over Due Bills Report Generation is Unsuccessful.");
             takeScreenShot();
             driver.quit();
             Assert.fail();
     }
	 }
	 
	 	 public void NavigateReceivableReportsforSuperBiller(Log Log) throws Exception
	    {
	    	 WebClick(EdaatOR.Biller_ReportsMenu);
             Thread.sleep(1000);
			 WebClick(EdaatOR.Biller_Recevible_ReportSuperBiller);
			 Log.ReportEvent("PASS", " Navigate to Receivable reports for super biller page");
			 this.takeScreenShot();
	    }
	 	  //Function Summary  : Method to SelectDate
		  //Parameter Summary : FromYear,FromMonth,FromDate,ToYear,ToMonth,ToDate.
	 public void ClientAccountSelectDate(Map<Object, Object> testdatamap)
	 {
		 try {
			  WebClick(EdaatOR.Biller_Rcv_superbilr_ClientAccount_Fromdate);
			  selectDropdownValue_PartialText(EdaatOR.Biller_Rcv_superbilr_ClientAccount_Fromyear,testdatamap.get("FromYear").toString());
			  selectDropdownValue_PartialText(EdaatOR.Biller_Rcv_superbilr_ClientAccount_FromMon,testdatamap.get("FromMonth").toString());
			  WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
			  WebClick(EdaatOR.Biller_Rcv_superbilr_ClientAccount_Todate);
			  selectDropdownValue_PartialText(EdaatOR.Biller_Rcv_superbilr_ClientAccount_Toyear,testdatamap.get("ToYear").toString());
			  selectDropdownValue_PartialText(EdaatOR.Biller_Rcv_superbilr_ClientAccount_Tomon,testdatamap.get("ToMonth").toString());
			  WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");
			  	}
			  catch (Exception e) {
			  	e.printStackTrace();
			  	
			  	}
			  		
	 }
//Function Summary  : Method to Select Client type. 
		//Parameter Summary : ClientType,Individual.
		public void ClientType(Map<Object, Object> testdatamap) { 
			
			try{
				WebClick(EdaatOR.Biller_ClientType);
				String ele=testdatamap.get("ClientType").toString();
				if(ele.equalsIgnoreCase("Individual")) {
				selectDropdownValue_PartialText(EdaatOR.Biller_ClientTypeindvidutial, ele);
				}
				else {
					selectDropdownValue_PartialText(EdaatOR.Biller_ClientTypeCorporate, ele);
				}			
				
			}
			catch(Exception e){
		test.log(Status.FAIL,"Generate Report and export" + driver.getTitle() +" * Generate Report and export FAIL * " );
		
		}			
		}
		
		  //Function Summary  : Method to Select Client type. 
		 //Parameter Summary : ClientName.
		public void SelectClient(Map<Object, Object> testdatamap) throws Exception {
			
			WebClick(EdaatOR.Biller_ReportSuper_ClientAccount_Client);
		   Thread.sleep(2000);
		   WebClick("//li[text()='"+testdatamap.get("ClientName").toString()+"']");
		}
		
//Function Summary  : Method to VerifyvClientvAccountvStatementvReport
//Parameter Summary : 	TrackedBiller,SubBiller,SubbillerName,FromYear,FromMonth,FromDate,ToYear,ToMonth,ToDate
	 public void VerifyClientAccountStatementReport(Map<Object, Object> testdatamap,Log Log)
	 {
	   try {
		    
			ClientType(testdatamap);
			WebClick(EdaatOR.Biller_ReportSuper_ClientAccount_TrackedBiller);
			WebClick("//li[text()='"+testdatamap.get("TrackedBiller").toString()+"']");
			Thread.sleep(1000);
			SelectClient(testdatamap);	
			//WebClick(EdaatOR.Biller_ReportSuper_ClientAccount_subBiller_type);
			Thread.sleep(1000);	
			WebSelect1(EdaatOR.Biller_ReportSuper_ClientAccount_subBiller_type, testdatamap.get("SubBiller").toString());    
		    Thread.sleep(2000);
		    WebClick(EdaatOR.Biller_ReportSuper_ClientAccount_subBiller_name);
		    Thread.sleep(2000);
		    WebClick("//li[text()='"+(testdatamap.get("SubbillerName").toString())+"']");					
		//	WebEdit(EdaatOR.Biller_Invoicecontract,testdatamap.get("Invoice Contract").toString());
		    WebClick(EdaatOR.Biller_ReportFromdate);
			Thread.sleep(1000);
	        selectDropdownValue_PartialText(EdaatOR.Biller_reportFromYear,testdatamap.get("FromYear").toString());
	    	Thread.sleep(1000);
	        selectDropdownValue_PartialText(EdaatOR.Biller_reportFromMonth,testdatamap.get("FromMonth").toString());
	    	Thread.sleep(1000);
	        WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
	    	Thread.sleep(1000);
	        WebClick(EdaatOR.Biller_ReportTodate);
	    	Thread.sleep(1000);
	        selectDropdownValue_PartialText(EdaatOR.Biller_reportToyear,testdatamap.get("ToYear").toString());
	    	Thread.sleep(1000);
	        selectDropdownValue_PartialText(EdaatOR.Biller_reportToMonth,testdatamap.get("ToMonth").toString());
	    	Thread.sleep(1000);
	        WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");	
	    	Thread.sleep(1000);
	        WebClick(EdaatOR.Biller_ReportSuper_ClientAccount_search);
	        waitForPageToLoad();
	        Thread.sleep(5000);			        
	        switchToWindow();			      
	        swithchToFrame(EdaatOR.Biller_reportframe);
	        
	        if(ExistsCheck(EdaatOR.Biller_Rcv_superbilr_ClientAccount_verify)) {
 	    		Log.ReportEvent("PASS", "Client Account Statement Report Generation is Successful.");

     		}
     		else {
 	    		Log.ReportEvent("FAIL", "Client Account Statement Generation is Unsuccessful.");
                 takeScreenShot();
                 driver.quit();
                 Assert.fail();
     		}
		    switchBacktoParentwindow();
	    	Thread.sleep(1000); 
		 }
		 catch(Exception e)
		 {
			 Log.ReportEvent("FAIL", "Client Account Statement Generation is Unsuccessful.");
             takeScreenShot();
             driver.quit();
             Assert.fail();
		 }
		 
	 }

	  //Function Summary  : Method to SelectDate
	  //Parameter Summary : FromYear,FromMonth,FromDate,ToYear,ToMonth,ToDate.
public void SelectDate(Map<Object, Object> testdatamap)
{
	 try {
		  WebClick(EdaatOR.Biller_FromDateCalendar);
		  selectDropdownValue_PartialText(EdaatOR.Biller_Rcv_superbilr_ClientAccount_Fromyear,testdatamap.get("FromYear").toString());
		  selectDropdownValue_PartialText(EdaatOR.Biller_Rcv_superbilr_ClientAccount_FromMon,testdatamap.get("FromMonth").toString());
		  WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
		  WebClick(EdaatOR.Biller_ToDateCalendar);
		  selectDropdownValue_PartialText(EdaatOR.Biller_Rcv_superbilr_ClientAccount_Toyear,testdatamap.get("ToYear").toString());
		  selectDropdownValue_PartialText(EdaatOR.Biller_Rcv_superbilr_ClientAccount_Tomon,testdatamap.get("ToMonth").toString());
		  Thread.sleep(5000);
		  WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");
		  
		  	}
		  catch (Exception e) {
		  	
		  	}
		  		
}
	 
	  //Function Summary  : Method to Verify Sadad Payment Transactions report
	  //Parameter Summary : InvoiceType,InvoiceNumber,ClientType,TrackedBillerName,ClientName.
	 public void VerifySadadPaymentsTransactions(Map<Object, Object> testdatamap,Log Log)
    {
		 try{
			 Thread.sleep(1000);
			 selectDropdownValue_PartialText(EdaatOR.Biller_SadadReportInvoiceType, testdatamap.get("InvoiceType").toString());
            Thread.sleep(1000);
            selectDropdownValue_PartialText(EdaatOR.Biller_SadadReportClientType, testdatamap.get("ClientType").toString() );
            Thread.sleep(2000);
             WebClickUsingJS(EdaatOR.Biller_SadadReportTrackerBiller);
             WebClick("//li[contains(text(),'"+testdatamap.get("TrackedBillerName").toString()+"')]");
            //WebEdit(EdaatOR.Biller_SadadReportTrackerBiller,testdatamap.get("TrackedBillerName").toString());
            Thread.sleep(2000);
            WebClick(EdaatOR.Biller_SadadReportClientName);
            WebClick("//li[contains(text(),'"+testdatamap.get("ClientName").toString()+"')]");
            Thread.sleep(1000);
            SelectDate(testdatamap);
            Thread.sleep(3000);
            WebEdit(EdaatOR.Biller_SadadReportInvoiceNo, testdatamap.get("InvoiceNumber").toString());
            Thread.sleep(2000);
            WebClick(EdaatOR.Biller_Products);
            WebClick("//li[contains(text(),'"+testdatamap.get("ProductName").toString()+"')]");
            Thread.sleep(3000);
            WebClick(EdaatOR.Biller_SadadReportSearchBtn);
            Thread.sleep(10000);

            waitForPageToLoad();
            switchToWindow();
            swithchToFrame(EdaatOR.Biller_CorporateReport);
            Thread.sleep(2000);
            
            if(ExistsCheck(EdaatOR.Biller_SadadReportVerify)) {
 	    		Log.ReportEvent("PASS", "Sadad Payments Transactions Report Generation is Successful.");

     		}
     		else {
 	    		Log.ReportEvent("FAIL", "Sadad Payments Transactions Report Generation is Unsuccessful.");
                 takeScreenShot();
                 driver.quit();
                 Assert.fail();
     		}
             Thread.sleep(2000);
             switchBacktoParentwindow();

		 }catch(Exception e){
			 Log.ReportEvent("FAIL", "Sadad Payments Transactions Report Generation is Unsuccessful.");
             takeScreenShot();
             driver.quit();
             Assert.fail();
    }
	 }
	 private void SendKeys(Keys enter) {
		// TODO Auto-generated method stub
		
	}
	//Function Summary  : Method to Select Client type. 
	 //Parameter Summary : ClientName.
	public void SelectClient(String client) throws Exception {
		
		WebClick(EdaatOR.Biller_ClientName);
		Thread.sleep(1000);
		WebClickUsingActions(EdaatOR.Biller_SelectClientName+"["+client+"]");
		//WebClick(EdaatOR.Biller_SelectClientName);
	}
	
		
		     //Function Summary   : Method to Verify Client Account Statement Report ErrorMsg
		   //Parameter Summary  : Expected.
			public void ClientAccountStatementErrorMsgValidation(Map<Object, Object> testdatamap,Log Log) {
				try
				{
					NavigatetoSuperBillerClientAccountStatementReport(Log);
					String ClientType=testdatamap.get("Client").toString();
					if(ClientType.equals("Valid")) {
					ClientType(testdatamap);
					Thread.sleep(1000);
					SelectClient(testdatamap.get("ClientName").toString());
					}
			       String Date = testdatamap.get("ValidDate").toString();
			       if(Date.equalsIgnoreCase("Valid")){
					WebClick(EdaatOR.Biller_ReportFromdate);
					Thread.sleep(1000);
			        selectDropdownValue_PartialText(EdaatOR.Biller_reportFromYear,testdatamap.get("FromYear").toString());
			    	Thread.sleep(1000);
			        selectDropdownValue_PartialText(EdaatOR.Biller_reportFromMonth,testdatamap.get("FromMonth").toString());
			    	Thread.sleep(1000);
			        WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
			    	Thread.sleep(1000);
			        WebClick(EdaatOR.Biller_ReportTodate);
			    	Thread.sleep(1000);
			        selectDropdownValue_PartialText(EdaatOR.Biller_reportToyear,testdatamap.get("ToYear").toString());
			    	Thread.sleep(1000);
			        selectDropdownValue_PartialText(EdaatOR.Biller_reportToMonth,testdatamap.get("ToMonth").toString());
			    	Thread.sleep(1000);
			        WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");	
			    	Thread.sleep(1000);
			       }
			        WebClickUsingJS(EdaatOR.Biller_reportsearchbutton);
			        Thread.sleep(2000);
					String Expected=testdatamap.get("ExpectedResult").toString();
					if(ExistsCheck(EdaatOR.Biller_Reports_Receiv_ClientAccStm_ClientTypeError))
					{
				         Log.ReportEvent("PASS", "Error Message Validation for Client Type Dropdown is Successful");			

					}
					else if (ExistsCheck(EdaatOR.Biller_Reports_Receiv_ClientAccStm_ClientError)) {
						
				         Log.ReportEvent("PASS", "Error Message Validation for Client Dropdown is Successful");			

					}
					else if (ExistsCheck(EdaatOR.Biller_Reports_Receiv_ClientAccStm_FromDateError)) {
						
				         Log.ReportEvent("PASS", "Error Message Validation for From Date Field is Successful");			

						
					}
		            else {
		            	
				         Log.ReportEvent("Fail", "Error Message Validation for Client Account Statement UI is Unsuccessful");	
				         takeScreenShot();
				         driver.quit();
				         Assert.fail();

		            }
				}
				catch (Exception e) {
					Log.ReportEvent("Fail", "Error Message Validation for Client Account Statement UI is Unsuccessful");	
			         takeScreenShot();
			         driver.quit();
			         Assert.fail();
				}
	 }
}
			
	 

