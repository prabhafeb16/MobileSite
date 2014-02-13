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
import org.openqa.selenium.*;

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
	private static final int DELETECOOKIES=13;
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
	private static String screenshot_path="/Users/WAitRoseTeam/Documents/Waitrose_Automation_Sanity/Reports/Web/ANDROID";
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
		driver = new AndroidDriver(new URL("http://localhost:"+getDataFromConfiguration("port","/Users/WAitRoseTeam/Documents/Waitrose_Automation_Sanity/config.xml")+"/wd/hub"),capabilities);
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

	@Test//test method for the SanityTestSuiteTC9_LogIn
	public void testSanityTestSuiteTC9_LogIn() throws Exception {
		String testcaseStatus="";
		current_testcase_name="TC9_LogIn";
		iterationspasscount=0;
		iterationsfailcount=0;
		iterationscompletedcount=0;
		iterationCount=0;
		int status=-1;
		testcaseElement = createTestcaseElement("TC9_LogIn","SanityTestSuite");

		status=SanityTestSuiteTC9_LogInIteration0(iterationCount);
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

		testcaseElement.setAttribute("testcase-description", "LogOutFunction");
		testcaseElement.setAttribute("expected-value", "LogOutFunction");
		testcaseElement.setAttribute("status", testcaseStatus);
		testcaseElement.setAttribute("end-time",dateFormat.format(Calendar.getInstance().getTime()) );
		testcasesElement.appendChild(testcaseElement);
	}


	@Test//test method for the SanityTestSuiteTC_CheckoutWithGiftCard
	public void testSanityTestSuiteTC_CheckoutWithGiftCard() throws Exception {
		String testcaseStatus="";
		current_testcase_name="TC_CheckoutWithGiftCard";
		iterationspasscount=0;
		iterationsfailcount=0;
		iterationscompletedcount=0;
		iterationCount=0;
		int status=-1;
		testcaseElement = createTestcaseElement("TC_CheckoutWithGiftCard","SanityTestSuite");

		status=SanityTestSuiteTC_CheckoutWithGiftCardIteration0(iterationCount);
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


	@Test//test method for the SanityTestSuiteTC_CheckoutWithVoucher
	public void testSanityTestSuiteTC_CheckoutWithVoucher() throws Exception {
		String testcaseStatus="";
		current_testcase_name="TC_CheckoutWithVoucher";
		iterationspasscount=0;
		iterationsfailcount=0;
		iterationscompletedcount=0;
		iterationCount=0;
		int status=-1;
		testcaseElement = createTestcaseElement("TC_CheckoutWithVoucher","SanityTestSuite");

		status=SanityTestSuiteTC_CheckoutWithVoucherIteration0(iterationCount);
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
		saveReport();
	}


	//method Definition for the SanityTestSuiteTC9_LogInIteration0
	public int SanityTestSuiteTC9_LogInIteration0(int iterationCnt){
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

		System.out.println("Executing	Action-WAIT		Timeout-3		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "3", true, "",""),"2","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - MenuButton		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[@id='dojox_mobile_ToolBarButton_5']",""),"3","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"4","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Control - LHS_Login		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//button[contains(text(),' Log in')]",""),"5","BUTTON","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-CLICK		Control - LHS_Login		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[contains(text(),' Log in')]",""),"6","BUTTON","","CLICK" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Control - LoginPage		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[contains(text(),'Login')]",""),"7","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-SET		Control - Login_EmailAddress		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "wait123@wtr-test.net", false, "//input[@id='dojox_mobile_TextBox_0']",""),"8","INPUT","wait123@wtr-test.net","SET" ));

		System.out.println("Executing	Action-SET		Control - Login_Password		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "test1234", false, "//input[@id='dojox_mobile_TextBox_1']",""),"9","INPUT","test1234","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"10","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - LoginPage_LoginButton		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[contains(text(),'Login')]",""),"11","BUTTON","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"12","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - MenuButton		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[@id='dojox_mobile_ToolBarButton_5']",""),"13","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"14","","","WAIT" ));

		System.out.println("Executing	Action-VERIFY		Control - Logged in User		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFY, "Julie Anderson", false, "//div[@ data-dojo-attach-point='_loggedInWelcomeName']",""),"15","DIV","Julie Anderson","VERIFY" ));
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

	//method Definition for the SanityTestSuiteTC_CheckoutWithGiftCardIteration0
	public int SanityTestSuiteTC_CheckoutWithGiftCardIteration0(int iterationCnt){
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

		System.out.println("Executing	Action-WAIT		Timeout-3		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "3", true, "",""),"2","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - MenuButton		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[@id='dojox_mobile_ToolBarButton_5']",""),"3","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"4","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - BookSlot		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[contains(text(),'Book Slot')]",""),"5","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"6","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - YouCollect		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[contains(text(),'You Collect')]",""),"7","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"8","","","WAIT" ));

		System.out.println("Executing	Action-SET		Control - CollectionPostcode		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "RG142DH", false, "//input[@placeholder='Enter town or full postcode']",""),"9","INPUT","RG142DH","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"10","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - FindButton		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "(//button[contains(text(),'Find')])[2]",""),"11","BUTTON","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"12","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - SelectionCollectionPoint		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "(//span[@class='branchName'])[1]",""),"13","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-3		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "3", true, "",""),"14","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - CalendarNextButton		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[@id='dojox_mobile_ToolBarButton_13']",""),"15","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"16","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - CalendarNextButton		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[@id='dojox_mobile_ToolBarButton_13']",""),"17","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"18","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - CollectionDate		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "(//div[@class='CalendarIcon ProductIconItem'])[8]",""),"19","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"20","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - Delivery_SelectCalendarTime		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[@id='waitrose_widgets_AvailableTimes_4']",""),"21","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"22","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - Collection_BookSlot		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[@id='dojox_mobile_Button_58']",""),"23","BUTTON","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"24","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Control - SlotConfirmationMessage		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[text()='Your slot is reserved for 2 hrs']",""),"25","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"26","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - StartShopping		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[text()='Start Shopping']",""),"27","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"28","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - WaitroseHomeIcon		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//img[@data-dojo-attach-event='click:_goHome']",""),"29","IMG","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"30","","","WAIT" ));

		System.out.println("Executing	Action-SET		Control - HomePage_SearchBar		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "rankin selection Irish fruit soda bread", false, "//div[@id='waitrose/widgets/Heading_0']//input[@placeholder='Search']",""),"31","INPUT","rankin selection Irish fruit soda bread","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"32","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - HomePage_SearchIcon		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[@id='waitrose/widgets/Heading_0']//i",""),"33","I","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"34","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - GroceryAddButton		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[text()='Add']",""),"35","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"36","","","WAIT" ));

		System.out.println("Executing	Action-SET		Control - GroceryUpdateQuantity		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "10", false, "(//ul[@id='waitrose/widgets/TaxonomyCategoryStoreList_0']//input[@data-dojo-attach-point='quantityNode'])[1]",""),"37","SPAN","10","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"38","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - WaitroseHomeIcon		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//img[@data-dojo-attach-event='click:_goHome']",""),"39","IMG","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"40","","","WAIT" ));

		System.out.println("Executing	Action-SET		Control - HomePage_SearchBar		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "cake", false, "//div[@id='waitrose/widgets/Heading_0']//input[@placeholder='Search']",""),"41","INPUT","cake","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"42","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - HomePage_SearchIcon		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[@id='waitrose/widgets/Heading_0']//i",""),"43","I","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"44","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - EntertainingTab		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//li[@id='dojox_mobile_TabBarButton_1']",""),"45","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"46","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - EntertainingAddButton		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "(//ul[@id='waitrose/widgets/TaxonomyCategoryStoreList_1']//span[text()='Add'])[1]",""),"47","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"48","","","WAIT" ));

		System.out.println("Executing	Action-SET		Control - EntertainingUpdateQuantity		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "2", false, "(//ul[@id='waitrose/widgets/TaxonomyCategoryStoreList_1']//input[@data-dojo-attach-point='quantityNode'])[1]",""),"49","SPAN","2","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"50","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - TrolleyIcon		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[@class='trolleyIcon']",""),"51","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"52","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Control - TrolleyPage		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[text()='Trolley']",""),"53","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"54","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - CheckoutButton		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[text()='Checkout']",""),"55","TD","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"56","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Control - CheckoutPage		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//h1[text()='Checkout']",""),"57","INPUT","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"58","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - Continuetopaymentdetailsbutton		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[text()='Continue to payment details']",""),"59","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"60","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Control - ContinuetoPaymentDetailsPage		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//h3[contains(text(),'Payment details')]",""),"61","BUTTON","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"62","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - GiftCard_Add		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[contains(text(),'Add a gift card')]",""),"63","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"64","","","WAIT" ));

		System.out.println("Executing	Action-SET		Control - GiftCard_Number		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "6371960007999916440", false, "(//input[@data-dojo-attach-point='_inputNumber'])[1]",""),"65","DIV","6371960007999916440","SET" ));

		System.out.println("Executing	Action-SET		Control - GiftCArd_SecurityCode		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "9092", false, "(//input[@data-dojo-attach-point='_inputCode'])[1]",""),"66","IMG","9092","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"67","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - Gift_Card_ApplyButton		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "(//button[contains(text(),'Apply')])[1]",""),"68","INPUT","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-4		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "4", true, "",""),"69","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - PlaceOrderButton		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[text()='Place your order']",""),"70","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"71","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Control - OrderConfirmationPage		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//h3[contains(text(),'Order confirmation')]",""),"72","BUTTON","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"73","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Control - OrderConfirmationMessage		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[text()='Your order is confirmed']",""),"74","DIV","1","VERIFYOBJECT" ));
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

	//method Definition for the SanityTestSuiteTC_CheckoutWithVoucherIteration0
	public int SanityTestSuiteTC_CheckoutWithVoucherIteration0(int iterationCnt){
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

		System.out.println("Executing	Action-WAIT		Timeout-3		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "3", true, "",""),"2","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - MenuButton		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[@id='dojox_mobile_ToolBarButton_5']",""),"3","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"4","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - BookSlot		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[contains(text(),'Book Slot')]",""),"5","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"6","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - YouCollect		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[contains(text(),'You Collect')]",""),"7","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"8","","","WAIT" ));

		System.out.println("Executing	Action-SET		Control - CollectionPostcode		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "RG142DH", false, "//input[@placeholder='Enter town or full postcode']",""),"9","INPUT","RG142DH","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"10","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - FindButton		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "(//button[contains(text(),'Find')])[2]",""),"11","BUTTON","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"12","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - SelectionCollectionPoint		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "(//span[@class='branchName'])[1]",""),"13","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-3		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "3", true, "",""),"14","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - CalendarNextButton		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[@id='dojox_mobile_ToolBarButton_13']",""),"15","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"16","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - CalendarNextButton		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[@id='dojox_mobile_ToolBarButton_13']",""),"17","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"18","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - CollectionDate		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "(//div[@class='CalendarIcon ProductIconItem'])[8]",""),"19","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"20","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - Delivery_SelectCalendarTime		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[@id='waitrose_widgets_AvailableTimes_4']",""),"21","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"22","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - Collection_BookSlot		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[@id='dojox_mobile_Button_58']",""),"23","BUTTON","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"24","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Control - SlotConfirmationMessage		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[text()='Your slot is reserved for 2 hrs']",""),"25","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"26","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - StartShopping		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[text()='Start Shopping']",""),"27","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"28","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - WaitroseHomeIcon		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//img[@data-dojo-attach-event='click:_goHome']",""),"29","IMG","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"30","","","WAIT" ));

		System.out.println("Executing	Action-SET		Control - HomePage_SearchBar		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "rankin selection Irish fruit soda bread", false, "//div[@id='waitrose/widgets/Heading_0']//input[@placeholder='Search']",""),"31","INPUT","rankin selection Irish fruit soda bread","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"32","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - HomePage_SearchIcon		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[@id='waitrose/widgets/Heading_0']//i",""),"33","I","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"34","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - GroceryAddButton		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[text()='Add']",""),"35","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"36","","","WAIT" ));

		System.out.println("Executing	Action-SET		Control - GroceryUpdateQuantity		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "10", false, "(//ul[@id='waitrose/widgets/TaxonomyCategoryStoreList_0']//input[@data-dojo-attach-point='quantityNode'])[1]",""),"37","SPAN","10","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"38","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - WaitroseHomeIcon		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//img[@data-dojo-attach-event='click:_goHome']",""),"39","IMG","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"40","","","WAIT" ));

		System.out.println("Executing	Action-SET		Control - HomePage_SearchBar		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "cake", false, "//div[@id='waitrose/widgets/Heading_0']//input[@placeholder='Search']",""),"41","INPUT","cake","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"42","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - HomePage_SearchIcon		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[@id='waitrose/widgets/Heading_0']//i",""),"43","I","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"44","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - EntertainingTab		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//li[@id='dojox_mobile_TabBarButton_1']",""),"45","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"46","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - EntertainingAddButton		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "(//ul[@id='waitrose/widgets/TaxonomyCategoryStoreList_1']//span[text()='Add'])[1]",""),"47","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"48","","","WAIT" ));

		System.out.println("Executing	Action-SET		Control - EntertainingUpdateQuantity		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "2", false, "(//ul[@id='waitrose/widgets/TaxonomyCategoryStoreList_1']//input[@data-dojo-attach-point='quantityNode'])[1]",""),"49","SPAN","2","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"50","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - TrolleyIcon		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[@class='trolleyIcon']",""),"51","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"52","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Control - TrolleyPage		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[text()='Trolley']",""),"53","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"54","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - CheckoutButton		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[text()='Checkout']",""),"55","TD","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"56","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Control - CheckoutPage		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//h1[text()='Checkout']",""),"57","INPUT","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"58","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - Continuetopaymentdetailsbutton		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[text()='Continue to payment details']",""),"59","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"60","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Control - ContinuetoPaymentDetailsPage		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//h3[contains(text(),'Payment details')]",""),"61","BUTTON","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"62","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - GiftVOucher_Add		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[contains(text(),'Add a gift voucher')]",""),"63","IMG","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"64","","","WAIT" ));

		System.out.println("Executing	Action-SET		Control - GiftVoucher_SerialNumber		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "5001162023", false, "(//input[@data-dojo-attach-point='_inputNumber'])[2]",""),"65","DIV","5001162023","SET" ));

		System.out.println("Executing	Action-SET		Control - GiftVoucher_SecurityCode		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "BBBBBBB", false, "(//input[@data-dojo-attach-point='_inputCode'])[2]",""),"66","DIV","BBBBBBB","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"67","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - GiftVoucher_ApplyButton		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "(//button[contains(text(),'Apply')])[2]",""),"68","IMG","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-4		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "4", true, "",""),"69","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Control - PlaceOrderButton		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[text()='Place your order']",""),"70","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"71","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Control - OrderConfirmationPage		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//h3[contains(text(),'Order confirmation')]",""),"72","BUTTON","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"73","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Control - OrderConfirmationMessage		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[text()='Your order is confirmed']",""),"74","DIV","1","VERIFYOBJECT" ));
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
				case DELETECOOKIES	:	try
									{
									deleteAllCookies();
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
	//Delete all cookies from webdriver
	private void deleteAllCookies(){ 
		driver.manage().deleteAllCookies(); 
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
			String result = document.getElementsByTagName(tag).item(0).getTextContent();
			if(tag.equals("port") && result.equals("")){
				result = "8080";
			}
			return result; 
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