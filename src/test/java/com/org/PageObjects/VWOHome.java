package com.org.PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VWOHome {

	private WebDriver driver;
	private By heatMapstab = By.xpath("//*[@id='main-container']/ul/li[3]/a");
	private By viewHeatmap = By.className("heatmap-thumb");

	public VWOHome(WebDriver driver) {
		this.driver = driver;
	}

	public void openheatMapinNewTab() {
		WebElement we1 = driver.findElement(heatMapstab);
		if (we1.isDisplayed() || we1.isEnabled()) {
			driver.findElement(heatMapstab).click();
			System.out.println("Clicked on HeatMaps tab...");
		} else {
			System.out.println("Heatmap tab not found");
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Waiting for element to load...");

		WebElement we2 = driver.findElement(viewHeatmap);
		if (we2.isDisplayed() || we2.isEnabled()) {
			driver.findElement(viewHeatmap).click();
			System.out.println("Clicked on View HeatMaps thumbnail...");
		} else {
			System.out.println("View HeatMaps thumbnail not found");
		}
		
	}
}
