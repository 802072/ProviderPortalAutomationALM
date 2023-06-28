package extentReport;

import java.awt.Desktop;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;
import dataDrivenPP.dataDrivenPP;

public class BaseTest {
	public static WebDriver driver;
	public static String screenshotsSubFolderName;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	public static ExtentTest testStepExtentTest;
	String myhomePage = "https://providerportal.vnshealthplans.org/login";
	String excelPath = "C:\\Users\\802072\\eclipse-workspace1\\providerPortalAutomationALM\\src\\test\\resources\\testData\\testData.xlsx";
	String sheetName = "loginInfo";
	dataDrivenPP d = new dataDrivenPP();
	
	@Parameters("browserName")
	@BeforeTest
	public void setup(ITestContext context, @Optional("chrome") String browserName) throws IOException, InterruptedException {
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
		driver.manage().window().maximize();
	
		//Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
		//String device = capabilities.getBrowserName() + " "
				//+ capabilities.getVersion().substring(0, capabilities.getVersion().indexOf("."));
		//String author = context.getCurrentXmlTest().getParameter("author");

		extentTest = extentReports.createTest(context.getName());
		//extentTest.assignAuthor(author);
		//extentTest.assignDevice(device);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@BeforeSuite
	public void initialiseExtentReports() {
		ExtentSparkReporter sparkReporter_all = new ExtentSparkReporter("ProviderPortalTests.html");
		sparkReporter_all.config().setReportName("VNS Health Provider Portal Automation Test Report");

		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter_all);

		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		

	}

	@AfterSuite
	public void generateExtentReports() throws Exception {
		extentReports.flush();
		//Desktop.getDesktop().browse(new File("ProviderPortalTests.html").toURI());
		//Desktop.getDesktop().browse(new File("FailedTests.html").toURI());
	}

	@AfterMethod
	public void checkStatus(Method m, ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			
			String screenshotpath = null;
			screenshotpath = captureScreenshot("failTest.jpg");
			extentTest.fail(m.getName() + " has failed");
			extentTest.log(Status.FAIL, result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath).build());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			
		}

		extentTest.assignCategory(m.getAnnotation(Test.class).groups());
	}

	/*
	 * @AfterTest public void teardown() { driver.quit(); }
	 */
	

	public String captureScreenshot(String screenShotName) throws IOException {
		File sourceFile= ( (TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotpath= "./Screenshots/"+screenShotName;
		File path= new File(screenshotpath);
		FileUtils.copyFile(sourceFile, path);
		
		return screenshotpath;
		
	}
}