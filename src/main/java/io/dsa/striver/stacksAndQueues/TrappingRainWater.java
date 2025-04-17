package io.dsa.striver.stacksAndQueues;

public class TrappingRainWater {

    /*
    we have to figure out the total units of water stored in the building
    we have to check the total water stored on top of the building of each building and sum it
    the water will be store only if there is a taller building to the left and right
    and the building (taller one) to each side should not have the taller building
    the height of water is the lower of the heights

    we use prefix max and suffix max concept here

    */

    public static void main(String[] args) {

    }
    public static void Solution(int[] heights) {
        // height = [4,2,0,3,2,5]

        int sum = 0;

        int prefix[] = new int[heights.length];
        prefix[0] = heights[0];

        int suffix[] = new int[heights.length];
        suffix[heights.length - 1] = heights[heights.length - 1];

        // prefix is the max height from a particular location
        for (int i = 1; i < heights.length; i++) {
            prefix[i] = Math.max(prefix[i - 1], heights[i]);
        }

        // suffix is the max height from a particular location
        for (int i = heights.length - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i + 1], heights[i]);
        }

        // sum of the areas -> area of the cube is 1 * ((Min(prefix and suffix)) - height)
        for (int i = 0; i < heights.length; i++) {
            sum += Math.min(suffix[i], prefix[i]) - heights[i];
        }

        System.out.println("Total trapped water: " + sum);
    }

    /*
    I always need the smaller one either the leftmax or the rightmax whichever one is the smaller one
     */

}

class TUF_Rainwater {
    static int trap(int[] arr) {
        int n = arr.length;
        int waterTrapped = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            int leftMax = 0, rightMax = 0;
            while (j >= 0) {
                leftMax = Math.max(leftMax, arr[j]);
                j--;
            }
            j = i;
            while (j < n) {
                rightMax = Math.max(rightMax, arr[j]);
                j++;
            }
            waterTrapped += Math.min(leftMax, rightMax) - arr[i];
        }
        return waterTrapped;
    }

    public static void main(String args[]) {
        int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("The water trapped is " + trap(arr));
    }
}
