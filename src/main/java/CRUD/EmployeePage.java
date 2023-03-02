package CRUD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeePage {
	private  WebDriver driver;	
	
	
	private By employeeBtn = By.xpath("//a/i[@class='fa fa-users']");
	private By searchLink = By.xpath("//*[text()=' Search ']");
	private By addEmployee = By.xpath("//div/a");
	
	private By firstName = By.id("FirstName");
	private By lastName = By.id("LastName");
	private By email = By.id("EmailId");
	private By mobileNo = By.id("MobileNo");
	private By saveBtn = By.xpath("//button[@type='button']");
	private By alertmsg = By.xpath("//*[@class='toast-title']");
	
	private By searchemp = By.xpath("//*[@id='Name']");
	private By searchrecord = By.xpath("//*[@id='btnSearch']");
	
	
	public EmployeePage(WebDriver driver) {
		this.driver = driver;
	 		
	}
	
	public void clickAddEmployee() {
		driver.findElement(employeeBtn).click();
		driver.findElement(searchLink).click();
		driver.findElement(addEmployee).click();
	}
	public String fillEmployeeDetailsform(Employee emp)
	{
		driver.findElement(firstName).sendKeys(emp.getFirstName());
		driver.findElement(lastName).sendKeys(emp.getLastName());
		driver.findElement(email).sendKeys(emp.getEmail());
		driver.findElement(mobileNo).sendKeys(emp.getMobileNo());
		driver.findElement(saveBtn).click();
		return driver.findElement(alertmsg).getText();
	}
	
	//for Create Database C =  Create 
	
	public String AddEmployee(Employee emp) {
		clickAddEmployee();
		return fillEmployeeDetailsform(emp);
	}
	
	//for Update database U = Update
	
	public String UpdateEmpoyeeDetails(Employee emp,String fName) {
		clickAddEmployee();
		driver.findElement(searchemp).sendKeys(fName);
		driver.findElement(searchrecord).click();
		String byname = "//td[text()='"+fName+"'] //following-sibling::td //following-sibling::td //following-sibling::td //following-sibling::td //following-sibling::td //following-sibling::td //following-sibling::td //following-sibling::td/a[text()='Edit']";
		driver.findElement(By.xpath(byname));
		return fillEmployeeDetailsform(emp);
	}
	
	//for Delete Employee details D =delete
	
	public String DeleteEmployeeDetails(String fName) {
		clickAddEmployee();
		driver.findElement(searchemp).sendKeys(fName);
		driver.findElement(searchrecord).click();
		String byname = "//td[text()='"+fName+"'] //following-sibling::td //following-sibling::td //following-sibling::td //following-sibling::td //following-sibling::td //following-sibling::td //following-sibling::td //following-sibling::td/a[text()='Delete']";
		driver.findElement(By.xpath(byname));
		driver.findElement(By.xpath("//*[text()='Yes']")).click();
		return driver.findElement(alertmsg).getText();
	}
	//for view details or Read Records from database
	public String getEmployeeDetails(Employee emp, String fName) {
		clickAddEmployee();
		driver.findElement(firstName).sendKeys(emp.getFirstName());
		driver.findElement(lastName).sendKeys(emp.getLastName());
		driver.findElement(email).sendKeys(emp.getEmail());
		driver.findElement(mobileNo).sendKeys(emp.getMobileNo());
		driver.findElement(saveBtn).click();
		String msg = driver.findElement(alertmsg).getText();
		
		driver.findElement(searchemp).sendKeys(fName);
		driver.findElement(searchrecord).click();
		String byname = "//td[text()='"+fName+"']";
		String emprecord = driver.findElement(By.xpath(byname)).getText();
		
		return msg;
	}
	
	
}
