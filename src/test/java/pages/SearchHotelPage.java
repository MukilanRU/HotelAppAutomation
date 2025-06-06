package pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import Base.ProjectSpecificationMethods;

public class SearchHotelPage extends ProjectSpecificationMethods {

	@FindBy(xpath = "//option[@value='Sydney']")
	WebElement locationName;

	@FindBy(xpath = "//option[@value='Hotel Creek']")
	WebElement hotelName;

	@FindBy(xpath = "//option[@value='Standard']")
	WebElement roomType;

	@FindBy(xpath = "//select[@id='room_nos']//option[@value='1']")
	WebElement noOfRooms;

	@FindBy(xpath = "//input[@id ='datepick_in']")
	WebElement checkinDate;

	@FindBy(xpath = "//input[@id ='datepick_out']")
	WebElement checkoutDate;

	@FindBy(xpath = "//select[@id='adult_room']//option[@value='1']")
	WebElement adultsPerRoom;

	@FindBy(xpath = "//select[@id='child_room']//option[@value='1']")
	WebElement childrenPerRoom;

	@FindBy(id = "Submit")
	WebElement confirmBtn;

	@FindBy(xpath = "//a[contains(text(),'Booked Itinerary')]")
	WebElement bookedItineraryBtn;

	@FindBy(xpath = "//a[contains(text(),'Change Password')]")
	WebElement changePasswordbtn;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement logoutBtn;

	@FindBy(id = "checkin_span")
	public static WebElement checkInError;

	@FindBy(id = "username_show")
	WebElement userNameShow;

	public SearchHotelPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public SearchHotelPage selectLocationName() {
		locationName.click();
		return this;
	}

	public SearchHotelPage selectHotelRoom() {
		hotelName.click();
		return this;
	}

	public SearchHotelPage selectRoomType() {
		roomType.click();
		return this;
	}

	public SearchHotelPage selectNoOfRooms() {
		noOfRooms.click();
		return this;
	}

	public SearchHotelPage enterCheckInDate(String checkinDateValue) {
		checkinDate.clear();
		checkinDate.sendKeys(checkinDateValue);
		return this;
	}

	public SearchHotelPage enterCheckOutDate(String checkoutDateValue) {
		checkoutDate.clear();
		checkoutDate.sendKeys(checkoutDateValue);
		return this;
	}

	public SearchHotelPage selectNoOfAdults() {
		adultsPerRoom.click();
		return this;
	}

	public SearchHotelPage selectNoOfChildren() {
		childrenPerRoom.click();
		return this;
	}

	public SelectHotelPage clickConfirmBtn() {
		waitForSeconds(2);
		confirmBtn.click();
		return new SelectHotelPage(driver);
	}

	public BookedItineraryPage clickBookedItineraryBtn() {
		waitForSeconds(2);
		bookedItineraryBtn.click();
		return new BookedItineraryPage(driver);
	}

	public ChangePasswordPage clickChangePasswordBtn() {
		waitForVisibilityOfElement(changePasswordbtn, 10).click();
		return new ChangePasswordPage(driver);
	}

	public LogoutPage clickLogoutBtn() {
		waitForSeconds(2);
		waitForVisibilityOfElement(logoutBtn, 10).click();
		return new LogoutPage(driver);
	}

	public SearchHotelPage loginValidation(String expected, String testType) {
		if (testType.equalsIgnoreCase("validtest")) {
			String actual = waitForVisibilityOfElement(userNameShow, 10).getAttribute("value");
			Assert.assertEquals(actual, expected, "Login not successful");
			Reporter.log("Login Successful",true);
		} else if (testType.equalsIgnoreCase("invalidtest")) {
			String actual = LoginPage.loginValidation.getText();
			Assert.assertEquals(actual, expected, "Login successful with invalid data");
			Reporter.log("Login not successful with invalid data",true);
		}
		return this;
	}
}
