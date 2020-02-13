package org.j2.faxqa.efax.corporate.admin.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.j2.faxqa.efax.common.Config;
import org.j2.faxqa.efax.common.TLDriverFactory;
import org.j2.faxqa.efax.corporate.admin.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddFaxNumbersOverlay extends CommonMethods {

	private WebDriver driver;
	private Logger logger;
	WebDriverWait wait;

	public AddFaxNumbersOverlay() {
		this.driver = TLDriverFactory.getTLDriver();
		this.logger = LogManager.getLogger();
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 5);
		logger.info("Initializing page - " + driver.getTitle());
	}

	static final String stateRadioButton = ".//div[@id='numbersGrid']//div[contains(@style,'block')]//input[@value='R']";
	static final String zipCodeRadioButton = ".//div[@id='numbersGrid']//div[contains(@style,'block')]//input[@value='P']";
	static final String tollFreeRadioButton = ".//div[@id='numbersGrid']//div[contains(@style,'block')]//input[@value='T']";
	static final String areaCodeRadioButton = ".//div[@id='numbersGrid']//div[contains(@style,'block')]//input[@value='A']";
	static final String selectAStateDropdown = ".//span[@id='addNumbersRegion-button']/span[1]";
	static final String selectACityDropdown = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[8]/div[1]/div[1]/div[1]/span[1]/span[1]";
	static final String nextButton = "next-button";
	static final String quantityOfFaxNumbersToAddTextbox = "didQuantity";
	static final String addFaxNumbersButton = "//button[@id='back-button']/preceding-sibling::button";
	static final String zipCodeTextBox = ".//input[@name='zipCode']";
	static final String searchButton = ".//input[@name='zipCode']/following-sibling::button";
	static final String areaCodeTextBox = ".//input[@name='areaCode']";
	static final String searchAreaCodeButton = ".//input[@name='areaCode']/following-sibling::button";
	static final String validationMessage = ".//div[@id='groupsGrid']//p";
	static final String closeIcon = ".//div[@class='icon_Exit']";
	static final String invalidInputCodeAddNumbersErrorMessage = "//div[@id='addNumbers']//div[contains(@class,'errorMessage ')]/div";
	static final String chooseCountryDropdown = ".//span[@id='addNumbersCountry-button']/span[1]";
	static final String maxFaxNumbersCountInAddFaxNumbersPopup = ".//span[@id='quantity']";
	static final String quantityErrorValidationMessage = ".//span[@id='quantityError']";
	
	@FindBy(xpath = stateRadioButton)
	private WebElement stateRadioButtonWebElement;

	@FindBy(xpath = zipCodeRadioButton)
	private WebElement zipCodeRadioButtonWebElement;

	@FindBy(xpath = tollFreeRadioButton)
	private WebElement tollFreeRadioButtonWebElement;

	@FindBy(xpath = areaCodeRadioButton)
	private WebElement areaCodeRadioButtonWebElement;

	@FindBy(xpath = selectAStateDropdown)
	private WebElement selectAStateDropdownWebElement;

	@FindBy(xpath = selectACityDropdown)
	private WebElement selectACityDropdownWebElement;

	@FindBy(id = nextButton)
	private WebElement nextButtonWebElement;

	@FindBy(id = quantityOfFaxNumbersToAddTextbox)
	private WebElement quantityOfFaxNumbersToAddTextboxWebElement;

	@FindBy(xpath = addFaxNumbersButton)
	private WebElement addFaxNumbersButtonWebElement;

	@FindBy(xpath = zipCodeTextBox)
	private WebElement zipCodeTextBoxWebElement;

	@FindBy(xpath = searchButton)
	private WebElement searchButtonWebElement;

	@FindBy(xpath = areaCodeTextBox)
	private WebElement areaCodeTextBoxWebElement;

	@FindBy(xpath = searchAreaCodeButton)
	private WebElement searchAreaCodeButtonWebElement;

	@FindBy(xpath = validationMessage)
	private WebElement validationMessageWebElement;

	@FindBy(xpath = closeIcon)
	private WebElement closeIconWebElement;

	@FindBy(xpath = invalidInputCodeAddNumbersErrorMessage)
	private WebElement invalidInputCodeAddNumbersErrorMessageWebElement;

	@FindBy(xpath = chooseCountryDropdown)
	private WebElement chooseCountryDropdownWebElement;

	@FindBy(xpath = maxFaxNumbersCountInAddFaxNumbersPopup)
	private WebElement maxFaxNumbersCountInAddFaxNumbersPopupWebElement;

	@FindBy(xpath = quantityErrorValidationMessage)
	private WebElement quantityErrorValidationMessageWebElement;

	public WebElement getStateRadioButton() {
		return stateRadioButtonWebElement;
	}

	public WebElement getZipCodeRadioButton() {
		return zipCodeRadioButtonWebElement;
	}

	public WebElement getTollFreeRadioButton() {
		return tollFreeRadioButtonWebElement;
	}

	public WebElement getAreaCodeRadioButton() {
		return areaCodeRadioButtonWebElement;
	}

	public WebElement getSelectAStateDropdown() {
		return selectAStateDropdownWebElement;
	}

	public WebElement getSelectACityDropdown() {
		return selectACityDropdownWebElement;
	}

	public WebElement getNextButton() {
		return nextButtonWebElement;
	}

	public WebElement getQuantityOfFaxNumbersToAddTextbox() {
		return quantityOfFaxNumbersToAddTextboxWebElement;
	}

	public WebElement getAddFaxNumbersButton() {
		return addFaxNumbersButtonWebElement;
	}

	public WebElement getZipCodeTextBox() {
		return zipCodeTextBoxWebElement;
	}

	public WebElement getSearchButton() {
		return searchButtonWebElement;
	}

	public WebElement getAreaCodeTextBox() {
		return areaCodeTextBoxWebElement;
	}

	public WebElement getSearchAreaCodeButton() {
		return searchAreaCodeButtonWebElement;
	}

	public WebElement getValidationMessage() {
		return validationMessageWebElement;
	}

	public WebElement getCloseIcon() {
		return closeIconWebElement;
	}

	public WebElement getInvalidInputCodeAddNumbersErrorMessage() {
		return invalidInputCodeAddNumbersErrorMessageWebElement;
	}

	public WebElement getChooseCountryDropdown() {
		return chooseCountryDropdownWebElement;
	}

	public WebElement getMaxFaxNumbersCountInAddFaxNumbersPopup() {
		return maxFaxNumbersCountInAddFaxNumbersPopupWebElement;
	}

	public WebElement getQuantityErrorValidationMessage() {
		return quantityErrorValidationMessageWebElement;
	}

	public void clickStateDropdown() throws Exception {
		
		selectAStateDropdownWebElement.click();
	}

	public void clickCityDropdown() throws Exception {
		
		getSelectACityDropdown().click();
	}

	public void clickStateRadioButton() throws Exception {
		
		getStateRadioButton().click();
	}

	public void clickZipCodeRadioButton() throws Exception {
		
		getZipCodeRadioButton().click();
	}

	public void clickTollFreeRadioButton() throws Exception {
		
		getTollFreeRadioButton().click();
	}

	public void clickAreaCodeRadioButton() throws Exception {
		
		getAreaCodeRadioButton().click();
	}

	public void clickNextButton() throws Exception {
		
		getNextButton().click();
	}

	public void enterFaxCount(String count) throws Exception {
		
		getQuantityOfFaxNumbersToAddTextbox().click();
		getQuantityOfFaxNumbersToAddTextbox().clear();
		getQuantityOfFaxNumbersToAddTextbox().sendKeys(count);
	}

	public void clickAddFaxNumbersButton() throws Exception {
		
		getAddFaxNumbersButton().click();
	}

	public void clickCloseIcon() {
		getCloseIcon().click();
	}

	public String getValidationMessageText() {
		String message = getValidationMessage().getText();
		return message;
	}

	public void enterZipCode(String code) throws Exception {
		
		getZipCodeTextBox().click();
		getZipCodeTextBox().clear();
		getZipCodeTextBox().sendKeys(code);
	}

	public void clickSearchButton() throws Exception {
		
		getSearchButton().click();
	}

	public void clickSearchAreaCodeButton() throws Exception {
		
		getSearchAreaCodeButton().click();
	}

	public void enterAreaCode(String code) throws Exception {
		
		getAreaCodeTextBox().click();
		getAreaCodeTextBox().clear();
		getAreaCodeTextBox().sendKeys(code);
	}

	public void selectAStateFromDropdown(String stateName) throws Exception {
		clickStateDropdown();
		this.pause(2000);
		String locator = ".//ul[contains(@id,'addNumbersRegion')]/li[text()='" + stateName + "']";
		try {
			WebElement element = driver.findElement(By.xpath(locator));
			this.clickAction(element);
		} catch (Exception e) {
			@SuppressWarnings("unused")
			WebElement element = driver.findElement(By.xpath(locator));
		}
	}

	public void chooseACityFromDropdown(String city) throws Exception {
		clickCityDropdown();
		this.pause(2000);
		String locator = "//li[contains(text(),'" + city + "')]";
		try {
			WebElement element = driver.findElement(By.xpath(locator));
			this.clickAction(element);
		} catch (Exception e) {
			@SuppressWarnings("unused")
			WebElement element = driver.findElement(By.xpath(locator));
		}
	}

	public void searchByState(String stateName, String faxCount) throws Exception {
		
		clickStateRadioButton();
		selectAStateFromDropdown(stateName);
		chooseACityFromDropdown(Config.selectCityForSearchByState);
		clickNextButton();
		this.pause(2000);
		
		enterFaxCount(faxCount);
		clickAddFaxNumbersButton();
		this.pause(8000);
	}

	public void searchByZipCode(String zipcode, String faxCount) throws Exception {
		
		clickZipCodeRadioButton();
		enterZipCode(zipcode);
		clickSearchButton();
		this.pause(8000);
		chooseACityFromDropdown(Config.selectCityForSearchByZipCode);
		clickNextButton();
		this.pause(2000);
		
		enterFaxCount(faxCount);
		clickAddFaxNumbersButton();
		this.pause(8000);
	}

	public void searchByTollFree(String faxCount) throws Exception {
		
		clickTollFreeRadioButton();
		this.pause(2000);
		chooseACityFromDropdown(Config.selectCityForSearchByTollFree);
		clickNextButton();
		this.pause(2000);
		
		enterFaxCount(faxCount);
		clickAddFaxNumbersButton();
		this.pause(8000);
	}

	public void searchByAreaCode(String areacode, String faxCount) throws Exception {
		
		clickAreaCodeRadioButton();
		enterAreaCode(areacode);
		clickSearchAreaCodeButton();
		this.pause(120000);
		chooseACityFromDropdown(Config.selectCityForSearchByAreaCode);
		clickNextButton();
		this.pause(2000);
		
		enterFaxCount(faxCount);
		clickAddFaxNumbersButton();
		this.pause(8000);
	}

	public String getErrorMessageInvalidInputCode() {
		String text = getInvalidInputCodeAddNumbersErrorMessage().getText();
		return text;
	}

	public String getFaxNumbersCount() {
		String faxCount = getMaxFaxNumbersCountInAddFaxNumbersPopup().getText();
		int count = Integer.parseInt(faxCount) + 1;
		String maxFaxCount = String.valueOf(count);
		return maxFaxCount;
	}

	public String getQuantityErrorMessage() {
		String text = getQuantityErrorValidationMessage().getText();
		return text;
	}
}