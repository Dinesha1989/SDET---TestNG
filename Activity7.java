package testNGTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Activity7 {
  WebDriver driver;
  
  @DataProvider(name = "Authentication")
  public static Object[][] credentials(){
	return new Object[][] {{"admin", "password"}};
  }
  
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.get("https://www.training-support.net/selenium/login-form");
  }
  
  @Test(dataProvider = "Authentication")
  public void testdDataProvider(String username, String password) {
	  driver.findElement(By.id("username")).sendKeys(username);
	  driver.findElement(By.id("password")).sendKeys(password);
	  driver.findElement(By.cssSelector("button.ui:nth-child(4")).click(); 
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
