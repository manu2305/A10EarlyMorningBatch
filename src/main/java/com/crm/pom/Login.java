package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	public Login(WebDriver driver){
	PageFactory.initElements(driver,this);	
	}
	
	
	@FindBy(name = "username")
   private WebElement username;
	
	@FindBy(css = "input[type='password']")
	private WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement login_button;
	
	public void username(String data) {
		username.sendKeys(data);
	}
	public void password(String data) {
		password.sendKeys(data);
	}
	public void login_button() {
		login_button.click();
	}
}
