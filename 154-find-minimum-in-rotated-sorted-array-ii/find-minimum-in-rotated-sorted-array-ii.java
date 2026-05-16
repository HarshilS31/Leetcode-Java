class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int hi=n-1;
        int lo=0;
        while(hi>lo) {
            int mid=lo+(hi-lo)/2;
            if(nums[mid]>nums[hi]) lo=mid+1;
            else if(nums[mid]<nums[hi]) hi=mid;
            else hi--;

        }
        return nums[lo];      
    }
}