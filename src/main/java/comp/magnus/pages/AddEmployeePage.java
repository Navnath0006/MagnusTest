package comp.magnus.pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * CRUD operation
 *For Create Operation 
 * 
 * */

public class AddEmployeePage {
	
	@FindBy(xpath = "//*[@id=\"MenusDashboard\"]/li[2]/a")
	private WebElement empolyeeBtn;
	
	@FindBy(xpath="//*[.=' Create ']")
	private WebElement create;
	
	@FindBy(xpath = "//input[@id='FirstName']")
	private WebElement fname;
	
	@FindBy(xpath = "//input[@id='LastName']")
	private WebElement lname;
	
	@FindBy(xpath = "//input[@id='EmailId']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@id='MobileNo']")
	private WebElement mobile;
	
	@FindBy(xpath = "//button[@type='button']")
	private WebElement save;
	
	@FindBy(xpath = "//div[@class='toast-title']")
	private WebElement alertmsg;
	
	@FindBy(xpath = "//a//i[@class='fa fa-search']")
	private WebElement search;
	
	public AddEmployeePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnEmployeeBtn() {
		empolyeeBtn.click();
		create.click();
	}
	public void enterFname(String firstname) throws EncryptedDocumentException, IOException {
		fname.sendKeys(firstname);
	}
	public void enterLname(String lastname) throws EncryptedDocumentException, IOException {
		lname.sendKeys(lastname);
	}
	public void enterEmaiId(String emailid) throws EncryptedDocumentException, IOException {
		email.sendKeys(emailid);
	}
	public void enterMobileNo(String mobileno) throws EncryptedDocumentException, IOException {
		mobile.sendKeys(mobileno);
	}
	public void clickOnSaveBtn() {
		save.click();
	}
	public String getStatusMessage() {
		String alertmessage = alertmsg.getText();
		return alertmessage;
	}
	public void clickOnSearchBtn() {
		search.click();
	}
}
