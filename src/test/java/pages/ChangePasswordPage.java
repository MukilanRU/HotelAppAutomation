package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import Base.ProjectSpecificationMethods;

public class ChangePasswordPage extends ProjectSpecificationMethods {

	@FindBy(id = "current_pass")
	WebElement currentPassword;

	@FindBy(id = "new_password")
	WebElement newPassword;

	@FindBy(id = "re_password")
	WebElement confirmPassword;

	@FindBy(id = "Submit")
	WebElement submitBtn;

	@FindBy(xpath = "//span[contains(text(),'Your Password is successfully updated!!!')]")
	WebElement sucessMsg;

	@FindBy(xpath = "//span[contains(text(),'Please enter correct current password!!!')]")
	WebElement failureMsg;

	public ChangePasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ChangePasswordPage enterCurrentPassword(String currentPasswordValue) {
		waitForVisibilityOfElement(currentPassword, 10).sendKeys(currentPasswordValue);
		return this;
	}

	public ChangePasswordPage enterNewPassword(String newPasswordValue) {
		waitForVisibilityOfElement(newPassword, 10).sendKeys(newPasswordValue);
		return this;
	}

	public ChangePasswordPage enterConfirmPassword(String confirmPasswordValue) {
		waitForVisibilityOfElement(confirmPassword, 10).sendKeys(confirmPasswordValue);
		return this;
	}

	public ChangePasswordPage clickSubmitBtn() {
		waitForSeconds(1);
		waitForVisibilityOfElement(submitBtn, 10).click();
		waitForSeconds(1);
		return this;
	}

	public void changePasswordValidation(String expected, String testType) {
		if (testType.equalsIgnoreCase("validtest")) {
			String actual = sucessMsg.getText();
			Assert.assertEquals(actual, expected,"Change Password UnSuccessful");
			Reporter.log("Change Password Successful",true);
		} else if (testType.equalsIgnoreCase("invalidtest")) {
			String actual = failureMsg.getText();
			Assert.assertEquals(actual, expected,"Change Password Successful");
			Reporter.log("Change Password Not Successful Due To Errors",true);
		}
	}

}
