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
	private static String screenshot_path="/Users/StaplesMac/CSMart_Workspace/Waitrose_Automation_Test4/Reports/Web/IOS/20131231_130752";
	private static String current_testcase_name="";
	private static SimpleDateFormat screenshotFormat;
	private static String SELECT_TAG="select";
	

	//Class Constructor
	public CSmartWeb() throws Exception {
		try{
		//initialize the IPhoneDriver for executing in iOS platform
		driver = new IPhoneDriver();
		reportFile = new File("/Users/StaplesMac/CSMart_Workspace/Waitrose_Automation_Test4/Reports/Web/IOS/20131231_130752/Master.xml");
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

	@Test//test method for the SanityTestSuiteTC5_ProductTaxonomy_LoanItemPricingValidationinPLPandPDP
	public void testSanityTestSuiteTC5_ProductTaxonomy_LoanItemPricingValidationinPLPandPDP() throws Exception {
		String testcaseStatus="";
		current_testcase_name="TC5_ProductTaxonomy_LoanItemPricingValidationinPLPandPDP";
		iterationspasscount=0;
		iterationsfailcount=0;
		iterationscompletedcount=0;
		iterationCount=0;
		int status=-1;
		testcaseElement = createTestcaseElement("TC5_ProductTaxonomy_LoanItemPricingValidationinPLPandPDP","SanityTestSuite");

		status=SanityTestSuiteTC5_ProductTaxonomy_LoanItemPricingValidationinPLPandPDPIteration0(iterationCount);
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
		saveReport();
	}


	//method Definition for the SanityTestSuiteTC5_ProductTaxonomy_LoanItemPricingValidationinPLPandPDPIteration0
	public int SanityTestSuiteTC5_ProductTaxonomy_LoanItemPricingValidationinPLPandPDPIteration0(int iterationCnt){
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

		System.out.println("Executing	Action-CLICK		Xpath-//div[contains(text(),'Shop Groceries')]		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[contains(text(),'Shop Groceries')]",""),"4","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"5","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//div[contains(text(),'
    Groceries
    
        
        
            
                
                
                    
                

            

        
        Cancel
        
        
        



    



    ')]/div[1]		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[contains(text(),'
    Groceries
    
        
        
            
                
                
                    
                

            

        
        Cancel
        
        
        



    



    ')]/div[1]",""),"6","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"7","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//div[contains(text(),'Food Cupboard')]		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[contains(text(),'Food Cupboard')]",""),"8","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//div[contains(text(),'Fresh')]		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[contains(text(),'Fresh')]",""),"9","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//div[contains(text(),'Health & Beauty')]		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[contains(text(),'Health & Beauty')]",""),"10","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//div[contains(text(),'Drinks')]		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[contains(text(),'Drinks')]",""),"11","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//div[contains(text(),'Home & Household')]		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[contains(text(),'Home & Household')]",""),"12","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//div[contains(text(),'Fruit & Veg')]		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[contains(text(),'Fruit & Veg')]",""),"13","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//div[contains(text(),'Bakery')]		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[contains(text(),'Bakery')]",""),"14","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//div[contains(text(),'Frozen')]		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[contains(text(),'Frozen')]",""),"15","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//div[contains(text(),'Baby')]		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[contains(text(),'Baby')]",""),"16","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//div[contains(text(),'Pets')]		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[contains(text(),'Pets')]",""),"17","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"18","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[contains(text(),'Food Cupboard')]		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[contains(text(),'Food Cupboard')]",""),"19","DIV","","CLICK" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//div[contains(text(),'
        Grocer...
        
            
                
                
                    
                

            

        
        Cancel
        
        
        



    ')]		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[contains(text(),'
        Grocer...
        
            
                
                
                    
                

            

        
        Cancel
        
        
        



    ')]",""),"20","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"21","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[contains(text(),'All Food Cupboard')]		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[contains(text(),'All Food Cupboard')]",""),"22","DIV","","CLICK" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//div[contains(text(),'
        Food C...
        
            
                
                
                    
                

            

        
        Cancel
        
        
        



    ')]		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[contains(text(),'
        Food C...
        
            
                
                
                    
                

            

        
        Cancel
        
        
        



    ')]",""),"23","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"24","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//span[contains(text(),'essential Waitrose chopped tomatoes in natural juice')]		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[contains(text(),'essential Waitrose chopped tomatoes in natural juice')]",""),"25","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"26","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//div[contains(text(),'
        Back
        
            
                
                
                    
                

            

        
        Cancel
        
        
        



    ')]		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[contains(text(),'
        Back
        
            
                
                
                    
                

            

        
        Cancel
        
        
        



    ')]",""),"27","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"28","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//span[@id='dojox_mobile_ToolBarButton_5']		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[@id='dojox_mobile_ToolBarButton_5']",""),"29","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"30","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[contains(text(),'Shop Entertaining')]		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[contains(text(),'Shop Entertaining')]",""),"31","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"32","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//div[contains(text(),'
    Entertaining
    
        
        
            
                
                
                    
                

            

        
        Cancel
        
        
        



    



    ')]/div[1]		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[contains(text(),'
    Entertaining
    
        
        
            
                
                
                    
                

            

        
        Cancel
        
        
        



    



    ')]/div[1]",""),"33","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"34","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//div[contains(text(),'Dinner Parties')]		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[contains(text(),'Dinner Parties')]",""),"35","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//div[contains(text(),'Cakes')]		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[contains(text(),'Cakes')]",""),"36","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//div[contains(text(),'Party Food & Buffet')]		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[contains(text(),'Party Food & Buffet')]",""),"37","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//div[contains(text(),'Wedding Cakes')]		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[contains(text(),'Wedding Cakes')]",""),"38","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//div[contains(text(),'Menu Suggestions')]		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[contains(text(),'Menu Suggestions')]",""),"39","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//div[contains(text(),'Glass & Fish Kettle Loan')]		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[contains(text(),'Glass & Fish Kettle Loan')]",""),"40","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//div[contains(text(),'Merchandising Pages')]		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[contains(text(),'Merchandising Pages')]",""),"41","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"42","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//div[contains(text(),'Glass & Fish Kettle Loan')]		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//div[contains(text(),'Glass & Fish Kettle Loan')]",""),"43","DIV","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"44","","","WAIT" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//div[contains(text(),'
        Entert...
        
            
                
                
                    
                

            

        
        Cancel
        
        
        



    ')]		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[contains(text(),'
        Entert...
        
            
                
                
                    
                

            

        
        Cancel
        
        
        



    ')]",""),"45","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"46","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//li[@id='waitrose/widgets/TaxonomyCategoryListItem_41']/div[2]		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//li[@id='waitrose/widgets/TaxonomyCategoryListItem_41']/div[2]",""),"47","DIV","","CLICK" ));

		System.out.println("Executing	Action-VERIFYOBJECT		Xpath-//div[contains(text(),'
        Glass ...
        
            
                
                
                    
                

            

        
        Cancel
        
        
        



    ')]		Timeout-1		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFYOBJECT, "1", false, "//div[contains(text(),'
        Glass ...
        
            
                
                
                    
                

            

        
        Cancel
        
        
        



    ')]",""),"48","DIV","1","VERIFYOBJECT" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"49","","","WAIT" ));

		System.out.println("Executing	Action-VERIFY		Xpath-(//span[@data-dojo-attach-point='priceNode'])[1]		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFY, "0p", false, "(//span[@data-dojo-attach-point='priceNode'])[1]",""),"50","SPAN","0p","VERIFY" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"51","","","WAIT" ));

		System.out.println("Executing	Action-CLICK		Xpath-//span[contains(text(),'essential Waitrose chopped tomatoes in natural juice')]		");
		iterationElement.appendChild(createActionElement( executeAction(CLICK, "", false, "//span[contains(text(),'essential Waitrose chopped tomatoes in natural juice')]",""),"52","SPAN","","CLICK" ));

		System.out.println("Executing	Action-WAIT		Timeout-2		");
		iterationElement.appendChild(createActionElement( executeAction(WAIT, "2", true, "",""),"53","","","WAIT" ));

		System.out.println("Executing	Action-VERIFY		Xpath-//div[@id="waitrose/widgets/ProductSummary_0"]/div[3]/span[2]		");
		iterationElement.appendChild(createActionElement( executeAction(VERIFY, "0p", false, "//div[@id="waitrose/widgets/ProductSummary_0"]/div[3]/span[2]",""),"54","DIV","0p","VERIFY" ));
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