class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
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