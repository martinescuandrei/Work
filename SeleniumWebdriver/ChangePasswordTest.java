/*
 * Author Andrei Martinescu
 */

package com.accenture.aiss.HRProjectTest;
import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.accenture.aiss.HRProjectTestHelpers.User;
import com.accenture.aiss.HRProjectTestHelpers.HelpFunctions;
import com.accenture.aiss.HRProjectTestHelpers.HelpFunctions.WriteMode;


public class ChangePasswordTest
{
	private  WebDriver driver; 
	HelpFunctions help = new HelpFunctions();


//---------------------------------------------------------------------------------	
	//Nr1
	//Test UserSetUpLogin
	@Test
	public void UserSetUpLoginITinChangePasswordIT() throws Exception
	{
		driver = new ChromeDriver();

		User user = new User(driver, "upper@upper.com", "upper");
		
		boolean UserSetUpFlag = true;
		try 
		{
			
			UserSetUpFlag = user.setUpLogin();
		
		}
		catch(Exception e)
		{
			help.write("Error finding login element! \nin UserSetUpLoginITinChangePasswordIT test in try catch for set up\n\n\n ", "ChangeUserTest", "UTF-8", WriteMode.APPEND);
			help.takeScreenShotOnFailure(e, "UserSetUpLoginITinChangePasswordIT", driver);
			System.out.println("Error finding login element!");
		}
			
		try
		{
			// test if we had Runtime error
			assertFalse(UserSetUpFlag);
			
			// test if we are on correct page 
			assertTrue(driver.getCurrentUrl().equals("http://localhost:8080/login"));
			
			//test if we have id element field for login
			assertTrue(user.isElementPresent(By.id("log-id")));
			
			//test if we have password element for login
			assertTrue(user.isElementPresent(By.id("log-pass")));
			
			//test if we have Login text displayed
			assertTrue(user.isElementPresent(By.xpath("html/body/div/div/div[1]/h2")));
			
			//test if we have Home button
			assertTrue(user.isElementPresent(By.xpath("html/body/div/div/div[2]/form/div/a")));
			
			//test if we have login button
			assertTrue(user.isElementPresent(By.name("action")));
			
			//test if we have RememberMe element for login
			assertTrue(user.isElementPresent(By.id("remember_me")));
			
			//assertFalse(user.isAlertPresent());
		}
		catch (AssertionError e)
		{
				help.write("Error finding login element! \nin UserSetUpLoginITinChangePasswordIT test in try catch assert\n\n\n ", "ChangeUserTest", "UTF-8", WriteMode.APPEND);
				help.takeScreenShotOnAssertFailure(e,"UserSetUpLoginITinChangePasswordIT",driver);
				System.out.println("Error finding login element!");
		}
		
		
		user.tearDown();
		String error =  user.tearDown();
		if (!"".equals(error)) 
		{
			System.out.println(error);
		}
	}
	
	
//---------------------------------------------------------------------------------		
	//Nr2
	//Test UserLogin
	@Test
	public void UserLoginITinChangePasswordIT() throws Exception
	{
	    //System.out.println("UserLogin");
		driver = new ChromeDriver();

		User user = new User(driver, "upper@upper.com", "upper");
		
		boolean userLoginFlag = true;
		
		try 
		{
			user.setUpLogin();
			
			userLoginFlag =	user.login();
			
		}
		catch (Exception e)
		{
			help.write("Error finding login element! \nin UserLoginITinChangePasswordIT test in try catch for set up\n\n\n ", "ChangeUserTest", "UTF-8", WriteMode.APPEND);
			help.takeScreenShotOnFailure(e, "UserLoginITinChangePasswordIT", driver);
			System.out.println("Error finding login id element or login pass element!");
		}
		
		try
		{   
						
			// test if we had Runtime error 
			assertFalse(userLoginFlag);
			
			// test if we are on correct page 
			assertTrue(driver.getCurrentUrl().equals("http://localhost:8080/"));
			
			//test if welcome user text is present
			assertTrue(user.isElementPresent(By.xpath("//*[@id='head-nav']/h2/span")));
			
			//test if Change Password button is present
			assertTrue(user.isElementPresent(By.xpath("//*[@id='head-nav']/a[1]")));
			
			//test if Logout button is present
			assertTrue(user.isElementPresent(By.xpath("//input[@type='submit' and @value='Log Out']")));
			
			//assertFalse(user.isAlertPresent());
		}
		catch (AssertionError e)
		{
			help.write("Error finding login element! \nin UserLoginITinChangePasswordIT test in try catch assert\n\n\n ", "ChangeUserTest", "UTF-8", WriteMode.APPEND);
			help.takeScreenShotOnAssertFailure(e,"UserLoginITinChangePasswordIT",driver);
			System.out.println("Error finding login id element or login pass element!");
		}
		
		
		user.tearDown();
		String error =  user.tearDown();
		if (!"".equals(error)) 
		{
			System.out.println(error);
		}
	}
	
	
//---------------------------------------------------------------------------------		
	//Nr3
	//Test UserLogout
	@Test
	public void UserLogoutITinChangePasswordIT() throws Exception
	{
	   // System.out.println("UserLogin");
		driver = new ChromeDriver();
	
		User user = new User(driver, "upper@upper.com", "upper");
		
		boolean userLogoutFlag = true;
		
		try 
		{
			user.setUpLogin();
			
			user.login();
			
			userLogoutFlag = user.logout();
			
		}
		catch (Exception e)
		{
			help.write("Error finding login element! \nin UserLogoutITinChangePasswordIT test in try catch for set up\n\n\n ", "ChangeUserTest", "UTF-8", WriteMode.APPEND);
			help.takeScreenShotOnFailure(e, "UserLogoutITinChangePasswordIT", driver);
			System.out.println("Error finding logout element!");
		}
		
		try
		{
			
			//test if we had runtime error
			assertFalse(userLogoutFlag);
			
			// test if we are on correct page 
			assertTrue(driver.getCurrentUrl().equals("http://localhost:8080/login?logout"));
			
			//test if we have id element field for login
			assertTrue(user.isElementPresent(By.id("log-id")));
			
			//test if we have password element for login
			assertTrue(user.isElementPresent(By.id("log-pass")));
			
			//test if we have Login text displayed
			assertTrue(user.isElementPresent(By.xpath("html/body/div/div/div[1]/h2")));
			
			//test if we have Home button
			assertTrue(user.isElementPresent(By.xpath("html/body/div/div/div[2]/form/div/a")));
			
			//test if we have login button
			assertTrue(user.isElementPresent(By.name("action")));
			
			//test if we have RememberMe element for login
			assertTrue(user.isElementPresent(By.id("remember_me")));
			
			//test if we have Logout message 
			assertTrue(user.isElementPresent(By.xpath("html/body/div/div/div[1]/h5")));
			
			//assertFalse(user.isAlertPresent());
		}
		catch (AssertionError e)
		{
			help.write("Error finding login element! \nin UserLogoutITinChangePasswordIT test in try catch assert\n\n\n ", "ChangeUserTest", "UTF-8", WriteMode.APPEND);
			help.takeScreenShotOnAssertFailure(e,"UserLogoutITinChangePasswordIT",driver);
			System.out.println("Error finding logout element!");
		}
			
		user.tearDown();
		String error =  user.tearDown();
		if (!"".equals(error)) 
		{
			System.out.println(error);
		}
	}
	
	
//---------------------------------------------------------------------------------	
	//Nr4	
	//Test CloseDriver after Setup
	@Test
	public void CloseDriverAfterSetUpinChangePasswordIT() throws Exception
	{

		driver = new ChromeDriver();

		User user = new User(driver, "upper@upper.com", "upper");
		
		String error ="";
		
		
		try 
		{
			user.setUpLogin();
			
			user.tearDown();
			
			error =  user.tearDown();
		}
		catch (Exception e)
		{
			help.write("Error finding login element! \nin CloseDriverAfterSetUpinChangePasswordIT test in try catch for set up\n\n\n ", "ChangeUserTest", "UTF-8", WriteMode.APPEND);
			help.takeScreenShotOnFailure(e, "CloseDriverAfterSetUpinChangePasswordIT", driver);
			System.out.println("Error closing browser!");

		}
		
		
		try
		{
			
			assertEquals(error,"");
			if (!"".equals(error)) 
			{
				System.out.println(error);
			}
			
			//assertFalse(user.isAlertPresent());
		}
		catch (AssertionError e)
		{
			help.write("Error finding login element! \nin CloseDriverAfterSetUpinChangePasswordIT test in try catch assert\n\n\n ", "ChangeUserTest", "UTF-8", WriteMode.APPEND);
			help.takeScreenShotOnAssertFailure(e,"CloseDriverinChangePasswordIT",driver);
			System.out.println("Error closing browser!");
		}	
		
	}
	
	
//---------------------------------------------------------------------------------	
	//Nr5
	//Test CloseDriver after Login
	@Test
	public void CloseDriverAfterLogininChangePasswordIT() throws Exception
	{

		driver = new ChromeDriver();

		User user = new User(driver, "upper@upper.com", "upper");
		
		String error ="";
		
		try 
		{
			user.setUpLogin();
			
			user.login();
			
			user.tearDown();
			
			error =  user.tearDown();
		}
		catch (Exception e)
		{
			help.write("Error finding login element! \nin CloseDriverAfterLogininChangePasswordIT test in try catch for set up\n\n\n ", "ChangeUserTest", "UTF-8", WriteMode.APPEND);
			help.takeScreenShotOnFailure(e, "CloseDriverAfterLogininChangePasswordIT", driver);
			System.out.println("Error closing browser!");
		}
		
		
		try
		{
						
			assertEquals(error,"");
			if (!"".equals(error)) 
			{
				System.out.println(error);
			}
			
			//assertFalse(user.isAlertPresent());
		}
		catch (AssertionError e)
		{
			help.write("Error finding login element! \nin CloseDriverAfterLogininChangePasswordIT test in try catch assert\n\n\n ", "ChangeUserTest", "UTF-8", WriteMode.APPEND);
			help.takeScreenShotOnAssertFailure(e,"CloseDriverAfterLogininChangePasswordIT",driver);
			System.out.println("Error closing browser!");
		}
	}
	

//---------------------------------------------------------------------------------	
	//Nr6
	//Test CloseDriver after Logout
	@Test
	public void CloseDriverAfterLogoutinChangePasswordIT() throws Exception
	{

		driver = new ChromeDriver();

		User user = new User(driver, "upper@upper.com", "upper");
		
		String error ="";
		
		try 
		{
			user.setUpLogin();
			
			user.login();
			
			user.logout();
			
			user.tearDown();
			
			error =  user.tearDown();
		}
		catch (Exception e)
		{
			help.write("Error finding login element! \nin CloseDriverAfterLogoutinChangePasswordIT test in try catch for set up\n\n\n ", "ChangeUserTest", "UTF-8", WriteMode.APPEND);
			help.takeScreenShotOnFailure(e, "CloseDriverAfterLogoutinChangePasswordIT", driver);
			System.out.println("Error closing browser!");
		}

		
		try
		{
			assertEquals(error,"");
			if (!"".equals(error)) 
			{
				System.out.println(error);
			}
			//assertFalse(user.isAlertPresent());
		}
		catch (AssertionError e)
		{
			help.write("Error finding login element! \nin CloseDriverAfterLogoutinChangePasswordIT test in try catch assert\n\n\n ", "ChangeUserTest", "UTF-8", WriteMode.APPEND);
			help.takeScreenShotOnAssertFailure(e,"CloseDriverAfterLogoutinChangePasswordIT",driver);
			System.out.println("Error closing browser!");
		}
	}

	
//---------------------------------------------------------------------------------	
	//Nr7
	//Test Logout after Login and Refresh Page
	@Test
	public void LogoutAfterLoginWithRefreshPageinChangePasswordIT() throws Exception
	{

		driver = new ChromeDriver();

		User user = new User(driver, "upper@upper.com", "upper");
		
		try 
		{
			user.setUpLogin();
			
			user.login();
			
			user.logout();
			
			driver.navigate().back();
		}
		catch (Exception e)
		{
			help.write("Error finding login element! \nin LogoutAfterLoginWithRefreshPageinChangePasswordIT test in try catch for set up\n\n\n ", "ChangeUserTest", "UTF-8", WriteMode.APPEND);
			help.takeScreenShotOnFailure(e, "LogoutAfterLoginWithRefreshPageinChangePasswordIT", driver);
			System.out.println("Error on logout!");
		}

		
		try
		{
			
			//check if we are in home page 
			assertEquals(driver.getCurrentUrl(),"http://localhost:8080/");
			
			//check if we are with Guest settings
			assertTrue(user.isElementPresent(By.xpath("//*[@id='head-nav']/h2/span")));
			
			//check if Login button is present
			assertTrue(user.isElementPresent(By.cssSelector("a.btn.btn-primary")));
			
			//assertFalse(user.isAlertPresent());
		}
		catch (AssertionError e)
		{
			help.write("Error finding login element! \nin LogoutAfterLoginWithRefreshPageinChangePasswordIT test in try catch assert\n\n\n ", "ChangeUserTest", "UTF-8", WriteMode.APPEND);
			help.takeScreenShotOnAssertFailure(e,"LogoutAfterLoginWithRefreshPageinChangePasswordIT",driver);
			System.out.println("Error on logout!");
		}
		
		user.tearDown();
		String error =  user.tearDown();
		if (!"".equals(error)) 
		{
			System.out.println(error);
		}
	}

	
//---------------------------------------------------------------------------------	
	//Nr8
	//Test Login and push back navigate button and forward navigate button
	@Test
	public void LoginPushBackAndForwardNavigateButtoninChangePasswordIT() throws Exception
	{

		driver = new ChromeDriver();

		User user = new User(driver, "upper@upper.com", "upper");
		
		try 
		{
			user.setUpLogin();
			
			user.login();
			
			driver.navigate().back();
			
			driver.navigate().forward();
		}
		catch (Exception e)
		{
			help.write("Error finding login element! \nin LoginPushBackAndForwardNavigateButtoninChangePasswordIT test in try catch for set up\n\n\n ", "ChangeUserTest", "UTF-8", WriteMode.APPEND);
			help.takeScreenShotOnFailure(e, "LoginPushBackAndForwardNavigateButtoninChangePasswordIT", driver);
			System.out.println("Error on login!");
		}

		try
		{
				
			//test if welcome user text is present
			assertTrue(user.isElementPresent(By.xpath("//*[@id='head-nav']/h2/span")));
			
			//test if Change Password button is present
			assertTrue(user.isElementPresent(By.xpath("//*[@id='head-nav']/a[1]")));
			
			//test if Logout button is present
			assertTrue(user.isElementPresent(By.xpath("//input[@type='submit' and @value='Log Out']")));
			
			//assertFalse(user.isAlertPresent());
		}
		catch (AssertionError e)
		{
			help.write("Error finding login element! \nin LoginPushBackAndForwardNavigateButtoninChangePasswordIT test in try catch assert\n\n\n ", "ChangeUserTest", "UTF-8", WriteMode.APPEND);
			help.takeScreenShotOnAssertFailure(e,"LoginPushBackAndForwardNavigateButtoninChangePasswordIT",driver);
			System.out.println("Error on login!");
		}
		
		user.tearDown();
		String error =  user.tearDown();
		if (!"".equals(error)) 
		{
			System.out.println(error);
		}
	}
	
	
//---------------------------------------------------------------------------------	
	//Nr9
	//Test Login Logout Login wrong user and push back navigate button twice
	@Test
	public void LoginLogoutLoginWrongUserPushBackTwiceinChangePasswordIT() throws Exception
	{

		driver = new ChromeDriver();

		User user = new User(driver, "upper@upper.com", "upper");
		
		User userWrong = new User(driver, "upperr@upper.com", "upper");
		
		try 
		{
			user.setUpLogin();
			
			user.login();
			
			user.logout();
			
			userWrong.login();
			
			driver.navigate().back();
			
			driver.navigate().back();
		}
		catch (Exception e)
		{
			help.write("Error finding login element! \nin LoginLogoutLoginWrongUserPushBackTwiceinChangePasswordIT test in try catch for set up\n\n\n ", "ChangeUserTest", "UTF-8", WriteMode.APPEND);
			help.takeScreenShotOnFailure(e, "LoginLogoutLoginWrongUserPushBackTwiceinChangePasswordIT", driver);
			System.out.println("Error on login!");
		}
		

		try
		{
			//test if welcome user text is present
			assertTrue(user.isElementPresent(By.xpath("//*[@id='head-nav']/h2/span")));
			
			//test if Login button is present
			assertTrue(user.isElementPresent(By.cssSelector("a.btn.btn-primary")));
			
			//assertFalse(user.isAlertPresent());
		}
		catch (AssertionError e)
		{
			help.write("Error finding login element! \nin LoginLogoutLoginWrongUserPushBackTwiceinChangePasswordIT test in try catch assert\n\n\n ", "ChangeUserTest", "UTF-8", WriteMode.APPEND);
			help.takeScreenShotOnAssertFailure(e,"LoginLogoutLoginWrongUserPushBackTwiceinChangePasswordIT",driver);
			System.out.println("Error on login!");
		}
		
		user.tearDown();
		String error =  user.tearDown();
		if (!"".equals(error)) 
		{
			System.out.println(error);
		}
	}
	
	
//---------------------------------------------------------------------------------	
	//Nr10
	//Test Login Logout Login wrong user and push back navigate button twice and push forward navigate button twice
	@Test
	public void LoginLogoutLoginWrongUserPushBackTwicePushForwardTwiceinChangePasswordIT() throws Exception
	{

		driver = new ChromeDriver();

		User user = new User(driver, "upper@upper.com", "upper");
		
		User userWrong = new User(driver, "upperr@upper.com", "upper");
		
		try 
		{
			user.setUpLogin();
			
			user.login();
			
			user.logout();
			
			userWrong.login();
			
			driver.navigate().back();
			
			driver.navigate().back();
			
			driver.navigate().forward();
			
			driver.navigate().forward();
		}
		catch (Exception e)
		{
			help.write("Error finding login element! \nin LoginLogoutLoginWrongUserPushBackTwicePushForwardTwiceinChangePasswordIT test in try catch for set up\n\n\n ", "ChangeUserTest", "UTF-8", WriteMode.APPEND);
			help.takeScreenShotOnFailure(e, "LoginLogoutLoginWrongUserPushBackTwicePushForwardTwiceinChangePasswordIT", driver);
			System.out.println("Error on login!");
		}
		

		try
		{			
			// test if we are on correct page 
			assertTrue(driver.getCurrentUrl().equals("http://localhost:8080/login?error"));
			
			//test if we have id element field for login
			assertTrue(user.isElementPresent(By.id("log-id")));
			
			//test if we have password element for login
			assertTrue(user.isElementPresent(By.id("log-pass")));
			
			//test if we have Login text displayed
			assertTrue(user.isElementPresent(By.xpath("html/body/div/div/div[1]/h2")));
			
			//test if we have Home button
			assertTrue(user.isElementPresent(By.xpath("html/body/div/div/div[2]/form/div/a")));
			
			//test if we have login button
			assertTrue(user.isElementPresent(By.name("action")));
			
			//test if we have RememberMe element for login
			assertTrue(user.isElementPresent(By.id("remember_me")));
			
			//test if we have Logout message 
			assertTrue(user.isElementPresent(By.xpath("html/body/div/div/div[1]/h5")));
			
			//assertFalse(user.isAlertPresent());
		}
		catch (AssertionError e)
		{
			help.write("Error finding login element! \nin LoginLogoutLoginWrongUserPushBackTwicePushForwardTwiceinChangePasswordIT test in try catch assert\n\n\n ", "ChangeUserTest", "UTF-8", WriteMode.APPEND);
			help.takeScreenShotOnAssertFailure(e,"LoginLogoutLoginWrongUserPushBackTwicePushForwardTwiceinChangePasswordIT",driver);
			System.out.println("Error on login");
		}
		
		user.tearDown();
		String error =  user.tearDown();
		if (!"".equals(error)) 
		{
			System.out.println(error);
		}
	}

	
//---------------------------------------------------------------------------------	
	//Nr11
	//Test Login and push back navigate button and forward navigate button
	@Test
	public void LoginLogoutAndPushLoginButtonfromLogoutMenuinChangePasswordIT() throws Exception
	{

		driver = new ChromeDriver();

		User user = new User(driver, "upper@upper.com", "upper");
		
		try 
		{
			user.setUpLogin();
			
			user.login();
			
			user.logout();
			
			driver.findElement(By.name("action")).click();
		}
		catch (Exception e)
		{
			help.write("Error finding login element! \nin LoginLogoutAndPushLoginButtonfromLogoutMenuinChangePasswordIT test in try catch for set up\n\n\n ", "ChangeUserTest", "UTF-8", WriteMode.APPEND);
			help.takeScreenShotOnFailure(e, "LoginLogoutAndPushLoginButtonfromLogoutMenuinChangePasswordIT", driver);
			System.out.println("Error on login!");
		}
		

		try
		{
						
			//test if we have id element field for login
			assertTrue(user.isElementPresent(By.id("log-id")));
			
			//test if we have password element for login
			assertTrue(user.isElementPresent(By.id("log-pass")));
			
			//test if we have Login text displayed
			assertTrue(user.isElementPresent(By.xpath("html/body/div/div/div[1]/h2")));
			
			//test if we have Home button
			assertTrue(user.isElementPresent(By.xpath("html/body/div/div/div[2]/form/div/a")));
			
			//test if we have login button
			assertTrue(user.isElementPresent(By.name("action")));
			
			//test if we have RememberMe element for login
			assertTrue(user.isElementPresent(By.id("remember_me")));
			
			//test if we have Logout message 
			assertTrue(user.isElementPresent(By.xpath("html/body/div/div/div[1]/h5")));
			
			//assertFalse(user.isAlertPresent());
		}
		catch (AssertionError e)
		{
			help.write("Error finding login element! \nin LoginLogoutAndPushLoginButtonfromLogoutMenuinChangePasswordIT test in try catch assert\n\n\n ", "ChangeUserTest", "UTF-8", WriteMode.APPEND);
			help.takeScreenShotOnAssertFailure(e,"LoginLogoutAndPushLoginButtonfromLogoutMenuinChangePasswordIT",driver);
			System.out.println("Error on login!");
		}
		
		user.tearDown();
		String error =  user.tearDown();
		if (!"".equals(error)) 
		{
			System.out.println(error);
		}
	}

	
//---------------------------------------------------------------------------------	
	//Nr12
	//Test Login with wrong user
	@Test
	public void LoginWrongUserinChangePasswordIT() throws Exception
	{

		driver = new ChromeDriver();

		User user = new User(driver, "upperr@upper.com", "upper");
		
		try 
		{
			user.setUpLogin();
			
			user.login();
			
		}
		catch (Exception e)
		{
			help.write("Error finding login element! \nin LoginWrongUserinChangePasswordIT test in try catch for set up\n\n\n ", "ChangeUserTest", "UTF-8", WriteMode.APPEND);
			help.takeScreenShotOnFailure(e, "LoginWrongUserinChangePasswordIT", driver);
			System.out.println("Error on login!");
		}

		try
		{
			
			// test if we are on correct page 
			assertTrue(driver.getCurrentUrl().equals("http://localhost:8080/login?error"));
			
			//test if we have id element field for login
			assertTrue(user.isElementPresent(By.id("log-id")));
			
			//test if we have password element for login
			assertTrue(user.isElementPresent(By.id("log-pass")));
			
			//test if we have Login text displayed
			assertTrue(user.isElementPresent(By.xpath("html/body/div/div/div[1]/h2")));
			
			//test if we have Home button
			assertTrue(user.isElementPresent(By.xpath("html/body/div/div/div[2]/form/div/a")));
			
			//test if we have login button
			assertTrue(user.isElementPresent(By.name("action")));
			
			//test if we have RememberMe element for login
			assertTrue(user.isElementPresent(By.id("remember_me")));
			
			//test if we have Logout message 
			assertTrue(user.isElementPresent(By.xpath("html/body/div/div/div[1]/h5")));
			
			//assertFalse(user.isAlertPresent());
		}
		catch (AssertionError e)
		{
			help.write("Error finding login element! \nin LoginWrongUserinChangePasswordIT test in try catch assert\n\n\n ", "ChangeUserTest", "UTF-8", WriteMode.APPEND);
			help.takeScreenShotOnAssertFailure(e,"LoginWrongUserinChangePasswordIT",driver);
			System.out.println("Error on login!");
		}
		
		user.tearDown();
		String error =  user.tearDown();
		if (!"".equals(error)) 
		{
			System.out.println(error);
		}
	}

	
//---------------------------------------------------------------------------------	
	//Nr13
	//Test Login with wrong password
	@Test
	public void LoginWrongPasswordinChangePasswordIT() throws Exception
	{

		driver = new ChromeDriver();

		User user = new User(driver, "upper@upper.com", "upperr");
		
		try 
		{
			user.setUpLogin();
			
			user.login();
			
		}
		catch (Exception e)
		{
			help.write("Error finding login element! \nin LoginWrongPasswordinChangePasswordIT test in try catch for set up\n\n\n ", "ChangeUserTest", "UTF-8", WriteMode.APPEND);
			help.takeScreenShotOnFailure(e, "LoginWrongPasswordinChangePasswordIT", driver);
			System.out.println("Error on login!");
		}

		try
		{
			
			// test if we are on correct page 
			assertTrue(driver.getCurrentUrl().equals("http://localhost:8080/login?error"));
			
			//test if we have id element field for login
			assertTrue(user.isElementPresent(By.id("log-id")));
			
			//test if we have password element for login
			assertTrue(user.isElementPresent(By.id("log-pass")));
			
			//test if we have Login text displayed
			assertTrue(user.isElementPresent(By.xpath("html/body/div/div/div[1]/h2")));
			
			//test if we have Home button
			assertTrue(user.isElementPresent(By.xpath("html/body/div/div/div[2]/form/div/a")));
			
			//test if we have login button
			assertTrue(user.isElementPresent(By.name("action")));
			
			//test if we have RememberMe element for login
			assertTrue(user.isElementPresent(By.id("remember_me")));
			
			//test if we have Logout message 
			assertTrue(user.isElementPresent(By.xpath("html/body/div/div/div[1]/h5")));
			
			//assertFalse(user.isAlertPresent());
		}
		catch (AssertionError e)
		{
			help.write("Error finding login element! \nin LoginWrongPasswordinChangePasswordIT test in try catch assert\n\n\n ", "ChangeUserTest", "UTF-8", WriteMode.APPEND);
			help.takeScreenShotOnAssertFailure(e,"LoginWrongPasswordinChangePasswordIT",driver);
			System.out.println("Error on login!");
		}
		
		user.tearDown();
		String error =  user.tearDown();
		if (!"".equals(error)) 
		{
			System.out.println(error);
		}
	}


//---------------------------------------------------------------------------------	
	//Nr14
	//Test SetUp change password
	@Test
	public void SetUpChangePasswordinChangePasswordIT() throws Exception
	{

		driver = new ChromeDriver();

		User user = new User(driver, "upper@upper.com", "upper");
		
		try 
		{
			user.setUpLogin();
			
			user.login();
			
			user.setUpChangePassword();
			
		}
		catch (Exception e)
		{
			help.write("Error finding login element! \nin SetUpChangePasswordinChangePasswordIT test in try catch for set up\n\n\n ", "ChangeUserTest", "UTF-8", WriteMode.APPEND);
			help.takeScreenShotOnFailure(e, "SetUpChangePasswordinChangePasswordIT", driver);
			System.out.println("Error entering ChangePassword button!");
		}
		
			
		try {
			
			//check if Change Password message is displayed on Change Password menu
			assertTrue(user.isElementPresent(By.xpath("//*[@id='pwdModalLabel']")));
			
			//check if Current Password message is displayed on Change Password menu
			assertTrue(user.isElementPresent(By.xpath("//*[@id='changePassword']/div/div/div[1]/div/label")));
			
			//check if Current Password field is present on Change Password menu
			assertTrue(user.isElementPresent(By.id("currentPassword")));
			
			//check if New Password message is displayed on Change Password menu
			assertTrue(user.isElementPresent(By.xpath("//*[@id='changePassword']/div/div/div[2]/div/label")));
			
			//check if New Password field is present on Change Password menu
			assertTrue(user.isElementPresent(By.id("newPassword")));
			
			//check if Confirm new Password message is displayed on Change Password menu
			assertTrue(user.isElementPresent(By.xpath("//*[@id='changePassword']/div/div/div[3]/div/label")));
			
			//check if Confirm new Password field is present on Change Password menu
			assertTrue(user.isElementPresent(By.id("confirmedPassword")));
			
			//check if ChangePassword button is present
			assertTrue(user.isElementPresent(By.xpath("//*[@id='changePassword']/div/div/div[4]/button[1]")));
			
			//check if Cancel button is present
			assertTrue(user.isElementPresent(By.xpath("//*[@id='changePassword']/div/div/div[4]/button[2]")));
			
			//check if x button is present
			assertTrue(user.isElementPresent(By.xpath("//*[@id='pwdModal']/div/div/div/button")));
			
		}
		catch (AssertionError e)
		{
			help.write("Error finding login element! \nin SetUpChangePasswordinChangePasswordIT test in try catch assert\n\n\n ", "ChangeUserTest", "UTF-8", WriteMode.APPEND);
			help.takeScreenShotOnAssertFailure(e,"SetUpChangePasswordinChangePasswordIT",driver);
			System.out.println("Error entering ChangePassword button!");
		}
		
		user.tearDown();
		String error =  user.tearDown();
		if (!"".equals(error)) 
		{
			System.out.println(error);
		}
	}
	

//---------------------------------------------------------------------------------	
	//Test 15
	// Test Create User from admin login
	@Test
	public void CreateUserFromAdminLogininChangePasswordIT() throws Exception
	{
		driver = new ChromeDriver();
	
		User user = new User(driver, "admin@admin.com", "admin");
		
		boolean createUserFlag = true;
		try 
		{
			user.setUpLogin();
			
			user.login();
			
			createUserFlag = user.createUser("Andrei", "andrei@gmail.com", "123456", "123456", "Upper Management");
		}
		catch (Exception e)
		{
			help.write("Error finding login element! \nin CreateUserFromAdminLogininChangePasswordIT test in try catch for set up\n\n\n ", "ChangeUserTest", "UTF-8", WriteMode.APPEND);
			help.takeScreenShotOnFailure(e, "CreateUserFromAdminLogininChangePasswordIT", driver);
			System.out.println("Error entering Create User!");
		}
		
		
		try
		{			
			//check if we had runtime error
			assertFalse(createUserFlag);
			
			//check if Full Name field is present
			assertTrue(user.isElementPresent(By.xpath("html/body/div[7]/div/div/form/div/div/div[1]/div/input")));
			
			//check if Andrei is in Full Name field written
			//assertEquals(driver.findElement(By.xpath("html/body/div[7]/div/div/form/div/div/div[1]/div/input")).getText(),"Andrei");
			
			//check if Email field is present
			assertTrue(user.isElementPresent(By.xpath("html/body/div[7]/div/div/form/div/div/div[2]/div/input")));
			
			//check if andrei@gmail.com is in Email field written
			//assertEquals(driver.findElement(By.xpath("html/body/div[7]/div/div/form/div/div/div[2]/div/input")).getText(),"andrei@gmail.com");
	
			//check if Password field is present
			assertTrue(user.isElementPresent(By.xpath("html/body/div[7]/div/div/form/div/div/div[3]/div/input")));
			
			//check if 123456 is in Password field written
			//assertEquals(driver.findElement(By.xpath("html/body/div[7]/div/div/form/div/div/div[3]/div/input")).getText(),"andrei@gmail.com");
			
			//check if ConfirmPassword field is present
			assertTrue(user.isElementPresent(By.xpath("html/body/div[7]/div/div/form/div/div/div[4]/div/input")));
			
			//check if 123456 is in ConfirmPassword field written
			//assertEquals(driver.findElement(By.xpath("html/body/div[7]/div/div/form/div/div/div[4]/div/input")).getText(),"andrei@gmail.com");
	
			//check if Role field is present
			assertTrue(user.isElementPresent(By.id("role")));
			
			//check if Role Upper Management is present
			assertTrue(user.isElementPresent(By.xpath("//*[@id='role']/option[2]")));
		}
		catch (AssertionError e)
		{
			help.write("Error finding login element! \nin CreateUserFromAdminLogininChangePasswordIT test in try catch assert\n\n\n ", "ChangeUserTest", "UTF-8", WriteMode.APPEND);
			help.takeScreenShotOnAssertFailure(e,"SetUpChangePasswordinChangePasswordIT",driver);
			System.out.println("Error entering Create User!");
		}
		
		user.tearDown();
		String error =  user.tearDown();
		if (!"".equals(error)) 
		{
			System.out.println(error);
		}
	}	
}
