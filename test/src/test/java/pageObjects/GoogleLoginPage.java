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



public class GoogleLoginPage {
	
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
	@FindBy(xpath="//input[@id='identifierId']") WebElement inputLogin;
	@FindBy(xpath="//span[contains(text(),'Siguiente')]") WebElement botonSiguiente;
	
	
	//3) El constructor e inicio elementos.
	public GoogleLoginPage (WebDriver driver) {
		this.driver = driver;
		 
        // Inicializa el objeto WebDriverWait con el driver y el tiempo de espera
        this.wait = new WebDriverWait(driver, 1);
		PageFactory.initElements(driver, this);
	} 

	public boolean EsVisible() {
		try {
			wait.until(ExpectedConditions.visibilityOf(inputLogin));
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		}
		return inputLogin.isDisplayed();
	};
	
	//función rellenar input login
	public void rellenarInputLogin(String input) {
		inputLogin.sendKeys(input);
	}
	 
	//función click en boton siguiente
	public GooglePasswPage clickSiguiente() {
		botonSiguiente.click();
		return new GooglePasswPage(this.driver);
	} 
	
	
}
