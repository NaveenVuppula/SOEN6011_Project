import java.util.Scanner;

public class Application {
	static Scanner s = new Scanner(System.in);
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to SOEN 6011 Project. Choose from the Menu:\n");
		System.out.println("1. arccos(x)\n2. sinh(x)\n3. ab^x\n4. x^y\n");
		
		int ch = s.nextInt();
		
		Application a = new Application();
		a.performChoice(ch);
		s.close();
	}
	
	//Perform the operation
	public void performChoice(int ch) {
		
		switch(ch) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			System.out.print("Enter the values of Constants, a:");
			double a = s.nextDouble();
			
			System.out.print("\nEnter b:");
			double b = s.nextDouble();
			
			System.out.print("\nEnter the values of x:");
			double x = s.nextDouble();
			
			F5 f5obj = new F5();
			double result = f5obj.calc_F5(a, b, x);
			
			System.out.printf("\nThe value returned by F5: ab^x = %f" ,result);						
			break;
		case 4:
			break;
		default:
			System.out.println("Enter a valid choice !!");
			break;
		}
	}	
}