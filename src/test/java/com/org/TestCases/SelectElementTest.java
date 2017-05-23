package com.org.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.org.Config.TestSetup;
import com.org.PageObjects.VWOHeatMaps;
import com.org.PageObjects.VWOHome;

public class SelectElementTest extends TestSetup {
	private WebDriver driver;
	VWOHome home;
	VWOHeatMaps heatMaps;
	@BeforeClass
	public void driverSetup()
	{
		driver=getDriver();
	}
	
	@Test(priority=1)
	public void checkElementSelected()
	{
		home=new VWOHome(driver);
		home.openheatMapinNewTab();
		heatMaps=new VWOHeatMaps(driver);
		heatMaps.selectElement();
	}
	

}
