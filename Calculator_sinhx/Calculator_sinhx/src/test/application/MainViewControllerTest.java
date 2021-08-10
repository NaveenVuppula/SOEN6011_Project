package test.application;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DecimalFormat;
import main.application.MainViewController;
import org.junit.Before;
import org.junit.Test;


/**
 * This class is test class for MainViewController which tests all the method such as 
 * validating input values, power values and logarithm function values. 
 * @author Harsh
 * 
 */
public class MainViewControllerTest {

  MainViewController testOb;
  /**
   * For before the test case.
   */
  @Before 
  public void before() {
    System.out.println("In before() which is called before every test case method!!");
    testOb = new MainViewController();
  }

  /**
   * This method tests the exponential of  x.  
   */
  @Test
  public void testcalculateExponential() {
    double result = testOb.calculateExponential(2);
    DecimalFormat df = new DecimalFormat(".#####");
    result = Double.parseDouble(df.format(result));
    System.out.println("Power result :" + result);
    assertEquals(result, 7.38906);
  }
  
  /**
   * This method tests the power method for real number.  
   */
  @Test
  public void testcalculateExponential1() {
    double result = testOb.calculateExponential(-2);
    DecimalFormat df = new DecimalFormat(".#####");
    result = Double.parseDouble(df.format(result));
    System.out.println("Power result :" + result);
    assertEquals(result, 0.13534);
  }
  
  /**
   * This method tests the sinhx method.  
   */
  @Test
  public void testcalculateSinhx() {
    double result = testOb.calculateSinhx(1);
    DecimalFormat df = new DecimalFormat(".####");
    result = Double.parseDouble(df.format(result));
    System.out.println("Power result :" + result);
    assertEquals(result, 1.1752);
  }
  
  /**
   * This method tests the sinhx method.  
   */
  @Test
  public void testcalculateSinhx1() {
    double result = testOb.calculateSinhx(-1);
    DecimalFormat df = new DecimalFormat(".####");
    result = Double.parseDouble(df.format(result));
    System.out.println("Power result :" + result);
    assertEquals(result, -1.1752);
  }
  

}
