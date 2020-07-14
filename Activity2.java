package testNGTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;

public class Activity2 {
	WebDriver driver;
  
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.get("https://www.training-support.net/selenium/target-practice");
  }

  @Test (priority=0)
  public void getTitle() {
	  String Title = driver.getTitle();
	  System.out.println("Title of the page is: "+ Title);
	  Assert.assertEquals(Title, "Target Practice");
  }
  
  @Test (priority=1)
  public void findElement() {
	  driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[3]")).isDisplayed();
	  String newTitle = driver.getTitle(); 
	  Assert.assertEquals(newTitle, "Target Practice1");
  }
  
  @Test (priority=2, enabled = false)
  public void skipEnabled() {
	  System.out.println("This test case will be skipped");
  }
  
  @Test (priority=3)
  public void skipExecption() {
	  throw new SkipException ("This test is skipped");
	  
  }
  
  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
