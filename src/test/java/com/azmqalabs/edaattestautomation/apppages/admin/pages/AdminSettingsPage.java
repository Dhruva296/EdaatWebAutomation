/**
*
* Test Script Name                   :N/A
* Objective                          : Admin Settings functionality.
* Version                            : 1.0
* Author                             : Kathirvelu M
* Created Date                       : 23/05/2023
* Last Updated on                    : N/A
* Updated By                         : Kalpana I R
* Pre-Conditions                     : N/A
* Manual Testcase Name               : N/A
* Epic Details                       : N/A
* User Story Details                 : N/A
* Defects affecting this test script : None
* Work Arounds/Known Issues          : None
**/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.io.File;
import java.io.IOException;
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

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;



public class AdminSettingsPage extends BasePage
{

	public AdminSettingsPage(WebDriver driver,ExtentTest test)
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
	
	public int getInvoiceCountNext() throws Exception {
		int intiCount=0;
		boolean countRow=false;
		while (CheckElementExists(EdaatOR.Admin_Invoice_Next)==false){  
			WebClick(EdaatOR.Admin_Invoice_NextPrevLink);
			int count=getInvoiceCount();
			String pageNum=getText(EdaatOR.Admin_Invoice_NextPrevLink);
			Thread.sleep(1000);
			intiCount=intiCount+getInvoiceCount()+((Integer.valueOf(pageNum)-1)*10);
			countRow=true;
		}
		if(countRow==false) {
			intiCount=10;
		}
		return intiCount;
	}
	
	public int getInvoiceCount() {
		List<WebElement> invoice = driver.findElements(By.xpath(EdaatOR.Admin_Invoice_Count));
		waitForPageToLoad();
		int count =invoice.size();
		System.out.println(count);
		return count;
	}
	public int getInvoiceCountNextAfteradd() throws Exception {
		int aftCount=0;
		boolean countRow=false;
		while (CheckElementExists(EdaatOR.Admin_Invoice_Next)==false){  
			WebClick(EdaatOR.Admin_Invoice_NextPrevLink);
			int count=getInvoiceCount();
			String pageNum=getText(EdaatOR.Admin_Invoice_NextPrevLink);
			Thread.sleep(1000);
			aftCount=aftCount+getInvoiceCount()+((Integer.valueOf(pageNum)-1)*10);
			countRow=true;
		}
		if(countRow==false) {
			aftCount=10;
		}
		return aftCount;
	}
//Function Summary  :To add recurring invoice template
//Parameter Summary : Enter TemplateArabic,TemplateEnglish and InvoiceType.
	public void AddInvoicetemplate(String TemplateArabic,String TemplateEnglish,String InvoiceType,String ReferenceCode,Log Log){
		try{
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Add_Invoice_Button);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Invoice_TemplateArabic,TemplateArabic);
			Thread.sleep(500);
			WebEdit(EdaatOR.Admin_Invoice_TemplateEng,TemplateEnglish);
			Thread.sleep(500);
			WebEdit(EdaatOR.Admin_Prod_Ref,ReferenceCode);  
			Thread.sleep(1000);
			if(InvoiceType.equalsIgnoreCase("Recurring"))
			WebClickUsingJS(EdaatOR.Admin_Invoice_Templatetype);
		else
			WebClickUsingJS(EdaatOR.Admin_Invoice_Templatetype_One);              	
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Admin_Invoice_Add);

		if(CheckElementExists(EdaatOR.Admin_Invoice_template_page)) {
			Log.ReportEvent("PASS", "Add Invoices Template is Successful");
			}
			else{
				Log.ReportEvent("FAIL", "Add Invoices Template is not Successful");
				this.takeScreenShot();
				driver.quit();Assert.fail();
			}
	}catch(Exception e){
		Log.ReportEvent("FAIL", "Add Invoices Template is not Successful");
		this.takeScreenShot();
		driver.quit();Assert.fail();
	}
}
	//Function Summary   : Method to UpadateProduct
	//Parameter Summary  : ProdEnglish,UpdateProdArabicUpdate,ProdEnglishCategory,ReferenceCode,TestDescription,BasicPrice,MinPriceSAR,MaxPriceSAR
	public void UpadateProduct(Map<Object,Object>testdatamap,Log Log) throws IOException, Exception {
		String priceList;
		try { 
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Individualclient_Name,testdatamap.get("ProdEnglish").toString());
			Thread.sleep(500);
			WebClickUsingJS(EdaatOR.Admin_Invoice_Search);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Product_EditLink);
			Thread.sleep(1000);
			WebClear(EdaatOR.Admin_Prod_NameArabic);
			WebEdit(EdaatOR.Admin_Prod_NameArabic,testdatamap.get("UpdateProdArabic").toString());
			Thread.sleep(1000);
			WebClear(EdaatOR.Admin_Invoice_TemplateEng);
			WebEdit(EdaatOR.Admin_Invoice_TemplateEng,testdatamap.get("UpdateProdEnglish").toString());  
			Thread.sleep(1000);
			WebSelect(EdaatOR.Admin_Invoice_Select,testdatamap.get("Category").toString());
			Thread.sleep(1000);
			WebClear(EdaatOR.Admin_Prod_Ref);
			WebEdit(EdaatOR.Admin_Prod_Ref,testdatamap.get("ReferenceCode").toString());
			Thread.sleep(1000);
			WebClear(EdaatOR.Admin_Prod_Description);
			WebEdit(EdaatOR.Admin_Prod_Description,testdatamap.get("TestDescription").toString());
			Thread.sleep(1000);		
			WebClear(EdaatOR.Admin_Prod_Price);
			WebEdit(EdaatOR.Admin_Prod_Price,testdatamap.get("BasicPrice").toString());  
			Thread.sleep(1000);
			WebClear(EdaatOR.Admin_Prod_MinPrice);
			WebEdit(EdaatOR.Admin_Prod_MinPrice,testdatamap.get("MinPriceSAR").toString());  
			Thread.sleep(1000);
			WebClear(EdaatOR.Admin_Prod_MaxPrice);
			WebEdit(EdaatOR.Admin_Prod_MaxPrice,testdatamap.get("MaxPriceSAR").toString());  
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Prod_Pricelist);
			Thread.sleep(1000);
			waitForPageToLoad();
			priceList=testdatamap.get("PriceList").toString();
			WebClickUsingJS("//li[contains(text(),'"+priceList+"')]"); 
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Update);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Individualclient_Name,testdatamap.get("UpdateProdEnglish").toString());
			WebClickUsingJS(EdaatOR.Admin_Invoice_Search);
			Thread.sleep(1000);
			if(getText("//td[text()='"+testdatamap.get("UpdateProdEnglish").toString()+"']").equals(testdatamap.get("UpdateProdEnglish").toString())){
				Log.ReportEvent("PASS", "Product is Edited successfully");

			}
			else {
				Log.ReportEvent("FAIL", "Product is not Edited successfully");
				this.takeScreenShot();	
				driver.quit();Assert.fail();
			}
		}catch(Exception e){
			Log.ReportEvent("FAIL", "Product is not Edited successfully");
			this.takeScreenShot();	
			driver.quit();Assert.fail();
		}
	}
