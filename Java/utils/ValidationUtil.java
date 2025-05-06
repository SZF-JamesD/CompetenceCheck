package utils;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ValidationUtil {

    public static boolean isNonEmptyString(String input) {
        return input != null && !input.trim().isEmpty();
    }


    public static boolean isAlphanumeric(String input) {
        if (input == null) return false;
        return Pattern.matches("^[a-zA-Z0-9 ]+$", input);
    }


    public static boolean isPositiveInt(int number) {
        return number > 0;
    }


    public static boolean isNonNegativeDouble(double number) {
        return number >= 0;
    }


    public static boolean isValidYear(int year) {
        return year >= 1886 && year <= 2100;
    }


    public static boolean isValidChar(char input, char... validOptions) {
        for (char option : validOptions) {
            if (input == option) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidVehicleChoice(int choice) {
        return choice >= 1 && choice <= 4;
    }

    public static boolean isValidName(String name) {
        Pattern namePattern = Pattern.compile("^(?!^\\s*$)([A-Za-zÄÖÜäöüß]+(-[A-Za-zÄÖÜäöüß]+)?)\\s+([A-Za-zÄÖÜäöüß]+(-[A-Za-zÄÖÜäöüß]+)?)$");
        if (name == null) {return false;}
        Matcher matcher = namePattern.matcher(name);
        return matcher.matches();
    }

    public static String capitalizeName(String name) {
        if (name == null || name.isEmpty()) {return name;}
        String[] parts = name.split("\\s+");
        StringBuilder capitalizedName = new StringBuilder();

        for (int i = 0; i < parts.length; i++) {
            if (i > 0) {
                capitalizedName.append(" ");
            }
            capitalizedName.append(capitalizeHyphen(parts[i]));
        }
        return capitalizedName.toString();
    }

    private static String capitalizeHyphen(String input) {
        String[] parts = input.split("-");
        StringBuilder capitalized = new StringBuilder();

        for (int i = 0; i < parts.length; i++) {
            if (i > 0) {
                capitalized.append("-");
            }
            capitalized.append(capitalizeWord(parts[i]));
        }
        return capitalized.toString();
    }

    private static String capitalizeWord(String input) {
        if (input == null || input.isEmpty()) {return input;}
        return input.substring(0,1).toUpperCase() + input.substring(1).toLowerCase();
    }
}
