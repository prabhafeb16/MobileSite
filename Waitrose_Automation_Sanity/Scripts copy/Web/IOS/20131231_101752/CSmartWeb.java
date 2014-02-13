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
	private static String screenshot_path="/Users/StaplesMac/CSMart_Workspace/Waitrose_Automation_SanitySuite/Reports/Web/IOS/20131223_103114";
	private static String current_testcase_name="";
	private static SimpleDateFormat screenshotFormat;
	private static String SELECT_TAG="select";
	

	//Class Constructor
	public CSmartWeb() throws Exception {
		try{
		//initialize the IPhoneDriver for executing in iOS platform
		//driver = new IPhoneDriver();
		driver = new RemoteWebDriver(new URL("http://192.168.1.105:3001/wd/hub"), DesiredCapabilities.iphone());
		reportFile = new File("/Users/StaplesMac/CSMart_Workspace/Waitrose_Automation_Test4/Reports/Web/IOS/20131231_101752/Master.xml");
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
		TransformerFactory transformerFactory=TransformerFactory.newInstance();
		Transformer transformer=transformerFactory.newTransformer();
		DOMSource domSource=new DOMSource(document);
		StreamResult result=new StreamResult(reportFile);
		transformer.transform(domSource, result);
		}catch(Exception e){
		e.printStackTrace();
		}
	}

	@Test//test method for the SanityTestSuiteTC1_LightRegistration
	public void testSanityTestSuiteTC1_LightRegistration() throws Exception {
		String testcaseStatus="";
		current_testcase_name="TC1_LightRegistration";
		iterationspasscount=0;
		iterationsfailcount=0;
		iterationscompletedcount=0;
		iterationCount=0;
		int status=-1;
		testcaseElement = createTestcaseElement("TC1_LightRegistration","SanityTestSuite");

		f();
		//status=SanityTestSuiteTC1_LightRegistrationIteration0(iterationCount);
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

		//testcaseElement.setAttribute("status", testcaseStatus);
		testcaseElement.setAttribute("end-time",dateFormat.format(Calendar.getInstance().getTime()) );
		testcasesElement.appendChild(testcaseElement);
		saveReport();
	}

	  private String getFormattedAction(String action , String mappingName , String urlOrXpath , String keysToSend ,boolean isLAstAction){
          
          String formattedAction = action+"_actionSeperator_"+mappingName+"_actionSeperator_"+urlOrXpath+"_valueSeperator_"+keysToSend;
          if(!isLAstAction){
                 formattedAction = formattedAction + ";";
          }
          return formattedAction;
         
   }
	

