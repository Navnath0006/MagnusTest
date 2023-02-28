package comp.magnus.test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import comp.magnus.libraryfiles.Base;
import comp.magnus.libraryfiles.Utility;
import comp.magnus.pages.MagnusHomePage;
import comp.magnus.pages.MagnusLoginPage;

public class MagnusTest extends Base{
	
	
	MagnusLoginPage login1;
	MagnusHomePage home1;
	@BeforeClass
	public void intialBrowser() throws EncryptedDocumentException, IOException {
		openBrowser();
		login1 = new MagnusLoginPage(driver);
		home1 = new MagnusHomePage(driver);
	}
	@BeforeMethod
	public void methodmsg() {
		Reporter.log("Test beeing executed....",true);
	}
	
	//Test case 1 for Validating Login Functionality
	@Test(priority = 0)
	public void verifyUserLoginPage() throws EncryptedDocumentException, IOException {
		login1.enterUsername();
		login1.enterPassword();
		login1.clickonSignInBtn();
	}
	//Test case 2 for Validation of Welcome Message on Home screen
	@Test(priority = 1)
	public void verifyWelcomeMsg() throws EncryptedDocumentException, IOException {
		String actWelcomeMsg = home1.getWelcomeMsg();
		String expWelcomeMsg = Utility.getexceldata(1, 2);
		
		Assert.assertEquals(actWelcomeMsg, expWelcomeMsg);
		Reporter.log("Actual Welcome Message : "+actWelcomeMsg,true);
		Reporter.log("Expected Welcome Message : "+expWelcomeMsg,true);
		
		
	}
	@AfterMethod
	public void testExecutionStatus() {
		Reporter.log("Test exection completed...",true);
	}
	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
