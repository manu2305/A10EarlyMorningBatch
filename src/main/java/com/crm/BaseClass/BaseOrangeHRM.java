package com.crm.BaseClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.FileUtility.ReadFromProperties;
import com.crm.pom.HomePage;
import com.crm.pom.Login;

public class BaseOrangeHRM {
	public static WebDriver driver=null;
@BeforeClass
public void preCondition() throws IOException, InterruptedException {
	String browser = ReadFromProperties.readProperty("browser");
	String url = ReadFromProperties.readProperty("url");
	if(browser.equalsIgnoreCase("chrome")) {
        driver=new ChromeDriver();
  }
	else if (browser.equalsIgnoreCase("firefox")) {
		  driver=new FirefoxDriver();	
	}
	else if (browser.equalsIgnoreCase("edge")) {
		 driver=new EdgeDriver();
	}
	else if (browser.equalsIgnoreCase("internetExplorer")) {
	     driver=new InternetExplorerDriver();	
	}
	else if (browser.equalsIgnoreCase("safari")) {
		 driver=new SafariDriver();
	}
	else {
	    driver=new ChromeDriver();
	}
	driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get(url);
	Thread.sleep(2000);
}
@BeforeMethod
public void login() throws IOException, InterruptedException {
	String username = ReadFromProperties.readProperty("username");
	String password = ReadFromProperties.readProperty("password");
	Login log=new Login(driver);
	log.username(username);
	log.password(password);
	log.login_button();
	Thread.sleep(3000);
}
@AfterMethod
public void logout() throws InterruptedException {
	HomePage home=new HomePage(driver);
	home.profile_icon();
	home.logout();
	Thread.sleep(2000);
}
@AfterClass
public void postCondition() {
	driver.quit();
}
}
