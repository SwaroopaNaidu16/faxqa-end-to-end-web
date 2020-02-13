package org.j2.faxqa.efax.corporate.myaccount.tests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.j2.faxqa.efax.common.Config;
import org.j2.faxqa.efax.common.TLDriverFactory;
import org.j2.faxqa.efax.common.TestRail;
import org.j2.faxqa.efax.common.Utils;
import org.j2.faxqa.efax.corporate.admin.CommonMethods;
import org.j2.faxqa.efax.corporate.admin.CoreFaxFunctions;
import org.j2.faxqa.efax.corporate.admin.pageobjects.*;
import org.j2.faxqa.efax.corporate.myaccount.pageobjects.*;

public class MyAccountTests {

	@TestRail(id="C8149")
	@Test(enabled = true, priority = 1, description = "Verify that admin user should be able to create new MyAccount user")
	public void shouldBeAbleToCreateNewMyAccountUser(ITestContext context) throws Exception {
		try {
			new CoreFaxFunctions().createNewMyAccountUser();
		} catch (Throwable e) {
			e.printStackTrace();
			new Utils().captureScreen(context);
			Assert.fail();
		}
	}

	@TestRail(id="C8150")
	@Test(enabled = true, description = "Verify that Send outbound fax and Receive inbound fax functionality is working as expected")
	public void verifySendOutboundReceiveInboundFaxFunctionality(ITestContext context) throws Exception {
		
		
		try {
			String[] credentials = new CoreFaxFunctions().createNewMyAccountUser().split(";");
			LoginPageMyAccount loginPageMyAccount = new LoginPageMyAccount();
			loginPageMyAccount.open();
			loginPageMyAccount.login(credentials[0], credentials[1]);
			
			boolean response = new CoreFaxFunctions().composeSendFaxTo(credentials[0]);
			Assert.assertEquals(response, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			new Utils().captureScreen(context);
			Assert.fail();
		}
	}

	@TestRail(id="C8151")
	@Test(enabled = true, priority = 17, description = "Verify that user should be able to send faxes, receive and view them in 'View faxes' page")
	public void ableToReceiveAndViewFaxWhenStorageEnabledONFromMGMT(ITestContext context) throws Exception {
		try {
			String[] credentials = new CoreFaxFunctions().createNewMyAccountUser().split(";");
			LoginPageMyAccount loginPageMyAccount = new LoginPageMyAccount();
			loginPageMyAccount.open();
			loginPageMyAccount.login(credentials[0], credentials[1]);
			String faxNumber = credentials[0];
			
			boolean response = new CoreFaxFunctions().composeSendFaxTo(credentials[0]);

			NavigationBarMyAccount navigationBarMyAccount = new NavigationBarMyAccount();
			navigationBarMyAccount.scrollToTheSpecificWebelement(navigationBarMyAccount.getViewFaxesTab());
			navigationBarMyAccount.clickViewFaxesTab();

			ViewFaxesModalMyAccount viewfaxespage = new ViewFaxesModalMyAccount();
			boolean flag = viewfaxespage.isFaxReceived(faxNumber, 60);
			
			Assert.assertTrue(flag);
		} catch (Throwable e) {
			e.printStackTrace();
			new Utils().captureScreen(context);
			Assert.fail();
		}
	}
}