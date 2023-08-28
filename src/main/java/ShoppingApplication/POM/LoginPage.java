package ShoppingApplication.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ShoppingApplication.abstractComponents.AbstractComponent;
import net.bytebuddy.implementation.bind.annotation.Super;

public class LoginPage extends AbstractComponent {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		// initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locators
	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement userPassword;

	@FindBy(id = "login")
	WebElement login;

	// ng-tns-c4-9 ng-star-inserted ng-trigger ng-trigger-flyInOut ngx-toastr
	// toast-error

	@FindBy(css = "[class*='flyInOut']")
	WebElement loginErrorMessage;

	// action methods

	public String getErrorMessage() {
		waitForWebElementToAppear(loginErrorMessage);
		return loginErrorMessage.getText();
	}

	public ProductsCataloguePage loginApplication(String email, String pwd) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(pwd);
		login.click();
		ProductsCataloguePage productCatalogue = new ProductsCataloguePage(driver);
		return productCatalogue;
	}

	public void goTo(String url) {
		driver.get(url);

	}
}
