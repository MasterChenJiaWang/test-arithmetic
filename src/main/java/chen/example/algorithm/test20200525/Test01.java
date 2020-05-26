package chen.example.algorithm.test20200525;

import java.util.HashMap;
import java.util.Map;

/**
 * 1010. 总持续时间可被 60 整除的歌曲
 *
 * @Description:
 * @author:chenjiawang
 * @CreateDate:2020/5/25 20:10
 */

public class Test01 {
//    在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
//
//    返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望索引的数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。
//
//             
//
//    示例 1：
//
//    输入：[30,20,150,100,40]
//    输出：3
//    解释：这三对的总持续时间可被 60 整数：
//            (time[0] = 30, time[2] = 150): 总持续时间 180
//            (time[1] = 20, time[3] = 100): 总持续时间 120
//            (time[1] = 20, time[4] = 40): 总持续时间 60
//    示例 2：
//
//    输入：[60,60,60]
//    输出：3
//    解释：所有三对的总持续时间都是 120，可以被 60 整数。
//             
//
//    提示：
//
//            1 <= time.length <= 60000
//            1 <= time[i] <= 500
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/pairs-of-songs-with-total-durations-divisible-by-60
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static void main(String[] args) {
        int[] nums = {30, 20, 150, 100, 40};
//        int[] nums = {60,60,60};
        Test01 test01 = new Test01();

        int i = test01.test03(nums);

        System.out.println(i);

    }


    public int numPairsDivisibleBy60(int[] time) {
        return test01(time);
    }

    private int test01(int[] time) {
        if (time == null) {
            throw new RuntimeException("数组为空");
        }
        int length = time.length;
        if (length == 0 || length > 60000) {
            throw new RuntimeException("数组错误");
        }

        int num = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if ((time[i] + time[j]) % 60 == 0) {
                    num++;
                }
            }
        }
        return num;
    }


    private int test02(int[] time) {
        if (time == null) {
            throw new RuntimeException("数组为空");
        }
        int length = time.length;
        if (length == 0 || length > 60000) {
            throw new RuntimeException("数组错误");
        }
        Map<Integer, Integer> map = new HashMap<>((int)(length/0.75));
        int num = 0;
        for (int i = 0; i < length; i++) {
            int i1 = time[i];
            int i2 = i1 % 60;
            if(map.containsKey(i2)){
                num+=map.get(i2);
            }
            if (i2 == 0) {
                // 特殊处理：余数为0的配对也是余数为0的
                map.put(0, map.getOrDefault(0, 0) + 1);
            } else {
                // 记录当前余数的配对余数
                int target = 60 - i2;
                map.put(target, map.getOrDefault(target, 0) + 1);
            }
        }
        return num;
    }

    private int test03(int[] time) {
        if (time == null) {
            throw new RuntimeException("数组为空");
        }
        int length = time.length;
        if (length == 0 || length > 60000) {
            throw new RuntimeException("数组错误");
        }
        int[] map = new int[60];
        int num = 0;
        for (int i = 0; i < length; i++) {
            int i1 = time[i];
            int i2 = i1 % 60;
            num+=map[i2];
            int target = i2 == 0 ? 0 : 60 - i2;
            map[target]++;
        }
        return num;
    }
}
