package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

import pages.HomePage;

public class HomePageTest extends Browser {
	
	HomePage home;

	final String correctEmail = "jelena742@live.com";
	final String correctPass = "qwe123";
	
	@Test (priority=0)
	public void correctLogin() throws InterruptedException {
		home = new HomePage(driver);
		driver.get("http://app.invoice-factory.source-code.rs/login");
		home.enterEmailAndPassword(correctEmail, correctPass);
		home.ClickOnLogin();
		assertTrue(home.correctLogin());
		Thread.sleep(2000);
}
	@Test(priority=1)
	public void selectClient() {
		
	home = new HomePage(driver);
	driver.get("http://app.invoice-factory.source-code.rs/invoices");
	home.clickOnSelectClient();
	assertTrue(home.isSelectClient());
	home.clickOnAroundTheHorn();
	assertTrue(home.isAtAroundTheHorn());
		
	}
	
	@Test(priority=2)
	public void addNewInvoice() throws InterruptedException {
		home = new HomePage(driver);
		driver.get("http://app.invoice-factory.source-code.rs/invoices");
		home.clickOnAddNewInvoice();
		Thread.sleep(2000);
		
		
	}
	@Test(priority=3)
	public void clickAndEnterTit() {
		home = new HomePage(driver);
		driver.get("http://app.invoice-factory.source-code.rs/invoices/form");
		home.enterTitle();

		
	}
	
}
