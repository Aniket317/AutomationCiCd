package AniketAcademy.Tests;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import AniketAcademy.TestComponents.BaseTest;
import AniketAcademy.pageobject.ProductCatalog;
import AniketAcademy.pageobject.cartPage;
import AniketAcademy.pageobject.checkoutPage;
import AniketAcademy.pageobject.confirmationPAge;
import AniketAcademy.pageobject.orderPage;

public class Standalonetest extends BaseTest{
	String productName = "ADIDAS ORIGINAL";
	@Test (dataProvider = "getData" , groups= {"Purchase"})
	public void submitOrder(HashMap<String, String>input) throws IOException, InterruptedException
	{		
		
		
		
		ProductCatalog ProductCatalog = landingPage.logindetails(input.get("email"), input.get("password"));		
		
		List<WebElement> products = ProductCatalog.getproductlist();
		ProductCatalog.addProductToCart(input.get("productName"));
		cartPage cartPage =ProductCatalog.goToCartPage();
			

		Boolean match = cartPage.VerifyProductDisplay(input.get("productName"));
		Assert.assertTrue(match);
		 
		checkoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("India");
		confirmationPAge confirmationPAge=checkoutPage.submitOrder();

		 	 
		 String ConfirmMessage =confirmationPAge.getconfirmationMessage();
		 Assert.assertTrue(ConfirmMessage.equalsIgnoreCase("Thankyou for the order."));
		 
		 System.out.println(ConfirmMessage);
		
	}
	
	@Test(dependsOnMethods = {"submitOrder"})
	public void orderHistoryTest()
	{
		ProductCatalog ProductCatalog = landingPage.logindetails("aniketpowar22@gmail.com","Aniket@197731");	
		orderPage ordersPage=ProductCatalog.goToorderPage();
		Assert.assertTrue(ordersPage.VerifyProductDisplay(productName));
		
	}
	
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		 List<HashMap<String, String>>data =getJsonDataToMap("C:\\Users\\anike\\eclipse-workspace\\SeleniumFramework\\src\\test\\java\\AniketAcademy\\data\\PurchaseOrder.json");
			
			return new Object[][] {{data.get(0)},{data.get(1)}};
	}



	//@DataProvider 
	//public Object[][] getData1()
	//{
	//	return new Object[] [] {{"aniketpowar22@gmail.com","Aniket@197731","ADIDAS ORIGINAL"},{"saniket@gmail.com","Aniket@197731","ZARA COAT 3" }};
	//}
	
	
	
	 /*
	 * HashMap<String, String> map= new HashMap<String, String>();
	 * map.put("email","aniketpowar22@gmail.com"); map.put("password",
	 * "Aniket@197731"); map.put("productName", "ADIDAS ORIGINAL");
	 * 
	 * HashMap<String, String> map1= new HashMap<String, String>();
	 * map1.put("email","saniket@gmail.com"); map1.put("password", "Aniket@197731");
	 * map1.put("productName", "ZARA COAT 3");
	 */
}
