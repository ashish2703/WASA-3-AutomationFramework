package vtiger.OrganizationTests;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationsInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;


@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateOrganizationTest extends BaseClass {

	  @Test(groups = "SmokeSuite")
	  public void createOrganizationTest() throws EncryptedDocumentException, IOException
	 {	
	
	String ORGNAME = eUtil.readDataFromExcel("Organizations", 1, 2)+jUtil.getRandomNumber();
	
      
  		//Step 4:Navigate to Contacts Link
  		HomePage hp=new HomePage(driver);
  		hp.ClickOnOrganizationsLnk();
  		
  		//Step 5:Click on Create Contacts LookUp Image
  		OrganizationsPage op=new OrganizationsPage(driver);
  		op.clickOnCreateOrgImg();
  		
  		//Step 6:Create contacts with mandatory fields
  		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
  		cnop.createOrganization(ORGNAME);
  		
  		//Step 7:Verify for contacts
  		OrganizationsInfoPage oip=new OrganizationsInfoPage(driver);
  		String OrgHeader = oip.getOrgHeader();
  		Assert.assertTrue(OrgHeader.contains(ORGNAME));

	 }
	  @Test(groups = "RegressionSuite")
	  public void demoScript()
	  {
		  System.out.println("Demo");
		  
	  }
	  @Test
	  public void regional()
	  {
		  System.out.println("Regional Regression");
	  }
	}


