
public class F5 {
	
	public double calc_F5(double a, double b, double x) {
		//Check base conditions.
		if (x==0) {
			return a;
		}
		else if (b ==0 && x>0) {
			return 0;
		}
		else if (b==0 && x<0) {
			return 1/0;
		}
		
		double result = 1;
		double power = x;
		double base = b;
		int i =0;
		
		while (power > 0) {
			i = i + 1;
			//System.out.println("Iteration#" +i +"base=" +base +"power=" +power +"result=" +result);
			if (power %2 == 1) {
				result = result * base;
			}
			
			power = (int)power /2;
			base = base * base;
		}
		
		return a*result;
	}
}