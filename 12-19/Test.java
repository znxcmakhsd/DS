class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i < s.length();i++) {
            char ch = s.charAt(i);
            // 左括号入栈
            if (ch == '(' || ch == '['  || ch == '{') {
                stack.push(ch);
            }else {
                // 不匹配情况1: 栈里没有左括号 -> )
                if (stack.empty()) {
                    return false;
                }
                // 左括号与右括号匹配，如果匹配 将左括号出栈准备下一次匹配
                char top = stack.peek();
                if (top == '(' && ch == ')' || top == '[' && ch == ']' || top == '{' && ch == '}') {
                    stack.pop();
                }else {
                    // 不匹配情况2: 左括号与右括号不匹配 -> (]
                    return false;
                }
            }
        }
        // 走到这里表示遍历完了字符串,有两种可能结果
        // 不匹配情况3: 栈里还有左括号 -> (()
        if (!stack.empty()) {
            return false;
        }
        // 遍历完了字符串 同时栈为空, 证明所有括号匹配
        return true;
    }
}

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param pushV int整型一维数组
     * @param popV int整型一维数组
     * @return bool布尔型
     */
   public static boolean IsPopOrder (int[] pushV, int[] popV) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0;i < pushV.length;i++) {
            stack.push(pushV[i]);
            while (!stack.empty() && j < popV.length && stack.peek() == popV[j]) {
                stack.pop();
                j++;
            }
        }
        // 最后有两种判断出栈顺序
        // 1. 栈是否为空
        /*if (stack.empty()) {
            return true;
        }else {
            return false;
        }*/

        // 2. j == popV.length
        return j == popV.length;
    }
}

package MinStack;

import java.util.Stack;

class MinStack {

    public Stack<Integer> stack = new Stack<>();
    public Stack<Integer> minStack = new Stack<>();

    public MinStack() {

    }

    public void push(int val) {
        stack.push(val);
        // 如果最小栈为空, 则直接入栈
        if (minStack.empty()) {
            minStack.push(val);
        }else {
            // 如果最小栈不为空, 比较最小栈栈顶元素与val
            // 如果val小于或者等于栈顶元素 入栈
            if (val < minStack.peek()) {
                minStack.push(val);
            }
        }
    }

    // 删除栈顶元素
    public void pop() {
        // 普通栈肯定是要出栈
        // 如果普通栈出栈的元素 与 最小栈栈顶元素一样
        // 则最小栈出栈, 因为出栈的会是最小元素
        int top = stack.pop();
        if (top == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */