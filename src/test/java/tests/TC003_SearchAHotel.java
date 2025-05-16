package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.ProjectSpecificationMethods;
import pages.LoginPage;

public class TC003_SearchAHotel extends ProjectSpecificationMethods {
	@BeforeTest
	public void setup() {
		sheetname = "SearchHotelData";
		testName = "Book Hotel Test";
		testDescription = "Verify that user is able to search a hotel";
		testCategory = "Smoke Test";
		testAuthor = "Mukilan";
	}

	@Test(dataProvider = "readData")
	public void bookHotelTest(String userName, String password, String checkinDate, String checkoutDate, String expected, String testType)
			throws InterruptedException {
		LoginPage obj = new LoginPage(driver);
		obj.enterUsername(userName).enterPassword(password).clickLogin().selectLocationName().selectHotelRoom()
				.selectRoomType().selectNoOfRooms().enterCheckInDate(checkinDate).enterCheckOutDate(checkoutDate)
				.selectNoOfAdults().selectNoOfChildren().clickConfirmBtn().searchHotelValidation(expected, testType);
	}
}
