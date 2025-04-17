package io.dsa.striver.stacksAndQueues;

import java.util.Stack;

public class Conversions {

    static int precedence(char c) {
        if (c == '^') return 3;
        else if (c == '/' || c == '*') return 2;
        else if (c == '+' || c == '-') return 1;
        else return -1;
    }

    static boolean isOperand(char ch) {
        return ch >= 'a' || ch <= 'z' || ch >= 'A' || ch <= 'Z' || ch <= '9' || ch >= '0';
    }

    static boolean isOperator(char ch) {
        return (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^');
    }

    static String InfixToPostfix(String s) {
        StringBuilder outputString = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isOperand(ch)) {
                outputString.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    outputString.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && (precedence(ch) < precedence(stack.peek())) || precedence(ch) == precedence(stack.pop())) {
                    outputString.append(stack.pop());
                }
            }
        }
        System.out.println("Result " + outputString.toString());
        return outputString.toString();
    }

    static String InfixToPrefix(String string) {
/*
Step by step approach:

Reverse the infix expression. Note while reversing each ‘(‘ will become ‘)’ and each ‘)’ becomes ‘(‘.
Convert the reversed infix expression to postfix expression.
Initialize an empty stack to store operators and an empty string for the postfix expression.
Scan the infix expression from left to right.
If the character is an operand, append it to the postfix expression.
If the character is ‘(‘, push it onto the stack.
If the character is ‘)’, pop from the stack and append to the postfix expression until ‘(‘ is found, then pop ‘(‘ without appending.
If the character is an operator, pop and append operators from the stack until the stack is empty or a lower precedence operator is found, then push the current operator onto the stack.
After scanning the expression, pop and append all remaining operators from the stack to the postfix expression.
Reverse the postfix expression and return it.
 */

        StringBuilder reverse = new StringBuilder(string).reverse();
        string = reverse.toString();

        char[] chars = string.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') chars[i] = ')';
            else if (chars[i] == ')') chars[i] = '(';
        }

        String postfix = InfixToPostfix(new String(chars));
        return new StringBuilder(postfix).reverse().toString();
    }
}

