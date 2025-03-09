/**
*
* Test Script Name                      : NA
* Objective                             : Verify to Client PayablesIncoming Bills Page Functionality.
* Version                               : 1.0
* Author                                : Basavaraj Mudnur
* Created Date                          : 
* Last Updated on                       : N/A
* Updated By   			 			    : Basavaraj Mudnur
* Pre-Conditions					    : N/A
* Epic Details						 	: N/A
* User Story Details				 	: N/A
**/
package com.azmqalabs.edaattestautomation.apppages.Client.pages;

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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.google.sitebricks.routing.Action;

public class ClientPayablesIncomingBillsPage extends BasePage {

	public ClientPayablesIncomingBillsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.Biller_Client)
	public WebElement Client;

	public boolean Exists() {
		return super.Exists(Client);
	}

	// Function Summary : Method to verify Navigate to "Incoming Bills" Page.
	// Parameter Summary : N/A
	public void NavigatetoIncomingBills(Log Log) throws InterruptedException, IOException {
		try {
			WebClickUsingJS(EdaatOR.ClientsPayablesIncomingBillsBTN);
			Thread.sleep(2000);
			if (ExistsCheck(EdaatOR.ClientIncomingBills)) {
				Log.ReportEvent("PASS", "Incoming Bills Page is Loaded Successfully");
			} else {
				Log.ReportEvent("FAIL", "Incoming Bills Page is not Loaded Successfully");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Incoming Bills Page is not Loaded Successfully");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}

	}

	public void SelectBillerNameDropDown(Map<Object, Object> testdatamap) throws Exception {
		WebClick(EdaatOR.ClientsPayablesBillerNameDropdown);
		Thread.sleep(1000);
		WebSelect(EdaatOR.ClientsPayablesBillerNameDropdown, testdatamap.get("BillerName").toString());
	}

	public void SelectPaymentStatusDropDown(Map<Object, Object> testdatamap) throws Exception {
		WebClick(EdaatOR.ClientsPayablesPaymentStatusDropdown);
		Thread.sleep(1000);
		WebSelect(EdaatOR.ClientsPayablesPaymentStatusDropdown, testdatamap.get("PaymentStatus").toString());
	}

	public void SearchIncomingBills(Map<Object, Object> testdatamap, Log Log) throws Exception {
		try {
			WebEdit(EdaatOR.ClientsPayablesInvoiceNumberTextField, testdatamap.get("BillNumber").toString());
			Thread.sleep(2000);
			SelectBillerNameDropDown(testdatamap);
			Thread.sleep(2000);
			SelectPaymentStatusDropDown(testdatamap);
			Thread.sleep(2000);
			WebClick(EdaatOR.ClientsPayablesIncomingBillSerach);
			Thread.sleep(1000);
			if (ExistsCheck("//td/a[text()='" + testdatamap.get("BillNumber").toString() + "']")) {

				Log.ReportEvent("PASS", " Incomming Bills Search is Successful");
			} else {
				Log.ReportEvent("Fail", " Incomming Bills Search is Unsuccessful");
				takeScreenShot();
				driver.quit();
				Assert.fail();

			}
		} catch (Exception e) {
			Log.ReportEvent("Fail", " Incomming Bills Search is Unsuccessful");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	// Function Summary : Method to verifyPayButtonAppearsWithMultiPaymentMethods
	// Parameter Summary : BillNumber
	public void verifyPayButtonAppearsWithMultiPaymentMethods(Map<Object, Object> testdatamap, Log Log)
			throws Exception {
		try {
			WebEdit(EdaatOR.ClientsPayablesInvoiceNumberTextField, testdatamap.get("BillNumber").toString());
			SelectBillerNameDropDown(testdatamap);
			Thread.sleep(1000);
			SelectPaymentStatusDropDown(testdatamap);
			Thread.sleep(2000);
			WebClick(EdaatOR.ClientsPayablesIncomingBillSerach);
			Thread.sleep(2000);
			verifyElementIsPresent("//td/a[text()='" + testdatamap.get("BillNumber").toString() + "']");
			Thread.sleep(2000);
			if (CheckElementExists("//a[text()='" + testdatamap.get("BillNumber").toString() + "']")) {
				WebClick(EdaatOR.ClientsPayablesIncomingBillsPay);
				Thread.sleep(2000);
				verifyElementIsPresent(EdaatOR.ClientsPayablesIncomingBills_Sadad_Link);
				Thread.sleep(2000);
				verifyElementIsPresent(EdaatOR.ClientsPayablesIncomingBills_Mada_Link);
				Thread.sleep(2000);
				verifyElementIsPresent(EdaatOR.ClientsPayablesIncomingBills_Visa_Link);
				Thread.sleep(2000);
				verifyElementIsPresent(EdaatOR.ClientsPayablesIncomingBills_MasterCard_Link);
				Thread.sleep(2000);
//				verifyElementIsPresent(EdaatOR.ClientsPayablesIncomingBills_ApplePay_Link);
//				Thread.sleep(1000);
				Log.ReportEvent("PASS", "Pay Button Verification for Multi-payment Invoices is Successful");
				Log.ReportEvent("PASS",
						"HyperPay Logo Verification for Each Payment method on the Invoice is Successful");
			} else {
				Log.ReportEvent("FAIL", "Pay Button Verification for Multi-payment Invoices is Unsuccessful");
				Log.ReportEvent("FAIL",
						"HyperPay Logo Verification for Each Payment method on the Invoice is Unsuccessful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Pay Button Verification for Multi-payment Invoices is Unsuccessful");
			Log.ReportEvent("FAIL",
					"HyperPay Logo Verification for Each Payment method on the Invoice is Unsuccessful");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	public void ClickonBillNumber(String BillNumber) {
		WebClickUsingJS("//a[text()='" + BillNumber + "']");
	}

	public void VerifyBillNumberClickable(Map<Object, Object> testdatamap, Log Log) throws Exception {
		try {
			SearchIncomingBills(testdatamap, Log);
			Thread.sleep(2000);
			ClickonBillNumber(testdatamap.get("BillNumber").toString());
			switchToDefault();
			Thread.sleep(2000);
			if (CheckElementExists(EdaatOR.ClientsPayablesIncomInvoiceDetailsHeader)) {
				Log.ReportEvent("PASS", "Bill Number is Clickable Functionality is Successful");
			} else {
				Log.ReportEvent("FAIL", "Bill Number is Clickable Functionality is UnSuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Bill Number is Clickable Functionality is UnSuccessful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	// Function Summary : Method to verify Bills Printout functionality.
	// Parameter Summary : N/A
	public void verifyBillsPrint(Map<Object, Object> testdatamap, Log Log) throws InterruptedException {
		try {
			WebClickUsingJS(EdaatOR.ClientsIncomingBillsBillnumber1);
			Thread.sleep(2000);
			switchToWindow();
			if (CheckElementExists(EdaatOR.ClientsIncomingBillPrintBtn)) {
				WebClickUsingJS(EdaatOR.ClientsIncomingBillPrintBtn);
				Thread.sleep(4000);
				Log.ReportEvent("PASS", "Printout Functionality for the Bills is Successful");
			} else {
				Log.ReportEvent("FAIL", "Printout Functionality for the Bills is not Successful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Printout Functionality for the Bills is not Successful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	// Function Summary: Verify Incoming Bills GridView
	// Function Parameter:NA
	public void IncomingBillsGridView(Log Log) throws InterruptedException {
		try {
			NavigatetoIncomingBills(Log);
			if (CheckElementExists(EdaatOR.ClientPayablesIncomingBillsGrid) == true) {
				Log.ReportEvent("PASS", "Verify Grid view details is Successful");

			} else {
				Log.ReportEvent("FAIL", "Verify Grid view details is not Successful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Verify Grid view details is not Successful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	// Function Summary :Method to VerifyPayIncomingBills
	// Function Parameter:N/A
	public void VerifyPayIncomingBills(Map<Object, Object> testdatamap, Log Log) {
		try {
			WebEdit(EdaatOR.ClientsPayablesInvoiceNumberTextField, testdatamap.get("BilNumber").toString());
			Thread.sleep(5000);
			SelectBillerNameDropDown(testdatamap);
			Thread.sleep(2000);
			SelectPaymentStatusDropDown(testdatamap);
			Thread.sleep(1000);
			WebClick(EdaatOR.ClientsPayablesIncomingBillSerach);

			Thread.sleep(1000);
			if (CheckElementExists("//a[text()='" + testdatamap.get("BilNumber").toString() + "']") == true) {
				WebClick(EdaatOR.ClientsPayablesIncomingBillsPay);

				Thread.sleep(1000);
				WebClick(EdaatOR.ClientsPayablesIncomingBillsPaysadad);

				Thread.sleep(1000);
				WebClick(EdaatOR.ClientsPayablesIncomingBillsfollowpay);
				Thread.sleep(2000);
				waitForPageToLoad();

				VerifyValue1(getText("//label[text()='" + testdatamap.get("PaymentSuccess").toString() + "']"),
						testdatamap.get("PaymentSuccess").toString());
				Thread.sleep(1000);
				test.log(Status.PASS, "Verify PAY Functionality" + driver.getTitle() + " * PAY Functionality PASS * ");
				Log.ReportEvent("PASS", " Verify Incoming Bills PAY Functionality is successfull");
				this.takeScreenShot();

			} else {
				test.log(Status.FAIL, "Verify PAY Functionality" + driver.getTitle() + " * PAY Functionality FAIL * ");
			}
		} catch (Exception e) {

			test.log(Status.FAIL, "Verify PAY Functionality" + driver.getTitle() + " * PAY Functionality FAIL * ");
			this.takeScreenShot();

		}

	}

	// Function Summary :Method to VerifyPayIncomingBills Error Message
	// Function Parameter:N/A
	public void VerifyIncomingbillsPayEroorMessage(Map<Object, Object> testdatamap, Log Log) throws Exception {
		NavigatetoIncomingBills(Log);
		SearchIncomingBills(testdatamap, Log);
		WebClick(EdaatOR.ClientsPayablesIncomingBillsPay);
		Thread.sleep(2000);
		try {
			if (ExistsCheck(EdaatOR.Client_IncomingBills_Pay_Error)) {
				Log.ReportEvent("PASS", "Incomming Bills Pay Error Message Verification is Successful");
			} else {
				Log.ReportEvent("FAIL", "Incomming Bills Pay Error Message Verification is Unsuccessful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}

		catch (Exception e) {
			Log.ReportEvent("FAIL", "Incomming Bills Pay Error Message Verification is Unsuccessful");
			takeScreenShot();
			driver.quit();
			Assert.fail();

		}
	}

//Function Summary  :Method to Verify newly added payment method
	public void VerifyNewAddedPaymentMethodColumn(Log Log) throws Exception {
		try {
			NavigatetoIncomingBills(Log);
			Thread.sleep(2000);
			if (ExistsCheck(EdaatOR.Client_IncomingBillsPaymentMethodColumn)) {
				verifyElementIsPresent(EdaatOR.Client_IncomingBillsPaymentMethodColumn);
				Log.ReportEvent("PASS", " Newly Added Payment Menthod is Successful");
			} else {
				Log.ReportEvent("FAIL", " Newly Added Payment Menthod is not Successful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Newly Added Payment Menthod is not Successful");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	// Function Summary :Method to Verify newly added payment method search dropdown
	public void VerifyNewAddedPaymentMethodSearchDropdown(Log Log) throws Exception {
		try {
			NavigatetoIncomingBills(Log);
			Thread.sleep(2000);
			if (ExistsCheck(EdaatOR.Client_IncomingBillsPaymentMethodSearchDropdown)) {
				verifyElementIsPresent(EdaatOR.Client_IncomingBillsPaymentMethodSearchDropdown);
				Log.ReportEvent("PASS", "Verify Newly Added Payment Menthod Search Dropdown is Successful");
			} else {
				Log.ReportEvent("FAIL", "Verify Newly Added Payment Menthod Search Dropdown is Unsuccessful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Verify Newly Added Payment Menthod Search Dropdown is Unsuccessful");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	// Function Summary :Method to Verify Pay Option In Incoming Bills
	public void VerifyPayOptionInIncomingBills(Log Log) throws Exception {
		NavigatetoIncomingBills(Log);
		Thread.sleep(1000);

		verifyElementIsPresent(EdaatOR.Client_IncomingBillsPayOption);
		Thread.sleep(1000);
		Log.ReportEvent("PASS", "Verify pay option in Incoming bills is successfull");
		this.takeScreenShot();
	}

}
