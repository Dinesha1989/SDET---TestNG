package testNGTests;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class Activity9 {
 WebDriver driver;
 
  @BeforeMethod
  public void beforeMethod() {
	  driver.switchTo().defaultContent();
  }

  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  driver.get("https://www.training-support.net/selenium/javascript-alerts");
	  
  }


  @Test (priority=0)
  public void simpleAlertTestCase() {
	  driver.findElement(By.id("simple")).click();
	  Reporter.log("Simple alert is opened");
	  Alert simplealert = driver.switchTo().alert();
	  Reporter.log("Switched to alert");
	  String text = simplealert.getText();
	  Reporter.log(text);
	  Assert.assertEquals("This is a JavaScript Alert!", text);
	  simplealert.accept();
	  simplealert.dismiss();
	  Reporter.log("Test case is ended");
  }
  
  @Test(priority=1)
  public void confirmAlertTestCase() {
	  driver.findElement(By.id("confirm")).click();
	  Reporter.log("Confirmation alert is opened");
	  Alert confirmalert = driver.switchTo().alert();
	  Reporter.log("Switched to alert");
	  
	  String textConfirm = confirmalert.getText();
	  Reporter.log(textConfirm);
	  Assert.assertEquals(textConfirm, "This is a JavaScript Confirmation!");
	  confirmalert.accept();
	  confirmalert.dismiss();
	  Reporter.log("Test case is eneded");
  }
  
  @Test(priority=2)
  public void promptAlertTestCase() {
	  driver.findElement(By.id("prompt")).click();
	  Reporter.log("Prompt alert is opened");
	  Alert promptalert = driver.switchTo().alert();
	  Reporter.log("Swicthed to alert");
	  String textprompt = promptalert.getText();
	  Reporter.log(textprompt);
	  Assert.assertEquals(textprompt, "This is a JavaScript Prompt!");
	  promptalert.accept();
	  promptalert.dismiss();
	  Reporter.log("Test case is eneded");
  }
  
  
  @AfterTest
  public void afterTest() {
	  driver.close();
  }
}

