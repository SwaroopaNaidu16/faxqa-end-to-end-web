package org.j2.faxqa.efax.corporate.admin.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.j2.faxqa.efax.common.TLDriverFactory;
import org.j2.faxqa.efax.corporate.admin.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GroupDetailsPage extends CommonMethods {

	private WebDriver driver;
	private Logger logger;
	WebDriverWait wait;

	public GroupDetailsPage() {
		this.driver = TLDriverFactory.getTLDriver();
		this.logger = LogManager.getLogger();
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 5);
		logger.info("Initializing page - " + driver.getTitle());
	}

	static final String advancedSettingsButton = "//div[contains(@class,'advanced-settings-button')]";
	static final String inputHiddenStorageEnabled = "//input[contains(@id,'SecureStorage')]";
	static final String inputHiddenEditProfile = "//input[contains(@id,'userEditProfile')]";
	
	@FindBy(xpath = advancedSettingsButton)
	private WebElement advancedSettingsButtonWebElement;

	@FindBy(xpath = inputHiddenStorageEnabled)
	private WebElement inputHiddenStorageEnabledWebElement;

	@FindBy(xpath = inputHiddenEditProfile)
	private WebElement inputHiddenEditProfileWebElement;

	public WebElement getAdvancedSettingsButton() {
		return advancedSettingsButtonWebElement;
	}

	public WebElement getInputHiddenStorageEnabled() {
		return inputHiddenStorageEnabledWebElement;
	}

	public WebElement getInputHiddenEditProfile() {
		return inputHiddenEditProfileWebElement;
	}

	public WebElement getUnassignedFaxEmailField() {
		WebElement unassignedFaxEmailFieldWebElement = null;
		String locator = "unassignedDIDEmail";
		try {
			unassignedFaxEmailFieldWebElement = driver.findElement(By.id("unassignedDIDEmail"));
		} catch (Exception e) {
			@SuppressWarnings("unused")
			WebElement element = driver.findElement(By.id("unassignedDIDEmail"));
		}

		return unassignedFaxEmailFieldWebElement;
	}

	public void clickAdvancedSettingsButton() {
		this.scrollToTheSpecificWebelement(getAdvancedSettingsButton());
		getAdvancedSettingsButton().click();
	}

	public String getAttributeValueOfStorageEnabledField(String attribute) {
		this.scrollToTheSpecificWebelement(getInputHiddenStorageEnabled());
		String attributeValue = getInputHiddenStorageEnabled().getAttribute(attribute);
		return attributeValue;
	}

	public String getAttributeValueOfEditProfileField(String attribute) {
		this.scrollToTheSpecificWebelement(getInputHiddenEditProfile());
		String attributeValue = getInputHiddenEditProfile().getAttribute(attribute);
		return attributeValue;
	}
}