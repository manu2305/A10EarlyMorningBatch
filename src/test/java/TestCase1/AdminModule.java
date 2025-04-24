package TestCase1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.BaseClass.BaseOrangeHRM;
import com.crm.FileUtility.ReadFromExcel;
import com.crm.javaUtility.GenerateNumbers;
import com.crm.pom.AdminPom;
import com.crm.pom.HomePage;
import com.crm.seleniumUtility.MouseAndKeyboard;

public class AdminModule extends BaseOrangeHRM {
@Test
public void tc_001() throws InterruptedException, EncryptedDocumentException, IOException {
	String homePage_url="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	Thread.sleep(1000);
	String actual_homeUrl = driver.getCurrentUrl();
	assertEquals(actual_homeUrl, homePage_url,"iam not in homepage");
	Reporter.log("iam in home page",true);
	HomePage home=new HomePage(driver);
	home.admin();
	AdminPom admin=new AdminPom(driver);
	admin.add();
	admin.user_role();
	MouseAndKeyboard.arrowDown(driver, 1);
	admin.status();
	MouseAndKeyboard.arrowDown(driver, 1);
	String password = ReadFromExcel.readExcel("Admin", 1, 1);
	admin.password(password);
	String emp_name = ReadFromExcel.readExcel("Admin", 1, 2);
	admin.employee_name(emp_name);
	Thread.sleep(3000);
	MouseAndKeyboard.arrowDown(driver, 1);
	String name = ReadFromExcel.readExcel("Admin", 1, 3);
	String username = GenerateNumbers.createUserName(name, 10000);
	admin.user_name(username);
	admin.confirm_password(password);
	Thread.sleep(2000);
	admin.submit();
	WebElement new_user = driver.findElement(By.xpath("//div[text()='"+username+"']"));
	assertTrue(new_user.isDisplayed(),"user is not added");
	Reporter.log("user is added successfully",true);
	Thread.sleep(10000);
}
}
