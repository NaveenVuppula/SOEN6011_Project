/*
 * Application.java
 * Version: 1.0
 * July 30, 2021
 * Copyright: Developed by Team F as part of SOEN 6011 Project.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class which provides an User interface for the calculator functionality.
 */
public class Application {
    static Scanner s = new Scanner(System.in);

    /**
     * Main method for the application class.
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Welcome to SOEN 6011 Project. Choose from the Menu:\n");
        System.out.println("1. arccos(x)\n2. sinh(x)\n3. ab^x\n4. x^y\n");

        int ch = s.nextInt();

        Application a = new Application();
        a.performChoice(ch);
        s.close();
    }

    /**
     * Method responsible for performing the operation needed.
     */
    public void performChoice(int ch) {

        switch (ch) {
        case 1:
            break;
        case 2:
            break;
        case 3:
            try {
                System.out.print("Enter the value of a:");
                double a = s.nextDouble();

                System.out.print("Enter the value of b:");
                double b = s.nextDouble();

                System.out.print("Enter the value of x:");
                int x = s.nextInt();

                F5 f5obj = new F5();
                double result = f5obj.calc_F5(a, b, x);
                System.out.println("\nThe value returned by F5: ab^x = " +result);

            } catch (InputMismatchException e) {
                System.out.println("Enter Valid values. " + e.toString());
            } catch (IllegalArgumentException e) {
                System.out.println("Undefined output: " + e.toString());
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            break;
        case 4:
            System.out.print("Enter the value of x:");
            double base = s.nextDouble();

            System.out.print("Enter the value of y:");
            long exponent = s.nextLong();

            try {
                double result = F7.myPow(base, exponent);
                System.out.printf("\nThe value returned by F5: x^y = %f" ,result);
            }
            catch(Exception e) {
                System.out.println("Undefined output: " +e.toString());
            }
            break;
        default:
            System.out.println("Enter a valid choice !!");
            break;
        }
    }
}