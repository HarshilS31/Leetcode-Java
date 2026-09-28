class Solution {
    public int maxDepth(String s) {
        int maxDepth=Integer.MIN_VALUE;
        int currDepth=0;
        boolean found = false;
        for(char c:s.toCharArray()) {
            if(c=='(') {
                currDepth++;
                found=true;
                maxDepth=Math.max(currDepth,maxDepth);
            }
            else if(c==')') currDepth--;
        }
        return found ? maxDepth : 0;


        
    }
}