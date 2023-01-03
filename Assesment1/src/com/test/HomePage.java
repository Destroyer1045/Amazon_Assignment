package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HomePage {
	
//    WebElements
	 static By search_bar = By.id("twotabsearchtextbox");
	 static By submit_button = By.id("nav-search-submit-button");
	
	 // open amazon & srch earphones & click submit button
	    public static void SearchProduct(WebDriver driver) {
	    	try {
	        String URL = "https://www.amazon.in/";
	        driver.get(URL);
	        driver.findElement(search_bar).sendKeys("earphones");
	        driver.findElement(submit_button).click();
	        
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	        
	    }
	    
	   //	    public static void main(String[] args) {
//	    	WebDriver driver = new EdgeDriver();
//	    	SearchProduct(driver);
//	    }
}