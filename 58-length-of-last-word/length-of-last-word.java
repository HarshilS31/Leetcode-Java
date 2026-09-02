class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        if(n==1 && s.charAt(n-1)!=' ') return 1;
        int idx = n-1;
        int len=0;
        while(idx>=0 && s.charAt(idx)==' ') idx--;
        while( idx>=0 && s.charAt(idx)!=' ') {
            idx--;
            len++;
        }
        return len;
        
    }
}