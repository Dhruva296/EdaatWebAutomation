/**
*
* Test Script Name                      : N/A.
* Objective                             : Verify biller Paid outside edaat functionality.
* Version                               : 1.0
* Author                                : Kathirvelu M
* Created Date                          : 08/05/2023
* Last Updated on                       : N/A
* Updated By                            : Radhika K R
* Pre-Conditions                        : N/A
* Manual Testcase Name                  : N/A
* Epic Details                          : N/A
* User Story Details                    : N/A
* Defects affecting this test script    : None
* Work Arounds/Known Issues             : None
**/
package com.azmqalabs.edaattestautomation.apppages.biller.pages;

import java.io.File;
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
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.azmqalabs.edaattestautomation.common.Log;


public class BillerReceivablesPaidOutsideEdaatPage extends BasePage
{

	public BillerReceivablesPaidOutsideEdaatPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  


	@FindBy(xpath = EdaatOR.Biller_PaidOutside)
	public WebElement PaidOutside;


	public boolean Exists(){
		return super.Exists(PaidOutside); 
	}


	//Function Summary   : Method to navigate on Paid Outside Edaat Page.
	//Parameter Summary :  N/A.
	public void naviagtePaidOusideEdaat(Log Log) throws InterruptedException {
		WebClickUsingJS(EdaatOR.Biller_Receivable_Link);
		WebClickUsingJS(EdaatOR.Biller_PaidOutsidePage);
		if (CheckElementExists(EdaatOR.Biller_PaidOutSideEdaat_Page)) {				
			Thread.sleep(3000);
	    	Log.ReportEvent("PASS", "Paid Out Side Edaat Page is Loaded Successfully");

	} else {
    	Log.ReportEvent("FAIL", "Paid Out Side Edaat Page is Not Loaded Successfully");
		this.takeScreenShot();
		driver.quit();
		Assert.fail();

	}		
		
	}
//Function Summary:Verify Grid View details
//Function Parameters:N/A.
	public void GridView(String table,Log Log)
	{
		try {

			Thread.sleep(5000);
			if (ExistsCheck(table))
			{
		 	    Log.ReportEvent("PASS", " View Grid Details is Loaded Successfully");
			
			}else {
		 	    Log.ReportEvent("FAIL", " View Grid Details is Not Loaded Successfully");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();


			}
		} catch (Exception e) {
	 	    Log.ReportEvent("FAIL", " View Grid Details is Not Loaded Successfully");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();

		}
	}
	
	//Function Summary   : Method to search Paid outside edaat bills
	//Parameter Summary :  BillNumber,SubBillerType,BillNumber,DocumentNo
	public void verifySearchPaidOutsideBills(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
			boolean existsElement;
			String BillNumber=testdatamap.get("BillNumber").toString();
			String SubBillerType=testdatamap.get("SubBillerType").toString();
			WebEdit(EdaatOR.Biller_BillNo, testdatamap.get("BillNumber").toString());
			WebEdit(EdaatOR.Biller_DocumentNo, testdatamap.get("DocumentNo").toString());
			WebSelect(EdaatOR.Biller_SubBillerType,SubBillerType);
			Thread.sleep(1000);
			WebClick(EdaatOR.Biller_SearchBtn);
			Thread.sleep(1000);
			existsElement=ExistsCheck("//td[text()='"+BillNumber+"']");
			Thread.sleep(1000);
			if(existsElement==true) {
				Log.ReportEvent("PASS", "Search Paid Outside Edaat Bills is Successful");

			}else {
				Log.ReportEvent("FAIL", "Search Paid Outside Edaat Bills is Unsuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();

			}
			
			}
		
		catch(Exception e){
			Log.ReportEvent("FAIL", "Search Paid Outside Edaat Bills is Unsuccessful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();

		}
	}

	

}
