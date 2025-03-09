/**
* Test Script Name  				 : N/A
* Objective                             : Verify the Individual Client Functionality.
* Version      						 : 1.0
* Author       						 : Kathirvelu M
* Created Date 			      		 : 17/05/2023
* Last Updated on					 : N/A
* Updated By   			 			 : Basavaraj Mudnur
* Pre-Conditions					 : N/A
* Epic Details						 : N/A
* User Story Details				 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.biller.pages;

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
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.azmqalabs.edaattestautomation.common.Log;



public class BillerIndividualClientPage extends BasePage
{

	public BillerIndividualClientPage(WebDriver driver,ExtentTest test)
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

		// Function Summary : Method to create Individual client
		// Parameter Summary:
		// CorporateName,CRNumber,PersonName,PersonID,MobileNo,Email,ClientRefno.
		public void AddIndividualclient(String FullName, String SecondName, String ThirdName, String LastName,
				String NationalID, String Year, String Month, String Date, String MobileNo, String Email, String Refno,
				Log Log) {
			Addclient(FullName, SecondName, ThirdName, LastName, NationalID, Year, Month, Date, MobileNo, Email, Refno,
					Log);

		}
		
		public void gridView(Log log) {
			try {
				Thread.sleep(2000);
				WebClear(EdaatOR.Biller_Individualclient_SearchByname);
				WebEdit(EdaatOR.Biller_Individualclient_SearchByname, "Fullname");
				WebClick(EdaatOR.Biller_Individualclient_Search);
				Thread.sleep(1500);
				WebClick(EdaatOR.Biller_Corpclient_Searchname);
				Thread.sleep(1500);
				switchTonextwindow();
				scrollDowntillend(driver);
				if (ExistsCheck(EdaatOR.Biller_Individualclient_Back)) {
					WebClick(EdaatOR.Biller_Individualclient_Back);
					log.ReportEvent("PASS", " Grid View is Successful");
				} else {
					log.ReportEvent("FAIL", " Grid View is not Successful");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			} catch (Exception e) {
				log.ReportEvent("FAIL", " Grid View is not Successful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}

		public void activateOrDeactivate(Log log) {
			try {

				WebEdit(EdaatOR.Biller_Individualclient_SearchByname, "Fullname");
				WebClick(EdaatOR.Biller_Individualclient_Search);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Biller_Individualclient_Deactivate);
				Thread.sleep(2000);
				WebClick(EdaatOR.Biller_Individualclient_button);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Biller_Individualclient_Deactivate);
				Thread.sleep(2000);
				WebClick(EdaatOR.Biller_Individualclient_button);
				if (ExistsCheck(EdaatOR.Biller_Individualclient_button)
						|| ExistsCheck(EdaatOR.Biller_Individualclient_Deactivate)) {
					log.ReportEvent("PASS", " Activate/Deactivate Client is Successful");
				} else {
					log.ReportEvent("FAIL", " Activate/Deactivate Client is not Successful");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}

			} catch (Exception e) {
				log.ReportEvent("FAIL", " Activate/Deactivate Client is not Successful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}

		public void ClickExcelCheck(Log log) {
			try {
				if (ExistsCheck(EdaatOR.Biller_Individualclient_export)) {
					WebClick(EdaatOR.Biller_Individualclient_export);
					Thread.sleep(2000);
					log.ReportEvent("PASS", " Click on Export to Excel is Successful");
				} else {
					log.ReportEvent("FAIL", " Click on Export to Excel is not Successful");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			} catch (Exception e) {
				log.ReportEvent("FAIL", " Click on Export to Excel is not Successful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}
	
			// Function Summary : Method to Search Individual Client and View Invoice
			// details of Client and Navigate back.
			// Parameter Summary : client,View.
			public void Action(String Action, Log Log) throws InterruptedException {
				NavigateToIndividualClientsList(Log);
				if (Action.equalsIgnoreCase("View")) {
					gridView(Log);
				}
				// Function Summary : Method to Search Individual Client and deactivate and
				// activate Client status.
				// Parameter Summary : Deactivate,Fullname.
				else if (Action.equalsIgnoreCase("Deactivate")) {
					activateOrDeactivate(Log);
				}
				// Function Summary : Method to verify the Export to Excel Functionality.
				// Parameter Summary : Excel.
				else if (Action.equalsIgnoreCase("Excel")) {
					ClickExcelCheck(Log);
				}

			}
	
	public void TableGridview(){
	    try{
	    	WebClickUsingJS(EdaatOR.Biller_Add_Individualclient);
	    	Thread.sleep(1000);	    
	    	if(CheckElementExists(EdaatOR.Biller_Invoice_table)==true) {
    			Thread.sleep(2000);
    			WebClear(EdaatOR.Biller_Individualclient_SearchByname);
    			WebEdit(EdaatOR.Biller_Individualclient_SearchByname, "client");        			
    			WebClick(EdaatOR.Biller_Individualclient_Search);
    			Thread.sleep(1000);
    			WebClick(EdaatOR.Biller_Corpclient_Searchname);
    			Thread.sleep(1000);
    			switchTonextwindow();
    			scrollDowntillend(driver);
    			this.takeScreenShot();
    			WebClick(EdaatOR.Biller_Individualclient_Back);
    			test.log(Status.PASS,"Individual Client Table Exists" + driver.getTitle() +" * Individual Client Table Exists PASS * " );
	    		}
	    	else {
	    		test.log(Status.FAIL,"Individual Client Table Not Exists" + driver.getTitle() +" * Individual Client Table Not Exists FAIL * " );
	    	}
	    }catch(Exception e){
	    	test.log(Status.FAIL,"Table View Individual client" + driver.getTitle() +" * Table View Individual client FAIL * " );
	        this.takeScreenShot();
	    }
	}
	
	
	public void Export(){
	    try{
	    	WebClickUsingJS(EdaatOR.Biller_Add_Individualclient);
	    	Thread.sleep(1000);	
	    	if(CheckElementClickable(EdaatOR.Biller_Individualclient_export)==true) {
	    		WebClick(EdaatOR.Biller_Individualclient_export);
				Thread.sleep(2000);    			
				test.log(Status.PASS,"Export Individual client Done" + driver.getTitle() +" * Export Individual client Done PASS * " );
	    	}
	    	else {
	    		test.log(Status.FAIL,"Export Individual client Not Done" + driver.getTitle() +" * Export Individual client Not Done FAIL  * " );
	    	}
	    }catch(Exception e){
	    	test.log(Status.FAIL," Export Individual client Not Done " + driver.getTitle() +" * Export Individual client Not Done FAIL * " );
	        this.takeScreenShot();
	    }
	}	
	
	public void ActivateDeactivate(Map<Object,Object> testdatamap){
	    try{
	    	WebClickUsingJS(EdaatOR.Biller_Add_Individualclient);
	    	Thread.sleep(1000);	
	    	if(CheckElementExists(EdaatOR.Biller_Individualclient_Deactivate)==true) {
	    		WebEdit(EdaatOR.Biller_Individualclient_SearchByname,testdatamap.get("ClintName").toString());        			
				Thread.sleep(2000);
	    		WebClickUsingJS(EdaatOR.Biller_Individualclient_Search);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Biller_Individualclient_Deactivate);
				Thread.sleep(2000);
				WebClick(EdaatOR.Biller_Individualclient_button);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Biller_Individualclient_Deactivate);
				Thread.sleep(2000);
				WebClick(EdaatOR.Biller_Individualclient_button);
				this.takeScreenShot();
				test.log(Status.PASS,"Individual Client Deactivate/Activate Done" + driver.getTitle() +" * Individual Client Deactivate/Activate Done PASS * " );
	    	}
	    	else {
	    		test.log(Status.FAIL,"Individual Client Deactivate/Activate Not Done" + driver.getTitle() +" * Individual Client Deactivate/Activate Not Done FAIL  * " );
	    		}
	    }catch(Exception e){
	    	test.log(Status.FAIL," Individual Client Deactivate/Activate Not Done " + driver.getTitle() +" * Individual Client Deactivate/Activate Not Done FAIL * " );
	        this.takeScreenShot();
	    }
	}	
	//Function Summary   : Method to Download Individual Client inovice details.	
	//Parameter Summary  : NationalID,FullName,Refno.
public void Download(Map<Object,Object> testdatamap,Log Log){
    try{
    	NavigateToIndividualClientsList(Log);
		boolean Ele=BillerSearchIndividualclient(testdatamap.get("NationalID").toString(),testdatamap.get("FullName").toString(),Log);
		Thread.sleep(4000);
    	if(Ele==true) {
			Thread.sleep(2000);		
			WebClick(EdaatOR.Biller_InvoiceName);
    		waitForPageToLoad();
    		switchTonextwindow();
    		Thread.sleep(4000);
    		
    		if(getText(EdaatOR.Biller_ViewClientInfo_Page).equals("View Client info")) {
            Log.ReportEvent("PASS", "'View Client info' Page is Loaded Successfully");
    		WebClickUsingJS(EdaatOR.Biller_Imgdownload);
    		Thread.sleep(4000);
         	Log.ReportEvent("PASS", " Download ID Image is Successful");
    		}
    		else {
            Log.ReportEvent("FAIL", "'View Client info' Page is not Loaded Successfully");
            takeScreenShot();
            driver.quit();
            Assert.fail();
    		}
    	}else {
    		Log.ReportEvent("FAIL", " Download ID Image is not Successful");
         	takeScreenShot();
         	driver.quit();
            Assert.fail();
    	}
	}catch(Exception e){
		Log.ReportEvent("FAIL", " Download ID is Image not Successful");
     	takeScreenShot();
     	driver.quit();
        Assert.fail();
	}
}
//Function Summary : Method to Search "client" 
//Parameter Summary: NationalID,FullName,.
	public boolean BillerSearchIndividualclient(String NationalID,String  FullName,Log log){
	boolean existsElement = false;
	try{          	
        	WebEdit(EdaatOR.Biller_Individualclient_IdNumber,NationalID);
        	Thread.sleep(2000);
			WebEdit(EdaatOR.Biller_Individualclient_Cname,FullName);
        	Thread.sleep(3000);
        	WebClickUsingJS(EdaatOR.Biller_Individualclient_Search);
        	Thread.sleep(3000);
        	if(CheckElementExists("//td[text()='"+NationalID+"']")==true) {
        		existsElement=true;
        		Thread.sleep(2000);
        		log.ReportEvent("PASS", "Individual Client Search is Successful");
		    }
        	else {
        		log.ReportEvent("FAIL", "Individual Client Search is not Successful");
        		this.takeScreenShot();
        		driver.quit();
        		Assert.fail();
        	}	    
    }catch(Exception e){
    	log.ReportEvent("FAIL", "Individual Client Search is not Successful");
		this.takeScreenShot();
		driver.quit();
		Assert.fail();
    }
    return existsElement;
}
 	//Function Summary   : Method to Search Individual Client.	
	//Parameter Summary   : NationalID,ClientName,Refno.
public boolean BillerSearchIndividualclientall(String ClientName,String NationalID,String Refno,Log Log){
	boolean existsElement = false;
	try{
		 	NavigateToIndividualClientsList(Log);
        	WebEdit(EdaatOR.Biller_Individualclient_Name,ClientName);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_Individualclient_Search);
			Thread.sleep(1000);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_Individualclient_IdNumber,NationalID);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_Individualclient_CustomerRefNumber,Refno);
			Thread.sleep(1000);
        	WebClickUsingJS(EdaatOR.Biller_Individualclient_Search);
			Thread.sleep(3000);
//        	existsElement=ExistsCheck("//td[text()='"+NationalID+"']");
//			Thread.sleep(2000);
			if(CheckElementExists("//td[text()='"+NationalID+"']") == true) {
  			Log.ReportEvent("PASS", " Individual Client  Search is Successful");
			}
			else {
				Log.ReportEvent("FAIL", " Individual Client  Search is not Successful");
		        this.takeScreenShot();
		        driver.quit();
		        Assert.fail();
			}
    }catch(Exception e){
			Log.ReportEvent("FAIL", " Individual Client  Search is not Successful");
        this.takeScreenShot();
        driver.quit();
        Assert.fail();
    }
    return existsElement;
}

public void NavigateToIndividualClientsList(Log log) throws InterruptedException {
	try {
		WebClickUsingJS(EdaatOR.Biller_Add_Individualclient);
		Thread.sleep(2000);
		if (getText(EdaatOR.Biller_IndividualORCorporateclientList_Page).equals("Individual Clients List")) {
			log.ReportEvent("PASS", "'Individual Clients List' Page is Loaded Successfully");
		} else {
			log.ReportEvent("FAIL", "'Individual Clients List' Page is not Loaded Successfully");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	} catch (Exception e) {
		log.ReportEvent("FAIL", "'Individual Clients List' Page is not Loaded Successfully");
		takeScreenShot();
		driver.quit();
		Assert.fail();
	}
}
public void NavigateToCorporateClientsList(Log log) throws InterruptedException {
	try {
    WebClickUsingJS(EdaatOR.Biller_Add_Companyclient);
	Thread.sleep(2000);
	if(getText(EdaatOR.Biller_IndividualORCorporateclientList_Page).equals("Corporate Clients List")) {
	log.ReportEvent("PASS", "'Corporate Clients List' Page is Loaded Successfully");
	}
	else {
		log.ReportEvent("FAIL", "'Corporate Clients List' Page is not Loaded Successfully");
		takeScreenShot();
		driver.quit();
		Assert.fail();
	}
	}
	catch (Exception e) {
		log.ReportEvent("FAIL", "Navigate to 'Corporate Clients List' Page is not Loaded Successfully");
		takeScreenShot();
		driver.quit();
		Assert.fail();	}
}

public void NavigateToAddIndividualClients(Log log) throws InterruptedException {
	try {
		WebClickUsingJS(EdaatOR.Biller_Add_Individualclient_Button);
		Thread.sleep(2000);
		if (getText(EdaatOR.Biller_AddIndividualclientORCorporateClient_Page).equals("Add Individual Clients")) {
			log.ReportEvent("PASS", "'Add Individual Clients' Page is Loaded Successfully");
		} else {
			log.ReportEvent("FAIL", "'Add Individual Clients' Page is not Loaded Successfully");
			takeScreenShot();
			driver.quit();
			Assert.fail();
		}
	} catch (Exception e) {
		log.ReportEvent("FAIL", "'Add Individual Clients' Page is not Loaded Successfully");
		takeScreenShot();
		driver.quit();
		Assert.fail();
	}
}

//Function Summary : "Navigate to  add Individual clients" page and enter all details and Create Individual client 
//Parameter Summary: CorporateName,CRNumber,PersonName,PersonID,MobileNo,Email,ClientRefno,Year,Month,Refno.
public void Addclient(String FullName,String SecondName,String ThirdName,String LastName,String NationalID,String Year,String Month,String Date,String MobileNo,String Email,String Refno,Log log){
	try{
			NavigateToIndividualClientsList(log);
			NavigateToAddIndividualClients(log);
        	WebEdit(EdaatOR.Biller_Individualclient_fname,FullName);
        	WebEdit(EdaatOR.Biller_Individualclient_sname,SecondName);
        	WebEdit(EdaatOR.Biller_Individualclient_tname,ThirdName);
        	WebEdit(EdaatOR.Biller_Individualclient_lname,LastName);
        	WebEdit(EdaatOR.Biller_Individualclient_IdNumber,NationalID);
        	WebClick(EdaatOR.Biller_Individualclient_DateOfBirth);
        	selectDropdownValue_PartialText(EdaatOR.Biller_Individualclient_DateOfYear, Year);
        	selectDropdownValue_PartialText(EdaatOR.Biller_Individualclient_DateOfMonth, Month);
        	WebClick("//a[text()='"+Date+"']");
        	WebEdit(EdaatOR.Biller_Individualclient_Email,Email);
        	WebEdit(EdaatOR.Biller_Individualclient_Refno,Refno);
        	Thread.sleep(2000);            	
        	WebEdit(EdaatOR.Biller_Individualclient_MobileNo,MobileNo);
        	Thread.sleep(2000);            	
        	WebClickUsingJS(EdaatOR.Biller_Individualclient_Add);
        	Thread.sleep(2000);            	
        	if(getText(EdaatOR.Biller_AlertMsg).equals("The client with the national ID number entered is already registered") 
        	|| getText(EdaatOR.Biller_FirstNameErrorMsg).equals("Please use only characters") 
        	|| getText(EdaatOR.Biller_SecondNameErrorMsg).equals("Please use only characters") 
        	|| getText(EdaatOR.Biller_ThirdNameErrorMsg).equals("Please use only characters") 
        	|| getText(EdaatOR.Biller_LastNameErrorMsg).equals("Please use only characters")
        	|| getText(EdaatOR.Biller_NationalIDErrorMsg).equals("Please enter a 10-digit number")
        	|| getText(EdaatOR.Biller_MobileNoErrorMsg).equals("The mobile number entered is incorrect")
        	|| getText(EdaatOR.Biller_EmailErrorMsg).equals("Invalid email")) {
        		log.ReportEvent("FAIL", "Individual Client is not Added Successfully");
        		this.takeScreenShot();
        		driver.quit();
        		Assert.fail();
        	}
        	else {
        		System.out.println("Individual Client created");
	        	log.ReportEvent("PASS", "Individual Client is Added Successfully");
        		BillerSearchIndividualclient(NationalID,FullName,log);
         	}
        	
    }catch(Exception e){
    	log.ReportEvent("FAIL", "Individual Client is not Added Successfully");
		this.takeScreenShot();
		driver.quit();
		Assert.fail();
    }
}

//Function Summary : "Navigate to  add Individual clients" page and enter all details and Create Individual client 
//Parameter Summary: CorporateName,CRNumber,PersonName,PersonID,MobileNo,Email,ClientRefno,Year,Month,Refno.
public void AddclientDelete(String FullName, String SecondName, String ThirdName, String LastName, String NationalID,
		String Year, String Month, String Date, String MobileNo, String Email, String Refno, String ResonforDelete,
		Log log) {
	try {
		NavigateToIndividualClientsList(log);
		NavigateToAddIndividualClients(log);
		WebEdit(EdaatOR.Biller_Individualclient_fname, FullName);
		WebEdit(EdaatOR.Biller_Individualclient_sname, SecondName);
		WebEdit(EdaatOR.Biller_Individualclient_tname, ThirdName);
		WebEdit(EdaatOR.Biller_Individualclient_lname, LastName);
		WebEdit(EdaatOR.Biller_Individualclient_IdNumber, NationalID);
		WebClick(EdaatOR.Biller_Individualclient_DateOfBirth);
		selectDropdownValue_PartialText(EdaatOR.Biller_Individualclient_DateOfYear, Year);
		selectDropdownValue_PartialText(EdaatOR.Biller_Individualclient_DateOfMonth, Month);
		WebClick("//a[text()='" + Date + "']");
		WebEdit(EdaatOR.Biller_Individualclient_Email, Email);
		WebEdit(EdaatOR.Biller_Individualclient_Refno, Refno);
		Thread.sleep(2000);
		WebEdit(EdaatOR.Biller_Individualclient_MobileNo, MobileNo);
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Biller_Individualclient_Add);
		Thread.sleep(3000);
		if (getText("//div[@id='alert-error']")
				.equals("The client with the national ID number entered is already registered")
				|| ExistsCheck("//span[@id='FirstName-error']")
				|| ExistsCheck("//span[@id='SecondName-error']")
				|| ExistsCheck("//span[@id='ThirdName-error']")
				|| ExistsCheck("//span[@id='LastName-error']")
				|| ExistsCheck("//span[@id='IdNumber-error']")
				|| ExistsCheck("//span[@id='MobileNo-error']")
				|| ExistsCheck("//span[@id='Email-error']")) {
			log.ReportEvent("FAIL", "Individual Client is not Added Successfully");
			this.takeScreenShot();
			driver.quit();
			Assert.fail();
		} else {
			System.out.println("Individual Client created");
			log.ReportEvent("PASS", "Individual Client is Added Successfully");
			boolean Ele = BillerSearchIndividualclient(NationalID, FullName, log);
			if (Ele == true) {
				boolean Ele1 = DeleteIndClient(NationalID, ResonforDelete, log);
				if (Ele1 == true) {
					log.ReportEvent("PASS", "Individual Client Delete is Successful");
				} else {
					log.ReportEvent("FAIL", "Individual Client Delete is not Successful");
					this.takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			}
		}

	} catch (Exception e) {
		log.ReportEvent("FAIL", "Individual Client Delete is not Successful");
		this.takeScreenShot();
		driver.quit();
		Assert.fail();
	}
}

	//Function Summary : Method to delete Individual client 
	//Parameter Summary: CorporateName, CRNumber, PersonName, PersonID, MobileNo, Email,ClientRefno,ResonforDelete 
public void DeleteIndividualClient(String FullName,String SecondName,String ThirdName,String LastName,String NationalID,String Year,String Month,String Date,String MobileNo,String Email,String Refno,String ResonforDelete,Log Log){
    	AddclientDelete(FullName,SecondName,ThirdName,LastName,NationalID,Year,Month,Date,MobileNo,Email,Refno,ResonforDelete,Log);
}

//Function Summary : Method to delete Individual client and check "deletedcheckbox".
//Parameter Summary: ClientRefno,ResonforDelete,Delete	
public boolean DeleteIndClient(String NationalID,String ResonforDelete,Log log){
	boolean existsNID = false;
	try{
    	if(getText("//td[text()='"+NationalID+"']").equals(NationalID)){
    	selectDropdownValue_PartialText(EdaatOR.Biller_Invoice_Delete,"Delete");
    	Thread.sleep(2000);    	
    	WebClick(EdaatOR.Biller_Invoice_Reasontxt);
    	Thread.sleep(1000);
    	WebClick("//li[text()='"+ResonforDelete+"']");
    	Thread.sleep(3000);
    	WebClick(EdaatOR.Biller_Invoice_Deletebtn);
    	Thread.sleep(2000);
    	WebEdit(EdaatOR.Biller_Individualclient_IdNumber,NationalID);
    	Thread.sleep(2000);
    	WebClick(EdaatOR.Biller_Invoice_Deletechkbox);
    	Thread.sleep(2000);
    	WebClick(EdaatOR.Biller_Individualclient_Search);
    	Thread.sleep(2000);
    	if(CheckElementExists("//td[text()='"+NationalID+"']")==true) {
	    	existsNID=true;
	    }
    	}
    	    	
    }catch (Exception e) {
    	log.ReportEvent("FAIL", "Individual Client Delete is not Successful");
        this.takeScreenShot();
        driver.quit();
  		Assert.fail();
	}
	return existsNID;
    }

//Function Summary   : Method to Update Individual client   
//Parameter Summary : FullName, SecondName, ThirdName, LastName, NationalID, Year, Month, Date, MobileNo, Email.
	public void UpdateIndividualClient(String FullName, String SecondName, String ThirdName, String LastName,
			String NationalID, String Year, String Month, String Date, String MobileNo, String Email, String Refno,
			Log Log) {
		UpdateIndClient(FullName, SecondName, ThirdName, LastName, Year, Month, Date, MobileNo, Email, Refno, Log);

	}



//Function Summary   : Method to Enter Details to Update Individual client   
//Parameter Summary : FullName, Seco
public boolean UpdateIndClient(String FullName,String SecondName,String ThirdName,String LastName,String Year,String Month,String Date,String MobileNo,String Email,String Refno, Log log){
	boolean existsNID = false;
	try{	
    	NavigateToIndividualClientsList(log);
    	selectDropdownValue_PartialText(EdaatOR.Biller_Invoice_Delete,"Edit");
    	Thread.sleep(1000);	    	
    	switchTonextwindow();
    	Thread.sleep(1000);
    	if (getText(EdaatOR.Biller_EditIndividualClientData_Page).equals("Edit individual client data")) {
    		log.ReportEvent("PASS","Navigate to 'Edit Individual Client Data' Page is Loaded Successfully");
    		WebClear(EdaatOR.Biller_Individualclient_fname);
        	WebEdit(EdaatOR.Biller_Individualclient_fname,FullName);
        	WebClear(EdaatOR.Biller_Individualclient_sname);
        	WebEdit(EdaatOR.Biller_Individualclient_sname,SecondName);
        	WebClear(EdaatOR.Biller_Individualclient_tname);
        	WebEdit(EdaatOR.Biller_Individualclient_tname,ThirdName);
        	WebClear(EdaatOR.Biller_Individualclient_lname);
        	WebEdit(EdaatOR.Biller_Individualclient_lname,LastName);
        	WebClick(EdaatOR.Biller_Individualclient_DateOfBirth);
        	selectDropdownValue_PartialText(EdaatOR.Biller_Individualclient_DateOfYear, Year);
        	selectDropdownValue_PartialText(EdaatOR.Biller_Individualclient_DateOfMonth, Month);
        	WebClick("//a[text()='"+Date+"']");
        	WebClear(EdaatOR.Biller_Individualclient_MobileNo);
        	WebEdit(EdaatOR.Biller_Individualclient_MobileNo,MobileNo);
        	WebClear(EdaatOR.Biller_Individualclient_Email);
        	WebEdit(EdaatOR.Biller_Individualclient_Email,Email);
        	WebClear(EdaatOR.Biller_Individualclient_Refno);
        	WebEdit(EdaatOR.Biller_Individualclient_Refno,Refno);
           	Thread.sleep(2000);	    	 	
        	WebClick(EdaatOR.Biller_Individualclient_Add);
        	Thread.sleep(2000);
        	if(getText("//div[@id='alert-error']").equals("The client with the national ID number entered is already registered") 
                	|| getText("//span[@id='FirstName-error']").equals("Please use only characters") 
                	|| getText("//span[@id='SecondName-error']").equals("Please use only characters") 
                	|| getText("//span[@id='ThirdName-error']").equals("Please use only characters") 
                	|| getText("//span[@id='LastName-error']").equals("Please use only characters")
                	|| getText("//span[@id='IdNumber-error']").equals("Please enter a 10-digit number")
                	|| getText("//span[@id='MobileNo-error']").equals("The mobile number entered is incorrect")
                	|| getText("//span[@id='Email-error']").equals("Invalid email")) {
            	log.ReportEvent("FAIL", " Upadate Individual Client is not Successful");
            	takeScreenShot();
            	driver.quit();
            	Assert.fail();
        	}
        	else {
        		if(CheckElementExists("//td[text()='"+MobileNo+"']")==true) {
        	    	existsNID=true;
            	Thread.sleep(2000);	 
    		}
            	log.ReportEvent("PASS", " Upadate Individual Client is Successful");

    	    }
    	}
    	else {
    		log.ReportEvent("FAIL","Navigate to 'Edit individual client data' Page is not Loaded Successfully");
    		takeScreenShot();
        	driver.quit();
        	Assert.fail();
    	}	    
    }catch (Exception e) {
    	log.ReportEvent("FAIL", " Upadate Individual Client is not Successful");
    	takeScreenShot();
    	driver.quit();
    	Assert.fail();
	}
	return existsNID;
    }


public int getInvoiceCountNext() throws Exception {
	int intiCount=0;
	boolean countRow=false;
	while (CheckElementExists(EdaatOR.Biller_Invoice_Next)==false){  
		WebClick(EdaatOR.Biller_Invoice_NextBtn);
		Thread.sleep(1000);
		intiCount=intiCount+getInvoiceCount()+10;
		countRow=true;
	}
	
	if(countRow==false) {
		intiCount=10;
	}
	return intiCount;
}
public int getInvoiceCount() {
	List<WebElement> invoice = driver.findElements(By.xpath(EdaatOR.Biller_Invoice_Count));
	waitForPageToLoad();
	int count =invoice.size();
	return count;
}
public void naviagteCreateInvoicePage() {
	ClickOnExportInvoiceBtn();
	waitForPageToLoad();

}
public void ClickOnExportInvoiceBtn() {
	WebClickUsingJS(EdaatOR.Biller_AddInvoice_btn);
	waitForPageToLoad();
}
public void enterClientNameOrNationalID(Map<Object,Object> testdatamap) throws Exception {
	String client=testdatamap.get("ClientID").toString();
	if(client.equalsIgnoreCase("Individual")) {
		ClickOnIndividualRadBtn();
	}
	else if(client.equalsIgnoreCase("Corporate")){
		ClickOnCoporateRadBtn();
	}

	SelectCustomerID(testdatamap.get("ClientName").toString());
	String sBill=testdatamap.get("SubBiller").toString();
	if(!sBill.equalsIgnoreCase("")) {
			SelectSubBiller(sBill);
		}

	}
	public void SelectSubBiller(String SubBiller) {
		WebSelect(EdaatOR.Biller_Invoice_SBilIdList,SubBiller);
		waitForPageToLoad();
	}
public void SelectCustomerID(String Cust) throws Exception {
		
		WebClick(EdaatOR.Biller_Invoice_CustIDListindi);
		Thread.sleep(500);
		WebClick(EdaatOR.Biller_Invoice_ClientRoleId+"["+Cust+"]");
	waitForPageToLoad();
}
public void ClickOnCoporateRadBtn() {
	WebClickUsingJS(EdaatOR.Biller_Invoice_CopoRdv);
	waitForPageToLoad();
}

public void ClickOnIndividualRadBtn() {
	WebClickUsingJS(EdaatOR.Biller_Invoice_IndividualRdv);
	waitForPageToLoad();
}


//Function Summary : Method to select "Invoice Template"from dropdown   
//Parameter Summary: TemplateName.
public void selectTemplate(String drop,Map<Object,Object> testdatamap) throws Exception {
	Thread.sleep(500);	
	waitForPageToLoad();
	WebSelectByVisibleText(EdaatOR.Biller_Invoice_TemplateList,testdatamap.get("TemplateName").toString());
	waitForPageToLoad();
}

	//Function Summary : Method to select "subbiller" and select "Name or register number" of subbiller from dropdowns  
	//Parameter Summary: SubBiller,FixedPrice,FixedPercentage.
public void selectSubbiller(String drop,Map<Object,Object> testdatamap) throws Exception {
	Thread.sleep(500);
	WebClickUsingJS(EdaatOR.Biller_Invoice_Subbill);
	SelectInvoiceTemplate(drop,testdatamap.get("SubBiller").toString());
	waitForPageToLoad();
	EnterFixedPrice(testdatamap.get("FixedPrice").toString());
	EnterPercentage(testdatamap.get("FixedPercentage").toString());	
}

//Function Summary : Method select "Name or Register number" of subbiller from dropdown  
//Parameter Summary: N/A
public void SelectInvoiceTemplate(String sel, String Tem) throws InterruptedException {
	Thread.sleep(500);
	selectDropdownValue_PartialText(sel, Tem);
}

//Function Summary : Method to click on "add product" button in "create invoice"page  
//Parameter Summary: N/A
public void ClickOnProductBtn() {
	WebClickUsingJS(EdaatOR.Biller_Invoice_AddProductBtn);
	waitForPageToLoad();
}

//Function Summary : Method to select "product" from dropdown.  
//Parameter Summary: N/A
public void SelectProduct(String Cust) {
	WebSelect(EdaatOR.Biller_Invoice_ProductID,Cust);
	waitForPageToLoad();
}

//Function Summary : Method to click on "add" button in "add product"popup.  
//Parameter Summary: N/A
public void ClickOnProductAddBtn() throws Exception {
	WebClick(EdaatOR.Biller_Invoice_AddBtn);
	waitForPageToLoad();
}

//Function Summary : Method to enter"Invoice Due Date" in "Create invoice"page 
//Parameter Summary: N/A
public void EnterIssuedDate() throws Exception {
	WebClick(EdaatOR.Biller_Invoice_DateInvoc);
	Thread.sleep(800);
	WebClick(EdaatOR.Biller_RegistDate_exprDate);
}


public void SelectDuration(String dur) {
	WebSelect(EdaatOR.Biller_Invoice_DurationID,dur);
	waitForPageToLoad();
}

public void EnterMinPrice(String Price) throws Exception {
	WebEdit(EdaatOR.Biller_Invoice_MinTax,Price);
	waitForPageToLoad();
}
public void EnterFixedPrice(String Price) throws Exception {
	WebEdit(EdaatOR.Biller_Invoice_Fixed,Price);
	waitForPageToLoad();
}


public void EnterCondition(String Price) throws Exception {
	WebEdit(EdaatOR.Biller_Invoice_Conditon,Price);
	waitForPageToLoad();
}
public void EnterPercentage(String Price)throws Exception {
	WebEdit(EdaatOR.Biller_Invoice_Percentage,Price);
	waitForPageToLoad();
}
public void ClickOnCreateInvoiceBtn() {
	WebClickUsingJS(EdaatOR.Biller_Invoice_CreateReapeat);
	waitForPageToLoad();
}
public void EnterDescriptionSaved(String Price) throws Exception {
	WebEdit(EdaatOR.Biller_Invoice_Descript,Price);
	waitForPageToLoad();
}

public void EnterDescriptionOne(String Price) throws Exception {
	WebEdit(EdaatOR.Biller_Invoice_Descript1,Price);
	waitForPageToLoad();
}
public void ClickOnExportBtn() {
	WebClickUsingJS(EdaatOR.Biller_Invoice_ExportButton);
	waitForPageToLoad();
}

public void ClickOnSaveBtn() {
	WebClickUsingJS(EdaatOR.Biller_Invoice_Create);
	waitForPageToLoad();
}

//Function Summary : Method to add "product" in "add product"popup.
//Parameter Summary: ProductName.
public void addProductDetails(Map<Object,Object> testdatamap) throws Exception {
	ClickOnProductBtn();
	Thread.sleep(1000);
	SelectProduct(testdatamap.get("ProductName").toString());
    	Thread.sleep(2000);	    	
	//EnterProductPrice(testdatamap.get("ProductPrice").toString());
	ClickOnProductAddBtn();
	Thread.sleep(1000);
}

//Function Summary : Method enter "Invoice Due Date" in "Create invoice"page
//Parameter Summary: N/A
public void enterInvoicDetails(Map<Object,Object> testdatamap) throws Exception {
	EnterIssuedDate();
//		SelectDuration(testdatamap.get("Duration").toString());
//		EnterMinPrice(testdatamap.get("MinPrice").toString());
//		EnterCondition(testdatamap.get("InvoiceCondition").toString());
//		ClickOnCreateInvoiceBtn();
	Thread.sleep(1000);
}
public int getInvoiceCountNextAfteradd() throws Exception {
	int aftCount=0;
	boolean countRow=false;
	while (CheckElementExists(EdaatOR.Biller_Invoice_Next)==false){  
		WebClick(EdaatOR.Biller_Invoice_NextBtn);
		Thread.sleep(1000);
		aftCount=aftCount+getInvoiceCountAdd()+10;
		countRow=true;
	}
	
	if(countRow==false) {
		aftCount=10;
	}
	return aftCount;
}

//Function Summary : Method to click on "Create and save" or "Create and Export"button in "create invoice" page
//Parameter Summary: InvoiceType,Save,Export.
public void enterInvoiceCaseType(Map<Object,Object> testdatamap) throws Exception {

//		EnterDescriptionSaved(testdatamap.get("Description").toString());
//		EnterDescriptionOne(testdatamap.get("Description").toString());
	String iType=testdatamap.get("InvoiceType").toString();
	if(iType.equalsIgnoreCase("Save")) {
		ClickOnSaveBtn();
	}
	else if(iType.equalsIgnoreCase("Export")){
		ClickOnExportBtn();
	}
	Thread.sleep(1000);
}

//Function Summary : Method to get the "count of the invoices" in the "Grid view" 
//Parameter Summary: N/A
public int getInvoiceCountAdd() {
	List<WebElement> invoice = driver.findElements(By.xpath(EdaatOR.Biller_Invoice_AfteraddInvoice));
	waitForPageToLoad();
	int count =invoice.size();
	return count;
}

//Function Summary : Method to create Individual client invoice  
//Parameter Summary: Create Invoice,Template Name.
public void CreateIndividualClientInvoice(Map<Object,Object> testdatamap,Log Log) throws Exception {
	try {
		
		NavigateToIndividualClientsList(Log);
    	selectDropdownValue_PartialText(EdaatOR.Biller_Invoice_Delete,"Create Invoice");
    		switchTonextwindow();
			Thread.sleep(1000);
			if (getText(EdaatOR.Biller_CreateInvoice_Page).equals("Create Invoice")) {
	    		Log.ReportEvent("PASS","Navigate to 'Create Invoice' Page is Loaded Successfully");
			selectSubbiller(EdaatOR.Biller_Invoice_SBilIdList,testdatamap);
			Thread.sleep(1000);
			WebClick(EdaatOR.Biller_Invoice_TemplateList);
			WebSelectByVisibleText(EdaatOR.Biller_Invoice_TemplateList,testdatamap.get("TemplateName").toString());
			selectTemplate(EdaatOR.Biller_Invoice_TemplateList,testdatamap);
			addProductDetails(testdatamap);
			enterInvoicDetails(testdatamap);
			enterInvoiceCaseType(testdatamap);
			int val=getInvoiceCountAdd();
			if(CheckElementExists(EdaatOR.Biller_Invoice_AfteraddInvoice+"["+val+"]/td[10]")==true){
				Log.ReportEvent("PASS", "Create Individual Client Invoice is Successful");
			}
			else{
				Log.ReportEvent("FAIL", "Create Individual Client Invoice is not Successful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
			}
			else {
	    		Log.ReportEvent("Fail","Navigate to 'Create Invoice' Page is not Loaded Successfully");
	    		takeScreenShot();
	    		driver.quit();
				Assert.fail();
			}
	}
	catch(Exception e){
		Log.ReportEvent("FAIL", "Create Individual Client Invoice is not Successful");
		takeScreenShot();
		driver.quit();
		Assert.fail();
	}
}
//Function Summary   : Method to View Client Invoice 
//Parameter Summary :Individual,Corporate
public void ViewIndividualClientInvoice(Map<Object,Object> testdatamap,Log Log) throws Exception {
	boolean existsNID=false;
	try {
		if(testdatamap.get("ClientID").toString().equalsIgnoreCase("Individual")) {
			NavigateToIndividualClientsList(Log);
		}if(testdatamap.get("ClientID").toString().equalsIgnoreCase("Corporate")) {
			
			NavigateToCorporateClientsList(Log);
		}
    	Thread.sleep(1000);	    	
    	selectDropdownValue_PartialText(EdaatOR.Biller_Invoice_Delete,"View Invoice");
    	switchTonextwindow();
    	Thread.sleep(1000);
    	if(getText(EdaatOR.Biller_BillsList_Page).equals("Bills List")) {
	    	Log.ReportEvent("PASS", "'Bills List' Page is Loaded Successfully");
    	WebClick(EdaatOR.Biller_Invoice_view);
    	switchTonextwindow();
    	if(getText(EdaatOR.Biller_InvoiceDetails_Page).equals("Invoice Details")) {
	    	Log.ReportEvent("PASS", "'Invoice Details' Page is Loaded Successfully ");
    	if(ExistsCheck(EdaatOR.Biller_Invoice_form)==true) {
	    	existsNID=true;
	    	Log.ReportEvent("PASS", " View Individual Client Invoice is Successful");
	    }
    	else {
	    	Log.ReportEvent("FAIL", " View Individual Client Invoice is not Successful");
	    	takeScreenShot();
	    	driver.quit();
	    	Assert.fail();
    	}
    	}
    	else {
	    	Log.ReportEvent("FAIL", "'Invoice Details' Page is not Loaded Successfully");
	    	takeScreenShot();
	    	driver.quit();
	    	Assert.fail();
		}
    	}
    	else {
    		Log.ReportEvent("FAIL", "'Bills List' Page is not Loaded Successfully");
    		takeScreenShot();
    		driver.quit();
	    	Assert.fail();
    	}
    }catch(Exception e){
    	Log.ReportEvent("FAIL", " View Individual Client Invoice is not Successful");
    	takeScreenShot();
    	driver.quit();
    	Assert.fail();
		}
	}

    // Function Summary  : Method to verify Error messages in Add individual client page
	// Parameter Summary : FullName,SecondName,ThirdName,LastName,NationalID,Year,Month,Date,MobileNo,Email and Refno,ExpectedResult.

	public void VerifyAddIndClietErrorMsg(String FullName, String SecondName, String ThirdName, String LastName,
			String NationalID, String Year, String Month, String Date, String MobileNo, String Email, String Refno,
			String ExpectedResult, Log log) throws Exception {
		{
			NavigateToIndividualClientsList(log);
			NavigateToAddIndividualClients(log);
			WebEdit(EdaatOR.Biller_Individualclient_fname, FullName);
			WebEdit(EdaatOR.Biller_Individualclient_sname, SecondName);
			WebEdit(EdaatOR.Biller_Individualclient_tname, ThirdName);
			WebEdit(EdaatOR.Biller_Individualclient_lname, LastName);
			WebEdit(EdaatOR.Biller_Individualclient_IdNumber, NationalID);

			if (Year.equals("") || Month.equals("") || Date.equals("")) {
				WebEdit(EdaatOR.Biller_Individualclient_Email, Email);
				WebEdit(EdaatOR.Biller_Individualclient_Refno, Refno);
				Thread.sleep(2000);
				WebEdit(EdaatOR.Biller_Individualclient_MobileNo, MobileNo);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Biller_Individualclient_Add);
				Thread.sleep(50);
			} else {
				WebClick(EdaatOR.Biller_Individualclient_DateOfBirth);
				WebClickUsingJS(EdaatOR.Biller_Individualclient_DateOfYear);
				selectDropdownValue_PartialText(EdaatOR.Biller_Individualclient_DateOfYear, Year);
				selectDropdownValue_PartialText(EdaatOR.Biller_Individualclient_DateOfMonth, Month);
				WebClick("//a[text()='" + Date + "']");
				WebEdit(EdaatOR.Biller_Individualclient_Email, Email);
				WebEdit(EdaatOR.Biller_Individualclient_Refno, Refno);
				Thread.sleep(2000);
				WebEdit(EdaatOR.Biller_Individualclient_MobileNo, MobileNo);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Biller_Individualclient_Add);
				Thread.sleep(50);
			}
			try {

				if (ExistsCheck(EdaatOR.Biller_AlertMsg)) {
					if (ExpectedResult.equals(getText(EdaatOR.Biller_NationalIDExistsAlertMsg))) {
						VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_NationalIDExistsAlertMsg));
						log.ReportEvent("PASS", "Validate alert message for Existing National ID is Successful");
					} else if (ExpectedResult.equals(getText(EdaatOR.Biller_ClientRefExistsAlertMsg))) {
						VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_ClientRefExistsAlertMsg));
						log.ReportEvent("PASS",
								"Validate alert message for already existing Client Reference Number is Successful");
					}
				} else if (ExpectedResult.equals(getText(EdaatOR.Biller_FirstNameErrorMsg))
						&& ExpectedResult.equals(getText(EdaatOR.Biller_SecondNameErrorMsg))
						&& ExpectedResult.equals(getText(EdaatOR.Biller_ThirdNameErrorMsg))
						&& ExpectedResult.equals(getText(EdaatOR.Biller_LastNameErrorMsg))
						&& ExpectedResult.equals(getText(EdaatOR.Biller_NationalIDErrorMsg))
						&& ExpectedResult.equals(getText(EdaatOR.Biller_MobileNoErrorMsg))) {
					VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_FirstNameErrorMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_SecondNameErrorMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_ThirdNameErrorMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_LastNameErrorMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_NationalIDErrorMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_MobileNoErrorMsg));
					log.ReportEvent("PASS", "Validate Error message for the Required Fields are Successful");
				}

				else if (ExpectedResult.equals(getText(EdaatOR.Biller_FirstNameErrorMsg))) {
					VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_FirstNameErrorMsg));
					log.ReportEvent("PASS", "Validate Error message for First Name Field is Successful");
				} else if (ExpectedResult.equals(getText(EdaatOR.Biller_SecondNameErrorMsg))) {
					VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_SecondNameErrorMsg));
					log.ReportEvent("PASS", "Validate Error message for Second Name Field is Successful");
				} else if (ExpectedResult.equals(getText(EdaatOR.Biller_ThirdNameErrorMsg))) {
					VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_ThirdNameErrorMsg));
					log.ReportEvent("PASS", "Validate Error message for Third Name Field is Successful");
				} else if (ExpectedResult.equals(getText(EdaatOR.Biller_LastNameErrorMsg))) {
					VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_LastNameErrorMsg));
					log.ReportEvent("PASS", "Validate Error message for Last Name Field is Successful");
				} else if (ExpectedResult.equals(getText(EdaatOR.Biller_NationalIDErrorMsg))) {
					VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_NationalIDErrorMsg));
					log.ReportEvent("PASS", "Validate Error message for National ID Field is Successful");
				} else if (ExpectedResult.equals(getText(EdaatOR.Biller_NationalIDStartsError))) {
					VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_NationalIDStartsError));
					log.ReportEvent("PASS", "Validate Error message for National ID Field is Successful");
				} else if (ExpectedResult.equals(getText(EdaatOR.Biller_MobileNoErrorMsg))) {
					VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_MobileNoErrorMsg));
					log.ReportEvent("PASS", "Validate Error message for Mobile Number Field is Successful");
				}

				else {
					log.ReportEvent("FAIL",
							"Validate  Add Individual Client Page Text Field Error Message is not Successful");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			} catch (Exception e) {
				log.ReportEvent("FAIL",
						"Validate  Add Individual Client Page Text Field Error Message is not Successful");
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}
	}

    //Function Summary  : method to verify Error messages in Edit individual client page
	//Parameter Summary : FullName,SecondName,ThirdName,LastName,NationalID,Year,Month,Date,MobileNo,Email and Refno,ExpectedResult.
	public void VerifyEditIndClietErrorMsg(String FullName,String SecondName,String ThirdName,String LastName,String NationalID,String Year,String Month,String Date,String MobileNo,String Email,String Refno,String ExpectedResult,Log log) throws InterruptedException{
		{			
			try {
				
				NavigateToIndividualClientsList(log);
		    	selectDropdownValue_PartialText(EdaatOR.Biller_Invoice_Delete,"Edit");
		    	Thread.sleep(1000);	    	
		    	switchTonextwindow();
		    	Thread.sleep(1000);
		    	if (getText(EdaatOR.Biller_EditIndividualClientData_Page).equals("Edit individual client data")) {
		    		log.ReportEvent("PASS","Navigate to 'Edit Individual Client Data' Page is Loaded Successfully");
		    		WebClear(EdaatOR.Biller_Individualclient_fname);
		        	WebEdit(EdaatOR.Biller_Individualclient_fname,FullName);
		        	WebClear(EdaatOR.Biller_Individualclient_sname);
		        	WebEdit(EdaatOR.Biller_Individualclient_sname,SecondName);
		        	WebClear(EdaatOR.Biller_Individualclient_tname);
		        	WebEdit(EdaatOR.Biller_Individualclient_tname,ThirdName);
		        	WebClear(EdaatOR.Biller_Individualclient_lname);
		        	WebEdit(EdaatOR.Biller_Individualclient_lname,LastName);
		        	WebClick(EdaatOR.Biller_Individualclient_DateOfBirth);

		        	if(Year.equals("")|| Month.equals("")|| Date.equals("")){
		        		WebClick(EdaatOR.Biller_Individualclient_DateClear);
		        	}
		        	else {
			        	selectDropdownValue_PartialText(EdaatOR.Biller_Individualclient_DateOfYear, Year);
			        	selectDropdownValue_PartialText(EdaatOR.Biller_Individualclient_DateOfMonth, Month);
			        	WebClick("//a[text()='"+Date+"']");
		        	}
			        	WebClear(EdaatOR.Biller_Individualclient_MobileNo);
			        	WebEdit(EdaatOR.Biller_Individualclient_MobileNo,MobileNo);
			        	WebClear(EdaatOR.Biller_Individualclient_Email);
			        	WebEdit(EdaatOR.Biller_Individualclient_Email,Email);
			        	WebClear(EdaatOR.Biller_Individualclient_Refno);
			        	WebEdit(EdaatOR.Biller_Individualclient_Refno,Refno);
			           	Thread.sleep(2000);	    	 	
			        	WebClick(EdaatOR.Biller_Individualclient_Add);
			        	Thread.sleep(2000);
		        	

		    	if (ExistsCheck(EdaatOR.Biller_AlertMsg)){	
					if(ExpectedResult.equals(getText(EdaatOR.Biller_ClientRefExistsAlertMsg))) {
			    		log.ReportEvent("PASS","Validate Individual Client Reference Number Alert Error Message is Successful");
					}else if(ExpectedResult.equals(getText(EdaatOR.Biller_NationalIDExistsAlertMsg))) {
			    		log.ReportEvent("PASS","Validate Individual Client National ID Alert Error Message is Successful");
					}
				}
				else if (ExpectedResult.equals(getText(EdaatOR.Biller_FirstNameErrorMsg)) && ExpectedResult.equals(getText(EdaatOR.Biller_SecondNameErrorMsg)) && ExpectedResult.equals(getText(EdaatOR.Biller_ThirdNameErrorMsg)) && ExpectedResult.equals(getText(EdaatOR.Biller_LastNameErrorMsg)) && ExpectedResult.equals(getText(EdaatOR.Biller_MobileNoErrorMsg))){	

		    		log.ReportEvent("PASS","Validate Edit Individual Required Fields Error Message is Successful");
				}
				else if (ExpectedResult.equals(getText(EdaatOR.Biller_FirstNameErrorMsg))) {
		    		log.ReportEvent("PASS","Validate First Name Field Error Message is Successful");
				}
				else if (ExpectedResult.equals(getText(EdaatOR.Biller_SecondNameErrorMsg))) {
		    		log.ReportEvent("PASS","Validate Second Name Field Error Message is Successful");
				}
				else if (ExpectedResult.equals(getText(EdaatOR.Biller_ThirdNameErrorMsg))){	
		    		log.ReportEvent("PASS","Validate Third Name Field Error Message is Successful");

				}
				else if (ExpectedResult.equals(getText(EdaatOR.Biller_LastNameErrorMsg))){	
		    		log.ReportEvent("PASS","Validate Last Name Field Error Message is Successful");
				}
				else if (ExpectedResult.equals(getText(EdaatOR.Biller_MobileNoErrorMsg))){	
		    		log.ReportEvent("PASS","Validate Mobile Number Field Error Message is Successful");
				}
				else {
					log.ReportEvent("FAIL","Validate  'Edit Individual Client Data' Page Fields Error Message is Successful");
		    		takeScreenShot();
		    		driver.quit();
		    		Assert.fail();	
		    		}
		    	}
		    	else {
		    		log.ReportEvent("FAIL","Navigate to 'Edit Individual Client Data' Page is not Loaded Successfully");
		    		takeScreenShot();
		    		driver.quit();
		    		Assert.fail();
		    	}
			} 
			catch (Exception e) {
				log.ReportEvent("FAIL","Validate  'Edit Individual Client Data' Page Fields Error Message is not Successful");
	    		takeScreenShot();
	    		driver.quit();
	    		Assert.fail();	
			}
		}
	}

	
    //Function Summary  : method to verify Error messages in delete individual client page
	//Parameter Summary : ExpectedResult
	public void VerifyDeleteIndClietErrorMsg(String ExpectedResult,Log log) throws InterruptedException{
		{
			try {
				WebClickUsingJS(EdaatOR.Biller_Add_Individualclient);
				Thread.sleep(500);
				selectDropdownValue_PartialText(EdaatOR.Biller_Invoice_DeleteFrstRow,"Delete");
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_Invoice_Deletebtn);
				if (ExpectedResult.equals(getText(EdaatOR.Biller_DeleteClientErrMsg))){	
					log.ReportEvent("PASS", "Validate 'if you wish to delete this client, please choose the reasons for deletion' Pop Up Error Message is Successful");
				}
				else {
					log.ReportEvent("FAIL", "Validate 'if you wish to delete this client, please choose the reasons for deletion' Pop Up Error Message is not Successful");
					takeScreenShot();
					driver.quit();
					Assert.fail();
				}
			} 
			catch (Exception e) {
				log.ReportEvent("FAIL", "Validate 'if you wish to delete this client, please choose the reasons for deletion' Pop Up Error Message is not Successful");
				e.printStackTrace();
				takeScreenShot();
				driver.quit();
				Assert.fail();
			}
		}
	}
	
}