package Basic;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Random;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Admin {
	public static WebDriver driver=null;
@Test
public void TC_001() throws InterruptedException {
	String expected_url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	String homePage_url="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	String browser="chrome";
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
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	String actual_url = driver.getCurrentUrl();
	assertEquals(actual_url,expected_url,"iam not in orangeHRm");
	Reporter.log("iam in OrangeHrm");
	driver.findElement(By.name("username")).sendKeys("Admin");
	driver.findElement(By.name("password")).sendKeys("admin123");
	driver.findElement(By.xpath("//button[text()=' Login ']")).click();
	Thread.sleep(2000);
	String actual_homeUrl = driver.getCurrentUrl();
	assertEquals(actual_homeUrl, homePage_url,"iam not in homepage");
	Reporter.log("iam in home");
	//click admin 
	driver.findElement(By.xpath("//ul[@class='oxd-main-menu']/li[1]/a/span")).click();
	//click Add button
	driver.findElement(By.xpath("//div[@class='orangehrm-header-container']/button")).click();
	//fill add user form 
	driver.findElement(By.xpath("//div[@class='oxd-select-wrapper']")).click();
	Actions act=new Actions(driver);
	act.keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
	driver.findElement(By.xpath("(//div[@class='oxd-select-wrapper'])[2]")).click();
	act.keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
	driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("Mani007");
	driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("peter");
	Thread.sleep(3000);
	act.keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
	Random r=new Random();
	 int num = r.nextInt(1000);
		String name="Pratik"+num;
	driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(name);
	driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("Mani007");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	System.out.println(name);
	WebElement new_user = driver.findElement(By.xpath("//div[text()='"+name+"']"));
	assertTrue(new_user.isDisplayed(),"user is not added");
	Reporter.log("user is added successfully");
	driver.close();
}
}


















