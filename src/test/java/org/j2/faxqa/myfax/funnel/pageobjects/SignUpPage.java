package org.j2.faxqa.myfax.funnel.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;

import net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ExceptionDefinition;

//import com.google.common.*;
//import com.google.common.io.Files;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.logging.log4j.*;
import org.j2.faxqa.efax.common.Config;
import org.j2.faxqa.efax.common.TLDriverFactory;


public class SignUpPage {
	private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";

    private static final String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
    private static SecureRandom random = new SecureRandom();
	private WebDriver driver;
	private Logger logger;
	WebDriverWait wait;

	public SignUpPage() {
		this.driver = TLDriverFactory.getTLDriver();
		this.logger = LogManager.getLogger();
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
		logger.info(driver.getTitle() + " - [" + driver.getCurrentUrl() + "]");
	}
	@FindBy(id = "rdbMyFaxChooseNumberState")
	private WebElement radioState;
	
	@FindBy(id = "ddlMyFaxChooseNumberSelectState")
	private WebElement ddlMyFaxChooseNumberSelectState;

	@FindBy(id = "ddlMyFaxChooseNumberSelectCity")
	private WebElement ddlMyFaxChooseNumberSelectCity;

	@FindBy(id = "chooseNumberMultiColumn")
	private WebElement chooseNumberMultiColumn;

	@FindBy(id = "btnChooseNumberSubmit")
	private WebElement btnChooseNumberSubmit;

	@FindBy(id = "myFaxNoInventory")
	private WebElement myFaxNoInventory;

	@FindBy(id = "txtFirstName")
	private WebElement txtFirstName;

	@FindBy(id = "txtLastName")
	private WebElement txtLastName;

	@FindBy(id = "txtEmailAddress")
	private WebElement txtEmailAddress;

	@FindBy(id = "btnAbandonedUser")
	private WebElement btnAbandonedUser;
	
	@FindBy(id = "txtPhoneNumber")
	private WebElement txtPhoneNumber;

	@FindBy(id = "rad_VISA")
	private WebElement rad_VISA;

	@FindBy(id = "lbleFaxNumberTitle")
	private WebElement lbleFaxNumberTitle;

	@FindBy(id = "lblMyFaxNumberValue")
	private WebElement lblMyFaxNumberValue;

	@FindBy(id = "lblMyFaxPasswordValue")
	private WebElement lblMyFaxPasswordValue;

	@FindBy(id = "hypMyFaxLogin")
	private WebElement MyFaxLogin;
	
	@FindBy(id="ddlMyFaxChooseNumberOldState")
	private WebElement ChooseState;
	
	@FindBy(xpath="//div[@class='sales-funnel']/select[@id='ddlMyFaxChooseNumberOldCity']")
	private WebElement ChooseCity;
	
	@FindBy(id="btnMyFaxChooseNumberOldNextStep")
	private WebElement Nextbutton;
	
	@FindBy(id="spanMyFaxChooseNumberOldUSMap")
	private WebElement country;
	
	@FindBy(xpath="//div[@class='map active']")
	private WebElement mapactive;
	
	@FindBy(id = "ddlMyFaxChooseNumberSelectCountry")
	private WebElement ddlMyFaxChooseNumberSelectCountry;
	
	@FindBy(id="txtBillingInfoCreditCardNumber")
	private WebElement CreditCardNumber;
	
	@FindBy(id="ddlBillingExpMonthFull")
	private WebElement ddlBillingInfoMonth;
	
	@FindBy(id="ddlBillingExpYearFull")
	private WebElement ddlBillingInfoYear;
	
	@FindBy(id="txtBillingInfoCVV")
	private WebElement txtBillingInfoCVV;
	
	@FindBy(id="txtBillingInfoCompany")
	private WebElement txtBillingInfoCompany;
	
	@FindBy(id="ddlBillingInfoCountry")
	private WebElement ddlBillingInfoCountry;
	
	@FindBy(id="txtBillingInfoAddress")
	private WebElement txtBillingInfoAddress;
	
	@FindBy(id="txtBillingInfoAddress2")
	private WebElement txtBillingInfoAddress2;
	
	@FindBy(id="txtBillingInfoCity")
	private WebElement txtBillingInfoCity;
	
	@FindBy(id="ddlBillingInfoState")
	private WebElement ddlBillingInfoState;
	
	@FindBy(id="txtBillingInfoPostalCode")
	private WebElement txtBillingInfoPostalCode;
	
	@FindBy(id="btnBillingInfoSubmitEnable")
	private WebElement btnBillingInfoSubmitEnable;
	
	@FindBy(id="chkAgreementBillingdomestic")
	private WebElement chkAgreementBillingdomestic;
	
