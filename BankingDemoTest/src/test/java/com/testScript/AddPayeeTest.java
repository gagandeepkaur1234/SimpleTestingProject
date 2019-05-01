package com.testScript;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.pages.AddPayeePage;
import com.testData.TestData;
import com.util.DriversUtilities;

public class AddPayeeTest {
	DriversUtilities driverUtilities;
	WebDriver driver;
	@Before
	public void init(){
		driverUtilities =DriversUtilities.getInstance();
		driver=driverUtilities.getDriver();		
	}
	
	@Test
	public void addPayeeTest(){
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		String actualText= AddPayeePage.getPayBillsPageWecomeTextAccess(driver).getText();
		//System.out.println(actualText);
		String expectedText= TestData.payBillsPageText;
		assertEquals(expectedText, actualText);
		
		
		AddPayeePage.getAddNewPayeeAccess(driver).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		expectedText=TestData.addNewPayeePageText;
		actualText= AddPayeePage.getaddNewPayeePageTextAccess(driver).getText();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		assertEquals(expectedText, actualText);
		
		// Enter Data for new Payee
		AddPayeePage.getaddNewPayeeNameAccess(driver).sendKeys(TestData.newPayeeName);
		AddPayeePage.getaddNewPayeeAddressAccess(driver).sendKeys(TestData.newPayeeAddress);
		AddPayeePage.getaddNewPayeeAccountAccess(driver).sendKeys(TestData.newPayeeAccout);
		AddPayeePage.getaddNewPayeeDetailsAccess(driver).sendKeys(TestData.newPayeeDetails);
		AddPayeePage.getaddNewPayeeADDButtonAccess(driver).click();
		
		System.out.println("Comparing welcome message text for newly added payee");
		
		expectedText=TestData.addNewPayeeWelcomeMessage;
		actualText= AddPayeePage.getaddNewPayeeWelcomeMessageTextAccess(driver).getText();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		assertEquals(expectedText, actualText);
		
		WebElement titledropdown= AddPayeePage.getFindSavedPayeeFromDropListAccess(driver);
		
		Select titleSelected= new Select(titledropdown);
		System.out.println(titledropdown.getText());
		try{
			titleSelected.selectByVisibleText(TestData.newPayeeName);
	        }catch(Exception e)
	        {
	            System.out.println("Failure!!!!!!Not able to find TELUS as the added Payee !!!!!!");
	        }	
		//titleSelected.selectByVisibleText(TestData.newPayeeName);
		
	}
}
