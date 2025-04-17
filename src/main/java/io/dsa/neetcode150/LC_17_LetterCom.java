package io.dsa.neetcode150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_17_LetterCom {
    public static void main(String[] args) {
        Solution("23");
    }
    private static void Solution(String digits) {
        /*
        Input: digits = "23"
        Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
         */
        Map<Character, String> digitToLetters = new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        StringBuilder formed = new StringBuilder();
        List<String> list = new ArrayList<>();

        getTheCombs(digitToLetters, list, digits, new StringBuilder(), 0);
        System.out.println(list);

    }

    /*
    We have a map of the strings against the corresponding char integer
    We create a method that would take the map and the list which is initially empty
    we are taking a counter of index (int), this counter is to keep track of all the chars that has been traversed
    We take the first character from the input string number and then we find the string corresponding to that character and
    then we traverse this whole string
    We create a string-builder and add this char to it at ith position and then we call the function again with this formed string and increase the index counter
       we remove the char  from the builder after this to check the other combinations
     */

    private static void getTheCombs(Map<Character, String> map, List<String> result, String digits, StringBuilder formed, int index) {
        if (index == formed.toString().length()) {
            result.add(formed.toString());
            return;
        }

        char c = digits.charAt(index);
        String str = map.get(c);
        for (int i = 0; i < str.length(); i++) {
            formed.append(i);
            getTheCombs(map, result, digits, formed, index++);
            formed.deleteCharAt(formed.length() - 1);

        }

    }
}