public void AdminSearchtemplate(String TemplateEnglish,Log Log){
	try{
		Thread.sleep(1000);
		WebEdit(EdaatOR.Admin_Individualclient_Name,TemplateEnglish);
		WebClickUsingJS(EdaatOR.Admin_Invoice_Search);
		Thread.sleep(1000);
		if(CheckElementExists("//td[text()='"+TemplateEnglish+"']")==true) {
			Log.ReportEvent("PASS", "Search Invoices template is Successful");
		}
		else{
			Log.ReportEvent("FAIL", "Search Invoices template is not Successful");
			this.takeScreenShot();
			driver.quit();Assert.fail();
		}	    	

	}catch(Exception e){
		Log.ReportEvent("FAIL", "Search Invoices template is not Successful");
		this.takeScreenShot();
		driver.quit();Assert.fail();		
	}
}
public void addProduct(Map<Object,Object>testdatamap) throws Exception {
	WebClickUsingJS(EdaatOR.Admin_Prod_Addbutton);
	Thread.sleep(2000);
	WebEdit(EdaatOR.Admin_Prod_NameArabic,testdatamap.get("ProdArabic").toString());
	Thread.sleep(500);
	WebEdit(EdaatOR.Admin_Invoice_TemplateEng,testdatamap.get("ProdEnglish").toString());  
	Thread.sleep(500);
	WebSelect1(EdaatOR.Admin_Invoice_Select,testdatamap.get("Category").toString());
	Thread.sleep(500);
	WebEdit(EdaatOR.Admin_Prod_Ref,testdatamap.get("ReferenceCode").toString());
	Thread.sleep(500);
	WebEdit(EdaatOR.Admin_Prod_Description,testdatamap.get("TestDescription").toString());
	Thread.sleep(500);
	WebEdit(EdaatOR.Admin_Prod_Price,testdatamap.get("BasicPrice").toString());  
	Thread.sleep(500);
	WebEdit(EdaatOR.Admin_Prod_MinPrice,testdatamap.get("MinPriceSAR").toString());  
	Thread.sleep(500);
	WebEdit(EdaatOR.Admin_Prod_MaxPrice,testdatamap.get("MaxPriceSAR").toString());  
	Thread.sleep(500);
	
	WebClick(EdaatOR.Admin_Invoice_Add);
}
//Function Summary   : Method to AddProduct
//Parameter Summary  : ProdArabic,ProdEnglish,Category,ReferenceCode,TestDescription,BasicPrice,MinPriceSAR,MaxPriceSAR
public void AddProduct(Map<Object,Object>testdatamap,Log Log){
	try{
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Admin_Prod_Addbutton);
		Thread.sleep(1000);
		WebEdit(EdaatOR.Admin_Prod_NameArabic,testdatamap.get("ProdArabic").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Admin_Invoice_TemplateEng,testdatamap.get("ProdEnglish").toString());  
		Thread.sleep(1000);
		WebSelect1(EdaatOR.Admin_Invoice_Select,testdatamap.get("Category").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Admin_Prod_Ref,testdatamap.get("ReferenceCode").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Admin_Prod_Description,testdatamap.get("ProductDescription").toString());
		Thread.sleep(1000);		
		WebEdit(EdaatOR.Admin_Prod_Price,testdatamap.get("BasicPrice").toString());  
		Thread.sleep(1000);
		WebEdit(EdaatOR.Admin_Prod_MinPrice,testdatamap.get("MinPriceSAR").toString());  
		Thread.sleep(500);
		WebEdit(EdaatOR.Admin_Prod_MaxPrice,testdatamap.get("MaxPriceSAR").toString());  
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Admin_Invoice_Add);
		Thread.sleep(1000);
		if(CheckElementExists(EdaatOR.Biller_Settings_ProductReferenceCodeError)) {
			Log.ReportEvent("FAIL", "'Add Product' is not successful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
		else {
			Log.ReportEvent("PASS", "'Add Product' is successful");

		}
	}catch(Exception e){
		Log.ReportEvent("FAIL", "'Add Product' is not successful");
		this.takeScreenShot();
		e.printStackTrace();
		driver.quit();
		Assert.fail();
	}

}

