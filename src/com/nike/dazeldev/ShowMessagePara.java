package com.nike.dazeldev;

import org.openqa.selenium.WebDriver;

public class ShowMessagePara extends BasePageObject {
	

	public ShowMessagePara(WebDriver driver) {
		super(driver, "showMsg");
	}
	
	public boolean isSuccessful() {
		return thisElement.getText().equals("Successful retrieval of records.");
	}

}
