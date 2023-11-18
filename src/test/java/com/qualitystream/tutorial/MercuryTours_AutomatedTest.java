package com.qualitystream.tutorial;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryTours_AutomatedTest {

	private WebDriver driver;
	By registerLinkLocator = By.linkText("REGISTER");
	By registerPageLocator = By.xpath("//img[@src='images/mast_register.gif']");
	By firstnameLocator = By.name("firstName");
	By lastnameLocator = By.name("lastName");
	By numberLocator = By.name("phone");
	By emailLocator = By.name("userName");

	By usernameLocator = By.id("email");
	By passwordLocator = By.name("password");
	By comfirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");

	By registerBtnLocator = By.name("submit");

	//By signOnLocator = By.xpath("");
	By userLocator = By.name("userName");
	By passLocator = By.name("password");
	By signInBtnLocator = By.name("submit");
	By flightLocator = By.xpath("/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]");
	//private By signInBtnLocator;

	By homePageLocator = By.xpath("//img[@src='images/mast_flightfinder.gif']");
	By anuncioLocator = By.xpath("//div[@class='btn skip']");

	By precioVueloAtlanta = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table[1]/tbody/tr[3]/td/table/tbody/tr[1]/td[2]/div/font/b");
	By precioVueloBoston = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table[1]/tbody/tr[3]/td/table/tbody/tr[2]/td[2]/div/font/b");
	By precioVueloLosAngeles = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table[1]/tbody/tr[3]/td/table/tbody/tr[3]/td[2]/div/font/b");
	By precioVueloNewYork = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table[1]/tbody/tr[3]/td/table/tbody/tr[4]/td[2]/div/font/b");
	By precioVueloPhoenix = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table[1]/tbody/tr[3]/td/table/tbody/tr[5]/td[2]/div/font/b");




	@Before
	public void setUp() throws Exception {
		System.setProperty("webDriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/index.php"); //aqui vos decis en que pagina vas a estar
		Thread.sleep(2000);
		Thread.sleep(2000);
		Thread.sleep(2000);

	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void extraerPrecioDeVuelo() throws InterruptedException {
		String precio;

		Thread.sleep(2000);
		precio = driver.findElement(precioVueloAtlanta).getText();
		System.out.println("1) Precio de vuelo de Atlanta a Las Vegas es:"+ precio);
	}


	@Test
	public void registerUser() throws InterruptedException {
		driver.findElement(registerLinkLocator).click();
		Thread.sleep(2000);
		if (driver.findElement(registerLinkLocator).isDisplayed()) {
			Thread.sleep(5000);
			driver.findElement(firstnameLocator).sendKeys("ian");
			driver.findElement(lastnameLocator).sendKeys("smith");
			driver.findElement(numberLocator).sendKeys("72414026");
			driver.findElement(emailLocator).sendKeys("iansmith40@gmail");
			driver.findElement(usernameLocator).sendKeys("qualityadmin");
			driver.findElement(passwordLocator).sendKeys("pass1");
			driver.findElement(comfirmPasswordLocator).sendKeys("pass1");

			driver.findElement(registerBtnLocator).click();
		} else {

			System.out.print("Register pages was not found");
		}
		List<WebElement> fonts = driver.findElements(By.tagName("font"));
		assertEquals("Note: Your user name is qualityadmin.", fonts.get(5).getText());
	}

	@Test
	public void singIn() throws InterruptedException {
		if (driver.findElement(userLocator).isDisplayed()) {
			driver.findElement(userLocator).sendKeys("qualityadmin");
			driver.findElement(passLocator).sendKeys("pass1");
			//Thread.sleep(2000);
			driver.findElement(signInBtnLocator).click();
			Thread.sleep(2000);
			driver.findElement(flightLocator).click();
			//driver.findElement(homePageLocator).click();
			Thread.sleep(5000);
			driver.switchTo().frame("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0");
			//con este comando hice que el driver se enfocara en el anuncio, poque si no, no puede ver los elementos del anuncio.
			Thread.sleep(2000);
			driver.findElement(anuncioLocator).click();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			// con este comando hice que el driver se enfocara de nuevo en la pagina,porque si no, no encuentra los elementos de la pagina
			Thread.sleep(2000);

			//driver.findElement(precioVueloAtlanta).getText();
			//System.out.println("1) Precio de vuelo de Atlanta a Las Vegas es:"+ precioVueloAtlanta);


			assertTrue(driver.findElement(homePageLocator).isDisplayed());
			//el assert es para comparar 2 cosas, en este caso no esta tan bien usado, pero se fija que
			//que lo de adentro quede en true, o sea que se fije que ese comando no falle
		} else {
			System.out.println("userName textbox was not present");

		}
	}
}
		


	


