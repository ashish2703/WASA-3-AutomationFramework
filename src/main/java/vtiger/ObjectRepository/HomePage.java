package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{
//declaration
	@FindBy(linkText="Organizations")
	private WebElement OrganizationsLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsLnk;
	
	@FindBy(linkText="Opportunities")
	private WebElement OpportunitiesLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLnk;
	
	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//Utilization
	public WebElement getOrganizationsLnk() {
	return OrganizationsLnk;
	}
	
	public WebElement getContactsLnk()
	{
		return ContactsLnk;
	}
	public WebElement getOpportunitiesLnk()
	{
		return OpportunitiesLnk;
	}
	public WebElement getAdministratorImg()
	{
		return AdministratorImg;
	}
	public WebElement getSignOutLnk()
	{
		return SignOutLnk;
	}
	//Business Libraries
	/**
	 * This method will perform click operations on Organization Link
	 */
	public void ClickOnOrganizationsLnk()
	{
		OrganizationsLnk.click();
	}
	public void ClickOnContactsLnk()
	{
		ContactsLnk.click();
	}
	/**
	 * This method will perform logout operation
	 * @param driver
	 */
	public void logoutOfApp(WebDriver driver)
	{
		mouseHoverAction(driver, AdministratorImg);
		SignOutLnk.click();
	}
}
