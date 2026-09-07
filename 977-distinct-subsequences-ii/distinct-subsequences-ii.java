class Solution {
    int MOD = 1_000_000_007;
    public int distinctSubseqII(String s) {
        int n = s.length();
        int[] dp = new int[2001];
        int[] prev = new int[n+1];
        Arrays.fill(dp,-1);
        int[] lastSeen = new int[26];
        for(int i=1;i<=n;i++) {
            int idx = s.charAt(i-1)-'a';
            prev[i]=lastSeen[idx];
            lastSeen[idx]=i;
        }
        return (solve(n,dp,prev)-1+MOD)%MOD;
    }
    public int solve(int n,int[] dp,int[] prev) {
        if(n==0) return 1;
        if(dp[n]!=-1) return dp[n];
        int total=(2*solve(n-1,dp,prev))%MOD;
        if(prev[n]!=0) {
            int duplicates = (solve(prev[n]-1,dp,prev));
            total=(total - duplicates + MOD)%MOD;
        }
        return dp[n]=total;

    }
}