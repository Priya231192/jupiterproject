package com.planittesting.jupiterproject;


//import io.cucumber.java.After;

//import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjectmodel.ContactPage;
import pageobjectmodel.ShopPage;
import utils.Common;

import org.openqa.selenium.WebDriver;



public class StepDefinitions {

	
	static WebDriver driver;
	Common common;
	String browser = "chrome";
	String baseUrl = "http://jupiter.cloud.planittesting.com";
	
	
	@Before
	public void setup() {
		common = new Common();
		common.setupBrowser(browser, baseUrl);
		driver = common.getDriver();
	}
	
//	@After
//	public void tearDown() {
//		common.quitBrowser();
//	}
	
	
	@Given("Navigate to contact page")
	public void contactinfo() {
		ContactPage contactpage = new ContactPage(driver);
		  contactpage.clickcontactlink();
		  
	  }
	
	@When("click on submit button")
	public void clickingonsubmitbtn() {
		ContactPage contactpage = new ContactPage(driver);
		  contactpage.clicksubmitbtn();
		
		  
	  }
	
	@And("I should get error messages {string}")
	public void errormsgvalidation(String Expectederrormessage) {
		ContactPage contactpage = new ContactPage(driver);
		String Actualerrormessage = contactpage.retrieveerrormsg();
    common.compareText(Actualerrormessage,Expectederrormessage);	
		
		  
	  }
	
	@And("Populate values {string} {string} {string} {string} {string}")
	public void populatefieldvalues(String fname,String sname,String email,String phone,String msg) {
		ContactPage contactpage = new ContactPage(driver);
		contactpage.entermadatoryfields(fname,sname,email,phone,msg);
  	
	}
	
	@Then("I should not get error messages {string}")
	public void msgvalidation(String Expectedmessage) {
		ContactPage contactpage = new ContactPage(driver);
		String Actualmessage = contactpage.retrievsuccessrmsg();
    if (!Actualmessage.equals(Expectedmessage)) {
		       System.out.println("Actual Message is  " +Actualmessage+ "-passed" );
			  } 
		
		  
	  }
	
	@Then("I should get successfull messages {string}")
	public void successmsgvalidation(String Expectedmessage) {
		ContactPage contactpage = new ContactPage(driver);
		String Actualmessage = contactpage.retrievsuccessrmsg();
		common.compareText(Actualmessage,Expectedmessage);
			 
		  
	  }
	
	
@When("the user perform contact page submission {int} times {string} {string} {string} {string} {string}")
public void mutiplerun(Integer run,String fname,String sname,String email,String phone,String msg) {
for (int i=0; i<run; i++)
{
ContactPage contactpage = new ContactPage(driver);
contactpage.clickcontactlink();
contactpage.entermadatoryfields(fname,sname,email,phone,msg);
contactpage.clicksubmitbtn();
String Actualmessage = contactpage.retrievsuccessrmsg();
System.out.println(Actualmessage);
common.compareText(Actualmessage,"we appreciate your feedback");
contactpage.clickbackbtn();
}	
}

//@When("Add stuffed frog {int}" )
//public void addingstuffedfrog(Integer buy) {
//ShopPage shoppage = new ShopPage(driver);
//shoppage.shopstuffedfrog(buy);
//	}
//
//@And("Add bunny {int}" )
//public void addingbunny(Integer buy) {
//ShopPage shoppage = new ShopPage(driver);
//shoppage.shopsbunny(buy);
//	}

@When("Add stuffed frog {int}")
public void addstuffedfrog(Integer int1) {
	ShopPage shoppage = new ShopPage(driver);
	shoppage.shopstuffedfrog(int1);
}

@When("Add fluppy bunny {int}")
public void addbunny(Integer int1) {
	ShopPage shoppage = new ShopPage(driver);
	shoppage.shopsbunny(int1);
}

@When("Add valentine bear {int}")
public void addvalentinebear(Integer int1) {
	ShopPage shoppage = new ShopPage(driver);
	shoppage.shopsvalentinebear(int1);
}


@Given("User is on shop page")
public void onshoppage() {
	ShopPage shoppage = new ShopPage(driver);
	shoppage.clickshoplink();
	  
}

@Then("click cart to check value")
public void oncartpage() {
	ShopPage shoppage = new ShopPage(driver);
	shoppage.clickcartlink();
	  
}

@Then("Subtotal validation for products {string} {double} {int}")
public void subtotal_validation_for_stuffed_frog(String product,Double price, Integer qty) {
	ShopPage shoppage = new ShopPage(driver);	 
	double finalpriceeach = shoppage.subtotalcalc(product,price,qty);
	
	System.out.println("Subtotal value for Each Product " + finalpriceeach);
}

@Then("Subtotal validation for fluppy bunny {double} {int}")
public void subtotal_validation_for_fluppy_bunny(Double double1, Integer int1) {
// Write code here that turns the phrase above into concrete actions
throw new io.cucumber.java.PendingException();
}

@Then("Subtotal validation for valentine bear {double} {int}")
public void subtotal_validation_for_valentine_bear(Double double1, Integer int1) {
// Write code here that turns the phrase above into concrete actions
throw new io.cucumber.java.PendingException();
}

@Then("Final amount verification")
public void verifyfinalprice() {
	
	ShopPage shoppage = new ShopPage(driver);
	shoppage.finalamount();
}

}









