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



public class GooglePasswPage {
	
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
  
	@FindBy(className="whsOnd zHQkBf") WebElement inputPassword;
	@FindBy(className="VfPpkd-vQzf8d") WebElement botonSiguiente;
	//encontrar elmento por clase que comience con WpHeLc
	//encontrar elemento por aria-label="Reintentar"
	
	@FindBy(id = "headingText") WebElement botonReintentar;
	//@FindBy(className = "vAV9bf") WebElement h1Error;
	 
	 
	
	
	public void mostrarTextoBotonReintentar() {
        String texto = botonReintentar.getText(); // Obtiene el texto del elemento
        System.out.println("Texto del botón Reintentar: " + texto);
    }
	
	//3) El constructor e inicio elementos.
	public GooglePasswPage (WebDriver driver) {
		this.driver = driver;
		 
        // Inicializa el objeto WebDriverWait con el driver y el tiempo de espera
        this.wait = new WebDriverWait(driver, 1);
		PageFactory.initElements(driver, this);
	} 

	//funcion para leer el tagname de un elemento 
	public String getTagName() {
		return botonReintentar.getTagName();
	}
	public boolean EsVisible() {
		try {
			wait.until(ExpectedConditions.visibilityOf(botonReintentar));
			botonReintentar.getTagName();
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		}
		return botonReintentar.isDisplayed();
	};
	
	//función rellenar input login
	public void rellenarInputLogin(String input) {
		inputPassword.sendKeys(input);
	}
	 
	//función click en boton reintentar
	public GoogleLoginPage clickReintentar() {
		botonReintentar.click();
		return new GoogleLoginPage(this.driver);
	}
	/*public GoogleLoginPage clickIniciarSesion() {
		botonIniciarSesion.click();
		return new GoogleLoginPage(this.driver);
	} 
	*/
	
}