	@FindBy(id="logout")
	private WebElement logout;
	
	public void selectCardNumber(String text) {
		
		CreditCardNumber.click();
		CreditCardNumber.clear();
		CreditCardNumber.sendKeys(text);
		logger.info("CreditCardNumber set to - " + text);
	}
	
	public void selectstate() {
		//Select the state
		
		wait.until(ExpectedConditions.elementToBeClickable(ChooseState));
		Select drpstate = new Select(ChooseState);
		drpstate.selectByIndex(ThreadLocalRandom.current().nextInt(1, drpstate.getOptions().size()));
		logger.info("Setting state");
	}
	
	public void selectCity() {
		//Select the city
		wait.until(ExpectedConditions.elementToBeClickable(ChooseCity));
		Select drpcity = new Select(ChooseCity);
		drpcity.selectByIndex(ThreadLocalRandom.current().nextInt(1, drpcity.getOptions().size()));
		logger.info("Setting City");
	}

	public void setBillingCreditCardMonth(String text) {
		Select selection = new Select(ddlBillingInfoMonth);
		selection.selectByVisibleText(text);
		logger.info("Setting CardExpiringMonth to  - " + text);
	}

	public void setBillingCreditCardYear(String text) {
		Select selection = new Select(ddlBillingInfoYear);
		selection.selectByVisibleText(text);
		logger.info("Setting CardExpiringYear to  - " + text);
	}

	public void setBillingCreditCardCVV(String text) {
		txtBillingInfoCVV.clear();
		txtBillingInfoCVV.sendKeys(text);
		logger.info("Setting CardCVV to  - " + text);
	}
	
	public void setBillingCompany(String text) {
		txtBillingInfoCompany.clear();
		txtBillingInfoCompany.sendKeys(text);
		logger.info("Setting CardCVV to  - " + text);
	}
	
