package chen.example.algorithm.test20200506;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @author: chenjiawang
 * @CreateDate: 2020/5/6 21:10
 */
public class Test01 {

//    给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
//
//    函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
//
//    说明:
//
//    返回的下标值（index1 和 index2）不是从零开始的。
//    你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
//    示例:
//
//    输入: numbers = [2, 7, 11, 15], target = 9
//    输出: [1,2]
//    解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。


    public static void main(String[] args) {
        int[] numbers = new int[]{2, 7, 11, 15};
        Test01 test20200505 = new Test01();
        int[] ints = test20200505.twoSum(numbers, 9);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+" ");
        }
    }

    public int[] twoSum(int[] numbers, int target) {
       return test03(numbers,target);
    }

    /**
     * 时间复杂度o(n^2)
     * @param numbers
     * @param target
     * @return
     */
    private int[] test01(int[] numbers, int target){
        if(numbers==null || numbers.length==0){
            return new int[0];
        }
        int length = numbers.length;

        int[] n = new int[2];

        for(int i=0;i<length;i++){
            for(int y=i+1;y<length;y++){
                if(numbers[i]+numbers[y]==target){
                    n[0]=i+1;
                    n[1]=y+1;
                    return n;
                }
            }
        }
        return n;
    }


    /**
     * o(n)
     * @param numbers
     * @param target
     * @return
     */
    private int[] test02(int[] numbers, int target){
        if(numbers==null || numbers.length==0){
            return new int[0];
        }
        int length = numbers.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<length;i++){
            map.put(numbers[i],i+1);
        }
        for(int i=0;i<length;i++){
            int n = target - numbers[i];
            int m;
            if(map.containsKey(n) && (m=map.get(n))!=i){
                return new int[]{i+1,m};
            }
        }
        return new int[0];
    }


    /**
     * o(n)
     * @param numbers
     * @param target
     * @return
     */
    private int[] test03(int[] numbers, int target){
        if(numbers==null || numbers.length==0){
            return new int[0];
        }
        int length = numbers.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<length;i++){
            int num = numbers[i];
            int i1 = target - num;
            if(map.containsKey(i1)){
                return new int[]{map.get(i1),i+1};
            }
            map.put(num,i+1);
        }
        return new int[0];
    }
}
