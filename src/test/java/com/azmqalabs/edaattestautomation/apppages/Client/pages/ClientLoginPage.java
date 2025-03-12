/**
* Test Script Name  				    : N/A
* Objective     					    : Verify ClientLogin Functionality
* Version                               : 1.0
* Author                                : Basavaraj Mudnur
* Created Date                          : 
* Last Updated on                       : N/A
* Updated By   			 			    : Basavaraj Mudnur
* Pre-Conditions					    : N/A
* Epic Details						 	: N/A
* User Story Details				 	: N/A
**/
package com.azmqalabs.edaattestautomation.apppages.Client.pages;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SendKeys;
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
import com.google.sitebricks.routing.Action;

public class ClientLoginPage extends BasePage {

	public ClientLoginPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.LoginPage_Username)
	public WebElement Username;

	public boolean Exists() {
		return super.Exists(Username);
	}

	// Function Summary : Method to ClickonClientLogin
	// Parameter Summary : N/A
	public void ClickonClientLogin(Map<Object, Object> testdatamap) {
		WebClickUsingJS(EdaatOR.Client_Link);

		waitForPageToLoad();
	}

	// Function Summary : Method to Check Mainpage/Error message is displayed.
	// Parameter Summary : N/A.
	public void ExistsCheckElement(Log Log) throws InterruptedException {
		Thread.sleep(1000);
		this.takeScreenShot();
		boolean Header;
		try {
			Header = ExistsCheck(EdaatOR.Client_HelloClient_Main);

			if (Header) {
				Log.ReportEvent("PASS", " Main Page is Dislayed Successfully");

			} else {
				Log.ReportEvent("FAIL", " Main Page is not Dislayed Successfully");

			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", " Main Page is not Dislayed Successfully");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	// Function Summary : Method to LoginToClientApplication
	// Parameter Summary : username,password
	public void LoginToApplication(String username, String password, Log Log) {
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
			Log.ReportEvent("PASS", "Client Login is Successful");

		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Client Login is not Successful");
			this.takeScreenShot();
			driver.close();
			Assert.fail();
		}
	}

	// Function Summary : Method to Login Edaat Application using Client login
	// credentials.
	// Parameter Summary : LoginUserName,LoginPassword.
	public void LoginToApplication(Map<Object, Object> testdatamap, Log Log) {
		try {
			Recordset login = ReadData.readTestDataBySpecifiedValue("Login", "LoginCategory",
					testdatamap.get("LoginCategory").toString());
			login.next();
			this.Exists();
			if (IsDispalyed(EdaatOR.LoginPage_Username)) {
				WebEdit(EdaatOR.LoginPage_Username, login.getField("LoginUserName"));
				Thread.sleep(2000);
				WebEdit(EdaatOR.LoginPage_Password, login.getField("LoginPassword"));
				Thread.sleep(2000);
				WebClick(EdaatOR.LoginPage_LogIn);
				Thread.sleep(3000);
				Log.ReportEvent("PASS", "Client Login is Successful");

			} else if (ExistsCheck(EdaatOR.LoginPage_UserError) || ExistsCheck(EdaatOR.LoginPage_PasswordError)) {
				Log.ReportEvent("FAIL", "Client Login is not Successful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}

		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Client Login is not Successful");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	public void Logout(Log Log) {
		try {
			WebClickUsingJS(EdaatOR.Logout);
			Thread.sleep(2000);
			if (CheckElementExists(EdaatOR.ClientLoginNewClientRegistrationTXT)) {
//				Log.ReportEvent("PASS", "Client Logout is Successful");				

			} else {
				Log.ReportEvent("FAIL", "Client Logout is not Successfull");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Client Logout is not Successfull");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();

		}
	}

	// Function Summary : Method to verify Edaat logo
	// Parameter Summary : N/A
	public void VerifyEdaatLogo(Log Log) {
		try {
			WebClickUsingJS(EdaatOR.EdaatLogo);
			waitForPageToLoad();
			switchTonextwindow();

			if (CheckElementExists(EdaatOR.HomePage)) {
				Log.ReportEvent("PASS", "Click on EDAAT logo and navigate to home page is Successful");

			} else {
				Log.ReportEvent("FAIL", "Click on EDAAT logo and navigate to home page is not Successful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Click on EDAAT logo and navigate to home page is not Successful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	// Function Summary : Method to Login Edaat Application using Client login
	// credentials.
	// Parameter Summary : LoginUserName,LoginPassword.
	public void InvalidLogin(Map<Object, Object> testdatamap, Log Log) {
		try {
			Recordset login = ReadData.readTestDataBySpecifiedValue("Login", "LoginCategory",
					testdatamap.get("LoginCategory").toString());
			login.next();
			this.Exists();
			WebEdit(EdaatOR.LoginPage_Username, login.getField("LoginUserName"));
			Thread.sleep(1000);
			WebEdit(EdaatOR.LoginPage_Password, login.getField("LoginPassword"));
			Thread.sleep(1000);
			WebClick(EdaatOR.LoginPage_LogIn);
			Thread.sleep(2000);
			if (CheckElementExists(EdaatOR.LoginPage_Invalid_LogIn)) {
				Log.ReportEvent("PASS", "Client Invalid Login is Successful");

			} else {
				Log.ReportEvent("FAIL", "Client Invalid Login is not Successful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}

		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Client Invalid Login is not Successful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	// Function Summary : Method to Verify About Edaat Link
	// Parameter Summary: N/A
	public void ClickOnAboutEdaatLink() throws Exception {
		WebClick(EdaatOR.ClientLoginAboutEdaatLink);
		waitForPageToLoad();
		Thread.sleep(1000);
		verifyElementIsPresent(EdaatOR.ClientLoginAboutEdaatText);
		Thread.sleep(2000);
		driver.navigate().back();
	}

	// Function Summary : Method to Verify OurServices Link
	// Parameter Summary: N/A
	public void ClickOnOurServicesLink() throws Exception {
		WebClick(EdaatOR.ClientLoginOurServicesLink);
		waitForPageToLoad();
		Thread.sleep(1000);
		verifyElementIsPresent(EdaatOR.ClientLoginOurServicesEdaatFeaturesTXT);
		Thread.sleep(2000);
		driver.navigate().back();
	}

	// Function Summary : Method to Verify Our Clients Link
	// Parameter Summary: N/A
	public void ClickOnOurClientsLink() throws Exception {
		WebClick(EdaatOR.ClientLoginOurClientsLink);
		waitForPageToLoad();
		Thread.sleep(1000);
		verifyElementIsPresent(EdaatOR.ClientLoginOurClientsTXT);
		Thread.sleep(2000);
		driver.navigate().back();
	}

	// Function Summary : Method to Verify About AZM Fintech Link
	// Parameter Summary: N/A
	public void ClickOnAboutAzmFintechLink() throws Exception {
		WebClick(EdaatOR.ClientLoginAZMFintechLink);
		waitForPageToLoad();
//		verifyElementIsPresent(EdaatOR.ClientLoginOurClientsTXT);
		Thread.sleep(4000);
		driver.navigate().back();
	}

	// Function Summary : Method to Verify Bill Inquiry Link
	// Parameter Summary: N/A
	public void ClickOnBillInquiryLink() throws Exception {
		WebClick(EdaatOR.ClientLoginBillInquiryLink);
		waitForPageToLoad();
		Thread.sleep(1000);
		verifyElementIsPresent(EdaatOR.ClientLoginEnterInvoiceNumTXT);
		Thread.sleep(2000);
		driver.navigate().back();
	}

	// Function Summary : Method to Verify Client Registration Link
	// Parameter Summary: N/A
	public void ClickOnClientRegistrationLink() throws Exception {
		WebClick(EdaatOR.ClientLoginClientRegistrationLink);
		waitForPageToLoad();
		Thread.sleep(1000);
		verifyElementIsPresent(EdaatOR.ClientLoginNewClientRegistrationTXT);
		Thread.sleep(2000);
		driver.navigate().back();
	}

	// Function Summary : Method to Verify Biller Registration Link
	// Parameter Summary: N/A
	public void ClickOnBillerRegistrationLink() throws Exception {
		WebClick(EdaatOR.ClientLoginBillerRegistrationLink);
		waitForPageToLoad();
		Thread.sleep(1000);
		verifyElementIsPresent(EdaatOR.ClientLoginNewBillerRegistrationTXT);
		Thread.sleep(2000);
		driver.navigate().back();
	}

	// Function Summary : Method to Verify Contact Us Link
	// Parameter Summary: N/A
	public void ClickOnContactUsLink() throws Exception {
		WebClick(EdaatOR.ClientLoginContactUSLink);
		waitForPageToLoad();
		Thread.sleep(1000);
		verifyElementIsPresent(EdaatOR.ClientLoginContactusTXT);
		Thread.sleep(2000);
		driver.navigate().back();
	}

	// Function Summary : Method to Verify FAQ Link
	// Parameter Summary: N/A
	public void ClickOnFAQLink() throws Exception {
		WebClick(EdaatOR.ClientLoginFAQLink);
		waitForPageToLoad();
		Thread.sleep(1000);
		verifyElementIsPresent(EdaatOR.ClientLoginFAQ_TXT);
		Thread.sleep(2000);
		driver.navigate().back();
	}

	// Function Summary : Method to Verify Terms and Conditions Link
	// Parameter Summary: N/A
	public void ClickOnTermsandConditionsLink() throws Exception {
		WebClick(EdaatOR.ClientLoginTermsandConditionLink);
		waitForPageToLoad();
		Thread.sleep(1000);
		verifyElementIsPresent(EdaatOR.ClientLoginTermsandConditionTXT);
		Thread.sleep(2000);
		driver.navigate().back();
	}

	// Function Summary : Method to Verify Privacy and Policy Link
	// Parameter Summary: N/A
	public void ClickOnPrivacyandPolicyLink(Log Log) throws Exception {
		WebClick(EdaatOR.ClientLoginPrivacyandPolicyLink);
		waitForPageToLoad();
		Thread.sleep(1000);
		if (CheckElementExists(EdaatOR.ClientLoginPrivacyandPolicyTXT)) {
			Log.ReportEvent("PASS", "Links in the Footer page are verified successfully");

		} else {
			Log.ReportEvent("FAIL", "Links in the Footer page are not verified successfully");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
		Thread.sleep(2000);
		driver.navigate().back();
	}

	// Function Summary : Method to Verify Links in the Footer Page
	// Parameter Summary: N/A
	public void VerifyLinksinFooterppage(Log Log) {
		try {
			ClickOnAboutEdaatLink();
			Thread.sleep(1000);
			ClickOnOurServicesLink();
			Thread.sleep(1000);
			ClickOnOurClientsLink();
			Thread.sleep(1000);
			ClickOnAboutAzmFintechLink();
			Thread.sleep(1000);
			ClickOnBillInquiryLink();
			Thread.sleep(1000);
			ClickOnClientRegistrationLink();
			Thread.sleep(1000);
			ClickOnBillerRegistrationLink();
			Thread.sleep(1000);
			ClickOnContactUsLink();
			Thread.sleep(1000);
			ClickOnFAQLink();
			Thread.sleep(1000);
			ClickOnTermsandConditionsLink();
			Thread.sleep(1000);
			ClickOnPrivacyandPolicyLink(Log);

		} catch (Exception e) {

			Log.ReportEvent("FAIL", "Links in the Footer page are not verified successfully");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();

		}
	}

	public void ChangeLanguage(Map<Object, Object> testdatamap, Log Log) {
		try {

			WebClickUsingJS(EdaatOR.Changelanguagebtn);

			if (getText(EdaatOR.Clientloginbtn).equals(testdatamap.get("Change").toString())) {

				Log.ReportEvent("PASS", "Client login- Language is changed successfully");
			} else {
				Log.ReportEvent("FAIL", "Client login- Language is not changed successfully");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {

			Log.ReportEvent("FAIL", "Client login- Language is not changed successfully");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();

		}

	}

	// Function Summary : Method to VerifyForgotPassword
	// Parameter Summary : LoginUserName,LoginPassword.
	public void VerifyForgotPassword(Map<Object, Object> testdatamap, Log Log) {

		try {
			WebClick(EdaatOR.Client_forgotpwd_Btn);
			Thread.sleep(2000);
			verifyElementIsPresent(EdaatOR.Client_forgotpwd_verify);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Client_Username_efield, testdatamap.get("UserName").toString());
			Thread.sleep(1000);
			WebClick(EdaatOR.Client_Username_sendbtn);

			Thread.sleep(1000);
			if (CheckElementExists(EdaatOR.Client_Username_confirm_verify)) {
				Log.ReportEvent("PASS", "Forget Password functionality is Successful");
				WebClick(EdaatOR.Client_Username_close);
			} else {
				Log.ReportEvent("FAIL", "Forget Password functionality is not Successful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}

		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Forget Password functionality is not Successful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	// Function Summary : Method to Verify Client login page fields validation
	// Parameter Summary : LoginUserName,LoginPassword.
	public void LoginErrormessageValidation(Map<Object, Object> testdatamap, Log Log) throws InterruptedException {
		InvalidLoginError(testdatamap, Log);
		String Expected = testdatamap.get("ExpectedResult").toString();
		try {
			if (ExistsCheck(EdaatOR.ClientLoginPage_EmailError)) {
				if (Expected.equals(getText(EdaatOR.ClientLoginPage_EmailError))) {
					Log.ReportEvent("PASS", "Client Login Email Error is Displayed");
				} else {
					Log.ReportEvent("FAIL", "Client Login Email Error is not Displayed");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			} else if (ExistsCheck(EdaatOR.ClientLoginPage_PasswordError)) {
				if (Expected.equals(getText(EdaatOR.ClientLoginPage_PasswordError))) {
					Log.ReportEvent("PASS", "Client Login Password Error is Displayed");
				} else {
					Log.ReportEvent("FAIL", "Client Login Password Error is not Displayed");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			} else if (ExistsCheck(EdaatOR.ClientLoginPage_EmailError)
					&& ExistsCheck(EdaatOR.ClientLoginPage_PasswordError)) {
				if (Expected.equals(getText(EdaatOR.ClientLoginPage_EmailError))
						&& Expected.equals(getText(EdaatOR.ClientLoginPage_PasswordError))) {
					Log.ReportEvent("PASS", "Client Login Email and Password Error is Displayed");
				} else {
					Log.ReportEvent("FAIL", "Client Login Email and Password Error is not Displayed");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Client Login Email and Password Error is not Displayed");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	// Function Summary : Method to enter invalid Client login credentials.
	// Parameter Summary : LoginUserName,LoginPassword.
	public void InvalidLoginError(Map<Object, Object> testdatamap, Log Log) {
		try {
			Recordset login = ReadData.readTestDataBySpecifiedValue("Login", "LoginCategory",
					testdatamap.get("LoginCategory").toString());
			login.next();
			this.Exists();
			if (IsDispalyed(EdaatOR.LoginPage_Username)) {
				WebEdit(EdaatOR.LoginPage_Username, login.getField("LoginUserName"));
				Thread.sleep(2000);
				WebEdit(EdaatOR.LoginPage_Password, login.getField("LoginPassword"));
				Thread.sleep(2000);
				WebClick(EdaatOR.LoginPage_LogIn);
				Thread.sleep(2000);
			} else {
				WebEdit(EdaatOR.LoginPage_Username, login.getField("LoginUserName"));
				WebClick(EdaatOR.LoginPage_LogIn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Function Summary : Method to VerifyForgotPassword
	// Parameter Summary : LoginUserName,LoginPassword.
	public void VerifyForgotPasswordError(Map<Object, Object> testdatamap, Log Log) {

		try {
			WebClick(EdaatOR.Client_forgotpwd_Btn);
			Thread.sleep(2000);
			verifyElementIsPresent(EdaatOR.Client_forgotpwd_verify);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Client_Username_efield, testdatamap.get("UserName").toString());
			Thread.sleep(1000);
			WebClick(EdaatOR.Client_Username_sendbtn);
			Thread.sleep(1000);
			Log.ReportEvent("PASS", "Forget Password functionality is Successful");
		} catch (Exception e) {

			Log.ReportEvent("FAIL", "Forget Password functionality is UnSuccessful");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	// Function Summary : Method to Verify Forgot password fields validation
	// Parameter Summary : LoginUserName,LoginPassword.
	public void forgotPasswordErrormessageValidation(Map<Object, Object> testdatamap, Log Log)
			throws InterruptedException {
		VerifyForgotPasswordError(testdatamap, Log);
		try {
			if (ExistsCheck(EdaatOR.ForgotPasswordPage_EmailError)) {
				if (testdatamap.get("ExpectedResult").toString()
						.equals(getText(EdaatOR.ForgotPasswordPage_EmailError))) {
					Log.ReportEvent("PASS", "Forgot Password Email Error is Displayed");
				} else {
					Log.ReportEvent("FAIL", "Forgot Password Email Error is not Displayed");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			} else if (ExistsCheck(EdaatOR.ForgotPasswordPage_invalidEmailError)) {
				if (testdatamap.get("ExpectedResult").toString()
						.equals(getText(EdaatOR.ForgotPasswordPage_invalidEmailError))) {
					Log.ReportEvent("PASS", "Forgot Password  Invalid Email Error is Displayed");

				} else {
					Log.ReportEvent("FAIL", "Forgot Password Invalid Email Error is  not Displayed");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Forgot Password Page is not Loaded");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	// Function Summary : Method to validateCorrectClientIsLoginToTheClientAccount
	// Parameter Summary : ClientName
	public void validateCorrectClientIsLoginToTheClientAccount(Map<Object, Object> testdatamap, Log Log) {
		try {
			if (CheckElementExists(EdaatOR.MyBills_Client_ClientName)) {
				verifyElementIsPresent(EdaatOR.MyBills_Client_ClientName);
				Log.ReportEvent("PASS",
						"When entering the contract number and redirecting to login as client then log by the correct client Functionality is Successful");

			} else {
				Log.ReportEvent("FAIL",
						"When entering the contract number and redirecting to login as client then log by the correct client Functionality is UnSuccessful");
				this.takeScreenShot();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL",
					"When entering the contract number and redirecting to login as client then log by the correct client Functionality is UnSuccessful");
			this.takeScreenShot();
			e.printStackTrace();
			Assert.fail();
		}
	}
}
