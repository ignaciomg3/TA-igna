package test;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations. Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.selenium.driver.BaseTest;

import pageObjects.GoogleHomePage;
import pageObjects.GoogleGmailPage;
import pageObjects.GoogleLoginPage;
import pageObjects.GooglePasswPage;
import utils.TestWithCSVDataProvider;
 
import java.time.Duration;


	//Run All
public class GoogleTest extends BaseTest{
	
		public WebDriver driver;
		//WebDriverWait wait = new WebDriverWait(driver, 1);
		
		//DataProviders
		/*
	    @DataProvider(name = "datos")
	    public Object[][] createData() {
	        return new Object[][] {
	            { "ignaciomg3@gmail.com"},
	        };
	    }
	    */
	    
	     
	    @BeforeMethod
		public void setUp() {
			driver = BaseTest.getDriver(driver, "CHROME");
			
		}
		
		@Test(dataProvider = "GoogleDatos", dataProviderClass = TestWithCSVDataProvider.class, description = "Validar Que no se puede iniciar sesión con un software automatizador de pruebas")
		
	//Run | Debug
	public void ValidarDenegacionDeLogin(String gmail) throws Exception {
			
		//vamos a la URL de inicio.
		BaseTest.goToMainPage(driver, "https://www.google.com/?hl=es");
		//pagina home
		GoogleHomePage homePage = new GoogleHomePage(driver);
		
		GoogleGmailPage gmailPage = homePage.clickGmail();
		
		//esperar 1 segundo
		Thread.sleep(1000);
		
		Assert.assertTrue(gmailPage.botonEsVisible(),"El botón no esta visible");
		GoogleLoginPage loginPage = gmailPage.clickIniciarSesion();
		
		//esperar 1 segundo
		Thread.sleep(1000);
		Assert.assertTrue(loginPage.EsVisible(),"El input no esta visible");
		loginPage.rellenarInputLogin(gmail);
		//esperar 1 segundo con waitDrive para que se vea el cambio
		
		
		GooglePasswPage passPage = loginPage.clickSiguiente();
		Thread.sleep(5000);
		Assert.assertTrue(passPage.EsVisible(),"El input no esta visible");
		 
		driver.close();
		}
		// Este método se ejecutará después de cada método de prueba
		
		@AfterMethod
	    public void cerrarVentanas() {
	        if (driver != null) {
	            driver.quit();  // Cierra todas las ventanas y termina la sesión
	        }
	    }
		
		 
}

