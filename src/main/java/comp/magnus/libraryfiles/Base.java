package comp.magnus.libraryfiles;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	public WebDriver driver;
	public void openBrowser() throws EncryptedDocumentException, IOException {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(Utility.getprofiles("url"));
		//System.out.println(driver.getTitle());
	}
}
