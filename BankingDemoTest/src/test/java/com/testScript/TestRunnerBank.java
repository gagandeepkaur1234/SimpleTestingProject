package com.testScript;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	BankLoginAndFunctionality.class,
	TransferFundsTest.class,
	AccountSummaryTest.class,
	AddPayeeTest.class,
	SettingsTest.class
}		
)
public class TestRunnerBank {
	
}

