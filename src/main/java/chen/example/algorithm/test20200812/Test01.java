package chen.example.algorithm.test20200812;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 *
 * @Description:
 * @author: chendaren
 * @CreateDate: 2020/8/12 10:12
 */
public class Test01 {
    /*   给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

    示例 1:

    输入: "abcabcbb"
    输出: 3
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    示例 2:

    输入: "bbbbb"
    输出: 1
    解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
    示例 3:

    输入: "pwwkew"
    输出: 3
    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
                 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。*/

    public static void main(String[] args) {
        Test01 test01 = new Test01();
        // String s = "abc12abcbb";
        String s = "bbbbb";
        // String s = "pwwkew";
        // String s = "dvdf";
        // String s = "abba";
        int i = test01.lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    public int lengthOfLongestSubstring(String s) {

        return test01(s);
    }

    private int test01(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        int max = 0;
        int n = 0;
        int newkey = 0;
        Map<Character, Integer> map = new LinkedHashMap<>(length);
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            Integer key = map.get(c);
            map.put(c, i);
            if (key == null) {
                n++;
            } else {
                newkey = Math.max(newkey, key);;
                n = i - newkey;
            }
            max = Math.max(max, n);
        }

        return max;
    }
}
