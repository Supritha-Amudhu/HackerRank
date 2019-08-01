package com.string;

public class LongestSubstringWORepeatingChar {

    StringBuilder longestSubstring;

    LongestSubstringWORepeatingChar() {
        longestSubstring = new StringBuilder();
    }

    void findLongestSubstring(String str) {
        StringBuilder string = new StringBuilder(str);
        StringBuilder longest = new StringBuilder();
        int length = string.length();
        System.out.println("Total length of input string: "+length);
        int i = 0;
        for(int j=i;j<length;j++) {
            System.out.println("i: "+i + " j: "+j);
            String currentChar = String.valueOf(string.charAt(j));
            System.out.println("Current char: "+currentChar);
            if(longest.indexOf(currentChar) != -1) {
                System.out.println(currentChar + " is already in longest.");
                if(longest.length() > longestSubstring.length()) {
                    System.out.println("longest > longestSubstring");
                    System.out.println("longest: "+longest);
                    longestSubstring = new StringBuilder(longest);
                    System.out.println("New Longest Substring: "+longestSubstring);
                }
                i = i + longest.indexOf(currentChar)+1;
                System.out.println("i is now the index of char " + currentChar + " + 1: "+i);
                longest = new StringBuilder(string.subSequence(i, j));
                System.out.println("longest is now: "+longest);
            }
            longest.append(currentChar);
            System.out.println("Appending "+currentChar+ " to longest: "+longest);
        }
        if(longestSubstring.length() == 0) {
            longestSubstring = new StringBuilder(str);
        }
        if(longest.length() > longestSubstring.length()) {
            longestSubstring = new StringBuilder(longest);
        }
        System.out.println("Final longest substring: "+longestSubstring);
    }

    public static void main(String[] args) {
//        String str = "aab";
        String str = "dabcabcabceee";
//        StringBuilder str1 = new StringBuilder(str);
//        str1 = new StringBuilder(str1.subSequence(2, 5));
//        System.out.println(str1);
        LongestSubstringWORepeatingChar longest = new LongestSubstringWORepeatingChar();
        longest.findLongestSubstring(str);
    }
}
