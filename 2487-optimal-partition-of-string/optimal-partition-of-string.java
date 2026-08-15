class Solution {
    public int partitionString(String s) {
        int n = s.length();
        int[] freq = new int[26];
        freq[s.charAt(0)-'a']++;
        int count=0;
        for(int i=1;i<n;i++) {
            char ch = s.charAt(i);
            freq[ch-'a']++;
            if(freq[ch-'a']>1) {
                count++;
                Arrays.fill(freq,0);
                freq[ch-'a']++;
            } 
        }
        return count+1;
    }
}