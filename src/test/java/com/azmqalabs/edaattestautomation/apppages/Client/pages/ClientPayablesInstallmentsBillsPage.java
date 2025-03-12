package com.azmqalabs.edaattestautomation.apppages.Client.pages;

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
import com.azmqalabs.edaattestautomation.common.ReadData;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.codoid.products.fillo.Recordset;
import com.azmqalabs.edaattestautomation.common.Log;

public class ClientPayablesInstallmentsBillsPage extends BasePage {

	public ClientPayablesInstallmentsBillsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.Client_Payables_InstallmentsPage_verify)
	public WebElement Installments;

	public boolean Exists() {
		return super.Exists(Installments);
	}
	public void InstallmentBillSearch(Map<Object, Object> testdatamap,Log Log) throws IOException
	{
		try {
		WebEdit(EdaatOR.Client_Payables_Installments_Contractnum,testdatamap.get("Contract Number").toString());
		WebEdit(EdaatOR.Client_Payables_Installments_billername,testdatamap.get("Biller Name").toString());
		WebClickUsingJS(EdaatOR.Client_Payables_Installments_Search);
		if(getText(EdaatOR.Client_Payables_Installments_Contract_Verify).equals(testdatamap.get("Contract Number").toString()))
		{
		    Log.ReportEvent("PASS", "Search Installment Bill is Successful");	        

		}else {
		    Log.ReportEvent("FAIL", "Search Installment Bill is Unsuccessful");	        
		    this.takeScreenShot();
            driver.quit();
            Assert.fail();

		}

	
		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Search Installment Bill is Unsuccessful");	        
		    this.takeScreenShot();
            driver.quit();
            Assert.fail();
		}
	}
		public void InstallmentBillSContractclick(Map<Object, Object> testdatamap,Log Log) throws IOException
	{
		try {
	    InstallmentBillSearch(testdatamap, Log);
	    WebClick(EdaatOR.Client_Payables_Installments_Contract_Click);
	    Thread.sleep(3000);
	    switchTonextwindow();
	    if(CheckElementExists("//label[text()='"+testdatamap.get("Contract Number").toString()+"']"))
	    {

	    Thread.sleep(3000);
	    switchToDefault();
    	Log.ReportEvent("PASS", "Click Contract Number is Successful");
		}
	    else {
	    	Log.ReportEvent("FAIL", "Click Contract Number is Unsuccessful");
			this.takeScreenShot();
            driver.quit();
            Assert.fail();

	    }
		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Click Contract Number is Unsuccessful");
			this.takeScreenShot();
            driver.quit();
            Assert.fail();
		}
		}
	
	public void VerifyInstallmentgridView(Log Log)
	{
		try
		{
			Thread.sleep(2000);
			if(CheckElementExists(EdaatOR.ClientsPayables_InstallmentsGrid)==true)
			{
		 	Log.ReportEvent("PASS", "  Grid View Details on Installment Bills is Successful");

			}
			else
			{
			 	Log.ReportEvent("FAIL", "  Grid View Details on Installment Bills is Unsuccessful");
				this.takeScreenShot();
                driver.quit();
                Assert.fail();

			}

		}
		catch (Exception e) {			
		 	Log.ReportEvent("FAIL", "  Grid View Details on Installment Bills is Unsuccessful");
			this.takeScreenShot();
            driver.quit();
            Assert.fail();
		}
	}
	//Function Summary :Method to Navigate Payables Installment bills
	//Parameter Summary: N/A.	
public void NavigatetoPayablesInstallmentPage(Log Log) throws InterruptedException
{
	WebClickUsingJS(EdaatOR.Client_Payables_InstallmentsPage_lnk);    
    Thread.sleep(2000);
    if(CheckElementExists(EdaatOR.Client_Payables_InstallmentsPage_verify))
    {
        Log.ReportEvent("PASS", " Installment Page is Loaded Successfully");

    }else {
        Log.ReportEvent("FAIL", " Installment Page is Not Loaded Successfully");
		this.takeScreenShot();
        driver.quit();
		Assert.fail();


    }

}
}


