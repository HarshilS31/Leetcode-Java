class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if(n==1 && nums[0]==target) return 1;
        int minLen = Integer.MAX_VALUE;
        int currSum=0;
        int left=0;
        for(int right=0;right<n;right++) {
            currSum+=nums[right];
            while(left<=right && currSum>=target) {
                minLen = Math.min(minLen,right-left+1);
                currSum-=nums[left++];
            }
        }
        return minLen==Integer.MAX_VALUE ? 0 : minLen;
    }
}