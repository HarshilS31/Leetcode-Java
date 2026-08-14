class Solution {
    public int maximumLengthSubstring(String s) {
        int n=s.length();
        int[] freq = new int[26];
        int left=0;
        int maxLen=1;
        for(int right=0;right<n;right++) {
            char r=s.charAt(right);
            freq[r-'a']++;
            while(left < n && freq[r-'a']>2) {
                freq[s.charAt(left)-'a']--;
                left++;
            }
            maxLen=Math.max(right-left+1,maxLen);
        }
        return maxLen;
    }
}