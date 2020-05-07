package chen.example.algorithm.test20200507;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description:
 * @author: chenjiawang
 * @CreateDate: 2020/5/7 15:24
 */
public class Test01 {
    // 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
    //
    // 示例 1:
    // 给定的树 s:
    //
    // 3
    // / \
    // 4 5
    // / \
    // 1 2
    // 给定的树 t：
    //
    // 4
    // / \
    // 1 2
    // 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
    //
    // 示例 2:
    // 给定的树 s：
    //
    // 3
    // / \
    // 4 5
    // / \
    // 1 2
    // /
    // 0
    // 给定的树 t：
    //
    // 4
    // / \
    // 1 2
    // 返回 false。

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(0);
        TreeNode treeNode2 = new TreeNode(2, null, null);
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(4, treeNode3, treeNode2);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode s = new TreeNode(3, treeNode4, treeNode5);
        //
        TreeNode treeNodet1 = new TreeNode(1);
        TreeNode treeNodet2 = new TreeNode(2);
        TreeNode t = new TreeNode(4, treeNodet1, treeNodet2);

        // TreeNode s = new TreeNode(12);
        // TreeNode t = new TreeNode(2);
        Test01 test01 = new Test01();
        System.out.println(test01.isSubtree(s, t));
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        //
        return test01(s, t);
    }

    private boolean test01(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return false;
        }
        List<Integer> slist = new ArrayList<>();
        addList(s, slist);
        String ss = slist.stream().map(integer -> integer + "").collect(Collectors.joining(","));
        List<Integer> tlist = new ArrayList<>();
        addList(t, tlist);
        String tt = tlist.stream().map(integer -> integer + "").collect(Collectors.joining(","));
        int i = ss.indexOf(tt);
        return i > -1 && (i == 0 || ss.contains("," + tt));
    }

    /**
     *
     * @param t
     * @param list
     */
    private void addList(TreeNode t, List<Integer> list) {
        if (t == null) {
            list.add(null);
            return;
        }
        list.add(t.val);
        addList(t.left, list);
        addList(t.right, list);
    }

    private void checkS(TreeNode s, Map<Integer, TreeNode> tmap) {
        if (s == null) {
            return;
        }
    }

    /**
     *
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
