package io.dsa.neetcode150;

import java.util.ArrayList;
import java.util.List;

public class LC_22_GenerateParentheses {
    /*
    We have to generate all sorts of possible patterns which are valid from the input
    Say n = 2 -> (()) , ()()
    Input: n = 3 Output: ["((()))","(()())","(())()","()(())","()()()"]
    So the conditions to look for here are that -
        create two pointers , close and open
        at any situation close <= open
        and the start element should never be open
     */
    private static List<String> Solution(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        int open = 0;
        int close = 0;

        backTrack(result, n, builder, open, close);
        return result;
    }

    public static void backTrack(List<String> result, int input, StringBuilder builder, int open, int close) {
        if (builder.length() == 2 * input) {
            result.add(builder.toString());
            return;
        }
        if (open < input) {
            backTrack(result, input, builder.append("("), open + 1, close);
        }
        if (close < open) {
            backTrack(result, input, builder.append(")"), open, close + 1);

        }
    }
}
