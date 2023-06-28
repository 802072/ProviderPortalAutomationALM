package providerPortalVNSHealthPlans;

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
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import dataDrivenPP.dataDrivenPP;
import extentReport.BaseTest;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ClaimsAndDisputes extends BaseTest {
	String loginPage = "https://providerportal.vnshealthplans.org/login";

	JavascriptExecutor js = (JavascriptExecutor) driver;
	dataDrivenPP d = new dataDrivenPP();
	
	@Test(priority = -1, testName = "Login as Provider")
	public void loginProvider() throws InterruptedException, IOException {

		ArrayList TS0001 = d.getData("TS0001", "TC0027");
		String description1 = (String) TS0001.get(0) + " " + TS0001.get(1);
		extentTest.log(Status.PASS, description1);

		ArrayList TS0002 = d.getData("TS0002", "TC0027");
		String loginUrl = (String) TS0002.get(6);
		driver.get(loginUrl);

		String description2 = (String) TS0002.get(0) + " " + TS0002.get(1);
		extentTest.log(Status.PASS, description2,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description2 + ".jpg")).build());

		ArrayList TS0003 = d.getData("TS0003", "TC0027");
		String enterBtn = (String) TS0003.get(5);
		WebElement enter = driver.findElement(By.xpath(enterBtn));
		enter.click();

		String description3 = (String) TS0003.get(0) + " " + TS0003.get(1);
		extentTest.log(Status.PASS, description3,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description3 + ".jpg")).build());

		// enter username
		ArrayList TS0004 = d.getData("TS0004", "TC0027");
		String username = (String) TS0004.get(6);
		String unamePath = (String) TS0004.get(5);
		WebElement unameField = driver.findElement(By.xpath(unamePath));
		unameField.sendKeys(username);

		String description4 = (String) TS0004.get(0) + " " + TS0004.get(1);
		extentTest.log(Status.PASS, description4,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description4 + ".jpg")).build());

		// enter password
		ArrayList TS0005 = d.getData("TS0005", "TC0027");
		String pwdPath = (String) TS0005.get(5);
		WebElement pwd = driver.findElement(By.xpath(pwdPath));
		String password = (String) TS0005.get(6);
		pwd.sendKeys(password);

		String description5 = (String) TS0005.get(0) + " " + TS0005.get(1);
		extentTest.log(Status.PASS, description5,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description5 + ".jpg")).build());

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// login
		ArrayList TS0006 = d.getData("TS0006", "TC0027");
		String signOnPath = (String) TS0006.get(5);
		WebElement signOn = driver.findElement(By.xpath(signOnPath));
		signOn.click();

		Thread.sleep(5000);

		String description6 = (String) TS0006.get(0) + " " + TS0006.get(1);
		extentTest.log(Status.PASS, description6,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description6 + ".jpg")).build());

	}

	@Test(priority = 1, testName = "7.1 PROV-TECH-REQ-028 - Claims - Verify Create a lightning page to display claim information")
	public void verifyClaimInfoDisplay() throws InterruptedException, IOException {
		Thread.sleep(5000);
		ArrayList TS0007 = d.getData("TS0007", "TC0027");
		String claimPath = (String) TS0007.get(5);
		WebElement claims = driver.findElement(By.xpath(claimPath));
		claims.click();
		Thread.sleep(5000);
		String description7 = (String) TS0007.get(0) + " " + TS0007.get(1);
		extentTest.log(Status.PASS, description7,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description7 + ".jpg")).build());

		ArrayList TS0008 = d.getData("TS0008", "TC0027");
		String claimTitlePath = (String) TS0008.get(5);
		Assert.assertEquals(driver.findElement(By.xpath(claimTitlePath)).getText(), "Claims");
		Thread.sleep(10000);
		String description8 = (String) TS0008.get(0) + " " + TS0008.get(1);
		extentTest.log(Status.PASS, description8,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description8 + ".jpg")).build());
	}

	@Test(priority = 2, testName = "7.2 PROV-TECH-REQ-029 - Claims - Verify Provide the ability to send search parameters to return claim data")
	public void verifySearchClaimData() throws InterruptedException, IOException {
		Thread.sleep(5000);
		ArrayList TS0007 = d.getData("TS0007", "TC0028");
		String claimPath = (String) TS0007.get(5);
		WebElement claims = driver.findElement(By.xpath(claimPath));
		claims.click();
		Thread.sleep(5000);
		String description7 = (String) TS0007.get(0) + " " + TS0007.get(1);
		extentTest.log(Status.PASS, description7,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description7 + ".jpg")).build());

		
		ArrayList TS0008 = d.getData("TS0008", "TC0028");
		String claimTitlePath = (String) TS0008.get(5);
		Assert.assertEquals(driver.findElement(By.xpath(claimTitlePath)).getText(), "Claims");
		Thread.sleep(10000);
		String description8 = (String) TS0008.get(0) + " " + TS0008.get(1);
		extentTest.log(Status.PASS, description8,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description8 + ".jpg")).build());

		//Search filter
		ArrayList TS0009 = d.getData("TS0009", "TC0028");
		String filterDatePath = (String) TS0009.get(5);
		WebElement filterDate = driver.findElement(By.xpath(filterDatePath));
		filterDate.click();
		String description9 = (String) TS0009.get(0) + " " + TS0009.get(1);
		extentTest.log(Status.PASS, description9,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description9 + ".jpg")).build());

		ArrayList TS0010 = d.getData("TS0010", "TC0028");
		String allTimePath = (String) TS0010.get(5);
		WebElement allTime = driver.findElement(By.xpath(allTimePath));
		allTime.click();
		String description10 = (String) TS0010.get(0) + " " + TS0010.get(1);
		extentTest.log(Status.PASS, description10,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description10 + ".jpg")).build());
		
		ArrayList TS0011 = d.getData("TS0011", "TC0028");
		String memberIDPath = (String) TS0011.get(5);
		WebElement memberID = driver.findElement(By.xpath(memberIDPath));
		memberID.click();
		memberID.sendKeys((String) TS0011.get(6));
		String description11 = (String) TS0011.get(0) + " " + TS0011.get(1);
		extentTest.log(Status.PASS, description11,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description11 + ".jpg")).build());

		ArrayList TS0012 = d.getData("TS0012", "TC0028");
		String fNamePath = (String) TS0012.get(5);
		WebElement fName = driver.findElement(By.xpath(fNamePath));
		fName.click();
		fName.sendKeys((String) TS0012.get(6));
		String description12 = (String) TS0012.get(0) + " " + TS0012.get(1);
		extentTest.log(Status.PASS, description12,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description12 + ".jpg")).build());
		
		ArrayList TS0013 = d.getData("TS0013", "TC0028");
		String lNamePath = (String) TS0013.get(5);
		WebElement lName = driver.findElement(By.xpath(lNamePath));
		lName.sendKeys((String) TS0013.get(6));
		String description13 = (String) TS0013.get(0) + " " + TS0013.get(1);
		extentTest.log(Status.PASS, description13,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description13 + ".jpg")).build());

		ArrayList TS0014 = d.getData("TS0014", "TC0028");
		String claimIDPath = (String) TS0014.get(5);
		WebElement claimID = driver.findElement(By.xpath(claimIDPath));
		claimID.sendKeys((String) TS0014.get(6));
		String description14 = (String) TS0014.get(0) + " " + TS0014.get(1);
		extentTest.log(Status.PASS, description14,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description14 + ".jpg")).build());

		ArrayList TS0015 = d.getData("TS0015", "TC0028");
		String medicareIDPath = (String) TS0015.get(5);
		WebElement medicareID = driver.findElement(By.xpath(medicareIDPath));
		medicareID.sendKeys((String) TS0015.get(6));
		String description15 = (String) TS0015.get(0) + " " + TS0015.get(1);
		extentTest.log(Status.PASS, description15,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description15 + ".jpg")).build());

		ArrayList TS0016 = d.getData("TS0016", "TC0028");
		String medicaidIDPath = (String) TS0016.get(5);
		WebElement medicaidID = driver.findElement(By.xpath(medicaidIDPath));
		medicaidID.sendKeys((String) TS0016.get(6));
		String description16 = (String) TS0016.get(0) + " " + TS0016.get(1);
		extentTest.log(Status.PASS, description16,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description16 + ".jpg")).build());
		
		
		
		ArrayList TS0017 = d.getData("TS0017", "TC0028");
		String claimTypePath = (String) TS0017.get(5);
		WebElement claimType = driver.findElement(
				By.xpath(claimTypePath));
		claimType.click();
		String description17 = (String) TS0017.get(0) + " " + TS0017.get(1);
		extentTest.log(Status.PASS, description17,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description17 + ".jpg")).build());
		
