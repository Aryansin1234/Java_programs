import java.util.Scanner;
public class AddLongestArrays {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int[] array1 = getUserArray("first");
        int[] array2 = getUserArray("second");

        int[] resultArray = addLongestArrays(array1, array2);

        System.out.print("Result array: ");
        displayArray(resultArray);
    }
    private static int[] getUserArray(String ordinal) {
        System.out.print("Enter the size of the " + ordinal + " array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Enter the elements of the " + ordinal + " array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }
    private static int[] addLongestArrays(int[] array1, int[] array2) {
        int maxLength = Math.max(array1.length, array2.length);
        int[] resultArray = new int[maxLength];
        for (int i = 0; i < maxLength; i++) {
            resultArray[i] = (i < array1.length ? array1[i] : 0) + (i < array2.length ? array2[i] : 0);
        }
        return resultArray;
    }
    private static void displayArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

