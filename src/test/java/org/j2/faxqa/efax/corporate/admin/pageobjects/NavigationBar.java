package org.j2.faxqa.efax.corporate.admin.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.j2.faxqa.efax.common.TLDriverFactory;
import org.j2.faxqa.efax.corporate.admin.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationBar extends CommonMethods {

	private WebDriver driver;
	private Logger logger;
	WebDriverWait wait;

	public NavigationBar() {
		this.driver = TLDriverFactory.getTLDriver();
		this.logger = LogManager.getLogger();
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 5);
		logger.info("Initializing page - " + driver.getTitle());
	}

	static final String settingsTab = "//*[@id='top-nav-btn-settings']/a/span[1]";
	static final String usersTab = "//*[@id='top-nav-btn-users']/a/span[1]";
	static final String groupsTab = "#manageGroups > span.text";
	static final String faxNumbersTab = "//a[@class='numbers']";
	static final String usageTab = "//a[@id='usage']";
	static final String homePageTab = "//ul[@class='top-level']//a[@href='/mgmt/dashboard']";

	static final String myAccount = "//a[@class='icon_MyAccount']";
	static final String currentLanguage = "//a[@class='icon_World']";
	static final String help = "//a[@class='icon_HelpCircled']";
	static final String logoutButton = "//div[@class='topLinksBtnText' and text()='Logout']";

	@FindBy(xpath = settingsTab)
	private WebElement settingsTabWebElement;

	@FindBy(xpath = usersTab)
	private WebElement usersTabWebElement;

	@FindBy(css = groupsTab)
	private WebElement groupsTabWebElement;

	@FindBy(xpath = faxNumbersTab)
	private WebElement faxNumbersTabWebElement;

	@FindBy(xpath = usageTab)
	private WebElement usageTabWebElement;

	@FindBy(xpath = homePageTab)
	private WebElement homePageTabWebElement;

	@FindBy(xpath = myAccount)
	private WebElement myAccountWebElement;

	@FindBy(css = currentLanguage)
	private WebElement currentLanguageWebElement;

	@FindBy(xpath = help)
	private WebElement helpWebElement;

	@FindBy(xpath = logoutButton)
	private WebElement logoutButtonWebElement;

	public void clickUsersTab() {
		
		usersTabWebElement.click();
	}

	public void clickSettingsTab() {
		
		settingsTabWebElement.click();
	}

	public void clickGroupsTab() {
		
		groupsTabWebElement.click();
	}

	public void clickFaxNumbersTab() {
		
		faxNumbersTabWebElement.click();
	}

	public void clickUsageTab() {
		
		usageTabWebElement.click();
	}

	public void clickHomeTab() {
		
		homePageTabWebElement.click();
	}

	public boolean isUserLoggedIn() {
		wait.until(ExpectedConditions.elementToBeClickable(logoutButtonWebElement));
		return logoutButtonWebElement.getText().contains("Logout");
	}

	public void logout() {
		
		logoutButtonWebElement.click();
	}
}