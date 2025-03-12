/**
*
* Test Script Name                      : NA.
* Objective                             : Verify to update client Profile Functionality.
* Version                               : 1.0
* Author                                : Kalpana I R
* Created Date                          : 
* Last Updated on                       : N/A
* Updated By                            : 
* Pre-Conditions                        : 1)Client Login Credentials.
* Epic Details                          : N/A
* User Story Details                    : N/A
* 
**/
package com.azmqalabs.edaattestautomation.apppages.Client.pages;

import java.io.IOException;
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
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.ReadData;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.codoid.products.fillo.Recordset;

public class ClientMyAccountPage extends BasePage {

	public ClientMyAccountPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.ClientMyAccountMenu)
	public WebElement Client;

	public boolean Exists() {
		return super.Exists(Client);
	}

	// Function summary:Verify Update Client Profile and Save.
	// Function Parameters:SecondName,ThirdName,LastName and MobileNumber.
	public void UpdateClientProfileSave(Map<Object, Object> testdatamap, Log Log) throws InterruptedException {
		try {
			WebClickUsingJS(EdaatOR.ClientMyAccUpdateProfileMenu);
			Thread.sleep(1500);
			if (getText(EdaatOR.ClientMyAccUpdateProfile_Page).equals("Update Client Profile")) {
				Log.ReportEvent("PASS", "'Update Client Profile' Page is Loaded Successfully");
			} else {
				Log.ReportEvent("FAIL", "'Update Client Profile' Page is not Loaded Successfully");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
			WebClearandEdit(EdaatOR.ClientMyAccUpdateProfileSecondName, testdatamap.get("SecondName").toString());
			Thread.sleep(1500);
			WebClearandEdit(EdaatOR.ClientMyAccUpdateProfileThirdName, testdatamap.get("ThirdName").toString());
			Thread.sleep(1500);
			WebClearandEdit(EdaatOR.ClientMyAccUpdateProfileLastName, testdatamap.get("LastName").toString());
			Thread.sleep(1500);
			WebClearandEdit(EdaatOR.ClientMyAccUpdateProfileMobNumber, testdatamap.get("MobileNumber").toString());
			Thread.sleep(1500);
			WebClick(EdaatOR.ClientMyAccUpdateProfileSaveChangesBTN);
			Thread.sleep(1500);
			if (getText(EdaatOR.Client_UpdateClientProfile_FirstNameFieldError).equals("Please use only characters")
					|| getText(EdaatOR.Client_UpdateClientProfile_SecondNameFieldError)
							.equals("Please use only characters")
					|| getText(EdaatOR.Client_UpdateClientProfile_ThirdNameFieldError)
							.equals("Please use only characters")
					|| getText(EdaatOR.Client_UpdateClientProfile_LastNameFieldError)
							.equals("Please use only characters")
					|| getText(EdaatOR.Client_UpdateClientProfile_MobileNoFieldError)
							.equals("The mobile number entered is incorrect")) {

				Log.ReportEvent("FAIL", "Update Client Profile is not Successful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			} else {
				Log.ReportEvent("PASS", "Update Client Profile is Successful");

			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Update Client Profile is not Successful");
			takeScreenShot();
			driver.quit();
			Assert.fail();

		}
	}

//Function summary:Verify Update Client Profile and Close
//Function Parameters:SecondName,ThirdName,LastName and MobileNumber.
	public void UpdateClientProfileClose(Map<Object, Object> testdatamap, Log Log) {
		try {
			WebClickUsingJS(EdaatOR.ClientMyAccUpdateProfileMenu);
			Thread.sleep(1500);
			if (getText(EdaatOR.ClientMyAccUpdateProfile_Page).equals("Update Client Profile")) {
				Log.ReportEvent("PASS", "'Update Client Profile' Page is Loaded Successfully");
			} else {
				Log.ReportEvent("FAIL", "'Update Client Profile' Page is not Loaded Successfully");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
			WebClearandEdit(EdaatOR.ClientMyAccUpdateProfileSecondName, testdatamap.get("SecondName").toString());
			Thread.sleep(1500);
			WebClearandEdit(EdaatOR.ClientMyAccUpdateProfileThirdName, testdatamap.get("ThirdName").toString());
			Thread.sleep(1500);
			WebClearandEdit(EdaatOR.ClientMyAccUpdateProfileLastName, testdatamap.get("LastName").toString());
			Thread.sleep(1500);
			WebClearandEdit(EdaatOR.ClientMyAccUpdateProfileMobNumber, testdatamap.get("MobileNumber").toString());
			Thread.sleep(1500);
			if (ExistsCheck(EdaatOR.ClientMyAccUpdateProfileCancelbtn)) {
				WebClick(EdaatOR.ClientMyAccUpdateProfileCancelbtn);
				Thread.sleep(1500);
				Log.ReportEvent("PASS", "Update Client Profile & Close is Successful");
			} else {
				Log.ReportEvent("FAIL", "Update Client Profile & Close is not Successful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Update Client Profile & Close is not Successful");
			takeScreenShot();
			driver.quit();
			Assert.fail();

		}
	}

//Function summary:Verify Update Client Login info and close.
	// Function Parameters:New Password,Old Password,Confirm Password
	public void UpdateClientLoginInfoClose(Map<Object, Object> testdatamap, Log Log) {
		try {
			WebClickUsingJS(EdaatOR.ClientMyAccUpdateLoginInfo);
			Thread.sleep(800);
			if (IsDispalyed(EdaatOR.ClientMyAccUpdateClientLogininfoHeader)) {
				Log.ReportEvent("PASS", "'Client Login info' page is Loaded Sucessfully");
			} else {
				Log.ReportEvent("FAIL", "'Client Login info' page is not Loaded");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}

			WebEdit(EdaatOR.ClientLogininfoOldPassword, testdatamap.get("Old Password").toString());
			Thread.sleep(800);
			if (WebGetTextAttribute(EdaatOR.ClientLogininfoOldPassword)
					.equals(testdatamap.get("Old Password").toString())) {
				Log.ReportEvent("PASS", "Old Password Matches successful ");
			} else {
				Log.ReportEvent("FAIL", " Old Password Doesn't Match Validation is successful ");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}

			WebEdit(EdaatOR.ClientLogininfoNewPassword, testdatamap.get("New Password").toString());
			Thread.sleep(800);

			if (WebGetTextAttribute(EdaatOR.ClientLogininfoNewPassword)
					.equals(testdatamap.get("New Password").toString())) {
				Log.ReportEvent("PASS", "New Password Matches successful ");
			} else {
				Log.ReportEvent("FAIL", "New Password Doesn't Match Validation is successful ");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}

			WebEdit(EdaatOR.ClientLogininfoConfirmPassword, testdatamap.get("Confirm Password").toString());
			Thread.sleep(800);

			if (WebGetTextAttribute(EdaatOR.ClientLogininfoConfirmPassword)
					.equals(testdatamap.get("Confirm Password").toString())) {
				Log.ReportEvent("PASS", "Confirm Password Matches successful ");
			} else {
				Log.ReportEvent("FAIL", "Confirm Password Doesn't Match Validation is successful ");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
			WebClick(EdaatOR.ClientMyAccUpdateProfileCancelbtn);
			Thread.sleep(800);
			Log.ReportEvent("PASS", "Client Login information is Cancelled Successfully");

		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Client Login information is Not Cancelled");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();

		}
	}

	// Function summary:Method to Verify NavigatetoUpdateClientLoginInfo
	// Function Parameters:N/A
	public void NavigatetoUpdateClientLoginInfo(Log Log) throws InterruptedException {
		try {
			WebClickUsingJS(EdaatOR.ClientMyAccUpdateClientLogininfo);
			Thread.sleep(1000);
			if (CheckElementExists(EdaatOR.ClientMyAccUpdateClientLogininfoHeader)) {
				Log.ReportEvent("PASS", "'Client Login info' page is Loaded Successfully");
			} else {
				Log.ReportEvent("FAIL", "'Client Login info' page is not Loaded");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "'Client Login info' page is not Loaded");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	// Function summary :Method to Verify VerifyNewPwdNotMatchconfirmPwd
	// Function Parameters:OldPassword,NewPassword,ConfirmPassword,VerifyMessage
	public void VerifyNewPwdNotMatchconfirmPwd(Map<Object, Object> testdatamap, Log Log) {
		try {
			WebEdit(EdaatOR.ClientMyAccUpdateClientLogin_oldpwd, testdatamap.get("OldPassword").toString());
			Thread.sleep(2000);

			if (WebGetTextAttribute(EdaatOR.ClientMyAccUpdateClientLogin_oldpwd)
					.equals(testdatamap.get("OldPassword").toString())) {
				Log.ReportEvent("PASS", "Old Password Matches successful ");
			} else {
				Log.ReportEvent("FAIL", "Old Password Doesn't Match Validation is Unsuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
			WebEdit(EdaatOR.ClientMyAccUpdateClientLogin_newpwd, testdatamap.get("NewPassword").toString());
			Thread.sleep(2000);
			if (WebGetTextAttribute(EdaatOR.ClientMyAccUpdateClientLogin_newpwd)
					.equals(testdatamap.get("NewPassword").toString())) {
				Log.ReportEvent("PASS", "New Password Matches successful ");
			} else {
				Log.ReportEvent("FAIL", "New Password Doesn't Match Validation is Unsuccessful ");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
			WebEdit(EdaatOR.ClientMyAccUpdateClientLogin_confirmpwd, testdatamap.get("ConfirmPassword").toString());
			Thread.sleep(2000);
			if (WebGetTextAttribute(EdaatOR.ClientMyAccUpdateClientLogin_confirmpwd)
					.equals(testdatamap.get("ConfirmPassword").toString())) {
				Log.ReportEvent("PASS", "Confirm Password Matches successful");
			} else {
				Log.ReportEvent("FAIL", "Confirm Doesn't Match Validation is Unsuccessful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
			WebClick(EdaatOR.ClientMyAccUpdateClientLogin_savebtn);
			Thread.sleep(3000);
			if ((getText("//span[text()='" + testdatamap.get("VerifyMessage").toString() + "']")
					.equals(testdatamap.get("VerifyMessage").toString()))) {
				Thread.sleep(2000);
				Log.ReportEvent("PASS", "New Password Does Not Match Confirm Password functionality is successful");
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "New Password Does Not Match confirm Password functionality is Unsuccessful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

//Function summary	 :Method to UpdateClientLoginInfoSave
	// Function Parameters:OldPassword,NewPassword,ConfirmPassword
	public void UpdateClientLoginInfoSave(Map<Object, Object> testdatamap, Log Log) {
		try {
			WebClickUsingJS(EdaatOR.ClientMyAccUpdateLoginInfo);
			Thread.sleep(800);
			if (CheckElementExists(EdaatOR.ClientMyAccUpdateClientLogininfoHeader)) {
				Log.ReportEvent("PASS", "'Client Login info' page is Loaded Sucessfully");
			} else {
				Log.ReportEvent("FAIL", "'Client Login info' page is not Loaded");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
			WebEdit(EdaatOR.ClientLogininfoOldPassword, testdatamap.get("Old Password").toString());
			Thread.sleep(800);
			if (WebGetTextAttribute(EdaatOR.ClientLogininfoOldPassword)
					.equals(testdatamap.get("Old Password").toString())) {
				Log.ReportEvent("PASS", "Old Password Matches successful");
			} else {
				Log.ReportEvent("FAIL", "Old Password Doesn't Match Validation is successful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
			WebEdit(EdaatOR.ClientLogininfoNewPassword, testdatamap.get("New Password").toString());
			Thread.sleep(800);
			if (WebGetTextAttribute(EdaatOR.ClientLogininfoNewPassword)
					.equals(testdatamap.get("New Password").toString())) {
				Log.ReportEvent("PASS", "New Password Matches successful");
			} else {
				Log.ReportEvent("FAIL", "New Password Doesn't Match Validation is successful");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
			WebEdit(EdaatOR.ClientLogininfoConfirmPassword, testdatamap.get("Confirm Password").toString());
			Thread.sleep(800);
			if (WebGetTextAttribute(EdaatOR.ClientLogininfoConfirmPassword)
					.equals(testdatamap.get("Confirm Password").toString())) {
				Log.ReportEvent("PASS", "Confirm Password Matches successful ");
			} else {
				Log.ReportEvent("FAIL", "Confirm Password Doesn't Match Validation is successful ");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
			WebClickUsingJS(EdaatOR.ClientLogininfoSaveBtn);
			Thread.sleep(1500);
			if (CheckElementExists(EdaatOR.ClientLogininfoSave_Verify) == true) {
				WebClickUsingJS(EdaatOR.ClientLogininfoyesbtn);
				Log.ReportEvent("PASS", "Update client Login Info & Save is Successful");
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Update Client Login Info & Save is not Successful");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	// Function summary :Method to UpdateClientLoginInfoError
	// Function Parameters:OldPassword,NewPassword,ConfirmPassword
	public void UpdateClientLoginInfoError(Map<Object, Object> testdatamap, Log Log) {
		try {
			WebClickUsingJS(EdaatOR.ClientMyAccUpdateLoginInfo);
			Thread.sleep(1500);
			WebEdit(EdaatOR.ClientLogininfoOldPassword, testdatamap.get("Old Password").toString());
			Thread.sleep(1500);
			WebEdit(EdaatOR.ClientLogininfoNewPassword, testdatamap.get("New Password").toString());
			Thread.sleep(1500);
			WebEdit(EdaatOR.ClientLogininfoConfirmPassword, testdatamap.get("Confirm Password").toString());
			Thread.sleep(1500);
			WebClickUsingJS(EdaatOR.ClientLogininfoSaveBtn);
			Thread.sleep(1500);
			if (ExistsCheck(EdaatOR.ClientLogininfoOldPasswordError)
					&& ExistsCheck(EdaatOR.ClientLogininfoNewPasswordError)
					&& ExistsCheck(EdaatOR.ClientLogininfoConfiPasswordError)) {
				if (testdatamap.get("Expected").toString().equals(getText(EdaatOR.ClientLogininfoOldPasswordError))
						&& testdatamap.get("Expected").toString()
								.equals(getText(EdaatOR.ClientLogininfoNewPasswordError))
						&& testdatamap.get("Expected").toString()
								.equals(getText(EdaatOR.ClientLogininfoOldPasswordError))) {
					Log.ReportEvent("PASS",
							"Client Login info New Password Error and Confirm Password Error and Old Password Error is Displayed");
				} else {
					Log.ReportEvent("FAIL",
							"Client Login info New Password Error and Confirm Password Error and Old Password Error is not Displayed");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			} else if (ExistsCheck(EdaatOR.ClientLogininfoNewPasswordError)) {

				if (testdatamap.get("Expected").toString().equals(getText(EdaatOR.ClientLogininfoNewPasswordError))) {
					Log.ReportEvent("PASS", "Client Login info New Password Error is Displayed");
				} else {
					Log.ReportEvent("FAIL", "Client Login info New Password Error is not Displayed");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			} else if (ExistsCheck(EdaatOR.ClientLogininfoConfiPasswordError)) {
				if (testdatamap.get("Expected").toString().equals(getText(EdaatOR.ClientLogininfoConfiPasswordError))) {
					Thread.sleep(1000);
					Log.ReportEvent("PASS", "Client Login info Confirm Password Error is Displayed");
				} else {
					Log.ReportEvent("FAIL", "Client Login info Confirm Password Error is not Displayed");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			} else if (ExistsCheck(EdaatOR.ClientLogininfoOldPasswordInvalid)) {
				if (testdatamap.get("Expected").toString().equals(getText(EdaatOR.ClientLogininfoOldPasswordInvalid))) {
					Log.ReportEvent("PASS", "Client Login info Old Password Invalid  Error is Displayed");
				}
			} else {
				Log.ReportEvent("FAIL", "Client Login info Old Password Invalid  Error is not Displayed");
				this.takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Client Login info Old Password Error is not Displayed");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		}

	}

	// Function summary :Method to UpdateClientProfileAllfieldsError
	public void UpdateClientProfileAllfieldsError(Map<Object, Object> testdatamap, Log Log) throws Exception {
		try {
			String Field = testdatamap.get("TextField").toString();
			if (Field.equalsIgnoreCase("All")) {
				if (getText(EdaatOR.ClientMyaccount_FirstnameError).equals(testdatamap.get("Expected1").toString())) {
					Log.ReportEvent("PASS", "Verify Error message for FirstName is successful");
				} else {
					Log.ReportEvent("FAIL", "Verify Error message for FirstName is Unsuccessful");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
				if (getText(EdaatOR.ClientMyaccount_SecondnameError).equals(testdatamap.get("Expected1").toString())) {
					Log.ReportEvent("PASS", "Verify Error message for SecondName is successful");
				} else {
					Log.ReportEvent("FAIL", "Verify Error message for SecondName is Unsuccessful");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
				if (getText(EdaatOR.ClientMyaccount_thirdnameError).equals(testdatamap.get("Expected1").toString())) {
					Log.ReportEvent("PASS", "Verify Error message for ThirdName is successful");
				} else {
					Log.ReportEvent("FAIL", "Verify Error message for ThirdName is Unsuccessful");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
				if (getText(EdaatOR.ClientMyaccount_lastnameError).equals(testdatamap.get("Expected1").toString())) {
					Log.ReportEvent("PASS", "Verify Error message for LastName is successful");

				} else {
					Log.ReportEvent("FAIL", "Verify Error message for LastName is Unsuccessful");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
				if (getText(EdaatOR.ClientMyaccount_DateofbirthError).equals(testdatamap.get("Expected1").toString())) {
					Log.ReportEvent("PASS", "Verify Error message for DathOfBirth is successful");
				} else {
					Log.ReportEvent("FAIL", "Verify Error message for DathOfBirth is Unsuccessful");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
				if (getText(EdaatOR.ClientMyaccount_DateofbirthHijiriError)
						.equals(testdatamap.get("Expected1").toString())) {
					Log.ReportEvent("PASS", "Verify Error message for DateOfBirthHijiri is successful");
				} else {
					Log.ReportEvent("FAIL", "Verify Error message for DateOfBirthHijiri is Unsuccessful");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
				if (getText(EdaatOR.ClientMyaccount_MobilenumError).equals(testdatamap.get("Expected1").toString())) {
					Log.ReportEvent("PASS", "Verify Error message for MobileNumber is successful");
				} else {
					Log.ReportEvent("FAIL", "Verify Error message for MobileNumber is Unsuccessful");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			}

			else if (CheckElementExists(EdaatOR.ClientMyaccount_FirstnameError)) {

				if (getText(EdaatOR.ClientMyaccount_FirstnameError).equals(testdatamap.get("Expected2").toString())) {
					Log.ReportEvent("PASS", "Verify Error message for FirstName is successful");
				} else {
					Log.ReportEvent("FAIL", "Verify Error message for FirstName is Unsuccessful");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}

			} else if (CheckElementExists(EdaatOR.ClientMyaccount_SecondnameError)) {
				if (getText(EdaatOR.ClientMyaccount_SecondnameError).equals(testdatamap.get("Expected2").toString())) {

					Log.ReportEvent("PASS", "Verify Error message for SecondName is successful");
				} else {
					Log.ReportEvent("FAIL", "Verify Error message for SecondName is Unsuccessful");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			} else if (CheckElementExists(EdaatOR.ClientMyaccount_thirdnameError)) {
				if (getText(EdaatOR.ClientMyaccount_thirdnameError).equals(testdatamap.get("Expected2").toString())) {

					Log.ReportEvent("PASS", "Verify Error message for ThirdName is successful");
				} else {
					Log.ReportEvent("FAIL", "Verify Error message for ThirdName is Unsuccessful");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			} else if (CheckElementExists(EdaatOR.ClientMyaccount_lastnameError)) {
				if (getText(EdaatOR.ClientMyaccount_lastnameError).equals(testdatamap.get("Expected2").toString())) {

					Log.ReportEvent("PASS", "Verify Error message for LastName is successful");
				} else {
					Log.ReportEvent("FAIL", "Verify Error message for LastName is Unsuccessful");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			} else if (CheckElementExists(EdaatOR.ClientMyaccount_DateofbirthError)
					&& CheckElementExists(EdaatOR.ClientMyaccount_DateofbirthHijiriError)) {
				if (getText(EdaatOR.ClientMyaccount_DateofbirthError).equals(testdatamap.get("Expected2").toString())
						&& (getText(EdaatOR.ClientMyaccount_DateofbirthHijiriError)
								.equals(testdatamap.get("Expected2").toString()))) {

					Log.ReportEvent("PASS", "Verify Error message for DathOfBirth and DateOfBirthHitiji is successful");
				} else {
					Log.ReportEvent("FAIL",
							"Verify Error message for DathOfBirth and DateOfBirthHitiji is Unsuccessful");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			} else if (CheckElementExists(EdaatOR.ClientMyaccount_MobilenumError)) {
				if (getText(EdaatOR.ClientMyaccount_MobilenumError).equals(testdatamap.get("Expected2").toString())) {

					Log.ReportEvent("PASS", "Verify Error message for MobileNumber is successful");
				} else {
					Log.ReportEvent("FAIL", "Verify Error message for MobileNumber is Unsuccessful");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			}

			else {
				Log.ReportEvent("FAIL", "Update Client Profile All fields Error is not Displayed");
				takeScreenShot();
				driver.quit();
				Assert.fail();

			}
		}

		catch (Exception e) {
			Log.ReportEvent("FAIL", "Update Client Profile All fields Error is not Displayed");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

	// Function summary :Method to UpdateClientProfile
	public void UpdateClientProfile(Map<Object, Object> testdatamap, Log Log) throws InterruptedException {
		try {
			String BirthDate = testdatamap.get("Birthdate").toString();
			WebClickUsingJS(EdaatOR.ClientMyAccUpdateProfileMenu);
			if (ExistsCheck(EdaatOR.ClientMyAccUpdateClientLoginHeader)) {
				Log.ReportEvent("PASS", "Update Client Login Page is Loaded Successfully");
				if (IsDispalyed(EdaatOR.ClientMyAccUpdateClientLoginHeader)) {
					WebClearandEdit(EdaatOR.ClientMyaccount_Firstname, testdatamap.get("FirstName").toString());
					Thread.sleep(1500);
					WebClearandEdit(EdaatOR.ClientMyAccUpdateProfileSecondName,
							testdatamap.get("SecondName").toString());
					Thread.sleep(1500);
					WebClearandEdit(EdaatOR.ClientMyAccUpdateProfileThirdName, testdatamap.get("ThirdName").toString());
					Thread.sleep(1500);
					WebClearandEdit(EdaatOR.ClientMyAccUpdateProfileLastName, testdatamap.get("LastName").toString());
					Thread.sleep(1500);
				} else {
					Log.ReportEvent("FAIL", "Update Client Login Page is not Loaded Successfully");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
				if (BirthDate.equalsIgnoreCase("No")) {
					// WebClearandEdit(EdaatOR.ClientMyaccount_Dateofbirth, testdatamap.get("Date of
					// Birth").toString());
					WebClear(EdaatOR.ClientMyaccount_Dateofbirth);
					Thread.sleep(1500);
					WebClear(EdaatOR.ClientMyaccount_DateofbirthHijiri);
					Thread.sleep(1500);
				}
				WebClearandEdit(EdaatOR.ClientMyAccUpdateProfileMobNumber, testdatamap.get("MobileNumber").toString());
				Thread.sleep(1500);
				WebClick(EdaatOR.ClientMyAccUpdateProfileSaveChangesBTN);
				Log.ReportEvent("PASS", "Update Client Login Details Updated Successfully");
				UpdateClientProfileAllfieldsError(testdatamap, Log);
			}

		} catch (Exception e) {
			Log.ReportEvent("FAIL", "Update Client Login Details not Updated");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	}

}
