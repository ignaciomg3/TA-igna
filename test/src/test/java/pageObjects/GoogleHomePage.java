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



public class GoogleHomePage {
	
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
	@FindBy(id="APjFqb") WebElement searchInput;
	//buscar por clase
	@FindBy(className="gb_A") WebElement iniciarSesion;
	@FindBy(className="LVal7b ") WebElement listaElementos; 
	@FindBy(className="gb_P") WebElement botonImagenPerfil; 
	@FindBy(className="gb_X") WebElement botonGmail; 
	
	//find by data-label
	@FindBy(xpath="//a[contains(text(),'Inicia sesión')]") WebElement botonIniciarSesion;
	//@FindBy(xpath="//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a[1]") WebElement butonPerfil; 
	@FindBy(xpath="//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/a[1]") WebElement butonElementos;
	
	
	
	//3) El constructor e inicio elementos.
	public GoogleHomePage (WebDriver driver) {
		this.driver = driver;
		 
        // Inicializa el objeto WebDriverWait con el driver y el tiempo de espera
        this.wait = new WebDriverWait(driver, 1);
		PageFactory.initElements(driver, this);
	} 
	
	//4) 
	public boolean searchInputEsVisible() {
		try {
			wait.until(ExpectedConditions.visibilityOf(searchInput));
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		}
		return this.searchInput.isDisplayed();
	};
	
	 
	
	//funcion para hacer click en el botón perfil
	public void clickButonLogin() {
		iniciarSesion.click();
	}
	public void clickFotoPerfil() {
		botonImagenPerfil.click();
	}
	public GoogleGmailPage clickGmail() {
		botonGmail.click();
		return new GoogleGmailPage(this.driver);
	}
	//click en el boton iniciar sesion
	public void clickIniciarSesion() {
		botonIniciarSesion.click();
	}
	
	
	public GoogleGmailPage searchText(String text) { 
		this.searchInput.sendKeys(text);
		searchInput.submit();
		return new GoogleGmailPage(this.driver);
	}
	
	//6) 
	public boolean botonLoginEsVisible() {
		try {
			wait.until(ExpectedConditions.visibilityOf(iniciarSesion));
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		}
		return this.iniciarSesion.isDisplayed();
	};
	 
	
	
}
