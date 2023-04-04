package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoTestScriptWithDDT {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Step 1:Read all the necessary data
		/*Read data from Property File - Common data*/
		FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pobj=new Properties();
		pobj.load(fisp);
		String URL = pobj.getProperty("url");
		String BROWSER = pobj.getProperty("browser");
	    String USERNAME = pobj.getProperty("username");
	    String PASSWORD = pobj.getProperty("password");
	    
	    /*Read the data from excel sheet - Test Data*/
	    FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\Test Data.xlsx");
	    Workbook wb=WorkbookFactory.create(fise);
	    String LASTNAME = wb.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();
	    
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
	    
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get(URL);
 
	    
	        //Step 3:Login to the Application
	  		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	  		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	  		driver.findElement(By.id("submitButton")).click();
	  		
	  		
	  		//Step 4:Navigate to Contacts Link
	  		driver.findElement(By.linkText("Contacts")).click();
	  		
	  		
	  		//Step 5:Click on Create Contacts LookUp Image
	  		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	  		
	  		
	  		
	  		//Step 6:Create contacts with mandatory fields
	  		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
	  		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	  		
	  		
	  		//Step 7:Verify for contacts
	  		String Contactheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	  		if(Contactheader.contains(LASTNAME))
	  		{
	  			System.out.println("Contactheader+ --- PASS ---");
	  		}
	  		
	  		else
	  		{
	  		System.out.println("--FAIL--");	
	  		}
	  		
	  		
	  	    //Step 8:Logout of the application
	  		WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	  		Actions act=new Actions(driver);
	  		act.moveToElement(ele).perform();
	  		driver.findElement(By.linkText("Sign Out")).click();
	  		System.out.println("Sign Out Successful");
	  		}
	  		
	  	

	  	


	}


