package org.j2.faxqa.efax.common;

import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EnvironmentSetup extends org.testng.Reporter {
	protected static final Logger logger = LogManager.getLogger();
	public static void setupEnvironment(){
		Properties prop = new Properties();
		String file = "/environment."+ System.getProperty("environment") +".properties";
		InputStream inputstream = EnvironmentSetup.class.getResourceAsStream(file);
		try {
			logger.info("Current Environment = " + System.getProperty("environment"));
			logger.info("Setting-up environment specific configuration.");
			logger.info("Picking-up config values from '" + file + "'");
			prop.load(inputstream);
		} catch (Throwable e) {
			logger.error("Failed to load '%s'", file);
			logger.error(e.getCause());
			e.printStackTrace();
			return;
		}

		Config.efax_myaccountBaseUrl = prop.getProperty("efax_myaccountBaseUrl");
		Config.efax_funnelBaseUrl = prop.getProperty("efax_funnelBaseUrl");
		Config.efax_landingpageBaseUrl = prop.getProperty("efax_landingpageBaseUrl");
		Config.DID = prop.getProperty("DID");
		Config.PIN = prop.getProperty("PIN");
		Config.creditCard = prop.getProperty("creditCard");
		
		
		Config.mgmtBaseUrl = prop.getProperty("baseUrl_MGMT");
		Config.myAccountBaseUrl = prop.getProperty("baseUrl_MyAccount");
		Config.dbConnectionUrl = prop.getProperty("dbConnectionUrl");
		Config.sampleCoverPage = prop.getProperty("SampleCoverPage");
		Config.dbUserName = prop.getProperty("dbUserName");
		Config.dbPassword = prop.getProperty("dbPassword");
		Config.AccountNumberMGMT = prop.getProperty("secureAccount_MGMT_AccountNumber");
		Config.AdministratorNameMGMT = prop.getProperty("secureAccount_MGMT_AdministratorName");
		Config.PasswordMGMT = prop.getProperty("secureAccount_MGMT_Password");
		Config.secureAccountNumber_MGMT = prop.getProperty("secureAccount_MGMT_AccountNumber");
		Config.nonSecureAccountNumber_MGMT = prop.getProperty("nonSecureAccount_MGMT_AccountNumber");
		Config.secureExpireAccountNumberMGMT = prop
				.getProperty("secureAccountWithExpiredPassword_MGMT_AccountNumber");
		Config.secureExpireAdministratorNameMGMT = prop
				.getProperty("secureAccountWithExpiredPassword_MGMT_AdministratorName");
		Config.secureExpirePasswordMGMT = prop.getProperty("secureAccountWithExpiredPassword_MGMT_Password");
		Config.faxNumberNonSecureMyAccount_SendFaxViewFax = prop
				.getProperty("nonSecureSendFaxAndViewFaxAccount_MyAccount_FaxNumber");
		Config.passwordNonSecureMyAccount_SendFaxViewFax = prop
				.getProperty("nonSecureSendFaxAndViewFaxAccount_MyAccount_Password");
		Config.faxNumberSecureMyAccount_ViewFax_Expire = prop
				.getProperty("secureViewFaxOnlyAccountWithExpiredPassword_MyAccount_FaxNumber");
		Config.passwordSecureMyAccount_ViewFax_Expire = prop
				.getProperty("secureViewFaxOnlyAccountWithExpiredPassword_MyAccount_Password");
		Config.faxNumberSecureMyAccount_ViewFax = prop.getProperty("secureViewFaxOnlyAccount_MyAccount_FaxNumber");
		Config.passwordSecureMyAccount_ViewFax = prop.getProperty("secureViewFaxOnlyAccount_MyAccount_Password");
		Config.nonSecureAccountNumberMGMTSuperAdmin = prop
				.getProperty("nonSecureAccountOfSuperAdminUser_MGMT_AccountNumber");
		Config.nonSecureAdministratorNameMGMTSuperAdmin = prop
				.getProperty("nonSecureAccountOfSuperAdminUser_MGMT_AdministratorName");
		Config.nonSecurePasswordMGMTSuperAdmin = prop.getProperty("nonSecureAccountOfSuperAdminUser_MGMT_Password");
		Config.adminCreateNewUser = prop.getProperty("adminCreateNewUser");
		Config.myAccountOverview = prop.getProperty("myAccountOverview");
		Config.getContactInfo = prop.getProperty("getContactInfo");
		Config.coverPageName = prop.getProperty("coverPageName");
		Config.searchValue_FirstName = prop.getProperty("searchValue_FirstName");
		Config.searchValue_LastName = prop.getProperty("searchValue_LastName");
		Config.searchValue_FaxNumber = prop.getProperty("searchValue_FaxNumber");
		Config.searchValue_Location = prop.getProperty("searchValue_Location");
		Config.searchValue_GroupName = prop.getProperty("searchValue_GroupName");
		Config.selectCityForSearchByAreaCode = prop.getProperty("selectCityForSearchByAreaCode");
		Config.selectCityForSearchByState = prop.getProperty("selectCityForSearchByState");
		Config.selectCityForSearchByZipCode = prop.getProperty("selectCityForSearchByZipCode");
		Config.selectCityForSearchByTollFree = prop.getProperty("selectCityForSearchByTollFree");
		
		
	}

}