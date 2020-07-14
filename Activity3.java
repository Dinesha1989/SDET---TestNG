package testNGTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity3 {
  WebDriver driver;
  
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.get("https://www.training-support.net/selenium/login-form");
  }
  
  @Test
  public void Login() {
	  String Title = driver.getTitle();
	  System.out.println(Title);
	  //Assert.assertEquals(Title, "Login Form");
	  //if (Title == "Login Form") {
	  driver.findElement(By.id("username")).sendKeys("admin");
	  driver.findElement(By.id("password")).sendKeys("password");
	  driver.findElement(By.cssSelector("button.ui:nth-child(4")).click();
	  String confirmation = driver.findElement(By.xpath("//*[@id=\"action-confirmation\"]")).getText();
	  System.out.println("Confirmation message is : "+ confirmation);
	  Assert.assertEquals(confirmation, "Welcome Back, admin");
	  //}
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
