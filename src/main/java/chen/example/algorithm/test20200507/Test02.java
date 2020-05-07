package chen.example.algorithm.test20200507;


import java.math.BigInteger;

/**
 * @Description:
 * @author: chenjiawang
 * @CreateDate: 2020/5/7 18:17
 */
public class Test02 {
    // 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
    //
    // 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
    //
    // 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    //
    // 示例：
    //
    // 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    // 输出：7 -> 0 -> 8
    // 原因：342 + 465 = 807

    public static void main(String[] args) {

//        ListNode l1 = new ListNode(2);
//        ListNode listNode11 = new ListNode(4);
//        ListNode listNode12 = new ListNode(3);
//        l1.next = listNode11;
//        listNode11.next = listNode12;
//
//        ListNode l2 = new ListNode(5);
//        ListNode listNode21 = new ListNode(6);
//        ListNode listNode22 = new ListNode(4);
//        l2.next = listNode21;
//        listNode21.next = listNode22;


        //
//        ListNode l1 = new ListNode(2);
//        ListNode listNode11 = new ListNode(4);
//        ListNode listNode12 = new ListNode(3);
//        l1.next = listNode11;
//        listNode11.next = listNode12;
//
//        ListNode l2 = new ListNode(5);
//        ListNode listNode21 = new ListNode(6);
//        ListNode listNode22 = new ListNode(4);
//        l2.next = listNode21;
//        listNode21.next = listNode22;


        Test02 test02 = new Test02();

//        int[] sl1=new int[]{9};
        int[] sl1 = new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        ListNode l1 = test02.addNode(sl1);
//        int[] sl2=new int[]{1,9,9,9,9,9,9,9,9,9,9,9,9};
        int[] sl2 = new int[]{5, 6, 4};
        ListNode l2 = test02.addNode(sl2);
        ListNode listNode = test02.addTwoNumbers(l1, l2);

        System.out.println(listNode.val);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return test02(l1, l2);
    }

    private ListNode test01(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null) {
            return l2;
        }
        if (l1 != null && l2 == null) {
            return l1;
        }
        String sb1 = parseNode(l1, "");
        BigInteger i1 = new BigInteger("".equals(sb1) ? "0" : sb1);

        String sb2 = parseNode(l2, "");
        BigInteger i2 = new BigInteger("".equals(sb2) ? "0" : sb2);
        BigInteger add = i1.add(i2);
        String i = add + "";
        ListNode lastListNode = null;
        ListNode listNode = null;
        for (int j = 0; j < i.length(); j++) {
            char c = i.charAt(j);
            int i3 = Integer.parseInt(c + "");
            lastListNode = new ListNode(i3);
            lastListNode.next = listNode;
            listNode = lastListNode;
        }
        return lastListNode;
    }

    private String parseNode(ListNode listNode, String sb) {
        if (listNode == null) {
            return sb;
        }
        sb = listNode.val + sb;
        sb = parseNode(listNode.next, sb);
        return sb;
    }


    private ListNode test02(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null) {
            return l2;
        }
        if (l1 != null && l2 == null) {
            return l1;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }


    private ListNode addNode(int[] snode) {
        ListNode lastListNode = null;
        ListNode listNode = null;
        for (int i = snode.length - 1; i >= 0; i--) {
            lastListNode = new ListNode(snode[i]);
            lastListNode.next = listNode;
            listNode = lastListNode;
        }
        return lastListNode;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
