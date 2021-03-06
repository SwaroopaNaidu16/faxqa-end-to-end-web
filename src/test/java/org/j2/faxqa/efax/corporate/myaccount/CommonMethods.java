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

	public static String returnAbsoluteFilePath(String filePath, String fileName) throws Exception {
		File file = new File(filePath + "/" + fileName);
		String path = file.getAbsolutePath();
		return path;
	}
	
	public String getWelcomeEmail(String email, String subject, int timeout) {
		WebDriver driver = TLDriverFactory.getTLDriver();
		driver.navigate().to("https://www.mailinator.com/v3/index.jsp?zone=public&query=<email>#/#msgpane".replace("<email>", email.split("@")[0]));
		driver.findElement(By.xpath("//table/tbody/tr/td[4]/a[contains(text(), '" + subject + "')]")).click();
		driver.findElement(By.xpath("//*[@id='parts_buttons']/button[1]")).click();
		return driver.switchTo().frame("msg_body").findElement(By.tagName("body")).getText();
	}

}