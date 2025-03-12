/**
* Test Script Name  				 : N/A
* Objective     					 : To Verify Settings Pricelist Functionality
* Version      						 : 1.0
* Author       						 : Kathirvelu Mohan
* Created Date 			      		 : 
* Last Updated on					 : N/A
* Updated By   			 			 : Basavaraj Mudnur
* Pre-Conditions					 : N/A
* Epic Details						 : N/A
* User Story Details				 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.util.Map;

import org.apache.poi.ss.formula.functions.EDate;
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



public class AdminSettingsPricingListPage extends BasePage
{

	public AdminSettingsPricingListPage(WebDriver driver,ExtentTest test)
	{
		 this.driver=driver;
		 this.test=test;
		 
		 PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  
	

	@FindBy(xpath = EdaatOR.Admin_Setting_pricelistpageVerify)
	public WebElement PriceList;
		
	    
	    public boolean Exists(){
	    	return super.Exists(PriceList); 
		}
 
	  //Function Summary : Method to navigate to pricing list page
	 //Parameter Summary: N/A  
    public void navigatePriceList(Log Log) throws Exception {
			try {
			Thread.sleep(1000);	
			WebClickUsingJS(EdaatOR.Admin_Setting_pricelistlnk);
			waitForPageToLoad();
			if(CheckElementExists(EdaatOR.Admin_Settings_PriceListsym)) {
				Log.ReportEvent("PASS", "price list page is Loaded Successfully");
				}
				else{
					Log.ReportEvent("FAIL", "price list page is not Loaded Successfully");
					this.takeScreenShot();
					driver.quit();Assert.fail();
				}

			}
			catch (Exception e) {
				Log.ReportEvent("FAIL", "price list page is not Loaded Successfully");
				this.takeScreenShot();
				driver.quit();Assert.fail();
			}
		}

  //Function Summary : Method to Select radio button of Impact on the base price.
  	//Parameter Summary: Impact On The Basic Price,Increase Price.
  	public void ImpactOnTheBasicPrice(Map<Object, Object> testdatamap) throws Exception
  	{
  	String ele=testdatamap.get("Impact On The Basic Price").toString();
  	if(ele.equalsIgnoreCase("Increase Price"))
  	{
  		WebClick(EdaatOR.Admin_Settings_Pricelistincradiobtn);
  	}
  	else
  	{
  		WebClick(EdaatOR.Admin_Settings_Pricelistdscradiobtn);
  	}
  	}
	public void Rounding(Map<Object, Object> testdatamap) throws Exception
	{
		String ele=testdatamap.get("Rounding").toString();
		if(ele.equalsIgnoreCase("Rounding Up"))
		{
			WebClick(EdaatOR.Admin_Settings_Roundinguprdn);
		}
		else if(ele.equalsIgnoreCase("Rounding Down"))
		{
			WebClick(EdaatOR.Admin_Settings_Roundingdownrdn);
		}
		else
		{
			WebClick(EdaatOR.Admin_Settings_RoundingNordn);
		}
	}
  //Function Summary : Method to search pricelist page 
  	//Parameter Summary: N/A
  	private void PriceListSearch(Map<Object,Object>testdatamap,Log Log) {
  		try {
  		WebEdit(EdaatOR.Admin_Settings_PriceListsfield,testdatamap.get("PriceListNameEnglish").toString());
  		Thread.sleep(1000);
  		WebClick(EdaatOR.Admin_Settings_PriceListSeacrchbtn);
  		Thread.sleep(2000);
  		VerifyValue1(getText(EdaatOR.Admin_Settings_PriceListnameverify), testdatamap.get("PriceListNameEnglish").toString());
  		
  		test.log(Status.PASS,"Verify Search Pricelist" + driver.getTitle() +" * Search Pricelist is Pass * " );
		Log.ReportEvent("PASS", " Verify to Add price list is Suceessful");
		this.takeScreenShot();
  		}
  		catch (Exception e) {
  			e.printStackTrace();
  			
  			test.log(Status.FAIL,"Verify Search Pricelist" + driver.getTitle() +" * Search Pricelist is Fail* " );
  			this.takeScreenShot();
  		}
  	}
  	//Function Summary : Method to Select Date
    //Parameter Summary: FromYear,FromMonth,FromDate,ToYear,ToMonth and ToDate.
    	public void SelectDate(Map<Object,Object>testdatamap)
    	{
    		try {
    		WebClick(EdaatOR.Admin_Settings_PriceFromd);
//    		selectDropdownValue_PartialText(EdaatOR.Admin_Settings_PriceFromyear,testdatamap.get("FromYear").toString());
//        	selectDropdownValue_PartialText(EdaatOR.Admin_Settings_PriceFromon,testdatamap.get("FromMonth").toString());
//        	WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
    		Thread.sleep(800);
    		WebClick(EdaatOR.Admin_Settings_TodayDate);
    		Thread.sleep(800);
    		WebClick(EdaatOR.Admin_Settings_PriceTod);
        	selectDropdownValue_PartialText(EdaatOR.Admin_Settings_PriceToyear,testdatamap.get("ToYear").toString());
        	selectDropdownValue_PartialText(EdaatOR.Admin_Settings_Priceomon,testdatamap.get("ToMonth").toString());
        	WebClick("//td/a[text()='"+testdatamap.get("ToDate").toString()+"']");
    		}

    		catch (Exception e){
    			e.printStackTrace();
    			
    			test.log(Status.FAIL,"Select Date" + driver.getTitle() +" *Select Date is Fail* " );
    			this.takeScreenShot();
    		}
    	}
  //Function Summary : Method to pricelistsearch
  //Parameter Summary: PriceListNameEnglish
    	public void pricelistsearch(Map<Object, Object> testdatamap,Log Log) throws Exception {
    		Thread.sleep(1000);
    		WebEdit(EdaatOR.Admin_Settings_PriceListsfield,testdatamap.get("PriceListNameEnglish").toString());
    		Thread.sleep(1000);
    		WebClick(EdaatOR.Admin_Settings_PriceListSeacrchbtn);
    		Thread.sleep(1000);
    		//  		VerifyValue1(getText("//td[text()='"+testdatamap.get("PriceListNameEnglish").toString()+"']//ancestor::tr//td[6]"),testdatamap.get("Status").toString());
    		if(getText("//td[text()='"+testdatamap.get("PriceListNameEnglish").toString()+"']").equals(testdatamap.get("PriceListNameEnglish").toString())) {
    			Log.ReportEvent("PASS", "Search price list is Successful");
    		}
    		else{
    			Log.ReportEvent("FAIL", "Search price list is not Successful");
    			this.takeScreenShot();
    			driver.quit();Assert.fail();
    		}

    	}
    	
   //Function Summary : Method to pricelistadd
  //Parameter Summary: PriceListNameArabic,PriceListNameEnglish,Increase/Decrease Ratio,Description
  	public void pricelistadd(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {
  		try {
  		WebClick(EdaatOR.Admin_Settings_Addpricelistbtn);
  		Thread.sleep(1000);
  		WebEdit(EdaatOR.Admin_Settings_PricelistArabicName,testdatamap.get("PriceListNameArabic").toString());
  		Thread.sleep(1000);
  		WebEdit(EdaatOR.Admin_Settings_PricelistEnglishName,testdatamap.get("PriceListNameEnglish").toString());
  		ImpactOnTheBasicPrice(testdatamap);
  		WebEdit(EdaatOR.Admin_Settings_Pricelistbtn,testdatamap.get("Increase/Decrease Ratio").toString());
  		SelectDate(testdatamap);
      	Rounding(testdatamap);
      	WebEdit(EdaatOR.Admin_Settings_descriptionbtn,testdatamap.get("Description").toString());
      	WebClick(EdaatOR.Biller_ActiveCheckbox);
      	Thread.sleep(1000);
     	
      	WebClick(EdaatOR.Admin_Settings_AddPricelistbtn2);
		if(CheckElementExists(EdaatOR.Admin_RequiredFieldsErrMsg)) {
			Log.ReportEvent("FAIL", "Add price list is not Successful");
			this.takeScreenShot();
			driver.quit();Assert.fail();
			}
			else{
				Log.ReportEvent("PASS", "Add price list is Successful");

			}
  		}
  		catch (Exception e) {
			Log.ReportEvent("FAIL", "Add price list is not Successful");
			this.takeScreenShot();
			driver.quit();Assert.fail();		}
	}
  	
  	//Function Summary : Method to VerifyPriceListSearch
  	//Parameter Summary: PriceListNameEnglish
  	public void VerifyPriceListSearch(Map<Object, Object> testdatamap,Log Log) throws InterruptedException
  	{
  		try
  		{
  			pricelistadd(testdatamap,Log);
  			Thread.sleep(500);
  			pricelistsearch(testdatamap,Log);	
  		}
  		catch (Exception e) {
  			Log.ReportEvent("FAIL", "Search price list is notSuccessful");
  			this.takeScreenShot();
  			driver.quit();Assert.fail();
  		}
  	}
  	
  	 //Function Summary : Method to Delete pricelist page 
  	//Parameter Summary: N/A
  	public void VerifyPriceListDelete(Map<Object,Object>testdatamap,Log Log) {
  		try {

  	  		 pricelistadd(testdatamap,Log);
   	  		Thread.sleep(500);
  	  		 pricelistsearch(testdatamap,Log);
   	  		Thread.sleep(500);
  	  		WebClick(EdaatOR.Admin_Settings_PriceList_DeleteBtn);
  	  		WebClick(EdaatOR.Admin_Settings_PriceList_yesDeleteBtn);
  	  		Thread.sleep(1000);
			if(CheckElementExists(EdaatOR.Admin_Product_NoData)) {
				Log.ReportEvent("PASS", "Delete price list is Successful");
			}
			else{
				Log.ReportEvent("FAIL", "Delete price list is not Successful");
				this.takeScreenShot();
				driver.quit();Assert.fail();
			}
  		}
  		catch (Exception e) {
			Log.ReportEvent("FAIL", "Delete price list is not Successful");
			this.takeScreenShot();
			driver.quit();Assert.fail();
  		}

  	}
  	 //Function Summary : Method to Verify grid view of Price list under settings.
  	//Parameter Summary: N/A
	public void VerifyGridView(Map<Object, Object> testdatamap,Log Log) {
		// TODO Auto-generated method stub
		try {
			navigatePriceList(Log);
			Thread.sleep(500);
			pricelistsearch(testdatamap, Log);
			Thread.sleep(500);
			if(CheckElementExists(EdaatOR.Admin_Settings_PriceListtable)) {
				Log.ReportEvent("PASS", "Price list grid view is Successful");
				}
				else{
					Log.ReportEvent("FAIL", "Price list grid view is not Successful");
					this.takeScreenShot();
					driver.quit();Assert.fail();
				}
		}
			catch (Exception e) {
				Log.ReportEvent("FAIL", "Price list grid view is not Successful");
				this.takeScreenShot();
				driver.quit();Assert.fail();
			}
		}
	
	//Function Summary : Method to View price lists details
  	//Parameter Summary: PriceListNameEnglish
	public void ViewPriceDetails(Map<Object,Object>testdatamap,Log Log)
  	{
  		try {
  			WebEdit(EdaatOR.Admin_Settings_PriceListsfield, testdatamap.get("PriceListNameEnglish").toString());
  	  		WebClick(EdaatOR.Admin_Settings_PriceListSeacrchbtn);
  	  	    Thread.sleep(2000);
  	  		WebClickUsingJS(EdaatOR.Admin_Settings_PriceListUpdateBtn);
  	  	    Thread.sleep(2000);
  			if(CheckElementExists(EdaatOR.Admin_Settings_PriceListUpdate)) {
  				Log.ReportEvent("PASS", "View price list details is Successful");
  				}
  				else{
  					Log.ReportEvent("FAIL", "View price list details is not Successful");
  					this.takeScreenShot();
  					driver.quit();Assert.fail();
  				}
  		}
  		catch (Exception e) {
				Log.ReportEvent("FAIL", "View price list details is not Successful");
				this.takeScreenShot();
				driver.quit();Assert.fail();
  		}
  		
  	}

	
	public void priceListAdd(Map<Object,Object>testdatamap) throws Exception {
 		WebClick(EdaatOR.Admin_Settings_Addpricelistbtn);
		Thread.sleep(500);
      	WebClick(EdaatOR.Admin_Settings_AddPricelistbtn2);

	}
	//Function Summary  : method to verify Error messages in Add price list page
	//Parameter Summary : ExpectedResult
	public void VerifyAddPriceListErrorMsg(Map<Object,Object>testdatamap,Log Log) throws InterruptedException{
		{
			try {
				
				Thread.sleep(1000);
		  		WebClick(EdaatOR.Admin_Settings_Addpricelistbtn);
		  		Thread.sleep(1000);
		  		if(testdatamap.get("ExpectedResult").toString().equalsIgnoreCase("This Field Is Required")) {
			      	WebClick(EdaatOR.Admin_Settings_AddPricelistbtn2);

		  		}
		  		else {
		  		WebEdit(EdaatOR.Admin_Settings_PricelistArabicName,testdatamap.get("PriceListNameArabic").toString());
		  		Thread.sleep(1000);
		  		WebEdit(EdaatOR.Admin_Settings_PricelistEnglishName,testdatamap.get("PriceListNameEnglish").toString());
		  		ImpactOnTheBasicPrice(testdatamap);
		  		WebEdit(EdaatOR.Admin_Settings_Pricelistbtn,testdatamap.get("Increase/Decrease Ratio").toString());
		  		SelectDate(testdatamap);
		      	Rounding(testdatamap);
		      	WebEdit(EdaatOR.Admin_Settings_descriptionbtn,testdatamap.get("Description").toString());
		      	WebClick(EdaatOR.Biller_ActiveCheckbox);
		      	Thread.sleep(1000);
		     	
		      	WebClick(EdaatOR.Admin_Settings_AddPricelistbtn2);}
				
				if (ExistsCheck(EdaatOR.Admin_MandatoryErrorMsg)){	
				
						VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_ArNameErrorMsg));
						Thread.sleep(500);
						VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_EnNameErrorMsg));
						Thread.sleep(500);
						VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_RatioErrorMsg));
						Thread.sleep(500);
						VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_FromDateErrorMsg));
						Thread.sleep(500);
						VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_ToDateErrorMsg));
						Thread.sleep(500);
						VerifyValue1(testdatamap.get("ExpectedResult").toString(), getText(EdaatOR.Admin_RoundingErrorMsg));
				
						Log.ReportEvent("PASS", "Verify 'This field is required' error Message is successful");
		
				}
				else if (testdatamap.get("ExpectedResult").toString().equals (getText(EdaatOR.Admin_RatioErrorMsg))) {
					Log.ReportEvent("PASS", "Verify Error message for 'PriceList Ratio' is successful");
				}
				
				else {
					Log.ReportEvent("FAIL", "Verify Add Price List error Message is not successful");
					this.takeScreenShot();
					driver.quit();Assert.fail();
				}

			} catch (Exception e) {
				Log.ReportEvent("FAIL", "Verify Add Add Price List error Message is not successful");
				this.takeScreenShot();
				driver.quit();Assert.fail();			}

		}
	}			
	
}
	
 


	
	
    

