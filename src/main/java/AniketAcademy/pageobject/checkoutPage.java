package AniketAcademy.pageobject;

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

import AniketAcademy.Abstractcomponent.AbstractComponent;

public class checkoutPage  extends AbstractComponent{
	
	WebDriver driver;
	public checkoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css= ".action__submit")
	WebElement submit;
	
	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement country;
	
	
	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;
	
	By results =By.cssSelector(".ta-results");
	
	public void selectCountry(String countryName)
	{
		 Actions a= new Actions(driver);
		a.sendKeys(country,countryName).build().perform();
		waitforelementToAppear(results);
		selectCountry.click();
		
	}
	public void waitForOverlayToDisappear(By overlay) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(overlay));
	}
	
	public confirmationPAge submitOrder() throws InterruptedException {
	    waitForOverlayToDisappear(By.cssSelector(".spinner")); // spinner overlay, optional
	    waitForOverlayToDisappear(By.cssSelector("div[role='alert']")); // wait for toast to disappear

	    waitforwebelementToAppear(submit);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submit);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);

	    return new confirmationPAge(driver);
	}
	
	
}
