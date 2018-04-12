package com.unityworks.testcases;

import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

public class MainClass {

	
	 public static void main(String[] args) {
		 
		 TestListenerAdapter tla = new TestListenerAdapter();
		 TestNG tng = new TestNG();
		 List<String> suites = Lists.newArrayList();
		 suites.add(System.getProperty("user.dir")+"\\src\\main\\resources\\testng.xml");//path to xml..
		 tng.setTestSuites(suites);
		 tng.addListener(tla);
		 tng.run();
		 
		 
	}
}
