package utils;

import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class InputHelper {
    private final Scanner sc;

    public InputHelper(Scanner sc) {
        this.sc = sc;
    }

    public String getValidString(String prompt, Predicate<String> validator, String errorMessage) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine();
            if (validator.test(input)) {
                return input;
            }
            System.out.println(errorMessage);
        }
    }

    public String getValidStatus(String prompt, Predicate<String> validator, String errorMessage) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine();
            if (validator.test(input.toLowerCase())) {
                return input;
            }
            System.out.println(errorMessage);
        }
    }

    public int getValidPrio(String prompt, IntPredicate validator, String errorMessage) {
        while (true) {
            System.out.print(prompt);
            int input = sc.nextInt();
            if (validator.test(input)) {
                return input;
            }
            System.out.println(errorMessage);
        }
    }


    public int getValidInt(String prompt, IntPredicate validator, String errorMessage) {
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
}


