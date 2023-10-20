package com.crm.vtiger.GenericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementation implements ITestListener {
	ExtentReports reports;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "testScriptExecutionStarted");
		test=reports.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+"Pass");
		System.out.println(methodName + "testScriptExecutionStatus Pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.FAIL, methodName+"Fail");
		test.log(Status.INFO, result.getThrowable());
		System.out.println(methodName + "testScriptExecutionStatus Fail");
		WebDriverUtility wutil = new WebDriverUtility();
		JavaUtility jutil = new JavaUtility();
		String screenShotName = methodName + jutil.getModifiedDate();
		try {
			String path = wutil.screenShotOfWebPage(BaseClass.sdriver, screenShotName);
			test.addScreenCaptureFromPath(path);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+"Skipped");
		test.log(Status.INFO, result.getThrowable());
		System.out.println(methodName + "testScriptExecutionStatus Skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Suitelevel execution started");

		// System Configuration
		ExtentSparkReporter htmlReports = new ExtentSparkReporter(
				"./ExtentReports\\Report-" + new JavaUtility().getModifiedDate() + ".html");
		htmlReports.config().setDocumentTitle("Execution Report");
		htmlReports.config().setTheme(Theme.DARK);
		htmlReports.config().setReportName("Vtiger Execution Report");

		// report Configuration
		reports = new ExtentReports();
		reports.attachReporter(htmlReports);
		reports.setSystemInfo("BaseURL", "http://localhost:8888/");
		reports.setSystemInfo("BasePlatform", "window");
		reports.setSystemInfo("Basebrowser", "chrome");
		reports.setSystemInfo("ReporterName", "Mathi");

	}

	@Override
	public void onFinish(ITestContext context) {
		// To consolidate the report or to replace the old report with new report
		reports.flush();
		System.out.println("Suitelevel execution Finished");
	}

}
