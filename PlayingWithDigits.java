import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Some numbers have funny properties. For example:
 * <p>
 * 89 --> 8¹ + 9² = 89 * 1
 * <p>
 * 695 --> 6² + 9³ + 5⁴= 1390 = 695 * 2
 * <p>
 * 46288 --> 4³ + 6⁴+ 2⁵ + 8⁶ + 8⁷ = 2360688 = 46288 * 51
 * <p>
 * Given a positive integer n written as abcd... (a, b, c, d... being digits) and a positive integer p
 * we want to find a positive integer k, if it exists,
 * such as the sum of the digits of n taken to the successive powers of p is equal to k * n.
 * In other words:
 * <p>
 * Is there an integer k such as : (a ^ p + b ^ (p+1) + c ^(p+2) + d ^ (p+3) + ...) = n * k
 * <p>
 * If it is the case we will return k, if not return -1.
 * <p>
 * Note: n and p will always be given as strictly positive integers.
 */

public class PlayingWithDigits {

    public static void main(String[] args) {
        System.out.println(getDigitsFromNumber(534));
        System.out.println(digPow(46288, 3));
    }

    public static long digPow(int n, int p) {
        int sum =0;
        ArrayList<Integer> digits= (ArrayList<Integer>) getDigitsFromNumber(n);
        for (int i = 0; i < getDigitsFromNumber(n).size(); i++) {
            sum+= Math.pow(digits.get(i),p+i);
        }
        int k = sum/n;

        if (k*n == sum){
            return k;
        }
        return -1;
    }

    private static List<Integer> getDigitsFromNumber(int n) {
        List<Integer> listOfDigits = new ArrayList<>();
        while (n > 0) {
            listOfDigits.add(n % 10);
            n /= 10;
        }
        Collections.reverse(listOfDigits);
        return listOfDigits;
    }

}
