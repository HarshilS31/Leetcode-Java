class Solution {
    public int numberOfSets(int n, int k) {
        int MOD = 1_000_000_007;
        int N = n + k - 1;
        int R = 2 * k;
        if (R > N || R < 0) return 0;
        long[][] dp = new long[N + 1][R + 1];
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= Math.min(i, R); j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
            }
        }
        
        return (int) dp[N][R];
    }
}