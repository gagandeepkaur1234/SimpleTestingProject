package com.testScript;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.pages.TransferFundsPage;
import com.testData.TestData;
import com.util.DriversUtilities;


public class TransferFundsTest {
	DriversUtilities driverUtilities;
	WebDriver driver;
	@Before
	public void init(){
		driverUtilities =DriversUtilities.getInstance();
		driver=driverUtilities.getDriver();
	}
	
	@Test
	public void testFundsTransferfromSavingstoSavings(){
		
		TransferFundsPage.getTransferFundsAccess(driver).click();
		
		
		System.out.println("Transferring funds ");
		WebElement welement=TransferFundsPage.getFromAccount(driver);
		Select titleSelected= new Select(welement);
		titleSelected.selectByVisibleText(TestData.fromAccount);
		
		
		welement=TransferFundsPage.getToAccount(driver);
		titleSelected=new Select(welement);
		titleSelected.selectByVisibleText(TestData.toAccount);
		
		
		
		TransferFundsPage.getAmountAccesst(driver).sendKeys(TestData.amountToTransfer);
		TransferFundsPage.getDescriptionAccess(driver).sendKeys(TestData.descriptiontotransfer);
		delay();
		TransferFundsPage.getContinueAccess(driver).click();
		//delay();
		TransferFundsPage.getSubmitAccess(driver).click();
		
		
		System.out.println("Checking for the confirmation message of funds transfer");
		
		String actualText=TransferFundsPage.getConfirmMessageAfterSubmitAccess(driver).getText();
		String expectedText= TestData.confirmFundsTransferMessage;
		assertEquals(expectedText, actualText);
		
		System.out.println("Checking whether funds havebeen transferred or not");
		
		TransferFundsPage.getAccountSummaryAccess(driver).click();
		
		
		
		
	}

	private void delay() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
