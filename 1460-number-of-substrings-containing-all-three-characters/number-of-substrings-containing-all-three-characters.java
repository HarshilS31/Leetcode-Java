class Solution {
    public int numberOfSubstrings(String s) {
        int left = 0;
        int count=0;
        int[] freq = new int[3];
        for(int right=0;right<s.length();right++) {
            char c=s.charAt(right);
            freq[c-'a']++;
            while(freq['a'-'a']>0  && freq['b'-'a']>0 && freq['c'-'a']>0) {
                count+=s.length()-right;
                freq[s.charAt(left++)-'a']--;
            }
        }
        return count;
    }
}