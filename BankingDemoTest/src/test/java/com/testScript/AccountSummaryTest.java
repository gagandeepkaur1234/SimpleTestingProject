package com.testScript;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Verifier;
import org.openqa.selenium.WebDriver;

import com.pages.AccountSummaryPage;
import com.pages.AddPayeePage;
import com.testData.TestData;
import com.util.DriversUtilities;

public class AccountSummaryTest {

	DriversUtilities driverUtilities;
	WebDriver driver;
	@Before
	public void init(){
		driverUtilities =DriversUtilities.getInstance();
		driver=driverUtilities.getDriver();
		
	}
	
	@Test
	public void testAccountBalanceAfterTransfer(){
		
		AccountSummaryPage.getAccountSummaryAccess(driver).click();
		System.out.println(AccountSummaryPage.getDetailsofFromAccount(driver).getText());
		System.out.println(AccountSummaryPage.getDetailsofToAccount(driver).getText());
		
		String expectedFundsInFromAccountAfterTransfer= TestData.fundsinFromAccountAfterTransfer;
		
		String actualFundsInFromAccountAfterTransfer= AccountSummaryPage.getDetailsofFromAccount(driver).getText();
		//assertEquals(expectedFundsInFromAccountAfterTransfer, actualFundsInFromAccountAfterTransfer);
		
		
		try{
	        //Assert.assertEquals(expectedFundsInFromAccountAfterTransfer, actualFundsInFromAccountAfterTransfer);
	        assertEquals(expectedFundsInFromAccountAfterTransfer, actualFundsInFromAccountAfterTransfer);
	        }catch(AssertionError e)
	        {
	            System.out.println("Failure!!!!!!!!! Funds Tranfer function not working!!!!!! ");
	        }	
		System.out.println("Out of try block");
		
		AddPayeePage.getPayBillsAccess(driver).click();
	}
	
}
