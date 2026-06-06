class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen=0;
        int[] freq = new int[26];
        int left=0;
        int maxFreq=-1;
        for(int right=0;right<s.length();right++) {
            char c= s.charAt(right);
            freq[c-'A']++;
            maxFreq= freq[c-'A']>maxFreq  ? freq[c-'A']:maxFreq;
            int len=right-left+1;
            if(len-maxFreq>k) {
                char leftChar=s.charAt(left);
                freq[leftChar-'A']--;
                left++;
            }
            len=right-left+1;

            maxLen = len>maxLen ? len:maxLen;

        }
        return maxLen;
 
        
    }
}