/**
* Test Script Name  				 : N/A
* Objective                          : Verify the TermsManagement Functionality.
* Version      						 : 1.0
* Author       						 : Arun Kumar MS
* Created Date 			      		 : 11/08/2023
* Last Updated on					 : N/A
* Updated By   			 			 : 
* Pre-Conditions					 : N/A
* Manual Test case Name				 : N/A
* Epic Details						 : N/A
* User Story Details				 : N/A
* Defects affecting this test script : N/A
* WorkArounds/Known Issues			 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.biller.pages;

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



public class BillerSettingProductsManagementPage extends BasePage
{

	public BillerSettingProductsManagementPage(WebDriver driver,ExtentTest test)
	{
		 this.driver=driver;
		 this.test=test;
		 
		 PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  
	

	@FindBy(xpath = EdaatOR.Biller_Termsmanagementsym)
	public WebElement TermsManagement;
		
	    
	    public boolean Exists(){
	    	return super.Exists(TermsManagement); 
		}
	    public void EnterProductInputBox(String pname) throws Exception {
			if(!pname.equalsIgnoreCase(""))
				WebEdit(EdaatOR.Biller_Product_NameInput, pname);
		}
	    public void SelectIdProductListBox(String lstname) {
			if(!lstname.equalsIgnoreCase(""))
				WebSelect1(EdaatOR.Biller_Product_SearchIDlist, lstname);
		}

		public void ClickOnSearchBtn() throws Exception {
			WebClick(EdaatOR.Biller_Product_SeachBtn);
		}
		//Function Summary   : Method to Edit Product
	    //Parameter Summary : ReferenceCode,Description,MinPrice,MaxPrice
	 	public void VerifyEditFunctionality(Map<Object,Object>testdatamap,Log Log) {
	 		
	 		try {
	 			WebClick(EdaatOR.Biller_Product_EditBtn);
	 			Thread.sleep(1000);
	 			WebEdit(EdaatOR.Biller_Invoice_TemplateEng,testdatamap.get("UpdatedName").toString());
	 			Thread.sleep(1000);
	 			WebEdit(EdaatOR.Biller_Product_MaxPrice,testdatamap.get("UpdatedMaxPrice").toString());
	 			Thread.sleep(2000);
	 			WebClick(EdaatOR.Biller_Product_SaveChangesBtn);
	 			Thread.sleep(1000);
	 			String pName=testdatamap.get("UpdatedName").toString();
				String pCate=testdatamap.get("SearchProdCateg").toString();
				EnterProductInputBox(pName);
				SelectIdProductListBox(pCate);
				Thread.sleep(2000);
				ClickOnSearchBtn();
				Thread.sleep(3000);
	 			WebClick(EdaatOR.Biller_Product_EditBtn);
	 			Thread.sleep(3000);
	 			String productName = driver.findElement(By.xpath(EdaatOR.Biller_Invoice_TemplateEng)).getAttribute("value");
	 			String Price= driver.findElement(By.xpath(EdaatOR.Biller_Product_MaxPrice)).getAttribute("value");

                if(productName.equals(testdatamap.get("UpdatedName").toString())
                	&& Price.equals(testdatamap.get("UpdatedMaxPrice").toString())) {
                	Log.ReportEvent("PASS", "Product is Edited Successfully");
                }
                else {
                	Log.ReportEvent("FAIL", "Product is not Edited Successfully");
                    takeScreenShot();
                    driver.quit();
                    Assert.fail();
                	
                }
				

	 		}
	 		catch(Exception e){
	 			Log.ReportEvent("FAIL", "Product is not Edited Successfully");
                takeScreenShot();
                driver.quit();
                Assert.fail();
	 		}	 		
	 	}
		
	 	public void SearchProduct(Map<Object,Object>testdatamap,Log Log) throws IOException, Exception {
			try {
				String pName=testdatamap.get("SearchProdName").toString();
				String pCate=testdatamap.get("SearchProdCateg").toString();
				EnterProductInputBox(pName);
				SelectIdProductListBox(pCate);
				Thread.sleep(2000);
				ClickOnSearchBtn();
				Thread.sleep(3000);

				if(getText(EdaatOR.Biller_Product_Table+"[1]/td[3]").equals(pName) ) {
					
					Log.ReportEvent("PASS", "Product Search is Successful");
				
				}
				else {
					Log.ReportEvent("FAIL", "Product Search is not Successful");
	                takeScreenShot();
	                driver.quit();
	                Assert.fail();
					
				}

			}
			catch(Exception e){
				Log.ReportEvent("FAIL", "Product Search is not Successful");
	            takeScreenShot();
	            driver.quit();
	            Assert.fail();
			}
		}
		public void AddProduct(String ProdArabic,String ProdEnglish,String Category,String BasicPrice){
			try{
				WebClickUsingJS(EdaatOR.Biller_Settings);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Biller_Product_Management);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Biller_Prod_Addbutton);
				Thread.sleep(2000);
				WebEdit(EdaatOR.Biller_Prod_NameArabic,ProdArabic);
				Thread.sleep(1000);
				WebEdit(EdaatOR.Biller_Invoice_TemplateEng,ProdEnglish);  
				Thread.sleep(1000);
				WebSelect1(EdaatOR.Biller_Invoice_Select,Category);
				Thread.sleep(1000);
				WebEdit(EdaatOR.Biller_Prod_Price,BasicPrice);  
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Biller_Invoice_Add);
				test.log(Status.PASS,"Add Product Successful" + driver.getTitle() +" * Add Product Successful PASS * " );
			}catch(Exception e){
				test.log(Status.FAIL,"Add Product Not Successful" + driver.getTitle() +" * Add Product Successful FAIL * " );
				this.takeScreenShot();
				
			}
		}
}