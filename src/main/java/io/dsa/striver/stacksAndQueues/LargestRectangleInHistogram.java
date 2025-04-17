package io.dsa.striver.stacksAndQueues;

import java.sql.SQLOutput;
import java.util.Stack;

public class LargestRectangleInHistogram {
    /*
    We are given histogram and we have to return the area of the largest rectangle that can be formed.
    My intuition or approach -> that we get the max area for the particular rectangle
    for to find the area we have to multiply the height * breadth
    this breadth needs to be calculated by checking if there is consecutive tower with same height at right or right
    now we have to create 2 different arrays containing the left consecutive element with similar or more height

    what are we going to store in the arrays -> we are going to store the last index having more or equal height \
    and then we can just subtract to get the breadth

    Striver - > for a particular element height i can go till the shorter element is encountered
    so i have to form an array of nse and pse
    we have to get the previous smaller element index and the next smallest element index and then subtract them to get the breadth
     */
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        Optimized(heights);
        BruteForce(heights);
    }

    private static int Optimized(int[] heights) {
/*
I can do the PSE on fly while traversing but i cannot do NSE since i have not visited them
I will calculate the pse as it is but while coming back will calc nse
What is coming back
When we calculate PSE we put the elements new elements that are greater than the pse of the previous elements in the stack
and when we find a element say 2 whose pse is not in the top that means that is not there in the stack , we kick out that pse
untill we find the element that is smaller than the current (that is one) or -1 in case it does not exist
So while coming back that is removing the elements from the stack we can just calculate the nse, nse for 6 (which we are removing is 2)
then nse for 5 is also 2 and for one we dont have any , while coming back we can compute the area and update maxArea too.

so basically we compute nse while removing that element , and if the elements are left in stack that is we have not touched them yet
that means there is no nse for them take the hypothetical index that is len of the array

 */
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int element = 0;
        int nse = 0;
        int pse = 0;

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                element = heights[stack.peek()]; // the element that we are going to remove , or the index ???
                stack.pop();
                nse = i;
                pse = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(element * (nse - pse - 1), maxArea);
            }
            stack.push(i);
        }

        /*
        Now the elements that are there in the stack they have not been touched , these elements dont have nse
        because if there had been an nse for a particular element that would have been popped
        element = stack.top()
        pse = whatever is in the stack for example if the stack is empty then -1 and if not then the top
         */

        while (!stack.isEmpty()) {

            nse = heights.length;
            element = heights[stack.peek()];
            stack.pop();
            pse = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea, element * (nse - pse - 1));
        }
        System.out.println("MaxArea " + maxArea);
        return maxArea;
    }

    private static int[] getPSE(int[] arr) {
        /*
To get the PSE for each element we
         */
        int pse[] = new int[arr.length];
        pse[0] = -1;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return pse;
    }

    static int[] getNSE(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int len = arr.length;
        int nse[] = new int[len];
        nse[len - 1] = len;
        for (int i = len - 2; i >= 0; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            nse[i] = stack.isEmpty() ? len : stack.peek();
            stack.push(i);
        }
        return nse;
    }

    static int BruteForce(int[] arr) {
        /*
Extreme Naive us we to each index and find the max Recatangle i can form (height and width calc)
For every index go left and right till the small element is encountered because till than i can form recatngle

I need PSE and NSE for each index
Area of each ith block will be height[i] * (nse[i] - pse[i] - 1)
         */
        int[] nse = getNSE(arr);
        int[] pse = getPSE(arr);

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i] * (nse[i] - pse[i] - 1));
        }
        System.out.println("Max = " + max);
        return max;
    }
}
