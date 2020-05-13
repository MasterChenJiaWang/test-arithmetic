package chen.example.algorithm.test20200513;

/**
 * @Description:
 * @author: chenjiawang
 * @CreateDate: 2020/5/13 21:19
 */
public class Test01 {
//    判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
//    示例 1:
//
//    输入: 121
//    输出: true
//    示例 2:
//
//    输入: -121
//    输出: false
//    解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
//    示例 3:
//
//    输入: 10
//    输出: false
//    解释: 从右向左读, 为 01 。因此它不是一个回文数。
//    进阶:
//
//    你能不将整数转为字符串来解决这个问题吗？


    public static void main(String[] args) {
        int x = 11222222;
        Test01 test01 = new Test01();
        boolean palindrome = test01.isPalindrome(x);
        System.out.println(palindrome);
    }


    /**
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        return test03(x);
    }


    /**
     * @param x
     * @return
     */
    private boolean test01(int x) {
        if (x >= 0 && x < 10) {
            return true;
        }
        if (x < 0) {
            return false;
        }

        int n = x;
        int key = 0;
        while (n > 0) {
            int i = n % 10;
            key = key * 10 + i;
            n = n / 10;
        }
        return key == x;
    }

    private boolean test02(int x) {
        if (x >= 0 && x < 10) {
            return true;
        }
        if (x < 0) {
            return false;
        }
        String s = x + "";
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return s.equals(sb.toString());
    }

    private boolean test03(int x){
        if (x >= 0 && x < 10) {
            return true;
        }
        if (x < 0) {
            return false;
        }
        int len = 0;
        String s = x + "";
        String substring="";
        int length = s.length();
        if (length % 2 != 0) {
            len = length / 2 + 1;
            substring= s.substring(0, len-1);
        } else {
            len = length / 2;
            substring= s.substring(0, len);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = length-1; i >=len; i--) {
            sb.append(s.charAt(i));
        }
        return substring.equals(sb.toString());
    }
}
