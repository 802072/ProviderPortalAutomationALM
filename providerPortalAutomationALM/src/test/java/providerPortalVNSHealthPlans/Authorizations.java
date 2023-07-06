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

public class Authorizations extends BaseTest {

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

	@Test(priority = 1, dependsOnMethods = "loginProvider", testName = "10.1 PROV-TECH-REQ-051 - Authorizations - Verify Create a lightning page to display authorization information")
	public void verifyAuthorizationPage() throws InterruptedException, IOException {
		Thread.sleep(5000);
		// Click Auth Link
		ArrayList TS0007 = d.getData("TS0007", "TC0043");
		String authorizationsPath = (String) TS0007.get(5);
		WebElement authorizations = driver.findElement(By.xpath(authorizationsPath));
		authorizations.click();
		Thread.sleep(5000);
		String description7 = (String) TS0007.get(0) + " " + TS0007.get(1);
		extentTest.log(Status.PASS, description7,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description7 + ".jpg")).build());

		// Assert Auth Page Displayed
		ArrayList TS0008 = d.getData("TS0008", "TC0043");
		String authTitlePath = (String) TS0008.get(5);
		Assert.assertEquals(driver.findElement(By.xpath(authTitlePath)).getText(), (String) TS0008.get(6));
		Thread.sleep(10000);
		String description8 = (String) TS0008.get(0) + " " + TS0008.get(1);
		extentTest.log(Status.PASS, description8,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description8 + ".jpg")).build());
	}

	@Test(priority = 2, dependsOnMethods = "loginProvider", testName = "10.2 PROV-TECH-REQ-052 - Authorizations - Verify Provide the ability to send search parameters to return authorization data")
	public void verifySearchParametersAuthPage() throws InterruptedException, IOException {

		Thread.sleep(5000);
		// Click Auth Link
		ArrayList TS0007 = d.getData("TS0007", "TC0044");
		String authorizationsPath = (String) TS0007.get(5);
		WebElement authorizations = driver.findElement(By.xpath(authorizationsPath));
		authorizations.click();
		Thread.sleep(5000);
		String description7 = (String) TS0007.get(0) + " " + TS0007.get(1);
		extentTest.log(Status.PASS, description7,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description7 + ".jpg")).build());

		// Assert Auth Page Displayed
		ArrayList TS0008 = d.getData("TS0008", "TC0044");
		String authTitlePath = (String) TS0008.get(5);
		Assert.assertEquals(driver.findElement(By.xpath(authTitlePath)).getText(), (String) TS0008.get(6));
		Thread.sleep(10000);
		String description8 = (String) TS0008.get(0) + " " + TS0008.get(1);
		extentTest.log(Status.PASS, description8,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description8 + ".jpg")).build());

		// FILTER
		// Date
		ArrayList TS0009 = d.getData("TS0009", "TC0044");
		String filterDatePath = (String) TS0009.get(5);
		WebElement filterDate = driver.findElement(By.xpath(filterDatePath));
		filterDate.click();
		String description9 = (String) TS0009.get(0) + " " + TS0009.get(1);
		extentTest.log(Status.PASS, description9,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description9 + ".jpg")).build());

		// All Time
		ArrayList TS0010 = d.getData("TS0010", "TC0044");
		String allTimePath = (String) TS0010.get(5);
		WebElement allTime = driver.findElement(By.xpath(allTimePath));
		allTime.click();
		String description10 = (String) TS0010.get(0) + " " + TS0010.get(1);
		extentTest.log(Status.PASS, description10,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description10 + ".jpg")).build());

		// Member ID
		ArrayList TS0011 = d.getData("TS0011", "TC0044");
		String memberIDPath = (String) TS0011.get(5);
		WebElement memberID = driver.findElement(By.xpath(memberIDPath));
		memberID.click();
		memberID.sendKeys((String) TS0011.get(6));
		String description11 = (String) TS0011.get(0) + " " + TS0011.get(1);
		extentTest.log(Status.PASS, description11,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description11 + ".jpg")).build());

		// FName
		ArrayList TS0012 = d.getData("TS0012", "TC0044");
		String fNamePath = (String) TS0012.get(5);
		WebElement fName = driver.findElement(By.xpath(fNamePath));
		fName.click();
		fName.sendKeys((String) TS0012.get(6));
		String description12 = (String) TS0012.get(0) + " " + TS0012.get(1);
		extentTest.log(Status.PASS, description12,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description12 + ".jpg")).build());

		// LName
		ArrayList TS0013 = d.getData("TS0013", "TC0044");
		String lNamePath = (String) TS0013.get(5);
		WebElement lName = driver.findElement(By.xpath(lNamePath));
		lName.sendKeys((String) TS0013.get(6));
		String description13 = (String) TS0013.get(0) + " " + TS0013.get(1);
		extentTest.log(Status.PASS, description13,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description13 + ".jpg")).build());

		// Auth Type
		ArrayList TS0014 = d.getData("TS0014", "TC0044");
		String authTypePath = (String) TS0014.get(5);
		WebElement authTypeBtn = driver.findElement(By.xpath(authTypePath));
		authTypeBtn.click();
		String description14 = (String) TS0014.get(0) + " " + TS0014.get(1);
		extentTest.log(Status.PASS, description14,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description14 + ".jpg")).build());

		Thread.sleep(5000);
		// Professional Sevices
		ArrayList TS0015 = d.getData("TS0015", "TC0044");
		String profServicePath = (String) TS0015.get(5);
		WebElement profService = driver.findElement(By.xpath(profServicePath));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", profService);
		profService.click();
		String description15 = (String) TS0015.get(0) + " " + TS0015.get(1);
		extentTest.log(Status.PASS, description15,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description15 + ".jpg")).build());

		// Decision Status
		ArrayList TS0016 = d.getData("TS0016", "TC0044");
		String decStatPath = (String) TS0016.get(5);
		WebElement decStatus = driver.findElement(By.xpath(decStatPath));
		decStatus.click();

		String description16 = (String) TS0016.get(0) + " " + TS0016.get(1);
		extentTest.log(Status.PASS, description16,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description16 + ".jpg")).build());
		Thread.sleep(5000);
		// Approved
		ArrayList TS0017 = d.getData("TS0017", "TC0044");
		String approvedPath = (String) TS0017.get(5);
		WebElement approvedOption = driver.findElement(By.xpath(approvedPath));
		approvedOption.click();
		String description17 = (String) TS0017.get(0) + " " + TS0017.get(1);
		extentTest.log(Status.PASS, description17,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description17 + ".jpg")).build());

		// Auth Number
		ArrayList TS0018 = d.getData("TS0018", "TC0044");
		String authNumPath = (String) TS0018.get(5);
		WebElement authNumber = driver.findElement(By.xpath(authNumPath));
		authNumber.sendKeys((String) TS0018.get(6));
		String description18 = (String) TS0018.get(0) + " " + TS0018.get(1);
		extentTest.log(Status.PASS, description18,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description18 + ".jpg")).build());

		// Search
		ArrayList TS0019 = d.getData("TS0019", "TC0044");
		String searchPath = (String) TS0019.get(5);
		WebElement search = driver.findElement(By.xpath(searchPath));
		search.click();
		String description19 = (String) TS0019.get(0) + " " + TS0019.get(1);
		extentTest.log(Status.PASS, description19,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description19 + ".jpg")).build());

		// Assert
		ArrayList TS0020 = d.getData("TS0020", "TC0044");
		String exportPath = (String) TS0020.get(5);
		WebElement exportBtn = driver.findElement(By.xpath(exportPath));
		Thread.sleep(10000);
		Assert.assertEquals(exportBtn.getText(), "Export");
		String description20 = (String) TS0020.get(0) + " " + TS0020.get(1);
		extentTest.log(Status.PASS, description20,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description20 + ".jpg")).build());

	}

	@Test(priority = 3, dependsOnMethods = "loginProvider", testName = "10.3 PROV-TECH-REQ-053 - Authorizations - Verify Display historical authorizations in table format")
	public void verifyAuthorizationTableFormat() throws InterruptedException, IOException {

		Thread.sleep(5000);
		// Click Auth Link
		ArrayList TS0007 = d.getData("TS0007", "TC0045");
		String authorizationsPath = (String) TS0007.get(5);
		WebElement authorizations = driver.findElement(By.xpath(authorizationsPath));
		authorizations.click();
		Thread.sleep(5000);
		String description7 = (String) TS0007.get(0) + " " + TS0007.get(1);
		extentTest.log(Status.PASS, description7,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description7 + ".jpg")).build());

		// Assert Auth Page Displayed
		ArrayList TS0008 = d.getData("TS0008", "TC0044");
		String authTitlePath = (String) TS0008.get(5);
		Assert.assertEquals(driver.findElement(By.xpath(authTitlePath)).getText(), (String) TS0008.get(6));
		Thread.sleep(10000);
		String description8 = (String) TS0008.get(0) + " " + TS0008.get(1);
		extentTest.log(Status.PASS, description8,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description8 + ".jpg")).build());

		// Assert Historical Auths Displayed in Table
		ArrayList TS0009 = d.getData("TS0009", "TC0045");
		String authTablePath = (String) TS0009.get(5);
		Assert.assertEquals(driver.findElement(By.xpath(authTablePath)).isDisplayed(), true);
		Thread.sleep(10000);
		String description9 = (String) TS0009.get(0) + " " + TS0009.get(1);
		extentTest.log(Status.PASS, description9,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description9 + ".jpg")).build());
		// Expand
		ArrayList TS0010 = d.getData("TS0010", "TC0045");
		String expandIconPath = (String) TS0010.get(5);
		WebElement expandIcon = driver.findElement(By.xpath(expandIconPath));
		expandIcon.click();
		Thread.sleep(10000);
		String description10 = (String) TS0010.get(0) + " " + TS0010.get(1);
		extentTest.log(Status.PASS, description10,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description10 + ".jpg")).build());

	}

	@Test(priority = 6, dependsOnMethods = "loginProvider", testName = "10.6 PROV-TECH-REQ-056 - Authorizations - Verify Provide the ability to export data if data is in a table view")
	public void verifyExportAuthorizationData() throws InterruptedException, IOException {

		Thread.sleep(5000);
		// Click Auth Link
		ArrayList TS0007 = d.getData("TS0007", "TC0048");
		String authorizationsPath = (String) TS0007.get(5);
		WebElement authorizations = driver.findElement(By.xpath(authorizationsPath));
		authorizations.click();
		Thread.sleep(5000);
		String description7 = (String) TS0007.get(0) + " " + TS0007.get(1);
		extentTest.log(Status.PASS, description7,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description7 + ".jpg")).build());

		// click Export Button
		Thread.sleep(10000);
		ArrayList TS0008 = d.getData("TS0008", "TC0048");
		String authExportBtnPath = (String) TS0008.get(5);
		WebElement claimsExportBtn = driver.findElement(By.xpath(authExportBtnPath));
		claimsExportBtn.click();
		String description8 = (String) TS0008.get(0) + " " + TS0008.get(1);
		extentTest.log(Status.PASS, description8,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description8 + ".jpg")).build());

		Thread.sleep(5000);
		// Verify File Exported
		ArrayList TS0009 = d.getData("TS0009", "TC0048");
		String fileName = (String) TS0009.get(6);
		check_file_exist(fileName);
		// Message logged from BaseTest

	}

	@Test(priority = 7, dependsOnMethods = "loginProvider", testName = "10.7 PROV-TECH-REQ-057 - Authorizations - Verify Provide the ability to submit Authorization Requests")
	public void verifySubmitAuthRequests() throws InterruptedException, IOException {
	

		// Click Auth Link
		ArrayList TS0007 = d.getData("TS0007", "TC0049");
		String authorizationsPath = (String) TS0007.get(5);
		WebElement authorizations = driver.findElement(By.xpath(authorizationsPath));
		authorizations.click();
		Thread.sleep(5000);
		String description7 = (String) TS0007.get(0) + " " + TS0007.get(1);
		extentTest.log(Status.PASS, description7,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description7 + ".jpg")).build());

		// SUBMIT A NEW AUTH*********************************************

		ArrayList TS0008 = d.getData("TS0008", "TC0049");
		String submitNewAuthPath = (String) TS0008.get(5);
		WebElement submitNewAuthBtn = driver.findElement(By.xpath(submitNewAuthPath));
		submitNewAuthBtn.click();
		String description8 = (String) TS0008.get(0) + " " + TS0008.get(1);
		extentTest.log(Status.PASS, description8,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description8 + ".jpg")).build());

		// FirstName
		ArrayList TS0009 = d.getData("TS0009", "TC0049");
		String fNamePath = (String) TS0009.get(5);
		WebElement fName = driver.findElement(By.xpath(fNamePath));
		fName.sendKeys((String) TS0009.get(6));
		String description9 = (String) TS0009.get(0) + " " + TS0009.get(1);
		extentTest.log(Status.PASS, description9,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description9 + ".jpg")).build());

		// LastName
		ArrayList TS0010 = d.getData("TS0010", "TC0049");
		String lNamePath = (String) TS0010.get(5);
		WebElement lName = driver.findElement(By.xpath(lNamePath));
		lName.sendKeys((String) TS0010.get(6));
		String description10 = (String) TS0010.get(0) + " " + TS0010.get(1);
		extentTest.log(Status.PASS, description10,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description10 + ".jpg")).build());

		// Member ID
		ArrayList TS0011 = d.getData("TS0011", "TC0049");
		String memIDPath = (String) TS0011.get(5);
		WebElement memID = driver.findElement(By.xpath(memIDPath));
		memID.sendKeys((String) TS0011.get(6));
		String description11 = (String) TS0011.get(0) + " " + TS0011.get(1);
		extentTest.log(Status.PASS, description11,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description11 + ".jpg")).build());
		// Next
		ArrayList TS0012 = d.getData("TS0012", "TC0049");
		String nextBtnPath = (String) TS0012.get(5);
		WebElement nextBtn = driver.findElement(By.xpath(nextBtnPath));
		nextBtn.click();
		String description12 = (String) TS0012.get(0) + " " + TS0012.get(1);
		extentTest.log(Status.PASS, description12,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description12 + ".jpg")).build());

		Thread.sleep(5000);

		// Yes
		ArrayList TS0013 = d.getData("TS0013", "TC0049");
		String yesBtnPath = (String) TS0013.get(5);
		WebElement yesBtn = driver.findElement(By.xpath(yesBtnPath));
		yesBtn.click();
		String description13 = (String) TS0013.get(0) + " " + TS0013.get(1);
		extentTest.log(Status.PASS, description13,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description13 + ".jpg")).build());

		// Next
		ArrayList TS0014 = d.getData("TS0014", "TC0049");
		String nextBtnPath1 = (String) TS0014.get(5);
		WebElement next = driver.findElement(By.xpath(nextBtnPath1));
		next.click();
		String description14 = (String) TS0014.get(0) + " " + TS0014.get(1);
		extentTest.log(Status.PASS, description14,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description14 + ".jpg")).build());

		Thread.sleep(5000);
		// Click Authorization Request Type
		ArrayList TS0015 = d.getData("TS0015", "TC0049");
		String authTypeBtnPath = (String) TS0015.get(5);
		WebElement authTypeBtn = driver.findElement(By.xpath(authTypeBtnPath));
		authTypeBtn.click();
		String description15 = (String) TS0015.get(0) + " " + TS0015.get(1);
		extentTest.log(Status.PASS, description15,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description15 + ".jpg")).build());

		// Select Adult Day Medical Model Option
		ArrayList TS0016 = d.getData("TS0016", "TC0049");
		String adultDayMedOptionPath = (String) TS0016.get(5);
		WebElement adultDayMedOption = driver.findElement(By.xpath(adultDayMedOptionPath));
		adultDayMedOption.click();
		String description16 = (String) TS0016.get(0) + " " + TS0016.get(1);
		extentTest.log(Status.PASS, description16,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description16 + ".jpg")).build());

		// Enter Effective Start Date
		ArrayList TS0017 = d.getData("TS0017", "TC0049");
		String startDatePath = (String) TS0017.get(5);
		WebElement startDate = driver.findElement(By.xpath(startDatePath));
		startDate.sendKeys("07/01/2023");
		//startDate.sendKeys((String) TS0017.get(6));
		String description17 = (String) TS0017.get(0) + " " + TS0017.get(1);
		extentTest.log(Status.PASS, description17,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description17 + ".jpg")).build());

		// Enter Effective End Date
		ArrayList TS0018 = d.getData("TS0018", "TC0049");
		String endDatePath = (String) TS0018.get(5);
		WebElement endDate = driver.findElement(By.xpath(endDatePath));
		//endDate.sendKeys((String) TS0018.get(6));
		endDate.sendKeys("07/05/2023");
		String description18 = (String) TS0018.get(0) + " " + TS0018.get(1);
		extentTest.log(Status.PASS, description18,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description18 + ".jpg")).build());

		// Requesting Provider Name
		ArrayList TS0019 = d.getData("TS0019", "TC0049");
		String reqProviderNamePath = (String) TS0019.get(5);
		WebElement reqProvider = driver.findElement(By.xpath(reqProviderNamePath));
		reqProvider.sendKeys((String) TS0019.get(6));
		String description19 = (String) TS0019.get(0) + " " + TS0019.get(1);
		extentTest.log(Status.PASS, description19,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description19 + ".jpg")).build());

		// Requesting Provider Address
		ArrayList TS0020 = d.getData("TS0020", "TC0049");
		String reqProviderAddPath = (String) TS0020.get(5);
		WebElement reqProviderAdd = driver.findElement(By.xpath(reqProviderAddPath));
		reqProviderAdd.sendKeys((String) TS0020.get(6));
		String description20 = (String) TS0020.get(0) + " " + TS0020.get(1);
		extentTest.log(Status.PASS, description20,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description20 + ".jpg")).build());

		// Requesting Provider City
		ArrayList TS0021 = d.getData("TS0021", "TC0049");
		String reqProvCityPath = (String) TS0021.get(5);
		WebElement reqProv = driver.findElement(By.xpath(reqProvCityPath));
		reqProv.sendKeys((String) TS0020.get(6));
		String description21 = (String) TS0021.get(0) + " " + TS0021.get(1);
		extentTest.log(Status.PASS, description21,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description21 + ".jpg")).build());

		// Requesting Provider State
		ArrayList TS0022 = d.getData("TS0022", "TC0049");
		String reqProvStatePath = (String) TS0022.get(5);
		WebElement reqProvState = driver.findElement(By.xpath(reqProvStatePath));
		reqProvState.click();
		String description22 = (String) TS0022.get(0) + " " + TS0022.get(1);
		extentTest.log(Status.PASS, description22,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description22 + ".jpg")).build());

		// Select NY
		ArrayList TS0023 = d.getData("TS0023", "TC0049");
		String NYOptionPath = (String) TS0023.get(5);
		WebElement NYOption = driver.findElement(By.xpath(NYOptionPath));
		NYOption.click();
		String description23 = (String) TS0023.get(0) + " " + TS0023.get(1);
		extentTest.log(Status.PASS, description23,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description23 + ".jpg")).build());

		// Requesting Provider ZIP
		ArrayList TS0024 = d.getData("TS0024", "TC0049");
		String reqProvZipPath = (String) TS0024.get(5);
		WebElement reqProvZip = driver.findElement(By.xpath(reqProvZipPath));
		reqProvZip.sendKeys((String) TS0024.get(6));
		String description24 = (String) TS0024.get(0) + " " + TS0024.get(1);
		extentTest.log(Status.PASS, description24,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description24 + ".jpg")).build());

		// Requesting Provider Phone
		ArrayList TS0025 = d.getData("TS0025", "TC0049");
		String phoneNumberPath = (String) TS0025.get(5);
		WebElement phoneNumber = driver.findElement(By.xpath(phoneNumberPath));
		phoneNumber.sendKeys((String) TS0025.get(6));
		String description25 = (String) TS0025.get(0) + " " + TS0025.get(1);
		extentTest.log(Status.PASS, description25,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description25 + ".jpg")).build());

		// Req provider NPI
		ArrayList TS0026 = d.getData("TS0026", "TC0049");
		String reqProvNPIPath = (String) TS0026.get(5);
		WebElement reqProvNPI = driver.findElement(By.xpath(reqProvNPIPath));
		reqProvNPI.sendKeys((String) TS0026.get(6));
		String description26 = (String) TS0026.get(0) + " " + TS0026.get(1);
		extentTest.log(Status.PASS, description26,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description26 + ".jpg")).build());

		// Servicing Provider Name
		ArrayList TS0027 = d.getData("TS0027", "TC0049");
		String servProvNamePath = (String) TS0027.get(5);
		WebElement servProvName = driver.findElement(By.xpath(servProvNamePath));
		servProvName.sendKeys((String) TS0027.get(6));
		String description27 = (String) TS0027.get(0) + " " + TS0027.get(1);
		extentTest.log(Status.PASS, description27,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description27 + ".jpg")).build());

		// Serv Address
		ArrayList TS0028 = d.getData("TS0028", "TC0049");
		String servAddressPath = (String) TS0028.get(5);
		WebElement servAddress = driver.findElement(By.xpath(servAddressPath));
		servAddress.sendKeys((String) TS0028.get(6));
		String description28 = (String) TS0028.get(0) + " " + TS0028.get(1);
		extentTest.log(Status.PASS, description28,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description28 + ".jpg")).build());

		// Serv City
		ArrayList TS0029 = d.getData("TS0029", "TC0049");
		String servCityPath = (String) TS0029.get(5);
		WebElement servCity = driver.findElement(By.xpath(servCityPath));
		servCity.sendKeys((String) TS0029.get(6));
		String description29 = (String) TS0029.get(0) + " " + TS0029.get(1);
		extentTest.log(Status.PASS, description29,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description29 + ".jpg")).build());

		// Serv State Btn
		ArrayList TS0030 = d.getData("TS0030", "TC0049");
		String servStateBtnPath = (String) TS0030.get(5);
		WebElement servStateBtn = driver.findElement(By.xpath(servStateBtnPath));
		servStateBtn.click();
		String description30 = (String) TS0030.get(0) + " " + TS0030.get(1);
		extentTest.log(Status.PASS, description30,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description30 + ".jpg")).build());

		// Select NY State
		ArrayList TS0031 = d.getData("TS0031", "TC0049");
		String NYStatePath = (String) TS0031.get(5);
		WebElement NYState = driver.findElement(By.xpath(NYStatePath));
		NYState.click();
		String description31 = (String) TS0031.get(0) + " " + TS0031.get(1);
		extentTest.log(Status.PASS, description31,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description31 + ".jpg")).build());

		//Serv ZIP
		ArrayList TS0032 = d.getData("TS0032", "TC0049");
		String servZIPPath = (String) TS0032.get(5);
		WebElement servZIP = driver.findElement(By.xpath(servZIPPath));
		servZIP.sendKeys((String) TS0032.get(6));
		String description32 = (String) TS0032.get(0) + " " + TS0032.get(1);
		extentTest.log(Status.PASS, description32,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description32 + ".jpg")).build());

		//Serv Phone
		ArrayList TS0033 = d.getData("TS0033", "TC0049");
		String phonePath = (String) TS0033.get(5);
		WebElement phone = driver.findElement(By.xpath(phonePath));
		phone.sendKeys((String) TS0033.get(6));
		String description33 = (String) TS0033.get(0) + " " + TS0033.get(1);
		extentTest.log(Status.PASS, description33,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description32 + ".jpg")).build());

		// NPI
		ArrayList TS0034 = d.getData("TS0034", "TC0049");
		String servNPIPath = (String) TS0034.get(5);
		WebElement servNPI = driver.findElement(By.xpath(servNPIPath));
		servNPI.sendKeys((String) TS0034.get(6));
		String description34 = (String) TS0034.get(0) + " " + TS0034.get(1);
		extentTest.log(Status.PASS, description34,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description34 + ".jpg")).build());

		//Diagnosis Codes
		ArrayList TS0035 = d.getData("TS0035", "TC0049");
		String diagCodePath = (String) TS0035.get(5);
		WebElement diagCode = driver.findElement(By.xpath(diagCodePath));
		diagCode.sendKeys((String) TS0035.get(6));
		String description35 = (String) TS0035.get(0) + " " + TS0035.get(1);
		extentTest.log(Status.PASS, description35,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description35 + ".jpg")).build());

		// Next
		ArrayList TS0036 = d.getData("TS0036", "TC0049");
		String nextBtnPath2 = (String) TS0036.get(5);
		WebElement nextBtn2 = driver.findElement(By.xpath(nextBtnPath2));
		nextBtn2.click();
		Thread.sleep(5000);
		String description36 = (String) TS0036.get(0) + " " + TS0036.get(1);
		extentTest.log(Status.PASS, description36,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description36 + ".jpg")).build());

		Thread.sleep(5000);
		
		// Next
		ArrayList TS0037 = d.getData("TS0037", "TC0049");
		String nextBtnPath3 = (String) TS0037.get(5);
		WebElement nextBtn3 = driver.findElement(By.xpath(nextBtnPath3));
		nextBtn3.click();
		Thread.sleep(5000);
		String description37 = (String) TS0037.get(0) + " " + TS0037.get(1);
		extentTest.log(Status.PASS, description37,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description37 + ".jpg")).build());
		Thread.sleep(10000);
		
		// Finish
		ArrayList TS0038 = d.getData("TS0038", "TC0049");
		String finishBtnPath = (String) TS0038.get(5);
		WebElement finishBtn = driver.findElement(By.xpath(finishBtnPath));
		finishBtn.click();
		Thread.sleep(5000);
		String description38 = (String) TS0038.get(0) + " " + TS0038.get(1);
		extentTest.log(Status.PASS, description38,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description38 + ".jpg")).build());

	}
	@Test(priority = 8, testName = "Verify Provide the ability for Prospective Providers to access knowledge base via a link on the login screen, to VNS Health website to further understand the onboarding process.")
	public void verifyProspectiveProviderKnowledgeLink() throws InterruptedException, IOException {
		ArrayList TS0001 = d.getData("TS0001", "TC0050");
		String description1 = (String) TS0001.get(0) + " " + TS0001.get(1);
		extentTest.log(Status.PASS, description1);

		ArrayList TS0002 = d.getData("TS0002", "TC0050");
		String loginUrl = (String) TS0002.get(6);
		driver.get(loginUrl);
		String description2 = (String) TS0002.get(0) + " " + TS0002.get(1);
		extentTest.log(Status.PASS, description2,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description2 + ".jpg")).build());
		
		ArrayList TS0003 = d.getData("TS0003", "TC0050");
		String helpResourcesBtnPath = (String) TS0003.get(5);
		WebElement helpResoucesBtn = driver.findElement(By.xpath(helpResourcesBtnPath));
		helpResoucesBtn.click();
		Thread.sleep(5000);
		String description3 = (String) TS0003.get(0) + " " + TS0003.get(1);
		extentTest.log(Status.PASS, description3,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description3 + ".jpg")).build());

	}
	
}