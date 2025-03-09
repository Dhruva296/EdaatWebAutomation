/**
*
* Test Script Name                   : N/A
* Objective                          : Verify User List Functionality
* Version                            : 1.0
* Author                             : Kathirvelu M
* Created Date                       : 01/06/2023
* Last Updated on                    : N/A
* Updated By                         : Obalanayak m s
* Pre-Conditions                     : N/A
* Manual Testcase Name               : N/A
* Epic Details                       : N/A
* User Story Details                 : N/A
* Defects affecting this test script : None
* Work Arounds/Known Issues          : None
**/
package com.azmqalabs.edaattestautomation.apppages.biller.pages;

import java.io.IOException;
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
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;



public class BillerUserMngUserListPage extends BasePage
{

	public BillerUserMngUserListPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  


	@FindBy(xpath = EdaatOR.Biller_Client)
	public WebElement Client;


	public boolean Exists(){
		return super.Exists(Client); 
	}


	//Function Summary   : Method to Navigate User Management and UserList Page
	//Parameter Summary : N/A
	public void navigateUserlistPage(Log Log) throws Exception {
		
		try {
			
		WebClickUsingJS(EdaatOR.Biller_Menu_UserManagement);
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Biller_Menu_UserList);
		Thread.sleep(2000);
		if(ExistsCheck(EdaatOR.Biller_UserList_Page)) {
    	Log.ReportEvent("PASS", " Users list Page is Loaded Successfully");
    	
		}
		else {
	    	Log.ReportEvent("FAIL", " Users list Page is not Loaded Successfully");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
		}
		catch(Exception e){
			Log.ReportEvent("FAIL", " Users list Page is not Loaded Successfully");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}

	}

	//Function Summary   : Method to Enter UserName in "Name" Text Field
	//Parameter Summary  :pname
	public void EnterUserNameBox(String pname) throws Exception {
		WebEdit(EdaatOR.Biller_UserListAdd_NameInput, pname);
	}
	//Function Summary   : Method to Enter Email in "Email" Text Field
	//Parameter Summary  :lstname
	public void EnterEmailIdBox(String lstname) throws Exception {
		WebEdit(EdaatOR.Biller_UserListAdd_EmailInput, lstname);
	}
	//Function Summary   : Method to Enter number in "PhoneNumber" Text Field
	//Parameter Summary  :lstname
	public void EnterPhoneNmBox(String lstname) throws Exception {
		WebEdit(EdaatOR.Biller_UserListAdd_PhoneInput, lstname);
	}
	//Function Summary   : Method to Select "Group" Checkbox
	//Parameter Summary  : N/A
	public void ClickOnGrouChekbox() {
		WebClickUsingJS(EdaatOR.Biller_UserListAdd_GroupCheckBox);
		WebClickUsingJS(EdaatOR.Biller_UserListAdd_GroupCheckBox2);
	}
	//Function Summary   : Method to Click on "Add" Button
	//Parameter Summary  : N/A
	public void ClickOnUserAddBtn() throws Exception {
		WebClickUsingJS(EdaatOR.Biller_UserListAdd_AddUserBtPop);
	}

	//Function Summary   : Method to name in "Name" TextField
	//Parameter Summary  :lstname
	public void EnterSearchUserName(String lstname) throws Exception {
		WebEdit(EdaatOR.Biller_UserListSearch_NameBt, lstname);
	}
	//Function Summary   : Method to Email in "Email" TextField
	//Parameter Summary  :lstname
	public void EnterSearchEmalID(String lstname) throws Exception {
		WebEdit(EdaatOR.Biller_UserListSearch_EmailBt, lstname);
	}
	//Function Summary   : Method to Click on "Search" Button
	//Parameter Summary  : N/A
	public void ClickOnUselistSearchBtn() throws Exception {
		WebClick(EdaatOR.Biller_UserListSearch_SaerchBt);
	}

	public void ClickOnDiscountDeleteBtn() throws Exception {
		WebClick(EdaatOR.Biller_Discount_DeleteBtn);
	}

