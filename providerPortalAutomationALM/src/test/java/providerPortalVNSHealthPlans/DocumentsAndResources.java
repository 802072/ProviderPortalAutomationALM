package providerPortalVNSHealthPlans;

import java.io.IOException;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import dataDrivenPP.dataDrivenPP;
import extentReport.BaseTest;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DocumentsAndResources extends BaseTest {

	JavascriptExecutor js = (JavascriptExecutor) driver;
	dataDrivenPP d = new dataDrivenPP();

	@BeforeTest
	public void loginProvider() throws InterruptedException, IOException {

		ArrayList TS0001 = d.getData("TS0001", "TC0037");
		String description1 = (String) TS0001.get(0) + " " + TS0001.get(1);
		extentTest.log(Status.PASS, description1);

		ArrayList TS0002 = d.getData("TS0002", "TC0037");
		String loginUrl = (String) TS0002.get(6);
		driver.get(loginUrl);

		String description2 = (String) TS0002.get(0) + " " + TS0002.get(1);
		extentTest.log(Status.PASS, description2,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description2 + ".jpg")).build());

		ArrayList TS0003 = d.getData("TS0003", "TC0037");
		String enterBtn = (String) TS0003.get(5);
		WebElement enter = driver.findElement(By.xpath(enterBtn));
		enter.click();

		String description3 = (String) TS0003.get(0) + " " + TS0003.get(1);
		extentTest.log(Status.PASS, description3,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description3 + ".jpg")).build());

		// enter username
		ArrayList TS0004 = d.getData("TS0004", "TC0037");
		String username = (String) TS0004.get(6);
		String unamePath = (String) TS0004.get(5);
		WebElement unameField = driver.findElement(By.xpath(unamePath));
		unameField.sendKeys(username);

		String description4 = (String) TS0004.get(0) + " " + TS0004.get(1);
		extentTest.log(Status.PASS, description4,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description4 + ".jpg")).build());

		// enter password
		ArrayList TS0005 = d.getData("TS0005", "TC0037");
		String pwdPath = (String) TS0005.get(5);
		WebElement pwd = driver.findElement(By.xpath(pwdPath));
		String password = (String) TS0005.get(6);
		pwd.sendKeys(password);

		String description5 = (String) TS0005.get(0) + " " + TS0005.get(1);
		extentTest.log(Status.PASS, description5,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description5 + ".jpg")).build());

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// login
		ArrayList TS0006 = d.getData("TS0006", "TC0037");
		String signOnPath = (String) TS0006.get(5);
		WebElement signOn = driver.findElement(By.xpath(signOnPath));
		signOn.click();

		Thread.sleep(5000);

		String description6 = (String) TS0006.get(0) + " " + TS0006.get(1);
		extentTest.log(Status.PASS, description6,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description6 + ".jpg")).build());

		Thread.sleep(5000);
		WebElement communiCenter = driver.findElement(By.xpath("//a[contains(text(),'Communication Center')]"));

		try {
			communiCenter.click();
		} catch (StaleElementReferenceException e) {
			communiCenter = driver.findElement(By.xpath("//a[contains(text(),'Communication Center')]"));
			communiCenter.click();
		}

		// SEND MESSAGE
		WebElement sendBtn = driver.findElement(By.xpath("//button[normalize-space()='Send a Message']"));
		sendBtn.click();

		WebElement drpSub = driver.findElement(By.xpath("//select[@name='ProviderSubject']"));
		drpSub.click();
		WebElement claimsInq = driver.findElement(By.xpath("//option[@value='Subject_Claims_Inquiry']"));
		claimsInq.click();

		WebElement msgBox = driver.findElement(By.xpath("//textarea"));
		msgBox.sendKeys("Test");

		WebElement nextBtn = driver.findElement(By.xpath("//button[normalize-space()='Next']"));
		nextBtn.click();
		Thread.sleep(3000);

	}

