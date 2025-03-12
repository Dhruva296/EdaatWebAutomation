package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.io.File;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.Alert;
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
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;



public class AdminSubbillerPage extends BasePage
{

	public AdminSubbillerPage(WebDriver driver,ExtentTest test)
	{
		 this.driver=driver;
		 this.test=test;
		 
		 PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  
	Log Log;

	@FindBy(xpath = EdaatOR.Admin_CorpSubBillerPageVerify)
	public WebElement subbiller;
		
	    
	    public boolean Exists(){
	    	return super.Exists(subbiller); 
		}

	
	public boolean SubbillerSearch(String BillerName,String NationalID){
		boolean existsElement = false;
		try{
				WebClickUsingJS(EdaatOR.Biller_Sub_Individualclient);
	        	Thread.sleep(2000);
	        	WebClickUsingJS(EdaatOR.Biller_Sub_IndividualsubBiller);
	        	Thread.sleep(2000);
	        	WebEdit(EdaatOR.Biller_Individualclient_Name,BillerName);
				Thread.sleep(1000);
				WebEdit(EdaatOR.Biller_Subbiller_NId,NationalID);
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Biller_Subbiller_Search);
				this.takeScreenShot();
            	existsElement=ExistsCheck("//td[text()='"+NationalID+"']");
				Thread.sleep(1000);
				
           	
        }
        catch(Exception e){
//       test.log(Status.FAIL,"#FUNC-Add Individual client" + driver.getTitle() +" * Add Individual client PASS * " );
            this.takeScreenShot();
        }
        return existsElement;
    }
    //Function summary:Verify Sub billers Corporate subBillers grid
//Function Parameters:view and table
public void CorporateSubBillersGridView(Log Log)
	{
		try {
				if (CheckElementExists(EdaatOR.Admin_CorpSubBillerlnk))
				{
				    Log.ReportEvent("PASS", "Corporate SubBiller Grid view details is Successful");
				}
				else
				{
				    Log.ReportEvent("FAIL", "Corporate SubBiller Grid view Details Verification is Unsuccessful");
                     takeScreenShot();
                     driver.quit();
                     Assert.fail();
				}
		} 
		catch (Exception e) {
			Log.ReportEvent("FAIL", "Corporate SubBiller Grid view Details Verification is Unsuccessful");
            takeScreenShot();
            driver.quit();
            Assert.fail();			
          }
	}

		
	//Function Summary  : Method to Upload Registration Certificate
	//Parameter Summary : N/A
	public void EnterAdminRegiAttachment() throws Exception {
		WebClickUsingActions(EdaatOR.Admin_CorpoSubBillerCRAttach);
		Thread.sleep(2000);
		getAutoItImagePathFile();
	}	
	
     public void  getAutoItImagePathFile() throws Exception {
  		Thread.sleep(1000);
		File classpathRoot = new File(System.getProperty("user.dir"));
		Thread.sleep(800);
		File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//ImageUpload.exe");
		String sFilename = app.toString();
		Thread.sleep(1000);
		Runtime.getRuntime().exec(sFilename);
		Thread.sleep(1000);
		}
		
	//Function Summary  : Method to Upload IBAN Attachment
	//Parameter Summary : N/A
	public void EnterAdminIBANAttmnt() throws Exception {
		WebClickUsingActions(EdaatOR.Admin_CorpoSubBillerIBANAttach);
		Thread.sleep(2000);
		getAutoItImagePathFile();
	}
	//Function Summary  : Method to Upload Product IBAN Attachment
	//Parameter Summary : N/A
	public void EnterAdminProductIBANAttmnt() throws Exception {
		WebClickUsingActions(EdaatOR.Admin_CorpoSubBillerProductIBANAttach);
		Thread.sleep(2000);
		getAutoItImagePathFile();
	}
	
	public void CRCertificate() throws Exception
	{
		WebClickUsingActions(EdaatOR.Admin_subbillerCRNCertificate);
		Thread.sleep(1000);
		getAutoItImagePathFile();
	}
	public void IbanCertificate() throws Exception {
		WebClickUsingActions(EdaatOR.Admin_subbillerAttachIban);
		getAutoItImagePathFile();
	}
	//Function summary:Method to add corporate subbiller.
	//Function Parameters:ClientName,CRNumber,IBANNumber,BeneficiaryName,Taxnumber,FixedValue,Percentage,DistrictName,StreetName,ZipCode,BuildingNo,
	//EmployeeName,EmployeeEmail,EmployeeMobileNumber.	

