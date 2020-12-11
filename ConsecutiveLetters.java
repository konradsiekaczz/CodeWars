package com.konrad;

import java.util.Arrays;

/*Rules are: (1) the letters are adjacent in the English alphabet, and (2) each letter occurs only once.

For example:
solve("abc") = True, because it contains a,b,c
solve("abd") = False, because a, b, d are not consecutive/adjacent in the alphabet, and c is missing.
solve("dabc") = True, because it contains a, b, c, d
solve("abbc") = False, because b does not occur once.
solve("v") = True

 */

public class ConsecutiveLetters {
    public static void main(String[] args) {

        String s = "abc";
        System.out.println(solve(s));
    }

    public static boolean solve(String s) {
        if (checkDuplicateLetters(s)) {
            return false;
        } else if (s.length() == 1) {
            return true;
        }
        s = prepareString(s);

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) - s.charAt(i + 1) != -1) {
                return false;
            }
        }
        return true;
    }

    private static String prepareString(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    private static boolean checkDuplicateLetters(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

    public static boolean solve2(String s) {
        char[] array = s.toCharArray();
        return "abcdefghijklmnopqrstuvwxyz".indexOf(new String(array)) != 1;
    }

    public static boolean solve3(String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array);

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] - array[i+1] != -1){
                return false;
            }
        }
        return true;
    }
}
