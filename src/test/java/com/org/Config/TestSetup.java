package com.org.Config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestSetup {
	private WebDriver driver;
	// private static final String URL =
	// "http://app.vwo.com/#/campaign/108/summary?token=eyJhY2NvdW50X2lkIjoxNTA3MzQsImV4cGVyaW1lbnRfaWQiOjEwOCwiY3JlYXRlZF9vbiI6MTQ0NDgxMjQ4MSwidHlwZSI6ImNhbXBhaWduIiwidmVyc2lvbiI6MSwiaGFzaCI6IjJmZjk3OTVjZTgwNmFmZjJiOTI5NDczMTc5YTBlODQxIn0=";
	private static String projectPath = System.getProperty("user.dir");

	public WebDriver getDriver() {
		return driver;

	}

	public void setDriver(String browser, String URL) {
		switch (browser) {
		case "chrome":
			System.out.println("Chrome Driver intializing...");
			System.setProperty("webdriver.chrome.driver", projectPath + "\\chromedriver\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
			//driver.manage().window().maximize();
			//System.out.println("Maximizing the window...");
			driver.get(URL);
				
			System.out.println("Opening URL in Chrome Browser...");
			break;

		case "firefox":
			System.out.println("Firefox Driver intializing...");
			driver = new FirefoxDriver();
			driver.get(URL);
			System.out.println("Opening URL in Firefox Browser...");
			break;
		default:
			System.out.println("Invalid browser, Lanching Firefox as default browser");
			driver = new FirefoxDriver();
			driver.get(URL);
			System.out.println("Opening URL in Firefox Browser...");
		}
	}

	@Parameters({ "browser", "URL" })
	@BeforeClass
	public void intializeDriver(String browser, String URL) {
		try {
			setDriver(browser, URL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void closeBrowser() {
		//System.out.println("Task completed :-)");
		//driver.quit();
	}
}
