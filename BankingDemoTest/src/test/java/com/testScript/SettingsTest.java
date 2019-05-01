package com.testScript;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pages.SettingsPage;
import com.util.DriversUtilities;

public class SettingsTest {

	DriversUtilities driverUtilities;
	WebDriver driver;
	@Before
	public void init(){
		driverUtilities =DriversUtilities.getInstance();
		driver=driverUtilities.getDriver();		
	}
	
	@Test
	public void settingsTest(){
		//WebElement element=SettingsPage.getAccountSettingsAccess(driver);
		
		try {
			if (SettingsPage.getAccountSettingsAccess(driver).isEnabled()) {
				SettingsPage.getAccountSettingsAccess(driver).click();
			}
			
		} catch (Exception e) {
			System.out.println("Failure!!!!!! Account Setting is disabled!!!!!!!");
		}
		
		if (SettingsPage.getAccountSettingsAccess(driver).isEnabled()) {
			SettingsPage.getAccountSettingsAccess(driver).click();
		}
		
	}
}
