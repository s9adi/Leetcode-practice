package io.dsa.DP;

public class Ninja {

    static int Recursive(int[][] activities, int n) {

        return helper(activities, n - 1, activities[0].length);
    }

    static int helper(int[][] points, int dayIndex, int lastActivity) {
        if (dayIndex == 0) {
            int maxPoints = 0;
            for (int task = 0; task < points[0].length; task++) {
                if (task != lastActivity) {
                    maxPoints = Math.max(maxPoints, points[0][task]);
                }
            }
            return maxPoints;
        }

        // if it is not zero and the call is made from n then this needs to call to check what was the maxEnergy till n-1

        int maxPoints = Integer.MIN_VALUE;

        // we will check for the previous call and the last element that was used in that call
        // take the max of all the calls
        // how can we make all the calls from here ?
        // by loop that runs from ot to k

        for (int i = 0; i < points[0].length; i++) {
            int currentMax = Integer.MIN_VALUE;
            // we are going to have 2 different calls given k = 3 and one of the element index was taken from the previous call
            if (i != lastActivity) {
                currentMax = helper(points, dayIndex - 1, i) + points[dayIndex][i];
            }

            maxPoints = Math.max(currentMax, maxPoints);
        }

        return maxPoints;
    }

    static int DPSolution(int[][] points, int len) {
        // what are the states that are changing ?
        // the day is changing and the task is changing so we create a dp array for these two
        int[][] dp = new int[points.length][points[0].length + 1];
        // we chose the j to be length + 1 that means the tasks + 1 the index to support that if there are all three choices to done
        // for a particular day what is the max that we can get from the
        // dp[i][j] means that for index/day i the last activity chosen was j
        // the max points that we can earn till day i if we chose index j is dp[i][j]
        // we have to make base case for all three tasks on day 0

        // dp[i][j] means that for maxSum of the activities on day i given j was index for day i-1
        // Initialize the first day's maximum points based on the available choices
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < len; day++) {
            for (int last = 0; last < 4; last++) {
                // we initialise that for current day and last activity
                dp[day][last] = 0;
                for (int task = 0; task < 4; task++) {
                    if (task != last) {
                        // we calculate the sum of activities till the day given the task we chose is not the last task performed
                        int activity = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }
        }

        return dp[len - 1][4];
    }


}
