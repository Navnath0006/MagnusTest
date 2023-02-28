package comp.magnus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MagnusHomePage {
	
	@FindBy(xpath="//center[@class='pt_100']")  
	WebElement welcomemsg;
 
	public MagnusHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getWelcomeMsg() {
		String actWelcomeMsg = welcomemsg.getText();
		return actWelcomeMsg;
	}
}
