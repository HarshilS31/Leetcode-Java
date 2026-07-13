class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum=0;
        for(int n:nums) totalSum+=n;
        if(totalSum%2==1) return false;
        Boolean [][] dp = new Boolean[nums.length][(totalSum/2)+1];
        return checkSum(nums,dp,totalSum/2,0,nums.length);
        
    }
    public static boolean checkSum(int[] arr, Boolean[][] dp, int sum, int i, int n) {
        if (sum == 0) return true;
        if (i >= n || sum < 0) return false;
        if (dp[i][sum] != null) return dp[i][sum];
        if (arr[i] > sum) {
            return dp[i][sum] = checkSum(arr, dp, sum, i + 1, n);
        }
        boolean pick = checkSum(arr, dp, sum - arr[i], i + 1, n);
        boolean skip = checkSum(arr, dp, sum, i + 1, n);

        return dp[i][sum] = (pick || skip);
    }
}