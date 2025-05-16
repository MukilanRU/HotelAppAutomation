package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.ProjectSpecificationMethods;
import pages.LoginPage;

public class TC005_ChangePasswordTest extends ProjectSpecificationMethods {

	@BeforeTest
	public void setup() {
		sheetname = "ChangePasswordData";
		testName = "ChangePasswordTest";
		testDescription = "Testing the Change Password Functionality";
		testCategory = "Smoke Test";
		testAuthor = "Mukilan";
	}

	@Test(dataProvider = "readData")
	public void changePasswordTest(String userName, String passWord, String currentPassword, String newPassword,
			String confirmPassword, String expected, String testType) throws InterruptedException {
		LoginPage obj = new LoginPage(driver);
		obj.enterUsername(userName).enterPassword(passWord).clickLogin().clickChangePasswordBtn()
				.enterCurrentPassword(currentPassword).enterNewPassword(newPassword)
				.enterConfirmPassword(confirmPassword).clickSubmitBtn().changePasswordValidation(expected, testType);
	}
}
