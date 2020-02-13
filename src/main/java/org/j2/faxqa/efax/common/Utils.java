package org.j2.faxqa.efax.common;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.zeroturnaround.zip.commons.FileUtils;
import java.io.File;

public class Utils {
	public void captureScreen(ITestContext context) throws Exception {

		File src = (((TakesScreenshot) TLDriverFactory.getTLDriver()).getScreenshotAs(OutputType.FILE));
		String path = context.getOutputDirectory() + "\\screenshots\\" + Thread.currentThread().getName()
				+ new Throwable().getStackTrace()[0].getMethodName() + ".png";
		System.out.println(path);
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
		Reporter.log("<br><img src='" + path + "' style=\"width: 33%; height: 33%\"");
	}
}
