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



public class DemoHomePage {
	
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
	@FindBy(id="login2") WebElement botonLogin;
	@FindBy(id="searchInput") WebElement espanol;
	
	
	
	//3) El constructor e inicio elementos.
	public DemoHomePage (WebDriver driver) {
		this.driver = driver;
		 
        // Inicializa el objeto WebDriverWait con el driver y el tiempo de espera
        this.wait = new WebDriverWait(driver, 1);
		PageFactory.initElements(driver, this);
	} 
	
	 
	
	//5) Envío el texto que quiero buscar. y devuelvo una WikiResults
	//
	public DemoLoginPage clickLogin() { 
		botonLogin.click();
		return new DemoLoginPage(this.driver);
	}
	
	//6) 
	public boolean EsVisible() {
		try {
			wait.until(ExpectedConditions.visibilityOf(botonLogin));
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		}
		return this.botonLogin.isDisplayed();
	};
	
	/* Otra forma de retornar true)
	public boolean searchInputEsVisible() {
		return this.searchInput.isDisplayed();
	}
	***/
	
	
	//7
	public boolean verificarTextoEspañol() {
	    String texto = espanol.getText(); // Obtiene el texto del elemento
	    return texto.equals("ES"); // Compara si el texto es igual a "ES"
	}
	
	
}
