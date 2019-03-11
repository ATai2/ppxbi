import org.junit.Test;

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

        for (int i = 0; i < list.length ; i++) {
            listreverse[list.length - i-1] = list[i];
        }
        String re = String.valueOf(listreverse);
        long parseLong = Long.parseLong(re);
        if (parseLong > Integer.MAX_VALUE||parseLong<Integer.MIN_VALUE) {
            return 0;
        }
        res = (int) (flag ? parseLong : -parseLong);
        return res;
    }


}
