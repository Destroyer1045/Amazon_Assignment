package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class ProductListPage {
    
	public static ArrayList<String> brand_Names;
	public static ArrayList<String> Price;
	
	// Print First 4 Product with their name and Price and store into list
    public void PrintFirst4Products(WebDriver driver) {
    	try {
        List<WebElement> lstProdNames = driver.findElements(By.xpath("//*[@class = \"a-size-medium a-color-base a-text-normal\"]"));
        List<WebElement> lstPrice =  driver.findElements(By.xpath("//*[@class = \"a-price-whole\"]"));
    
        brand_Names = new ArrayList<>();
        Price = new ArrayList<>();
        
        for(WebElement rb : lstProdNames) {
        	String str = rb.getText();
        	brand_Names.add(str.substring(0 , 30));
        }
        for(int cnt = 0 ; cnt < 4 ; cnt++) {
      	    System.out.println(brand_Names.get(cnt));
        }
        
        System.out.println();
        for(WebElement rb : lstPrice) {
        	String str = rb.getText();
        	str = str.replace("," , "");
        	Price.add(str);
        }
        for(int cnt = 0 ; cnt < 4; cnt++) {
        	System.out.println(Price.get(cnt));
        }
        
        System.out.println(brand_Names.size());
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
       
    
    }
    
    // check list of product is valid or not >- query 4 product with their name & price from database and compare from the list
    public static void ValidateListofProducts(WebDriver driver) {
        
        //lst of ProductNames and Prices
        
    	System.out.println("__");
		ArrayList<String> Product_Brand = new ArrayList<>();
		ArrayList<String> Product_Price = new ArrayList<>();
    	
		//Connect to Database, query, rs
    	try {

      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Amazon","root","Vivek1045@");
      Statement stmt = conn.createStatement();

    		ResultSet res = stmt.executeQuery("select * from Product");
    		System.out.println(res.next());
    		
    		
    	     while(res.next()){
//    	        exp from DB
//    	        act from list (app)
    	    	// print product name & price from database table 
    	    	System.out.println(res.getString(1) + ". " + res.getString(2) + " >= " + res.getString(3)); 
    	    	// store Product_brand & price into list
    	    	Product_Brand.add(res.getString(2));
    	    	Product_Price.add(res.getString(3));
    	        
    	    }
    	      
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	System.out.println("_____________________________");
        
    	// check Product_Brand with database_table Product_brand names
    	int cnt1 = 0;
    	while(cnt1 < Product_Brand.size()) {
    		String str1 = Product_Brand.get(cnt1);
    		for(int i = 0 ; i < brand_Names.size() ; i++) {
    			String str2 = brand_Names.get(i);
    			if(str1.equals(str2)) {
    				System.out.println("Product Brand Match");
    			} 
            	
            } 
    		cnt1++;
    		
    	}
    	System.out.println("__________________________________");
    	
    	// check Product_price with database_table Product_price
    	int cnt2 = 0;
    	while(cnt2 < Product_Price.size()) {
    		String str1 = Product_Price.get(cnt2);
    		for(int i = 0 ; i < Price.size() ; i++) {
    			String str2 = Price.get(i);
    			if(str1.equals(str2)) {
    				System.out.println("Product Price Match");
    			}
    		}
    		cnt2++;
    	}
    	System.out.println("__________________________________");
    
        
    }
   

    
    // click on Product
    public void ClickOnProduct(WebDriver driver) {
    	try {
    		
    	   driver.findElement(By.xpath("//span[contains(text(),\"Oraimo Truly Wireless Earbuds Half in Ear Bluetooth Earbuds with ENC,Deep Bass, 16Hrs Playtime, 13Mm Dynamic Driver, Immersive Audio, Touch Control, Voice Assistance & Fast Charging\")]")).click();
    	}catch(Exception e) {
    		System.out.println("Not Click");
    	}
        
       // handle new Browser_tab
    	ArrayList<String>Win_List1   = new ArrayList<String>(driver.getWindowHandles());
    	driver.switchTo().window(Win_List1.get(0));
    	driver.close();
    	driver.switchTo().window(Win_List1.get(1));
    	     
    }

}