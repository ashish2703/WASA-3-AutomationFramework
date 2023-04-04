package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	//Declaration
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement CreateContactLookUpImg;
	
	//initialization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getCeateContactLookUpImg() {
		return CreateContactLookUpImg;
	}

    //Business Library
	/**
	 * This method will perform click Operation on create contact look up image
	 */
    public void ClickOnCreateContactImg()
    {
    	CreateContactLookUpImg.click();
    }


	
	}