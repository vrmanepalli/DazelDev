package com.nike.dazeldev;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectFileNameBegin extends BasePageObject{

	WebDriver driver;
	private Select thisSelect;

	public SelectFileNameBegin(WebDriver driver) {
		super(driver, "select_file_begin");
		thisSelect = new Select(thisElement);
	}

	public Select getSelector() {
		return thisSelect;
	}

	public SelectFileNameBegin selectAKey(String key) {
		thisElement.click();
		getSelector().selectByVisibleText(key);
		return this;
	}

	public boolean isSelected(String key) {
		if (getSelector().getFirstSelectedOption() == null) {
			return false;
		}
		return getSelector().getFirstSelectedOption().getText().trim().equals(key);
	}

}
