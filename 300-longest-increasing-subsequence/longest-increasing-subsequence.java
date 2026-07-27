class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(nums[j]<nums[i]) dp[i]=Math.max(dp[i],1+dp[j]);
            }
        }
        int max=0;
        for(int LIS :dp) max= Math.max(max,LIS);
        return max;
    }
}