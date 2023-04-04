package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  
	{
		//Rule 1:Create a Pom class for every webpage
		//Rule 2:Identify the web elements with @FindBy, @FindAll and @FindBys
		@FindBy(name="user_name")
		private WebElement UsernameEdt;
		
		@FindAll({@FindBy(name="user_password"),@FindBy(xpath="//input[@type='password']")})
		private WebElement PasswordEdt;
		
        @FindBy(id="submitButton")
        private WebElement SubmitBtn;
        
        //Rule 3:Create a Constructor to initialise these WebElements
        public LoginPage(WebDriver driver)
        {
        	PageFactory.initElements(driver,this);
        }
        //Rule 4:Provide Getters to access these elements
        public WebElement getUsernameEdt()
        {
        	return UsernameEdt;
        }
        public WebElement getPasswordEdt()
        {
        	return PasswordEdt;
        }
        public WebElement getSubmitBtn()
        {
        	return SubmitBtn;
        }
        
        //Business Libraries-generic methods specific to current project
        /**
         * This method will login to application with username and password
         * @param Username
         * @param Password
         */
        public void loginToApp(String Username,String Password)
        {
        	UsernameEdt.sendKeys(Username);
        	PasswordEdt.sendKeys(Password);
        	SubmitBtn.click();
        }
	}