//Function Summary   : Method to navigate to Invoice templates 
//Parameter Summary : N/A
public void navigateTemplate(Log Log) throws Exception {
	Thread.sleep(2000);
	WebClickUsingJS(EdaatOR.Admin_Settings);
	Thread.sleep(2000);
	WebClickUsingJS(EdaatOR.Admin_Add_Invoice_template);
	Thread.sleep(2000);
	if(CheckElementExists(EdaatOR.Admin_Invoice_template_page)) {
		Log.ReportEvent("PASS", "Invoices Templates page is Loaded Successfully");
		}
		else{
			Log.ReportEvent("FAIL", "Invoices Templates Page is not Loaded Successfully");
			this.takeScreenShot();
			driver.quit();Assert.fail();
		}

}
//Function Summary   : Method to verifyInvoiceTemplateVariables
//Parameter Summary  : AddTemplateHeadr
public void verifyInvoiceTemplateVariables(Map<Object,Object>testdatamap,Log Log) throws Exception {
	Thread.sleep(2000);
	WebClickUsingJS(EdaatOR.Admin_Add_Invoice_Button);
	Thread.sleep(2000);
	if(getText(EdaatOR.Admin_Tamplate_AddTitleHdr).equals(testdatamap.get("AddTemplateHeadr").toString())) {
	verifyElementIsPresent(EdaatOR.Admin_Tamplate_AllowDiscount);
	verifyElementIsPresent(EdaatOR.Admin_Tamplate_AllowTax);
	verifyElementIsPresent(EdaatOR.Admin_Tamplate_AllowPreCond);
	verifyElementIsPresent(EdaatOR.AllowValidity);
	Log.ReportEvent("PASS", "View Invoices Template Variable is Successful");
	}
	else{
		Log.ReportEvent("FAIL", "View Invoices Template Variable is not Successful");
		this.takeScreenShot();
		driver.quit();Assert.fail();	
	}
}

//Function Summary   : Method to view Table in invoice template
//Parameter Summary : N/A
public void GridView(Log Log) throws Exception {
	try {
		if(CheckElementExists(EdaatOR.Systemmgmt_table_Invoice)) {
			Log.ReportEvent("PASS", "Grid view Invoices Templates is Successful");
			}
			else{
				Log.ReportEvent("FAIL", "Grid view Invoices Templates is not Successful");
				this.takeScreenShot();
				driver.quit();Assert.fail();
			}

	} catch (Exception e) {
		Log.ReportEvent("FAIL", "Grid view Invoices Templates is not Successful");
		this.takeScreenShot();
		driver.quit();Assert.fail();
	}
}


