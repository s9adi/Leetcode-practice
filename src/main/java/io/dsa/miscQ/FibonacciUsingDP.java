package io.dsa.miscQ;

public class FibonacciUsingDP {
    public static void main(String[] args) {
        int x = usingDP(6);
        System.out.println(x);
    }

    private static int UsingRecursion(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return UsingRecursion(n - 1) + UsingRecursion(n - 2);
    }

    private static int usingDP(int n){
        int[] dp = new int[n+1];
        dp[0] = 0 ;
        dp[1] = 1;

        for (int i = 2 ; i <= n ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
