import java.util.Arrays;
import java.util.HashMap;

public class isUnique {

    // Approach 1: Using external data structures
    // Method 1: Using a boolean array
    public static boolean isUniqueBooleanArray(String str) {
        if (str.length() > 128) return false;

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    /* Time Complexity: O(n), where n is the length of the string.
    We iterate over the string one time. You could also argue that it's O(1), since the loop will never go beyond 128. */

    // Space Complexity: O(1). Fixed-size array of 128 booleans (ASCII).

    // Method 2: Using a hash map
    public static boolean isUniqueHashMap(String str) {
        if (str == null || str.length() <= 1) return true;

        HashMap<Character, Boolean> charMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (charMap.containsKey(c)) {
                return false;
            }
            charMap.put(c, true);
        }
        return true;
    }

    // Time Complexity: O(n), where n is the length of the string. HashMap operations are O(1) average time.
    // Space Complexity: O(n). In worst case, all characters are unique and stored.

    // Approach 2: Without using additional data structures
    // Method 1: Brute force using two loops
    public static boolean isUniqueBruteForce(String str) {
        if (str == null || str.length() <= 1) return true;

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    // Time Complexity: O(n^2), where n is the length of the string. Compares every character to every other character.
    // Space Complexity: O(1). No extra space used.

    // Method 2: Sorting first
    public static boolean isUniqueSorting(String str) {
        if (str == null || str.length() <= 1) return true;

        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);

        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] == charArray[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // Time Complexity: O(n log n), due to sorting the character array.
    // Space Complexity: O(n), because Arrays.sort creates a copy of the array.

    // Method 3: Bit vector (only valid for lowercase a–z)
    public static boolean isUniqueBitVector(String str) {
        if (str == null || str.length() <= 1) return true;

        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if (val < 0 || val > 25) return false; // Only supports lowercase a-z

            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

    // Time Complexity: O(n), where n is the length of the string. We check and set a bit for each character.
    // Space Complexity: O(1). Uses a single int (bitmask) for storage.

    public static void main(String[] args) {
        String input = "is quick brown fox";

        System.out.println("Testing input: \"" + input + "\"\n");

        System.out.println("Boolean Array: " + isUniqueBooleanArray(input));
        System.out.println("HashMap:       " + isUniqueHashMap(input));
        System.out.println("Brute Force:   " + isUniqueBruteForce(input));
        System.out.println("Sorting:       " + isUniqueSorting(input));
        System.out.println("Bit Vector:    " + isUniqueBitVector(input)); // Will return false (includes space and non-lowercase)
    }
}

// Things to note for this problem:
/* You should ask your interviewer if the string is ASCII or Unicode. ASCII is a subset of Unicode,
the first 128 characters are identical. ASCII characters are 7-bit(original) or 8-bit(extended). Unicode characters 
are 8-bit, 16-bit, 32-bit. */
