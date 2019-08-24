package com.ppx.message.ppxutil.hxp;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack=new ArrayStack(4);
        arrayStack.list();
    }
}

class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
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

    public void list(){
        if (isEmpty()) {
            System.out.println("empty");
            return;
        }
        for (int i =top; i >=0; i++) {
            System.out.println("item:" + stack[i]);

        }
    }
}
