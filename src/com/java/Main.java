package com.java;

/*
https://www.sapling.com/7966257/checksum-credit-card
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your credit card number:");
	    String creditCardNumber = scanner.nextLine();
        int checkDigit = Character.getNumericValue(creditCardNumber.charAt(creditCardNumber.length()-1));
	    int[] transformedCardNumber = transformDigits(creditCardNumber);
	    boolean isCreditCardNumberValid = isCreditCardValid(transformedCardNumber, checkDigit);
	    System.out.println("Credit card is valid: " + isCreditCardNumberValid);
    }

    private static int[] transformDigits(String s) {
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length() - 1; i++) {
            arr[i] = Character.getNumericValue(s.charAt(i));
            if (i % 2 == 0) { //multiply every second digit by 2
                arr[i] *= 2;
                if (arr[i] >= 10) { //sum the digits of the number if it's a two digit number
                    arr[i] = sumNumberDigits(arr[i]);
                }
            }
        }
        return arr;
    }

    private static int sumNumberDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum = sum + number % 10;
            number = number / 10;
        }
        return sum;
    }

    private static boolean isCreditCardValid(int[] transformedCreditCardDigits, int checkDigit) {
        int sum = 0;
        for (int i = 0; i < transformedCreditCardDigits.length; i++) {
            sum += transformedCreditCardDigits[i];
        }
        return ((sum + checkDigit) % 10 == 0);
    }

}
