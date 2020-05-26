package chen.example.algorithm.test20200514;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @author: chenjiawang
 * @CreateDate: 2020/5/14 19:21
 */
public class Test01 {
//    给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//
//    说明：
//
//    你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
//
//    示例 1:
//
//    输入: [2,2,1]
//    输出: 1
//    示例 2:
//
//    输入: [4,1,2,1,2]
//    输出: 4

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2,4,3,5,6,5,6};
        Test01 test01 = new Test01();
        int i = test01.singleNumber(nums);
        System.out.println(i);
    }



    public int singleNumber(int[] nums) {
        return test01(nums);
    }

    private int  test01(int[] nums){
      int n=0;

        for (int num : nums) {
            n^=num;
        }
        return n;
    }
}