public void f(){
		
		try{
			//example
			driver.get(	getFormattedAction("url", "LoadUrl", "https://wtr-mob-test4.tiffani.co.uk/worklight/apps/services/www/Waitrose_Real/mobilewebapp/default/Waitrose_Real.html", "", false)+
						getFormattedAction("click", "MenuButton", "//span[@id='dojox_mobile_ToolBarButton_5']", "", false)+
						getFormattedAction("wait", "", "", "2", false)+
						getFormattedAction("click", "RegisterButtoninMenu", "//button[@id='dojox_mobile_Button_7']", "", false)+
                        getFormattedAction("wait", "", "", "2", false)+
						getFormattedAction("verifyObject", "RegisterPage", "//h1[text()='Register']", "", false)+
						getFormattedAction("set", "EmailField", "//input[@id='dojox_mobile_TextBox_3']", "ice1test45@wtr-test.net", false)+
						getFormattedAction("set", "Password", "//input[@id='dojox_mobile_TextBox_4']", "test1234", false)+
						getFormattedAction("set", "ConfirmPassword", "//input[@id='dojox_mobile_TextBox_5']", "test1234", false)+
						getFormattedAction("wait", "", "", "2", false)+
						getFormattedAction("click", "Dont Sign up for Waitrose checkbox", "//input[@id='dojox_mobile_CheckBox_1']", "", false)+
						getFormattedAction("wait", "", "", "2", false)+
						getFormattedAction("click", "Register Button in Register Page", "//button[text()='Register']", "", false)+
						getFormattedAction("wait", "", "", "2", false)+
						getFormattedAction("verifyObject", "Registration Successful Message", "//p[contains(text(),'You have created a Waitrose.com account. An email confirmation will be sent to you shortly')]", "", false)+
						getFormattedAction("wait", "", "", "2", false)+
						getFormattedAction("click", "Continue", "//button[contains(text(),'Continue')]", "", false)+
						getFormattedAction("click", "Menu", "//span[@id='dojox_mobile_ToolBarButton_5']", "", false)+
						getFormattedAction("verify", "Logged in User", "//div[@ data-dojo-attach-point='_loggedInWelcomeName']", "ice1test45@wtr-test.net", false)+
						getFormattedAction("wait", "", "", "2", false)+
						getFormattedAction("click", "Log out", "//div[contains(text(),'Logout')]", "", true)
						
						
					);
			
			
			
			
			/*driver.get(	"url_actionSeperator_LoadUrl_actionSeperator_https://m.waitrose.com_valueSeperator_;" +
					"click_actionSeperator_MenuButton_actionSeperator_//span[@id='dojox_mobile_ToolBarButton_7']_valueSeperator_;" +
					//"wait_actionSeperator__valueSeperator_2;" +
					//"click_actionSeperator_//div[@id='waitrose/widgets/scrollablePane_1']/div/div[2]/div/span[2]_valueSeperator_;"+ 
					"click_actionSeperator_BookSlotButton_actionSeperator_//div[contains(text(),'Book Slot')]_valueSeperator_;"+ 
					//"wait_actionSeperator__valueSeperator_2;" +
					"click_actionSeperator_WeDeliverTab_actionSeperator_//div[contains(text(),'We deliver')]_valueSeperator_;"+	
					"wait_actionSeperator__actionSeperator__valueSeperator_5;" +
					"verify_actionSeperator_LoginButton_actionSeperator_//div[contains(text(),'Login')]_valueSeperator_Login;"+	
					"set_actionSeperator_EmailField_actionSeperator_//input[@id='dojox_mobile_TextBox_0']_valueSeperator_prod1test1@wtr-test.net;"	+
					"set_actionSeperator_PasswordField_actionSeperator_//input[@id='dojox_mobile_TextBox_1']_valueSeperator_test1234;"	+
					//"set_actionSeperator_//input[@id='dojox_mobile_TextBox_5']_valueSeperator_test1234;"+
					"click_actionSeperator_LoginButton_actionSeperator_//button[contains(text(),'Login')]_valueSeperator_"
					
					/*"wait_actionSeperator__actionSeperator__valueSeperator_5;" +
					"click_actionSeperator_BookSlotButton_actionSeperator_//button[@id='dojox_mobile_Button_20']_valueSeperator_;"+
					"click_actionSeperator_CalendarIcon_actionSeperator_//div[@id='waitrose_widgets_CalendarIcon_33']_valueSeperator_;"+
					"click_actionSeperator_AvailableTime_actionSeperator_//div[@id='waitrose_widgets_AvailableTimes_5']_valueSeperator_;"+
					"wait_actionSeperator__actionSeperator__valueSeperator_2;"+
					"click_actionSeperator__actionSeperator_//span[@id='dojox_mobile_ToolBarButton_29']_valueSeperator_;"+
					"verifyObject_actionSeperator_Your slot is reserved for 2 hrs_actionSeperator_//span[contains(text(),'Your slot is reserved for 2 hrs')]_valueSeperator_;"+
					"click_actionSeperator_StartShoppingBtn_actionSeperator_//span[contains(text(),'Start Shopping')]_valueSeperator_;"+
					"set_actionSeperator_SearchBar_actionSeperator_//form[@id='waitrose_widgets_SearchWidget_3']/input[1]_valueSeperator_chicken;"+
					"click_actionSeperator_Category_actionSeperator_//form[@id='waitrose_widgets_SearchWidget_3']/span[1]_valueSeperator_;"+
					"click_actionSeperator_AddButton_actionSeperator_//span[text()='Add']_valueSeperator_;"+
					"set_actionSeperator__actionSeperator_(//ul[@id='waitrose/widgets/TaxonomyCategoryStoreList_0']//input[@data-dojo-attach-point='quantityNode'])[1]_valueSeperator_31;"	+
					"click_actionSeperator_Home_actionSeperator_//img[@data-dojo-attach-event='click:_goHome']_valueSeperator_;"+*/
					
					//"set_actionSeperator_//form[@id='waitrose_widgets_SearchWidget_0']/input[1]_valueSeperator_Cakes;"	+
					//"click_actionSeperator_//form[@id='waitrose_widgets_SearchWidget_0']/span[1]_valueSeperator_;"+
					//"click_actionSeperator_//li[@id='dojox_mobile_TabBarButton_1']_valueSeperator_;"+
					//"click_actionSeperator_(//ul[@id='waitrose/widgets/TaxonomyCategoryStoreList_1']//span[text()='Add'])[1]_valueSeperator_;"+
					//"set_actionSeperator_(//ul[@id='waitrose/widgets/TaxonomyCategoryStoreList_1']//input[@data-dojo-attach-point='quantityNode'])[1]_valueSeperator_31;"	+
					
					/*"click_actionSeperator__actionSeperator_//span[@id='dojox_mobile_ToolBarButton_8']_valueSeperator_;"+
					"click_actionSeperator_Checkout_actionSeperator_//span[@title='Checkout']_valueSeperator_;"+
					"verifyObject_actionSeperator_CheckoutOrderPreview_actionSeperator_//div[@id='CheckoutOrderPreview']_valueSeperator_;"+
					"click_actionSeperator_Continue to payment details_actionSeperator_//span[text()='Continue to payment details']_valueSeperator_;"+
					"verifyObject_actionSeperator_Payment details_actionSeperator_//span[contains(text(),'Payment details')]_valueSeperator_;"+
					"set_actionSeperator__actionSeperator_//input[@id='dojox_mobile_TextBox_6']_valueSeperator_4111111111111111;"	+
					"click_actionSeperator_Month_actionSeperator_//button[@ data-dojo-attach-point='_validFromMonth']_valueSeperator_;"+
					"click_actionSeperator__actionSeperator_//span[@id='dijit_form_Button_6']_valueSeperator_;"+
					"click_actionSeperator_Year_actionSeperator_//button[@data-dojo-attach-point='_validFromYear']_valueSeperator_;"+
					"click_actionSeperator__actionSeperator_//span[@id='dijit_form_Button_13']_valueSeperator_;"+
					"click_actionSeperator__actionSeperator_//button[@data-dojo-attach-point='_validToMonth']_valueSeperator_;"+
					"click_actionSeperator__actionSeperator_//span[text()='08']_valueSeperator_;"+
					"click_actionSeperator__actionSeperator_//button[@data-dojo-attach-point='_validToYear']_valueSeperator_;"+
					"click_actionSeperator__actionSeperator_//span[text()='16']_valueSeperator_;"+
					"set_actionSeperator_KathyJones_actionSeperator_//input[@data-dojo-attach-point='_enterName']_valueSeperator_KathyJones"*/
					
				    /*"click_actionSeperator_//span[text()='Place your order']_valueSeperator_;"+
				    "verifyObject_actionSeperator_//span[text()='Order Confirmation']_valueSeperator_;"+
				    "verifyObject_actionSeperator_//span[text()='Your order is confirmed.']_valueSeperator_;"+
				    "click_actionSeperator_//span[text()='Edit order']_valueSeperator_;"+
				    "verifyObject_actionSeperator_//span[text()='My Orders']_valueSeperator_;"+
					"click_actionSeperator_//div[text()='Order Status: Pending']_valueSeperator_;"+
					"verifyObject_actionSeperator_//div[text()='Order details']_valueSeperator_;"+
					"click_actionSeperator_//button[text()='Edit Order']_valueSeperator_;"+
					"click_actionSeperator_//span[text()='Continue shopping']_valueSeperator_;"+
					"set_actionSeperator_//form[@id='waitrose_widgets_SearchWidget_3']/input[1]_valueSeperator_fruitcake;"	+
					"click_actionSeperator_//form[@id='waitrose_widgets_SearchWidget_3']/span[1]_valueSeperator_;"+
					"click_actionSeperator_//span[text()='Add']_valueSeperator_;"+
					"set_actionSeperator_(//ul[@id='waitrose/widgets/TaxonomyCategoryStoreList_0']//input[@data-dojo-attach-point='quantityNode'])[1]_valueSeperator_2;"	+
					"click_actionSeperator_//img[@data-dojo-attach-event='click:_goHome']_valueSeperator_;"+
					"click_actionSeperator_//span[@id='dojox_mobile_ToolBarButton_8']_valueSeperator_;"+
					"click_actionSeperator_//span[@title='Checkout']_valueSeperator_;"+
					"wait_actionSeperator__valueSeperator_2;"+
					"click_actionSeperator_//span[text()='Continue to payment details']_valueSeperator_;"+
					"wait_actionSeperator__valueSeperator_2;"+
					"click_actionSeperator_//span[text()='Place your order']_valueSeperator_;"+
					"verifyObject_actionSeperator_//span[text()='Order Confirmation']_valueSeperator_;"+
				    "verifyObject_actionSeperator_//span[text()='Your order is confirmed.']_valueSeperator_"
					//"_iterationSeperator_"
					
					
					//"url_actionSeperator_https://m.waitrose.com_valueSeperator_;" +
					/*"click_actionSeperator_//span[@id='dojox_mobile_ToolBarButton_7']_valueSeperator_;" +
					"click_actionSeperator_//button[@id='dojox_mobile_Button_6']_valueSeperator_;"	+
					"set_actionSeperator_//input[@id='dojox_mobile_TextBox_3']_valueSeperator_waitroseid6@wtr-test.net;"	+
					"set_actionSeperator_//input[@id='dojox_mobile_TextBox_4']_valueSeperator_test1234;"	+
					"set_actionSeperator_//input[@id='dojox_mobile_TextBox_5']_valueSeperator_test1234;"+
					"click_actionSeperator_//input[@id='dojox_mobile_CheckBox_1']_valueSeperator_;"+
					"click_actionSeperator_//button[text()='Register']_valueSeperator_;"+
					"click_actionSeperator_//button[contains(text(),'Continue')]_valueSeperator_;"+
					"click_actionSeperator_//span[@id='dojox_mobile_ToolBarButton_7']_valueSeperator_"
					
				);*/
		}
		catch(Exception e){
			System.out.println("Response   "+e.getMessage());
		    String response = e.getMessage();
			String[] iterations = response.split("_iterationSeperator_");
			for(int i=0;i<iterations.length;i++){
				
				if(!iterations[i].equals("")){
					
					iterationElement = createIterationElement(i);
					String[] actions = iterations[i].split(";");
					for(int j=0;j<actions.length;j++){
					
						if(!actions[j].equals("")){
							
							String[] actionInfo = actions[j].split(":");							
							iterationElement.appendChild(createActionElement( actionInfo[4],String.valueOf(j),actionInfo[1],actionInfo[3],actionInfo[0]));
							
						}
						
					}
					//iterationElement.setAttribute("iteration-status", getStatus(status));
					iterationElement.setAttribute("end-time", dateFormat.format(Calendar.getInstance().getTime()));
					iterationsElement.appendChild(iterationElement);
					
				}
				
				
			}
			
			
			
		}
		
		
	}
	
	//method Definition for the SanityTestSuiteTC1_LightRegistrationIteration0
