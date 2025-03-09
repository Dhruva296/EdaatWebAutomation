/**
* Test Script Name  				 : N/A
* Objective     					 : Verify System Management Functionality
* Version      						 : 1.0
* Author       						 : Kathirvelu M
* Created Date 			      		 : 29/05/2023
* Last Updated on					 : N/A
* Updated By   			 			 : Basavaraj Mudnur
* Pre-Conditions					 : N/A
* Manual Test case Name				 : N/A
* Epic Details						 : N/A
* User Story Details				 : N/A
* Defects affecting this test script : N/A
* WorkArounds/Known Issues			 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.biller.pages;

import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;

import java.io.File;

import java.util.List;

import java.util.Map;
import org.openqa.selenium.Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.Status;

import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;

import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;

import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;

import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
public class BillerSystemMangementPage extends BasePage {

	public BillerSystemMangementPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.Systemmgmt_Menu)
	public WebElement Client;

	public boolean Exists() {
		return super.Exists(Client);
	}


//Function Summary   : Method to Update Data for Non Approved Biller  
//Parameter Summary : N/A
public void UpdateData(Map<Object,Object> testdatamap,Log Log) {
	

	EnterValidDetails(testdatamap,Log);
	
	
	}
//Function Summary   : Method to Enter Valid Data for DeActivated Biller
//Parameter Summary :N/A
	public void DeactoAct(Map<Object,Object> testdatamap,Log Log) {
		

			EnterValidDetails(testdatamap,Log);
		
}
	//Function Summary   : Method to Enter Valid Data and save for DeActivated Biller
	//Parameter Summary :N/A
	public void SaveActivationInfo(Map<Object,Object> testdatamap,Log Log) {
		

			EnterValidDetails2(testdatamap,Log);
		
		
}

//Function Summary   : Method to Enter Data for DeActivated Biller 
//Parameter Summary : N/A
public void DeactoActInvalid(Map<Object,Object> testdatamap,Log Log) {
	try {

		EnterInvalidDetails(testdatamap,Log);
			
	} catch (Exception e) {
		
		this.takeScreenShot();
	}
}


//Function Summary   : Method to verify Biller Account  
//Parameter Summary  : UserID , Password .
public void ValidateBillerAccount(Map<Object,Object>testdatamap,Log Log) {
	try {
		
		BillerLoginPage billerLoginPage=new BillerLoginPage(driver, test);
		billerLoginPage.LoginToApplication(testdatamap.get("UserID").toString(),testdatamap.get("Password").toString(),Log);

		
		if (ExistsCheck(EdaatOR.Biller_HomePage_Main)) {
	    	Log.ReportEvent("PASS", "Biller Account verification is Successful.");
		}
		else {
			
			Log.ReportEvent("Fail", "Biller Account verification is Unsuccessful.");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
		
	}

	catch (Exception e) {
		Log.ReportEvent("Fail", "Biller Account verification is Unsuccessful.");
		this.takeScreenShot();
		driver.quit();
		Assert.fail();
	}
}

//Function Summary   : Method Performing Actions to View Grid View Details 
//Parameter Summary  : view , table .
public void GridViewtable(Map<Object,Object>testdatamap,Log Log) {
	try {
		NavigateToApprovedBillersMenu(testdatamap,Log);
		
		if (ExistsCheck(EdaatOR.Systemmgmt_table_approved)) {
	    	Log.ReportEvent("PASS", "Approved Billers Grid view is Loaded Successfully");
		}
		else {
			
			Log.ReportEvent("Fail", "Approved Billers Grid view is not Loaded Successfully");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
		
	}

	catch (Exception e) {
		this.takeScreenShot();
		e.printStackTrace();
		takeScreenShot();
		driver.quit();
		Assert.fail();
	}
}
//Function Summary   : Method Performing Actions to View Billers Under Activation Grid View Details 
//Parameter Summary  : view , table .
public void BillersUnderActivationGridViewtable(Map<Object,Object>testdatamap,Log Log) {
	try {
		NavigateToBillersBillersUnderActivationMenu(testdatamap,Log);
		
		if (ExistsCheck(EdaatOR.Systemmgmt_table_Notapproved) == true) {
	    	Log.ReportEvent("PASS", "Billers Under Activation Grid view is Loaded Successfully");
		}
		else {
			
			Log.ReportEvent("Fail", "Billers Under Activation Grid view is not Loaded Successfully");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
		
	}

	catch (Exception e) {
		e.printStackTrace();
		Log.ReportEvent("Fail", "Billers Under Activation Grid view is not Loaded Successfully");
		this.takeScreenShot();
		driver.quit();
		Assert.fail();
		
	}
}

//Function Summary   : Method to Click on System Management and Non Approved Biller Management  
//Parameter Summary :N/A
public void NavigateToBillersBillersUnderActivationMenu(Map<Object,Object>testdatamap,Log Log) throws InterruptedException {
	try {
		
		
		WebClickUsingJS(EdaatOR.Systemmgmt_Menu);
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Systemmgmt_NotApproved_Menu);
		if(ExistsCheck(EdaatOR.Systemmgmt_Biller_UnderActivation_Page)) {
			Log.ReportEvent("PASS", "Billers Under Activation page is Loaded Successfully");
		}
		else {
			Log.ReportEvent("Fail", "Billers Under Activation page is not Loaded Successfully");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
			
		}
		Thread.sleep(1000);
		}
		catch (Exception e) {
			e.printStackTrace();
			Log.ReportEvent("Fail", "Billers Under Activation page is not Loaded Successfully");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();

			
		}
}

//Function Summary   : Method to Click on System Management and Approved Biller Management  
//Parameter Summary :N/A
public void NavigateToApprovedBillersMenu(Map<Object,Object>testdatamap,Log Log) throws Exception {
	
	try {
		
	
	WebClickUsingJS(EdaatOR.Systemmgmt_Menu);
	Thread.sleep(1000);
	WebClickUsingJS(EdaatOR.Systemmgmt_Approved_Menu);
	if(ExistsCheck(EdaatOR.Systemmgmt_Approved_Biller_Page)) {
		Log.ReportEvent("PASS", "Approved Billers Page is Loaded Successfully");
	}
	else {
		Log.ReportEvent("Fail", "Approved Billers Page is not Loaded Successfully");
		this.takeScreenShot();
		driver.quit();
		Assert.fail();
		
	}
	Thread.sleep(1000);
	}
	catch (Exception e) {
		e.printStackTrace();
		Log.ReportEvent("Fail", "Approved Billers Page is not Loaded Successfully");
		this.takeScreenShot();
		driver.quit();
		Assert.fail();

		
	}
}

//Function Summary   : Method to Navigate to Last Page in NonApproved Grid View
	//Parameter Summary :N/A
public int getInvoiceCountNextAfteradd() throws Exception {

    int aftCount=0;
    boolean countRow=false;
    while (CheckElementExists(EdaatOR.Biller_Invoice_Next)==false){  
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
public int getInvoiceCount() {

    List<WebElement> invoice = driver.findElements(By.xpath(EdaatOR.Biller_Invoice_Count));
    waitForPageToLoad();
    int count =invoice.size();
    return count;

}
//Function Summary   : Method to get Count of Biller Account in Gridview Page
//Parameter Summary :N/A
public int getInvoiceCountAdd() {
	List<WebElement> invoice = driver.findElements(By.xpath(EdaatOR.Biller_nonapproved_Afteradd));
	waitForPageToLoad();
	int count =invoice.size();
	return count;
}


public void selectCategoryID(String Benifi) throws Exception {
	//WebSelectByVisibleText(EdaatOR.Admin_SystemMgm_BillerCategoryID,Benifi);
	WebClick(EdaatOR.Biller_Systemmgmt_BillingCatgeoryType);
	WebSelect(EdaatOR.Biller_Systemmgmt_BillingCatgeoryType, Benifi);

}
//Function Summary   : Method to Search Biller
//Parameter Summary :CompanyName,BillerName
public void SearchBiller(Map<Object,Object>testdatamap,Log Log) throws Exception {
	try {
		
	WebEdit(EdaatOR.Biller_Individualclient_Name,testdatamap.get("CompanyName").toString());
	Thread.sleep(1000);
	WebClick(EdaatOR.Biller_Individualclient_Search);
	Thread.sleep(2000);
	if(getText(EdaatOR.AppBiller_Name).equals(testdatamap.get("BillerName").toString())) {
		Log.ReportEvent("PASS", "Biller Search is Successful");
	}
	else {
		
    	Log.ReportEvent("FAIL", "Biller Search is Unsuccessful");
    	this.takeScreenShot();
    	driver.quit();
    	Assert.fail();

	}
	}
	catch (Exception e) {
		e.printStackTrace();
		Log.ReportEvent("FAIL", "Biller Search is Unsuccessful");
    	this.takeScreenShot();
    	driver.quit();
    	Assert.fail();
		
	}
}



//Function Summary   : Method to Enter Valid Details For Non Approved Biller/DeActivated Biller  
//Parameter Summary : CompanyName,TempBenificaryName,BillerCode,TransferDuration,BillerNameArabic,BillerNameEnglich,
//                    BenificaryCategory,MaxAllowedDailyInvoices,MaximumInvoiceAmount,SuperBiller
public void EnterValidDetails(Map<Object,Object>testdatamap,Log Log) {
	
	try {
		NavigateToBillersBillersUnderActivationMenu(testdatamap,Log);
		
		SearchBiller(testdatamap,Log);
		Thread.sleep(1500);
		WebClick(EdaatOR.Systemmgmt_NotApproved_Edit);
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_TempBenificaryName,testdatamap.get("TempBenificaryName").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_BillerCode,testdatamap.get("BillerCode").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_TransferDuration,testdatamap.get("TransferDuration").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_BillerAliasNameAr,testdatamap.get("BillerNameArabic").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_BillerAliasNameEn,testdatamap.get("BillerNameEnglich").toString());
		Thread.sleep(1000);
		selectCategoryID(testdatamap.get("BenificaryCategory").toString());
		Thread.sleep(1000);		
		
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasSubBillers);
		Thread.sleep(1000);		
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasEnterpriseSubBillers);
		Thread.sleep(1000);		
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasIndividualSubBillers);
		Thread.sleep(1000);		
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_IsUrgentBillUploader);
		Thread.sleep(1000);		
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasMaximumInvoiceNumberPerDay);
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_MaximumInvoiceNumber,testdatamap.get("MaxAllowedDailyInvoices").toString());
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasMaximumInvoiceAmountPerDay);
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_MaximumInvoiceAmount,testdatamap.get("MaximumInvoiceAmount").toString());
		Thread.sleep(1000);
		if(testdatamap.get("Billertype").toString().equalsIgnoreCase("Super Biller")) {
			WebClickUsingJS(EdaatOR.Biller_Systemmgmt_Super);
			Thread.sleep(1000);	
		}else {
			WebClickUsingJS(EdaatOR.Biller_Systemmgmt_Tracker);
			Thread.sleep(1000);	
			selectDropdownValue_PartialText(EdaatOR.Biller_Systemmgmt_NewSuperBiller, testdatamap.get("SuperBiller").toString());
		}
		SelectThePaymentMethod(testdatamap.get("PaymentMethod").toString());
		WebClick(EdaatOR.Biller_Systemmgmt_Confirm);	
		
		Thread.sleep(2000);
		WebClick(EdaatOR.Biller_Save);
		Thread.sleep(1000);	
		WebClick(EdaatOR.Biller_Save_Yes);	
		Thread.sleep(1000);
		if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_idError)) {
			 Log.ReportEvent("FAIL", "Activation Information is not Saved Successfully.");
			 this.takeScreenShot();
			 driver.quit();
			 Assert.fail();
			 }
		
       else if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_BenificaryError)) {
       	  scrollToElementCenter(driver, driver.findElement(By.xpath(EdaatOR.Biller_SystemMgm_Biller_BenificaryError)));
	          Log.ReportEvent("FAIL", "Activation Information is not Saved Successfully.");
	          this.takeScreenShot();
	          driver.quit();
	          Assert.fail();
	        }
		

       else if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_Durationerror)) {
       	  scrollToElementCenter(driver, driver.findElement(By.xpath(EdaatOR.Biller_SystemMgm_Biller_Durationerror)));
	          Log.ReportEvent("FAIL", "Activation Information is not Saved Successfully.");
	          this.takeScreenShot();
	          driver.quit();
	          Assert.fail();
	        }
		
      else if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_CrpArbError)) {
   	   
   	   scrollToElementCenter(driver, driver.findElement(By.xpath(EdaatOR.Biller_SystemMgm_Biller_CrpArbError)));
	         Log.ReportEvent("FAIL", "Activation Information is not Saved Successfully.");
	         this.takeScreenShot();
	         driver.quit();
	         Assert.fail();
         }
      else if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_CrpEngError)) {
      	   
      	   scrollToElementCenter(driver, driver.findElement(By.xpath(EdaatOR.Biller_SystemMgm_Biller_CrpEngError)));
      		Log.ReportEvent("FAIL", "Biller Details update by Maker is Unsuccessful."); 
  	         this.takeScreenShot();
  	         driver.quit();
  	         Assert.fail();
            }
		
      else if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_BillerCatgError)) {
      	   
      	     scrollToElementCenter(driver, driver.findElement(By.xpath(EdaatOR.Biller_SystemMgm_Biller_BillerCatgError)));
      		Log.ReportEvent("FAIL", "Biller Details update by Maker is Unsuccessful."); 
  	         this.takeScreenShot();
  	         driver.quit();
  	         Assert.fail();
            }
      else if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_SuperBillerErrormsg)) {
      	   
    	     scrollToElementCenter(driver, driver.findElement(By.xpath(EdaatOR.Biller_SystemMgm_Biller_SuperBillerErrormsg)));
    	 	Log.ReportEvent("FAIL", "Biller Details update by Maker is Unsuccessful."); 
	         this.takeScreenShot();
	         driver.quit();
	         Assert.fail();
          }
      else if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_TransferErrormsg)){
      	   
  	     scrollToElementCenter(driver, driver.findElement(By.xpath(EdaatOR.Biller_SystemMgm_Biller_TransferErrormsg)));
  		Log.ReportEvent("FAIL", "Biller Details update by Maker is Unsuccessful."); 
	         this.takeScreenShot();
	         driver.quit();
	         Assert.fail();
        }
      else if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_PaymentError)){
    		Log.ReportEvent("FAIL", "Biller Details update by Maker is Unsuccessful."); 
	         this.takeScreenShot();
	         driver.quit();
	         Assert.fail();
         }
     else {
           WebClick(EdaatOR.Biller_Save_Yesclose);
       	Log.ReportEvent("PASS", "Biller Details update by Maker is Successful."); 
				 
          }
									
					
	} catch (Exception e) {
	Log.ReportEvent("FAIL", "Biller Details update by Maker is Unsuccessful."); 
	this.takeScreenShot();
	driver.quit();
	Assert.fail();
					
				}
	
}


//Function Summary   : Method to Enter valid Details for Deactivate Biller Account
//Parameter Summary :TempBenificaryName,BillerCode,TransferDuration,BillerNameArabic,BillerNameEnglich,BenificaryCategory,
//                   MaxAllowedDailyInvoices,MaximumInvoiceAmount,Super Biller,SuperBiller
public void EnterValidDetails2(Map<Object,Object>testdatamap,Log Log) {
	try {
		NavigateToBillersBillersUnderActivationMenu(testdatamap,Log);
		getInvoiceCountNextAfteradd();
		int value = getInvoiceCountAdd();
		WebClick(EdaatOR.Biller_nonapproved_Afteradd+"["+value+"]/td[9]");
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_TempBenificaryName,testdatamap.get("TempBenificaryName").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_BillerCode,testdatamap.get("BillerCode").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_TransferDuration,testdatamap.get("TransferDuration").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_BillerAliasNameAr,testdatamap.get("BillerNameArabic").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_BillerAliasNameEn,testdatamap.get("BillerNameEnglich").toString());
		Thread.sleep(1000);
		selectCategoryID(testdatamap.get("BenificaryCategory").toString());
		Thread.sleep(1000);		
		
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasSubBillers);
		Thread.sleep(1000);		
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasEnterpriseSubBillers);
		Thread.sleep(1000);		
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasIndividualSubBillers);
		Thread.sleep(1000);		
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_IsUrgentBillUploader);
		Thread.sleep(1000);		
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasMaximumInvoiceNumberPerDay);
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_MaximumInvoiceNumber,testdatamap.get("MaxAllowedDailyInvoices").toString());
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasMaximumInvoiceAmountPerDay);
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_MaximumInvoiceAmount,testdatamap.get("MaximumInvoiceAmount").toString());
		Thread.sleep(1000);
		if(testdatamap.get("Billertype").toString().equalsIgnoreCase("Super Biller")) {
			WebClickUsingJS(EdaatOR.Biller_Systemmgmt_Super);
			Thread.sleep(1000);	
		}else {
			WebClickUsingJS(EdaatOR.Biller_Systemmgmt_Tracker);
			Thread.sleep(1000);	
			selectDropdownValue_PartialText(EdaatOR.Biller_Systemmgmt_NewSuperBiller, testdatamap.get("SuperBiller").toString());
		}		
		SelectThePaymentMethod(testdatamap.get("PaymentMethod").toString());
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_Confirm);	
		
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Biller_Save);
		Thread.sleep(1000);	
		WebClickUsingJS(EdaatOR.Biller_Save_Yes);
		Thread.sleep(1000);	
		
		if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_idError)) {
			 Log.ReportEvent("FAIL", "Activation Information is not Saved Successfully.");
			 this.takeScreenShot();
			 driver.quit();
			 Assert.fail();
			 }
		
        else if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_BenificaryError)) {
        	  scrollToElementCenter(driver, driver.findElement(By.xpath(EdaatOR.Biller_SystemMgm_Biller_BenificaryError)));
	          Log.ReportEvent("FAIL", "Activation Information is not Saved Successfully.");
	          this.takeScreenShot();
	          driver.quit();
	          Assert.fail();
	        }
		

        else if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_Durationerror)) {
        	  scrollToElementCenter(driver, driver.findElement(By.xpath(EdaatOR.Biller_SystemMgm_Biller_Durationerror)));
	          Log.ReportEvent("FAIL", "Activation Information is not Saved Successfully.");
	          this.takeScreenShot();
	          driver.quit();
	          Assert.fail();
	        }
		
       else if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_CrpArbError)) {
    	   
    	   scrollToElementCenter(driver, driver.findElement(By.xpath(EdaatOR.Biller_SystemMgm_Biller_CrpArbError)));
	         Log.ReportEvent("FAIL", "Activation Information is not Saved Successfully.");
	         this.takeScreenShot();
	         driver.quit();
	         Assert.fail();
          }
       else if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_CrpEngError)) {
       	   
       	   scrollToElementCenter(driver, driver.findElement(By.xpath(EdaatOR.Biller_SystemMgm_Biller_CrpEngError)));
   	         Log.ReportEvent("FAIL", "Activation Information is not Saved Successfully.");
   	         this.takeScreenShot();
   	         driver.quit();
   	         Assert.fail();
             }
		
       else if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_BillerCatgError)) {
       	   
       	     scrollToElementCenter(driver, driver.findElement(By.xpath(EdaatOR.Biller_SystemMgm_Biller_BillerCatgError)));
   	         Log.ReportEvent("FAIL", "Activation Information is not Saved Successfully.");
   	         this.takeScreenShot();
   	         driver.quit();
   	         Assert.fail();
             }
       else if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_SuperBillerErrormsg)) {
       	   
     	     scrollToElementCenter(driver, driver.findElement(By.xpath(EdaatOR.Biller_SystemMgm_Biller_SuperBillerErrormsg)));
 	         Log.ReportEvent("FAIL", "Activation Information is not Saved Successfully.");
 	         this.takeScreenShot();
 	         driver.quit();
 	         Assert.fail();
           }
       else if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_TransferErrormsg)){
       	   
   	     scrollToElementCenter(driver, driver.findElement(By.xpath(EdaatOR.Biller_SystemMgm_Biller_TransferErrormsg)));
	         Log.ReportEvent("FAIL", "Activation Information is not Saved Successfully.");
	         this.takeScreenShot();
	         driver.quit();
	         Assert.fail();
         }
       else if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_PaymentError)){
	         Log.ReportEvent("FAIL", "Activation Information is not Saved Successfully.");
	         this.takeScreenShot();
	         driver.quit();
	         Assert.fail();
          }
      else {
            WebClick(EdaatOR.Biller_Save_Yesclose);
            Log.ReportEvent("PASS", "Activation Information Saved Successfully."); 
				 
           }
							
		
  } catch (Exception e) {
           Log.ReportEvent("FAIL", "Activation Information is not Saved Successfully."); 
           this.takeScreenShot();
           driver.quit();
           Assert.fail();
			
		}

}
//Function Summary   : Method to Enter Invalid Data For DeActivated Biller 
//Parameter Summary :CompanyName,TempBenificaryName,BillerCode,TransferDuration,BillerNameArabic,
//                   BillerNameEnglich,BillerNameEnglich,MaxAllowedDailyInvoices,MaximumInvoiceAmount,SuperBiller
public boolean EnterInvalidDetails(Map<Object,Object>testdatamap,Log Log) {
	boolean existsNID = false;
	try {
		NavigateToBillersBillersUnderActivationMenu(testdatamap,Log);
		SearchBiller(testdatamap,Log);

		Thread.sleep(1500);
		WebClick(EdaatOR.Systemmgmt_NotApproved_Edit);
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_TempBenificaryName,testdatamap.get("TempBenificaryName").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_BillerCode,testdatamap.get("BillerCode").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_TransferDuration,testdatamap.get("TransferDuration").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_BillerAliasNameAr,testdatamap.get("BillerNameArabic").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_BillerAliasNameEn,testdatamap.get("BillerNameEnglich").toString());
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasSubBillers);
		Thread.sleep(1000);		
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasEnterpriseSubBillers);
		Thread.sleep(1000);		
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasIndividualSubBillers);
		Thread.sleep(1000);		
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_IsUrgentBillUploader);
		Thread.sleep(1000);		
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasMaximumInvoiceNumberPerDay);
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_MaximumInvoiceNumber,testdatamap.get("MaxAllowedDailyInvoices").toString());
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasMaximumInvoiceAmountPerDay);
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_MaximumInvoiceAmount,testdatamap.get("MaximumInvoiceAmount").toString());
		Thread.sleep(1000);
		if(testdatamap.get("Billertype").toString().equalsIgnoreCase("Super Biller")) {
			WebClickUsingJS(EdaatOR.Biller_Systemmgmt_Super);
			Thread.sleep(1000);	
		}else {
			WebClickUsingJS(EdaatOR.Biller_Systemmgmt_Tracker);
			Thread.sleep(1000);	
			selectDropdownValue_PartialText(EdaatOR.Biller_Systemmgmt_NewSuperBiller, testdatamap.get("SuperBiller").toString());
		}		
		SelectThePaymentMethod(testdatamap.get("PaymentMethod").toString());
		WebClick(EdaatOR.Biller_Systemmgmt_Confirm);	
		
		Thread.sleep(2000);
		WebClick(EdaatOR.Biller_Save);
		Thread.sleep(2000);
		WebClick(EdaatOR.Biller_Save_Yes);
		
		if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_idError)) {
			 Log.ReportEvent("FAIL", "Activation Information is not Saved Successfully.");
			 this.takeScreenShot();
			 driver.quit();
			 Assert.fail();
			 }
		
       else if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_BenificaryError)) {
       	  scrollToElementCenter(driver, driver.findElement(By.xpath(EdaatOR.Biller_SystemMgm_Biller_BenificaryError)));
	          Log.ReportEvent("FAIL", "Activation Information is not Saved Successfully.");
	          this.takeScreenShot();
	          driver.quit();
	          Assert.fail();
	        }
		

       else if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_Durationerror)) {
       	  scrollToElementCenter(driver, driver.findElement(By.xpath(EdaatOR.Biller_SystemMgm_Biller_Durationerror)));
	         Log.ReportEvent("PASS", "Invalid Activation info for Deactivated Biller by Maker was Successful.");
	          
	        }
		
      else if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_CrpArbError)
			||ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_CrpEngError)||ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_BillerCatgError)) {
   	   
       Log.ReportEvent("PASS", "Invalid Activation info for Deactivated Biller by Maker was Successful.");
	        
         }
      else if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_CrpEngError)||ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_BillerCatgError)) {
      	   
	         Log.ReportEvent("PASS", "Invalid Activation info for Deactivated Biller by Maker was Successful.");
  	       
            }
		
      else if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_BillerCatgError)) {
      	   
	         Log.ReportEvent("PASS", "Invalid Activation info for Deactivated Biller by Maker was Successful.");
  	        
            }
      else if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_SuperBillerErrormsg)) {
      	   
	         Log.ReportEvent("PASS", "Invalid Activation info for Deactivated Biller by Maker was Successful.");
	        
          }
      else if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_TransferErrormsg)){
      	   
         Log.ReportEvent("PASS", "Invalid Activation info for Deactivated Biller by Maker was Successful.");
	        
        }
      else if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_PaymentError)){
	         Log.ReportEvent("PASS", "Invalid ; info for Deactivated Biller by Maker was Successful.");

         }

     else {
         
          Log.ReportEvent("FAIL", "Invalid Activation info for Deactivated Biller by Maker was Unsuccessful."); 
          this.takeScreenShot();
	      driver.quit();
	     Assert.fail();	 
       }
		Thread.sleep(1000);	
		existsNID = true;
	}

	catch (Exception e) {
		e.printStackTrace();
		Log.ReportEvent("FAIL", "Invalid Activation info for Deactivated Biller by Maker was Unsuccessful."); 
		 this.takeScreenShot();
	      driver.quit();
	     Assert.fail();	
	}
	return existsNID;
}
//Function Summary   : Method to Perform Actions, To Approve Biller Account Activation
//Parameter Summary :Company Name
public void ApprovalByChecker(Map<Object,Object>testdatamap,Log Log) {
	try {
		NavigateToBillersBillersUnderActivationMenu(testdatamap,Log);
		SearchBiller(testdatamap, Log);
		Thread.sleep(1000);
		
		WebClick(EdaatOR.Biller_Individualclient_Edit);
		Thread.sleep(1000);
		if (ExistsCheck(EdaatOR.Biller_Systemmgmt_Btnapprove)) {
	
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_Btnapprove);
		Thread.sleep(1000);
		
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_ConfirmApprove);
		waitForPageToLoad();
		Log.ReportEvent("PASS","Biller Account is Successfully Approved by the Checker.");
		Thread.sleep(2000);
		NavigateToApprovedBillersMenu(testdatamap,Log);
		SearchBiller(testdatamap, Log);
		
		}
		else {
			Log.ReportEvent("FAIL","Biller Account is not Successfully Approved by the Checker.");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}
	catch (Exception e) {
		Log.ReportEvent("FAIL","Biller Account is not Successfully Approved by the Checker.");
		this.takeScreenShot();
		driver.quit();
		Assert.fail();
		
	}
	
}
//Function Summary   : Method to Perform Actions, To Reject Biller Account Activation
//Parameter Summary :Company Name
public void RejectActivation(Map<Object,Object>testdatamap,Log Log) {
	boolean existsNID = false;
	try {
		NavigateToBillersBillersUnderActivationMenu(testdatamap,Log);
		Thread.sleep(1000);
		SearchBiller(testdatamap, Log);
		Thread.sleep(1000);
		WebClick(EdaatOR.Biller_Individualclient_Edit);
		Thread.sleep(1000);
		
		if(ExistsCheck(EdaatOR.Biller_Systemmgmt_RejectButton)) {
			WebClickUsingJS(EdaatOR.Biller_Systemmgmt_RejectButton);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_Systemmgmt_ConfirmReject);
			waitForPageToLoad();
			Log.ReportEvent("PASS", "Biller Account is Successfully Rejected by the Checker.");
			Thread.sleep(1000);
			SearchBiller(testdatamap, Log);
		}
		else {
			Log.ReportEvent("FAIL", "Biller Account is not Successfully Rejected by the Checker.");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
			
		}

	}catch (Exception e) {
		e.printStackTrace();
		Log.ReportEvent("FAIL", "Biller Account is not Successfully Rejected by the Checker.");
		this.takeScreenShot();
		driver.quit();
		Assert.fail();
	}

}

//Function Summary   : Method to Perform Actions for Verify Toggle Functionality  
//Parameter Summary : ActivationToggleMsg,DeActivationToggleMsg
public void ToggleValidation(Map<Object,Object>testdatamap,Log Log) {

	    try {        
	        NavigateToApprovedBillersMenu(testdatamap, Log); 
	        
	        WebClickUsingJS(EdaatOR.Systemmgmt_toggle);
	        if (getText(EdaatOR.Biller_Systm_Active_toggle_Msg).toString().equals(testdatamap.get("ActivationToggleMsg").toString())) {
	            WebClickUsingJS(EdaatOR.Biller_Confirm_toggle);
	            Thread.sleep(1000);
	            Log.ReportEvent("PASS", "Activate Toggle is Successful");
	        } else if (getText(EdaatOR.Biller_Systm_DeActive_toggle_Msg).equals(testdatamap.get("DeActivationToggleMsg").toString())) {
	            WebClickUsingJS(EdaatOR.Biller_Confirm_toggle);
	            Thread.sleep(1000);
	            Log.ReportEvent("PASS", "Deactivate Toggle is Successful");
	        } else {
	            Log.ReportEvent("FAIL", "Activate/Deactivate Toggle Action was not Successful");
	            this.takeScreenShot();
	            driver.quit();
	            Assert.fail();
	        }
	      
	    } catch (Exception e) {
	            Log.ReportEvent("FAIL", "Toggle Action was not Successful");
	            this.takeScreenShot();
	            driver.quit();
	            Assert.fail();
	        }   

}


//Function Summary : Navigate to "Approved Biller" Page and update client Details
//Parameter Summary: Billername,MonthlyLimits,TransferDuration.AzimFeesadadFee,corpName,Max,driver
public void UpdateApprovedBiller( Map<Object,Object>testdatamap,Log Log){
	try{
	    NavigateToApprovedBillersMenu(testdatamap, Log);
	    SearchBiller(testdatamap, Log);
		Thread.sleep(500);
		WebClickUsingJS(EdaatOR.Biller_Edit);
    	Thread.sleep(1000);	    	
    	WebClear(EdaatOR.Biller_Maxlimit);
    	WebEdit(EdaatOR.Biller_Maxlimit,testdatamap.get("MonthlyLimits").toString());
    	WebClear(EdaatOR.Biller_TransferDuration);
    	WebEdit(EdaatOR.Biller_TransferDuration,testdatamap.get("TransferDuration").toString());
    	
    	WebClear(EdaatOR.Biller_BillerAliasNameEn);
    	WebEdit(EdaatOR.Biller_BillerAliasNameEn,testdatamap.get("CorporateName").toString());
    	WebClear(EdaatOR.Biller_MaximumInvoiceAmount);
    	Thread.sleep(1500);
    	WebEdit(EdaatOR.Biller_MaximumInvoiceAmount,testdatamap.get("MaximumAmt").toString());
    	scrollDowntillend(driver);
    	WebClick(EdaatOR.Biller_Save);
    	Thread.sleep(1000);	
		WebClick(EdaatOR.Biller_Save_Yes);	
    	
    	if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_idError)) {
            Log.ReportEvent("FAIL", "Approved Biller Account not Updated Successfully");
			 this.takeScreenShot();
			 driver.quit();
			 Assert.fail();
			 }
       else if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_BenificaryError)) {
       	  scrollToElementCenter(driver, driver.findElement(By.xpath(EdaatOR.Biller_SystemMgm_Biller_BenificaryError)));
          Log.ReportEvent("FAIL", "Approved Biller Account not Updated Successfully");
	          this.takeScreenShot();
	          driver.quit();
	          Assert.fail();
	        }
		

       else if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_Durationerror)) {
       	  scrollToElementCenter(driver, driver.findElement(By.xpath(EdaatOR.Biller_SystemMgm_Biller_Durationerror)));
          Log.ReportEvent("FAIL", "Approved Biller Account not Updated Successfully");
	          this.takeScreenShot();
	          driver.quit();
	          Assert.fail();
	        }
		
      else if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_CrpArbError)
			) { 
   	   scrollToElementCenter(driver, driver.findElement(By.xpath(EdaatOR.Biller_SystemMgm_Biller_CrpArbError)));
       Log.ReportEvent("FAIL", "Approved Biller Account not Updated Successfully");
	         this.takeScreenShot();
	         driver.quit();
	         Assert.fail();
         }
      else if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_CrpEngError)) {
      	   
      	   scrollToElementCenter(driver, driver.findElement(By.xpath(EdaatOR.Biller_SystemMgm_Biller_CrpEngError)));
           Log.ReportEvent("FAIL", "Approved Biller Account not Updated Successfully");
  	         this.takeScreenShot();
  	         driver.quit();
  	         Assert.fail();
            }
		
      else if(ExistsCheck(EdaatOR.Biller_SystemMgm_Maximum_Invoice_Error)) {
      	   
      	     scrollToElementCenter(driver, driver.findElement(By.xpath(EdaatOR.Biller_SystemMgm_Maximum_Invoice_Error)));
             Log.ReportEvent("FAIL", "Approved Biller Account not Updated Successfully");
  	         this.takeScreenShot();
  	         driver.quit();
  	         Assert.fail();
            }
      else if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_TransferErrormsg)){
      	   
  	     scrollToElementCenter(driver, driver.findElement(By.xpath(EdaatOR.Biller_SystemMgm_Biller_TransferErrormsg)));
         Log.ReportEvent("FAIL", "Approved Biller Account not Updated Successfully");
	         this.takeScreenShot();
	         driver.quit();
	         Assert.fail();
        }
      else if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_PaymentError)){
          Log.ReportEvent("FAIL", "Approved Biller Account not Updated Successfully");
	         this.takeScreenShot();
	         driver.quit();
	         Assert.fail();
         }
    else {
        
         Log.ReportEvent("PASS", "Approved Biller Account Updated Successfully"); 
      }
	}catch (Exception e) {
		Log.ReportEvent("FAIL", "Approved Biller Account not Updated Successfully");
        this.takeScreenShot();
        driver.quit();
        Assert.fail();
   	 	
	}
    }

//Function Summary   : Method to verify Close Button By Maker or Checker
//Parameter Summary : view , tog.
public void VerifyCloseButton(Map<Object,Object>testdatamap,Log Log) throws InterruptedException {
	try{
	NavigateToBillersBillersUnderActivationMenu(testdatamap, Log);
	Thread.sleep(1000);
    SearchBiller(testdatamap, Log);
	Thread.sleep(1000);
	WebClickUsingJS(EdaatOR.Biller_Edit);
	
	Thread.sleep(2000);
	WebClick(EdaatOR.Systemmgmt_NonApprovedCloseBtn);
	
	if(ExistsCheck(EdaatOR.Systemmgmt_Biller_UnderActivation_Page)) {
		Log.ReportEvent("PASS", " Close button verification is Successful.");

	}
	else {
		Log.ReportEvent("FAIL", " Close button verification is Unsuccessful.");
		this.takeScreenShot();
		driver.quit();
		Assert.fail();
	}
	
	}
    catch(Exception e){
    	Log.ReportEvent("FAIL", " Close button verification is Unsuccessful.");
		this.takeScreenShot();
		driver.quit();
		Assert.fail();
    
}

}


//Function Summary   : Method to EnterFees
	//Parameter Summary  : N/A
	public void EnterFees(Map<Object, Object> testdatamap) throws Exception {				
		   // WebClear(EdaatOR.Admin_SystemMgm_Biller_sadadfees);
			WebEdit(EdaatOR.Biller_SystemMgm_Biller_sadadfees,testdatamap.get("SadadFees").toString());
			Thread.sleep(1000);
		//	WebClear(EdaatOR.Admin_SystemMgm_Biller_Azimfees);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_SystemMgm_Biller_Azimfees, testdatamap.get("AZMFees").toString());
		
	}
     //Function Summary   : Method to ApproveBillerErrorMsg
		//Parameter Summary  : CompanyName		
		public void UpdateBillerdetailsErrorMSGvalidation(Map<Object, Object> testdatamap,Log Log) throws Exception {
			try {
			NavigateToBillersBillersUnderActivationMenu(testdatamap,Log);
			SearchBiller(testdatamap, Log);
			Thread.sleep(1500);
			WebClick(EdaatOR.Systemmgmt_NotApproved_Edit);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_Systemmgmt_TempBenificaryName,testdatamap.get("TempBenificaryName").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_Systemmgmt_BillerCode,testdatamap.get("BillerCode").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_Systemmgmt_TransferDuration,testdatamap.get("TransferDuration").toString());
			Thread.sleep(1000);
			selectCategoryID(testdatamap.get("BenificaryCategory").toString());
			Thread.sleep(1000);	
			//EnterFees(testdatamap);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_Systemmgmt_BillerAliasNameAr,testdatamap.get("BillerNameArabic").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_Systemmgmt_BillerAliasNameEn,testdatamap.get("BillerNameEnglich").toString());
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasSubBillers);
			Thread.sleep(1000);		
			WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasEnterpriseSubBillers);
			Thread.sleep(1000);		
			WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasIndividualSubBillers);
			Thread.sleep(1000);		
			WebClickUsingJS(EdaatOR.Biller_Systemmgmt_IsUrgentBillUploader);
			Thread.sleep(1000);		
			WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasMaximumInvoiceNumberPerDay);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_Systemmgmt_MaximumInvoiceNumber,testdatamap.get("MaxAllowedDailyInvoices").toString());
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasMaximumInvoiceAmountPerDay);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_Systemmgmt_MaximumInvoiceAmount,testdatamap.get("MaximumInvoiceAmount").toString());
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_Systemmgmt_Tracker);
			Thread.sleep(1000);	
			WebClick(EdaatOR.Biller_SystemMgm_ConfirmTrackedBiller);
			Thread.sleep(1000);	
	    	WebSelect(EdaatOR.Biller_SystemMgm_TrackedBiller, testdatamap.get("SuperBillerName").toString());
	    	Thread.sleep(2000);
	    	SelectThePaymentMethod(testdatamap.get("PaymentMethod").toString());
	    	Thread.sleep(1000);
	    	WebClickUsingJS(EdaatOR.Biller_Save);
	    	Thread.sleep(1000);
	    	WebClickUsingJS(EdaatOR.Biller_Save_Yes);
	    	Thread.sleep(2000);
			Thread.sleep(5000);
			String Expected=testdatamap.get("ExpectedResult").toString();
			
			 if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_idError))
				{
			        getText(EdaatOR.Biller_SystemMgm_Biller_idError).equals(Expected);
					Log.ReportEvent("Pass", "Error Message Validation for Biller ID Text Field is Successful");
					
				}
			
			else if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_BenificaryError))
			{
				scrollToElementCenter(driver, driver.findElement(By.xpath(EdaatOR.Biller_SystemMgm_BillerAliasEnName)));
				getText(EdaatOR.Biller_SystemMgm_BillerAliasEnName).equals(Expected);
				Log.ReportEvent("Pass", "Error Message Validation for Beneficary Name Text Field is Successful");
			}
			
			
			else if(ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_Durationerror))
					{
				       scrollToElementCenter(driver, driver.findElement(By.xpath(EdaatOR.Biller_SystemMgm_Biller_Durationerror)));
				        getText(EdaatOR.Biller_SystemMgm_Biller_Durationerror).equals(Expected);
				       Log.ReportEvent("Pass", "Error Message Validation for Transfer Duration Text Field is Successful");						
						
					}
			else if (ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_CrpArbError)) {
				
				scrollToElementCenter(driver, driver.findElement(By.xpath(EdaatOR.Biller_SystemMgm_Biller_CrpArbError)));
		        getText(EdaatOR.Biller_SystemMgm_Biller_CrpArbError).equals(Expected);
		       Log.ReportEvent("Pass", "Error Message Validation for Corporate Name in Arabic Text Field is Successful");
			
			}	
			else if (ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_CrpEngError)) {
				
				scrollToElementCenter(driver, driver.findElement(By.xpath(EdaatOR.Biller_SystemMgm_Biller_CrpEngError)));
		        getText(EdaatOR.Biller_SystemMgm_Biller_CrpEngError).equals(Expected);
			       Log.ReportEvent("Pass", "Error Message Validation for Corporate Name English Text Field is Successful");
			
			}	
			else if (ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_BillerCatgError)) {
				
				scrollToElementCenter(driver, driver.findElement(By.xpath(EdaatOR.Biller_SystemMgm_Biller_BillerCatgError)));
		        getText(EdaatOR.Biller_SystemMgm_Biller_BillerCatgError).equals(Expected);
		       Log.ReportEvent("Pass", "Error Message Validation for Transfer Duration Text Field is Successful");
			
			}	
			 
			else if (ExistsCheck(EdaatOR.Biller_SystemMgm_Biller_TransferErrormsg)) {
				
				scrollToElementCenter(driver, driver.findElement(By.xpath(EdaatOR.Biller_SystemMgm_Biller_TransferErrormsg)));
		        getText(EdaatOR.Biller_SystemMgm_Biller_TransferErrormsg).equals(Expected);
		       Log.ReportEvent("Pass", "Error Message Validation for Transfer Duration Text Field is Successful");
		       
			}
			
			else
			{

			       Log.ReportEvent("Fail", "Error Message Validation for Update Biller Details is Successful");	
			       takeScreenShot();
			       driver.quit();
			       Assert.fail();

			}
		}
			catch (Exception e) {
				
				 Log.ReportEvent("Fail", "Error Message Validation for Update Biller Details is Successful");	
			       takeScreenShot();
			       driver.quit();
			       Assert.fail();
			}

		}
		
		//Function summary:Navigate to IndividualClient Management
		//Function Parameters:NA
			public void NavigateIndividualClientManagement()
			{
				WebClickUsingJS(EdaatOR.AdminSystem_Individual_link);
		 	    
			}
		public void VerifyAccountSettingButtonErrorMsg(Map<Object, Object> testdatamap){		
			try {
				  String accountstatus=testdatamap.get("Account Status Type").toString();
				  WebClear(EdaatOR.BillerSystem_IndividualClient_Name);
			      WebEdit(EdaatOR.BillerSystem_IndividualClient_Name,testdatamap.get("ClientName").toString());
			      Thread.sleep(1000);
			      WebClear(EdaatOR.BillerSystem_Individual_national);
			      WebEdit(EdaatOR.BillerSystem_Individual_national,testdatamap.get("National ID").toString());
			      Thread.sleep(1000);
			      WebClickUsingJS(EdaatOR.BillerSystem_Individual_Search);
			      Thread.sleep(1000);
			      VerifyValue1(getText("//a[text()='"+testdatamap.get("ClientName").toString()+"']"),testdatamap.get("ClientName").toString());
			      WebClickUsingJS(EdaatOR.BillerSystem_Individuaul_SettingsBTN);
			      Thread.sleep(1000);
			      if(accountstatus.equalsIgnoreCase("Suspended Permanently")) {
						WebClickUsingJS(EdaatOR.BillerSystem_Individuaul_SuspendPermradioBTN);
						Thread.sleep(3000);
					}
					else if(accountstatus.equalsIgnoreCase("Suspended")){
						WebClickUsingJS(EdaatOR.BillerSystem_Individuaul_SuspendradioBTN);
						Thread.sleep(3000);
					}
			      WebClickUsingJS(EdaatOR.BillerSystem_Individuaul_SettingConirmBTN);
			      if(ExistsCheck(EdaatOR.BillerSystem_Individuaul_Accountstatuserrormsg))
			      {
			    	  
			    	  VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.BillerSystem_Individuaul_Accountstatuserrormsg);
			    	  
			    	  test.log(Status.PASS, "Individual clients Account status ErrorMessage Exists" + driver.getTitle() + " * Account Status ErrorMessage Exists * ");
			      }
			      else if(ExistsCheck(EdaatOR.BillerSystem_Individuaul_SuspendReasonerrormsg)){
			    	  
			    	  VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.BillerSystem_Individuaul_SuspendReasonerrormsg);
			    	  
			    	  test.log(Status.PASS, "Individual clients Account Suspended Reason ErrorMessage Exists" + driver.getTitle() + " * Account Suspended Reason ErrorMessage Exists * ");				
			      }
			      else
			      {
			          test.log(Status.FAIL, "Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");		      
			      }
			     WebClick(EdaatOR.BillerSystem_Individuaul_cancelbtn);
			    }
			catch(Exception e){
		    	test.log(Status.FAIL,"Verify Individual Client Account settings Button " + driver.getTitle() +" *  Individual Client Account settings Button is UnSucessful  FAIL * " );
		        
		   }
		}	
		//Function Summary  : Method to select client status dropdown
		//Parameter Summary : Client Status
		public void SelectClientDropdown(Map<Object, Object> testdatamap) throws Exception
	    {
	        WebClick(EdaatOR.Biller_SymCorpoClientstatus);
	        WebClick("//option[text()='"+testdatamap.get("Client Status").toString()+"']");
	    
	    }
		//Function Summary  : Method to Search corporate client
		//Parameter Summary : CompanyName
		public void SearchcorpClient(Map<Object, Object> testdatamap,Log Log) throws Exception {
			try {
			WebEdit(EdaatOR.Admin_SymCorpoName,testdatamap.get("CompanyName").toString());
			Thread.sleep(1000);
			SelectClientDropdown(testdatamap);
			WebClick(EdaatOR.Biller_Corporateclient_srchbtn);
			if(getText(EdaatOR.AppBiller_Name).equals(testdatamap.get("CompanyName").toString())) {
				Log.ReportEvent("PASS", "Corporate Client Search is Successful");
			}
			else {
				
		    	Log.ReportEvent("FAIL", "Corporate Client Search is Unsuccessful");
		    	this.takeScreenShot();
		    	driver.quit();
		    	Assert.fail();

			}
			}
			
			catch(Exception e) {
		    	Log.ReportEvent("FAIL", "Corporate Client Search is Unsuccessful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}	
		}
		

		//Function Summary  : Method to ReconcilledDateSearch
		//Parameter Summary : Month,Year,Date
		public void ReconcilledDateSearch(Map<Object, Object> testdatamap) throws Exception {
			WebClick(EdaatOR.Admin_DailyTransReconciledCalender);
			selectDropdownValue_PartialText(EdaatOR.Admin_ReconciledMonth, testdatamap.get("Month").toString());
			selectDropdownValue_PartialText(EdaatOR.Admin_ReconciledYear, testdatamap.get("Year").toString());
			WebClick("//a[text()='"+testdatamap.get("Date").toString()+"']");
			Thread.sleep(1000);
			WebClick(EdaatOR.Admin_ReconciledSearchBtn);
			Thread.sleep(2000);
	 
		}
	
	//Function Summary  : Method to VerifyEODSettlementReportErrorMsg
	//Parameter Summary : Expected	
	public void VerifyEODSettlementReportErrorMsg(Map<Object, Object> testdatamap) {
		
		try {
			WebClickUsingJS(EdaatOR.Biller_Dist_EODSettlement);
			Thread.sleep(1000);
			WebClick(EdaatOR.Biller_Dist_EODSettlementSearchbtn);
			Thread.sleep(1000);
			if(ExistsCheck(EdaatOR.Biller_Dist_EODSettlementErrorMsg))
			{
				VerifyValue(testdatamap.get("Expected").toString(),EdaatOR.Biller_Dist_EODSettlementErrorMsg);
				Thread.sleep(1000);
				
				test.log(Status.PASS, "Date ErrorMessage Exists" + driver.getTitle() + " * Date ErrorMessage Exists * ");
			}
			else
			{
				test.log(Status.FAIL, "Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");
			}
			
		} catch (Exception e) {
						
			test.log(Status.FAIL,"Verify Distribution EOD Settlement" + driver.getTitle() +" * Verify Distribution EOD Settlement is unsuccessfull FAIL * " );
			
		}
	}
	//Function Summary   : Method to Select The Payment Method
	//Parameter Summary  : paymentMethod
	public void SelectThePaymentMethod(String paymentMethod) {
		try {
			
		if (paymentMethod.equalsIgnoreCase("sadad")) {
			
			WebClickUsingJS(EdaatOR.Systemmgmt_NonApproved_SadadBtn);
		}
		else if (paymentMethod.equalsIgnoreCase("mada")) {
			
			WebClickUsingJS(EdaatOR.Systemmgmt_NonApproved_MadaBtn);
		}
		else if (paymentMethod.equalsIgnoreCase("visa")) {
			
			WebClickUsingJS(EdaatOR.Systemmgmt_NonApproved_VisaBtn);
		}
		else {
			
			WebClickUsingJS(EdaatOR.Systemmgmt_NonApproved_MasterCardBtn);
		}
	}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}