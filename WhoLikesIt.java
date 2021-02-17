import java.util.HashMap;
import java.util.Map;

/**
 * You probably know the "like" system from Facebook and other pages.
 * People can "like" blog posts, pictures or other items.
 * We want to create the text that should be displayed next to such an item.
 *
 * Implement a function likes :: [String] -> String, which must take in input array,
 * containing the names of people who like an item.
 * It must return the display text as shown in the examples:
 */

public class WhoLikesIt {
    public static void main(String[] args) {
        System.out.println(whoLikesIt("Alex", "Mark", "Jacob"));
    }


    public static String whoLikesIt(String... names) {
        if (names.length == 0) {
            return "no one likes this";
        } else if (names.length == 1) {
            return names[0] + " likes this";

        } else if (names.length == 2) {
            return names[0] + " and " + names[1] + " like this";

        } else if (names.length == 3) {
            return names[0] + ", " + names[1] + " and " + names[2] + " like this";
        } else {
            String numberOfRestNames = String.valueOf(names.length - 2);

            return names[0] + ", " + names[1] + " and " + numberOfRestNames + " others like this";
        }
    }

    public static String whoLikesIt1(String... names) {
        switch (names.length) {
            case 0:
                return "no one like this";
            case 1:
                return names[0] + " likes this";
            case 2:
                return names[0] + " and " + names[1] + " like this";
            case 3:
                return names[0] + ", " + names[1] + " and " + names[2] + " like this";
            default:
                String numberOfRestNames = String.valueOf(names.length - 2);
                return names[0] + ", " + names[1] + " and " + numberOfRestNames + " others like this";
        }
    }


    private static Map<Integer, String> choices = new HashMap<>();

    static {
        choices.put(0, "no one likes this");
        choices.put(1, "%s likes this");
        choices.put(2, "%s and %s like this");
        choices.put(3, "%s, %s and %s like this");
    }

    public static String whoLikesIt3(String... names) {
        int numberOfNames = names.length;

        return numberOfNames <= 3 ?
                String.format(choices.get(numberOfNames), names) :
                String.format("%s, %s and %s others like this", names[0], names[1], numberOfNames - 2);
    }
}
