package comp.magnus.test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import comp.magnus.libraryfiles.Base;
import comp.magnus.libraryfiles.Utility;
import comp.magnus.pages.AddEmployeePage;
import comp.magnus.pages.MagnusLoginPage;

public class MagnusCRUDTest extends Base{
	
	AddEmployeePage create;
	MagnusLoginPage login1;
	@BeforeClass
	public void setup() throws EncryptedDocumentException, IOException {
		openBrowser();
		login1 = new MagnusLoginPage(driver);
		create = new AddEmployeePage(driver);
	}
	public void emptab() {
		create.clickOnEmployeeBtn();
	}
	public void AddNewEmployee() throws EncryptedDocumentException, IOException {
		create.enterFname(Utility.getempdata(1, 0));
		create.enterLname(Utility.getempdata(1, 1));
		create.enterEmaiId(Utility.getempdata(1, 2));
		create.enterMobileNo(Utility.getempdata(1, 3));
		create.clickOnSaveBtn();
		String actStatusMsg = create.getStatusMessage();
		System.out.println(actStatusMsg);
		String expStatusMsg = Utility.getempdata(1, 4);
		Assert.assertEquals(actStatusMsg, expStatusMsg);
	}
	@Test(priority = 0)
	public void loginPageTes() throws EncryptedDocumentException, IOException {
		login1.enterUsername();
		login1.enterPassword();
		login1.clickonSignInBtn();
	}
	
	@Test(priority = 1)
	public void addNewEmployeeRecordTest() throws EncryptedDocumentException, IOException {
		emptab();
		AddNewEmployee();
	}
	@Test(priority = 2)
	public void SearchEmpDetails() throws EncryptedDocumentException, IOException {
		/*
		 *for read data 
		 */
		create.clickOnSearchBtn();
		AddNewEmployee();
	}
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		
	}
}
