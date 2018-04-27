package com.unityworks.testcases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gargoylesoftware.htmlunit.javascript.host.Set;

public class HarReaderClass1 {

	/*static String filepath = "F:/SeleniumEasy.har";

	public static void main(String[] args) throws IOException, ParseException {

		
		
	
	
	/*public void parse(String json)  {
	       JsonFactory factory = new JsonFactory();

	       ObjectMapper mapper = new ObjectMapper(factory);
	       JsonNode rootNode = mapper.readTree(json);  

	       Iterator<Map.Entry<String,JsonNode>> fieldsIterator = rootNode.fields();
	       while (fieldsIterator.hasNext()) {

	           Map.Entry<String,JsonNode> field = fieldsIterator.next();
	           System.out.println("Key: " + field.getKey() + "\tValue:" + field.getValue());
	       }
		
		
		
		
		
		
		
		
		/*FileReader reader = new FileReader(filepath);
		/*
		 * ObjectMapper mapper = new ObjectMapper(); 
		 * Object user = mapper.readValue(new File(filepath), Object.class);
		 */

		/*JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
		
		Object[] s = (Object[]) jsonObject.get("request");
		System.out.println(s);*/
	}

