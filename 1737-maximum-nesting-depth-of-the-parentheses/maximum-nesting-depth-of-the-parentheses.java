class Solution {
    public int maxDepth(String s) {
        int maxDepth=0;
        int currDepth=0;
        for(char c:s.toCharArray()) {
            if(c=='(') {
                currDepth++;
                maxDepth=Math.max(currDepth,maxDepth);
            }
            else if(c==')') currDepth--;
        }
        return maxDepth;
       


        
    }
}