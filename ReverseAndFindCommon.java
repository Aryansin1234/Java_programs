import java.util.Arrays;
import java.util.Scanner;

public class ReverseAndFindCommon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Take a number from the user
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Store digits in an array
        int[] originalArray = getDigitsArray(number);

        // Reverse the array
        int[] reversedArray = reverseArray(originalArray);

        // Find and print common elements
        int[] commonElements = findCommonElements(originalArray, reversedArray);

        // Output: Print the original and reversed arrays, and common elements
        System.out.println("Original Array: " + Arrays.toString(originalArray));
        System.out.println("Reversed Array: " + Arrays.toString(reversedArray));
        System.out.println("Common elements: " + Arrays.toString(commonElements));
    }

    private static int[] getDigitsArray(int number) {
        // Count the number of digits
        int count = 0;
        int tempNumber = number;
        while (tempNumber != 0) {
            tempNumber /= 10;
            count++;
        }

        // Store digits in an array
        int[] digitsArray = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            digitsArray[i] = number % 10;
            number /= 10;
        }

        return digitsArray;
    }

    private static int[] reverseArray(int[] array) {
        int length = array.length;
        int[] reversedArray = new int[length];

        for (int i = 0; i < length; i++) {
            reversedArray[i] = array[length - 1 - i];
        }

        return reversedArray;
    }

    private static int[] findCommonElements(int[] array1, int[] array2) {
        return Arrays.stream(array1)
                .distinct()
                .filter(value -> Arrays.stream(array2).anyMatch(x -> x == value))
                .toArray();
    }
}

