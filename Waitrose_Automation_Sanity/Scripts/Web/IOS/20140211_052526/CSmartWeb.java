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

import org.openqa.selenium.iphone.IPhoneDriver;
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
	private static String screenshot_path="/Users/WAitRoseTeam/Documents/Waitrose_Automation_Sanity/Reports/Web/IOS";
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
		//initialize the IPhoneDriver for executing in iOS platform
		driver = new RemoteWebDriver(new URL("http://"+getDataFromConfiguration("ip","/Users/WAitRoseTeam/Documents/Waitrose_Automation_Sanity/config.xml")+":3001/wd/hub"),DesiredCapabilities.iphone());
		//driver = new IPhoneDriver();
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

	//Test doc here ... 
	@Test
	public void testNew() throws Exception {
	try{
		driver.get(""+

	//Testcase TC9_LogIn

	"SanityTestSuite:TC9_LogIn"+

		TESTCASE_INFO_SEPERATOR+


	//Iteration 0
		getFormattedAction("url","LoadUrl","https://wtr-mob-acpt.tiffani.co.uk","")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "3")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "Menu Button", "//span[@id='dojox_mobile_ToolBarButton_5']", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("verifyObject", "Login Button in LHS Menu", "//button[contains(text(),' Log in')]", "")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "Login Button in LHS Menu", "//button[contains(text(),' Log in')]", "")+

		ACTION_SEPERATOR+

		getFormattedAction("verifyObject", "Login Page", "//div[contains(text(),'Login')]", "")+

		ACTION_SEPERATOR+

		getFormattedAction("set", "Email Address in Login", "//input[@id='dojox_mobile_TextBox_0']", "rajeshauto90@wtr-test.net")+

		ACTION_SEPERATOR+

		getFormattedAction("set", "Password in Login", "//input[@id='dojox_mobile_TextBox_1']", "test1234")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "Login Button in Login Page", "//button[contains(text(),'Login')]", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "Menu Button", "//span[@id='dojox_mobile_ToolBarButton_5']", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("verify", "Logged User", "//div[@ data-dojo-attach-point='_loggedInWelcomeName']", "Julie Anderson")+

		TESTCASE_SEPERATOR+


	//Testcase TC_CheckoutWithGiftCard

	"SanityTestSuite:TC_CheckoutWithGiftCard"+

		TESTCASE_INFO_SEPERATOR+


	//Iteration 0
		getFormattedAction("url","LoadUrl","https://wtr-mob-acpt.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html","")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "3")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "Menu Button", "//span[@id='dojox_mobile_ToolBarButton_5']", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "BookSlot", "//div[contains(text(),'Book Slot')]", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "YouCollect", "//div[contains(text(),'You Collect')]", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("set", "CollectionPostcode", "//input[@placeholder='Enter town or full postcode']", "RG142DH")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "PostcodeFind", "(//button[contains(text(),'Find')])[2]", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "SelectCollectionPoint", "(//span[@class='branchName'])[1]", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "3")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "CalendarNextButton", "//span[@id='dojox_mobile_ToolBarButton_13']", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "CalendarNextButton", "//span[@id='dojox_mobile_ToolBarButton_13']", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "CollectionSelectDate", "(//div[@class='CalendarIcon ProductIconItem'])[5]", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "SelectTimefordelivery", "//div[@id='waitrose_widgets_AvailableTimes_4']", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "Collection_BookSlot", "//button[@id='dojox_mobile_Button_57']", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("verifyObject", "YourSlotisReservedFor2hrs", "//div[text()='Your slot is reserved for 2 hrs']", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "StartShopping", "//button[text()='Start Shopping']", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "WaitroseHome", "//img[@data-dojo-attach-event='click:_goHome']", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("set", "SearchBoxinHomePage", "//div[@id='waitrose/widgets/Heading_0']//input[@placeholder='Search']", "rankin selection Irish fruit soda bread")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "SearchIcon", "//div[@id='waitrose/widgets/Heading_0']//i", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "AddGroceryProduct", "//span[text()='Add']", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("set", "UpdateGroceryQuantity", "(//ul[@id='waitrose/widgets/TaxonomyCategoryStoreList_0']//input[@data-dojo-attach-point='quantityNode'])[1]", "10")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "WaitroseHomeIcon", "//img[@data-dojo-attach-event='click:_goHome']", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("set", "SearchBoxinHomePage", "//div[@id='waitrose/widgets/Heading_0']//input[@placeholder='Search']", "cake")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "SearchIcon", "//div[@id='waitrose/widgets/Heading_0']//i", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "EntertainingTab", "//li[@id='dojox_mobile_TabBarButton_1']", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "AddEntertainingProduct", "(//ul[@id='waitrose/widgets/TaxonomyCategoryStoreList_1']//span[text()='Add'])[1]", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("set", "UpdateEntertainingQty", "(//ul[@id='waitrose/widgets/TaxonomyCategoryStoreList_1']//input[@data-dojo-attach-point='quantityNode'])[1]", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "TrolleyIcon", "//div[@class='trolleyIcon']", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("verifyObject", "TrolleyPage", "//div[text()='Trolley']", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "CheckoutinTrolleyIcon", "//button[text()='Checkout']", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("verifyObject", "CheckoutPage", "//h1[text()='Checkout']", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "ContinuetoPaymentDetails", "//button[text()='Continue to payment details']", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("verifyObject", "PaymentDetailsPage", "//h3[contains(text(),'Payment details')]", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "GiftCArd_Add", "//button[contains(text(),'Add a gift card')]", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("set", "GiftCard_Number", "(//input[@data-dojo-attach-point='_inputNumber'])[1]", "6371960007999916440")+

		ACTION_SEPERATOR+

		getFormattedAction("set", "GiftCArd_SerurityCode", "(//input[@data-dojo-attach-point='_inputCode'])[1]", "9092")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "GiftCard_Apply", "(//button[contains(text(),'Apply')])[1]", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "4")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "PlaceYourOrder", "//button[text()='Place your order']", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("verifyObject", "OrderConfirmationPage", "//h3[contains(text(),'Order confirmation')]", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("verifyObject", "YourOrderisConfirmed", "//div[text()='Your order is confirmed']", "")+

		TESTCASE_SEPERATOR+


	//Testcase TC_CheckoutWithVoucher

	"SanityTestSuite:TC_CheckoutWithVoucher"+

		TESTCASE_INFO_SEPERATOR+


	//Iteration 0
		getFormattedAction("url","LoadUrl","https://wtr-mob-acpt.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html","")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "3")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "Menu Button", "//span[@id='dojox_mobile_ToolBarButton_5']", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "BookSlot", "//div[contains(text(),'Book Slot')]", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "YouCollect", "//div[contains(text(),'You Collect')]", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("set", "CollectionPostcode", "//input[@placeholder='Enter town or full postcode']", "RG142DH")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "PostcodeFind", "(//button[contains(text(),'Find')])[2]", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "SelectCollectionPoint", "(//span[@class='branchName'])[1]", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "3")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "CalendarNextButton", "//span[@id='dojox_mobile_ToolBarButton_13']", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "CalendarNextButton", "//span[@id='dojox_mobile_ToolBarButton_13']", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "CollectionSelectDate", "(//div[@class='CalendarIcon ProductIconItem'])[8]", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "SelectTimefordelivery", "//div[@id='waitrose_widgets_AvailableTimes_4']", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "Collection_BookSlot", "//button[@id='dojox_mobile_Button_58']", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("verifyObject", "YourSlotisReservedFor2hrs", "//div[text()='Your slot is reserved for 2 hrs']", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "StartShopping", "//button[text()='Start Shopping']", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "WaitroseHome", "//img[@data-dojo-attach-event='click:_goHome']", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("set", "SearchBoxinHomePage", "//div[@id='waitrose/widgets/Heading_0']//input[@placeholder='Search']", "rankin selection Irish fruit soda bread")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "SearchIcon", "//div[@id='waitrose/widgets/Heading_0']//i", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "AddGroceryProduct", "//span[text()='Add']", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("set", "UpdateGroceryQuantity", "(//ul[@id='waitrose/widgets/TaxonomyCategoryStoreList_0']//input[@data-dojo-attach-point='quantityNode'])[1]", "10")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "WaitroseHomeIcon", "//img[@data-dojo-attach-event='click:_goHome']", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("set", "SearchBoxinHomePage", "//div[@id='waitrose/widgets/Heading_0']//input[@placeholder='Search']", "cake")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "SearchIcon", "//div[@id='waitrose/widgets/Heading_0']//i", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "EntertainingTab", "//li[@id='dojox_mobile_TabBarButton_1']", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "AddEntertainingProduct", "(//ul[@id='waitrose/widgets/TaxonomyCategoryStoreList_1']//span[text()='Add'])[1]", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("set", "UpdateEntertainingQty", "(//ul[@id='waitrose/widgets/TaxonomyCategoryStoreList_1']//input[@data-dojo-attach-point='quantityNode'])[1]", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "TrolleyIcon", "//div[@class='trolleyIcon']", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("verifyObject", "TrolleyPage", "//div[text()='Trolley']", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "CheckoutinTrolleyIcon", "//button[text()='Checkout']", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("verifyObject", "CheckoutPage", "//h1[text()='Checkout']", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "ContinuetoPaymentDetails", "//button[text()='Continue to payment details']", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("verifyObject", "PaymentDetailsPage", "//h3[contains(text(),'Payment details')]", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "GiftVOucher_Add", "//button[contains(text(),'Add a gift voucher')]", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("set", "GiftVoucher_SerialNumber", "(//input[@data-dojo-attach-point='_inputNumber'])[2]", "5001162023")+

		ACTION_SEPERATOR+

		getFormattedAction("set", "GiftVoucher_SecurityCode", "(//input[@data-dojo-attach-point='_inputCode'])[2]", "BBBBBBB")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "GiftVoucher_ApplyButton", "(//button[contains(text(),'Apply')])[2]", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "4")+

		ACTION_SEPERATOR+

		getFormattedAction("click", "PlaceYourOrder", "//button[text()='Place your order']", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("verifyObject", "OrderConfirmationPage", "//h3[contains(text(),'Order confirmation')]", "")+

		ACTION_SEPERATOR+

		getFormattedAction("wait", "WAIT", "", "2")+

		ACTION_SEPERATOR+

		getFormattedAction("verifyObject", "YourOrderisConfirmed", "//div[text()='Your order is confirmed']", "")+
	"");}

	catch(Exception e){

		updateReportDocument(e.getMessage());

	}

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
	//updates report document with the provided result
	private void updateReportDocument(String result){
		System.out.println("Res      "+result);
		if(result.contains(ACTION_SEPERATOR)){
			String[] testcases = result.split(TESTCASE_SEPERATOR);
			if(testcases.length>0){
				//Testcase String in result is of the form ScenarioName:TestcaseName _ startTime _ infoOfIterations _ endTime 
				//Lopp thru testcases
					for(int i=0;i<testcases.length;i++){
						if(testcases[i].contains(ACTION_SEPERATOR)){
							String testcaseStatus="";
							iterationspasscount=0;
							iterationsfailcount=0;
							iterationscompletedcount=0;
							iterationCount=0;
							String[] testcaseInfo = testcases[i].split(TESTCASE_INFO_SEPERATOR);
							String scenario = testcaseInfo[0].split(":")[0];
							String testcase = testcaseInfo[0].split(":")[1];
							testcaseElement = createTestcaseElement(testcase,scenario);
							testcaseElement.setAttribute("start-time",testcaseInfo[1]);
							testcaseElement.setAttribute("end-time",testcaseInfo[3]);
							String[] iterations = testcaseInfo[2].split(ITERATION_SEPERATOR);
							if(iterations.length>0){
								//Iteration String in result is of the form startTime _ infoOfActions _ endTime
								//Loop thru iterations
								for(int j=0;j<iterations.length;j++){
									int iterstatus;
									verifications=0;
									actionspasscount=0;
									actionscompletedCount=0;
									actionsCount=0;
									iterationElement = createIterationElement(iterationCount);
									String[] iterationsInfo = iterations[j].split(ITERATION_INFO_SEPERATOR);
									iterationElement.setAttribute("start-time",iterationsInfo[0]);
									iterationElement.setAttribute("end-time",iterationsInfo[2]);
									String[] actions = iterationsInfo[1].split(ACTION_SEPERATOR);
									if(actions.length>0){
										//Action String in result is of the form actionName _ User-friendly-MappingName _ urlOrXpath _ Value-to-send _ time _status
										//Loop thru actions
										for(int k=0;k<actions.length;k++){
											String[] actionInfo = actions[k].split(ACTION_INFO_SEPERATOR);
											String action = actionInfo[0];
											boolean isVerification = action.equals("verify") || action.equals("verifyObject");
											if(isVerification){
												verifications++;
												String verStatus = actionInfo[5];
												if(verStatus.equals("pass")){
													actionspasscount++;
												}
											}
											actionscompletedCount++;
											Element actionElement = createActionElement(actionInfo[5],String.valueOf(k),actionInfo[1],actionInfo[3],actionInfo[0] );
											actionElement.setAttribute("action-time", actionInfo[4]);
											iterationElement.appendChild(actionElement);
										}
									}
									if(verifications==0){
										if(actionsCount==actionscompletedCount){
											iterstatus=COMPLETED;
										}
										else{
											iterstatus=FAIL;
										}
									}
									else{
										if(verifications==actionspasscount){
											iterstatus=PASS;
										}
										else{
											iterstatus=FAIL;
										}
									}
									iterationElement.setAttribute("iteration-status", getStatus(iterstatus));
									iterationsElement.appendChild(iterationElement);
									iterationCount++;
									updateIterationCounters(iterstatus);
								}
							}
							if(iterationsfailcount>0){
								testcaseStatus="fail";
							}
							else if(iterationspasscount==iterationCount){
								testcaseStatus="pass";
							}
							else{
								testcaseStatus="completed";
							}
							testcaseElement.setAttribute("status", testcaseStatus);
							testcasesElement.appendChild(testcaseElement);
						}
					}
					saveReport();
				}
			}
		}

	//method to create a testcase-action DOM element
	private Element createActionElement(String status,String index,String type,String inputVal,String name){
		Element actionControlElement = document.createElement("action-control");
		actionControlElement.setAttribute("name", name);
		actionControlElement.setAttribute("action-remarks", status);
		actionControlElement.setAttribute("input-value", inputVal);
		actionControlElement.setAttribute("number", index);
		actionControlElement.setAttribute("type", type);
		actionControlElement.setAttribute("screenshot", "");
		Element remarksDescElement = document.createElement("remarks-description");
		remarksDescElement.appendChild( document.createTextNode(status) );
		actionControlElement.appendChild(remarksDescElement);
		return actionControlElement;
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
			WebDriver webDriver= new Augmenter().augment(driver);
			TakesScreenshot takesScreenshot=(TakesScreenshot) webDriver;
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