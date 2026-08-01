class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] nums2=new int[n+2];
        nums2[0]=1;
        nums2[n+1]=1;
        for(int i=0;i<n;i++) nums2[i+1]=nums[i];
        int[][] dp = new int[n+1][n+1];
        for(int[] arr : dp) Arrays.fill(arr,-1);
        return findMaxCoins(1,n,nums2,dp);
    }
    public int findMaxCoins(int i,int j,int[] nums,int[][] dp) {
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int maxCoins=Integer.MIN_VALUE;
        for(int k=i;k<=j;k++) {
            int coins = nums[i-1]*nums[k]*nums[j+1] + findMaxCoins(i,k-1,nums,dp) + findMaxCoins(k+1,j,nums,dp);
            maxCoins=Math.max(coins,maxCoins);
        }
        return dp[i][j]=maxCoins;

    }
}