// Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?

import java.util.Arrays;
import java.util.HashMap;

public class isUnique {
    // Approach 1: Using external data structures
    // Method 1: Using a boolean array
    public boolean isUniqueBooleanArray(String str) {
        if (str.length() > 128) return false;
        
        boolean[] char_set = new boolean[128];
        for (int i = 0; i <str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }       
        return true;
    }
    // Time Complexity: O(n), where n is the length of the string. We iterate over the string one time. You could also argue that the Time Complexity is O(1),
    // since the for loop will never iterate over more than 128 characters. 

    // Space complexity: O(1). 

    // Approach 1: Using external data structures
    // Method 2: Using a hash set
    public boolean isUniqueHashSet(String str) {
        if (str == null || str.length() == 1){
            return true;
        }

        HashMap<Character, Boolean> charMap = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (charMap.containsKey(c)) {
                return false;
            } else {
                charMap.put(c, true);
            }
        }
        return true;
    }
    // Time Complexity: O(n), where n is the length of the string. We iterate over the string one time.
    // Hash map operations insertion and lookup run in O(1).

    // Space complexity: O(n). In the worst case scenario (all unique characters), the hash map stores at 
    // most n characters.  

    // Approach 2: Without using external data structures
    // Method 1: Using two for loops
    public boolean isUniqueBruteForce(String str) {
        if (str == null || str.length() <= 1){
            return true;
        }

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false; 
                }
            }
        }
        return true;
    }
    // Time Complexity: O(n^2), where n is the length of the string. In the worst case, the function will compare each character to all the ones after it.

    // Space complexity: O(1). This method does not use any extra data structures (like HashMap or HashSet), only two integer variables.

    // Approach 2: Without using external data structures
    // Method 2: Sorting
    public boolean isUniqueSorting(String str) {
        if (str == null || str.length() <= 1){
            return true;
        }
        
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);

   
        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] == charArray[i + 1]) {
                return false;
            }
        }

        return true;
    }
    // Time Complexity: Sorting takes O(n log n) using Timsort (used in Arrays.sort() for primitive types). The for loop runs in O(n)
    // time. 

    // Space complexity: O(n). In the worst case scenario, space complexity is O(n), though it could be 
    // O(1) if an in-place sorting algorithm is used. No external data structures used.

    // Approach 2: Without using external data structures
    // Method 3: Bit vector
    public boolean isUniqueBitVector(String str) {
        if (str == null || str.length() <= 1){
            return true;
        }
        
        int checker = 0;

        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a'; // Convert character to a bit index (0-25)

            if ((checker & (1 << val)) > 0) {
                return false; // Duplicate character found
            }

            checker |= (1 << val); // Mark this character as seen
        }

        return true; // No duplicates found
    }
}
    // Time Complexity: We iterate over the string once, O(n). Each operation (&, |, <<) runs in constant time, O(1).

    // Space complexity: O(1). We only use one integer (int checker) → constant space, O(1). Most space-efficient approach 
    // if input is only lowercase letters. No external data structures used. 

// Things to note for this problem:
// You should ask your interviewer if the string is ASCII or Unicode. ASCII is a subset of Unicode,
// the first 128 characters are identical. ASCII characters are 7-bit(original) or 8-bit(extended). Unicode characters 
// are 8-bit, 16-bit, 32-bit. 
