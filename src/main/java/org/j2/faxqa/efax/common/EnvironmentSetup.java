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

	public static void setupDNSEntries() {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(EnvironmentSetup.class.getResourceAsStream("/hosts")))) {
			LogManager.getLogger().info("Adding DNS look-up entries to default cache.");
	        while (reader.ready()) {
	        	String[] line = reader.readLine().split(" ");
	        	String ipaddress = line[0].trim();
	        	String hostname = line[1].trim();
	        	addHostToCacheAs(hostname, ipaddress);
	        	LogManager.getLogger().info(ipaddress + " " + hostname);
	        }
	    }catch (FileNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	}

	public static void addHostToCacheAs(String hostname, String ipAddress) throws UnknownHostException, TextParseException {
		// add an ending period assuming the hostname is truly an absolute hostname
		Name host = new Name(hostname + ".");
		// putting in a good long TTL, and using an A record, but AAAA might be desired
		// as well for IPv6
		Record aRec = new ARecord(host, Type.A, 9999999, InetAddress.getByName(ipAddress));
		Lookup.getDefaultCache(Type.A).addRecord(aRec, Credibility.NORMAL, "QA");
	}

	public static InetAddress getInetAddressFromString(String ip) throws UnknownHostException {
		// Assume we are using IPv4
		byte[] bytes = new byte[4];
		String[] ipParts = ip.split("\\.");
		InetAddress ipaddress = null;
		// if we only have one part, it must actually be a hostname, rather than a real IP
		if (ipParts.length <= 1) {
			ipaddress = InetAddress.getByName(ip);
		} else {
			for (int i = 0; i < ipParts.length; i++) {
				bytes[i] = Byte.parseByte(ipParts[i], 2);
			}
			ipaddress = InetAddress.getByAddress(bytes);
		}
		return ipaddress;
	}

}