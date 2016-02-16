/*
 * Author Andrei Martinescu
 */

package com.accenture.aiss.HRProjectTestHelpers;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class User 
{
	private WebDriver m_driver;
	private String user;
	private String m_oldPassword;
	private String m_newPassword;
	private String m_confirmPassword;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	public User() 
	{}
	
	public User(WebDriver driver) 
	{
		this.m_driver = driver;
	}
	
	
	public User(WebDriver driver, String user, String oldPassword) 
	{
		this.m_driver = driver;
		this.user = user;
		this.m_oldPassword = oldPassword;
	}
	
	
//--------------------------------------------------------------------------------------
	//set homepage method
	public boolean setUpHomePage()
	{
		boolean flag;
		try 
		{
			flag = false;
			baseUrl = "http://localhost:8080";
			m_driver.get(baseUrl + "/");
			m_driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			m_driver.manage().window().maximize();	
		}
		catch (Exception e)
		{
			flag = true;
		}
		
		return flag;
		
	}

	
//--------------------------------------------------------------------------------------	
	//method for set up before login
	public boolean setUpLogin()
	{
		boolean SetUpLoginFlag;
		try 
		{
			SetUpLoginFlag = false;
			baseUrl = "http://localhost:8080/login";
			m_driver.get(baseUrl);
			m_driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			m_driver.manage().window().maximize();
		}
		catch (Exception e)
		{
			SetUpLoginFlag = true;
		}
		
		return SetUpLoginFlag;

	}
	
	
//--------------------------------------------------------------------------------------	
	//method for login 
	public boolean login()
	{
		boolean flag;
		try 
		{
			flag = false;
			m_driver.findElement(By.id("log-id")).clear();
			m_driver.findElement(By.id("log-id")).sendKeys(user);
			m_driver.findElement(By.id("log-pass")).clear();
			m_driver.findElement(By.id("log-pass")).sendKeys(m_oldPassword);
			m_driver.findElement(By.name("action")).click();
		}
		catch (Exception e)
		{
			flag = true;
		}
		
		return   flag;
	}
	
	
//--------------------------------------------------------------------------------------	
	//method for login with new password
	public boolean login(String Password)
	{
		this.m_newPassword = Password;
		boolean flag ;
		
		try 
		{
			flag = false;
			m_driver.findElement(By.id("log-id")).clear();
			m_driver.findElement(By.id("log-id")).sendKeys(user);
			m_driver.findElement(By.id("log-pass")).clear();
			m_driver.findElement(By.id("log-pass")).sendKeys(m_newPassword);
			m_driver.findElement(By.name("action")).click();
		}
		catch (NoSuchElementException e)
		{
			 if (e.toString() == "false")
			 {
				 flag = false;
			 }
			 else 
			 {
				 flag = true;
			 }
		}
		return   flag;
	}

	
//--------------------------------------------------------------------------------------	
	//method for logout
	public boolean logout()
	{
		boolean flag;
		
		try
		{
			WebElement logOut = m_driver.findElement(By.xpath("//input[@type='submit' and @value='Log Out']"));
			logOut.click();
			flag = false;
		}
		
		catch (Exception e)
		{
			flag = true;
		}
		
		return flag;
	}

	
//--------------------------------------------------------------------------------------	
	//method for set up change password
	public boolean setUpChangePassword()
	{
		
		boolean flag = true;
		
		try 
		{
			flag = true;			
			//enter change pass
			m_driver.findElement(By.cssSelector("a.btn.btn-default")).click();
		}
		catch (NoSuchElementException e)
		{
			 if (e.toString() == "false")
			 {
				 flag = false;
			 }
			 else 
			 {
				 flag = true;
			 }
		}
		return   flag;
	}

	
//------------------------------------------------------------------------------	
	//method for change password 
	public boolean changePassword(String newPassword)
	{
		this.m_newPassword = newPassword;
		this.m_confirmPassword = newPassword;
		
		boolean flag = true;
		
		try 
		{
			flag = true;			
			//enter change pass
			//m_driver.findElement(By.cssSelector("a.btn.btn-default")).click();
			
			//enter old pass
			m_driver.findElement(By.id("currentPassword")).clear();
			m_driver.findElement(By.id("currentPassword")).sendKeys(m_oldPassword);
			
			//enter the new pass 
			m_driver.findElement(By.id("newPassword")).clear();
			m_driver.findElement(By.id("newPassword")).sendKeys(m_newPassword);
			
			//confirm pass (same as current )
			m_driver.findElement(By.id("confirmedPassword")).clear();
			m_driver.findElement(By.id("confirmedPassword")).sendKeys(m_confirmPassword);
		}
		catch (NoSuchElementException e)
		{
			 if (e.toString() == "false")
			 {
				 flag = false;
			 }
			 else 
			 {
				 flag = true;
			 }
		}
		return   flag;
	}

	
//--------------------------------------------------------------------------------------
	//method for change password with new password and confirm password
	public boolean changePassword(String newPassword, String confirmPassword)
	{
		this.m_newPassword = newPassword;
		this.m_confirmPassword = confirmPassword;
		
		boolean flag = true;
		
		try 
		{
			flag = true;			
			//enter change pass
			//m_driver.findElement(By.cssSelector("a.btn.btn-default")).click();
			
			//enter old pass
			m_driver.findElement(By.id("currentPassword")).clear();
			m_driver.findElement(By.id("currentPassword")).sendKeys(m_oldPassword);
			
			//enter the new pass 
			m_driver.findElement(By.id("newPassword")).clear();
			m_driver.findElement(By.id("newPassword")).sendKeys(m_newPassword);
			
			//confirm pass (same as current )
			m_driver.findElement(By.id("confirmedPassword")).clear();
			m_driver.findElement(By.id("confirmedPassword")).sendKeys(m_confirmPassword);
		}
		catch (NoSuchElementException e)
		{
			 if (e.toString() == "false")
			 {
				 flag = false;
			 }
			 else 
			 {
				 flag = true;
			 }
		}
		return   flag;
	}
	
	
//--------------------------------------------------------------------------------------	
	//method for create user 
	public boolean createUser(String FullName, String UserEmail, String Password, String ConfirmPassword , String Role)
	{
		boolean createUserFlag;
		
		try
		{
			createUserFlag = false;
			
			m_driver.findElement(By.linkText("Create User")).click();
			
			m_driver.findElement(By.xpath("html/body/div[7]/div/div/form/div/div/div[1]/div/input")).clear();
			
			m_driver.findElement(By.xpath("html/body/div[7]/div/div/form/div/div/div[1]/div/input")).sendKeys(FullName);
			
			m_driver.findElement(By.xpath("html/body/div[7]/div/div/form/div/div/div[2]/div/input")).clear();
			
			m_driver.findElement(By.xpath("html/body/div[7]/div/div/form/div/div/div[2]/div/input")).sendKeys(UserEmail);
			
			m_driver.findElement(By.xpath("html/body/div[7]/div/div/form/div/div/div[3]/div/input")).clear();
			
			m_driver.findElement(By.xpath("html/body/div[7]/div/div/form/div/div/div[3]/div/input")).sendKeys(Password);
			
			m_driver.findElement(By.xpath("html/body/div[7]/div/div/form/div/div/div[4]/div/input")).clear();
			
			m_driver.findElement(By.xpath("html/body/div[7]/div/div/form/div/div/div[4]/div/input")).sendKeys(ConfirmPassword);
			
			if (user == "admin@admin.com") 
			{
				if (Role == "Human Resources")
				{
					m_driver.findElement(By.id("role")).click();
					m_driver.findElement(By.xpath("//*[@id='role']/option[2]")).click();
				}
				
				else if (Role == "Lower Management")
				{
					m_driver.findElement(By.id("role")).click();
					m_driver.findElement(By.xpath("//*[@id='role']/option[3]")).click();
				}
				
				else if (Role == "Upper Management")
				{
					m_driver.findElement(By.id("role")).click();
					m_driver.findElement(By.xpath("//*[@id='role']/option[4]")).click();
				}
				
				else 
				{
					createUserFlag = true;
				}

			}
			
			else if (user == "upper@upper.com") 
			{
				if (Role == "Human Resources")
				{
					m_driver.findElement(By.id("role")).click();
					m_driver.findElement(By.xpath("//*[@id='role']/option[2]")).click();
				}
				
				else if (Role == "Lower Management")
				{
					m_driver.findElement(By.id("role")).click();
					m_driver.findElement(By.xpath("//*[@id='role']/option[3]")).click();
				}
				else 
				{
					createUserFlag = true;
				}
			}
			else 
			{
				createUserFlag = true;
			}
			
		}
		catch (Exception e)
		{
			createUserFlag = true;
		}
		
		return createUserFlag;
	}	
	
	
//------------------------------------------------------------------	
	//method for closing driver
	public String tearDown() 
	{
		m_driver.quit();
		String verificationErrorString = verificationErrors.toString();
		return verificationErrorString;
	}

	
//----------------------------------------------------------------------	
	//method for is element present 
	public boolean isElementPresent(By by)
	{
		try {
			m_driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	
//-------------------------------------------------------------------------
	// check if we have a pop up alert
	public boolean isAlertPresent() 
	{
		try {
			m_driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	
//--------------------------------------------------------------------------------
	// for pop up alerts
	public String closeAlertAndGetItsText() 
	{
		try {
			Alert alert = m_driver.switchTo().alert();
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