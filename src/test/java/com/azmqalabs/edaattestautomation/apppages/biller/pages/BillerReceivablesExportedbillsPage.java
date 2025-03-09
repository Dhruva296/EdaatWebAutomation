/**
*
* Test Script Name                      : N/A.
* Objective                             : Verify biller Receviable functionality.
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
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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



public class BillerReceivablesExportedbillsPage extends BasePage
{

	public BillerReceivablesExportedbillsPage(WebDriver driver,ExtentTest test)
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


	public void ClickOnBReceivableLink() {
		WebClickUsingJS(EdaatOR.Biller_Receivable_Link);
		waitForPageToLoad();
	}
	//Function Summary   : Method to Click on Exported bills.
	//Parameter Summary :  N/A.
	public void ClickOnBillerExportBillLink() {
		WebClickUsingJS(EdaatOR.Biller_ExportBill_Link);
		waitForPageToLoad();
	}
	//Function Summary   : Method to Click on Add Invoice button.
	//Parameter Summary :  N/A.
	public void ClickOnExportInvoiceBtn() {
		WebClickUsingJS(EdaatOR.Biller_AddInvoice_btn);
		waitForPageToLoad();
	}
	//Function Summary   : Method to Check Corporate radio button.
	//Parameter Summary :  N/A.

	public void ClickOnCoporateRadBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_CopoRdv);
		waitForPageToLoad();
	}
	//Function Summary   : Method to Check Individual radio button.
	//Parameter Summary :  N/A.
	public void ClickOnIndividualRadBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_IndividualRdv);
		waitForPageToLoad();
	}
	//Function Summary   : Method to Check Subbiller Individual radio button.
		//Parameter Summary :  N/A.
	public void ClickOnSubIndividualRadBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_subIndividualRdv);
		waitForPageToLoad();
	}


	//Function Summary   : Method to Select the Individual ClientName/id in Create Invoice page.
	//Parameter Summary :  N/A.
	public void SelectIndCustomerID(String Cust) throws Exception {

		WebClick(EdaatOR.Biller_Invoice_CustIDList);
		Thread.sleep(2000);
		WebClick(EdaatOR.Biller_Invoice_ClientRoleId+"["+Cust+"]");
		waitForPageToLoad();
	}

	public void SelectCopCustomerID(String Cust) throws Exception {

		WebClick(EdaatOR.Biller_Invoice_ComCustIDList);
		Thread.sleep(2000);
		WebClick(EdaatOR.Biller_Invoice_ClientRoleId+"["+Cust+"]");
		waitForPageToLoad();
	}

	public void SelectSubBiller(String SubBiller) throws Exception {
		//WebSelect1(EdaatOR.Biller_Invoice_SBilIdList,SubBiller);
		WebClick(EdaatOR.Biller_Invoice_SBilIdList);
		Thread.sleep(2000);
		WebClick(EdaatOR.Biller_Invoice_ClientRoleId+"["+SubBiller+"]");
		
		waitForPageToLoad();
        Thread.sleep(2000);
	}

	public void SelectInvoiceTemplate(String Tem) {
		WebSelect(EdaatOR.Biller_Invoice_TemplateList,Tem);
		waitForPageToLoad();
	}
	//Function Summary   : Method to Click add product.
	//Parameter Summary :  N/A.

	public void ClickOnProductBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_AddProductBtn);
		waitForPageToLoad();
	}
	//Function Summary   : Method to Select product.
	//Parameter Summary :  N/A.

	public void SelectProduct(String Cust) throws Exception {
		WebClick(EdaatOR.Biller_Invoice_ProductID);
		WebSelect(EdaatOR.Biller_Invoice_ProductID,Cust);
		waitForPageToLoad();
	}
	//Function Summary   : Method to Enter product price.
	//Parameter Summary :  Price.

	public void EnterProductPrice(String Price) throws Exception {
		Thread.sleep(1000);
		WebClearUsingKeys(EdaatOR.Biller_Invoice_TaxPric);
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Invoice_TaxPric,Price);
		waitForPageToLoad();
	}
	//Function Summary   : Method to Click on Add product button.
	//Parameter Summary :  N/A.

	public void ClickOnProductAddBtn() throws Exception {
		WebClick(EdaatOR.Biller_Invoice_AddBtn);
		waitForPageToLoad();
	}
	//Function Summary   : Method to Enter issued date in invoice page.
	//Parameter Summary :  N/A.

	public void EnterIssuedDate() throws Exception {
		Thread.sleep(2000);
		WebClick(EdaatOR.Biller_Invoice_DateInvoc);
		Thread.sleep(800);
		WebClick(EdaatOR.Biller_RegistDate_exprDate);
	}
	//Function Summary   : Method to Select duration in invoice page.
	//Parameter Summary :  N/A.

	public void SelectDuration(String dur) {
		if(CheckElementExists(EdaatOR.Biller_Invoice_DurationID)) {
			WebClickUsingJS(EdaatOR.Biller_Invoice_DurationID);
			WebSelect1(EdaatOR.Biller_Invoice_DurationID,dur);
			waitForPageToLoad();
		}
	}
	public void SelectDurationinstall(String dur) throws Exception {
		if(CheckElementExists(EdaatOR.Biller_Invoice_DurationID)) {
			WebClick(EdaatOR.Biller_Invoice_DurationID);
			WebClick(dur);
			waitForPageToLoad();
		}
	}
	//Function Summary   : Method to Enter Minimum price.
	//Parameter Summary :  N/A.
	public void EnterMinPrice(String Price) throws Exception {
		if(CheckElementExists(EdaatOR.Biller_Invoice_MinTax)) {
			WebEdit(EdaatOR.Biller_Invoice_MinTax,Price);
			waitForPageToLoad();
		}
	}
	//Function Summary   : Method to Check Condition Checkbox.
	//Parameter Summary :  N/A.
	public void EnterCondition() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_Conditonbtn);
		waitForPageToLoad();
	}
	//Function Summary   : Method to Click on Create and Save Button.
	//Parameter Summary :  N/A.
		public void ClickOnCreateInvoiceBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_Createandsave);
		waitForPageToLoad();
	}

	public void EnterDescriptionSaved(String Price) throws Exception {
		WebEdit(EdaatOR.Biller_Invoice_Descript,Price);
		waitForPageToLoad();
	}

	public void EnterDescriptionOne(String Price) throws Exception {
		WebEdit(EdaatOR.Biller_Invoice_Descript1,Price);
		waitForPageToLoad();
	}
	//Function Summary   : Method to Click on Save button.
	//Parameter Summary :  N/A.
	public void ClickOnSaveBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_SaveButton);
		waitForPageToLoad();
	}
	//Function Summary   : Method to Click on Installment button.
	//Parameter Summary :  N/A.
	public void ClickOninstallmentBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_installmentButton);
		waitForPageToLoad();
	}
	//Function Summary   : Method to Click on Save button in after click on Installment button.
	//Parameter Summary :  N/A.
	public void ClickOninstallmentSAVEBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_SaveINSTALButton);
		waitForPageToLoad();
	}
	//Function Summary   : Method to Click on Export button.
	//Parameter Summary :  N/A.

	public void ClickOnExportBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_ExportButton);
		waitForPageToLoad();
	}
	public void ClickOnExportandcreatBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_Exportandcreatebtn);
		waitForPageToLoad();
	}
	//Function Summary   : Method to Click on Export button in after click on Installment button.
	//Parameter Summary :  N/A.
	public void ClickOnExportinstallBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_ExportinastallButton);
		waitForPageToLoad();
	}
	//Function Summary   : Method to Check the Checkbox of last record in a table.
	//Parameter Summary :  N/A.

	public void ClickOnLastCheckBoxBtn() {
		WebClickUsingJS(EdaatOR.Biller_InvoiceLastCheckBox);
		waitForPageToLoad();
	}

	public String getBillerID() throws Exception {
		String ID=getText(EdaatOR.Biller_Invoice_GetBilId);
		waitForPageToLoad();
		return ID;
	}

	public String getBillerContactID() throws Exception {
		String ID=getText(EdaatOR.Biller_Invoice_GetContactId);
		waitForPageToLoad();
		return ID;
	}


	public void ClickOnBillerExportContactLink() {
		WebClickUsingJS(EdaatOR.Biller_ExportContact_Link);
		waitForPageToLoad();
	}
	//Function Summary   : Method to Click on Exported Contracts.
	//Parameter Summary :  N/A.

	public void naviagteReveiableExportContact(Log Log) throws InterruptedException {
		ClickOnBReceivableLink();
		ClickOnBillerExportContactLink();
		waitForPageToLoad();
		if (CheckElementExists(EdaatOR.Biller_Exported_Contarcts_Page)) {				
			Thread.sleep(2000);
        	Log.ReportEvent("PASS", "Exported Contracts Page is Loaded Successfully");

	} else {
    	Log.ReportEvent("FAIL", "Exported Contracts Page is Not Loaded Successfully");
		this.takeScreenShot();
		driver.quit();
		Assert.fail();

	}
	}



	public int getInvoiceCount() {
		List<WebElement> invoice = driver.findElements(By.xpath(EdaatOR.Biller_Invoice_Count));
		waitForPageToLoad();
		int count =invoice.size();
		return count;
	}


	public int getInvoiceCountNext() throws Exception {
		int intiCount=0;
		boolean countRow=false;
		while (CheckElementExists(EdaatOR.Biller_Invoice_Next)==false){  
			WebClick(EdaatOR.Biller_Invoice_NextPrevLink);
			int count=getInvoiceCount();
			String pageNum=getText(EdaatOR.Biller_Invoice_NextPrevLink);
			Thread.sleep(1000);
			intiCount=intiCount+getInvoiceCount()+((Integer.valueOf(pageNum)-1)*10);
			countRow=true;
		}

		if(countRow==false) {
			intiCount=10;
		}
		return intiCount;
	}


	public int getInvoiceCountAdd() {
		List<WebElement> invoice = driver.findElements(By.xpath(EdaatOR.Biller_Invoice_AfteraddInvoice));
		waitForPageToLoad();
		int count =invoice.size();
		return count;
	}

	public int getInvoiceCountNextAfteradd() throws Exception {
		int aftCount=0;
		boolean countRow=false;
		while (CheckElementExists(EdaatOR.Biller_Invoice_Next)==false){  
			Thread.sleep(400);
			WebClick(EdaatOR.Biller_Invoice_NextPrevLink);
			int count=getInvoiceCount();
			String pageNum=getText(EdaatOR.Biller_Invoice_NextPrevLink);
			Thread.sleep(1000);
			aftCount=aftCount+getInvoiceCount()+((Integer.valueOf(pageNum)-1)*10);
			countRow=true;
		}

		if(countRow==false) {
			aftCount=10;
		}
		return aftCount;
	}
	//Function Summary   : Method to Navigate Biller Exported Bills.
	//Parameter Summary :  N/A.

	public void navigateToReceivableExportBiller(Log Log) throws InterruptedException {
		try {
		ClickOnBReceivableLink();
		ClickOnBillerExportBillLink();
		waitForPageToLoad();
		if (CheckElementExists(EdaatOR.Biller_Exported_BillsList)) {				
			Thread.sleep(2000);
        	Log.ReportEvent("PASS", "Exported Bills Page is Loaded Successfully");

	} else {
    	Log.ReportEvent("FAIL", "Exported Bills Page is Not Loaded Successfully");
		this.takeScreenShot();
		driver.quit();
		Assert.fail();

	}
}	
		catch (Exception e) {
			Log.ReportEvent("FAIL", "Exported Bills Page is Not Loaded Successfully");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}
	
	//Function Summary   : Method to Navigate Create Invoice page.
	//Parameter Summary :  N/A.
	public void navigateToCreateInvoicePage(Log Log) {
		try {
		ClickOnExportInvoiceBtn();
		waitForPageToLoad();
		if(IsDispalyed(EdaatOR.Admin_AddInvoice_Header)) {
		Log.ReportEvent("PASS", "Create Invoice Page is Loaded Successfully");
		}
		else {
			Log.ReportEvent("FAIL", "Create Invoice Page is Not Loaded Successfully");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "Create Invoice Page is Not Loaded Successfully");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}
	//Function Summary   : Method to Check Individual/Corporate biller/Subbiller radio button.
	//Parameter Summary :  N/A.

	public void enterClientNameOrNationalID(Map<Object,Object> testdatamap) throws Exception {
		String client=testdatamap.get("ClientID").toString();
		if(client.equalsIgnoreCase("Individual")) {
			Thread.sleep(100);
			ClickOnIndividualRadBtn();
			Thread.sleep(500);
			SelectIndCustomerID(testdatamap.get("ClientName").toString());
		}
		else if(client.equalsIgnoreCase("Corporate")){
			Thread.sleep(100);
			ClickOnCoporateRadBtn();
			Thread.sleep(500);
			SelectCopCustomerID(testdatamap.get("ClientName").toString());
		}
		String sBill=testdatamap.get("SubBiller").toString();
		if(!sBill.equalsIgnoreCase(""))
		{
			Thread.sleep(100);
			ClickOnSubIndividualRadBtn();
			Thread.sleep(500);
			SelectSubBiller(sBill);
		}

	}
	public String getClientName() throws Exception
	{
		 String clientName=getText(EdaatOR.Biller_ExportBills_ClientName);    
		 return clientName; 
	}

	//Function Summary   : Method to Select template.
	//Parameter Summary :  TemplateName.

	public void selectTemplate(Map<Object,Object> testdatamap) throws Exception {
		Thread.sleep(100);
		SelectInvoiceTemplate(testdatamap.get("TemplateName").toString());
	}
	//Function Summary   : Method to Add product in Create Invoice page.
	//Parameter Summary :  ProductName,ProductPrice.

	public void addProductDetails(Map<Object,Object> testdatamap) throws Exception {
		ClickOnProductBtn();
		Thread.sleep(300);
		SelectProduct(testdatamap.get("ProductName").toString());
		Thread.sleep(300);
		waitForPageToLoad();
		EnterProductPrice(testdatamap.get("ProductPrice").toString());
        Thread.sleep(500);
		ClickOnProductAddBtn();
		Thread.sleep(1000);

	}
	//Function Summary   : Method to Enter invoice details in Create invoice page.
    //Parameter Summary :  ProductName,ProductPrice.

	public void enterInvoicDetails(Map<Object,Object> testdatamap,Log Log) throws Exception {

		Thread.sleep(300);
			if(testdatamap.get("TemplateName").toString().equalsIgnoreCase("One Time")) {
				
				EnterIssuedDate();
				Thread.sleep(2000);
				if(testdatamap.get("InvoiceType").toString().equalsIgnoreCase("Save")) {

				ClickOnCreateInvoiceBtn();
				Thread.sleep(2000);				
				if(CheckElementExists(EdaatOR.Biller_ExportedBills_ErrorMsg)||CheckElementExists(EdaatOR.Biller_ExportedBills_FieldRequiredErrorMsg))
				{
					WebElement element=driver.findElement(By.xpath(EdaatOR.Biller_AddPaymentMethod));
					scrollToElement(driver, element);
					Log.ReportEvent("FAIL", "Create and Save One Time Invoice is Unsuccessful");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();

				}
				Log.ReportEvent("PASS", "Create and Save One Time Invoice is Successful");
				
			}
				else {
					ClickOnExportandcreatBtn();
					Thread.sleep(2000);
					if(CheckElementExists(EdaatOR.Biller_ExportedBills_ErrorMsg)|| CheckElementExists(EdaatOR.Biller_ExportedBills_FieldRequiredErrorMsg))
					{
						WebElement element=driver.findElement(By.xpath(EdaatOR.Biller_AddPaymentMethod));
						scrollToElement(driver, element);
						Log.ReportEvent("FAIL", "Create and Export One Time Invoice is Unsuccessful");
						this.takeScreenShot();
						driver.quit();
						Assert.fail();

					}
					Log.ReportEvent("PASS", "Create and Export One Time Invoice is Successful");
				}
			}
			else {			
					EnterIssuedDate();
					Thread.sleep(300);
					SelectDuration(testdatamap.get("Duration").toString());
					Thread.sleep(300);
				//	EnterMinPrice(testdatamap.get("MinPrice").toString());
					EnterCondition();
					ClickOninstallmentBtn();
					Thread.sleep(2000);
					if(CheckElementExists(EdaatOR.Biller_ExportedBills_ErrorMsg)|| CheckElementExists(EdaatOR.Biller_ExportedBills_FieldRequiredErrorMsg))
					{
						WebElement element=driver.findElement(By.xpath(EdaatOR.Biller_AddPaymentMethod));
						scrollToElement(driver, element);
						Log.ReportEvent("FAIL", "Create Installment Invoice is Unsuccessful");
						this.takeScreenShot();
						driver.quit();
						Assert.fail();

					}
					else {
						Log.ReportEvent("PASS", "Create Installment Invoice is Successful");

					}
				}
			Thread.sleep(500);
	}
	
			
	//Function Summary   : Method to Enter invoice Description details.
    //Parameter Summary :  Description,InvoiceType.
	public void enterInvoiceCaseSaveType(Map<Object,Object> testdatamap,Log Log) throws Exception {
		if(CheckElementExists(EdaatOR.Biller_Invoice_Descript)==true) {
		EnterDescriptionSaved(testdatamap.get("Description").toString());
		EnterDescriptionOne(testdatamap.get("Description").toString());
		Thread.sleep(800);
		if(testdatamap.get("InvoiceType").toString().equalsIgnoreCase("Save")) {
			ClickOninstallmentSAVEBtn();
			Thread.sleep(800);

			if(CheckElementExists(EdaatOR.Biller_ExportedBills_ErrorMsg)|| CheckElementExists(EdaatOR.Biller_ExportedBills_FieldRequiredErrorMsg))
			{
				Log.ReportEvent("FAIL", "Create Invoice is Unsuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
			Log.ReportEvent("PASS", "Create Invoice is Successful");

		}
		else {
			ClickOnExportinstallBtn();
			Thread.sleep(800);
			if(CheckElementExists(EdaatOR.Biller_ExportedBills_ErrorMsg)|| CheckElementExists(EdaatOR.Biller_ExportedBills_FieldRequiredErrorMsg))
			{
				Log.ReportEvent("FAIL", "Create Invoice is Unsuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
			Log.ReportEvent("PASS", "Create Invoice is Successful");
		}

		}
	
//		String iType=testdatamap.get("InvoiceType").toString();
//		if(testdatamap.get("iType").toString().equalsIgnoreCase("Save")) {
//			ClickOninstallmentSAVEBtn();
//			Thread.sleep(2000);
//		}
//		else//(testdatamap.get("iType").toString().equalsIgnoreCase("Export")) 
//			{
//			ClickOnExportinstallBtn();
//		}
		
		
	
		Thread.sleep(1000);
	}

	//Function Summary   : Method to Enter invoice Description details.
    //Parameter Summary :  Description,saveorexport.
	public void enterInvoiceCaseExportType(Map<Object,Object> testdatamap) throws Exception {
		if(CheckElementExists(EdaatOR.Biller_Invoice_Descript)==true) {
		EnterDescriptionSaved(testdatamap.get("Description").toString());
		Thread.sleep(300);
		EnterDescriptionOne(testdatamap.get("Description").toString());
		Thread.sleep(300);
//		String iType=testdatamap.get("InvoiceType").toString();
//		Thread.sleep(300);
//		ClickOnExportinstallBtn();
	if(testdatamap.get("saveorexport").toString().equalsIgnoreCase("Save")) {
			ClickOninstallmentSAVEBtn();
			Thread.sleep(100);
		}
		else {
			ClickOnExportinstallBtn();
			Thread.sleep(100);

		}
//	ClickOnExportBtn();
		}
		}


	//Function Summary   : Method to create and Save onetime/Recurring invoice.
	//Parameter Summary :  InvoiceType,Save.
	public void createSaveInvoiceData(Map<Object,Object> testdatamap,Log Log) throws Exception {
		//
		try {
			String iType=testdatamap.get("InvoiceType").toString();
			if(iType.equalsIgnoreCase("Save")) {			
				navigateToCreateInvoicePage(Log);
				enterClientNameOrNationalID(testdatamap);
				Thread.sleep(100);
				String clientName=getClientName();
				Thread.sleep(100);
				selectTemplate(testdatamap);
				Thread.sleep(100);
				addProductDetails(testdatamap);
				Thread.sleep(400);
				verifyElementIsPresent(EdaatOR.Biller_ExportBills_PayedOutSideEdaatPaymentMethod);
				Thread.sleep(400);
				verifyElementIsPresent(EdaatOR.Biller_ExportBills_SadadPaymentMethod);			
				Thread.sleep(100);
				enterInvoicDetails(testdatamap,Log);
				Thread.sleep(100);
				waitForPageToLoad();
				ClickOnBillerExportBillLink();	
				try {
				if (CheckElementExists(EdaatOR.Biller_Exported_BillsList)) {					
					Thread.sleep(2000);
						WebElement element=driver.findElement(By.xpath(EdaatOR.Biller_ExportExcel));
						scrollToElement(driver, element);
						waitForPageToLoad();		
					    int val=1;
						ValidateTwoValue(getText(EdaatOR.Biller_Invoice_AfteraddInvoice+"["+val+"]/td[4]"),clientName);
						ValidateTwoValue(getText(EdaatOR.Biller_Invoice_AfteraddInvoice+"["+val+"]/td[6]"), testdatamap.get("BilStatus").toString());
						Log.ReportEvent("PASS", " Create and Save Bills is Successful");

			} else {
				Log.ReportEvent("FAIL", " Create and Save Bills is Unsuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();

			}
				}
				catch(Exception e)
				{
					Log.ReportEvent("FAIL", " Create and Save Bills is Unsuccessful");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();

				}
			  
			}else
			{
				navigateToCreateInvoicePage(Log);
				enterClientNameOrNationalID(testdatamap);
				Thread.sleep(100);
				String clientName=getClientName();
				Thread.sleep(100);
				selectTemplate(testdatamap);
				Thread.sleep(100);
				addProductDetails(testdatamap);
				Thread.sleep(400);
				verifyElementIsPresent(EdaatOR.Biller_ExportBills_PayedOutSideEdaatPaymentMethod);
				Thread.sleep(400);
				verifyElementIsPresent(EdaatOR.Biller_ExportBills_SadadPaymentMethod);			
				Thread.sleep(100);
				enterInvoicDetails(testdatamap,Log);
				Thread.sleep(100);
//				enterInvoiceCaseSaveType(testdatamap,Log);
				Thread.sleep(100);
				waitForPageToLoad();
				ClickOnBillerExportBillLink();
			    Thread.sleep(100);	
			    
			    try {
					if (CheckElementExists(EdaatOR.Biller_Exported_BillsList)) {					
						Thread.sleep(2000);
						WebElement element=driver.findElement(By.xpath(EdaatOR.Biller_ExportExcel));
						scrollToElement(driver, element);
						waitForPageToLoad();		
					    int val=1;
						ValidateTwoValue(getText(EdaatOR.Biller_Invoice_AfteraddInvoice+"["+val+"]/td[4]"),clientName);
						ValidateTwoValue(getText(EdaatOR.Biller_Invoice_AfteraddInvoice+"["+val+"]/td[6]"), testdatamap.get("BilStatus").toString());
						Log.ReportEvent("PASS", " Create and Export Bills is Successful");

				} else {
					Log.ReportEvent("FAIL", " Create and Export Bills is Unsuccessful");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
				}
					}
					catch(Exception e)
					{
						Log.ReportEvent("FAIL", " Create and Export Bills is Unsuccessful");
						this.takeScreenShot();
						driver.quit();
						Assert.fail();
					}
			    
			
				
			}

		}
		catch(Exception e){
			Log.ReportEvent("FAIL", " Create and Export Bills is Unsuccessful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

		//Function Summary   : Method to create and Export onetime/Recurring invoice.
	//Parameter Summary :  InvoiceType,Save.

	public void createExportInvoiceData(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			String iType=testdatamap.get("InvoiceType").toString();
			if(iType.equalsIgnoreCase("Export")) {			
				navigateToCreateInvoicePage(Log);
				enterClientNameOrNationalID(testdatamap);
				Thread.sleep(100);
				String clientName=getClientName();
				Thread.sleep(100);
				selectTemplate(testdatamap);
				Thread.sleep(100);
				addProductDetails(testdatamap);
				Thread.sleep(100);
				enterInvoicDetails(testdatamap,Log);
				Thread.sleep(100);
				enterInvoiceCaseExportType(testdatamap);
				Thread.sleep(400);
				ClickOnBillerExportBillLink();
				Thread.sleep(2000);
				if(CheckElementExists(EdaatOR.Biller_Exported_BillsList)) {
				Thread.sleep(400);
				WebElement element=driver.findElement(By.xpath(EdaatOR.Biller_ExportExcel));
				scrollToElement(driver, element);
				waitForPageToLoad();
				int val=1;
				ValidateTwoValue(getText(EdaatOR.Biller_Invoice_AfteraddInvoice+"["+val+"]/td[4]"),clientName);
				ValidateTwoValue(getText(EdaatOR.Biller_Invoice_AfteraddInvoice+"["+val+"]/td[6]"), testdatamap.get("BillStatus").toString());				
				Thread.sleep(100);
				WebClickUsingJS(EdaatOR.Biller_ExportExcel);
				Thread.sleep(100);
				verifyElementIsPresent(EdaatOR.Biller_ConformExportExcel);				
				Thread.sleep(8000);
			    ClickOnLastCheckBoxBtn();
				ValidateTwoValue(getText(EdaatOR.Biller_Export_CancellationBtn), testdatamap.get("Cancel").toString());		
			    ValidateTwoValue(getText(EdaatOR.Biller_Export_PayOutsideBtn), testdatamap.get("Confirm").toString());				
				verifyElementIsPresent(EdaatOR.Biller_Export_ViewContactBtn);
				Log.ReportEvent("PASS", " Create and Validate Installment Invoice is Successful");
				}
				
			}else {
				Log.ReportEvent("FAIL", " Create and Validate Installment Invoice is Successful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}

		}
		catch(Exception e){		
			Log.ReportEvent("FAIL", " Create and Validate Installment Invoice is Unsuccessful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}


	//Function Summary   : Method to Navigate Exported contract and Print invoice details.
	//Parameter Summary :  InvoiceType,BIlID.
	public void verifyInvoiceIDandPrint(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			String ID=null;
			Thread.sleep(1000);
			String iType=testdatamap.get("InvoiceType").toString();
			if(iType.equalsIgnoreCase("BIlID")) {
				Thread.sleep(3000);
				scrollDowntillend(driver);
				if(CheckElementExists(EdaatOR.Biller_Invoice_BillNo)==false){
					navigateToCreateInvoicePage(Log);
					enterClientNameOrNationalID(testdatamap);
					selectTemplate(testdatamap);
					addProductDetails(testdatamap);
					enterInvoicDetails(testdatamap,Log);
					ID=getBillerID();
					enterInvoiceCaseSaveType(testdatamap,Log);
					int afterSave=getInvoiceCountNextAfteradd();
					WebClick(EdaatOR.Biller_Invoice_BillNo+"/span[text(),'"+ID+"']");
				}
				else {
					ID=getText("("+EdaatOR.Biller_Invoice_BillNo+"/span)[2]");
					WebClickUsingJS("("+EdaatOR.Biller_Invoice_BillNo+"/span)[2]");
				}
				switchToWindow();
				Thread.sleep(2000);
				if(ExistsCheck(EdaatOR.Biller_Invoice_PrintButton))
				{
				VerifyValue1(getText(EdaatOR.Biller_Invoice_BillerNumber), ID);
				WebClick(EdaatOR.Biller_Invoice_PrintButton);
				Log.ReportEvent("PASS", " View and Print Invoice Details is Successful");
				
				}
				else {
					Log.ReportEvent("FAIL", " View and Print Invoice Details is Unsuccessful");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}

			}
		}
		catch(Exception e){
			Log.ReportEvent("FAIL", " View and Print Invoice Details is Unsuccessful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}


	
	public void getInvoiceDetails(Map<Object,Object> testdatamap) throws Exception {
		testdatamap.put("InvoiceID",getText(EdaatOR.Biller_ExportBille_InvoiceID));
	}

	//Function Summary   : Method to enterClientName
	//Parameter Summary :  ClientID,ClientName
	public void enterClientName(Map<Object, Object> testdatamap) throws Exception {

		String client=testdatamap.get("ClientID").toString();
		if(client.equalsIgnoreCase("Individual")) {
			ClickOnIndividualRadBtn();
			SelectIndCustomerID(testdatamap.get("ClientName").toString());
		}
		else{
			ClickOnCoporateRadBtn();
			SelectCopCustomerID(testdatamap.get("ClientName").toString());
		}
	}
	//Function Summary   : Method to CreateNewInvoice
	//Parameter Summary :  TemplateName,Month,Year,Date,BilNumber
	public void CreateNewInvoice(Map<Object, Object> testdatamap,Log Log) {
		try
		{
			navigateToCreateInvoicePage(Log);
			enterClientName(testdatamap);
			Thread.sleep(2000);
			selectDropdownValue_PartialText(EdaatOR.Biller_Receivables_Template,testdatamap.get("TemplateName").toString());
			Thread.sleep(2000);
			addProductDetails(testdatamap);
			
			Thread.sleep(2000);
			WebClick(EdaatOR.Biller_Receivables_Invoiceduedate);
			Thread.sleep(2000);
			selectDropdownValue_PartialText(EdaatOR.Biller_Receivables_Invoiceduedate_month,testdatamap.get("Month").toString());
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Biller_Receivables_Invoiceduedate_year,testdatamap.get("Year").toString());
			Thread.sleep(1000);
			WebClick("//a[text()='"+testdatamap.get("Date").toString()+"']");
			
			Thread.sleep(1000);
			WebClick(EdaatOR.Biller_Receivables_CreateExport);
			Thread.sleep(30000);
			WebClick(EdaatOR.Biller_Invoice_NextPrevLink);
			Thread.sleep(40000);
			testdatamap.put("BilNumber",getText(EdaatOR.Biller_Receivables_billnumber));
			Thread.sleep(40000);
			
			Thread.sleep(1000);		
        	Log.ReportEvent("PASS", "Step4 : Verify To Create a New Invoice and Capture the Bill Number is successfull");
        	this.takeScreenShot();
		}
		catch (Exception e) {
			
			
			this.takeScreenShot();
		}
		
	}
	public void Onetimeerrorvalidation(Map<Object,Object> testdatamap,Log Log) {
		try
		{
			
			String Testfield= testdatamap.get("Type").toString();		
						
			navigateToCreateInvoicePage(Log);
				//enterClientNameOrNationalID(testdatamap);
	        	Thread.sleep(2000);
				selectDropdownValue_PartialText(EdaatOR.Biller_Receivables_Template,testdatamap.get("TemplateName").toString());
			
			if(Testfield.equalsIgnoreCase("Invoiceduedate"))
			{
			WebClick(EdaatOR.Biller_CreateandSaveUi);
			verifyElementIsPresent(EdaatOR.Biller_InvoiceduedateUi);
			Thread.sleep(1000);
			driver.findElement(By.xpath(EdaatOR.BillerInternalcode)).sendKeys(Keys.PAGE_DOWN);
			Thread.sleep(1000);
			test.log(Status.PASS,"Verify Receviables Invoicedue date error message" + driver.getTitle() +" * Receviables Invoicedue date error message is Pass * " );
						
		}
			else if(Testfield.equalsIgnoreCase("InvoiceExpiredate"))
			{
				    duedate(testdatamap);
		        	Thread.sleep(2000);
		        	WebClick(EdaatOR.Biller_CreateandSaveUi);
					verifyElementIsPresent(EdaatOR.Biller_InvoiceExpiredateUi);
					Thread.sleep(1000);
					driver.findElement(By.xpath(EdaatOR.Biller_Invoice_DueDate)).sendKeys(Keys.PAGE_UP);
					Thread.sleep(1000);
					test.log(Status.PASS,"Verify Receviables InvoiceExpire date error message" + driver.getTitle() +" * Receviables InvoiceExpire date error message is Pass * " );
					
			}
			else if(Testfield.equalsIgnoreCase("Invoiceduedate1"))
			{
				 
				    Expiredate(testdatamap);
		        	Thread.sleep(2000);
		        	WebClick(EdaatOR.Biller_CreateandSaveUi);
					verifyElementIsPresent(EdaatOR.Biller_InvoiceduedateUi);
					Thread.sleep(1000);
					driver.findElement(By.xpath(EdaatOR.BillerInternalcode)).sendKeys(Keys.PAGE_UP);
					Thread.sleep(1000);
					test.log(Status.PASS,"Verify Receviables Invoicedue date error message" + driver.getTitle() +" * Receviables Invoicedue date error message is Pass * " );
					
			}
			else if(Testfield.equalsIgnoreCase("Fromhour"))
			{
				    duedate(testdatamap);
		        	Thread.sleep(2000);
				    Expiredate(testdatamap);
		        	Thread.sleep(2000);
		        	WebClick(EdaatOR.Biller_CreateandSaveUi);
					verifyElementIsPresent(EdaatOR.Biller_InvoiceFromhourUi);
					Thread.sleep(1000);
					driver.findElement(By.xpath(EdaatOR.BillerInternalcode)).sendKeys(Keys.PAGE_UP);
					Thread.sleep(1000);
					test.log(Status.PASS,"Verify Receviables Invoice Fromhour error message" + driver.getTitle() +" * Receviables Invoice Fromhour error message is Pass * " );
					
			}
			else if(Testfield.equalsIgnoreCase("ToTime"))
			{
				    duedate(testdatamap);
		        	Thread.sleep(2000);
				    Expiredate(testdatamap);
		        	Thread.sleep(2000);
		        	WebEdit(EdaatOR.Biller_Fromhour,testdatamap.get("FromHour").toString());
		        	Thread.sleep(2000);
		        	WebClick(EdaatOR.Biller_CreateandSaveUi);
					verifyElementIsPresent(EdaatOR.Biller_InvoiceTotimeUi);
					Thread.sleep(1000);
					driver.findElement(By.xpath(EdaatOR.BillerInternalcode)).sendKeys(Keys.PAGE_UP);
					Thread.sleep(1000);
					test.log(Status.PASS,"Verify Receviables Invoice Totime error message" + driver.getTitle() +" * Receviables Invoice Totime error message is Pass * " );
					
			}
			else if(Testfield.equalsIgnoreCase("Fromhour1"))
			{
				    duedate(testdatamap);
		        	Thread.sleep(2000);
				    Expiredate(testdatamap);
		        	Thread.sleep(2000);
		        	WebEdit(EdaatOR.Biller_Totime,testdatamap.get("ToTime").toString());
		        	Thread.sleep(2000);
		        	WebClick(EdaatOR.Biller_CreateandSaveUi);
					verifyElementIsPresent(EdaatOR.Biller_InvoiceFromhourUi);
					Thread.sleep(1000);
					driver.findElement(By.xpath(EdaatOR.BillerInternalcode)).sendKeys(Keys.PAGE_UP);
					Thread.sleep(1000);
					test.log(Status.PASS,"Verify Receviables Invoice Totime error message" + driver.getTitle() +" * Receviables Invoice Totime error message is Pass * " );
					
			}
			else if(Testfield.equalsIgnoreCase("Condition"))
			{
				    duedate(testdatamap);
		        	Thread.sleep(2000);
				    Expiredate(testdatamap);
		        	Thread.sleep(2000);
		        	WebEdit(EdaatOR.Biller_Fromhour,testdatamap.get("FromHour").toString());
		        	Thread.sleep(2000);
		        	WebEdit(EdaatOR.Biller_Totime,testdatamap.get("ToTime").toString());
		        	Thread.sleep(2000);
		        	WebClick(EdaatOR.Biller_CreateandSaveUi);
					verifyElementIsPresent(EdaatOR.Biller_InvoiceConditionUi);
					Thread.sleep(1000);
					driver.findElement(By.xpath(EdaatOR.BillerInternalcode)).sendKeys(Keys.PAGE_UP);
					Thread.sleep(1000);
					test.log(Status.PASS,"Verify Receviables Invoice Totime error message" + driver.getTitle() +" * Receviables Invoice Totime error message is Pass * " );
					
			}
			else if(Testfield.equalsIgnoreCase("Clienttype"))
			{
				    duedate(testdatamap);
		        	Thread.sleep(2000);
				    Expiredate(testdatamap);
		        	Thread.sleep(2000);
		        	WebEdit(EdaatOR.Biller_Fromhour,testdatamap.get("FromHour").toString());
		        	Thread.sleep(2000);
		        	WebEdit(EdaatOR.Biller_Totime,testdatamap.get("ToTime").toString());
		        	Thread.sleep(2000);
		        	WebEdit(EdaatOR.Biller_Condition,testdatamap.get("Condition").toString());
		        	WebClick(EdaatOR.Biller_CreateandSaveUi);
					verifyElementIsPresent(EdaatOR.Biller_Selecttype);
					Thread.sleep(2000);
					driver.findElement(By.xpath(EdaatOR.BillerInternalcode)).sendKeys(Keys.PAGE_UP);
					Thread.sleep(1000);
					test.log(Status.PASS,"Verify Receviables Invoice Clienttype error message" + driver.getTitle() +" * Receviables Invoice Clienttype error message is Pass * " );
					
			}
			else if(Testfield.equalsIgnoreCase("Product"))
			{		   
	        	          	  
	        	  
				    duedate(testdatamap);	        	   
		        	Thread.sleep(2000);
				    Expiredate(testdatamap);
		        	Thread.sleep(2000);
		        	WebClickUsingJS(EdaatOR.Biller_Indivbtn);
		        	Thread.sleep(2000);
		        	SelectIndCustomerID(testdatamap.get("ClientName").toString());
		        	//enterClientNameOrNationalID(testdatamap);
		        	Thread.sleep(5000);
		        	WebEdit(EdaatOR.Biller_Fromhour,testdatamap.get("FromHour").toString());
		        	Thread.sleep(2000);
		        	WebEdit(EdaatOR.Biller_Totime,testdatamap.get("ToTime").toString());
		        	Thread.sleep(2000);
		        	WebEdit(EdaatOR.Biller_Condition,testdatamap.get("Condition").toString());
		        	Thread.sleep(2000);		        	
		        	WebClick(EdaatOR.Biller_CreateandSaveUi);
					verifyElementIsPresent(EdaatOR.Biller_Product);
					Thread.sleep(2000);
					driver.findElement(By.xpath(EdaatOR.BillerInternalcode)).sendKeys(Keys.PAGE_UP);
					Thread.sleep(1000);
					test.log(Status.PASS,"Verify Receviables Invoice Clienttype error message" + driver.getTitle() +" * Receviables Invoice Clienttype error message is Pass * " );
					
			}
			else if(Testfield.equalsIgnoreCase("Invoice Due Date"))
			{
			WebClickUsingJS(EdaatOR.Biller_CreateIns);
			verifyElementIsPresent(EdaatOR.Biller_Invoiceduedateerrormsg);
			Thread.sleep(2000);
			driver.findElement(By.xpath(EdaatOR.Biller_Invoiceduration)).sendKeys(Keys.PAGE_UP);
			Thread.sleep(1000);
			test.log(Status.PASS,"Verify Receviables Invoicedue date error message" + driver.getTitle() +" * Receviables Invoicedue date error message is Pass * " );
						
		}
			else if(Testfield.equalsIgnoreCase("Duration type"))
			{
			duedate(testdatamap);
			Thread.sleep(2000);
			addProductDetails(testdatamap);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_CreateIns);
			verifyElementIsPresent(EdaatOR.Biller_InvoiceDurationUi);
			Thread.sleep(2000);
			driver.findElement(By.xpath(EdaatOR.Biller_Invoiceduration)).sendKeys(Keys.PAGE_UP);
			Thread.sleep(1000);
			test.log(Status.PASS,"Verify Receviables Duration type error message" + driver.getTitle() +" * Receviables Duration type error message is Pass * " );
						
		}
			else if(Testfield.equalsIgnoreCase("Client Type"))
			{
			duedate(testdatamap);
			Thread.sleep(2000);
			addProductDetails(testdatamap);
			Thread.sleep(2000);
			SelectDuration(testdatamap.get("Duration").toString());
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_CreateIns);
			verifyElementIsPresent(EdaatOR.Biller_Selecttype);
			Thread.sleep(2000);
			driver.findElement(By.xpath(EdaatOR.Biller_Invoiceduration)).sendKeys(Keys.PAGE_UP);
			Thread.sleep(1000);
			test.log(Status.PASS,"Verify Receviables Client type error message" + driver.getTitle() +" * Receviables Client type error message is Pass * " );
						
		}
			else if(Testfield.equalsIgnoreCase("Description"))
			{
			duedate(testdatamap);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Indivbtn);
        	Thread.sleep(2000);
        	SelectIndCustomerID(testdatamap.get("ClientName").toString());
        	Thread.sleep(2000);
			addProductDetails(testdatamap);
			Thread.sleep(2000);
			SelectDuration(testdatamap.get("Duration").toString());
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_CreateIns);
			Thread.sleep(4000);
			WebClickUsingJS(EdaatOR.Biller_Invoiceexportbtn);
			verifyElementIsPresent(EdaatOR.Biller_Descriptiondetails);
			Thread.sleep(2000);		
			test.log(Status.PASS,"Verify Receviables Description error message" + driver.getTitle() +" * Receviables Description error message is Pass * " );
						
		}
			else if(Testfield.equalsIgnoreCase("Select Client"))
			{
			duedate(testdatamap);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Indivbtn);
        	Thread.sleep(2000);
        	SelectIndCustomerID(testdatamap.get("ClientName").toString());
        	Thread.sleep(2000);
			addProductDetails(testdatamap);
			Thread.sleep(2000);
			SelectDuration(testdatamap.get("Duration").toString());
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_CreateIns);
			verifyElementIsPresent(EdaatOR.Biller_Selectclienttype);
			Thread.sleep(4000);							
			test.log(Status.PASS,"Verify Receviables Select client error message" + driver.getTitle() +" * Receviables Select Client error message is Pass * " );
						
		}
			else if(Testfield.equalsIgnoreCase("Tax"))
			{
			WebClickUsingJS(EdaatOR.Biller_addtax);			
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_addbutton);
			
			verifyElementIsPresent(EdaatOR.Biller_taxerrormsg);
			Thread.sleep(2000);
			test.log(Status.PASS,"Verify Receviables Tax error message" + driver.getTitle() +" * Receviables Tax error message is Pass * " );
					
		}
			else if(Testfield.equalsIgnoreCase("Discount"))
			{
			WebClickUsingJS(EdaatOR.Biller_adddiscount);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_adddisbutton);
				
			verifyElementIsPresent(EdaatOR.Biller_discounterrormsg);
			Thread.sleep(1000);
			test.log(Status.PASS,"Verify Receviables Discount error message" + driver.getTitle() +" * Receviables Discount error message is Pass * " );
					
		}
		}
		catch(Exception e)
		{
			test.log(Status.FAIL,"Verify Receviables error message" + driver.getTitle() +" * Receviables error message is FAIL * " );
			
		}
	}
	public void duedate(Map<Object,Object> testdatamap) throws Exception
	{
		    WebClick(EdaatOR.Biller_Invoice_DueDate);
	        Thread.sleep(1000);
	    	selectDropdownValue_PartialText(EdaatOR.Biller_Invoice_Fromyear,testdatamap.get("FromYear").toString());
	    	Thread.sleep(1000);
	    	selectDropdownValue_PartialText(EdaatOR.Biller_Invoice_FromMonth,testdatamap.get("FromMonth").toString());
	    	Thread.sleep(1000);
      	    WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
		
	}
	
	public void Expiredate(Map<Object,Object> testdatamap) throws Exception
	{
		WebClick(EdaatOR.Biller_Invoice_TODate);
    	Thread.sleep(1000);
    	selectDropdownValue_PartialText(EdaatOR.Biller_Invoice_Toyear,testdatamap.get("ToYear").toString());
    	Thread.sleep(1000);
    	selectDropdownValue_PartialText(EdaatOR.Biller_Invoice_ToMonth,testdatamap.get("ToMonth").toString());
    	Thread.sleep(1000);
    	WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");
		
	}
		//Function Summary   : Method to verify Newly Added PaymentMethod Column In Grid	
	public void verifyNewlyAddedPaymentMethodColumnInGrid(Log Log) throws Exception
	{
		Thread.sleep(500);
		WebElement element=driver.findElement(By.xpath(EdaatOR.Biller_ExportedContract_Searchbtn));
		scrollToElement(driver, element);
		if(CheckElementExists(EdaatOR.Biller_ExportedBills_PaymentMethod))
		{
			Thread.sleep(500);
			Log.ReportEvent("PASS", "Newly Added PaymentMethod Column In Grid is Successful");	
		}else {
			Log.ReportEvent("FAIL", "Newly Added PaymentMethod Column In Grid is Unsuccessful");	
			this.takeScreenShot();
			driver.quit();
            Assert.fail();		
            }
	

		
	}
	//Function Summary  : Method to select payment method
	//Parameter Summary : PaymentMethod	
		public void selectPaymentMethod(Map<Object,Object> testdatamap) throws InterruptedException
	{
    	Thread.sleep(1000);
    	WebSelect(EdaatOR.Biller_PaymentMethod,testdatamap.get("PaymentMethod").toString());
    	Thread.sleep(1000);
		
	}
		
	//Function Summary  : Method to click on search button
	//Parameter Summary : N/A	
	public void clickOnSearchButton() throws Exception
	{
		WebClick(EdaatOR.Admin_Button);
    	Thread.sleep(2000);
		
	}
	//Function Summary  : Method to enter contract number
	//Parameter Summary : ContractNumber	
	public void enterContractNumber(Map<Object,Object> testdatamap) throws Exception
	{
    	Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Receivables_ContractNumber_Textfeild,testdatamap.get("ContractNumber").toString());
		
	}
	
//Function Summary  : Method to verify new search criteria in Exported contracts page for the payment method
	//Parameter Summary : PaymentMethod	
	public void verifyPaymentMethodInExportContactSearch(Map<Object,Object> testdatamap,Log Log) {
		try {

			Thread.sleep(2000);
			verifyElementIsPresent(EdaatOR.Biller_PaymentMethod, "Payment method dropdown");
			WebClick(EdaatOR.Biller_PaymentMethod);
	    	Thread.sleep(2000);
	    	List<WebElement> options=getElements(EdaatOR.Biller_ExportContact_PaymentMethodOptions);
	    	if(options.size()==7) {	    	
	    		for (Object option:options){
	    			CheckElementExists(option.toString());           	

	    	}
	    		}
    		else {
    	    	Log.ReportEvent("FAIL", " New Search Criteria In Exported Contracts Page For The Payment Method is Unsuccessful");
    	    	this.takeScreenShot();
    	    	driver.quit();
    	    	Assert.fail();
    		}
	    	Log.ReportEvent("PASS", " New Search Criteria In Exported Contracts Page For The Payment Method is Successful");
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", " New Search Criteria In Exported Contracts Page For The Payment Method is Unsuccessful");
	    	this.takeScreenShot();
	    	driver.quit();
	    	Assert.fail();
		}
	 	
				
	}
//Function Summary   : Method to verify available payment method appear as logo when click on contract number
	//Parameter Summary :  InvoiceType,ExportContact.

	public void verifyPaymentMethodLogoInContractNumber(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			enterContractNumber(testdatamap);
	        Thread.sleep(500);
	        clickOnSearchButton();
	        if(CheckElementExists(EdaatOR.Biller_conctact))
		    {
		    	Log.ReportEvent("FAIL", "Search Invoice By Contract Number is Unsuccessful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
		    }
		    else {
			Log.ReportEvent("PASS", "Search Invoice By Contract Number is Successful");
		    }
	        
			WebClick(EdaatOR.Biller_ExportContact_InvID+"/span");;
				switchToWindow();
				Thread.sleep(2000);
				scrollDowntillend(driver);
				if(CheckElementExists(EdaatOR.Biller_ExportContact_PaymentMethodLogo_Sadad)) {
					verifyElementIsPresent(EdaatOR.Biller_ExportContact_PaymentMethodLogo_Mada);
					verifyElementIsPresent(EdaatOR.Biller_ExportContact_PaymentMethodLogo_MasterCard);
					verifyElementIsPresent(EdaatOR.Biller_ExportContact_PaymentMethodLogo_Visa);
					Log.ReportEvent("PASS", "Payment Method Appear As Logo When Click On Contract Number is Successful");

				}
				else {
					Log.ReportEvent("FAIL", "Payment Method Appear As Logo When Click On Contract Number is Unsuccessful");
					this.takeScreenShot();
					driver.quit();
                    Assert.fail();
					
				}
			

			}
		
		catch(Exception e){
			Log.ReportEvent("FAIL", "Payment Method Appear As Logo When Click On Contract Number is Unsuccessful");
			this.takeScreenShot();
			driver.quit();
            Assert.fail();
		}
	}
//Function Summary   : Method to verify that the available payment method appears when click on view button of an invoice
		//Parameter Summary :  InvoiceType,ExportContact.
	 
		public void verifyPaymentMethodLogoInBillNumber(Map<Object,Object> testdatamap,Log Log) throws Exception {
			try {
				String ID=null;
				String iType=testdatamap.get("InvoiceType").toString();
				if(iType.equalsIgnoreCase("ExportContact")) {
					Thread.sleep(1000);
					if(CheckElementExists(EdaatOR.Biller_Invoice_BillNo)==false){
						navigateToCreateInvoicePage(Log);
						enterClientNameOrNationalID(testdatamap);
						selectTemplate(testdatamap);
						addProductDetails(testdatamap);
						enterInvoicDetails(testdatamap,Log);
						ID=getBillerContactID();
						enterInvoiceCaseSaveType(testdatamap,Log);
						int afterSave=getInvoiceCountNextAfteradd();
						WebClick(EdaatOR.Biller_Invoice_BillNo+"/span[text(),'"+ID+"']");
	 
					}
					else {
						ID=getText(EdaatOR.Biller_Invoice_BillNo+"/span");
						WebClick(EdaatOR.Biller_Invoice_BillNo+"/span");
					}
					switchToWindow();
					Thread.sleep(2000);
					scrollDowntillend(driver);
					if(CheckElementExists(EdaatOR.Biller_ExportContact_PaymentMethodLogo_Sadad))
					{
						verifyElementIsPresent(EdaatOR.Biller_ExportContact_PaymentMethodLogo_Mada);
						verifyElementIsPresent(EdaatOR.Biller_ExportContact_PaymentMethodLogo_Visa);
						verifyElementIsPresent(EdaatOR.Biller_ExportContact_PaymentMethodLogo_MasterCard);
						Log.ReportEvent("PASS", " Available Payment Method Appears When Click On View Button of an Invoice is Successful");

					}
					else {
						Log.ReportEvent("FAIL", " Available Payment Method Appears When Click On View Button of an Invoice is Unsuccessful");
						this.takeScreenShot();
						driver.quit();
                        Assert.fail();
					}
				}			}
			catch(Exception e){
				Log.ReportEvent("FAIL", " Available Payment Method Appears When Click On View Button of an Invoice is Unsuccessful");
				this.takeScreenShot();
				driver.quit();
                Assert.fail();
			}
		}
		//Function Summary  : Method to uncheck payment methods checkbox
	//Parameter Summary : N/A	
	public void uncheckOrCheckPaymentMethods() throws Exception
	{
		WebClick(EdaatOR.Biller_ExportBills_SadadPaymentMethod);
		Thread.sleep(100);
		WebClick(EdaatOR.Biller_ExportBills_MadaPaymentMethod);			
		Thread.sleep(100);
		WebClick(EdaatOR.Biller_ExportBills_VisaPaymentMethod);
		Thread.sleep(100);
		WebClick(EdaatOR.Biller_ExportBills_MasterCardPaymentMethod);			
		Thread.sleep(100);
	//	WebClick(EdaatOR.Biller_ExportBills_ApplePaydPaymentMethod);			
		Thread.sleep(100);
		
	}
			//Function Summary   : Method to create invoice with only paid outside edaat payment method.
	//Parameter Summary :  InvoiceType,Export.
	public void verifyToCreateInvoiceOnlyForPaidOutsideEdaat(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			navigateToCreateInvoicePage(Log);
				enterClientNameOrNationalID(testdatamap);
				Thread.sleep(100);
				selectTemplate(testdatamap);
				Thread.sleep(100);
				addProductDetails(testdatamap);
				Thread.sleep(400);
				uncheckOrCheckPaymentMethods();
				EnterIssuedDate();
				Thread.sleep(100);
				WebClickUsingJS(EdaatOR.Biller_Invoice_Exportandcreatebtn);
				if(CheckElementExists(EdaatOR.Biller_ExportBills_error))
				{
					Log.ReportEvent("PASS", " Create Invoice With Only Paid Outside Edaat Payment Method is Successful");

				}else {
					Log.ReportEvent("FAIL", " Create Invoice With Only Paid Outside Edaat Payment Method is Unsuccessful");
					takeScreenShot();
                    Assert.fail();
				}

		}
		catch(Exception e){
			Log.ReportEvent("FAIL", " Create Invoice With Only Paid Outside Edaat Payment Method is Unsuccessful");
			takeScreenShot();
            Assert.fail();
		}
	}
	//Function Summary  : Method to enter transfer notes text area
	//Parameter Summary : N/A	
	public void enterTransferNotesTextArea(int length) throws Exception
	{
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append('a'); 
        }
		Thread.sleep(200);
        WebEdit(EdaatOR.Biller_ExportBills_TransferRemarkTextArea, sb.toString());
		Thread.sleep(100);

	}
	//Function Summary   : Method to verify max length of Transfer Notes textarea
		//Parameter Summary :  InvoiceType,Save.
		public void verifyMaxLengthOfTransferRemarkField(Map<Object,Object> testdatamap,Log Log) throws Exception {
			try {
					navigateToCreateInvoicePage(Log);
					enterClientNameOrNationalID(testdatamap);
					Thread.sleep(2000);
					selectTemplate(testdatamap);
					Thread.sleep(2000);
					addProductDetails(testdatamap);
					Thread.sleep(3000);
					EnterIssuedDate();
					Thread.sleep(3000);
					enterTransferNotesTextArea(280);
					validateTransferRemarkLengthWithinLimit(Log);
					Thread.sleep(1000);
			}
			catch(Exception e){
				Log.ReportEvent("FAIL", "validation of transfer note limit is Unsuccessfull");									
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
				
			}
		}

	//Function Summary   : Method to verify Payment Method is Editable For Exported Contracts
	//Parameter Summary  : ContractNumber,Status
	public void verifyPaymentMethodisEditableForExportedContracts(Map<Object, Object> testdatamap, Log Log) throws Exception {

		try {
			enterContractNumber(testdatamap);
			Thread.sleep(500);
			clickOnSearchButton();
			Thread.sleep(2000);
			if(getText(EdaatOR.Biller_Receivables_exportedContracts_StatusInGrid).equals(testdatamap.get("Status").toString()))
			{
				WebClick(EdaatOR.Biller_ExportContact_InvID+"/span");
				switchToWindow();
				uncheckOrCheckPaymentMethods();
				WebClickUsingJS(EdaatOR.Biller_Receivables_exportedContracts_SaveButton);
				Log.ReportEvent("PASS", " Edit Payment Methods is Successful");

				
			}else {
				Log.ReportEvent("FAIL", " Edit Payment Methods is Unsuccessful");
				this.takeScreenShot();
                Assert.fail();
			}
			
			Thread.sleep(500);
			if(CheckElementExists(EdaatOR.Biller_Receievables_PaymentMethod_Update_PopupHeader)) {
				verifyElementIsPresent(EdaatOR.Biller_Receievables_PaymentMethod_Update_PopupHeader);
				WebClickUsingJS(EdaatOR.Biller_Receievables_PaymentMethod_Add_Btn);
				Thread.sleep(2000);
				Log.ReportEvent("PASS", " Payment Methods is Editable After The Invoice Partial Paid is Successful");

			}
			else
			{
				Log.ReportEvent("FAIL", " Payment Methods is Editable After The Invoice Partial Paid is Unsuccessful");
				this.takeScreenShot();
                Assert.fail();
			}

		} catch (Exception e) {
			Log.ReportEvent("FAIL", " Payment Methods is Editable After The Invoice Partial Paid is Unsuccessful");
			this.takeScreenShot();
            Assert.fail();
			e.printStackTrace();
		}
	}
//Function Summary   : Method to verify Default Payment Method is Selected And Disabled
		//Parameter Summary :  TemplateName
		public void verifyDefaultPaymentMethodisSelectedAndDisabled(Map<Object,Object> testdatamap,Log Log)
		{
			try {
				navigateToCreateInvoicePage(Log);
				Thread.sleep(2000);
				selectTemplate(testdatamap);
				Thread.sleep(2000);
				WebElement element=driver.findElement(By.xpath(EdaatOR.Biller_ExportBills_SelectTemplateDropdown));
				scrollToElement(driver, element);
				Thread.sleep(1000);
				WebElement paymentField = driver.findElement(By.xpath(EdaatOR.Biller_ExportBills_DefaultPaymentMethod));
				if(paymentField.isSelected()&& !paymentField.isEnabled()==true)
				{
					Log.ReportEvent("PASS", " Select And Disable Default Payment Method is Successful");

				}
			else
			{
				Log.ReportEvent("FAIL", " Select And Disable Default Payment Method is Unsuccessful");
				this.takeScreenShot();
				Assert.fail();

			}
		}
			catch(Exception e){
				Log.ReportEvent("FAIL", " Select And Disable Default Payment Method is Unsuccessful");
				this.takeScreenShot();
				Assert.fail();
			}
			
	}
	//Function Summary   : Method to verifyNewPaymentMethodColumnisAdded
	//Parameter Summary  : N/A 
	public void verifyNewPaymentMethodColumnisAdded(Log Log) throws Exception {
		try {
			verifyElementIsPresent(EdaatOR.Biller_Receievables_PaymentMethod);
			test.log(Status.PASS,"Verify new payment method column is added Functionality is successfull" + driver.getTitle() +" * Verify new payment method column is added Functionality is successfull PASS * " );	
	    	Log.ReportEvent("PASS", " Verify new payment method column is added Functionality is successfull");
		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL,"Verify new payment method column is added Functionality is Failed" + driver.getTitle() +" * Verify new payment method column is added Functionality is Failed FAIL * " );	
		}
		
	}

//Function Summary   : Method to verifyPaymentMethodisEditable
	//Parameter Summary  : BillNumber,Status
	public void verifyPaymentMethodisEditable(Map<Object, Object> testdatamap, Log Log) throws Exception {
		
		try {
			WebEdit(EdaatOR.Biller_receivables_BillNumber,testdatamap.get("BillNumber").toString());
			Thread.sleep(2000);
			WebClick(EdaatOR.Biller_receivables_SrchBtn);
			Thread.sleep(2000);
			if(getText(EdaatOR.Biller_Receivables_Bill_Status).equals(testdatamap.get("Status").toString()))
			{
				WebClickUsingJS(EdaatOR.Biller_Export_ViewContactBtn);
				switchToWindow();
				WebClickUsingJS(EdaatOR.Biller_Receievables_PaymentMethod_Mada);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Biller_Receievables_PaymentMethod_Visa);
				WebClickUsingJS(EdaatOR.Biller_Receievables_PaymentMethod_MasterCard);
				WebClickUsingJS(EdaatOR.Biller_Receievables_PaymentMethod_Savebtn);
		    	Log.ReportEvent("PASS", "Edit Available Payment Methods is Successful");

			}else {
		    	Log.ReportEvent("FAIL", "Edit Available Payment Methods is Unsuccessful");
		    	this.takeScreenShot();
                Assert.fail();
			}
		
			if(CheckElementExists(EdaatOR.Biller_Receievables_PaymentMethod_Update_PopupHeader)) {
				verifyElementIsPresent(EdaatOR.Biller_Receievables_PaymentMethod_Update_PopupHeader);
				WebClickUsingJS(EdaatOR.Biller_Receievables_PaymentMethod_Add_Btn);
				Thread.sleep(2000);
		    	Log.ReportEvent("PASS", "Available Payment Methods is Editable After The Invoice Partially Paid is Successful");

			}
			else
			{
		    	Log.ReportEvent("FAIL", "Available Payment Methods is Editable After The Invoice Partially Paid is Unsuccessful");
				this.takeScreenShot();
                Assert.fail();
			}
			
		} catch (Exception e) {
			Log.ReportEvent("FAIL", " Available Payment Methods is Editable After The Invoice Partially Paid is Unsuccessful");
			this.takeScreenShot();
            Assert.fail();
			e.printStackTrace();
			

		}
		
	
	}
	//Function Summary   : Method to search exported bills
	//Parameter Summary  : BillNumber
	public void searchExportedBillsUsingBillNUmber(Map<Object, Object> testdatamap, Log Log) throws Exception {
		try {
			
			WebEdit(EdaatOR.Biller_receivables_BillNumber,testdatamap.get("BillNumber").toString());
			Thread.sleep(800);
			WebClick(EdaatOR.Biller_receivables_SrchBtn);
			Thread.sleep(5000);
			if(getText(EdaatOR.Biller_ReceivableExportedBills_BillNumber).equals(testdatamap.get("BillNumber").toString())){
				Log.ReportEvent("PASS", "Search Exported Biller is Successful");
				
			}
			else {
				Log.ReportEvent("PASS", "Search Exported Biller is Unsuccessful");
				takeScreenShot();
				driver.quit();
				Assert.fail();

			}
		}
		 catch (Exception e) {
			 Log.ReportEvent("PASS", "Search Exported Biller is Unsuccessful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
	}


	//Function Summary   : Method to VerifyTransferRemarkFieldAppearsAfterSelectingSubBiller
		//Parameter Summary  : N/A 
		public void VerifyTransferRemarkFieldAppearsAfterSelectingSubBiller(Map<Object, Object> testdatamap, Log Log) throws Exception {
			try {
				navigateToCreateInvoicePage(Log);
				Thread.sleep(2000);
				enterClientNameOrNationalID(testdatamap);
				Thread.sleep(2000);

				selectTemplate(testdatamap);
				Thread.sleep(2000);

				addProductDetails(testdatamap);
				Thread.sleep(2000);

	              scrollToElementCenter(driver, getElement(EdaatOR.Biller_receivables_SubbillerTransferNotes));	
	  			Thread.sleep(2000);

				if (ExistsCheck(EdaatOR.Biller_receivables_SubbillerTransferNotes)) {
					
					Log.ReportEvent("PASS", "Transfer Remark field is Appeared SuccessfullY");
				}
				else {
					Log.ReportEvent("FAIL", "Transfer Remark field is not Appeared ");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			  }
		catch (Exception e) {
				e.printStackTrace();
				Log.ReportEvent("FAIL", "Transfer Remark field is not Appeared ");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		
	}
	//Function Summary   : Method to Verify Transfer Remark in invoice details page
	   //Parameter Summary :  InvoiceType,Save,TransferRemarkMessage,BilStatus
		public void createSaveInvoiceDataWithTransferRemark(Map<Object,Object> testdatamap,Log Log) throws Exception {
			
			try {
				String iType=testdatamap.get("InvoiceType").toString();
				if(iType.equalsIgnoreCase("Save")) {
					navigateToCreateInvoicePage(Log);

					enterClientNameOrNationalID(testdatamap);
					Thread.sleep(100);
					selectTemplate(testdatamap);
					Thread.sleep(100);
					addProductDetails(testdatamap);
					Thread.sleep(400);
					verifyElementIsPresent(EdaatOR.Biller_ExportBills_PayedOutSideEdaatPaymentMethod);
					Thread.sleep(400);
					verifyElementIsPresent(EdaatOR.Biller_ExportBills_SadadPaymentMethod);			
					Thread.sleep(100);					
					EnterIssuedDate();
					Thread.sleep(100);
					WebEdit(EdaatOR.Biller_Rece_Transfer_Remark_TestArea,testdatamap.get("TransferRemarkMessage").toString());
					Thread.sleep(100);
					WebClick(EdaatOR.Biller_Rece_CreateandExportButton);					
					waitForPageToLoad();
					Thread.sleep(2000);
					driver.findElement(By.xpath(EdaatOR.Biller_ExportExcel)).sendKeys(Keys.PAGE_DOWN);
					takeScreenShot();
				    int val=1;
					//ValidateTwoValue(getText(EdaatOR.Biller_Invoice_AfteraddInvoice+"["+val+"]/td[6]"), testdatamap.get("BilStatus").toString());
					Thread.sleep(2000);	
					WebClickUsingJS("("+EdaatOR.Biller_Invoice_BillNo+"/span)[2]");
					Thread.sleep(5000);
					switchToWindow();
					VerifyValue1(getText(EdaatOR.Biller_Rece_SubillerTransferNotes), testdatamap.get("TransferRemarkMessage").toString());
					Thread.sleep(100);
					test.log(Status.PASS,"Verify Transfer Remark in invoice details page" + driver.getTitle() +" * Trasfer Remark in invoice details page PASS * " );				
					takeScreenShot();
					Log.ReportEvent("PASS", " Verify Transfer Remark in invoice details page is sucessfull");								
					this.takeScreenShot();			
				}
 
			}
			catch(Exception e){
				test.log(Status.FAIL,"Verify Transfer Remark in invoice details page" + driver.getTitle() +" * Trasfer Remark in invoice details page Fail * " );				
				this.takeScreenShot();
			}
		}
	
		//Function Summary   : Method to VerifyTransferRemarkFieldDoesntAppearAfterSelectingTemplateOtherThanOneTime
	    //Parameter Summary  : N/A 
		public void VerifyTransferRemarkFieldDoesntAppearAfterSelectingTemplateOtherThanOneTime(
				Map<Object, Object> testdatamap, Log Log) {
			try {
				navigateToCreateInvoicePage(Log);
				
				enterClientNameOrNationalID(testdatamap);
				selectTemplate(testdatamap);
				Thread.sleep(2000);
				
				if(ExistsCheck(EdaatOR.Biller_Rece_Transfer_Remark_TestArea)==false) {
					
					Log.ReportEvent("PASS", "Transfer Remark field not Appeared is Successfull ");
					
				}
				else {
					Log.ReportEvent("FAIL", "Transfer Remark field not Appeared is Unsuccessfull");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
				
			  }
		     catch (Exception e) {
				e.printStackTrace();
				Log.ReportEvent("FAIL", "Transfer Remark field not Appeared is Unsuccessfull");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			
			}
		}	
	public void naviagteReceviableExportedContracts(Log Log) throws InterruptedException {
		ClickOnBReceivableLink();
		ClickOnBillerExportBillLink();
		Thread.sleep(500);
		WebClickUsingJS(EdaatOR.Biller_ExportedContract_Page);
		waitForPageToLoad();
		Log.ReportEvent("PASS", "Verify naviagted Suceessfull Export contract Page");

	}
	
		//Function Summary  : Method to verify Payment Methods List In Export Bills
	
		public void verifyPaymentMethodsListInPaymentMethodDropdownInExportedBills(Log Log) {
			try {	 
				Thread.sleep(2000);
				verifyElementIsPresent(EdaatOR.Biller_PaymentMethod, "Payment method dropdown");
				WebClick(EdaatOR.Biller_PaymentMethod);
		    	Thread.sleep(1000);
		    	List<WebElement> options=getElements(EdaatOR.Biller_ExportContact_PaymentMethodOptions);
		    	if(options.size()==7) {	    	
		    		for (Object option:options){
		    			CheckElementExists(option.toString());
		    			
		    		}
		    	}
		    	else {
	            	Log.ReportEvent("FAIL", "Payment Methods List In Exported Bills is Unsuccessful");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();

		    	
		    	}
            	Log.ReportEvent("PASS", " Payment Methods List In Exported Bills is Successful");
		    	}
			catch (Exception e) {
				Log.ReportEvent("FAIL", " Payment Methods List In Exported Bills is Unsuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();

			}
					
		}		
//Function Summary   : Method to verify Transfer Remark Field Not Appears 
public void verifyTransferRemarkFieldNotAppears(Map<Object,Object> testdatamap,Log Log) throws Exception {

	try {
			navigateToCreateInvoicePage(Log);
			enterClientNameOrNationalID(testdatamap);
			Thread.sleep(100);
			selectTemplate(testdatamap);
			Thread.sleep(100);
			addProductDetails(testdatamap);
			Thread.sleep(400);
			EnterIssuedDate();
			WebElement element=driver.findElement(By.xpath(EdaatOR.Biller_Invoice_installmentButton));
			scrollToElementCenter(driver, element);
			if(CheckElementExists(EdaatOR.Biller_Rece_Transfer_Remark_TestArea)==false)
			{
				Log.ReportEvent("PASS", "Transfer Remark Field is not Displayed Successfully");
				Thread.sleep(400);
			
			}else {
				Log.ReportEvent("FAIL", "Transfer Remark field is displayed Successfully ");
				scrollToElementCenter(driver, getElement(EdaatOR.Biller_Rece_Transfer_Remark_TestArea));
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}	
		}
	catch(Exception e){
		Log.ReportEvent("FAIL", "Transfer Remark field is displayed Successfully");
		this.takeScreenShot();
		driver.quit();
		Assert.fail();
	}}  
	
			
				
				
				//Function Summary   : Method to Verify Transfer Remark in invoice details page
				//Parameter Summary :  InvoiceType,Save,TransferRemarkMessage,BilStatus
				public void createSaveInvoiceDataWithTransferRemarkField(Map<Object,Object> testdatamap,Log Log) throws Exception {
					//
					try {
						String iType=testdatamap.get("InvoiceType").toString();
						if(iType.equalsIgnoreCase("Save")) {
							navigateToCreateInvoicePage(Log);

							enterClientNameOrNationalID(testdatamap);
							Thread.sleep(100);
							selectTemplate(testdatamap);
							Thread.sleep(100);
							addProductDetails(testdatamap);
							Thread.sleep(400);
							verifyElementIsPresent(EdaatOR.Biller_ExportBills_PayedOutSideEdaatPaymentMethod);
							Thread.sleep(400);
							verifyElementIsPresent(EdaatOR.Biller_ExportBills_SadadPaymentMethod);			
							Thread.sleep(100);					
							EnterIssuedDate();
							Thread.sleep(100);
							WebEdit(EdaatOR.Biller_Rece_Transfer_Remark_TestArea,testdatamap.get("TransferRemarkMessage").toString());
							Thread.sleep(100);
							WebClick(EdaatOR.Biller_Rece_CreateandExportButton);					
							waitForPageToLoad();
							Thread.sleep(5000);
							WebElement element=driver.findElement(By.xpath(EdaatOR.Biller_ExportExcel));
							scrollToElement(driver, element);							
							takeScreenShot();
						    int val=1;
							//ValidateTwoValue(getText(EdaatOR.Biller_Invoice_AfteraddInvoice+"["+val+"]/td[6]"), testdatamap.get("BilStatus").toString());
							Thread.sleep(1000);	
							WebClickUsingJS("("+EdaatOR.Biller_Invoice_BillNo+"/span)[2]");
							Thread.sleep(1000);
							switchToWindow();
							Thread.sleep(500);
							WebElement element1=driver.findElement(By.xpath(EdaatOR.Biller_Rece_SubBiller));
							scrollToElement(driver, element1);
							Thread.sleep(1000);
							VerifyValue1(getText(EdaatOR.Biller_Rece_SubillerTransferNotes), testdatamap.get("TransferRemarkMessage").toString());
							Thread.sleep(100);
							test.log(Status.PASS,"Verify Transfer Remark in invoice details page" + driver.getTitle() +" * Trasfer Remark Field in invoice details page PASS * " );				
							takeScreenShot();
							Log.ReportEvent("PASS", " Verify Transfer Remark in invoice details page is sucessfull");	
							this.takeScreenShot();
										
						}

					}
					catch(Exception e){
						test.log(Status.FAIL,"Verify Transfer Remark in invoice details page" + driver.getTitle() +" * Trasfer Remark Field in invoice details page Fail * " );				
						this.takeScreenShot();
					}
				}
				//Function Summary  : Method to uncheck payment methods checkbox
				//Parameter Summary : N/A	
				public void uncheckPaymentMethods() throws Exception
				{
					WebClick(EdaatOR.Biller_ExportBills_SadadPaymentMethod);
					Thread.sleep(400);
					WebClick(EdaatOR.Biller_ExportBills_MadaPaymentMethod);			
					Thread.sleep(100);
					WebClick(EdaatOR.Biller_ExportBills_VisaPaymentMethod);
					Thread.sleep(400);
					WebClick(EdaatOR.Biller_ExportBills_MasterCardPaymentMethod);		
					Thread.sleep(100);
					
				}
				
				 
			//Function Summary   : Method to verify Payment Methods Logo In Invoice Details Page
				public void verifyPaymentMethodsLogoInInvoiceDetailsPage(Log Log) throws Exception {
					
					try {
						WebClick(EdaatOR.Biller_ExportBills_InvID);;
						Thread.sleep(100);
						switchToWindow();	
						Thread.sleep(100);						
						WebElement element=driver.findElement(By.xpath(EdaatOR.Biller_ExportBills_SadadLogo));
						scrollToElement(driver, element);
						Thread.sleep(100);
						if(CheckElementExists(EdaatOR.Biller_ExportBills_SadadLogo)) {
							Thread.sleep(100);	
							verifyElementIsPresent(EdaatOR.Biller_ExportBills_MadaLogo);
							Thread.sleep(100);
							verifyElementIsPresent(EdaatOR.Biller_ExportBills_VisaLogo);
							Thread.sleep(100);
							verifyElementIsPresent(EdaatOR.Biller_ExportBills_MasterCardLogo);
							Thread.sleep(100);
							Log.ReportEvent("PASS", "View Payment Methods Logo In Invoice Details Page is Successful");
						}
						else {
							Log.ReportEvent("FAIL", "View Payment Methods Logo In Invoice Details Page is Unsuccessful");
							takeScreenShot();
                            Assert.fail();
						}											
						}
					catch(Exception e){
						Log.ReportEvent("FAIL", "View Payment Methods Logo In Invoice Details Page is Unsuccessful");
						takeScreenShot();
                        Assert.fail();
					}
				}	

	//Function Summary   : Method to validate transfer remark note is within limit
	//Parameter Summary : NA
	public void validateTransferRemarkLengthWithinLimit(Log Log){
	try {
		WebElement element=driver.findElement(By.xpath(EdaatOR.Biller_ExportBills_TransferRemarkTextArea));
		scrollToElementCenter(driver, element);
		Thread.sleep(100);
		String transferNotes=WebGetTextAttribute(EdaatOR.Biller_ExportBills_TransferRemarkTextArea);
		Thread.sleep(100);
		int transferNotesLength=transferNotes.length();
		Thread.sleep(500);			
		if(transferNotesLength<281) {
			Log.ReportEvent("PASS", "Length of Transfer Note is Within the Limit");									
			Thread.sleep(100);
		}
		else {
			Log.ReportEvent("FAIL", "Length of Transfer Note is not Within the Limit");									
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
		
	}
	catch (Exception e) {
		Log.ReportEvent("FAIL", "Length of Transfer Note is not Within the Limit");									
		this.takeScreenShot();
		driver.quit();
		Assert.fail();
	}
	}
	
	//Function Summary   : Method to enter transfer note
	//Parameter Summary : Transfer note
	public void verifyTransferNotesField(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try{
			enterClientNameOrNationalID(testdatamap);
			Thread.sleep(100);
			selectTemplate(testdatamap);
			Thread.sleep(100);
			addProductDetails(testdatamap);
			Thread.sleep(100);					
			EnterIssuedDate();
			if(IsDispalyed(EdaatOR.Biller_Rece_Transfer_Remark_TestArea)) {
		      WebEdit(EdaatOR.Biller_Rece_Transfer_Remark_TestArea,testdatamap.get("TransferRemarkMessage").toString());
			   WebClick(EdaatOR.Biller_Rece_CreateandExportButton);
			  Log.ReportEvent("PASS", "Transfer Remark Field Verfication is Successful");
			Thread.sleep(5000);

		}
			else {
				Log.ReportEvent("FAIL", "Transfer Remark Field Verfication is Unsuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
				}
			}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "Transfer Remark Field Verfication is Unsuccessful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
			}
		}
	
	//Function Summary   : Method to validate transfer note
	//Parameter Summary : Transfer note
	public void validateTransferNotes(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try{
			WebClickUsingJS("("+EdaatOR.Biller_Invoice_BillNo+"/span)");
			Thread.sleep(5000);
			switchToWindow();
			Thread.sleep(5000);
		     if(IsDispalyed(EdaatOR.Biller_InvoiceDetails)) {
			Thread.sleep(3000);
			scrollToElementCenter(driver, getElement(EdaatOR.Biller_Rece_SubillerTransferNotes));
			Thread.sleep(2000);
			VerifyValue1(getText(EdaatOR.Biller_Rece_SubillerTransferNotes), testdatamap.get("TransferRemarkMessage").toString());
			Thread.sleep(100);
			Log.ReportEvent("PASS", "Transfer Note in Invoice Details Page is Matching Succesfully");									
		}
		else {
			Log.ReportEvent("FAIL", "Transfer Note in invoice Details Page is not Matching");									
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
			}
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "Transfer Note in Invoice Details Page is not Matching");									
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
		}
	//Function Summary   : Method to verify Payment Methods In Invoice Details Page
	public void verifyPaymentMethodsInInvoiceDetailsPage(Map<Object,Object> testdatamap,Log Log) throws Exception {
		
		try {
			enterContractNumber(testdatamap);
	        Thread.sleep(500);
	        clickOnSearchButton();
			WebClick(EdaatOR.Biller_ExportContact_InvID+"/span");
			Thread.sleep(100);
			switchToWindow();	
			Thread.sleep(100);						
			WebElement element=driver.findElement(By.xpath(EdaatOR.Biller_ExportBills_MadaLogo));
			scrollToElement(driver, element);
			Thread.sleep(100);
			if(CheckElementExists(EdaatOR.Biller_ExportBills_SadadPaymentMethod))
			{
				Thread.sleep(100);	
				verifyElementIsPresent(EdaatOR.Biller_ExportBills_MadaPaymentMethod);
				Thread.sleep(100);
				verifyElementIsPresent(EdaatOR.Biller_ExportBills_VisaPaymentMethod);
				Thread.sleep(100);
				verifyElementIsPresent(EdaatOR.Biller_ExportBills_MasterCardPaymentMethod);
				Thread.sleep(100);
				Log.ReportEvent("PASS", " View Payment Methods In Invoice Details Page is successful");							

			}else {
				Log.ReportEvent("FAIL", " View Payment Methods In Invoice Details Page is Unsuccessful");						
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
			

			}
		catch(Exception e){
			Log.ReportEvent("FAIL", " View Payment Methods In Invoice Details Page is Unsuccessful");						
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}
	//Function Summary  : Method to Verify payment methods editable in invoice details page			
	public void verifyExportedContractsInvoiceDetailsPaymentMethodsEditable(Map<Object,Object> testdatamap,Log Log) throws Exception {

		try {	enterContractNumber(testdatamap);
		        Thread.sleep(500);
		        clickOnSearchButton();
		        Thread.sleep(2000);
		        if(getText(EdaatOR.Biller_Receivables_exportedContracts_StatusInGrid).equals(testdatamap.get("Status").toString()))
		        {
		        	WebClick(EdaatOR.Biller_ExportContact_InvID+"/span");
					Thread.sleep(100);
					switchToWindow();
					Thread.sleep(100);
					uncheckPaymentMethods();
					Thread.sleep(100);
					Thread.sleep(100);
					uncheckPaymentMethods();
					Log.ReportEvent("PASS", " Payment Methods Are Editable In Invoice Details Page is Successful");								

		        }
		        else {
					Log.ReportEvent("FAIL", " Payment Methods Are Editable In Invoice Details Page is Unsuccessful");	
					takeScreenShot();
					driver.quit();
                    Assert.fail();
		        }
			    						
		}
		catch(Exception e){
			Log.ReportEvent("FAIL", " Payment Methods Are Editable In Invoice Details Page is Unsuccessful");	
			takeScreenShot();
			driver.quit();
            Assert.fail();

		}
	}
		//Function Summary   : Method to Navigate Exported contract and Print invoice details.
				//Parameter Summary :  InvoiceType,ExportContact.

				public void verifyExportContact(Map<Object,Object> testdatamap,Log Log) throws Exception {
					try {
						String ID=null;
						String iType=testdatamap.get("InvoiceType").toString();
						if(iType.equalsIgnoreCase("ExportContact")) {
							naviagteReveiableExportContact(Log);
							Thread.sleep(1000);
							if(CheckElementExists(EdaatOR.Biller_ExportContact_InvID)==false){
								navigateToCreateInvoicePage(Log);
								enterClientNameOrNationalID(testdatamap);
								selectTemplate(testdatamap);
								addProductDetails(testdatamap);
								enterInvoicDetails(testdatamap,Log);
								ID=getBillerContactID();
								enterInvoiceCaseSaveType(testdatamap,Log);
								int afterSave=getInvoiceCountNextAfteradd();
								WebClick(EdaatOR.Biller_Invoice_BillNo+"/span[text(),'"+ID+"']");
							}
							else {
								ID=getText(EdaatOR.Biller_ExportContact_InvID+"/span");
								WebClick(EdaatOR.Biller_ExportContact_InvID+"/span");
							}
							switchToWindow();
							Thread.sleep(2000);
							if(ExistsCheck(EdaatOR.Biller_Invoice_PrintButton))
							{
							VerifyValue1(getText(EdaatOR.Biller_ExportContact_ContactHeader), ID);
							verifyElementIsPresent(EdaatOR.Biller_ExportContact_InvoiceDetails);
							WebClick(EdaatOR.Biller_Invoice_PrintButton);		
							

							Log.ReportEvent("PASS", " Print Invoice Details on Exported Contacts is Successful");
							}
							else {
								Log.ReportEvent("FAIL", " Print Invoice Details on Exported Contacts is Unsuccessful");
								this.takeScreenShot();
								driver.quit();
								Assert.fail();
							}
						}
					}
					catch(Exception e){
						Log.ReportEvent("FAIL", " Print Invoice Details on Exported Contacts is Unsuccessful");
						this.takeScreenShot();
						driver.quit();
						Assert.fail();
					}
				}
				
				public void createInvoiceErrorMessageValidation(Map<Object,Object> testdatamap,Log Log) {
					try
					{
						
						String Testfield= testdatamap.get("Type").toString();		
									
						     naviagteReveiableExportBiller(Log);
							//enterClientNameOrNationalID(testdatamap);
				        	Thread.sleep(2000);
							selectDropdownValue_PartialText(EdaatOR.Biller_Receivables_Template,testdatamap.get("TemplateName").toString());
						
						if(Testfield.equalsIgnoreCase("Invoiceduedate"))
						{
						WebClick(EdaatOR.Biller_CreateandSaveUi);
						Thread.sleep(1000);
						driver.findElement(By.xpath(EdaatOR.BillerInternalcode)).sendKeys(Keys.PAGE_DOWN);
						Thread.sleep(1000);
						if(IsDispalyed(EdaatOR.Biller_InvoiceduedateUi))
						{
				        	Log.ReportEvent("PASS", "Validate Enter Invoice Due Date Error Message is Successful");
				
						}else {
				        	Log.ReportEvent("FAIL", "Validate Enter Invoice Due Date Error Message is Unsuccessful");
							this.takeScreenShot();			
			                driver.quit();
			                Assert.fail();
						}
					}
						else if(Testfield.equalsIgnoreCase("InvoiceExpiredate"))
						{
							    duedate(testdatamap);
					        	Thread.sleep(2000);
					        	WebClick(EdaatOR.Biller_CreateandSaveUi);
								Thread.sleep(1000);
								driver.findElement(By.xpath(EdaatOR.Biller_Invoice_DueDate)).sendKeys(Keys.PAGE_UP);
								Thread.sleep(1000);
								if(IsDispalyed(EdaatOR.Biller_InvoiceExpiredateUi))
								{
						        	Log.ReportEvent("PASS", "Validate Enter Invoice Expire Date Error Message is Successful");
						
								}else {
						        	Log.ReportEvent("FAIL", "Validate Enter Invoice Expire Date Error Message is Unsuccessful");
									this.takeScreenShot();			
					                driver.quit();
					                Assert.fail();
								}
						}			
						else if(Testfield.equalsIgnoreCase("Fromhour"))
						{
							    duedate(testdatamap);
					        	Thread.sleep(2000);
							    Expiredate(testdatamap);
					        	Thread.sleep(2000);
					        	WebClick(EdaatOR.Biller_CreateandSaveUi);
								Thread.sleep(1000);
								driver.findElement(By.xpath(EdaatOR.BillerInternalcode)).sendKeys(Keys.PAGE_UP);
								Thread.sleep(1000);
								if(IsDispalyed(EdaatOR.Biller_InvoiceFromhourUi))
								{
						        	Log.ReportEvent("PASS", "Validate Enter Invoice From Hour Error Message is Successful");
						
								}else {
						        	Log.ReportEvent("FAIL", "Validate Enter Invoice From Hour Error Message is Unsuccessful");
									this.takeScreenShot();			
					                driver.quit();
					                Assert.fail();
								}
						}
						else if(Testfield.equalsIgnoreCase("ToTime"))
						{
							    duedate(testdatamap);
					        	Thread.sleep(2000);
							    Expiredate(testdatamap);
					        	Thread.sleep(2000);
					        	WebEdit(EdaatOR.Biller_Fromhour,testdatamap.get("FromHour").toString());
					        	Thread.sleep(2000);
					        	WebClick(EdaatOR.Biller_CreateandSaveUi);
								Thread.sleep(1000);
								driver.findElement(By.xpath(EdaatOR.BillerInternalcode)).sendKeys(Keys.PAGE_UP);
								Thread.sleep(1000);
								if(IsDispalyed(EdaatOR.Biller_InvoiceTotimeUi))
								{
						        	Log.ReportEvent("PASS", "Validate Enter Invoice To Time Error Message is Successful");
						
								}else {
						        	Log.ReportEvent("FAIL", "Validate Enter Invoice To Time Error Message is Unsuccessful");
									this.takeScreenShot();			
					                driver.quit();
					                Assert.fail();
								}
						}
					
						else if(Testfield.equalsIgnoreCase("Condition"))
						{
							    duedate(testdatamap);
					        	Thread.sleep(2000);
							    Expiredate(testdatamap);
					        	Thread.sleep(2000);
					        	WebEdit(EdaatOR.Biller_Fromhour,testdatamap.get("FromHour").toString());
					        	Thread.sleep(2000);
					        	WebEdit(EdaatOR.Biller_Totime,testdatamap.get("ToTime").toString());
					        	Thread.sleep(2000);
					        	WebClick(EdaatOR.Biller_CreateandSaveUi);
								Thread.sleep(1000);
								driver.findElement(By.xpath(EdaatOR.BillerInternalcode)).sendKeys(Keys.PAGE_UP);
								Thread.sleep(1000);
								if(IsDispalyed(EdaatOR.Biller_InvoiceConditionUi))
								{
						        	Log.ReportEvent("PASS", "Validate Enter Invoice Condition Error Message is Successful");
						
								}else {
						        	Log.ReportEvent("FAIL", "Validate Enter Invoice Condition Error Message is Unsuccessful");
									this.takeScreenShot();			
					                driver.quit();
					                Assert.fail();
								}
						}
						else if(Testfield.equalsIgnoreCase("Clienttype"))
						{
							    duedate(testdatamap);
					        	Thread.sleep(2000);
							    Expiredate(testdatamap);
					        	Thread.sleep(2000);
					        	WebEdit(EdaatOR.Biller_Fromhour,testdatamap.get("FromHour").toString());
					        	Thread.sleep(2000);
					        	WebEdit(EdaatOR.Biller_Totime,testdatamap.get("ToTime").toString());
					        	Thread.sleep(2000);
					        	WebEdit(EdaatOR.Biller_Condition,testdatamap.get("Condition").toString());
					        	WebClick(EdaatOR.Biller_CreateandSaveUi);
								Thread.sleep(2000);
								driver.findElement(By.xpath(EdaatOR.BillerInternalcode)).sendKeys(Keys.PAGE_UP);
								Thread.sleep(1000);
								if(IsDispalyed(EdaatOR.Biller_Selecttype))
								{
						        	Log.ReportEvent("PASS", "Validate Enter Invoice Client Type Error Message is Successful");
						
								}else {
						        	Log.ReportEvent("FAIL", "Validate Enter Invoice Client Type Error Message is Unsuccessful");
									this.takeScreenShot();			
					                driver.quit();
					                Assert.fail();
								}
						}
						else if(Testfield.equalsIgnoreCase("Product"))
						{	   	        	          	 
				        	 
							    duedate(testdatamap);	        	  
					        	Thread.sleep(2000);
							    Expiredate(testdatamap);
					        	Thread.sleep(2000);
					        	WebClickUsingJS(EdaatOR.Biller_Indivbtn);
					        	Thread.sleep(2000);
					        	SelectIndCustomerID(testdatamap.get("ClientName").toString());
					        	//enterClientNameOrNationalID(testdatamap);
					        	Thread.sleep(5000);
					        	WebEdit(EdaatOR.Biller_Fromhour,testdatamap.get("FromHour").toString());
					        	Thread.sleep(2000);
					        	WebEdit(EdaatOR.Biller_Totime,testdatamap.get("ToTime").toString());
					        	Thread.sleep(2000);
					        	WebEdit(EdaatOR.Biller_Condition,testdatamap.get("Condition").toString());
					        	Thread.sleep(2000);		        	
					        	WebClick(EdaatOR.Biller_CreateandSaveUi);
								Thread.sleep(2000);
								driver.findElement(By.xpath(EdaatOR.BillerInternalcode)).sendKeys(Keys.PAGE_UP);
								Thread.sleep(1000);
								if(IsDispalyed(EdaatOR.Biller_Product))
								{
						        	Log.ReportEvent("PASS", "Validate Select Product Error Message on Invoice Page is Successful");
						
								}else {
						        	Log.ReportEvent("FAIL", "Validate Select Product Error Message on Invoice Page is Unsuccessful");
									this.takeScreenShot();			
					                driver.quit();
					                Assert.fail();
								}
						}
						
						else if(Testfield.equalsIgnoreCase("Duration type"))
						{
						duedate(testdatamap);
						Thread.sleep(2000);
						addProductDetails(testdatamap);
						Thread.sleep(2000);
						WebClickUsingJS(EdaatOR.Biller_CreateIns);
						Thread.sleep(2000);
						driver.findElement(By.xpath(EdaatOR.Biller_Invoiceduration)).sendKeys(Keys.PAGE_UP);
						Thread.sleep(1000);
						if(IsDispalyed(EdaatOR.Biller_InvoiceDurationUi))
						{
				        	Log.ReportEvent("PASS", "Validate Invoice Duration Type Error Message is Successful");
				
						}else {
				        	Log.ReportEvent("FAIL", "Validate Invoice Duration Type Error Message is Unsuccessful");
							this.takeScreenShot();			
			                driver.quit();
			                Assert.fail();
						}			
					}
						
						else if(Testfield.equalsIgnoreCase("Description"))
						{
						duedate(testdatamap);
						Thread.sleep(2000);
						WebClickUsingJS(EdaatOR.Biller_Indivbtn);
			        	Thread.sleep(2000);
			        	SelectIndCustomerID(testdatamap.get("ClientName").toString());
			        	Thread.sleep(2000);
						addProductDetails(testdatamap);
						Thread.sleep(2000);
						SelectDuration(testdatamap.get("Duration").toString());
						Thread.sleep(2000);
						WebClickUsingJS(EdaatOR.Biller_CreateIns);
						Thread.sleep(4000);
						WebClickUsingJS(EdaatOR.Biller_Invoiceexportbtn);
						Thread.sleep(2000);		
						if(IsDispalyed(EdaatOR.Biller_Descriptiondetails))
						{
				        	Log.ReportEvent("PASS", "Validate Invoice Description Error Message is Successful");
				
						}else {
				        	Log.ReportEvent("FAIL", "Validate Invoice Description Error Message is Unsuccessful");
							this.takeScreenShot();			
			                driver.quit();
			                Assert.fail();
						}		
					}			
						else if(Testfield.equalsIgnoreCase("Tax"))
						{
						WebClickUsingJS(EdaatOR.Biller_addtax);			
						Thread.sleep(2000);
						WebClickUsingJS(EdaatOR.Biller_addbutton);
						Thread.sleep(2000);
						if(IsDispalyed(EdaatOR.Biller_taxerrormsg))
						{
				        	Log.ReportEvent("PASS", "Validate Invoice Add Tax Error Message is Successful");
				
						}else {
				        	Log.ReportEvent("FAIL", "Validate Invoice Add Tax Error Message is Unsuccessful");
							this.takeScreenShot();			
			                driver.quit();
			                Assert.fail();
						}					
					}
						else if(Testfield.equalsIgnoreCase("Discount"))
						{
						WebClickUsingJS(EdaatOR.Biller_adddiscount);
						Thread.sleep(2000);
						WebClickUsingJS(EdaatOR.Biller_adddisbutton);
						Thread.sleep(1000);
						if(IsDispalyed(EdaatOR.Biller_discounterrormsg))
						{
				        	Log.ReportEvent("PASS", "Validate Invoice Add Discount Error Message is Successful");
				
						}else {
				        	Log.ReportEvent("FAIL", "Validate Invoice Add Discount Error Message is Unsuccessful");
							this.takeScreenShot();			
			                driver.quit();
			                Assert.fail();
						}					
					}
						Log.ReportEvent("PASS", "Validate Error Message on Create Invoice Page is Successful");
					}
					catch(Exception e)
					{
						Log.ReportEvent("FAIL", "Validate Error Message on Create Invoice Page is Unsuccessful");
						this.takeScreenShot();			
			            driver.quit();
			            Assert.fail();
					}
				}
				//Function Summary   : Method to Navigate Biller Exported Bills.
				//Parameter Summary :  N/A.
				public void naviagteReveiableExportBiller(Log Log) throws InterruptedException {
					ClickOnBReceivableLink();
					ClickOnBillerExportBillLink();
					waitForPageToLoad();
					if (CheckElementExists(EdaatOR.Biller_Exported_BillsList)) {				
						Thread.sleep(2000);
			        	Log.ReportEvent("PASS", "Exported Bills Page is Loaded Successfully");
				} else {
			    	Log.ReportEvent("FAIL", "Exported Bills Page is Not Loaded Successfully");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
				}
				}


}
