package generic_utility;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This Class contains webdriver specific generic Methods
 * @author Chandan NR
 */
public class WebDriver_Utility {
	/**
	 * This method is used to maximize the browser window.
	 * @param driver
	 */
public void maximizeWindow(WebDriver driver) {
	driver.manage().window().maximize();
}
/**
 * This method waits for specified time for page loading.
 * @param driver
 */
public void waitUntilPageLoad(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
}
/**
 * This method waits till the element is visible
 * @param driver
 * @param element
 */
public void waitForElementVisibility(WebDriver driver, WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOf(element));
}
/**
 * This method waits for the element to be clicked, it's a custom wait created to avoid ElementInterceptable Exception
 * @param driver 
 * @param element
 * @throws InterruptedException 
 */
public void waitandClick(WebDriver driver, WebElement element) throws InterruptedException {
	int count = 0;
	while (count<20) {
		try {
		element.click();
		break;
		}
		catch (Throwable e ) {
			Thread.sleep(1000);
			count++;			
		}
	}
}
/**
 * This method will perform the mouse hover action.
 * @param driver
 * @param element
 */
public void mouseHover(WebDriver driver, WebElement element) {
	Actions actions = new Actions(driver);
	actions.moveToElement(element).perform();	
}
/**
 * This method will helps to switch from one window to another window
 * @param driver
 * @param partialWindowTitle
 */
public void switchToWindow(WebDriver driver, String partialWindowTitle ) {
	 Set<String> windowIDs = driver.getWindowHandles();
	Iterator<String> iterator = windowIDs.iterator();
	while (iterator.hasNext()) {
		String windowID = iterator.next();
		String title = driver.switchTo().window(windowID).getTitle();
		System.out.println("Title: "+ title);
		if (title.contains(partialWindowTitle)) {
			break;
		}
	}	 
}
/**
 * This method will help to switch from one window to another window using URL
 * @param driver
 * @param url
 */
public void switchToWindowOnURL(WebDriver driver, String url) {
	Set<String> windowIDs = driver.getWindowHandles();
	Iterator<String> iterator = windowIDs.iterator();
	while (iterator.hasNext()) {
		String windowID = iterator.next();
	String currentURL = driver.switchTo().window(windowID).getCurrentUrl();
	System.out.println("URL: "+ currentURL );
	if (currentURL.contains(url))
	{
		break;
	}	
	}
}
/**
 * This method is used to accept the alert.
 * @param driver
 */
public void acceptAlert(WebDriver driver) {
	driver.switchTo().alert().accept();
}
/**
 * This method is used to cancel the alert.
 * @param driver
 */
public void rejectAlert(WebDriver driver) {
	driver.switchTo().alert().dismiss();
}
/**
 * This method enables the user to handle the dropdown using visible text.
 * @param element
 * @param option
 */
public void select(WebElement element, String option) {
	Select select = new Select(element);
	select.selectByVisibleText(option);	
}
/**
 * This method enables the user to handle the dropdown using the index.
 * @param element
 * @param index
 */
public void select(WebElement element, int index ) {
	 Select select = new Select(element);
	 select.selectByIndex(index);	
}
}
