import java.util.Scanner;

public class LongestSeries {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Get the size of the array from the user
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        // Input: Get the array values from the user
        int[] array = new int[size];
        System.out.println("Enter the array values (0 or 1 only):");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        // Find the longest series
        Result result = findLongestSeries(array);

        // Output
        System.out.println("Longest series: " + result.value);
        System.out.println("Length: " + result.length);
    }

    private static Result findLongestSeries(int[] array) {
        int currentLength = 1;
        int maxLength = 0;
        int value = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) {
                currentLength++;
            } else {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    value = array[i - 1];
                }
                currentLength = 1;
            }
        }

        // Check for the last sequence
        if (currentLength > maxLength) {
            maxLength = currentLength;
            value = array[array.length - 1];
        }

        return new Result(value, maxLength);
    }

    static class Result {
        int value;
        int length;

        Result(int value, int length) {
            this.value = value;
            this.length = length;
        }
    }
}

