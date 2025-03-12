/**
 *
 * Test Script Name                   : N/A
 * Objective                          : Admin reports functionality.
 * Version                            : 1.0
 * Author                             : Kathirvelu M
 * Created Date                       : 23/05/2023
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
import org.openqa.selenium.remote.server.handler.SwitchToFrame;
import org.openqa.selenium.remote.server.handler.SwitchToWindow;
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
import com.azmqalabs.edaattestautomation.testscripts.admin.AdminTrackerMgmToggleStatus;



public class AdminReportsReceivablesReportsPage extends BasePage
{

	public AdminReportsReceivablesReportsPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  


	@FindBy(xpath = EdaatOR.Admin_Reports_superbiller)
	public WebElement Client;


	public boolean Exists(){
		return super.Exists(Client); 
	}
	//Function Summary   : Method to  Navigate to Receivables reports.
	//Parameter Summary  : N/A
	public void NavigateTOReceivablesReports() throws InterruptedException {
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Admin_Reports);
		Thread.sleep(800);
		WebClickUsingJS(EdaatOR.Admin_Receivables_Reports);
		Thread.sleep(800);

	}
	//Function Summary   : Method to  Verify Receivables Corporate Client reports.
	//Parameter Summary  : N/A
	public void VerifyCorporateClientReport(Log Log) throws Exception {
		try{
			WebClickUsingJS(EdaatOR.Admin_Receivables_Corpo_ClientReports);
			Thread.sleep(4000);
			switchToWindow();
			waitForPageToLoad();
		
			swithchToFrame(EdaatOR.Admin_Receivables_CorpoClientFrame);
			
			if(CheckElementExists(EdaatOR.Admin_Receivables_CorpoClientListTXT)) {
				Log.ReportEvent("PASS", "Verify Receivables Corporate Client reports is Successful");				

			}
			else {
				Log.ReportEvent("FAIL", "Verify Receivables Corporate Client reports is not Successful");
				this.takeScreenShot();	
				driver.quit();Assert.fail();	
			}
			switchBacktoParentwindow();


		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Verify Receivables Corporate Client reports is not Successful");
			this.takeScreenShot();	
			driver.quit();Assert.fail();	
		}
	}

	//Function Summary  : Method to Enter FromDate 
	//Parameter Summary : FromYear,FromMonth,FromDate
	private void EnterFromdate(Map<Object, Object> testdatamap) throws Exception
	{
		WebClick(EdaatOR.Admin_ReceivablesReports_ClientInvoice_Fromdate);
		selectDropdownValue_PartialText(EdaatOR.Admin_ReceivablesReports_ClientInvoice_Fromyear,testdatamap.get("FromYear").toString());
		selectDropdownValue_PartialText(EdaatOR.Admin_ReceivablesReports_ClientInvoice_FromMon,testdatamap.get("FromMonth").toString());
		WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
		Thread.sleep(1000);
	}

	//Function Summary  : Method to Enter Todate 
	//Parameter Summary : ToYear,ToMonth,ToDate
	private void EnterTodate(Map<Object, Object> testdatamap) throws Exception {
		WebClick(EdaatOR.Admin_ReceivablesReports_ClientInvoice_Todate);
		selectDropdownValue_PartialText(EdaatOR.Admin_ReceivablesReports_ClientInvoice_Toyear,testdatamap.get("ToYear").toString());
		selectDropdownValue_PartialText(EdaatOR.Admin_ReceivablesReports_ClientInvoice_Tomon,testdatamap.get("ToMonth").toString());
		WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");
		Thread.sleep(1000);
	}

	//Function Summary   : Method to  Navigate to SubBillerReport
	//Parameter Summary  : N/A
	public void NavigateToSubBillerReport(Log Log) throws InterruptedException {
		try {
			WebClickUsingJS(EdaatOR.Admin_Receivables_SubBillerReportLink); 
			Thread.sleep(800);
			if(CheckElementExists(EdaatOR.Admin_SubbillerReportPage)) {
				Log.ReportEvent("PASS", "Receivables Sub Billers Report Page is loaded Successfully");				

			}
			else {
				Log.ReportEvent("FAIL", "Receivables Sub Billers Report Page is not loaded Successfully");
				this.takeScreenShot();	
				driver.quit();Assert.fail();	
			}

		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Receivables Sub Billers Report Page is not loaded Successfully");
			this.takeScreenShot();	
			driver.quit();Assert.fail();	
		}
	}

	//Function Summary  : Method to verify Sub Biller report 
	//Parameter Summary : CRNumber,SubBillerName
	public void SubBillerReport(Map<Object, Object> testdatamap,Log Log) { 

		try{

			NavigateTOReceivablesReports();
			NavigateToSubBillerReport(Log);
			switchToWindow();
			WebEdit(EdaatOR.Admin_Receivables_SubBillerCRNumber, testdatamap.get("CRNumber").toString());
			Thread.sleep(800);	
			WebClickUsingJS(EdaatOR.Admin_Receivables_SubBillerGenerateReport);
			Thread.sleep(800);
			switchToWindow();
			swithchToFrame(EdaatOR.Admin_Receivables_Corporate_Report);
			if(CheckElementExists("//div[contains(text(),'"+testdatamap.get("SubBillerName").toString()+"')]")) {
				Log.ReportEvent("PASS", "Verify Sub Billers Report is Successful");				

			}
			else {
				Log.ReportEvent("FAIL", "Verify Sub Billers Report is not Successful");
				this.takeScreenShot();	
				driver.quit();Assert.fail();	
			}
			switchBacktoParentwindow();

		}

		catch(Exception e){
			Log.ReportEvent("FAIL", "Verify Sub Billers Report is not Successful");
			this.takeScreenShot();	
			driver.quit();Assert.fail();
		}			
	}



	//Function Summary  : Navigate to  Receivable Reports
	//Parameter Summary : NA
	public void NavigateReceivableReports() {
		WebClickUsingJS(EdaatOR.Admin_Receivables_Reports);
	}

	//Function Summary   : Method to  Navigate to ReceivableReportsClientInvoice
	//Parameter Summary  : N/A
	public void NavigateToReceivableReportsClientInvoice(Log Log) throws InterruptedException {
		try {
			WebClickUsingJS(EdaatOR.Admin_Receivables_SubBillerReportLink); 
			Thread.sleep(800);
			if(CheckElementExists(EdaatOR.Admin_SubbillerReportPage)) {
				Log.ReportEvent("PASS", "Receivables Sub Billers Report page is displayed Successfully");				

			}
			else {
				Log.ReportEvent("FAIL", "Receivables Sub Billers Report page is not displayed Successfully");
				this.takeScreenShot();	
				driver.quit();Assert.fail();	
			}

		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Receivables Sub Billers Report page is not displayed Successfully");
			this.takeScreenShot();	
			driver.quit();Assert.fail();	
		}
	}
	
	//Function Summary  : Method to Verify Client Invoice Report Generate Functionality  
	//Parameter Summary : ClientType,ClientName,BillStatus,IdorCR,
	public void ReceivableReportsClientInvoice(Map<Object, Object> testdatamap,Log Log) { 
		try{
			NavigateReceivableReports();
			NavigateToReceivableReportsClientInvoice(Log );
			WebClickUsingJS(EdaatOR.Admin_ReceivablesReports_ClientInvoice_reportbtn);
			Thread.sleep(2000);
			if(CheckElementExists(EdaatOR.Admin_clientinvoiceReport)) {
				Log.ReportEvent("PASS", "Clients Invoices Report page is Loaded Successfully");				

			}
			else {
				Log.ReportEvent("FAIL", "Clients Invoices Report page is not Loaded Successfully");
				this.takeScreenShot();	
				driver.quit();Assert.fail();	
			}
			EnterFromdate(testdatamap);
			EnterTodate(testdatamap);
			selectDropdownValue_PartialText(EdaatOR.Admin_ReceivablesReports_ClientInvoice_ClientType,testdatamap.get("ClientType").toString());
			Thread.sleep(500);
			WebClick(EdaatOR.Admin_ClientNamearro);
			WebEdit(EdaatOR.Admin_ClientNametextbox, testdatamap.get("ClientName").toString());
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_ClientNameoption);
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Admin_ReceivablesReports_ClientInvoice_Billstatus,testdatamap.get("BillStatus").toString());
			Thread.sleep(500);
			WebEdit(EdaatOR.Admin_ReceivablesReports_ClientInvoice_ID_CR,testdatamap.get("IdorCR").toString());
			Thread.sleep(2000);
			WebClick(EdaatOR.Admin_ReceivablesReports_ClientInvoice_Generate);
			Thread.sleep(2000);
			switchTonextwindow();
			waitForPageToLoad();
			
			switchBacktoParentwindow();
			Thread.sleep(2000);
			WebClick(EdaatOR.Admin_ReceivablesReports_ClientInvoice_ExportExcel);
			scrollDowntillend(driver);
			if(CheckElementExists(EdaatOR.Admin_ReceivablesReports_ClientInvoice_Exportverify)) {
				Log.ReportEvent("PASS", "Verify Clients Invoices Report is Successful");				

			}
			else {
				Log.ReportEvent("FAIL", "Verify Clients Invoices Report is not Successful");
				this.takeScreenShot();	
				driver.quit();Assert.fail();	
			}
		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Verify Clients Invoices Report is not Successful");
			this.takeScreenShot();	
			driver.quit();Assert.fail();
		}

	}

	//Function Summary   : Method to  Navigate to OverDueBills
	//Parameter Summary  : N/A
	public void NavigateToOverDueBills(Log Log) throws InterruptedException {
		try {
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_Overduebills);
	        Thread.sleep(1000);
			if(CheckElementExists(EdaatOR.Admin_ReportsOverDueBills_Page)) {
				Log.ReportEvent("PASS", "Over Due Bills Report page is displayed Successfully");				

			}
			else {
				Log.ReportEvent("FAIL", "Over Due Bills Report page is not displayed Successfully");
				this.takeScreenShot();	
				driver.quit();Assert.fail();	
			}

		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Over Due Bills Report page is not displayed Successfully");
			this.takeScreenShot();	
			driver.quit();Assert.fail();	
		}
	}
	
	//Function Summary   : Method to  Verify Receivables Over due bills.
	//Parameter Summary  :Client Type,Client Name,Sub Biller Name,Reportname.
	public void OverDueBills(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {
		// TODO Auto-generated method stub
		try
		{
			NavigateToOverDueBills(Log);
			WebSelect(EdaatOR.Admin_Clienttypedrop,testdatamap.get("Client Type").toString());
			Thread.sleep(2000);
			selectClientname(testdatamap.get("Client Name").toString());		
			Thread.sleep(2000);
			selectSubiller(testdatamap.get("Sub Biller Name").toString());		
			Thread.sleep(2000);
			WebClick(EdaatOR.Admin_GenerateReportbtn);
			Thread.sleep(5000);
			waitForPageToLoad();
			switchToWindow();
			
			swithchToFrame(EdaatOR.Admin_Receframe);
			
			if(CheckElementExists(EdaatOR.Admin_ReportsOverDueBills)) {
				Log.ReportEvent("PASS", "Verify Over Due Bills Report is Successful");				

			}
			else {
				Log.ReportEvent("FAIL", "Verify Over Due Bills Report is not Successful");
				this.takeScreenShot();	
				driver.quit();Assert.fail();	
			}
			switchBacktoParentwindow();

		}
		catch(Exception e) {
			Log.ReportEvent("FAIL", "Verify Over Due Bills Report is not Successful");
			this.takeScreenShot();	
			driver.quit();Assert.fail();
		}
	}
	//Function Summary   : Method to select client name .
	//Parameter Summary  : N/A.
	public void selectClientname(String Cust) throws Exception
	{
		WebClick(EdaatOR.Admin_ClientNamedrop);
		Thread.sleep(2000);
		WebClick(EdaatOR.Admin_ReceClientName+"["+Cust+"]");
	}
	//Function Summary   : Method to select Subbiller name .
	//Parameter Summary  : N/A.
	public void selectSubiller(String Cust) throws Exception
	{
		WebClick(EdaatOR.Admin_Subbillerdrop);
		Thread.sleep(2000);
		WebClick(EdaatOR.Admin_ReceSubbillerName+"["+Cust+"]");
	}
	//Function Summary   : Method to select Subbiller name .
	//Parameter Summary  : N/A.
	public void selectSadedClientname(String Cust) throws Exception
	{
		WebClick(EdaatOR.Admin_ReceviableClientName);
		Thread.sleep(2000);
		WebClick(EdaatOR.Admin_ReceviableClientNameclick+"["+Cust+"]");
	}
	//Function Summary   : Method to select product name .
	//Parameter Summary  : N/A.
	public void selectSadedproductname(String Custm) throws Exception
	{
		WebClick(EdaatOR.Admin_Receviableproducts);
		Thread.sleep(3000);
		WebClickUsingActions(EdaatOR.Admin_Receviableproductsclick+"["+Custm+"]");
	}
	//Function Summary   : Method to  Verify Payment Transactions Report
	//Parameter Summary  : FromYear, FromMonth,ToYear,ToMonth.
	public void SelectDate(Map<Object,Object> testdatamap) throws InterruptedException
	{
		try {
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
			this.takeScreenShot();
		}
	}
	
	
	//Function Summary   : Method to  Navigate to SadedPaymentsReport
	//Parameter Summary  : N/A
	public void NavigateToSadedPaymentsReport(Log Log) throws InterruptedException {
		try {
			WebClickUsingJS(EdaatOR.Admin_ReceSadedPaymentRpt);
			Thread.sleep(2000);
			if(CheckElementExists(EdaatOR.Admin_ReceSadedPaymentRpt_Page)) {
				Log.ReportEvent("PASS", "Sadad Payments Transactions Report page is displayed Successfully");				

			}
			else {
				Log.ReportEvent("FAIL", "Sadad Payments Transactions Report page is not displayed Successfully");
				this.takeScreenShot();	
				driver.quit();Assert.fail();	
			}

		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Sadad Payments Transactions Report page is not displayed Successfully");
			this.takeScreenShot();	
			driver.quit();Assert.fail();	
		}
	}
	
	//Function Summary   : Method to  Verify Receivables Corporate Client reports.
	//Parameter Summary  : N/A
	public void VerifySadedPaymentsReport(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try{
			NavigateToSadedPaymentsReport(Log);
			WebSelect(EdaatOR.Admin_ReceInvoiceType,testdatamap.get("Invoice Type").toString());
			Thread.sleep(2000);
			WebEdit(EdaatOR.Admin_ReceInvoiceNumber,testdatamap.get("InvoiceNumber").toString());
			Thread.sleep(2000);
			WebEdit(EdaatOR.Admin_ReceInviceinternalcode,testdatamap.get("InvoiceInternal Type").toString());
			Thread.sleep(2000);
			WebSelect(EdaatOR.Admin_ReceClienttype,testdatamap.get("Client Type").toString());
			Thread.sleep(2000);
			selectSadedClientname(testdatamap.get("Client Name").toString());
			Thread.sleep(2000);
			SelectDate(testdatamap);
			Thread.sleep(2000);
			selectSadedproductname(testdatamap.get("Product Name").toString());
			Thread.sleep(2000);
			WebClick(EdaatOR.Admin_ReceSabGenBtn);
			waitForPageToLoad();
			switchToWindow();
			
			swithchToFrame(EdaatOR.Admin_Receframe);
			Thread.sleep(1000);
			if(getText("//div[text()='"+testdatamap.get("SadedPayment").toString()+"']").equals(testdatamap.get("SadedPayment").toString())) {
				Log.ReportEvent("PASS", "Verify Sadad Payments Transactions Report is Successful");				

			}
			else {
				Log.ReportEvent("FAIL", "Verify Sadad Payments Transactions Report is not Successful");
				this.takeScreenShot();	
				driver.quit();Assert.fail();	
			}
			switchBacktoParentwindow();

		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Verify Sadad Payments Transactions Report is not Successful");
			this.takeScreenShot();	
			driver.quit();Assert.fail();
		}
	}



	//Function Summary  : Method to Navigate to Client account statement.  
	//Parameter Summary : N/A
	public void navigatetoclientAccountStatement(Log Log) {
		try{
			WebClickUsingJS(EdaatOR.Biller_ReportMenu); 
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_ReceivablesReportsbtn); 
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_ReportClientaccountbtn); 
			if(CheckElementExists(EdaatOR.Admin_ClientAccount_ReportPage)) {
				Log.ReportEvent("PASS", "Client Account Statement page is Loaded Successfully");				

			}
			else {
				Log.ReportEvent("FAIL", "Client Account Statement page is not Loaded Successfully");
				this.takeScreenShot();	
				driver.quit();Assert.fail();	
			}
			
		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Client Account Statement page is not Loaded Successfully");
			this.takeScreenShot();	
			driver.quit();Assert.fail();
		}
	}
	//Function Summary  : Method to Select Client type
	//Parameter Summary : ClientType,Individual
	public void ClientType(Map<Object, Object> testdatamap) { 

		try{
			WebClick(EdaatOR.Admin_ClientType);
			String ele=testdatamap.get("ClientType").toString();
			if(ele.equalsIgnoreCase("Individual")) {
				selectDropdownValue_PartialText(EdaatOR.Admin_ClientTypeindvidutial,ele);
			}
			else {
				selectDropdownValue_PartialText(EdaatOR.Admin_ClientTypeCorporate,ele);
			}			

		}
		catch(Exception e){
//			test.log(Status.FAIL,"Generate Report and export" + driver.getTitle() +" * Generate Report and export FAIL * " );
//			this.takeScreenShot();
		}			
	}
	//Function Summary  : Method to Generate Client account Statement Report 
	//Parameter Summary : InvoiceContract,FromYear,FromMonth,ToYear,ToMonth,ToDate
	public void ClientAccountReports(Map<Object, Object> testdatamap,Log Log)
	{
		try{
			ClientType(testdatamap);
			Thread.sleep(2000);
			WebClick(EdaatOR.Admin_Client_name);
			Thread.sleep(1000);
			WebClickUsingActions(EdaatOR.Admin_Client_name_Option);
//			WebClickUsingActions("//li[text()='"+testdatamap.get("ClientName").toString()+"']");
			WebClick(EdaatOR.Admin_Reports_SubBiller_name);
			Thread.sleep(1000);
			WebClickUsingActions("//li[text()='"+testdatamap.get("SubbillerName").toString()+"']");
			Thread.sleep(1000);
			//		WebEdit(EdaatOR.Admin_Invoicecontract,testdatamap.get("InvoiceContract").toString());
			//		Thread.sleep(1000);
			WebClick(EdaatOR.Admin_ReportFromdate);
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Admin_reportFromYear,testdatamap.get("FromYear").toString());
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Admin_reportFromMonth,testdatamap.get("FromMonth").toString());
			Thread.sleep(1000);
			WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_ReportTodate);
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Admin_reportToyear,testdatamap.get("ToYear").toString());
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Admin_reportToMonth,testdatamap.get("ToMonth").toString());
			Thread.sleep(1000);
			WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");	
			Thread.sleep(1000);
			
			WebClick(EdaatOR.Admin_reportsearchbutton);
			Thread.sleep(1000);
			waitForPageToLoad();			       
			switchToWindow();
			
			swithchToFrame(EdaatOR.Admin_reportframe);
			if(CheckElementExists(EdaatOR.Admin_report)) {
				Log.ReportEvent("PASS", "Verify Client Account Statement is Successful");				

			}
			else {
				Log.ReportEvent("FAIL", "Verify Client Account Statement is not Successful");
				this.takeScreenShot();	
				driver.quit();Assert.fail();	
			}
			switchBacktoParentwindow();

		}

		catch(Exception e){
			Log.ReportEvent("FAIL", "Verify Client Account Statement is not Successful");
			this.takeScreenShot();	
			driver.quit();Assert.fail();	
		}			
	}

	//Function Summary  : Method to VerifyIndividualClientsReport
	//Parameter Summary : N/A
	public void VerifyIndividualClientsReport(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try{			
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_ReportsMenu);
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_Recevible_ReportMenu);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_individual_Report);
			waitForPageToLoad();
			Thread.sleep(4000);
			switchToWindow();
		
			swithchToFrame(EdaatOR.Admin_Recevible_Reportframe);
			Thread.sleep(2000);
			if(CheckElementExists(EdaatOR.Admin_Recevible_Report_IndVerify)) {
				Log.ReportEvent("PASS", "Verify Receivables Individual Clients Report is Successful");				

			}
			else {
				Log.ReportEvent("FAIL", "Verify Receivables Individual Clients is not Successful");
				this.takeScreenShot();	
				driver.quit();Assert.fail();	
			}
			Thread.sleep(2000);
			switchBacktoParentwindow();

		}catch(Exception e){
			Log.ReportEvent("FAIL", "Verify Receivables Individual Clients is not Successful");
			this.takeScreenShot();	
			driver.quit();Assert.fail();
		}

	}

	//Function Summary  : method to verify Error messages in Client Account Statement Report page
	//Parameter Summary : ExpectedResult
	public void VerifyClientAccountStatementReportErrorMsg(Map<Object,Object>testdatamap,Log Log) throws InterruptedException{
		{
			try {

				Thread.sleep(1000);
				WebClick(EdaatOR.Admin_Search_ReportBTn);
				
				if (ExistsCheck(EdaatOR.Admin_MandatoryErrorMsg)){	
					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_Report_FromDateErrMsg));
					Thread.sleep(500);
					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_Report_ClientIDErrMsg));
					Thread.sleep(500);
					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_Report_ClientTypeErrMsg));
					Log.ReportEvent("PASS", "Verify Receivables-Client Account Statement Report Error Message is Successful");

				}
				else {
					Log.ReportEvent("FAIL", "Verify Receivables-Client Account Statement Report Error Message is not Successful");
					this.takeScreenShot();	
					driver.quit();Assert.fail();				}

			} catch (Exception e) {
				Log.ReportEvent("FAIL", "Verify Receivables-Client Account Statement Report Error Message is not Successful");
				this.takeScreenShot();	
				driver.quit();Assert.fail();			}

		}
	}		 
}
