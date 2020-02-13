package org.j2.faxqa.efax.corporate.admin.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.j2.faxqa.efax.common.TLDriverFactory;
import org.j2.faxqa.efax.corporate.admin.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends CommonMethods {
	private WebDriver driver;
	private Logger logger;
	WebDriverWait wait;

	public LoginPage() {
		this.driver = TLDriverFactory.getTLDriver();
		this.logger = LogManager.getLogger();
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 5);
		logger.info("Initializing page - " + driver.getTitle());
	}
	
	static final String accountNumberField = "adminId";
	static final String administratorNameField = "gAdmin";
	static final String passwordField = "adminpassword";
	static final String loginButton = "adminLoginButton";
	static final String forgotPasswordLink = "forgotPassword";
	static final String errorMessage = "//div[contains(text(),'Sorry, we were not able to log you')]";
	static final String rememberMeCheckbox = "rememberUsernameAndPasswordChk";
	static final String solutionsLinkHeader = "//ul[@class='nav-list']//a[contains(text(),'Solutions')]";
	static final String industryLinkHeader = "//ul[@class='nav-list']//a[contains(text(),'Industry')]";
	static final String resourcesLinkHeader = "//ul[@class='nav-list']//a[contains(text(),'Resources')]";
	static final String aboutLinkHeader = "//a[contains(text(),'About')]";
	static final String partnersLinkHeader = "//a[contains(text(),'Partners')]";
	static final String blogLinkHeader = "//ul[@class='nav-list']//a[contains(text(),'Blog')]";
	static final String getAQuoteLinkHeader = "//a[contains(text(),'Get a Quote')]";
	static final String userTab = "//div[@class='fake-user-tab']";
	static final String partnerTab = "//li[@id='partnerTab']";
	static final String developerTab = "//li[@id='developerTab']//a[contains(text(),'Developer')]";
	static final String onlineFaxingLinkFooter = "//a[contains(text(),'Online Faxing')]";
	static final String solutionsLinkFooter = "//div[@class='text-center']//a[contains(text(),'Solutions')]";
	static final String industryLinkFooter = "//div[@class='text-center']//a[contains(text(),'Industry')]";
	static final String resourcesLinkFooter = "//div[@class='text-center']//a[contains(text(),'Resources')]";
	static final String eventsLinkFooter = "//a[contains(text(),'Events')]";
	static final String cloudServicesLinkFooter = "//a[contains(text(),'Cloud Services')]";
	static final String blogLinkFooter = "//div[@class='text-center']//a[contains(text(),'Blog')]";
	static final String contactUsLinkFooter = "//a[contains(text(),'Contact Us')]";
	static final String smallBusinessLinkFooter = "//a[contains(text(),'Small Business')]";
	static final String mediumSizeBusinessLinkFooter = "//a[contains(text(),'Medium Size Business')]";
	static final String enterpriseBusinessLinkFooter = "//a[contains(text(),'Enterprise Business')]";
	static final String customerAgreementLinkFooter = "//a[contains(text(),'Customer Agreement')]";
	static final String privacyPolicyLinkFooter = "//a[contains(text(),'Privacy Policy')]";
	static final String legalNoticesLinkFooter = "//a[contains(text(),'Legal Notices')]";
	static final String footerBrandingImage = "//p[@class='footer-img']//a//img";
	static final String sitemapLinkFooter = "//a[contains(text(),'Sitemap')]";
	static final String errorMessageForExpiredPasswordTTLScenario = ".//table[@id='formErrorGeneralTableloginFormErrors']//div[@class='formErrorLarge']";
	static final String currentLanguage = "//div[@class='current-language']";
	static final String requiredFieldsValidationMessage = "//div[@id='formErrorJavascriptTableloginFormErrorsAdmin']//td[@class='formMessage']";


	@FindBy(id = accountNumberField)
	private WebElement accountNumberFieldWebElement;

	@FindBy(id = administratorNameField)
	private WebElement administratorNameFieldWebElement;

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

	@FindBy(xpath = solutionsLinkHeader)
	private WebElement solutionsLinkHeaderWebElement;

	@FindBy(xpath = industryLinkHeader)
	private WebElement industryLinkHeaderWebElement;

	@FindBy(xpath = resourcesLinkHeader)
	private WebElement resourcesLinkHeaderWebElement;

	@FindBy(xpath = aboutLinkHeader)
	private WebElement aboutLinkHeaderWebElement;

	@FindBy(xpath = partnersLinkHeader)
	private WebElement partnersLinkHeaderWebElement;

	@FindBy(xpath = blogLinkHeader)
	private WebElement blogLinkHeaderWebElement;

	@FindBy(xpath = getAQuoteLinkHeader)
	private WebElement getAQuoteLinkHeaderWebElement;

	@FindBy(xpath = userTab)
	private WebElement userTabWebElement;

	@FindBy(xpath = partnerTab)
	private WebElement partnerTabWebElement;

	@FindBy(xpath = developerTab)
	private WebElement developerTabWebElement;

	@FindBy(xpath = onlineFaxingLinkFooter)
	private WebElement onlineFaxingLinkFooterWebElement;

	@FindBy(xpath = solutionsLinkFooter)
	private WebElement solutionsLinkFooterWebElement;

	@FindBy(xpath = industryLinkFooter)
	private WebElement industryLinkFooterWebElement;

	@FindBy(xpath = resourcesLinkFooter)
	private WebElement resourcesLinkFooterWebElement;

	@FindBy(xpath = eventsLinkFooter)
	private WebElement eventsLinkFooterWebElement;

	@FindBy(xpath = cloudServicesLinkFooter)
	private WebElement cloudServicesLinkFooterWebElement;

	@FindBy(xpath = blogLinkFooter)
	private WebElement blogLinkFooterWebElement;

	@FindBy(xpath = contactUsLinkFooter)
	private WebElement contactUsLinkFooterWebElement;

	@FindBy(xpath = smallBusinessLinkFooter)
	private WebElement smallBusinessLinkFooterWebElement;

	@FindBy(xpath = mediumSizeBusinessLinkFooter)
	private WebElement mediumSizeBusinessLinkFooterWebElement;

	@FindBy(xpath = enterpriseBusinessLinkFooter)
	private WebElement enterpriseBusinessLinkFooterWebElement;

	@FindBy(xpath = customerAgreementLinkFooter)
	private WebElement customerAgreementLinkFooterWebElement;

	@FindBy(xpath = privacyPolicyLinkFooter)
	private WebElement privacyPolicyLinkFooterWebElement;

	@FindBy(xpath = legalNoticesLinkFooter)
	private WebElement legalNoticesLinkFooterWebElement;

	@FindBy(xpath = sitemapLinkFooter)
	private WebElement sitemapLinkFooterWebElement;

	@FindBy(xpath = footerBrandingImage)
	private WebElement footerBrandingImageWebElement;

	@FindBy(xpath = errorMessageForExpiredPasswordTTLScenario)
	private WebElement errorMessageForExpiredPasswordTTLScenarioWebElement;
	
	@FindBy(xpath = currentLanguage)
	private WebElement currentLanguageWebElement;
	
	@FindBy(xpath = requiredFieldsValidationMessage)
	private WebElement requiredFieldsValidationMessageWebElement;
		
	public WebElement getAccountNumberField() {
		return accountNumberFieldWebElement;
	}

	public WebElement getAdministratorNameField() {
		return administratorNameFieldWebElement;
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

	public WebElement getSolutionsLinkHeader() {
		return solutionsLinkHeaderWebElement;
	}

	public WebElement getIndustryLinkHeader() {
		return industryLinkHeaderWebElement;
	}

	public WebElement getResourcesLinkHeader() {
		return resourcesLinkHeaderWebElement;
	}

	public WebElement getAboutLinkHeader() {
		return aboutLinkHeaderWebElement;
	}

	public WebElement getPartnersLinkHeader() {
		return partnersLinkHeaderWebElement;
	}

	public WebElement getBlogLinkHeader() {
		return blogLinkHeaderWebElement;
	}

	public WebElement getAQuoteLinkHeader() {
		return getAQuoteLinkHeaderWebElement;
	}

	public WebElement getUserTab() {
		return userTabWebElement;
	}

	public WebElement getPartnerTab() {
		return partnerTabWebElement;
	}

	public WebElement getDeveloperTab() {
		return developerTabWebElement;
	}

	public WebElement getOnlineFaxingLinkFooter() {
		return onlineFaxingLinkFooterWebElement;
	}

	public WebElement getSolutionsLinkFooter() {
		return solutionsLinkFooterWebElement;
	}

	public WebElement getIndustryLinkFooter() {
		return industryLinkFooterWebElement;
	}

	public WebElement getResourcesLinkFooter() {
		return resourcesLinkFooterWebElement;
	}

	public WebElement getEventsLinkFooter() {
		return eventsLinkFooterWebElement;
	}

	public WebElement getCloudServicesLinkFooter() {
		return cloudServicesLinkFooterWebElement;
	}

	public WebElement getBlogLinkFooter() {
		return blogLinkFooterWebElement;
	}

	public WebElement getContactUsLinkFooter() {
		return contactUsLinkFooterWebElement;
	}

	public WebElement getSmallBusinessLinkFooter() {
		return smallBusinessLinkFooterWebElement;
	}

	public WebElement getMediumSizeBusinessLinkFooter() {
		return mediumSizeBusinessLinkFooterWebElement;
	}

	public WebElement getEnterpriseBusinessLinkFooter() {
		return enterpriseBusinessLinkFooterWebElement;
	}

	public WebElement getCustomerAgreementLinkFooter() {
		return customerAgreementLinkFooterWebElement;
	}

	public WebElement getPrivacyPolicyLinkFooter() {
		return privacyPolicyLinkFooterWebElement;
	}

	public WebElement getLegalNoticesLinkFooter() {
		return legalNoticesLinkFooterWebElement;
	}

	public WebElement getSitemapLinkFooter() {
		return sitemapLinkFooterWebElement;
	}

	public WebElement getFooterBrandingImage() {
		return footerBrandingImageWebElement;
	}

	public WebElement getErrorMessageForExpiredPasswordTTLScenario() {
		return errorMessageForExpiredPasswordTTLScenarioWebElement;
	}
	
	public WebElement getCurrentLanguage() {
		return currentLanguageWebElement;
	}
	
	public WebElement getRequiredFieldsValidationMessage() {
		return requiredFieldsValidationMessageWebElement;
	}

	public String errorMessage() {
		String errorMessage = getErrorMessage().getText();
		return errorMessage;
	}

	public void enterAccountNumber(String AccountNumber) {
		getAccountNumberField().clear();
		getAccountNumberField().sendKeys(AccountNumber);
	}

	public void enterAdministratorName(String AdministratorName) {
		getAdministratorNameField().clear();
		getAdministratorNameField().sendKeys(AdministratorName);
	}

	public void enterPassword(String password) {
		getPasswordField().clear();
		getPasswordField().sendKeys(password);
	}

	public void clickLoginButton() {
		new CommonMethods().closeGDPRbanner();
		getLoginButton().click();
	}

	public void login(String AccountNumber, String AdministratorName, String password) {
		this.enterAccountNumber(AccountNumber);
		this.enterAdministratorName(AdministratorName);
		this.enterPassword(password);
		this.clickLoginButton();
	}

	public void clickForgotPasswordLink() {
		
		getForgotPasswordLink().click();
	}

	public void clickSolutionsLinkHeader() {
		
		getSolutionsLinkHeader().click();
	}

	public void clickIndustryLinkHeader() {
		
		getIndustryLinkHeader().click();
	}

	public void clickResourcesLinkHeader() {
		
		getResourcesLinkHeader().click();
	}

	public void clickAboutLinkHeader() {
		
		getAboutLinkHeader().click();
	}

	public void clickPartnersLinkHeader() {
		
		getPartnersLinkHeader().click();
	}

	public void clickBlogLinkHeader() {
		
		getBlogLinkHeader().click();
	}

	public void clickAQuoteLinkHeader() {
		
		getAQuoteLinkHeader().click();
	}

	public void clickUserTab() {
		
		getUserTab().click();
	}

	public void clickPartnerTab() {
		
		getPartnerTab().click();
	}

	public void clickDeveloperTab() {
		
		getDeveloperTab().click();
	}

	public void clickOnlineFaxingLinkFooter() {
		
		getOnlineFaxingLinkFooter().click();
	}

	public void clickSolutionsLinkFooter() {
		
		getSolutionsLinkFooter().click();
	}

	public void clickIndustryLinkFooter() {
		
		getIndustryLinkFooter().click();
	}

	public void clickResourcesLinkFooter() {
		
		getResourcesLinkFooter().click();
	}

	public void clickEventsLinkFooter() {
		
		getEventsLinkFooter().click();
	}

	public void clickCloudServicesLinkFooter() {
		
		getCloudServicesLinkFooter().click();
	}

	public void clickBlogLinkFooter() {
		
		getBlogLinkFooter().click();
	}

	public void clickContactUsLinkFooter() {
		
		getContactUsLinkFooter().click();
	}

	public void clickSmallBusinessLinkFooter() {
		
		getSmallBusinessLinkFooter().click();
	}

	public void clickMediumSizeBusinessLinkFooter() {
		
		getMediumSizeBusinessLinkFooter().click();
	}

	public void clickEnterpriseBusinessLinkFooter() {
		
		getEnterpriseBusinessLinkFooter().click();
	}

	public void clickCustomerAgreementLinkFooter() {
		
		getCustomerAgreementLinkFooter().click();
	}

	public void clickPrivacyPolicyLinkFooter() {
		
		getPrivacyPolicyLinkFooter().click();
	}

	public void clickLegalNoticesLinkFooter() {
		
		getLegalNoticesLinkFooter().click();
	}

	public void clickSitemapLinkFooter() {
		
		getSitemapLinkFooter().click();
	}

	public void clickFooterBrandingImage() {
		
		getFooterBrandingImage().click();
	}

	public String getErrorMessageTextForExpiredPassword() {
		String errorMessage = getErrorMessageForExpiredPasswordTTLScenario().getText();
		return errorMessage;
	}
	
	public String currentLanguage() throws Exception {
		this.scrollToTheSpecificWebelement(getCurrentLanguage());
		String language = getCurrentLanguage().getText();
		return language;
	}
	
	public String requiredFieldsValidationMessage() {
		String validationMessage = getRequiredFieldsValidationMessage().getText();
		return validationMessage;
	}
}