package utils;

import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.function.DoublePredicate;
import java.util.function.Predicate;

public class InputHelper {
    private static final Scanner sc = new Scanner(System.in);

    public static String getValidString(String prompt, Predicate<String> validator, String errorMessage) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine();
            if (validator.test(input)) {
                return input;
            }
            System.out.println(errorMessage);
        }
    }

    public static int getValidInt(String prompt, IntPredicate validator, String errorMessage) {
        while (true) {
            System.out.print(prompt);
            try {
                int input = Integer.parseInt(sc.nextLine());
                if (validator.test(input)) {
                    return input;
                }
            } catch (NumberFormatException _) {
            }
            System.out.println(errorMessage);
        }
    }

    public static double getValidDouble(String prompt, DoublePredicate validator, String errorMessage) {
        while (true) {
            System.out.print(prompt);
            try {
                double input = Double.parseDouble(sc.nextLine());
                if (validator.test(input)) {
                    return input;
                }
            } catch (NumberFormatException _) {
            }
            System.out.println(errorMessage);
        }
    }

    public static char getValidChar(String prompt, char[] validOptions) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().toLowerCase();
            if (input.length() > 0) {
                char c = input.charAt(0);
                for (char option : validOptions) {
                    if (c == option) {
                        return c;
                    }
                }
            }
            System.out.println("Invalid input. Please try again.");
        }
    }
}


