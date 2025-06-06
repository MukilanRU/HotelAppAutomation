package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import Base.ProjectSpecificationMethods;

public class SelectHotelPage extends ProjectSpecificationMethods {

	@FindBy(id = "radiobutton_0")
	WebElement selectBtn;

	@FindBy(id = "continue")
	WebElement continueBtn;

	@FindBy(xpath = "//td[contains(text(),'Select Hotel ')]")
	WebElement pageTitle;

	@FindBy(id = "radiobutton_span")
	WebElement selectHotelError;

	public SelectHotelPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public SelectHotelPage clickSelectBtn() {
		selectBtn.click();
		return this;
	}

	public BookAHotelPage clickcontinueBtn() {
		continueBtn.click();
		return new BookAHotelPage(driver);
	}

	public SelectHotelPage searchHotelValidation(String expected, String testType) {
		if (testType.equalsIgnoreCase("validtest")) {
			String actual = pageTitle.getText();
			Assert.assertEquals(actual, expected, "browser not redirect to next page");
			Reporter.log("Search Hotel Function Completed With Valid Details", true);
		} else {
			String actual = SearchHotelPage.checkInError.getText();
			Assert.assertEquals(actual, expected);
			Reporter.log("Search Hotel Function Completed Due To Error", true);
		}
		return this;
	}

	public SelectHotelPage selectHotelValidation(String expected, String testType) {
		if (testType.equalsIgnoreCase("validtest")) {
			selectBtn.click();
			waitForVisibilityOfElement(continueBtn, 10).click();
			String actual = driver.getTitle();
			Assert.assertEquals(actual, expected, "browser not redirect to next page");
			Reporter.log("Select Hotel Function Completed With Valid Details", true);
		} else {
			waitForVisibilityOfElement(continueBtn, 10).click();
			String actual = selectHotelError.getText();
			Assert.assertEquals(actual, expected);
			Reporter.log("Select Hotel Function Not Completed Due To Error", true);
		}
		return this;

	}
}
