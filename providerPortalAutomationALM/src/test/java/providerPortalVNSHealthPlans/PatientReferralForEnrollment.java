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

public class PatientReferralForEnrollment extends BaseTest {

	JavascriptExecutor js = (JavascriptExecutor) driver;
	dataDrivenPP d = new dataDrivenPP();

	@Test(priority = -1,  testName = "Login as Provider")
	public void loginProvider() throws InterruptedException, IOException {

		ArrayList TS0001 = d.getData("TS0001", "TC0025");
		String description1 = (String) TS0001.get(0) + " " + TS0001.get(1);
		extentTest.log(Status.PASS, description1);

		ArrayList TS0002 = d.getData("TS0002", "TC0025");
		String loginUrl = (String) TS0002.get(6);
		driver.get(loginUrl);

		String description2 = (String) TS0002.get(0) + " " + TS0002.get(1);
		extentTest.log(Status.PASS, description2,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description2 + ".jpg")).build());

		ArrayList TS0003 = d.getData("TS0003", "TC0025");
		String enterBtn = (String) TS0003.get(5);
		WebElement enter = driver.findElement(By.xpath(enterBtn));
		enter.click();

		String description3 = (String) TS0003.get(0) + " " + TS0003.get(1);
		extentTest.log(Status.PASS, description3,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description3 + ".jpg")).build());

		// enter username
		ArrayList TS0004 = d.getData("TS0004", "TC0025");
		String username = (String) TS0004.get(6);
		String unamePath = (String) TS0004.get(5);
		WebElement unameField = driver.findElement(By.xpath(unamePath));
		unameField.sendKeys(username);

		String description4 = (String) TS0004.get(0) + " " + TS0004.get(1);
		extentTest.log(Status.PASS, description4,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description4 + ".jpg")).build());

		// enter password
		ArrayList TS0005 = d.getData("TS0005", "TC0025");
		String pwdPath = (String) TS0005.get(5);
		WebElement pwd = driver.findElement(By.xpath(pwdPath));
		String password = (String) TS0005.get(6);
		pwd.sendKeys(password);

		String description5 = (String) TS0005.get(0) + " " + TS0005.get(1);
		extentTest.log(Status.PASS, description5,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description5 + ".jpg")).build());

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// login
		ArrayList TS0006 = d.getData("TS0006", "TC0025");
		String signOnPath = (String) TS0006.get(5);
		WebElement signOn = driver.findElement(By.xpath(signOnPath));
		signOn.click();

		Thread.sleep(5000);

		String description6 = (String) TS0006.get(0) + " " + TS0006.get(1);
		extentTest.log(Status.PASS, description6,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description6 + ".jpg")).build());
	}

	@Test(priority = 1, dependsOnMethods="loginProvider", testName = "6.1 PROV-TECH-REQ-025 - Patient Referrals for Enrollment - Verify Provide the ability to capture a Referral for Enrollment")
	public void verifyPatientRefEnrollment() throws InterruptedException, IOException {

		// Patients
		Thread.sleep(5000);

		ArrayList TS0007 = d.getData("TS0007", "TC0025");
		String patientPath = (String) TS0007.get(5);
		WebElement patients = driver.findElement(By.xpath(patientPath));
		Actions action = new Actions(driver);
		action.moveToElement(patients).perform();
		String description7 = (String) TS0007.get(0) + " " + TS0007.get(1);
		extentTest.log(Status.PASS, description7,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description7 + ".jpg")).build());

		Thread.sleep(5000);
		ArrayList TS0008 = d.getData("TS0008", "TC0025");
		String enrollmentRefPath = (String) TS0008.get(5);
		WebElement enrollmentRef = driver.findElement(By.xpath(enrollmentRefPath));
		try {
			enrollmentRef.click();
		} catch (StaleElementReferenceException e) {
			enrollmentRef = driver.findElement(By.xpath(enrollmentRefPath));
			enrollmentRef.click();
		}
		Thread.sleep(5000);
		String description8 = (String) TS0008.get(0) + " " + TS0008.get(1);
		extentTest.log(Status.PASS, description8,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description8 + ".jpg")).build());

		// Assert.assertEquals(
		// driver.findElement(By.xpath("//strong[normalize-space()='Patient Enrollment
		// Referrals']")).getText(),
		// "Patient Enrollment Referrals");

		Thread.sleep(5000);
		// SUBMIT REF*********************************************
		ArrayList TS0009 = d.getData("TS0009", "TC0025");
		String submitRefPath = (String) TS0009.get(5);
		WebElement submitRef = driver.findElement(By.xpath(submitRefPath));
		submitRef.click();
		String description9 = (String) TS0009.get(0) + " " + TS0009.get(1);
		extentTest.log(Status.PASS, description9,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description9 + ".jpg")).build());

		Thread.sleep(5000);
		 String parentHandle = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		ArrayList TS0010 = d.getData("TS0010", "TC0025");
		String titlePath = (String) TS0010.get(5);
		Assert.assertEquals(driver.findElement(By.xpath(titlePath)).getText(), (String) TS0010.get(6));
		String description10 = (String) TS0010.get(0) + " " + TS0010.get(1);
		extentTest.log(Status.PASS, description10,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description10 + ".jpg")).build());
		driver.close(); // close newly opened window when done with it
		driver.switchTo().window(parentHandle); // switch back to the original window
	}

	@Test(priority = 3,dependsOnMethods="loginProvider", testName = "6.3 PROV-TECH-REQ-027 - Patient Referrals for Enrollment - Verify For prospective providers, display a link to FAQs/Knowledge Article to search for information")
	public void verifyResourcesLinkDisplay() throws InterruptedException, IOException {
		Thread.sleep(5000);
		//Open Resources
		ArrayList TS0007 = d.getData("TS0007", "TC0026");
		String resourcesPath = (String) TS0007.get(5);
		WebElement resources = driver.findElement(By.xpath(resourcesPath));
		try {
			resources.click();
		} catch (StaleElementReferenceException e) {
			resources = driver.findElement(By.xpath(resourcesPath));
			resources.click();
		}
		String description7 = (String) TS0007.get(0) + " " + TS0007.get(1);
		extentTest.log(Status.PASS, description7,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description7 + ".jpg")).build());
		
		Thread.sleep(5000);
		
		//Assert
		ArrayList TS0008 = d.getData("TS0008", "TC0026");
		String titlePath = (String) TS0008.get(5);
		Assert.assertEquals(driver.findElement(By.xpath(titlePath)).getText(),
				(String) TS0008.get(6));
		String description8 = (String) TS0008.get(0) + " " + TS0008.get(1);
		extentTest.log(Status.PASS, description8,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description8 + ".jpg")).build());
	}
	
	
}