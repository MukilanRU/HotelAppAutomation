package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.ProjectSpecificationMethods;
import pages.LoginPage;

public class TC001_NewRegisterationTest extends ProjectSpecificationMethods {
	@BeforeTest
	public void setup() {
		sheetname = "NewRegisterUserCredentials";
		testName = "New RegisterationTest";
		testDescription = "Testing the New Registeration Functionality";
		testCategory = "Smoke Testing";
		testAuthor = "Mukilan";
	}

	@Test(dataProvider = "readData")
	public void newRegisterTest(String username, String password, String confirmpassword, String fullname, String email, String expected, String testType)
			throws InterruptedException {
		LoginPage obj = new LoginPage(driver);
		obj.clickNewRegButton().enterUsername(username).enterpassword(password).enterConfirmPassword(confirmpassword)
				.enterFullName(fullname).enterEmail(email).clicktncBox().clickSubmit().registerValidation(expected, testType);
	}
}
