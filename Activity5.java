package testNGTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity5 {
  WebDriver driver;
  
  @BeforeClass (alwaysRun=true)
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.get("https://www.training-support.net/selenium/target-practice");
  }
  
  @Test (groups = {"HeaderTests", "ButtonTests"})
  public void pageTitleTest() {
	  String Title = driver.getTitle();
	  System.out.println("Title of the page is: "+ Title);
	  Assert.assertEquals(Title, "Target Practice"); 
  }
  
  @Test (dependsOnMethods = "pageTitleTest", groups = {"HeaderTests"})
  public void pageHeaderTest1() {
	  WebElement thirdHeader= driver.findElement(By.id("third-header"));
	  System.out.println("Third header of the page is: "+ thirdHeader.getText());
	  Assert.assertEquals(thirdHeader.getText(), "Third header");
  }

  @Test (dependsOnMethods = "pageTitleTest",groups = {"HeaderTests"})
  public void pageHeaderTest2() {
	  String color = driver.findElement(By.cssSelector("h5.ui")).getCssValue("color");
	  System.out.println("Color of the fifth header is: "+ color);
	  Assert.assertEquals(color, "rgb(33, 186, 69)");
  }
  
  @Test (dependsOnMethods = "pageTitleTest",groups = {"ButtonTests"})
  public void buttonTest1() {
	  String oliveButton = driver.findElement(By.cssSelector("button.olive")).getText();
	  System.out.println("Olive button text is: "+ oliveButton);
	  Assert.assertEquals(oliveButton, "Olive");
  }
  
  @Test (dependsOnMethods = "pageTitleTest",groups = {"ButtonTests"})
  public void buttonTest2() {
	  String color1= driver.findElement(By.cssSelector(".brown")).getCssValue("background-color");
	  System.out.println("button color is: "+ color1);
	  Assert.assertEquals(color1, "rgb(165, 103, 63)");
  }
  @AfterClass(alwaysRun=true)
  public void afterClass() {
	  driver.close();
  }

}
