package io.dsa.neetcode150.TwoPointer;

public class LC_11_Container {
    public static void main(String[] args) {
        Solution(new int[]{1,8,6,2,5,4,8,3,7});
    }

    private static void Solution(int[] array) {
        // height = [1,8,6,2,5,4,8,3,7]
        int maxArea = Integer.MIN_VALUE;
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int h = Math.min(array[left], array[right]);
            int w = right - left;
            int area = h * w;
            if(array[left] > array[right]){
                right--;
            }else {
                left++;
            }
            maxArea = Math.max(area, maxArea);
        }
        System.out.println(maxArea);
    }
}
