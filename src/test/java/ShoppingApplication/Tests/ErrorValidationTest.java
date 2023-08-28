package ShoppingApplication.Tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ShoppingApplication.POM.ProductsCataloguePage;
import ShoppingApplication.TestComponents.BaseTest;
import ShoppingApplication.TestComponents.Retry;

public class ErrorValidationTest extends BaseTest {

	@Test(groups = "ErrorHandling", retryAnalyzer = Retry.class)
	public void loginErrorValidation() throws IOException {

		// launchApplication() handled in BaseTest class ;
		ProductsCataloguePage productCatalogue = loginPage.loginApplication("ashubgowda06@gmail.com", "Root@123");
		Assert.assertEquals(loginPage.getErrorMessage(), "Incorrect email  password.");

	}

}
