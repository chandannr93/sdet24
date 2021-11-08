package pom_repository_library;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contacts_info_page {
	public void ContactInfo(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
@FindBy(xpath="//span[@class='dvHeaderText']")
private WebElement contactMsg;

public WebElement getContactMsg() {
	return contactMsg;
}


}


