package AniketAcademy.Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Standaloneordertest {

	public static void main(String[] args) throws InterruptedException {
		
		
		String productName = "ADIDAS ORIGINAL";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		
		driver.findElement(By.id("userEmail")).sendKeys("aniketpowar22@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Aniket@197731");
		driver.findElement(By.id("login")).click();
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		 List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		 
		 WebElement prod = products.stream().filter(product->
		 product.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
		 
		 prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#toast-container")));
		 wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		 
		 driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		 
		 
		 List<WebElement> cartproducts = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		 
		 boolean match = cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productName));
		 Assert.assertTrue(match);
		 
		 driver.findElement(By.cssSelector(".totalRow button")).click();
		 
		 Actions a= new Actions(driver);
		 a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")),"India").build().perform();
		 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		 
		 driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		 


// Wait for the loader to disappear if it's present
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));

// Then wait for the button to be visible
		 WebElement placeOrderBtn = wait.until(
				 ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnn.action__submit.ng-star-inserted"))
				 );

// Scroll the button into view in case it's off-screen
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", placeOrderBtn);

// Try clicking it now
		 placeOrderBtn.click();
		 
		 
		 String ConfirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		 Assert.assertTrue(ConfirmMessage.equalsIgnoreCase("Thankyou for the order."));
		 
		 System.out.println(ConfirmMessage);
		 driver.close();

	}

}
