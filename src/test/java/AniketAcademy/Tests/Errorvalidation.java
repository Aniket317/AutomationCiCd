package AniketAcademy.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import AniketAcademy.TestComponents.BaseTest;
import AniketAcademy.TestComponents.Retry;

public class Errorvalidation extends BaseTest{

	@Test (groups = {"Error handling"}, retryAnalyzer =Retry.class)
	public void submitOrder() throws IOException, InterruptedException
	{		
		//testing ci cd
		//div[@class='ng-tns-c4-11 ng-star-inserted ng-trigger ng-trigger-flyInOut ngx-toastr toast-error']
		
		landingPage.logindetails("aniketpowar22@gmail.co","Aniket@197731");		
	
	
		Assert.assertEquals(landingPage.geterrorMessage(),"Incorrect email or password");


	}

}
