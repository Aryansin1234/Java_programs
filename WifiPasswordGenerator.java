import java.util.Scanner;

public class WifiPasswordGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter City: ");
        String city = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();

        System.out.print("Enter Gender (M/F): ");
        char gender = scanner.next().charAt(0);

        // Constraints
        if (name.length() < 3 || city.length() < 3 || age == 18) {
            System.out.println("Invalid input. Please ensure name and city have at least 3 characters, and age is not 18.");
            return;
        }

        // Password Generation
        String password;
        if (gender == 'F') {
            if (age < 18) {
                password = name.substring(0, 3) + sumOfDigits(age) + city.substring(city.length() - 3);
            } else {
                password = name.substring(name.length() - 3) + Math.abs(differenceOfDigits(age)) + city.substring(0, 3);
            }
        } else {
            password = generateDefaultPassword(name, city) + age;
        }

        System.out.println("Generated Password: " + password);
    }

    private static int sumOfDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    private static int differenceOfDigits(int number) {
        int digit1 = number % 10;
        int digit2 = (number / 10) % 10;
        return digit1 - digit2;
    }

    private static String generateDefaultPassword(String name, String city) {
        StringBuilder passwordBuilder = new StringBuilder();
        int maxLength = Math.max(name.length(), city.length());

        for (int i = 0; i < maxLength; i++) {
            if (i < name.length()) {
                passwordBuilder.append(name.charAt(i));
            }
            if (i < city.length()) {
                passwordBuilder.append(city.charAt(i));
            }
        }

        return passwordBuilder.toString();
    }
}

