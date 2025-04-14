/* Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient
space at the end to hold the additional characters, and that you are given the 'true' length of the string. (Note: If implementing)
in Java, please use a character array so you can perform the operations in place). */

/*
Ex: 
Input: "Mr John Smith    ", 13
Output: "Mr%20John%20SMith"
*/

public class URLify {

    public static void replaceSpaces (char[] str, int realLength) {
        if (str.length == 0) {
            return;
        }

        int spaceCount = 0;
        for (int i = 0; i < realLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }

        int index = realLength + spaceCount * 2;
        if (index > str.length) {
            return;
        }
        for (int i = realLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }          
        }
        System.out.println(String.valueOf(str));
    }
    public static void main (String[] args) {
        char[] input = "Hello World!  ".toCharArray();
        replaceSpaces (input, 11);
    } 
}
// Time Complexity: O(n), where n is the length of the string.
// Space Complexity: O(1), no additional data space required, only a few variables.
