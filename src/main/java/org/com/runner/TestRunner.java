package org.com.runner;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;
import java.lang.reflect.Method;
import org.testng.ITest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(features="src//main//java//org//com//featureFiles",
				tags= "@Test1",
				dryRun=false,
				glue="org.com.step",
				plugin= {"pretty","html:target/cucumber-reports/cucumber.html","json:target/cucumber-reports/cucumber.json"},
				monochrome=true)

public class TestRunner implements ITest
{
	private TestNGCucumberRunner testNGCucumberRunner;
	private static BaseClass baseClass;
	private ThreadLocal<String> testName=new ThreadLocal<String>();
	
	public String getTestName()
	{
		return testName.get();
	}
	
	@BeforeClass(alwaysRun=false)
	public void beforeClass()
	{
		baseClass=new BaseClass();
		//baseClass.initBeforeClass();
		testNGCucumberRunner=new TestNGCucumberRunner(this.getClass());
		//BasicConfigurator.configure();
	}
	
	@AfterClass
	public void tearDown()
	{
		//Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
		
		testNGCucumberRunner.finish();
		//baseClass.quitBrowsers();
	}
	
	@BeforeMethod
	public void beforeMethod(Method method,Object[] testData)
	{
		String testname=testData[0].toString();
		testName.set(testname);
	}
	
	@Test(groups="cucumber scenarios",dataProvider="scenarios")
	public void scenario(PickleWrapper pickleEvent, FeatureWrapper cucumberFeature) throws Throwable
	{
		testNGCucumberRunner.runScenario(pickleEvent.getPickle());
	}
	
	@DataProvider(parallel=false)
	public Object[][] scenarios()
	{
		testNGCucumberRunner=new TestNGCucumberRunner(this.getClass());
		return testNGCucumberRunner.provideScenarios();
	}
}
/*
 * File to run the TestNG tests
 */
/*public class TestRunner{
	public static WebDriver driver; 
	protected final static String URL="https://www.google.com/";
	
	@BeforeSuite
	public void initialize() throws IOException{
		/*System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\setup\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
	}
	
	@AfterSuite
	public void TeardownTest()
    {
        TestRunner.driver.quit();
    }
	@Test
	public void init() throws Exception{

		CheckAccessibility checkAccessibilityObject=PageFactory.initElements(driver, CheckAccessibility.class);
		checkAccessibilityObject.checkAccessibility();
		
		}
}*/