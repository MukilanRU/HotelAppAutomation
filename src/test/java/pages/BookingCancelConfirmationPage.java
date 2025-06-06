package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import Base.ProjectSpecificationMethods;

public class BookingCancelConfirmationPage extends ProjectSpecificationMethods {

	@FindBy(id = "search_result_error")
	WebElement searchErrorText;

	public BookingCancelConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void cancelValidation(String expected) {
		waitForSeconds(5);
		String actual = searchErrorText.getText();
		Assert.assertEquals(actual, expected);
		Reporter.log("Cancel Confirmation Verified",true);
	}

}
