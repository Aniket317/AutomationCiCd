package AniketAcademy.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AniketAcademy.Abstractcomponent.AbstractComponent;

public class confirmationPAge extends AbstractComponent{
	

	WebDriver driver;
	public confirmationPAge(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	


	@FindBy (css = ".hero-primary")
	WebElement confirmationMessage;
	
	public String getconfirmationMessage()
	{
		return confirmationMessage.getText();
	}
}
