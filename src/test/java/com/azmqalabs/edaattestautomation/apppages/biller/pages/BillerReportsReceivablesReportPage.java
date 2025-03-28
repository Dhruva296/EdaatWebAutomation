package com.azmqalabs.edaattestautomation.apppages.biller.pages;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.remote.server.handler.SwitchToFrame;
import org.openqa.selenium.remote.server.handler.SwitchToParentFrame;
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

public class BillerReportsReceivablesReportPage extends BasePage {

	public BillerReportsReceivablesReportPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.Biller_Client)
	public WebElement Client;

	public boolean Exists() {
		return super.Exists(Client);
	}

	public void VerifyIndividualClientsReport(Map<Object, Object> testdatamap, Log Log) throws Exception {
		try {
			WebClick(EdaatOR.Biller_ReportsMenu);
			Thread.sleep(1000);
			WebClick(EdaatOR.Biller_Recevible_ReportMenu);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_individual_Report);
			Thread.sleep(2000);
			driver.navigate().back();
			// Thread.sleep(2000);

			test.log(Status.PASS, "Delete User from userlist and IsDelete User check box" + driver.getTitle()
					+ " * User Management PASS * ");
			Log.ReportEvent("PASS", " Verify IndividualClientReport");
			this.takeScreenShot();
		} catch (Exception e) {
			test.log(Status.FAIL, "Toggle Click" + driver.getTitle() + " * Toggle Click FAIL * ");
			this.takeScreenShot();
		}

	}

	// Function Summary : Method to Navigate to Client account statement.
	// Parameter Summary : N/A
	public void navigatetoclientAccountStatement(Log Log) {
		try {
			WebClickUsingJS(EdaatOR.Biller_ReportMenu);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_ReceivablesReportsbtn);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_ReportClientaccountbtn);
			Thread.sleep(1000);
			if (ExistsCheck(EdaatOR.Biller_ReportClientaccountStatement_Page)) {
				Log.ReportEvent("PASS", "Client Account Statement Page is Loaded Successfully");
			} else {
				Log.ReportEvent("FAIL", "Client Account Statement Page is not Loaded Successfully");
				takeScreenShot();
				driver.quit();
				Assert.fail();

			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Client Account Statement Page is not Loaded Successfully");
			takeScreenShot();
			driver.quit();
			Assert.fail();

		}

	}

	// Function Summary : Method to Generate Client account Statement Report.
	// Parameter Summary : Invoice
	// Contract,FromYear,FromMonth,ToYear,ToMonth,ToDate.
	public void ClientAccountReports(Map<Object, Object> testdatamap, Log Log) {
		try {
			navigatetoclientAccountStatement(Log);
			ClientType(testdatamap);
			Thread.sleep(1000);
			SelectClient(testdatamap.get("ClientName").toString());
			// WebClick(EdaatOR.Biller_SelectSubbillertype);
			Thread.sleep(1000);
			WebSelect(EdaatOR.Biller_SubbillerTypeindvidutial, testdatamap.get("SubBiller").toString());
			Thread.sleep(2000);
			WebClick(EdaatOR.Biller_Report_ClientAccount_SelectSubbillerName);
			Thread.sleep(2000);
			WebClickUsingJS("//li[text()='" + (testdatamap.get("SubbillerName").toString()) + "']");
			// WebEdit(EdaatOR.Biller_Invoicecontract,testdatamap.get("Invoice
			// Contract").toString());
			WebClick(EdaatOR.Biller_ReportFromdate);
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Biller_reportFromYear, testdatamap.get("FromYear").toString());
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Biller_reportFromMonth, testdatamap.get("FromMonth").toString());
			Thread.sleep(1000);
			WebClick("//a[text()='" + testdatamap.get("FromDate").toString() + "']");
			Thread.sleep(1000);
			WebClick(EdaatOR.Biller_ReportTodate);
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Biller_reportToyear, testdatamap.get("ToYear").toString());
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Biller_reportToMonth, testdatamap.get("ToMonth").toString());
			Thread.sleep(1000);
			WebClick("//a[text()='" + testdatamap.get("ToDate").toString() + "']");
			Thread.sleep(1000);
			WebClick(EdaatOR.Biller_reportsearchbutton);
			Thread.sleep(10000);

			if (ExistsCheck(EdaatOR.Biller_Reports_Receiv_ClientAccStm_ClientTypeError)) {
				Log.ReportEvent("FAIL", "Client Account Statement Report Generation is Unsuccessful");
				takeScreenShot();
				driver.quit();
				Assert.fail();

			} else if (ExistsCheck(EdaatOR.Biller_Reports_Receiv_ClientAccStm_ClientError)) {
				Log.ReportEvent("FAIL", "Client Account Statement Report Generation is Unsuccessful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			} else if (ExistsCheck(EdaatOR.Biller_Reports_Receiv_ClientAccStm_FromDateError)) {
				Log.ReportEvent("FAIL", "Client Account Statement Report Generation is Unsuccessful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			} else {
				waitForPageToLoad();
				switchToWindow();
				swithchToFrame(EdaatOR.Biller_reportframe);
				verifyElementIsPresent(EdaatOR.Biller_report);
				Thread.sleep(1000);
				Log.ReportEvent("PASS", "Client Account Statement Report Generation is Successful");
				switchBacktoParentwindow();
				Thread.sleep(1000);

			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Client Account Statement Report Generation is Unsuccessful");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	// Function Summary : Method to Select Client type.
	// Parameter Summary : ClientType,Individual.
	public void ClientType(Map<Object, Object> testdatamap) {

		try {
			WebClick(EdaatOR.Biller_ClientType);
			String ele = testdatamap.get("ClientType").toString();
			if (ele.equalsIgnoreCase("Individual")) {
				selectDropdownValue_PartialText(EdaatOR.Biller_ClientTypeindvidutial, ele);
			} else {
				selectDropdownValue_PartialText(EdaatOR.Biller_ClientTypeCorporate, ele);
			}

		} catch (Exception e) {
			test.log(Status.FAIL,
					"Generate Report and export" + driver.getTitle() + " * Generate Report and export FAIL * ");

		}
	}

	// Function Summary : Method to Select Client type.
	// Parameter Summary : ClientName.
	public void SelectClient(String client) throws Exception {

		WebClick(EdaatOR.Biller_ClientName);
		Thread.sleep(1000);
		WebClickUsingActions(EdaatOR.Biller_SelectClientName + "[" + client + "]");
		// WebClick(EdaatOR.Biller_SelectClientName);
	}

	// Function Summary : Method to Select SubBiller type.
	// Parameter Summary : SubBiller,Individual.
	public void SubbillerType(Map<Object, Object> testdatamap) {

		try {
			WebClick(EdaatOR.Biller_SelectSubbillertype);
			String ele = testdatamap.get("SubBiller").toString();
			if (ele.equalsIgnoreCase("Individual")) {
				selectDropdownValue_PartialText(EdaatOR.Biller_SubbillerTypeindvidutial, ele);
			} else {
				selectDropdownValue_PartialText(EdaatOR.Biller_SubbillerTypeCorporate, ele);
			}

		} catch (Exception e) {
			test.log(Status.FAIL,
					"Generate Report and export" + driver.getTitle() + " * Generate Report and export FAIL * ");

		}
	}

	// Function Summary : Method to Select SubBiller Name.
	// Parameter Summary : N/A.
	public void SelectSubbillername(String sub) throws Exception {
		// WebSelect1(EdaatOR.Biller_Invoice_SBilIdList,SubBiller);
		WebClick(EdaatOR.Biller_SelectSubbillerName);
		Thread.sleep(1000);
		WebClick(EdaatOR.Biller_SelectSubbillerName1 + "[" + sub + "]");
		// WebClick(EdaatOR.Biller_SelectClientName);
	}

	// Function Summary : Navigate to Verify ClientInvoiceReport Generate
	// Functionality
	// Parameter Summary : N/A
	public void navigatetoclientinvoicereport(Log Log) {
		try {
			WebClickUsingJS(EdaatOR.Biller_ReportMenu);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_ReceivablesReportsbtn);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_ClientsInvoicesReport);
			Thread.sleep(1000);
			if (ExistsCheck(EdaatOR.Biller_ClientsInvoicesReport_Page)) {
				Log.ReportEvent("PASS", "Client Invoices Report Page is Loaded successfully");

			} else {
				Log.ReportEvent("FAIL", "Client Invoices Report Page is not Loaded successfully");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();

			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Client Invoices Report Page is not Loaded successfully");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}

	}

	// Function Summary : Method to Enter FromDate
	// Parameter Summary : FromYear,FromMonth,FromDate
	private void EnterFromdate(Map<Object, Object> testdatamap) throws Exception {
		WebClick(EdaatOR.Biller_Clientreport_FromDate);
		selectDropdownValue_PartialText(EdaatOR.Biller_Clientreport_Fromyear, testdatamap.get("FromYear").toString());
		selectDropdownValue_PartialText(EdaatOR.Biller_Clientreport_FromMonth, testdatamap.get("FromMonth").toString());
		WebClick("//a[text()='" + testdatamap.get("FromDate").toString() + "']");
		Thread.sleep(1000);
	}

	// Function Summary : Method to Enter Todate
	// Parameter Summary : ToYear,ToMonth,ToDate
	private void EnterTodate(Map<Object, Object> testdatamap) throws Exception {
		WebClick(EdaatOR.Biller_Clientreport_TODate);
		selectDropdownValue_PartialText(EdaatOR.Biller_Clientreport_Toyear, testdatamap.get("ToYear").toString());
		selectDropdownValue_PartialText(EdaatOR.Biller_Clientreport_ToMonth, testdatamap.get("ToMonth").toString());
		WebClick("//a[text()='" + testdatamap.get("ToDate").toString() + "']");
		Thread.sleep(1000);

	}

	// Function Summary : Method to Verify ClientInvoiceReport Generate
	// Functionality
	// Parameter Summary : ClientType,ClientName,BillStatus,IdorCR,exportmsg
	public void GenerateReport(Map<Object, Object> testdatamap, Log Log) {
		try {
			EnterFromdate(testdatamap);
			EnterTodate(testdatamap);
			selectDropdownValue_PartialText(EdaatOR.Biller_ClientType, testdatamap.get("ClientType").toString());
			Thread.sleep(500);
			WebClick(EdaatOR.Biller_ClientNamearro);
			WebEdit(EdaatOR.Biller_ClientNametextbox, testdatamap.get("ClientName").toString());
			Thread.sleep(1000);
			WebClick(EdaatOR.Biller_ClientNameoption);
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Biller_BillStatus, testdatamap.get("BillStatus").toString());
			Thread.sleep(500);
			WebEdit(EdaatOR.Biller_IdorCR, testdatamap.get("IdorCR").toString());
			Thread.sleep(2000);
			selectDropdownValue_PartialText(EdaatOR.Biller_SubBillerType, testdatamap.get("SubBillerType").toString());
			WebClickUsingJS(EdaatOR.Biller_SubBillerType);
			WebClick("(//option[text()='" + testdatamap.get("SubBillerType").toString() + "'])[2]");
			Thread.sleep(1000);
			WebClick(EdaatOR.Biller_Generatebtn);
			Thread.sleep(2000);
			switchTonextwindow();
			waitForPageToLoad();
			swithchToFrame(EdaatOR.Biller_ClientsInvoicesReport_Frame);
//				(//div[text()='1010330250'])[1]
			if (ExistsCheck("(//div[text()='" + testdatamap.get("IdorCR").toString() + "'])[1]")
					|| ExistsCheck(EdaatOR.Biller_ClientsInvoicesReport_Header)) {
				Log.ReportEvent("PASS", "Client Invoices Report generation is successful.");

			} else {
				Log.ReportEvent("FAIL", "Client Invoices Report generation is unsuccessful.");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
			switchBacktoParentwindow();

		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Client Invoices Report generation is unsuccessful.");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}

	}

	private void SendKeys(Keys enter) {
		// TODO Auto-generated method stub

	}

	// Function Summary : Method to navigate to Receivevable report
	// Parameter Summary : N/A
	public void navigatetoReceivableReports() throws InterruptedException {

		WebClickUsingJS(EdaatOR.Biller_ReportMenu);
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Biller_ReceivablesReportsbtn);
		Thread.sleep(1000);
	}

	// Function Summary : Method to navigate to Receivevable report
	// Parameter Summary : N/A
	public void navigatetoSubbillersReports(Log Log) throws InterruptedException {
		try {
			WebClickUsingJS(EdaatOR.Biller_ReportMenu);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_ReceivablesReportsbtn);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_SubBillerReportLink);
			Thread.sleep(800);

			if (ExistsCheck(EdaatOR.Biller_SubBillerReport_Page)) {
				Log.ReportEvent("PASS", " Sub Billers Report Page is Loaded Successfully");

			} else {
				Log.ReportEvent("FAIL", " Sub Billers Report Page is not Loaded Successfully");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", " Sub Billers Report Page is not Loaded Successfully");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}

	}

	// Function Summary : Method to verify corporate client report
	// Parameter Summary : N/A
	public void CorporateClientReport(Log Log) {

		try {
			navigatetoReceivableReports();
			WebClickUsingJS(EdaatOR.Biller_CorporateClientReport);
			Thread.sleep(3000);
			swithchToFrame(EdaatOR.Biller_CorporateReport);
			Thread.sleep(3000);
			verifyElementIsPresent(EdaatOR.Biller_CorporateReportBillerName);

			driver.navigate().back();
			test.log(Status.PASS,
					"Corporate client report " + driver.getTitle() + " * Corporate client report FAIL * ");
			Log.ReportEvent("PASS", " Verify Generate Client account statement is Successful");
			this.takeScreenShot();
		}

		catch (Exception e) {
			test.log(Status.FAIL,
					"Corporate client report " + driver.getTitle() + " * Corporate client report  FAIL * ");
			this.takeScreenShot();
		}
	}

	// Function Summary : Method to verify Sub Biller report
	// Parameter Summary : SubBillerType,NationalID,CRNumber
	public void SubBillerReport(Map<Object, Object> testdatamap, Log Log) {

		try {
			String SubBillerType = testdatamap.get("SubBillerType").toString();
			navigatetoSubbillersReports(Log);

			switchToWindow();
			// WebClickUsingJS(EdaatOR.Biller_SubBillerCorporate);
			WebClickUsingJS("//label[text()='" + SubBillerType + "']");
			if (SubBillerType.equals("Individual")) {
				WebEdit(EdaatOR.Biller_SubBillerNationalID, testdatamap.get("NationalID").toString());
				Thread.sleep(800);
			} else {
				WebEdit(EdaatOR.Biller_SubBillerCRNumber, testdatamap.get("CRNumber").toString());
				Thread.sleep(800);
			}
			WebClickUsingJS(EdaatOR.Biller_SubBillerGenerateReport);
			Thread.sleep(800);
			switchToWindow();
			swithchToFrame(EdaatOR.Admin_Corporate_Report);
			if (ExistsCheck("//div[contains(text(),'" + SubBillerType + "')]")) {
				Log.ReportEvent("PASS", " Sub Billers Report Generation is Successful");

			} else {
				Log.ReportEvent("FAIL", " Sub Billers Report Generation is Unsuccessful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}

			switchBacktoParentwindow();
		}

		catch (Exception e) {
			Log.ReportEvent("FAIL", " Sub Billers Report Generation is Unsuccessful");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	public void NavigatetoOverdueBillsReport(Log Log) throws InterruptedException, IOException {
		try {
			WebClickUsingJS(EdaatOR.Biller_ReportMenu);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_ReceivablesReportsbtn);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_OverDueBillsReport);
			Thread.sleep(1000);
			if (ExistsCheck(EdaatOR.Biller_OverDueBillsReport_Page)) {
				Log.ReportEvent("PASS", " Overdue Bills Report Page is Loaded Successfully");

			} else {
				Log.ReportEvent("FAIL", " Overdue Bills Report Page is not Loaded Successfully");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", " Overdue Bills Report Page is not Loaded Successfully");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	public void VerifyOverdueBillsReport(Map<Object, Object> testdatamap, Log Log) {
		try {

			WebClick(EdaatOR.Biller_OverDueBillsReportClientType);
			WebSelect(EdaatOR.Biller_OverDueBillsReportClientType, testdatamap.get("ClientType").toString());
			Thread.sleep(2000);
			WebClick(EdaatOR.Biller_OverDueBillsReportClientName);
			Thread.sleep(2000);
			WebEdit(EdaatOR.Biller_OverDueBillsReportclientNameTxtField, testdatamap.get("ClientName").toString());
			Thread.sleep(2000);
			WebSelect(EdaatOR.Biller_OverDueBillsReportSubBillerType, testdatamap.get("SuperBillerType").toString());
			/// Thread.sleep(1000);
			// WebSelect(EdaatOR.Biller_OverDueBillsReportSubBillerName,
			/// testdatamap.get("SuperBillerName").toString());
			Thread.sleep(3000);
			WebClickUsingJS(EdaatOR.Biller_OverDueBillsGenerateReportBTN);
			waitForPageToLoad();
			switchToWindow();

			swithchToFrame(EdaatOR.Biller_OverDueBillsReportFrame);
			Thread.sleep(1000);
			if (getText("//div[text()='" + testdatamap.get("ClientName").toString() + "']")
					.equals(testdatamap.get("ClientName").toString())) {
				Log.ReportEvent("PASS", " Overdue Bills Report generation is successful");

			} else {
				Log.ReportEvent("FAIL", " Overdue Bills Report Generation is Unsuccessful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}

			switchBacktoParentwindow();

		} catch (Exception e) {
			Log.ReportEvent("FAIL", " Overdue Bills Report Generation is Unsuccessful");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	// Function Summary : Method to NavigatetoSadadPaymentsTransactionsReport
	// Parameter Summary : N/A
	public void NavigatetoSadadPaymentsTransactionsReport(Log Log) throws InterruptedException {
		try {
			WebClickUsingJS(EdaatOR.Biller_ReportMenu);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_ReceivablesReportsbtn);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_Receivables_Sadadpaybtn);
			Thread.sleep(1000);
			if (ExistsCheck(EdaatOR.Biller_Receivables_Sadadpayment_Page)) {
				Log.ReportEvent("PASS", "Sadad Payments Transactions Report Page is Loaded Successfully");

			} else {
				Log.ReportEvent("FAIL", " Sadad Payments Transactions Report Page is not Loaded Successfully");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", " Sadad Payments Transactions Report Page is not Loaded Successfully");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	// Function Summary : Method to VerifySadadPaymentTransactionReport
	// Parameter Summary :
	// InvoiceNumber,InvoiceType,ClientType,ClientName,FromYear,ToYear,FromMonth,ToMonth,ToDate,FromDate,Products
	public void VerifySadadPaymentTransactionReport(Map<Object, Object> testdatamap, Log Log) {

		try {
			selectDropdownValue_PartialText(EdaatOR.Biller_Receivables_SadadpayInvoicetype,
					testdatamap.get("InvoiceType").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_Receivables_SadadpayInvoiceno, testdatamap.get("InvoiceNumber").toString());
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Biller_Receivables_SadadpayClienttype,
					testdatamap.get("ClientType").toString());
			Thread.sleep(1000);
			WebClick(EdaatOR.Biller_Receivables_SadadpayClientname);
			Thread.sleep(1000);
			WebClickUsingActions("//li[text()='" + testdatamap.get("ClientName").toString() + "']");
			WebClick(EdaatOR.Biller_Receivables_Sadadpay_FromCalender);
			selectDropdownValue_PartialText(EdaatOR.Biller_Receivables_Sadadpay_FromYear,
					testdatamap.get("FromYear").toString());
			selectDropdownValue_PartialText(EdaatOR.Biller_Receivables_Sadadpay_FromMonth,
					testdatamap.get("FromMonth").toString());
			WebClick("//a[text()='" + testdatamap.get("FromDate").toString() + "']");
			Thread.sleep(800);
			WebClick(EdaatOR.Biller_Receivables_Sadadpay_ToCalender);
			selectDropdownValue_PartialText(EdaatOR.Biller_Receivables_Sadadpay_ToYear,
					testdatamap.get("ToYear").toString());
			selectDropdownValue_PartialText(EdaatOR.Biller_Receivables_Sadadpay_ToMonth,
					testdatamap.get("ToMonth").toString());
			WebClick("//a[text()='" + testdatamap.get("ToDate").toString() + "']");
			Thread.sleep(1000);
			WebClick(EdaatOR.Biller_Receivables_Sadadpay_product);
			Thread.sleep(1000);
			WebClickUsingActions("//li[text()='" + testdatamap.get("Products").toString() + "']");
			Thread.sleep(1000);

			WebClick(EdaatOR.Biller_Receivables_Sadadpay_generatebtn);
			switchToWindow();
			Thread.sleep(1000);
			swithchToFrame(EdaatOR.Biller_Receivables_Sadadpay_frame);
			Thread.sleep(1000);
			if (ExistsCheck(EdaatOR.Biller_Receivables_Sadadpay_Verify)) {
				Log.ReportEvent("PASS", " Sadad Payments Transactions Report Generation is Successful");

			} else {
				Log.ReportEvent("FAIL", " Sadad Payments Transactions Report Generation is Unsuccessful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
			Thread.sleep(1000);
			switchBacktoParentwindow();

		} catch (Exception e) {
			Log.ReportEvent("FAIL", " Sadad Payments Transactions Report Generation is Unsuccessful");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	// Function Summary : Method to Verify Client Account Statement Report ErrorMsg
	// Parameter Summary : Expected.
	public void ClientAccountStatementErrorMsgValidation(Map<Object, Object> testdatamap, Log Log) {
		try {
			navigatetoclientAccountStatement(Log);
			String ClientType = testdatamap.get("Client").toString();
			if (ClientType.equals("Valid")) {
				ClientType(testdatamap);
				Thread.sleep(1000);
				SelectClient(testdatamap.get("ClientName").toString());
			}
			String Date = testdatamap.get("ValidDate").toString();
			if (Date.equalsIgnoreCase("Valid")) {
				WebClick(EdaatOR.Biller_ReportFromdate);
				Thread.sleep(1000);
				selectDropdownValue_PartialText(EdaatOR.Biller_reportFromYear, testdatamap.get("FromYear").toString());
				Thread.sleep(1000);
				selectDropdownValue_PartialText(EdaatOR.Biller_reportFromMonth,
						testdatamap.get("FromMonth").toString());
				Thread.sleep(1000);
				WebClick("//a[text()='" + testdatamap.get("FromDate").toString() + "']");
				Thread.sleep(1000);
				WebClick(EdaatOR.Biller_ReportTodate);
				Thread.sleep(1000);
				selectDropdownValue_PartialText(EdaatOR.Biller_reportToyear, testdatamap.get("ToYear").toString());
				Thread.sleep(1000);
				selectDropdownValue_PartialText(EdaatOR.Biller_reportToMonth, testdatamap.get("ToMonth").toString());
				Thread.sleep(1000);
				WebClick("//a[text()='" + testdatamap.get("ToDate").toString() + "']");
				Thread.sleep(1000);
			}
			WebClickUsingJS(EdaatOR.Biller_reportsearchbutton);
			Thread.sleep(2000);
			String Expected = testdatamap.get("ExpectedResult").toString();
			if (ExistsCheck(EdaatOR.Biller_Reports_Receiv_ClientAccStm_ClientTypeError)) {
				Log.ReportEvent("PASS", "Error Message Validation for Client Type Dropdown is Successful");

			} else if (ExistsCheck(EdaatOR.Biller_Reports_Receiv_ClientAccStm_ClientError)) {

				Log.ReportEvent("PASS", "Error Message Validation for Client Dropdown is Successful");

			} else if (ExistsCheck(EdaatOR.Biller_Reports_Receiv_ClientAccStm_FromDateError)) {

				Log.ReportEvent("PASS", "Error Message Validation for From Date Field is Successful");

			} else {

				Log.ReportEvent("Fail", "Error Message Validation for Client Account Statement UI is Unsuccessful");
				takeScreenShot();
				driver.quit();
				Assert.fail();

			}
		} catch (Exception e) {
			Log.ReportEvent("Fail", "Error Message Validation for Client Account Statement UI is Unsuccessful");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	// Function Summary : Method to Navigate Custom reconciliation Report Page.
	// Parameter Summary : NA
	public void navigateToCustomReconciliationReportPage(Log Log) throws InterruptedException {
		try {
			WebClickUsingJS(EdaatOR.Biller_ReportMenu);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_ReceivablesReportsbtn);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_CustomReconciliationReport);
			Thread.sleep(1000);
			if (CheckElementExists(EdaatOR.Biller_customReconciliation_Report_Header)) {
				Log.ReportEvent("PASS", "Custom Reconciliation Report Page is displayed Successfully");
				Thread.sleep(1000);
			} else {
				Log.ReportEvent("FAIL", "Custom Reconciliation Report Page is not displayed Successfully");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Custom Reconciliation Report Page is not displayed Successfully");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	// Function Summary : Method to Navigate Daily Reconciliation Report SADAD Page.
	// Parameter Summary : NA
	public void navigateDailyReconciliationReportSADAD(Log Log) throws InterruptedException {
		try {
			WebClickUsingJS(EdaatOR.Biller_ReportMenu);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_ReceivablesReportsbtn);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_CustomReconciliationReportSadad);
			Thread.sleep(1000);

			Log.ReportEvent("PASS", " Verify Custom Reconciliation Report(Sadad) is Suceessful");
			this.takeScreenShot();
		} catch (Exception e) {
			test.log(Status.FAIL, "Navigate to Custom Reconciliation Report Page is FAIL");
			this.takeScreenShot();
		}
	}

}
