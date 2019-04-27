import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LeetcodeTest {
    @Test
    public void test() {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(-123));
    }

    public int reverse(int x) {
        int res = 0;
        long temp = 0L;
        boolean flag = x > 0 ? true : false;
        x = flag ? x : -x;
        String value = String.valueOf(x);
        char[] list = value.toCharArray();
        char[] listreverse = new char[list.length];

        for (int i = 0; i < list.length; i++) {
            listreverse[list.length - i - 1] = list[i];
        }
        String re = String.valueOf(listreverse);
        long parseLong = Long.parseLong(re);
        if (parseLong > Integer.MAX_VALUE || parseLong < Integer.MIN_VALUE) {
            return 0;
        }
        res = (int) (flag ? parseLong : -parseLong);
        return res;
    }

    public int reverse2(int x) {
        long res = 0L;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
            if ((res < Integer.MIN_VALUE) || (res > Integer.MAX_VALUE)) {
                return 0;
            }
        }
        return (int) res;
    }

    public int myAtoi(String str) {
        String value = str.trim();
        int begin, end;

        return 0;
    }

    @Test
    public void palindromeTest() {
        isPalindrome(121);
    }

    public boolean isPalindrome(int x) {
        String list = String.valueOf(x);
        int length = list.length();
        char[] charList = list.toCharArray();
        for (int i = 0; i < length / 2; i++) {
            if (!(charList[i] == charList[length - 1 - i])) {
                return false;
            }
        }
        return true;

    }

    @Test
    public void testBinaryTree() {
        TreeMap<String, String> treeMap = new TreeMap<>();


    }

    public int romanToInt(String s) {
        Map<String, Integer> valueMap = new HashMap<>();
        valueMap.put("I", 1);
        valueMap.put("V", 5);
        valueMap.put("X", 10);
        valueMap.put("L", 50);
        valueMap.put("C", 100);
        valueMap.put("D", 500);
        valueMap.put("M", 1000);
        valueMap.put("IV", 4);
        valueMap.put("IX", 9);
        valueMap.put("XL", 40);
        valueMap.put("XC", 90);
        valueMap.put("CD", 400);
        valueMap.put("CM", 900);


        return 0;
    }

    @Test
    public void romanToIntTest() {
        Assert.assertEquals("3", romanToInt("III"));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {


        return 0;
    }

    @Test
    public void findMedianSortedArraysTest() {
        int[] a = new int[]{1, 3};
        int[] b = new int[]{2};

        System.out.println(findMedianSortedArrays(a, b));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String res = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                dp[j][i] = s.charAt(j) == s.charAt(i) && ((i - j <= 2) || dp[j + 1][i - 1]);
                if (dp[j][i]) {
                    if (i - j + 1 > max) {
                        max = i - j + 1;
                        res = s.substring(j, i + 1);
                    }
                }
            }
        }
        return res;
    }

    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            res = helper(s, i, i, res);
            res = helper(s, i, i + 1, res);
        }
        return res;
    }

    public String helper(String s, int left, int right, String res) {
        while (left > 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        String current = s.substring(left + 1, right);
        if (current.length() > res.length()) {
            return current;
        }
        return res;
    }
}
