/**
*
* Test Script Name                   : N/A.
* Objective                          : Verify Price List Functionality.
* Version                            : 1.0
* Author                             : Arun Kumar MS.
* Created Date                       : 11/08/2023
* Last Updated on                    : N/A
* Updated By                         : Arun Kumar MS
* Pre-Conditions                     :
* Manual Testcase Name               : N/A.
* Epic Details                       : N/A
* User Story Details                 : N/A
* Defects affecting this test script : None
* Work Arounds/Known Issues          : None
**/
package com.azmqalabs.edaattestautomation.apppages.biller.pages;

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

public class BillerSettingPricelistPage extends BasePage {
	public BillerSettingPricelistPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  


	@FindBy(xpath = EdaatOR.Biller_PriceListpagetxt)
	public WebElement PriceList;


	public boolean Exists(){
		return super.Exists(PriceList); 
	}
	
	//Function Summary : Navigate to pricelist page 
	//Parameter Summary: N/A
	public void navigatetoPriceListPage() throws Exception {
		try {
		WebClickUsingJS(EdaatOR.Biller_Settings);
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Biller_PriceList);
		waitForPageToLoad();
		
		test.log(Status.PASS,"Verify Navigate to Pricelist page " + driver.getTitle() +" * Navigate to Pricelist page is Pass * " );
		}
		catch (Exception e) {
			e.printStackTrace();
			
			test.log(Status.FAIL,"View Navigate to Pricelist page " + driver.getTitle() +" * Navigate to Pricelist page is Fail * " );
		}
		
	}
	
	//Function Summary : Method to search Price List 
	//Parameter Summary: N/A
	public void PriceListSearch(Map<Object,Object>testdatamap,Log Log) {
		try {
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_PriceListsfield,testdatamap.get("PriceNameEnglish").toString());
		Thread.sleep(1000);
		WebClick(EdaatOR.Biller_PriceListSeacrchbtn);
		Thread.sleep(4000);
		
		if(ExistsCheck("//td[text()='"+testdatamap.get("PriceNameEnglish").toString()+"']")) {
			Log.ReportEvent("PASS", "Price list search is Successful");
		}
		else {
			Log.ReportEvent("FAIL", "Price list search is not Successful");
			takeScreenShot();
			driver.quit();
			Assert.fail();

		}
		
	}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "Price list search is not Successful");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
		}
	//Function Summary : Method to Select radio Button of Impact on the base price.
	//Parameter Summary: Impact On The Basic Price,Increase Price.
	public void ImpactOnTheBasicPrice(Map<Object, Object> testdatamap) throws Exception
	{
	String ele=testdatamap.get("Impact On The Basic Price").toString();
	if(ele.equalsIgnoreCase("Increase Price"))
	{
		WebClick(EdaatOR.Biller_Pricelistincradiobtn);
	}
	else
	{
		WebClick(EdaatOR.Biller_Pricelistdscradiobtn);
	}
	}
	public void Rounding(Map<Object, Object> testdatamap) throws Exception
	{
		String ele=testdatamap.get("Rounding").toString();
		if(ele.equalsIgnoreCase("Rounding Up"))
		{
			WebClick(EdaatOR.Biller_Roundinguprdn);
		}
		else if(ele.equalsIgnoreCase("Rounding Down"))
		{
			WebClick(EdaatOR.Biller_Roundingdownrdn);
		}
		else
		{
			WebClick(EdaatOR.Biller_RoundingNordn);
		}
	}
	//Function Summary : Method to add Price List.
	//Parameter Summary: Price List Name in Arabic,Price List Name in English,Increase or Decrease Ratio,FromYear,FromMonth,FromDate,ToYear,ToMonth,ToDate,Description.	
	public void AddPriselist(Map<Object, Object> testdatamap) throws Exception
	{
		WebClick(EdaatOR.Biller_AddPricelistbtn);
		WebEdit(EdaatOR.Biller_Pricelistnameinarabic,testdatamap.get("Price List Name in Arabic").toString());
		WebEdit(EdaatOR.Biller_PricelistnameinEnglish,testdatamap.get("Price List Name in English").toString());
		ImpactOnTheBasicPrice(testdatamap);
		WebEdit(EdaatOR.Biller_Pricelistbtn,testdatamap.get("Increase or Decrease Ratio").toString());
		WebClick(EdaatOR.Biller_AddPriceFromdate);
		selectDropdownValue_PartialText(EdaatOR.Biller_AddPriceFromYear,testdatamap.get("FromYear").toString());
    	selectDropdownValue_PartialText(EdaatOR.Biller_AddPriceFromMonth,testdatamap.get("FromMonth").toString());
    	WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
    	WebClick(EdaatOR.Biller_AddPriceTodate);
    	selectDropdownValue_PartialText(EdaatOR.Biller_AddPriceToyear,testdatamap.get("ToYear").toString());
    	selectDropdownValue_PartialText(EdaatOR.Biller_AddPriceToMonth,testdatamap.get("ToMonth").toString());
    	WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");
    	Rounding(testdatamap);
    	WebEdit(EdaatOR.Biller_Pricelistdescriptionbtn,testdatamap.get("Description").toString());
    	WebClick(EdaatOR.Biller_ActiveCheckbox);
    	WebClick(EdaatOR.Biller_AddPricelistbtn2);
    	
	}
	//Function Summary : Method to Search Price List.
	//Parameter Summary: N/A.	
	public void verifySearchFunctionality(Map<Object,Object>testdatamap,Log Log) throws Exception {
		try {
			navigatetoPriceListPage();
			PriceListSearch(testdatamap,Log);
			
			test.log(Status.PASS,"Verify Navigate to pricelist page  and search pricelist page " + driver.getTitle() +" * Navigate to pricelist page  and search pricelist page Pass * " );
        	Log.ReportEvent("PASS", " Verify Search pricelist is Suceessfull");
        	this.takeScreenShot();

			
		}
			catch (Exception e) {
				e.printStackTrace();
				
				test.log(Status.FAIL,"Verify Navigate to pricelist page  and search pricelist page" + driver.getTitle() +" * Navigate to pricelist page  and search pricelist page Fail* " );
				 this.takeScreenShot();
			}
		}
	
	//Function Summary : Method to Search/add/delete Price List.
	//Parameter Summary: N/A.
	public void PriceListDelete(Map<Object, Object> testdatamap,Log Log) {
		// TODO Auto-generated method stub
		try {
			
			WebClick(EdaatOR.Biller_PriceListDeletebtn);
			
			WebClick(EdaatOR.Biller_PriceListDeleteConformbtn);
			Thread.sleep(2000);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_PriceListsfield,testdatamap.get("PriceNameEnglish").toString());
			Thread.sleep(1000);
			WebClick(EdaatOR.Biller_PriceListSeacrchbtn);
			Thread.sleep(2000);
			if(	ExistsCheck(EdaatOR.Biller_PriceListNodata)) {
			
        	Log.ReportEvent("PASS", " Price list delete is Successful");
     
		}
		else 
		{
			Log.ReportEvent("FAIL", " Price list delete is not Successful");
			takeScreenShot();
			driver.quit();
			Assert.fail();	
		}	
	}
	
	catch (Exception e) {
		Log.ReportEvent("FAIL", " Price list delete is not Successful");
		takeScreenShot();
		driver.quit();
		Assert.fail();
			}
	}
	//Function Summary   : Method to ClickonBillersettings
	//Parameter Summary  : N/A
	public void ClickonBillersettings() {
	WebClickUsingJS(EdaatOR.Biller_Settings);
	waitForPageToLoad();
	}
	//Function Summary   : Method to ClickonPricingList
	//Parameter Summary  : N/A
	private void ClickonPricingList() {
	WebClickUsingJS(EdaatOR.Biller_settings_Price);
	waitForPageToLoad();
	}
	
	//Function Summary   : Method to EnterSearchitem
	//Parameter Summary  : N/A
	public void EnterSearchitem(String PriceListName) throws Exception {
		
		WebEdit(EdaatOR.Biller_settings_efield,PriceListName);
		Thread.sleep(1000);
		WebClick(EdaatOR.Biller_settings_sbtn);
		}
	//Function Summary   : Method to VerifyViewPriceButton
	//Parameter Summary  : PriceListName
	public void VerifyViewPriceButton(Map<Object, Object> testdatamap,Log Log)
	{
		try {
			Thread.sleep(1000);
			WebClick(EdaatOR.Biller_settings_Pricebtn );
			
			Thread.sleep(1000);
			verifyElementIsPresent(EdaatOR.Biller_settings_Priceverify);
			Thread.sleep(1000);
 			String pricelistName = driver.findElement(By.xpath(EdaatOR.Biller_PriceNameEn)).getAttribute("value");
			if(pricelistName.equals(testdatamap.get("PriceNameEnglish").toString())) {
	        	Log.ReportEvent("PASS", " View Price Details Button Verification is Successful");

			}
			else {
				Log.ReportEvent("FAIL", " View Price Details Button Verification is Unsuccessful");
	        	this.takeScreenShot(); 
	        	driver.quit();
	        	Assert.fail();
	        	
			}
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", " View Price Details Button Verification is Unsuccessful");
        	this.takeScreenShot(); 
        	driver.quit();
        	Assert.fail();
		}
	}
	//Function Summary   : Method to Navigate pricing list in settings module.
	//Parameter Summary : N/A.
	public void navigateToPriceList(Log Log) throws Exception {
		try {
		WebClickUsingJS(EdaatOR.Biller_Settings);
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Biller_PricingList);
		Thread.sleep(2000);
		
		if(ExistsCheck(EdaatOR.Biller_PricingList_Page)) {
	    	Log.ReportEvent("PASS", " Pricing List Page Is Loaded Successfully");

		}
		else {
	    	Log.ReportEvent("FAIL", " Pricing List Page Is not Loaded Successfully");
	    	this.takeScreenShot();
	    	driver.quit();
	    	Assert.fail();

		}
	}catch (Exception e) {
		Log.ReportEvent("FAIL", " Pricing List Page Is not Loaded Successfully");
    	this.takeScreenShot();
    	driver.quit();
    	Assert.fail();
		}
	}
	
	//Function Summary   : Method to add pricing list
	//Parameter Summary : PriceNameEnglish,PriceNameArabic,FromYear,FromMonth,FromDate,ToYear,ToMonth,ToDate,ImpactOnPrice
	public void addPriceList(Map<Object,Object>testdatamap,Log Log) {
		try {
			String PriceNameEnglish=testdatamap.get("PriceNameEnglish").toString();
			WebClickUsingJS(EdaatOR.Biller_AddBtn);
			waitForPageToLoad();
			WebEdit(EdaatOR.Biller_PriceNameAr, testdatamap.get("PriceNameArabic").toString());
			Thread.sleep(200);
			WebEdit(EdaatOR.Biller_PriceNameEn, PriceNameEnglish);
			Thread.sleep(200);
			WebClick("//label[text()='"+testdatamap.get("ImpactOnPrice").toString()+"']");
			Thread.sleep(200);
			WebEdit(EdaatOR.Biller_Ratio, testdatamap.get("Ratio").toString());
			Thread.sleep(200);
			WebClick(EdaatOR.Biller_FromCalendar);
			Thread.sleep(200);
			selectDropdownValue_PartialText(EdaatOR.Biller_FromYear,testdatamap.get("FromYear").toString());
	        selectDropdownValue_PartialText(EdaatOR.Biller_FromMonth,testdatamap.get("FromMonth").toString());
	        WebClick(" //div[@class='calendars-popup']//a[text()='"+testdatamap.get("FromDate").toString()+"']");
	        WebClick(EdaatOR.Biller_ToCalendar);
	        Thread.sleep(200);
	        selectDropdownValue_PartialText(EdaatOR.Biller_FromYear,testdatamap.get("ToYear").toString());
	        selectDropdownValue_PartialText(EdaatOR.Biller_FromMonth,testdatamap.get("ToMonth").toString());
	        WebClick(" //div[@class='calendars-popup']//a[text()='"+testdatamap.get("ToDate").toString()+"']");
	        Thread.sleep(200);
	        WebClick("//label[text()='"+testdatamap.get("ImpactOnPrice").toString()+"']");
	        WebClickUsingJS(EdaatOR.Biller_RadioBtn);
	    	
	        WebClickUsingJS(EdaatOR.Biller_AddPriceBtn);
	        
	        if(ExistsCheck(EdaatOR.Biller_Settings_PricelistArabicNameError)) {
	          Log.ReportEvent("FAIL", " Add Price List is not Successful");
	          takeScreenShot();
	          driver.quit();
	          Assert.fail();

		     }
			else if(ExistsCheck(EdaatOR.Biller_Settings_PricelistEngNameError)){
				Log.ReportEvent("FAIL", " Add Price List is not Successful");
		          takeScreenShot();
		          driver.quit();
		          Assert.fail();
			}
			else if(ExistsCheck(EdaatOR.Biller_Settings_PricelistRatioError)){
				Log.ReportEvent("FAIL", " Add Price List is not Successful");
		          takeScreenShot();
		          driver.quit();
		          Assert.fail();
			}
			else if(ExistsCheck(EdaatOR.Biller_Settings_PricelistFromDateError)){
				Log.ReportEvent("FAIL", " Add Price List is not Successful");
		          takeScreenShot();
		          driver.quit();
		          Assert.fail();
			}
			else if(ExistsCheck(EdaatOR.Biller_Settings_PricelistToDateError)){
				Log.ReportEvent("FAIL", " Add Price List is not Successful");
		          takeScreenShot();
		          driver.quit();
		          Assert.fail();
			}
			else if(ExistsCheck(EdaatOR.Biller_Settings_PricelistRoundingRadioBTNError)){
				Log.ReportEvent("FAIL", " Add Price List is not Successful");
		          takeScreenShot();
		          driver.quit();
		          Assert.fail();
			}
			
			else {

	        	Log.ReportEvent("PASS", " Add Price List is Successful");
			  }
	    	
		}
		catch(Exception e){
			Log.ReportEvent("FAIL", " Add Price List is not Successful");
	          takeScreenShot();
	          driver.quit();
	          Assert.fail();
		}
}
	//Function Summary : Method to Search Price List.
		//Parameter Summary: N/A.	
		public void verifyPricelistgridview(Log Log) throws Exception {
			try {
				
				if(ExistsCheck(EdaatOR.Biller_Pricelistgrid)) {
		        	Log.ReportEvent("PASS", "Price List Grid View verified successfully.");

				}
				else {
		        	Log.ReportEvent("FAIL", "Price List Grid View Verification failed.");
		        	this.takeScreenShot();
		        	driver.quit();
		        	Assert.fail();
				}
			}
		catch (Exception e) {
					Log.ReportEvent("FAIL", "Price List Grid View Verification failed.");
		        	this.takeScreenShot();
		        	driver.quit();
		        	Assert.fail();
				}
			}
	
		//Function Summary   : Method to Verify AddPricelistErrorMsg
		//Parameter Summary  : Expected
		public void AddPriceListErrorMessageValidation(Map<Object,Object>testdatamap,Log Log) throws Exception {
			WebClick(EdaatOR.Biller_AddPricelistbtn);
			Thread.sleep(1500);
			WebEdit(EdaatOR.Biller_Pricelistnameinarabic,testdatamap.get("Price List Name in Arabic").toString());
			Thread.sleep(1500);
			WebEdit(EdaatOR.Biller_PricelistnameinEnglish,testdatamap.get("Price List Name in English").toString());
			Thread.sleep(1500);
			ImpactOnTheBasicPrice(testdatamap);
			Thread.sleep(1500);
			WebEdit(EdaatOR.Biller_Pricelistbtn,testdatamap.get("Increase or Decrease Ratio").toString());
			Thread.sleep(1500);
			String FromDate = testdatamap.get("ValidFromDate").toString();
			Thread.sleep(1500);
			if(FromDate.equalsIgnoreCase("Valid")) {
			WebClick(EdaatOR.Biller_AddPriceFromdate);
			selectDropdownValue_PartialText(EdaatOR.Biller_AddPriceFromYear,testdatamap.get("FromYear").toString());
			Thread.sleep(1500);
	    	selectDropdownValue_PartialText(EdaatOR.Biller_AddPriceFromMonth,testdatamap.get("FromMonth").toString());
			Thread.sleep(1500);
	    	WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
			}
			String ToDate = testdatamap.get("ValidToDate").toString();
			Thread.sleep(1500);
			if(ToDate.equalsIgnoreCase("Valid")) {
	    	WebClick(EdaatOR.Biller_AddPriceTodate);
			Thread.sleep(1500);
	    	selectDropdownValue_PartialText(EdaatOR.Biller_AddPriceToyear,testdatamap.get("ToYear").toString());
			Thread.sleep(1500);
	    	selectDropdownValue_PartialText(EdaatOR.Biller_AddPriceToMonth,testdatamap.get("ToMonth").toString());
	    	WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");
			}
			String Radio= testdatamap.get("RadioButton").toString();
			if(Radio.equalsIgnoreCase("Valid")) {
	    	Rounding(testdatamap);
			}
	    	WebEdit(EdaatOR.Biller_Pricelistdescriptionbtn,testdatamap.get("Description").toString());
	    	WebClick(EdaatOR.Biller_ActiveCheckbox);
	    	WebClick(EdaatOR.Biller_AddPricelistbtn2);			try {
				if(getText(EdaatOR.Biller_Settings_PricelistArabicNameError).equals(testdatamap.get("ErrorMessage1").toString())
						||getText(EdaatOR.Biller_Settings_PricelistArabicNameError).equals(testdatamap.get("ErrorMessage2").toString())) {
			         Log.ReportEvent("PASS", "Error Message Validation for Price List Name in Arabic Text Field is Successful");			


				}
				else if(getText(EdaatOR.Biller_Settings_PricelistEngNameError).equals(testdatamap.get("ErrorMessage1").toString())
						||getText(EdaatOR.Biller_Settings_PricelistEngNameError).equals(testdatamap.get("ErrorMessage2").toString())){
			         Log.ReportEvent("PASS", "Error Message Validation for Price List Name in English Text Field is Successful");			
				}
				else if(getText(EdaatOR.Biller_Settings_PricelistRatioError).equals(testdatamap.get("ErrorMessage1").toString())
						||getText(EdaatOR.Biller_Settings_PricelistRatioError).equals(testdatamap.get("ErrorMessage2").toString())){
			         Log.ReportEvent("PASS", "Error Message Validation for Ratio Text Field is Successful");			

				}
				else if(getText(EdaatOR.Biller_Settings_PricelistFromDateError).equals(testdatamap.get("ErrorMessage1").toString())
						||getText(EdaatOR.Biller_Settings_PricelistFromDateError).equals(testdatamap.get("ErrorMessage2").toString())){
			         
			         Log.ReportEvent("PASS", "Error Message Validation for From Date Text Field is Successful");			

				}
				else if(getText(EdaatOR.Biller_Settings_PricelistToDateError).equals(testdatamap.get("ErrorMessage1").toString())
						||getText(EdaatOR.Biller_Settings_PricelistToDateError).equals(testdatamap.get("ErrorMessage2").toString())){
					
			         Log.ReportEvent("PASS", "Error Message Validation for To Date Text Field is Successful");			

				}
				else if(getText(EdaatOR.Biller_Settings_PricelistRoundingRadioBTNError).equals(testdatamap.get("ErrorMessage2").toString())){
					
			         Log.ReportEvent("PASS", "Error Message Validation for Round Up radio Button is Successful");			

					
				}
				
				else {
					
					Log.ReportEvent("FAIL", "Add Pricing List UI Error Message Validation is Unsuccessful");	
			         takeScreenShot();
			         driver.quit();
			         Assert.fail();

				  }
		
			}
			catch(Exception e){
				Log.ReportEvent("FAIL", "Add Pricing List UI Error Message Validation is Unsuccessful");	
		         takeScreenShot();
		         driver.quit();
		         Assert.fail();
			}
	}
		

	
}
