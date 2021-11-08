package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SampleSeleniumTest {
	public static void main(String[] args) throws IOException  {
		//Step 01:Get the java representaion object of the physical file
		  FileInputStream fis = new FileInputStream("./data/commondata.properties"); 
		  // Step 02: Create an Object to property class and load all the keys
		  Properties pobj = new Properties();
		  pobj.load(fis);
		  //Read the value using get property
		  String BROWSER = pobj.getProperty("browser");
		 String URL = pobj.getProperty("url");
		 String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		WebDriver driver = null;
	if (BROWSER.equals("chrome"))
	{
		driver = new ChromeDriver();
	}else if (BROWSER.equals("firefox"))
	{
		driver = new FirefoxDriver();
	}
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
	}

}
