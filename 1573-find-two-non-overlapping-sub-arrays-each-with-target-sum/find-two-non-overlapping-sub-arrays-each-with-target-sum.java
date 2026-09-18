class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] dp = new int[n];
        int left=0;
        int minSum = Integer.MAX_VALUE;
        int minLen =Integer.MAX_VALUE;
        int currSum = 0;
        for(int right=0;right<n;right++) {
            currSum+=arr[right];
            while(currSum > target && left <= right) {
                currSum-=arr[left++];
            }
            if(currSum==target) {
                int currLen = right-left+1;
                if(left > 0  && dp[left-1]!=Integer.MAX_VALUE) {
                    minSum = Math.min(minSum,dp[left-1]+currLen);
                }
                minLen=Math.min(minLen,currLen);
            }
            dp[right]=minLen;  
        }
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
        
        
    }
}