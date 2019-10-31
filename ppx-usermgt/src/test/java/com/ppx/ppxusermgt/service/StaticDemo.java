package com.ppx.ppxusermgt.service;

public class StaticDemo {
    static int tmp=1;
    static{
        tmp=2;
    }

    public static void main(String[] args) {
        tmp=3;
        System.out.println(tmp);
//        Class.forName()
    }
}
