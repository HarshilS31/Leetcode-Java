class Solution {
    public String reverseParentheses(String s) {
        int n =  s.length();
        Stack<Character> stack = new Stack<>();
        Queue<Character> q = new LinkedList<>();
        for(int i=0;i<n;i++) {
            if(s.charAt(i)!=')') stack.push(s.charAt(i));
            else {
                while(stack.peek()!='(') {
                    q.add(stack.pop());
                }
                stack.pop();
            }
            while(!q.isEmpty()) stack.push(q.poll());
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
}