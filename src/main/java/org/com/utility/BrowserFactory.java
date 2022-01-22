package org.com.utility;

import java.util.concurrent.TimeUnit;

import org.com.runner.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserFactory extends BaseClass{
	public WebDriver launchBrowser(String browser, String browserVersion)
	{
		int ID=(int) Thread.currentThread().getId();
		try
		{
		if(browser.equalsIgnoreCase("Chrome"))
		{
			ChromeOptions chromeOptions=new ChromeOptions(); 
			chromeOptions.addArguments("start-maximized");
			chromeOptions.addArguments("--no-sandbox","--disable-dev-shm-usage","disable-inforbars","--enable-automation","--false-useAutomationExtension");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\setup\\ChromeDriver\\chromedriver.exe");
			driver.set(new ChromeDriver(chromeOptions));
			/*System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\setup\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();		
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);*/
			//getWebDriver();
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return getWebDriver();
	}
}
