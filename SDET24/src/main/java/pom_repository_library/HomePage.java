package pom_repository_library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.WebDriver_Utility;

public class HomePage {
 WebDriver driver;
 public HomePage(WebDriver driver) {
	 this.driver = driver;
	 PageFactory.initElements(driver, this);
 }
 @FindBy (linkText = "Contacts")
 private WebElement contacts_Link;
 
 @FindBy (linkText = "Organizations")
 private WebElement organizatioins_Link;
 
 @FindBy( xpath = "//img[contains(@src,'images/user')]")
 private WebElement administrator_Img;
 
 @FindBy (linkText = "Sign Out")
 private WebElement signout_Link;
 
 public WebElement getContactsLink() {
	 return contacts_Link;
 }
 public WebElement get_Organization_Link() {
	 return organizatioins_Link;
 }
 public WebElement get_Administrator_Img() {
	return administrator_Img;
}
 public WebElement getSignOut_Link() {
	 return signout_Link;
 }
 public void sign_Out() {
	 WebDriver_Utility webDriverUtility = new WebDriver_Utility();
	 webDriverUtility.mouseHover(driver, administrator_Img);
	 signout_Link.click();
}
}
