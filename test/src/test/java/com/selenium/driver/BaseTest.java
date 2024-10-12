package com.selenium.driver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;




public class BaseTest {
	
	//1) pasar un string URL
	public static void goToMainPage(WebDriver driver, String url) {
		driver.get(url);
	}
	private enum browers {
		CHROME, FIREFOX, EDGE
	}
	
	public static WebDriver getDriver(WebDriver driver, String browser) {
		switch (browers.valueOf(browser.toUpperCase())) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			System.setProperty("webdriver.gecko.driver", "src/resources/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case EDGE:
			System.setProperty("webdriver.edge.driver", "src/resources/msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		default:
			throw new IllegalArgumentException("Invalid browser value");
		}
		
		return driver;
	}
}