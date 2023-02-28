package comp.magnus.pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import comp.magnus.libraryfiles.Utility;

public class MagnusLoginPage {
	
	@FindBy(xpath="//input[@name='UserName']")	
	private WebElement username ;
	
	@FindBy(xpath="//input[@name='Password']")
	private WebElement password;
	
	@FindBy(xpath="//button[.='Sign In']")
	private WebElement sgnbtn;
	
	public MagnusLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername() throws EncryptedDocumentException, IOException {
		username.sendKeys(Utility.getexceldata(1, 0));
	}
	public void enterPassword() throws EncryptedDocumentException, IOException {
		password.sendKeys(Utility.getexceldata(1, 1));
	}
	public void clickonSignInBtn() {
		sgnbtn.click();
	}
}
