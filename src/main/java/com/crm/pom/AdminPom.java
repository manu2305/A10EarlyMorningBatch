package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPom {
	public AdminPom(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//div[@class='orangehrm-header-container']/button")
	private WebElement add;
	
	@FindBy(xpath = "//div[@class='oxd-select-wrapper']")
	private WebElement user_role;
	
	@FindBy(xpath = "(//div[@class='oxd-select-wrapper'])[2]")
	private WebElement status;
	
	@FindBy(xpath = "(//input[@type='password'])[1]")
	private WebElement password;
	
	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	private WebElement employee_name;
	
	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement user_name;
	
	@FindBy(xpath = "(//input[@type='password'])[2]")
	private WebElement confirm_password;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submit;
	
	public void add() {
		add.click();
	}
	
	public void user_role() {
		user_role.click();
	}
	public void status() {
		status.click();
	}
	public void password(String data) {
		password.sendKeys(data);
	}
	public void employee_name(String data) {
		employee_name.sendKeys(data);
	}
	public void user_name(String data) {
		user_name.sendKeys(data);
	}
	public void confirm_password(String data) {
		confirm_password.sendKeys(data);
	}
	public void submit() {
		submit.click();
	}
}




























