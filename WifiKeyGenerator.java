import java.util.Scanner;
public class WifiKeyGenerator {
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

        // Generate Wi-Fi key
        String wifiKey = generateWifiKey(name, city, age, gender);

        // Output
        System.out.println("Generated Wi-Fi Key: " + wifiKey);
    }
    private static String generateWifiKey(String name, String city, int age, char gender) {
        if (gender == 'M') {
            return name.substring(0, 3) + differenceOfDigits(age) + city.substring(city.length() - 3);
        } else if (gender == 'F') {
            return name.substring(name.length() - 3) + sumOfDigits(age) + city.substring(0, 3);
        } else {
            return "Invalid gender. Please enter M or F.";
        }
    }
    private static int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
    private static int differenceOfDigits(int number) {
        return (number % 10) - ((number / 10) % 10);
    }
}

