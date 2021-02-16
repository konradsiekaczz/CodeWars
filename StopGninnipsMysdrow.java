import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Write a function that takes in a string of one or more words, and returns the same string,
 * but with all five or more letter words reversed (Just like the name of this Kata).
 * Strings passed in will consist of only letters and spaces.
 * Spaces will be included only when more than one word is present.
 * <p>
 * Examples:
 * <p>
 * spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw"
 * spinWords( "This is a test") => returns "This is a test"
 * spinWords( "This is another test" )=> returns "This is rehtona test"
 */


public class StopGninnipsMysdrow {

    public static void main(String[] args) {

        String s = "Hey fellow warriors";

        System.out.println(spinWords(s));
    }

    public static String spinWords(String sentence) {
        String[] words = sentence.split(" ");
        String[] reverseWords = new String[words.length];
        String newSentence = "";
        int index = 0;
        for (String word : words) {
            StringBuilder sb = new StringBuilder(word);
            if (sb.length() >= 5) {
                sb.reverse();
                reverseWords[index] = sb.toString();
            } else {
                reverseWords[index] = word;
            }
            index++;
            newSentence += sb.toString() + " ";
        }
        return newSentence.trim();
    }

    public static String spinWords1(String sentence) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() >= 5) {
                words[i] = new StringBuilder(words[i]).reverse().toString();
            }
        }
        return String.join(" ", words);
    }

    public static String spinWords2(String sentence) {
        return Arrays.stream(sentence.split(" "))
                .map(i -> i.length() >= 5 ? new StringBuilder(i).reverse().toString() : i)
                .collect(Collectors.joining(" "));
    }
}
