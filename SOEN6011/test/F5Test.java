/*
 * F5Test.java
 * Version: 1.0
 * July 30, 2021
 * Copyright: Naveen Vuppula
 */

import org.junit.Assert;
import org.junit.Test;

/**
 * Class which is responsible for unit testing F5.
 */
public class F5Test {
    
    F5 f5obj = new F5();
    
    /**
     * Test1
     */
    @Test
    public void test1() {
        double a = 2;
        double base = 3;
        int power = 6;
        Assert.assertEquals(1458.0, f5obj.calc_F5(a, base, power), 0.00000000001);
    }
    
    /**
     * Test2
     */
    @Test
    public void test2() {
        double a = 6;
        double base = 0;
        int power = 0;
        Assert.assertEquals(6.0, f5obj.calc_F5(a, base, power), 0.00000000001);
    }
    
    /**
     * Test3
     */
    @Test
    public void test3() {
        double a = 518;
        double base = 5;
        int power = 0;
        Assert.assertEquals(518.0, f5obj.calc_F5(a, base, power), 0.00000000001);
    }
    
    /**
     * Test4
     */
    @Test
    public void test4() {
        double a = 125;
        double base = 0;
        int power = 5;
        Assert.assertEquals(0.0, f5obj.calc_F5(a, base, power), 0.00000000001);
    }
    
    /**
     * Test5
     */
    @Test(expected = IllegalArgumentException.class)
    public void test5() {
        double a = 89;
        double base = 0;
        int power = -4;
        f5obj.calc_F5(a, base, power);
    }
    
    /**
     * Test6
     */
    @Test
    public void test6() {
        double a = -10;
        double base = 2;
        int power = 6;
        Assert.assertEquals(-640.0, f5obj.calc_F5(a, base, power), 0.00000000001);
    }
    
    /**
     * Test7
     */
    @Test
    public void test7() {
        double a = 10;
        double base = 2;
        int power = -6;
        Assert.assertEquals(0.15625, f5obj.calc_F5(a, base, power), 0.00000000001);
    }
    
    /**
     * Test8
     */
    @Test
    public void test8() {
        double a = 10;
        double base = -2;
        int power = 6;
        Assert.assertEquals(640.0, f5obj.calc_F5(a, base, power), 0.00000000001);
    }
    
    /**
     * Test9
     */
    @Test
    public void test9() {
        double a = -20;
        double base = -2;
        int power = -5;
        Assert.assertEquals(0.625, f5obj.calc_F5(a, base, power), 0.00000000001);
    }
    
    /**
     * Test10
     */
    @Test
    public void test10() {
        double a = 134520;
        double base = 5;
        int power = 256;
        Assert.assertEquals(1.1617373940313053E184, f5obj.calc_F5(a, base, power), 0.00000000001);
    }
    
    /**
     * Test11
     */
    @Test
    public void test11() {
        double a = 520;
        double base = 6;
        int power = -156;
        Assert.assertEquals(2.110611e-119, f5obj.calc_F5(a, base, power), 0.00000000001);
    }
}