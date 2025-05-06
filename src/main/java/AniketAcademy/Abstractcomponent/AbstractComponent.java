package AniketAcademy.Abstractcomponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AniketAcademy.pageobject.cartPage;
import AniketAcademy.pageobject.orderPage;

public class AbstractComponent {

	
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderheader;

	public void waitforelementToAppear(By findby)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	
	public void waitforwebelementToAppear(WebElement findby)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(findby));
	}
	
	
	public cartPage goToCartPage()
	{
		cartHeader.click();
		cartPage cartPage = new cartPage(driver);
		return cartPage;
	}
	
	public orderPage goToorderPage()
	{
		orderheader.click();
		orderPage orderPage=new orderPage(driver);
		return orderPage;
	}
	
	public void WaitForElementTodisapper(WebElement ele) throws InterruptedException
	{
		Thread.sleep(1000);
	//	WebDriverWait wait = new  WebDriverWait(driver, Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.invisibilityOf(ele));
	}
}
