import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Write a function that takes an array of numbers (integers for the tests) and a target number.
 * It should find two different items in the array that, when added together, give the target value.
 * The indices of these items should then be returned in a tuple like so: (index1, index2).
 * For the purposes of this kata, some tests may have multiple answers; any valid solutions will be accepted.
 * The input will always be valid (numbers will be an array of length 2 or greater, and all of the items will be numbers;
 * target will always be the sum of two different items from that array).
 **/

public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
//        System.out.println(Arrays.toString(twoSum(arr, 4)));
        System.out.println(Arrays.toString(twoSum1(arr, 4)));
        System.out.println(Arrays.toString(twoSum2(arr, 4)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] indexes = new int[2];
        int flagOne;
        int flagTwo;
        for (int i = 0; i < numbers.length; i++) {
            flagOne = numbers[i];
            for (int j = 0; j < numbers.length; j++) {
                flagTwo = numbers[j];
                if (flagOne + flagTwo == target) {
                    indexes[0] = i;
                    indexes[1] = j;
                    return indexes;
                }
            }
        }
        return indexes;
    }

    public static int[] twoSum1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] twoSum2(int[] numbers, int target) {
        List<Integer> boxedIntegersFromArray = Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toList());
        for (Integer integer : boxedIntegersFromArray) {
            if (boxedIntegersFromArray.contains(target - integer)) {
                return new int[]{boxedIntegersFromArray.indexOf(integer), boxedIntegersFromArray.indexOf(target - integer)};
            }
        }
        return null;
    }
}
