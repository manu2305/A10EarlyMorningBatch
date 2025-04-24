package com.crm.javaUtility;

import java.util.Random;

public class GenerateNumbers {
public static String createUserName(String name,int range) {
	Random r=new Random();
	int num = r.nextInt(range);
	String username = name+num;
	return username;
}
}