//	@Test(priority = 1, description = "9.1 PROV-TECH-REQ-045 - Documents and Resources - Verify Create a lightning page to display document information")
//	public void verifyResourcesDisplay() throws InterruptedException, IOException {
//		
//		
//		Thread.sleep(5000);
//		//Click Resources Link
//		ArrayList TS0007 = d.getData("TS0007", "TC0037");
//		String resourcesPath = (String) TS0007.get(5);
//		WebElement resources = driver.findElement(By.xpath(resourcesPath));
//		resources.click();
//		Thread.sleep(5000);
//		String description7 = (String) TS0007.get(0) + " " + TS0007.get(1);
//		extentTest.log(Status.PASS, description7,
//				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description7 + ".jpg")).build());
//
//		//
//		ArrayList TS0008 = d.getData("TS0008", "TC0037");
//		String resTypeBtnPath = (String) TS0008.get(5);
//		WebElement resourceType = driver.findElement(By.xpath(resTypeBtnPath));
//		resourceType.click();
//		Thread.sleep(5000);
//		String description8 = (String) TS0008.get(0) + " " + TS0008.get(1);
//		extentTest.log(Status.PASS, description8,
//				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description8 + ".jpg")).build());
//	
//		ArrayList<String> TS0009 = d.getData("TS0009", "TC0037");
//		String documentPath = (String) TS0009.get(5);
//		WebElement document = driver.findElement(By.xpath(documentPath));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", document);
//		document.click();
//		//document.click();
//		Thread.sleep(5000);
//		String description9 = (String) TS0009.get(0) + " " + TS0009.get(1);
//		extentTest.log(Status.PASS, description9,
//				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description9 + ".jpg")).build());
//	}
	
