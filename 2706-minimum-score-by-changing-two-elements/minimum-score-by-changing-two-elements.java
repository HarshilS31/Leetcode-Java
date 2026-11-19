class Solution {
    public int minimizeSum(int[] nums) {
        int n = nums.length;
        if(nums.length==3) return 0;
        Arrays.sort(nums);
        int diff1=nums[n-1]-nums[2];
        int diff2=nums[n-3]-nums[0];
        int diff3=nums[n-2]-nums[1];
        return Math.min(diff1,Math.min(diff2,diff3));
    }
}