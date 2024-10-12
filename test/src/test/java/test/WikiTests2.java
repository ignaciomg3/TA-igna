package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations. Test;
import org.testng.annotations.Parameters;

import com.selenium.driver.BaseTest;

import pageObjects.WikiHomePage;
import pageObjects.WikiResultsPage;
import utils.TestWithCSVDataProvider;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

	
 
//Run All
public class WikiTests2 extends BaseTest{
		
	public WebDriver driver;
	
	
	//DataProviders
    @DataProvider(name = "datos")
    public Object[][] createData() {
        return new Object[][] {
            { "Selenium"},
            //{ "TestNG"},
            //{ "Maven"},
        };
    }
    
     
    @BeforeMethod
	public void setUp() {
		driver = BaseTest.getDriver(driver, "CHROME");
	}
    
    //Variables rutas
    String wikifilePath = "src/resources/WikiDatos.csv";
    String googlefilePath = "src/resources/GoogleDatos.csv";
    String demofilePath = "src/resources/DemoDatos.csv";
    
     
  //************************************************ TESTS ************************************************
    @Test(  dataProvider = "WikiDatos", 
    		dataProviderClass = TestWithCSVDataProvider.class,
    		description = "Validar que las busquedas en leyendo un archivo CSV")
    //Run | Debug
    public void ValidarBusquedaWikipediaConCSV( String parametro)
    {
        
		//vamos a la URL de inicio.
  		BaseTest.goToMainPage(driver, "http://wikipedia.org");
  		//pagina home
  		WikiHomePage homePage = new WikiHomePage(driver);
  		//funcion para mostrar por pantalla el titulo de la pagina
  		
  		//mostrar "hasta acá funciona" por pantalla 
  		//System.out.println("Hasta acá funciona"); 
  		
  		Assert.assertTrue(homePage.searchInputEsVisible(), "El input NO esta visible");
  		//WikiResultsPage resultsPage = homePage.searchText("Selenium");
  		WikiResultsPage resultsPage = homePage.searchText(parametro);
  		Assert.assertTrue(resultsPage.tituloEsVisible(), "El titulo no esta visible");
  		driver.close();
    }
    
	@Test(dataProvider = "datos" , description = "Validar que las busquedas en Wikipedia funcionan")
	//Run | Debug
	public void ValidarBusquedaWikipedia(String parametro) throws Exception {
		//driver =  BaseTest.getDriver(driver, "CHROME");
		//vamos a la URL de inicio.
		BaseTest.goToMainPage(driver, "http://wikipedia.org");
		//pagina home
		WikiHomePage homePage = new WikiHomePage(driver);
		//funcion para mostrar por pantalla el titulo de la pagina
		
		//mostrar "hasta acá funciona" por pantalla
		//System.out.println("Hasta acá funciona"); 
		
		Assert.assertTrue(homePage.searchInputEsVisible(), "El input NO esta visible");
		//WikiResultsPage resultsPage = homePage.searchText("Selenium");
		WikiResultsPage resultsPage = homePage.searchText(parametro);
		Assert.assertTrue(resultsPage.tituloEsVisible(), "El titulo no esta visible");
		driver.close();
	}
	// Este método se ejecutará después de cada método de prueba
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Cerrar el navegador
        }
        System.out.println("Cerrando navegador..");
    }
}

