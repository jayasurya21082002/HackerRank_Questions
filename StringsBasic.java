package HacherRank_Algorithms;

import java.util.*;

public class StringsBasic {
    public static void main(String[] args) {
        String str = "abcdc";
        String str2 = "aberh";
        ArrayList<String> arr = new ArrayList<>();
        arr.add("abcdde");
        arr.add("baccd");
        arr.add("eeabg");
        //System.out.println(gemstones(arr));
        System.out.println(makingAnagram(str,str2));
    }

    //CamelCase
    public static int CamelCase(String s) {
        int numberOfWords = 0;                  //count of the words
        for (int i = 0; i < s.length(); i++) { //runs the loop character by character in a string
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {                // finds the number of capital words im a string
                numberOfWords++;
            }
        }
        numberOfWords = numberOfWords + 1;         //this 1 was the first word which starts by small letter
        return numberOfWords;
    }

    public static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        int missingChars = 0;
        String specialCharacters = "!@#$%^&*()-+";
        boolean hasNumber = false;
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length() && (!hasNumber || !hasLower || !hasUpper || !hasSpecial); i++) {
            if (!hasUpper) {
                hasUpper = Character.isUpperCase(password.charAt(i));
            }
            if (!hasLower) {
                hasLower = Character.isLowerCase(password.charAt(i));
            }
            if (!hasNumber) {
                hasNumber = Character.isDigit(password.charAt(i));
            }
            if (!hasSpecial && specialCharacters.indexOf(password.charAt(i)) != -1) {
                hasSpecial = true;
            }
        }
        if (!hasNumber) missingChars++;
        if (!hasLower) missingChars++;
        if (!hasUpper) missingChars++;
        if (!hasSpecial) missingChars++;

        if (password.length() < 6) {
            if (6 - password.length() > missingChars) {
                missingChars = 6 - password.length();
            }
        }
        return missingChars;
    }

    //Caesar Cipher
    public static String caesarCipher(String s, int k) {
        StringBuilder encrypted = new StringBuilder();

        for (char c : s.toCharArray()) { //loops every character in the string
            if (Character.isLetter(c)) {    //returns the Ascii code of the given character
                char base = Character.isLowerCase(c) ? 'a' : 'A';  //checks whether which base is used as character returned
                char encryptedChar = (char) (base + (c - base + k) % 26); //
                encrypted.append(encryptedChar);
            } else {
                encrypted.append(c);
            }
        }

        return encrypted.toString();
    }

    //Mars Exploration
    public static int findDifferentLetters(String s) {      // counts the characters which does not match the sos message
        int count = 0;
        if (s.charAt(0) != 'S') {
            count++;
        }
        if (s.charAt(1) != 'O') {
            count++;
        }
        if (s.charAt(2) != 'S') {
            count++;
        }
        return count;
    }

    public static int marsExploration(String s) {
        int ans = 0;
        for (int i = 0; i <= s.length() - 3; i = i + 3) {            //checks the string with index + 3
            if (!s.substring(i, i + 3).equals("SOS")) {             // if it is not equal then executes the condition
                ans += findDifferentLetters(s.substring(i, i + 3)); //count of the mismatched characters
            }
        }
        return ans;
    }

    //Hackerrank in a String
    public static String hackerrankInString(String s) {
        // Write your code here
        String target = "hackerrank";      // finds the given string whether the characters lies on that string
        int targetIdx = 0;

        for (char c : s.toCharArray()) {    // runs the loop by checking every character in the given string
            if (c == target.charAt(targetIdx)) {  //if character from target matches the string then moves forward.
                targetIdx++;
                if (targetIdx == target.length()) { // if the whole target has been checked in given string it returns YES
                    return "YES";
                }
            }
        }

        return "NO";                          //if it false it returns no

    }

    //Pangrams
    public static String pangrams(String s) {
        s = s.toLowerCase();
        boolean[] alphabetPresence = new boolean[26];// Create a boolean array to track the presence of each letter
        for (char c : s.toCharArray()) {             // Iterate through the string and mark the presence of each letter
            if (Character.isLetter(c)) {
                int index = c - 'a';                 // Calculate the index of the letter in the alphabet
                alphabetPresence[index] = true;
            }
        }
        for (boolean present : alphabetPresence) {   // Check if all letters are present
            if (!present) {
                return "not pangram";
            }
        }
        return "pangram";
    }

    //Separate the numbers              //not prepared
    private static boolean isBeautifulSequence(String s, long firstNumber) {
        String sequence = Long.toString(firstNumber);
        long nextNumber = firstNumber + 1;

        while (sequence.length() < s.length()) {
            sequence += nextNumber;
            nextNumber++;
        }

        return sequence.equals(s);
    }

    public static void separateNumbers(String s) {
        int n = s.length();
        boolean isValid = false;
        long firstNumber = -1;

        for (int i = 1; i <= n / 2; i++) {
            long num = Long.parseLong(s.substring(0, i));

            if (isBeautifulSequence(s, num)) {
                isValid = true;
                firstNumber = num;
                break;
            }
        }

        if (isValid) {
            System.out.println("YES " + firstNumber);
        } else {
            System.out.println("NO");
        }

    }

    //Funny String
    public static String funnyString(String s) {
        String reversed = new StringBuilder(s).reverse().toString();

        for (int i = 1; i < s.length(); i++) {
            int diffS = Math.abs(s.charAt(i) - s.charAt(i - 1));
            int reverseDiff = Math.abs(reversed.charAt(i) - reversed.charAt(i - 1));

            if (diffS != reverseDiff) {
                return "not funny";
            }
        }
        return "Funny";
    }

    //GemStones
    public static int gemstones(List<String> arr) {
        int n = arr.size();
        Set<Character> gemstonesSet = new HashSet<>();

        for (char mineral : arr.get(0).toCharArray()) {
            gemstonesSet.add(mineral);
        }

        for (int i = 1; i < n; i++) {
            Set<Character> currentRockMinerals = new HashSet<>();
            for (char mineral : arr.get(i).toCharArray()) {
                currentRockMinerals.add(mineral);
            }
            gemstonesSet.retainAll(currentRockMinerals);
        }
        return gemstonesSet.size();
    }

    //Alternating Characters
    public static int alternatingCharacters(String s) {
        int deletions = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                deletions++;
            }
        }
        return deletions;
    }

    //Beautiful Binary String
    public static int beautifulBinaryString(String s) {
        int minSteps = 0;
        int index = 0;

        while (index < s.length() - 2) {
            if (s.charAt(index) == '0' && s.charAt(index + 1) == '1' && s.charAt(index + 2) == '0') {
                minSteps++;
                index += 3;
            } else {
                index++;
            }
        }
        return minSteps;
    }

    // A Love Letter Mystery
    public static int loveLetterMystery(String s) {
        int querys = 0;
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            int left = s.charAt(i);
            int right = s.charAt(n - i - 1);
            querys += Math.abs(left - right);
        }
        return querys;
    }

    //palindrome index

    public static int palindromeIndex(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (isPalindrome(s, left + 1, right)) {
                    return left;
                } else if (isPalindrome(s, left, right - 1)) {
                    return right;
                } else {
                    return -1;
                }
            }
            left++;
            right--;
        }
        return -1;
    }

    public static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    //Anagram
    public static int anagram(String s) {
        if (s.length() % 2 != 0) {
            return -1;
        }
        int[] frequency = new int[26];
        for (int i = 0; i < s.length() / 2; i++) {
            frequency[s.charAt(i) - 1]++;
        }
        for (int i = s.length() / 2; i < s.length(); i++) {
            frequency[s.charAt(i) - 1]--;
        }
        int changes = 0;
        for (int freq : frequency) {
            if (freq > 0) {
                changes += freq;
            }
        }
        return changes;
    }

    //Making Anagrams

    public static int makingAnagram(String s1, String s2) {
        Map<Character,Integer> frequencyMap = new HashMap<>();
        for(char c : s1.toCharArray()) {                      //calculates the frequency of String 1
            frequencyMap.put(c, frequencyMap.getOrDefault(c,0) + 1);
        }
        for( char c : s2.toCharArray()) {                     //calculate the frequency of the String 2
            frequencyMap.put(c, frequencyMap.getOrDefault(c,0) - 1);
        }

        int deletions =0;                                     //calculates the elements to be deleted
        for( int  freq : frequencyMap.values()){
            deletions += Math.abs(freq);
        }
        return  deletions;
    }

    //Game Of Thrones - 1
    public static String gameOfThrones(String s) {
        // Count the frequencies of characters in the string
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Count the number of characters with odd frequencies
        int oddCount = 0;
        for (int freq : frequencyMap.values()) {
            if (freq % 2 != 0) {
                oddCount++;
            }
        }

        // If there's more than one character with odd frequency, it's not possible to form a palindrome
        if (oddCount > 1) {
            return "NO";
        }

        return "YES";

    }

    // Two String
    public static String twoStrings(String s1, String s2) {
        // Write your code here
        Set<Character> s1Chars = new HashSet<>();

        // Store the characters of the first string in a set
        for (char c : s1.toCharArray()) {
            s1Chars.add(c);
        }

        // Check if any character of the second string is present in the set
        for (char c : s2.toCharArray()) {
            if (s1Chars.contains(c)) {
                return "YES";
            }
        }

        return "NO";
    }

    //String Construction
    public static int stringConstruction(String s) {
        // Write your code here
        // The minimum cost is equal to the number of distinct characters in the string
        int cost = 0;
        boolean[] visited = new boolean[26]; // Assuming lowercase English letters

        for (char c : s.toCharArray()) {
            if (!visited[c - 'a']) {
                visited[c - 'a'] = true;
                cost++;
            }
        }

        return cost;

    }

}