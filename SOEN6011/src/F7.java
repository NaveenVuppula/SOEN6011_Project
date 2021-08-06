/**
 * Implementation for function 7
 */
public class F7 {
    /**
     * Method to calculate the value of function F7 x^y
     * @param base the base of the function
     * @param exponent the exponent of the function
     * @return the value of function F7 x^y
     */
    public static double myPow(double base, long exponent) {


        boolean isNegative = false;

        if (base < 0 && exponent % 2 != 0) {
            isNegative = true;
        }

        if (base == 0 && exponent == 0) {
            return 0;
        }

        if (base == 0 && exponent < 0) {

            throw new IllegalArgumentException("x = 0 and y is negative number will cause divide by zero exception");


        }

        if (base == 0 && exponent > 0) {
            return 0;
        }

        if (exponent == 0) {
            return 1;
        }

        if(exponent < 0){
            exponent = -exponent;
            base = 1 / base;
        }

        double result = 1;

        while(exponent != 0){
            if (result == 0 && !isNegative) {
                return Double.POSITIVE_INFINITY;
            }

            if (result == 0 && isNegative) {
                return Double.NEGATIVE_INFINITY;
            }

            if((exponent & 1) != 0) {
                result *= base;
            }

            base *= base;
            exponent >>>= 1;

        }

        return result;
    }

}