//Function Summary   : Method to  view and verify invoice templates 
//Parameter Summary : N/A
public void verfiyViewInvoiceTemplate(Map<Object,Object>testdatamap,Log Log) throws Exception {
	try {
		Thread.sleep(2000);
		String TemplateEnglish = testdatamap.get("TemplateEnglish").toString();
		AdminSearchtemplate(TemplateEnglish,Log);
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Admin_Tamplate_Table+"[1]"+EdaatOR.Admin_Tamplate_UpdateBtn);
		Thread.sleep(1000);
		if(getText(EdaatOR.Admin_Tamplate_UpdateTitleHdr).equals(testdatamap.get("VeiwTempleteHeader").toString()+" "+TemplateEnglish)) {
			Thread.sleep(500);
			verifyElementIsPresent(EdaatOR.Admin_Tamplate_UpdateDesHdr);
			Thread.sleep(500);
			verifyElementIsPresent(EdaatOR.Biller_Tamplate_UpdateInVTyeHdr);
			Log.ReportEvent("PASS", "View Invoices Template details is Successful");
		}
		else{
			Log.ReportEvent("FAIL", "View Invoices Template details is not Successful");
			this.takeScreenShot();
			driver.quit();Assert.fail();
		}

	}catch(Exception e){
		Log.ReportEvent("FAIL", "View Invoices Template details is not Successful");
		this.takeScreenShot();
		driver.quit();Assert.fail();
	}
}

//Function Summary   : Method to delete the invoice template displayed first in invoice templates grid
//Parameter Summary : N/A
public void verfiyDeleteInvoiceTemplate(Map<Object,Object>testdatamap,Log Log) throws Exception {
	try {
		while (CheckElementExists(EdaatOR.Admin_Invoice_Next)==false){  
			WebClick(EdaatOR.Admin_Invoice_NextPrevLink);}
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Admin_Tamplate_Table+"[1]"+EdaatOR.Admin_Tamplate_DeleteBtn);
		Thread.sleep(2000);
//		verifyElementIsPresent(EdaatOR.Admin_Tamplate_DeleteNoBtn);
		if(getText(EdaatOR.Admin_Tamplate_DeletePop).equals(testdatamap.get("DeleteConfirmMes").toString())) {
			WebClick(EdaatOR.Admin_Tamplate_DeleteConfBtn);
			Log.ReportEvent("PASS", "Delete Invoices Template is Successful");
			Thread.sleep(2000);
			}
			else{
				Log.ReportEvent("FAIL", "Delete Invoices Template is not Successful");
				this.takeScreenShot();
				driver.quit();Assert.fail();
			}
	}catch(Exception e){
		Log.ReportEvent("FAIL", "Delete Invoices Template is not Successful");
		this.takeScreenShot();
		driver.quit();Assert.fail();
	}
}

public void verifyInvoiceTemplateDetails(Map<Object,Object>testdatamap,Log Log) throws Exception {
	String TemName=testdatamap.get("ActionTemplate").toString();
	switch(TemName) {

	case "Template":
		verifyInvoiceTemplateVariables(testdatamap,Log);
		break;

	case "View":
		verfiyViewInvoiceTemplate(testdatamap,Log);
		break;

	case "Delete":
		verfiyDeleteInvoiceTemplate(testdatamap,Log);
		break;
	}

}

//Function Summary  :Navigate to Settings and Products Management
//Parameter Summary : N/A
public void navigateProduct(Log Log) throws Exception {
	Thread.sleep(2000);
	WebClickUsingJS(EdaatOR.Admin_Settings);
	Thread.sleep(1000);
	WebClickUsingJS(EdaatOR.Admin_Add_Product);
	Thread.sleep(1000);
	if(CheckElementExists(EdaatOR.Admin_Product_MgmTitle)) {
	Log.ReportEvent("PASS", "Product Management page is Loaded Successfully");
	}
	else{
		Log.ReportEvent("FAIL", "Product Management page is not Loaded Successfully");
		this.takeScreenShot();
		driver.quit();Assert.fail();
	}
	}

