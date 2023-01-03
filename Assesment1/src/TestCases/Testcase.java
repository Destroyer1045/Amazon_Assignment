package TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.test.AddToCart;
import com.test.HomePage;
import com.test.ProductListPage;

public class Testcase {
	// Print List of Products 
	public void TestPrintListOfProducts() {
      
	  try {
      //driver
      ProductListPage listPage = new ProductListPage();
	  HomePage home = new HomePage();	
	  WebDriver driver = new EdgeDriver();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
      
//      HomePage.SearchProduct(driver);
//      listPage.PrintFirst4Products(driver);

      driver.close();
	  }catch(Exception e){
		  e.printStackTrace();
		  
	  }   
  }
  
// check List of Product is valid or not
public void ValidateListOfProducts() {
      
	try {
//      driver
      ProductListPage listPage = new ProductListPage();
      HomePage home = new HomePage();
      WebDriver driver = new EdgeDriver();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
      
      home.SearchProduct(driver);
      ProductListPage.ValidateListofProducts(driver);
      
//      listPage.ClickOnProduct(driver);
//      AddtoCart
      
      driver.close();
	}catch(Exception e){
		e.printStackTrace();
		
	}
	   
   }

// click on Product
public void clickonProducts() {
    
    HomePage home = new HomePage();
    WebDriver driver = new EdgeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    
    home.SearchProduct(driver);
    ProductListPage listPage = new ProductListPage();
    listPage.ClickOnProduct(driver);
    
    AddToCart cart = new AddToCart();
    cart.AddIntoCartEle(driver);
    
    
//    driver.close();
      
  }

}