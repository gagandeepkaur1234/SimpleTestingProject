package com.testScript;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.pages.HomePage;
import com.pages.SignUpPage;
import com.testData.TestData;
import com.util.DriversUtilities;

public class BankLoginAndFunctionality {
	DriversUtilities driverUtilities;
	WebDriver driver;
	@Before
	public void init(){
		driverUtilities =DriversUtilities.getInstance();
		driver=driverUtilities.getDriver();
		
		driver.get(TestData.homePage);
		
		delay();
	}
	
	@Test
	public void checkVariousLinksOpenLoginPageAndDoLogin() {
		
		System.out.println("Checking text data inside OnlineBanking title");
		String expectedText= TestData.OnlineBankingText;
		String actualText = HomePage.getOnlineBankingTextElement(driver).getText();
		assertEquals(expectedText,actualText);
		delay();
		
		System.out.println("Chectext under Checking account activity");
		
		expectedText=TestData.CheckingAccountActivityText;
		actualText=HomePage.getCheckingAccountActivityElement(driver).getText();
		assertEquals(expectedText, actualText);
		
		System.out.println("Checking text under TransferFundsText");
		expectedText= TestData.TransferFundsText;
		actualText= HomePage.getTransferFundsElement(driver).getText();
		assertEquals(expectedText, actualText);
		
		HomePage.getMoreServicesLink(driver).click();
		delay();
		driver.navigate().back();
		
		delay();
		HomePage.getOnlineBankingLink(driver).click();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		delay();
		driver.navigate().back();
		
		HomePage.getFeedBackLink(driver).click();
		delay();
		
		HomePage.getSignupLink(driver).click();
		SignUpPage.getUserNameField(driver).sendKeys(TestData.userName);
		delay();
		SignUpPage.getPasswordField(driver).sendKeys(TestData.password);
		
		SignUpPage.getSignInLink(driver).click();
	}
	
	
	
	public void delay() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
