import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/*Simple enough this one - you will be given an array.
The values in the array will either be numbers or strings, or a mix of both.
You will not get an empty array, nor a sparse one.

Your job is to return a single array that has first the numbers sorted in ascending order,
followed by the strings sorted in alphabetic order. The values must maintain their original type.

Note that numbers written as strings are strings and must be sorted with the other strings.*/

public class DoubleSort {

    public static Object[] dbSort(Object[] a) {

        Object[] objects;
        List<Object> integers = new ArrayList<>();
        List<Object> strings = new ArrayList<>();

        addElementFromArrayToList(a, integers, strings);

        integers = integers.stream().sorted().collect(Collectors.toList());
        strings = strings.stream().sorted().collect(Collectors.toList());

        integers.addAll(strings);
        objects = integers.stream().toArray();

        return objects;
    }

    private static void addElementFromArrayToList(Object[] a, List<Object> integers, List<Object> strings) {
        for (int i = 0; i < a.length; i++) {
            if (a[i].getClass().equals(Integer.class)) {
                integers.add(a[i]);
            } else {
                strings.add(a[i]);
            }
        }
    }

    public static Object[] dbSort1(Object[] a) {
        return Stream.concat(Arrays.stream(a).filter((x) -> x instanceof Number).map((x) -> (Number) x).sorted(),
                Arrays.stream(a).filter((x) -> x instanceof String).map((x) -> (String) x).sorted()).toArray();
    }
k
    public static Object[] dbSort2(Object[] a) {
        Stream b = Stream.of(a).filter(Integer.class::isInstance).sorted();
        Stream c = Stream.of(a).filter(String.class::isInstance).sorted();
        return Stream.concat(b, c).toArray();
    }
}
