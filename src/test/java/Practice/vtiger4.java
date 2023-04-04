package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class vtiger4 {

	public static void main(String[] args) {
		
		//Step 1:Launch Browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		
		//Step 2:Login to application with valid credentials
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Step 3:Navigate to Organizations link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 4:Click on Create Organization look Up Image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		//Step 5:Create Organization with Mandatory fields
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("rishu2");
		
		//Step 5:Select "Energy" in the industry drop down
		WebElement drop = driver.findElement(By.xpath("//select[@name='industry']"));
		Select s=new Select(drop);
		s.selectByVisibleText("Energy");
		
		//Step 6:Select "Customer" in the Type Drop down 
		WebElement drop2 = driver.findElement(By.xpath("//select[@name='accounttype']"));
		Select s1=new Select(drop2);
		s1.selectByVisibleText("Customer");

		//Step 7:Save and Verify
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String ver = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(ver.contains("rishu2"))
		{
		System.out.println(ver+ "---Pass---");
		}
		else
		{
			System.out.println(ver+ "---Fail---");
		}
		
		//Step 8:logout of Application
		WebElement dracula = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(dracula).perform();
        driver.findElement(By.linkText("Sign Out")).click();
        System.out.println("Sign Out Successful");
		
	}

}
