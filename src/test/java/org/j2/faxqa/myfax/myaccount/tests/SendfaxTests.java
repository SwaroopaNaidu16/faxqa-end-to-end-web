package org.j2.faxqa.myfax.myaccount.tests;

import java.io.BufferedReader;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import javax.management.RuntimeErrorException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.j2.faxqa.efax.common.BaseTest;
import org.j2.faxqa.efax.common.Config;
import org.j2.faxqa.efax.common.TLDriverFactory;
import org.j2.faxqa.efax.common.TestExecutionListener;
import org.j2.faxqa.efax.common.TestNGReportListener;
import org.j2.faxqa.efax.common.TestRail;
import org.j2.faxqa.myfax.myaccount.pageobjects.AccountDetailsPage;
import org.j2.faxqa.myfax.myaccount.pageobjects.HomePage;
import org.j2.faxqa.myfax.myaccount.pageobjects.LoginPage;
import org.j2.faxqa.myfax.myaccount.pageobjects.NavigationBar;
import org.j2.faxqa.myfax.myaccount.pageobjects.SendFaxesPage;
import org.j2.faxqa.myfax.myaccount.pageobjects.ViewFaxesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners({TestExecutionListener.class, TestNGReportListener.class})
public class SendfaxTests extends BaseTest {

	protected static final Logger logger = LogManager.getLogger();

	// If uploadresults=true, then the results get uploaded to location
	// https://testrail.test.j2noc.com/

	@TestRail(id = "C7861")
	@Test(enabled = true, groups = { "smoke",
			"regression" }, priority = 1, description = "US > Send a fax to self and verify the received fax")
	public void testcase1(ITestContext context) throws Exception {
		WebDriver driver = TLDriverFactory.getTLDriver();
		driver.navigate().to(Config.myfax_myaccountBaseUrl);
		LoginPage loginpage = new LoginPage();
		loginpage.login(Config.myfax_DID,Config.myfax_PIN);

		if (driver.findElements(By.id("viewfaxesdash")).size() > 0) {
			logger.info("Default home-page is 'My eFax Home Page'");
		} else if (driver.findElements(By.xpath("//*/a/span[contains(text(),'INBOX ')]")).size() > 0) {
			logger.info("Default home-page is 'Main MessageCenter� Page (View Faxes)'");
			logger.info("Navigating back to default home-page");
			driver.findElement(By.id("myaccthometab")).click();
		}

		HomePage homepage = new HomePage();
		homepage.gotoacctdetailsview();

		String senderid = UUID.randomUUID().toString().replace("-", "").substring(0, 15);
		AccountDetailsPage acctdetailspage = new AccountDetailsPage();
		acctdetailspage.updatesendCSID(senderid);

		homepage = new HomePage();
		homepage.gotosendfaxesview();

		SendFaxesPage sendpage = new SendFaxesPage();
		sendpage.sendfax(senderid);
		sendpage.confirmationVerify();
		sendpage.closeconfirmation();
		boolean flag;

		homepage = new HomePage();
		homepage.gotoacctdetailsview();
		acctdetailspage = new AccountDetailsPage();
		flag = acctdetailspage.isSendActivityLogFound(senderid, 60);
		// Assert.assertTrue(flag);

		acctdetailspage.switchToReceiveLogs();
		acctdetailspage = new AccountDetailsPage();
		flag = acctdetailspage.isReceiveActivityLogFound(senderid, 60);
		// Assert.assertTrue(flag);

		NavigationBar navigate = new NavigationBar();
		navigate.clickViewFaxesTab();

		ViewFaxesPage viewfaxespage = new ViewFaxesPage();
		flag = viewfaxespage.isFaxReceived(senderid, 60);
		Assert.assertTrue(flag);

	}
}
