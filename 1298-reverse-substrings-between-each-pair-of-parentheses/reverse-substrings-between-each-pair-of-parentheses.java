import java.util.Stack;

class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        int[] pair = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                int openIndex = stack.pop();
                pair[openIndex] = i;
                pair[i] = openIndex;
            }
        }
        StringBuilder res = new StringBuilder();
        int curr = 0;
        int direction = 1; 

        while (curr < n && curr >= 0) {
            char c = s.charAt(curr);
            if (c == '(' || c == ')') {
                curr = pair[curr];
                direction = -direction; 
            } else {
                res.append(c);
            }
            curr += direction;
        }

        return res.toString();
    }
}