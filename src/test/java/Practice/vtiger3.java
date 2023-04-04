package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class vtiger3 {

	public static void main(String[] args) {
		
		//Step 1:Launch the browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		
		//Step 2:Login to the application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Step 3:Navigate to Organization Link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 4:Click on Create Organization Look Up Image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Step 5:Create Organization with Mandatory fields
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("rishu1");
		WebElement drop = driver.findElement(By.xpath("//select[@name='industry']"));
		Select s=new Select(drop);
		s.selectByVisibleText("Chemicals");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 6:Verify
		String ver = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(ver.contains("rishu1"))
		{
		System.out.println(ver+ "---Pass---");
		}
		else
		{
			System.out.println(ver+ "---Fail---");
		}
		
		//Step 7:Close the Browser
		WebElement dracula = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(dracula).perform();
        driver.findElement(By.linkText("Sign Out")).click();
        System.out.println("Sign Out Successful");
		
	
		
		
		
		
		
		
		

	}

}