	public void AddCorporatesubbiller(Map<Object, Object> testdatamap,Log Log) {
		try{
			WebClickUsingJS(EdaatOR.Admin_Carpoaddsubbiller);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerName,testdatamap.get("BillerName").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerCRNumber,testdatamap.get("CRNumber").toString());
			Thread.sleep(1000);
			CRCertificate();
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerIban,testdatamap.get("IBANNumber").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerBenfName,testdatamap.get("BeneficiaryName").toString());
			Thread.sleep(1000);
			IbanCertificate();
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerTaxNumber,testdatamap.get("Taxnumber").toString());
			Thread.sleep(1000);
			SelectFeesDeductionMethod(testdatamap,Log);
			Thread.sleep(1000);
			NationalAdressInfo(testdatamap);
			Thread.sleep(1000);
			ContactInfo(testdatamap);
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_subbillerAddbtn);
			Thread.sleep(1000);
			List<WebElement> elements = getElements(EdaatOR.Admin_SubBillerAllErrorMessage);
			if(CheckElementExists(EdaatOR.Admin_SubBillerAlertPopUp)) {
				Log.ReportEvent("Fail", "Add SubBiller is Unsuccessful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
			else if(elements != null && !elements.isEmpty()) {
			        Log.ReportEvent("Fail", "Add SubBiller is Unsuccessful");
			        takeScreenShot();
			        driver.quit();
			        Assert.fail();
			 }
			validateSubBillerAdded(testdatamap,Log);
			  
			}
			catch(Exception e){
				Log.ReportEvent("FAIL", "Failed Add sub Biller with Fees Deduction from ."+testdatamap.get("FeesDeductionType").toString());
			    takeScreenShot();
			    driver.quit();
			    Assert.fail();
    }
 }
	//Function Summary  :Verify SubbillerA
	//Parameter :Log 
	   public void validateSubBillerAdded(Map<Object, Object> testdatamap,Log log) throws Exception {
		if(CheckElementExists(EdaatOR.Admin_SubBiller_CorporatePage)) {
			log.ReportEvent("Pass", "Corporate Sub Biller is Added Successfully");
			WebEdit(EdaatOR.Admin_subbillerBillerName,testdatamap.get("BillerName").toString());
			Thread.sleep(500);
			WebEdit(EdaatOR.Admin_subbillerCrNumber,testdatamap.get("CRNumber").toString());
			WebClick(EdaatOR.Admin_subbillerSearchBtn);
			Thread.sleep(500);
			String actualValue = WebGetText("//tr/td[text()='" + testdatamap.get("CRNumber").toString() + "']");
			Thread.sleep(200);
			String expectedValue=testdatamap.get("CRNumber").toString();
			if (actualValue.equals(expectedValue)) {
			    log.ReportEvent("PASS", "Add sub Biller with Fees Deduction from "+testdatamap.get("FeesDeductionType").toString()+" verification is Successful");
			} else {
			    log.ReportEvent("FAIL", "Add sub Biller with Fees Deduction from "+testdatamap.get("FeesDeductionType").toString()+" Verification Unsuccessful");
			    takeScreenShot();
			    driver.quit();
			    Assert.fail();
			}   
		}
		else {
		    log.ReportEvent("FAIL", "Add sub Biller with Fees Deduction from "+testdatamap.get("FeesDeductionType").toString()+" Verification Unsuccessful");
		    takeScreenShot();
		    driver.quit();
		    Assert.fail();
		} 
	}
	
	
	//Function Summary  : Method to Enter National Address Information
		//Parameter Summary : BDistric,City,BDistric,Street,ZipCode,BuildNum
		public void NationalAdressInfo(Map<Object,Object> testdatamap) throws Exception {
			   WebClick(EdaatOR.Admin_CorpoSubBillerCityList);
			   Thread.sleep(2000);
			   WebClick("//li[text()='"+testdatamap.get("City").toString()+"']");
			   Thread.sleep(2000);
			   WebEdit(EdaatOR.Admin_District_eField,testdatamap.get("DistrictName").toString());
			   Thread.sleep(2000);
			   WebEdit(EdaatOR.Admin_Street_eField,testdatamap.get("StreetName").toString());
			   Thread.sleep(2000);
			   WebEdit(EdaatOR.Admin_PostalCode_eField,testdatamap.get("ZipCode").toString());
			   Thread.sleep(2000);
			   WebEdit(EdaatOR.Admin_BuildNo_eField,testdatamap.get("BuildingNo").toString()); 
		}
	//Function summary:Select Operation Fees Deduction Method and 
	//Function Parameters:FixedValue,Percentage,FeesDuctionType
	public void SelectFeesDeductionMethod(Map<Object, Object> testdatamap,Log Log) throws Exception {
			if(testdatamap.get("FeesDeductionType").toString().equals("Invoice Total Amount")){
			WebClick(EdaatOR.Admin_subbillerTotalAmountCheck);
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_subbillerFixedValue);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerEnterFixedValue,testdatamap.get("FixedValue").toString());
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_subbillerPercentage);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerEnterPercentValue,testdatamap.get("Percentage").toString());
			}
			else if(testdatamap.get("FeesDeductionType").toString().equals("Based on Product")) {
				WebClickUsingJS(EdaatOR.Admin_CorpoSubBillerFeeDeductonProductCHXbox);
				   AddProduct(testdatamap);
			}
			
		}

	//Function summary:Navigate to subBillers Page
		//Function Parameters:CRNumber.
		public void NavigateSubBillersPage(Log Log) {
			try{
				
				WebClickUsingJS(EdaatOR.Admin_subbillerbtn);
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Admin_CarpoSubbillerdatabtn);
				waitForPageToLoad();
				if(CheckElementExists(EdaatOR.Admin_SubBiller_CorporatePage)) {
					Log.ReportEvent("Pass", "Navigate to Corporate Sub Billers Page is Successful");
				}
				else {
					Log.ReportEvent("Fail", "Navigate to Corporate Sub Billers Page is Unsuccessful");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			}
		catch(Exception e){
	             e.getMessage();
	             Log.ReportEvent("Fail", "Navigate to Corporate Sub Billers Page is Unsuccessful");
					takeScreenShot();
					driver.quit();
					Assert.fail();
		}
	  }
