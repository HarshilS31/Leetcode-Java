class Solution {
    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        // dp[i][j] stores results for index i and remaining sum j
        Boolean[][] dp = new Boolean[n][sum + 1];
        return checkSum(arr, dp, sum, 0, n);
    }
    
    private static Boolean checkSum(int[] arr, Boolean[][] dp, int sum, int i, int n) {
        // Base Case 1: Success criteria met
        if (sum == 0) return true;
        
        // Base Case 2: Out of bounds or invalid sum
        if (i >= n || sum < 0) return false;
        
        // Memoization Lookup
        if (dp[i][sum] != null) return dp[i][sum];
        
        // Choice 1: Pick the element (only if it fits within the current target sum)
        boolean pick = false;
        if (arr[i] <= sum) {
            pick = checkSum(arr, dp, sum - arr[i], i + 1, n);
        }
        
        // Choice 2: Skip the element
        boolean skip = checkSum(arr, dp, sum, i + 1, n);
        
        // Cache and return
        return dp[i][sum] = pick || skip;
    }
}