package org.j2.faxqa.efax.corporate.myaccount.tests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.j2.faxqa.efax.common.BaseTest;
import org.j2.faxqa.efax.common.Config;
import org.j2.faxqa.efax.common.TLDriverFactory;
import org.j2.faxqa.efax.common.TestRail;
import org.j2.faxqa.efax.corporate.admin.CommonMethods;
import org.j2.faxqa.efax.corporate.admin.CoreFaxFunctions;
import org.j2.faxqa.efax.corporate.admin.pageobjects.*;
import org.j2.faxqa.efax.corporate.myaccount.pageobjects.*;
import org.j2.faxqa.efax.efax_us.myaccount.pageobjects.AccountDetailsPage;
import org.j2.faxqa.efax.efax_us.myaccount.pageobjects.HomePage;

public class MyAccountTests  extends BaseTest {

	@TestRail(id = "C8149")
	@Test(enabled = true, priority = 1, groups = {"smoke", "regression" }, description = "Verify that admin user should be able to create new MyAccount user")
	public void shouldBeAbleToCreateNewMyAccountUser() throws Exception {
		CoreFaxFunctions coreFunctions = new CoreFaxFunctions();
		Map<String, String> details = coreFunctions.createNewMyAccountUser();
		
		coreFunctions.deleteAccount(Config.AccountNumberMGMT, Config.AdministratorNameMGMT, Config.PasswordMGMT, details.get("primaryemail"));
	}

	@TestRail(id = "C8150")
	@Test(enabled = true, priority = 1, groups = {"smoke", "regression" }, description = "Verify that Send outbound fax and Receive inbound fax functionality is working as expected")
	public void verifySendOutboundReceiveInboundFaxFunctionality() throws Exception {
		CoreFaxFunctions coreFunctions = new CoreFaxFunctions();
		Map<String, String> details = coreFunctions.createNewMyAccountUser();
		
		LoginPageMyAccount loginPageMyAccount = new LoginPageMyAccount();
		loginPageMyAccount.login(details.get("faxNumber"), details.get("password"));
		boolean response = new CoreFaxFunctions().composeSendFaxTo(details.get("faxNumber"));
		Assert.assertEquals(response, true);
		HomePageMyAccount myaccount = new HomePageMyAccount();
		myaccount.logout();
		
		coreFunctions.deleteAccount(Config.AccountNumberMGMT, Config.AdministratorNameMGMT, Config.PasswordMGMT, details.get("primaryemail"));
	}

	@TestRail(id = "C8151")
	@Test(enabled = true, priority = 1, groups = {"smoke", "regression" }, expectedExceptions = {Exception.class}, description = "Verify that user should be able to send faxes, receive and view them in 'View faxes' page")
	public void ableToReceiveAndViewFaxWhenStorageEnabledONFromMGMT() throws Exception {
		CoreFaxFunctions coreFunctions = new CoreFaxFunctions();
		Map<String, String> details = coreFunctions.createNewMyAccountUser();
		LoginPageMyAccount loginPageMyAccount = new LoginPageMyAccount();
		loginPageMyAccount.login(details.get("faxNumber"), details.get("password"));
		String faxNumber = details.get("faxNumber");

		String uniqueid = UUID.randomUUID().toString().replace("-", "").substring(0, 15);
		HomePageMyAccount homepage = new HomePageMyAccount();
		homepage.clickAccountDetailsTab();

		AccountDetailsPageMyAccount acctdetailspage = new AccountDetailsPageMyAccount();
		acctdetailspage.clickPreferencesTab();
		acctdetailspage.updatesendCSID(uniqueid);

		boolean response = new CoreFaxFunctions().composeSendFaxTo(details.get("faxNumber"));
		Assert.assertTrue(response);

		NavigationBarMyAccount navigationBarMyAccount = new NavigationBarMyAccount();
		navigationBarMyAccount.clickReportsTab();

		AccountDetailsPageMyAccount aacdetailspage = new AccountDetailsPageMyAccount();
		aacdetailspage.clickReportsTab();
		aacdetailspage.clickSendTab();
		aacdetailspage.clickSendGo();
		boolean flag = aacdetailspage.isSendActivityLogFound(uniqueid, 120);
		// Assert.assertTrue(response);

		aacdetailspage.clickReceiveTab();
		aacdetailspage.clickReceiveGo();
		flag = aacdetailspage.isReceiveActivityLogFound(uniqueid, 120);
		// Assert.assertTrue(response);

		aacdetailspage.clickViewFaxesTab();
		ViewFaxesModalMyAccount viewfaxespage = new ViewFaxesModalMyAccount();
		viewfaxespage.clickViewFaxesTab();
		flag = viewfaxespage.isFaxReceived(uniqueid, 120);
		Assert.assertTrue(flag);

		coreFunctions.deleteAccount(Config.AccountNumberMGMT, Config.AdministratorNameMGMT, Config.PasswordMGMT, details.get("primaryemail"));
	}
}