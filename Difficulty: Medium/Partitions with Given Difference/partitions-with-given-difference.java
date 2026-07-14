class Solution {
    public int countPartitions(int[] arr, int diff) {
        int totalSum = 0;
        for (int num : arr) totalSum += num;
        if (diff > totalSum || (totalSum + diff) % 2 != 0) return 0;
        int target = (totalSum + diff) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1; 
        int mod = 1000000007; 
        for (int num : arr) {
            for (int j = target; j >= num; j--) {
                dp[j] = (dp[j] + dp[j - num]) % mod;
            }
        }
        
        return dp[target];
    }
}