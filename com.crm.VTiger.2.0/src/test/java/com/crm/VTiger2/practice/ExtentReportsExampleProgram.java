package com.crm.VTiger2.practice;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsExampleProgram {
	@Test
	public void report() {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
		
		String screen_shot=driver.getScreenshotAs(OutputType.BASE64);
		
		ExtentSparkReporter esp=new ExtentSparkReporter("ExtentReport//report231220232.html");
		ExtentReports er=new ExtentReports();
		er.attachReporter(esp);
		er.setSystemInfo("ReporterName", "Mathi");
		ExtentTest test=er.createTest("ExtentReportsExampleProgram");
		test.log(Status.INFO, "Test executed");
		
		test.addScreenCaptureFromBase64String(screen_shot);
		er.flush();
	}
	
}
