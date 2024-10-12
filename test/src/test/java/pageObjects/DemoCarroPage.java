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

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

public class DemoCarroPage {

	// 0) variables.
	
	
	private WebDriver driver = null;
	private WebDriverWait wait ;
	// 1) Condiciones finales
	@AfterMethod
	public void PostCondition() {
		driver.manage().deleteAllCookies();
		driver.close();
	}

	// 2) Defino los elementos
	@FindBy(xpath = "//a[contains(text(),'Add to cart')]")
	WebElement AddToCart;
	@FindBy(xpath = "//input[@id='loginpassword']")
	WebElement password;
	@FindBy(xpath = "//td[contains(text(),'360')]")
	WebElement contenedor;
	@FindBy(xpath = "//a[contains(text(),'Delete')]")
	WebElement btndelete;

	// 3) El constructor e inicio elementos.
	public DemoCarroPage(WebDriver driver) {
		this.driver = driver;

		
		//this.wait = new WebDriverWait(driver, 1);
		//this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, 2 );
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		PageFactory.initElements(driver, this);
	}

	public boolean AddToCartEsVisible() {
		try {
			wait.until(ExpectedConditions.visibilityOf(AddToCart));
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		}
		return AddToCart.isDisplayed();			
	};

	// función rellenar input login
	/*
	 * public void rellenarInputLogin(String input) { username.sendKeys(input); }
	 */

	public void rellenarInputPass(String input) {
		password.sendKeys(input);
	}

	// función click en boton siguiente
	public void clickdelete() {
		btndelete.click();
		// return new GooglePasswPage(this.driver);
	}

	public boolean addToCartEsVisible() {
		try {
			wait.until(ExpectedConditions.visibilityOf(AddToCart));
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		}
		return AddToCart.isDisplayed();
	};

	public boolean contenedorEsVisible() {
		//si está visible retornar	true
		//si no está visible retornar false
		//wait.until(ExpectedConditions.visibilityOf(contenedor));
		if(contenedor.isDisplayed()) {
            return true;
        }else {
          	return false;
        }
	}
	public boolean eliminarEsVisible() {
		//try
	    //si está visible retornar	tru
		try {
			wait.until(ExpectedConditions.visibilityOf(btndelete));
			return true;
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
			return false;
		}
		
	}
	//click en delete mientras esté visible
	public void clickDeleteMientrasVisible() {
	    // Mientras el botón delete esté visible
	    while (btndelete.isDisplayed()) {
	        // Hacer clic en el botón delete
	        btndelete.click();

	        // Añadir una pequeña pausa para evitar clicks demasiado rápidos (opcional)
	        try {
	            Thread.sleep(500); // Espera 0.5 segundos entre clicks
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}

	public void clickAddToCart() {
		AddToCart.click();
		// return new GooglePasswPage(this.driver);
	}
	public boolean elementoEsVisible() throws TimeoutException {
	    try {
	        // Espera hasta que el elemento sea visible
	        wait.until(ExpectedConditions.visibilityOf(contenedor));
	        return contenedor.isDisplayed(); // Retorna true si el elemento está visible
	    } catch (NoSuchElementException e) {
	        return false; // Retorna false si no se encuentra el elemento o si se agota el tiempo de espera
	    }
	}


}
