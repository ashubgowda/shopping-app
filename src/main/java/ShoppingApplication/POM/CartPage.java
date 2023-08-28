package ShoppingApplication.POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ShoppingApplication.abstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;
	public PaymentPage paymentPage;

	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProducts;

	@FindBy(xpath = "//button[contains(text(),'Checkout')]")
	WebElement checkOut;

	By cartList = By.cssSelector(".cartSection h3");

	public List<WebElement> getCartList() {
		waitForElementToAppear(cartList);
		return cartProducts;
	}

	public Boolean verifyCartProduct(String productName) {
		Boolean match = getCartList().stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return match;

	}

	public PaymentPage goToPayment() {
		checkOut.click();
		paymentPage =  new PaymentPage(driver);
		return paymentPage;
	}

}
