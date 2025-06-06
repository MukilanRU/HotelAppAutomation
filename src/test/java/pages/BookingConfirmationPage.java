package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import Base.ProjectSpecificationMethods;

public class BookingConfirmationPage extends ProjectSpecificationMethods {

	@FindBy(id = "order_no")
	WebElement orderNo;

	public BookingConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void bookingConfirmationValidation(String expected, String testType) {
		if (testType.equalsIgnoreCase("validtest")) {
			Assert.assertTrue(!orderNo.getAttribute("value").isEmpty(), "Hotel booked");
			Reporter.log("Hotel Booked Successfully ", true);
		} else if (testType.equalsIgnoreCase("invalidtest")) {
			String actual = BookAHotelPage.ccNumErr.getText();
			Assert.assertEquals(actual, expected, "Hotel booked");
			Reporter.log("Hotel Booking Was Successfull Due To Error ", true);
		}
	}

}
