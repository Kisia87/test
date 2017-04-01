package pl.lait.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignOnPage {
	
	static String userNameText = "userName";
	static String passowordText = "password";
	static String loginButonText = "login";
	
	public void loginAs(String user, String pass,WebDriver driver) {
	
			driver.findElement(By.name(userNameText)).sendKeys(user);
			driver.findElement(By.name(passowordText)).sendKeys(pass);
			driver.findElement(By.name(loginButonText)).click();
	
	}

	private boolean isElementPresent(By locatorKey, WebDriver driver) {
		try {
			driver.findElement(locatorKey);
			return true;
		}catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}	
	private void linkClick(String string) {
		// TODO Auto-generated method stub
		
	}

	private boolean isElementPresent(By linkText) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