//Function summary:Verify Corporate subBillers Search
	//Function Parameters:CRNumber.
	public void CorporatesubbillerSearch(Map<Object, Object> testdatamap,Log Log) {
		try{
			
			WebEdit(EdaatOR.Admin_subbillerBillerName,testdatamap.get("BillerName").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerCrNumber,testdatamap.get("CRNumber").toString());
			WebClick(EdaatOR.Admin_subbillerSearchBtn);
			String actualValue=WebGetText("//tr/td[text()='"+testdatamap.get("CRNumber").toString()+"']");
			String expectedValue=testdatamap.get("CRNumber").toString();
			if(actualValue.equals(expectedValue)) {
		        Log.ReportEvent("PASS", "Corporate SubBillers Search Functionality is Successful");
			}
			else {
		        Log.ReportEvent("Fail", "Corporate SubBillers Search Functionality is Unsuccessful");
                takeScreenShot();
                driver.quit();
                Assert.fail();
			}
		}
	catch(Exception e){
		Log.ReportEvent("Fail", "Corporate SubBillers Search Functionality is Unsuccessful");
        takeScreenShot();
        driver.quit();
        Assert.fail();
	}
  }
  //Function Summary  : Method to Add Product
	//Parameter Summary : SelectProduct,FixedValue,Percentage,ProIBANNumber,BeneficaryName
	public void AddProduct(Map<Object,Object> testdatamap) throws Exception {
		
		   WebClick(EdaatOR.Admin_CorpoSubBillerAddProduct);
		   WebSelect(EdaatOR.Admin_CorpoSubBillerSelectProduct,testdatamap.get("SelectProduct").toString());
		   WebEdit(EdaatOR.Admin_CorpoSubBillerProFixedValue,testdatamap.get("FixedValue").toString());
		   WebEdit(EdaatOR.Admin_CorpoSubBillerProPercentage,testdatamap.get("Percentage").toString());
		   WebEdit(EdaatOR.Admin_CorpoSubBillerProductIBAN,testdatamap.get("ProIBANNumber").toString());
		   WebEdit(EdaatOR.Admin_CorpoSubBillerProductBeneficaryName,testdatamap.get("BeneficiaryName").toString());
		   EnterAdminProductIBANAttmnt();
		   WebClick(EdaatOR.Admin_CorpoSubBillerProductAddBTN);
	}
	
	
	
	//Function Summary  : Method to Enter Contact Information
	//Parameter Summary : EmployeeName,EmployeeEmailID,EmployeeMobNumber
	public void ContactInfo(Map<Object,Object> testdatamap) throws Exception {
		   
		   WebEdit(EdaatOR.Admin_EmplyName_eField,testdatamap.get("EmployeeName").toString());
		   WebEdit(EdaatOR.Admin_EmplyEmail_eField,testdatamap.get("EmployeeEmail").toString());
		   WebEdit(EdaatOR.Admin_EmplyMobileNumber_eField,testdatamap.get("EmployeeMobileNumber").toString());  
	}
	//Function Summary  : Method to Add Corporate SubBiler Based on Fee Deduction on Product
	//Parameter Summary : BillerName,CRNumber,IBANNumber,BeneficaryName,TaxNumber
	public void CorporateSubBillersAdd(Map<Object,Object> testdatamap,Log Log)
	{
		try {
			   WebClickUsingJS(EdaatOR.Admin_CorpoSubBiller);
			   WebClickUsingJS(EdaatOR.Admin_CorpoSubBillerAddBTN);
			   WebEdit(EdaatOR.Admin_CorpoSubBillerName,testdatamap.get("BillerName").toString());
			   WebEdit(EdaatOR.Admin_CorpoSubBillerCRNum,testdatamap.get("CRNumber").toString());
			   EnterAdminRegiAttachment();
			   WebEdit(EdaatOR.Admin_CorpoSubBillerIBAN,testdatamap.get("IBANNumber").toString());
			   WebEdit(EdaatOR.Admin_CorpoSubBillerBeneficaryName,testdatamap.get("BeneficaryName").toString());
			   EnterAdminIBANAttmnt();
			   WebEdit(EdaatOR.Admin_CorpoSubBillerTaxNum,testdatamap.get("TaxNumber").toString());
			   WebClickUsingJS(EdaatOR.Admin_CorpoSubBillerFeeDeductonProductCHXbox);
			   AddProduct(testdatamap);
			   Thread.sleep(2000);
			   NationalAdressInfo(testdatamap);
			   ContactInfo(testdatamap);
			   WebClickUsingJS(EdaatOR.Admin_CorpoSubBillerAddButton);
			   WebEdit(EdaatOR.Admin_subbillerBillerName,testdatamap.get("BillerName").toString());
			   Thread.sleep(1000);
			   WebEdit(EdaatOR.Admin_subbillerCrNumber,testdatamap.get("CRNumber").toString());
			   WebClick(EdaatOR.Admin_subbillerSearchBtn);
			   Thread.sleep(1000);
			   VerifyValue1(getText(EdaatOR.Admin_CorpoSubBillerVerfiy1),testdatamap.get("BillerName").toString());
			   Thread.sleep(1000);
			   VerifyValue1(getText(EdaatOR.Admin_CorpoSubBillerVerfiy2),testdatamap.get("CRNumber").toString());
			   this.takeScreenShot();			   
	           Log.ReportEvent("PASS", "Verify Add Corporate SubBiller is Suceessful");

			} catch (Exception e) {
				this.takeScreenShot();
			}
    }
	
	//Function Summary  : Method to Add Corporate SubBiller ErrorMsg
    //Parameter Summary : MethodDeduct,Expected
	public void CorporateSubBillerErrorMsg(Map<Object,Object> testdatamap,Log log)
	{
		try {
			  String Feesdeduct = testdatamap.get("MethodDeduct").toString();
			   NavigateSubBillersPage(log);
			   WebClickUsingJS(EdaatOR.Admin_Carpoaddsubbiller);
			  if(Feesdeduct.equalsIgnoreCase("none"))
			  {
			   
			   WebClick(EdaatOR.Admin_subbillerAddbtn);
			   if(getText(EdaatOR.Admin_SubBillerAdd).equals(testdatamap.get("Expected").toString())) {
				   log.ReportEvent("Pass", "Select fees deduction error mesage validation is successful");
			   }
			   else {
				   log.ReportEvent("Fail", "Select fees deduction error mesage validation is Unsuccessful");
				   takeScreenShot();
                   driver.quit();
                   Assert.fail();
			   }
			  }
			  else if(Feesdeduct.equalsIgnoreCase("Fixed Value"))
			  {
			    WebClick(EdaatOR.Admin_subbillerTotalAmountCheck);
			    WebClick(EdaatOR.Admin_subbillerFixedValue);
			    WebClick(EdaatOR.Admin_subbillerAddbtn);
			    if(getText(EdaatOR.Admin_SubBillerFixedValueError).equals( testdatamap.get("Expected").toString())){
			    	log.ReportEvent("Pass", "Fixed Value Error Message Validation is Successful");
			    }
			    else {
			    	log.ReportEvent("Fail", "Fixed Value Error Message Validation is Unsuccessful");
                    takeScreenShot();
                    driver.quit();
                    Assert.fail();
			    }
			  }
			  else if(Feesdeduct.equalsIgnoreCase("Percentage"))
			  {
				 WebClick(EdaatOR.Admin_subbillerTotalAmountCheck);
				 WebClick(EdaatOR.Admin_subbillerPercentage);
				 WebClick(EdaatOR.Admin_subbillerAddbtn);
				 WebClick(EdaatOR.Admin_subbillerAddbtn);
				 if(CheckElementExists(EdaatOR.Admin_SubBillerPercentError2)&&getText(EdaatOR.Admin_SubBillerPercentError).equals(testdatamap.get("Expected").toString())) {
                 log.ReportEvent("Pass", "Percent Value Error Message Validation is Successful");
				 }
				 else {
	                 log.ReportEvent("Fail", "Percent Value Error Message Validation is Unsuccessful");
	                 takeScreenShot();
	                 driver.quit();
	                 Assert.fail();
				 }
			  }
			  else if(Feesdeduct.equalsIgnoreCase("Invoice Amount"))
			  {
				WebClick(EdaatOR.Admin_subbillerTotalAmountCheck);
				WebClick(EdaatOR.Admin_subbillerAddbtn);
			    if(getText(EdaatOR.Admin_SubBillerInvoiceAmount).equals(testdatamap.get("Expected").toString())) {
	                 log.ReportEvent("Pass", " Invoice Operation Fees Error Message Validation is Successful");

			   }
			    else {
	                 log.ReportEvent("Fail", " Invoice Operation Fees Error Message Validation is Unsuccessful");
	                 takeScreenShot();
	                 driver.quit();
	                 Assert.fail();
			    	}
			    }
			  }
		catch (Exception e) {

			this.takeScreenShot();
		}
	}

	//Function Summary  : Method to Add product Error Messages
    //Parameter Summary : Product,FixedValue,Percentage,BeneficaryName,IBAN Number
	public void AddproductError(Map<Object,Object> testdatamap,Log log) throws Exception
	{
		
		   WebClickUsingJS(EdaatOR.Admin_SubBillers);
		   WebClickUsingJS(EdaatOR.Admin_CorpoSubBiller);
		   WebClickUsingJS(EdaatOR.Admin_Carpoaddsubbiller);
		   WebClick(EdaatOR.Admin_SubBillerBasedProductcheck);
		   WebClick(EdaatOR.Admin_CorpoSubBillerAddProduct);
		   WebClickUsingJS(EdaatOR.Admin_CorpoSubBillerSelectProduct);
		   selectDropdownValue_PartialText(EdaatOR.Admin_CorpoSubBillerSelectProduct,testdatamap.get("Product").toString());
		   WebEdit(EdaatOR.Admin_CorpoSubBillerProFixedValue,testdatamap.get("FixedValue").toString());
		   WebEdit(EdaatOR.Admin_CorpoSubBillerProPercentage,testdatamap.get("Percentage").toString());
		   WebEdit(EdaatOR.Admin_SubBillerProductIBAN,testdatamap.get("IBAN Number").toString());
		   WebEdit(EdaatOR.Admin_SubBillerProductBeneficiary,testdatamap.get("BeneficaryName").toString());
		   WebClick(EdaatOR.Admin_CorpoSubBillerProductAddBTN);
		   CorporateSubBillerBasedOnProductError(testdatamap,log);
		
	}
	
	//Function Summary  : Method to Add product Error Messages
    //Parameter Summary : Expected
	public void CorporateSubBillerBasedOnProductError(Map<Object,Object> testdatamap,Log log) throws Exception
	{
		try {
			if(CheckElementExists(EdaatOR.Admin_SubBillerSelectproductError)){

				if(getText(EdaatOR.Admin_SubBillerSelectproductError).equals(testdatamap.get("Expected").toString()))
				{
					log.ReportEvent("Pass", "Select Product error message Validation is successful");
				}
				else {
					log.ReportEvent("Fail", "Select Product Error message Validation is Unsuccessful");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			}
			else if(CheckElementExists(EdaatOR.Admin_SubBillerProductFixedPer)) {

				if(getText(EdaatOR.Admin_SubBillerProductFixedPer).equals(testdatamap.get("Expected").toString())) {
					log.ReportEvent("Pass", "Fixed value or percentage for Product Error Message Validation is Successful");
				}
				else {
					log.ReportEvent("Fail", "Add Fixed value or percentage for Product Error Message Validation is Unsuccessful");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			}
			else if(CheckElementExists(EdaatOR.Admin_SubBillerProductIbanError)) {
				
				if(getText(EdaatOR.Admin_SubBillerProductIbanError).equals(testdatamap.get("Expected").toString())){
				log.ReportEvent("Pass", "Product IBAN Error Message Validation is Successful");
			    }
				else {
					log.ReportEvent("Fail", "Product IBAN Error Message Validation is Unsuccessful");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			}
			else if(CheckElementExists(EdaatOR.Admin_SubBillerProductIbanInvalid)) {
				if(getText(EdaatOR.Admin_SubBillerProductIbanInvalid).equals(testdatamap.get("Expected").toString())){
				log.ReportEvent("Pass", "Invalid Product IBAN Error Message Validation is Successful"); 
			    }
				else {
					log.ReportEvent("Fail", "Invalid Product IBAN Error Message Validation is Unuccessful"); 
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			}
			else if(CheckElementExists(EdaatOR.Admin_SubBillerProductBeneficiaryError)) {
				if(getText(EdaatOR.Admin_SubBillerProductBeneficiaryError).equals(testdatamap.get("Expected").toString())){
				log.ReportEvent("Pass", "Benificiary Name Error Message Validation is Successful"); 
			    }
				else {
					log.ReportEvent("Fail", "Benificiary Name Error Message Validation is Unsuccessful"); 
					takeScreenShot();
					driver.quit();
					Assert.fail();
					}
				}
				
			else if(CheckElementExists(EdaatOR.Admin_SubBillerProductIBanAttachError))
				if(getText(EdaatOR.Admin_SubBillerProductIBanAttachError).equals(testdatamap.get("Expected").toString())){
				log.ReportEvent("Pass", "Attach iban image Error Message Validation is Successful"); 
			    }
			    else {
					log.ReportEvent("Fail", "Attach iban image Error Message Validation is Unsuccessful"); 
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
		}
		catch (Exception e) {
			log.ReportEvent("Fail", "Add Product Popup Error Message Validation is Unsuccessful");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	//Function Summary  : Method to Verify SubBiller GeneralInfo Error Message
	//Function Parameters:CRNumber,BillerName,IBANNumber,BeneficaryName,TaxNumber,FixedValue,Percentage

	public void SubBillerGeneralInfo(Map<Object,Object> testdatamap,Log log) throws Exception
	{ 
		try {	
			NavigateSubBillersPage(log);
			WebClickUsingJS(EdaatOR.Admin_Carpoaddsubbiller);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerName,testdatamap.get("BillerName").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerCRNumber,testdatamap.get("CRNumber").toString());
			Thread.sleep(1000);
			CRCertificate();
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerIban,testdatamap.get("IBANNumber").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerBenfName,testdatamap.get("BeneficaryName").toString());
			Thread.sleep(1000);
			IbanCertificate();
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_subbillerTaxNumber,testdatamap.get("TaxNumber").toString());
			Thread.sleep(1000);
			SelectFeesDeductionMethod(testdatamap,Log);
			Thread.sleep(1000);
			NationalAdressInfo(testdatamap);
			Thread.sleep(1000);
			ContactInfo(testdatamap);
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_subbillerAddbtn);
			AddSubBillerInfoErrorCheck(testdatamap,log);
		}
		catch (Exception e) {
			log.ReportEvent("Fail", "Error Message validation is Unsuccessful");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}

	} 
	//Function Summary  : Method to Verify SubBiller GeneralInfo Error Messages
	//Function Parameters: Expected
	public void AddSubBillerInfoErrorCheck(Map<Object, Object> testdatamap, Log log) {
		String elementName = "";
		try {
			List<WebElement> elements = getElements(EdaatOR.Admin_SubBillerAllErrorMessage);
			List<WebElement> elementNames = getElements(EdaatOR.Admin_SubBillerAllErrorMessage + EdaatOR.Admin_SubBillerAllErrorMessageTxtBoxName);

			for (int i = 0; i < elements.size(); i++) {
				WebElement errorMessage = elements.get(i);
				WebElement textBoxName = elementNames.get(i);

				if (elements.size()== elementNames.size()&&errorMessage.getText().equals(testdatamap.get("Expected"))) {
					elementName = textBoxName.getText();
					log.ReportEvent("Pass", elementName + " Error Message Validation is Successful");
				} else {
					elementName = textBoxName.getText();
					log.ReportEvent("Fail", elementName + " Error Message Validation is Unsuccessful");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			}
		} catch (Exception e) {
			log.ReportEvent("Fail", elementName + " Error Message Validation encountered an Exception");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	
     //Function Summary  : Method to Verify SubBiller National Info Details Error Message
	//Function Parameters:CRNumber,BillerName,IBANNumber,BeneficaryName,TaxNumber,FixedValue,Percentage,Attachment
	public void SubBillerNationalInfoDetails(Map<Object,Object> testdatamap,Log log) throws Exception
	{
		String Certificate = testdatamap.get("Attachment").toString();
		NavigateSubBillersPage(log);
		WebClickUsingJS(EdaatOR.Admin_Carpoaddsubbiller);
		WebEdit(EdaatOR.Admin_subbillerName,testdatamap.get("BillerName").toString());
		WebEdit(EdaatOR.Admin_subbillerCRNumber,testdatamap.get("CRNumber").toString());
		WebEdit(EdaatOR.Admin_subbillerIban,testdatamap.get("IBANNumber").toString());
		WebEdit(EdaatOR.Admin_subbillerBenfName,testdatamap.get("BeneficaryName").toString());
		WebEdit(EdaatOR.Admin_subbillerTaxNumber,testdatamap.get("TaxNumber").toString());
		WebClick(EdaatOR.Admin_subbillerTotalAmountCheck);
		WebClick(EdaatOR.Admin_subbillerFixedValue);
		WebEdit(EdaatOR.Admin_subbillerEnterFixedValue,testdatamap.get("FixedValue").toString());
		WebClick(EdaatOR.Admin_subbillerPercentage);
		WebEdit(EdaatOR.Admin_subbillerEnterPercentValue,testdatamap.get("Percentage").toString());
		Thread.sleep(1000);
		NationalAdressInfo(testdatamap);
		ContactInfo(testdatamap);
		if(Certificate.equalsIgnoreCase("CR"))
		{
			CRCertificate();
		    AddSubBillerNationalInfoError(testdatamap,log);

		}
		else if(Certificate.equalsIgnoreCase("IBAN"))
		{
			IbanCertificate();
		    AddSubBillerNationalInfoError(testdatamap,log);

		}
	    WebClick(EdaatOR.Admin_subbillerAddbtn);
	    AddSubBillerNationalInfoError(testdatamap,log);
	}
	
	 //Function Summary  : Method to Verify SubBiller National Info Error Messages
		//Function Parameters: Expected
	public void AddSubBillerNationalInfoError(Map<Object,Object> testdatamap,Log log) throws Exception
	{
		 String elementName = "";
		    try {
		        List<WebElement> elements = getElements(EdaatOR.Admin_SubBillerAllErrorMessage);
		        List<WebElement> elementNames = getElements(EdaatOR.Admin_SubBillerAllErrorMessage + EdaatOR.Admin_SubBillerAllErrorMessageTxtBoxName);

		        for (int i = 0; i < elements.size(); i++) {
		            WebElement errorMessage = elements.get(i);
		            WebElement textBoxName = elementNames.get(i);
		            
		            if (elements.size()== elementNames.size()&&errorMessage.getText().equals(testdatamap.get("Expected"))) {
		                elementName = textBoxName.getText();
		                log.ReportEvent("Pass", elementName + " Error Message Validation is Successful");
		            } else {
		                elementName = textBoxName.getText();
		                log.ReportEvent("Fail", elementName + " Error Message Validation is Unsuccessful");
		                takeScreenShot();
		                driver.quit();
		                Assert.fail();
		            }
		        }
		    } catch (Exception e) {
		        log.ReportEvent("Fail", elementName + " Error Message Validation encountered an Exception");
		        takeScreenShot();
		        driver.quit();
		        Assert.fail();
		    }
	  }
}
 	
  
	
	
    

