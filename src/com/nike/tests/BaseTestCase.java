package com.nike.tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public class BaseTestCase {
	
	public WebDriver driver;
	public static final String baseURL = "https://mobileappstdev.nike.com:8276/DazelDev/#";

	public WebDriver createFirefoxDriver() {
		this.driver = new FirefoxDriver(getDesiredCapabilities());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return this.driver;
	}
	
	public WebDriver createChromeDriver() {
		this.driver = new ChromeDriver();
		return this.driver;
	}
	
	public WebDriver createSafariDriver() {
		this.driver = new SafariDriver(getDesiredCapabilities());
		return this.driver;
	}
	
	public WebDriver createIEDriver() {
		this.driver = new InternetExplorerDriver(getDesiredCapabilities());
		return this.driver;
	}
	
	public DesiredCapabilities getDesiredCapabilities() {
		DesiredCapabilities capability = new DesiredCapabilities();
		FirefoxProfile firefoxprofile = new FirefoxProfile();
        firefoxprofile.setAssumeUntrustedCertificateIssuer(false);
        
        capability = DesiredCapabilities.firefox();
        capability.setCapability(FirefoxDriver.PROFILE, firefoxprofile);
		return capability;
	}
	
	public FirefoxProfile getProfile() {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(false);
		return profile;
	}
	
	public WebDriver navigateTo(String path) {
		this.driver.get(path);
		return this.driver;
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Applications/geckodriver");
		System.setProperty("webdriver.chrome.driver", "/Users/vmanep/node_modules/chromedriver/lib/chromedriver/chromedriver");
		driver = createChromeDriver();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
