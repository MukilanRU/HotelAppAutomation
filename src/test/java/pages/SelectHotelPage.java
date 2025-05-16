package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
			Assert.assertEquals(actual, expected);
		} else {
			String actual = SearchHotelPage.checkInError.getText();
			Assert.assertEquals(actual, expected);
		}
		return this;
	}

	public SelectHotelPage selectHotelValidation(String expected, String testType) {
		if (testType.equalsIgnoreCase("validtest")) {
			selectBtn.click();
			waitForVisibilityOfElement(continueBtn, 10).click();
			String actual = driver.getTitle();
			Assert.assertEquals(actual, expected);
		} else {
			waitForVisibilityOfElement(continueBtn, 10).click();
			String actual = selectHotelError.getText();
			Assert.assertEquals(actual, expected);
		}
		return this;

	}
}
