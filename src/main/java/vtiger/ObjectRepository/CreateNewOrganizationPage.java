package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility{
	
	//Declaration
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name="industry")
	private WebElement IndustryDropDwn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	//initialization
	public CreateNewOrganizationPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);	
	}
    //Utilization
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDwn() {
		return IndustryDropDwn;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	//Business Library
	/**
	 * This method will create Organization with OrgName
	 * @param OrgName
	 */
	public void createOrganization(String OrgName)
	{
		OrgNameEdt.sendKeys(OrgName);
		SaveBtn.click();
	}
	/**
	 * 	 * This method will create Organization with OrgName and Industry Type

	 * @param OrgName
	 * @param industryType
	 */
	public void createOrganization(String OrgName,String industryType)
	{
		OrgNameEdt.sendKeys(OrgName);
		handleDropdown(IndustryDropDwn, industryType);
		SaveBtn.click();
	}

	
	
	


}
