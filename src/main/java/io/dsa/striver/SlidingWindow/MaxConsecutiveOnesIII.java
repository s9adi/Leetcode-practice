package io.dsa.striver.SlidingWindow;

public class MaxConsecutiveOnesIII {
    /*
    I am allowed to flip k 0s
     */

    public static void main(String[] args) {
        BruteForce(new int[]{1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1}, 2);
    }

    static void BruteForce(int[] arr, int k) {
        int maxLen = 0;
        int rightP = 0;
        int leftP = 0;
        int flip = 0;
        int currentLen = 0;

        while (rightP < arr.length && leftP <= rightP && leftP < arr.length) {

            while (flip > k && leftP < arr.length) {
                if(arr[leftP] == 0){
                    flip--;
                }
                leftP = leftP + 1;
            }

            if (arr[rightP] == 0 ){
                flip= flip+1;
                currentLen = rightP-leftP + 1;
            }
            rightP++;
            maxLen = Math.max(currentLen , maxLen);

        }

        System.out.println("MaxLen - " + maxLen);
    }
}
