package com.crm.FileUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadFromProperties {
public static String readProperty(String key) {
	Properties prop=new Properties();
	FileInputStream fis=null;
	try {
		fis = new FileInputStream(".\\src\\test\\resources\\OrangeHRM.properties");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		prop.load(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String data = prop.getProperty(key);
	return data;
}
}
