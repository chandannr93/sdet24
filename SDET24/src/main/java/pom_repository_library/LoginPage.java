package pom_repository_library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
public LoginPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);	
}
@FindBy(name="user_name")
private WebElement userNameField;

@FindBy (name="user_password")
private WebElement passwordField;

@FindBy (id="submitButton")
private WebElement loginButton;

public WebElement getUserNameField() {
	return userNameField;
}
public WebElement getPasswordField() {
	return passwordField;
}
public WebElement getLoginButton() {
	return loginButton;
}
public void login(String username, String password) {
	userNameField.sendKeys(username);
	passwordField.sendKeys(password);
	loginButton.click();
}
}
