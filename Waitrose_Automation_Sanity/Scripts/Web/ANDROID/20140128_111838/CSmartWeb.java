import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.iphone.IPhoneDriver;
import org.openqa.selenium.support.ui.Select;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.File;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.ArrayList;
import org.junit.BeforeClass;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.Augmenter;

import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
public class CSmartWeb{

	private WebDriver driver =null;
	private File reportFile = null;
	private WebDriverWait driverWait= null;
	private static DocumentBuilderFactory documentBuilderFactory;
	private static DocumentBuilder documentBuilder;
	private static Document document;
	private static Element testcasesElement;
	private static Element testcaseElement;
	private static Element iterationsElement;
	private static Element iterationElement;
	private static final int SET=0;
	private static final int CLICK=1;
	private static final int VERIFY=2;
	private static final int WAIT=3;
	private static final int LOADPAGE=4;
	private static final int VERIFYOBJECT=5;
	private static final int GET=6;
	private static final int SETVALUE=7;
	private static final int IS_ENABLED=8;
	private static final int GETVALUES=9;
	private static final int VERIFYVALUES=10;
	private static final int IS_SELECTED=11;
	private static final int WAITFOROBJECT=12;
	private static final int PASS=0;
	private static final int FAIL=1;
	private static final int COMPLETED=2;
	private static final int ERROR=3;
	private static Calendar calendar;
	private static SimpleDateFormat dateFormat;
	private int verifications=0;
	private int actionspasscount=0;
	private int actionscompletedCount=0;
	private int actionsCount=0;
	private int iterationspasscount=0;
	private int iterationsfailcount=0;
	private int iterationscompletedcount=0;
	private int iterationCount=0;
	private static String screenshot_path="/Users/StaplesMac/Desktop/New_Workspace/Waitrose_Automation_Sanity_1/Reports/Web/ANDROID";
	private static String current_testcase_name="";
	private static SimpleDateFormat screenshotFormat;
	private static String SELECT_TAG="select";
	private static String TESTCASE_SEPERATOR = "_testcaseSeperator_";
	private static String TESTCASE_INFO_SEPERATOR = "_testcaseInfoSeperator_";
	private static String ITERATION_SEPERATOR = "_iterationSeperator_";
	private static String ITERATION_INFO_SEPERATOR = "_iterationInfoSeperator_";
	private static String ACTION_SEPERATOR = "_actionSeperator_";
	private static String ACTION_INFO_SEPERATOR = "_actionInfoSeperator_";
	

	//Class Constructor
	public CSmartWeb() throws Exception {
		try{
		//initialize the AndroidDriver for executing in Android platform
		DesiredCapabilities capabilities = DesiredCapabilities.android();
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		driver = new AndroidDriver(new URL("http://localhost:"+getDataFromConfiguration("port","/Users/StaplesMac/Desktop/New_Workspace/Waitrose_Automation_Sanity_1/config.xml")+"/wd/hub"),capabilities);
		createReportDirectory();
		reportFile = new File(screenshot_path+""+File.separator+"Master.xml");
		reportFile.createNewFile();
		}catch(Exception e){
		e.printStackTrace();
		}
	}

	private static void putInitialVariablesInString(){
		Element platformElement = document.createElement("platform");
		platformElement.setAttribute("name", "Web");
		document.appendChild(platformElement);
		testcasesElement = document.createElement("test-cases");
		platformElement.appendChild(testcasesElement);
		Element testinfoElement = document.createElement("test-info");
		platformElement.appendChild(testinfoElement);
		Element mobileSdkElement = document.createElement("mobile-sdk");
		Element mobileOsElement = document.createElement("mobile-os");
		Element dateElement = document.createElement("date");
		Element startTimeElement = document.createElement("start-time");
		Element endTimeElement = document.createElement("end-time");
		Element deviceVersionElement = document.createElement("device-version");
		Element appinfoElement = document.createElement("application-info");
		testinfoElement.appendChild(mobileSdkElement);
		testinfoElement.appendChild(mobileOsElement);
		testinfoElement.appendChild(dateElement);
		testinfoElement.appendChild(startTimeElement);
		testinfoElement.appendChild(endTimeElement);
		testinfoElement.appendChild(deviceVersionElement);
		testinfoElement.appendChild(appinfoElement);
	}

	//Used to save the report
	private void saveReport(){
		try{
		System.out.println("Updating the report file at "+reportFile.getAbsolutePath());
		TransformerFactory transformerFactory=TransformerFactory.newInstance();
		Transformer transformer=transformerFactory.newTransformer();
		DOMSource domSource=new DOMSource(document);
		StreamResult result=new StreamResult(reportFile);
		transformer.transform(domSource, result);
		}catch(Exception e){
		e.printStackTrace();
		}
	}

	@Test//test method for the SanityTestSuiteTC1_DeliveryCheckout_EditOrderConfirmation
	public void testSanityTestSuiteTC1_DeliveryCheckout_EditOrderConfirmation() throws Exception {
		String testcaseStatus="";
		current_testcase_name="TC1_DeliveryCheckout_EditOrderConfirmation";
		iterationspasscount=0;
		iterationsfailcount=0;
		iterationscompletedcount=0;
		iterationCount=0;
		int status=-1;
		testcaseElement = createTestcaseElement("TC1_DeliveryCheckout_EditOrderConfirmation","SanityTestSuite");

		status=SanityTestSuiteTC1_DeliveryCheckout_EditOrderConfirmationIteration0(iterationCount);
		iterationCount++;
		updateIterationCounters(status);
		
		if(iterationsfailcount>0){
		testcaseStatus="fail";
		}
		else if(iterationspasscount==iterationCount){
		testcaseStatus="pass";
		}
		else{
		testcaseStatus="completed";
		}

		testcaseElement.setAttribute("testcase-description", "User should be able to book a slot and perform a delivery checkout. User should be able to edit the order from order confirmation page.");
		testcaseElement.setAttribute("expected-value", "User should be able to book a slot and perform a delivery checkout. User should be able to edit the order from order confirmation page.");
		testcaseElement.setAttribute("status", testcaseStatus);
		testcaseElement.setAttribute("end-time",dateFormat.format(Calendar.getInstance().getTime()) );
		testcasesElement.appendChild(testcaseElement);
	}


	@Test//test method for the SanityTestSuiteTC2_ProductSearch
	public void testSanityTestSuiteTC2_ProductSearch() throws Exception {
		String testcaseStatus="";
		current_testcase_name="TC2_ProductSearch";
		iterationspasscount=0;
		iterationsfailcount=0;
		iterationscompletedcount=0;
		iterationCount=0;
		int status=-1;
		testcaseElement = createTestcaseElement("TC2_ProductSearch","SanityTestSuite");

		status=SanityTestSuiteTC2_ProductSearchIteration0(iterationCount);
		iterationCount++;
		updateIterationCounters(status);
		
		if(iterationsfailcount>0){
		testcaseStatus="fail";
		}
		else if(iterationspasscount==iterationCount){
		testcaseStatus="pass";
		}
		else{
		testcaseStatus="completed";
		}

		testcaseElement.setAttribute("testcase-description", "User able to search the items using keyword search from the home page for Groceries/Entertaining/Recipes");
		testcaseElement.setAttribute("expected-value", "User able to search the items using keyword search from the home page for Groceries/Entertaining/Recipes");
		testcaseElement.setAttribute("status", testcaseStatus);
		testcaseElement.setAttribute("end-time",dateFormat.format(Calendar.getInstance().getTime()) );
		testcasesElement.appendChild(testcaseElement);
	}


