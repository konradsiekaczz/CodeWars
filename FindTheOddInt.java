/*Given an array of integers, find the one that appears an odd number of times.

There will always be only one integer that appears an odd number of times.*/


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindTheOddInt {

    public static void main(String[] args) {
        int[] a = {1,1,2,-2,5,2,4,4,-1,-2,5};


        System.out.println(findIt(a));
    }

    public static int findIt(int[] a) {
        int odd;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            odd = a[i];
            for (int j = 0; j < a.length; j++) {
                if (a[i] == a[j]){
                    count++;
                }
            }
            if (count%2 != 0){
                return odd;
            }
        }
        return 0;
    }
}
