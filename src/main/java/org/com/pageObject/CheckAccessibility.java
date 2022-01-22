package org.com.pageObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.com.runner.BaseClass;
import org.com.utility.ExcelUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.deque.html.axecore.axeargs.AxeRunOnlyOptions;
import com.deque.html.axecore.axeargs.AxeRunOptions;
import com.deque.html.axecore.results.CheckedNode;
import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeBuilder;

public class CheckAccessibility extends BaseClass
{
	public CheckAccessibility(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

    
	Map<String,String> mapOfElements=new LinkedHashMap<>();
	int id=(int)Thread.currentThread().getId();
	@SuppressWarnings("deprecation")
	public void findAndPrintPasses(String levelOfConformance) throws IOException 
	{
	    AxeRunOnlyOptions runOnlyOptions = new AxeRunOnlyOptions();	    
	    runOnlyOptions.setValues(Arrays.asList(levelOfConformance));
	    AxeRunOptions options = new AxeRunOptions();	    
	    AxeBuilder axe = new AxeBuilder().withOptions(options);
	    Results result = axe.setLegacyMode().analyze(getWebDriver());
	    //Results result = axe.analyze(getWebDriver());
	    PassedListSize=(result.getPasses().size());
	    for (Rule r : result.getPasses()) {
	    	for(CheckedNode l:(r.getNodes()))
	    	{
		    	PassedCompleteResult.put("CSS element= "+l.getTarget(),"Description= "+r.getHelp());
		    	mapOfElements.put(l.getTarget().toString(),r.getHelp());
	    	}
	    	//PassedHelpResult.add("Help Url= "+r.getHelp());
	        /*System.out.println("Complete = "+r.toString());
	        System.out.println("Tags = "+r.getTags());
	        System.out.println("Description = "+r.toString());
	        System.out.println("Help Url = "+r.getHelp());
	        System.out.println("\n");*/
	    	//axeResults.sethelp(r.getHelp());
	    	//axeResults.sethtml(levelOfConformance);
	        //list.add(r.toString());
	        //list.add(r.getHelp());
	    	
	        //     
	        }
	    for (String name: mapOfElements.keySet()) {
    	    String key = name.toString();
    	    String value = mapOfElements.get(name).toString();
    	    
    	}
	    List<String> elements = new ArrayList<String>(mapOfElements.keySet());
	    List<String> description = new ArrayList<String>(mapOfElements.values());
	    ExcelUtility.writeStringValueIntoExcel("Passed items",elements,description);
		  
	}
	
	@SuppressWarnings("deprecation")
	public void findAndPrintViolations(String levelOfConformance) throws IOException 
	{
	    AxeRunOnlyOptions runOnlyOptions = new AxeRunOnlyOptions();	    
	    runOnlyOptions.setValues(Arrays.asList(levelOfConformance));
	    AxeRunOptions options = new AxeRunOptions();    
	    AxeBuilder axe = new AxeBuilder().withOptions(options);
	   // Results result = axe.analyze(getWebDriver());
	    Results result = axe.setLegacyMode().analyze(getWebDriver());
	    FailedListSize=(result.getViolations().size());
	    for (Rule r : result.getViolations()) {
	    	for(CheckedNode l:(r.getNodes()))
	    	{
		    	FailedCompleteResult.put("CSS element= "+l.getTarget(),"Description= "+r.getHelp());
		    	mapOfElements.put(l.getTarget().toString(),r.getHelp());
	    	}   
	        }
	    for (String name: mapOfElements.keySet()) {
    	    String key = name.toString();
    	    String value = mapOfElements.get(name).toString();
    	    
    	}
	    List<String> elements = new ArrayList<String>(mapOfElements.keySet());
	    List<String> description = new ArrayList<String>(mapOfElements.values());
	    ExcelUtility.writeStringValueIntoExcel("Violation items",elements,description);
		  
	    }
	
	@SuppressWarnings("deprecation")
	public void findAndPrintReviews(String levelOfConformance) throws IOException 
	{
	    AxeRunOnlyOptions runOnlyOptions = new AxeRunOnlyOptions();
	    
	    runOnlyOptions.setValues(Arrays.asList(levelOfConformance));
	    AxeRunOptions options = new AxeRunOptions();

 
	    AxeBuilder axe = new AxeBuilder().withOptions(options);
	    Results result = axe.setLegacyMode().analyze(getWebDriver());
	    //Results result = axe.analyze(getWebDriver());
	    IncompleteListSize=(result.getIncomplete().size());
	    for (Rule r : result.getIncomplete()) {
	    	for(CheckedNode l:(r.getNodes()))
	    	{
	    		IncompleteCompleteResult.put("CSS element= "+l.getTarget(),"Description= "+r.getHelp());
		    	mapOfElements.put(l.getTarget().toString(),r.getHelp());
	    	}   
	        }
	    for (String name: mapOfElements.keySet()) {
    	    String key = name.toString();
    	    String value = mapOfElements.get(name).toString();
    	    
    	}
	    List<String> elements = new ArrayList<String>(mapOfElements.keySet());
	    List<String> description = new ArrayList<String>(mapOfElements.values());
	    ExcelUtility.writeStringValueIntoExcel("Incomplete items",elements,description);
		 
	}
	
	@SuppressWarnings("deprecation")
	public void findAndPrintInapplicable(String levelOfConformance) throws IOException 
	{
	    AxeRunOnlyOptions runOnlyOptions = new AxeRunOnlyOptions();
	    
	    runOnlyOptions.setValues(Arrays.asList(levelOfConformance));
	    AxeRunOptions options = new AxeRunOptions();
	    
	    AxeBuilder axe = new AxeBuilder().withOptions(options);
	    Results result = axe.setLegacyMode().analyze(getWebDriver());
	    //Results result = axe.analyze(getWebDriver());
	    InapplicableListSize=(result.getInapplicable().size());
	    for (Rule r : result.getInapplicable()) {
	    	for(CheckedNode l:(r.getNodes()))
	    	{
	    		InapplicableCompleteResult.put("CSS element= "+l.getTarget(),"Description= "+r.getHelp());
		    	mapOfElements.put(l.getTarget().toString(),r.getHelp());
	    	}   
	        }
	    for (String name: mapOfElements.keySet()) {
    	    String key = name.toString();
    	    String value = mapOfElements.get(name).toString();
    	    
    	}
	    List<String> elements = new ArrayList<String>(mapOfElements.keySet());
	    List<String> description = new ArrayList<String>(mapOfElements.values());
	    ExcelUtility.writeStringValueIntoExcel("Inapplicable items",elements,description);	 
	}
	@SuppressWarnings("deprecation")
	public void findAndPrintViolations(String levelOfConformance,String ruleToBeChecked) throws IOException 
	{
		List<String> rule=new ArrayList<>();
		rule.add(ruleToBeChecked);
	    AxeRunOnlyOptions runOnlyOptions = new AxeRunOnlyOptions();	    
	    runOnlyOptions.setValues(Arrays.asList(levelOfConformance));
	    AxeRunOptions options = new AxeRunOptions();    
	    AxeBuilder axe = new AxeBuilder().withOptions(options);
	    axe.withRules(rule);
	    Results result = axe.setLegacyMode().analyze(getWebDriver());
	    //Results result = axe.analyze(getWebDriver());
	    FailedListSize=(result.getViolations().size());
	    for (Rule r : result.getViolations()) {
	    	for(CheckedNode l:(r.getNodes()))
	    	{
		    	FailedCompleteResult.put("CSS element= "+l.getTarget(),"Description= "+r.getHelp());
		    	mapOfElements.put(l.getTarget().toString(),r.getHelp());
	    	}   
	        }
	    for (String name: mapOfElements.keySet()) {
    	    String key = name.toString();
    	    String value = mapOfElements.get(name).toString();
    	    
    	}
	    List<String> elements = new ArrayList<String>(mapOfElements.keySet());
	    List<String> description = new ArrayList<String>(mapOfElements.values());
	    ExcelUtility.writeStringValueIntoExcel("Violation items",elements,description);
	    }
	
}