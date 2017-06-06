package com.nike.dazeldev;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePageObject {
	
	public WebDriver driver;
	public String id;
	public WebElement thisElement;
	
	public BasePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public BasePageObject(WebDriver driver, String id) {
		this.driver = driver;
		this.id = id;
		thisElement = driver.findElement(By.id(this.id));
	}
	
}
