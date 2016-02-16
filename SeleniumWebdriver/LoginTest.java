package com.accenture.aiss.HRProjectTest;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

@RunWith(Parameterized.class)
public class LoginTest {
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {     
			{ "admin@admin.com", "admin" },
			{ "hr@hr.com", "hr" },
			{ "upper@upper.com", "upper" },
			{ "lower@lower.com", "lower" }
		});
	}

	private static ChromeDriverService service;
	private WebDriver driver;
	
	private String fUserName;
	private String fPassword;
	
	public LoginTest(String userName, String password) {
		fUserName = userName;
		fPassword = password;
	}
	
	@BeforeClass
	public static void createAndStartService() throws IOException {
		service = new ChromeDriverService.Builder()
				.usingAnyFreePort()
				.build();
		service.start();
	}
	
	@AfterClass
	public static void stopService() {
		service.stop();
	}
	
	@Before
	public void setUp() {
//		Download latest release from 
//		http://chromedriver.storage.googleapis.com/index.html
//		unzip and add location to path
		driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
		//driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
//		app should already run for this to work
		driver.get("http://localhost:8080/login");
		assertEquals("Page title is not Login", "Login", driver.getTitle());
		assertEquals("URL is /login", "http://localhost:8080/login", driver.getCurrentUrl());

	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void loginUser() {
		try
		{
			WebElement userNameField = driver.findElement(By.id("log-id"));
			userNameField.sendKeys(fUserName);
			
			WebElement passwordField = driver.findElement(By.id("log-pass"));
			passwordField.sendKeys(fPassword);
			
			passwordField.submit();
			
			assertTrue(fUserName + " is not logged in", driver.findElement(
					By.cssSelector("#head h2.subtitle"))
					.getText().contains(fUserName));		
	
			WebElement logOut = driver.findElement(By.xpath("//input[@type='submit' and @value='Log Out']"));
			logOut.click();
			
			assertEquals("http://localhost:8080/login?logout", driver.getCurrentUrl());
			assertEquals("Login", driver.getTitle());
		}
		catch (NoSuchElementException e)
		{
			assertTrue(e.toString(), false);
		}
	}
}
