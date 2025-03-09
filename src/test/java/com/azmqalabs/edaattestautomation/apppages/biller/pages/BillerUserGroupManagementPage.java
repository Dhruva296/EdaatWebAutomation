/**
*
* Test Script Name                   : N/A
* Objective                          : Verify Group Management Functionality.
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



public class BillerUserGroupManagementPage extends BasePage
{

	public BillerUserGroupManagementPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  


	@FindBy(xpath = EdaatOR.Biller_GroupMgm_Header)
	public WebElement Header;


	public boolean Exists(){
		return super.Exists(Header); 
	}


	//Function Summary   : Method to Navigate GroupManagement
	//Parameter Summary : N/A
	public void naviagteGroupManagement(Map<Object, Object> testdatamap,Log Log) throws Exception {
		
		try {
			Thread.sleep(2000);
		WebClick(EdaatOR.Biller_UserManagement);
		WebClick(EdaatOR.Biller_GropManagment);
		waitForPageToLoad();
		
		if(ExistsCheck(EdaatOR.Biller_GroupMgm_Header)) {
    	Log.ReportEvent("PASS", "Group Management Page is Loaded Successfully");
		}
    	
		else {
			Log.ReportEvent("FAIL", "Group Management Page is not Loaded Successfully");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		
		}
		}
		catch (Exception e) {
			e.printStackTrace();
			Log.ReportEvent("FAIL", "Group Management Page is not Loaded Successfully");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();

		}
			
	}

	//Function Summary   : Method to Enter Group Name in "Group Name" Text field
	//Parameter Summary : pname

	public void EnterSearchGroupName(String pname) throws Exception {
		WebEdit(EdaatOR.Biller_GroupMgm_SearchGrpName, pname);
	}

	//Function Summary   : Method to Enter Group Code in "Group Code" Text field
	//Parameter Summary : pname
	public void EnterSearchGroupCode(String lstname) throws Exception {
		WebEdit(EdaatOR.Biller_GroupMgm_SearchCode, lstname);
	}

	//Function Summary   : Method to Click on "Search" Button
	//Parameter Summary : pname
	public void ClickOnGrouSearchBtn() throws Exception {
		WebClick(EdaatOR.Biller_GroupMgm_SearchButton);
	}
	//Function Summary   : Method to Click on Add Button
	//Parameter Summary :N/A
	public void ClickOnAddBtn() throws Exception {
		WebClick(EdaatOR.Biller_GroupMgm_AddGrpBtn);
	}

	//Function Summary   : Method to Enter Group Name In Arabic
	//Parameter Summary : pname
	public void EnterAddGroupArabic(String pname) throws Exception {
		WebEdit(EdaatOR.Biller_AddGroupMgm_ArabicName, pname);
	}
	//Function Summary   : Method to Enter Group Name In English
	//Parameter Summary : lstname
	public void EnterAddGroupEng(String lstname) throws Exception {
		WebEdit(EdaatOR.Biller_AddGroupMgm_Name, lstname);
	}

	//Function Summary   : Method to Enter Group Description
	//Parameter Summary : lstname
	public void EnterAddGroupDescription(String lstname) throws Exception {
		WebEdit(EdaatOR.Biller_AddGroupMgm_Description, lstname);
	}
	//Function Summary   : Method to Enter Group Code
	//Parameter Summary : lstname
	public void EnterAddGroupCode(String lstname) throws Exception {
		WebEdit(EdaatOR.Biller_AddGroupMgm_GroupCode, lstname);
	}

	//Function Summary   : Method to Click on "Add" Button
	//Parameter Summary : N/A
	public void ClickOnGroupAddBtn() throws Exception {
		WebClick(EdaatOR.Biller_AddGroupMgm_AddBtn);
	}

	//Function Summary   : Method to Add New Group
	//Parameter Summary : ArabicName,GroupCode,EngName

	public void addGroup(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {
		
			ClickOnAddBtn();
			waitForPageToLoad();
			Thread.sleep(1000);
			EnterAddGroupArabic(testdatamap.get("ArabicName").toString());
			EnterAddGroupEng(testdatamap.get("EngName").toString());
			EnterAddGroupDescription(testdatamap.get("Description").toString());
			EnterAddGroupCode(testdatamap.get("GroupCode").toString());
			ClickOnGroupAddBtn();
			waitForPageToLoad();
			 if (ExistsCheck(EdaatOR.Biller_GrpMgm_GrpNameEngErrorMsg)||ExistsCheck(EdaatOR.Biller_GrpMgm_GrpNameArbErrorMsg)||ExistsCheck(EdaatOR.Biller_GrpMgm_GrpCodeErrorMsg) ) {
				 Log.ReportEvent("Fail", " Add new Group is not Successful");
				 this.takeScreenShot();
				 driver.quit();
				Assert.fail();
			 }
			 
			
			 
			 else {
        	Log.ReportEvent("PASS", "Add new Group is Successful");
			Thread.sleep(1000);
        	
			 }
		}
		catch(Exception e){
		   Log.ReportEvent("Fail", " Add new Group is not Successful");
		   this.takeScreenShot();
		   driver.quit();
		   Assert.fail();

		}	   
	
	}
	
	//Function Summary   : Method to View Users Under The Group
	//Parameter Summary  : UserPopupName
	public void ViewUsers(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {
			
			WebClick(EdaatOR.Biller_GroupMgm_UsersBtn);
			Thread.sleep(20000);
			 if(getText(EdaatOR.Biller_GroupMgm_Userspopup).equals(testdatamap.get("UserPopupName").toString())) {
				 Log.ReportEvent("PASS", " View the users under this Group is Successful");
				 WebClick(EdaatOR.Userlist_close);
			 }
			 else {
				 Log.ReportEvent("FAIL", "View the users under this Group is Unsuccessful");
				 takeScreenShot();
				 driver.quit();
				 Assert.fail();
			 }
		}
		catch(Exception e){
			 Log.ReportEvent("FAIL", "View the users under this Group is Unsuccessful");
			 takeScreenShot();
			 driver.quit();
			 Assert.fail();
			
		}
          
	}
	
	
	//Function Summary   : Method to Search Group by Group Name
	//Parameter Summary : searchName

	public void searchGroupByName(String searchName) throws Exception {
		if(!searchName.equalsIgnoreCase("")) {
			EnterSearchGroupName(searchName);
		}
	}
	
	//Function Summary   :Method to Search Group by Group Code
	//Parameter Summary : GroupCode
	public void searchGroupByCode(String GroupCode) throws Exception {
		if(!GroupCode.equalsIgnoreCase("")) {
			EnterSearchGroupCode(GroupCode);
		}
	}
	//Function Summary   :Method to Search Group 
	//Parameter Summary : ArabicName,GroupCode
	public void searchGroup(Map<Object, Object> testdatamap,Log Log) throws Exception {
	
		try {
            Thread.sleep(2000);
	        searchGroupByName(testdatamap.get("EngName").toString());
            Thread.sleep(2000);
			searchGroupByCode(testdatamap.get("GroupCode").toString());
            Thread.sleep(2000);
			ClickOnGrouSearchBtn();
            Thread.sleep(5000);
			if(getText(EdaatOR.Biller_SearchGroupMgm_GrpName).equals(testdatamap.get("EngName").toString()) 
				||getText(EdaatOR.Biller_SearchGroupMgm_Code).equals(testdatamap.get("GroupCode").toString()))
			{
				Log.ReportEvent("PASS", " Search Group is Successful");
				
			}
			else {
				Log.ReportEvent("Fail", " Search Group is Unsuccessful");
				this.takeScreenShot();
				Assert.fail();

			}
				
		}
		catch(Exception e){
	     Log.ReportEvent("Fail", " Search Group is Unsuccessful");
		 this.takeScreenShot();
			Assert.fail();

		}

	}
	//Function Summary   : Method to Delete Group
	//Parameter Summary : GroupCode
	public void deleteGroup(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {
			searchGroup(testdatamap, Log);
			if(ExistsCheck(EdaatOR.Biller_SearchGroupMgm_DeleteBtn)) {
			WebClick(EdaatOR.Biller_SearchGroupMgm_DeleteBtn);
			Thread.sleep(500);
			WebClick(EdaatOR.Biller_SearchGroupMgm_YesDeleteBtn);
			Thread.sleep(1000);
			searchGroupByCode(testdatamap.get("GroupCode").toString());
			ClickOnGrouSearchBtn();
			verifyElementIsPresent(EdaatOR.Biller_SearchGroupMgm_Nodata);
        	Log.ReportEvent("PASS", "Group has been Successfully deleted.");

			}
			
			else {
				Log.ReportEvent("FAIL", "Group Deletion is Unsuccessfull.");	
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}	

		}
		catch(Exception e){
			Log.ReportEvent("FAIL", "Group Deletion is Unsuccessfull.");	
			takeScreenShot();
			driver.quit();
			Assert.fail();
			
		}

	}
	
	//Function Summary   : Method to Update Group Permission
	//Parameter Summary  : GroupPermission,GroupCode
	public void EditGroupPermission(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try {
			
			
			WebClick(EdaatOR.Biller_SearchGroupMgm_EditIcon);
			Thread.sleep(3000);
			VerifyValue1(getText(EdaatOR.Biller_SearchGroupMgm_PermissuionPOp), testdatamap.get("GroupPermission").toString());
			Thread.sleep(3000);
			WebClickUsingJS(EdaatOR.Biller_EditGroup_Receivable);
			Thread.sleep(3000);
			WebClick(EdaatOR.Biller_EditGroup_UpdateBtn);
			Thread.sleep(3000);
			searchGroupByCode(testdatamap.get("GroupCode").toString());
			ClickOnGrouSearchBtn();
			WebClick(EdaatOR.Biller_SearchGroupMgm_EditIcon);
			Thread.sleep(3000);
			if(IsSelected(EdaatOR.Biller_EditGroup_Receivable)) {
				Thread.sleep(3000);
				 WebClick(EdaatOR.Biller_EditGroup_Close);
	            Log.ReportEvent("PASS", " Edit Group Permission is Successful");
	           
			}
			else {
	            Log.ReportEvent("FAIL", " Edit Group Permission is Unsuccessfull");
	            takeScreenShot();
	            driver.quit();
	            Assert.fail();

			}
		}
		catch(Exception e){
			Log.ReportEvent("FAIL", " Edit Group Permission is Unsuccessfull");
            takeScreenShot();
            driver.quit();
            Assert.fail();
		}

	}
	
	//Function Summary   : Method to View Group Permission
		//Parameter Summary  : GroupPermission,GroupCode
		public void ViewGroupPermission(Map<Object, Object> testdatamap,Log Log) throws Exception {
			try {
				Thread.sleep(3000);
					WebClick(EdaatOR.Biller_SearchGroupMgm_ViewIcon);
					Thread.sleep(5000);
					VerifyValue1(getText(EdaatOR.Biller_SearchGroupMgm_ViewPermission), testdatamap.get("ViewGroupPermission").toString());
					Thread.sleep(3000);
					if(ExistsCheck(EdaatOR.Biller_ViewGroup_Receivable)) {
		            Log.ReportEvent("PASS", " View Group Permission is Successful");

				}
				else {
		            Log.ReportEvent("FAIL", " View Group Permission is Unsuccessfull");
		            takeScreenShot();
		            driver.quit();
		            Assert.fail();
				}
			}
			catch(Exception e){
				Log.ReportEvent("FAIL", " View Group Permission is Unsuccessfull");
	            takeScreenShot();
	            driver.quit();
	            Assert.fail();
			}

		}


	public void verifyViewGroupUnderUserList(Map<Object, Object> testdatamap) throws Exception {
		boolean listGr=false;
		try {
			List<WebElement> glist=driver.findElements(By.xpath(EdaatOR.Biller_Userlist_groups));
			for(int i=0;i<glist.size();i++) {
				int g=i+1;
				String grList=glist.get(i).getText();
				if(grList.contains(testdatamap.get("ArabicName").toString())) {
					test.log(Status.PASS,"Group Name is Available in the UserList " );
					listGr=true;
					break;
				}
			}
			if(listGr==false) {
				test.log(Status.FAIL,"Group Name is not Available in the UserList " );
			}
		}
		catch(Exception e){
			test.log(Status.FAIL,"View Group is Failed" + driver.getTitle() +" * User Group Management  FAIL * " );
			
		}

	}

	//Function Summary   : Method to Add New Group
	//Parameter Summary : ArabicName,GroupCode,EngName,Description
	public void addGroupUI(Map<Object, Object> testdatamap) throws Exception {
		try {
			ClickOnAddBtn();
			waitForPageToLoad();
			Thread.sleep(1000);
			EnterAddGroupArabic(testdatamap.get("ArabicName").toString());
			Thread.sleep(300);
			EnterAddGroupEng(testdatamap.get("EngName").toString());
			Thread.sleep(300);
			EnterAddGroupDescription(testdatamap.get("Description").toString());
			Thread.sleep(300);
			EnterAddGroupCode(testdatamap.get("GroupCode").toString());
			Thread.sleep(300);
			ClickOnGroupAddBtn();
			
		}
		catch(Exception e){
			test.log(Status.FAIL,"Add Group is Failed" + driver.getTitle() +" * User Group Management  FAIL * " );
			
		}	   
	}
	    //Function Summary   : Method to Verify AddGroupErrorMsg
	   //Parameter Summary  : Expected
		public void AddGroupErrorMsgValidation(Map<Object, Object> testdatamap,Log Log) {
			try
			{
				ClickOnAddBtn();
				waitForPageToLoad();
				Thread.sleep(1000);
				EnterAddGroupArabic(testdatamap.get("ArabicName").toString());
				Thread.sleep(300);
				EnterAddGroupEng(testdatamap.get("EngName").toString());
				Thread.sleep(300);
				EnterAddGroupDescription(testdatamap.get("Description").toString());
				Thread.sleep(300);
				EnterAddGroupCode(testdatamap.get("GroupCode").toString());
				Thread.sleep(300);
				ClickOnGroupAddBtn();
				
				if(getText(EdaatOR.Biller_GrpMgm_GrpCodeError).equals(testdatamap.get("Expected").toString()))
				{

			         Log.ReportEvent("PASS", " Error Message Validation for Group Code Text Field is Successful");			

				}
				else if (getText(EdaatOR.Biller_GrpMgm_GrpNameEngError).equals(testdatamap.get("Expected").toString())) {

			         Log.ReportEvent("PASS", " Error Message Validation for Group Name in English Text Field is Successful");			
					
				}
				else if (getText(EdaatOR.Biller_GrpMgm_GrpNameArbError).equals(testdatamap.get("Expected").toString())) {
				  
					Log.ReportEvent("PASS", " Error Message Validation for Group Name in Arabic Text Field is Successful");
				}
				else if (getText(EdaatOR.Biller_GrpMgm_GrpNameEngErrorMsg).equals(testdatamap.get("Expected").toString())) {
					
			         Log.ReportEvent("PASS", " Error Message Validation for Group Name in English Text Field is Successful");			
					
				}
	            else if (getText(EdaatOR.Biller_GrpMgm_GrpNameArbErrorMsg).equals(testdatamap.get("Expected").toString())) {
					
			         Log.ReportEvent("PASS", " Error Message Validation for Group Name in Arabic Text Field is Successful");	

				}
	            else if (getText(EdaatOR.Biller_GrpMgm_GrpCodeErrorMsg).equals(testdatamap.get("Expected").toString())) {

			         Log.ReportEvent("PASS", " Error Message Validation for Group Code Text Field is Successful");			
	            	
				}
	            else {
	            	
			         Log.ReportEvent("FAIL", " Error Message Validation for Add Group is Unsuccessful");	
			         takeScreenShot();
			         driver.quit();
			         Assert.fail();

	            }
			}
			catch (Exception e) {
				Log.ReportEvent("FAIL", " Error Message Validation for Add Group is Unsuccessful");	
		         takeScreenShot();
		         driver.quit();
		         Assert.fail();				
			}	
		}
		
		//Function Summary   : Method to Verify that the Custom reconciliation report appears in the  Group Permission
		//Parameter Summary  : GroupCode,
		public void VerifyCustomReconciliationReportAppearsIntheGroupPermission(Map<Object, Object> testdatamap,Log Log) throws Exception {
			try {
				Thread.sleep(1000);
				addGroup(testdatamap,Log);
				Thread.sleep(1000);
				searchGroup(testdatamap, Log);
				Thread.sleep(1000);
				WebClick(EdaatOR.Biller_SearchGroupMgm_EditIcon);
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Biller_Usermng_GrpPermission_Reports);
				Thread.sleep(1000);
				WebClick(EdaatOR.Biller_Usermng_GrpPermission_RecievableReports);
				Thread.sleep(1000);
				if(ExistsCheck(EdaatOR.Biller_Usermng_CustomReconciliationReport_GrpPermission)) {
					Log.ReportEvent("PASS", "Custom Reconciliation Report Successfully Appeared in the Group Permissions.");
				}
				
				else {
					Log.ReportEvent("FAIL", "Custom Reconciliation Report failed to Appear in the Group Permissions.");
					takeScreenShot();
					driver.quit();
					Assert.fail();

				}
			
			}
			catch(Exception e){
				Log.ReportEvent("FAIL", "Custom Reconciliation Report failed to Appear in the Group Permissions.");
				takeScreenShot();
				driver.quit();
				Assert.fail();				
			}

		}
	
}
