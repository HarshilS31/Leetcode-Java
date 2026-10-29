class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int target = coin; target <= amount; target++) {
                int pick = dp[target - coin];
                int notPick = dp[target];
                dp[target] = pick + notPick;
            }
        }
        return dp[amount];
    }
}