import java.util.Scanner;
public class StringCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("Enter the first string: ");
        String firstString = scanner.nextLine();

        System.out.print("Enter the second string: ");
        String secondString = scanner.nextLine();

        System.out.print("Enter the character to check for duplication: ");
        char charToCheck = scanner.next().charAt(0);

        // Check and get result
        String[] modifiedStrings = check(firstString, secondString, charToCheck);

        // Output
        if (modifiedStrings != null) {
            System.out.println("Modified First String: " + modifiedStrings[0]);
            System.out.println("Modified Second String: " + modifiedStrings[1]);
        } else {
            System.out.println("The character does not appear twice in both strings.");
        }
    }

    private static String[] check(String firstString, String secondString, char charToCheck) {
        // Count occurrences of the character in both strings
        int firstStringCount = (int) firstString.chars().filter(ch -> ch == charToCheck).count();
        int secondStringCount = (int) secondString.chars().filter(ch -> ch == charToCheck).count();

        // Check if the character appears twice in both strings
        if (firstStringCount == 2 && secondStringCount == 2) {
            // Remove the character from both strings
            String modifiedFirstString = firstString.replace(String.valueOf(charToCheck), "");
            String modifiedSecondString = secondString.replace(String.valueOf(charToCheck), "");

            return new String[]{modifiedFirstString, modifiedSecondString};
        } else {
            return null;
        }
    }
}

