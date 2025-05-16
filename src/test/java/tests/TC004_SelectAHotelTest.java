package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.ProjectSpecificationMethods;
import pages.LoginPage;

public class TC004_SelectAHotelTest extends ProjectSpecificationMethods {
	@BeforeTest
	public void setup() {
		sheetname = "SelectHotelData";
		testName = "ChangePasswordTest";
		testDescription = "Testing the Change Password Functionality";
		testCategory = "Smoke Test";
		testAuthor = "Mukilan";
	}

	@Test(dataProvider = "readData")
	public void selectHotelTest(String userName, String password, String checkInDate, String checkoutDate,
			String expected, String testType) {
		LoginPage obj = new LoginPage(driver);
		obj.enterUsername(userName).enterPassword(password).clickLogin().selectLocationName().selectHotelRoom()
				.selectRoomType().selectNoOfRooms().enterCheckInDate(checkInDate).enterCheckOutDate(checkoutDate)
				.selectNoOfAdults().selectNoOfChildren().clickConfirmBtn().selectHotelValidation(expected, testType);
	}

}
