package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends PageObject{
	
	@FindBy(id="login-form-email")
	WebElement email;
	
	@FindBy(id="login-pass")
	WebElement password;
	
	@FindBy(id="login-form-btn")
	WebElement loginBtn;
	
	 @FindBy(css="i[class='v-icon material-icons material-icons']")
	  WebElement user;
	
	@FindBy(css="label[for='filter-client']")
	WebElement selectClient;
	
	@FindBy(xpath="//*[contains(text(), 'All clients')]")
	WebElement clientList;
	
	@FindBy (xpath="//div[contains(text(),'Around the Horn')]")
    WebElement clientAroundTheHorn;
	
	@FindBy (id ="inv-client-2018-DD1")
	WebElement nameAroundTheHorn;

	@FindBy(id="add-new-invoice")
	WebElement addNewInvoiceBtn;
	
	@FindBy(xpath="//*[@id=\"inv-form-status\"]")
	WebElement draftDropDown;

	@FindBy(id="click-to-enter")
	WebElement enterTitle;

	@FindBy(id="invoice-title-content")
	WebElement titleInvoiceInput;

	

	public HomePage(WebDriver driver) {
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
	
	public boolean correctLogin() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("i[class='v-icon material-icons material-icons']")));
	    return user.isDisplayed();
	        
	}
	
	public void clickOnSelectClient() {
		selectClient.click();
	}
	
	public boolean isSelectClient() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'All clients')]")));
		return clientList.isDisplayed();
	}
	
	public void clickOnAddNewInvoice() {
		addNewInvoiceBtn.click();
	}
	
	public void clickOnDraft() {
		draftDropDown.click();
	}
    
	public void clickOnAroundTheHorn() {
		clientAroundTheHorn.click();
	}
	public boolean isAtAroundTheHorn() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inv-client-2018-DD1")));
		return nameAroundTheHorn.isDisplayed();
	}
	public void clickOnTitle() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("click-to-enter")));
		
	}
	
	public void enterTitle() {
		titleInvoiceInput.sendKeys("Naslov");
}

}