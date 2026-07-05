class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo,-1);
        return maxAmount(nums,memo,0);
    }
    public int maxAmount(int[] nums,int[] memo,int i) {
        if(i>=nums.length) return 0;
        if(memo[i]!=-1) return memo[i];
        int take = nums[i]+maxAmount(nums,memo,i+2);
        int skip = maxAmount(nums,memo,i+1);
        memo[i]=Math.max(take,skip);
        return memo[i];
    }
}