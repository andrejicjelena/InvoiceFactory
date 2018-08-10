package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageObject {
	
	@FindBy(id="login-form-email")
	WebElement email;
	
	@FindBy(id="login-pass")
	WebElement password;
	
	@FindBy(id="login-form-btn")
	WebElement loginBtn;
	
	@FindBy(xpath="//*[contains(text(), 'The email field is required.')]")
	WebElement errorMsgE;
	
	@FindBy(xpath="//*[contains(text(), 'The password field is required.')]")
	WebElement errorMsgP;
	
	@FindBy(xpath="//*[contains(text(), 'The email field must be a valid email.')]")
	WebElement errorMsgInvE;
	
	@FindBy(xpath="//*[contains(text(), 'Invalid credentials.')]")
	WebElement errorMsgInvC;
	
	@FindBy(xpath="//*[contains(text(), 'The password field must be at least 6 characters.')]")
    WebElement errorMsgShortPass;
	
	@FindBy(xpath="//*[contains(text(), 'The password field may not be greater than 20 characters.')]")
	WebElement errorMsgLongPass;
	
	  @FindBy(css="i[class='v-icon material-icons material-icons']")
	  WebElement user;
    
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterEmailAndPassword(String em, String pass) {
		email.clear();
		email.sendKeys(em);
		
		password.clear();
		password.sendKeys(pass);
	}
	
	public void ClickOnLogin() {
		loginBtn.click();
	}
	
	public boolean nullFields() {
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'The email field is required.')]")));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'The password field is required.')]")));
        return (errorMsgE.isDisplayed() || errorMsgP.isDisplayed());
	    }
	public boolean nullPass() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'The password field is required.')]")));
	    return errorMsgP.isDisplayed();
	}
	public boolean nullEmail() {
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'The email field is required.')]")));
	    return errorMsgE.isDisplayed();
	}
	
	public boolean invalidEmail() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'The email field must be a valid email.')]")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '')]")));
		return (errorMsgInvE.isDisplayed() || errorMsgP.isDisplayed());
	}
	public boolean invalidCred() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Invalid credentials.')]")));
	    return errorMsgInvC.isDisplayed();
	}
	public boolean shortPass() {
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'The email field is required.')]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'The password field must be at least 6 characters.')]")));
        return (errorMsgE.isDisplayed() || errorMsgShortPass.isDisplayed());
	}
	public boolean longPass() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'The email field is required.')]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'The password field may not be greater than 20 characters.')]")));
        return (errorMsgE.isDisplayed() || errorMsgLongPass.isDisplayed());
	}
	public boolean correctLogin() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("i[class='v-icon material-icons material-icons']")));
	    return user.isDisplayed();
	        
	}
	
	}
		