package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.ProjectSpecificationMethods;
import pages.LoginPage;

public class TC008_LogoutTest extends ProjectSpecificationMethods {
	@BeforeTest
	public void setup() {
		sheetname = "LogoutData";
		testName = "LogoutTest";
		testDescription = "To Verify the Logout Functionality";
		testCategory = "Smoke Test";
		testAuthor = "Mukilan";
	}

	@Test(dataProvider = "readData")
	public void logoutTest(String userName, String passWord, String expected) {
		LoginPage obj = new LoginPage(driver);
		obj.enterUsername(userName).enterPassword(passWord).clickLogin().clickLogoutBtn().logoutValidation(expected);
		;
	}

}
