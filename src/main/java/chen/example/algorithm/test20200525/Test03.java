package chen.example.algorithm.test20200525;

/**
 * 面试题53 - II. 0～n-1中缺失的数字
 *
 * @Description:
 * @author: chenjiawang
 * @CreateDate: 2020/5/26 20:05
 */
public class Test03 {
//    一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
//
//             
//
//    示例 1:
//
//    输入: [0,1,3]
//    输出: 2
//    示例 2:
//
//    输入: [0,1,2,3,4,5,6,7,9]
//    输出: 8
//             
//
//    限制：
//
//            1 <= 数组长度 <= 10000
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static void main(String[] args) {

        Test03 test02 = new Test03();
        int[] heights = {0,1, 2, 3, 4, 5, 6, 7,9};
//        int[] heights = {0,2,3};
        int i = test02.missingNumber(heights);

        System.out.println(i);
    }


    public int missingNumber(int[] nums) {
        return test02(nums);
    }


    private int test01(int[] nums) {
        int length = 0;
        if (nums == null || (length = nums.length) == 0) {
            throw new RuntimeException("错误");
        }
        int num = 0;
        for (int i = 0; i < length; i++) {
            int height = nums[i];
            if (i == 0) {
                if (height > 0) {
                    return 0;
                }
                num = height + 1;
                continue;
            }
            if (num != height) {
                return num;
            }
            num = height + 1;
        }
        return num;
    }

    private  int test02(int[] nums){
        int length = 0;
        if (nums == null || (length = nums.length) == 0) {
            throw new RuntimeException("错误");
        }
        if(nums[length-1]==length-1){
            return length;
        }
        int i=0,y=length-1;
        while (i<=y){
            int m = (i + y) / 2;
            if(nums[m]==m){
                i=m+1;
            }else{
                y=m-1;
            }
        }
        return i;
    }
}