public int SanityTestSuiteTC1_LightRegistrationIteration0(int iterationCnt){
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

	System.out.println("Executing	Action-CLICK		Xpath-//span[@id='dojox_mobile_ToolBarButton_5']		");
	iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[@id='dojox_mobile_ToolBarButton_5']",""),"2","SPAN","","CLICK" ));

	System.out.println("Executing	Action-WAIT		Timeout-2		");
	iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"3","","","WAIT" ));

	System.out.println("Executing	Action-CLICK		Xpath-//button[@id='dojox_mobile_Button_7']		");
	iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[@id='dojox_mobile_Button_7']",""),"4","BUTTON","","CLICK" ));

	System.out.println("Executing	Action-WAIT		Timeout-2		");
	iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"5","","","WAIT" ));

	System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//h1[text()='Register']		Timeout-1		");
	iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//h1[text()='Register']",""),"6","DIV","1","VERIFYOBJECT" ));

	System.out.println("Executing	Action-WAIT		Timeout-2		");
	iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"7","","","WAIT" ));

	System.out.println("Executing	Action-SET		Xpath-//input[@id='dojox_mobile_TextBox_3']		");
	iterationElement.appendChild(createActionElement( executeAction(SET, "aish7test41@wtr-test.net", false, "//input[@id='dojox_mobile_TextBox_3']",""),"8","INPUT","aish7test41@wtr-test.net","SET" ));

	System.out.println("Executing	Action-SET		Xpath-//input[@id='dojox_mobile_TextBox_4']		");
	iterationElement.appendChild(createActionElement( executeAction(SET, "test1234", false, "//input[@id='dojox_mobile_TextBox_4']",""),"9","INPUT","test1234","SET" ));

	System.out.println("Executing	Action-SET		Xpath-//input[@id='dojox_mobile_TextBox_5']		");
	iterationElement.appendChild(createActionElement( executeAction(SET, "test1234", false, "//input[@id='dojox_mobile_TextBox_5']",""),"10","INPUT","test1234","SET" ));

	System.out.println("Executing	Action-WAIT		Timeout-2		");
	iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"11","","","WAIT" ));

	System.out.println("Executing	Action-CLICK		Xpath-//input[@id='dojox_mobile_CheckBox_1']		");
	iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//input[@id='dojox_mobile_CheckBox_1']",""),"12","INPUT","","CLICK" ));

	System.out.println("Executing	Action-WAIT		Timeout-2		");
	iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"13","","","WAIT" ));

	System.out.println("Executing	Action-CLICK		Xpath-//button[text()='Register']		");
	iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[text()='Register']",""),"14","BUTTON","","CLICK" ));

	System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//p[contains(text(),'You have created a Waitrose.com account. An email confirmation will be sent to you shortly')]		Timeout-1		");
	iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//p[contains(text(),'You have created a Waitrose.com account. An email confirmation will be sent to you shortly')]",""),"15","P","1","VERIFYOBJECT" ));

	System.out.println("Executing	Action-CLICK		Xpath-//button[contains(text(),'Continue')]		");
	iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[contains(text(),'Continue')]",""),"16","BUTTON","","CLICK" ));

	System.out.println("Executing	Action-WAIT		Timeout-2		");
	iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"17","","","WAIT" ));

	System.out.println("Executing	Action-CLICK		Xpath-//span[@id='dojox_mobile_ToolBarButton_5']		");
	iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[@id='dojox_mobile_ToolBarButton_5']",""),"18","SPAN","","CLICK" ));

	System.out.println("Executing	Action-VERIFY		Xpath-//span[@id='dojox_mobile_ToolBarButton_5']		");
	iterationElement.appendChild(createActionElement( executeAction(VERIFY, "aish7test41@wtr-test.net", false, "//span[@id='dojox_mobile_ToolBarButton_5']",""),"19","SPAN","aish7test41@wtr-test.net","VERIFY" ));

	System.out.println("Executing	Action-CLICK		Xpath-//div[contains(text(),'Logout')]		");
	iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[contains(text(),'Logout')]",""),"20","DIV","","CLICK" ));
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
			WebDriverWait wait = new WebDriverWait(driver, 45);
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
	
	
	//method to create a testcase-action DOM element
		/**
		 * @param status 
		 * @param index
		 * @param type
		 * @param inputVal
		 * @param name
		 * @return
		 */
		private Element createActionElement(String status,String index,String type,String inputVal,String name){
			Element actionControlElement = document.createElement("action-control");
			actionControlElement.setAttribute("name", name);
			actionControlElement.setAttribute("action-remarks", status);
			actionControlElement.setAttribute("action-time", dateFormat.format(Calendar.getInstance().getTime()));
			actionControlElement.setAttribute("input-value", inputVal);
			actionControlElement.setAttribute("number", index);
			actionControlElement.setAttribute("type", type);
			actionControlElement.setAttribute("screenshot", "");
			Element remarksDescElement = document.createElement("remarks-description");
			remarksDescElement.appendChild( document.createTextNode(status) );
			actionControlElement.appendChild(remarksDescElement);
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

				case SET		:	//updateDriver(iframePath);
									//waitForObject(byid,idOrxpath,60);
									element=getElement(byid, idOrxpath);
									handleSetValue(element, valueOrUrl);
									//restoreDriverToDefaultContent();
									status=COMPLETED;break;

				case CLICK		:	//updateDriver(iframePath);
									//waitForObject(byid,idOrxpath,60);
									element=getElement(byid, idOrxpath);
									element.click();
									//restoreDriverToDefaultContent();
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
									actionspasscount++;
									}
									else{
									status=FAIL;
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
									actionspasscount++;
									}
									else{
									status=FAIL;
									}
									restoreDriverToDefaultContent();
									break;

				case IS_SELECTED		:	verifications++;
									updateDriver(iframePath);waitForObject(byid,idOrxpath,60);element=getElement(byid,idOrxpath);
									if(element.isSelected()){
									status=PASS;
									actionspasscount++;
									}
									else{
									status=FAIL;
									}
									restoreDriverToDefaultContent();
									break;

			}
			actionscompletedCount++;
			return status;
		}
		catch(Exception e){
			return ERROR;
		}
	}

	//fetches the specified element 
			private WebElement getElement(boolean byid,String idOrXpath){
				System.out.println("Abt to find..."+idOrXpath);
				WebElement element ;
				WebDriverWait wait = new WebDriverWait(driver, 45);
				if(byid){
					element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(idOrXpath)));
					return element;
				}else{
					element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(idOrXpath)));
					System.out.println("Abt to return ...     "+element);
					return element;
				}
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
			FileUtils.copyFile(file, new File(imageName));
		} catch (Exception e) {
			e.printStackTrace();
			}
	}
	//gets ip from the configuration xml file 
	private String getIpFromConfiguration(String configXmlPath){
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance(); 
		try { 
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder(); 
			Document document=documentBuilder.parse(new File(configXmlPath)); 
			return document.getElementsByTagName("ip").item(0).getTextContent(); 
		} catch (ParserConfigurationException e) { 
			e.printStackTrace(); 
		}catch (SAXException e) {  
			e.printStackTrace(); 
		} catch (IOException e) {
			e.printStackTrace(); 
		} 
		return null; 
	} 
}