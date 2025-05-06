package AniketAcademy.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import AniketAcademy.Abstractcomponent.AbstractComponent;

public class orderPage extends AbstractComponent {
	WebDriver driver;

	@FindBy(css = ".totalRow button")
	WebElement checkoutEle;

	@FindBy(css = "tr td:nth-child(3)")
	private List<WebElement> productNames;

	public orderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public Boolean VerifyProductDisplay(String productName) {
		Boolean match = productNames.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return match;

	}	 		

	public checkoutPage goToCheckout()
	{
		checkoutEle.click();
		checkoutPage checkoutPage= new checkoutPage(driver);
		return checkoutPage;
	}
		

	
	
	

}
