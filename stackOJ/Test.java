
1. 逆波兰表达式求值
https://leetcode.cn/problems/evaluate-reverse-polish-notation/description/
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i < tokens.length;i++) {
            if (!isOperator(tokens[i])) {
                int val = Integer.valueOf(tokens[i]);
                stack.push(val);
            }else {
                int rightNum = stack.pop();
                int leftNum = stack.pop();
                switch (tokens[i]) {
                    case "+":
                        stack.push(leftNum + rightNum);
                        break;
                    case "-":
                        stack.push(leftNum - rightNum);
                        break;
                    case "*":
                        stack.push(leftNum * rightNum);
                        break;
                    case "/":
                        stack.push(leftNum / rightNum);
                        break;           
                }
            }
        }
        return stack.peek();
    }
    public boolean isOperator(String operator) {
        if (operator.equals("+") || operator.equals("-") 
            || operator.equals("*") || operator.equals("/")){
            return true;
        }else {
            return false;
        }
    }
}

2. 有效的括号
https://leetcode.cn/problems/valid-parentheses/description/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < s.length();i++) {
            char ch = s.charAt(i);
            // 左括号进栈 右括号 进行匹配
            // 不匹配 有3种情况
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }else {
              // 1. ()) 
                if (stack.isEmpty()) 
                    return false;
                char top = stack.peek();
                if (top == '(' && ch == ')' || top == '[' && ch == ']' || top == '{' && ch == '}'){
                    stack.pop();
                }else {
                  // 2. (]
                    return false;
                }
            }
        }
        // 3.  (() 
        if (!stack.isEmpty()) {
            return false;
        }else {
            return true;
        }
    }
}

3. 栈的压入、弹出序列
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
    public boolean IsPopOrder (int[] pushV, int[] popV) {
        // write code here
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0;i < pushV.length;i++) {
            stack.push(pushV[i]);           
            while (!stack.isEmpty() && stack.peek() == popV[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
4. 最小栈
https://leetcode.cn/problems/min-stack/description/
class MinStack {
    public Stack<Integer> stack;
    public Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int val) {
        this.stack.push(val);
        if (this.minStack.isEmpty()) {
            this.minStack.push(val);
        }else {
            // 比较
            if (val <= this.minStack.peek()) {
                this.minStack.push(val);
            }
        }
    }

    public void pop() {
        int top = this.stack.pop();
        if (top == this.minStack.peek()) {
            this.minStack.pop();
        }
    }

    public int top() {
        return this.stack.peek();
    }

    public int getMin() {
        return this.minStack.peek();
    }
}