/**
* Test Script Name                   : NA
* TestData Sheet Name                : NA
* Objective                          : Wathiq Integration Functionality.
* Version                            : 1.0
* Author                             : Kathirvelu M
* Created Date                       : 14/06/2023
* Last Updated on                    : N/A
* Updated By                         : Kalpana I R
* Pre-Conditions                     : NA
* Epic Details                       : N/A
* User Story Details                 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;

public class AdminSettingsContentManagementPage extends BasePage {

	public AdminSettingsContentManagementPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.Admin_API_Document)
	public WebElement Admin_API_Document;


	public boolean Exists(){
		return super.Exists(Admin_API_Document); 
	}

   //Function summary:Verify to API Document
   //Parameter summary: NA
	public void NavigatetoSettingsContentManagement(Log Log) throws Exception
	{
		WebClick(EdaatOR.Admin_settings);
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Admin_settings_Contentmgm);
		if(CheckElementExists(EdaatOR.Admin_settings_ContentMgm_Page)) {
			Log.ReportEvent("PASS", "Content Management page is Loaded Successfully");
			}
			else{
				Log.ReportEvent("FAIL", "Content Management page is not Loaded Successfully");
				this.takeScreenShot();
				driver.quit();Assert.fail();
			}

	}
	//Function summary:Verify to upload bulk data
	//Parameter summary: NA	
	public void  getAutoItImagePathFile() throws Exception {
		File classpathRoot = new File(System.getProperty("user.dir"));
		Thread.sleep(800);
		File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//AdminSettingsContentManagement.exe");
		String sFilename = app.toString();
		Thread.sleep(1000);
		Runtime.getRuntime().exec(sFilename);
		Thread.sleep(800);
	}
	//Function Summary  : Method to VerifyToUploadBulkData
    //Parameter Summary : N/A
	public void VerifyToUploadBulkData(Map<Object, Object> testdatamap,Log Log)
	{
		try {
			WebClickUsingActions(EdaatOR.Admin_settings_ContentAttach);
			Thread.sleep(1500);
			getAutoItImagePathFile();
			WebClickUsingJS(EdaatOR.Admin_settings_ContentAttach_process);
			verifyElementIsPresent(EdaatOR.Admin_settings_ContentAttach_verify);
			Thread.sleep(2000);		
			WebClickUsingJS(EdaatOR.Admin_Client);
			Thread.sleep(500);		
			WebClickUsingJS(EdaatOR.Admin_Add_Individualclient);
			Thread.sleep(2000);
			WebEdit(EdaatOR.Admin_IN_nationalID,testdatamap.get("NationalID").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_ClientRef_Number,testdatamap.get("ClientReferenceNumber").toString());
        	Thread.sleep(1000);
        	WebClick(EdaatOR.Admin_ClientSearch_button);
        	Thread.sleep(10000);
        	if(getText(EdaatOR.Admin_SettingContentMngVerifyNationalid).equals(testdatamap.get("NationalID").toString())) {
            	VerifyValue1(getText(EdaatOR.Admin_SettingContentMngVerifyRefnoid),testdatamap.get("ClientReferenceNumber").toString());
    			Log.ReportEvent("PASS", "Upload bulk data is Successful");
        	}
			else{
				Log.ReportEvent("FAIL", "Upload bulk data is not Successful");
				this.takeScreenShot();
				driver.quit();Assert.fail();
			}
		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Upload bulk data is not Successful");
			this.takeScreenShot();
			driver.quit();Assert.fail();
		}
	
}
	
	
	//Function Summary  : method to verify Error messages in Content Management page
	//Parameter Summary : ExpectedResult
	public void VerifyContentMgmErrorMsg(Map<Object,Object>testdatamap,Log Log) throws InterruptedException{
		{
			try {
				
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Admin_settings_ContentAttach_process);
				
				if (testdatamap.get("ExpectedResult").toString().equals (getText(EdaatOR.Admin_settings_ContentAttachErrorMsg))){	
					Log.ReportEvent("PASS", "Verify Content Management error Message is successful");

				}
				else {
					Log.ReportEvent("FAIL", "Verify Content Management error Message is not successful");
					this.takeScreenShot();
					driver.quit();Assert.fail();
				}

			} catch (Exception e) {
				Log.ReportEvent("FAIL", "Verify Content Management error Message is not successful");
				this.takeScreenShot();
				driver.quit();Assert.fail();			}

		}
	}			

}
