package CRUDEmployeeDetailsTestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CRUD.Employee;
import CRUD.EmployeePage;
import comp.magnus.libraryfiles.Base;
import comp.magnus.libraryfiles.Utility;
import comp.magnus.pages.MagnusLoginPage;

public class EmployeeDetailTests extends Base {
	MagnusLoginPage login1;
	private EmployeePage emp1;
	@BeforeTest
	public void setupBrowser() throws EncryptedDocumentException, IOException {
		openBrowser();
		emp1 = new EmployeePage(driver);
		login1 = new MagnusLoginPage(driver);
		login1.enterUsername();
		login1.enterPassword();
		login1.clickonSignInBtn();
	}
	@Test
	public void createNewEployeeRecord() throws EncryptedDocumentException, IOException {
		Employee emp = new Employee(Utility.getempdata(2, 0), Utility.getempdata(2, 1),
				Utility.getempdata(2, 2), Utility.getempdata(2, 3));
		emp1.AddEmployee(emp);
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
