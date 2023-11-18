package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base<WebELement> {
	
	private WebDriver driver;
	
	public Base(WebDriver driver) {
		this.driver = driver;
		
	}

	public WebDriver chromeDriverConnection() {
		System.setProperty("webDriver.chrome.driver","./src/test/resources/chromedriver/.exe/");
		driver = new ChromeDriver();
		return driver;
	}
	//public WebELement findElement(By locator) {
		//return driver.findElement(locator);
		
		
}
