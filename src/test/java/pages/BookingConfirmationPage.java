package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
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
			Assert.assertTrue(!orderNo.getAttribute("value").isEmpty(), "Order No is " + orderNo.getAttribute("value"));
		} else if (testType.equalsIgnoreCase("invalidtest")) {
			String actual = BookAHotelPage.ccNumErr.getText();
			Assert.assertEquals(actual, expected);
		}
	}

}
