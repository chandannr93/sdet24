package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LaunchRMGYantra {
public static void main(String[] args) {
	//Setting the path of ChromeDriver - Illegal State Exception Avoided
	System.setProperty("webdriver.chrome.driver", "./drivers\\chromedriver.exe");
	// Launching upcasting from chrome to web driver.
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	 // Handling synchronization issue 
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  // Launching the web application through url
	  driver.get("http://localhost:8084/");
	  // locating the username text box
	  driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys("rmgyantra");
	  // locating the password text field
	  driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("rmgy@9999");
	  // locating and clicking on signin button
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  driver.findElement(By.xpath("//a[.='Projects']")).click();
	  driver.findElement(By.xpath("//span[.='Create Project']")).click();
	  driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("SDET2402");
	  driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("ChandanNR01");
	  // select dropdown by index value
	  WebElement element = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
	  // creating select class and passing the argument as webelement ref variable
	  Select s = new Select(element);
	  // select value by using visible text method
	  s.selectByVisibleText("Created");
	  // clicking on addproject button
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  
	  
	  
}
}
