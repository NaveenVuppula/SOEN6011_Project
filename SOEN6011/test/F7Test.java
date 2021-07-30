import org.junit.Assert;
import org.junit.Test;

public class F7Test {
    @Test
    public void test1() {
        double x1 = 2;
        int y1 = 10;
        Assert.assertEquals(1024.0, F7.myPow(x1, y1), 0.00000000001);
    }

    @Test
    public void test2() {
        double x2 = -2;
        int y2 = 10;
        System.out.println(F7.myPow(x2, y2));
        Assert.assertEquals(1024.0, F7.myPow(x2, y2), 0.00000000001);
    }

    @Test
    public void test3() {
        long x3 = 2;
        int y3 = -2;
        System.out.println(F7.myPow(x3, y3));
        Assert.assertEquals(0.25, F7.myPow(x3, y3), 0.00000000001);
    }

    @Test
    public void test4() {
        double x4 = -2;
        int y4 = -2;
        System.out.println(F7.myPow(x4, y4));
        Assert.assertEquals(0.25, F7.myPow(x4, y4), 0.00000000001);
    }

    @Test
    public void test5() {
        double x5 = -2;
        int y5 = -3;
        System.out.println(F7.myPow(x5, y5));
        Assert.assertEquals(-0.125, F7.myPow(x5, y5), 0.00000000001);
    }

    @Test
    public void test6() {
        double x6 = 0.5;
        int y6 = -2;
        System.out.println(F7.myPow(x6, y6));
        Assert.assertEquals(4.0, F7.myPow(x6, y6), 0.00000000001);
    }

    @Test
    public void test7() {
        double x7 = -2147483648;
        long y7 = -10;
        Assert.assertEquals(4.794036587204811E-94, F7.myPow(x7, y7), 0.00000000001);
    }

    @Test
    public void test8() {
        double x8 = 2147483648D;
        long y8 = 10;
        Assert.assertEquals(2.0859248397665138E93, F7.myPow(x8, y8), 0.00000000001);
    }


    @Test(expected = IllegalArgumentException.class)
    public void test9() {
        double x9 = 0;
        long y9 = -1;
        F7.myPow(x9, y9);

    }
}