//Function Summary  : //To enter product name.
//Parameter Summary : SearchProdName.
public void EnterProductInputBox(String pname) throws Exception {
	if(!pname.equalsIgnoreCase(""))
		WebEdit(EdaatOR.Biller_Product_NameInput, pname);
}
//Function Summary  : //to select category from dropdown.
//Parameter Summary : SearchProdCateg
public void SelectIdProductListBox(String lstname) {
	if(!lstname.equalsIgnoreCase(""))
		WebSelect1(EdaatOR.Biller_Product_SearchIDlist, lstname);
}
public void SearchProduct(Map<Object,Object>testdatamap,Log Log) throws Exception {
	WebEdit(EdaatOR.Biller_Product_NameInput, testdatamap.get("ProdEnglish").toString());
	Thread.sleep(500);
	WebSelect1(EdaatOR.Biller_Product_SearchIDlist, testdatamap.get("Category").toString());
	Thread.sleep(500);
	WebClick(EdaatOR.Biller_Product_SeachBtn);
	Thread.sleep(1000);
	if(getText("//td[text()='"+testdatamap.get("ProdEnglish").toString()+"']").equals(testdatamap.get("ProdEnglish").toString())){
		Log.ReportEvent("PASS", "Searched Product is displayed Successfully");

	}
	else {
		Log.ReportEvent("FAIL", "Searched Product is not displayed Successfully");
		this.takeScreenShot();	
		driver.quit();Assert.fail();
	}
}
//Function Summary  : To click on search button
//Parameter Summary : N/A
public void ClickOnSearchBtn() throws Exception {
	WebClick(EdaatOR.Biller_Product_SeachBtn);
}

//Function Summary  : verify Activate Product Functionality.
//Parameter Summary : ProdEnglish.
public void verifyActivateProductFunctionality(Map<Object,Object>testdatamap,Log Log) throws IOException, Exception {
	try{
		AddProduct(testdatamap,Log);
		Thread.sleep(4000);
		WebClearandEdit(EdaatOR.Admin_Individualclient_Name,testdatamap.get("ProdEnglish").toString());
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Admin_Invoice_Search);
		Thread.sleep(3000);
		//verifyElementIsPresent(EdaatOR.Admin_Product_ToggleBtn);
		WebClickUsingJS(EdaatOR.Admin_Product_ToggleBtn);
		Thread.sleep(2000);
		if(getText(EdaatOR.Admin_Product_ActivePop).equals( testdatamap.get("Active").toString())) {
			WebClick(EdaatOR.Admin_Product_ActiveConfbtn);
	    	Log.ReportEvent("PASS", "Product activation is Successful");
		}
		else {
    	Log.ReportEvent("FAIL", "Product activation is not Successful");
    	this.takeScreenShot();
    	driver.quit();Assert.fail();
	}
	}catch(Exception e){
    	Log.ReportEvent("FAIL", "Product activation is not Successful");
    	this.takeScreenShot();
    	driver.quit();Assert.fail();
	}

}

//Function Summary   : Method to verifyDeActiveProductFunctionality
//Parameter Summary  : ProdEnglish,Active,Deactive
public void verifyDeActiveProductFunctionality(Map<Object,Object>testdatamap,Log Log) throws IOException, Exception {
	try {
		AddProduct(testdatamap,Log);
		Thread.sleep(5000);
		WebEdit(EdaatOR.Admin_Individualclient_Name,testdatamap.get("ProdEnglish").toString());
		Thread.sleep(500);
		WebClick(EdaatOR.Admin_Invoice_Search);
		Thread.sleep(5000);
		verifyElementIsPresent(EdaatOR.Admin_Product_ToggleBtn);
		WebClickUsingJS(EdaatOR.Admin_Product_ToggleBtn);
		Thread.sleep(2000);
		VerifyValue1(getText(EdaatOR.Admin_Product_ActivePop), testdatamap.get("Active").toString());
		WebClickUsingJS(EdaatOR.Admin_Product_ActiveConfbtn);
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Admin_Product_ToggleBtn);
		Thread.sleep(1000);
		if(getText(EdaatOR.Admin_Product_ActivePop).equals( testdatamap.get("Deactive").toString())) {
			WebClickUsingJS(EdaatOR.Admin_Product_ActiveConfbtn);
	    	Log.ReportEvent("PASS", "Product Activation and Deactivation is successful");
		}
		else {
	    	Log.ReportEvent("FAIL", "Product Activation and Deactivation is not successful");
	    	this.takeScreenShot();
	    	driver.quit();Assert.fail();
		}
	}


	catch(Exception e){
    	Log.ReportEvent("FAIL", "Product Activation and Deactivation is not successful");
    	this.takeScreenShot();
    	driver.quit();Assert.fail();
	}
}

