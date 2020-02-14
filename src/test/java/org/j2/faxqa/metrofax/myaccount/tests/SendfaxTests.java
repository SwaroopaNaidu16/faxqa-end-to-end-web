package org.j2.faxqa.metrofax.myaccount.tests;

import java.io.BufferedReader;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import javax.management.RuntimeErrorException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.j2.faxqa.efax.common.Config;
import org.j2.faxqa.efax.common.TLDriverFactory;
import org.j2.faxqa.efax.common.TestExecutionListener;
import org.j2.faxqa.efax.common.TestNGReportListener;
import org.j2.faxqa.efax.common.TestRail;
import org.j2.faxqa.efax.common.Utils;
import org.j2.faxqa.efax.efax_us.myaccount.pageobjects.AccountDetailsPage;
import org.j2.faxqa.efax.efax_us.myaccount.pageobjects.HomePage;
import org.j2.faxqa.efax.efax_us.myaccount.pageobjects.LoginPage;
import org.j2.faxqa.efax.efax_us.myaccount.pageobjects.SendFaxesPage;
import org.j2.faxqa.efax.efax_us.myaccount.pageobjects.ViewFaxesPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners({TestExecutionListener.class, TestNGReportListener.class})
public class SendfaxTests {

	protected static final Logger logger = LogManager.getLogger();
	
	// If uploadresults=true, then the results get uploaded to location
	// https://testrail.test.j2noc.com/

	@TestRail(id = "C7861")
	@Test(enabled = true, groups = { "smoke", "regression" }, priority = 1, description = "US > Send a fax to self and verify the received fax")
	public void testcase1(ITestContext context) throws Exception {
		WebDriver driver = null;
		try {
			driver = TLDriverFactory.getTLDriver();
			driver.navigate().to(Config.efax_myaccountBaseUrl);
			LoginPage loginpage = new LoginPage();
			loginpage.login();

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

			homepage = new HomePage();
			homepage.gotoacctdetailsview();
			acctdetailspage = new AccountDetailsPage();
			boolean flag = acctdetailspage.isSendActivityLogFound(senderid, 600);			 
			Assert.assertTrue(flag);
					
			acctdetailspage.switchToReceiveLogs();
			acctdetailspage = new AccountDetailsPage();
			flag = acctdetailspage.isReceiveActivityLogFound(senderid, 600);
			Assert.assertTrue(flag);
			
			homepage = new HomePage();
			homepage.gotoviewfaxesview();
			ViewFaxesPage viewfaxespage = new ViewFaxesPage();
			flag = viewfaxespage.isFaxReceived(senderid, 600);
			Assert.assertTrue(flag);
			
		} catch (Throwable e) {
			e.printStackTrace();
			logger.info(e.toString());
			new Utils().captureScreen(context);
			Assert.fail();
		}
	}
}
