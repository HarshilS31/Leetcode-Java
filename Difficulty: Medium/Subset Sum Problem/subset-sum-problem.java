class Solution {
    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        // 2D DP table: [index][current_sum]
        Boolean[][] dp = new Boolean[n][sum + 1];
        return checkSum(arr, dp, sum, 0, n);
    }

    // Must be static
    public static boolean checkSum(int[] arr, Boolean[][] dp, int sum, int i, int n) {
        if (sum == 0) return true;
        if (i >= n || sum < 0) return false;

        // Check memoization table
        if (dp[i][sum] != null) return dp[i][sum];

        if (arr[i] > sum) {
            return dp[i][sum] = checkSum(arr, dp, sum, i + 1, n);
        }

        boolean pick = checkSum(arr, dp, sum - arr[i], i + 1, n);
        boolean skip = checkSum(arr, dp, sum, i + 1, n);

        return dp[i][sum] = (pick || skip);
    }
}