//Function Summary  : To Search a Product
//Parameter Summary : SearchProdName and SearchProdCateg
public void verifySearchFunctionality(Map<Object,Object>testdatamap,Log Log) throws IOException, Exception {
	try {
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Product_NameInput, testdatamap.get("ProdEnglish").toString());
		Thread.sleep(500);
		WebSelect1(EdaatOR.Biller_Product_SearchIDlist, testdatamap.get("Category").toString());
		Thread.sleep(500);
		WebClick(EdaatOR.Biller_Product_SeachBtn);
		Thread.sleep(1000);
		String Pname=testdatamap.get("ProdEnglish").toString();
		String pCate=testdatamap.get("Category").toString();
		List<WebElement> listTable=driver.findElements(By.xpath(EdaatOR.Biller_Product_Table));
		for(int i=0;i<listTable.size();i++) {
			int j=i+1;
			if(getText(EdaatOR.Biller_Product_Table+"["+j+"]/td[3]").equals(Pname) && getText(EdaatOR.Biller_Product_Table+"["+j+"]/td[4]").equals(pCate)){
				Log.ReportEvent("PASS", "Searched Product is displayed Successfully");
			}else  {
				Log.ReportEvent("FAIL", "Searched Product is not displayed Successfully");
				this.takeScreenShot();	
				driver.quit();Assert.fail();	
				}
		}

	}
	catch(Exception e){
		Log.ReportEvent("FAIL", "Searched Product is not displayed Successfully");
		this.takeScreenShot();	
		driver.quit();Assert.fail();
		}
	}
    	//Function Summary   : Method to Attach Excel.
		//Parameter Summary  : N/A.	
		public void  getAutoItImagePathFile() throws Exception {
		File classpathRoot = new File(System.getProperty("user.dir"));
		Thread.sleep(800);
		File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//AdminSettingsBillsCancellation.exe");
		String sFilename = app.toString();
		Thread.sleep(1000);
		Runtime.getRuntime().exec(sFilename);
		Thread.sleep(800);
		}
    	//Function Summary   : Method to Attach Excel.
		//Parameter Summary  : N/A.	
		public void  getAutoItImagePathFilePaidOutEdaat() throws Exception {
		File classpathRoot = new File(System.getProperty("user.dir"));
		Thread.sleep(800);
		File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//AdminSettingsPaidOutsideEdaatBills.exe");
		String sFilename = app.toString();
		Thread.sleep(1000);
		Runtime.getRuntime().exec(sFilename);
		Thread.sleep(800);
		}
	
		//Function Summary  : Method to upload Bulk data for bills cancellation.
		//Parameter Summary : N/A
		public void VerifyUploadBulkData(Log Log) throws IOException, Exception {
			try {
				WebClickUsingJS(EdaatOR.Admin_Settings);
				Thread.sleep(800);
				WebClickUsingJS(EdaatOR.Admin_BillsCancellation);
				Thread.sleep(2000);

				if(CheckElementExists(EdaatOR.Admin_BillsCancellation_page)) {
					Log.ReportEvent("PASS", "Bills cancellation page is Loaded Successfully");
					}
					else{
						Log.ReportEvent("FAIL", "Bills cancellation page is not Loaded Successfully");
						this.takeScreenShot();
						driver.quit();Assert.fail();
					}
				Thread.sleep(800);
				WebClickUsingActions(EdaatOR.Admin_AttachExcel);
				Thread.sleep(800);
				getAutoItImagePathFile();
				Thread.sleep(800);
				WebClickUsingJS(EdaatOR.Admin_ProcessBtn);
				Thread.sleep(800);
				if(CheckElementExists(EdaatOR.Admin_SuccessfulMsg)) {
					Log.ReportEvent("PASS", "Upload Bulk data is Successful");
					}
					else{
						Log.ReportEvent("FAIL", "Upload Bulk data is not Successful");
						this.takeScreenShot();
						driver.quit();Assert.fail();
					}
			}
			catch(Exception e){
				Log.ReportEvent("FAIL", "Upload Bulk data is not Successful");
				this.takeScreenShot();
				driver.quit();Assert.fail();
			}
		}
		//Function Summary  : Method to upload Bulk data for Paid Outside EDAAT Bills.
		//Parameter Summary : N/A
		public void VerifyUploadBulkDataForPaidOutEdaatBills(Log Log) throws IOException, Exception {
			try {
				WebClickUsingJS(EdaatOR.Admin_Settings);
				Thread.sleep(800);
				WebClickUsingJS(EdaatOR.Admin_PaidOutsideEdaatBills);
				Thread.sleep(2000);
				if(CheckElementExists(EdaatOR.Admin_PaidOutsideEdaatBills_page)) {
					Log.ReportEvent("PASS", "Paid Outside EDAAT Bills page is Loaded Successfully");
					}
					else{
						Log.ReportEvent("FAIL", "Paid Outside EDAAT Bills page is not Loaded Successfully");
						this.takeScreenShot();
						driver.quit();Assert.fail();
					}
				Thread.sleep(800);
				WebClickUsingActions(EdaatOR.Admin_AttachExcel);
				Thread.sleep(800);
				getAutoItImagePathFilePaidOutEdaat();
				Thread.sleep(800);
				WebClickUsingJS(EdaatOR.Admin_ProcessBtn);
				Thread.sleep(800);
				if(CheckElementExists(EdaatOR.Admin_SuccessfulMsg)) {
					Log.ReportEvent("PASS", "Upload Bulk data is Successful");
					}
					else{
						Log.ReportEvent("FAIL", "Upload Bulk data is not Successful");
						this.takeScreenShot();
						driver.quit();Assert.fail();
					}
			}
			catch(Exception e){
				Log.ReportEvent("FAIL", "Upload Bulk data is not Successful");
				this.takeScreenShot();
				driver.quit();Assert.fail();
			}
		}

		//Function Summary  : Method to add new invoice template.
		//Parameter Summary : TemplateArabic, TemplateEnglish,	InvoiceType	
		public void AddInvoiceTemplate(String TemplateArabic,String TemplateEnglish,String InvoiceType) throws Exception {

			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Add_Invoice_Button);
			Thread.sleep(500);
			WebEdit(EdaatOR.Admin_Invoice_TemplateArabic,TemplateArabic);
			Thread.sleep(500);
			WebEdit(EdaatOR.Admin_Invoice_TemplateEng,TemplateEnglish);  
			Thread.sleep(500);
			if(InvoiceType.equalsIgnoreCase("Recurring")) 
			{
			WebClickUsingJS(EdaatOR.Admin_Invoice_Templatetype);}
		   else if(InvoiceType.equalsIgnoreCase("One Time"))  {
			WebClickUsingJS(EdaatOR.Admin_Invoice_Templatetype_One); 
			}            	
	    	Thread.sleep(500);
		    WebClickUsingJS(EdaatOR.Admin_Invoice_Add);

		}
		
		//Function Summary  : method to verify Error messages in Add invoice template page
		//Parameter Summary : ExpectedResult, TemplateArabic, TemplateEnglish,	InvoiceType	
		public void VerifyAddInvoiceTemplateErrorMsg(String TemplateArabic,String TemplateEnglish,String InvoiceType,String ExpectedResult,Log Log) throws InterruptedException{
			{
		try {
			AddInvoiceTemplate(TemplateArabic, TemplateEnglish, InvoiceType);
			Thread.sleep(500);
			
			if (ExistsCheck(EdaatOR.Admin_MandatoryErrorMsg)){	
				VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_InvoiceTemplateArNameErrMsg));
				Thread.sleep(500);
				VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_InvoiceTemplateEnNameErrMsg));
				
				VerifyValue1(ExpectedResult, getText(EdaatOR.Admin_InvoiceTypeErrMsg));
				Log.ReportEvent("PASS", "Verify 'This field is required' error Message is successful");

				}
			        
			else if (ExpectedResult.equals (getText(EdaatOR.Admin_InvoiceTemplateArNameErrMsg))) {
				Log.ReportEvent("PASS", "Verify Error message for 'Template Name in Arabic' is successful");

			}
   
			else {
				Log.ReportEvent("FAIL", "Verify Add invoice template error Message is not successful");
				this.takeScreenShot();
				driver.quit();Assert.fail();
			}

		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Verify Add invoice template error Message is not successful");
			this.takeScreenShot();
			driver.quit();Assert.fail();		}

	}
				
	}
	

		//Function Summary  : method to verify Error messages in Add product page
		//Parameter Summary : ExpectedResult
		public void VerifyAddProductErrorMsg(Map<Object,Object>testdatamap,Log Log) throws InterruptedException{
			{
				try {
					Thread.sleep(1000);
					addProduct(testdatamap);
					Thread.sleep(500);
					
					if (ExistsCheck(EdaatOR.Admin_MandatoryErrorMsg)){	
					
							VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_ProductNameArErrorMsg));
							Thread.sleep(500);
							VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_ProductNameEnErrorMsg));
							Thread.sleep(500);