//	@Test(priority = 2, dependsOnMethods="loginProvider", description = "9.2 PROV-TECH-REQ-046 - Documents & Resources - Verify Providers should be able to upload documents with a document type")
//	public void verifyDocumentUpload() throws InterruptedException, IOException, AWTException {
//	//Via Communication Center
//		
//		Thread.sleep(5000);
//		
//		ArrayList TS0007 = d.getData("TS0007", "TC0038");
//		String communicationPath = (String) TS0007.get(5);
//		WebElement communicationCenter = driver.findElement(By.xpath(communicationPath));
//		communicationCenter.click();
//		String description7 = (String) TS0007.get(0) + " " + TS0007.get(1);
//		extentTest.log(Status.PASS, description7,
//				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description7 + ".jpg")).build());
//
//		Thread.sleep(5000);
//		System.out.println("Communication page open");
//	
//		Thread.sleep(5000);
//		// SEND MESSAGE
//		ArrayList<String> TS0008 = d.getData("TS0008", "TC0038");
//		String sendMsgPath = (String) TS0008.get(5);
//		WebElement sendMessage = driver.findElement(By.xpath(sendMsgPath));
//		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sendMessage);
//		sendMessage.click();
//		Thread.sleep(5000);
//		String description8 = (String) TS0008.get(0) + " " + TS0008.get(1);
//		extentTest.log(Status.PASS, description7,
//				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description8 + ".jpg")).build());
//
//	
//		
//		ArrayList TS0009 = d.getData("TS0009", "TC0038");
//		String subListPath = (String) TS0009.get(5);
//		WebElement SubListBtn = driver.findElement(By.xpath(subListPath));
//		SubListBtn.click();
//		String description9 = (String) TS0009.get(0) + " " + TS0009.get(1);
//		extentTest.log(Status.PASS, description9,
//				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description9 + ".jpg")).build());
//
//		ArrayList TS0010 = d.getData("TS0010", "TC0038");
//		String selClaimInquiryPath = (String) TS0010.get(5);
//		WebElement claimInquiry = driver.findElement(By.xpath(selClaimInquiryPath));
//		claimInquiry.click();
//		String description10 = (String) TS0010.get(0) + " " + TS0010.get(1);
//		extentTest.log(Status.PASS, description10,
//				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description10 + ".jpg")).build());
//	
//		ArrayList TS0011 = d.getData("TS0011", "TC0038");
//		String messageBoxPath = (String) TS0011.get(5);
//		WebElement messageBox = driver.findElement(By.xpath(messageBoxPath));
//		messageBox.sendKeys((String) TS0011.get(6));
//		String description11 = (String) TS0011.get(0) + " " + TS0011.get(1);
//		extentTest.log(Status.PASS, description11,
//				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description11 + ".jpg")).build());
//
//
//		ArrayList TS0012 = d.getData("TS0012", "TC0038");
//		String nextBtnPath = (String) TS0012.get(5);
//		WebElement nextBtn = driver.findElement(By.xpath(nextBtnPath));
//		nextBtn.click();
//		String description12 = (String) TS0012.get(0) + " " + TS0012.get(1);
//		extentTest.log(Status.PASS, description12,
//				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description12 + ".jpg")).build());
//		
//
//		Thread.sleep(3000);
//
//		ArrayList TS0013 = d.getData("TS0013", "TC0038");
//		String xlFilePath = (String) TS0013.get(5);
//		WebElement uploadFiles = driver.findElement(By.xpath(xlFilePath));
//		uploadFiles.click();
//		String description13 = (String) TS0013.get(0) + " " + TS0013.get(1);
//		extentTest.log(Status.PASS, description13,
//				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description13 + ".jpg")).build());
//		
//		//EXCEL FILE
//		ArrayList TS0014 = d.getData("TS0014", "TC0038");
//		String excelFilePath = (String) TS0014.get(5);
//		System.out.println(excelFilePath);
//		Thread.sleep(5000);
//		Robot rb=new Robot();
//	    StringSelection str = new StringSelection(excelFilePath);
//	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
//	    Thread.sleep(5000);
//	    
//	     // press Contol+V for pasting
//	     rb.keyPress(KeyEvent.VK_CONTROL);
//	     rb.keyPress(KeyEvent.VK_V);
//	     Thread.sleep(2000);
//	    // release Contol+V for pasting
//	    rb.keyRelease(KeyEvent.VK_CONTROL);
//	    rb.keyRelease(KeyEvent.VK_V);
//	    Thread.sleep(2000);
//	    // for pressing and releasing Enter
//	    rb.keyPress(KeyEvent.VK_ENTER);
//	    rb.keyRelease(KeyEvent.VK_ENTER);
//	    
//		String description14 = (String) TS0014.get(0) + " " + TS0014.get(1);
//		extentTest.log(Status.PASS, description14,
//				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description14 + ".jpg")).build());
//		
//	    Thread.sleep(10000);
//	    
//		ArrayList TS0015 = d.getData("TS0015", "TC0038");
//		String descriptionPath = (String) TS0015.get(5);
//		WebElement fileDescription = driver.findElement(By.xpath(descriptionPath));
//		fileDescription.sendKeys((String) TS0015.get(6));
//		   String description15 = (String) TS0015.get(0) + " " + TS0015.get(1);
//			extentTest.log(Status.PASS, description15,
//					MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description15 + ".jpg")).build());
//		
//		ArrayList TS0016 = d.getData("TS0016", "TC0038");
//		String submitPath = (String) TS0016.get(5);
//		WebElement submitBtn = driver.findElement(By.xpath(submitPath));
//		submitBtn.click();
//		String description16 = (String) TS0016.get(0) + " " + TS0016.get(1);
//		extentTest.log(Status.PASS, description16,
//				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description16 + ".jpg")).build());
//
//		//Get Success Message
//		ArrayList TS0017 = d.getData("TS0017", "TC0038");
//		String messagePath = (String) TS0017.get(5);
//		 String msg=driver.findElement(By.xpath(messagePath)).getText();
//		String description17 = (String) TS0017.get(0) + " " + TS0017.get(1);
//		extentTest.log(Status.PASS, description17+" Success message>> "+msg,
//				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description17 + ".jpg")).build());
//		
//		uploadFiles.click();
//	
//		extentTest.log(Status.PASS, description13,
//				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description13 + ".jpg")).build());
//		
//		ArrayList TS0019 = d.getData("TS0019", "TC0038");
//		String JPEGFilePath = (String) TS0019.get(5);
//		System.out.println(JPEGFilePath);
//		Thread.sleep(5000);
//		//Robot rb=new Robot();
//	    StringSelection strJPEG = new StringSelection(JPEGFilePath);
//	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strJPEG, null);
//	    Thread.sleep(5000);
//	    
//	     // press Contol+V for pasting
//	     rb.keyPress(KeyEvent.VK_CONTROL);
//	     rb.keyPress(KeyEvent.VK_V);
//	     Thread.sleep(2000);
//	    // release Contol+V for pasting
//	    rb.keyRelease(KeyEvent.VK_CONTROL);
//	    rb.keyRelease(KeyEvent.VK_V);
//	    Thread.sleep(2000);
//	    // for pressing and releasing Enter
//	    rb.keyPress(KeyEvent.VK_ENTER);
//	    rb.keyRelease(KeyEvent.VK_ENTER);
//	    
//		String description19 = (String) TS0019.get(0) + " " + TS0019.get(1);
//		extentTest.log(Status.PASS, description19,
//				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description19 + ".jpg")).build());
//		
//	    Thread.sleep(10000);
//	    
//		ArrayList TS0020 = d.getData("TS0020", "TC0038");
//		//String descriptionPath = (String) TS0015.get(5);
//		WebElement fileDescriptionJPEG = driver.findElement(By.xpath(descriptionPath));
//		fileDescriptionJPEG.sendKeys((String) TS0020.get(6));
//		   String description20 = (String) TS0015.get(0) + " " + TS0015.get(1);
//			extentTest.log(Status.PASS, description20,
//					MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description20 + ".jpg")).build());
//		
//			Thread.sleep(5000);
//			ArrayList TS0021 = d.getData("TS0021", "TC0038");
//			String submitPath1 = (String) TS0016.get(5);
//			WebElement submitBtn1 = driver.findElement(By.xpath(submitPath1));
//			submitBtn1.click();
//		//String description16 = (String) TS0016.get(0) + " " + TS0016.get(1);
//		extentTest.log(Status.PASS, description16,
//				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description16 + ".jpg")).build());
//
//		//Get Success Message
////		ArrayList TS0017 = d.getData("TS0017", "TC0038");
////		String messagePath = (String) TS0017.get(5);
////		 String msg=driver.findElement(By.xpath(messagePath)).getText();
////		String description17 = (String) TS0017.get(0) + " " + TS0017.get(1);
//		extentTest.log(Status.PASS, description17+" Success message>> "+msg,
//				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description17 + ".jpg")).build());
		
	//}
	
	@Test(priority = 2, dataProviderClass = DataProviderTestdata.class,dataProvider = "UploadFilePath", description = "9.2 PROV-TECH-REQ-046 - Documents & Resources - Verify Providers should be able to upload documents with a document type")
	public void verifyDocumentUpload(String path, String fileName) throws InterruptedException, IOException, AWTException {
	//Via Communication Center
		driver.findElement(By.xpath("//*[contains(text(),'Upload Files')]")).click();
		Thread.sleep(5000);
		Robot rb=new Robot();
	    StringSelection str = new StringSelection(path);
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
	    Thread.sleep(5000);
	    
	     // press Contol+V for pasting
	     rb.keyPress(KeyEvent.VK_CONTROL);
	     rb.keyPress(KeyEvent.VK_V);
	     Thread.sleep(2000);
	    // release Contol+V for pasting
	    rb.keyRelease(KeyEvent.VK_CONTROL);
	    rb.keyRelease(KeyEvent.VK_V);
	    Thread.sleep(2000);
	    // for pressing and releasing Enter
	    rb.keyPress(KeyEvent.VK_ENTER);
	    rb.keyRelease(KeyEvent.VK_ENTER);
	    
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//*[@name='description']")).sendKeys(fileName);
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//*[text()='Submit']")).click();
	  String msg=driver.findElement(By.xpath("//*[text()='Uploaded Successfully']")).getText();
	  System.out.println("Success message>>"+msg);
	  Thread.sleep(5000);
	  extentTest.log(Status.PASS, fileName+" Success message>> "+msg,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(fileName + ".jpg")).build());
	}

	
	
