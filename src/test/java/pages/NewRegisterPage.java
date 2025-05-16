package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Base.ProjectSpecificationMethods;

public class NewRegisterPage extends ProjectSpecificationMethods {
	@FindBy(id = "username")
	WebElement userName;
	@FindBy(id = "password")
	WebElement passWord;
	@FindBy(id = "re_password")
	WebElement confrimPassword;
	@FindBy(id = "full_name")
	WebElement fullName;
	@FindBy(id = "email_add")
	WebElement emailAddress;
	@FindBy(id = "tnc_box")
	WebElement tncBox;
	@FindBy(id = "Submit")
	WebElement submitBox;
	@FindBy(id = "captcha-form")
	WebElement captchaText;
	@FindBy(xpath = "//a[contains(text(),'Click here to login')]")
	WebElement verificationText;
	@FindBy(id = "email_add_span")
	public static WebElement errorEmail;

	public NewRegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public NewRegisterPage enterUsername(String username) {
		userName.sendKeys(username);
		return this;
	}

	public NewRegisterPage enterpassword(String password) {
		passWord.sendKeys(password);
		return this;
	}

	public NewRegisterPage enterConfirmPassword(String confirmPassword) {
		confrimPassword.sendKeys(confirmPassword);
		return this;
	}

	public NewRegisterPage enterFullName(String fullname) {
		fullName.sendKeys(fullname);
		return this;
	}

	public NewRegisterPage enterEmail(String email) throws InterruptedException {
		waitForVisibilityOfElement(emailAddress, 10).sendKeys(email);
		waitForSeconds(10);
		Actions action = new Actions(driver);
		action.moveToElement(waitForVisibilityOfElement(captchaText, 10)).perform();
		return this;
	}

	public NewRegisterPage clicktncBox() {
		tncBox.click();
		return this;
	}

	public RegesterationEmailVerificationPage clickSubmit() throws InterruptedException {
		waitForSeconds(2);
		waitForVisibilityOfElement(submitBox, 10).click();
		return new RegesterationEmailVerificationPage(driver);
	}

}
