/**
* Test Script Name  				 : N/A
* Objective     					 : Verify InvoicesTemplates Functionality
* Version      						 : 1.0
* Author       						 : Basavaraj Mudnur
* Created Date 			      		 : 
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

public class BillerSettingsInvoicesTemplatesPage extends BasePage {
	public BillerSettingsInvoicesTemplatesPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  


	@FindBy(xpath = EdaatOR.Biller_Settings)
	public WebElement Settings;


	public boolean Exists(){
		return super.Exists(Settings); 
	}
	
	//Function Summary   : Method to verify Invoice Template Gridview.
		//Parameter Summary  : N/A
		public void verifyInvoiceTemplateGridview(Log Log) {
			try {
				navigateToInvoicesTemplate(Log);
				Thread.sleep(1000);
				if (ExistsCheck(EdaatOR.Biller_Invoice_Templategridview)) {
					Log.ReportEvent("PASS", "Invoice Templates Grid view verified Successfully.");
				}
				else {
					Log.ReportEvent("FAIL", "Invoice Templates Grid view Verification failed.");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			}

			catch (Exception e) {
				Log.ReportEvent("FAIL", "Invoice Templates Grid view Verification failed.");
				takeScreenShot();
				driver.quit();
				Assert.fail();
				
			}
		}
		
		//Function Summary   : Method to Navigate invoice template in settings module.
		//Parameter Summary : N/A.
		public void navigateToInvoicesTemplate(Log Log) throws Exception {
			try {
			WebClickUsingJS(EdaatOR.Biller_Settings);
			Thread.sleep(200);
			WebClickUsingJS(EdaatOR.Biller_Invoice_template);
			Thread.sleep(2000);
			if(ExistsCheck(EdaatOR.Biller_Invoice_template_Page)) {
		    	Log.ReportEvent("PASS", "Invoices templates page is Loaded Successfully");
			}
			else {
		    	Log.ReportEvent("FAIL", "Invoices templates page is Loaded Successfully");
	            takeScreenShot();
	            driver.quit();
	            Assert.fail();
			}
			
		}catch(Exception e){
			Log.ReportEvent("FAIL", "Invoices templates page is Loaded Successfully");
	        takeScreenShot();
	        driver.quit();
	        Assert.fail();

		}
		}

}
