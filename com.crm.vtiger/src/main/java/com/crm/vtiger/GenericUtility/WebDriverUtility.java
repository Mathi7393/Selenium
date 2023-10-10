package com.crm.vtiger.GenericUtility;

import java.io.File;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	/**
	 * This method is used to maximize window
	 * @param driver
	 */
	public void maximizeWebPage(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to minimize window
	 * @param driver
	 */
	public void minimizeWebPage(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/**
	 * This method is used to make the web page to wait for certain time until the condition met
	 * @param driver
	 */
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IpathConstant.implicitWaitDuration));
	}
	/**
	 * This method is used to make the web page to wait for certain time until the condition met-element is visible
	 * @param driver
	 * @param element
	 */
	public void visibleElement(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(IpathConstant.explicitwaitDuration));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * this method is used to make the web page to wait for certain time until the condition met-element is clickable
	 * @param driver
	 * @param element
	 */
	public void elementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(IpathConstant.explicitwaitDuration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * this method is used to check the alert pop-up is present in the web page
	 * this method is used to check pop up is alert type or not
	 * @param driver
	 * @param element
	 */
	public void alertIsPresent(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(IpathConstant.explicitwaitDuration));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	/**
	 * This method is used to check the Web page title
	 * @param driver
	 * @param title
	 */
	public void titlePresent(WebDriver driver,String title) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(IpathConstant.explicitwaitDuration));
		wait.until(ExpectedConditions.titleContains(title));
	}
	/**
	 * This method is used to check the url of the Web page
	 * @param driver
	 * @param url
	 */
	public void urlPresent(WebDriver driver,String url) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(IpathConstant.explicitwaitDuration));
		wait.until(ExpectedConditions.urlContains(url));
	}
	/**
	 * This method is used avoid the exception by using Explicit wait method
	 * @param driver
	 */
	public void ignoreException(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(IpathConstant.explicitwaitDuration));
		wait.ignoring(NoSuchElementException.class);
	}
	/**
	 * This method is used to handle drop down by index 
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element, int index) {
		Select se=new Select(element);
		se.selectByIndex(index);
	}
	/**
	 * This method is used to handle drop down by value
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element, String value) {
		Select se=new Select(element);
		se.selectByValue(value);
	}
	/**
	 * This method is used to handle drop down by visible text
	 * @param visibleText
	 * @param element
	 */
	public void handleDropdown(String visibleText, WebElement element) {
		Select se=new Select(element);
		se.selectByVisibleText(visibleText);
	}
	/**
	 * this method is used to move mouse to particular element
	 * @param driver
	 * @param element
	 */
	public void moveToElement(WebDriver driver, WebElement element) {
		Actions actions=new Actions(driver);
		actions.moveToElement(element).perform();
	}
	/**
	 * this method is used to right click on anywhere
	 * @param driver
	 */
	public void rightClickAnyWhere(WebDriver driver) {
		Actions actions=new Actions(driver);
		actions.contextClick().perform();
	}
	/**
	 * this method is used to right click on Web element
	 * @param driver
	 */
	public void rightClickOnWebElement(WebDriver driver,WebElement element) {
		Actions actions=new Actions(driver);
		actions.contextClick(element).perform();
	}
	/**
	 * this method is used to Double click on Web element
	 * @param driver
	 */
	public void doubleClickOnWebElement(WebDriver driver,WebElement element) {
		Actions actions=new Actions(driver);
		actions.doubleClick(element).perform();
	}
	/**
	 * this method is used to Drag and Drop the source element to destination element
	 * @param driver
	 */
	public void dragAndDroP(WebDriver driver,WebElement srcelement, WebElement destelement) {
		Actions actions=new Actions(driver);
		actions.dragAndDrop(srcelement, destelement).perform();
	}
	/**
	 * This method used to switch the control to the another frame by using index value
	 * @param driver
	 * @param index
	 */
	public void frameByIndex(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * This method used to switch the control to the another frame by name or ID
	 * @param driver
	 * @param index
	 */
	public void frameByNameOrID(WebDriver driver,String nameOrID) {
		driver.switchTo().frame(nameOrID);
	}
	/**
	 * This method used to switch the control to the another frame by Web Element
	 * @param driver
	 * @param index
	 */
	public void frameByWebElement(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 * This method used to switch the control back to Parent frame
	 * @param driver
	 * @param index
	 */
	public void parentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	/**
	 * This method used to switch the control back to  main/default frame
	 * @param driver
	 * @param index
	 */
	public void defaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	/**
	 * This Method is used to use alert pop up by accepting
	 * @param driver
	 */
	public void acceptalert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * This Method is used to use confirmation pop up by clicking cancel button
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This Method is used to get alert text from pop ups
	 * @param driver
	 */
	public String getTextFromAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	/**
	 * This Method is used to get alert text from pop ups
	 * @param driver
	 */
	public void passTextIntoAlert(WebDriver driver, String text) {
		driver.switchTo().alert().sendKeys(text);
	}
	/**
	 * This method is to handle multiple windows and switch to particular window
	 * @param driver
	 * @param partialTargetTitle
	 */
	public void handleMultipleWindows(WebDriver driver, String partialTargetTitle) {
		//capture all the 
		Set<String> ids = driver.getWindowHandles();
		
		//navigate to each window
		for (String winid : ids) {
			
			//navigate to each window and capture the title
			String currentTitle=driver.switchTo().window(winid).getTitle();
			
			//compare the title with target window title
			if (currentTitle.contains(partialTargetTitle)) {
				break;
			}
		}
	}
	/**
	 * This method is used to take screenshot of entire web page
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws Throwable
	 */
	public String screenShotOfWebPage(WebDriver driver, String screenShotName) throws Throwable {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		JavaUtility jutil=new JavaUtility();
		String currentdate=jutil.getModifiedDate();
		File dest=new File("./ScreenShots/"+currentdate+screenShotName+".png");
		Files.copy(src, dest);
		return dest.getAbsolutePath();//Extent report
	}
	/**
	 * This method is used to take screenshot of web element
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws Throwable
	 */
	public String screenShotOfWebElement(WebDriver driver, String screenShotName) throws Throwable {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		JavaUtility jutil=new JavaUtility();
		String currentdate=jutil.getModifiedDate();
		File dest=new File("./ScreenShots/"+currentdate+screenShotName+".png");
		Files.copy(src, dest);
		return dest.getAbsolutePath();//Extent report
	}
}
