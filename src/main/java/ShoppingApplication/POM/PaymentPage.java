package ShoppingApplication.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ShoppingApplication.abstractComponents.AbstractComponent;

public class PaymentPage extends AbstractComponent {

	WebDriver driver;
	public ConfirmationPage confirmationPage;

	public PaymentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "input[placeholder='Select Country']")
	WebElement country;

	@FindBy(xpath = "(//button[contains(@class, 'ta-item')])[2]")
	WebElement selectCountry;

	@FindBy(css = ".action__submit")
	WebElement placeOrder;

	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(By.cssSelector(".ta-results"));
		selectCountry.click();
	}

	public ConfirmationPage submitOrder() {
		waitForWebElementToAppear(placeOrder);
		placeOrder.click();
		confirmationPage = new ConfirmationPage(driver);
		return confirmationPage;
	}

}
