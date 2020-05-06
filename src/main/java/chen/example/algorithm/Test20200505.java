package chen.example.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @author: chenjiawang
 * @CreateDate: 2020/5/5 21:10
 */
public class Test20200505 {

//    给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
//    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//
//             
//
//    示例:
//
//    给定 nums = [2, 7, 11, 15], target = 9
//
//    因为 nums[0] + nums[1] = 2 + 7 = 9
//    所以返回 [0, 1]


    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15,4,7};
        Test20200505 test20200505 = new Test20200505();
        int[] ints = test20200505.twoSum(nums, 9);
        System.out.println(ints);
    }

    public int[] twoSum(int[] nums, int target) {
       return test02(nums,target);
    }

    /**
     * 时间复杂度n^2
     * @param nums
     * @param target
     * @return
     */
    private int[] test01(int[] nums, int target){
        if(nums==null || nums.length==0){
            return new int[0];
        }
        int length = nums.length;

        int[] n = new int[2];

        for(int i=0;i<length;i++){
            for(int y=i+1;y<length;y++){
                if(nums[i]+nums[y]==target){
                    n[0]=i;
                    n[1]=y;
                    return n;
                }
            }
        }
        return n;
    }


    /**
     * 2n
     * @param nums
     * @param target
     * @return
     */
    private int[] test02(int[] nums, int target){
        if(nums==null || nums.length==0){
            return new int[0];
        }
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<length;i++){
            int n = target - nums[i];
            int m;
            if(map.containsKey(n) && (m=map.get(n))!=i){
                return new int[]{i,m};
            }
        }
        return new int[0];
    }
}
