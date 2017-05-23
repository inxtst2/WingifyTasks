package com.org.PageObjects;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VWOHeatMaps {

	private WebDriver driver;
	private By elementListtab = By.xpath("//*[@id='option-section']/div[6]");
	private By heatmapFrame = By.id("heatmap-iframe");
	private By elementListFrame = By.id("element-list-iframe");
	 
	private By toBeselectedElement = By.xpath("//*[@id='element-list--content']/tr[2]/td[1]");

	public VWOHeatMaps(WebDriver driver) {
		this.driver = driver;
	}

	public void selectElement() {
		
		try {
			System.out.println("Moving driver to new tab...");
			
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			System.out.println("Title for this tab is :-->"+driver.getTitle());

			System.out.println("Switching the frame...");
			driver.switchTo().frame(driver.findElement(heatmapFrame));

			System.out.println("Waiting for 5 secs...");

			WebElement we = driver.findElement(elementListtab);
			if (we.isDisplayed() == false) {
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			}
			else{
				driver.findElement(elementListtab).click();
				System.out.println("Elementlist Tab clicked...");
			}

						
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(elementListFrame));
			
			WebElement we1 = driver.findElement(toBeselectedElement);
			if (we1.isDisplayed() == false) {
				System.out.println("Waiting for element to appear");
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			}
			else{
				System.out.println("The standard chunk of...(found)");
				driver.findElement(toBeselectedElement).click();	
			}
		
			
			System.out.println("Selected element clicked...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