//							VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_ProductCategoryErrorMsg));
							Thread.sleep(500);
							VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_ProductPriceErrorMsg));
						
							Log.ReportEvent("PASS", "Verify 'This field is required' error Message is successful");
										}
					else if (testdatamap.get("ExpectedResult").toString().equals(getText(EdaatOR.Admin_ProductNameArErrorMsg))) {
						Log.ReportEvent("PASS", "Verify Error message for 'Product Name in Arabic' is successful");

					}
					else if (ExistsCheck(EdaatOR.Admin_RefCodeErrorMsg)) {
						Log.ReportEvent("PASS", "Verify 'Reference Code is already in use' error Message is successful");

					}
					else {
						Log.ReportEvent("FAIL", "Verify Add product error Message is not successful");
						this.takeScreenShot();
						driver.quit();Assert.fail();
					}

				} catch (Exception e) {
					Log.ReportEvent("FAIL", "Verify Add product error Message is not successful");
					this.takeScreenShot();
					driver.quit();Assert.fail();				}

			}
		}
		
		public void navigateToPaidOutsideBillsPage(Log Log) throws InterruptedException {
			WebClickUsingJS(EdaatOR.Admin_Settings);
			Thread.sleep(500);
			WebClickUsingJS(EdaatOR.Admin_settings_PaidOutsideEdaatPage);
			Thread.sleep(1000);

			if(CheckElementExists(EdaatOR.Admin_PaidOutsideEdaatBills_page)) {
				Log.ReportEvent("PASS", "Paid Outside EDAAT Bills page is Loaded Successfully");
				}
				else{
					Log.ReportEvent("FAIL", "Paid Outside EDAAT Bills page is not Loaded Successfully");
					this.takeScreenShot();
					driver.quit();Assert.fail();
				}

		}
		public void navigateToBillsCancellationPage(Log Log) throws InterruptedException {
			WebClickUsingJS(EdaatOR.Admin_Settings);
			Thread.sleep(800);
			WebClickUsingJS(EdaatOR.Admin_BillsCancellation);
			Thread.sleep(2000);

			if(CheckElementExists(EdaatOR.Admin_BillsCancellation_page)) {
				Log.ReportEvent("PASS", "Bills cancellation page is Loaded Successfully");
				}
				else{
					Log.ReportEvent("FAIL", "Bills cancellation page is not Loaded Successfully");
					this.takeScreenShot();
					driver.quit();Assert.fail();
				}
		}
		//Function Summary  : method to verify Error messages in Paid Outside Edaat bills page
		//Parameter Summary : ExpectedResult
		public void VerifyPaidOutsideEdaatBillsErrorMsg(Map<Object,Object>testdatamap,Log Log) throws InterruptedException{
			{
				try {
					Thread.sleep(500);
					WebClickUsingJS(EdaatOR.Admin_settings_PaidOusideBillsAttach_process);
					
					if (testdatamap.get("ExpectedResult").toString().equals (getText(EdaatOR.Admin_settings_ContentAttachErrorMsg))){	
						Log.ReportEvent("Pass", "Verify Paid Outside Edaat bills error Message is successful");

					}
					else {
						Log.ReportEvent("FAIL", "Verify Paid Outside Edaat bills error Message is not successful");
						this.takeScreenShot();
						driver.quit();Assert.fail();
					}

				} catch (Exception e) {
					Log.ReportEvent("FAIL", "Verify Paid Outside Edaat bills error Message is not successful");
					this.takeScreenShot();
					driver.quit();Assert.fail();				}

			}
		}			
		
		//Function Summary  : method to verify Error messages in Bills cancellation page
		//Parameter Summary : ExpectedResult
		public void VerifyBillsCancelationErrorMsg(Map<Object,Object>testdatamap,Log Log) throws InterruptedException{
			{
				try {
					Thread.sleep(500);
					WebClickUsingJS(EdaatOR.Admin_settings_PaidOusideBillsAttach_process);
					Thread.sleep(1500);

					if (testdatamap.get("ExpectedResult").toString().equals (getText(EdaatOR.Admin_settings_ContentAttachErrorMsg))){	

						Log.ReportEvent("PASS", "Verify Bills cancellation error Message is successful");

					}
					else {
						Log.ReportEvent("FAIL", "Verify Bills cancellation error Message is not successful");
						this.takeScreenShot();
						driver.quit();Assert.fail();
					}

				} catch (Exception e) {
					Log.ReportEvent("FAIL", "Verify Bills cancellation error Message is not successful");
					this.takeScreenShot();
					driver.quit();Assert.fail();				}

			}
		}		
		
}