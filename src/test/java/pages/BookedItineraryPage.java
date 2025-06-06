package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import Base.ProjectSpecificationMethods;

public class BookedItineraryPage extends ProjectSpecificationMethods {

	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	WebElement firstCheckBoxBtn;

	@FindBy(xpath = "//input[@value='Cancel Selected']")
	WebElement cancelSelectedBtn;

	@FindBy(xpath = "(//input[@type='button'])[1]")
	WebElement cancelItineraryBtn;

	@FindBy(xpath = "(//input[@class='select_text'])[1]")
	WebElement orderId;

	@FindBy(id = "order_id_text")
	WebElement searchBar;

	@FindBy(id = "search_hotel_id")
	WebElement goBtn;

	@FindBy(id = "search_result_error")
	WebElement searchError;

	public BookedItineraryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public BookedItineraryPage cancelSelected() {
		waitForVisibilityOfElement(firstCheckBoxBtn, 10).click();
		waitForSeconds(1);
		waitForVisibilityOfElement(cancelSelectedBtn, 10).click();
		waitForSeconds(1);
		Alert alert = driver.switchTo().alert();
		waitForSeconds(0.5);
		alert.accept();
		Reporter.log("Cancel hotel by select function verified",true);
		return this;
	}

	public BookingCancelConfirmationPage cancelSingleItinerary() {
		waitForVisibilityOfElement(cancelItineraryBtn, 10).click();
		waitForSeconds(1);
		Alert alert = driver.switchTo().alert();
		waitForSeconds(1);
		alert.accept();
		Reporter.log("Cancel hotel by a single itienerary function verified",true);
		return new BookingCancelConfirmationPage(driver);
	}

	public void searchAnOrder(String expected, String testType) {
		String orderIdValue = waitForVisibilityOfElement(orderId, 10).getAttribute("value");
		if (testType.equalsIgnoreCase("validtest")) {
			waitForVisibilityOfElement(searchBar, 10).sendKeys(orderIdValue);
			waitForVisibilityOfElement(goBtn, 10).click();
			String actual = searchError.getText();
			Assert.assertEquals(actual, expected);
			Reporter.log("Valid search function verified",true);
		} else {
			waitForVisibilityOfElement(goBtn, 10).click();
			String actual = searchError.getText();
			Assert.assertEquals(actual, expected);
			Reporter.log("Invalid search function verified",true);
		}
	}
}
