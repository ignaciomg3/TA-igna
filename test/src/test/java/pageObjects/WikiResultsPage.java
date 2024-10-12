package pageObjects;
import com.selenium.driver.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;


public class WikiResultsPage {

	@FindBy(id="firstHeading")
	WebElement titulo;
	
	private WebDriver driver = null;
	
	public WikiResultsPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	public boolean tituloEsVisible() {
		return this.titulo.isDisplayed();
	}
}
