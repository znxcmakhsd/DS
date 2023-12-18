class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i < tokens.length;i++) {
            String str = tokens[i];
            if (!isOperator(str)) {
                // 如果是数字入栈
                int num = Integer.parseInt(str);
                stack.push(num);                
            }else {
                // 是运算符, 出栈计算                
                int right = stack.pop();
                int left = stack.pop();
                switch (str) {
                    case "+":
                        stack.push(left + right);
                        break;
                    case "-":
                        stack.push(left - right);
                        break;
                    case "*":
                        stack.push(left * right);
                        break;
                    case "/":
                        stack.push(left / right);
                        break;    
                }
            }
        }
        return stack.peek();
    }
    private boolean isOperator(String str) {
        if (str.equals("+") || str.equals("-") 
            || str.equals("*") || str.equals("/")) {
                return true;
            }
            return false;
    }
}