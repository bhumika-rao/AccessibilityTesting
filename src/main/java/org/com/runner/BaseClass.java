package org.com.runner;
import org.apache.logging.log4j.Logger;
import org.com.pageObject.CheckAccessibility;
import org.com.step.Hooks;
import org.com.utility.BrowserFactory;
import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
  
public class BaseClass { 
	
	public static String sessionID;
	public static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	//public static WebDriver driver;
	public static BrowserFactory browserFactory=new BrowserFactory(); 
	//public static String[] Browser=new String[1000];
	//public static String[] BrowserVersion=new String[1000];
	public static int[] ScreenshotCounter=new int[1000];
	public static String[] FailedDescription=new String[1000];
	public static String[] ExceptionName=new String[1000];
	public static String[] ExceptionMessage=new String[1000];
	public static String[] Scenario_Name=new String[1000];
	
	public static int PassedListSize;
	public static String[] PassedTagsResult=new String[10000];
	//public static List<String> PassedHelpResult=new ArrayList<>();
	public static Map<String,String> PassedCompleteResult=new LinkedHashMap<>();
	
	public static int FailedListSize;
	public static Map<String,String> FailedCompleteResult=new LinkedHashMap<>();
	public static String[] FailedTagsResult=new String[10000];
	public static String[] FailedHelpResult=new String[10000];
	
	public static int InapplicableListSize;
	public static Map<String,String> InapplicableCompleteResult=new LinkedHashMap<>();
	public static String[] InapplicableTagsResult=new String[10000];
	public static String[] InapplicableHelpResult=new String[10000];
	
	public static int IncompleteListSize;
	public static Map<String,String> IncompleteCompleteResult=new LinkedHashMap<>();
	public static String[] IncompleteTagsResult=new String[10000];
	public static String[] IncompleteHelpResult=new String[10000];
	
	
	public static String Browser=new String();
	public static String BrowserVersion=new String();
	public static String ChromeDriverPath=System.getProperty("user.dir")+"/setup/ChromeDriver/chromedriver.exe";
	public CheckAccessibility checkAccessibility;
	public Hooks hooks;
	public static long TestExecutionStartTime;
	public final static Logger logger=LogManager.getLogger("log4j2");
	
	SimpleDateFormat dateFormat=new SimpleDateFormat("MM_dd_YYYY");
	public static Date today;
	
	public WebDriver getWebDriver() {
	    //WebDriverManager.chromedriver().setup();
	    //WebDriver driver = new ChromeDriver();
	    //driver.get("https://www.google.com/");
	    return driver.get();
	}
	
	public void navigateTo(String URL)
	{
		getWebDriver().navigate().to(URL);
	}
	
	public static String getCurrentDateAndTime()
	{
		String CurrentDateAndTime=Calendar.getInstance().getTime().toString();
		CurrentDateAndTime=CurrentDateAndTime.replaceAll(" ", "_");
		CurrentDateAndTime=CurrentDateAndTime.replaceAll(":", "_");
		return CurrentDateAndTime;
	}

	public void quitBrowsers() {
		getWebDriver().quit();		
	}
}  
