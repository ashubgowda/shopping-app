package ShoppingApplication.Tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ShoppingApplication.POM.CartPage;
import ShoppingApplication.POM.ConfirmationPage;
import ShoppingApplication.POM.OrderHistoryPage;
import ShoppingApplication.POM.PaymentPage;
import ShoppingApplication.POM.ProductsCataloguePage;
import ShoppingApplication.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {

	@Test(dataProvider = "getData")
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {

		// launchApplication() handled in BaseTest class ;
		ProductsCataloguePage productCatalogue = loginPage.loginApplication(input.get("email"), input.get("password"));
		productCatalogue.addProductToCart(input.get("product"));
		CartPage cartPage = productCatalogue.goToCart();
		Boolean cartProduct = cartPage.verifyCartProduct(input.get("product"));
		Assert.assertTrue(cartProduct);

		PaymentPage paymentPage = cartPage.goToPayment();
		paymentPage.selectCountry("india");
		ConfirmationPage confirmationPage = paymentPage.submitOrder();

	}

	@Test(dataProvider = "getData", dependsOnMethods = { "submitOrder" })
	public void orderHistory(HashMap<String, String> input) {
		ProductsCataloguePage productCatalogue = loginPage.loginApplication(input.get("email"), input.get("password"));
		OrderHistoryPage orderHistoryPage = productCatalogue.goToOrderedHistoryPage();
		Assert.assertTrue(orderHistoryPage.verifyOrderedProduct(input.get("product")));
	}

	@DataProvider
	public Object[] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//ShoppingApplication//data//PurchaseOrder.json");

		// new Object[][] { { data.get(0) }, { data.get(1) }, {data.get(2)} };

		Object[] objArr = data.toArray();
		return objArr;
	}
}
