package com.konrad;

public class TrainingOnBitCounting {

    //Write a function that takes an integer as input,
    // and returns the number of bits that are equal to one in the binary representation of that number.
    // You can guarantee that input is non-negative.

    public static void main(String[] args) {
        int number = 7;
        System.out.println(countBits2(number));
    }

    public static int countBits(int n) {
        return Integer.bitCount(n);
    }

    public static int countBits2(int n) {
        int ret = n % 2;
        while ((n /= 2) > 0) {
            ret += n % 2;
        }
        return ret;
    }
}
