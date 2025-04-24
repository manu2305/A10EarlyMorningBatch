package Basic;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.BaseClass.BaseOrangeHRM;
import com.crm.pom.HomePage;

public class Test1 extends BaseOrangeHRM{
@Test
public void main1() {
	Reporter.log("Page object model...");
	HomePage home=new HomePage(driver);
	home.search("manikandan");
}
}
