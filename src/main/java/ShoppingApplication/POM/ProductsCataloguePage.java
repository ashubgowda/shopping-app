package ShoppingApplication.POM;

import java.time.Duration;
import java.util.Collection;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ShoppingApplication.abstractComponents.AbstractComponent;
import net.bytebuddy.implementation.bind.annotation.Super;

public class ProductsCataloguePage extends AbstractComponent {

	private WebDriver driver;

	public ProductsCataloguePage(WebDriver driver) {
		super(driver); //
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;

	@FindBy(css = ".ng-animating")
	WebElement spinner;

	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By productList = By.cssSelector(".mb-3");

	By toastMessage = By.cssSelector("#toast-container");

	public List<WebElement> getProductList() {
		waitForElementToAppear(productList);
		return products;

	}

	public WebElement getProductName(String productName) {
		WebElement prod = getProductList().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		return prod;
	}

	public void addProductToCart(String productName) throws InterruptedException {
		WebElement prod = getProductName(productName);
		System.out.println(prod);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
	}

}
