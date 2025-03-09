/**
 *
 * Test Script Name                   : N/A
 * Objective                          : Individual Client functionality
 * Version                            : 1.0
 * Author                             : Kathirvelu M
 * Created Date                       : 23/05/2023
 * Last Updated on                    : N/A
 * Updated By                         : Kalpana I R
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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.azmqalabs.edaattestautomation.common.Log;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;



public class AdminIndividualClientPage extends BasePage
{

	public AdminIndividualClientPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  


	@FindBy(xpath = EdaatOR.Admin_Client)
	public WebElement Client;


	public boolean Exists(){
		return super.Exists(Client); 
	}
	
	//Function Summary   : Method to navigate to Individual client lists 
	//Parameter Summary : N/A
	public void navigateToIndividualClientsList(Log Log) throws Exception {
		try{Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Admin_Client);
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Admin_Add_Individualclient);
		Thread.sleep(2000);
		if(CheckElementExists(EdaatOR.Admin_Individualclient_page)) {
			Log.ReportEvent("PASS", "Individual Clients List page is Loaded Successfully");
			}
			else{
				Log.ReportEvent("FAIL", "Individual Clients List is not Loaded Successfully");
				this.takeScreenShot();
				driver.quit();Assert.fail();
			}
		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Individual Clients List is not Loaded Successfully");
			this.takeScreenShot();
			driver.quit();Assert.fail();			
		}

	}

	//Function Summary  : Navigate to individual client, search client and view client
	//Parameter Summary : ClientName
	public void TableGridview(String Refno,Log Log){
		try{Thread.sleep(2000);
		WebClear(EdaatOR.Admin_Individualclient_CustomerRefNumber);
		WebEdit(EdaatOR.Admin_Individualclient_CustomerRefNumber,Refno);
		Thread.sleep(1000);
		WebClick(EdaatOR.Admin_Individualclient_Search);
		Thread.sleep(5000);

			if(CheckElementExists("//td[text()='"+Refno+"']")) {
				Log.ReportEvent("PASS", "Grid view Individual Client is Successfull");
			}
			else {
				Log.ReportEvent("FAIL", "Grid view Individual Client is not Successfull");
				this.takeScreenShot();
				driver.quit();Assert.fail();
			}
		}catch(Exception e){
			Log.ReportEvent("FAIL", "Grid view Individual Client is not Successfull");
			this.takeScreenShot();
			driver.quit();Assert.fail();	
		}
	}

	//Function Summary   : Method to to check "Export to excel" is clickable.  
	//Parameter Summary : N/A.
	public void Export(Log Log){
		try{
			Thread.sleep(1000);	
			if(CheckElementClickable(EdaatOR.Admin_Individualclient_export)==true) {
				WebClick(EdaatOR.Admin_Individualclient_export);
	        	Log.ReportEvent("PASS", "Export to excel is Successfull");
			}
			else {
	        	Log.ReportEvent("FAIL", "Export to excel is not Successfull");
				this.takeScreenShot();
				driver.quit();Assert.fail();
			}
		}catch(Exception e){
        	Log.ReportEvent("FAIL", "Export to excel is not Successfull");
			this.takeScreenShot();
			driver.quit();Assert.fail();	
		}
	}	

	//Function Summary   : Method to search individual client then activate and deactivate the client. 
	//Parameter Summary : ClientName
	public void ActivateDeactivate(Map<Object, Object>testdatamap,Log Log){
		try{
			Thread.sleep(1000);	
			WebEdit(EdaatOR.Biller_Individualclient_SearchByNationalID, testdatamap.get("NationalID").toString());        			
				WebClick(EdaatOR.Biller_Individualclient_SearchBtn);
				Thread.sleep(2000);
//				while (CheckElementExists(EdaatOR.Admin_Invoice_Next)==false){  
//				WebClick(EdaatOR.Admin_Invoice_NextPrevLink);}
				Thread.sleep(2000);
				verifyElementIsPresent(EdaatOR.Admin_Company_Togglebtn);
				WebClickUsingJS(EdaatOR.Admin_Company_Togglebtn);
				Thread.sleep(500);
		
				VerifyValue1(getText(EdaatOR.Admin_Compan_ActivePop), testdatamap.get("Active").toString());
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Admin_Compan_ActiveConfbtn);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Admin_Company_Togglebtn);
				Thread.sleep(2000);
				if(getText(EdaatOR.Admin_Compan_ActivePop).equals(testdatamap.get("InActive").toString())) {
				WebClickUsingJS(EdaatOR.Admin_Compan_ActiveConfbtn);
	        	Log.ReportEvent("PASS", "Activate and Deactivate Individual Client is Successful");

				}
				else {
		        	Log.ReportEvent("FAIL", "Activate and Deactivate Individual Client is not Successful");
					this.takeScreenShot();
                    driver.quit();Assert.fail();
				}

		}catch(Exception e){
        	Log.ReportEvent("FAIL", "Activate and Deactivate Individual Client is not Successful");
			this.takeScreenShot();
            driver.quit();Assert.fail();
		}
	}
	
	//Function Summary  : To click on Individual Client Lists and download ID image
	//Parameter Summary : NationalID
	public void Download(Map<Object,Object> testdatamap, Log Log){
		try{

			Thread.sleep(1000);
			AdminSearchIndividualclient(testdatamap.get("NationalID").toString());

				WebClickUsingJS(EdaatOR.Admin_InvoiceName);
				switchTonextwindow();
				Thread.sleep(1000);

				if(CheckElementExists(EdaatOR.Admin_Imgdownload)) {
					WebClickUsingJS(EdaatOR.Admin_Imgdownload);

					Log.ReportEvent("PASS", "Download ID is Successful");
					}
					else{
						Log.ReportEvent("FAIL", "Download ID is not Successful");
						this.takeScreenShot();
						driver.quit();Assert.fail();
					}

		}catch(Exception e){
			Log.ReportEvent("FAIL", "Download ID is not Suceessfull");
			this.takeScreenShot();
			driver.quit();Assert.fail();
		}
	}

	//Function Summary  : To search individual client using national id
	//Parameter Summary : Enter NationalID	
	public void AdminSearchIndividualclient(String NationalID) throws Exception{
			Thread.sleep(2000);	 
		    WebClickUsingJS(EdaatOR.Admin_Add_Individualclient);
			Thread.sleep(2000);
			WebEdit(EdaatOR.Admin_Individualclient_IdNumber,NationalID);
			Thread.sleep(2000);
			WebClick(EdaatOR.Admin_Individualclient_Search);
			Thread.sleep(1000);

	}

	//Function Summary   : Method to search individual client and verify client is displayed.  
	//Parameter Summary : Client name, National ID and Refno.
	public void AdminSearchIndividualclientall(String ClientName,String NationalID,String Refno,Log Log){
		try{

			WebEdit(EdaatOR.Admin_Individualclient_Name,ClientName);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Individualclient_IdNumber,NationalID);
			Thread.sleep(100);
//			WebEdit(EdaatOR.Admin_Individualclient_CustomerRefNumber,Refno);
//			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Individualclient_Search);
			Thread.sleep(4000);
			if(CheckElementExists("//td[text()='"+NationalID+"']")) {
				Log.ReportEvent("PASS", "Search Individual Client is Successful");
				}
				else{
					Log.ReportEvent("FAIL", "Search Individual Client is not Successful");
					this.takeScreenShot();
					driver.quit();Assert.fail();
				}

		}catch(Exception e){
			Log.ReportEvent("FAIL", "Search Individual Client is not Successful");
			this.takeScreenShot();
			driver.quit();Assert.fail();			
		}
	}

	//Function Summary  : method to add client details
	//Parameter Summary : FullName,SecondName,ThirdName,LastName,NationalID,Year,Month,Date,MobileNo,Email and Refno.
	public void Addclient(String FullName,String SecondName,String ThirdName,String LastName,String NationalID,String Year,String Month,String Date,String MobileNo,String Email,String Refno,Log Log){
		try{

			Thread.sleep(2000);
			WebClick(EdaatOR.Admin_Add_Individualclient_Button);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Individualclient_fname,FullName);
			WebEdit(EdaatOR.Admin_Individualclient_sname,SecondName);
			WebEdit(EdaatOR.Admin_Individualclient_tname,ThirdName);
			WebEdit(EdaatOR.Admin_Individualclient_lname,LastName);
			WebEdit(EdaatOR.Admin_Individualclient_IdNumber,NationalID);
			WebClick(EdaatOR.Admin_Individualclient_DateOfBirth);
			
			selectDropdownValue_PartialText(EdaatOR.Admin_Individualclient_DateOfYear, Year);
			selectDropdownValue_PartialText(EdaatOR.Admin_Individualclient_DateOfMonth, Month);
			WebClick("//a[text()='"+Date+"']");
			WebEdit(EdaatOR.Admin_Individualclient_Email,Email);
			WebClear(EdaatOR.Admin_Individualclient_Refno);
			WebEdit(EdaatOR.Admin_Individualclient_Refno,Refno);
			Thread.sleep(1000);            	
			WebEdit(EdaatOR.Admin_Individualclient_MobileNo,MobileNo);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Individualclient_Add);
			Thread.sleep(500);
			if(CheckElementExists(EdaatOR.Admin_NationalIDExistsAlertMsg)||CheckElementExists(EdaatOR.Admin_MandatoryErrorMsg)) {
				Log.ReportEvent("FAIL", "Add Individual client is not Successful");
				this.takeScreenShot();
				driver.quit();Assert.fail();
				}
				else{
					Log.ReportEvent("PASS", "Add Individual client is Successful");

				}
		}catch(Exception e){
			Log.ReportEvent("FAIL", "Add Individual client is not Successful");
			this.takeScreenShot();
			driver.quit();Assert.fail();			
		}
	}
	
	//Function Summary   : method to DeleteIndividualClient
	//Parameter Summary  : NationalID,ResonforDelete
	public void DeleteIndividualClient(String FullName,String SecondName,String ThirdName,String LastName,String NationalID,String Year,String Month,String Date,String MobileNo,String Email,String Refno,String ResonforDelete,Log Log) throws InterruptedException{
			Addclient(FullName,SecondName,ThirdName,LastName,NationalID,Year,Month,Date,MobileNo,Email,Refno,Log);
			Thread.sleep(1000);
			AdminSearchIndividualclientall(FullName,NationalID,Refno,Log);
			Thread.sleep(1000);
			DeleteIndClient(NationalID,ResonforDelete,Log);
	}
	
	//Function Summary   : method to  DeleteIndClient
	//Parameter Summary  : NationalID
	public void DeleteIndClient(String NationalID,String ResonforDelete,Log Log){
		try{
			if(getText("//td[text()='"+NationalID+"']").equals(NationalID)){
				selectDropdownValue_PartialText(EdaatOR.Admin_Invoice_Delete,"Delete");
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Admin_Invoice_Reasontxt);
				Thread.sleep(2000);
				WebClick("//li[text()='"+ResonforDelete+"']");
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Admin_Invoice_Deletebtn);
				Thread.sleep(2000);
				WebEdit(EdaatOR.Admin_Individualclient_IdNumber,NationalID);
				Thread.sleep(1000);
				WebClick(EdaatOR.Admin_Invoice_Deletechkbox);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Admin_Individualclient_Search);
				Thread.sleep(3000);
				if(CheckElementExists("//td[text()='"+NationalID+"']")) {
					Log.ReportEvent("PASS", "Delete Individul client is Successful");
				}
				else{
					Log.ReportEvent("FAIL", "Delete Individul client is not Successful");
					this.takeScreenShot();
					driver.quit();Assert.fail();
				}
					    	
			}

		}catch (Exception e) {
			Log.ReportEvent("FAIL", "Delete Individul client is Successful");
			this.takeScreenShot();
			driver.quit();Assert.fail();			
		}
	}
	//Function Summary  :To update individual Client.
	//Parameter Summary :N/A
	public void UpdateIndividualClient(String FullName,String SecondName,String ThirdName,String LastName,String NationalID,String Year,String Month,String Date,String MobileNo,String Email,String Refno,Log Log) throws InterruptedException{

			AdminSearchIndividualclientall(FullName,NationalID,Refno,Log);
			Thread.sleep(2000);
			UpdateIndClient(FullName, SecondName, ThirdName, LastName, Year, Month,Date, MobileNo, Email,Refno,Log);
		
	}


	//Function Summary  : To Edit Individual Client.
	//Parameter Summary : Enter FullName,SecondName,ThirdName,LastName,Year,Month,MobileNo and Email 
	public void UpdateIndClient(String FullName,String SecondName,String ThirdName,String LastName,String Year,String Month,String Date,String MobileNo,String Email,String Refno,Log Log){
		try{
			Thread.sleep(1000);	    	
			selectDropdownValue_PartialText(EdaatOR.Biller_Invoice_Delete,"Edit");
			//WebClick(EdaatOR.Biller_Invoice_Reasontxt);
			switchTonextwindow();
			WebClear(EdaatOR.Admin_Individualclient_fname);
			WebEdit(EdaatOR.Admin_Individualclient_fname,FullName);
			WebClear(EdaatOR.Admin_Individualclient_sname);
			WebEdit(EdaatOR.Admin_Individualclient_sname,SecondName);
			WebClear(EdaatOR.Admin_Individualclient_tname);
			WebEdit(EdaatOR.Admin_Individualclient_tname,ThirdName);
			WebClear(EdaatOR.Admin_Individualclient_lname);
			WebEdit(EdaatOR.Admin_Individualclient_lname,LastName);
			WebClick(EdaatOR.Admin_Individualclient_DateOfBirth);
			selectDropdownValue_PartialText(EdaatOR.Admin_Individualclient_DateOfYear, Year);
			selectDropdownValue_PartialText(EdaatOR.Admin_Individualclient_DateOfMonth, Month);
			WebClick("//a[text()='"+Date+"']");
			WebClear(EdaatOR.Admin_Individualclient_MobileNo);
			WebEdit(EdaatOR.Admin_Individualclient_MobileNo,MobileNo);
			WebClear(EdaatOR.Admin_Individualclient_Email);
			WebEdit(EdaatOR.Admin_Individualclient_Email,Email);
			//WebClear(EdaatOR.Admin_Individualclient_ClientRefNo);
			WebEdit(EdaatOR.Admin_Individualclient_ClientRefNo,Refno);
				
			WebClick(EdaatOR.Admin_Individualclient_Add);
			Thread.sleep(1000);	    	
			if(CheckElementExists(EdaatOR.Admin_Individualclient_page)) {
				Log.ReportEvent("PASS", "Update Individual Client is Successful");
				}
				else{
					Log.ReportEvent("FAIL", "Update Individual Client is not Successful");
					this.takeScreenShot();
					driver.quit();Assert.fail();
				}


		}catch (Exception e) {
			Log.ReportEvent("FAIL", "Update Individual Client is not Successful");
			this.takeScreenShot();
			driver.quit();Assert.fail();			
		}
	}


	public int getInvoiceCountNext() throws Exception {
		int intiCount=0;
		boolean countRow=false;
		while (CheckElementExists(EdaatOR.Biller_Invoice_Next)==false){  
			WebClick(EdaatOR.Biller_Invoice_NextBtn);
			Thread.sleep(1000);
			intiCount=intiCount+getInvoiceCount()+10;
			countRow=true;
		}

		if(countRow==false) {
			intiCount=10;
		}
		return intiCount;
	}
	public int getInvoiceCount() {
		List<WebElement> invoice = driver.findElements(By.xpath(EdaatOR.Biller_Invoice_Count));
		waitForPageToLoad();
		int count =invoice.size();
		return count;
	}
	public void naviagteCreateInvoicePage() {
		ClickOnExportInvoiceBtn();
		waitForPageToLoad();

	}
	public void ClickOnExportInvoiceBtn() {
		WebClickUsingJS(EdaatOR.Biller_AddInvoice_btn);
		waitForPageToLoad();
	}
	public void enterClientNameOrNationalID(Map<Object,Object> testdatamap) throws Exception {
		String client=testdatamap.get("ClientID").toString();
		if(client.equalsIgnoreCase("Individual")) {
			ClickOnIndividualRadBtn();
		}
		else if(client.equalsIgnoreCase("Corporate")){
			ClickOnCoporateRadBtn();
		}

		SelectCustomerID(testdatamap.get("ClientName").toString());
		String sBill=testdatamap.get("SubBiller").toString();
		if(!sBill.equalsIgnoreCase("")) {
			SelectSubBiller(sBill);
		}

	}
	public void SelectSubBiller(String SubBiller) {
		WebSelect(EdaatOR.Biller_Invoice_SBilIdList,SubBiller);
		waitForPageToLoad();
	}
	public void SelectCustomerID(String Cust) throws Exception {

		WebClick(EdaatOR.Biller_Invoice_CustIDList);
		Thread.sleep(500);
		WebClick(EdaatOR.Biller_Invoice_ClientRoleId+"["+Cust+"]");
		waitForPageToLoad();
	}
	public void ClickOnCoporateRadBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_CopoRdv);
		waitForPageToLoad();
	}

	public void ClickOnIndividualRadBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_IndividualRdv);
		waitForPageToLoad();
	}
	public void selectTemplate(String drop,Map<Object,Object> testdatamap) throws Exception {

		Thread.sleep(500);	
		waitForPageToLoad();

		waitForPageToLoad();
	}
	//Function Summary   : Method to select sub biller 
	//Parameter Summary  :N/A 
	public void selectSubbiller(String drop,Map<Object,Object> testdatamap) throws Exception {
		Thread.sleep(1000);
		WebClick(EdaatOR.Admin_Invoice_SBilIdList);
		Thread.sleep(5000);
		WebClick(EdaatOR.Admin_Invoice_ClientRoleId+"["+drop+"]");
		waitForPageToLoad();
		Thread.sleep(2000);
		//EnterFixedPrice(testdatamap.get("FixedPrice").toString());
		//	EnterPercentage(testdatamap.get("FixedPercentage").toString());

	}
	public void SelectInvoiceTemplate(String sel, String Tem) throws InterruptedException {
		Thread.sleep(500);
		selectDropdownValue_PartialText(sel, Tem);
	}
	public void ClickOnProductBtn() {
		WebClickUsingJS(EdaatOR.Admin_Invoice_AddProductBtn);
		waitForPageToLoad();
	}
	//Function Summary   : Method to select product name
	//Parameter Summary : product name
	public void SelectProduct(String Cust) {
		WebSelect(EdaatOR.Admin_Invoice_ProductID,Cust);
		waitForPageToLoad();
	}
	public void ClickOnProductAddBtn() throws Exception{
		WebClick(EdaatOR.Admin_Invoice_AddBtn);
		waitForPageToLoad();
	}
	//Function Summary   : Method to enter issue date
	//Parameter Summary  : Issue date
	public void EnterIssuedDate() throws Exception {
		//	scrollDowntillend(driver);
		Thread.sleep(1000);
		WebClick(EdaatOR.Admin_Invoice_DateInvoc);
		Thread.sleep(1000);
		WebClick(EdaatOR.Admin_RegistDate_exprDate);
		Thread.sleep(1000);
	}


	public void SelectDuration(String dur) {
		WebSelect(EdaatOR.Admin_Invoice_DurationID,dur);
		waitForPageToLoad();
	}

	public void EnterMinPrice(String Price) throws Exception {
		WebEdit(EdaatOR.Admin_Invoice_MinTax,Price);
		waitForPageToLoad();
	}
	public void EnterFixedPrice(String Price) throws Exception {
		WebEdit(EdaatOR.Admin_Invoice_Fixed,Price);
		waitForPageToLoad();
	}


	public void EnterCondition(String Price) throws Exception {
		WebEdit(EdaatOR.Biller_Invoice_Conditon,Price);
		waitForPageToLoad();
	}
	public void EnterPercentage(String Price) throws Exception {
		WebEdit(EdaatOR.Admin_Invoice_Percentage,Price);
		waitForPageToLoad();
	}
	public void ClickOnCreateInvoiceBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_CreateReapeat);
		waitForPageToLoad();
	}
	public void EnterDescriptionSaved(String Price) throws Exception{
		WebEdit(EdaatOR.Biller_Invoice_Descript,Price);
		waitForPageToLoad();
	}

	public void EnterDescriptionOne(String Price) throws Exception{
		WebEdit(EdaatOR.Admin_Invoice_Descript1,Price);
		waitForPageToLoad();
	}
	public void ClickOnExportBtn() {
		WebClickUsingJS(EdaatOR.Admin_Invoice_ExportButton);
		waitForPageToLoad();
	}

	//Function Summary  : Method to click on "Save" button
	//Parameter Summary :N/A
	public void ClickOnSaveBtn() {
		WebClickUsingJS(EdaatOR.Admin_Invoice_Create);
		waitForPageToLoad();
	}

	//Function Summary   : Method to add ProductPrice 
	//Parameter Summary :Price
	public void EnterProductPrice(String Price) throws Exception {
		Thread.sleep(1000);
		WebClearUsingKeys(EdaatOR.Admin_Invoice_TaxPric);
		WebEdit(EdaatOR.Admin_Invoice_TaxPric,Price);
		waitForPageToLoad();
	}

	//Function Summary   : Method to add product 
	//Parameter Summary : ProductName, ProductPrice
	public void addProductDetails(Map<Object,Object> testdatamap) throws Exception {
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
	//Function Summary   : Method to  click on terms
	//Parameter Summary  : N/A
	public void EnterCondition() {
		WebClickUsingJS(EdaatOR.Admin_Invoice_Conditonbtn);
		waitForPageToLoad();
	}

	//Function Summary   : Method to enter issue date and terms
	//Parameter Summary  : Issue date and terms
	public void enterInvoicDetails(Map<Object,Object> testdatamap) throws Exception {
		scrollDowntillend(driver);
		
		EnterIssuedDate();
		EnterCondition();
		Thread.sleep(1000);
	}
	public int getInvoiceCountNextAfteradd() throws Exception {
		int aftCount=0;
		boolean countRow=false;
		while (CheckElementExists(EdaatOR.Admin_Invoice_Next)==false){  
			WebClick(EdaatOR.Admin_Invoice_NextBtn);
			Thread.sleep(1000);
			aftCount=aftCount+getInvoiceCountAdd()+10;
			countRow=true;
		}

		if(countRow==false) {
			aftCount=10;
		}
		return aftCount;
	}
	public void enterInvoiceCaseType(Map<Object,Object> testdatamap) throws Exception {

		//		EnterDescriptionSaved(testdatamap.get("Description").toString());
		//		EnterDescriptionOne(testdatamap.get("Description").toString());
		String iType=testdatamap.get("InvoiceType").toString();
		if(iType.equalsIgnoreCase("Save")) {
			ClickOnSaveBtn();
		}
		else if(iType.equalsIgnoreCase("Export")){
			ClickOnExportBtn();
		}
		Thread.sleep(1000);
	}
	//Function Summary  :Method to get invoice count
	//Parameter Summary :N/A
	public int getInvoiceCountAdd() {
		List<WebElement> invoice = driver.findElements(By.xpath(EdaatOR.Biller_Invoice_AfteraddInvoice));
		waitForPageToLoad();
		int count =invoice.size();
		return count;
	}
	//Function Summary  :Method to enter invoice description
	//Parameter Summary :Description
	public void enterInvoiceCaseSaveType(Map<Object,Object> testdatamap) throws Exception {
		EnterDescriptionSaved(testdatamap.get("Description").toString());
		EnterDescriptionOne(testdatamap.get("Description").toString());
		String iType=testdatamap.get("InvoiceType").toString();
		ClickOnSaveBtn();

		Thread.sleep(1000);
	}
	//Function Summary  :Method to click on exported bills
	//Parameter Summary :N/A
	public void ClickOnAdminExportBillLink() {
		WebClickUsingJS(EdaatOR.Admin_ExportBill_Link);
		waitForPageToLoad();
	}

	//Function Summary   :Navigate to individual client, create invoice and verify invoice is created
	//Parameter Summary :TemplateName.
	public void CreateIndividualClientInvoice(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {

			Thread.sleep(2000);	    	
			selectDropdownValue_PartialText(EdaatOR.Admin_Invoice_Delete,"Create Invoice");
			switchTonextwindow();
			waitForPageToLoad();
			Thread.sleep(4000);	
			selectSubbiller(EdaatOR.Admin_Invoice_SBilIdList,testdatamap);
			Thread.sleep(1000);
			WebSelect(EdaatOR.Admin_Invoice_TemplateList,testdatamap.get("TemplateName").toString());
			waitForPageToLoad();
			addProductDetails(testdatamap);
			enterInvoicDetails(testdatamap);
			Thread.sleep(800);
			ClickOnSaveBtn();
			Thread.sleep(2000);
			waitForPageToLoad();
			
			ClickOnAdminExportBillLink();
			Thread.sleep(2000);
			waitForPageToLoad();
			int val=getInvoiceCountAdd();
			if(CheckElementExists(EdaatOR.Admin_Invoice_AfteraddInvoice+"["+val+"]/td[10]")){
	        	Log.ReportEvent("PASS", "Create Individual Client Invoice is Successfull");
			}
			else{
	        	Log.ReportEvent("FAIL", "Create Individual Client Invoice is not Successfull");
	        	this.takeScreenShot();
	        	driver.quit();Assert.fail();
			}
			


		}
		catch(Exception e){
        	Log.ReportEvent("FAIL", "Create Individual Client Invoice is not Successfull");
        	this.takeScreenShot();
        	driver.quit();Assert.fail();
		}
	}
	//Function Summary  :Navigate to individual client, search client and view invoice
	//Parameter Summary :ClientName,nationalID,ClientReferenceNumber
	public void ViewIndividualClientInvoice(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			Thread.sleep(1000);	    	
			WebEdit(EdaatOR.Admin_ClientName,testdatamap.get("ClientName").toString());
			Thread.sleep(1000);	 
			WebEdit(EdaatOR.Admin_IN_nationalID,testdatamap.get("nationalID").toString());
			Thread.sleep(1000);	
			WebEdit(EdaatOR.Admin_IN_ClientRef_Number,testdatamap.get("ClientReferenceNumber").toString());
			Thread.sleep(1000);	
			WebClick(EdaatOR.Admin_ClientSearch_button);
			Thread.sleep(1000);	
			selectDropdownValue_PartialText(EdaatOR.Admin_Invoice_Delete,"View Invoice");
			switchTonextwindow();
		
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_Invoice_view);
			Thread.sleep(2000);
			switchTonextwindow();
			
			if(ExistsCheck(EdaatOR.Admin_Invoice_form)) {
	        	Log.ReportEvent("PASS", "View Individual Client Invoice is Successfull");
			}
			else {
	        	Log.ReportEvent("FAIL", "View Individual Client Invoice is not Successfull");
				this.takeScreenShot();
				driver.quit();Assert.fail();
			}
				    	
		}catch(Exception e){
        	Log.ReportEvent("FAIL", "View Individual Client Invoice is not Successfull");
			this.takeScreenShot();
			driver.quit();Assert.fail();
		}}
	
	//Function Summary  : method to verify Error messages in Add individual client page
	//Parameter Summary : FullName,SecondName,ThirdName,LastName,NationalID,Year,Month,Date,MobileNo,Email and Refno.
	public void VerifyAddIndClietErrorMsg(String FullName,String SecondName,String ThirdName,String LastName,String NationalID,String Year,String Month,String Date,String MobileNo,String Email,String Refno,String ExpectedResult,Log Log) throws InterruptedException{
		{
			try {
			Thread.sleep(2000);
			WebClick(EdaatOR.Admin_Add_Individualclient_Button);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Individualclient_fname,FullName);
			WebEdit(EdaatOR.Admin_Individualclient_sname,SecondName);
			WebEdit(EdaatOR.Admin_Individualclient_tname,ThirdName);
			WebEdit(EdaatOR.Admin_Individualclient_lname,LastName);
			WebEdit(EdaatOR.Admin_Individualclient_IdNumber,NationalID);
			WebClick(EdaatOR.Admin_Individualclient_DateOfBirth);
			
			selectDropdownValue_PartialText(EdaatOR.Admin_Individualclient_DateOfYear, Year);
			selectDropdownValue_PartialText(EdaatOR.Admin_Individualclient_DateOfMonth, Month);
			WebClick("//a[text()='"+Date+"']");
			WebEdit(EdaatOR.Admin_Individualclient_Email,Email);
			WebClear(EdaatOR.Admin_Individualclient_Refno);
			WebEdit(EdaatOR.Admin_Individualclient_Refno,Refno);
			Thread.sleep(1000);            	
			WebEdit(EdaatOR.Admin_Individualclient_MobileNo,MobileNo);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Individualclient_Add);
			
			
				if (ExistsCheck(EdaatOR.Admin_AlertMsg)){	
						if(ExpectedResult.equals( getText(EdaatOR.Admin_ClientRefExistsAlertMsg))) {
						Log.ReportEvent("PASS", "Verify 'Individual Client Reference number Exists' alert message is successful");
					}else if(ExpectedResult.equals( getText(EdaatOR.Admin_NationalIDExistsAlertMsg))) { 
						Log.ReportEvent("PASS", "Verify 'Individual Client NationalID Exists' alert message is successful");
					}
				}
				else if (ExistsCheck(EdaatOR.Admin_MandatoryErrorMsg)){	
					
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_FirstNameErrorMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_SecondNameErrorMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_ThirdNameErrorMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_LastNameErrorMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_NationalIDErrorMsg));	
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_MobileNoErrorMsg));	
					Log.ReportEvent("PASS", "Verify 'This field is required' error Message is successful");

				}
				else if (ExpectedResult.equals( getText(EdaatOR.Admin_FirstNameErrorMsg))) {

					Log.ReportEvent("PASS", "Verify Individual Client FirstName error Message is successful");
				}else if (ExpectedResult.equals( getText(EdaatOR.Admin_SecondNameErrorMsg))) {

					Log.ReportEvent("PASS", "Verify Individual Client SecondName error Message is successful");
				}else if (ExpectedResult.equals( getText(EdaatOR.Admin_ThirdNameErrorMsg))){	

					Log.ReportEvent("PASS", "Verify Individual Client ThirdName error Message is successful");

				}else if (ExpectedResult.equals( getText(EdaatOR.Admin_LastNameErrorMsg))){	

					Log.ReportEvent("PASS", "Verify Individual Client LastName error Message is successful");

				}else if (ExpectedResult.equals( getText(EdaatOR.Admin_NationalIDErrorMsg))){

					Log.ReportEvent("PASS", "Verify Individual Client NationalID error Message is successful");

				}else if (ExpectedResult.equals( getText(EdaatOR.Admin_MobileNoErrorMsg))){

					Log.ReportEvent("PASS", "Verify Individual Client Mobile Number error Message is successful");

				}
//				else if (ExpectedResult.equals( getText(EdaatOR.Admin_NationalIDStartsError))){	
//
//					Log.ReportEvent("PASS", "Verify 'Individual Client National ID should starts with 1 or 2' error Message is successful");
//
//				}
				else {
					Log.ReportEvent("FAIL", "Verify Individual Client error Message is not successful");
					this.takeScreenShot();
					driver.quit();Assert.fail();
				}

			} catch (Exception e) {
				Log.ReportEvent("FAIL", "Verify Individual Client error Message is not successful");
				this.takeScreenShot();
				driver.quit();Assert.fail();			}

		}

	}

	//Function Summary  : method to verify Error messages in Edit individual client page
	//Parameter Summary : FullName,SecondName,ThirdName,LastName,NationalID,Year,Month,Date,MobileNo,Email and Refno.
	public void VerifyEditIndClietErrorMsg(String FullName,String SecondName,String ThirdName,String LastName,String NationalID,String Year,String Month,String Date,String MobileNo,String Email,String Refno,String ExpectedResult,Log Log) throws InterruptedException{
		{try {
			Thread.sleep(1000);	
			WebClick(EdaatOR.Admin_Invoice_NextBtn);
			Thread.sleep(2000);	
			selectDropdownValue_PartialText(EdaatOR.Biller_Invoice_Delete,"Edit");
			//WebClick(EdaatOR.Biller_Invoice_Reasontxt);
			switchTonextwindow();
			WebClear(EdaatOR.Admin_Individualclient_fname);
			WebEdit(EdaatOR.Admin_Individualclient_fname,FullName);
			WebClear(EdaatOR.Admin_Individualclient_sname);
			WebEdit(EdaatOR.Admin_Individualclient_sname,SecondName);
			WebClear(EdaatOR.Admin_Individualclient_tname);
			WebEdit(EdaatOR.Admin_Individualclient_tname,ThirdName);
			WebClear(EdaatOR.Admin_Individualclient_lname);
			WebEdit(EdaatOR.Admin_Individualclient_lname,LastName);
			WebClick(EdaatOR.Admin_Individualclient_DateOfBirth);
			selectDropdownValue_PartialText(EdaatOR.Admin_Individualclient_DateOfYear, Year);
			selectDropdownValue_PartialText(EdaatOR.Admin_Individualclient_DateOfMonth, Month);
			WebClick("//a[text()='"+Date+"']");
			WebClear(EdaatOR.Admin_Individualclient_MobileNo);
			WebEdit(EdaatOR.Admin_Individualclient_MobileNo,MobileNo);
			WebClear(EdaatOR.Admin_Individualclient_Email);
			WebEdit(EdaatOR.Admin_Individualclient_Email,Email);
			WebClear(EdaatOR.Admin_Individualclient_ClientRefNo);
			WebEdit(EdaatOR.Admin_Individualclient_ClientRefNo,Refno);
				
			WebClick(EdaatOR.Admin_Individualclient_Add);
			
			
				if (ExistsCheck(EdaatOR.Admin_AlertMsg)){	
					if(ExpectedResult.equals(getText(EdaatOR.Admin_ClientRefExistsAlertMsg))) {
						Log.ReportEvent("PASS", "Verify 'Individual Client Reference number Exists' alert message is successful");
					}else if(ExpectedResult.equals(getText(EdaatOR.Admin_NationalIDExistsAlertMsg))) { 
						Log.ReportEvent("PASS", "Verify 'Individual Client NationalID Exists' alert message is successful");

					}
				}
				else if (ExistsCheck(EdaatOR.Admin_MandatoryErrorMsg)){	
					
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_FirstNameErrorMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_SecondNameErrorMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_ThirdNameErrorMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_LastNameErrorMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_MobileNoErrorMsg));	
					Log.ReportEvent("PASS", "Verify 'This field is required' error Message is successful");

				}
				else if (ExpectedResult.equals (getText(EdaatOR.Admin_FirstNameErrorMsg))) {
					Log.ReportEvent("PASS", "Verify Individual Client FirstName error Message is successful");

				}else if (ExpectedResult.equals (getText(EdaatOR.Admin_SecondNameErrorMsg))) {

					Log.ReportEvent("PASS", "Verify Individual Client SecondName error Message is successful");

				}else if (ExpectedResult.equals (getText(EdaatOR.Admin_ThirdNameErrorMsg))){	
					Log.ReportEvent("PASS", "Verify Individual Client ThirdName error Message is successful");

				}else if (ExpectedResult.equals (getText(EdaatOR.Admin_LastNameErrorMsg))){	

					Log.ReportEvent("PASS", "Verify Individual Client LastName error Message is successful");

				}
				else if (ExpectedResult.equals (getText(EdaatOR.Admin_MobileNoErrorMsg))){	
					Log.ReportEvent("PASS", "Verify Individual Client Mobile Number error Message is successful");

				}

				else {
					Log.ReportEvent("FAIL", "Verify Edit Individual Client error Message is not successful");
					this.takeScreenShot();
					driver.quit();Assert.fail();
				}

			} catch (Exception e) {
				Log.ReportEvent("FAIL", "Verify Edit Individual Client error Message is not successful");
				this.takeScreenShot();
				driver.quit();Assert.fail();			}

		}

	}

	//Function Summary  : method to verify Error messages in delete individual client page
	//Parameter Summary : ExpectedResult
	public void VerifyDeleteIndClietErrorMsg(String ExpectedResult,Log Log) throws InterruptedException{
		{
			try {
				Thread.sleep(1000);
				selectDropdownValue_PartialText(EdaatOR.Admin_Invoice_DeleteFrstRow,"Delete");
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_Invoice_Deletebtn);
				
				if (ExpectedResult.equals(getText(EdaatOR.Admin_DeleteClientErrMsg))){	
					Log.ReportEvent("PASS", "Verify Delete Individual Client Error message is Successful");

				}

				else {
					Log.ReportEvent("FAIL", "Verify Delete Individual Client Error message is not Successful");
					this.takeScreenShot();
					driver.quit();Assert.fail();
				}

			} catch (Exception e) {
				Log.ReportEvent("FAIL", "Verify Delete Individual Client Error message is not Successful");
				this.takeScreenShot();
				driver.quit();Assert.fail();
				}

		}

	}
}