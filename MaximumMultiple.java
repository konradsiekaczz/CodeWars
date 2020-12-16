package com.konrad;

/*Task
Given a Divisor and a Bound , Find the largest integer N , Such That ,

Conditions :
N is divisible by divisor
N is less than or equal to bound
N is greater than 0.
 */

public class MaximumMultiple {
    public static void main(String[] args) {
        System.out.println(maxMultiple(37,200));
    }
    public static int maxMultiple(int divisor, int bound) {
        while (bound % divisor != 0){
            bound--;
        }
        return bound;
    }
}
