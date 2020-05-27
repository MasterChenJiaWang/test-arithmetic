package chen.example.algorithm.test20200527;

/**
 * 674. 最长连续递增序列
 *
 * @Description:
 * @author: chenjiawang
 * @CreateDate: 2020/5/27 22:08
 */
public class Test01 {
//    给定一个未经排序的整数数组，找到最长且连续的的递增序列。
//
//    示例 1:
//
//    输入: [1,3,5,4,7]
//    输出: 3
//    解释: 最长连续递增序列是 [1,3,5], 长度为3。
//    尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
//    示例 2:
//
//    输入: [2,2,2,2,2]
//    输出: 1
//    解释: 最长连续递增序列是 [2], 长度为1。
//    注意：数组长度不会超过10000。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static void main(String[] args) {

        Test01 test01 = new Test01();

//        int[] ints = {1, 3, 5, 4, 7};
        int[] ints = {1,3,5,4,2,3,4,5};
//        int[] ints = {2,2,2,2};
        int length = test01.findLengthOfLCIS(ints);

        System.out.println(length);
    }


    public int findLengthOfLCIS(int[] nums) {
        return test02(nums);
    }

    private int test01(int[] nums) {
        int length = 0;
        if (nums == null || (length = nums.length) == 0) {
            return 0;
        }
        if (length == 1) {
            return 1;
        }
        int totalNum = 0, keyNum = 1, key = 0;

        for (int i = 0; i < length; i++) {
            if (i == 0) {
                key = nums[i];
                continue;
            }
            if (nums[i] > key) {
                keyNum++;
            } else {
                totalNum = Math.max(totalNum, keyNum);
                keyNum = 1;
            }
            key = nums[i];
        }
        return Math.max(totalNum, keyNum);
    }


    private int test02(int[] nums) {
        int length = 0;
        if (nums == null || (length = nums.length) == 0) {
            return 0;
        }
        if (length == 1) {
            return 1;
        }
        int totalNum=1,key=0;
        for (int i = 0; i < length; i++) {
            if(i>0 && nums[i-1]>=nums[i]){
                key=i;
            }
            totalNum=Math.max(totalNum,i-key+1);
        }
        return totalNum;
    }
}
