// Given two strings, write a method to decide if one is a permutation of another.

import java.util.Arrays;
import java.util.HashMap;

public class checkPermutation {
    // Approach 1: Sort the Strings
    public boolean checkPermutationSorting (String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        
        }
        return sort(str1) == sort(str2);  
    }
    
    String sort (String s) {
        char [] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
    // Time Complexity: O(n), where n is the length of the string. We iterate over the string one time. You could also argue that the Time Complexity is O(1),
    // since the for loop will never iterate over more than 128 characters. 

    // Space complexity: O(1). 

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

    // Approach 2: Check character counts
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
// A string is a permutation of another string if it fulfills the following conditions: 
// Both have to have the same characters. Both have to have same length. You should ask your interviewer if
// the permutation comparison is case sensitive. You should ask them if whitespace is significant. 
