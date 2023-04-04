package vtiger.ContactsTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.ContactsInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationsInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;
@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateContactWithOrganizationTest extends BaseClass{
	
    @Test(groups = "RegressionSuite")
	public void createContactWithOrganizationTest() throws IOException {
		
	

			
			   //Read data from excel sheet
				
			String ORGNAME = eUtil.readDataFromExcel("Contacts", 4, 2)+jUtil.getRandomNumber();
			String LASTNAME=eUtil.readDataFromExcel("Contacts", 4, 3);
			
		    
		    
		    		   
	  	    //Step 4:Navigate to Organizations Link
	  		HomePage hp=new HomePage(driver);
	  		hp.ClickOnOrganizationsLnk();
	  		Reporter.log("Click on Organizations link successful");
	  		
	  		//Step 5:Click on Create Organizations LookUp Image
	  		OrganizationsPage op=new OrganizationsPage(driver);
	  		op.clickOnCreateOrgImg();
	  		Reporter.log("Click on Create Organizations LookUp Image successful");
	  		
	  		
	  		//Step 6:Create Organization with mandatory fields
	  		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
	  		cnop.createOrganization(ORGNAME);
	  		Reporter.log("Create Organization with mandatory fields");
	  		
	  		
	  		//Step 7:Validate for Organization
	  		OrganizationsInfoPage oip=new OrganizationsInfoPage(driver);
	  		String orgHeader = oip.getOrgHeader();
	  		Assert.assertTrue(orgHeader.contains(ORGNAME));
	  		System.out.println(orgHeader+"---Organization Created");
	  		
	  	
	  		//Step 8:Navigate to Contacts Linl
			hp.ClickOnContactsLnk();
	  		Reporter.log("Navigate to Contacts link successful");

			
			//Step 9:Click on Create Contacts LookUp Image
			ContactsPage cp=new ContactsPage(driver);
			cp.ClickOnCreateContactImg();
	  		Reporter.log("Click on Create Contacts LookUp Image  successful");

			
			
			//Step 10:Create contacts with mandatory fields
			CreateNewContactPage cncp=new CreateNewContactPage(driver);
			cncp.createNewContact(driver, LASTNAME, ORGNAME);
	  		Reporter.log("Create contacts with mandatory fields successful");

			
			
			
		    //Step 11:Validate for contacts
			ContactsInfoPage cip=new ContactsInfoPage(driver);
			String Contactheader = cip.getContactHeader();
			Assert.assertTrue(Contactheader.contains(LASTNAME));
			System.out.println(Contactheader+" Contact Created");
			
			
			
	}
}