	public void setBillingCountry(String text) {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,1000)");
		 wait.until(ExpectedConditions.visibilityOf(ddlBillingInfoCountry));
		Select selection = new Select(ddlBillingInfoCountry);
		selection.selectByVisibleText(text);
		logger.info("BillingCountry set to - " + text);
	}
	public void setBillingAddress(String text) {
		txtBillingInfoAddress.clear();
		txtBillingInfoAddress.sendKeys(text);
		logger.info("Setting CardCVV to  - " + text);
	}
	
	public void setBillingCity(String text) {
		txtBillingInfoCity.clear();
		txtBillingInfoCity.sendKeys(text);
		logger.info("Setting CardCVV to  - " + text);
	}
	public void setBillingState(String text) {
		wait.until(ExpectedConditions.elementToBeClickable(ddlBillingInfoState));
		if (ddlBillingInfoState.isEnabled()) {
			Select selection = new Select(ddlBillingInfoState);
			selection.selectByVisibleText(text);
			logger.info("BillingState set to - " + text);
		} else
			logger.info("BillingState disabled.");
	}
	public void setBillingPostalCode(String text) {
		txtBillingInfoPostalCode.clear();
		txtBillingInfoPostalCode.sendKeys(text);
		logger.info("BillingPostalCode set to - " + text);
	}


	 public static String generateRandomString(int length) {
		 
		 
	        if (length < 1) throw new IllegalArgumentException();

	        StringBuilder sb = new StringBuilder(length);
	        for (int i = 0; i < length; i++) {

				// 0-62 (exclusive), random returns 0-61
	            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
	            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);

	            // debug
	            System.out.format("%d\t:\t%c%n", rndCharAt, rndChar);

	            sb.append(rndChar);

	        }

	        return sb.toString();

	    }
	
	public String setCity() {
		wait.until(ExpectedConditions.elementToBeClickable(ddlMyFaxChooseNumberSelectCity));
		Select selection = new Select(ddlMyFaxChooseNumberSelectCity);
		selection.selectByIndex(ThreadLocalRandom.current().nextInt(1, selection.getOptions().size()));
		String city = selection.getFirstSelectedOption().getText();
		logger.info("Setting City to - " + city);
		return city;
	}

	public String setState() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(ddlMyFaxChooseNumberSelectState));
		Select selection = new Select(ddlMyFaxChooseNumberSelectState);
		selection.selectByIndex(ThreadLocalRandom.current().nextInt(1, selection.getOptions().size()));
		String state = selection.getFirstSelectedOption().getText();
		logger.info("Setting State to - " + state);
		return state;
	}
	public boolean noInventory() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("myFaxloadingChooseNumber")));
		if (myFaxNoInventory.isDisplayed()) {
			logger.info(myFaxNoInventory.getText());
			return true;
		}
		else {
		return false;
		}
	}


	public void proceedNext() {
		btnChooseNumberSubmit.click();
		logger.info("Continuing further with Sign-Up");
	}
	
	public void Nextbutton() {
		wait.until(ExpectedConditions.visibilityOf(Nextbutton));
		Nextbutton.click();
		logger.info("Continuing further with Account & Billing Info");
	}
	
	public void  SelectCountry(String text) {
		try {
			if (driver.findElement(By.xpath("//div[@class='map active']")).isDisplayed())
			{
				wait.until(ExpectedConditions.elementToBeClickable(country));
				
			}
			else {
				driver.navigate().refresh();
				wait.until(ExpectedConditions.elementToBeClickable(country));
			}
		
		Thread.sleep(1000);
		//wait.until(ExpectedConditions.visibilityOf(country));
		//wait.until(ExpectedConditions.elementToBeClickable(country));
		Select selection = new Select(country);
		selection.selectByVisibleText(text);
		logger.info("Setting faxnumber country to - " + text);
		}
		catch(Exception ex){
			
			logger.info("Setting faxnumber country to is not navigating - " + text);
		}
	}

	public void setFirstName(String text,String text1) {
		txtFirstName.clear();
		txtFirstName.sendKeys(text+ " "+text1);
		logger.info("FirstName set to - " + text+ " "+text1);
	}
	
	public void setEmail(String text) {
		txtEmailAddress.clear();
		txtEmailAddress.sendKeys(text);
		logger.info("eMail set to - " + text);
	}

	public void proceedToOrderConfirmation() {
		wait.until(ExpectedConditions.elementToBeClickable(btnAbandonedUser));
		btnAbandonedUser.click();
		logger.info("Continuing further to Billing...");
	}

	public void setBillingPhoneNumber(String text) {
		txtPhoneNumber.clear();
		txtPhoneNumber.sendKeys(text);
		logger.info("BillingPhoneNumber set to - " + text);
	}

	public void setBillingCardTypeVisa() {
		rad_VISA.click();
		logger.info("Setting CardType to - " + rad_VISA.getAttribute("value"));
	}

	public void setBillingCreditCardNumber(String text) {
		wait.until(ExpectedConditions.visibilityOf(CreditCardNumber));
		CreditCardNumber.clear();
		CreditCardNumber.sendKeys(text);
		logger.info("Setting CardNumber to - " + text);
	}


	public void agreeToTermsConditions() {
		chkAgreementBillingdomestic.click();
	    logger.info("Agreeing to Terms & Conditions");
	}

	public void ActivateAccount() {
		btnBillingInfoSubmitEnable.click();
		logger.info("Attempting to Activate Account");
	}

	public boolean isSignUpSuccess() {
		wait.until(ExpectedConditions.visibilityOf(lblMyFaxNumberValue));
		wait.until(ExpectedConditions.visibilityOf(lblMyFaxPasswordValue));
		if (lblMyFaxNumberValue.isDisplayed() && lblMyFaxPasswordValue.isDisplayed()) {
			logger.info(String.format("Registration successful - FaxNumber=%1$s Password=%2$s", lblMyFaxNumberValue.getText(), lblMyFaxPasswordValue.getText()));
			return true;
		} else {
			logger.info("Registration un-successful.");
			return false;
		}
	}
	
	public String getLoginDetails()
	{
		return lblMyFaxNumberValue.getText() + ";" + lblMyFaxPasswordValue.getText();	
	}

	public boolean isLoginBtnAvailable() {
		wait.until(ExpectedConditions.visibilityOf(MyFaxLogin));
		boolean flag = MyFaxLogin.isDisplayed();
		return flag;
	}

	public void clickLogin() {
		
		logger.info("Attempting Auto log-in.");
		wait.until(ExpectedConditions.visibilityOf(MyFaxLogin));
		MyFaxLogin.click();
	}

	public boolean isLoggedIn() {
		if (!(driver.findElements(By.id("loginSubmitBtn")).size() > 0)) {
			logger.info("Auto Sign-in successful.");
			return true;
		} else {
			logger.info("Auto Sign-in unsuccessful.");
			return false;
		}
	}
	
	public void LoginWithCredentials(String faxnumber, String pin) {
		logger.info("Signing-in with credentials.");
		driver.findElement(By.id("phoneNumber")).sendKeys(faxnumber);
		driver.findElement(By.id("pin")).sendKeys(pin);
		driver.findElement(By.id("loginSubmitBtn")).click();
	}

	public boolean logout() {
		if (driver.findElement(By.xpath("//a[@id='logout']")).isDisplayed()) {
			logger.info("Attempting log-out.");
			driver.findElement(By.xpath("//a[@id='logout']")).click();
			return true;
		} else {
			logger.info("Sign-out unsuccessful.");
			return false;
		}
	}
}