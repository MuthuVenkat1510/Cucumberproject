package org.steps;

import java.io.IOException;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.pojo.ForgetPojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgetPassword extends BaseClass{

 ForgetPojo f;

@Given("User have to click forgotten password")
public void user_have_to_click_forgotten_password() {
	f = new ForgetPojo();
	WebElement frgtpassbtn = f.getFrgtpassbtn();
	toClick(frgtpassbtn);
   
}

@When("User have to enter invalid mobile number")
public void user_have_to_enter_invalid_mobile_number() throws IOException {
	f = new ForgetPojo();
	WebElement searchBox = f.getSearchBox();
	fillText(searchBox, excelRead(1, 0));
}

@When("user have to click search button")
public void user_have_to_click_search_button() {
	f = new ForgetPojo();
	WebElement searchbtn = f.getSearchbtn();
	toClick(searchbtn);
}

@Then("User have to be in Identiy account")
public void user_have_to_be_in_Identiy_account() {
	String url = toCurrentUrl();
	
	if (url.contains("/login/identify/")) {
		System.out.println("User in Identify Page");

	} else {
		System.out.println("User in not Identiy page");
	}
    
}


}
