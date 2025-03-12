/**
* Test Script Name                      : NA
* Objective                             : Verify to Client Reports ClientAccountStatement Page Functionality.
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

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SwitchToFrame;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;

public class ClientReportsClientAccountStatementPage extends BasePage {
	public ClientReportsClientAccountStatementPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.ClientAccountStatementtext)
	public WebElement ClientStatement;

	public boolean Exists() {
		return super.Exists(ClientStatement);
	}

	// Function Summary : Navigate to "Client Account Statement" Page.
	// Parameter Summary : N/A
	public void navigateToClientAccountStatement(Log Log) throws InterruptedException {
		try {
			WebClickUsingJS(EdaatOR.Client_ClientAccountStatementMenu);
			Thread.sleep(1000);
			switchToWindow();
			if (ExistsCheck(EdaatOR.ClientAccountStatementtext)) {
				Log.ReportEvent("PASS", "Client Acount Statement Page is Loaded Successfully");
			} else {
				Log.ReportEvent("FAIL", "Client Acount Statement Page is Not Loaded Successfully");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Client Acount Statement Page is Not Loaded Successfully");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}

	}

	// Function Summary : Method to Verify Client Account Statement Report.
	// Parameter Summary : BillerName,Invoice
	// Contract,FromYear,FromMonth,FromDate,ToYear,ToMonth,ToDate,ClientName
	public void VerifyAccountstatement(Map<Object, Object> testdatamap, Log Log) {
		try {
			navigateToClientAccountStatement(Log);
			selectDropdownValue_PartialText(EdaatOR.Client_ClientAccountStatement_BillerName,
					testdatamap.get("BillerName").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Client_ClientAccountStatement_InvoiceContactfield,
					testdatamap.get("Invoice Contract").toString());
			WebClick(EdaatOR.Biller_Dashboard_FromDate);
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Client_ClientAccountStatement_Fromyear,
					testdatamap.get("FromYear").toString());
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Client_ClientAccountStatement_FromMonth,
					testdatamap.get("FromMonth").toString());
			Thread.sleep(1000);
			WebClick("//a[text()='" + testdatamap.get("FromDate").toString() + "']");
			Thread.sleep(1000);
			WebClick(EdaatOR.Client_ClientAccountStatement_TODate);
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Client_ClientAccountStatement_Toyear,
					testdatamap.get("ToYear").toString());
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Client_ClientAccountStatement_ToMonth,
					testdatamap.get("ToMonth").toString());
			Thread.sleep(1000);
			WebClick("//a[text()='" + testdatamap.get("ToDate").toString() + "']");
			WebClick(EdaatOR.Client_ClientAccountStatement_SearchBtn);
			switchToWindow();
			swithchToFrame(EdaatOR.Client_reportFrame);
			Thread.sleep(2000);
			if (ExistsCheck("//div[text()='" + testdatamap.get("ClientName").toString() + "']")
					|| ExistsCheck("//div[text()='" + testdatamap.get("Invoice Contract").toString() + "']")) {
				switchBacktoParentwindow();
				Log.ReportEvent("PASS", " Exported Report for The Selected Biller is successful");
			} else {
				Log.ReportEvent("FAIL", " Exported Report for The Selected Biller is not successful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}

		} catch (Exception e) {
			Log.ReportEvent("FAIL", " Exported Report for The Selected Biller is not successful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}

	}

	// Function Summary : Method to Verify Client Account Statement Report.
	// Parameter Summary : BillerName,Invoice
	// Contract,FromYear,FromMonth,FromDate,ToYear,ToMonth,ToDate,ClientName
	public void VerifySerachFunctionality(Map<Object, Object> testdatamap, Log Log) {
		try {
			navigateToClientAccountStatement(Log);
			Thread.sleep(2000);
			selectDropdownValue_PartialText(EdaatOR.Client_ClientAccountStatement_BillerName,
					testdatamap.get("BillerName").toString());
			Thread.sleep(2000);
			WebEdit(EdaatOR.Client_ClientAccountStatement_InvoiceContactfield,
					testdatamap.get("Invoice Contract").toString());
			WebClick(EdaatOR.Biller_Dashboard_FromDate);
			Thread.sleep(2000);
			selectDropdownValue_PartialText(EdaatOR.Client_ClientAccountStatement_Fromyear,
					testdatamap.get("FromYear").toString());
			Thread.sleep(2000);
			selectDropdownValue_PartialText(EdaatOR.Client_ClientAccountStatement_FromMonth,
					testdatamap.get("FromMonth").toString());
			Thread.sleep(1000);
			WebClick("//a[text()='" + testdatamap.get("FromDate").toString() + "']");
			Thread.sleep(2000);
			WebClick(EdaatOR.Client_ClientAccountStatement_TODate);
			Thread.sleep(2000);
			selectDropdownValue_PartialText(EdaatOR.Client_ClientAccountStatement_Toyear,
					testdatamap.get("ToYear").toString());
			Thread.sleep(2000);
			selectDropdownValue_PartialText(EdaatOR.Client_ClientAccountStatement_ToMonth,
					testdatamap.get("ToMonth").toString());
			Thread.sleep(2000);
			WebClick("//a[text()='" + testdatamap.get("ToDate").toString() + "']");
			WebClick(EdaatOR.Client_ClientAccountStatement_SearchBtn);
			Thread.sleep(10000);

			switchToWindow();
			swithchToFrame(EdaatOR.Client_reportFrame);
			Thread.sleep(2000);
			if ((ExistsCheck(
					"//br/parent::div[contains(text(),'" + testdatamap.get("Invoice Contract").toString() + "')]"))) {
				Log.ReportEvent("PASS", "Client Acount Statement Search is Successful");

			} else {
				Log.ReportEvent("FAIL", "Client Acount Statement Search is Unsuccessful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
			Thread.sleep(2000);
			switchBacktoParentwindow();

		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Client Acount Statement Search is Unsuccessful");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}

	}

	public void Fromdate(Map<Object, Object> testdatamap) throws Exception {
		WebClick(EdaatOR.Biller_Dashboard_FromDate);
		Thread.sleep(1000);
		selectDropdownValue_PartialText(EdaatOR.Client_ClientAccountStatement_Fromyear,
				testdatamap.get("FromYear").toString());
		Thread.sleep(1000);
		selectDropdownValue_PartialText(EdaatOR.Client_ClientAccountStatement_FromMonth,
				testdatamap.get("FromMonth").toString());
		Thread.sleep(1000);
		WebClick("//a[text()='" + testdatamap.get("FromDate").toString() + "']");

	}

	public void Todate(Map<Object, Object> testdatamap) throws Exception {
		WebClick(EdaatOR.Client_ClientAccountStatement_TODate);
		Thread.sleep(1000);
		selectDropdownValue_PartialText(EdaatOR.Client_ClientAccountStatement_Toyear,
				testdatamap.get("ToYear").toString());
		Thread.sleep(1000);
		selectDropdownValue_PartialText(EdaatOR.Client_ClientAccountStatement_ToMonth,
				testdatamap.get("ToMonth").toString());
		Thread.sleep(1000);
		WebClick("//a[text()='" + testdatamap.get("ToDate").toString() + "']");

	}

	// Function Summary : Method to Verify Client Account Statement Report.
	// Parameter Summary : BillerName,Invoice
	// Contract,FromYear,FromMonth,FromDate,ToYear,ToMonth,ToDate,ClientName
	public void VerifySerachFunctionalityErrorMsg(Map<Object, Object> testdatamap, Log Log) {
		try {
			navigateToClientAccountStatement(Log);
			Thread.sleep(2000);
			String Error = testdatamap.get("Type").toString();
			if (Error.equalsIgnoreCase("FromandTo")) {
				selectDropdownValue_PartialText(EdaatOR.Client_ClientAccountStatement_BillerName,
						testdatamap.get("BillerName").toString());
				Thread.sleep(1000);
				WebClick(EdaatOR.Client_ClientAccountStatement_SearchBtn);
				if (getText(EdaatOR.Client_ClientAccountStatement_FromerrorMsg)
						.equals(testdatamap.get("ErrorMessage").toString())
						&& getText(EdaatOR.Client_ClientAccountStatement_ToerrorMsg)
								.equals(testdatamap.get("ErrorMessage").toString())) {

					Log.ReportEvent("PASS", "Error Message Verification for From amd To date is Successful");

				} else {
					Log.ReportEvent("Fail", "Error Message Verification for From amd To date is Unsuccessful");
					takeScreenShot();
					driver.quit();
					Assert.fail();

				}

			}
			if (Error.equalsIgnoreCase("Todate")) {
				selectDropdownValue_PartialText(EdaatOR.Client_ClientAccountStatement_BillerName,
						testdatamap.get("BillerName").toString());
				Thread.sleep(1000);
				Fromdate(testdatamap);
				Thread.sleep(1000);
				WebClick(EdaatOR.Client_ClientAccountStatement_SearchBtn);
				if (getText(EdaatOR.Client_ClientAccountStatement_ToerrorMsg)
						.equals(testdatamap.get("ErrorMessage").toString())) {

					Log.ReportEvent("PASS", "Error Message Verification for To Date is Successful");

				} else {
					Log.ReportEvent("Fail", "Error Message Verification for To Date is Unsuccessful");
					takeScreenShot();
					driver.quit();
					Assert.fail();

				}
			}
			if (Error.equalsIgnoreCase("Fromdate")) {
				selectDropdownValue_PartialText(EdaatOR.Client_ClientAccountStatement_BillerName,
						testdatamap.get("BillerName").toString());
				Thread.sleep(1000);
				Todate(testdatamap);
				Thread.sleep(1000);
				WebClick(EdaatOR.Client_ClientAccountStatement_SearchBtn);
				if (getText(EdaatOR.Client_ClientAccountStatement_FromerrorMsg)
						.equals(testdatamap.get("ErrorMessage").toString())) {

					Log.ReportEvent("PASS", "Error Message Verification for From Date is Successful");

				} else {
					Log.ReportEvent("Fail", "Error Message Verification for From Date is Unsuccessful");
					takeScreenShot();
					driver.quit();
					Assert.fail();

				}
			}
			if (Error.equalsIgnoreCase("BillerName")) {
				selectDropdownValue_PartialText(EdaatOR.Client_ClientAccountStatement_BillerName,
						testdatamap.get("BillerName").toString());
				Fromdate(testdatamap);
				Thread.sleep(1000);
				Todate(testdatamap);
				Thread.sleep(1000);
				Thread.sleep(1000);
				WebClick(EdaatOR.Client_ClientAccountStatement_SearchBtn);
				if (getText(EdaatOR.Client_ClientAccountStatement_BillernameerrorMsg)
						.equals(testdatamap.get("ErrorMessage").toString())) {

					Log.ReportEvent("PASS", "Error Message Verification for To Date is Successful");

				} else {
					Log.ReportEvent("Fail", "Error Message Verification for Biller Name is Unsuccessful");
					takeScreenShot();
					driver.quit();
					Assert.fail();

				}
			}
		} catch (Exception e) {
			Log.ReportEvent("Fail", "Error Message Verification for To Date is Unsuccessful");
			takeScreenShot();
			driver.quit();
			Assert.fail();

		}

	}
	// VerifyValue1(WebGetText(EdaatOR.Client_ClientAccountStatement_Reportclientname),testdatamap.get("ClientName").toString());
	// Thread.sleep(2000);
}