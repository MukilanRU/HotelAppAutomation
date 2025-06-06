package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import Base.ProjectSpecificationMethods;

public class RegesterationEmailVerificationPage extends ProjectSpecificationMethods {
	@FindBy(xpath = "//a[contains(text(),'Click here to login')]")
	WebElement clickheretologinbutton;

	public RegesterationEmailVerificationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public RegesterationEmailVerificationPage registerValidation(String expected, String testType) {
		if (testType.equalsIgnoreCase("ValidTest")) {
			String actual = clickheretologinbutton.getText();
			Assert.assertEquals(actual, expected, "Registeration Not Successful");
			Reporter.log("Registeration Successful", true);
			waitForSeconds(1);
			clickheretologinbutton.click();
		} else if (testType.equalsIgnoreCase("InvalidTest")) {
			String actual = NewRegisterPage.errorEmail.getText();
			Assert.assertEquals(actual, expected, "Registerion successful with invalid data");
			Reporter.log("Registeration not successful due to invalid data", true);
		}
		return this;
	}
}
