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
import com.azmqalabs.edaattestautomation.common.Log;
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
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.azmqalabs.edaattestautomation.testscripts.admin.AdminTrackerMgmToggleStatus;



public class AdminReportsAdminReportsPage extends BasePage
{

	public AdminReportsAdminReportsPage(WebDriver driver,ExtentTest test)
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

	//Function Summary   : Method to  Navigate to Admin reports.
	//Parameter Summary  : N/A
	public void NavigateTOAdminReports(Log Log) throws InterruptedException {
		Thread.sleep(3000);
		WebClickUsingJS(EdaatOR.Admin_Reports);
		Thread.sleep(800);
		WebClickUsingJS(EdaatOR.Admin_ReportsAdmin);
		Thread.sleep(2000);

	}
	
	//Function Summary   : Method to  Navigate to Super Biller Report
	//Parameter Summary  : N/A
	public void NavigateTOSuperBillerReport(Log Log) throws InterruptedException {
		try {
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_ReportsSuperbiller);
			Thread.sleep(2000);
			if(CheckElementExists(EdaatOR.Admin_Reports_superbiller)) {
				Log.ReportEvent("PASS", "Super Billers Report is displayed Successfully");				

			}
			else {
				Log.ReportEvent("FAIL", "Super Billers Report is not displayed Successfully");
				this.takeScreenShot();	
				driver.quit();Assert.fail();	
			}

		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Super Billers Report is not displayed Successfully");
			this.takeScreenShot();	
			driver.quit();Assert.fail();
		}

	}
	//Function Summary   : Method to  Verify SuperBiller Report
	//Parameter Summary  : BillerName, TrackedBillerName
	public void VerifySuperBillerReport(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			NavigateTOSuperBillerReport(Log);
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Admin_BillerNameDropdwn, testdatamap.get("BillerName").toString());
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_TrackedBillerDropdwn);
			Thread.sleep(1000);
			WebClick("//li[text()='"+testdatamap.get("TrackedBillerName").toString()+"']");
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_GenerateReportBtn);
			switchToWindow();
			swithchToFrame(EdaatOR.Admin_Corporate_Report);
			Thread.sleep(3000);
			if(CheckElementExists(EdaatOR.Admin_SuperBillerReport)) {
				Log.ReportEvent("PASS", "Verify Super Billers Report is Successful");				

			}
			else {
				Log.ReportEvent("FAIL", "Verify Super Billers Report is not Successful");
				this.takeScreenShot();	
				driver.quit();Assert.fail();	
			}
			switchBacktoParentwindow();

		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Verify Super Billers Report is not Successful");
			this.takeScreenShot();	
			driver.quit();Assert.fail();
		}
	}
	

	//Function Summary   : Method to  Navigate to OutsideEdaatPaymentReports
	//Parameter Summary  : N/A
	public void NavigateTOOutsideEdaatPaymentReports(Log Log) throws InterruptedException {
		try {
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_ReportsOutsidePaid);
			Thread.sleep(1000);
			if(CheckElementExists(EdaatOR.Admin_ReportsOutsidePaid_Page)) {
				Log.ReportEvent("PASS", "Outside Edaat Payment Report page is displayed Successfully");				

			}
			else {
				Log.ReportEvent("FAIL", "Outside Edaat Payment Report page is not displayed Successfully");
				this.takeScreenShot();	
				driver.quit();Assert.fail();	
			}

		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Outside Edaat Payment Report page is not displayed Successfully");
			this.takeScreenShot();	
			driver.quit();Assert.fail();
		}

	}
	//Function Summary   : Method to  Verify Outside Edaat Payment Report
	//Parameter Summary  : FromYear, FromMonth,FromDate,ToYear,ToMonth,ToDate,BillerName,
	public void VerifyOutsideEdaatPaymentReports(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			NavigateTOOutsideEdaatPaymentReports(Log);
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_ReportsFromCalender);
			selectDropdownValue_PartialText(EdaatOR.Admin_ReportsFromYear, testdatamap.get("FromYear").toString());
			selectDropdownValue_PartialText(EdaatOR.Admin_ReportsFromMonth, testdatamap.get("FromMonth").toString());
			WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
			Thread.sleep(800);
			WebClick(EdaatOR.Admin_ReportsToCalender);
			selectDropdownValue_PartialText(EdaatOR.Admin_ReportsFromYear, testdatamap.get("ToYear").toString());
			selectDropdownValue_PartialText(EdaatOR.Admin_ReportsFromMonth, testdatamap.get("ToMonth").toString());
			WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");
			Thread.sleep(800);
			selectDropdownValue_PartialText(EdaatOR.Admin_ReportBillerName, testdatamap.get("BillerName").toString());
			Thread.sleep(800);
			WebClick(EdaatOR.Admin_GenerateReport);
			switchToWindow();
			swithchToFrame(EdaatOR.Admin_Corporate_Report);
			Thread.sleep(3000);
			if(CheckElementExists(EdaatOR.Admin_Reports_PaymntTransaction_report)) {
				Log.ReportEvent("PASS", "Verify Outside Edaat Payment Report is Successful");				

			}
			else {
				Log.ReportEvent("FAIL", "Verify Outside Edaat Payment Report is not Successful");
				this.takeScreenShot();	
				driver.quit();Assert.fail();	
			}
			switchBacktoParentwindow();

		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Verify Outside Edaat Payment Report is not Successful");
			this.takeScreenShot();	
			driver.quit();Assert.fail();
		}
	}

	
	//Function Summary   : Method to  Navigate to BillerTransactionReport
	//Parameter Summary  : N/A
	public void NavigateTOBillerTransactionReport(Log Log) throws InterruptedException {
		try {
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_BillerTransaction);
			Thread.sleep(1000);
			if(CheckElementExists(EdaatOR.Admin_BillerTransactionReport_Page)) {
				Log.ReportEvent("PASS", "Billers Transactions Report page is displayed Successfully");				

			}
			else {
				Log.ReportEvent("FAIL", "Billers Transactions Report page is not displayed Successfully");
				this.takeScreenShot();	
				driver.quit();Assert.fail();	
			}

		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Billers Transactions Report page is not displayed Successfully");
			this.takeScreenShot();	
			driver.quit();Assert.fail();
		}

	}
	
	//Function Summary   : Method to  Verify Biller Transaction Report
	//Parameter Summary  : FromYear, FromMonth,ToYear,ToMonth,MainBiller,BillStatus,
	public void VerifyBillerTransactionReport(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			NavigateTOBillerTransactionReport(Log);
			Thread.sleep(800);
			selectDropdownValue_PartialText(EdaatOR.Admin_FromMonth, testdatamap.get("FromMonth").toString());
			selectDropdownValue_PartialText(EdaatOR.Admin_FromYear, testdatamap.get("FromYear").toString());
			WebClick(EdaatOR.Admin_ToMonth);
			WebSelect1(EdaatOR.Admin_ToMonth, testdatamap.get("ToMonth").toString());
			WebClick(EdaatOR.Admin_ToYear);
			WebSelect1(EdaatOR.Admin_ToYear, testdatamap.get("ToYear").toString());
			WebClick(EdaatOR.Admin_MainBiller);
			WebClick("//li[text()='"+testdatamap.get("MainBiller").toString()+"']");
			WebClick("//label[text()='"+testdatamap.get("BillStatus").toString()+"']");
			Thread.sleep(800);
			WebClick(EdaatOR.Admin_ReportPaymentMethod);
			WebClick("//li[text()='"+testdatamap.get("PaymentMethod").toString()+"']");
			WebClick(EdaatOR.Admin_Generatereport);
//			switchToWindow();
//			swithchToFrame(EdaatOR.Admin_Corporate_Report);
//			Thread.sleep(800);
//			WebEdit(EdaatOR.Admin_Report_PaymentID, testdatamap.get("PaymentID").toString());
//			Thread.sleep(800);
//			WebClick(EdaatOR.Admin_Report_VerifyPID);
			Thread.sleep(3000);
			waitForPageToLoad();
			switchToWindow();
			swithchToFrame(EdaatOR.Admin_Corporate_Report);
			Thread.sleep(2000);
			if(CheckElementExists(EdaatOR.Admin_ReportVerify)) {
				Log.ReportEvent("PASS", "Verify Billers Transactions Report is Successful");				

			}
			else {
				Log.ReportEvent("FAIL", "Verify Billers Transactions Report is not Successful");
				this.takeScreenShot();	
				driver.quit();Assert.fail();	
			}
			switchBacktoParentwindow();

		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Verify Billers Transactions Report is not Successful");
			this.takeScreenShot();	
			driver.quit();Assert.fail();	
		}
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

	//Function Summary  : Method to SelectDate
	//Parameter Summary : FromYear,FromMonth,FromDate,ToYear,ToMonth,ToDate
	public void SelectDate1(Map<Object,Object>testdatamap)
	{
		try {
			WebClick(EdaatOR.Admin_Reorts_monitor_Fromd);
			selectDropdownValue_PartialText(EdaatOR.Admin_Reorts_monitor_Fromyear,testdatamap.get("FromYear").toString());
			selectDropdownValue_PartialText(EdaatOR.Admin_Reorts_monitor_Fromon,testdatamap.get("FromMonth").toString());
			WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
			WebClick(EdaatOR.Admin_Reorts_monitor_Tod);
			selectDropdownValue_PartialText(EdaatOR.Admin_Reorts_monitor_Toyear,testdatamap.get("ToYear").toString());
			selectDropdownValue_PartialText(EdaatOR.Admin_Reorts_monitor_omon,testdatamap.get("ToMonth").toString());
			WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}

	}
	//Function Summary  : Method to EnterSearchitem
	//Parameter Summary : MainBiller
	public void EnterSearchitem(Map<Object, Object> testdatamap) throws Exception {

		WebClick(EdaatOR.Admin_Reorts_monitor_BillerName);
		Thread.sleep(1000);
		WebClickUsingActions("//li[text()='"+testdatamap.get("MainBiller").toString()+"']");
		Thread.sleep(1000);
		WebClick(EdaatOR.Admin_Reorts_monitor_srcbtn);
	}
	
	
	//Function Summary   : Method to  Navigate to CorporateClientsReport
	//Parameter Summary  : N/A
	public void NavigateTOCorporateClientsReport(Log Log) throws InterruptedException {
		try {
			Thread.sleep(2000);
			NavigateTOAdminReports(Log);
			WebClickUsingJS(EdaatOR.Admin_CorporateClientReportBTN);
			Thread.sleep(1000);
			if(CheckElementExists(EdaatOR.Admin_CorporateClientReport_Page)) {
				Log.ReportEvent("PASS", "Corporate Client Report Page is Successful");				

			}
			else {
				Log.ReportEvent("FAIL", "Corporate Client Report Page is not Successful");
				this.takeScreenShot();	
				driver.quit();Assert.fail();	
			}

		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Corporate Client Report Page is not Successful");
			this.takeScreenShot();	
			driver.quit();Assert.fail();	
		}
	}
	
	
	//Function Summary  : Method to Verify Corporate Clients Reports
	//Parameter Summary : BillerName
	public void VerifyCorporateClientsReport(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			NavigateTOCorporateClientsReport(Log);
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_CorporateClientBillerNameDropDown);
			WebClick("//li[text()='"+testdatamap.get("BillerName").toString()+"']");
			WebClick(EdaatOR.Admin_CorporateClientGenerateReportBTN);
			switchToWindow();
			swithchToFrame(EdaatOR.Admin_Corporate_Report);
			Thread.sleep(3000);
			if(CheckElementExists(EdaatOR.Admin_CorporateClientReport)) {
				Log.ReportEvent("PASS", "Verify Corporate Client Report is Successful");				

			}
			else {
				Log.ReportEvent("FAIL", "Verify Corporate Client Report is not Successful");
				this.takeScreenShot();	
				driver.quit();Assert.fail();	
			}
			switchBacktoParentwindow();

		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Verify Corporate Client Report is not Successful");
			this.takeScreenShot();	
			driver.quit();Assert.fail();
		}
	}

	//Function Summary   : Method to  Navigate to BillerMonitoringReport
	//Parameter Summary  : N/A
	public void NavigateToBillerMonitoringReport(Log Log) throws InterruptedException {
		try {
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_BillerMonitoring);
			Thread.sleep(1000);
			if(CheckElementExists(EdaatOR.Admin_Report_BillerMonitoringReport)) {
				Log.ReportEvent("PASS", "Biller Monitoring Report page is displayed Successfully");				

			}
			else {
				Log.ReportEvent("FAIL", "Biller Monitoring Report page is not displayed Successfully");
				this.takeScreenShot();	
				driver.quit();Assert.fail();	
			}

		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Biller Monitoring Report page is not displayed Successfully");
			this.takeScreenShot();	
			driver.quit();Assert.fail();	
		}
	}
	
	//Function Summary  : Method to EnterSearchitem
	//Parameter Summary : MainBiller
	public void VerifyBillerMonitoringReport(Map<Object, Object> testdatamap,Log Log)
	{
		try {
			NavigateToBillerMonitoringReport(Log);
			Thread.sleep(1000);
			SelectDate1(testdatamap);
			WebClick(EdaatOR.Admin_ReportPaymentMethod);
			WebClick("//li[text()='"+testdatamap.get("PaymentMethod").toString()+"']");
			EnterSearchitem(testdatamap);
//			Thread.sleep(800);
//			switchToWindow();
//			swithchToFrame(EdaatOR.Admin_Corporate_Report);
//			Thread.sleep(800);
//			WebEdit(EdaatOR.Admin_Report_PaymentID, testdatamap.get("PaymentID").toString());
//			Thread.sleep(800);
//			WebClick(EdaatOR.Admin_Report_VerifyPID);
			Thread.sleep(3000);
			waitForPageToLoad();
			switchToWindow();
			swithchToFrame(EdaatOR.Admin_Corporate_Report);
			Thread.sleep(2000);
			if(CheckElementExists(EdaatOR.Admin_Report_VerifyBillerMonitoringReport)) {
				Log.ReportEvent("PASS", "Verify Biller Monitoring Report is Successful");				

			}
			else {
				Log.ReportEvent("FAIL", "Verify Biller Monitoring Report is not Successful");
				this.takeScreenShot();	
				driver.quit();Assert.fail();	
			}
			switchBacktoParentwindow();
			Thread.sleep(1000);

		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "Verify Biller Monitoring Report is not Successful");
			this.takeScreenShot();	
			driver.quit();Assert.fail();
		}

	}

	
	//Function Summary   : Method to  Navigate to SubBillersReport
	//Parameter Summary  : N/A
	public void NavigateToSubBillersReport(Log Log) throws InterruptedException {
		try {
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_Reports_SubbillerReportMenu);
			Thread.sleep(1000);
			if(CheckElementExists(EdaatOR.Admin_SubbillerReportPage)) {
				Log.ReportEvent("PASS", "Sub biller Report Page is loaded Successfully");				

			}
			else {
				Log.ReportEvent("FAIL", "Sub biller Report Page is not loaded Successfully");
				this.takeScreenShot();	
				driver.quit();Assert.fail();	
			}

		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Sub biller Report Page is not loaded Successfully");
			this.takeScreenShot();	
			driver.quit();Assert.fail();	
		}
	}
	
	//Function Summary   : Method to  Verify Sub Billers Report
	//Parameter Summary  : BillerName,CRNumber
	public void VerifySubBillersReport(Map<Object, Object> testdatamap,Log Log) {
		try {
			NavigateToSubBillersReport(Log);
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Admin_SubbillerReport_BillerNameDropdwn, testdatamap.get("BillerName").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_SubbillerReport_CRNumberfield, testdatamap.get("CRNumber").toString());
			WebClickUsingJS(EdaatOR.Admin_SubbillerReport_GenerateReportBtn);
			switchToWindow();
			swithchToFrame(EdaatOR.Admin_Corporate_Report);
			Thread.sleep(3000);
			if(CheckElementExists(EdaatOR.Admin_SubbillerReportverify)) {
				Log.ReportEvent("PASS", "Verify Sub biller Report is Successful");				

			}
			else {
				Log.ReportEvent("FAIL", "Verify Sub biller Report is not Successful");
				this.takeScreenShot();	
				driver.quit();
				Assert.fail();	
			}
			switchBacktoParentwindow();

		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Verify Sub biller Report is not Successful");
			this.takeScreenShot();	
			driver.quit();
			Assert.fail();
		}
	}

	
	//Function Summary   : Method to  Navigate to ClientTypeReports
	//Parameter Summary  : N/A
	public void NavigateToClientTypeReports(Log Log) throws InterruptedException {
		try {
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_Reports_ClientsTypeReportMenu);
			Thread.sleep(1000);
			if(CheckElementExists(EdaatOR.Admin_Report_ClientTypePage)) {
				Log.ReportEvent("PASS", "Clients Type Report page is Loaded Successfully");				

			}
			else {
				Log.ReportEvent("FAIL", "Clients Type Report page is not Loaded Successfully");
				this.takeScreenShot();	
				driver.quit();Assert.fail();	
			}

		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Clients Type Report page is not Loaded Successfully");
			this.takeScreenShot();	
			driver.quit();Assert.fail();	
		}
	}
	
	//Function Summary   : Method to  Verify ClientType Reports
	//Parameter Summary  : FromMonth,FromYear,ToMonth,ToYear,ClientType,MainBiller,BillStatus
	public void VerifyClientsTypersReport(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {
		try {
			NavigateToClientTypeReports(Log );
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Admin_FromMonth, testdatamap.get("FromMonth").toString());
			selectDropdownValue_PartialText(EdaatOR.Admin_FromYear, testdatamap.get("FromYear").toString());
			WebClick(EdaatOR.Admin_ToMonth);
			WebSelect1(EdaatOR.Admin_ToMonth, testdatamap.get("ToMonth").toString());
			WebClick(EdaatOR.Admin_ToYear);
			WebSelect1(EdaatOR.Admin_ToYear, testdatamap.get("ToYear").toString());
			WebClick(EdaatOR.Admin_clientType);
			WebSelect1(EdaatOR.Admin_clientType, testdatamap.get("ClientType").toString());
			WebSelect1(EdaatOR.ClientsPayablesBillerNameDropdown,testdatamap.get("MainBiller").toString());
			Thread.sleep(800);
			WebClick("//label[text()='"+testdatamap.get("BillStatus").toString()+"']");
			Thread.sleep(800);
			WebClick(EdaatOR.Admin_ReportClientTypePaymentMethod);
			WebClick("//option[text()='"+testdatamap.get("PaymentMethod").toString()+"']");
			Thread.sleep(800);
			WebClick(EdaatOR.Admin_Generatereport);
//			switchToWindow();
//			swithchToFrame(EdaatOR.Admin_Corporate_Report);
//			Thread.sleep(800);
//			WebEdit(EdaatOR.Admin_Report_PaymentID, testdatamap.get("PaymentID").toString());
//			Thread.sleep(800);
//			WebClick(EdaatOR.Admin_Report_VerifyPID);
			waitForPageToLoad();
			Thread.sleep(3000);
			switchToWindow();
			swithchToFrame(EdaatOR.Admin_Corporate_Report);
			Thread.sleep(2000);
			if(CheckElementExists(EdaatOR.Admin_ClientTypeReporttext)) {
				Log.ReportEvent("PASS", "Verify Clients Type Report is Successful");				

			}
			else {
				Log.ReportEvent("FAIL", "Verify Clients Type Report is not Successful");
				this.takeScreenShot();	
				driver.quit();Assert.fail();	
			}
			switchBacktoParentwindow();

		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Verify Clients Type Report is not Successful");
			this.takeScreenShot();	
			driver.quit();Assert.fail();
		}
	}

	//Function Summary   : Method to  Navigate to PaymentTransactionsReport
	//Parameter Summary  : N/A
	public void NavigateToPaymentTransactionsReport(Log Log) throws InterruptedException {
		try {
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Reports_PaymntTransactionlink);
			Thread.sleep(1000);
			if(CheckElementExists(EdaatOR.Admin_Reports_PaymntTransactionReport_Page)) {
				Log.ReportEvent("PASS", "Payment Transactions & Operation Fees Report page is displayed Successfully");				

			}
			else {
				Log.ReportEvent("FAIL", "Payment Transactions & Operation Fees Report page is not displayed Successfully");
				this.takeScreenShot();	
				driver.quit();Assert.fail();	
			}


		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Payment Transactions & Operation Fees Report page is not displayed Successfully");
			this.takeScreenShot();	
			driver.quit();Assert.fail();
		}
	}
	
	//Function Summary   : Method to  Verify Payment Transactions Report
	//Parameter Summary  :MainBiller.
	public void VerifyPaymentTransactionsReport(Map<Object,Object> testdatamap,Log Log) throws InterruptedException
	{
		try {
			Thread.sleep(2000);
			NavigateTOAdminReports(Log);
			NavigateToPaymentTransactionsReport(Log);
			Thread.sleep(2000);
			SelectDate(testdatamap);
			Thread.sleep(2000);
			WebClick(EdaatOR.Admin_Reports_PaymntTransaction_MainBlr);
			WebClick("//li[text()='"+testdatamap.get("Main Biller").toString()+"']");
			WebClick(EdaatOR.Admin_ReportPaymentMethod);
			WebClick("//li[text()='"+testdatamap.get("PaymentMethod").toString()+"']");
			WebClickUsingJS(EdaatOR.Admin_Reports_PaymntTransaction_generate);
//			switchToWindow();
//			swithchToFrame(EdaatOR.Admin_Corporate_Report);
//			Thread.sleep(800);
//			WebEdit(EdaatOR.Admin_Report_PaymentID, testdatamap.get("PaymentID").toString());
//			Thread.sleep(800);
//			WebClick(EdaatOR.Admin_Report_VerifyPID);
			waitForPageToLoad();
			Thread.sleep(3000);
			switchToWindow();
			swithchToFrame(EdaatOR.Admin_Corporate_Report);
			Thread.sleep(2000);
			if(CheckElementExists(EdaatOR.Admin_Reports_PaymntTransactionReport)) {
				Log.ReportEvent("PASS", "Verify Payment Transactions & Operation Fees Report is Successful");				

			}
			else {
				Log.ReportEvent("FAIL", "Verify Payment Transactions & Operation Fees Report is not Successful");
				this.takeScreenShot();	
				driver.quit();Assert.fail();	
			}
			switchBacktoParentwindow();

		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Verify Payment Transactions & Operation Fees Report is not Successful");
			this.takeScreenShot();	
			driver.quit();Assert.fail();

		}	
	}
	
	
	//Function Summary   : Method to  Verify Blocked Corporate Client Report
	//Parameter Summary  :NA
	public void VerifyBlockedCorporateClientReport(Log Log) throws InterruptedException
	{
		try {
			Thread.sleep(2000);
			NavigateTOAdminReports(Log);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_Reports_Blockedcorporatelnk);
			switchToWindow();
			swithchToFrame(EdaatOR.Admin_Corporate_Report);
			Thread.sleep(3000);
			if(CheckElementExists(EdaatOR.Admin_Reports_BlockedcorporateVerify)) {
				Log.ReportEvent("PASS", "Verify Blocked Corporate Client Report is Successful");				

			}
			else {
				Log.ReportEvent("FAIL", "Verify Blocked Corporate Client Report is not Successful");
				this.takeScreenShot();	
				driver.quit();Assert.fail();	
			}
			switchBacktoParentwindow();

		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Verify Blocked Corporate Client Report is not Successful");
			this.takeScreenShot();	
			driver.quit();Assert.fail();  
		}
	}

	//Function Summary  : Method to VerifyBlockedIndividualClientReport
	//Parameter Summary : N/A
	public void VerifyBlockedIndividualClientReport(Map<Object, Object> testdatamap,Log Log) {

		try
		{Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_Rport_Blocked_IndivReport);
			Thread.sleep(1000);
			switchTonextwindow();
			Thread.sleep(1000);
			swithchToFrame(EdaatOR.Admin_Rport_Blocked_IndivReportframe);
			Thread.sleep(3000);
			if(CheckElementExists(EdaatOR.Admin_Rport_Blocked_IndivReportverify)) {
				Log.ReportEvent("PASS", "Verify Blocked Individual Client Report is Successful");				

			}
			else {
				Log.ReportEvent("FAIL", "Verify Blocked Individual Client Report is not Successful");
				this.takeScreenShot();	
				driver.quit();Assert.fail();	
			}
			switchBacktoParentwindow();

		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "Verify Blocked Individual Client Report is not Successful");
			this.takeScreenShot();	
			driver.quit();Assert.fail();
		}
	}

	//Function Summary  : Method to VerifyIndividualClientReport
	//Parameter Summary : MainBiller,NationalityName
	public void VerifyIndividualClientReport(Map<Object, Object> testdatamap) {

		try
		{Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_IndivReport);
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_Reorts_Indiv_BillerName);
			Thread.sleep(1000);
			WebClick("//li[text()='"+testdatamap.get("MainBiller").toString()+"']");
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Admin_Reorts_Indiv_NationalityName,testdatamap.get("NationalityName").toString());
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_Reorts_Indiv_srcbtn);
			switchToWindow();
			swithchToFrame(EdaatOR.Admin_Corporate_Report);
			Thread.sleep(3000);
			verifyElementIsPresent(EdaatOR.Admin_Reorts_monitor_verify);
			
			switchBacktoParentwindow();
			test.log(Status.PASS,"Verify  Individual Clients Report" + driver.getTitle() +" *  Individual Clients Report PASS * " );
			this.takeScreenShot();
		}
		catch (Exception e) {

			test.log(Status.FAIL,"Verify Blocked Individual Clients Report" + driver.getTitle() +" * Blocked Individual Clients Report FAIL * " );
			this.takeScreenShot();
		}
	}
	
	//Function Summary   : Method to  Navigate to IndividualClientReport
	//Parameter Summary  : N/A
	public void NavigateToIndividualClientReport(Log Log) throws InterruptedException {
		try {
			Thread.sleep(3000);
			WebClickUsingJS(EdaatOR.Admin_IndivClientReport);
			Thread.sleep(1000);
			if(CheckElementExists(EdaatOR.Admin_IndivClientReport_Page)) {
				Log.ReportEvent("PASS", "Individual Client Report page is displayed Successfully");				

			}
			else {
				Log.ReportEvent("FAIL", "Individual Client Report page is not displayed Successfully");
				this.takeScreenShot();	
				driver.quit();Assert.fail();	
			}

		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Individual Client Report page is not displayed Successfully");
			this.takeScreenShot();	
			driver.quit();Assert.fail();	
		}
	}
	
	//Function Summary   : Method to generate Individual Client Report.
	//Parameter Summary  : BillerName, NationalityName.
	public void IndividualClientReport(Map<Object, Object> testdatamap,Log Log) {
		// TODO Auto-generated method stub
		try {	
			NavigateToIndividualClientReport(Log);
			WebClick(EdaatOR.Admin_ClickBillerName);	
			WebClick("//ul/li[text()='"+testdatamap.get("BillerName").toString()+"']");
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_ClickNationalityName);
			Thread.sleep(1000);
			WebClick("//option[text()='"+testdatamap.get("NationalityName").toString()+"']");
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_GenerateReportBtn);
			switchToWindow();
			swithchToFrame(EdaatOR.Admin_Corporate_Report);
			Thread.sleep(3000);
			if(CheckElementExists(EdaatOR.Admin_IndClientReport)) {
				Log.ReportEvent("PASS", "Verify Individual Client Report is Successful");				

			}
			else {
				Log.ReportEvent("FAIL", "Verify Individual Client Report is not Successful");
				this.takeScreenShot();	
				driver.quit();Assert.fail();	
			}
			switchBacktoParentwindow();

		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Verify Individual Client Report is not Successful");
			this.takeScreenShot();	
			driver.quit();Assert.fail();
		}
	}
	
	
	//Function Summary   : Method to  Navigate to TicketSizeReport
	//Parameter Summary  : N/A
	public void NavigateToTicketSizeReport(Log Log) throws InterruptedException {
		try {
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_Ticketsize);
			Thread.sleep(1000);	
			if(CheckElementExists(EdaatOR.Admin_TicketReportPage)) {
				Log.ReportEvent("PASS", "Ticket Size Report page is loaded Successfully");				

			}
			else {
				Log.ReportEvent("FAIL", "Ticket Size Report page is not loaded Successfully");
				this.takeScreenShot();	
				driver.quit();Assert.fail();	
			}

		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Ticket Size Report page is not loaded Successfully");
			this.takeScreenShot();	
			driver.quit();Assert.fail();		
		}
	}
	
	//Function Summary   : Method to generate Ticket Size report under Admin Reports.
	//Parameter Summary  : FromYear, FromMonth,ToYear,ToMonth,MainBiller,BillStatus,Ticket Size.
	public void TicketSizeReport(Map<Object, Object> testdatamap,Log Log) {
		// TODO Auto-generated method stub
		try {
			NavigateToTicketSizeReport(Log );
			selectDropdownValue_PartialText(EdaatOR.Admin_FromMonth, testdatamap.get("FromMonth").toString());
			selectDropdownValue_PartialText(EdaatOR.Admin_FromYear, testdatamap.get("FromYear").toString());
			WebClick(EdaatOR.Admin_ToMonth);
			WebSelect1(EdaatOR.Admin_ToMonth, testdatamap.get("ToMonth").toString());
			WebClick(EdaatOR.Admin_ToYear);
			WebSelect1(EdaatOR.Admin_ToYear, testdatamap.get("ToYear").toString());
			WebClick(EdaatOR.Admin_ClickTicketsize);
			WebClick("//option[text()='"+ testdatamap.get("Ticket Size").toString()+"']");
			WebClick(EdaatOR.Client_ClientAccountStatement_BillerName);
			WebClick("//option[text()='"+testdatamap.get("MainBiller").toString()+"']");
			WebClick("//label[text()='"+testdatamap.get("BillStatus").toString()+"']");
			Thread.sleep(2000);
			WebClick(EdaatOR.Admin_ReportClientTypePaymentMethod);
			WebClick("//option[text()='"+testdatamap.get("PaymentMethod").toString()+"']");
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_Generatereport);
//			switchToWindow();
//			swithchToFrame(EdaatOR.Admin_Corporate_Report);
//			Thread.sleep(800);
//			WebEdit(EdaatOR.Admin_Report_PaymentID, testdatamap.get("PaymentID").toString());
//			Thread.sleep(800);
//			WebClick(EdaatOR.Admin_Report_VerifyPID);
			waitForPageToLoad();
			Thread.sleep(2000);
			switchToWindow();
			swithchToFrame(EdaatOR.Admin_Corporate_Report);
			Thread.sleep(3000);
			if(CheckElementExists(EdaatOR.Admin_TicketReportVerify)) {
				Log.ReportEvent("PASS", "Verify Ticket Size Report is Successful");				

			}
			else {
				Log.ReportEvent("FAIL", "Verify Ticket Size Report is not Successful");
				this.takeScreenShot();	
				driver.quit();Assert.fail();	
			}
			switchBacktoParentwindow();

		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Verify Ticket Size Report is not Successful");
			this.takeScreenShot();	
			driver.quit();Assert.fail();
		}
	}

	//Function Summary  : Method to CorporateBilllersReport
	//Parameter Summary : N/A
	public void VerifyCorporateBilllersReport(Log Log) throws InterruptedException {
		try {
			Thread.sleep(2000);
			WebClick(EdaatOR.Admin_Corporate_Billers_Report);

			switchToWindow();
			swithchToFrame(EdaatOR.Admin_Corporate_Report);
			Thread.sleep(3000);
			if(CheckElementExists(EdaatOR.Admin_Corporate_verifyReport)) {
	        	Log.ReportEvent("PASS", "Verify Corporate Billers Report is successful");

			}
			else {
	        	Log.ReportEvent("FAIL", "Verify Corporate Billers Report is not successful");
				this.takeScreenShot();	
				driver.quit();Assert.fail();	
			}
			switchBacktoParentwindow();
		}
		catch (Exception e) {
        	Log.ReportEvent("FAIL", "Verify Corporate Billers Report is not successful");
			this.takeScreenShot();	
			driver.quit();Assert.fail();
		}		
	}	

	//Function Summary  : method to verify Error messages in Sub Biller Report page
	//Parameter Summary : ExpectedResult
	public void VerifySubBillesrReportErrorMsg(Map<Object,Object>testdatamap,Log Log) throws InterruptedException{
		{
			try {

				Thread.sleep(1000);
				WebClick(EdaatOR.Admin_Generate_ReportBTn);
				
				if (testdatamap.get("ExpectedResult").toString().equals(getText(EdaatOR.Admin_MandatoryFeild_ReportErrMsg))){	
		        	Log.ReportEvent("PASS", "Verify Sub Biller Report is successful");

				}
				else {
		        	Log.ReportEvent("FAIL", "Verify Sub Biller Report is not successful");
					this.takeScreenShot();	
					driver.quit();Assert.fail();
				}

			} catch (Exception e) {
	        	Log.ReportEvent("FAIL", "Verify Sub Biller Report is not successful");
				this.takeScreenShot();	
				driver.quit();Assert.fail();			}

		}
	}


	//Function Summary  : method to verify Error messages in Individual client Report page
	//Parameter Summary : ExpectedResult
	public void VerifyIndividualClientReportErrorMsg(Map<Object,Object>testdatamap,Log Log) throws InterruptedException{
		{
			try {

				Thread.sleep(1000);
				WebClick(EdaatOR.Admin_Generate_ReportBTn);
				
				if (testdatamap.get("ExpectedResult").toString().equals(getText(EdaatOR.Admin_MandatoryFeild_ReportErrMsg))){	
		        	Log.ReportEvent("PASS", "Verify Individual client Report Error message is successful");

				}
				else {
		        	Log.ReportEvent("FAIL", "Verify Individual Client Report Error message is not successful");
					this.takeScreenShot();	
					driver.quit();Assert.fail();
				}

			} catch (Exception e) {
	        	Log.ReportEvent("FAIL", "Verify Individual Client Report Error message is not successful");
				this.takeScreenShot();	
				driver.quit();Assert.fail();			}

		}
	}
	//Function Summary  : method to verify Error messages in Corporate client Report page
	//Parameter Summary : ExpectedResult
	public void VerifyCorporateClientReportErrorMsg(Map<Object,Object>testdatamap,Log Log) throws InterruptedException{
		{
			try {

				Thread.sleep(1000);
				WebClick(EdaatOR.Admin_Generate_ReportBTn);
				
				if (testdatamap.get("ExpectedResult").toString().equals (getText(EdaatOR.Admin_MandatoryFeild_ReportErrMsg))){	
					Log.ReportEvent("PASS", "Verify Corporate client Report error Message is successful");

				}
				else {
					Log.ReportEvent("FAIL", "Verify Corporate client Report error Message is not successful");
					this.takeScreenShot();
					driver.quit();Assert.fail();
				}

			} catch (Exception e) {
				Log.ReportEvent("FAIL", "Verify Corporate client Report error Message is not successful");
				this.takeScreenShot();
				driver.quit();Assert.fail();			}

		}
	}

	//Function Summary  : method to verify Error messages in Outside Edaat Payments Report page
	//Parameter Summary : ExpectedResult
	public void VerifyOutsideEdaatPaymentsReportErrorMsg(Map<Object,Object>testdatamap,Log Log) throws InterruptedException{
		{
			try {
	
				Thread.sleep(1000);
				WebClick(EdaatOR.Admin_Generate_ReportBTn);
				
				if (testdatamap.get("ExpectedResult").toString().equals(getText(EdaatOR.Admin_MandatoryFeild_ReportErrMsg))){	
					Log.ReportEvent("PASS", "Verify Outside Edaat Payments Report Error Message is successful");

				}
				else {
					Log.ReportEvent("FAIL", "Verify Outside Edaat Payments Report Error Message is not successful");
					this.takeScreenShot();
					driver.quit();Assert.fail();
				}

			} catch (Exception e) {
				Log.ReportEvent("FAIL", "Verify Outside Edaat Payments Report Error Message is not successful");
				this.takeScreenShot();
				driver.quit();Assert.fail();			}

		}
	}

	//Function Summary  : method to verify Error messages in Biller Transaction Report page
	//Parameter Summary : ExpectedResult
	public void VerifyBillerTransactionReportErrorMsg(Map<Object,Object>testdatamap,Log Log) throws InterruptedException{
		{
			try {
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_Generate_ReportBTn);
				
				if (ExistsCheck(EdaatOR.Admin_MandatoryErrorMsg)){	

					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_Report_FromMonthErrMsg));
					Thread.sleep(500);
					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_Report_FromYearErrMsg));
					Thread.sleep(500);
					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_Report_ToMonthErrMsg));
					Thread.sleep(500);
					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_Report_ToYearErrMsg));
					Log.ReportEvent("PASS", "Verify Biller Transaction Report error Message is successful");
				}
				else {
					Log.ReportEvent("FAIL", "Verify Biller Transaction Report error Message is not successful");
					this.takeScreenShot();
					driver.quit();Assert.fail();
				}

			} catch (Exception e) {
				Log.ReportEvent("FAIL", "Verify Biller Transaction Report error Message is not successful");
				this.takeScreenShot();
				driver.quit();Assert.fail();
				}

		}
	}

	//Function Summary  : method to verify Error messages in Clients Type Report page
	//Parameter Summary : ExpectedResult
	public void VerifyClientsTypeReportErrorMsg(Map<Object,Object>testdatamap,Log Log) throws InterruptedException{
		{
			try {

				Thread.sleep(500);
				WebClick(EdaatOR.Admin_Generate_ReportBTn);
				
				if (ExistsCheck(EdaatOR.Admin_MandatoryErrorMsg)){	

					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_Report_FromMonthErrMsg));
					Thread.sleep(500);
					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_Report_FromYearErrMsg));
					Thread.sleep(500);
					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_Report_ToMonthErrMsg));
					Thread.sleep(500);
					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_Report_ToYearErrMsg));
					Thread.sleep(500);
					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_Report_ClientTypeErrMsg));
					Log.ReportEvent("PASS", "Verify Clients Type Report error Message is successful");

				}
				else {
					Log.ReportEvent("FAIL", "Verify Clients Type Report error Message is not successful");
					this.takeScreenShot();
					driver.quit();Assert.fail();
				}

			} catch (Exception e) {
				Log.ReportEvent("FAIL", "Verify Clients Type Report error Message is not successful");
				this.takeScreenShot();
				driver.quit();Assert.fail();			}

		}
	}

	//Function Summary  : method to verify Error messages in Ticket Size Report page
	//Parameter Summary : ExpectedResult
	public void VerifyTicketSizeReportErrorMsg(Map<Object,Object>testdatamap,Log Log) throws InterruptedException{
		{
			try {

				Thread.sleep(500);
				WebClick(EdaatOR.Admin_Generate_ReportBTn);
				
				if (ExistsCheck(EdaatOR.Admin_MandatoryErrorMsg)){	

					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_Report_FromMonthErrMsg));
					Thread.sleep(500);
					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_Report_FromYearErrMsg));
					Thread.sleep(500);
					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_Report_ToMonthErrMsg));
					Thread.sleep(500);
					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_Report_ToYearErrMsg));
					Thread.sleep(500);
					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_Report_TicketSizeErrMsg));
					Log.ReportEvent("PASS", "Verify Ticket Size Report error Message is successful");

				}
				else {
					Log.ReportEvent("FAIL", "Verify Ticket Size Report error Message is not successful");
					this.takeScreenShot();
					driver.quit();Assert.fail();
				}

			} catch (Exception e) {
				Log.ReportEvent("FAIL", "Verify Ticket Size Report error Message is not successful");
				this.takeScreenShot();
				driver.quit();Assert.fail();			}

		}
	}
	
	//Function Summary  : method to verify Error messages in Payment Transactions & Operation Fees Report page
	//Parameter Summary : ExpectedResult
	public void VerifyPaymentTransactionReportErrorMsg(Map<Object,Object>testdatamap,Log Log) throws InterruptedException{
		{
			try {

				Thread.sleep(1000);
				WebClick(EdaatOR.Admin_Generate_ReportBTn);
				
				if (testdatamap.get("ExpectedResult").toString().equals (getText(EdaatOR.Admin_Report_PaymentTransactionErrMsg))){	
					Log.ReportEvent("PASS", "Verify Payment Transactions & Operation Fees error Message is successful");

				}
				else {
					Log.ReportEvent("FAIL", "Verify Payment Transactions & Operation Fees Report error Message is not successful");
					this.takeScreenShot();
					driver.quit();Assert.fail();
				}

			} catch (Exception e) {
				Log.ReportEvent("FAIL", "Verify Payment Transactions & Operation Fees Report error Message is not successful");
				this.takeScreenShot();
				driver.quit();Assert.fail();			}

		}
	}	

	//Function Summary  : method to verify Error messages in Biller Monitoring Report page
	//Parameter Summary : ExpectedResult
	public void VerifyBillerMonitoringReportErrorMsg(Map<Object,Object>testdatamap,Log Log) throws InterruptedException{
		{
			try {
				Thread.sleep(1000);
				WebClick(EdaatOR.Admin_Generate_ReportBTn);
				if (ExistsCheck(EdaatOR.Admin_MandatoryErrorMsg)){	

					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_Report_FromDateErrMsg));
					Thread.sleep(500);
					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_ToDateErrorMsg));
					Thread.sleep(500);
					VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_MandatoryFeild_ReportErrMsg));
					Thread.sleep(500);
			
					Log.ReportEvent("PASS", "Verify Biller Monitoring Report error Message is successful");

				}
				else {
					Log.ReportEvent("FAIL", "Verify Biller Monitoring Report error Message is not successful");
					this.takeScreenShot();
					driver.quit();Assert.fail();
				}

			} catch (Exception e) {
				Log.ReportEvent("FAIL", "Verify Biller Monitoring Report error Message is not successful");
				this.takeScreenShot();
				driver.quit();Assert.fail();			}

		}
	}	
}
