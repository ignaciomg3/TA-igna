package test;

import org.testng.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations. Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.selenium.driver.BaseTest;

import pageObjects.DemoCarroPage;
import pageObjects.DemoCartPage;
import pageObjects.DemoHomePage;
import pageObjects.DemoLoginPage;

import pageObjects.WikiHomePage;
import pageObjects.WikiResultsPage;


import java.time.Duration;

	

 
	//Run All
public class DemoBlazeTest extends BaseTest{
	
	
		public WebDriver driver;
		public WebDriverWait wait;
		public DemoLoginPage loginPage;   
		public DemoCartPage cartPage;
		public DemoCarroPage carroPage;
		
	@BeforeMethod
	public void setUp() throws InterruptedException {
		driver = BaseTest.getDriver(driver, "CHROME");
		driver.manage().deleteAllCookies();
		//wait = new WebDriverWait(driver, 2);
		//vamos a la URL de inicio.
		BaseTest.goToMainPage(driver, "https://www.demoblaze.com/index.html");
		//pagina home
		DemoHomePage homePage = new DemoHomePage(driver);
		//funcion para mostrar por pantalla el titulo de la pagina
		
		
		Assert.assertTrue(homePage.EsVisible(), "El input NO esta visible");
		//DemoLoginPage loginPage = homePage.clickLogin();
		loginPage = homePage.clickLogin();
		//esperar 1 segundo
		Thread.sleep(1000);
		Assert.assertTrue(loginPage.usernameEsVisible(), "El input NO esta visible");
		Assert.assertTrue(loginPage.passwordEsVisible(), "El input NO esta visible");
		loginPage.rellenarInputLogin("admin");
		loginPage.rellenarInputPass("admin");
		loginPage.clickLogin();
		//esperar 1 segundo
		Thread.sleep(1000);
		Assert.assertTrue(loginPage.telefonoSamsungEsVisible(), "telefono NO esta visible");
		
        
	}
		
		
		
	@Test(description = "Validar que el producto se elimina del carrito.")
	//Run | Debug
	public void ValidarEliminacionDeProductos() throws Exception {
		
		wait = new WebDriverWait(driver, 2);
		cartPage = loginPage.clickTelefono();
		
		Assert.assertTrue(cartPage.addToCartEsVisible(), "addtocart NO esta visible");
		//click en Add to cart
		cartPage.clickAddToCart();
		
		//esperar una alerta y aceptarla
		
		// Espera hasta que la alerta esté presente
        Alert alerta = wait.until(ExpectedConditions.alertIsPresent());
       
        // Acepta la alerta
        alerta.accept();
        
        //click en cart
        carroPage = cartPage.clickCarro();
        try {
            Thread.sleep(5000); // Pausa por 5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(carroPage.contenedorEsVisible(), "contenedor NO esta visible");
        try {
            Thread.sleep(2000); // Pausa por 5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        carroPage.clickdelete();
        try {
            Thread.sleep(2000); // Pausa por 5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //espera
        //Assert.assertFalse(carroPage.contenedorEsVisible(), "contenedor esta visible");
        
        Assert.assertFalse(carroPage.eliminarEsVisible(), "El contenedor está visible cuando debería ser invisible.");

        //distinto de true
        //Assert.assertFalse(carroPage.contenedorEsVisible(), "contenedor esta visible");
		driver.close();
		driver.quit();
		}
	
	@AfterMethod
	public void tearDown() {
		driver.manage().deleteAllCookies();
		//driver.close();
		driver.quit();
	}
		
		 
}

