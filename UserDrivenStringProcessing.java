import java.util.Scanner;

public class UserDrivenStringProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = scanner.nextLine();

        // Output 1: Compute the product of single digits
        System.out.println("Output 1: " + computeProductOfSingleDigits(s));

        // Output 2: Get all alphabets without repetition
        System.out.println("Output 2: " + getUniqueAlphabets(s));

        // Output 3: Calculate the sum of 2-digit and 3-digit numbers
        System.out.println("Output 3: " + calculateSumOfNumbers(s));
    }

    private static int computeProductOfSingleDigits(String s) {
        int product = 1;

        for (int i = 1; i < s.length() - 1; i++) {
            char currentChar = s.charAt(i);
            char prevChar = s.charAt(i - 1);
            char nextChar = s.charAt(i + 1);

            if (Character.isDigit(currentChar) && Character.isAlphabetic(prevChar) && Character.isAlphabetic(nextChar)) {
                product *= Character.getNumericValue(currentChar);
            }
        }

        return product;
    }

    private static String getUniqueAlphabets(String s) {
        StringBuilder uniqueAlphabets = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c) && uniqueAlphabets.indexOf(String.valueOf(c)) == -1) {
                uniqueAlphabets.append(c);
            }
        }
        return uniqueAlphabets.toString();
    }

    private static int calculateSumOfNumbers(String s) {
        int sum = 0;
        StringBuilder currentNumber = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                currentNumber.append(c);
            } else {
                if (currentNumber.length() > 0) {
                    int number = Integer.parseInt(currentNumber.toString());
                    if (number >= 10 && number <= 999) {
                        sum += number;
                    }
                    currentNumber.setLength(0);
                }
            }
        }

        // Check if there is a number at the end of the string
        if (currentNumber.length() > 0) {
            int number = Integer.parseInt(currentNumber.toString());
            if (number >= 10 && number <= 999) {
                sum += number;
            }
        }

        return sum;
    }
}

