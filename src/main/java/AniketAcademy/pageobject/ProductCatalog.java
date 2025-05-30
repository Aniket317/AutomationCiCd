package AniketAcademy.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import AniketAcademy.Abstractcomponent.AbstractComponent;

public class ProductCatalog  extends AbstractComponent{

	
	WebDriver driver;
	
	public ProductCatalog(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css = ".mb-3")
	List<WebElement>products;
	

	@FindBy(css = ".ng-animating")
	WebElement spinner;

	
	By productsby= By.cssSelector(".mb-3");
	By addToCart= By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	
	public List<WebElement> getproductlist()
	{
		waitforelementToAppear(productsby);
		return products;
	}
	
	
	public WebElement getProductByName(String productName)
	{
		WebElement prod =	getproductlist().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) throws InterruptedException
	{
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		waitforelementToAppear(toastMessage);
		WaitForElementTodisapper(spinner);
	}
		
}

