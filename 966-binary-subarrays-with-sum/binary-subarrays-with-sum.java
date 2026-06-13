class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count1=checkSubarrays(nums,goal);
        int count2=checkSubarrays(nums,goal-1);
        return count1-count2;
    }
    public int checkSubarrays(int[] nums,int goal) {
        if(goal < 0) return 0;
        int left=0;
        int count=0;
        int sum=0;
        for(int right=0;right<nums.length;right++) {
            sum+=nums[right];
            while(sum>goal) {
                sum-=nums[left++];
            }
            count+=right-left+1;

        }
        return count;

    }
}