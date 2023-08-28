package ShoppingApplication.POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ShoppingApplication.abstractComponents.AbstractComponent;

public class OrderHistoryPage extends AbstractComponent{
	
	WebDriver driver;

	public OrderHistoryPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> orderedList;
	
	@FindBy(css=".table-responsive")
	WebElement orderedTable;
	
	public boolean verifyOrderedProduct(String productName) {
		
		waitForWebElementToAppear(orderedTable);
		boolean orderedProductMatch = orderedList.stream().anyMatch(item ->
		item.getText().equalsIgnoreCase(productName));
		
		return orderedProductMatch; 
		
	}

}
