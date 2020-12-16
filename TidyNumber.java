package com.konrad;

public class TidyNumber {

    public static void main(String[] args) {
        System.out.println(tidyNumber(12));
    }

    public static boolean tidyNumber(int number) {
        String num = "" + number;
        char[] charArray = num.toCharArray();

        for (int i = 0; i+1 < charArray.length;  i++) {
            if ((int) charArray[i] > (int) charArray[i + 1]){
                return false;
            }
        }
        return true;
    }
}
