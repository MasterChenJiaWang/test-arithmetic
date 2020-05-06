package chen.example.algorithm.test20200506;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @author: chenjiawang
 * @CreateDate: 2020/5/6 21:10
 */
public class Test02 {

//    给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
//
//    案例 1:
//
//    输入:
//            5
//            / \
//            3   6
//            / \   \
//            2   4   7
//
//    Target = 9
//
//    输出: True
// 
//
//    案例 2:
//
//    输入:
//            5
//            / \
//            3   6
//            / \   \
//            2   4   7
//
//    Target = 28
//
//    输出: False

    public static void main(String[] args) {


        Test02 test02 = new Test02();
        boolean target = test02.findTarget();
        System.out.println(target);
    }

    public boolean findTarget() {
        TreeNode treeNode = new TreeNode(-3);
        TreeNode treeNode1 = new TreeNode(-4);


        TreeNode treeNode2 = new TreeNode(0);
        treeNode2.left = new TreeNode(-2);
        treeNode2.right = new TreeNode(1);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        //
//        TreeNode treeNode = new TreeNode(2);
//        TreeNode treeNode1 = new TreeNode(1);
//
//        TreeNode treeNode2 = new TreeNode(3);
//        treeNode.left=treeNode1;
//        treeNode.right=treeNode2;

//        TreeNode treeNode = new TreeNode(1);
        return findTarget(treeNode, -1);
    }

    /**
     * 时间复杂度o(n^2)
     *
     * @param root
     * @param k
     * @return
     */
    private boolean findTarget(TreeNode root, int k) {

        if (root == null) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        addList(root, list, map);
        for (int i = 0; i <list.size() ; i++) {
            int y;
            if (map.containsKey(y=(k - list.get(i))) && map.get(y)!=i) {
                return true;
            }
        }
        return false;
    }

    private void addList(TreeNode root, List<Integer> list, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        list.add(root.val);
        map.put(root.val, list.size()-1);
        if (left != null) {
            list.add(left.val);
            map.put(left.val, list.size()-1);
            addList(left.left, list, map);
            addList(left.right, list, map);
        }
        if (right != null) {
            list.add(right.val);
            map.put(right.val, list.size()-1);
            addList(right.left, list, map);
            addList(right.right, list, map);
        }
    }

    /**
     * o(n)
     *
     * @param numbers
     * @param target
     * @return
     */
    private int[] test02(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[0];
        }
        int length = numbers.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(numbers[i], i + 1);
        }
        for (int i = 0; i < length; i++) {
            int n = target - numbers[i];
            int m;
            if (map.containsKey(n) && (m = map.get(n)) != i) {
                return new int[]{i + 1, m};
            }
        }
        return new int[0];
    }


    /**
     * o(n)
     *
     * @param numbers
     * @param target
     * @return
     */
    private int[] test03(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[0];
        }
        int length = numbers.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int num = numbers[i];
            int i1 = target - num;
            if (map.containsKey(i1)) {
                return new int[]{map.get(i1), i + 1};
            }
            map.put(num, i + 1);
        }
        return new int[0];
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
