package io.dsa.striver.Arrays;

public class Stocks {
    public static void main(String[] args) {
        StocksIBetter(new int [] {7,1,5,3,6,4});
    }
    static void StocksIBrute(int[] prices) {
        int maxP = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int profit = 0;
            for (int j = i + 1; j < prices.length; j++) {
                profit = prices[j] - prices[i];
                maxP = Math.max(maxP , profit);
            }
        }
        System.out.println("MaxP " + maxP);
    }
    static void StocksIBetter(int[] arr){
        // always buy on the minimum
        // find the min first and then we can make the profit from there
        int min = arr[0];
        int maxP = Integer.MIN_VALUE;
        int currentP = 0;
        for (int i = 0 ; i < arr.length ; i++){
            min = Math.min(min , arr[i]);
            currentP = arr[i] - min;
            maxP = Math.max(currentP , maxP);
        }

        System.out.println("MaxP " + maxP);
    }
}
