import java.util.Scanner;
public class LongestSameCharacterSubsequence {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Input
            System.out.print("Enter a string: ");
            String inputString = scanner.nextLine();
            // Find the longest subsequence of the same character
            Result result = findLongestSameCharacterSubsequence(inputString);
            // Output
            if (result.character != '\0') {
                System.out.println("Longest subsequence: " + result.character + "=" + result.count);
            } else {
                System.out.println("No repeated characters found in the string.");
            }
        }
    }

    private static Result findLongestSameCharacterSubsequence(String inputString) {
        char currentChar = '\0';
        int currentCount = 0;
        char maxChar = '\0';
        int maxCount = 0;

        for (char c : inputString.toCharArray()) {
            if (c == currentChar) {
                currentCount++;
            } else {
                currentChar = c;
                currentCount = 1;
            }
            if (currentCount > maxCount) {
                maxChar = currentChar;
                maxCount = currentCount;
            }
        }
        return new Result(maxChar, maxCount);
    }

    static class Result {
        char character;
        int count;
        Result(char character, int count) {
            this.character = character;
            this.count = count;
        }
    }
}

