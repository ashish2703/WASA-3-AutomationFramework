package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoTestScript {

	public static void main(String[] args) {
		
		//Step 1:Launch the browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		
		
		//Step 2:Login to the Application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		
		//Step 3:Navigate to Contacts Link
		driver.findElement(By.linkText("Contacts")).click();
		
		
		//Step 4:Click on Create Contacts LookUp Image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		
		
		//Step 5:Create contacts with mandatory fields
		driver.findElement(By.name("lastname")).sendKeys("Ashish");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		//Step 6:Verify for contacts
		String Contactheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(Contactheader.contains("Ashish"))
		{
			System.out.println("Contactheader+ --- PASS ---");
		}
		
		else
		{
		System.out.println("--FAIL--");	
		}
		
		
	    //Step 7:Logout of the application
		WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Sign Out Successful");
		}
		
	

	}


