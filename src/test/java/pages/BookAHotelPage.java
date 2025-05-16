package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Base.ProjectSpecificationMethods;

public class BookAHotelPage extends ProjectSpecificationMethods {

	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(id = "last_name")
	WebElement lastName;

	@FindBy(id = "address")
	WebElement billingAddress;

	@FindBy(id = "cc_num")
	WebElement ccNum;

	@FindBy(xpath = "//select[@id='cc_type']//option[@value='AMEX']")
	WebElement ccType;

	@FindBy(xpath = "//select[@id='cc_exp_month']//option[@value='1']")
	WebElement ccExMonth;

	@FindBy(xpath = "//select[@id='cc_exp_year']//option[@value='2028']")
	WebElement ccExYear;

	@FindBy(id = "cc_cvv")
	WebElement cvvNum;

	@FindBy(id = "book_now")
	WebElement bookNowBtn;

	@FindBy(id = "cc_num_span")
	public static WebElement ccNumErr;

	public BookAHotelPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public BookAHotelPage enterFirstName(String firstNameValue) {
		firstName.sendKeys(firstNameValue);
		return this;
	}

	public BookAHotelPage enterLastName(String secondNameValue) {
		lastName.sendKeys(secondNameValue);
		return this;
	}

	public BookAHotelPage enterAddress(String emailId) {
		billingAddress.sendKeys(emailId);
		return this;
	}

	public BookAHotelPage enterCCNum(String ccNumValue) {
		ccNum.sendKeys(ccNumValue);
		return this;
	}

	public BookAHotelPage selectCCType() {
		ccType.click();
		return this;
	}

	public BookAHotelPage selectCCExpiryMonth() {
		ccExMonth.click();
		return this;
	}

	public BookAHotelPage selectCCExpiryYear() {
		ccExYear.click();
		return this;
	}

	public BookAHotelPage enterCVVNum(String cvvNumValue) {
		cvvNum.sendKeys(cvvNumValue);
		return this;
	}

	public BookingConfirmationPage clickBookNowBtn() {
		waitForSeconds(2);
		bookNowBtn.click();
		return new BookingConfirmationPage(driver);
	}

}
