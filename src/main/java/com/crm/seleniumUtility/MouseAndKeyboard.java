package com.crm.seleniumUtility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseAndKeyboard {
public static void arrowDown(WebDriver driver,int count) {
	Actions act=new Actions(driver);
	for (int i = 0; i < count; i++) {
		act.keyDown(Keys.ARROW_DOWN).perform();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	act.keyDown(Keys.ENTER).perform();
}
}
