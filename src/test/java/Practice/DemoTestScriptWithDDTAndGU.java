package Practice;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class DemoTestScriptWithDDTAndGU {

	public static void main(String[] args) throws IOException {
		
		//Step 1: Create Object for all Utilities
		PropertyFileUtility pUtil=new PropertyFileUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		JavaUtility jUtil=new JavaUtility();

		
		//Read all the necessary data
		/*Read the data from property file-Common Data*/
		String URL = pUtil.readDataFromPropertyFile("url");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
	   //Read data from excel sheet
		
	String ORGNAME = eUtil.readDataFromExcel("Organizations", 1, 2)+jUtil.getRandomNumber();
	WebDriver driver=null;
    
    
    //Step 2:Launch the Browser-Run Time Polymorphism
    if(BROWSER.equalsIgnoreCase("chrome"))
    {
    	WebDriverManager.chromedriver().setup();
    	driver=new ChromeDriver();
    }
    else if(BROWSER.equalsIgnoreCase("firefox"))
    {
    	WebDriverManager.firefoxdriver().setup();
    	driver=new FirefoxDriver();
    }
    else
    {
    	System.out.println("Invalid browser name");
    }
    
    wUtil.maximiseWindow(driver);
    wUtil.waitForPage(driver);
    driver.get(URL);

    
        //Step 3:Login to the Application
  		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
  		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
  		driver.findElement(By.id("submitButton")).click();
  		
  		
  		//Step 4:Navigate to Contacts Link
  		driver.findElement(By.linkText("Organizations")).click();
  		
  		
  		//Step 5:Click on Create Contacts LookUp Image
  		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
  		
  		
  		
  		//Step 6:Create contacts with mandatory fields
  		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
  		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
  		
  		
  		//Step 7:Verify for contacts
  		String Contactheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
  		if(Contactheader.contains(ORGNAME))
  		{
  			System.out.println("Contactheader+ --- PASS ---");
  		}
  		
  		else
  		{
  		System.out.println("--FAIL--");	
  		}
  		
  		
  	    //Step 8:Logout of the application
  		WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
  		wUtil.mouseHoverAction(driver, ele);
  		driver.findElement(By.linkText("Sign Out")).click();
  		System.out.println("Sign Out Successful");
  		}
  		
  	

  	





	


	}


