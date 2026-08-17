import java.util.Arrays;

class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n=stoneValue.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = stoneValue[0];
        for (int i =1; i<n;i++) {
            prefixSum[i]=stoneValue[i] +prefixSum[i-1];
        }
        int[][] dp = new int[n][n];
        for (int[] arr:dp) {
            Arrays.fill(arr,-1); 
        }
        
        return maxAliceScore(0,n-1,stoneValue,prefixSum,dp); 
    }

    public int maxAliceScore(int left,int right,int[] stoneValue,int[] prefixSum,int[][] dp) {
        if (left>=right) return 0; 
        if (dp[left][right]!=-1) return dp[left][right];
        dp[left][right]=0; 
        for (int partition=left;partition<right;partition++) {
            int leftSum = prefixSum[partition]-(left>0 ? prefixSum[left-1] : 0);
            int rightSum = prefixSum[right]-prefixSum[partition];

            if (leftSum>rightSum) {
                dp[left][right] = Math.max(dp[left][right],rightSum+maxAliceScore(partition+1,right,stoneValue,prefixSum,dp));
            } else if (rightSum > leftSum) {
                dp[left][right] = Math.max(dp[left][right], leftSum+maxAliceScore(left, partition, stoneValue, prefixSum,dp));
            } else {
                dp[left][right]=Math.max(dp[left][right],leftSum+Math.max(
                    maxAliceScore(partition+1,right,stoneValue,prefixSum,dp),
                    maxAliceScore(left,partition,stoneValue,prefixSum,dp) 
                ));
            }
        }
        return dp[left][right];
    }
}