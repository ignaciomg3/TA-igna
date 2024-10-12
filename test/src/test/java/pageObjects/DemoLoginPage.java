package pageObjects;

import org.openqa.selenium.support.PageFactory;
import com.selenium.driver.*;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class DemoLoginPage {
	
	//0) variables.
    private WebDriverWait wait;
    private WebDriver driver = null;
	
	 
	//1) Condiciones finales
	@AfterMethod
	public void PostCondition() {
		driver.manage().deleteAllCookies();
		driver.close();
	}
	
	//2) Defino los elementos
	@FindBy(xpath="//input[@id='loginusername']") WebElement username;
	@FindBy(xpath="//input[@id='loginpassword']") WebElement password;
	@FindBy(xpath="//button[contains(text(),'Log in')]") WebElement btnLogin;
	@FindBy(xpath="//a[contains(text(),'Samsung galaxy s6')]") WebElement telefonoSamsung;
	
	
	//3) El constructor e inicio elementos.
	public DemoLoginPage (WebDriver driver) {
		this.driver = driver;
		 
        // Inicializa el objeto WebDriverWait con el driver y el tiempo de espera
        this.wait = new WebDriverWait(driver, 1);
		PageFactory.initElements(driver, this);
	} 

	public boolean usernameEsVisible() {
		try {
			wait.until(ExpectedConditions.visibilityOf(username));
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		}
		return username.isDisplayed();
	};
	public boolean passwordEsVisible() {
		try {
			wait.until(ExpectedConditions.visibilityOf(password));
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		}
		return password.isDisplayed();
	};
	
	
	//función rellenar input login
	public void rellenarInputLogin(String input) {
		username.sendKeys(input);
	}

	public void rellenarInputPass(String input) {
		password.sendKeys(input);
	}
	//función click en boton siguiente
	public  void clickLogin() {
		btnLogin.click();
		//return new GooglePasswPage(this.driver);
	} 
	public boolean telefonoSamsungEsVisible() {
		try {
			wait.until(ExpectedConditions.visibilityOf(telefonoSamsung));
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		}
		return telefonoSamsung.isDisplayed();
	};
	public  DemoCartPage clickTelefono() {
		telefonoSamsung.click();
		return new DemoCartPage(this.driver);
		//return new GooglePasswPage(this.driver);
	} 
	
	
}
