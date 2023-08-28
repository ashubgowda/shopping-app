package ShoppingApplication.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import ShoppingApplication.abstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{
	
	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
		
	}
	
	

}
