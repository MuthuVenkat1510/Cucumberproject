package org.steps;

import java.io.IOException;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.pojo.LoginPojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseClass {
	

	@Given("We have to be in FB login page")
	public void we_have_to_be_in_FB_login_page() throws InterruptedException {
	
		loadUrl("https://www.facebook.com/");
		toMaximize();
		toSleep(5000);
	}

	@When("User have to Enter the Invalid EmailID and Invalid Password")
	public void user_have_to_Enter_the_Invalid_EmailID_and_Invalid_Password() throws IOException {
		LoginPojo l = new LoginPojo();
		WebElement txtEmail = l.getTxtEmail();
		txtEmail.sendKeys(excelRead(1, 0));
	WebElement txtpass = l.getTxtpass();
		txtpass.sendKeys(excelRead(1, 1));
	}
	@When("User have to Enter the valid EmailID and Invalid Password")
	public void user_have_to_Enter_the_valid_EmailID_and_Invalid_Password() throws IOException {
		LoginPojo l = new LoginPojo();
		WebElement txtEmail = l.getTxtEmail();
		txtEmail.sendKeys(excelRead(2, 0));
	WebElement txtpass = l.getTxtpass();
		txtpass.sendKeys(excelRead(2, 1));
	}

	@When("User have to Enter the Invalid EmailID and valid Password")
	public void user_have_to_Enter_the_Invalid_EmailID_and_valid_Password() throws IOException {
		LoginPojo l = new LoginPojo();
		WebElement txtEmail = l.getTxtEmail();
		txtEmail.sendKeys(excelRead(3, 0));
	WebElement txtpass = l.getTxtpass();
		txtpass.sendKeys(excelRead(3, 1));
	}

	@When("Click the loginButton")
	public void click_the_loginButton() throws InterruptedException {
		LoginPojo l = new LoginPojo();
		WebElement btnlogin = l.getBtnlogin();
		toClick(btnlogin);
		Thread.sleep(2000);
	}
	

	@Then("User have to be in Invalid credientials page")
	public void user_have_to_be_in_Invalid_credientials_page() {
		String url = toCurrentUrl();
	
		if (url.contains("privacy_mutation_token")) {
			System.out.println("User in Invalid Credientials Page");

		} else {
			System.out.println("User in not Invalid Credientials page");
		}
	
	}
}
