class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j <= n; j++) {
                int skip = dp[i+1][j];
                if (j == n || nums[i] > nums[j]) {
                    dp[i][j] = Math.max(skip, 1 + dp[i+1][i]);
                } else {
                    dp[i][j] = skip;
                }
            }
        }
        return dp[0][n];
    }
}