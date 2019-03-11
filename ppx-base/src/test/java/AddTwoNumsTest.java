import org.junit.Test;

import java.util.HashMap;

public class AddTwoNumsTest {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    @Test
    public void solution() {
        ListNode a = new ListNode(2);
        a.next = new ListNode(3);
        a.next.next = new ListNode(4);
        ListNode b = new ListNode(4);
        b.next = new ListNode(5);
        b.next.next = new ListNode(6);
        System.out.println(addTwoNumbers(a, b));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        int sum = 0;
        ListNode cur = dummy;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null || p2 != null) {
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            cur.next = new ListNode(sum % 10);
            sum /= 10;
            cur = cur.next;
        }
        if (sum == 1) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }

    @Test
    public void testlengthOfLongestSubstring() {
        System.out.println(lengthOfLongestSubstring("abcabc"));
    }
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> container=new HashMap<>();
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res=0;
        for (int i = 0,j=0; i < s.length(); i++) {
            if (container.containsKey(s.charAt(i))) {
                j = Math.max(j, container.get(s.charAt(i)) + 1);
            }
            container.put(s.charAt(i), i);
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