	@Test//test method for the SanityTestSuiteTC3_CollectionCheckout_MyOrderEdit_EmptyTrolley
	public void testSanityTestSuiteTC3_CollectionCheckout_MyOrderEdit_EmptyTrolley() throws Exception {
		String testcaseStatus="";
		current_testcase_name="TC3_CollectionCheckout_MyOrderEdit_EmptyTrolley";
		iterationspasscount=0;
		iterationsfailcount=0;
		iterationscompletedcount=0;
		iterationCount=0;
		int status=-1;
		testcaseElement = createTestcaseElement("TC3_CollectionCheckout_MyOrderEdit_EmptyTrolley","SanityTestSuite");

		status=SanityTestSuiteTC3_CollectionCheckout_MyOrderEdit_EmptyTrolleyIteration0(iterationCount);
		iterationCount++;
		updateIterationCounters(status);
		
		if(iterationsfailcount>0){
		testcaseStatus="fail";
		}
		else if(iterationspasscount==iterationCount){
		testcaseStatus="pass";
		}
		else{
		testcaseStatus="completed";
		}

		testcaseElement.setAttribute("testcase-description", "User should be able to book a slot and perform a collection checkout. User should be able to Empty Trolley.");
		testcaseElement.setAttribute("expected-value", "User should be able to book a slot and perform a collection checkout. User should be able to Empty Trolley.");
		testcaseElement.setAttribute("status", testcaseStatus);
		testcaseElement.setAttribute("end-time",dateFormat.format(Calendar.getInstance().getTime()) );
		testcasesElement.appendChild(testcaseElement);
	}


	@Test//test method for the SanityTestSuiteTC4_ProductTaxonomy
	public void testSanityTestSuiteTC4_ProductTaxonomy() throws Exception {
		String testcaseStatus="";
		current_testcase_name="TC4_ProductTaxonomy";
		iterationspasscount=0;
		iterationsfailcount=0;
		iterationscompletedcount=0;
		iterationCount=0;
		int status=-1;
		testcaseElement = createTestcaseElement("TC4_ProductTaxonomy","SanityTestSuite");

		status=SanityTestSuiteTC4_ProductTaxonomyIteration0(iterationCount);
		iterationCount++;
		updateIterationCounters(status);
		
		if(iterationsfailcount>0){
		testcaseStatus="fail";
		}
		else if(iterationspasscount==iterationCount){
		testcaseStatus="pass";
		}
		else{
		testcaseStatus="completed";
		}

		testcaseElement.setAttribute("testcase-description", "User able to view PLP and  PDP via Groceries and Entertaining taxonomy from Menu");
		testcaseElement.setAttribute("expected-value", "User able to view PLP and  PDP via Groceries and Entertaining taxonomy from Menu");
		testcaseElement.setAttribute("status", testcaseStatus);
		testcaseElement.setAttribute("end-time",dateFormat.format(Calendar.getInstance().getTime()) );
		testcasesElement.appendChild(testcaseElement);
	}


	@Test//test method for the SanityTestSuiteTC5_MyWaitroseRegistration
	public void testSanityTestSuiteTC5_MyWaitroseRegistration() throws Exception {
		String testcaseStatus="";
		current_testcase_name="TC5_MyWaitroseRegistration";
		iterationspasscount=0;
		iterationsfailcount=0;
		iterationscompletedcount=0;
		iterationCount=0;
		int status=-1;
		testcaseElement = createTestcaseElement("TC5_MyWaitroseRegistration","SanityTestSuite");

		status=SanityTestSuiteTC5_MyWaitroseRegistrationIteration0(iterationCount);
		iterationCount++;
		updateIterationCounters(status);
		
		if(iterationsfailcount>0){
		testcaseStatus="fail";
		}
		else if(iterationspasscount==iterationCount){
		testcaseStatus="pass";
		}
		else{
		testcaseStatus="completed";
		}

		testcaseElement.setAttribute("testcase-description", "myWaitrose registration should be successful");
		testcaseElement.setAttribute("expected-value", "myWaitrose registration should be successful");
		testcaseElement.setAttribute("status", testcaseStatus);
		testcaseElement.setAttribute("end-time",dateFormat.format(Calendar.getInstance().getTime()) );
		testcasesElement.appendChild(testcaseElement);
	}


	@Test//test method for the SanityTestSuiteTC6_LightRegistration
	public void testSanityTestSuiteTC6_LightRegistration() throws Exception {
		String testcaseStatus="";
		current_testcase_name="TC6_LightRegistration";
		iterationspasscount=0;
		iterationsfailcount=0;
		iterationscompletedcount=0;
		iterationCount=0;
		int status=-1;
		testcaseElement = createTestcaseElement("TC6_LightRegistration","SanityTestSuite");

		status=SanityTestSuiteTC6_LightRegistrationIteration0(iterationCount);
		iterationCount++;
		updateIterationCounters(status);
		
		if(iterationsfailcount>0){
		testcaseStatus="fail";
		}
		else if(iterationspasscount==iterationCount){
		testcaseStatus="pass";
		}
		else{
		testcaseStatus="completed";
		}

		testcaseElement.setAttribute("testcase-description", "Light Registration should be successful");
		testcaseElement.setAttribute("expected-value", "Light Registration should be successful");
		testcaseElement.setAttribute("status", testcaseStatus);
		testcaseElement.setAttribute("end-time",dateFormat.format(Calendar.getInstance().getTime()) );
		testcasesElement.appendChild(testcaseElement);
	}


	@Test//test method for the SanityTestSuiteTC7_BranchFinder
	public void testSanityTestSuiteTC7_BranchFinder() throws Exception {
		String testcaseStatus="";
		current_testcase_name="TC7_BranchFinder";
		iterationspasscount=0;
		iterationsfailcount=0;
		iterationscompletedcount=0;
		iterationCount=0;
		int status=-1;
		testcaseElement = createTestcaseElement("TC7_BranchFinder","SanityTestSuite");

		status=SanityTestSuiteTC7_BranchFinderIteration0(iterationCount);
		iterationCount++;
		updateIterationCounters(status);
		
		if(iterationsfailcount>0){
		testcaseStatus="fail";
		}
		else if(iterationspasscount==iterationCount){
		testcaseStatus="pass";
		}
		else{
		testcaseStatus="completed";
		}

		testcaseElement.setAttribute("testcase-description", "User able to search by town or postcode  and able to set My Branch");
		testcaseElement.setAttribute("expected-value", "User able to search by town or postcode  and able to set My Branch");
		testcaseElement.setAttribute("status", testcaseStatus);
		testcaseElement.setAttribute("end-time",dateFormat.format(Calendar.getInstance().getTime()) );
		testcasesElement.appendChild(testcaseElement);
		saveReport();
	}


