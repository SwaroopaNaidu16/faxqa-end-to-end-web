package org.j2.faxqa.efax.corporate.myaccount.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.j2.faxqa.efax.common.TLDriverFactory;
import org.j2.faxqa.efax.corporate.myaccount.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationBarMyAccount extends CommonMethods {

	private WebDriver driver;
	private Logger logger;
	WebDriverWait wait;

	public NavigationBarMyAccount() {
		this.driver = TLDriverFactory.getTLDriver();
		this.logger = LogManager.getLogger();
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 5);
		logger.info("Initializing page - " + driver.getTitle());
	}

	static final String sendFaxesTab = "sendfaxestab";
	static final String accountDetailsTab = "updateaccttab";
	static final String viewFaxesTab = "viewfaxestab";
	static final String ReportsTab = "reportstab";
	
	@FindBy(id = sendFaxesTab)
	private WebElement sendFaxesTabWebElement;

	@FindBy(id = accountDetailsTab)
	private WebElement accountDetailsTabWebElement;

	@FindBy(id = viewFaxesTab)
	private WebElement viewFaxesTabWebElement;

	@FindBy(id = ReportsTab)
	private WebElement ReportsTabWebElement;

	public WebElement getReportsTab() {
		return ReportsTabWebElement;
	}

	public WebElement getSendFaxesTab() {
		return sendFaxesTabWebElement;
	}

	public WebElement getAccountDetailsTab() {
		return accountDetailsTabWebElement;
	}

	public WebElement getViewFaxesTab() {
		return viewFaxesTabWebElement;
	}

	public void clickSendFaxesTab() {
		getSendFaxesTab().click();
	}

	public void clickAccountDetailsTab() {
		getAccountDetailsTab().click();
	}

	public void clickViewFaxesTab() {
		getViewFaxesTab().click();
	}

	public void clickReportsTab() {
		getReportsTab().click();
	}

}