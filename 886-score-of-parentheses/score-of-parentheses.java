class Solution {
    public int scoreOfParentheses(String s) {
        int n =s.length();
        Stack<Integer> stack = new Stack<>();
        int score=0;
        for(int i=0;i<n;i++) {
            if(s.charAt(i)=='(') {
                stack.push(score);
                score=0;
            }else {
                if( i>0 && s.charAt(i-1)=='(') {
                    score=stack.peek()+1;
                }
                else {
                    score=stack.peek()+2*score;
                }
                stack.pop();
            }
        }
        return score;  
    }
}