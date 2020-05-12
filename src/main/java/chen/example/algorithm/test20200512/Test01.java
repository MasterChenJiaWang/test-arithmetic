package chen.example.algorithm.test20200512;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description:
 * @author: chenjiawang
 * @CreateDate: 2020/5/12 15:42
 */
public class Test01 {
    // 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
    //
    // push(x) —— 将元素 x 推入栈中。
    // pop() —— 删除栈顶的元素。
    // top() —— 获取栈顶元素。
    // getMin() —— 检索栈中的最小元素。
    //  
    //
    // 示例:
    //
    // 输入：
    // ["MinStack","push","push","push","getMin","pop","top","getMin"]
    // [[],[-2],[0],[-3],[],[],[],[]]
    //
    // 输出：
    // [null,null,null,null,-3,null,0,-2]
    //
    // 解释：
    // MinStack minStack = new MinStack();
    // minStack.push(-2);
    // minStack.push(0);
    // minStack.push(-3);
    // minStack.getMin(); --> 返回 -3.
    // minStack.pop();
    // minStack.top(); --> 返回 0.
    // minStack.getMin(); --> 返回 -2.
    //  
    //
    // 提示：
    //
    // pop、top 和 getMin 操作总是在 非空栈 上调用。

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.top();
        System.out.println(minStack.getMin());
    }

    static class MinStack {
        List<Integer> stack = null;
        List<Integer> minStack = null;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new ArrayList<>();
            minStack = new ArrayList<>();
        }

        public void push(int x) {
            stack.add(x);
            minStack.add(findMin());
        }

        public void pop() {
            stack.remove(stack.size() - 1);
            minStack.remove(minStack.size() - 1);
        }

        public int top() {
            return stack.get(stack.size() - 1);
        }

        public int getMin() {
            return minStack.get(minStack.size() - 1);
        }

        private Integer findMin() {
            Integer x = null;
            if (stack == null || stack.size() == 0) {
                return x;
            }
            for (Integer i : stack) {
                if (x == null) {
                    x = i;
                }
                if (i < x) {
                    x = i;
                }
            }
            return x;
        }
    }

    static class MinStack2 {
        Stack<Integer> stack = null;
        Stack<Integer> minStack = null;

        /** initialize your data structure here. */
        public MinStack2() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            stack.add(x);
            minStack.add(0);
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.get(stack.size() - 1);
        }

        public int getMin() {
            return minStack.get(minStack.size() - 1);
        }

    }
}
