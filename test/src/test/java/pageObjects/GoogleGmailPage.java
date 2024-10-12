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



public class GoogleGmailPage {
	
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
	//findby xpath
	@FindBy(xpath="//a[contains(text(),'Inicia sesión')]") WebElement botonIniciarSesion;
	 
	
	
	//3) El constructor e inicio elementos.
	public GoogleGmailPage (WebDriver driver) {
		this.driver = driver;
		 
        // Inicializa el objeto WebDriverWait con el driver y el tiempo de espera
        this.wait = new WebDriverWait(driver, 1);
		PageFactory.initElements(driver, this);
	} 
	
	//4) 
	public boolean botonEsVisible() {
		try {
			wait.until(ExpectedConditions.visibilityOf(botonIniciarSesion));
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		}
		return this.botonIniciarSesion.isDisplayed();
	};
	
	//5) Función apretar boton noticiasbtn 
	public GoogleLoginPage clickIniciarSesion() {
		botonIniciarSesion.click();
		return new GoogleLoginPage(this.driver);
	} 
	
	
}
