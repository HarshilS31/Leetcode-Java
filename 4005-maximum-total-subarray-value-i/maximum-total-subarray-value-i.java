class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int maxNum=Integer.MIN_VALUE;
        int minNum=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]>maxNum) maxNum=nums[i];
            if(nums[i]<minNum) minNum=nums[i];
        
        }
        return (long)k*(maxNum-minNum);

        

        
    }
}