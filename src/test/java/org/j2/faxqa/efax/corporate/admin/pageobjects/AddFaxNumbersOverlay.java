package org.j2.faxqa.efax.corporate.admin.pageobjects;

import java.util.List;
import java.util.stream.Collectors;

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

import com.github.javafaker.Faker;

public class AddFaxNumbersOverlay extends CommonMethods {

	private WebDriver driver;
	private Logger logger;
	WebDriverWait wait;

	public AddFaxNumbersOverlay() {
		this.driver = TLDriverFactory.getTLDriver();
		this.logger = LogManager.getLogger();
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 15);
		logger.info("URL - " + driver.getCurrentUrl());
		logger.info(driver.getTitle() + " - [" + driver.getCurrentUrl() + "]");
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

	public void enterFaxCount(int count) throws Exception {
		
		getQuantityOfFaxNumbersToAddTextbox().click();
		getQuantityOfFaxNumbersToAddTextbox().clear();
		getQuantityOfFaxNumbersToAddTextbox().sendKeys(Integer.toString(count));
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

	public void selectAStateFromDropdown() throws Exception {
		clickStateDropdown();
		List<String> states = driver.findElements(By.xpath("//select[@id='addNumbersRegion']/option")).stream().map(e->e.getAttribute("innerText")).collect(Collectors.toList());
		String state = states.get((new Faker()).number().numberBetween(1,states.size()));
		String locator = ".//ul[contains(@id,'addNumbersRegion')]/li[text()='" + state + "']";
		driver.findElement(By.xpath(locator)).click();
	}

	public void chooseACityFromDropdown() throws Exception {
		clickCityDropdown();
		List<String> cities = driver.findElements(By.xpath("//select[@id='addNumbersCity']/option")).stream().map(e->e.getAttribute("innerText")).collect(Collectors.toList());
		String city = cities.get((new Faker()).number().numberBetween(1,cities.size()));
		String locator = "//li[contains(text(),'" + city + "')]";
		driver.findElement(By.xpath(locator)).click();
	}

	public void searchByState(int faxCount) throws Exception {
		
		clickStateRadioButton();
		selectAStateFromDropdown();
		chooseACityFromDropdown();
		clickNextButton();	
		enterFaxCount(faxCount);
		clickAddFaxNumbersButton();
	}

	public void searchByZipCode(String zipcode, int faxCount) throws Exception {
		
		clickZipCodeRadioButton();
		enterZipCode(zipcode);
		clickSearchButton();
		chooseACityFromDropdown();
		clickNextButton();
		
		enterFaxCount(faxCount);
		clickAddFaxNumbersButton();
	}

	public void searchByTollFree(int faxCount) throws Exception {
		
		clickTollFreeRadioButton();
		chooseACityFromDropdown();
		clickNextButton();
		
		enterFaxCount(faxCount);
		clickAddFaxNumbersButton();
	}

	public void searchByAreaCode(String areacode, int faxCount) throws Exception {
		
		clickAreaCodeRadioButton();
		enterAreaCode(areacode);
		clickSearchAreaCodeButton();
		chooseACityFromDropdown();
		clickNextButton();
		
		enterFaxCount(faxCount);
		clickAddFaxNumbersButton();
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