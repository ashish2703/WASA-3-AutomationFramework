package vtiger.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This Class Consists of Generic Methods related to wedriver actions
 * @author patna
 *
 */

public class WebDriverUtility {
	/**
	 * This method will maximize the window
	 * @param driver
	 */

	public void maximiseWindow(WebDriver driver) 
	{
	driver.manage().window().maximize();
	}
	/**
	 * Thos method will minimise the window
	 * @param driver
	 */
	public void minimiseWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * This method will wait for the page load
	 * @param driver
	 */
	public void waitForPage(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	/**
	 * This method will wait until the element becomes visible
	 * @param driver
	 * @param element
	 */
	public void waitForEementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method will wait until the element becomes clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will handle dropdown based on index
	 * @param element
	 * @param index
	 */
     public void handleDropdown(WebElement element,int index)
     {
    	 Select sel=new Select(element);
    	 sel.selectByIndex(index);
     }
     /**
      * This method will handle dropdown based on value
      * @param element
      * @param value
      */
     public void handleDropdown(WebElement element,String value)
     {
    	 Select sel=new Select(element);
    	 sel.selectByValue(value);
     }
     /**
      * This method will handle dropdown based on visible text
      * @param text
      * @param element
      */
     public void handleDropdown(String text,WebElement element)
     {
    	 Select sel=new Select(element);
    	 sel.selectByVisibleText(text);
     }
     /**
      * This method will perform Mouse Hover Action
      * @param driver
      * @param element
      */
     public void mouseHoverAction(WebDriver driver,WebElement element)
     {
    	 Actions act=new Actions(driver);
    	 act.moveToElement(element).perform(); 
     }
     /**
      * This method will perform right click action anywhere in the web page
      * @param driver
      */
     public void rightClickAction(WebDriver driver)
     {
    	 Actions act=new Actions(driver);
    	 act.contextClick().perform();
     }
     /**
      * This method will perform right click on web element
      * @param driver
      * @param element
      */
     public void rightClickAction(WebDriver driver,WebElement element)
     {
    	 Actions act=new Actions(driver);
    	 act.contextClick(element).perform();
     }
     /**
      * This method will double Click anywhere on the web page
      * @param driver
      */
     public void doubleClickAction(WebDriver driver)
     {
    	 Actions act=new Actions(driver);
    	 act.doubleClick().perform();
     }
     /**
      * This method will perform double click on a web element
      * @param driver
      * @param element
      */
     public void doubleClickAction(WebDriver driver,WebElement element)
     {
    	 Actions act=new Actions(driver);
    	 act.doubleClick(element).perform();
     }
     /**
      * This method will perform Drag and Drop action
      * @param driver
      * @param srcElement
      * @param dstElement
      */
     public void dragAndDrop(WebDriver driver,WebElement srcElement,WebElement dstElement)
     {
    	Actions act=new Actions(driver);
    	act.dragAndDrop(srcElement, dstElement).perform();
     }
     /**
      * This method will accept the alert
      * @param driver
      */
     public void acceptAlert(WebDriver driver)
     {
    	 driver.switchTo().alert().accept();
     }
     /**
      * This method will dismiss the alert
      * @param driver
      */
     public void dismissAlert(WebDriver driver)
     {
    	 driver.switchTo().alert().dismiss();
     }
     /**
      * This method will capture the text from alert popup
      * @param driver
      */
     public void getAlertText(WebDriver driver)
     {
    	 driver.switchTo().alert().getText();
     }
     /**
      * This method will handle the frame based on index and is an example of method overloading
      * @param driver
      * @param index
      */
     public void handleFrame(WebDriver driver,int index)
     {
    	 driver.switchTo().frame(index);
     }
     /**
      * This method will handle the frame based on name or id and also is an example of method overloading
      * @param driver
      * @param nameorid
      */
     public void handleFrame(WebDriver driver,String nameorid)
     {
    	 driver.switchTo().frame(nameorid);
     }
     /**
      * This method will handle frame based on WebElement and is an example of method overloading
      * @param driver
      * @param element
      */
     public void handleFrame(WebDriver driver,WebElement element)
     {
    	 driver.switchTo().frame(element);
     }
     /**
      * This method will switch to immediate parent frame
      * @param driver
      */
     public void switchToParentFrame(WebDriver driver)
     {
    	 driver.switchTo().parentFrame();
     }
     /**
      * This method will switch to default frame
      * @param driver
      */
     public void switchToDefaultFrame(WebDriver driver)
     {
    	 driver.switchTo().defaultContent();
     }
     /**
      * This method will switch the window based on partial window title
      * @param driver
      * @param partialWinTitle
      */
     public void switchToWindow(WebDriver driver,String partialWinTitle)
     {
    	//Step 1:Capture all the Window IDs
    	 Set<String> winIDs = driver.getWindowHandles();
    	 
    	 //Step 2:Navigate to each Window
    	 for(String win:winIDs)
    	 {
    		 //Step 3:Switch to window and capture the title
    		 String winTitle = driver.switchTo().window(win).getTitle();
    		 
    		 //Step 4:Compare the title with required partial title
    		 if(winTitle.contains(partialWinTitle))
    		 {
    			break;
    		 }
    	 }  
     }
     /**
      * This method will take screenshot and save it in required folder
      * @param driver
      * @param screenshotName
      * @return
      * @throws IOException
      */
     public String takeScreenShot(WebDriver driver,String screenshotName) throws IOException
     {
    	TakesScreenshot ts=(TakesScreenshot)driver;
    	File src = ts.getScreenshotAs(OutputType.FILE);
    	File dst=new File(".\\ScreenShots\\"+screenshotName+".png");
    	FileUtils.copyFile(src, dst);
    	
    	return dst.getAbsolutePath();//used for extent reports
     }
     /**
      * This method will perform random scroll downwards vertically
      * @param driver
      */
     public void scrollAction(WebDriver driver)
     {
    	 JavascriptExecutor js=(JavascriptExecutor) driver;
    	 js.executeScript("window.scrollBy(0,500)", "");
     }
     /**
      * This method will scroll untill the element is identified in DOM
      * @param driver
      * @param element
      */
     public void scrollAction(WebDriver driver,WebElement element) 
     {
    	JavascriptExecutor js=(JavascriptExecutor) driver ;
    	int y = element.getLocation().getY();
    	js.executeScript("window.scrollBy(0,"+y+")", element);
     }
}

