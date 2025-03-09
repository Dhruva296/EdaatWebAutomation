/**
*
* Test Script Name                   : N/A
* Objective                          : Admin Login functionality
* Version                            : 1.0
* Author                             : Kathirvelu M
* Created Date                       : 23/05/2023
* Last Updated on                    : N/A
* Updated By                         : Kalpana I R
* Pre-Conditions                     : Admin login credentials
* Manual Testcase Name               : N/A
* Epic Details                       : N/A
* User Story Details                 : N/A
* Defects affecting this test script : None
* Work Arounds/Known Issues          : None
**/
package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.util.Map;

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
import com.azmqalabs.edaattestautomation.common.ReadData;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.codoid.products.fillo.Recordset;

public class AdminLoginPage extends BasePage {

	public AdminLoginPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.LoginPage_Username)
	public WebElement Username;

	public boolean Exists() {
		return super.Exists(Username);
	}
		//Function Summary  : To check Homepage is displayed
	//Parameter Summary : N/A
	public void ExistsCheckElement(String Main, Log Log) throws InterruptedException {
		Thread.sleep(1000);
		boolean Header;
		try {
			Header = ExistsCheck(Main);
			
			if (Header) {
	        	Log.ReportEvent("PASS", " Main Page Is Displayed Successfully");	

			} else {
	        	Log.ReportEvent("FAIL", "Main Page Is Not Displayed Successfully");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Main Page Is Not Displayed Successfully");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	//LOGIN TO APPLICATION WITH GLOBAL LOGIN USER ID FROM LOGIN PAGE
	public void LoginToApplication(){
		try {
			
			this.Exists();
			if (IsDispalyed(EdaatOR.LoginPage_Username)) {
				WebEdit(EdaatOR.LoginPage_Username,  GlobalConstant.GLOBALTESTDATALOGINMAP.get("LoginUserName"));
				Thread.sleep(2000);
				WebEdit(EdaatOR.LoginPage_Password,  GlobalConstant.GLOBALTESTDATALOGINMAP.get("LoginPassword"));
				Thread.sleep(2000);
				this.takeScreenShot();
				WebClick(EdaatOR.LoginPage_LogIn);
				Thread.sleep(2000);
			} else {
				WebEdit(EdaatOR.LoginPage_Username, GlobalConstant.GLOBALTESTDATALOGINMAP.get("LoginUserName"));
				WebClick(EdaatOR.LoginPage_LogIn);

			}
		} catch (Exception e) {
			this.takeScreenShot();
		}
	}

	//LOGIN TO APPLICATION WITH INDIVIDUAL TESTDATA SHEET(SAME SHEET - CALL THIS METHOD IF USER WANTS PASS USER ID FROM THE SAME SHEET)
	public void LoginToApplication(String username, String password) {
		try {
			this.Exists();
			if (IsDispalyed(EdaatOR.LoginPage_Username)) {
				WebEdit(EdaatOR.LoginPage_Username, username);
				Thread.sleep(2000);
				WebEdit(EdaatOR.LoginPage_Password, password);
				Thread.sleep(2000);
				this.takeScreenShot();
				WebClick(EdaatOR.LoginPage_LogIn);
			} else {
				WebEdit(EdaatOR.LoginPage_Username, GlobalConstant.GLOBALTESTDATALOGINMAP.get("LoginUserName"));
				WebClick(EdaatOR.LoginPage_LogIn);

			}

		} catch (Exception e) {
			this.takeScreenShot();
		}
	}
	public void loginToApplication(String Username) {
		try {
			if (Username.equalsIgnoreCase("")) {
				Username = GlobalConstant.GLOBALTESTDATALOGINMAP.get("LoginUserName").toString();
			}

			WebEdit(EdaatOR.LoginPage_Username, Username);
			WebEdit(EdaatOR.LoginPage_Password, GlobalConstant.GLOBALTESTDATALOGINMAP.get("LoginPassword").toString());
			WebClick(EdaatOR.LoginPage_LogIn);

		} catch (Exception e) {
			throw new NoSuchElementException("loginToApplication - Login Failed");
		}

	}
	//Function Summary   : Method to validate invalid admin login
	//Parameter Summary  : N/A
	public void InvalidAdminlogin(Map<Object,Object> testdatamap,Log Log){
		try {
			Recordset login=ReadData.readTestDataBySpecifiedValue("Login", "LoginCategory", testdatamap.get("LoginCategory").toString());
			login.next();
			this.Exists();
			if (IsDispalyed(EdaatOR.LoginPage_Username)) {
				WebEdit(EdaatOR.LoginPage_Username,  login.getField("LoginUserName"));
				Thread.sleep(2000);
				WebEdit(EdaatOR.LoginPage_Password,  login.getField("LoginPassword"));
				Thread.sleep(2000);
				WebClick(EdaatOR.LoginPage_LogIn);
				Thread.sleep(2000);
				verifyElementIsPresent(EdaatOR.LoginPage_Invalid_LogIn);
	        	Log.ReportEvent("PASS", "Invalid Admin Login Verification Is Successful");
			} else {
				Log.ReportEvent("FAIL", "Invalid Admin Login Verification Is Unsuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();

			}

		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Invalid Admin Login Verification Is Unsuccessful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}
	
	public void Wait() throws Exception {
		int i = 0;
		while (i < 10) {
			SetExecutionDelay();
			i = i + 1;
		}
	}
	//Function Summary   : Method to  Logout
	//Parameter Summary  : N/A
	public void Logout(String logout,Log Log) {
		try {
			Thread.sleep(2000);
			WebClickUsingJS(logout);
        	//Log.ReportEvent("PASS", " Logout  Successful");
		} catch (Exception e) {
			//Log.ReportEvent("FAIL", " Logout  UnSuccessful");
			this.takeScreenShot();
			
		}
	}
	
	public void ForgetPassword(String forGet,String Username) {
		try {
			WebClickUsingJS(forGet);
			WebEdit(EdaatOR.LoginPage_Username, Username);
			WebClickUsingJS(EdaatOR.LoginPage_send);
			this.takeScreenShot();
		} catch (Exception e) {
			this.takeScreenShot();
			throw new NoSuchElementException("ForgetPassword - ForgetPassword Failed");

		}
	}
		//Function Summary   : Method to clickOnBillerLogin
	//Parameter Summary  : N/A
	public void clickOnBillerLogin() throws InterruptedException {
		WebClickUsingJS(EdaatOR.Biller_Link);
		waitForPageToLoad();
		Thread.sleep(1000);
	}
		//Function Summary   : Method to Login to the application
	//Parameter Summary  : LoginUserName,LoginPassword
	public void LoginToApplication(Map<Object,Object> testdatamap,Log Log){
		try {
			Recordset login=ReadData.readTestDataBySpecifiedValue("Login", "LoginCategory", testdatamap.get("LoginCategory").toString());
			login.next();
			this.Exists();
			if (IsDispalyed(EdaatOR.LoginPage_Username)) {
				WebEdit(EdaatOR.LoginPage_Username,  login.getField("LoginUserName"));
				Thread.sleep(2000);
				WebEdit(EdaatOR.LoginPage_Password,  login.getField("LoginPassword"));
				Thread.sleep(2000);
				WebClick(EdaatOR.LoginPage_LogIn);
				Thread.sleep(2000);
			} else {
				WebEdit(EdaatOR.LoginPage_Username, login.getField("LoginUserName"));
				WebClick(EdaatOR.LoginPage_LogIn);

			}
			Log.ReportEvent("PASS", "Admin Login Is Successful");

		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Admin Login Is Unsuccessful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}
		//Function Summary   : Method to VerifyForgotPassword
	//Parameter Summary : UserName
	public void VerifyForgotPassword(Map<Object, Object> testdatamap,Log Log) {
		
		try {
			NavigateToForgotPasswordPage(Log);
			WebEdit(EdaatOR.Admin_Username_efield,testdatamap.get("UserName").toString());
			Thread.sleep(2000);
			WebClick(EdaatOR.Admin_Username_sendbtn);
			Thread.sleep(1000);
			if(CheckElementExists(EdaatOR.Admin_Username_confirm_verify)==true)
			{
	       	Log.ReportEvent("PASS", "Forgot Password Functionality is Successful");
	       	Thread.sleep(1000);
			WebClick(EdaatOR.Admin_Username_close);
			}
			else
			{
		       	Log.ReportEvent("FAIL", "Forgot Password Functionality is UnSuccessful");
		       	this.takeScreenShot();
		       	driver.quit();
		       	Assert.fail();
			}
			}

		catch (Exception e) {
			Log.ReportEvent("FAIL", "Forgot Password Page Is Not Loaded Successfully");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

//Function Summary   : Method to verify links in the footer page.
    //Parameter Summary : NA.
	public void footerlinks(Log Log)
	{
		try
		{
			AboutUs(Log);
			Services(Log);
			Information( Log);
		}
		catch (Exception e) {
			
			Log.ReportEvent("FAIL", "Footer Links Functionality Is Unsuccessful");
	       	this.takeScreenShot();
	       	driver.quit();
	       	Assert.fail();		
		}
	}
	
	//Function Summary   : Method to verify links in the footer page.
    //Parameter Summary : NA.
	public void AboutUs(Log Log) throws InterruptedException
	{
		AboutEdaat(Log);
		Thread.sleep(1000);
		Ourservices(Log);
		Thread.sleep(1000);
		OursClients(Log);
		Thread.sleep(1000);
		Fintech(Log);
		
	}
	//Function Summary   : Method to verify links in the footer page.
    //Parameter Summary : NA.
	public void Services(Log Log) throws Exception{
		BillerEnquiry(Log);
		Thread.sleep(1000);
		driver.navigate().back();
		ClientRegister(Log);
		Thread.sleep(1000);
		BillerRegister(Log);
	}
	//Function Summary   : Method to verify links in the footer page.
    //Parameter Summary : NA.
	public void Information(Log Log) throws InterruptedException {
		ContactUS(Log);
		Thread.sleep(1000);
		FAQ(Log);
		Thread.sleep(1000);
		Terms(Log);
		Thread.sleep(1000);
		Privacy(Log);
		
     }
	//Function Summary   : Method to verify About Edaat links in the footer page.
    //Parameter Summary : NA.
	public void AboutEdaat(Log Log)
	{
		try {
	          WebClickUsingJS(EdaatOR.Biller_About_Edaat);
	          switchToWindow();
	  		  Thread.sleep(1000);
	  		  if(IsDispalyed(EdaatOR.Biller_About_verify)) {
			  Log.ReportEvent("PASS", "About Edaat Link In The Footer Page Is Displayed Successfully");
			  driver.navigate().back();
	  		  }
	  		  else {
				  Log.ReportEvent("FAIL", "About EdaatLink In The Footer Page Is Not Displayed");
	  			 this.takeScreenShot(); 
	  			 driver.quit();
	  			 Assert.fail();
	  		  }
		    }
		catch (Exception e) {
			  Log.ReportEvent("FAIL", "About Link In The Footer Page Is Not Displayed");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}
	//Function Summary   : Method to verify Ourservices link in the footer page.
    //Parameter Summary : NA.

	public void Ourservices(Log Log)
	{
		try {
	          WebClickUsingJS(EdaatOR.Biller_OurService);
	          switchToWindow();
	  		 Thread.sleep(1000);
	  		 if(IsDispalyed(EdaatOR.Biller_OurService_verif)) {
			  Log.ReportEvent("PASS", "Ourservices Link In The Footer Page Is Displayed Successfully");
			  driver.navigate().back();
	  		 }
	  		 else {
	  			Log.ReportEvent("FAIL", "Ourservices Link In The Footer Page Is Not Displayed");
	  			this.takeScreenShot();
	  			driver.quit();
	  			Assert.fail();
		}
		}
		catch (Exception e) {
  			Log.ReportEvent("FAIL", "Ourservices Link In The Footer Page Is Not Displayed");
  			this.takeScreenShot();
  			driver.quit();
  			Assert.fail();
		}
	}
	
	//Function Summary   : Method to verify Fintech link in the footer page.
    //Parameter Summary : NA.
	public void Fintech(Log Log)
	{
		try {
	          WebClickUsingJS(EdaatOR.Biller_fintech);
	          switchToWindow();
	          if(IsDispalyed(EdaatOR.Biller_fintech_verif)) {
	          Log.ReportEvent("PASS", "Fintech Link In The Footer Page Is Displayed Successfully");
			  driver.navigate().back();
		    }
	          else {
		          Log.ReportEvent("FAIL", "Fintech Link In The Footer Page Is Not Displayed");
		          this.takeScreenShot();
		          driver.quit();
		          Assert.fail();
		    	}
		    }
		catch (Exception e) {
	          Log.ReportEvent("FAIL", "Fintech Link In The Footer Page Is Not Displayed");
	          this.takeScreenShot();
	          driver.quit();
	          Assert.fail();
		}
	}
	//Function Summary   : Method to verify OursClients link in the footer page.
    //Parameter Summary : NA.
	public void OursClients(Log Log)
	{
		try {
	          WebClickUsingJS(EdaatOR.Biller_OurClient);
	          switchToWindow();
	  		 Thread.sleep(1000);
	  		if(IsDispalyed(EdaatOR.Biller_OurClient_verif)) {
			  Log.ReportEvent("PASS", "OurClients Link In The Footer Page Is Displayed Successfully");
			  driver.navigate().back();
		    }
	  		else {
				  Log.ReportEvent("FAIL", "OurClients Link In The Footer Page Is Not Displayed");
				  this.takeScreenShot();
				  driver.quit();
				  Assert.fail();
	  			}
	  		}
		catch (Exception e) {
			  Log.ReportEvent("FAIL", "OurClients Link In The Footer Page Is Not Displayed");
			  this.takeScreenShot();
			  driver.quit();
			  Assert.fail();
		}
	}
	
	//Function Summary   : Method to verify BillerEnquiry link in the footer page.
    //Parameter Summary : NA.
	public void BillerEnquiry(Log Log)
	{
		try {
	          WebClickUsingJS(EdaatOR.Biller_Enquiry);
	          switchToWindow();
	  	   		Thread.sleep(1000);
	  	   		if(IsDispalyed(EdaatOR.Biller_Enquiry_verif)) {
	          WebClickUsingJS(EdaatOR.Biller_Clientreg_cancel);
	          WebClickUsingJS(EdaatOR.Biller_Clientreg_yescancel);
			  Log.ReportEvent("PASS", "BillerEnquiry Link In The Footer Page Is Displayed Successfully");
			  driver.navigate().back();
		    }else {
				  Log.ReportEvent("FAIL", "BillerEnquiry Link In The Footer Page Is Not Displayed");
				  this.takeScreenShot();
				  driver.quit();
				  Assert.fail();
		    	}
		    }
		catch (Exception e) {
			  Log.ReportEvent("FAIL", "BillerEnquiry Link In The Footer Page Is Not Displayed");
			  this.takeScreenShot();
			  driver.quit();
			  Assert.fail();
		}
		
	}
	//Function Summary   : Method to verify ClientRegister link in the footer page.
    //Parameter Summary : NA.
	public void ClientRegister(Log Log)
	{
		try {
	          WebClickUsingJS(EdaatOR.Biller_Clientreg);
	          switchToWindow();
	  		  Thread.sleep(1000);
	  		  if(IsDispalyed(EdaatOR.Biller_Clientreg_verif)) {
			  Log.ReportEvent("PASS", "ClientRegister Link In The Footer Page Is Displayed Successfully");
			  driver.navigate().back();
	  		  }else {
	  			 Log.ReportEvent("FAIL", "ClientRegister Link In The Footer Page Is Not Displayed");
	  			 this.takeScreenShot();
	  			 driver.quit();
	  			 Assert.fail();
	  			  }
	  		  }
		catch (Exception e) {
 			 Log.ReportEvent("FAIL", "ClientRegister Link In The Footer Page Is Not Displayed");
 			 this.takeScreenShot();
 			 driver.quit();
 			 Assert.fail();
		}
		
		

	}
	//Function Summary   : Method to verify BillerRegister link in the footer page.
    //Parameter Summary : NA.
	public void BillerRegister(Log Log)
	{
		try {
	          WebClickUsingJS(EdaatOR.Biller_registerlnk);
	          switchToWindow();
	  		  Thread.sleep(1000);
	  		  if(IsDispalyed(EdaatOR.Biller_registerlnk_verif)){
			  Log.ReportEvent("PASS", "BillerRegister Link In The Footer Page Is Displayed Successfully");
			  driver.navigate().back();
		    }else {
		    	Log.ReportEvent("FAIL", "BillerRegister Link In The Footer Page Is Not Displayed");
		    	this.takeScreenShot();
		    	driver.quit();
		    	Assert.fail();
		    	}
		    } 
		catch (Exception e) {
	    	Log.ReportEvent("FAIL", "BillerRegister Link In The Footer Page Is Not Displaye");
	    	this.takeScreenShot();
	    	driver.quit();
	    	Assert.fail();
		}
	}
	
	//Function Summary   : Method to verify ContactUS link in the footer page.
    //Parameter Summary : NA.
   public void ContactUS(Log Log)
   {
	   try {
	          WebClickUsingJS(EdaatOR.Biller_ContactUs);
	          switchToWindow();
	  		Thread.sleep(1000);
	  		if(IsDispalyed(EdaatOR.Biller_ContactUs_verif)) {
			  Log.ReportEvent("PASS", "ContactUS Link In The Footer Page Is Displayed Successfully");
			  driver.navigate().back();
		    }
	  		else {
				  Log.ReportEvent("FAIL", "ContactUS Link In The Footer Page Is Not Displayed");
				  this.takeScreenShot();
				  driver.quit();
				  Assert.fail();
	  			}
	  		}
		catch (Exception e) {
			  Log.ReportEvent("FAIL", "ContactUS Link In The Footer Page Is Not Displayed");
			  this.takeScreenShot();
			  driver.quit();
			  Assert.fail();
		}
	   
   }
	//Function Summary   : Method to verify FAQ link in the footer page.
   //Parameter Summary : NA.
   public void FAQ(Log Log)
   {
	   try {
		   WebClickUsingJS(EdaatOR.Biller_FAQ_link);
		   switchToWindow();
			Thread.sleep(1000);
			if(IsDispalyed(EdaatOR.Biller_FAQ_Verify)) {
		   Log.ReportEvent("PASS", "FAQ Link In The Footer Page Is Displayed Successfully");
		   driver.navigate().back();
	   }else {
		   Log.ReportEvent("FAIL", "FAQ Link In The Footer Page Is Not Displayed");
		   this.takeScreenShot();
		   driver.quit();
		   Assert.fail();
	   }
	   }
	   catch(Exception e)
	   {
		   Log.ReportEvent("FAIL", "FAQ Link In The Footer Page Is Not Displayed");
		   this.takeScreenShot();
		   driver.quit();
		   Assert.fail();
	   }
	   
   }
	//Function Summary   : Method to verify Terms and Condition link in the footer page.
   //Parameter Summary : NA.
   public void Terms(Log Log)
   {
      try {
    	   WebClickUsingJS(EdaatOR.Biller_Tearms_link);
    	   switchToWindow();
   		   Thread.sleep(1000);
   		   if(IsDispalyed(EdaatOR.Biller_Tearms_Verify)) {
    	   Log.ReportEvent("PASS", "Terms And Condition Link In The Footer Page Is Displayed Successfully");
		   driver.navigate().back();
	   }
   		   else {
   	    	   Log.ReportEvent("FAIL", "Terms And Condition Link In The Footer Page Is Not Displayed");
   	    	   this.takeScreenShot();
   	    	   driver.quit();
   	    	   Assert.fail();
   		   }
   		   }
	   catch(Exception e)
	   {
	    	   Log.ReportEvent("FAIL", "Terms And Condition Link In The Footer Page Is Not Displayed");
	    	   this.takeScreenShot();
	    	   driver.quit();
	    	   Assert.fail();
	   }
	    
   }
	//Function Summary   : Method to verify Privacy policy link in the footer page.
   //Parameter Summary : NA.
   public void Privacy(Log Log)
   {
     try {
    	   WebClickUsingJS(EdaatOR.Biller_Priavcy_link);
    	   switchToWindow();
   		Thread.sleep(1000);
   		if(IsDispalyed(EdaatOR.Biller_Priavcy_verify)) {
		   Log.ReportEvent("PASS", "Privacy Policy Link In The Footer Page Is Displayed Successfully");
    	   driver.navigate().back();
	   }else {
		   Log.ReportEvent("FAIL", "Privacy Policy Link In The Footer Page Is Not Displayed");
		   this.takeScreenShot();
		   driver.quit();
		   Assert.fail();
	   }
	   }
	   catch(Exception e)
	   {
		   Log.ReportEvent("FAIL", "Privacy Policy Link In The Footer Page Is Not Displayed");
		   this.takeScreenShot();
		   driver.quit();
		   Assert.fail();
	   }
	   
   }		


//Function Summary   : Method to verify Edaat logo
//Parameter Summary : N/A
			public void VerifyEdaatLogo(Log Log)
			{
				try {
					WebClickUsingJS(EdaatOR.EdaatLogo);
					waitForPageToLoad();
					switchTonextwindow();
					if(IsDispalyed(EdaatOR.HomePage)) {
				    Log.ReportEvent("PASS", "Click On EDAAT Logo And Navigate To Home Page Is Successful");
				}
					else {
						 Log.ReportEvent("FAIL", "Click On EDAAT Logo And Navigate To Home Page Is Unsuccessful");
						this.takeScreenShot();
						driver.quit();
						Assert.fail();
					}
					}
		catch(Exception e) {
			 Log.ReportEvent("FAIL", "Click On EDAAT Logo And Navigate To Home Page Is Unsuccessful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}			
			}	
			//Function Summary   : Method to verify Admin login Error Message and Forgot Password
			//Parameter Summary : N/A
			public void AdminLoginErrorValidation(Map<Object,Object> testdatamap,Log Log)
			{
				try {
					Recordset login=ReadData.readTestDataBySpecifiedValue("Login", "LoginCategory", testdatamap.get("LoginCategory").toString());
					login.next();
					String ErrorType = testdatamap.get("Type").toString();
					if(ErrorType.equalsIgnoreCase("Both")){
						WebClickUsingJS(EdaatOR.LoginPage_LogIn);
						if(getText(EdaatOR.Admin_UserNameError).equals(testdatamap.get("Expected").toString()) &&
								getText(EdaatOR.Admin_PassError).equals(testdatamap.get("Expected").toString())) {
							Log.ReportEvent("PASS", "Admin Username And Password Textfield Error Message Validation Is Successful");
						}
						else {
							Log.ReportEvent("FAIL", "Admin Username And Password Textfield Error Message Validation Is Unsuccessful");
							this.takeScreenShot();
							driver.quit();
							Assert.fail();
						}
					}
					else if(ErrorType.equalsIgnoreCase("UserNameText"))
					{
						WebEdit(EdaatOR.LoginPage_Username,login.getField("LoginUserName"));
						WebClickUsingJS(EdaatOR.LoginPage_LogIn);
						if(getText(EdaatOR.Admin_PassError).equals(testdatamap.get("Expected").toString())){
							Log.ReportEvent("PASS", "Admin Password Textfield Error Message Validation Is Successful");
						}
						else {
							Log.ReportEvent("FAIL", "Admin Password Textfield Error Message Validation Is Unsuccessful");
							this.takeScreenShot();
							driver.quit();
							Assert.fail();
						}
					}
					else if(ErrorType.equalsIgnoreCase("PasswordText"))
					{
						WebEdit(EdaatOR.LoginPage_Password,  login.getField("LoginPassword"));
						Thread.sleep(2000);
						WebClickUsingJS(EdaatOR.LoginPage_LogIn);
						if(getText(EdaatOR.Admin_UserNameError).equals(testdatamap.get("Expected").toString())){
							Log.ReportEvent("PASS", "Admin Username Textfield Error Message Validation Is Successful");
						}
						else {
							Log.ReportEvent("FAIL", "Admin Username Textfield Error Message Validation Is Unsuccessful");
							this.takeScreenShot();
							driver.quit();
							Assert.fail();
						}
					}
					else
					{
						WebClickUsingJS(EdaatOR.Admin_forgotpasslink);
						WebClickUsingJS(EdaatOR.Admin_forgotSendbtn);
						if(getText(EdaatOR.Admin_forgotError).equals(testdatamap.get("Expected").toString())){
							Log.ReportEvent("PASS", "Admin Forgot Password Username Textfield Error Message Validation Is Successful");
						}
						else {
							Log.ReportEvent("FAIL", "Admin Forgot Password Username Textfield Error Message Validation Is Unsuccessful");
							this.takeScreenShot();
							driver.quit();
							Assert.fail();
						}
					}
				}
				catch(Exception e) {
					Log.ReportEvent("FAIL", "Admin Login Textfields Error Message Validation Is Unsuccessful");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
				}	
			}
			//Function Summary   : Method to navigate to forgot password page
			//Parameter Summary : N/A
						public void NavigateToForgotPasswordPage(Log Log) throws Exception{
							WebClick(EdaatOR.Admin_forgotpwd_Btn);
							Thread.sleep(2000);
							if (IsDispalyed(EdaatOR.Admin_forgotpwd_verify)) {
							Log.ReportEvent("PASS", "Forgot Password Page Is Loaded Successful");
							Thread.sleep(1000);
							}
							else {
								Log.ReportEvent("FAIL", "Forgot Password Page Is Not Loaded");
								this.takeScreenShot();
								driver.quit();
								Assert.fail();
							}
						}
						//Function Summary   : Method to click on Logout button in HomePage
						//Parameter Summary : N/A
						public void clickOnLogoutButtonInHomePage(Log Log)
						{
							try {
								if(CheckElementExists(EdaatOR.Biller_HomePage_Main))
								{
									WebClickUsingJS(EdaatOR.Logout);
									waitForPageToLoad();
									Log.ReportEvent("PASS", "Navigate to Login Page is Successful");
								}
								if(CheckElementExists(EdaatOR.LoginPage))
								{
									Log.ReportEvent("PASS", "Login Page is Loaded Successfully");
								}
								else {
									Log.ReportEvent("FAIL", "Login Page is not Loaded Successfully");
									this.takeScreenShot();
									driver.quit();
									Assert.fail();
								}
							}
							catch(Exception e) {
								Log.ReportEvent("FAIL", "Login Page is not Loaded Successfully");
								this.takeScreenShot();
								driver.quit();
								Assert.fail();
							}	
						}
}
