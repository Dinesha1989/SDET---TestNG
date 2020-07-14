package testNGTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class DemoOne {
 
  @Test
  public void testcase1() {
	  System.out.println("First test case executed from demoOne");
  }
  
  @Test
  public void testcase2() {
	  System.out.println("Second test case executed from demoOne");
  }
}
