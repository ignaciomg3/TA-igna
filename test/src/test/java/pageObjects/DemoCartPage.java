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



public class DemoCartPage {
	
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
	@FindBy(xpath="//a[contains(text(),'Add to cart')]") WebElement AddToCart;
	@FindBy(xpath="//a[@id='cartur']") WebElement carro;
	@FindBy(xpath="//button[contains(text(),'Log in')]") WebElement btnLogin;
	@FindBy(xpath="//a[contains(text(),'Samsung galaxy s6')]") WebElement telefonoSamsung;
	
	
	//3) El constructor e inicio elementos.
	public DemoCartPage (WebDriver driver) {
		this.driver = driver;
		 
        // Inicializa el objeto WebDriverWait con el driver y el tiempo de espera
        this.wait = new WebDriverWait(driver, 1);
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
	
	
	//función rellenar input login
	/*public void rellenarInputLogin(String input) {
		username.sendKeys(input);
	}
	*/
	
	
	
	//función click en boton siguiente
	public  void clickLogin() {
		btnLogin.click();
		//return new GooglePasswPage(this.driver);
	} 
	public boolean addToCartEsVisible() {
		try {
			wait.until(ExpectedConditions.visibilityOf(AddToCart));
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		}
		return AddToCart.isDisplayed();
	};
	
	public  void clickAddToCart() {
		AddToCart.click();
		//return new GooglePasswPage(this.driver);
	} 
	public  DemoCarroPage clickCarro() {
		carro.click();
		return new DemoCarroPage(this.driver);
		//return new GooglePasswPage(this.driver);
	} 
	
	
}
