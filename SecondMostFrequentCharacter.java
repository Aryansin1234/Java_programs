import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SecondMostFrequentCharacter {

    public static char findSecondMostFrequentCharacter(String str) {
        // Create a hash map to store character frequencies
        HashMap<Character, Integer> charFreqMap = new HashMap<>();

        // Count character frequencies
        for (char ch : str.toCharArray()) {
            int count = charFreqMap.getOrDefault(ch, 0) + 1;
            charFreqMap.put(ch, count);
        }

        // Find the maximum frequency
        int maxFreq = 0;
        for (Map.Entry<Character, Integer> entry : charFreqMap.entrySet()) {
            maxFreq = Math.max(maxFreq, entry.getValue());
        }

        // Find the second maximum frequency
        int secondMaxFreq = 0;
        boolean secondMaxFound = false;
        for (Map.Entry<Character, Integer> entry : charFreqMap.entrySet()) {
            if (entry.getValue() == maxFreq) {
                continue;
            }
            if (!secondMaxFound || entry.getValue() > secondMaxFreq) {
                secondMaxFreq = entry.getValue();
                secondMaxFound = true;
            }
        }

        // Find the character with the second maximum frequency
        char secondMostFrequentChar = '\0';
        for (Map.Entry<Character, Integer> entry : charFreqMap.entrySet()) {
            if (entry.getValue() == secondMaxFreq) {
                secondMostFrequentChar = entry.getKey();
                break;
            }
        }

        return secondMostFrequentChar;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();

        char secondMostFrequentChar = findSecondMostFrequentCharacter(str);
        System.out.println("Second most frequent character: " + secondMostFrequentChar);
    }
}

