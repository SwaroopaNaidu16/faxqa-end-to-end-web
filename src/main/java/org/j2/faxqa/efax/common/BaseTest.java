package org.j2.faxqa.efax.common;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

import jdk.jfr.internal.LogLevel;

public class BaseTest implements IHookable {

	@Override
	public final void run(IHookCallBack callBack, ITestResult testResult) {
		callBack.runTestMethod(testResult);
		if (testResult.getThrowable() != null) {
			//testResult.getThrowable().printStackTrace();
			LogManager.getLogger().error(ExceptionUtils.getFullStackTrace(testResult.getThrowable()));
			Assert.fail();
		}
	}
}