/**
*
* Test Script Name                      : BillerLogin.
* Objective                             : Verify the Biller Login Functionality.
* Version                               : 1.0
* Author                                : Kathirvelu M
* Created Date                          : 02/06/2023
* Last Updated on                       : N/A
* Updated By                            :  Arun Kumar MS.
* Pre-Conditions                        : 
* Manual Testcase Name                  : BillerLogin.
* Epic Details                          : N/A
* User Story Details                    : N/A
* Defects affecting this test script    : None
* Work Arounds/Known Issues             : None
**/
package com.azmqalabs.edaattestautomation.apppages.biller.pages;

import java.util.Map;

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
import com.azmqalabs.edaattestautomation.common.ReadData;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.codoid.products.fillo.Recordset;

public class BillerLoginPage extends BasePage {

	public BillerLoginPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.LoginPage_Username)
	public WebElement Username;

	public boolean Exists() {
		return super.Exists(Username);
	}
	//Function Summary   : Method to Check Invalid Credentials Error message is displayed.
		//Parameter Summary : ErrorMessage.
		public void ExistsCheckElement(String ErrorMessage,Log Log) throws InterruptedException {
			Thread.sleep(2000);
			try {					
				if (CheckElementExists(ErrorMessage)) {				
					Thread.sleep(2000);
		        	Log.ReportEvent("PASS", "Main Page is Loaded Successfully");

			} else {
	        	Log.ReportEvent("FAIL", "Main Page is Not Loaded Successfully");
				this.takeScreenShot();
	            driver.quit();
				Assert.fail();


			}
			} catch (Exception e) {
	        	Log.ReportEvent("FAIL", "Main Page is Not Loaded Successfully");
				this.takeScreenShot();
	            driver.quit();
				Assert.fail();
				throw new NoSuchElementException("Biller Home Page - Not Loaded");
			}
		}
	//Function Summary   : Method to Check Invalid Credentials Error message is displayed.
	//Parameter Summary : ErrorMessage.
	public void ExistsCheckElementInValidCredentials(String ErrorMessage,Log Log) throws InterruptedException {
		Thread.sleep(2000);
		try {					
			if (CheckElementExists(ErrorMessage)) {				
				Thread.sleep(2000);
	        	Log.ReportEvent("PASS", "Invalid Credentials Error Message is Displayed Successfully");

		} else {
        	Log.ReportEvent("FAIL", "Invalid Credentials Error Message is Not Displayed");
			this.takeScreenShot();
            driver.quit();
            Assert.fail();

		}
		} catch (Exception e) {
        	Log.ReportEvent("FAIL", "Invalid Credentials Error Message is Not Displayed");
			this.takeScreenShot();
            driver.quit();
            Assert.fail();
			throw new NoSuchElementException("Biller Home Page - Not Loaded");
		}
	}
	//Function Summary   : Method to Check InActivated Credentials Error message is displayed.
		//Parameter Summary : ErrorMessage.
		public void ExistsCheckElementInActivatedUser(String ErrorMessage,Log Log) throws InterruptedException {
			Thread.sleep(2000);
			try {					
				if (CheckElementExists(ErrorMessage)) {				
					Thread.sleep(2000);
		        	Log.ReportEvent("PASS", "Inactivated Credentials Error Message is Displayed Successfully");

			} else {
	        	Log.ReportEvent("FAIL", "Inactivated Credentials Error Message is Not Displayed");
				this.takeScreenShot();
	            driver.quit();
				Assert.fail();


			}
			} catch (Exception e) {
	        	Log.ReportEvent("FAIL", "Inactivated Credentials Error Message is not Displayed");
				this.takeScreenShot();
	            driver.quit();
				Assert.fail();
				throw new NoSuchElementException("Inactivated Credentials Error Message - Not Displayed");
			}
		}

	//LOGIN TO APPLICATION WITH GLOBAL LOGIN USER ID FROM LOGIN PAGE
	public void LoginToApplication(Log Log){
		try {
			
			this.Exists();
			if (IsDispalyed(EdaatOR.LoginPage_Username)) {
				WebEdit(EdaatOR.LoginPage_Username,  GlobalConstant.GLOBALTESTDATALOGINMAP.get("LoginUserName"));
				Thread.sleep(2000);
				WebEdit(EdaatOR.LoginPage_Password,  GlobalConstant.GLOBALTESTDATALOGINMAP.get("LoginPassword"));
				Thread.sleep(2000);
				WebClick(EdaatOR.LoginPage_LogIn);
				Thread.sleep(2000);
			} else {
				WebEdit(EdaatOR.LoginPage_Username, GlobalConstant.GLOBALTESTDATALOGINMAP.get("LoginUserName"));
				WebClick(EdaatOR.LoginPage_LogIn);

			}
  			Log.ReportEvent("PASS", "Biller Login is Successful");
		} catch (Exception e) {
		Log.ReportEvent("FAIL", "Biller Login is Unsuccessful");
		this.takeScreenShot();
        driver.quit();
		Assert.fail();
		}
	}

	//Function Summary   : Method to Login Edaat Application using Biller login credentials.
	//Parameter Summary : LoginUserName,LoginPassword.
	public void LoginToApplication(Map<Object,Object> testdatamap,Log Log){
		try {
			Recordset login=ReadData.readTestDataBySpecifiedValue("Login", "LoginCategory", testdatamap.get("LoginCategory").toString());
			login.next();
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
  			Log.ReportEvent("PASS", "Biller Login is Successful");

		} catch (Exception e) {
  			Log.ReportEvent("FAIL", "Biller Login is Unsuccessful");
			this.takeScreenShot();
            driver.quit();
			Assert.fail();
		}
	}
	//LOGIN TO APPLICATION WITH INDIVIDUAL TESTDATA SHEET(SAME SHEET - CALL THIS METHOD IF USER WANTS PASS USER ID FROM THE SAME SHEET)
	//Function Summary   : Method to Login Edaat Application using invalid/Activated/inActivated Biller login credentials.
	//Parameter Summary  : username,password.
	public void LoginToApplication(String username, String password,Log Log) {
		try {
			this.Exists();
			if (IsDispalyed(EdaatOR.LoginPage_Username)) {
				WebEdit(EdaatOR.LoginPage_Username, username);
				Thread.sleep(2000);
				WebEdit(EdaatOR.LoginPage_Password, password);
				Thread.sleep(2000);
				WebClick(EdaatOR.LoginPage_LogIn);
			} else {
				WebEdit(EdaatOR.LoginPage_Username, GlobalConstant.GLOBALTESTDATALOGINMAP.get("LoginUserName"));
				WebClick(EdaatOR.LoginPage_LogIn);

			}
        	Log.ReportEvent("PASS", "Biller Login is Successful");			

		} catch (Exception e) {
        	Log.ReportEvent("FAIL", "Biller Login is Unsuccessful");
			this.takeScreenShot();
            driver.quit();
			Assert.fail();
		}
	}
	public void LoginToApplicationWithInvalidCredentials(String username, String password,Log Log) {
		try {
			this.Exists();
			if (IsDispalyed(EdaatOR.LoginPage_Username)) {
				WebEdit(EdaatOR.LoginPage_Username, username);
				Thread.sleep(2000);
				WebEdit(EdaatOR.LoginPage_Password, password);
				Thread.sleep(2000);
				WebClick(EdaatOR.LoginPage_LogIn);
			} else {
				WebEdit(EdaatOR.LoginPage_Username, GlobalConstant.GLOBALTESTDATALOGINMAP.get("LoginUserName"));
				WebClick(EdaatOR.LoginPage_LogIn);

			}
        	Log.ReportEvent("PASS", " Enter Invalid Biller Credentials is Successful");			

		} catch (Exception e) {
        	Log.ReportEvent("FAIL", " Enter Invalid Biller Credentials is Unsuccessful");			
			this.takeScreenShot();
            driver.quit();
			Assert.fail();
		}
	}
	public void LoginToApplicationWithInActivatedCredentials(String username, String password,Log Log) {
		try {
			this.Exists();
			if (IsDispalyed(EdaatOR.LoginPage_Username)) {
				WebEdit(EdaatOR.LoginPage_Username, username);
				Thread.sleep(2000);
				WebEdit(EdaatOR.LoginPage_Password, password);
				Thread.sleep(2000);
				WebClick(EdaatOR.LoginPage_LogIn);
			} else {
				WebEdit(EdaatOR.LoginPage_Username, GlobalConstant.GLOBALTESTDATALOGINMAP.get("LoginUserName"));
				WebClick(EdaatOR.LoginPage_LogIn);

			}
        	Log.ReportEvent("PASS", " Enter InActivated Biller Credentials is Successful");			

		} catch (Exception e) {
        	Log.ReportEvent("FAIL", " Enter InActivated Biller Credentials is Unsuccessful");			
			this.takeScreenShot();
            driver.quit();
			Assert.fail();
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
			test.log(Status.FAIL,
					INFOFontColorPrefix + "launchApplication Page - loginToApplication failed - unable to Enter" + e
							+ FAILFontColorSuffix);
			test.log(Status.FAIL,
					INFOFontColorPrefix + "Error found at class: " + this.getClass().getName() + " Code line Number: "
							+ new Exception().getStackTrace()[0].getLineNumber() + "!" + FAILFontColorSuffix);
			throw new NoSuchElementException("loginToApplication - Login Failed");
		}

	}

	public void Wait() throws Exception {
		int i = 0;
		while (i < 10) {
			SetExecutionDelay();
			i = i + 1;
		}
	}

	public void Logout(String logout,Log Log) {
		try {
			WebClickUsingJS(logout);
			Thread.sleep(500);
			if(CheckElementExists(EdaatOR.LoginPage_Username))
			{
//        	Log.ReportEvent("PASS", " Logout Successful");
			}else {
				Log.ReportEvent("FAIL", " Logout Not Successful");
				this.takeScreenShot();
	            driver.quit();
				Assert.fail();
			}
			
		} catch (Exception e) {
        	Log.ReportEvent("FAIL", " Logout Not Successful");
			this.takeScreenShot();
            driver.quit();
			Assert.fail();
			throw new NoSuchElementException("Logout - Logout Failed");

		}
	}
	//Function Summary   : Method to Verifying ForgetPassword Functionality.
	//Parameter Summary : username,forGet.
	public void ForgetPassword(String forGet,String Username,Log Log) {
		try {
			
			WebClickUsingJS(forGet);
			if(CheckElementExists(EdaatOR.Biller_Reset_Password))
			{
			WebEdit(EdaatOR.LoginPage_Username, Username);
			WebClickUsingJS(EdaatOR.LoginPage_send);
			Thread.sleep(1000);
			if(CheckElementExists(EdaatOR.LoginPage_Forgetpassword_confirmation))
			{
				Log.ReportEvent("PASS","Biller Forget Password Functionality is Successful");

			}
			}
			else {
				Log.ReportEvent("FAIL","Biller Forget Password Functionality is Unsuccessful");
				this.takeScreenShot();
	            driver.quit();
				Assert.fail();

			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL","Biller Forget Password Functionality is Unsuccessful");
			this.takeScreenShot();
            driver.quit();
			Assert.fail();
			throw new NoSuchElementException("ForgetPassword - ForgetPassword Failed");

		}
	}
	//Function Summary   : Method to Click on Biller Login Button  
		//Parameter Summary : 
	public void clickOnBillerLogin() throws InterruptedException {
		WebClickUsingJS(EdaatOR.Biller_Link);
		waitForPageToLoad();
		Thread.sleep(1000);
	}
//Function Summary   : Method to Click on change language
		//Parameter Summary : NA
		public void ChangeLanguage(Log Log) throws InterruptedException {
			try {
			WebClickUsingJS(EdaatOR.Biller_AR_LoginBtn);
			Thread.sleep(2000);
			Log.ReportEvent("PASS", "Biller Application Launched Successfully");
			if(IsDispalyed(EdaatOR.Biller_loginverify)) {
				
		       	Log.ReportEvent("PASS", "Login Page Is Loaded Successfully");
				WebClickUsingJS(EdaatOR.Biller_Login_ChangeLanguage);
				Thread.sleep(2000);
				
				if(getText(EdaatOR.Biller_loginverify).equals("Login")){
					
		       	Log.ReportEvent("PASS", "Biller Application Language Change Is Successful");
		       	}
				
				else {
					
				Log.ReportEvent("FAIL","Biller application Language Change Is Unsuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
				
				}
				  }
			else {
				
				Log.ReportEvent("FAIL", "Login Page Is Not Loaded");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
			}
			catch(Exception e) {
				Log.ReportEvent("FAIL", "Biller Application Was Not Launched");
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
				if(CheckElementExists(EdaatOR.HomePage))
				{
					Log.ReportEvent("PASS", " Click on EDAAT Logo and Navigate to Home Page is Successful");

				}else {
					Log.ReportEvent("FAIL", " Click on EDAAT Logo and Navigate to Home Page is Unsuccessful");
					this.takeScreenShot();
                    driver.quit();
                    Assert.fail();

				}
			}
	catch(Exception e) {
		Log.ReportEvent("FAIL", " Click on EDAAT Logo and Navigate to Home Page is is Unsuccessful");
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
			Information(Log);
			Log.ReportEvent("PASS", "Verify Links in the Footer Page is Successful");	

		}
		catch (Exception e) {
			Log.ReportEvent("FAIL", "Verify Links in the Footer Page is Unsuccessful");	
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
	//Function Summary   : Method to verify AboutEdaat links in the footer page.
    //Parameter Summary : NA.
	public void AboutEdaat(Log Log)
	{
		try {
	          WebClickUsingJS(EdaatOR.Biller_About_Edaat);
	          switchToWindow();
	          if(CheckElementExists(EdaatOR.Biller_About_verify))
	          {
				  Log.ReportEvent("PASS", " AboutEdaat Link is Loaded Successfully");	
	        	  
	          }
	          else {
				  Log.ReportEvent("FAIL", " AboutEdaat Link is Not Loaded Successfully");	
				  this.takeScreenShot();
		          driver.quit();
				  Assert.fail();


	          }
			  driver.navigate().back();
		    }
		catch (Exception e) {
			  Log.ReportEvent("FAIL", " AboutEdaat Link is Not Loaded Successfully");	
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
			  if(CheckElementExists(EdaatOR.Biller_OurService_verif))
	          {
				  Log.ReportEvent("PASS", " Ourservices Link is Loaded Successfully");	
	        	  
	          }
	          else {
				  Log.ReportEvent("FAIL", " Ourservices Link is Not Loaded Successfully");	
				  this.takeScreenShot();
		          driver.quit();
				  Assert.fail();


	          }
			  driver.navigate().back();
		    }
		catch (Exception e) {
			Log.ReportEvent("FAIL", " Ourservices Link is Not Loaded Successfully");	
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
	         Thread.sleep(10000);
	          if(CheckElementExists(EdaatOR.Biller_FintechVerf))
	          {
				  Log.ReportEvent("PASS", " Fintech Link is Loaded Successfully");	
	        	  
	          }
	          else {
				  Log.ReportEvent("FAIL", " Fintech Link is Not Loaded Successfully");	
				  this.takeScreenShot();
		          driver.quit();
				  Assert.fail();

	          }
		    
			  driver.navigate().back();
		    }
		catch (Exception e) {
			 Log.ReportEvent("FAIL", " Fintech Link is Not Loaded Successfully");	
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
	          if(CheckElementExists(EdaatOR.Biller_OurClient_verif))
	          {
				  Log.ReportEvent("PASS", " OurClients Link is Loaded Successfully");	
	        	  
	          }
	          else {
				  Log.ReportEvent("FAIL", " OurClients Link is Not Loaded Successfully");	
				  this.takeScreenShot();
		          driver.quit();
				  Assert.fail();

	          }
			 
			  driver.navigate().back();
		    }
		catch (Exception e) {
			  Log.ReportEvent("FAIL", " OurClients Link is Not Loaded Successfully");	
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
	          if(CheckElementExists(EdaatOR.Biller_Enquiry_verif))
	          {
	            
				  Log.ReportEvent("PASS", " BillerEnquiry Link is Loaded Successfully");	
	        	  
	          }
	          else {
				  Log.ReportEvent("FAIL", " BillerEnquiry Link is Not Loaded Successfully");	
				  this.takeScreenShot();
		          driver.quit();
				  Assert.fail();

	          }			  
			  driver.navigate().back();
		    }
		catch (Exception e) {
			 Log.ReportEvent("FAIL", " BillerEnquiry Link is Not Loaded Successfully");	
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
	          if(CheckElementExists(EdaatOR.Biller_Clientreg_verif))
	          {	            
				  Log.ReportEvent("PASS", " ClientRegister Link is Loaded Successfully");	
	        	  
	          }
	          else {
				  Log.ReportEvent("FAIL", " ClientRegister Link is Not Loaded Unsuccessfully");	
				  this.takeScreenShot();
		          driver.quit();
				  Assert.fail();

	          }		
			  driver.navigate().back();

		    }
		catch (Exception e) {
			  Log.ReportEvent("FAIL", " ClientRegister Link is Not Loaded Unsuccessfully");	
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
	          if(CheckElementExists(EdaatOR.Biller_registerlnk_verif))
	          {	            
				  Log.ReportEvent("PASS", " BillerRegister Link is Loaded Successfully");	
	        	  
	          }
	          else {
				  Log.ReportEvent("FAIL", " BillerRegister Link is Not Loaded Successfully");	
				  this.takeScreenShot();
		          driver.quit();
				  Assert.fail();

	          }	
			 
			  driver.navigate().back();

		    }
		catch (Exception e) {
			 Log.ReportEvent("FAIL", " BillerRegister Link is Not Loaded Successfully");	
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
	          if(CheckElementExists(EdaatOR.Biller_ContactUs_verif))
	          {	            
				  Log.ReportEvent("PASS", " ContactUs Link is Loaded Successfully");	
	        	  
	          }
	          else {
				  Log.ReportEvent("FAIL", " ContactUs Link is Not Loaded Successfully");	
				  this.takeScreenShot();
		          driver.quit();
				  Assert.fail();

	          }	
			 driver.navigate().back();
		    }
		catch (Exception e) {
			  Log.ReportEvent("FAIL", " ContactUs Link is Not Loaded Successfully");	
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
		   if(CheckElementExists(EdaatOR.Biller_FAQ_Verify))
	          {	            
				  Log.ReportEvent("PASS", " FAQ Link is Loaded Successfully");	
	        	  
	          }
	          else {
				  Log.ReportEvent("FAIL", " FAQ Link is Not Loaded Successfully");	
				  this.takeScreenShot();
		          driver.quit();
				  Assert.fail();

	          }	
		   
		   driver.navigate().back();
	   }
	   catch(Exception e)
	   {
		   Log.ReportEvent("FAIL", " FAQ Link is Not Loaded Successfully");	
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
    	   if(CheckElementExists(EdaatOR.Biller_Tearms_Verify))
	          {	            
				  Log.ReportEvent("PASS", " Terms Link is Loaded Successfully");	
	        	  
	          }
	          else {
				  Log.ReportEvent("FAIL", " Terms Link is Not Loaded Successfully");	
				  this.takeScreenShot();
		          driver.quit();
				  Assert.fail();

	          }	    	   
			  driver.navigate().back();
	   }
	   catch(Exception e)
	   {
		   Log.ReportEvent("FAIL", " Terms Link is Not Loaded Successfully");	
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
    	   if(CheckElementExists(EdaatOR.Biller_Priavcy_verify))
	          {	            
				  Log.ReportEvent("PASS", " Privacy policy Link is Loaded Successfully");	
	        	  
	          }
	          else {
				  Log.ReportEvent("FAIL", " Privacy policy Link is Not Loaded Successfully");	
				  this.takeScreenShot();
		          driver.quit();
				  Assert.fail();

	          }	 
    	 
			  driver.navigate().back();
	   }
	   catch(Exception e)
	   {
		   Log.ReportEvent("FAIL", " Privacy policy Link is Not Loaded Successfully");	
			  this.takeScreenShot();
	          driver.quit();
			  Assert.fail();
	   }
	   
   }	
   public void InvalidLogin(Map<Object,Object> testdatamap)
   {
	   try {
		   WebEdit(EdaatOR.Biller_InvalidloginUserName,testdatamap.get("UserName").toString());
		   Thread.sleep(2000);
		   WebEdit(EdaatOR.Biller_InvalidloginPassword,testdatamap.get("Password").toString());
		   Thread.sleep(2000);
           WebClick(EdaatOR.Biller_InvalidloginButton);
           Thread.sleep(1000);
           LoginErrormeaasgaeValidation(testdatamap);
           test.log(Status.PASS, "Invalid Error message" + driver.getTitle() + " * Invalid login error message Success* "); 
		   this.takeScreenShot();

	   }
	   catch(Exception e)
	   {
		   this.takeScreenShot();
		test.log(Status.FAIL, "Invalid Error message" + driver.getTitle() + " * Invalid login error message is Fail* "); 	   
 }
   }

   public void LoginErrormeaasgaeValidation(Map<Object,Object> testdatamap) throws InterruptedException {
		this.takeScreenShot();
		String Expected=testdatamap.get("ExpectedMessage").toString();
		try {
			if (ExistsCheck(EdaatOR.Biller_InvalidloginUserError)&&(ExistsCheck(EdaatOR.Biller_InvalidloginPasswordError))) {
				VerifyValue(Expected,EdaatOR.Biller_InvalidloginUserError);
				test.log(Status.PASS, "LoginUserName ErrorMessage Exists" + driver.getTitle() + " * LoginUserNameAndpassword ErrorMessage Exists * ");
			}
			else if	(ExistsCheck(EdaatOR.Biller_InvalidloginPasswordError)) {
				VerifyValue(Expected,EdaatOR.Biller_InvalidloginPasswordError);
				test.log(Status.PASS, "LoginUserName ErrorMessage Exists" + driver.getTitle() + " * LoginPassword ErrorMessage Exists * ");	
   }
			else if	(ExistsCheck(EdaatOR.Biller_InvalidloginUserErrors)) {
				VerifyValue(Expected,EdaatOR.Biller_InvalidloginUserErrors);
				test.log(Status.PASS, "LoginUserName ErrorMessage Exists" + driver.getTitle() + " * LoginPassword ErrorMessage Exists * ");	
   }
		}
		   catch(Exception e)
		   {
			   this.takeScreenShot();
			test.log(Status.FAIL, "Invalid Error message" + driver.getTitle() + " * Invalid login error message is Fail* "); 	   
	 }

}
 //Function Summary   : Method to Verifying ForgetPassword Functionality.
 	//Parameter Summary : username,forGet.
 	public void ForgetPasswordValidation(String forGet,String Username,Log Log) {
 		try {
 			WebClickUsingJS(forGet);
 			WebClickUsingJS(EdaatOR.LoginPage_send);
 			Thread.sleep(3000);
 			if(IsDispalyed(EdaatOR.Biller_Usernamevalidation))
 			{
 				VerifyValue1(Username,EdaatOR.Biller_Usernamevalidation);
 				Log.ReportEvent("PASS", " Enter Username Error Message on Forget Password Page is Successful");	
 			}
 			else {
 				Log.ReportEvent("FAIL", "Enter Username Error Message on Forget Password Page is Unsuccessful");	
 				   this.takeScreenShot();
 				   driver.quit();
 				   Assert.fail();
 				
 			}
 		}
 		catch (Exception e) {
 			
 			   Log.ReportEvent("FAIL", "Enter Username Error Message on Forget Password Page is Unsuccessful");	
 			   this.takeScreenShot();
 			   driver.quit();
 			   Assert.fail();
 		}
 	}
}