	//method Definition for the SanityTestSuiteTC1_DeliveryCheckout_EditOrderConfirmationIteration0
	public int SanityTestSuiteTC1_DeliveryCheckout_EditOrderConfirmationIteration0(int iterationCnt){
		int status;
		verifications=0;
		actionspasscount=0;
		actionscompletedCount=0;
		actionsCount=0;
		iterationElement = createIterationElement(iterationCnt);
		//Load a new web page in the current browser window, with the specified Url
		System.out.println("Loading the url - https://wtr-mob-acpt.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html");
		iterationElement.appendChild(createActionElement( executeAction(LOADPAGE, "https://wtr-mob-acpt.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html", true, "",""),"1","URL","https://wtr-mob-test4.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html","PAGELOAD"));
		iterationElement.appendChild(createActionElement( executeAction(LOADPAGE, "https://wtr-mob-acpt.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html", true, "",""),"1","URL","https://wtr-mob-test4.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html","PAGELOAD"));

		System.out.println("Executing	Action-CLICK		Xpath-//span[@id='dojox_mob ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[@id='dojox_mobile_ToolBarButton_5']",""),"2","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"3","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[contains(text() ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[contains(text(),'Home')]",""),"4","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"5","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//span[@id='dojox_mob ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[@id='dojox_mobile_ToolBarButton_5']",""),"6","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"7","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[contains(text() ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[contains(text(),'Book Slot')]",""),"8","DIV","","CLICK" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//h1[text()='Book Slo ... 		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//h1[text()='Book Slot']",""),"9","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"10","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[contains(text() ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[contains(text(),'We Deliver')]",""),"11","DIV","","CLICK" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//h1[text()='Login']		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//h1[text()='Login']",""),"12","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"13","","","WAIT" ));

		System.out.println("Executing	Action-SET		Xpath-//input[@id='dojox_mo ... 		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "autoteam1@wtr-test.net", false, "//input[@id='dojox_mobile_TextBox_0']",""),"14","INPUT","autoteam1@wtr-test.net","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"15","","","WAIT" ));

		System.out.println("Executing	Action-SET		Xpath-//input[@id='dojox_mo ... 		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "test1234", false, "//input[@id='dojox_mobile_TextBox_1']",""),"16","INPUT","test1234","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"17","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[contains(tex ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[contains(text(),'Login')]",""),"18","BUTTON","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"19","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[@id='dojox_m ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[@id='dojox_mobile_Button_47']",""),"20","BUTTON","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"21","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//span[@id='dojox_mob ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[@id='dojox_mobile_ToolBarButton_13']",""),"22","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"23","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//span[@id='dojox_mob ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[@id='dojox_mobile_ToolBarButton_13']",""),"24","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"25","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[@id='waitrose_w ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[@id='waitrose_widgets_CalendarIcon_115']",""),"26","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"27","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[@id='waitrose_w ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[@id='waitrose_widgets_AvailableTimes_4']",""),"28","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"29","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[@id='dojox_m ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[@id='dojox_mobile_Button_59']",""),"30","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"31","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//div[text()='Your sl ... 		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[text()='Your slot is reserved for 2 hrs']",""),"32","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"33","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[text()='Star ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[text()='Start Shopping']",""),"34","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"35","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//img[@data-dojo-atta ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//img[@data-dojo-attach-event='click:_goHome']",""),"36","IMG","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"37","","","WAIT" ));

		System.out.println("Executing	Action-SET		Xpath-//div[@id='waitrose/w ... 		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "Waitrose Free Range Chicken", false, "//div[@id='waitrose/widgets/Heading_0']//input[@placeholder='Search']",""),"38","INPUT","Waitrose Free Range Chicken","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"39","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[@id='waitrose/w ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[@id='waitrose/widgets/Heading_0']//i",""),"40","I","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"41","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//span[text()='Add']		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[text()='Add']",""),"42","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"43","","","WAIT" ));

		System.out.println("Executing	Action-SET		Xpath-(//ul[@id='waitrose/w ... 		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "10", false, "(//ul[@id='waitrose/widgets/TaxonomyCategoryStoreList_0']//input[@data-dojo-attach-point='quantityNode'])[1]",""),"44","SPAN","10","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"45","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//img[@data-dojo-atta ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//img[@data-dojo-attach-event='click:_goHome']",""),"46","IMG","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"47","","","WAIT" ));

		System.out.println("Executing	Action-SET		Xpath-//div[@id='waitrose/w ... 		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "Waitrose lemon drizzle cake", false, "//div[@id='waitrose/widgets/Heading_0']//input[@placeholder='Search']",""),"48","INPUT","Waitrose lemon drizzle cake","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"49","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[@id='waitrose/w ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[@id='waitrose/widgets/Heading_0']//i",""),"50","I","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"51","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//li[@id='dojox_mobil ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//li[@id='dojox_mobile_TabBarButton_1']",""),"52","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"53","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-(//ul[@id='waitrose/w ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "(//ul[@id='waitrose/widgets/TaxonomyCategoryStoreList_1']//span[text()='Add'])[1]",""),"54","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"55","","","WAIT" ));

		System.out.println("Executing	Action-SET		Xpath-(//ul[@id='waitrose/w ... 		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "5", false, "(//ul[@id='waitrose/widgets/TaxonomyCategoryStoreList_1']//input[@data-dojo-attach-point='quantityNode'])[1]",""),"56","SPAN","5","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"57","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[@class='trolley ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[@class='trolleyIcon']",""),"58","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"59","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//div[text()='Trolley ... 		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[text()='Trolley']",""),"60","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"61","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[text()='Chec ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[text()='Checkout']",""),"62","TD","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"63","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//h1[text()='Checkout ... 		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//h1[text()='Checkout']",""),"64","INPUT","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"65","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[text()='Cont ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[text()='Continue to payment details']",""),"66","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"67","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//h3[contains(text(), ... 		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//h3[contains(text(),'Payment details')]",""),"68","BUTTON","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"69","","","WAIT" ));

		System.out.println("Executing	Action-SET		Xpath-//input[@id='dojox_mo ... 		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "4111111111111111", false, "//input[@id='dojox_mobile_TextBox_6']",""),"70","DIV","4111111111111111","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"71","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//select[@data-dojo-a ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//select[@data-dojo-attach-point='_validFromMonth']",""),"72","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"73","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//select[@data-dojo-a ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//select[@data-dojo-attach-point='_validFromMonth']/option[text()='03']",""),"74","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"75","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//select[@data-dojo-a ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//select[@data-dojo-attach-point='_validFromYear']",""),"76","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"77","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//select[@data-dojo-a ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//select[@data-dojo-attach-point='_validFromYear']/option[text()='11']",""),"78","IMG","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"79","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//select[@data-dojo-a ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//select[@data-dojo-attach-point='_validToMonth']",""),"80","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"81","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//select[@data-dojo-a ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//select[@data-dojo-attach-point='_validToMonth']",""),"82","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"83","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//select[@data-dojo-a ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//select[@data-dojo-attach-point='_validToYear']",""),"84","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"85","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//select[@data-dojo-a ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//select[@data-dojo-attach-point='_validToYear']",""),"86","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"87","","","WAIT" ));

		System.out.println("Executing	Action-SET		Xpath-//input[@data-dojo-at ... 		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "KathyJones", false, "//input[@data-dojo-attach-point='_enterName']",""),"88","BUTTON","KathyJones","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"89","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[text()='Plac ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[text()='Place your order']",""),"90","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"91","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//h3[contains(text(), ... 		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//h3[contains(text(),'Order confirmation')]",""),"92","BUTTON","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"93","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//div[text()='Your or ... 		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[text()='Your order is confirmed']",""),"94","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"95","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[text()='Edit ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[text()='Edit order']",""),"96","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"97","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//h1[text()='My Order ... 		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//h1[text()='My Orders']",""),"98","BUTTON","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"99","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[text()='Order S ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[text()='Order Status: Pending']",""),"100","H1","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"101","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[text()='Edit ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[text()='Edit order']",""),"102","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"103","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[@class='dial ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[@class='dialogButton'][text()='Edit order'] ",""),"104","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"105","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//span[text()='Contin ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[text()='Continue shopping']",""),"106","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"107","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//img[@data-dojo-atta ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//img[@data-dojo-attach-event='click:_goHome']",""),"108","IMG","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"109","","","WAIT" ));

		System.out.println("Executing	Action-SET		Xpath-//div[@id='waitrose/w ... 		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "Organic Garlic", false, "//div[@id='waitrose/widgets/Heading_0']//input[@placeholder='Search']",""),"110","INPUT","Organic Garlic","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"111","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[@id='waitrose/w ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[@id='waitrose/widgets/Heading_0']//i",""),"112","I","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"113","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//span[text()='Add']		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[text()='Add']",""),"114","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"115","","","WAIT" ));

		System.out.println("Executing	Action-SET		Xpath-(//ul[@id='waitrose/w ... 		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "10", false, "(//ul[@id='waitrose/widgets/TaxonomyCategoryStoreList_0']//input[@data-dojo-attach-point='quantityNode'])[1]",""),"116","SPAN","10","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"117","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[@class='trolley ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[@class='trolleyIcon']",""),"118","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"119","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//div[text()='Trolley ... 		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[text()='Trolley']",""),"120","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"121","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[text()='Chec ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[text()='Checkout']",""),"122","TD","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"123","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//h1[text()='Checkout ... 		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//h1[text()='Checkout']",""),"124","INPUT","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"125","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[text()='Cont ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[text()='Continue to payment details']",""),"126","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"127","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//h3[contains(text(), ... 		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//h3[contains(text(),'Payment details')]",""),"128","BUTTON","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"129","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[text()='Plac ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[text()='Place your order']",""),"130","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"131","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//h3[contains(text(), ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//h3[contains(text(),'Order confirmation')]",""),"132","BUTTON","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"133","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[@data-dojo-a ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[@data-dojo-attach-point='_editShopAgainButtonNode']",""),"134","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"135","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//img[@data-dojo-atta ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//img[@data-dojo-attach-event='click:_goHome']",""),"136","IMG","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"137","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//span[@id='dojox_mob ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[@id='dojox_mobile_ToolBarButton_5']",""),"138","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"139","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[contains(text() ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[contains(text(),'Logout')]",""),"140","DIV","","CLICK" ));
		if(verifications==0){
			if(actionsCount==actionscompletedCount){
			status=COMPLETED;
		}
		else{
			status=FAIL;
		}
		}
		else{
			if(verifications==actionspasscount){
			status=PASS;
		}
		else{
			status=FAIL;
		}
		}
		iterationElement.setAttribute("iteration-status", getStatus(status));
		iterationElement.setAttribute("end-time", dateFormat.format(Calendar.getInstance().getTime()));
		iterationsElement.appendChild(iterationElement);
		return status;
		}

	//method Definition for the SanityTestSuiteTC2_ProductSearchIteration0
	public int SanityTestSuiteTC2_ProductSearchIteration0(int iterationCnt){
		int status;
		verifications=0;
		actionspasscount=0;
		actionscompletedCount=0;
		actionsCount=0;
		iterationElement = createIterationElement(iterationCnt);
		//Load a new web page in the current browser window, with the specified Url
		System.out.println("Loading the url - https://wtr-mob-test4.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html");
		iterationElement.appendChild(createActionElement( executeAction(LOADPAGE, "https://wtr-mob-test4.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html", true, "",""),"1","URL","https://wtr-mob-test4.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html","PAGELOAD"));
		iterationElement.appendChild(createActionElement( executeAction(LOADPAGE, "https://wtr-mob-test4.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html", true, "",""),"1","URL","https://wtr-mob-test4.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html","PAGELOAD"));

		System.out.println("Executing	Action-CLICK		Xpath-//span[@id='dojox_mob ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[@id='dojox_mobile_ToolBarButton_5']",""),"2","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"3","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[contains(text() ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[contains(text(),'Home')]",""),"4","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"5","","","WAIT" ));

		System.out.println("Executing	Action-SET		Xpath-//div[@id='waitrose/w ... 		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "Turkey", false, "//div[@id='waitrose/widgets/Heading_0']//input[@placeholder='Search']",""),"6","INPUT","Turkey","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"7","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[@id='waitrose/w ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[@id='waitrose/widgets/Heading_0']//i",""),"8","I","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"9","","","WAIT" ));

		System.out.println("Executing	Action-VERIFY		Xpath-(//span[@class='produ ... 		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFY, "turkey", false, "(//span[@class='productName'])[1]",""),"10","SPAN","turkey","VERIFY" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"11","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//li[@id='dojox_mobil ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//li[@id='dojox_mobile_TabBarButton_1']",""),"12","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"13","","","WAIT" ));

		System.out.println("Executing	Action-VERIFY		Xpath-(//ul [@id='waitrose/ ... 		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFY, "turkey", false, "(//ul [@id='waitrose/widgets/TaxonomyCategoryStoreList_1']//span[@class='productName'])[1]",""),"14","SPAN","turkey","VERIFY" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"15","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[contains(text() ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[contains(text(),'Recipes')]",""),"16","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"17","","","WAIT" ));

		System.out.println("Executing	Action-VERIFY		Xpath-(//li[@class='mblList ... 		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFY, "Turkey", false, "(//li[@class='mblListItem RecipeListItem'])[1]",""),"18","DIV","Turkey","VERIFY" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"19","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//img[@data-dojo-atta ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//img[@data-dojo-attach-event='click:_goHome']",""),"20","IMG","","CLICK" ));
		if(verifications==0){
			if(actionsCount==actionscompletedCount){
			status=COMPLETED;
		}
		else{
			status=FAIL;
		}
		}
		else{
			if(verifications==actionspasscount){
			status=PASS;
		}
		else{
			status=FAIL;
		}
		}
		iterationElement.setAttribute("iteration-status", getStatus(status));
		iterationElement.setAttribute("end-time", dateFormat.format(Calendar.getInstance().getTime()));
		iterationsElement.appendChild(iterationElement);
		return status;
		}

	//method Definition for the SanityTestSuiteTC3_CollectionCheckout_MyOrderEdit_EmptyTrolleyIteration0
	public int SanityTestSuiteTC3_CollectionCheckout_MyOrderEdit_EmptyTrolleyIteration0(int iterationCnt){
		int status;
		verifications=0;
		actionspasscount=0;
		actionscompletedCount=0;
		actionsCount=0;
		iterationElement = createIterationElement(iterationCnt);
		//Load a new web page in the current browser window, with the specified Url
		System.out.println("Loading the url - https://wtr-mob-test4.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html");
		iterationElement.appendChild(createActionElement( executeAction(LOADPAGE, "https://wtr-mob-test4.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html", true, "",""),"1","URL","https://wtr-mob-test4.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html","PAGELOAD"));
		iterationElement.appendChild(createActionElement( executeAction(LOADPAGE, "https://wtr-mob-test4.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html", true, "",""),"1","URL","https://wtr-mob-test4.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html","PAGELOAD"));

		System.out.println("Executing	Action-CLICK		Xpath-//span[@id='dojox_mob ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[@id='dojox_mobile_ToolBarButton_5']",""),"2","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-3		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "3", true, "",""),"3","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[contains(text() ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[contains(text(),'Home')]",""),"4","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"5","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//span[@id='dojox_mob ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[@id='dojox_mobile_ToolBarButton_5']",""),"6","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"7","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[contains(text() ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[contains(text(),'Book Slot')]",""),"8","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"9","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[contains(text() ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[contains(text(),'You Collect')]",""),"10","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"11","","","WAIT" ));

		System.out.println("Executing	Action-SET		Xpath-//input[@placeholder= ... 		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "RG142DH", false, "//input[@placeholder='Enter town or full postcode']",""),"12","INPUT","RG142DH","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"13","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-(//button[contains(te ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "(//button[contains(text(),'Find')])[2]",""),"14","BUTTON","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"15","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-(//span[@class='branc ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "(//span[@class='branchName'])[1]",""),"16","SPAN","","CLICK" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//h1[text()='Login']		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//h1[text()='Login']",""),"17","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-SET		Xpath-//input[@id='dojox_mo ... 		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "autoteam5@wtr-test.net", false, "//input[@id='dojox_mobile_TextBox_0']",""),"18","INPUT","autoteam5@wtr-test.net","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"19","","","WAIT" ));

		System.out.println("Executing	Action-SET		Xpath-//input[@id='dojox_mo ... 		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "test1234", false, "//input[@id='dojox_mobile_TextBox_1']",""),"20","INPUT","test1234","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"21","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[contains(tex ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[contains(text(),'Login')]",""),"22","BUTTON","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"23","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//span[@id='dojox_mob ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[@id='dojox_mobile_ToolBarButton_13']",""),"24","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"25","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//span[@id='dojox_mob ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[@id='dojox_mobile_ToolBarButton_13']",""),"26","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"27","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[@id='waitrose_w ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[@id='waitrose_widgets_CalendarIcon_115']",""),"28","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"29","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[@id='waitrose_w ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[@id='waitrose_widgets_AvailableTimes_4']",""),"30","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"31","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[@id='dojox_m ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[@id='dojox_mobile_Button_58']",""),"32","BUTTON","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"33","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//div[text()='Your sl ... 		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[text()='Your slot is reserved for 2 hrs']",""),"34","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"35","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[text()='Star ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[text()='Start Shopping']",""),"36","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"37","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//img[@data-dojo-atta ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//img[@data-dojo-attach-event='click:_goHome']",""),"38","IMG","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"39","","","WAIT" ));

		System.out.println("Executing	Action-SET		Xpath-//div[@id='waitrose/w ... 		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "rankin selection Irish fruit soda bread", false, "//div[@id='waitrose/widgets/Heading_0']//input[@placeholder='Search']",""),"40","INPUT","rankin selection Irish fruit soda bread","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"41","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[@id='waitrose/w ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[@id='waitrose/widgets/Heading_0']//i",""),"42","I","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"43","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//span[text()='Add']		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[text()='Add']",""),"44","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"45","","","WAIT" ));

		System.out.println("Executing	Action-SET		Xpath-(//ul[@id='waitrose/w ... 		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "10", false, "(//ul[@id='waitrose/widgets/TaxonomyCategoryStoreList_0']//input[@data-dojo-attach-point='quantityNode'])[1]",""),"46","SPAN","10","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"47","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//img[@data-dojo-atta ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//img[@data-dojo-attach-event='click:_goHome']",""),"48","IMG","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"49","","","WAIT" ));

		System.out.println("Executing	Action-SET		Xpath-//div[@id='waitrose/w ... 		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "Double stuffed turkey breast", false, "//div[@id='waitrose/widgets/Heading_0']//input[@placeholder='Search']",""),"50","INPUT","Fiona Cairns Butterflies Birthday Cake","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"51","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[@id='waitrose/w ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[@id='waitrose/widgets/Heading_0']//i",""),"52","I","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"53","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//li[@id='dojox_mobil ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//li[@id='dojox_mobile_TabBarButton_1']",""),"54","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"55","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-(//ul[@id='waitrose/w ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "(//ul[@id='waitrose/widgets/TaxonomyCategoryStoreList_1']//span[text()='Add'])[1]",""),"56","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"57","","","WAIT" ));

		System.out.println("Executing	Action-SET		Xpath-(//ul[@id='waitrose/w ... 		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "2", false, "(//ul[@id='waitrose/widgets/TaxonomyCategoryStoreList_1']//input[@data-dojo-attach-point='quantityNode'])[1]",""),"58","SPAN","3","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"59","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[@class='trolley ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[@class='trolleyIcon']",""),"60","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"61","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//div[text()='Trolley ... 		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[text()='Trolley']",""),"62","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"63","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[text()='Chec ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[text()='Checkout']",""),"64","TD","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"65","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//h1[text()='Checkout ... 		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//h1[text()='Checkout']",""),"66","INPUT","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"67","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[text()='Cont ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[text()='Continue to payment details']",""),"68","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"69","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//h3[contains(text(), ... 		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//h3[contains(text(),'Payment details')]",""),"70","BUTTON","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"71","","","WAIT" ));

		System.out.println("Executing	Action-SET		Xpath-//input[@id='dojox_mo ... 		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "4111111111111111", false, "//input[@id='dojox_mobile_TextBox_5']",""),"72","INPUT","4111111111111111","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"73","","","WAIT" ));

		System.out.println("Executing	Action-SET		Xpath-//input[@id='dojox_mo ... 		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "4111111111111111", false, "//input[@id='dojox_mobile_TextBox_6']",""),"74","DIV","4111111111111111","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"75","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//select[@data-dojo-a ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//select[@data-dojo-attach-point='_validFromMonth']",""),"76","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"77","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//select[@data-dojo-a ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//select[@data-dojo-attach-point='_validFromMonth']/option[text()='03']",""),"78","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"79","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//select[@data-dojo-a ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//select[@data-dojo-attach-point='_validFromYear']",""),"80","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"81","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//select[@data-dojo-a ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//select[@data-dojo-attach-point='_validFromYear']/option[text()='11']",""),"82","IMG","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"83","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//select[@data-dojo-a ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//select[@data-dojo-attach-point='_validToMonth']",""),"84","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"85","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//select[@data-dojo-a ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//select[@data-dojo-attach-point='_validToMonth']",""),"86","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"87","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//select[@data-dojo-a ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//select[@data-dojo-attach-point='_validToYear']",""),"88","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"89","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//select[@data-dojo-a ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//select[@data-dojo-attach-point='_validToYear']/option[text()='17']",""),"90","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"91","","","WAIT" ));

		System.out.println("Executing	Action-SET		Xpath-//input[@data-dojo-at ... 		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "KathyJones", false, "//input[@data-dojo-attach-point='_enterName']",""),"92","BUTTON","KathyJones","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"93","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[text()='Plac ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[text()='Place your order']",""),"94","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"95","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//h3[contains(text(), ... 		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//h3[contains(text(),'Order confirmation')]",""),"96","BUTTON","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"97","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//div[text()='Your or ... 		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[text()='Your order is confirmed']",""),"98","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"99","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[text()='Edit ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[text()='Edit order']",""),"100","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"101","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[@data-dojo-a ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[@data-dojo-attach-point='_editShopAgainButtonNode']",""),"102","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"103","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[contains(tex ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[contains(text(),'My Orders')]",""),"104","BUTTON","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"105","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//h1[text()='My Order ... 		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//h1[text()='My Orders']",""),"106","BUTTON","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"107","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[text()='Order S ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[text()='Order Status: Pending']",""),"108","H1","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"109","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[text()='Edit ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[text()='Edit order']",""),"110","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"111","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[@class='dial ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[@class='dialogButton'][text()='Edit order'] ",""),"112","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"113","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//span[text()='Contin ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[text()='Continue shopping']",""),"114","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"115","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[@data-dojo-a ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[@data-dojo-attach-event='click:_emptyTrolley']",""),"116","BUTTON","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"117","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//p[@id='WLdialogBody ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//p[@id='WLdialogBody']/button[2]",""),"118","BUTTON","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"119","","","WAIT" ));

		System.out.println("Executing	Action-VERIFY		Xpath-//td[contains(text(), ... 		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFY, "0", false, "//td[contains(text(),'0')]",""),"120","TD","0","VERIFY" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"121","","","WAIT" ));

		System.out.println("Executing	Action-VERIFY		Xpath-//td[@data-dojo-attac ... 		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFY, "?0.00", false, "//td[@data-dojo-attach-point='totalNode']",""),"122","TD","?0.00","VERIFY" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"123","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//div[contains(text() ... 		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[contains(text(),'The minimum order value for delivery is £50')]",""),"124","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"125","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//img[@data-dojo-atta ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//img[@data-dojo-attach-event='click:_goHome']",""),"126","IMG","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"127","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//span[@id='dojox_mob ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[@id='dojox_mobile_ToolBarButton_5']",""),"128","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"129","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[contains(text() ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[contains(text(),'Logout')]",""),"130","DIV","","CLICK" ));
		if(verifications==0){
			if(actionsCount==actionscompletedCount){
			status=COMPLETED;
		}
		else{
			status=FAIL;
		}
		}
		else{
			if(verifications==actionspasscount){
			status=PASS;
		}
		else{
			status=FAIL;
		}
		}
		iterationElement.setAttribute("iteration-status", getStatus(status));
		iterationElement.setAttribute("end-time", dateFormat.format(Calendar.getInstance().getTime()));
		iterationsElement.appendChild(iterationElement);
		return status;
		}

	//method Definition for the SanityTestSuiteTC4_ProductTaxonomyIteration0
	public int SanityTestSuiteTC4_ProductTaxonomyIteration0(int iterationCnt){
		int status;
		verifications=0;
		actionspasscount=0;
		actionscompletedCount=0;
		actionsCount=0;
		iterationElement = createIterationElement(iterationCnt);
		//Load a new web page in the current browser window, with the specified Url
		System.out.println("Loading the url - https://wtr-mob-test4.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html");
		iterationElement.appendChild(createActionElement( executeAction(LOADPAGE, "https://wtr-mob-test4.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html", true, "",""),"1","URL","https://wtr-mob-test4.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html","PAGELOAD"));
		iterationElement.appendChild(createActionElement( executeAction(LOADPAGE, "https://wtr-mob-test4.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html", true, "",""),"1","URL","https://wtr-mob-test4.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html","PAGELOAD"));

		System.out.println("Executing	Action-CLICK		Xpath-//span[@id='dojox_mob ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[@id='dojox_mobile_ToolBarButton_5']",""),"2","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"3","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[contains(text() ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[contains(text(),'Home')]",""),"4","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"5","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//span[@id='dojox_mob ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[@id='dojox_mobile_ToolBarButton_5']",""),"6","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"7","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[contains(text() ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[contains(text(),'Shop Groceries')]",""),"8","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"9","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//h1[text()='Grocerie ... 		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//h1[text()='Groceries']",""),"10","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"11","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[contains(text() ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[contains(text(),'Food Cupboard')]",""),"12","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"13","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//h1[text()='Food Cup ... 		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//h1[text()='Food Cupboar...']",""),"14","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"15","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[contains(text() ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[contains(text(),'All Food Cupboard')]",""),"16","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"17","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//h1[text()='All Food ... 		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//h1[text()='All Food Cup...']",""),"18","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"19","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-(//span[@class='produ ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "(//span[@class='productName'])[1]",""),"20","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"21","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//h1[text()='Product  ... 		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//h1[text()='Product details']",""),"22","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"23","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//span[@id='dojox_mob ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[@id='dojox_mobile_ToolBarButton_5']",""),"24","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"25","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[contains(text() ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[contains(text(),'Shop Entertaining')]",""),"26","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"27","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[contains(text() ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[contains(text(),'Cakes')]",""),"28","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"29","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[contains(text() ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[contains(text(),'All Cakes')]",""),"30","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"31","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//span[contains(text( ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[contains(text(),'essential Waitrose white muffins')]",""),"32","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"33","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//h1[text()='Product  ... 		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//h1[text()='Product details']",""),"34","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"35","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//img[@data-dojo-atta ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//img[@data-dojo-attach-event='click:_goHome']",""),"36","IMG","","CLICK" ));
		if(verifications==0){
			if(actionsCount==actionscompletedCount){
			status=COMPLETED;
		}
		else{
			status=FAIL;
		}
		}
		else{
			if(verifications==actionspasscount){
			status=PASS;
		}
		else{
			status=FAIL;
		}
		}
		iterationElement.setAttribute("iteration-status", getStatus(status));
		iterationElement.setAttribute("end-time", dateFormat.format(Calendar.getInstance().getTime()));
		iterationsElement.appendChild(iterationElement);
		return status;
		}

	//method Definition for the SanityTestSuiteTC5_MyWaitroseRegistrationIteration0
	public int SanityTestSuiteTC5_MyWaitroseRegistrationIteration0(int iterationCnt){
		int status;
		verifications=0;
		actionspasscount=0;
		actionscompletedCount=0;
		actionsCount=0;
		iterationElement = createIterationElement(iterationCnt);
		//Load a new web page in the current browser window, with the specified Url
		System.out.println("Loading the url - https://wtr-mob-test4.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html");
		iterationElement.appendChild(createActionElement( executeAction(LOADPAGE, "https://wtr-mob-test4.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html", true, "",""),"1","URL","https://wtr-mob-test4.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html","PAGELOAD"));
		iterationElement.appendChild(createActionElement( executeAction(LOADPAGE, "https://wtr-mob-test4.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html", true, "",""),"1","URL","https://wtr-mob-test4.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html","PAGELOAD"));

		System.out.println("Executing	Action-CLICK		Xpath-//span[@id='dojox_mob ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[@id='dojox_mobile_ToolBarButton_5']",""),"2","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"3","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[contains(text() ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[contains(text(),'Home')]",""),"4","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"5","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//span[@id='dojox_mob ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[@id='dojox_mobile_ToolBarButton_5']",""),"6","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"7","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[@id='dojox_m ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[@id='dojox_mobile_Button_7']",""),"8","BUTTON","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"9","","","WAIT" ));

		System.out.println("Executing	Action-SET		Xpath-//input[@id='dojox_mo ... 		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "auto1test2@wtr-test.net", false, "//input[@id='dojox_mobile_TextBox_3']",""),"10","INPUT","auto1test2@wtr-test.net","SET" ));

		System.out.println("Executing	Action-SET		Xpath-//input[@id='dojox_mo ... 		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "test1234", false, "//input[@id='dojox_mobile_TextBox_4']",""),"11","INPUT","test1234","SET" ));

		System.out.println("Executing	Action-SET		Xpath-//input[@id='dojox_mo ... 		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "test1234", false, "//input[@id='dojox_mobile_TextBox_5']",""),"12","INPUT","test1234","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"13","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[text()='Regi ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[text()='Register']",""),"14","BUTTON","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"15","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//p[contains(text(),' ... 		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//p[contains(text(),'Congratulations - you have created a Waitrose.com account. Please provide us with some more information to complete your registration for myWaitrose.')]",""),"16","P","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"17","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[contains(tex ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[contains(text(),'Continue')]",""),"18","BUTTON","","CLICK" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//h1[text()='myWaitro ... 		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//h1[text()='myWaitrose']",""),"19","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-SET		Xpath-//input[@data-dojo-at ... 		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "auto1test2", false, "//input[@data-dojo-attach-point='_enterScreenName']",""),"20","INPUT","auto1test2","SET" ));

		System.out.println("Executing	Action-SET		Xpath-//input[@data-dojo-at ... 		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "Miss", false, "//input[@data-dojo-attach-point='_enterTitle']",""),"21","INPUT","Miss","SET" ));

		System.out.println("Executing	Action-SET		Xpath-//input[@data-dojo-at ... 		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "Janet", false, "//input[@data-dojo-attach-point='_enterFirstName']",""),"22","INPUT","Janet","SET" ));

		System.out.println("Executing	Action-SET		Xpath-//input[@data-dojo-at ... 		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "James", false, "//input[@data-dojo-attach-point='_enterLastName']",""),"23","INPUT","James","SET" ));

		System.out.println("Executing	Action-SET		Xpath-//input[@data-dojo-at ... 		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "Home", false, "//input[@data-dojo-attach-point='_addressNickname']",""),"24","INPUT","Home","SET" ));

		System.out.println("Executing	Action-SET		Xpath-//input[@data-dojo-at ... 		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "RG142DH", false, "//input[@data-dojo-attach-point='_enterPostcode']",""),"25","INPUT","RG142DH","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"26","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[contains(tex ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[contains(text(),'Find address')]",""),"27","BUTTON","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"28","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-(//li[@class='mblList ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "(//li[@class='mblListItem']/div[2]/span)[1]",""),"29","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"30","","","WAIT" ));

		System.out.println("Executing	Action-SET		Xpath-//input[@data-dojo-at ... 		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "6477200772", false, "//input[@data-dojo-attach-point='_enterPhone']",""),"31","INPUT","6477200772","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"32","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[@data-dojo-a ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[@data-dojo-attach-event='onClick:_register']",""),"33","BUTTON","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"34","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//p[contains(text(),' ... 		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//p[contains(text(),'You have successfully registered and can now start enjoying all the benefits of being a myWaitrose customer')]",""),"35","P","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"36","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[@data-dojo-a ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[@data-dojo-attach-event='onClick:_continue']",""),"37","BUTTON","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"38","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//span[@id='dojox_mob ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[@id='dojox_mobile_ToolBarButton_5']",""),"39","SPAN","","CLICK" ));

		System.out.println("Executing	Action-VERIFY		Xpath-//div[@ data-dojo-att ... 		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFY, "Janet james", false, "//div[@ data-dojo-attach-point='_loggedInWelcomeName']",""),"40","DIV","Janet james","VERIFY" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"41","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[contains(text() ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[contains(text(),'Logout')]",""),"42","DIV","","CLICK" ));
		if(verifications==0){
			if(actionsCount==actionscompletedCount){
			status=COMPLETED;
		}
		else{
			status=FAIL;
		}
		}
		else{
			if(verifications==actionspasscount){
			status=PASS;
		}
		else{
			status=FAIL;
		}
		}
		iterationElement.setAttribute("iteration-status", getStatus(status));
		iterationElement.setAttribute("end-time", dateFormat.format(Calendar.getInstance().getTime()));
		iterationsElement.appendChild(iterationElement);
		return status;
		}

	//method Definition for the SanityTestSuiteTC6_LightRegistrationIteration0
	public int SanityTestSuiteTC6_LightRegistrationIteration0(int iterationCnt){
		int status;
		verifications=0;
		actionspasscount=0;
		actionscompletedCount=0;
		actionsCount=0;
		iterationElement = createIterationElement(iterationCnt);
		//Load a new web page in the current browser window, with the specified Url
		System.out.println("Loading the url - https://wtr-mob-test4.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html");
		iterationElement.appendChild(createActionElement( executeAction(LOADPAGE, "https://wtr-mob-test4.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html", true, "",""),"1","URL","https://wtr-mob-test4.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html","PAGELOAD"));
		iterationElement.appendChild(createActionElement( executeAction(LOADPAGE, "https://wtr-mob-test4.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html", true, "",""),"1","URL","https://wtr-mob-test4.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html","PAGELOAD"));

		System.out.println("Executing	Action-CLICK		Xpath-//span[@id='dojox_mob ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[@id='dojox_mobile_ToolBarButton_5']",""),"2","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"3","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[contains(text() ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[contains(text(),'Home')]",""),"4","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"5","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//span[@id='dojox_mob ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[@id='dojox_mobile_ToolBarButton_5']",""),"6","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"7","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[@id='dojox_m ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[@id='dojox_mobile_Button_7']",""),"8","BUTTON","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"9","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//h1[text()='Register ... 		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//h1[text()='Register']",""),"10","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"11","","","WAIT" ));

		System.out.println("Executing	Action-SET		Xpath-//input[@id='dojox_mo ... 		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "auto1user1@wtr-test.net", false, "//input[@id='dojox_mobile_TextBox_3']",""),"12","INPUT","auto1user1@wtr-test.net","SET" ));

		System.out.println("Executing	Action-SET		Xpath-//input[@id='dojox_mo ... 		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "test1234", false, "//input[@id='dojox_mobile_TextBox_4']",""),"13","INPUT","test1234","SET" ));

		System.out.println("Executing	Action-SET		Xpath-//input[@id='dojox_mo ... 		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "test1234", false, "//input[@id='dojox_mobile_TextBox_5']",""),"14","INPUT","test1234","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"15","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//input[@id='dojox_mo ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//input[@id='dojox_mobile_CheckBox_1']",""),"16","INPUT","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"17","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[text()='Regi ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[text()='Register']",""),"18","BUTTON","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"19","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//p[contains(text(),' ... 		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//p[contains(text(),'You have created a Waitrose.com account. An email confirmation will be sent to you shortly')]",""),"20","P","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"21","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[contains(tex ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[contains(text(),'Continue')]",""),"22","BUTTON","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"23","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//span[@id='dojox_mob ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[@id='dojox_mobile_ToolBarButton_5']",""),"24","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"25","","","WAIT" ));

		System.out.println("Executing	Action-VERIFY		Xpath-//div[@ data-dojo-att ... 		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFY, "auto1user1@wtr-test.net", false, "//div[@ data-dojo-attach-point='_loggedInWelcomeName']",""),"26","DIV","auto1user1@wtr-test.net","VERIFY" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"27","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[contains(text() ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[contains(text(),'Logout')]",""),"28","DIV","","CLICK" ));
		if(verifications==0){
			if(actionsCount==actionscompletedCount){
			status=COMPLETED;
		}
		else{
			status=FAIL;
		}
		}
		else{
			if(verifications==actionspasscount){
			status=PASS;
		}
		else{
			status=FAIL;
		}
		}
		iterationElement.setAttribute("iteration-status", getStatus(status));
		iterationElement.setAttribute("end-time", dateFormat.format(Calendar.getInstance().getTime()));
		iterationsElement.appendChild(iterationElement);
		return status;
		}

	//method Definition for the SanityTestSuiteTC7_BranchFinderIteration0
	public int SanityTestSuiteTC7_BranchFinderIteration0(int iterationCnt){
		int status;
		verifications=0;
		actionspasscount=0;
		actionscompletedCount=0;
		actionsCount=0;
		iterationElement = createIterationElement(iterationCnt);
		//Load a new web page in the current browser window, with the specified Url
		System.out.println("Loading the url - https://wtr-mob-test4.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html");
		iterationElement.appendChild(createActionElement( executeAction(LOADPAGE, "https://wtr-mob-test4.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html", true, "",""),"1","URL","https://wtr-mob-test4.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html","PAGELOAD"));
		iterationElement.appendChild(createActionElement( executeAction(LOADPAGE, "https://wtr-mob-test4.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html", true, "",""),"1","URL","https://wtr-mob-test4.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html","PAGELOAD"));

		System.out.println("Executing	Action-CLICK		Xpath-//span[@id='dojox_mob ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[@id='dojox_mobile_ToolBarButton_5']",""),"2","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"3","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[contains(text() ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[contains(text(),'Home')]",""),"4","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"5","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[contains(tex ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[contains(text(),'Branch Finder')]",""),"6","BUTTON","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"7","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//h1[text()='Branch F ... 		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//h1[text()='Branch Finder']",""),"8","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-SET		Xpath-//input[@id='dojox_mo ... 		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "GU466FR", false, "//input[@id='dojox_mobile_TextBox_3']",""),"9","INPUT","GU466FR","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"10","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-(//li[@class='mblList ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "(//li[@class='mblListItem']/div[3])[1]",""),"11","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"12","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-(//li[@class='mblList ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "(//li[@class='mblListItem']/div[3])[1]",""),"13","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"14","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//p[contains(text(),' ... 		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//p[contains(text(),'Opening hours')]",""),"15","P","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//p[contains(text(),' ... 		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//p[contains(text(),'Customer notices')]",""),"16","P","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//p[contains(text(),' ... 		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//p[contains(text(),'Services')]",""),"17","P","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"18","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[contains(tex ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[contains(text(),'Set as My Branch')]",""),"19","BUTTON","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"20","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[contains(tex ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[contains(text(),'OK')]",""),"21","BUTTON","","CLICK" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[@id='dojox_mobi ... 		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[@id='dojox_mobile_Button_47']",""),"22","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"23","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//div[@class='myBranc ... 		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[@class='myBranch']",""),"24","DIV","1","VERIFYOBJECT" ));
		if(verifications==0){
			if(actionsCount==actionscompletedCount){
			status=COMPLETED;
		}
		else{
			status=FAIL;
		}
		}
		else{
			if(verifications==actionspasscount){
			status=PASS;
		}
		else{
			status=FAIL;
		}
		}
		iterationElement.setAttribute("iteration-status", getStatus(status));
		iterationElement.setAttribute("end-time", dateFormat.format(Calendar.getInstance().getTime()));
		iterationsElement.appendChild(iterationElement);
		return status;
		}

	//pre-requisite operations prior to all testcase executions 
	@BeforeClass
	public static void beforeCls(){
		try{
			documentBuilderFactory = DocumentBuilderFactory.newInstance();
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.newDocument();
			putInitialVariablesInString();
			dateFormat=new SimpleDateFormat("HH:mm:ss");
			screenshotFormat=new SimpleDateFormat("HHmmss");
		}catch(Exception e){
		e.printStackTrace();
		}
	}

	//method for verify the existence of the object
	private boolean verifyObject(boolean byid, String strName, int timeoutInSeconds){
		try{
			WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
			if(byid){
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id(strName)));
			}else{
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(strName)));
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	//method for delay
	private void delay(int timeoutInSeconds){
		try{
			WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("")));
		}catch(Exception e){ }
	}

	//method to wait with default timeout till the required control is found 
	private void waitForObject(boolean byid, String strName, int timeoutInSeconds){
			WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
			if(byid){
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id(strName)));
			}else{
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(strName)));
			}
		}

	//method to create a testcase DOM element
	private Element createTestcaseElement(String testcase,String scenario){
		Element testcaseElement = document.createElement("test-case");
		testcaseElement.setAttribute("testcseName", testcase);
		testcaseElement.setAttribute("scenarioName", scenario);
		testcaseElement.setAttribute("start-time", dateFormat.format(Calendar.getInstance().getTime()));
		testcaseElement.setAttribute("execution-time", "");
		Element descriptionElement = document.createElement("testcase-description");
		Element expectedValueElement = document.createElement("expected-value");
		Element actualValueElement = document.createElement("actual-value");
		testcaseElement.appendChild(descriptionElement);
		testcaseElement.appendChild(expectedValueElement);
		testcaseElement.appendChild(actualValueElement);
		iterationsElement = document.createElement("iterations");
		testcaseElement.appendChild(iterationsElement);
		return testcaseElement;
	}
	

	//method to create a testcase-iteration DOM element
	private Element createIterationElement(int iterationIndex){
		Element iterationElement = document.createElement("iteration");
		iterationElement.setAttribute("count", String.valueOf(iterationIndex));
		iterationElement.setAttribute("start-time", dateFormat.format(Calendar.getInstance().getTime()));
		iterationElement.setAttribute("execution-time", "");
		return iterationElement;
	}
	

	//method to create a testcase-action DOM element
	private Element createActionElement(int status,String index,String type,String inputVal,String name){
		Element actionControlElement = document.createElement("action-control");
		actionControlElement.setAttribute("name", name);
		actionControlElement.setAttribute("action-remarks", getStatus(status));
		actionControlElement.setAttribute("action-time", dateFormat.format(Calendar.getInstance().getTime()));
		actionControlElement.setAttribute("input-value", inputVal);
		actionControlElement.setAttribute("number", index);
		actionControlElement.setAttribute("type", type);
		actionControlElement.setAttribute("screenshot", "");
		Element remarksDescElement = document.createElement("remarks-description");
		remarksDescElement.appendChild( document.createTextNode(getRemarks(name, status)) );
		actionControlElement.appendChild(remarksDescElement);
		if(status==FAIL || status==ERROR){
			String imageFileName=current_testcase_name+"_"+screenshotFormat.format(Calendar.getInstance().getTime())+".jpg";
			takeScreenShot(screenshot_path+File.separator+imageFileName);
			actionControlElement.setAttribute("screenshot", imageFileName);
		}
		return actionControlElement;
	}
	

	//returns the status in string format
	private String getStatus(int status){
		switch(status){
		case PASS 		:	return "pass";
		case FAIL		:	return "fail";
		case COMPLETED	:	return "completed";
		case ERROR		:	return "error";
		}
		return "";
	}
	

	//returns Remarks based on the action status
	private String getRemarks(String actionName,int status){
		switch(status){
		case PASS 		:	return actionName+" action passed";
		case FAIL		:	return "Failed to execute "+actionName+" action";
		case COMPLETED	:	return actionName+" action completed successfully";
		case ERROR		:	return "Element Not Found";
		}
		return "";
	}
	

	//updates counters needed to track iteraction status
	private void updateIterationCounters(int status){
		switch(status){
		case PASS 		:	iterationspasscount++;return;
		case FAIL		:	iterationsfailcount++;return;
		case COMPLETED	:	iterationscompletedcount++;return;
		}
	}
	

	//executes the specified actions
	private int executeAction(int action,String valueOrUrl,boolean byid,String idOrxpath,String iframePath){
		WebElement element=null;
		int status=-1;
		actionsCount++;
		try{
			switch(action){
				case LOADPAGE	:	driver.get(valueOrUrl);status=COMPLETED;break;

				case SET		:	updateDriver(iframePath);waitForObject(byid,idOrxpath,60);element=getElement(byid, idOrxpath);
									handleSetValue(element, valueOrUrl);
									restoreDriverToDefaultContent();
									status=COMPLETED;break;

				case CLICK		:	updateDriver(iframePath);waitForObject(byid,idOrxpath,60);element=getElement(byid, idOrxpath);
									element.click();
									restoreDriverToDefaultContent();
									status=COMPLETED;break;

				case VERIFY		:	verifications++;
									updateDriver(iframePath);waitForObject(byid,idOrxpath,60);element=getElement(byid,idOrxpath);
									if(element.getText().equals(valueOrUrl)){
									status=PASS;
									actionspasscount++;
									}
									else{
									status=FAIL;
									}
									restoreDriverToDefaultContent();
									break;

				case WAIT		:	delay(Integer.parseInt(valueOrUrl));
									status=COMPLETED;break;

				case VERIFYOBJECT:	verifications++;
									updateDriver(iframePath);if( verifyObject(byid, idOrxpath, Integer.parseInt(valueOrUrl)) ){
									status=PASS;
									System.out.println("Status - Pass");
									actionspasscount++;
									}
									else{
									status=FAIL;
									System.out.println("Status - Fail");
									}
									restoreDriverToDefaultContent();
									break;

				case GET		:	updateDriver(iframePath);waitForObject(byid,idOrxpath,60);element=getElement(byid, idOrxpath);
									status=COMPLETED;break;

				case GETVALUES	:	updateDriver(iframePath);waitForObject(byid,idOrxpath,60);element=getElement(byid, idOrxpath);
									status=COMPLETED;break;

				case VERIFYVALUES	:	updateDriver(iframePath);waitForObject(byid,idOrxpath,60);element=getElement(byid, idOrxpath);
									status=COMPLETED;break;

				case SETVALUE		:	updateDriver(iframePath);waitForObject(byid,idOrxpath,60);element=getElement(byid, idOrxpath);
									status=COMPLETED;break;

				case IS_ENABLED		:	verifications++;
									updateDriver(iframePath);waitForObject(byid,idOrxpath,60);element=getElement(byid,idOrxpath);
									if(element.isEnabled()){
									status=PASS;
									System.out.println("Status - Pass");
									actionspasscount++;
									}
									else{
									status=FAIL;
									System.out.println("Status - Fail");
									}
									restoreDriverToDefaultContent();
									break;

				case IS_SELECTED		:	verifications++;
									updateDriver(iframePath);waitForObject(byid,idOrxpath,60);element=getElement(byid,idOrxpath);
									if(element.isSelected()){
									status=PASS;
									System.out.println("Status - Pass");
									actionspasscount++;
									}
									else{
									status=FAIL;
									System.out.println("Status - Fail");
									}
									restoreDriverToDefaultContent();
									break;

				case WAITFOROBJECT		:	try
									{
									waitForObject(byid,idOrxpath,60);
									status=COMPLETED;
									}
									catch(Exception e)
									{
									status=FAIL;
									}
			}
			actionscompletedCount++;
			return status;
		}
		catch(Exception e){
		e.printStackTrace();
			return ERROR;
		}
	}

	//fetches the specified element 
	private WebElement getElement(boolean byid,String idOrXpath){
		WebElement element=null;
		if(byid){
		System.out.println("Finding element by id - "+idOrXpath);
			element=driver.findElement(By.id(idOrXpath));
		}
		else{
		System.out.println("Finding element by xpath - "+idOrXpath);
			element=driver.findElement(By.xpath(idOrXpath));
		}
		return element;
	}
	//Method to handle set action where in the logic for select is differentiated from other elements 
	private void handleSetValue(WebElement element,String value){

		String tagName=element.getTagName();
		if(tagName.equalsIgnoreCase(SELECT_TAG)){
			Select select=new Select(element);
			select.selectByVisibleText(value);
		}else{
			element.sendKeys(value);
		}

	}
	// Updates the driver to identify web controls inside an iframe 
	private void updateDriver(String iframePath){

		if(!iframePath.equals("")){ 
			String[] iframes=iframePath.split("-"); 
			for(int i=0;i<iframes.length;i++){ 
				int iframeCnt=Integer.parseInt(iframes[i]); 
				driver=driver.switchTo().frame(iframeCnt); 
			}
		} 
	} 
	// Restores the driver to identify controls in main document
	private void restoreDriverToDefaultContent(){ 
		driver= driver.switchTo().defaultContent(); 
	} 
	//Takes the screenshot of the current screen
	private void takeScreenShot(String imageName){
		delay(10);
		try {
			TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
			File file=takesScreenshot.getScreenshotAs(OutputType.FILE);
			System.out.println("Taking snapshop and storing it in "+file.getAbsolutePath());
			FileUtils.copyFile(file, new File(imageName));
		} catch (Exception e) {
			e.printStackTrace();
			}
	}
	//gets ip from the configuration xml file 
	private String getDataFromConfiguration(String tag,String configXmlPath){
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance(); 
		try { 
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder(); 
			Document document=documentBuilder.parse(new File(configXmlPath)); 
			return document.getElementsByTagName(tag).item(0).getTextContent(); 
		} catch (ParserConfigurationException e) { 
			e.printStackTrace(); 
		}catch (SAXException e) {  
			e.printStackTrace(); 
		} catch (IOException e) {
			e.printStackTrace(); 
		} 
		return null; 
	} 
	//gets the formatted action 
	private String getFormattedAction(String action , String mappingName , String urlOrXpath , String keysToSend){
		return action+ACTION_INFO_SEPERATOR+mappingName+ACTION_INFO_SEPERATOR+urlOrXpath+ACTION_INFO_SEPERATOR+keysToSend;
	} 
	//timestampFor Report folder creation 
	private static String getTimeStampFolderName() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("HHmmss");
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd");
		String formattedDate = dateFormatter.format(calendar.getTime());
		String formattedTime = formatter.format(calendar.getTime());
		return (formattedDate+ "_" + formattedTime);
	} 
	//Report folder creation 
	private void createReportDirectory() {
	screenshot_path=screenshot_path+"/"+getTimeStampFolderName();
		File file=new File(screenshot_path);
		if(!(file.isDirectory()&&file.exists())) {
		file.mkdirs();
	} 
	} 
}