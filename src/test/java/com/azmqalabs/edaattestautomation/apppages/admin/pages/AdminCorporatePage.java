/**
 *
 * Test Script Name                   : N/A
 * Objective                          : Corporate client functionality.
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

public class AdminCorporatePage extends BasePage {

	public AdminCorporatePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.Biller_Corporate)
	public WebElement Client;

	public boolean Exists() {
		return super.Exists(Client);
	}

	// Function Summary : Method to navigate to Corporate client lists
	// Parameter Summary : N/A
	public void navigateToCorporateClientsList(Log Log) throws Exception {
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Admin_Client);
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Admin_Add_Companyclient);
		Thread.sleep(2000);
		if (CheckElementExists(EdaatOR.Admin_Receivables_CorpoClientList_Page)) {
			Log.ReportEvent("PASS", "Corporate Clients List page is Loaded Successfully");
		} else {
			Log.ReportEvent("FAIL", "Corporate Clients List page is not Loaded Successfully");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}

	}

	// Function Summary : Method to BillerSearchCorporateclient
	// Parameter Summary : ClientRefno
	public boolean BillerSearchCorporateclient(String ClientRefno) {
		boolean existsElement = false;
		try {
			Thread.sleep(3000);
			WebEdit(EdaatOR.Admin_Individualclient_CustomerRefNumber, ClientRefno);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Individualclient_Search);
			Thread.sleep(5000);
			waitForPageToLoad();
			if (CheckElementExists("//td[text()='" + ClientRefno + "']") == true) {
				existsElement = true;
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return existsElement;
	}

	// Function Summary :To search and view corporate Client details in grid.
	// Parameter Summary :CorporateName
	public void TableGridview(String CorporateName, Log Log) {
		try {
			Thread.sleep(2000);
			WebClear(EdaatOR.Admin_Corporateclient_search);
			WebEdit(EdaatOR.Admin_Corporateclient_search, CorporateName);
			WebClick(EdaatOR.Admin_Individualclient_Search);
			Thread.sleep(1000);
			WebClick("//span[contains(text(),'" + CorporateName + "')]");
			Thread.sleep(1000);
			switchTonextwindow();
			scrollDowntillend(driver);
			if (CheckElementExists(EdaatOR.Admin_Individualclient_Back)) {
				WebClick(EdaatOR.Admin_Individualclient_Back);
				Log.ReportEvent("PASS", "Corporate client grid view is Successful");
			} else {
				Log.ReportEvent("FAIL", "Corporate client grid view is not Successful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Corporate client grid view is not Successful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	// Function Summary : To active and Deactive client.
	// Parameter Summary : CorporateName
	public void ActivateDactivate(String CorporateName, Map<Object, Object> testdatamap, Log Log) {
		try {
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Corporateclient_search, CorporateName);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_Individualclient_Search);
			Thread.sleep(2000);
			verifyElementIsPresent(EdaatOR.Admin_Company_ToggleBtn);
			WebClickUsingJS(EdaatOR.Admin_Company_ToggleBtn);
			Thread.sleep(500);

			String actualvalue1 = getText(EdaatOR.Admin_Compan_ActivePop);
			if (actualvalue1.equals(testdatamap.get("Active").toString())) {
				VerifyValue1(getText(EdaatOR.Admin_Compan_ActivePop), testdatamap.get("Active").toString());
			} else {
				Log.ReportEvent("FAIL", "Corporate Client Activation is not Successful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
			WebClickUsingJS(EdaatOR.Admin_Compan_ActiveConfbtn);
			Thread.sleep(2000);

			WebClickUsingJS(EdaatOR.Admin_Company_ToggleBtn);
			Thread.sleep(2000);

			if (getText(EdaatOR.Admin_Compan_ActivePop).equals(testdatamap.get("InActive").toString())) {
				WebClickUsingJS(EdaatOR.Admin_Compan_ActiveConfbtn);
				Log.ReportEvent("PASS", "Corporate Client Activate/Deactivate is Successful");
			} else {
				Log.ReportEvent("FAIL", "Corporate Client Activate/Deactivate is not Successful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}

		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Corporate Client Activate/Deactivate is not Successful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	// Function Summary : Method to Export
	// Parameter Summary : N/A
	public void Export(Log Log) {
		try {
			Thread.sleep(1000);
			if (CheckElementExists(EdaatOR.Admin_Individualclient_export)) {
				WebClick(EdaatOR.Admin_Individualclient_export);
				Log.ReportEvent("PASS", "Export to Excel is Successful");
			} else {
				Log.ReportEvent("FAIL", "Export to Excel is not Successful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Export to Excel is not Successful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	// Function Summary : Method to navigate to corporate client, search client and
	// verify client is displayed
	// Parameter Summary : CRNumber
	public void AdminSearchCorporateclientall(String CRNumber, String CorporateName, String Corporateno, Log Log) {
		try {
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Add_Companyclient);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Corporateclient_Rno, CRNumber);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_CorporateclientName, CorporateName);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Individualclient_CustomerRefNumber, Corporateno);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Individualclient_Search);
			Thread.sleep(3000);

			if (CheckElementExists("//td[text()='" + CRNumber + "']")) {
				Log.ReportEvent("PASS", "Search Corporate Client is Successful");
			} else {
				Log.ReportEvent("FAIL", "Search Corporate Client is not Successful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}

		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Search Corporate Client is not Successful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	// Function Summary : Method to AddCorpclient
	// Parameter Summary :
	// CorporateName,CRNumber,PersonName,Email,MobileNo,ClientRefno
	public void AddCorpclient(String CorporateName, String CRNumber, String PersonName, String PersonID,
			String MobileNo, String Email, String ClientRefno, Log Log) {
		try {
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_Add_Individualclient_Button);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Corporateclient_name, CorporateName);
			WebEdit(EdaatOR.Admin_Corporateclient_Rno, CRNumber);
			WebClick(EdaatOR.Admin_Corporateclient_lang);
			WebEdit(EdaatOR.Admin_Corporateclient_commissioner, PersonName);
			WebEdit(EdaatOR.Admin_Corporateclient_commissionerID, PersonID);
			WebEdit(EdaatOR.Admin_Corporateclient_commissioner_Email, Email);
			WebEdit(EdaatOR.Admin_Corporateclient_commissioner_Mobile, MobileNo);
			WebEdit(EdaatOR.Admin_Corporateclient_commissioner_Crno, ClientRefno);

			WebClick(EdaatOR.Admin_Individualclient_Add);
			Thread.sleep(1000);
			if (CheckElementExists(EdaatOR.Biller_ClientRefExistsAlertMsg)
					|| CheckElementExists(EdaatOR.Admin_AddCorporateClient_error)) {
				Log.ReportEvent("FAIL", "Add Corporate Clients is not Successful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			} else {
				Log.ReportEvent("PASS", "Add Corporate Clients is Successful");

			}

		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Add Corporate Clients is not Successful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	// Function Summary : Method to DeleteCorporateClient
	// Parameter Summary : N/A
	public void DeleteCorporateClient(String CorporateName, String CRNumber, String PersonName, String PersonID,
			String MobileNo, String Email, String ClientRefno, String ResonforDelete, Log Log) {
		AddCorpclient(CorporateName, CRNumber, PersonName, PersonID, MobileNo, Email, ClientRefno, Log);
		AdminSearchCorporateclientall(CRNumber, CorporateName, ClientRefno, Log);
		DeleteCorpClient(ClientRefno, ResonforDelete, Log);

	}

	// Function Summary : Method to DeleteCorpClient
	// Parameter Summary : ClientRefno
	public void DeleteCorpClient(String ClientRefno, String ResonforDelete, Log Log) {
		try {
			if (getText("//td[text()='" + ClientRefno + "']").equals(ClientRefno)) {
				selectDropdownValue_PartialText(EdaatOR.Admin_Invoice_Delete, "Delete");
				Thread.sleep(2000);
				WebClick(EdaatOR.Admin_Invoice_Reasontxt);
				Thread.sleep(1000);
				WebClick("//ul/li[contains(text(),'" + ResonforDelete + "')]");
				WebClick(EdaatOR.Admin_Invoice_Deletebtn);
				Thread.sleep(3000);
				WebEdit(EdaatOR.Admin_Individualclient_CustomerRefNumber, ClientRefno);
				Thread.sleep(2000);
				WebClick(EdaatOR.Admin_Invoice_Deletechkbox);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Admin_Individualclient_Search);
				Thread.sleep(4000);

				if (CheckElementExists("//td[text()='" + ClientRefno + "']")) {
					Log.ReportEvent("PASS", "Delete Corporate client is Successful");
				} else {
					Log.ReportEvent("FAIL", "Delete Corporate client is not Successful");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
				}

			}

		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Delete Corporate client is not Successful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	// Function Summary : Method to Navigate to corporate client,edit and save the
	// client details
	// Parameter Summary : CorporateName,
	// PersonName,PersonID,MobileNo,Email,ClientRefno
	public void UpdateCorpClient(String CorporateName, String CRNumber, String PersonName, String PersonID,
			String ClientRefno, String MobileNo, String Email, Log Log) {
		try {
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Biller_Invoice_Delete, "Edit");
			switchTonextwindow();
			WebClear(EdaatOR.Admin_Corporateclient_name);
			WebEdit(EdaatOR.Admin_Corporateclient_name, CorporateName);
			WebClear(EdaatOR.Admin_Corporateclient_commissioner);
			WebEdit(EdaatOR.Admin_Corporateclient_commissioner, PersonName);
			WebClear(EdaatOR.Admin_Corporateclient_commissionerID);
			WebEdit(EdaatOR.Admin_Corporateclient_commissionerID, PersonID);
			WebClear(EdaatOR.Admin_Corporateclient_commissioner_Mobile);
			WebEdit(EdaatOR.Admin_Corporateclient_commissioner_Mobile, MobileNo);
			WebClear(EdaatOR.Admin_Corporateclient_commissioner_Email);
			WebEdit(EdaatOR.Admin_Corporateclient_commissioner_Email, Email);
			// WebClear(EdaatOR.Admin_Corporateclient_commissioner_Crno);
			WebEdit(EdaatOR.Admin_Corporateclient_commissioner_Crno, ClientRefno);
			Thread.sleep(1000);

			WebClickUsingJS(EdaatOR.Admin_Corporateclient_Save);
			Thread.sleep(5000);
			if (CheckElementExists("(//span[text()='" + CorporateName + "'])[1]")) {
				Log.ReportEvent("PASS", "Update corporate client is Successful");
			} else {
				Log.ReportEvent("FAIL", "Update corporate client is not Successful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}

		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Update corporate client is not Successful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	// Function Summary : Method to select sub biller
	// Parameter Summary : SubBiller.
	public void selectSubbiller(Map<Object, Object> testdatamap) throws Exception {
		Thread.sleep(1000);
		WebClick(EdaatOR.Admin_Invoice_SBilIdList);
		Thread.sleep(1000);
		WebClick(EdaatOR.Admin_Invoice_ClientRoleId + "[" + testdatamap.get("SubBiller").toString() + "]");
		waitForPageToLoad();
		Thread.sleep(1000);
	}

	public void SelectInvoiceTemplate(String sel, String Tem) throws InterruptedException {
		Thread.sleep(500);
		selectDropdownValue_PartialText(sel, Tem);
	}

	public void ClickOnProductBtn() {
		WebClickUsingJS(EdaatOR.Admin_Invoice_AddProductBtn);
		waitForPageToLoad();
	}

	public void SelectProduct(String Cust) {
		WebSelect(EdaatOR.Admin_Invoice_ProductID, Cust);
		waitForPageToLoad();
	}

	// Function Summary : Method to click on "Add Product" button
	// Parameter Summary : N/A
	public void ClickOnProductAddBtn() throws Exception {
		WebClick(EdaatOR.Admin_Invoice_AddBtn);
		waitForPageToLoad();
	}

	// Function Summary : Method to enter issue due date
	// Parameter Summary : Issue due date
	public void EnterIssuedDate() throws Exception {
		Thread.sleep(2000);
		WebClick(EdaatOR.Admin_Invoice_DateInvoc);
		Thread.sleep(1000);
		WebClick(EdaatOR.Admin_RegistDate_exprDate);
	}

	public void SelectDuration(String dur) {
		WebSelect(EdaatOR.Admin_Invoice_DurationID, dur);
		waitForPageToLoad();
	}

	public void EnterMinPrice(String Price) throws Exception {
		WebEdit(EdaatOR.Admin_Invoice_MinTax, Price);
		waitForPageToLoad();
	}

	public void EnterFixedPrice(String Price) throws Exception {
		WebEdit(EdaatOR.Admin_Invoice_Fixed, Price);
		waitForPageToLoad();
	}

	// Function Summary : Method to click on "Create invoice" button
	// Parameter Summary : N/A.
	public void ClickOnSaveBtn() {
		WebClickUsingJS(EdaatOR.Admin_Invoice_Create);
		waitForPageToLoad();
	}

	public void ClickOnExportBtn() {
		WebClickUsingJS(EdaatOR.Admin_Invoice_ExportButton);
		waitForPageToLoad();
	}

	public void EnterCondition(String Price) throws Exception {
		WebEdit(EdaatOR.Admin_Invoice_Conditon, Price);
		waitForPageToLoad();
	}

	public void EnterPercentage(String Price) throws Exception {
		WebEdit(EdaatOR.Admin_Invoice_Percentage, Price);
		waitForPageToLoad();
	}

	public void ClickOnCreateInvoiceBtn() {
		WebClickUsingJS(EdaatOR.Admin_Invoice_CreateReapeat);
		waitForPageToLoad();
	}

	public void EnterDescriptionSaved(String Price) throws Exception {
		WebEdit(EdaatOR.Admin_Invoice_Descript, Price);
		waitForPageToLoad();
	}

	public void EnterDescriptionOne(String Price) throws Exception {
		WebEdit(EdaatOR.Admin_Invoice_Descript1, Price);
		waitForPageToLoad();
	}

	public void WebSelectByVisibleText(String sEleXpath, String sText) {
		try {
			Select select = new Select(driver.findElement(By.xpath(sEleXpath)));
			select.selectByVisibleText(sText);
		} catch (Exception e) {
			// Code to reset implicit wait and select value and then reset implicit wait
			Select select1 = new Select(driver.findElement(By.xpath(sEleXpath)));
			select1.selectByVisibleText(sText);
			test.log(Status.INFO, "WebSelectByVisibleText - Not Found");
		}
	}

	public void selectTemplate(String drop, Map<Object, Object> testdatamap) throws Exception {

		Thread.sleep(500);
		waitForPageToLoad();

		waitForPageToLoad();
	}

	// Function Summary : Method to add ProductPrice
	// Parameter Summary : Price
	public void EnterProductPrice(String Price) throws Exception {
		Thread.sleep(1000);
		WebClearUsingKeys(EdaatOR.Admin_Invoice_TaxPric);
		WebEdit(EdaatOR.Admin_Invoice_TaxPric, Price);
		waitForPageToLoad();
	}

	// Function Summary : Method to add product
	// Parameter Summary : ProductName, ProductPrice
	public void addProductDetails(Map<Object, Object> testdatamap) throws Exception {
		Thread.sleep(1000);
		ClickOnProductBtn();
		Thread.sleep(1000);
		SelectProduct(testdatamap.get("ProductName").toString());
		Thread.sleep(2000);
		waitForPageToLoad();
		EnterProductPrice(testdatamap.get("ProductPrice").toString());
		ClickOnProductAddBtn();
		Thread.sleep(500);
	}

	// Function Summary : Method to click on Terms
	// Parameter Summary : N/A
	public void EnterCondition() {
		WebClickUsingJS(EdaatOR.Admin_Invoice_Conditonbtn);
		waitForPageToLoad();
	}

	// Function Summary : Method to enter Invoice issue due date and terms
	// Parameter Summary : N/A
	public void enterInvoicDetails(Map<Object, Object> testdatamap) throws Exception {
		scrollDowntillend(driver);
		Thread.sleep(2000);
		EnterIssuedDate();
		EnterCondition();
		Thread.sleep(1000);
	}

	public void enterInvoiceCaseType(Map<Object, Object> testdatamap) throws Exception {

		// EnterDescriptionSaved(testdatamap.get("Description").toString());
		// EnterDescriptionOne(testdatamap.get("Description").toString());
		String iType = testdatamap.get("InvoiceType").toString();
		if (iType.equalsIgnoreCase("Save")) {
			ClickOnSaveBtn();
		} else if (iType.equalsIgnoreCase("Export")) {
			ClickOnExportBtn();
		}
		Thread.sleep(1000);
	}

	// Function Summary :To get invoice count
	// Parameter Summary :TemplateName.
	public int getInvoiceCountAdd() {
		List<WebElement> invoice = driver.findElements(By.xpath(EdaatOR.Biller_Invoice_AfteraddInvoice));
		waitForPageToLoad();
		int count = invoice.size();
		return count;
	}

	// Function Summary :Navigate to corporate client,create and verify invoice for
	// the Corporate client
	// Parameter Summary :TemplateName.
	public void CreateCorporateClientInvoice(Map<Object, Object> testdatamap, Log Log) throws Exception {
		try {
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Add_Companyclient);
			Thread.sleep(2000);
			selectDropdownValue_PartialText(EdaatOR.Admin_Invoice_Delete, "Create Invoice");
			switchTonextwindow();
			selectSubbiller(testdatamap);
			Thread.sleep(2000);
			WebSelect(EdaatOR.Admin_Invoice_TemplateList, testdatamap.get("TemplateName").toString());
			waitForPageToLoad();
			addProductDetails(testdatamap);
			enterInvoicDetails(testdatamap);
			Thread.sleep(800);
			ClickOnSaveBtn();
			Thread.sleep(2000);
			waitForPageToLoad();
			int val = getInvoiceCountAdd();
			if (CheckElementExists(EdaatOR.Admin_Invoice_AfteraddInvoice + "[" + val + "]/td[10]") == true) {
				Log.ReportEvent("PASS", "Create Corporate Client Invoice is Successfull");
			} else {
				Log.ReportEvent("FAIL", "Create Corporate Client Invoice is not Successfull");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}

		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Create Corporate Client Invoice is not Successfull");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	public void ViewCorporateClientInvoice(Map<Object, Object> testdatamap, Log Log) throws Exception {
		try {
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_CorporateName, testdatamap.get("CorporateName").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_CR_Number, testdatamap.get("CRNumber").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_ClientRef_Number, testdatamap.get("ClientReferenceNumber").toString());
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_ClientSearch_button);
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Admin_Invoice_Delete, "View Invoice");
			switchTonextwindow();

			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_Invoice_view);
			Thread.sleep(2000);
			switchTonextwindow();

			if (CheckElementExists(EdaatOR.Admin_Invoice_form)) {
				Log.ReportEvent("PASS", "View Corporate Client Invoice is Successfull");
			} else {
				Log.ReportEvent("FAIL", "View Corporate Client Invoice is not Successfull");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}

		} catch (Exception e) {
			Log.ReportEvent("FAIL", "View Corporate Client Invoice is not Successfull");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	// Function Summary : method to verify Error messages in Add Corporate client
	// page
	// Parameter Summary :
	// FullName,SecondName,ThirdName,LastName,NationalID,Year,Month,Date,MobileNo,Email
	// and Refno.
	public void VerifyAddCorpClietErrorMsg(String CorporateName, String CRNumber, String PersonName, String PersonID,
			String MobileNo, String Email, String ClientRefno, String ExpectedResult, Log Log)
			throws InterruptedException {
		{
			try {
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Admin_Add_Individualclient_Button);
				Thread.sleep(1000);
				WebEdit(EdaatOR.Admin_Corporateclient_name, CorporateName);
				WebEdit(EdaatOR.Admin_Corporateclient_Rno, CRNumber);
				WebClick(EdaatOR.Admin_Corporateclient_lang);
				WebEdit(EdaatOR.Admin_Corporateclient_commissioner, PersonName);
				WebEdit(EdaatOR.Admin_Corporateclient_commissionerID, PersonID);
				WebEdit(EdaatOR.Admin_Corporateclient_commissioner_Email, Email);
				WebEdit(EdaatOR.Admin_Corporateclient_commissioner_Mobile, MobileNo);
				WebEdit(EdaatOR.Admin_Corporateclient_commissioner_Crno, ClientRefno);
				Thread.sleep(1000);
				WebClick(EdaatOR.Admin_Individualclient_Add);
				Thread.sleep(50);
				if (CheckElementExists(EdaatOR.Admin_ClientRefExistsAlertMsg)) {
					Log.ReportEvent("PASS",
							"Verify 'Corporate Client Reference number Exists' alert Message is successful");
				} else if (ExistsCheck(EdaatOR.Admin_RequiredFieldsErrMsg)) {

					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_RequiredCorpNameErrMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_RequiredCRNoErrMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_RequiredAuthNameErrMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_RequiredAuthIDErrMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_RequiredAuthMobileNoErrMsg));
					Log.ReportEvent("PASS", "Verify 'This field is required' error Message is successful");

				} else if (ExpectedResult.equals(getText(EdaatOR.Admin_RequiredCRNoErrMsg))) {

					Log.ReportEvent("PASS", "Verify Error message for CR Number is successful");
				} else if (ExpectedResult.equals(getText(EdaatOR.Admin_RequiredAuthIDErrMsg))) {

					Log.ReportEvent("PASS", "Verify Error message for Authorized person ID is successful");

				} else if (ExpectedResult.equals(getText(EdaatOR.Admin_RequiredAuthMobileNoErrMsg))) {

					Log.ReportEvent("PASS", "Verify Error message for Mobile No is successful");

				}

				else {
					Log.ReportEvent("FAIL", "Verify Add Corporate Client error Message is not successful");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
				}

			} catch (Exception e) {
				Log.ReportEvent("FAIL", "Verify Add Corporate Client error Message is not successful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}

		}

	}

	// Function Summary : method to verify Error messages in Add Corporate client
	// page
	// Parameter Summary :
	// FullName,SecondName,ThirdName,LastName,NationalID,Year,Month,Date,MobileNo,Email
	// and Refno.
	public void VerifyEditCorpClietErrorMsg(String CorporateName, String CRNumber, String PersonName, String PersonID,
			String MobileNo, String Email, String ClientRefno, String ExpectedResult, Log Log) throws Exception {
		{
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Biller_Invoice_Delete, "Edit");
			switchTonextwindow();
			WebClear(EdaatOR.Admin_Corporateclient_name);
			WebEdit(EdaatOR.Admin_Corporateclient_name, CorporateName);
			WebClear(EdaatOR.Admin_Corporateclient_commissioner);
			WebEdit(EdaatOR.Admin_Corporateclient_commissioner, PersonName);
			WebClear(EdaatOR.Admin_Corporateclient_commissionerID);
			WebEdit(EdaatOR.Admin_Corporateclient_commissionerID, PersonID);
			WebClear(EdaatOR.Admin_Corporateclient_commissioner_Mobile);
			WebEdit(EdaatOR.Admin_Corporateclient_commissioner_Mobile, MobileNo);
			WebClear(EdaatOR.Admin_Corporateclient_commissioner_Email);
			WebEdit(EdaatOR.Admin_Corporateclient_commissioner_Email, Email);
			WebClear(EdaatOR.Admin_Corporateclient_commissioner_Crno);
			WebEdit(EdaatOR.Admin_Corporateclient_commissioner_Crno, ClientRefno);
			Thread.sleep(1000);

			WebClickUsingJS(EdaatOR.Admin_Corporateclient_Save);

			try {
				if (ExpectedResult.equals(getText(EdaatOR.Admin_ClientRefExistsAlertMsg))) {
					Log.ReportEvent("PASS",
							"Verify 'Corporate Client Reference number Exists' alert Message is successful");

				} else if (ExistsCheck(EdaatOR.Admin_RequiredFieldsErrMsg)) {

					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_RequiredCorpNameErrMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_RequiredAuthNameErrMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_RequiredAuthIDErrMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_RequiredAuthMobileNoErrMsg));
					Log.ReportEvent("PASS", "Verify 'This field is required' error Message is successful");

				} else if (ExpectedResult.equals(getText(EdaatOR.Admin_RequiredAuthIDErrMsg))) {
					Log.ReportEvent("PASS", "Verify Error message for Authorized person ID is successful");

				} else if (ExpectedResult.equals(getText(EdaatOR.Admin_RequiredAuthMobileNoErrMsg))) {

					Log.ReportEvent("PASS", "Verify Error message for Mobile No is successful");

				}

				else {
					Log.ReportEvent("FAIL", "Verify Edit Corporate Client error Message is not successful");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
				}

			} catch (Exception e) {
				Log.ReportEvent("FAIL", "Verify Edit Corporate Client error Message is not successful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}

		}

	}

	// Function Summary : method to verify Error messages in delete Corporate client
	// page
	// Parameter Summary : ExpectedResult
	public void VerifyDeleteCorpClietErrorMsg(String ExpectedResult, Log Log) throws InterruptedException {
		{
			try {
				Thread.sleep(1000);
				selectDropdownValue_PartialText(EdaatOR.Admin_Invoice_Delete, "Delete");
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_Invoice_Deletebtn);

				if (ExpectedResult.equals(getText(EdaatOR.Admin_DeleteClientErrMsg))) {
					Log.ReportEvent("PASS", "Verify Delete Corporate CLient Error message is successful");
				}

				else {
					Log.ReportEvent("FAIL", "Verify Delete Corporate CLient Error message is not successful");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
				}

			} catch (Exception e) {
				Log.ReportEvent("FAIL", "Verify Delete Corporate CLient Error message is not successful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}

		}

	}

}
