package com.nike.dazeldev;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchButton extends BasePageObject{

	public SearchButton(WebDriver driver) {
		super(driver, "search_btn");
	}
	
	public WebElement getSearchButton() {
		return thisElement;
	}

	public void setSearchButton(WebElement searchButton) {
		this.thisElement = searchButton;
	}
}
