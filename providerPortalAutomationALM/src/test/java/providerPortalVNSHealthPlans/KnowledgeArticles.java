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

public class KnowledgeArticles extends BaseTest {

	JavascriptExecutor js = (JavascriptExecutor) driver;
	dataDrivenPP d = new dataDrivenPP();

	@Test
	public void loginProvider() throws InterruptedException, IOException {

		ArrayList TS0001 = d.getData("TS0001", "TC0057");
		String description1 = (String) TS0001.get(0) + " " + TS0001.get(1);
		extentTest.log(Status.PASS, description1);

		ArrayList TS0002 = d.getData("TS0002", "TC0057");
		String loginUrl = (String) TS0002.get(6);
		driver.get(loginUrl);

		String description2 = (String) TS0002.get(0) + " " + TS0002.get(1);
		extentTest.log(Status.PASS, description2,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description2 + ".jpg")).build());

		ArrayList TS0003 = d.getData("TS0003", "TC0057");
		String enterBtn = (String) TS0003.get(5);
		WebElement enter = driver.findElement(By.xpath(enterBtn));
		enter.click();

		String description3 = (String) TS0003.get(0) + " " + TS0003.get(1);
		extentTest.log(Status.PASS, description3,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description3 + ".jpg")).build());

		// enter username
		ArrayList TS0004 = d.getData("TS0004", "TC0057");
		String username = (String) TS0004.get(6);
		String unamePath = (String) TS0004.get(5);
		WebElement unameField = driver.findElement(By.xpath(unamePath));
		unameField.sendKeys(username);

		String description4 = (String) TS0004.get(0) + " " + TS0004.get(1);
		extentTest.log(Status.PASS, description4,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description4 + ".jpg")).build());

		// enter password
		ArrayList TS0005 = d.getData("TS0005", "TC0057");
		String pwdPath = (String) TS0005.get(5);
		WebElement pwd = driver.findElement(By.xpath(pwdPath));
		String password = (String) TS0005.get(6);
		pwd.sendKeys(password);

		String description5 = (String) TS0005.get(0) + " " + TS0005.get(1);
		extentTest.log(Status.PASS, description5,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description5 + ".jpg")).build());

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// login
		ArrayList TS0006 = d.getData("TS0006", "TC0057");
		String signOnPath = (String) TS0006.get(5);
		WebElement signOn = driver.findElement(By.xpath(signOnPath));
		signOn.click();
		Thread.sleep(5000);
		String description6 = (String) TS0006.get(0) + " " + TS0006.get(1);
		extentTest.log(Status.PASS, description6,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description6 + ".jpg")).build());

		Thread.sleep(5000);
	}

	@Test(priority = 1, dependsOnMethods="loginProvider",  description = "14.1 PROV-TECH-REQ-065 - Knowledge Articles - Verify Create a lightning page to display knowledge articles")
	public void verifyKnowledgeDisplay() throws InterruptedException, IOException {
		
		
		Thread.sleep(5000);
		//Click Resources Link
		ArrayList TS0007 = d.getData("TS0007", "TC0057");
		String resourcesPath = (String) TS0007.get(5);
		WebElement resources = driver.findElement(By.xpath(resourcesPath));
		resources.click();
		Thread.sleep(5000);
		String description7 = (String) TS0007.get(0) + " " + TS0007.get(1);
		extentTest.log(Status.PASS, description7,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description7 + ".jpg")).build());

		//Resource Type
		ArrayList TS0008 = d.getData("TS0008", "TC0057");
		String resTypeBtnPath = (String) TS0008.get(5);
		WebElement resourceType = driver.findElement(By.xpath(resTypeBtnPath));
		resourceType.click();
		Thread.sleep(5000);
		String description8 = (String) TS0008.get(0) + " " + TS0008.get(1);
		extentTest.log(Status.PASS, description8,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description8 + ".jpg")).build());
	
		//Select Knowledge
		ArrayList<String> TS0009 = d.getData("TS0009", "TC0057");
		String knowledgePath = (String) TS0009.get(5);
		WebElement knowledge = driver.findElement(By.xpath(knowledgePath));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", knowledge);
		knowledge.click();
		Thread.sleep(5000);
		String description9 = (String) TS0009.get(0) + " " + TS0009.get(1);
		extentTest.log(Status.PASS, description9,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description9 + ".jpg")).build());
	}

	@Test(priority = 2, dependsOnMethods="verifyKnowledgeDisplay", description = "14.2 PROV-TECH-REQ-066 - Knowledge Articles - Verify Enable the ability to search knowledge articles")
	public void verifySearchKnowledge() throws InterruptedException, IOException {

		//Enter text in search bar
		ArrayList TS0010 = d.getData("TS0010", "TC0058");
		String searchBarPath = (String) TS0010.get(5);
		WebElement searchBar = driver.findElement(By.xpath(searchBarPath));
		searchBar.sendKeys((String) TS0010.get(6));
		String description10 = (String) TS0010.get(0) + " " + TS0010.get(1);
		extentTest.log(Status.PASS, description10,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description10 + ".jpg")).build());
		
		//Verify Search Result
		ArrayList TS0011 = d.getData("TS0011", "TC0058");
		String searchResultPath = (String) TS0011.get(5);
		WebElement searchResult = driver.findElement(By.xpath(searchResultPath));
		 Assert.assertEquals((searchResult).getText(),(String) TS0011.get(6));
		String description11 = (String) TS0011.get(0) + " " + TS0011.get(1);
		extentTest.log(Status.PASS, description11,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(description11 + ".jpg")).build());	
		
	}
}