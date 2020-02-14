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

		Config.dbUserName = prop.getProperty("dbUserName");
		Config.dbPassword = prop.getProperty("dbPassword");
		
		Config.AccountNumberMGMT = prop.getProperty("secureAccount_MGMT_AccountNumber");
		Config.AdministratorNameMGMT = prop.getProperty("secureAccount_MGMT_AdministratorName");
		Config.PasswordMGMT = prop.getProperty("secureAccount_MGMT_Password");
		
		Config.nonsecureAccountNumber_MGMT = prop.getProperty("nonSecureAccount_MGMT_AccountNumber");
		Config.nonsecureadministratorName_MGMT = prop.getProperty("nonSecureAccount_MGMT_AdministratorName");
		Config.nonsecurepassword_MGMT = prop.getProperty("nonSecureAccount_MGMT_Password");		
		
	}

}