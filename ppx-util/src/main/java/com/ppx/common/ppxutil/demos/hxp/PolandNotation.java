package com.ppx.common.ppxutil.demos.hxp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main2(String[] args) {
        String suffixExpression = "3 4 + 5 * 6 -";
        List<String> listString = getListString(suffixExpression);
        System.out.println("rpnList=" + listString);
        int res = calculate(listString);
        System.out.println("res=" + res);
    }


    public static List<String> getListString(String suffuxExpression) {
        String[] split = suffuxExpression.split(" ");
        List<String> list = new ArrayList<>();
        Collections.addAll(list, split);
        return list;
    }

    public static int calculate(List<String> ls) {
//        only needs one stack
        Stack<String> stack = new Stack<>();
        for (String item :
                ls) {
            if (item.matches("\\d+")) {
                stack.push(item);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("operator error");
                }
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
