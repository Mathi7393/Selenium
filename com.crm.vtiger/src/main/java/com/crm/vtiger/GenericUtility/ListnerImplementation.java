package com.crm.vtiger.GenericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerImplementation implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "testScriptExecutionStarted");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "testScriptExecutionStatus Pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "testScriptExecutionStatus Fail");
		WebDriverUtility wutil = new WebDriverUtility();
		JavaUtility jutil = new JavaUtility();
		String screenShotName=methodName+jutil.getModifiedDate();
		try {
			wutil.screenShotOfWebPage(BaseClass.sdriver, screenShotName);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "testScriptExecutionStatus Skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Suitelevel execution started");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Suitelevel execution Finished");
	}

}
