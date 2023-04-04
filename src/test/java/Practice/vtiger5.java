package Practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class vtiger5 {

	public static void main(String[] args) {
		
		//Step 1:Launch the Browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		
		//Step 2:Login to the Application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		
		//Step 3:Navigate to contacts Link
		driver.findElement(By.linkText("Contacts")).click();
		
		
		//Step 4:Click on Create Contact Look Up Image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//Step 5:Create Contact with mandatory Field
		driver.findElement(By.name("lastname")).sendKeys("Ashish34");
		
		//Step 6:Select the Organization from organization look up image
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif'][1]"));
		String mainid=driver.getWindowHandle();
		Set<String> allid=driver.getWindowHandles();
		for (String id:allid)
		{
			if(!(mainid.equals(id)))
			{
				driver.switchTo().window(id);
			}
		}
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//Step 7:Verify
		String ver = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(ver.contains("Ashish27"))
		{
		System.out.println(ver+ "---Pass---");
		}
		else
		{
			System.out.println(ver+ "---Fail---");
		}
		//Step 8:Logout
		WebElement dracula = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(dracula).perform();
        driver.findElement(By.linkText("Sign Out")).click();
        System.out.println("Sign Out Successful");
	
		
	}

}
