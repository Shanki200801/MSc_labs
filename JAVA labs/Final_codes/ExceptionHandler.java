/*-----------------------------------------------------------
Program to Demonstate exception handling
Catching filenotfound and divide by 0 errors
@Author - Shashank
-------------------------------------------------------------*/
package Final_codes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ExceptionHandler {
    private static void divideOp(int num1, int num2) {
        int result = 0;
        try {
            // Placing the block of code that may throw a ArithmeticException within
            // the try block
            result = num1 / num2;
            System.out.println("The result of the division is " + result);
        } catch (ArithmeticException e1) {
            System.out.println("It is not possible to divide a number by 0!");
        }
    }

    private static void readFile(String fileName) {
        FileReader fileReader;
        try {
            // Placing the block of code that may throw a FileNotFound within
            // the try block
            fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String fileData = null;
            try {

                // Placing the block of code that may throw a IOException
                // within the try block
                while ((fileData = bufferedReader.readLine()) != null) {
                    System.out.println(fileData);
                }
            } catch (IOException e2) {
                e2.printStackTrace(); // prints the message of e2 & the line
                // number where the exception occurs

            }
        } catch (FileNotFoundException e3) {
            e3.printStackTrace();
            // prints the message of e3 &

            // the line number where the exception occurs
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the name of the file to be printed");
        readFile(scan.nextLine());
        System.out.println("Enter 2 numbers:");
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        divideOp(num1, num2);
        scan.close();
    }
}
