package com.example.tests;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class JavaTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver", "/Applications/geckodriver");
    driver = new FirefoxDriver(getDesiredCapabilities());
    baseUrl = "https://mobileappstdev.nike.com:8276/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
	
  public DesiredCapabilities getDesiredCapabilities() {
		DesiredCapabilities capability = new DesiredCapabilities();
		FirefoxProfile firefoxprofile = new FirefoxProfile();
        firefoxprofile.setAssumeUntrustedCertificateIssuer(false);
        
        capability = DesiredCapabilities.firefox();
        capability.setCapability(FirefoxDriver.PROFILE, firefoxprofile);
		return capability;
	}

  @Test
  public void testJava() throws Exception {
    driver.get(baseUrl + "/DazelDev/#/default");
    driver.findElement(By.id("search_btn")).click();
    new Select(driver.findElement(By.id("select_file_begin"))).selectByVisibleText("MEC");
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
