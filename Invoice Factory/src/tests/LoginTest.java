package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends Browser {
	
	LoginPage login;
	
	final String correctEmail = "jelena742@live.com";
	final String correctPass = "qwe123";
	final String incorrectEmail = "jelena742742@live.com";
	final String invalidEmail = "jelena742live.com";
	final String incorrectPass = "xxxxxx";
	final String nullField = "";
	final String shortPass = "qwe";
	final String longPass = "123456789012345678901";
	final String capsLockEmail = "JELENA742@LIVE.COM";
	final String capsLockPass = "QWE123";

	@Test (priority=0)
	public void correctEmailCapsLockPass() {
		login = new LoginPage(driver);
		driver.get("http://app.invoice-factory.source-code.rs/login");
		login.enterEmailAndPassword(correctEmail, capsLockPass);
		login.ClickOnLogin();
		assertTrue(login.invalidCred());
	}
	@Test(priority=1)
	public void correctEmailEmptyPass() {
			login = new LoginPage(driver);
			driver.get("http://app.invoice-factory.source-code.rs/login");
			login.enterEmailAndPassword(correctEmail, nullField);
			login.ClickOnLogin();
			assertTrue(login.nullPass());		
	}
	@Test(priority=2)
    public void emptyEmailEmptyPass() {
		login = new LoginPage(driver);
		driver.get("http://app.invoice-factory.source-code.rs/login");
		login.enterEmailAndPassword(nullField, nullField);
		login.ClickOnLogin();
		assertTrue(login.nullFields());
	}
	
	@Test(priority=3)
	public void emptyEmailCorrectPass() {
		login = new LoginPage(driver);
		driver.get("http://app.invoice-factory.source-code.rs/login");
		login.enterEmailAndPassword(nullField, correctPass);
		login.ClickOnLogin();
		assertTrue(login.nullEmail());		
	}
	@Test(priority=4)
	public void invalidEmailEmptyPass() {
		login = new LoginPage(driver);
		driver.get("http://app.invoice-factory.source-code.rs/login");
		login.enterEmailAndPassword(invalidEmail, nullField);
		login.ClickOnLogin();
		assertTrue(login.invalidEmail());
	}
	@Test(priority=5)
	public void correctEmailIncorrectPass() {
		login = new LoginPage(driver);
		driver.get("http://app.invoice-factory.source-code.rs/login");
		login.enterEmailAndPassword(correctEmail, incorrectPass);
		login.ClickOnLogin();
		assertTrue(login.invalidCred());
	}
	@Test(priority=6)
	public void emptyEmailShortPass() {
		login = new LoginPage(driver);
		driver.get("http://app.invoice-factory.source-code.rs/login");
		login.enterEmailAndPassword(nullField, shortPass);
		login.ClickOnLogin();
		assertTrue(login.shortPass());
	}
	@Test(priority=7)
	public void emptyEmailLongPass() {
		login = new LoginPage(driver);
		driver.get("http://app.invoice-factory.source-code.rs/login");
		login.enterEmailAndPassword(nullField, longPass);
		login.ClickOnLogin();
		assertTrue(login.longPass());
	}
	@Test(priority=8)
	public void invalidEmailcorrectPass() {
		login = new LoginPage(driver);
		driver.get("http://app.invoice-factory.source-code.rs/login");
		login.enterEmailAndPassword(invalidEmail, correctPass);
		login.ClickOnLogin();
		assertTrue(login.invalidEmail());
	}
	@Test(priority=9)
	public void invalidEmailShortPass() {
		login = new LoginPage(driver);
		driver.get("http://app.invoice-factory.source-code.rs/login");
		login.enterEmailAndPassword(invalidEmail, shortPass);
		login.ClickOnLogin();
		assertTrue(login.invalidEmail() || login.shortPass());
	}
	@Test(priority=10)
	public void invalidEmailLongPass() {
		login = new LoginPage(driver);
		driver.get("http://app.invoice-factory.source-code.rs/login");
		login.enterEmailAndPassword(invalidEmail, longPass);
		login.ClickOnLogin();
		assertTrue(login.invalidEmail() || login.longPass());
	}
	@Test (priority=11)
	public void capsLockEmailCorrectPass() {
		login = new LoginPage(driver);
		driver.get("http://app.invoice-factory.source-code.rs/login");
		login.enterEmailAndPassword(capsLockEmail, correctPass);
		login.ClickOnLogin();
		assertTrue(login.correctLogin());
	}

//	@Test (priority=12)
//	public void correctLogin() {
//		login = new LoginPage(driver);
//		driver.get("http://app.invoice-factory.source-code.rs/login");
//		login.enterEmailAndPassword(correctEmail, correctPass);
//		login.ClickOnLogin();
//		assertTrue(login.correctLogin());
//}
	}

   
   
