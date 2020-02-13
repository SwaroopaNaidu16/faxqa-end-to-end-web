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
	// ---------- NonSecure MGMT SuperAdmin Account
	public static String nonSecureAccountNumberMGMTSuperAdmin;
	public static String nonSecureAdministratorNameMGMTSuperAdmin;
	public static String nonSecurePasswordMGMTSuperAdmin;
	// ---------- NonSecure MyAccount_SendFax & ViewFax
	public static String faxNumberNonSecureMyAccount_SendFaxViewFax;
	public static String passwordNonSecureMyAccount_SendFaxViewFax;
	// ---------- Secure MyAccount_SendFax & ViewFax
	public static String faxNumberSecureMyAccount_SendFaxViewFax;
	public static String passwordSecureMyAccount_SendFaxViewFax;
	public static String secondDID_SendFaxViewFax;
	// ---------- Secure MyAccount_ViewFax_Expire
	public static String faxNumberSecureMyAccount_ViewFax_Expire;
	public static String passwordSecureMyAccount_ViewFax_Expire;
	// ---------- NonSecure MyAccount_ViewFax_Expire
	public static String faxNumberNonSecureMyAccount_ViewFax_Expire;
	public static String passwordNonSecureMyAccount_ViewFax_Expire;
	// ---------- Secure MyAccount_ViewFax
	public static String faxNumberSecureMyAccount_ViewFax;
	public static String passwordSecureMyAccount_ViewFax;
	// ---------- NonSecure MyAccount_ViewFax
	public static String faxNumberNonSecureMyAccount_ViewFax;
	public static String passwordNonSecureMyAccount_ViewFax;
	public static String emailAddressNonSecureMyAccount_ViewFax;
	public static String emailAddressPasswordNonSecureMyAccount_ViewFax;
	// ---------- NonSecure MyAccount_SendFax
	public static String faxNumberNonSecureMyAccount_SendFax;
	public static String passwordNonSecureMyAccount_SendFax;
	// ---------- Cover Page
	public static String coverPageName;
	// ---------- Usage
	public static String firstName_DisplayLogsForField_ReceivedFaxes;
	public static String lastName_DisplayLogsForField_ReceivedFaxes;
	public static String faxNumber_ChooseFaxNumberField_ReceivedFaxes;
	public static String firstName_DisplayLogsForField_SentFaxes;
	public static String lastName_DisplayLogsForField_SentFaxes;
	// ---------- Add Fax Number
	public static String selectCityForSearchByAreaCode;
	public static String selectCityForSearchByState;
	public static String selectCityForSearchByZipCode;
	public static String selectCityForSearchByTollFree;
	// -------------------------------------------------------------------------------------//

	// Use this variable for create new admin user
	public static String secureAccountNumber_MGMT; // Set value from the base.properties
	public static String nonSecureAccountNumber_MGMT; // Set value from the base.properties
	public static String administratorName_MGMT;
	public static String password_MGMT;
	/*
	 * Note for administratorName_MGMT variable: 
	 * - set value from the AddUser.java page 
	 * Note for password_MGMT variable: 
	 * - set value from the ExpiredPasswordTest.java page & PasswordRequirementsTest.java page
	 */
	// -------------------------------------------------------------------------------------//

	// Use this variable for create new MyAccount user
	public static String faxNumber;
	public static String password;
	/*
	 * Note for faxNumber variable: 
	 * - set value from the AddUser.java page 
	 * Note for password variable: 
	 * - set value from the ExpiredPasswordMyAccountTest.java page & PasswordRequirementsTest.java page
	 */
	// -------------------------------------------------------------------------------------//

	// Gmail login info
	public static String URL = "https://accounts.google.com/signin";
	public static String EMAILID = "ttlttl.tg30";
	public static String PASSWORD = "Admin@123@123";
	public static String emailSuffix = "gmail.com";

	// Password that is going to be used for create new user
	public static String passwordCreateNewUser_1 = "Admin@a#7@A#8@b#9@B#8";
	public static String passwordCreateNewUser_2 = "Admin@a#7@A#8@b#9@B#61";

	// Password that is going to be used while changing password of newly created user
	public static String passwordCreateNewUser_3 = "Admin@a#7@A#8@b#9@B#91";

	// Use to set value into 'Reset Period For Users' field
	public static String valueIntoResetPeriodForUsersField = "90";
	public static String valueIntoResetPeriodForUsersField_2 = "25";
	public static String valueIntoResetPeriodForUsersField_3 = "95";

	// Use to set value into 'Reset Period For Admins' field
	public static String valueIntoResetPeriodForAdminsField_1 = "60";
	public static String valueIntoResetPeriodForAdminsField_2 = "21";
	public static String valueIntoResetPeriodForAdminsField_3 = "25";
	public static String valueIntoResetPeriodForAdminsField_4 = "65";

	// Password, Email Address, Account Number, Administrator Name & Fax Number that is going to be used for validation checks
	public static String password_4 = "Admin@a#7@A#8@b#9@B#92889";
	public static String password_5 = "A@12";
	public static String password_6 = "A@1";
	public static String password_7 = "111111111111111111111111111111111111111111111111111111111111111111";
	public static String password_8 = "@@@@@@@@@@";
	public static String password_9 = "1111111111";
	public static String password_10 = "AAAAAAAAAA";
	public static String password_11 = "Admin@a#7@A#8@b#9@B#92881";
	public static String password_12 = "Password6@123@2";
	public static String password_13 = "Password6@123@3";
	public static String password_14 = "Password6@123@4";
	public static String password_15 = "Password@123$789$Test";
	public static String password_16 = "123456789";
	public static String password_17 = "**********";
	public static String faxNumber_1 = "00000000000";
	public static String password_39Characters = "Admin@123456$Password@99@88Test089UNCLE";
	public static String password_24Characters = "Admin@123456@Password@99";
	public static String passwordLength_1 = "7";
	public static String passwordLength_2 = "41";
	public static String emailAddress = "test@test.com";
	public static String accountNumber = "12345";
	public static String invalidAdministratorName = "test";

	// Use for TTL scenarios
	public static String actualTimeToRunTTLScripts = "6";
	public static String updateSqlQueryTo1MinuteForTTLScenario = "update j2_oem_settings t set t.value = 1 where t.name='TempPasswordTimeToLive'";
	public static String updateSqlQueryTo30MinuteForTTLScenario = "update j2_oem_settings t set t.value = 30 where t.name='TempPasswordTimeToLive'";

	// Use for validate input fields
	public static String inputValue_1 = "0";
	public static String inputValue_2 = "-1";
	public static String inputValue_3 = "ab";
	public static String inputValue_4 = "%";
	public static String inputValue_5 = "2";
	public static String inputValue_6 = "1";
	public static String inputValue_7 = "9";
	public static String inputValue_8 = "31";
	public static String inputValue_9 = "10";
	public static String inputValue_10 = "45";
	public static String inputValue_11 = "3";
	public static String inputValue_12 = "1000000";
	public static String inputValue_13 = "google.com";
	public static String inputValue_14 = "google.edu";
	public static String inputValue_15 = "google.net";
	public static String inputValue_16 = "google.gov";
	public static String inputValue_17 = "google.org";
	public static String inputValue_18 = "org";
	public static String inputValue_19 = "gov";
	public static String inputValue_20 = "net";
	public static String inputValue_21 = "edu";
	public static String inputValue_22 = "com";
	public static String inputValue_23 = "c";
	
	// ---------- 'Commonly Used Password' file info
	public static String FileName = "CommonlyUsePasswords.xlsx";
	public static String workBookName = "CommonlyUsePasswords";

	// Cover Page file info
	public static String CoverPageName = "SampleCoverPage.rtf";

	// Import UserList file info
	public static String UserListFileName = "ImportUserList.csv";
	
	// Upload Document info MyAccount
	public static String UploadDocumentFileName_1 = "UploadDocumentMyAccount.png";
	public static String UploadDocumentFileName_2 = "SampleCoverPage.rtf";
	public static String UploadPdfDocumentFileName = "UploadPdfFile.pdf";
	public static String UploadTifDocumentFileName = "UploadTifFile.tif";
	public static String UploadNonSupportedDocumentFileName = "NonSupportedUploadFile.txt";
	public static String UploadPdfDocument10PagesFileName = "UploadPdfDocument10Pages.pdf";

	// Use for scenario - Add FaxNumbers using 'Search By State'
	public static String addedFaxCount = "1";
	public static String state = "Arizona";

	// Use for scenario - Add FaxNumbers using 'Search By ZipCode'
	public static String addedFaxCountUnderZipCode = "1";
	public static String zipCode = "90005";

	// Use for scenario - Add FaxNumbers using 'Search By TollFree'
	public static String addedFaxCountUnderTollFree = "1";

	// Use for scenario - Add FaxNumbers using 'Search By AreaCode'
	public static String addedFaxCountUnderAreaCode = "1";
	public static String areCode = "323";

	// Use for scenario - Import User List
	public static String lastName = "New_User";

	// Use for set value in 'Logs Received Within' field under the Usage page
	public static String timeInterval_1 = "30 days";
	public static String timeInterval_2 = "60 days";
	public static String timeInterval_3 = "90 days";
	public static String timeInterval_4 = "1 year";

	// Use for scenario Export User List - Usage page
	public static String exportUserList = "exportReport";

	// Use for scenario - Add Fax Numbers - Search By Zipcode & Search By Areacode
	public static String invalidInputCode = "1234";

	// Use for scenario - State field of MyAccount
	public static String country_1 = "Algeria";
	public static String country_2 = "United States";
	public static String state_1 = "Alaska";

	// Use for scenario - Add Widget
	public static String faxNumberSummaryWidgetID = "4";
	public static String totalUsagWidgetID = "2";
	public static String assignedFaxNumberColor = "rgb(112, 191, 102)";
	public static String unassignedFaxNumberColor = "rgb(59, 114, 181)";
	public static String totalUsagWidgetTitle = "Total Usage";
	public static String userSummaryWidgetID = "1";
	public static String recentActivityWidgetID = "3";

	// Use for scenario - Fax Number Search
	public static String searchValue_GroupName;
	public static String searchValue_FirstName;
	public static String searchValue_LastName;
	public static String searchValue_FaxNumber;
	public static String searchValue_Location;
	public static String searchBy_FirstName = "First name";
	public static String searchBy_LastName = "Last name";
	public static String searchBy_FaxNumber = "Fax number";
	public static String searchBy_Location = "Location";
	public static String searchOperator_Is = "is";
	public static String searchOperator_Contains = "contains";
	public static String searchOperator_StartsWith = "starts with";

	// Use for scenario - Time Zone Preference
	public static String defaultTimeZone = "Pacific Time";
	public static String indiaTimeZone = "Calcutta: Chennai:";
		
	// Send A Fax Scenario MyAccount
	public static String sendReceiptEmailAddress = "pavan.kandukuri@j2.com";
		
	// Non Efax User jConnect Url and Credentials
	public static String nonEfaxUserJconnectUrl = "https://myaccount.jconnect.com/internet_fax_login";
	public static String jConnectNumber = "15092784216";
	public static String jConnectPassword = "2347";
	
	// User Time zone preference info
	public static String userTimeZoneFormat = "MM/d/yyyy";
		
	// Refresh Inbox Time info in Message center of Account details page in Preference tab 
	public static String oneMinute = "Every minute";
	public static String fiveMinutes = "Every 5 minutes";
		
	// View fax link in preview pane of message center
	public static String faxViewer1 = "Fax Viewer -1";
	
	// Create, Rename & Delete Folder
	public static String newFolder = "New Folder";
	public static String renameFolder = "Rename Folder";
	public static String deleteFolder = "Delete Folder";
	public static String folderName_1 = "![]()\'{}<>%";
	public static String folderName_2 = "`~@#$^& ;*-_=+:,./?";
	public static String folderName_3 = "loremIpsumissimplydummytextoftheprintingandtypesettingindustry";
	
	// Import Contacts
	public static String importCSVFile = "Import CSV File";
	public static String gmail = "Gmail";
	public static String yahooMail = "Yahoo! Mail";
	public static String importFile = "importContacts.csv";
	public static String firstNameFromImportFile = "James";
	/*
	 * Note for firstNameFromImportFile variable: 
	 * - value of this variable should be same as first name of first entry from the 'importContacts.csv' file
	 */
	// -------------------------------------------------------------------------------------//
}