package AniketAcademy.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AniketAcademy.Abstractcomponent.AbstractComponent;

public class LandingPage extends AbstractComponent{

	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{	
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement useremail;
	
	@FindBy(id="userPassword")
	WebElement passwordele;
	
	@FindBy(id="login")
	WebElement login;
	
	@FindBy(css = "[class*='flyInOut']")
	WebElement errorMessage;
	
	public ProductCatalog logindetails (String email, String password)
	{
		useremail.sendKeys(email);
		passwordele.sendKeys(password);
		login.click();
		ProductCatalog ProductCatalog = new ProductCatalog(driver);
		return ProductCatalog;
	}
	
	
	public String geterrorMessage()
	{
		waitforwebelementToAppear(errorMessage);
		return errorMessage.getText();
	}
	public void url()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
}
