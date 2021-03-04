import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * You probably know that some characters written on a piece of paper,
 * after turning this sheet 180 degrees, can be read,
 * although sometimes in a different way.
 * So, uppercase letters "H", "I", "N", "O", "S", "X", "Z" after rotation are not changed,
 * the letter "M" becomes a "W", and Vice versa, the letter "W" becomes a "M".
 * <p>
 * We will call a word "shifter" if it consists only of letters "H", "I", "N", "O", "S", "X", "Z", "M" and "W".
 * After turning the sheet, this word can also be read,
 * although in a different way. So, the word "WOW "turns into the word "MOM".
 * On the other hand, the word "HOME" is not a shifter.
 * <p>
 * Find the number of unique shifter words in the input string (without duplicates).
 * String contains only uppercase letters.
 * <p>
 * Examples
 * Shifter.count("SOS IN THE HOME") == 2 // shifter words are "SOS" and "IN"
 * Shifter.count("WHO IS SHIFTER AND WHO IS NO") == 3 // shifter words are "WHO", "IS", "NO"
 * Shifter.count("TASK") == 0 // no shifter words
 * Shifter.count("") == 0 // no shifter words in empty string
 */


public class ShifterWords {

    public static void main(String[] args) {
        String st = "WHO IS WHO";

        System.out.println(count2(st));
    }

    public static int count(String st) {

        String[] wordsFromString;
        wordsFromString = st.split(" ");
        Set<String> words = new HashSet<>(Arrays.asList(wordsFromString));
        int numberOfShifterInString = 0;
        for (String s : words) {
            if (st.equals("")) {
                return 0;
            } else if (s.matches("[HIMNOSWXZ]*")) {
                numberOfShifterInString++;
            }
        }
        System.out.println(words);
        return numberOfShifterInString;
    }

    public static int count2(String st) {
        return (int) Stream.of(st.split(" ")).distinct().filter(w -> w.matches("[HIMNOSWXZ]*")).count();
    }

    public static int count3(String str) {
        return str.length() == 0 ? 0 : (int) Arrays.stream(str.split(" "))
                .distinct().filter(a -> a.replaceAll("[MWHINOSXZ]", "")
                        .length() == 0).count();
    }
}
