package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.ProjectSpecificationMethods;
import pages.LoginPage;

public class TC007_SearchTest extends ProjectSpecificationMethods {
	@BeforeTest
	public void setup() {
		sheetname = "SearchFunction";
		testName = "SearchFunctionTest";
		testDescription = "Verify that user is able to search an order";
		testCategory = "Smoke Test";
		testAuthor = "Mukilan";
	}

	@Test(dataProvider = "readData")
	public void searchFunctionTest(String userName, String password, String expected, String testType)
			throws InterruptedException {
		LoginPage obj = new LoginPage(driver);
		obj.enterUsername(userName).enterPassword(password).clickLogin().clickBookedItineraryBtn()
				.searchAnOrder(expected, testType);
	}
}
