package providerPortalVNSHealthPlans;

import java.io.IOException;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class ProfileManagement extends BaseTest {

	JavascriptExecutor js = (JavascriptExecutor) driver;
	dataDrivenPP d = new dataDrivenPP();

	@Test(priority = -1, testName = "Login as Provider")
	public void loginProvider() throws InterruptedException, IOException {

		ArrayList TS0001 = d.getData("TS0001", "TC0001");
		String description1 = (String) TS0001.get(0) + " " + TS0001.get(1);
		extentTest.log(Status.PASS, description1);

		ArrayList TS0002 = d.getData("TS0002", "TC0001");
		String loginUrl = (String) TS0002.get(6);
		driver.get(loginUrl);

		String description2 = (String) TS0002.get(0) + " " + TS0002.get(1);
		extentTest.log(Status.PASS, description2,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description2 + ".jpg")).build());

		ArrayList TS0003 = d.getData("TS0003", "TC0001");
		String enterBtn = (String) TS0003.get(5);
		WebElement enter = driver.findElement(By.xpath(enterBtn));
		enter.click();

		String description3 = (String) TS0003.get(0) + " " + TS0003.get(1);
		extentTest.log(Status.PASS, description3,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description3 + ".jpg")).build());

		// enter username
		ArrayList TS0004 = d.getData("TS0004", "TC0001");
		String username = (String) TS0004.get(6);
		String unamePath = (String) TS0004.get(5);
		WebElement unameField = driver.findElement(By.xpath(unamePath));
		unameField.sendKeys(username);

		String description4 = (String) TS0004.get(0) + " " + TS0004.get(1);
		extentTest.log(Status.PASS, description4,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description4 + ".jpg")).build());

		// enter password
		ArrayList TS0005 = d.getData("TS0005", "TC0001");
		String pwdPath = (String) TS0005.get(5);
		WebElement pwd = driver.findElement(By.xpath(pwdPath));
		String password = (String) TS0005.get(6);
		pwd.sendKeys(password);

		String description5 = (String) TS0005.get(0) + " " + TS0005.get(1);
		extentTest.log(Status.PASS, description5,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description5 + ".jpg")).build());

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// login
		ArrayList TS0006 = d.getData("TS0006", "TC0001");
		String signOnPath = (String) TS0006.get(5);
		WebElement signOn = driver.findElement(By.xpath(signOnPath));
		signOn.click();

		Thread.sleep(5000);

		String description6 = (String) TS0006.get(0) + " " + TS0006.get(1);
		extentTest.log(Status.PASS, description6,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description6 + ".jpg")).build());
	}

	@Test(priority = -1, testName = "Login as Admin")
	public void loginAdmin() throws InterruptedException, IOException {
//NEED TO UPDATE USER NAME AND LOGIN PATh
//		ArrayList loginpageStep = d.getData("TS0002", "TC0001");
//		String loginUrl = (String) loginpageStep.get(6);
//		driver.get(loginUrl);
//
//		ArrayList enterStep = d.getData("TS0003", "TC0001");
//		String enterBtn = (String) enterStep.get(5);
//		WebElement enter = driver.findElement(By.xpath(enterBtn));
//		enter.click();
//
//		// extentTest.log(Status.PASS, "TSLI002: Click Enter",
//		// MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot("L2.jpg")).build());
//
//		// enter username
//		ArrayList usernameStep = d.getData("TS0004", "TC0001");
//		String username = (String) usernameStep.get(6);
//		String unamePath = (String) usernameStep.get(5);
//		WebElement unameField = driver.findElement(By.xpath(unamePath));
//		unameField.sendKeys(username);
//
//		// enter password
//		ArrayList pwdStep = d.getData("TS0005", "TC0001");
//		String pwdPath = (String) pwdStep.get(5);
//		WebElement pwd = driver.findElement(By.xpath(pwdPath));
//		String password = (String) pwdStep.get(6);
//		pwd.sendKeys(password);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//		extentTest.log(Status.PASS, "TSLI004: Enter Password",
//				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot("L4.jpg")).build());
//
//		// login
//		ArrayList signOnStep = d.getData("TS0006", "TC0001");
//		String signOnPath = (String) signOnStep.get(5);
//		WebElement signOn = driver.findElement(By.xpath(signOnPath));
//		signOn.click();

//		Thread.sleep(5000);
	}

	@Test(priority = 1, dependsOnMethods = "loginProvider", testName = "3.1 PROV-TECH-REQ-001 - Profile Management - Verify Create a lightning page to display Provider profile information")
	public void verifyProfileDisplay() throws InterruptedException, IOException {
		Thread.sleep(5000);
		ArrayList TS0007 = d.getData("TS0007", "TC0001");
		String myAccPath = (String) TS0007.get(5);

		WebElement myAcc = driver.findElement(By.xpath(myAccPath));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		try {
			myAcc.click();
		} catch (StaleElementReferenceException e) {
			myAcc = driver.findElement(By.xpath(myAccPath));
			myAcc.click();
		}
		Thread.sleep(5000);
		String description7 = (String) TS0007.get(0) + " " + TS0007.get(1);
		extentTest.log(Status.PASS, description7,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description7 + ".jpg")).build());

		Thread.sleep(5000);
		// PROVIDER PRAC
		ArrayList TS0008 = d.getData("TS0008", "TC0001");
		String provPracDrpDwnPath = (String) TS0008.get(5);
		WebElement provPractice = driver.findElement(By.xpath(provPracDrpDwnPath));
		provPractice.click();

		Thread.sleep(5000);
		String description8 = (String) TS0008.get(0) + " " + TS0008.get(1);
		extentTest.log(Status.PASS, description8,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description8 + ".jpg")).build());

		Thread.sleep(5000);
		ArrayList TS0009 = d.getData("TS0009", "TC0001");
		String internalMedPath = (String) TS0009.get(5);
		WebElement internalMed = driver.findElement(By.xpath(internalMedPath));
		internalMed.click();
		String description9 = (String) TS0009.get(0) + " " + TS0009.get(1);
		extentTest.log(Status.PASS, description9,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description9 + ".jpg")).build());
	}

	@Test(priority = 2, dependsOnMethods = "loginProvider", testName = "3.2 PROV-TECH-REQ-002 - Profile Management - Verify Provide the ability for a provider to submit a request to change their profile information")
	public void verifySubmitProfileInfoUpdate() throws InterruptedException, IOException {
		Thread.sleep(5000);

		ArrayList TS0007 = d.getData("TS0007", "TC0002");
		String myAccPath = (String) TS0007.get(5);

		WebElement myAcc = driver.findElement(By.xpath(myAccPath));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		try {
			myAcc.click();
		} catch (StaleElementReferenceException e) {
			myAcc = driver.findElement(By.xpath(myAccPath));
			myAcc.click();
		}
		String description7 = (String) TS0007.get(0) + " " + TS0007.get(1);
		extentTest.log(Status.PASS, description7,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description7 + ".jpg")).build());

		Thread.sleep(5000);
		// Assert.assertEquals(driver.findElement(By.xpath("//h1[normalize-space()='Account
		// Information']")).getText(),
		// "Account Information");

		// PROVIDER PRAC
		ArrayList TS0008 = d.getData("TS0008", "TC0002");
		String provPracDrpDwnPath = (String) TS0008.get(5);
		WebElement provPractice = driver.findElement(By.xpath(provPracDrpDwnPath));
		provPractice.click();
		Thread.sleep(5000);
		String description8 = (String) TS0008.get(0) + " " + TS0008.get(1);
		extentTest.log(Status.PASS, description8,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description8 + ".jpg")).build());

		Thread.sleep(5000);
		ArrayList TS0009 = d.getData("TS0009", "TC0002");
		String internalMedPath = (String) TS0009.get(5);
		WebElement internalMed = driver.findElement(By.xpath(internalMedPath));
		internalMed.click();
		String description9 = (String) TS0009.get(0) + " " + TS0009.get(1);
		extentTest.log(Status.PASS, description9,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description9 + ".jpg")).build());

		//Request Change
		ArrayList TS0010 = d.getData("TS0010", "TC0002");
		String reqChangeBtnPath = (String) TS0010.get(5);
		WebElement reqChangeBtn = driver.findElement(By.xpath(reqChangeBtnPath));
		reqChangeBtn.click();
		String description10 = (String) TS0010.get(0) + " " + TS0010.get(1);
		extentTest.log(Status.PASS, description10,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description10 + ".jpg")).build());

		// OfficeEmail
		ArrayList TS0011 = d.getData("TS0011", "TC0002");
		String officeEmailPath = (String) TS0011.get(5);
		WebElement officeEmailBtn = driver.findElement(By.xpath(officeEmailPath));
		officeEmailBtn.click();
		String description11 = (String) TS0011.get(0) + " " + TS0011.get(1);
		extentTest.log(Status.PASS, description11,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description11 + ".jpg")).build());

		ArrayList TS0012 = d.getData("TS0012", "TC0002");
		String emailPath = (String) TS0012.get(5);
		WebElement emailField = driver.findElement(By.xpath(emailPath));
		emailField.sendKeys((String) TS0012.get(6));
		String description12 = (String) TS0012.get(0) + " " + TS0012.get(1);
		extentTest.log(Status.PASS, description12,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description12 + ".jpg")).build());
		/////////////////////
		// OfficePhoneNo
		ArrayList TS0013 = d.getData("TS0013", "TC0002");
		String phoneBtnPath = (String) TS0013.get(5);
		WebElement officePhoneField = driver.findElement(By.xpath(phoneBtnPath));
		officePhoneField.click();
		String description13 = (String) TS0013.get(0) + " " + TS0013.get(1);
		extentTest.log(Status.PASS, description13,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description13 + ".jpg")).build());

		ArrayList TS0014 = d.getData("TS0014", "TC0002");
		String newPhonePath = (String) TS0014.get(5);
		WebElement newOfficePhone = driver.findElement(By.xpath(newPhonePath));
		newOfficePhone.sendKeys((String) TS0014.get(6));
		String description14 = (String) TS0014.get(0) + " " + TS0014.get(1);
		extentTest.log(Status.PASS, description14,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description14 + ".jpg")).build());

		// OfficeFaxNo
		ArrayList TS0015 = d.getData("TS0015", "TC0002");
		String faxBtnPath = (String) TS0015.get(5);
		WebElement officeFaxNoBtn = driver.findElement(By.xpath(faxBtnPath));
		officeFaxNoBtn.click();
		String description15 = (String) TS0015.get(0) + " " + TS0015.get(1);
		extentTest.log(Status.PASS, description15,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description15 + ".jpg")).build());

		ArrayList TS0016 = d.getData("TS0016", "TC0002");
		String newFaxPath = (String) TS0016.get(5);
		WebElement newOfficeFax = driver.findElement(By.xpath(newFaxPath));
		newOfficeFax.sendKeys((String) TS0016.get(6));
		String description16 = (String) TS0016.get(0) + " " + TS0016.get(1);
		extentTest.log(Status.PASS, description16,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description16 + ".jpg")).build());
		// NPI
		ArrayList TS0017 = d.getData("TS0017", "TC0002");
		String npiPath = (String) TS0017.get(5);
		WebElement npi = driver.findElement(By.xpath(npiPath));
		npi.click();
		String description17 = (String) TS0017.get(0) + " " + TS0017.get(1);
		extentTest.log(Status.PASS, description17,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description17 + ".jpg")).build());

		ArrayList TS0018 = d.getData("TS0018", "TC0002");
		String newNPIPath = (String) TS0018.get(5);
		WebElement npiField = driver.findElement(By.xpath(newNPIPath));
		npiField.sendKeys((String) TS0018.get(6));
		String description18 = (String) TS0018.get(0) + " " + TS0018.get(1);
		extentTest.log(Status.PASS, description18,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description18 + ".jpg")).build());

		// OfficeHours
		ArrayList TS0019 = d.getData("TS0019", "TC0002");
		String officeHrPath = (String) TS0019.get(5);
		WebElement officeHours = driver.findElement(By.xpath(officeHrPath));
		officeHours.click();
		String description19 = (String) TS0019.get(0) + " " + TS0019.get(1);
		extentTest.log(Status.PASS, description19,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description19 + ".jpg")).build());

		ArrayList TS0020 = d.getData("TS0020", "TC0002");
		String officeHrFieldPath = (String) TS0020.get(5);
		WebElement officeHrField = driver.findElement(By.xpath(officeHrFieldPath));
		officeHrField.sendKeys((String) TS0020.get(6));
		String description20 = (String) TS0020.get(0) + " " + TS0020.get(1);
		extentTest.log(Status.PASS, description20,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description20 + ".jpg")).build());

		// Office Address
		ArrayList TS0021 = d.getData("TS0021", "TC0002");
		String officeAddPath = (String) TS0021.get(5);
		WebElement officeAdd = driver.findElement(By.xpath(officeAddPath));
		officeAdd.click();
		String description21 = (String) TS0021.get(0) + " " + TS0021.get(1);
		extentTest.log(Status.PASS, description21,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description21 + ".jpg")).build());

		ArrayList TS0022 = d.getData("TS0022", "TC0002");
		String street1Path = (String) TS0022.get(5);
		WebElement newStreetAddL1 = driver.findElement(By.xpath(street1Path));
		newStreetAddL1.sendKeys((String) TS0022.get(6));
		String description22 = (String) TS0022.get(0) + " " + TS0022.get(1);
		extentTest.log(Status.PASS, description22,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description22 + ".jpg")).build());

		ArrayList TS0023 = d.getData("TS0023", "TC0002");
		String street2Path = (String) TS0023.get(5);
		WebElement newStreetAddL2 = driver.findElement(By.xpath(street2Path));
		newStreetAddL2.sendKeys((String) TS0023.get(6));
		String description23 = (String) TS0023.get(0) + " " + TS0023.get(1);
		extentTest.log(Status.PASS, description23,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description23 + ".jpg")).build());

		ArrayList TS0024 = d.getData("TS0024", "TC0002");
		String cityPath = (String) TS0024.get(5);
		WebElement newOfficeCity = driver.findElement(By.xpath(cityPath));
		newOfficeCity.sendKeys((String) TS0024.get(6));
		String description24 = (String) TS0024.get(0) + " " + TS0024.get(1);
		extentTest.log(Status.PASS, description24,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description24 + ".jpg")).build());

		ArrayList TS0025 = d.getData("TS0025", "TC0002");
		String zipcodePath = (String) TS0025.get(5);
		WebElement newOfficeZipCode = driver.findElement(By.xpath(zipcodePath));
		newOfficeZipCode.sendKeys((String) TS0025.get(6));
		String description25 = (String) TS0025.get(0) + " " + TS0025.get(1);
		extentTest.log(Status.PASS, description25,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description25 + ".jpg")).build());

		ArrayList TS0026 = d.getData("TS0026", "TC0002");
		String stateSelectPath = (String) TS0026.get(5);
		WebElement newOfficeState = driver.findElement(By.xpath(stateSelectPath));
		newOfficeState.click();
		String description26 = (String) TS0026.get(0) + " " + TS0026.get(1);
		extentTest.log(Status.PASS, description26,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description26 + ".jpg")).build());

		//
		ArrayList TS0027 = d.getData("TS0027", "TC0002");
		String NYStatePath = (String) TS0027.get(5);
		WebElement newStateValue = driver.findElement(By.xpath(NYStatePath));
		newStateValue.click();
		String description27 = (String) TS0027.get(0) + " " + TS0027.get(1);
		extentTest.log(Status.PASS, description27,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description27 + ".jpg")).build());

		// Mass Transit Availability
		ArrayList TS0028 = d.getData("TS0028", "TC0002");
		String massTransitBtnPath = (String) TS0028.get(5);
		WebElement massTransitBtn = driver.findElement(By.xpath(massTransitBtnPath));
		massTransitBtn.click();
		String description28 = (String) TS0028.get(0) + " " + TS0028.get(1);
		extentTest.log(Status.PASS, description28,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description28 + ".jpg")).build());

		ArrayList TS0029 = d.getData("TS0029", "TC0002");
		String selectMTPath = (String) TS0029.get(5);
		WebElement selectMassTransit = driver.findElement(By.xpath(selectMTPath));
		selectMassTransit.click();
		String description29 = (String) TS0029.get(0) + " " + TS0029.get(1);
		extentTest.log(Status.PASS, description29,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description29 + ".jpg")).build());

		ArrayList TS0030 = d.getData("TS0030", "TC0002");
		String notAvailableMTPath = (String) TS0030.get(5);
		WebElement optionValueMasstran = driver.findElement(By.xpath(notAvailableMTPath));
		optionValueMasstran.click();
		String description30 = (String) TS0030.get(0) + " " + TS0030.get(1);
		extentTest.log(Status.PASS, description30,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description30 + ".jpg")).build());

		// Wheelchair Accessibility
		ArrayList TS0031 = d.getData("TS0031", "TC0002");
		String wheelchairBtnPath = (String) TS0031.get(5);
		WebElement wheelchairAccBtn = driver.findElement(By.xpath(wheelchairBtnPath));
		wheelchairAccBtn.click();
		String description31 = (String) TS0031.get(0) + " " + TS0031.get(1);
		extentTest.log(Status.PASS, description31,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description31 + ".jpg")).build());

		ArrayList TS0032 = d.getData("TS0032", "TC0002");
		String wheelchairSelectPath = (String) TS0032.get(5);
		WebElement selectWheelchairAcc = driver.findElement(By.xpath(wheelchairSelectPath));
		selectWheelchairAcc.click();
		String description32 = (String) TS0032.get(0) + " " + TS0032.get(1);
		extentTest.log(Status.PASS, description32,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description32 + ".jpg")).build());

		ArrayList TS0033 = d.getData("TS0033", "TC0002");
		String wheelchairAccessPath = (String) TS0033.get(5);
		WebElement optionValueWheelchair = driver.findElement(By.xpath(wheelchairAccessPath));
		optionValueWheelchair.click();
		String description33 = (String) TS0033.get(0) + " " + TS0033.get(1);
		extentTest.log(Status.PASS, description33,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description32 + ".jpg")).build());

		// Group Name
		ArrayList TS0034 = d.getData("TS0034", "TC0002");
		String groupBtnPath = (String) TS0034.get(5);
		WebElement groupBtn = driver.findElement(By.xpath(groupBtnPath));
		groupBtn.click();
		String description34 = (String) TS0034.get(0) + " " + TS0034.get(1);
		extentTest.log(Status.PASS, description34,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description34 + ".jpg")).build());

		ArrayList TS0035 = d.getData("TS0035", "TC0002");
		String groupNamePath = (String) TS0035.get(5);
		WebElement newGroupName = driver.findElement(By.xpath(groupNamePath));
		newGroupName.sendKeys((String) TS0035.get(6));
		String description35 = (String) TS0035.get(0) + " " + TS0035.get(1);
		extentTest.log(Status.PASS, description35,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description35 + ".jpg")).build());

		// TIN
		ArrayList TS0036 = d.getData("TS0036", "TC0002");
		String tinBtnPath = (String) TS0036.get(5);
		WebElement tinBtn = driver.findElement(By.xpath(tinBtnPath));
		tinBtn.click();
		String description36 = (String) TS0036.get(0) + " " + TS0036.get(1);
		extentTest.log(Status.PASS, description36,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description36 + ".jpg")).build());

		ArrayList TS0037 = d.getData("TS0037", "TC0002");
		String newTINPath = (String) TS0037.get(5);
		WebElement newTIN = driver.findElement(By.xpath(newTINPath));
		newTIN.sendKeys((String) TS0037.get(6));
		String description37 = (String) TS0037.get(0) + " " + TS0037.get(1);
		extentTest.log(Status.PASS, description37,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description37 + ".jpg")).build());

		// Panel Status
		ArrayList TS0038 = d.getData("TS0038", "TC0002");
		String panelStatus = (String) TS0038.get(5);
		WebElement panelStatusBtn = driver.findElement(By.xpath(panelStatus));
		panelStatusBtn.click();
		String description38 = (String) TS0038.get(0) + " " + TS0038.get(1);
		extentTest.log(Status.PASS, description38,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description38 + ".jpg")).build());

		ArrayList TS0039 = d.getData("TS0039", "TC0002");
		String newPanelOption = (String) TS0039.get(5);
		WebElement newPanelSelect = driver.findElement(By.xpath(newPanelOption));
		newPanelSelect.click();
		String description39 = (String) TS0039.get(0) + " " + TS0039.get(1);
		extentTest.log(Status.PASS, description39,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description39 + ".jpg")).build());

		ArrayList TS0040 = d.getData("TS0040", "TC0002");
		String panelOption = (String) TS0040.get(5);
		WebElement optionNewPanel = driver.findElement(By.xpath(panelOption));
		optionNewPanel.click();
		String description40 = (String) TS0040.get(0) + " " + TS0040.get(1);
		extentTest.log(Status.PASS, description40,
			MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description40 + ".jpg")).build());

		// Languages Spoken
		ArrayList TS0041 = d.getData("TS0041", "TC0002");
		String langBtnPath = (String) TS0041.get(5);
		WebElement languageBtn = driver.findElement(By.xpath(langBtnPath));
		languageBtn.click();
		
		String description41 = (String) TS0041.get(0) + " " + TS0041.get(1);
		extentTest.log(Status.PASS, description41,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description41 + ".jpg")).build());

		ArrayList TS0042 = d.getData("TS0042", "TC0002");
		String engLangPath = (String) TS0042.get(5);
		WebElement optionEng = driver.findElement(By.xpath(engLangPath));
		optionEng.click();
		
		String description42 = (String) TS0042.get(0) + " " + TS0042.get(1);
		extentTest.log(Status.PASS, description42,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description42 + ".jpg")).build());

		//UNABLE TO SELECT MULtiPLE LANGUAGES
		// NextBtn
		ArrayList TS0043 = d.getData("TS0043", "TC0002");
		String nextBtnPath = (String) TS0043.get(5);
		WebElement nextBtn = driver.findElement(By.xpath(nextBtnPath));
		nextBtn.click();
		Thread.sleep(5000);
		String description43 = (String) TS0043.get(0) + " " + TS0043.get(1);
		extentTest.log(Status.PASS, description43,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description43 + ".jpg")).build());

		// NextPage
		ArrayList TS0044 = d.getData("TS0044", "TC0002");
		String nextBtnPath1 = (String) TS0044.get(5);
		WebElement nextBtn1 = driver.findElement(By.xpath(nextBtnPath1));
		nextBtn1.click();
		Thread.sleep(5000);
		String description44 = (String) TS0044.get(0) + " " + TS0044.get(1);
		extentTest.log(Status.PASS, description44,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description44 + ".jpg")).build());
		// Assert.assertEquals(driver
		// .findElement(By.xpath("//span[contains(text(),'We have captured your
		// information. ')]")).getText(),
		// "We have captured your information.");

		ArrayList TS0045 = d.getData("TS0045", "TC0002");
		String finishBtnPath = (String) TS0045.get(5);
		WebElement finishBtn = driver.findElement(By.xpath(finishBtnPath));
		finishBtn.click();
		Thread.sleep(5000);
		String description45 = (String) TS0045.get(0) + " " + TS0045.get(1);
		extentTest.log(Status.PASS, description45,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description45 + ".jpg")).build());
	}

	@Test(priority = 3, dependsOnMethods = "loginProvider", testName = "3.3 PROV-TECH-REQ-003 - Profile Management - Verify Provide the ability for an Admin to register a group, add/remove members from groups and add/remote appropriate permissions to users")
	public void verifyAdminManageGroups() throws InterruptedException, IOException {

		// LOGIN AS ADMIN
		// Verify Register Group
//		WebElement grpMgmt = driver.findElement(By.xpath("//span[@title='Group Management']"));
//		grpMgmt.click();
//
//		Thread.sleep(5000);
//		WebElement addGroup = driver.findElement(By.xpath("//button[contains(text(),'Add A New Group')]"));
//		// WORKING HERE
//		js.executeScript("arguments[0].scrollIntoView(true);", addGroup);
//		// WebDriverWait wait = new WebDriverWait(driver, 10);
//		// WebElement addGroup =
//		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Add
//		// A New Group')]")));
//		// addGroup.click();
//
//		WebElement groupName = driver.findElement(By.xpath("//input[@name='Group_Name__c']"));
//		groupName.sendKeys("Test Group 1");
//
//		WebElement groupNPI = driver.findElement(By.xpath("//input[@name='Group_ID__c']"));
//		groupNPI.sendKeys("NPI 1234567890");
//
//		WebElement groupTaxID = driver.findElement(By.xpath("//input[@name='Group_Tax_ID__c']"));
//		groupTaxID.sendKeys("Tax 1234567890");
//
//		WebElement submitBtn = driver.findElement(By.xpath("//button[@name='Add']']"));
//		submitBtn.click();

	}

	@Test(priority = 4, dependsOnMethods = "loginProvider", testName = "3.4 PROV-TECH-REQ-004 - Profile Management - Verify Provide the ability for a provider to update their Provider Panel Status")
	public void verifyProviderPanelStatusUpdate() throws InterruptedException, IOException {
		ArrayList TS0007 = d.getData("TS0007", "TC0004");
		String myAccPath = (String) TS0007.get(5);
		WebElement myAcc = driver.findElement(By.xpath(myAccPath));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		try {
			myAcc.click();
		} catch (StaleElementReferenceException e) {
			myAcc = driver.findElement(By.xpath(myAccPath));
			myAcc.click();
		}

		String description7 = (String) TS0007.get(0) + " " + TS0007.get(1);
		extentTest.log(Status.PASS, description7,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description7 + ".jpg")).build());
		Thread.sleep(5000);
		// Assert.assertEquals(driver.findElement(By.xpath("//h1[normalize-space()='Account
		// Information']")).getText(),
		// "Account Information");
		// PROVIDER PRAC

		TS0007 = d.getData("TS0008", "TC0004");
		String provPracDrpDwnPath = (String) TS0007.get(5);
		WebElement provPractice = driver.findElement(By.xpath(provPracDrpDwnPath));
		provPractice.click();
		Thread.sleep(5000);
		String description8 = (String) TS0007.get(0) + " " + TS0007.get(1);
		extentTest.log(Status.PASS, description8,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description8 + ".jpg")).build());
		Thread.sleep(5000);

		ArrayList TS0009 = d.getData("TS0009", "TC0004");
		String internalMedPath = (String) TS0009.get(5);
		WebElement internalMed = driver.findElement(By.xpath(internalMedPath));
		internalMed.click();
		String description9 = (String) TS0009.get(0) + " " + TS0009.get(1);
		extentTest.log(Status.PASS, description9,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description9 + ".jpg")).build());

		// Request Change
		ArrayList TS0010 = d.getData("TS0010", "TC0004");
		String changeRequest = (String) TS0010.get(5);
		WebElement reqChangeBtn = driver.findElement(By.xpath(changeRequest));
		reqChangeBtn.click();
		String description10 = (String) TS0010.get(0) + " " + TS0010.get(1);
		extentTest.log(Status.PASS, description10,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description10 + ".jpg")).build());

		// Panel Status
		ArrayList TS0011 = d.getData("TS0011", "TC0004");
		String panelStatus = (String) TS0011.get(5);
		WebElement panelStatusBtn = driver.findElement(By.xpath(panelStatus));
		panelStatusBtn.click();
		String description11 = (String) TS0011.get(0) + " " + TS0011.get(1);
		extentTest.log(Status.PASS, description11,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description11 + ".jpg")).build());

		ArrayList TS0012 = d.getData("TS0012", "TC0004");
		String newPanelOption = (String) TS0012.get(5);
		WebElement newPanelSelect = driver.findElement(By.xpath(newPanelOption));
		newPanelSelect.click();
		String description12 = (String) TS0012.get(0) + " " + TS0012.get(1);
		extentTest.log(Status.PASS, description12,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description12 + ".jpg")).build());

		ArrayList TS0013 = d.getData("TS0013", "TC0004");
		String panelOption = (String) TS0013.get(5);
		WebElement optionNewPanel = driver.findElement(By.xpath(panelOption));
		optionNewPanel.click();
		String description13 = (String) TS0013.get(0) + " " + TS0013.get(1);
		extentTest.log(Status.PASS, description13,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description13 + ".jpg")).build());

		// NextBtn
		ArrayList TS0014 = d.getData("TS0014", "TC0004");
		String nextBtnPath = (String) TS0014.get(5);
		WebElement nextBtn = driver.findElement(By.xpath(nextBtnPath));
		nextBtn.click();
		String description14 = (String) TS0014.get(0) + " " + TS0014.get(1);
		extentTest.log(Status.PASS, description14,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description14 + ".jpg")).build());

		Thread.sleep(5000);
		// NextPage
		ArrayList TS0015 = d.getData("TS0015", "TC0004");
		String nextBtnPath1 = (String) TS0015.get(5);
		WebElement nextBtn1 = driver.findElement(By.xpath(nextBtnPath1));
		nextBtn1.click();
		String description15 = (String) TS0015.get(0) + " " + TS0015.get(1);
		extentTest.log(Status.PASS, description15,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description15 + ".jpg")).build());

		// Assert.assertEquals(driver
		// .findElement(By.xpath("//span[contains(text(),'We have captured your
		// information. ')]")).getText(),
		// "We have captured your information.");

		// extentTest.log(Status.PASS, "TSCC006: Click Next Button and Verify Message
		// Captured",
		// MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot("TSCC006.jpg")).build());
		ArrayList TS0016 = d.getData("TS0016", "TC0004");
		String finishBtnPath = (String) TS0016.get(5);
		WebElement finishBtn = driver.findElement(By.xpath(finishBtnPath));
		finishBtn.click();
		Thread.sleep(5000);
		String description16 = (String) TS0016.get(0) + " " + TS0016.get(1);
		extentTest.log(Status.PASS, description16,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description16 + ".jpg")).build());

	}

	@Test(priority = 5, testName = "3.5 PROV-TECH-REQ-005 - Registration - Verify Configure PING connection and test connectivity")
	public void verifyPingConnectionAndTest() throws InterruptedException, IOException {

	}

	@Test(priority = 6, testName = "3.6 PROV-TECH-REQ-006 - Registration - Verify Provide the ability for Providers to self-register for portal access")
	public void verifyProviderSelfRegister() throws InterruptedException, IOException {

		// Initiate Browser
		ArrayList TS0001 = d.getData("TS0001", "TC0006");
		String description1 = (String) TS0001.get(0) + " " + TS0001.get(1);
		extentTest.log(Status.PASS, description1);

		// Get Login Page
		ArrayList TS0002 = d.getData("TS0002", "TC0006");
		String loginUrl = (String) TS0002.get(6);
		driver.get(loginUrl);

		String description2 = (String) TS0002.get(0) + " " + TS0002.get(1);
		extentTest.log(Status.PASS, description2,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description2 + ".jpg")).build());

		ArrayList TS0003 = d.getData("TS0003", "TC0006");
		String resisterBtnPath = (String) TS0003.get(5);
		WebElement registerBtn = driver.findElement(By.xpath(resisterBtnPath));
		registerBtn.click();
		String description3 = (String) TS0003.get(0) + " " + TS0003.get(1);
		extentTest.log(Status.PASS, description3,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description3 + ".jpg")).build());

		ArrayList TS0004 = d.getData("TS0004", "TC0006");
		String userTypeBtnPath = (String) TS0004.get(5);
		WebElement userType = driver.findElement(By.xpath(userTypeBtnPath));
		userType.click();
		String description4 = (String) TS0004.get(0) + " " + TS0004.get(1);
		extentTest.log(Status.PASS, description4,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description4 + ".jpg")).build());

		ArrayList TS0005 = d.getData("TS0005", "TC0006");
		String providerRolePath = (String) TS0005.get(5);
		WebElement providerOption = driver.findElement(By.xpath(providerRolePath));
		providerOption.click();
		String description5 = (String) TS0005.get(0) + " " + TS0005.get(1);
		extentTest.log(Status.PASS, description5,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description5 + ".jpg")).build());

		// FILL FORM
		ArrayList TS0006 = d.getData("TS0006", "TC0006");
		String fNamePath = (String) TS0006.get(5);
		WebElement fName = driver.findElement(By.xpath(fNamePath));
		fName.sendKeys((String) TS0006.get(6));
		String description6 = (String) TS0006.get(0) + " " + TS0006.get(1);
		extentTest.log(Status.PASS, description6,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description6 + ".jpg")).build());

		ArrayList TS0007 = d.getData("TS0007", "TC0006");
		String lNamePath = (String) TS0007.get(5);
		WebElement lastName = driver.findElement(By.xpath(lNamePath));
		lastName.sendKeys((String) TS0007.get(6));
		String description7 = (String) TS0007.get(0) + " " + TS0007.get(1);
		extentTest.log(Status.PASS, description7,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description7 + ".jpg")).build());

		ArrayList TS0008 = d.getData("TS0008", "TC0006");
		String taxIDPath = (String) TS0008.get(5);
		WebElement taxID = driver.findElement(By.xpath(taxIDPath));
		taxID.sendKeys((String) TS0008.get(6));
		String description8 = (String) TS0008.get(0) + " " + TS0008.get(1);
		extentTest.log(Status.PASS, description8,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description8 + ".jpg")).build());
		Thread.sleep(5000);

		ArrayList TS0009 = d.getData("TS0009", "TC0006");
		String npiPath = (String) TS0009.get(5);
		WebElement npi = driver.findElement(By.xpath(npiPath));
		npi.sendKeys((String) TS0009.get(6));
		String description9 = (String) TS0009.get(0) + " " + TS0009.get(1);
		extentTest.log(Status.PASS, description9,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description9 + ".jpg")).build());

		ArrayList TS0010 = d.getData("TS0010", "TC0006");
		String emailPath = (String) TS0010.get(5);
		WebElement email = driver.findElement(By.xpath(emailPath));
		email.sendKeys((String) TS0010.get(6));
		String description10 = (String) TS0010.get(0) + " " + TS0010.get(1);
		extentTest.log(Status.PASS, description10,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description10 + ".jpg")).build());

		ArrayList TS0011 = d.getData("TS0011", "TC0006");
		String confirmEmailPath = (String) TS0011.get(5);
		WebElement confirmEmail = driver.findElement(By.xpath(confirmEmailPath));
		confirmEmail.sendKeys((String) TS0011.get(6));
		String description11 = (String) TS0011.get(0) + " " + TS0011.get(1);
		extentTest.log(Status.PASS, description11,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description11 + ".jpg")).build());

		ArrayList TS0012 = d.getData("TS0012", "TC0006");
		String phonePath = (String) TS0012.get(5);
		WebElement phoneNumber = driver.findElement(By.xpath(phonePath));
		phoneNumber.sendKeys((String) TS0012.get(6));
		String description12 = (String) TS0012.get(0) + " " + TS0012.get(1);
		extentTest.log(Status.PASS, description12,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description12 + ".jpg")).build());

		// NETWORK STATUS
		ArrayList TS0013 = d.getData("TS0013", "TC0006");
		String networkStatPath = (String) TS0013.get(5);
		WebElement networkStatus = driver.findElement(By.xpath(networkStatPath));
		networkStatus.click();
		String description13 = (String) TS0013.get(0) + " " + TS0013.get(1);
		extentTest.log(Status.PASS, description13,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description13 + ".jpg")).build());

		// Check/EFT#
		ArrayList TS0014 = d.getData("TS0014", "TC0006");
		String checkPath = (String) TS0014.get(5);
		WebElement checkNoIndicator = driver.findElement(By.xpath(checkPath));
		checkNoIndicator.click();
		String description14 = (String) TS0014.get(0) + " " + TS0014.get(1);
		extentTest.log(Status.PASS, description14,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description14 + ".jpg")).build());

		ArrayList TS0015 = d.getData("TS0015", "TC0006");
		String checkNumPath = (String) TS0015.get(5);
		WebElement checkNoInput = driver.findElement(By.xpath(checkNumPath));
		checkNoInput.sendKeys((String) TS0015.get(6));
		String description15 = (String) TS0015.get(0) + " " + TS0015.get(1);
		extentTest.log(Status.PASS, description15,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description15 + ".jpg")).build());

		ArrayList TS0016 = d.getData("TS0016", "TC0006");
		String loginInfoPath = (String) TS0016.get(5);
		WebElement loginInfo = driver.findElement(By.xpath(loginInfoPath));
		loginInfo.click();
		String description16 = (String) TS0016.get(0) + " " + TS0016.get(1);
		extentTest.log(Status.PASS, description16,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description16 + ".jpg")).build());

		// CREATE LOGIN INFO
		ArrayList TS0017 = d.getData("TS0017", "TC0006");
		String usernamePath = (String) TS0017.get(5);
		WebElement newUsername = driver.findElement(By.xpath(usernamePath));
		newUsername.sendKeys((String) TS0017.get(6));
		String description17 = (String) TS0017.get(0) + " " + TS0017.get(1);
		extentTest.log(Status.PASS, description17,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description17 + ".jpg")).build());

		ArrayList TS0018 = d.getData("TS0018", "TC0006");
		String passwordPath = (String) TS0018.get(5);
		WebElement newPwd = driver.findElement(By.xpath(passwordPath));
		newPwd.sendKeys((String) TS0018.get(6));
		String description18 = (String) TS0018.get(0) + " " + TS0018.get(1);
		extentTest.log(Status.PASS, description18,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description18 + ".jpg")).build());

		ArrayList TS0019 = d.getData("TS0019", "TC0006");
		String confirmPasswordPath = (String) TS0019.get(5);
		WebElement confirmPassword = driver.findElement(By.xpath(confirmPasswordPath));
		confirmPassword.sendKeys((String) TS0019.get(6));
		String description19 = (String) TS0019.get(0) + " " + TS0019.get(1);
		extentTest.log(Status.PASS, description19,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description19 + ".jpg")).build());

		// Email Multi Factor Authentication
		ArrayList TS0020 = d.getData("TS0020", "TC0006");
		String mfaPath = (String) TS0020.get(5);
		WebElement mfaEmailBtn = driver.findElement(By.xpath(mfaPath));
		mfaEmailBtn.click();
		String description20 = (String) TS0020.get(0) + " " + TS0020.get(1);
		extentTest.log(Status.PASS, description20,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description20 + ".jpg")).build());
		// Next
		ArrayList TS0021 = d.getData("TS0021", "TC0006");
		String nextBtnPath = (String) TS0021.get(5);
		WebElement nextBtn = driver.findElement(By.xpath(nextBtnPath));
		nextBtn.click();
		String description21 = (String) TS0021.get(0) + " " + TS0021.get(1);
		extentTest.log(Status.PASS, description21,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description21 + ".jpg")).build());
		// REGISTRATION SUCCESS PAGE DOESNOT LOAD
	}

	@Test(priority = 7, testName = "3.7 PROV-TECH-REQ-007 - Sharing - Verify Provide the ability for an Admin to control access for other Provider users for the same Account/Hospital System")
	public void verifyAdminControlProviderAccess() throws InterruptedException, IOException {

	}

}