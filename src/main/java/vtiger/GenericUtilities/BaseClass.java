package vtiger.GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

/**
 * This class consist of Basic Configuration annotations of TestNG
 * @author patna
 *
 */
public class BaseClass {
	
	public PropertyFileUtility pUtil=new PropertyFileUtility();
	public ExcelFileUtility eUtil=new ExcelFileUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	public JavaUtility jUtil=new JavaUtility();
	public static WebDriver sDriver;//listeners
	
	public WebDriver driver;

	@BeforeSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void bsConfig()
	{
		System.out.println("-----Database Connection Successful-----");
	}
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(groups = {"SmokeSuite","RegressionSuite"})
	public void bcConfig(/*String BROWSER*/) throws IOException
	{
		String URL = pUtil.readDataFromPropertyFile("url");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");	
		
		 //Step 2:Launch the Browser-Run Time Polymorphism
	    if(BROWSER.equalsIgnoreCase("chrome"))
	    {
	    	WebDriverManager.chromedriver().setup();
	    	driver=new ChromeDriver();
	    	System.out.println("----"+BROWSER+" Launched successfully----");
	    }
	    else if(BROWSER.equalsIgnoreCase("firefox"))
	    {
	    	WebDriverManager.firefoxdriver().setup();
	    	driver=new FirefoxDriver();
	    	System.out.println("----"+BROWSER+" Launched successfully----");

	    }
	    else
	    {
	    	System.out.println("Invalid browser name");
	    }
	    
	    sDriver=driver;
	    wUtil.maximiseWindow(driver);
	    wUtil.waitForPage(driver);
	    driver.get(URL);
	}
	@BeforeMethod(groups = {"SmokeSuite","RegressionSuite"})
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		 LoginPage lp=new LoginPage(driver);
		 lp.loginToApp(USERNAME, PASSWORD);
		 System.out.println("----Login Successful----");  
		   
		
	}
	@AfterMethod(groups = {"SmokeSuite","RegressionSuite"})
	public void amConfig()
	{
		HomePage hp=new HomePage(driver);
		hp.logoutOfApp(driver);
		System.out.println("----Logout Successful----");
	}
	@AfterClass(groups = {"SmokeSuite","RegressionSuite"})
	public void acConfig()
	{
		driver.quit();
		System.out.println("----Driver Closed Successfully----");
		
	}
	@AfterSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void asConfig()
	{
		System.out.println("----Database Connection Successful----");
	}
}
