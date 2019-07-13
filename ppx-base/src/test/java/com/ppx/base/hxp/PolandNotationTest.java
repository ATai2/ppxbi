package com.ppx.base.hxp;

import org.junit.Test;

import static org.junit.Assert.*;

public class PolandNotationTest {

    @Test
    public void sta(){
        test(4);
    }
    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
//        else {
            System.out.println("n="+n);
//        }
    }
}