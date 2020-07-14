package testNGTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class Activity10 {
  WebDriver driver;
  Actions builder;
	
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  builder = new Actions(driver);
	  driver.get("https://www.training-support.net/selenium/sliders");
  }
  
  @Test (priority=0)
  public void slidertTomiddleValue() {
	  
	  WebElement slider = driver.findElement(By.id("slider"));
	  slider.click();
      String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
  	  System.out.println(volumeLevel);
      Reporter.log("Mid value: " + volumeLevel);
      
      Assert.assertEquals(volumeLevel, "50");
  }
  

  @Test (priority=1)
  public void sliderTomaximumValue() {
	  
      WebElement slider = driver.findElement(By.id("slider")); 	
      //Drag the slider
      builder.clickAndHold(slider).moveByOffset(80, 0).release().build().perform();
      String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
      System.out.println(volumeLevel);
      Reporter.log("Max value: " + volumeLevel);
      Assert.assertEquals(volumeLevel, "100");
  }
  
  
  @Test (priority=2)
  public void sliderTominimumValue() {
	  
      //Find slider	
      WebElement slider = driver.findElement(By.id("slider"));
      //Drag the slider
      builder.clickAndHold(slider).moveByOffset(-79, 0).release().build().perform();
      String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
      System.out.println(volumeLevel);
      Reporter.log("Min value: " + volumeLevel);
      Assert.assertEquals(volumeLevel, "0");   
  }
  
  
  @Test (priority=3)
  public void sliderto30Value() {
	  
      //Find slider	
      WebElement slider = driver.findElement(By.id("slider"));	
      //Drag the slider	
      builder.clickAndHold(slider).moveByOffset(-31, 0).release().build().perform();		
      String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
      System.out.println(volumeLevel);
      Reporter.log("Min value: " + volumeLevel);	
      Assert.assertEquals(volumeLevel, "30");
  }
  
  
  @Test (priority=4)
  public void sliderTO80Value() {
      //Find slider	
      WebElement slider = driver.findElement(By.id("slider"));	
      //Drag the slider	
      builder.clickAndHold(slider).moveByOffset(48, 0).release().build().perform();	
      String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();	
      System.out.println(volumeLevel);
      Reporter.log("Min value: " + volumeLevel);	
      Assert.assertEquals(volumeLevel, "80");
  }
  
  
  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
