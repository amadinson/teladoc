package org.health;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

public class SumStringsAsNumber {

    private static final Logger logger = LogManager.getLogger(SumStringsAsNumber.class);
    private final Pattern pattern = Pattern.compile("^\\d+$");

    /**
     * This method receive an Array of String representing Number and return their sum as String
     *
     * @param stringAsNumberList - Array of Number as String
     * @return sum of element of String as number
     */
    public String execute(String[] stringAsNumberList) {
        for (int i = 0; i <= stringAsNumberList.length - 1; i++) {
            checkParameter(stringAsNumberList[i]);
        }
        var result = stringAsNumberList[0];
        for (int i = 1; i <= stringAsNumberList.length - 1; i++) {
            result = sumString(result, stringAsNumberList[i]);
        }
        return result;
    }

    private void checkParameter(String stringAsNumber) {
        if (stringAsNumber == null || !pattern.matcher(stringAsNumber).matches()) {
            throw new IllegalArgumentException("Invalid parameter. String must be non-null and contain only digits.");
        }
    }

    /**
     * This method receive a String[] representing of Numbers and return their sum as String
     *
     * @param stringAsNumber1 - Number as String
     * @param stringAsNumber2 - Number as String
     * @return sum of element of String as number
     */
    public String execute(String stringAsNumber1, String stringAsNumber2) {
        return execute(new String[]{stringAsNumber1, stringAsNumber2});
    }

    private String sumString(String stringAsNumber1, String stringAsNumber2) {
        var pivotLength = Math.max(stringAsNumber1.length(), stringAsNumber2.length()) + 1;
        int ten = 0;
        var result = new StringBuilder(pivotLength);
        for (int i = stringAsNumber1.length() - 1, j = stringAsNumber2.length() - 1; i >= 0 || j >= 0; i--, j--) {
            var digit1 = i >= 0 ? Character.getNumericValue(stringAsNumber1.charAt(i)) : 0;
            var digit2 = j >= 0 ? Character.getNumericValue(stringAsNumber2.charAt(j)) : 0;
            var sum = digit1 + digit2 + ten;
            var unit = sum % 10;
            ten = sum / 10;
            result.append(unit);
            pivotLength--;
        }
        if (ten > 0) {
            result.append(ten);
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            logger.info("Invalid Parameter, usage: java -jar App.jar  \"109\" \"2010\"");
        } else {
            var sumStringsAsNumber = new SumStringsAsNumber();
            var total = sumStringsAsNumber.execute(args);
            logger.info("Result: {}", total);
        }
    }
}