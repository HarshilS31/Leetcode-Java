class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int k: nums){
            sum+=k;
        }
        if(sum%2==1){
            return false;
        }

        int target=sum/2;
        boolean[] dp=new boolean[target+1];
        dp[0]=true;
        for(int n:nums){
            for(int j=target;j>=n;j--){
                dp[j]=dp[j]||dp[j-n];
            }
        }
        return dp[target];
    }
}