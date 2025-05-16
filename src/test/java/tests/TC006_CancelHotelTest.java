package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.ProjectSpecificationMethods;
import pages.LoginPage;

public class TC006_CancelHotelTest extends ProjectSpecificationMethods {
	@BeforeTest
	public void setup() {
		sheetname = "CancelHotel";
		testName = "Cancel Hotel Test";
		testDescription = "Verify that user is able to cancel selected hotel";
		testCategory = "Smoke Test";
		testAuthor = "Mukilan";
	}
@Test(dataProvider = "readData")
	public void cancelHotelTest(String userName, String passWord, String expected) throws InterruptedException {
		LoginPage obj = new LoginPage(driver);
		obj.enterUsername(userName).enterPassword(passWord).clickLogin().clickBookedItineraryBtn().cancelSelected().cancelSingleItinerary().cancelValidation(expected);;

	}
}
