package org.pojo;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgetPojo extends BaseClass{
	
public ForgetPojo() {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath = "//a[contains(text(),'password')]")
private WebElement frgtpassbtn;
@FindBy(id="identify_email")
private WebElement searchBox;
public WebElement getFrgtpassbtn() {
	return frgtpassbtn;
}
public WebElement getSearchBox() {
	return searchBox;
}
public WebElement getSearchbtn() {
	return searchbtn;
}
@FindBy(xpath = "//button[text()='Search']")
private WebElement searchbtn;

}
