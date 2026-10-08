class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        int open=0;
        int close=0;
        StringBuilder res = new StringBuilder();
        for(int i=0;i<n;i++) {
            char ch = s.charAt(i);
            if(ch=='(') open++;
            else close++;
            if(open==1 && ch=='(') continue;
            else if(open==close && ch==')') {
                open=0;
                close=0;
                continue;
            }
            else {
                res.append(ch);
            }
        }
        return res.toString();
        
        
    }
}