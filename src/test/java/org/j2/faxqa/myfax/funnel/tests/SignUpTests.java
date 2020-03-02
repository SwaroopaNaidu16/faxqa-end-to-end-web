package org.j2.faxqa.myfax.funnel.tests;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.j2.faxqa.efax.common.BaseTest;
import org.j2.faxqa.efax.common.Config;
import org.j2.faxqa.efax.common.TLDriverFactory;
import org.j2.faxqa.efax.common.TestRail;
import org.j2.faxqa.myfax.funnel.pageobjects.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

//@Listeners({TestExecutionListener.class, TestNGReportListener.class})
public class SignUpTests extends BaseTest {

	protected static final Logger logger = LogManager.getLogger();

	// If uploadresults=true, then the results get uploaded to location
	// https://testrail.test.j2noc.com/

	@TestRail(id = "C7862")
	@Test(enabled = true, groups = { "smoke",
			"regression" }, priority = 1, description = "US > SignUp for a new user account")
	public void verifyNewUserSignUpLogin(ITestContext context) throws Exception {
		WebDriver driver = null;

		driver = TLDriverFactory.getTLDriver();
		logger.info("Navigating to - " + Config.myfax_funnelBaseUrl+"/");
		driver.navigate().to(Config.myfax_funnelBaseUrl);
		
		

		String random = UUID.randomUUID().toString().replace("-", "").substring(0, 12);
		String firstname = "QATest";
		String lastname = new Faker().address().firstName();
		String email = firstname + "." + lastname + random.substring(3, 8) + "@mailinator.com";
		String phone = String.format("%1$s%2$s", ThreadLocalRandom.current().nextInt(10000, 99999),
				ThreadLocalRandom.current().nextInt(10000, 99999));
		String address1 = new Faker().address().streetAddress();
		String address2 = new Faker().address().zipCode();
		String city = new Faker().address().city();
		String pcode = String.format("%s", ThreadLocalRandom.current().nextInt(10000, 99999));
		String state = "California";
		String country = "United States";
		String creditcardnumber = "4133738662043055"; // "4872906545490653"; // "441506691331";
		String creditcardmonth = "DEC";
		String creditcardyear = "2025";
		String creditcardcvv = "321";
		String company = "Vensiti";

		
		
		SignUpPage signup = new SignUpPage();
		signup.SelectCountry(country);
		// signup.enterAreaCode("212");
		signup.selectstate();
		signup.selectCity();
		signup.Nextbutton();
		signup.setFirstName(firstname,lastname);
		signup.setEmail(email);
		signup.proceedToOrderConfirmation();
		signup.setBillingCountry(country);
		signup.setBillingAddress(address1);
		signup.setBillingCity(city);
		signup.setBillingState(state);
		signup.setBillingPostalCode(pcode);
		signup.setBillingPhoneNumber(phone);
		signup.setBillingCreditCardNumber(creditcardnumber);
		signup.setBillingCreditCardCVV(creditcardcvv);
		signup.setBillingCreditCardMonth(creditcardmonth);
		signup.setBillingCreditCardYear(creditcardyear);
		//signup.setBillingCompany(company);
		signup.agreeToTermsConditions();
		signup.ActivateAccount();

		boolean flag = signup.isSignUpSuccess();
		Assert.assertTrue(flag);

		String[] login = signup.getLoginDetails().split(";");
		String fax = login[0];
		String pin = login[1];

		if (signup.isLoginBtnAvailable()) {
			signup.clickLogin();
		}else {
			signup.LoginWithCredentials(fax, pin);
		}

		flag = signup.logout();
		Assert.assertTrue(flag);
	}
}
