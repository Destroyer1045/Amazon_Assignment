package com.test;

	import java.time.Duration;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;

	public class AddToCart {
		// add into cart
		public void AddIntoCartEle(WebDriver driver) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.findElement(By.xpath("//input[@id = \"add-to-cart-button\"]")).click();
			
		}
	}

