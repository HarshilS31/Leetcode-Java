class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] freq = new int[256];
        int count=0;
        int left=0;
        int startIdx=-1;
        int minLen=Integer.MAX_VALUE;
        for(char ch :t.toCharArray()) freq[ch]++;
        for(int right=0;right<m;right++) {
            char ch=s.charAt(right);
            if(freq[ch]>0) count++;
            freq[ch]--;
            while(count==n) {
                if(right-left+1<minLen) {
                    minLen = right - left + 1;
                    startIdx=left;
                }
                freq[s.charAt(left)]++;
                if(freq[s.charAt(left)]>0) count--;
                left++;
            }
        }
        return startIdx==-1 ? "" :s.substring(startIdx,startIdx+minLen);
    }
}