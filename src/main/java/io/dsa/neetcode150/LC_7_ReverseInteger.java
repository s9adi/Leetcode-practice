package io.dsa.neetcode150;

public class LC_7_ReverseInteger {
    public static void main(String[] args) {

    }

    private static int Solution(int x) {
        int res = 0;
        boolean isNeg = x < 0;
        String value = String.valueOf(Math.abs(x));
        StringBuilder reversed = new StringBuilder(value).reverse();
        try {
            res = Integer.parseInt(reversed.toString());
        } catch (NumberFormatException num) {
            return 0;
        }
        return isNeg ? -res : res;
    }
}
