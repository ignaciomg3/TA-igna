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



public class WikiHomePage {
	
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
	@FindBy(id="searchInput") WebElement searchInput;
	@FindBy(id="searchInput") WebElement espanol;
	
	
	
	//3) El constructor e inicio elementos.
	public WikiHomePage (WebDriver driver) {
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
	
	//5) Envío el texto que quiero buscar. y devuelvo una WikiResults
	//
	public WikiResultsPage searchText(String text) { 
		this.searchInput.sendKeys(text);
		searchInput.submit();
		return new WikiResultsPage(this.driver);
	}
	
	//6) 
	public boolean espanolEsVisible() {
		try {
			wait.until(ExpectedConditions.visibilityOf(espanol));
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		}
		return this.espanol.isDisplayed();
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
