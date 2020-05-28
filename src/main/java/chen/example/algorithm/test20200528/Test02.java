package chen.example.algorithm.test20200528;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 *
 * @Description:
 * @author: chenjiawang
 * @CreateDate: 2020/5/28 20:22
 */
public class Test02 {

//    给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
//
//             
//
//    说明:
//
//    初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
//    你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
//             
//
//    示例:
//
//    输入:
//    nums1 = [1,2,3,0,0,0], m = 3
//    nums2 = [2,5,6],       n = 3
//
//    输出: [1,2,2,3,5,6]
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/merge-sorted-array
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 3, 6};
        int n = 0;

        Test02 test02 = new Test02();

        test02.merge(nums1, m, nums2, n);
        System.out.println(nums1.length);
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        test03(nums1, m, nums2, n);
    }

    private void test01(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m] = nums2[i];
            m++;
        }
        Arrays.sort(nums1);
    }

    private void test02(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }


    private void test03(int[] nums1, int m, int[] nums2, int n) {

        int[] newNums1 = new int[m];
        for (int i = 0; i < m; i++) {
            newNums1[i] = nums1[i];
        }
        int x = 0, y = 0;
        for (int i = 0; i < (m + n); i++) {
            if (y < n && x<m && newNums1[x] < nums2[y]) {
                nums1[i] = newNums1[x];
                x++;
            } else if(y < n) {
                nums1[i] = nums2[y];
                y++;
            }
        }
    }
}
