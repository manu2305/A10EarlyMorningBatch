package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
public HomePage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
@FindBy(xpath = "//input[@class='oxd-input oxd-input--active']")
private WebElement search_field;

@FindBy(xpath = "//li[@class='oxd-userdropdown']")
private WebElement profile_icon;
@FindBy(xpath = "(//a[@role='menuitem'])[4]")
private WebElement logOut;

@FindBy(xpath = "//ul[@class='oxd-main-menu']/li[1]/a/span")
private WebElement admin;

public void search(String data) {
	search_field.sendKeys(data);
}
public void profile_icon() {
	profile_icon.click();
}
public void logout() {
	logOut.click();
}

public void admin() {
	admin.click();
}
}
