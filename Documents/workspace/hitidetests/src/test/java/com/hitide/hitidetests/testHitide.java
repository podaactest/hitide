package com.hitide.hitidetests;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testHitide {
	WebDriver driver;

	@BeforeTest
	public void setup() throws InterruptedException {

		driver = BrowserFactory.getBrowser("Firefox");
		driver.get("http://podaac-tools.jpl.nasa.gov/hitide/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	
	@AfterTest
	public void teardown() {
		driver.quit();

	}
	
	@Test(groups="orderBo")
	public void samTest() throws InterruptedException{
		hitideDashBoardPage hpage= PageFactory.initElements(driver, hitideDashBoardPage.class);
		hitideHomePage hhp= hpage.ClickContinue();
		Selected_DatasetsPage sdp = hhp.SelectMatchnigDataset();
		sdp.SelectGranuleForDataset();;
		Thread.sleep(500);
		
	}

}
