package com.crm.vtiger.practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DisplayBrokenLinks {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://www.amazon.in/");
		List<WebElement> allLink = driver.findElements(By.xpath("//a"));
		List<String> brokenLinks=new ArrayList<String>();
		for (int i = 0; i < allLink.size(); i++) {
			String links=allLink.get(i).getAttribute("href");
			int statuscode=0;
			try {
				URL ob=new URL(links);
				URLConnection urlConn = ob.openConnection();
				HttpURLConnection httpurlconn=(HttpURLConnection)urlConn;
				statuscode=httpurlconn.getResponseCode();
				if (statuscode>=400) {
					brokenLinks.add(links+""+statuscode);
				}
			} catch (Exception e) {
				continue;
			}
			
		}
		System.out.println(brokenLinks+"\n");	
	}

}
