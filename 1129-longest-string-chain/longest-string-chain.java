class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int n =words.length;
        int[] dp = new int[n];
        int max=1;
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++) {
            for(int j=0;j<i;j++){
                if(compare(words[i],words[j]) && dp[i]<dp[j]+1) dp[i]=dp[j]+1;
            }
            max=Math.max(dp[i],max);
        }
        return max;
    }
    public boolean compare(String curr,String prev) {
        int lc=curr.length();
        int lp=prev.length();
        if(lc-lp!=1) return false;
        int i2=0;
        for (int i1=0;i1<lc;i1++) {
            if(i2<lp && curr.charAt(i1)==prev.charAt(i2)) i2++;
        }
        return (i2==lp);
    }
}