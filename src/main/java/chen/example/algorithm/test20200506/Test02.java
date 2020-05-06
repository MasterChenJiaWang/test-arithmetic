package chen.example.algorithm.test20200506;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

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
        return test03(root, k);
    }

    /**
     * @param root
     * @param k
     * @return
     */
    private boolean test01(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        addList(root, list, map);
        for (int i = 0; i < list.size(); i++) {
            int y;
            if (map.containsKey(y = (k - list.get(i))) && map.get(y) != i) {
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
        map.put(root.val, list.size() - 1);
        if (left != null) {
            list.add(left.val);
            map.put(left.val, list.size() - 1);
            addList(left.left, list, map);
            addList(left.right, list, map);
        }
        if (right != null) {
            list.add(right.val);
            map.put(right.val, list.size() - 1);
            addList(right.left, list, map);
            addList(right.right, list, map);
        }
    }

    /**
     * @param root
     * @param k
     * @return
     */
    private boolean test02(TreeNode root, int k) {

        Set<Integer> set = new HashSet<>();
        return find02(root, k, set);
    }


    private boolean find02(TreeNode root, int k, Set<Integer> set) {
        if (root == null) {
            return false;
        }
        int i = k - root.val;
        if (set.contains(i)) {
            return true;
        }
        set.add(root.val);
        return find02(root.left, k, set) || find02(root.right, k, set);
    }

    /**
     * @param root
     * @param k
     * @return
     */
    private boolean test03(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            if (queue.peek() != null) {
                TreeNode node = queue.remove();
                if (set.contains(k - node.val)) {
                    return true;
                }
                set.add(node.val);
                queue.add(node.right);
                queue.add(node.left);
            } else {
                queue.remove();
            }
        }
        return false;
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