//	@Test(priority = 3,dependsOnMethods="loginProvider", description = "9.3 PROV-TECH-REQ-047 - Documents & Resources - Verify Provide the ability to filter document list")
//	public void verifyFilterDocList() throws InterruptedException, IOException {
//		
//		
//		Thread.sleep(5000);
//		//Click Resources Link
//		ArrayList TS0007 = d.getData("TS0007", "TC0037");
//		String resourcesPath = (String) TS0007.get(5);
//		WebElement resources = driver.findElement(By.xpath(resourcesPath));
//		resources.click();
//		Thread.sleep(5000);
//		String description7 = (String) TS0007.get(0) + " " + TS0007.get(1);
//		extentTest.log(Status.PASS, description7,
//				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description7 + ".jpg")).build());
//
//		//
//		ArrayList TS0008 = d.getData("TS0008", "TC0037");
//		String resTypeBtnPath = (String) TS0008.get(5);
//		WebElement resourceType = driver.findElement(By.xpath(resTypeBtnPath));
//		resourceType.click();
//		Thread.sleep(5000);
//		String description8 = (String) TS0008.get(0) + " " + TS0008.get(1);
//		extentTest.log(Status.PASS, description8,
//				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description8 + ".jpg")).build());
//	
//		ArrayList<String> TS0009 = d.getData("TS0009", "TC0037");
//		String documentPath = (String) TS0009.get(5);
//		WebElement document = driver.findElement(By.xpath(documentPath));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", document);
//		document.click();
//		//document.click();
//		Thread.sleep(5000);
//		String description9 = (String) TS0009.get(0) + " " + TS0009.get(1);
//		extentTest.log(Status.PASS, description9,
//				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description9 + ".jpg")).build());
//	}


	
}