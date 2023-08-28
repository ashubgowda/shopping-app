package ShoppingApplication.abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ShoppingApplication.POM.CartPage;
import ShoppingApplication.POM.OrderHistoryPage;

public class AbstractComponent {

	WebDriver driver;
	public CartPage cartpage;
	public OrderHistoryPage orderHistoryPage;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[routerlink*='cart']")
	WebElement cartButton;

	@FindBy(css = "button[routerlink*='myorders']")
	WebElement ordersButton;

	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}

	public void waitForWebElementToAppear(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));

	}

	public void waitForElementToDisappear(WebElement ele) throws InterruptedException {
		Thread.sleep(1000);

	}

	public CartPage goToCart() {
		cartButton.click();
		cartpage = new CartPage(driver);
		return cartpage;

	}

	public OrderHistoryPage goToOrderedHistoryPage() {

		ordersButton.click();
		orderHistoryPage = new OrderHistoryPage(driver);
		return orderHistoryPage;
	}
}
