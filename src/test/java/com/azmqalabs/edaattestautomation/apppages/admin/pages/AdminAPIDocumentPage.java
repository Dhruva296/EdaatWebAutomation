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

import java.io.IOException;
import java.util.Map;

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

public class AdminAPIDocumentPage extends BasePage {

	public AdminAPIDocumentPage(WebDriver driver, ExtentTest test) {
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
		public void APIDocument(Log Log) {
			try {
				WebClickUsingJS(EdaatOR.Admin_API_lnk);
				if (CheckElementExists(EdaatOR.Admin_API_Document)) {
					Log.ReportEvent("PASS", "'API Document' Page is Loaded Successfully");
					if (ExistsCheck(EdaatOR.Admin_API_Download)) {
						WebClickUsingJS(EdaatOR.Admin_API_Download);
						Log.ReportEvent("PASS", "API Document sheet is Downloaded Successfully");
					} else {
						Log.ReportEvent("FAIL", "API Document sheet is not Downloaded");
						this.takeScreenShot();
						driver.quit();
						Assert.fail();
					}
				} else {
					Log.ReportEvent("FAIL", "'API Document' Page is not Loaded");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			} catch (Exception e) {
				Log.ReportEvent("FAIL", "API Document sheet is not Downloaded");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}
}
