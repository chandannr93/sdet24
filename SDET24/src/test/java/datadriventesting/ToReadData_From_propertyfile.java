package datadriventesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import generic_utility.File_Utility;

public class ToReadData_From_propertyfile {
public static void main(String[] args) throws Throwable {
	File_Utility file = new File_Utility();
	 String BROWSER = file.getPropertyKeyValue("browser");
	 String URL = file.getPropertyKeyValue("url");
	 String USERNAME = file.getPropertyKeyValue("username");
	 String PASSWORD = file.getPropertyKeyValue("password");
	 System.out.println(BROWSER + '\n' + URL + '\n' + USERNAME + '\n'+ PASSWORD);
	 WebDriver driver = null;
	 if (BROWSER.equals("chrome"))
	 {
		 driver = new ChromeDriver();
	 }
	 else if (BROWSER.equals("firefox"))
	 {
		 driver = new FirefoxDriver();
	 }
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 driver.get(URL);
	 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	 driver.findElement(By.id("submitButton")).click();
}
}
