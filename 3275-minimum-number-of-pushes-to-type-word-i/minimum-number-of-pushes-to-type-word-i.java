class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        if(n<=8) return n;
        int pushes=0;
        int traversal=1;
        while(n>0) {
            if(n>=8) pushes+=8*traversal;
            else pushes+=n*traversal;
            traversal++;
            n-=8;
        }
        return pushes;       
    }
}