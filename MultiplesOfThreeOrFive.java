import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class MultiplesOfThreeOrFive {

    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution1(10));
    }

    public static int solution(int number) {
        Set<Integer> listOfMultiples = new HashSet<>();
        int multiplesOf3;
        int multiplesOf5;
        for (multiplesOf3 = 3; multiplesOf3 < number; multiplesOf3 += 3) {
            listOfMultiples.add(multiplesOf3);
        }

        for (multiplesOf5 = 5; multiplesOf5 < number; multiplesOf5 += 5) {
            listOfMultiples.add(multiplesOf5);
        }
        int sum = listOfMultiples.stream().mapToInt(Integer::intValue).sum();
        return sum;
    }

    public static int solution1(int number) {
        int sum = 0;

        for (int i = 0; i < number; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static int solution3(int number) {
        return IntStream.range(0, number)
                .filter(n -> (n % 3 == 0) || (n % 5 == 0))
                .sum();
    }
}
