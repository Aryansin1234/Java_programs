import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class AgeGapCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("Enter your birthdate (DD-MM-YYYY): ");
        String birthdateString = scanner.nextLine();

        // Calculate and output age gap
        long ageGapInDays = calculateAgeGap(birthdateString);
        printAgeGap(ageGapInDays);
    }
    private static long calculateAgeGap(String birthdateString) {
        try {
            LocalDate birthdate = LocalDate.parse(birthdateString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            return LocalDate.now().toEpochDay() - birthdate.toEpochDay();
        } catch (Exception e) {
            return -1; // Handle invalid date format
        }
    }
    private static void printAgeGap(long ageGapInDays) {
        if (ageGapInDays >= 0) {
            System.out.println("Number of days gap in your age: " + ageGapInDays + " days");
        } else {
            System.out.println("Invalid date format. Please enter the date in DD-MM-YYYY format.");
        }
    }
}

