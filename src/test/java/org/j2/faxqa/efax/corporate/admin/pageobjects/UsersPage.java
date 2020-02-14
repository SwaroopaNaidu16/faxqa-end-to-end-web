package org.j2.faxqa.efax.corporate.admin.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.j2.faxqa.efax.common.TLDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsersPage extends NavigationBar {

	private WebDriver driver;
	private Logger logger;
	WebDriverWait wait;

	public UsersPage() {
		this.driver = TLDriverFactory.getTLDriver();
		this.logger = LogManager.getLogger();
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 15);
		logger.info("URL - " + driver.getCurrentUrl());
		logger.info("Initializing page - " + driver.getTitle());
	}

	static final String usersTab = "//a[@class='users']";
	static final String pageActionsMenu = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/span[1]/span[2]";
	static final String addUsersOption = "/html[1]/body[1]/div[8]/ul[1]/li[2]";
	static final String moveUsersOption = "/html[1]/body[1]/div[8]/ul[1]/li[3]";
	static final String clickUserFirstName = "(//label[@class='cursorPointer']/span)[1]";
	static final String search = "//div[@class='users-search-menu']";
	static final String searchValue = "viewAccountsSearchField";
	static final String searchButton = "search-menu-submit-btn";
	static final String resendWelcomeEmailOption = ".//span[contains(@class,'icon_resendEmail')]/parent::li";
	static final String resendButton = ".//button[contains(@onclick,'resend')]";
	static final String closeButton = ".//div[contains(@id,'success-resend')]/following-sibling::div/button[contains(@class,'accept')]";
	static final String clickUserCheckbox = ".//td[@class='check']//input[@id='childrenStr']";
	static final String importUserListOption = ".//span[contains(@class,'import-icon')]/parent::li";
	static final String deleteUserOption = ".//span[contains(@class,'delete-user-icon')]/parent::li";
	static final String successRemoveValidationMessage = "successStatusBox";
	static final String noUsersSelectedPopUpForMoveUsers = "//div[@id='modal-no-move-users-body']";
	static final String closeButtonNoUsersSelectedPopUpForMoveUsers = "//div[@id='no-move-modal']//button[@class='btn btn-primary modal-accept-btn'][contains(text(),'Close')]";
	static final String moveButton = "//div[@id='move-modal']//div[@class='modal-footer-container']/button[contains(@class,'modal-accept-btn')]";
	static final String successfullyMovedUsersPopUp = "//div[@id='modal-success-move-users-body']";
	static final String selectGroup = "//div[@id='modal-move-users-body']//div[contains(@class,'tree-view-tray modal-move-users-group-tray')]//a[@class='jstree-anchor']";
	static final String noUsersSelectedPopUpForResendWelcomeEmail = "//div[@id='no-resend-modal']//div[@id='modal-no-resend-body']";
	static final String closeButtonNoUsersSelectedPopUpForResendWelcomeEmail = "//div[@id='no-resend-modal']//div[@class='modal-footer-container']//button[contains(text(),'Close')]";
	static final String successfullySentWelcomeEmails = "/html[1]/body[1]/div[1]/div[2]/div[10]/div[2]/div[1]/div[2]";
	static final String exportUserListOption = ".//span[contains(@class,'export-icon')]/parent::li";
	static final String validationMessageNoUsersSeleted = ".//div[@id='no-delete-modal']//div[@class='modal-body']";
	static final String closeButtonNoUsersSelectedPopup = "mismatchedEmailDomainsModalCloseBtn";
	static final String usersPaitle = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/h1[1]/span[2]";
	static final String exportUserListIcon = ".//span[contains(@class,'export-icon')]/parent::li";
	static final String SearchWithDropdown = ".//span[@id='searchField-button']/span[1]";
	static final String faxNumberOption = "//li[contains(.,'Fax number')]";
	static final String deleteUserIcon = ".//span[contains(@class,'delete-user-icon')]/parent::li";
	
	@FindBy(xpath = usersTab)
	private WebElement usersTabWebElement;

	@FindBy(xpath = pageActionsMenu)
	private WebElement pageActionsMenuWebElement;

	@FindBy(xpath = addUsersOption)
	private WebElement addUsersOptionWebElement;

	@FindBy(xpath = clickUserFirstName)
	private WebElement clickUserFirstNameWebElement;

	@FindBy(xpath = search)
	private WebElement searchWebElement;

	@FindBy(id = searchValue)
	private WebElement searchValueWebElement;

	@FindBy(id = searchButton)
	private WebElement searchButtonWebElement;

	@FindBy(xpath = resendWelcomeEmailOption)
	private WebElement resendWelcomeEmailOptionWebElement;

	@FindBy(xpath = resendButton)
	private WebElement resendButtonWebElement;

	@FindBy(xpath = closeButton)
	private WebElement closeButtonWebElement;

	@FindBy(xpath = clickUserCheckbox)
	private WebElement clickUserCheckboxWebElement;

	@FindBy(xpath = importUserListOption)
	private WebElement importUserListOptionWebElement;

	@FindBy(xpath = deleteUserOption)
	private WebElement deleteUserOptionWebElement;

	@FindBy(id = successRemoveValidationMessage)
	private WebElement successRemoveValidationMessageWebElement;

	@FindBy(xpath = moveUsersOption)
	private WebElement moveUsersOptionWebElement;

	@FindBy(xpath = noUsersSelectedPopUpForMoveUsers)
	private WebElement noUsersSelectedPopUpWebElement;

	@FindBy(xpath = closeButtonNoUsersSelectedPopUpForMoveUsers)
	private WebElement closeButtonNoUsersSelectedPopUpWebElement;

	@FindBy(xpath = selectGroup)
	private WebElement selectGroupWebElement;

	@FindBy(xpath = moveButton)
	private WebElement moveButtonWebElement;

	@FindBy(xpath = successfullyMovedUsersPopUp)
	private WebElement successfullyMovedUsersPopUpWebElement;

	@FindBy(xpath = noUsersSelectedPopUpForResendWelcomeEmail)
	private WebElement noUsersSelectedPopUpForResendWelcomeEmailWebElement;

	@FindBy(xpath = closeButtonNoUsersSelectedPopUpForResendWelcomeEmail)
	private WebElement closeButtonNoUsersSelectedPopUpForResendWelcomeEmailWebElement;

	@FindBy(xpath = successfullySentWelcomeEmails)
	private WebElement successfullySentWelcomeEmailsWebElement;

	@FindBy(xpath = exportUserListOption)
	private WebElement exportUserListOptionWebElement;

	@FindBy(xpath = validationMessageNoUsersSeleted)
	private WebElement validationMessageNoUsersSeletedWebElement;

	@FindBy(id = closeButtonNoUsersSelectedPopup)
	private WebElement closeButtonNoUsersSelectedPopupWebElement;

	@FindBy(xpath = usersPaitle)
	private WebElement usersPaitleWebElement;
	
	@FindBy(xpath = exportUserListIcon)
	private WebElement exportUserListIconWebElement;
	
	@FindBy(xpath = SearchWithDropdown)
	private WebElement SearchWithDropdownWebElement;
	
	@FindBy(xpath = faxNumberOption)
	private WebElement faxNumberOptionWebElement;
	
	@FindBy(xpath = deleteUserIcon)
	private WebElement deleteUserIconWebElement;

	public void clickUsersTab() {
		
		usersTabWebElement.click();
	}

	public void clickPageActionsMenu() {
		logger.info("Opening Page Action Menu");
		pageActionsMenuWebElement.click();
	}

	public void clickAddUsersOption() {
		logger.info("Selecting Add Users option");
		addUsersOptionWebElement.click();
	}

	public void clickMoveUsersOption() {
		
		moveUsersOptionWebElement.click();
	}

	public void searchByLastName(String setLastName) {
		searchWebElement.click();
		searchValueWebElement.sendKeys(setLastName);
		searchButtonWebElement.click();
	}

	public void clickFirstUserFromTheList() {
		clickUserFirstNameWebElement.click();
	}

	public void clickUserCheckbox() {
		
		clickUserCheckboxWebElement.click();
	}

	public void clickCloseButton() {
		
		closeButtonWebElement.click();
	}

	public void clickResendButton() {
		
		resendButtonWebElement.click();
	}

	public void clickResendWelcomeEmailOption() {
		
		resendWelcomeEmailOptionWebElement.click();
	}

	public void clickImportUserListOption() {
		importUserListOptionWebElement.click();
	}

	public void clickDeleteUserOption() {
		deleteUserOptionWebElement.click();
	}

	public String successRemovalValidationMessgae() {
		String message = successRemoveValidationMessageWebElement.getText();
		return message;
	}

	public void clickCloseButtonNoUsersSelectedPopUpForMoveUsers() {
		closeButtonNoUsersSelectedPopUpWebElement.click();
	}

	public void clickCloseButtonNoUsersSelectedPopUpForResendWelcomeEmail() {
		closeButtonNoUsersSelectedPopUpForResendWelcomeEmailWebElement.click();
	}

	public void clickSelectGroup() {
		selectGroupWebElement.click();
	}

	public void clickMoveButton() {
		moveButtonWebElement.click();
	}

	public String errorValidationMessage() {
		String element = validationMessageNoUsersSeletedWebElement.getText();
		return element;
	}

	public void clickCloseButtonNoUsersSelectedPopup() {
		closeButtonNoUsersSelectedPopupWebElement.click();
	}
	
	public void searchUserByFaxno(String user_faxnumber_string) throws Exception {
		searchWebElement.click();
		this.pause(2000);
		SearchWithDropdownWebElement.click();
		this.pause(2000);
		faxNumberOptionWebElement.click();
		searchValueWebElement.sendKeys(user_faxnumber_string);
		searchButtonWebElement.click();
	}	
}