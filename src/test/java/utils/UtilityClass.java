package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class UtilityClass {
	public static WebDriver driver;
	public String sheetname;
	public static ExtentTest test;
	public static ExtentReports extent;
	public String testName, testDescription, testCategory, testAuthor;

	public void launchBrowser(String browser, String Url) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(Url);
	}

	public void closeBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}

	public static String[][] excelRead(String sheetname) throws IOException {
		FileInputStream file;
		file = new FileInputStream("C:\\Users\\mukil\\eclipse-workspace\\HotelApp\\resources\\Excel\\TestData1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		int rowCount = sheet.getLastRowNum();
		short coloumnCount = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[rowCount][coloumnCount];
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			if (row != null) {

				for (int j = 0; j < coloumnCount; j++) {
					XSSFCell cell = row.getCell(j);
					if (cell != null) {
						data[i - 1][j] = cell.getStringCellValue();
					}
				}
			}

		}
		workbook.close();
		return data;
	}

	public String screenShot(String name) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		String path = "C:\\Users\\mukil\\eclipse-workspace\\HotelApp\\resources\\Snaps\\" + name + timeStamp + ".png";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File des = new File(path);
		FileUtils.copyFile(src, des);
		return path;
	}

	public WebElement waitForVisibilityOfElement(WebElement element, int timeoutSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForSeconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
