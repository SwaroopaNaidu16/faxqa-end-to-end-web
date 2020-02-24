package org.j2.faxqa.efax.common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xbill.DNS.ARecord;
import org.xbill.DNS.Credibility;
import org.xbill.DNS.DClass;
import org.xbill.DNS.Lookup;
import org.xbill.DNS.Name;
import org.xbill.DNS.Record;
import org.xbill.DNS.TextParseException;
import org.xbill.DNS.Type;

public class EnvironmentSetup extends org.testng.Reporter {
	protected static final Logger logger = LogManager.getLogger();

	public static void setupEnvironment() {

		Properties prop = new Properties();
		String file = "/environment." + System.getProperty("environment") + ".properties";
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

		Config.efax_US_myaccountBaseUrl = prop.getProperty("efax_US_myaccountBaseUrl");
		Config.efax_US_funnelBaseUrl = prop.getProperty("efax_US_funnelBaseUrl");
		Config.efax_US_landingpageBaseUrl = prop.getProperty("efax_US_landingpagelBaseUrl");
		Config.DID_US = prop.getProperty("DID_US");
		Config.PIN_US = prop.getProperty("PIN_US");
		Config.creditCard_US = prop.getProperty("CreditCard_US");

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