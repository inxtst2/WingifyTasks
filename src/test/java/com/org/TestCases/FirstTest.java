package com.org.TestCases;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.org.Config.TestSetup;

public class FirstTest {

	
	
	private String driverpath;
	private By heatMapstab = By.xpath("//*[@id='main-container']/ul/li[3]/a");
	private By viewHeatmap = By.className("heatmap-thumb");
	private By elementListtab = By.xpath("//*[@id='option-section']/div[6]");
	private By heatmapFrame = By.id("heatmap-iframe");
	private By elementListFrame = By.id("element-list-iframe");
	private By elementListHeader = By.id("element-list--container");
	private By toBeselectedElement = By.xpath("//*[@id='element-list--content']/tr[2]/td[1]");
	WebDriver driver;
	private static final String URL ="http://app.vwo.com/#/campaign/108/summary?token=eyJhY2NvdW50X2lkIjoxNTA3MzQsImV4cGVyaW1lbnRfaWQiOjEwOCwiY3JlYXRlZF9vbiI6MTQ0NDgxMjQ4MSwidHlwZSI6ImNhbXBhaWduIiwidmVyc2lvbiI6MSwiaGFzaCI6IjJmZjk3OTVjZTgwNmFmZjJiOTI5NDczMTc5YTBlODQxIn0=";

	@Test
	public void testMethod() {

		try {
			driverpath = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", driverpath + "\\chromedriver\\chromedriver.exe");
			System.out.println("Intializing Webdriber....");

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
			System.out.println("Opening URL...");

			driver.get(URL);

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			System.out.println("Waiting for heatMastab to load...");
			driver.findElement(heatMapstab).click();
			System.out.println("After clicking heatSmapTab...");

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			driver.findElement(viewHeatmap).click();
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			System.out.println(driver.getTitle());

			System.out.println("Switching the frame...");
			driver.switchTo().frame(driver.findElement(heatmapFrame));

			System.out.println("Waiting for 10 secs...");

			WebElement we = driver.findElement(elementListtab);
			while (we.isDisplayed() == false) {
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			}

			driver.findElement(elementListtab).click();
			System.out.println("Elementlist Tab clicked...");
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(elementListFrame));
			
			WebElement we1 = driver.findElement(elementListHeader);
			while (we1.isDisplayed() == false) {
				System.out.println("Waiting for element to appear");
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			}

			System.out.println("List header found...");
			driver.findElement(toBeselectedElement).click();
			
			System.out.println("Selected element clicked...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