//////////////
		ArrayList TS0018 = d.getData("TS0018", "TC0028");
		String medicalPath = (String) TS0018.get(5);
		WebElement medical = driver.findElement(By.xpath(medicalPath));
		medical.click();
		String description18 = (String) TS0018.get(0) + " " + TS0018.get(1);
		extentTest.log(Status.PASS, description18,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description18 + ".jpg")).build());
		
		ArrayList TS0019 = d.getData("TS0019", "TC0028");
		String statusPath = (String) TS0019.get(5);
		WebElement status = driver.findElement(By.xpath(statusPath));
		status.click();
		String description19 = (String) TS0019.get(0) + " " + TS0019.get(1);
		extentTest.log(Status.PASS, description19,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description19 + ".jpg")).build());

		ArrayList TS0020 = d.getData("TS0020", "TC0028");
		String paidPath = (String) TS0020.get(5);
		WebElement paid = driver.findElement(By.xpath(paidPath));
		paid.click();
		String description20 = (String) TS0020.get(0) + " " + TS0020.get(1);
		extentTest.log(Status.PASS, description20,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description20 + ".jpg")).build());

		//Search
		ArrayList TS0021 = d.getData("TS0021", "TC0028");
		String searchPath = (String) TS0021.get(5);
		WebElement search = driver.findElement(By.xpath(searchPath));
		search.click();
		String description21 = (String) TS0021.get(0) + " " + TS0021.get(1);
		extentTest.log(Status.PASS, description21,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description21 + ".jpg")).build());

		Thread.sleep(7000);
		
		ArrayList TS0022 = d.getData("TS0022", "TC0028");
		String exportPath = (String) TS0022.get(5);
		Assert.assertEquals(driver.findElement(By.xpath(exportPath)).getText(), "Export");
		String description22 = (String) TS0022.get(0) + " " + TS0022.get(1);
		extentTest.log(Status.PASS, description22,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description22 + ".jpg")).build());

	}

	@Test(priority = 3, testName = "7.3 PROV-TECH-REQ-030 - Claims - Verify Display historical claims in table format")
	public void verifyDisplayClaimsTableFormat() throws InterruptedException, IOException {

//WH
		Thread.sleep(5000);
		ArrayList TS0007 = d.getData("TS0007", "TC0029");
		String claimPath = (String) TS0007.get(5);
		WebElement claims = driver.findElement(By.xpath(claimPath));
		claims.click();
		Thread.sleep(5000);
		String description7 = (String) TS0007.get(0) + " " + TS0007.get(1);
		extentTest.log(Status.PASS, description7,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description7 + ".jpg")).build());

		Thread.sleep(5000);

		ArrayList TS0008 = d.getData("TS0008", "TC0029");
		String claimTablePath = (String) TS0008.get(5);
		WebElement claimsTable = driver.findElement(By.xpath(claimTablePath));
		Assert.assertEquals(true, claimsTable.isDisplayed());
		String description8 = (String) TS0008.get(0) + " " + TS0008.get(1);
		extentTest.log(Status.PASS, description8,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description8 + ".jpg")).build());
		
		System.out.println("Claims Displayed");
		
	}
	
	@Test(priority = 4, testName = "7.4 PROV-TECH-REQ-031 - Claims - Verify Display historical claims in card format")
	public void verifyDisplayClaimsCardFormat() throws InterruptedException, IOException {
		Thread.sleep(5000);
		ArrayList TS0007 = d.getData("TS0007", "TC0030");
		String claimPath = (String) TS0007.get(5);
		WebElement claims = driver.findElement(By.xpath(claimPath));
		claims.click();
		Thread.sleep(5000);
		String description7 = (String) TS0007.get(0) + " " + TS0007.get(1);
		extentTest.log(Status.PASS, description7,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description7 + ".jpg")).build());

		//CLAIM CARD NOT DISPLAYED; ONLY MOBILE VIEW
		Thread.sleep(5000);
		ArrayList TS0008 = d.getData("TS0008", "TC0030");
		String claimCardPath = (String) TS0008.get(5);
		WebElement claimsCard = driver.findElement(By.xpath(claimCardPath));
		Assert.assertEquals(true, claimsCard.isDisplayed());
		String description8 = (String) TS0008.get(0) + " " + TS0008.get(1);
		extentTest.log(Status.PASS, description8,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description8 + ".jpg")).build());
	}
	
	@Test(priority = 6, testName = "7.6 PROV-TECH-REQ-033- Claims - Verify Provide the ability to export data if data is in a table view")
	public void verifyExportClaimData() throws InterruptedException, IOException {
		Thread.sleep(5000);
		ArrayList TS0007 = d.getData("TS0007", "TC0032");
		String claimPath = (String) TS0007.get(5);
		WebElement claims = driver.findElement(By.xpath(claimPath));
		claims.click();
		Thread.sleep(5000);
		String description7 = (String) TS0007.get(0) + " " + TS0007.get(1);
		extentTest.log(Status.PASS, description7,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description7 + ".jpg")).build());
//click Export
		Thread.sleep(5000);
		ArrayList TS0008 = d.getData("TS0008", "TC0032");
		String claimExportBtnPath = (String) TS0008.get(5);
		WebElement claimsExportBtn = driver.findElement(By.xpath(claimExportBtnPath));
		claimsExportBtn.click();
		String description8 = (String) TS0008.get(0) + " " + TS0008.get(1);
		extentTest.log(Status.PASS, description8,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description8 + ".jpg")).build());
		
		Thread.sleep(5000);

		check_file_exist("ClaimsDataExport.csv");
	}

}