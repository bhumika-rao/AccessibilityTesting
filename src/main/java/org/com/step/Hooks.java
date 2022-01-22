package org.com.step;

import java.util.LinkedHashMap;

import org.com.runner.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks extends BaseClass{
	public static String[] reportDateOTR=new String[1000];
	public static String[] reportDateAndTimeOTR=new String[1000];
	
	@Before
	public void cucumberBefore(Scenario scenario)
	{
		int id=(int)Thread.currentThread().getId();
		System.out.println("Before TestCase Method, Thread id="+id);
		/*ScreenshotCounter[id]=1;
		FailedDescription[id]="";
		ExceptionName[id]=" ";
		ExceptionMessage[id]=" ";
	
		SimpleDateFormat dateFormat=new SimpleDateFormat("MM_dd_YYYY");
		Date today;
		today=Calendar.getInstance().getTime();
		reportDateOTR[id]=dateFormat.format(today);
		
		//genericUtilities=new GenericUtilities();
		//document[id]=new XWPFDocument();
		TestExecutionStartTime=System.currentTimeMillis();
		String ScenarioName=scenario.getName();
		Scenario_Name[id]=scenario.getName();*/
		//genericUtilities.createOTR(Scenario_Name[id]);
		logger.info("----------------------------------------------");
		logger.info(Scenario_Name[id]);
	}
	
	private void reporting(Scenario scenario)
	{
		int id=(int)Thread.currentThread().getId();
		String ScenarioName=scenario.getName();
	}
	
	@After
	public void cucumberAfter(Scenario scenario)
	{
		int id=(int)Thread.currentThread().getId();
		System.out.println("Before TestCase Method, Thread id="+id);
		scenario.log("**************************Result Logs**************************");
		if(!PassedCompleteResult.isEmpty())
		{
			scenario.log("Passed items list size: "+PassedListSize);
			for (String name: PassedCompleteResult.keySet()) {
			    String key = name.toString();
			    String value = PassedCompleteResult.get(name).toString();
			    scenario.log(key + "\n" + value);
			}
			//scenario.log("Passed items list size:"+PassedListSize[id]+"\n"+PassedCompleteResult[id]+"\n"+PassedTagsResult[id]+"\n"+PassedDescriptionResult[id]+"\n"+PassedHelpResult[id]);
			/*scenario.log(PassedCompleteResult[id]);
			scenario.log(PassedTagsResult[id]);
			scenario.log(PassedDescriptionResult[id]);
			scenario.log(PassedHelpResult[id]);*/
		}
		if(!FailedCompleteResult.isEmpty())
		{
			scenario.log("Failed items list size: "+FailedListSize);
			for (String name: FailedCompleteResult.keySet()) {
			    String key = name.toString();
			    String value = FailedCompleteResult.get(name).toString();
			    scenario.log(key + "\n" + value);
			}
			//scenario.log("Failed items list size:"+FailedListSize[id]+"\n"+FailedCompleteResult[id]+"\n"+FailedTagsResult[id]+"\n"+FailedDescriptionResult[id]+"\n"+FailedHelpResult[id]);			
		}
		if(!IncompleteCompleteResult.isEmpty())
		{
			scenario.log("Incomplete items list size: "+IncompleteListSize);
			for (String name: IncompleteCompleteResult.keySet()) {
			    String key = name.toString();
			    String value = IncompleteCompleteResult.get(name).toString();
			    scenario.log(key + "\n" + value);
			}
			//scenario.log("Incomplete items list size:"+IncompleteListSize[id]+"\n"+IncompleteCompleteResult[id]+"\n"+IncompleteTagsResult[id]+"\n"+IncompleteDescriptionResult[id]+"\n"+IncompleteHelpResult[id]);			
		}
		if(!InapplicableCompleteResult.isEmpty())
		{
			scenario.log("Inapplicable items list size: "+InapplicableListSize);
			for (String name: InapplicableCompleteResult.keySet()) {
			    String key = name.toString();
			    String value = InapplicableCompleteResult.get(name).toString();
			    scenario.log(key + "\n" + value);
			}
			//scenario.log("Inapplicable items list size:"+InapplicableListSize[id]+"\n"+InapplicableCompleteResult[id]+"\n"+InapplicableTagsResult[id]+"\n"+InapplicableDescriptionResult[id]+"\n"+InapplicableHelpResult[id]);			
		}
		if(getWebDriver()!=null)
		{
			getWebDriver().quit();
		}
	}
}