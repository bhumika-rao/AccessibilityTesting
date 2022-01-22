package org.com.step;

import java.io.IOException;
import java.util.List;

import org.com.pageObject.CheckAccessibility;
import org.com.runner.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccessibilityTesting_Step extends BaseClass{
	
	@Given("Launch the {string} {string} and navigate to {string}")
	public void launchTheBrowser(String browser, String browserVersion, String url)
	{
		int ID=(int) Thread.currentThread().getId();
		/*Browser[ID]=browser;
		BrowserVersion[ID]=browserVersion;
		browserFactory.launchBrowser(Browser[ID],BrowserVersion[ID]);*/
		Browser=browser;
		BrowserVersion=browserVersion;
		browserFactory.launchBrowser(Browser,BrowserVersion);
		//getWebDriver();
		//System.out.println(getWebDriver());
		navigateTo(url);
	}
	
	@Then("find and print the number of passed items for ConformanceLevel {string}")
	public void findPassedItems(String ConformanceLevel) throws IOException
	{
		checkAccessibility=new CheckAccessibility(getWebDriver());
		checkAccessibility.findAndPrintPasses(ConformanceLevel);
	}
	
	@Then("find and print the number of violation items for ConformanceLevel {string}")
	public void findViolationItems(String ConformanceLevel) throws IOException
	{
		checkAccessibility=new CheckAccessibility(getWebDriver());
		checkAccessibility.findAndPrintViolations(ConformanceLevel);
	}
	
	@Then("find and print the number of review items for ConformanceLevel {string}")
	public void findIncompleteItems(String ConformanceLevel) throws IOException 
	{
		checkAccessibility=new CheckAccessibility(getWebDriver());
		checkAccessibility.findAndPrintReviews(ConformanceLevel);
	}
	
	@Then("find and print the number of inapplicable items for ConformanceLevel {string}")
	public void findInapplicableItems(String ConformanceLevel) throws IOException
	{
		checkAccessibility=new CheckAccessibility(getWebDriver());
		checkAccessibility.findAndPrintInapplicable(ConformanceLevel);
	}
	
	@Then("find and print the number of violation items for Rule {string} and ConformanceLevel {string}")
	public void findViolationsForSpecificRules(String ruleToCheck,String conformanceLevel) throws IOException
	{
		checkAccessibility=new CheckAccessibility(getWebDriver());
		checkAccessibility.findAndPrintViolations(conformanceLevel, ruleToCheck);
	}
}
