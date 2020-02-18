package org.j2.faxqa.efax.corporate.myaccount;

import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.j2.faxqa.efax.common.TLDriverFactory;
import org.j2.faxqa.efax.corporate.admin.pageobjects.NavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.zeroturnaround.zip.ZipUtil;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

public class CommonMethods {

	public WebDriver driver = TLDriverFactory.getTLDriver();
	public String url = null;
	public static String zipFile = null;
	public static String folderName = null;
	public static String folderPath = null;
	
	public void waitForElementToBeVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(this.driver, 20); // 20 seconds
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(this.driver, 20); // 20 seconds
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void scrollToTheSpecificWebelement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void clickUsingJavaScript(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void mouseHoverOn(WebElement element) {
		Actions action = new Actions(this.driver);
		action.moveToElement(element).build().perform();
	}

	public void doubleClickAction(WebElement element) {
		Actions actions = new Actions(this.driver);
		actions.doubleClick(element).perform();
	}

	public void rightClickAction(WebElement element) {
		Actions action = new Actions(this.driver);
		action.contextClick(element).build().perform();
	}

	public void clickAction(WebElement element) throws Exception {
		Actions actions = new Actions(this.driver);
		actions.click(element).build().perform();
	}

	public void open() throws Exception {
		if (System.getProperty("environment").contains("prod")) {
			driver.get(this.url);
		} else {
			//driver.get(this.url);
			try {
				driver.navigate().to("javascript:document.getElementById('details-button').click()");
				driver.navigate().refresh();
			} catch (Exception e) {
				driver.navigate().refresh();
			}
		}
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public void keyBoardClickInteraction(int keyCode) throws Exception {
		Robot robot = new Robot();
		robot.keyPress(keyCode);
		robot.keyRelease(keyCode);
	}

	public static Sheet fileRead(String filePath, String fileName, String sheetName) throws Exception {
		File object1 = new File(filePath + "\\" + fileName);
		FileInputStream object2 = new FileInputStream(object1);
		@SuppressWarnings("resource")
		Workbook object3 = new XSSFWorkbook(object2);
		Sheet object4 = object3.getSheet(sheetName);
		return object4;
	}

	public void switchSiteLanguageToFrench() throws Exception {
		String locator1 = "//div[@class='current-language']";
		String locator2 = "/html[1]/body[1]/div[2]/footer[1]/div[3]/ul[1]/li[5]/ul[1]/li[3]/a[1]";
		try {
			WebElement languageOption = driver.findElement(By.xpath("//div[@class='current-language']"));
			WebElement frenchLanguageSelection = driver
					.findElement(By.xpath("/html[1]/body[1]/div[2]/footer[1]/div[3]/ul[1]/li[5]/ul[1]/li[3]/a[1]"));
			scrollToTheSpecificWebelement(languageOption);
			languageOption.click();
			frenchLanguageSelection.click();
		} catch (Exception e) {
			@SuppressWarnings("unused")
			WebElement element1 = driver.findElement(By.xpath("//div[@class='current-language']"));
			@SuppressWarnings("unused")
			WebElement element2 = driver
					.findElement(By.xpath("/html[1]/body[1]/div[2]/footer[1]/div[3]/ul[1]/li[5]/ul[1]/li[3]/a[1]"));
		}
	}

	public void switchSiteLanguageToGerman() throws Exception {

		String locator1 = "//div[@class='current-language']";
		String locator2 = "/html[1]/body[1]/div[2]/footer[1]/div[3]/ul[1]/li[5]/ul[1]/li[2]/a[1]";
		try {
			WebElement languageOption = driver.findElement(By.xpath("//div[@class='current-language']"));
			WebElement germanLanguageSelection = driver
					.findElement(By.xpath("/html[1]/body[1]/div[2]/footer[1]/div[3]/ul[1]/li[5]/ul[1]/li[2]/a[1]"));
			scrollToTheSpecificWebelement(languageOption);
			languageOption.click();
			germanLanguageSelection.click();
		} catch (Exception e) {
			@SuppressWarnings("unused")
			WebElement element1 = driver.findElement(By.xpath("//div[@class='current-language']"));
			@SuppressWarnings("unused")
			WebElement element2 = driver
					.findElement(By.xpath("/html[1]/body[1]/div[2]/footer[1]/div[3]/ul[1]/li[5]/ul[1]/li[2]/a[1]"));
		}
	}

	public void switchSiteLanguageToEnglish() throws Exception {
		String locator1 = "//div[@class='current-language']";
		String locator2 = "/html[1]/body[1]/div[2]/footer[1]/div[3]/ul[1]/li[5]/ul[1]/li[1]/a[1]";
		try {
			WebElement languageOption = driver.findElement(By.xpath("//div[@class='current-language']"));
			WebElement englishLanguageSelection = driver
					.findElement(By.xpath("/html[1]/body[1]/div[2]/footer[1]/div[3]/ul[1]/li[5]/ul[1]/li[1]/a[1]"));
			scrollToTheSpecificWebelement(languageOption);
			languageOption.click();
			englishLanguageSelection.click();
		} catch (Exception e) {
			@SuppressWarnings("unused")
			WebElement element1 = driver.findElement(By.xpath("//div[@class='current-language']"));
			@SuppressWarnings("unused")
			WebElement element2 = driver
					.findElement(By.xpath("/html[1]/body[1]/div[2]/footer[1]/div[3]/ul[1]/li[5]/ul[1]/li[1]/a[1]"));
		}
	}

	public void closeGDPRbanner() {
		try {
			By gdprUnderstandButton = By.id("cookie-understand");
			WebDriverWait wait = new WebDriverWait(driver, 5); // 5 seconds
			wait.until(ExpectedConditions.elementToBeClickable(gdprUnderstandButton));
			this.driver.findElement(gdprUnderstandButton).click();
		} catch (Exception e) {
		}
	}


	// For Admin / Group Admin user
	@SuppressWarnings("unused")
	public void executeSQLqueryToSetPasswordToExpired(String accountNumber, String administratorName,
			String expiredDays) {
		String query = "select caa.adminck from j2_corp_accounts ca, j2_corp_admin_accounts caa, ispcustomer c where ca.resellerid = '"
				+ accountNumber + "' and caa.parentck = ca.customerkey and caa.username = '" + administratorName
				+ "' and caa.status = 'A' and c.customerkey = caa.adminck and c.status = 'A'";
		ArrayList<String> arrayContainingCustomerKey = null;
		try {
			arrayContainingCustomerKey = DatabaseUtility.executeSQLQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String customerKey = arrayContainingCustomerKey.get(0).toString().trim().replace("ADMINCK:", "");
		String query2 = "select * from j2_password_history t where t.customerkey = " + customerKey;
		ArrayList<String> passwordHistoryTableValuesForAdmin = null;
		try {
			passwordHistoryTableValuesForAdmin = DatabaseUtility.executeSQLQuery(query2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String query3 = "update j2_password_history t set t.createdatetime = t.createdatetime -" + expiredDays
				+ "where t.customerkey = '" + customerKey + "'";
		try {
			DatabaseUtility.executeSQLQuery(query3);
		} catch (SQLException e) {
		}
		String query4 = "select * from j2_password_history t where t.customerkey = " + customerKey;
		ArrayList<String> passwordHistoryTableValuesForAdmin2 = null;
		try {
			passwordHistoryTableValuesForAdmin2 = DatabaseUtility.executeSQLQuery(query4);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// For MyAccount / child user
	public void myAccountUserexecuteSQLqueryToSetPasswordToExpired(String faxNumber, String expiredDays) {
		String query = "select s.customerkey from ispservice s where s.serviceid = '" + faxNumber
				+ "' and status = 'A'";

		ArrayList<String> arrayContainingCustomerKey = null;
		try {
			arrayContainingCustomerKey = DatabaseUtility.executeSQLQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String customerKey = arrayContainingCustomerKey.get(0).toString().trim().replace("CUSTOMERKEY:", "");
		String query2 = "select * from j2_password_history t where t.customerkey = " + customerKey;
		ArrayList<String> passwordHistoryTableValuesForUser = null;
		try {
			passwordHistoryTableValuesForUser = DatabaseUtility.executeSQLQuery(query2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String query3 = "update j2_password_history t set t.createdatetime = t.createdatetime -" + expiredDays
				+ "where t.customerkey = '" + customerKey + "'";
		try {
			DatabaseUtility.executeSQLQuery(query3);
		} catch (SQLException e) {
		}
		String query4 = "select * from j2_password_history t where t.customerkey = " + customerKey;
		ArrayList<String> passwordHistoryTableValuesForUser2 = null;
		try {
			passwordHistoryTableValuesForUser2 = DatabaseUtility.executeSQLQuery(query4);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static String returnAbsoluteFilePath(String filePath, String fileName) throws Exception {
		File file = new File(filePath + "/" + fileName);
		String path = file.getAbsolutePath();
		return path;
	}
	
	public String getWelcomeEmail(String email, int timeout) {
		WebDriver driver = TLDriverFactory.getTLDriver();
		driver.navigate().to("https://www.mailinator.com/v3/index.jsp?zone=public&query=<email>#/#msgpane".replace("<email>", email.split("@")[0]));
		driver.findElement(By.xpath("//table/tbody/tr/td[4]/a[contains(text(), 'Your eFax Group Administrator Information')]")).click();
		return driver.findElement(By.xpath("//p[contains(.,'Account Number:') and contains(.,'User Name:') and contains(.,'Password:')]/..")).getText();
	}

}