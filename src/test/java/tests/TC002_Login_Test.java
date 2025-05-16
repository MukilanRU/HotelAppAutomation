package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.ProjectSpecificationMethods;
import pages.LoginPage;

public class TC002_Login_Test extends ProjectSpecificationMethods {
	@BeforeTest
	public void setup() {
		sheetname = "LoginCredentials";
		testName = "Login Test";
		testDescription = "Testing the login functionality";
		testCategory = "Smoke Test";
		testAuthor = "Mukilan";
	}

	@Test(dataProvider = "readData")
	public void loginTest(String userName, String password, String expected, String testType)
			throws InterruptedException {
		LoginPage obj = new LoginPage(driver);
		obj.enterUsername(userName).enterPassword(password).clickLogin().loginValidation(expected, testType);
	}
}
