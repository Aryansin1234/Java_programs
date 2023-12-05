import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserRegistrationForm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User Registration Form
        System.out.println("User Registration Form");

        // Validation: Name should contain only character values
        String name;
        do {
            System.out.print("Enter your name: ");
            name = scanner.nextLine();
        } while (!isValidName(name));

        // Validation: Address should contain multiple values
        System.out.print("Enter your address: ");
        String address = scanner.nextLine();

        // Validation: Select maximum 2 checkboxes out of three in the subject field
        List<String> selectedSubjects = selectItems(scanner, "Subjects", List.of("Math", "Science", "English"), 2);

        // Validation: Select maximum 2 items in the Exam center field
        List<String> selectedExamCenters = selectItems(scanner, "Exam Centers", List.of("Center A", "Center B", "Center C"), 2);

        // Display User Information
        System.out.println("\nUser Information:");
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Selected Subjects: " + selectedSubjects);
        System.out.println("Selected Exam Centers: " + selectedExamCenters);

        scanner.close();
    }

    private static boolean isValidName(String name) {
        // Validate if the name contains only characters
        return name.matches("[a-zA-Z]+");
    }

    private static List<String> selectItems(Scanner scanner, String itemType, List<String> items, int maxSelections) {
        System.out.println("\nSelect " + itemType + " (Maximum " + maxSelections + "):");
        List<String> selectedItems = new ArrayList<>();

        for (String item : items) {
            System.out.print("Do you like " + item + "? (yes/no): ");
            String choice = scanner.nextLine().toLowerCase();

            if (choice.equals("yes")) {
                selectedItems.add(item);
                if (selectedItems.size() == maxSelections) {
                    break; // Maximum selections reached
                }
            }
        }

        return selectedItems;
    }
}

