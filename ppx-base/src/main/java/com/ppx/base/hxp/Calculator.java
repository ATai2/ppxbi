package com.ppx.base.hxp;

import scala.Int;

/**
 * @author Administrator
 */
public class Calculator {
    public static void main(String[] args) {
        String expression = "30+2*6-2";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        int index = 0;
        int num1 = 0, num2 = 0, oper = 0, res = 0;
        char ch = ' ';
//        store multi slot nums
        String keepNum = "";

        while (true) {
            ch = expression.substring(index, index + 1).charAt(0);
            if (operStack.isOper(ch)) {
                // judge if operStack is empty
                if (!operStack.isEmpty()) {
                    //deal
                    if (operStack.priority(ch) <= operStack.priority(operStack.peak())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                } else {
                    // push
                    operStack.push(ch);
                }
            } else {
                keepNum += ch;
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(ch + ""));

                } else if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                    numStack.push(Integer.parseInt(keepNum));
                    keepNum = "";
                }
//                numStack.push(ch - 48);
            }
            index++;
            if (index >= expression.length()) {
                break;
            }
        }
        while (true) {
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        int res2 = numStack.pop();
        System.out.printf("expression %s =%d ", expression, res2);
    }
}

class ArrayStack2 {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("stack is full.");
        }
        top++;
        stack[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("stack is empty");
            throw new RuntimeException();
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("empty");
            return;
        }
        for (int i = top; i >= 0; i++) {
            System.out.println("item:" + stack[i]);
        }
    }

    //    define the priority of operators
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num1 / num2;
                break;
            default:
                break;
        }
        return res;
    }

    public int peak() {
        return stack[top];
    }
}

