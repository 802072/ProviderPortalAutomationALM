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

public class Reporting extends BaseTest {

	JavascriptExecutor js = (JavascriptExecutor) driver;
	dataDrivenPP d = new dataDrivenPP();

	@Test(priority = -1, testName = "Login as Provider")
	public void loginProvider() throws InterruptedException, IOException {

		ArrayList TS0001 = d.getData("TS0001", "TC0053");
		String description1 = (String) TS0001.get(0) + " " + TS0001.get(1);
		extentTest.log(Status.PASS, description1);

		ArrayList TS0002 = d.getData("TS0002", "TC0053");
		String loginUrl = (String) TS0002.get(6);
		driver.get(loginUrl);

		String description2 = (String) TS0002.get(0) + " " + TS0002.get(1);
		extentTest.log(Status.PASS, description2,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description2 + ".jpg")).build());

		ArrayList TS0003 = d.getData("TS0003", "TC0053");
		String enterBtn = (String) TS0003.get(5);
		WebElement enter = driver.findElement(By.xpath(enterBtn));
		enter.click();

		String description3 = (String) TS0003.get(0) + " " + TS0003.get(1);
		extentTest.log(Status.PASS, description3,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description3 + ".jpg")).build());

		// enter username
		ArrayList TS0004 = d.getData("TS0004", "TC0053");
		String username = (String) TS0004.get(6);
		String unamePath = (String) TS0004.get(5);
		WebElement unameField = driver.findElement(By.xpath(unamePath));
		unameField.sendKeys(username);

		String description4 = (String) TS0004.get(0) + " " + TS0004.get(1);
		extentTest.log(Status.PASS, description4,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description4 + ".jpg")).build());

		// enter password
		ArrayList TS0005 = d.getData("TS0005", "TC0053");
		String pwdPath = (String) TS0005.get(5);
		WebElement pwd = driver.findElement(By.xpath(pwdPath));
		String password = (String) TS0005.get(6);
		pwd.sendKeys(password);

		String description5 = (String) TS0005.get(0) + " " + TS0005.get(1);
		extentTest.log(Status.PASS, description5,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description5 + ".jpg")).build());

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// login
		ArrayList TS0006 = d.getData("TS0006", "TC0053");
		String signOnPath = (String) TS0006.get(5);
		WebElement signOn = driver.findElement(By.xpath(signOnPath));
		signOn.click();

		Thread.sleep(5000);

		String description6 = (String) TS0006.get(0) + " " + TS0006.get(1);
		extentTest.log(Status.PASS, description6,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description6 + ".jpg")).build());

	}

	@Test(priority = 2, dependsOnMethods = "loginProvider", testName = "11.2 PROV-TECH-REQ-061 - Provider Dashboard - Verify Create provider dashboard homepage")
	public void verifyProviderDashboardHomepage() throws InterruptedException, IOException {

		//Click Search or Filter authorizations Link
		ArrayList TS0007 = d.getData("TS0007", "TC0053");
		String authSearchPath = (String) TS0007.get(5);
		WebElement authSearch = driver.findElement(By.xpath(authSearchPath));
		authSearch.click();
		Thread.sleep(5000);
		String description7 = (String) TS0007.get(0) + " " + TS0007.get(1);
		extentTest.log(Status.PASS, description7,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description7 + ".jpg")).build());

		//Return Home
		ArrayList TS0008 = d.getData("TS0008", "TC0053");
		String homeBtnPath = (String) TS0008.get(5);
		WebElement homeBtn = driver.findElement(By.xpath(homeBtnPath));
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
	      executor.executeScript("arguments[0].click();", homeBtn);
		//homeBtn.click();
		Thread.sleep(5000);
		String description8 = (String) TS0008.get(0) + " " + TS0008.get(1);
		extentTest.log(Status.PASS, description8,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description8 + ".jpg")).build());

		//Click Claim Search Link
		Thread.sleep(5000);
		ArrayList TS0009 = d.getData("TS0009", "TC0053");
		String claimSearchPath = (String) TS0009.get(5);
		WebElement claimSearch = driver.findElement(By.xpath(claimSearchPath));
		claimSearch.click();
		Thread.sleep(5000);
		String description9 = (String) TS0009.get(0) + " " + TS0009.get(1);
		extentTest.log(Status.PASS, description9,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description9 + ".jpg")).build());

		//Return Home
		ArrayList TS0010 = d.getData("TS0010", "TC0053");
		homeBtn.click();
		Thread.sleep(5000);
		String description10 = (String) TS0010.get(0) + " " + TS0010.get(1);
		extentTest.log(Status.PASS, description10,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description10 + ".jpg")).build());

		//Click View My Personal Details
		ArrayList TS0011 = d.getData("TS0011", "TC0053");
		String viewPersonalDetPath = (String) TS0011.get(5);
		WebElement viewPersonalDet = driver.findElement(By.xpath(viewPersonalDetPath));
		viewPersonalDet.click();
		Thread.sleep(5000);
		String description11 = (String) TS0011.get(0) + " " + TS0011.get(1);
		extentTest.log(Status.PASS, description11,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description11 + ".jpg")).build());

		//Return Home
		ArrayList TS0012 = d.getData("TS0012", "TC0053");
		homeBtn.click();
		Thread.sleep(5000);
		String description12 = (String) TS0012.get(0) + " " + TS0012.get(1);
		extentTest.log(Status.PASS, description12,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description12 + ".jpg")).build());

		//Click View My Messages
		ArrayList TS0013 = d.getData("TS0013", "TC0053");
		String viewMsgsPath = (String) TS0013.get(5);
		WebElement viewMsgs = driver.findElement(By.xpath(viewMsgsPath));
		viewMsgs.click();
		Thread.sleep(5000);
		String description13 = (String) TS0013.get(0) + " " + TS0013.get(1);
		extentTest.log(Status.PASS, description13,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description13 + ".jpg")).build());
	
		//Return Home
		ArrayList TS0014 = d.getData("TS0014", "TC0053");
		homeBtn.click();
		Thread.sleep(5000);
		String description14 = (String) TS0014.get(0) + " " + TS0014.get(1);
		extentTest.log(Status.PASS, description14,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description14 + ".jpg")).build());

	
	}


	
}