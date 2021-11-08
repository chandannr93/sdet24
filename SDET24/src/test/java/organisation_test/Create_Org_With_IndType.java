package organisation_test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.FileUtility;
import com.crm.comcast.genericutility.JavaUtility;
import com.crm.comcast.genericutility.WebDriverUtility;
import com.crm.comcast.objectrepository.CreateNewOrganization;
import com.crm.comcast.objectrepository.Home;
import com.crm.comcast.objectrepository.Login;
import com.crm.comcast.objectrepository.OrganizationInfo;
import com.crm.comcast.objectrepository.Organizations;

public class Create_Org_With_IndType {
	@Test
	public void CreateOrgWithIndAndType() throws IOException
	{
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		WebDriver driver=null;
		
		String BROWSER=fLib.getPropertyKeyValue("browser");
		
		//test script specific data
		String orgName=eLib.getData("sheet1",1,2)+ "_" +jLib.getRandomNum();
		String industry=eLib.getData("sheet1",4,4);
		String type=eLib.getData("sheet1",4,5);
		
		//launch the browser
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}else if(BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();
			
		}else if(BROWSER.equals("InternetExplorer"))
        {
			driver=new InternetExplorerDriver();
		}

		//login to app
		wLib.waitUntilPageLoad(driver);
	Login lp=new Login(driver);
	lp.loginToApp();
	
	//navigate to Org
	Home hp=new Home(driver);
	hp.getOrganizationLnk().click();
	
	//navigate to create org page
	Organizations op=new Organizations(driver);
	op.getCreateOrgImg().click();
	
	//create org with industry and type
	CreateNewOrganization cnp=new CreateNewOrganization(driver);
	cnp.createOrg(orgName, industry, type);
	
	//verify organisation
	OrganizationInfo of=new OrganizationInfo(driver);
	String actMsg=of.getOrgText().getText();
	if(actMsg.contains(orgName))
	{
		System.out.println(orgName+ " org is created successfully ==>PASS");
	}
	else
	{
		System.out.println(orgName+ " org is not created successfully ==>FAIL");
	}
	//verify industry
	String actIndustryMsg=of.getIndustryText().getText();
	if(actIndustryMsg.contains(industry))
	{
		System.out.println(industry+ " industry is created successfully ==>PASS");
	}
	else
	{
		System.out.println(industry+ " industry is not created successfully ==>FAIL");
	}
	//verify type
	String actType=of.getTypeText().getText();
	if(actType.contains(type))
	{
		System.out.println(type+ " type is created successfully ==>PASS");
	}
	else
	{
		System.out.println(type+ " type is not created successfully ==>FAIL");
	}
	
	//step:logout
	hp.logout();
	
	//close the browser
	driver.close();
	
	
	
}
}

}
