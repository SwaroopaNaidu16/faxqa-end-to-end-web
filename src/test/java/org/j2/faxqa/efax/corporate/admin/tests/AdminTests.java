package org.j2.faxqa.efax.corporate.admin.tests;

import java.util.ArrayList;

import org.j2.faxqa.efax.common.Config;
import org.j2.faxqa.efax.common.TLDriverFactory;
import org.j2.faxqa.efax.common.TestExecutionListener;
import org.j2.faxqa.efax.common.TestRail;
import org.j2.faxqa.efax.corporate.admin.CommonMethods;
import org.j2.faxqa.efax.corporate.admin.pageobjects.AddFaxNumbersOverlay;
import org.j2.faxqa.efax.corporate.admin.pageobjects.AddGroupPage;
import org.j2.faxqa.efax.corporate.admin.pageobjects.AddUser;
import org.j2.faxqa.efax.corporate.admin.pageobjects.EditUser;
import org.j2.faxqa.efax.corporate.admin.pageobjects.FaxNumbersPage;
import org.j2.faxqa.efax.corporate.admin.pageobjects.GroupDetailsPage;
import org.j2.faxqa.efax.corporate.admin.pageobjects.GroupsPage;
import org.j2.faxqa.efax.corporate.admin.pageobjects.HomePage;
import org.j2.faxqa.efax.corporate.admin.pageobjects.LoginPage;
import org.j2.faxqa.efax.corporate.admin.pageobjects.UsersPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class AdminTests {

	@TestRail(id="C8144")
	@Test(enabled = true, priority = 0, description = "Verify that new admin user should be created successfully")
	public void adminUserShouldBeCreatedSuccessfully() throws Exception {
		try {
			WebDriver driver = TLDriverFactory.getTLDriver();
			String firstname = "QA" + new Faker().address().firstName();
			String lastname = new Faker().address().lastName();
			String primaryemail = firstname + lastname + new Faker().number().digits(3) + "@mailinator.com";
			String password = "Welcome@123";

			String expectedValidationMessage = "Group Admin Created Successfully.";
			driver.navigate().to(Config.mgmtBaseUrl);
			LoginPage loginPage = new LoginPage();
			loginPage.login(Config.AccountNumberMGMT, Config.AdministratorNameMGMT, Config.PasswordMGMT);
			HomePage homepage = new HomePage();
			homepage.clickUsersTab();
			UsersPage usersPage = new UsersPage();
			usersPage.clickPageActionsMenu();
			usersPage.clickAddUsersOption();
			AddUser adduserpage = new AddUser();
			adduserpage.tickAdminAccountCheckbox(true);
			adduserpage.enterFirstName(firstname);
			adduserpage.enterLastName(lastname);
			adduserpage.enterPrimaryEmailAddress(primaryemail);
			adduserpage.enterPassword(password);
			adduserpage.enterConfirmPassword(password);
			adduserpage.enterAdministratorName(firstname + lastname);
			adduserpage.clickCreateUserButton();
			Assert.assertEquals(adduserpage.createUserValidationMessage(), expectedValidationMessage);
			homepage = new HomePage();
			homepage.logout();
			// CommonMethods.getWelcomeEmail(primaryemail);
			loginPage = new LoginPage();
			loginPage.login(Config.AccountNumberMGMT, firstname + lastname, password);
			homepage = new HomePage();
			Assert.assertEquals(true, homepage.isUserLoggedIn());
			homepage.logout();
		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@TestRail(id="C8145")
	@Test(enabled = true, priority = 1, description = "Verify that new group should be created/added successfully")
	public void testAddGroupUsingGroupAdmin() throws Exception {
		try {
			WebDriver driver = TLDriverFactory.getTLDriver();
			String firstname = "QA" + new Faker().address().firstName();
			String lastname = new Faker().address().lastName();
			String primaryemail = firstname + lastname + new Faker().number().digits(3) + "@mailinator.com";
			String password = "Welcome@123";

			String expectedValidationMessage = "Group Admin Created Successfully.";
			driver.navigate().to(Config.mgmtBaseUrl);
			LoginPage loginPage = new LoginPage();
			loginPage.login(Config.AccountNumberMGMT, Config.AdministratorNameMGMT, Config.PasswordMGMT);
			HomePage homepage = new HomePage();
			homepage.clickUsersTab();
			UsersPage usersPage = new UsersPage();
			usersPage.clickPageActionsMenu();
			usersPage.clickAddUsersOption();
			AddUser adduserpage = new AddUser();
			adduserpage.tickAdminAccountCheckbox(true);
			adduserpage.enterFirstName(firstname);
			adduserpage.enterLastName(lastname);
			adduserpage.enterPrimaryEmailAddress(primaryemail);
			adduserpage.enterPassword(password);
			adduserpage.enterConfirmPassword(password);
			adduserpage.enterAdministratorName(firstname + lastname);
			adduserpage.clickCreateUserButton();
			Assert.assertEquals(adduserpage.createUserValidationMessage(), expectedValidationMessage);
			homepage = new HomePage();
			homepage.logout();
			// CommonMethods.getWelcomeEmail(primaryemail);
			loginPage = new LoginPage();
			loginPage.login(Config.AccountNumberMGMT, firstname + lastname, password);
			if (loginPage.isPasswordChangePrompted())
				password = loginPage.changePassword(password);
			
			driver.navigate().refresh();
			homepage = new HomePage();
			homepage.clickGroupsTab();

			AddGroupPage addGroupPage = new AddGroupPage();
			String newGrpName = "QA_Automation_" + new Faker().number().digits(5);
			addGroupPage.enterNewGroupName(newGrpName);
			addGroupPage.toggleBillingCodeRequiredBtn(false);
			addGroupPage.togglePrivatePoolRequiredBtn(false);
			addGroupPage.clickGetBtnCreateGroup();

			String expected = "Group created successfully.";
			Assert.assertEquals(addGroupPage.getSuccessGroupValidationMessage(), expected);
		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@TestRail(id="C8146")
	@Test(enabled = true, priority = 1, description = "Verify that new user should be created from the Group Details page and setting of that user should be inherited from the Group")
	public void newUserShouldBeCreatedAndSettingShouldBeInheritedFromTheGroup() throws Exception {

		try {
						
			TLDriverFactory.getTLDriver().navigate().to(Config.mgmtBaseUrl);
			LoginPage loginPage = new LoginPage();
			loginPage.login(Config.nonsecureAccountNumber_MGMT, Config.nonsecureadministratorName_MGMT, Config.nonsecurepassword_MGMT);
			HomePage homepage = new HomePage();
			homepage.clickGroupsTab();
			GroupsPage groupsPage = new GroupsPage();
			groupsPage.clickMyAccountEditButton();
			GroupDetailsPage groupDetailsPage = new GroupDetailsPage();
			groupDetailsPage.clickAdvancedSettingsButton();
			boolean groupSetting1 = groupDetailsPage.isStorageEnabled();
			boolean groupSetting2 = groupDetailsPage.isEditProfileEnabled();

			String firstname = "QATest" + new Faker().address().firstName();
			String lastname = new Faker().address().lastName();
			String contactemail = String.join(".", firstname, lastname + "@mailinator.com");
			String password = "Welcome@123";

			groupDetailsPage.clickAddUser();
			AddUser addUser = new AddUser();
			addUser.enterFirstName(firstname);
			addUser.enterLastName(lastname);
			addUser.enterPrimaryEmailPrefix(contactemail);
			addUser.enterPassword(password);
			addUser.enterConfirmPassword(password);
			addUser.clickCreateUserButton();
			
			EditUser editUser = new EditUser();
			editUser.clickAdvancedSettingsButton();

			boolean userSetting1 = editUser.isStorageEnabled();
			boolean userSetting2 = editUser.isEditProfileEnabled();
			
			Assert.assertEquals(groupSetting1, userSetting1);
			Assert.assertEquals(groupSetting2, userSetting2);
			
		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@TestRail(id="C8147")
	@Test(enabled = true, priority = 1, description = "Verify that new Fax Numbers should be added successfully to account using 'Search By - State' option")
	public void addFaxNumberUsingSearchByState() throws Exception {
		try {
			TLDriverFactory.getTLDriver().navigate().to(Config.mgmtBaseUrl);
			LoginPage loginPage = new LoginPage();
			loginPage.login(Config.AccountNumberMGMT, Config.AdministratorNameMGMT, Config.PasswordMGMT);

			HomePage homepage = new HomePage();
			homepage.clickFaxNumbersTab();

			FaxNumbersPage faxNumbersPage = new FaxNumbersPage();
			String unassignedFaxNumberCountOne = faxNumbersPage.totalUnassignedFaxNumbers();
			int unassignedFaxNumberCount1 = Integer.parseInt(unassignedFaxNumberCountOne);
			faxNumbersPage.clickPageActionsDropdown();
			faxNumbersPage.clickAddFaxNumbersIcon();

			AddFaxNumbersOverlay addFaxNumbersOverlay = new AddFaxNumbersOverlay();
			addFaxNumbersOverlay.searchByState(1);

			String actualText = addFaxNumbersOverlay.getValidationMessageText();
			Assert.assertTrue(actualText.contains("You have successfully added numbers to your account"));
			addFaxNumbersOverlay.clickCloseIcon();
			
			faxNumbersPage.refresh();
			String unassignedFaxNumberCountTwo = faxNumbersPage.totalUnassignedFaxNumbers();
			int unassignedFaxNumberCount2 = Integer.parseInt(unassignedFaxNumberCountTwo);
			Assert.assertEquals(unassignedFaxNumberCount1 + 1, unassignedFaxNumberCount2);

		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		}
	}

	@TestRail(id="C8148")
	@Test(enabled = true, priority = 19, description = "Admin > Test assigning fax numbers functionality to myaccount users")
	public void testAssignFunctionality() throws Exception {

		try {
			String unassignedFaxNumberCount;
			int count;
			LoginPage loginPage = new LoginPage();
			HomePage homepage = new HomePage();
			FaxNumbersPage faxNumbersPage = new FaxNumbersPage();
			UsersPage usersPage = new UsersPage();
			AddUser addUser = new AddUser();

			TLDriverFactory.getTLDriver().navigate().to(Config.mgmtBaseUrl);
			loginPage.login(Config.AccountNumberMGMT, Config.AdministratorNameMGMT, Config.PasswordMGMT);
			homepage.clickUsersTab();
			
			usersPage.clickPageActionsMenu();
			usersPage.clickAddUsersOption();

			String firstname = "QA" + new Faker().address().firstName();
			String lastname = "QA" + new Faker().address().lastName();
			String primaryemail = firstname + lastname + new Faker().number().digits(3) + "@mailinator.com";
			String password = new Faker().internet().password(8, 40, true, true, true);

			addUser.enterFirstName(firstname);
			addUser.enterLastName(lastname);
			addUser.enterPrimaryEmailAddress(primaryemail);
			addUser.clickCreateUserButton();

			addUser.clickFaxNumbersTab();

			faxNumbersPage.clickUnassignedNumbersTab();

			String faxNumber = faxNumbersPage.getFirstFaxNumberFromTheUnassignedTab().getText();

			faxNumbersPage.getAllTab().click();

			faxNumbersPage.searchByFaxNumber(faxNumber);

			faxNumbersPage.selectFirstFaxNumberFromTheAllTab();

			faxNumbersPage.clickMoveOption();

			faxNumbersPage.clickFirstGroupFromMoveFaxNumberPopup();

			faxNumbersPage.clickMoveButtonFromMoveFaxNumberPopup();

			faxNumbersPage.clickCloseButtonFromSucceededPopup();

			homepage.clickFaxNumbersTab();

			homepage.refresh();

			faxNumbersPage.getAllTab().click();

			faxNumbersPage.searchByFaxNumber(faxNumber);

			faxNumbersPage.selectFirstFaxNumberFromTheAllTab();

			faxNumbersPage.clickAssignOption();

			faxNumbersPage.enterUserSearchTerm(lastname);

			faxNumbersPage.clickAssignFaxNumbersButton();

			String expectedResult_1 = "All selected fax numbers were successfully assigned!";
			String actualResult_1 = faxNumbersPage.getSucceededPopup().getText();

			Assert.assertEquals(actualResult_1, expectedResult_1);

			faxNumbersPage.clickCloseButtonFromSucceededPopup();

			unassignedFaxNumberCount = faxNumbersPage.totalUnassignedFaxNumbers();
			count = Integer.parseInt(unassignedFaxNumberCount);

			Assert.assertEquals(count, 0);

		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}