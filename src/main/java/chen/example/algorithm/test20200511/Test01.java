package chen.example.algorithm.test20200511;

/**
 * @Description:
 * @author: chenjiawang
 * @CreateDate: 2020/5/11 9:23
 */
public class Test01 {
    // 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
    //
    // 示例 1:
    //
    // 输入: 123
    // 输出: 321
    //  示例 2:
    //
    // 输入: -123
    // 输出: -321
    // 示例 3:
    //
    // 输入: 120
    // 输出: 21
    // 注意:
    //
    // 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

    public static void main(String[] args) {
        Test01 test01 = new Test01();
        // System.out.println(Math.pow(2, 31) - 1);
        int x = 1474836489;
        System.out.println(x);
        int reverse = test01.reverse(x);
        System.out.println(reverse);
    }

    public int reverse(int x) {
        return test02(x);
    }

    private int test01(int x) {
        if (x < -(Math.pow(2, 31) - 1) || x > Math.pow(2, 31)) {
            return 0;
        }
        String s = Math.abs(x) + "";
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }

        String s1 = sb.toString();
        long l = Long.parseLong(s1);
        if (x < 0) {
            l = -l;
        }
        return (l > Integer.MAX_VALUE || l < -Integer.MAX_VALUE) ? 0 : (int)l;
    }

    //147483648
    private int test02(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    private int test03(int x){

        return 0;
    }
}
