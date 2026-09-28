import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                int num2 = stack.pop(); 
                int num1 = stack.pop();
                
                switch (token) {
                    case "+": stack.push(num1 + num2); break;
                    case "-": stack.push(num1 - num2); break;
                    case "*": stack.push(num1 * num2); break;
                    case "/": stack.push(num1 / num2); break;
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.length() == 1 && "+-*/".indexOf(token.charAt(0)) != -1;
    }
}