	public void ClickOnDiscountConfYesBtn() throws Exception {
		WebClick(EdaatOR.Biller_Discount_YesConfBtn);
	}

	public void ClickOnUserDeleteBtn() throws Exception {
		WebClick(EdaatOR.Biller_UserList_DeleteBtn);
	}

	public void ClickOnUserConfYesBtn() throws Exception {
		WebClick(EdaatOR.Biller_UserList_YesConfBtn );
	}

	//Function Summary   : Method to Navigate Add User Page
	//Parameter Summary : N/A
	public void NavigateToAddUserPage(Log Log) throws Exception {
		try {
		WebClick(EdaatOR.Biller_UserList_AddUserBt);
		if(ExistsCheck(EdaatOR.Biller_AddUser_Page)) {
			Log.ReportEvent("PASS", "Add Users Page is Loaded Successfully");
		}
		else {
			Log.ReportEvent("FAIL", "Add Users Page is not Loaded Successfully");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Add Users Page is not Loaded Successfully");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}
	
	

	//Function Summary   : Method to Add New User
	//Parameter Summary : UserName,EmailID,PhoneNum
	public void AddUser(Map<Object,Object>testdatamap,Log Log) throws Exception {
		try {
		NavigateToAddUserPage(Log);
		Thread.sleep(1500);
		EnterUserNameBox(testdatamap.get("UserName").toString());
		Thread.sleep(500);
		EnterEmailIdBox(testdatamap.get("EmailID").toString());
		Thread.sleep(200);
		EnterPhoneNmBox(testdatamap.get("PhoneNum").toString());
		ClickOnGrouChekbox();
		Thread.sleep(2000);
		ClickOnUserAddBtn();
		
		if(ExistsCheck(EdaatOR.Biller_UserList_NameErrorMsg)||ExistsCheck(EdaatOR.Biller_UserList_EmailErrorMsg)
				||ExistsCheck(EdaatOR.Biller_UserList_EmailExistsErrorMsg)||ExistsCheck(EdaatOR.Biller_UserList_PhonenoErrorMsg)
				||ExistsCheck(EdaatOR.Biller_UserList_GroupErrorMsg)) {
			Log.ReportEvent("FAIL","User has not been Added Successfully.");
			takeScreenShot();
			driver.quit();
			Assert.fail();
			
		}
		else {
			Log.ReportEvent("PASS","User has been Added Successfully.");
		}
		Thread.sleep(2000);
		}
		catch(Exception e){
			Log.ReportEvent("FAIL","User has not been Added Successfully.");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
		
		
	}

	//Function Summary   : Method to Search Users
	//Parameter Summary  :UserName,EmailID
	public void SearchUser(Map<Object,Object>testdatamap,Log Log) throws Exception {
		try {
		EnterSearchUserName(testdatamap.get("UserName").toString());
		EnterSearchEmalID(testdatamap.get("EmailID").toString());
		Thread.sleep(1500);

		ClickOnUselistSearchBtn();
		Thread.sleep(3500);
		if(getText(EdaatOR.Biller_UserList_UserName).equals(testdatamap.get("UserName").toString())) {
			Log.ReportEvent("PASS", "User Search is Successful.");
		}
		else {
			Log.ReportEvent("FAIL", "User Search is Unsuccessful.");
            takeScreenShot();
            driver.quit();
            Assert.fail();
		}
		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "User Search is Unsuccessful.");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}

	}
	//Function Summary   : Method to verify deleted Users Functionality
	//Parameter Summary  :UserName	,DeleteUser,EmailID
	public void DeleteUser(Map<Object,Object>testdatamap,Log Log) throws Exception {
		try {
		ClickOnUserDeleteBtn();
		Thread.sleep(1500);
		VerifyValue1(getText(EdaatOR. Biller_UserList_ConfirmDeletePop), testdatamap.get("DeleteUser").toString());
		Thread.sleep(1500);
		ClickOnUserConfYesBtn();
		Thread.sleep(1500);
		EnterSearchUserName(testdatamap.get("UserName").toString());
		EnterSearchEmalID(testdatamap.get("EmailID").toString());
		ClickOnUselistSearchBtn();
		Thread.sleep(3500);
		
		 if(ExistsCheck(EdaatOR.Biller_Product_NoData)) {
			 Log.ReportEvent("PASS", "User is deleted Successfully");
		 }
		 else {
			 Log.ReportEvent("FAIL", "User deletion is Unsuccessful");
             takeScreenShot();
             driver.quit();
             Assert.fail();
		 }
		}
		catch(Exception e){
			 Log.ReportEvent("FAIL", "User deletion is Unsuccessful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
		
	}
	
	

	//Function Summary   : Method to verify deleted Users check box
	//Parameter Summary  :UserName	
	public void verifyDeleteUserCheckbox(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try{
			Thread.sleep(1500);
			WebClickUsingJS(EdaatOR.Biller_UserList_IsDeletChekckbox);
			SearchUser(testdatamap,Log);
			Thread.sleep(3500);
			if(getText(EdaatOR.Biller_UserList_UserName).equals(testdatamap.get("UserName").toString()))
			{
	        	Log.ReportEvent("PASS", "Deleted Users checkbox Verification is Successful. ");

			}
			else {
        	Log.ReportEvent("FAIL", "Deleted Users checkbox Verification is Unsuccessful.");
        	this.takeScreenShot();
        	driver.quit();
        	Assert.fail();
			}
		}
		catch(Exception e){
				 Log.ReportEvent("FAIL", "Deleted Users checkbox Verification is Unsuccessful.");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}	
	}


	//Function Summary   : Method to Add New User
	//Parameter Summary : UserName
	public void verifyAddUser(Map<Object,Object> testdatamap,Log Log) throws Exception {
	
			AddUser(testdatamap, Log);
			waitForPageToLoad();
			SearchUser(testdatamap,Log);
			verifyToggleStatus(testdatamap,Log);
	}
	
	//Function Summary   : Method to verify Toggle Status
	//Parameter Summary : N/A
   public void verifyToggleStatus(Map<Object,Object> testdatamap,Log Log) throws Exception {
		   try{
				if(ExistsCheck(EdaatOR.Biller_Userlisttoggledisable)) {
					Log.ReportEvent("PASS", "Toggle Status Verification is Successful");
					
				}
				else {
					Log.ReportEvent("FAIL", "Toggle Status Verification is Unsuccessful");
					takeScreenShot();
					driver.quit();
					Assert.fail();

				}
		   }
		   catch(Exception e){
				Log.ReportEvent("FAIL", "Toggle Status Verification is Unsuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}
	
	//Function Summary   : Method to Search User
	//Parameter Summary : UserName
	public void verifyUserNameIsClickable(Map<Object,Object> testdatamap,Log Log) throws Exception {
		try {
		
			WebClick(EdaatOR.Biller_UserList_UserName);
			switchToWindow();
			Thread.sleep(1000);
			if(WebGetTextAttribute(EdaatOR.Biller_UserListAdd_NameInput).equals(testdatamap.get("UserName").toString())
			||getText(EdaatOR.Biller_UserListAdd_EmailInput).equals(testdatamap.get("EmailID").toString())) {
				Log.ReportEvent("PASS", " Username is clickable.");
			}
			else {
				Log.ReportEvent("FAIL", " Username is not clickable.");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
        	
		}
		catch(Exception e){
			Log.ReportEvent("FAIL", " Username is not clickable.");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}
public void ClickOnEditUser(String UserName ) throws Exception {
		
		WebClick(EdaatOR.Biller_AddUser_Edit);
	}
	public void ClickOnSaveBtn() throws Exception {
		
		WebClick(EdaatOR.Biller_UserList_savebtn);
	}
	public void EnterUpdatedPhoneNmBox(String UpdatePhoneNum) {
		
		WebClearandEdit(EdaatOR.Biller_UserListAdd_PhoneInput, UpdatePhoneNum);
	}
	public void UpdateDetails(Map<Object, Object> testdatamap) throws Exception {
		
		EnterUserNameBox(testdatamap.get("UserNameUpdate").toString());
		Thread.sleep(1000);
		EnterUpdatedPhoneNmBox(testdatamap.get("UpdatePhoneNum").toString());
		Thread.sleep(1000);
		ClickOnSaveBtn();
	}
	

	public void verifyEditUser(Map<Object, Object> testdatamap,Log Log){
		try {
			AddUser(testdatamap,Log);
			Thread.sleep(2000);
			SearchUser(testdatamap,Log);
			Thread.sleep(4000);
			ClickOnEditUser(testdatamap.get("UserName").toString());
			switchToWindow();
			UpdateDetails(testdatamap);
			EnterSearchUserName(testdatamap.get("UserNameUpdate").toString());
			EnterSearchEmalID(testdatamap.get("EmailID").toString());
			ClickOnUselistSearchBtn();
			Thread.sleep(1500);
			if(getText("//a/span[text()='"+testdatamap.get("UserNameUpdate").toString()+"']")
					.equals(testdatamap.get("UserNameUpdate").toString())){
				Log.ReportEvent("PASS", "User Details Edit is Successful");
			}
			else {
				Log.ReportEvent("FAIL", "User Details Edit is Unsuccessful");
				takeScreenShot();
				driver.quit();
				Assert.fail();

			}
			
		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "User Details Edit is Unsuccessful");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		
		}	
	}

//Function Summary  : Method to verifyAddUserErrorMsg

	//Parameter Summary : Expected

	public void verifyAddUserErrorMsg(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try
		{
			String Group = testdatamap.get("GroupClick").toString();
			NavigateToAddUserPage(Log);
			Thread.sleep(1500);
			EnterUserNameBox(testdatamap.get("UserName").toString());
			Thread.sleep(500);
			EnterEmailIdBox(testdatamap.get("EmailID").toString());
			Thread.sleep(200);
			EnterPhoneNmBox(testdatamap.get("PhoneNum").toString());
			if(Group.equalsIgnoreCase("Yes"))
			{
				WebClickUsingJS(EdaatOR.Admin_UserListAdd_GroupCheckBox);
			}
			Thread.sleep(1500);
			ClickOnUserAddBtn();
			Thread.sleep(1000);
			
		if(getText(EdaatOR.Biller_UserList_NameErrorMsg).equals(testdatamap.get("Expected").toString()))
		{
	         Log.ReportEvent("PASS", " Error Message Validation for Name Text Field is Successful");			

		}
				
		else if (getText(EdaatOR.Biller_UserList_EmailErrorMsg).equals(testdatamap.get("Expected").toString())) {

	         Log.ReportEvent("PASS", " Error Message Validation for Email Text Field is Successful");			
	
		}
		else if (getText(EdaatOR.Biller_UserList_EmailExistsErrorMsg).equals(testdatamap.get("Expected").toString()))
		{	
	         Log.ReportEvent("PASS", " Error Message Validation for Email Text Field is Successful");			

		}

		else if (ExistsCheck(EdaatOR.Biller_UserList_GroupErrorMsg))
		{
			scrollToElementCenter(driver, driver.findElement(By.xpath(EdaatOR.Biller_UserList_GroupErrorMsg)));
			getText(EdaatOR.Biller_UserList_GroupErrorMsg).equals(testdatamap.get("Expected").toString());
	         Log.ReportEvent("PASS", " Error Message Validation for Groups Checkbox is Successful");			

		}
		else
		{
	         Log.ReportEvent("PASS", " Error Message Validation for Add User is Successful");
	         takeScreenShot();
	         driver.quit();
	         Assert.fail();

		}
		}

		catch (Exception e) {
			Log.ReportEvent("PASS", " Error Message Validation for Add User is Successful");
	         takeScreenShot();
	         driver.quit();
	         Assert.fail();			
		}

	}
	
}


