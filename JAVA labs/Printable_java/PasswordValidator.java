/*-----------------------------------------------------------
Program to validate passwords with the given conditions
@Author - Shashank
-------------------------------------------------------------*/
package Printable_java;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        String password;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your password");
        password = sc.nextLine();

        if (passwordValidate(password)) {
            System.out.println("Your password is strong");
            return;
        }
        System.out.println("Your password is weak");

    }

    private static boolean passwordValidate(String password) {
        if (password.length() < 8) {
            return false;
        }

        // flags
        boolean ucase = false, lcase = false, special = false, num = false;

        for (int i = 0; i < password.length(); i++) {
            Character c = password.charAt(i);
            if (Character.isLowerCase(c)) {
                lcase = true;
            } else if (Character.isUpperCase(c)) {
                ucase = true;
            } else if (Character.isDigit(c)) {
                num = true;
                // considering all characters except space and above conditions as special
                // characters
            } else if (!Character.isWhitespace(c))
                special = true;
            else
                return false;
        }

        if (lcase && ucase && special && num)
            return true;
        return false;
    }
}
