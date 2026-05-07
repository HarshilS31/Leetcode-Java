class Solution {
    public int beautySum(String s) {
        
        int totalSum=0;
        for(int i=0;i<s.length();i++) {
            int[] freq= new int[26];
            for(int j=i;j<s.length();j++) {
                freq[s.charAt(j)-'a']++;
                int maxFreq=0;
                int minFreq=Integer.MAX_VALUE;
                for(int f:freq) {
                    if(f>0) {
                        maxFreq=Math.max(f,maxFreq);
                        minFreq=Math.min(f,minFreq);
                    }
                }
                totalSum+=(maxFreq-minFreq);
            }
        }
        return totalSum;
    }
}