package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.ProjectSpecificationMethods;

public class LogoutPage extends ProjectSpecificationMethods {

	@FindBy(xpath = "//td[contains(text(),'You have successfully logged out. ')]")
	WebElement logoutText;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void logoutValidation(String expected) {
		String actual = logoutText.getText();
		Assert.assertEquals(actual, expected);
	}

}
