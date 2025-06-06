package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.ProjectSpecificationMethods;
import pages.LoginPage;

public class TC005_BookAHotelTest extends ProjectSpecificationMethods {

	@BeforeTest
	public void setup() {
		sheetname = "BookHotelData";
		testName = "Book A Hotel Test";
		testDescription = "To Verify that user is able to book a hotel";
		testCategory = "Smoke Test";
		testAuthor = "Mukilan";
	}

	@Test(dataProvider = "readData")
	public void bookAHotelTest(String userName, String passWord, String checkinDate, String checkOutDate,
			String firstName, String lastName, String address, String ccNumber, String cvvNumber, String expected,
			String testType) {
		LoginPage obj = new LoginPage(driver);
			obj.enterUsername(userName).enterPassword(passWord).clickLogin().selectLocationName().selectHotelRoom()
			.selectRoomType().selectNoOfRooms().enterCheckInDate(checkinDate).enterCheckOutDate(checkOutDate)
			.selectNoOfAdults().selectNoOfChildren().clickConfirmBtn().clickSelectBtn().clickcontinueBtn()
			.enterFirstName(firstName).enterLastName(lastName).enterAddress(address).enterCCNum(ccNumber)
			.selectCCType().selectCCExpiryMonth().selectCCExpiryYear().enterCVVNum(cvvNumber).clickBookNowBtn().bookingConfirmationValidation(expected, testType);
	}
}
