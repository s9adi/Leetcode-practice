package io.dsa.striver.stacksAndQueues;

import java.util.Stack;

public class OperatorsAndOperands {
    public static void main(String[] args) {

        InfixToPrefix("abc");
    }

    private static String InfixToPostFix(String string) {
// (a+b)*(p-q) -> postfix -> ab+pq-*
        Stack<Character> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            // we have to check if its operator or operand
            // if its operand then just append the string first
            if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || (ch >= '0' && ch <= '9')) {
                stringBuilder.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (stack.peek() != '(') {
                    stringBuilder.append(stack.pop());
                }
                stack.pop();
            }
            // check for the operands
            else {
                while (!stack.isEmpty() && prec(ch) < prec(stack.peek()) || prec(ch) == prec(stack.peek())) {
                    stringBuilder.append(stack.pop());
                }
                stack.push(ch);
            }


        }
        stringBuilder.append(stack.pop());
        return stringBuilder.toString();
    }

    public static int prec(char c) {
        if (c == '^')
            return 3;
        else if (c == '/' || c == '*')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return -1;
    }

    private static boolean isOperator(char c) {
        return (!(c >= 'a' && c <= 'z') &&
                !(c >= '0' && c <= '9') &&
                !(c >= 'A' && c <= 'Z'));
    }

    private static String InfixToPrefix(String string) {
        // reverse the string
        // perform the infixtopostfix

        char[] chars = string.toCharArray();
        char[] reversedchararray = reverseForPrefix(chars, 0, chars.length);

        for (int i = 0; i < reversedchararray.length; i++) {
            if (reversedchararray[i] == '(') {
                reversedchararray[i] = ')';
            } else if (reversedchararray[i] == ')') {
                reversedchararray[i] = '(';
            }


        }


        // now call the postfix
        String str = reversedchararray.toString();
        String res = InfixToPostFix(str);

        res = reverseForPrefix(res.toCharArray(), 0, res.length() - 1).toString();
        return res;

    }

    private static char[] reverseForPrefix(char[] chars, int left, int right) {

        while (left <= right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
        }

        return chars;

    }
}

