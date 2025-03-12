/**
*
* Test Script Name                   : N/A
* Objective                          : Corporate client functionality.
* Version                            : 1.0
* Author                             : Kathirvelu M
* Created Date                       : 23/05/2023
* Last Updated on                    : N/A
* Updated By                         : Radhika K R
* Pre-Conditions                     : N/A
* Epic Details                       : N/A
* User Story Details                 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;



public class AdminMyAccountPage extends BasePage
{

	public AdminMyAccountPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  


	@FindBy(xpath = EdaatOR.Biller_Corporate)
	public WebElement Client;


	public boolean Exists(){
		return super.Exists(Client); 
	}
	//Function Summary   : Method to  Navigate My Account Page
	//Parameter Summary  : N/A
	public void NavigatetoMyAccountPage(Log log) throws InterruptedException {
	try {
		WebClickUsingJS(EdaatOR.Admin_MyAccount_Menu);
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Admin_MyAccount_NotificationSettings);
		Thread.sleep(1000);
		if(CheckElementExists(EdaatOR.Admin_Notification_Header)) {
			log.ReportEvent("Pass", "Navigate to Notification Setting Page is successful");
		}
		else {
			log.ReportEvent("Fail", "Failed to Navigate Notification setting page");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
		}
		catch(Exception e) {
			log.ReportEvent("Fail", "Failed to Navigate Notification setting page");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}
		//Function Summary   : Method to Verify Notification Settings Send Email Toggle
		//Parameter Summary  : N/A
		public void  VerifySendEmailtoggle(Log Log)
		{
			try{
				WebClickUsingJS(EdaatOR.Admin_MyAccount_Menu);
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Admin_MyAccount_NotificationSettings);
				Thread.sleep(1000);
				if(IsDispalyed(EdaatOR.Admin_NotificationHeader)) {
				 	Log.ReportEvent("PASS", "'Notification Settings' Page is Loaded Sucessfully");
				}
				else
				{
					Log.ReportEvent("FAIL", "'Notification Settings' Page  is not Loaded");
	        		this.takeScreenShot();
	        		driver.quit();
	        		Assert.fail();
				}
				if(CheckElementExists(EdaatOR.Admin_MyAccount_SendEmailToggelBTN))
				{
				 	WebClickUsingJS(EdaatOR.Admin_MyAccount_SendEmailToggelBTN);
					Thread.sleep(1000);
				 	WebClickUsingJS(EdaatOR.Admin_MyAcc_SendEmailToggelConfirmCancelActivation);
					Thread.sleep(2000);
					WebClickUsingJS(EdaatOR.Admin_MyAccount_SendEmailToggelBTN);
					Thread.sleep(1000);
					WebClickUsingJS(EdaatOR.Admin_MyAcc_SendEmailToggelConfirmCancelActivation);
					Thread.sleep(2000);
	    			Log.ReportEvent("PASS", "Send Email Toggle Activate/Deactivate is Successful");
	    		}
	    		else {
	    			Log.ReportEvent("FAIL", "Send Email Toggle Activate/Deactivate is not Successful");
	        		this.takeScreenShot();
	        		driver.quit();
	        		Assert.fail();
	    			}
				}
				catch(Exception e){
					Log.ReportEvent("FAIL", "Send Email Toggle Activate/Deactivate is not Successful");
	        		this.takeScreenShot();
	        		driver.quit();
	        		Assert.fail();
				}
		}
	
	// Function Summary   : Method to verify and toggle the push notification settings (enable/disable)
	// Parameter Summary  : N/A
	public void togglePushNotification(Map<Object, Object> testdatamap, Log Log) {
	    try {
	        NavigatetoMyAccountPage(Log);

	        boolean isToggleEnabled = getElement(EdaatOR.Admin_MyAccount_PushNotificationstoggelBTN).isSelected();

	        toggleAndVerifyPushNotification(!isToggleEnabled, Log); 
	        toggleAndVerifyPushNotification(isToggleEnabled, Log); 

	    } catch (Exception e) {
	        Log.ReportEvent("Fail", "Push Notification Verification is Unsuccessful");
	        takeScreenShot();
	        driver.quit();
	        Assert.fail();
	    }
	}
	
	// Function Summary   : Method to toggle the push notification state (enable/disable) and verify the result
	// Parameter Summary  :expectedState (boolean) : The desired state for the push notification toggle (true for enabled, false for disabled)
	private void toggleAndVerifyPushNotification(boolean expectedState, Log Log) {
	    try {
	        WebClickUsingJS(EdaatOR.Admin_MyAccount_PushNotificationstoggelBTN);
	        Thread.sleep(1000);
	        WebClickUsingJS(EdaatOR.Admin_MyAcc_SendEmailToggelConfirmCancelActivation);
	        Thread.sleep(1000);
	        
	        boolean isToggled = getElement(EdaatOR.Admin_MyAccount_PushNotificationstoggelBTN).isSelected();

	        if (isToggled == expectedState) {
	            Log.ReportEvent("Pass", expectedState ? "Push Notification Activation Verification is Successful" : "Push Notification Deactivation Verification is Successful");
	        } else {
	            Log.ReportEvent("Fail", expectedState ? "Activate Push Notification Toggle is Unsuccessful." : "Deactivate Push Notification Toggle is Unsuccessful.");
	            takeScreenShot();
	            driver.quit();
	            Assert.fail();
	        }

	    } catch (Exception e) {
	        Log.ReportEvent("Fail", "Failed to verify the push notification state.");
	        takeScreenShot();
	        driver.quit();
	        Assert.fail();
	    }
	}


	//Function Summary   : Method to Verify Notification Settings Send SMS  Toggle
	//Parameter Summary  : N/A
			public void  VerifySendSMStoggle(Log Log)
			{
				try{
					WebClickUsingJS(EdaatOR.Admin_MyAccount_Menu);
					Thread.sleep(1000);
					WebClickUsingJS(EdaatOR.Admin_MyAccount_NotificationSettings);
					Thread.sleep(1000);
					if(CheckElementExists(EdaatOR.Admin_NotificationHeader))
					{
					 	Log.ReportEvent("PASS", "'Notification Settings' page is Loaded Successfully");
					}
					else {
						Log.ReportEvent("FAIL", "'Notification Settings' page is not Loaded");
		        		this.takeScreenShot();
		        		driver.quit();
		        		Assert.fail();
					}
						if(CheckElementExists(EdaatOR.Admin_MyAcc_SendSMSToggle))
						{
					WebClickUsingJS(EdaatOR.Admin_MyAcc_SendSMSToggle);
					Thread.sleep(1000);
					WebClickUsingJS(EdaatOR.Admin_MyAcc_SendEmailToggelConfirmCancelActivation);
					Thread.sleep(2000);
					WebClickUsingJS(EdaatOR.Admin_MyAcc_SendSMSToggle);
					Thread.sleep(1000);
					WebClickUsingJS(EdaatOR.Admin_MyAcc_SendEmailToggelConfirmCancelActivation);
					Thread.sleep(2000);
			        Log.ReportEvent("PASS", "Send SMS Toggle Activate/Deactivate is Successful");
						}
					else {
						Log.ReportEvent("FAIL", "Send SMS Toggle Activate/Deactivate is not Successful");
		        		this.takeScreenShot();
		        		driver.quit();
		        		Assert.fail();
						
					}
					
				}
				catch(Exception e){
						Log.ReportEvent("FAIL", "Send SMS Toggle Activate/Deactivate is not Successful");
		        		this.takeScreenShot();
		        		driver.quit();
		        		Assert.fail();				
		        		}
			}
	}
