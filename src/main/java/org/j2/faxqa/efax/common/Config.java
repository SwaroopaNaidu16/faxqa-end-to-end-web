package org.j2.faxqa.efax.common;

public class Config {

	/* efax US related config*/ 
	public static String efax_myaccountBaseUrl;
	public static String efax_funnelBaseUrl;
	public static String efax_landingpageBaseUrl;
	public static String DID;
	public static String PIN;
	public static String creditCard;
	 
	
	/*
	 * Add following entries to your host file
	 * (C:\Windows\System32\drivers\etc\hosts) 
	 * 64.125.38.77 qa.efaxcorporate.com
	 * 10.160.90.170 test.efaxcorporate.com 
	 * 10.128.90.18 offline.efaxcorporate.com
	 * 10.160.110.75 mfdev1.efaxcorporate.com 
	 * 10.160.110.74 sbdev.efaxcorporate.com
	 * 10.128.90.18 offline.efaxcorporate.com 
	 * 10.160.110.75 myfx1.efaxcorporate.com
	 * 
	 */
	// -------------------------------------------------------------------------------------//

	// Set value from the base.properties
	// ---------- URLs
	public static String mgmtBaseUrl;
	public static String myAccountBaseUrl;
	public static String adminCreateNewUser;
	public static String myAccountOverview;
	public static String getContactInfo;
	public static String sampleCoverPage;
	// ---------- DB Connection
	public static String dbConnectionUrl;
	public static String dbUserName;
	public static String dbPassword;
	// ---------- file path
	public static String filePath = "src//main//java//j2//eFaxCorporate//utils";
	// ---------- Secure MGMT Account
	public static String secureAccountNumberMGMT;
	public static String secureAdministratorNameMGMT;
	public static String securePasswordMGMT;
	// ---------- Secure MGMT Account_Expire
	public static String secureExpireAccountNumberMGMT;
	public static String secureExpireAdministratorNameMGMT;
	public static String secureExpirePasswordMGMT;
	// ---------- NonSecure MGMT Account
	public static String AccountNumberMGMT;
	public static String AdministratorNameMGMT;
	public static String PasswordMGMT;
	// ---------- NonSecure MGMT Account
	public static String nonsecureAccountNumber_MGMT; // Set value from the base.properties
	public static String nonsecureadministratorName_MGMT;
	public static String nonsecurepassword_MGMT;
	// ---------- NonSecure MGMT SuperAdmin Account
	public static String nonSecureAccountNumberMGMTSuperAdmin;
	public static String nonSecureAdministratorNameMGMTSuperAdmin;
	public static String nonSecurePasswordMGMTSuperAdmin;
	// ---------- NonSecure MyAccount_SendFax & ViewFax
	
}