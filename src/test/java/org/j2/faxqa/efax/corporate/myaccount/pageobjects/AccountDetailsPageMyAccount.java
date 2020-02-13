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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountDetailsPageMyAccount extends CommonMethods {
	private WebDriver driver;
	private Logger logger;
	WebDriverWait wait;

	public AccountDetailsPageMyAccount() {
		this.driver = TLDriverFactory.getTLDriver();
		this.logger = LogManager.getLogger();
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 5);
		logger.info("Initializing page - " + driver.getTitle());
	}

	@FindBy(id = "tabs-prefs")
	private WebElement tabprefs;

	@FindBy(id = "tabs-billing")
	private WebElement tabbilling;

	@FindBy(id = "tabs-usage")
	private WebElement tabusage;

	@FindBy(id = "tabs-profile")
	private WebElement tabprofile;

	@FindBy(xpath = "//*/div[contains(text(), 'Send Fax Options:')]/../*/a[text()='Edit']")
	private WebElement sendfaxoptionsedit;

	@FindBy(id = "txt_sendCSID")
	private WebElement sendCSID;

	@FindBy(xpath = "//form[@id='form_sendPrefs']//input[@alt='Update']")
	private WebElement update;

	@FindBy(id = "myaccthometab")
	private WebElement myaccthometab;

	@FindBy(id = "chk_deliverFaxReceipts")
	private WebElement deliverFaxReceipts;

	@FindBy(id = "sel_defaultEmailAddress")
	private WebElement defaultEmailAddress;

	public void updatesendCSID(String sender) {
		wait.until(ExpectedConditions.elementToBeClickable(sendfaxoptionsedit));
		sendfaxoptionsedit.click();
		sendCSID.clear();
		sendCSID.sendKeys(sender);
		setdeliverFaxReceipts(false);
		setdefaultEmailAddress();
		update.click();
		logger.info("CSID is set to " + sender);
		wait.until(ExpectedConditions.elementToBeClickable(myaccthometab));
		myaccthometab.click();
	}

	private void setdeliverFaxReceipts(boolean check) {
		if (check && !deliverFaxReceipts.isSelected())
			deliverFaxReceipts.click();
		else if (!check && deliverFaxReceipts.isSelected())
			deliverFaxReceipts.click();
		logger.info("Coverage option enabled.");
	}

	private void setdefaultEmailAddress() {
		Select receipt = new Select(defaultEmailAddress);
		// receipt.selectByVisibleText(text);
		receipt.selectByIndex(1);
	}
}