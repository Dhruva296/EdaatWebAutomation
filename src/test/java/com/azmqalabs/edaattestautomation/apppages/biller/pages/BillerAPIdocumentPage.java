/**
* Test Script Name  				 : N/A
* Objective                          : Verify API document functionality.
* Version      						 : 1.0
* Author       						 : Kathirvelu M
* Created Date 			      		 : 06/09/2023
* Last Updated on					 : N/A
* Updated By   			 			 : Radhika K R
* Pre-Conditions					 : N/A
* Epic Details						 : N/A
* User Story Details				 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.biller.pages;

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



public class BillerAPIdocumentPage extends BasePage
{

	public BillerAPIdocumentPage(WebDriver driver,ExtentTest test)
	{
		 this.driver=driver;
		 this.test=test;
		 
		 PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  
	

	@FindBy(xpath = EdaatOR.Biller_ApiDoc)
	public WebElement API;
		
	    
	    public boolean Exists(){
	    	return super.Exists(API); 
		}
//Function Summary : Method to export API document. 
//Parameter Summary: N/A
	    public void VerifyExportAPIdoc(Log Log)
	    {
	    	try {
		        WebClick(EdaatOR.Biller_ApiDocPageLink);
		        Thread.sleep(1000);
		        if(getText(EdaatOR.Biller_ApiDoc_Page).equals("API Document")) {
				  Log.ReportEvent("PASS", "'API Document' Page is Loaded Successfully");
				  if(ExistsCheck(EdaatOR.Biller_ApiDocDownload)) {
			      WebClick(EdaatOR.Biller_ApiDocDownload);
				  Log.ReportEvent("PASS", "Export 'API Document' is Successful");
				  }
				  else {
					  Log.ReportEvent("FAIL", "Export 'API Document' is not Successful");
					  takeScreenShot();
					  driver.quit();
					  Assert.fail();
					  }
		        }
		        else {
		          Log.ReportEvent("FAIL", "'API Document' Page is not Loaded Successfully");
				  takeScreenShot();
				  driver.quit();
				  Assert.fail();
		        }

			}
			catch(Exception e){
				Log.ReportEvent("FAIL", "Export 'API Document' is not Successful");
				  takeScreenShot();
				  driver.quit();
				  Assert.fail();
			}

	    	
	    	
	    }
 

}