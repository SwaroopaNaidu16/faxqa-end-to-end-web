package org.j2.faxqa.efax.corporate.myaccount.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.j2.faxqa.efax.common.Config;
import org.j2.faxqa.efax.common.TLDriverFactory;
import org.j2.faxqa.efax.corporate.myaccount.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageMyAccount extends CommonMethods {

	private WebDriver driver;
	private Logger logger;
	WebDriverWait wait;

	public LoginPageMyAccount() {
		this.driver = TLDriverFactory.getTLDriver();
		this.logger = LogManager.getLogger();
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 15);
		logger.info("Initializing page - " + driver.getTitle());
	}

	static final String faxNumberField = "phoneNumber";
	static final String passwordField = "pin";
	static final String loginButton = "userLoginButton";
	static final String forgotPasswordLink = "forgotPassword";
	static final String errorMessage = "//div[@class='loginError']";
	static final String rememberMeCheckbox = "rememberUsernameAndPasswordChk";
	
	@FindBy(id = faxNumberField)
	private WebElement faxNumberFieldWebElement;

	@FindBy(id = passwordField)
	private WebElement passwordFieldWebElement;

	@FindBy(id = loginButton)
	private WebElement loginButtonWebElement;

	@FindBy(name = forgotPasswordLink)
	private WebElement forgotPasswordLinkWebElement;

	@FindBy(xpath = errorMessage)
	private WebElement errorMessageWebElement;

	@FindBy(id = rememberMeCheckbox)
	private WebElement rememberMeCheckboxWebElement;

	public WebElement getFaxNumberField() {
		return faxNumberFieldWebElement;
	}

	public WebElement getPasswordField() {
		return passwordFieldWebElement;
	}

	public WebElement getLoginButton() {
		return loginButtonWebElement;
	}

	public WebElement getForgotPasswordLink() {
		return forgotPasswordLinkWebElement;
	}

	public WebElement getErrorMessage() {
		return errorMessageWebElement;
	}

	public WebElement getRememberMeCheckbox() {
		return rememberMeCheckboxWebElement;
	}

	public String errorMessage() {
		String errorMessage = getErrorMessage().getText();
		return errorMessage;
	}

	public void enterFaxNumber(String AccountNumber) {
		getFaxNumberField().clear();
		getFaxNumberField().sendKeys(AccountNumber);
	}

	public void enterPassword(String password) {
		getPasswordField().clear();
		getPasswordField().sendKeys(password);
	}

	public void clickLoginButton() {
		this.closeGDPRbanner();
		getLoginButton().click();
	}

	public void login(String AccountNumber, String password) {
		this.enterFaxNumber(AccountNumber);
		this.enterPassword(password);
		this.clickLoginButton();
	}

	public void clickForgotPasswordLink() {
		this.closeGDPRbanner();
		getForgotPasswordLink().click();
	}
}