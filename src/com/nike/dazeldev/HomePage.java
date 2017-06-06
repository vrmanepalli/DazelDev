package com.nike.dazeldev;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePageObject {
	
	public SearchButton searchButton;
	public SelectFileNameBegin selectFileElement;
	public ShowMessagePara showMsg;
	
	public HomePage(WebDriver driver) {
		super(driver);
		selectFileElement = new SelectFileNameBegin(driver);
		searchButton = new SearchButton(driver);
		showMsg = new ShowMessagePara(driver);
	}

	public SelectFileNameBegin searchFileBegin(String key) {
		selectFileElement.selectAKey(key);
		searchButton.getSearchButton()
		.click();
		return selectFileElement;
	}

}
