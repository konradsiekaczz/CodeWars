package com.konrad;

/*Your goal is to create a function dative() (Dative() in C#)
which returns the valid form of a valid Hungarian word w in dative case i. e.
append the correct suffix nek or nak to the word w based on vowel harmony rules.*/

public class HungarianVowelHarmony {
    public static void main(String[] args) {
        String word = "úr";
        System.out.println(dative(word));
    }

    public static String dative(String word) {
        char[] allVowel = {'e', 'é', 'i', 'í', 'ö', 'ő', 'ü', 'ű', 'a', 'á', 'o', 'ó', 'u', 'ú'};

        for (int i = word.length() - 1; i >= 0; i--) {
            for (int j = 0; j <= allVowel.length - 1; j++) {
                char c = word.charAt(i);
                if (c == allVowel[j] && checkIfContainsBackVowel(c)) {
                    return word + "nak";
                } else if (c == allVowel[j] && checkIfContainsFrontVowel(c)) {
                    return word + "nek";
                }
            }
        }
        return word;
    }

    public static boolean checkIfContainsFrontVowel(char c) {
        char[] frontVowel = {'e', 'é', 'i', 'í', 'ö', 'ő', 'ü', 'ű'};
        for (char c1 : frontVowel) {
            if (c == c1) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkIfContainsBackVowel(char c) {
        char[] backVowel = {'a', 'á', 'o', 'ó', 'u', 'ú'};
        for (char c1 : backVowel) {
            if (c == c1) {
                return true;
            }
        }
        return false;
    }

    public static String dative2(String word) {
        for (int i = word.length() - 1; i >= 0; i--)
        {
            if ("eéiíöőüű".indexOf(word.charAt(i)) > -1)
            {
                return word + "nek";
            }
            if ("aáoóuú".indexOf(word.charAt(i)) > -1)
            {
                return word + "nak";
            }
        }
        return word;
    }

}
