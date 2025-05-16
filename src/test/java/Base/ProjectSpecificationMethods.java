package Base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.UtilityClass;

public class ProjectSpecificationMethods extends UtilityClass {

	@BeforeSuite
	public void reportInitilization() {

		ExtentSparkReporter reporter = new ExtentSparkReporter(
				"C:\\Users\\mukil\\eclipse-workspace\\HotelApp\\resources\\Reports\\HotelAppReport.html");
		reporter.config().setReportName("HotelAppReport");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	@BeforeClass
	public void testDetails() {
		test = extent.createTest(testName, testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
	}

	@Parameters({ "browser", "url" })
	@BeforeMethod
	public void launchAndLoadingURL(String browser, String url) {
		launchBrowser(browser, url);
	}

	@AfterMethod
	public void browserclose() {
		waitForSeconds(2);
		closeBrowser();
	}

	@DataProvider
	public String[][] readData() throws IOException {
		String[][] data = excelRead(sheetname);
		return data;
	}

	@AfterSuite
	public void closereport() {
		extent.flush();
	}
}
