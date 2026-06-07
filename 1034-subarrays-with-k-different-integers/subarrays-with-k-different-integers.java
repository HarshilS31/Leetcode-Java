class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return goodSubArrays(nums,k)-goodSubArrays(nums,k-1);
        
    }
    public int goodSubArrays(int[] nums,int k) {
        int left=0;
        int count=0;
        int n=nums.length;
        int[] freq=new int[n+1];
        int unique=0;
        for(int right=0;right<n;right++) {
            if(freq[nums[right]]==0) unique++;
            freq[nums[right]]++;
            while(unique>k) {
                freq[nums[left]]--;
                if(freq[nums[left]]==0) unique--;
                left++;
            }
            count+=right-left+1;

        }
        return count;

    }
}