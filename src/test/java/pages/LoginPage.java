package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Base.ProjectSpecificationMethods;

public class LoginPage extends ProjectSpecificationMethods {
	@FindBy(xpath = "//a[contains(text(),'New User Register Here')]")
	WebElement newregButton;

	@FindBy(id = "username")
	WebElement userName;

	@FindBy(id = "password")
	WebElement passWord;

	@FindBy(id = "login")
	WebElement loginBtn;

	@FindBy(xpath = "//div[@class='auth_error']")
	public static WebElement loginValidation;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public NewRegisterPage clickNewRegButton() {
		newregButton.click();
		return new NewRegisterPage(driver);

	}

	public LoginPage enterUsername(String uName) {
		userName.sendKeys(uName);
		return this;
	}

	public LoginPage enterPassword(String pWord) {
		passWord.sendKeys(pWord);
		return this;
	}

	public SearchHotelPage clickLogin() {
		waitForSeconds(2);
		loginBtn.click();
		waitForSeconds(2);
		return new SearchHotelPage(driver);
	}
}
