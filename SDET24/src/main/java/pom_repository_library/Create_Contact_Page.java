package pom_repository_library;
;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.WebDriverUtility;
import com.crm.comcast.objectrepository.Organisation_page.Organizations;

public class Create_Contact_Page extends WebDriver_Utility{
	WebDriver driver=null;
	public void CreateNewContact(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement selectOrgBtn;
		
	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement saveBtn;

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getSelectOrgBtn() {
		return selectOrgBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public void createContact(String lastname)
	{
		lastNameEdt.sendKeys(lastname);
		saveBtn.click();
	}
	public void createContact(String lastName, String orgName) throws InterruptedException
	{
		lastNameEdt.sendKeys(lastName);
		selectOrgBtn.click();
		switchToWindow(driver, "Accounts&action");
		Organizations op=new Organizations(driver);
		//waitForElementVisibility(driver, op.getSearchEdt());
		
		op.getSearchEdt().sendKeys(orgName);
		op.getSearchBtn().click();
		
		int count=0;
		while(count<20){
			try{
				driver.findElement(By.xpath("//a[.='"+orgName+"']")).click();
				break;
			}
			catch(Exception e){
				count++;
				Thread.sleep(1000);
			}
		}
		switchToWindow(driver,"Contacts");
		saveBtn.click();
	}
	
}
