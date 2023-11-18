package com.qualitystream.tutorial;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		
		
		System.setProperty("webDriver.chrome.driver","./src/test/resources/chromedriver/.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}
	
	@Test
	public void testGooglePage() throws InterruptedException {
		WebElement searchbox = driver.findElement(By.name("q"));
		String tituloDeLaPagina;
		
		searchbox.clear();
		
		searchbox.sendKeys("quality-stream Introduccion a la Automatización de Pruebas de Software");
		
		searchbox.submit();
		Thread.sleep(10000);
		
	//river.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		tituloDeLaPagina = driver.getTitle();
		System.out.println("Titulo:" + tituloDeLaPagina);
		
		
	assertEquals("quality-stream Introduccion a la Automatización de Pruebas de Software - Buscar con Google", driver.getTitle());
		
		
}
	
	@After
	public void tearDown() {
		driver.quit();
		
	}
}
