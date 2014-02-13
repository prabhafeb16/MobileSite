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
	private static String screenshot_path="/Users/StaplesMac/CSMart_Workspace/Waitrose_Automation_Test4/Reports/Web/IOS/20131231_130737";
	private static String current_testcase_name="";
	private static SimpleDateFormat screenshotFormat;
	private static String SELECT_TAG="select";
	

	//Class Constructor
	public CSmartWeb() throws Exception {
		try{
		//initialize the IPhoneDriver for executing in iOS platform
		driver = new IPhoneDriver();
		reportFile = new File("/Users/StaplesMac/CSMart_Workspace/Waitrose_Automation_Test4/Reports/Web/IOS/20131231_130737/Master.xml");
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

	@Test//test method for the SanityTestSuiteTC3_MyWaitroseRegistration
	public void testSanityTestSuiteTC3_MyWaitroseRegistration() throws Exception {
		String testcaseStatus="";
		current_testcase_name="TC3_MyWaitroseRegistration";
		iterationspasscount=0;
		iterationsfailcount=0;
		iterationscompletedcount=0;
		iterationCount=0;
		int status=-1;
		testcaseElement = createTestcaseElement("TC3_MyWaitroseRegistration","SanityTestSuite");

		status=SanityTestSuiteTC3_MyWaitroseRegistrationIteration0(iterationCount);
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
		saveReport();
	}


	//method Definition for the SanityTestSuiteTC3_MyWaitroseRegistrationIteration0
	public int SanityTestSuiteTC3_MyWaitroseRegistrationIteration0(int iterationCnt){
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

		System.out.println("Executing	Action-SET		Xpath-//input[@id='dojox_mobile_TextBox_3']		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "aish7test44@wtr-test.net", false, "//input[@id='dojox_mobile_TextBox_3']",""),"6","INPUT","aish7test44@wtr-test.net","SET" ));

		System.out.println("Executing	Action-SET		Xpath-//input[@id='dojox_mobile_TextBox_4']		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "test1234", false, "//input[@id='dojox_mobile_TextBox_4']",""),"7","INPUT","test1234","SET" ));

		System.out.println("Executing	Action-SET		Xpath-//input[@id='dojox_mobile_TextBox_5']		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "test1234", false, "//input[@id='dojox_mobile_TextBox_5']",""),"8","INPUT","test1234","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"9","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[text()='Register']		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[text()='Register']",""),"10","BUTTON","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"11","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//p[contains(text(),'Congratulations - you have created a Waitrose.com account. Please provide us with some more information to complete your registration for myWaitrose.')]		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//p[contains(text(),'Congratulations - you have created a Waitrose.com account. Please provide us with some more information to complete your registration for myWaitrose.')]",""),"12","P","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[contains(text(),'Continue')]		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[contains(text(),'Continue')]",""),"13","BUTTON","","CLICK" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//h1[text()='myWaitrose']		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//h1[text()='myWaitrose']",""),"14","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-SET		Xpath-//input[@data-dojo-attach-point='_enterScreenName']		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "ScrenHello1", false, "//input[@data-dojo-attach-point='_enterScreenName']",""),"15","INPUT","ScrenHello1","SET" ));

		System.out.println("Executing	Action-SET		Xpath-//input[@data-dojo-attach-point='__enterTitle']		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "Miss", false, "//input[@data-dojo-attach-point='__enterTitle']",""),"16","INPUT","Miss","SET" ));

		System.out.println("Executing	Action-SET		Xpath-//input[@data-dojo-attach-point='_enterFirstName']		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "Janet", false, "//input[@data-dojo-attach-point='_enterFirstName']",""),"17","INPUT","Janet","SET" ));

		System.out.println("Executing	Action-SET		Xpath-//input[@data-dojo-attach-point='_enterLastName']		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "James", false, "//input[@data-dojo-attach-point='_enterLastName']",""),"18","INPUT","James","SET" ));

		System.out.println("Executing	Action-SET		Xpath-//input[@data-dojo-attach-point='_addressNickname']		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "Home", false, "//input[@data-dojo-attach-point='_addressNickname']",""),"19","INPUT","Home","SET" ));

		System.out.println("Executing	Action-SET		Xpath-//input[@data-dojo-attach-point='_enterPostcode']		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "RG128YA", false, "//input[@data-dojo-attach-point='_enterPostcode']",""),"20","INPUT","RG128YA","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"21","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[contains(text(),'Find address')]		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[contains(text(),'Find address')]",""),"22","BUTTON","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"23","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-(//li[@class='mblListItem']/div[2]/span)[1]		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "(//li[@class='mblListItem']/div[2]/span)[1]",""),"24","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"25","","","WAIT" ));

		System.out.println("Executing	Action-SET		Xpath-//input[@data-dojo-attach-point='_enterPhone']		");
		iterationElement.appendChild(createActionElement( executeAction(SET, "6477200772", false, "//input[@data-dojo-attach-point='_enterPhone']",""),"26","INPUT","6477200772","SET" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"27","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[@id='dojox_mobile_Button_50']		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[@id='dojox_mobile_Button_50']",""),"28","BUTTON","","CLICK" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//p[contains(text(),'You have successfully registered and can now start enjoying all the benefits of being a myWaitrose customer')]		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//p[contains(text(),'You have successfully registered and can now start enjoying all the benefits of being a myWaitrose customer')]",""),"29","P","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"30","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//button[@id='dojox_mobile_Button_56']		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//button[@id='dojox_mobile_Button_56']",""),"31","BUTTON","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"32","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//span[@id='dojox_mobile_ToolBarButton_5']		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[@id='dojox_mobile_ToolBarButton_5']",""),"33","SPAN","","CLICK" ));

		System.out.println("Executing	Action-VERIFY		Xpath-//div[@id='dojox_mobile_Container_0']
		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFY, "JanetJames", false, "//div[@id='dojox_mobile_Container_0']
",""),"34","DIV","JanetJames","VERIFY" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"35","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[contains(text(),'Logout')]		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[contains(text(),'Logout')]",""),"36","DIV","","CLICK" ));
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
}