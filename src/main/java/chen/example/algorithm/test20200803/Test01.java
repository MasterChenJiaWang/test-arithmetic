package chen.example.algorithm.test20200803;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @author: chenjiawang
 * @CreateDate: 2020/8/3 13:47
 */
public class Test01 {
    // 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
    //
    // 注意：
    //
    // num1 和num2 的长度都小于 5100.
    // num1 和num2 都只包含数字 0-9.
    // num1 和num2 都不包含任何前导零。
    // 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
    //
    // 来源：力扣（LeetCode）
    // 链接：https://leetcode-cn.com/problems/add-strings
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static void main(String[] args) {
        Test01 test01 = new Test01();
        String num1 = "12345";
        String num2 = "123456";
        String s = test01.addStrings(num1, num2);
        System.out.println(s);
    }

    public String addStrings(String num1, String num2) {

        return test02(num1, num2);
    }

    /**
     *
     * @param num1
     * @param num2
     * @return
     */
    private String test01(String num1, String num2) {
        int key = 10;
        List<Integer> newNum = new LinkedList<>();
        int lastNum = 0;
        int length1 = num1.length();
        int length2 = num2.length();
        if (length1 >= length2) {
            int ccc = length2 - 1;
            for (int i = length1 - 1; i >= 0; i--) {
                int c1 = Integer.parseInt(String.valueOf(num1.charAt(i)));
                int c2 = 0;
                if (ccc >= 0) {
                    c2 = Integer.parseInt(String.valueOf(num2.charAt(ccc)));
                }
                int num = c1 + c2 + lastNum;
                newNum.add(num % key);
                lastNum = num / key;
                ccc--;
            }
        } else {
            int ccc = length1 - 1;
            for (int i = length2 - 1; i >= 0; i--) {
                int c1 = 0;
                if (ccc >= 0) {
                    c1 = Integer.parseInt(String.valueOf(num1.charAt(ccc)));
                }
                int c2 = Integer.parseInt(String.valueOf(num2.charAt(i)));
                int num = c1 + c2 + lastNum;
                newNum.add(num % key);
                lastNum = num / key;
                ccc--;
            }
        }
        if (lastNum > 0) {
            newNum.add(lastNum);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = newNum.size() - 1; i >= 0; i--) {
            stringBuilder.append(newNum.get(i));
        }
        return stringBuilder.toString();
    }

    /**
     *
     * @param num1
     * @param num2
     * @return
     */
    private String test02(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) {
                carry += num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                carry += num2.charAt(j--) - '0';
            }
            sb.append(carry % 10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }
}
